package problem1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents command line parser that process and validate command line arguments.
 */
public class CommandLineParser {

  private static final int START_POINT = 0;
  private static final int INCREMENT = 1;
  private static final int FIRST_ELEMENT = 0;

  private Map<String, List<String>> arguments; // store validated arguments
  private int processedArgs; // count args that has been processed

  /**
   * Construct a new commandline parser object with the given parameters.
   *
   * @param options - the list of option that the program can process
   * @param args    - the command line arguments
   * @throws InvalidArgumentException - throw exception if argument is invalid
   */
  public CommandLineParser(Options options, String[] args) throws InvalidArgumentException {
    this.arguments = new HashMap<>();
    this.processedArgs = START_POINT;
    this.processArgs(options, args);
    this.validateCsv(); // --csv-file is required
    this.validateTodoText(); // --todo-text is required when --add-todo is given
    this.validateDisplay();
    this.validateSort(); // make sure two --sort are not given together
    this.processLeftOver(args); // process left over args in the command line arguments
  }

  /**
   * Process the commandline arguments.
   * @param options - the options onject
   * @param args - the array of commandline arguments
   * @throws InvalidArgumentException - throw exception if "email" command is not followed by
   *                                  "email-template" or "letter" command is not followed by
   *                                  "letter-template".
   */
  private void processArgs(Options options, String[] args) throws InvalidArgumentException {
    int i = START_POINT;
    while (i < args.length) {
      String cmdArg = args[i];
      // for each commandline arg, see if it can be found in the list of option
      for (int j = START_POINT; j < options.getOptions().size(); j++) {
        String cmdName = options.getOptions().get(j).getCmd();
        Boolean takeValue = options.getOptions().get(j).getTakeValue();
        if (cmdName.equals(cmdArg)) {
          // if the command needs to take a value
          if (takeValue) {
            // cmdArg is followed by its value, not another commandline argument
            if (i + INCREMENT < args.length && !args[i + INCREMENT]
                .startsWith("--")) {
              String value = args[i + INCREMENT];
              // if the map does contain the key
              if (this.arguments.containsKey(
                  cmdName)) { // command like "--complete-todo" can appear more than once
                this.arguments.get(cmdName).add(value);
              } else {
                ArrayList<String> lst = new ArrayList<>();
                lst.add(value);
                this.arguments.put(cmdName, lst);
              }
              i++;
              this.processedArgs++;
              this.processedArgs++;
              break;
            } else {
              throw new InvalidArgumentException(cmdArg + " is provided but no value is given");
            }
          } else { // if the command does not need to take a value
            this.arguments.put(cmdName, null);
            this.processedArgs++;
            break;
          }
        }
      }
      i++;
    }
  }

  /**
   * Checks if --csv-file is given
   * @throws InvalidArgumentException - throw exception if csv command is not given
   */
  private void validateCsv() throws InvalidArgumentException {
    if (!this.arguments.containsKey(Options.CSV)) {
      throw new InvalidArgumentException("csv command is required");
    }
  }

  /**
   * Checks if --todo-text is given when --add-todo is provided
   * @throws InvalidArgumentException - throw exception if --todo-text is given when --add-todo is provided
   */
  private void validateTodoText() throws InvalidArgumentException {
    if (this.arguments.containsKey(Options.ADD_TODO) && !this.arguments
        .containsKey(Options.TODO_TEXT)) {
      throw new InvalidArgumentException("--add-todo provided but no --todo-text given");
    }
  }

  /**
   * When one of the four display option command is given, checks if --display is provided
   * @throws InvalidArgumentException - throw exception if one of the four display option command is given but --display is provided
   */
  private void validateDisplay() throws InvalidArgumentException {
    // --display not given
    if (!this.arguments.containsKey(Options.DISPLAY)) {
      if (this.arguments.containsKey(Options.SHOW_CATEGORY) || this.arguments
          .containsKey(Options.SHOW_INCOMPLETE)
          || this.arguments.containsKey(Options.SORT_BY_DATE) || this.arguments
          .containsKey(Options.SORT_BY_PRIORITY)) {
        throw new InvalidArgumentException("--display is not given");
      }
    }
  }

  /**
   * Checks if two sort commands are provided together
   * @throws InvalidArgumentException - throw exception if two sort commands are provided together
   */
  private void validateSort() throws InvalidArgumentException {
    if (this.arguments.containsKey(Options.SORT_BY_DATE) && this.arguments
        .containsKey(Options.SORT_BY_PRIORITY)) {
      throw new InvalidArgumentException(
          "--sort-by-date cannot be combined with --sort-by-priority");
    }
  }

  /**
   * Checks if there are any arguments left after the processArgs() is finished
   * @param args - the array of commandline arguments
   * @throws InvalidArgumentException - throw exception if there are any arguments left
   */
  private void processLeftOver(String[] args) throws InvalidArgumentException {
    // if there are any arguments left after finishing processArgs()
    if (args.length > this.processedArgs) {
      throw new InvalidArgumentException(
          "invalid arguments that can not be processed are provided.");
    }
  }

  /**
   * Get the csv file
   *
   * @return - the csv file
   */
  public String getCsvFile() {
    return this.arguments.get(Options.CSV).get(FIRST_ELEMENT);
  }

  /**
   * Checks if --add-todo is given
   *
   * @return - true if --add-todo is given
   */
  public Boolean getAddTodo() {
    return this.arguments.containsKey(Options.ADD_TODO);
  }

  /**
   * get todo text
   *
   * @return - todo text
   */
  public String getTodoText() {
    if (this.getAddTodo()) {
      return this.arguments.get(Options.TODO_TEXT).get(FIRST_ELEMENT);
    }
    return null;
  }

  /**
   * Checks if the new todo has the --completed option
   *
   * @return - true if the todo to be added is completed.
   */
  public Boolean getCompleted() {
    return this.arguments.containsKey(Options.COMPLETED);
  }

  /**
   * get due date
   *
   * @return - the due date or null if not given
   */
  public String getDueDate() {
    if (this.arguments.containsKey(Options.DUE)) {
      return this.arguments.get(Options.DUE).get(FIRST_ELEMENT);
    }
    return null;
  }

  /**
   * get priority
   * @return - priority of the new todo or null if not given
   */
  public String getPriority() {
    if (this.arguments.containsKey(Options.PRIORITY)) {
      return this.arguments.get(Options.PRIORITY).get(0);
    }
    return null;
  }

  /**
   * get category of the new todo
   * @return - category of the new todo or null if not given
   */
  public String getCategory() {
    if (this.arguments.containsKey(Options.CATEGORY)) {
      return this.arguments.get(Options.CATEGORY).get(0);
    }
    return null;
  }

  /**
   * get the list of todo IDs to mark completed
   *
   * @return - the list of todo IDs which need to mark completed, can be null if the list is empty.
   */
  public List<String> getCompleteTodos() {
    if (this.arguments.containsKey(Options.COMPLETE_TODO)) {
      return this.arguments.get(Options.COMPLETE_TODO);
    }
    return null;
  }

  /**
   * Checks if --display is given
   *
   * @return - true if --display is given
   */
  public Boolean getDisplay() {
    return this.arguments.containsKey(Options.DISPLAY);
  }

  /**
   * Get show category
   * @return - the category to show or null if not given
   */
  public String getShowCategory() {
    if (this.arguments.containsKey(Options.SHOW_CATEGORY)){
      return this.arguments.get(Options.SHOW_CATEGORY).get(FIRST_ELEMENT);
    }
    return null;
  }

  /**
   * Get show incomplete
   * @return - true if --show-incomplete is given
   */
  public Boolean getShowIncomplete() {
    return this.arguments.containsKey(Options.SHOW_INCOMPLETE);
  }

  /**
   * get sort by date
   * @return - true if --sort-by-date is given
   */
  public Boolean getSortByDate() {
    return this.arguments.containsKey(Options.SORT_BY_DATE);
  }

  /**
   * get sort by priority
   * @return - true if --sort-by-priority is given
   */
  public Boolean getSortByPriority() {
    return this.arguments.containsKey(Options.SORT_BY_PRIORITY);
  }

  /**
   * Compare this object with the given object.
   *
   * @param o - the given object to compare with
   * @return - true if this is equal to the given object
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    CommandLineParser that = (CommandLineParser) o;
    return this.processedArgs == that.processedArgs && Objects.equals(this.arguments, that.arguments);
  }

  /**
   * Calculate the hashcode of this object.
   *
   * @return - the hash code of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.arguments, this.processedArgs);
  }

  /**
   * Get string representation of this object.
   *
   * @return - string representation of this object.
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
        "arguments=" + this.arguments +
        ", processedArgs=" + this.processedArgs +
        '}';
  }
}
