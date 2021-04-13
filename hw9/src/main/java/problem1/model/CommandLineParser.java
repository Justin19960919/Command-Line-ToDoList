package problem1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents command line parser that process and validate command line arguments.
 */
public class CommandLineParser {

  private static final int INITIAL_VALUE = 0;
  private static final int INCREMENT = 1;

  private Options options;
  private List<String> cmdArgs; // store original commandline args that passed in
  private Map<String, List<String>> arguments; // store validated arguments

  /**
   * Construct a new commandline parser object with the given parameters.
   *
   * @param options - the list of option that the program can process
   * @param args    - the command line arguments
   * @throws InvalidArgumentException - throw exception if argument is invalid
   */
  public CommandLineParser(Options options, String[] args) throws InvalidArgumentException {
    this.cmdArgs = new ArrayList<>(Arrays.asList(args)); // convert args into an ArrayList
    this.options = options;
    this.arguments = new HashMap<>();
    this.processArgs();
    this.validateCsv(); // --csv-file is required
    this.validateTodoText(); // --todo-text is required when --add-todo is given
    this.validateDisplay();
    this.validateSort(); // make sure two --sort are not given together
    this.processLeftOver(); // process left over args in the command line arguments
  }

  /**
   * Process the commandline arguments.
   *
   * @throws InvalidArgumentException - throw exception if "email" command is not followed by
   *                                  "email-template" or "letter" command is not followed by
   *                                  "letter-template".
   */
  private void processArgs() throws InvalidArgumentException {
    int i = INITIAL_VALUE;
    while (i < options.getOptions().size()) {
      String cmdName = options.getOptions().get(i).getCmd();
      Boolean takeValue = options.getOptions().get(i).getTakeValue();
      String toBeRemoved = null; // place holder for argument to be removed from the list later
      String toBeRemoved2 = null; // place holder for argument to be removed from the list later
      // for each option, see if it can be found in the commandline args
      for (int j = INITIAL_VALUE; j < this.cmdArgs.size(); j++) {
        String cmdArg = this.cmdArgs.get(j);
        if (cmdName.equals(cmdArg)) {
          // if the command needs to take a value
          if (takeValue) {
            // cmdArg is followed by its value, not another commandline argument
            if (j + INCREMENT < this.cmdArgs.size() && !this.cmdArgs.get(j + INCREMENT)
                .startsWith("--")) {
              String value = this.cmdArgs.get(j + INCREMENT);
              // if the map does contain the key
              if (this.arguments.containsKey(
                  cmdName)) { // command like "--complete-todo" can appear more than once
                this.arguments.get(cmdArg).add(value);
              } else {
                ArrayList<String> lst = new ArrayList<>();
                lst.add(value);
                this.arguments.put(cmdName, lst);
              }
              toBeRemoved = cmdArg;
              toBeRemoved2 = value;
              break;
            } else {
              throw new InvalidArgumentException(cmdArg + " is provided but no value is given");
            }
          } else { // if the command does not need to take a value
            this.arguments.put(cmdName, null);
            toBeRemoved = cmdArg;
            break;
          }
        }
      }
      if (toBeRemoved != null) {
        this.cmdArgs.remove(toBeRemoved);// remove argument from the list
      }
      if (toBeRemoved2 != null) {
        this.cmdArgs.remove(toBeRemoved2);// remove argument from the list
      }
      i++;
    }
  }

  private void validateCsv() throws InvalidArgumentException {
    if (!this.arguments.containsKey(Options.CSV)) {
      throw new InvalidArgumentException("csv command is required");
    }
  }

  private void validateTodoText() throws InvalidArgumentException {
    if (this.arguments.containsKey(Options.ADD_TODO) && !this.arguments
        .containsKey(Options.TODO_TEXT)) {
      throw new InvalidArgumentException("--add-todo provided but no --todo-text given");
    }
  }

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

  private void validateSort() throws InvalidArgumentException {
    if (this.arguments.containsKey(Options.SORT_BY_DATE) && this.arguments
        .containsKey(Options.SORT_BY_PRIORITY)) {
      throw new InvalidArgumentException(
          "--sort-by-date cannot be combined with --sort-by-priority");
    }
  }

  /**
   * Checks if there are any arguments left after the processArgs() is finished
   *
   * @throws InvalidArgumentException - throw exception if there are any arguments left
   */
  private void processLeftOver() throws InvalidArgumentException {
    // if there are any arguments left after finishing processArgs()
    if (this.cmdArgs.size() > INITIAL_VALUE) {
      throw new InvalidArgumentException(
          "invalid arguments that can not be processed are provided.");
    }
  }

  public String getCsvFile() {
    return this.arguments.get(Options.CSV).get(0);
  }

  /**
   * Checks if --add-todo is given
   *
   * @return - true if --add-todo is given
   */
  public Boolean getAddTodo() {
    return this.arguments.containsKey(Options.ADD_TODO);
  }

  public String getTodoText() {
    if (this.getAddTodo()) {
      return this.arguments.get(Options.TODO_TEXT).get(0);
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

  public String getDueDate() {
    if (this.arguments.containsKey(Options.DUE)) {
      return this.arguments.get(Options.DUE).get(0);
    }
    return null;
  }

  public String getPriority() {
    if (this.arguments.containsKey(Options.PRIORITY)) {
      return this.arguments.get(Options.PRIORITY).get(0);
    }
    return null;
  }

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

  public Boolean getShowCategory() {
    return this.arguments.containsKey(Options.SHOW_CATEGORY);
  }

  public Boolean getShowIncomplete() {
    return this.arguments.containsKey(Options.SHOW_INCOMPLETE);
  }

  public Boolean getSortByDate() {
    return this.arguments.containsKey(Options.SORT_BY_DATE);
  }

  public Boolean getSortByPriority() {
    return this.arguments.containsKey(Options.SORT_BY_PRIORITY);
  }
}
