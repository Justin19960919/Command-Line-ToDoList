package problem1.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Options class represents a list of option that the program can process
 */
public class Options {

  protected static final String CSV = "--csv-file";
  protected static final String ADD_TODO = "--add-todo";
  protected static final String TODO_TEXT = "--todo-text";
  protected static final String COMPLETED = "--completed";
  protected static final String DUE = "--due";
  protected static final String PRIORITY = "--priority";
  protected static final String CATEGORY = "--category";
  protected static final String COMPLETE_TODO = "--complete-todo";
  protected static final String DISPLAY = "--display";
  protected static final String SHOW_INCOMPLETE = "--show-incomplete";
  protected static final String SHOW_CATEGORY = "--show-category";
  protected static final String SORT_BY_DATE = "--sort-by-date";
  protected static final String SORT_BY_PRIORITY = "--sort-by-priority";

  private static Options singleInstance; // singleton pattern
  private List<Option> options;

  /**
   * Return the only instance of this class
   * @return the only instance of the class
   */
  public static Options getInstance() {
    if (singleInstance == null) {
      singleInstance = new Options();
    }
    return singleInstance;
  }

  /**
   * Constructs a new Options object
   */
  private Options() {
    this.options = new ArrayList<>();
    this.createOptions();
  }

  /**
   * Add option into the list
   */
  private void createOptions() {
    this.options.add(new Option(CSV, true));
    this.options.add(new Option(ADD_TODO, false));
    this.options.add(new Option(TODO_TEXT, true));
    this.options.add(new Option(COMPLETED, false));
    this.options.add(new Option(DUE, true));
    this.options.add(new Option(PRIORITY, true));
    this.options.add(new Option(CATEGORY, true));
    this.options.add(new Option(COMPLETE_TODO, true));
    this.options.add(new Option(DISPLAY, false));
    this.options.add(new Option(SHOW_INCOMPLETE, false));
    this.options.add(new Option(SHOW_CATEGORY, true));
    this.options.add(new Option(SORT_BY_DATE, false));
    this.options.add(new Option(SORT_BY_PRIORITY, false));
  }

  /**
   * Get the list of options
   *
   * @return - the list of options
   */
  public List<Option> getOptions() {
    return this.options;
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