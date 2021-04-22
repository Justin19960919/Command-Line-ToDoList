package problem1.view;
import java.util.List;
import java.util.ArrayList;

import java.util.Objects;
import problem1.controller.CommandLineParser;

import problem1.controller.TodoApplication;
import problem1.model.Todo;

import problem1.model.comparator.DateComparator;
import problem1.model.comparator.PriorityComparator;
import java.util.Collections;

/**
 * A Display class that displays the to do list if it is called upon
 * Can specify several filtering and sorting options, including:
 * sort by priority
 * sort by date
 * filter by incomplete
 * filter by category
 */
public class Display{

  private static final String SPACE = "   \t\t   ";
  private TodoApplication toDoApp;
  private List<Todo> toDoList;
  private CommandLineParser cmp;

  /**
   * Constructor for the Display class
   * @param todoApp a TodoApplication object
   */
  public Display(TodoApplication todoApp){
    this.toDoApp = todoApp;
    this.toDoList = this.toDoApp.getTodoList();
    this.cmp = this.toDoApp.getParser();
  }


  /**
   * Displays the output to console according to the parser arguments
   */
  public void display(){
    if(this.cmp.getDisplay()) {
      this.filterIncompleteToDos();
      this.filterToDoByCategory();
      this.sortTodoByDate();
      this.sortTodoByPriority();
      this.printToDoList();
    }
  }


  /**
   *  Print out to do list given a list of Todo objects
   */
  private void printToDoList(){
    String NO_TODOLIST = "There are currently no todos in the todolist to display.";
    if(this.toDoList.size() == 0) {
      System.out.println(NO_TODOLIST);
    }else {
      this.printHeader();
      for (Todo td : this.toDoList) {
        System.out.println(this.formatTodo(td));
      }
    }
  }

  /**
   * Print header of the todo list display
   */
  private void printHeader(){
    String HEADER_SPACE = " \t\t ";
    System.out.println("priority" + HEADER_SPACE +  "due date" + HEADER_SPACE + "Completed"
        + HEADER_SPACE + "Category" + HEADER_SPACE + "text" + HEADER_SPACE);
  }

  /**
   * Formats the todo object and print to console
   * @param td a Todo object (instance)
   * @return a formatted string that contains information of the todo object
   */
  private String formatTodo(Todo td){
    StringBuilder tdData = new StringBuilder();
    tdData.append("\t").append(td.getPriority()).append(SPACE)
        .append(td.getDueDate()).append(SPACE)
        .append(td.isCompleted()).append(SPACE)
        .append(td.getCategory()).append(SPACE)
        .append(td.getText()).append(SPACE);
    return tdData.toString();
  }


  /**
   * Filters the todo list to only include incomplete to dos
   */
  private void filterIncompleteToDos() {
    if(this.cmp.getShowIncomplete()) {
      List<Todo> res = new ArrayList<>();
      for (Todo currentTodo : this.toDoList) {
        if (!currentTodo.isCompleted()) {
          // if not complete, add to list
          res.add(currentTodo);
        }
      }
      this.toDoList = res;
    }
  }


  /**
   * Filters the todo list to only include todos from a particular String category
   */
  private void filterToDoByCategory() {
    if(this.cmp.getShowCategory() != null) {
      String category = this.cmp.getShowCategory();
      List<Todo> res = new ArrayList<>();
      for (Todo currentTodo : this.toDoList) {
        if (currentTodo.getCategory() != null && currentTodo.getCategory().equals(category)) {
          res.add(currentTodo);
        }
      }
      this.toDoList = res;
    }
  }

  /**
   * Sorts the list of Todo objects by date using the Date Comparator
   */
  private void sortTodoByDate() {
    if(this.cmp.getSortByDate()) {
      Collections.sort(this.toDoList, new DateComparator());
    }
  }

  /**
   * Sorts the list of Todo objects by priority using the Priority Comparator
   */
  private void sortTodoByPriority() {
    if(this.cmp.getSortByPriority()){
    Collections.sort(this.toDoList, new PriorityComparator());
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Display display = (Display) o;
    return Objects.equals(toDoApp, display.toDoApp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(toDoApp);
  }



}
