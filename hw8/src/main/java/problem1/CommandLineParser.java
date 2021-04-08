package problem1;

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
  private static final int INITIAL_VALUE = 0;
  private static final int INCREMENT = 1;

  private Options options;
  private List<String> cmdArgs; // store original commandline args that passed in
  private Map<String, String> arguments; // store validated arguments

  /**
   * Construct a new commandline parser object with the given parameters.
   *
   * @param options - the list of option that the program can process
   * @param args - the command line arguments
   * @throws InvalidArgumentException - throw exception if argument is invalid
   */
  public CommandLineParser(Options options, String[] args) throws InvalidArgumentException {
    this.cmdArgs = new ArrayList<>(Arrays.asList(args)); // convert args into an ArrayList
    this.options = options;
    this.arguments = new HashMap<>();
    this.processArgs();
    this.validateOutputAndCsv(); // checks if output command and csv command is in the map;
    this.validateLetterAndEmail(Options.LETTER); // validate letter and letter template command
    this.validateLetterAndEmail(Options.EMAIL); // validate email and email template command
    this.processLeftOver(); // process left over args in the command line arguments
  }

  /**
   * Checks if there are any arguments left after the processArgs() is finished
   *
   * @throws InvalidArgumentException - throw exception if there are any arguments left
   */
  private void processLeftOver() throws InvalidArgumentException {
    // if there are any arguments left after finishing processArgs()
    if (this.cmdArgs.size() > INITIAL_VALUE) {
      System.out.println(this.cmdArgs.size());
      throw new InvalidArgumentException("invalid arguments that can not be processed are provided.");
    }
  }

  /**
   * Output and csv are required commands.
   * After process arguments, checks if output and csv have been set a value.
   *
   * @throws InvalidArgumentException - throw exception if output or csv is null
   */
  private void validateOutputAndCsv() throws InvalidArgumentException {
    if (!this.arguments.containsKey(Options.OUTPUT) || !this.arguments.containsKey(Options.CSV)) {
      throw new InvalidArgumentException("--output-dir and --csv-file are required commands");
    }
  }

  private void validateLetterAndEmail(String cmd) throws InvalidArgumentException {
    String template = cmd + "-template";
    // eg: --email is given but --email-template is not given
    if (this.arguments.containsKey(cmd) && !this.arguments.containsKey(template)) {
      throw new InvalidArgumentException(cmd + " is provided but no " + template + " is given");
      // eg: --email-template is given but --email is not given
    } else if (this.arguments.containsKey(template) && !this.arguments.containsKey(cmd)) {
      throw new InvalidArgumentException(template + " is given but no " + cmd + " is provided");
    }
  }

  /**
   * Process the commandline arguments.
   *
   * @throws InvalidArgumentException - throw exception if "email" command is not followed by "email-template"
   * or "letter" command is not followed by "letter-template".
   */
  private void processArgs() throws InvalidArgumentException {
    int i = INITIAL_VALUE;
    while (i < options.getOptions().size()) {
      String cmdName = options.getOptions().get(i).getCmd();
      Boolean takeValue = options.getOptions().get(i).getTakeValue();
      String toBeRemoved = null; // place holder to store the argument that needs to be removed from the list
      String toBeRemoved2 = null; // place holder to store the argument that needs to be removed from the list
      // for each option, see if it can be found in the commandline args
      for (int j = INITIAL_VALUE; j < this.cmdArgs.size(); j++) {
        String cmdArg = this.cmdArgs.get(j);
        if (cmdName.equals(cmdArg)) {
          // if the command needs to take a value
          if (takeValue) {
            // cmdArg is followed by its value, not another commandline argument
            if (j + INCREMENT < this.cmdArgs.size() && !this.cmdArgs.get(j + INCREMENT).startsWith("--")) {
              this.arguments.put(cmdName, this.cmdArgs.get(j + INCREMENT));
              toBeRemoved = cmdArg;
              toBeRemoved2 = this.cmdArgs.get(j + INCREMENT);
              break;
            } else {
              throw new InvalidArgumentException(cmdArg + " is provided but no value is given");
            }
            // if the command does not need to take a value
          } else {
            this.arguments.put(cmdName, null);
            toBeRemoved = cmdArg;
            break;
          }
        }
      }
      // remove argument from the list
      if (toBeRemoved != null) {
        this.cmdArgs.remove(toBeRemoved);
      }
      if (toBeRemoved2 != null) {
        this.cmdArgs.remove(toBeRemoved2);
      }
      i++;
    }
  }

  /**
   * Get the output dir.
   *
   * @return - the output directory
   */
  public String getOutput() {
    return this.arguments.get(Options.OUTPUT);
  }

  /**
   * Get the email template
   *
   * @return - the email template
   */
  public String getEmailTemplate() {
    if (this.arguments.containsKey(Options.EMAIL_TEMPLATE)) {
      return this.arguments.get(Options.EMAIL_TEMPLATE);
    }
    return null;
  }

  /**
   * Get the letter template
   *
   * @return - the letter template
   */
  public String getLetterTemplate() {
    if (this.arguments.containsKey(Options.LETTER_TEMPLATE)) {
      return this.arguments.get(Options.LETTER_TEMPLATE);
    }
    return null;
  }

  /**
   * Get the csv file
   *
   * @return - the csv file name
   */
  public String getCsv() {
    return this.arguments.get(Options.CSV);
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
    return Objects.equals(this.options, that.options) && Objects
        .equals(this.cmdArgs, that.cmdArgs) && Objects.equals(this.arguments, that.arguments);
  }

  /**
   * Calculate the hashcode of this object.
   *
   * @return - the hash code of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.options, this.cmdArgs, this.arguments);
  }

  /**
   * Get string representation of this object.
   *
   * @return - string representation of this object.
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
        "options=" + this.options +
        ", cmdArgs=" + this.cmdArgs +
        ", arguments=" + this.arguments +
        '}';
  }
}
