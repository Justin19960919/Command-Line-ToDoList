package problem1.model;

import static org.junit.Assert.*;

import org.junit.Test;
import problem1.controller.InvalidArgumentException;

public class InvalidArgumentExceptionTest {
  private InvalidArgumentException e;

  @Test
  public void getMessage() {
    e = new InvalidArgumentException("invalid args");
    String s = "Error message: invalid args\n"
        + "Usage: \n"
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
        + "--csv-file todos.csv --add-todo --todo-text \"finish homework10\" --due 04/19/2021 --priority 3\n"
        + "--complete-todo 1 --display --show-incomplete --sort-by-date";
    assertEquals(s, e.getMessage());
  }

}