package problem1.model;

public class InvalidArgumentException extends Exception{
  private static final String S = "\nUsage: \n"
      + "--csv-file <path/to/folder> The CSV file containing the todos. This option is required.\n"
      + "--add-todo Add a new todo. If this option is provided, then --todo-text must also be provided.\n"
      + "--todo-text <description of todo> A description of the todo.\n"
      + "--completed (Optional) Sets the completed status of a new todo to true.\n"
      + "--due <due date> (Optional) Sets the due date of a new todo. You may choose how the date should be formatted.\n"
      + "--priority <1, 2, or 3> (Optional) Sets the priority of a new todo. The value can be 1, 2, or 3.\n"
      + "--category <a category name> (Optional) Sets the category of a new todo. The value can be any string.\n"
      + "--complete-todo <id> Mark the Todo with the provided ID as complete.\n"
      + "--display Display todos. If none of the following optional arguments are provided, displays all todos.\n"
      + "--show-incomplete (Optional) If --display is provided, only incomplete todos should be displayed.\n"
      + "--show-category <category> (Optional) If --display is provided, only todos with the given category should be displayed.\n"
      + "--sort-by-date (Optional) If --display is provided, sort the list of by date order (ascending). be combined with --sort-by-priority.\n"
      + "--sort-by-priority (Optional) If --display is provided, sort the list of todos by priority (ascending). Cannot be combined with --sort-by-date.\n"
      + "Examples:\n"
      + "--csv-file todos.csv --add-todo --todo-text homework10 --due 04/19/2021 --priority 3\n"
      + "--complete-todo 1 --display --show-incomplete --sort-by-date";
  private String message;

  /**
   * Constructs a new exception with {@code null} as its detail message. The cause is not initialized,
   * and may subsequently be initialized by a call to {@link #initCause}.
   *
   * @param message - the given error message
   */
  public InvalidArgumentException(String message) {
    super(message);
    this.message = message;
  }

  /**
   * Returns the detail message string of this throwable.
   *
   * @return the detail message string of this {@code Throwable} instance (which may be {@code
   * null}).
   */
  @Override
  public String getMessage() {
    return "Error message: " + message + S;
  }
}
