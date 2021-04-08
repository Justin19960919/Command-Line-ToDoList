package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Options class represents a list of option that the program can process
 */
public class Options {
  protected static final String EMAIL = "--email";
  protected static final String EMAIL_TEMPLATE = "--email-template";
  protected static final String LETTER = "--letter";
  protected static final String LETTER_TEMPLATE = "--letter-template";
  protected static final String OUTPUT = "--output-dir";
  protected static final String CSV = "--csv-file";

  private List<Option> options;

  /**
   * Constructs a new Options object
   */
  public Options() {
    this.options = new ArrayList<>();
    this.createOptions();
  }

  /**
   * Add option into the list
   */
  private void createOptions() {
    this.options.add(new Option(EMAIL, false));
    this.options.add(new Option(EMAIL_TEMPLATE, true));
    this.options.add(new Option(LETTER, false));
    this.options.add(new Option(LETTER_TEMPLATE, true));
    this.options.add(new Option(OUTPUT, true));
    this.options.add(new Option(CSV, true));
  }

  /**
   * Get the list of options
   * @return - the list of options
   */
  public List<Option> getOptions() {
    return this.options;
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
    Options options1 = (Options) o;
    return Objects.equals(this.options, options1.options);
  }

  /**
   * Calculate the hashcode of this object.
   *
   * @return - the hash code of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.options);
  }

  /**
   * Get string representation of this object.
   *
   * @return - string representation of this object.
   */
  @Override
  public String toString() {
    return "Options{" +
        "options=" + this.options +
        '}';
  }
}
