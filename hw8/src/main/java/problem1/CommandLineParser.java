package problem1;

import java.util.Objects;

/**
 * Represents command line parser that process and validate command line arguments.
 */
public class CommandLineParser {
  private static final int PROCESSED_TWO_ARGS = 2;
  private static final String EMAIL = "--email";
  private static final String EMAIL_TEMPLATE = "--email-template";
  private static final String LETTER = "--letter";
  private static final String LETTER_TEMPLATE = "--letter-template";
  private static final String OUTPUT = "--output-dir";
  private static final String CSV = "--csv-file";

  private String output;
  private String csv;
  private String emailTemplate;
  private String letterTemplate;

  /**
   * Construct a new commandline parser object with the given parameters.
   *
   * @param args - the command line arguments
   * @throws InvalidArgumentException - throw exception if argument is invalid
   */
  public CommandLineParser(String[] args) throws InvalidArgumentException {
    this.output = null;
    this.csv = null;
    this.emailTemplate = null;
    this.letterTemplate = null;
    this.processArgs(args);
    this.validateOutputAndCsv(); // checks if output and csv have value;
  }

  /**
   * Output and csv are required commands.
   * After process arguments, checks if output and csv have been set a value.
   *
   * @throws InvalidArgumentException - throw exception if output or csv is null
   */
  private void validateOutputAndCsv() throws InvalidArgumentException {
    if (this.output == null || this.csv == null) {
      throw new InvalidArgumentException("Error: --output-dir and --csv-file are required commands");
    }
  }

  /**
   * Process email command
   *
   * @param args - the given arguments
   * @param i - the starting point to process
   * @throws InvalidArgumentException - throws exception for invalid argument
   */
  private void processEmail(String[] args, int i) throws InvalidArgumentException {
    if (args[i].equals(EMAIL)){
      // email command followed by email template
      if (i + 1 < args.length && args[i + 1].equals(EMAIL_TEMPLATE)) {
        i += 1;
        // email template followed by template file, not next command line argument
        if (i + 1 < args.length && !args[i + 1].startsWith("--")) {
          i += 1;
          this.emailTemplate = args[i];
        } else {
          throw new InvalidArgumentException("Error: --email-template provided but no template file was given");
        }
      } else {
        throw new InvalidArgumentException("Error: --email provided but no --email-template was given");
      }
    } else { // handle the case that --email-template is given but no --email command before it
      throw new InvalidArgumentException("Error: --email-template given but no --email was given before it");
    }
  }

  /**
   * Process letter command
   *
   * @param args - the given arguments
   * @param i - the starting point to process
   * @throws InvalidArgumentException - throws exception for invalid argument
   */
  private void processLetter(String[] args, int i) throws InvalidArgumentException {
    if (args[i].equals(LETTER)) {
      // letter command followed by letter template
      if (i + 1 < args.length && args[i + 1].equals(LETTER_TEMPLATE)) {
        i += 1;
        // letter template followed by template file, not another command line argument
        if (i + 1 < args.length && !args[i + 1].startsWith("--")) {
          i += 1;
          this.letterTemplate = args[i];
        } else {
          throw new InvalidArgumentException("Error: --letter-template provided but no template file was given");
        }
      } else {
        throw new InvalidArgumentException("Error: --letter provided but no --letter-template was given");
      }
    } else { // handle the case that --letter-template given but no --letter command before it
      throw new InvalidArgumentException("Error: --letter-template given but no --letter before it");
    }
  }

  /**
   * Process output dir command
   *
   * @param args - the given arguments
   * @param i - the starting point to process
   * @throws InvalidArgumentException - throws exception for invalid argument
   */
  private void processOutput(String[] args, int i) throws InvalidArgumentException {
    // --output-dir followed by a path, not another command line argument
    if (i + 1 < args.length && !args[i + 1].startsWith("--")) {
      i += 1;
      this.output = args[i];
    } else {
      throw new InvalidArgumentException("Error: --output-dir provided but no path was given");
    }
  }

  /**
   * Process csv command
   *
   * @param args - the given arguments
   * @param i - the starting point to process
   * @throws InvalidArgumentException - throws exception for invalid argument
   */
  private void processCsv(String[] args, int i) throws InvalidArgumentException {
    // --csv-file followed by a file not another command line argument
    if (i + 1 < args.length && !args[i + 1].startsWith("--")) {
      i += 1;
      this.csv = args[i];
    } else {
      throw new InvalidArgumentException("Error: --csv-file provided but no file was given");
    }
  }

  /**
   * Process the given arguments.
   *
   * @param args - the command line arguments.
   * @throws InvalidArgumentException - throw exception if "email" command is not followed by "email-template"
   * or "letter" command is not followed by "letter-template".
   */
  private void processArgs(String[] args) throws InvalidArgumentException {
    int i = 0;
    while (i < args.length) {
      // process email
      if (args[i].startsWith(EMAIL)) {
        this.processEmail(args, i);
        i += PROCESSED_TWO_ARGS;
        // process letter
      } else if (args[i].startsWith(LETTER)) {
        this.processLetter(args, i);
        i += PROCESSED_TWO_ARGS;
        // process output dir
      } else if (args[i].equals(OUTPUT)) {
        this.processOutput(args, i);
        i += 1;
        // process csv file
      } else if (args[i].equals(CSV)) {
        this.processCsv(args, i);
        i += 1;
      }
      i += 1;
    }
  }

  /**
   * Get the output dir.
   *
   * @return - the output directory
   */
  public String getOutput() {
    return this.output;
  }

  /**
   * Get the email template
   *
   * @return - the email template
   */
  public String getEmailTemplate() {
    return this.emailTemplate;
  }

  /**
   * Get the letter template
   *
   * @return - the letter template
   */
  public String getLetterTemplate() {
    return this.letterTemplate;
  }

  /**
   * Get the csv file
   *
   * @return - the csv file name
   */
  public String getCsv() {
    return this.csv;
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
    return Objects.equals(this.output, that.output) && Objects.equals(this.csv, that.csv)
        && Objects.equals(this.emailTemplate, that.emailTemplate) && Objects
        .equals(this.letterTemplate, that.letterTemplate);
  }

  /**
   * Calculate the hashcode of this object.
   *
   * @return - the hash code of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.output, this.csv, this.emailTemplate, this.letterTemplate);
  }

  /**
   * Get string representation of this object.
   *
   * @return - string representation of this object.
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
        "output='" + this.output + '\'' +
        ", csv='" + this.csv + '\'' +
        ", emailTemplate='" + this.emailTemplate + '\'' +
        ", letterTemplate='" + this.letterTemplate + '\'' +
        '}';
  }
}
