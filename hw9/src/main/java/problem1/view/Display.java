package problem1.view;
import java.util.List;
import java.util.ArrayList;

import problem1.model.CommandLineParser;

import problem1.controller.TodoApplication;
import problem1.controller.Todo;

import problem1.view.comparator.*;
import java.util.Collections;

public class Display{

  private TodoApplication toDoApp;
  private List<Todo> toDoList;
  private CommandLineParser cmp;

  public Display(TodoApplication todoApp){
    this.toDoApp = todoApp;
    this.toDoList = this.toDoApp.getTodoList();
    this.cmp = this.toDoApp.getParser();
    this.display();
  }

  /**
   * Displays the output to console according to the parser arguments
   */
  public void display(){}



  /**
   *  Print out to do list given a list of Todo objects
   */
  private void printToDoList(){
      this.printHeader();
      for (Todo td : this.toDoList) {
        System.out.println(this.formatTodo(td));
      }
  }

  /**
   * Print header of the todo list display
   */
  private void printHeader(){
    for(int i=0; i < 100; i++) {
      System.out.print("#");
    }
    System.out.println();

    System.out.println("priority \t\t due date \t\t Completed \t\t Category \t\t text \t\t ");
  }

  /**
   * Foramtes the todo object and print to console
   * @param td a Todo object (instance)
   * @return a formatted string that contains information of the todo object
   */
  private String formatTodo(Todo td){
    String SPACE = "   \t\t   ";
    StringBuilder tdData = new StringBuilder();
    tdData.append("\t").append(td.getPriority()).append(SPACE)
        .append(td.getDueDate()).append(SPACE)
        .append(td.isCompleted()).append(SPACE)
        .append(td.getCategory()).append(SPACE)
        .append(td.getText()).append(SPACE);
    String tdDataString = tdData.toString();
    return tdDataString;
  }


  /**
   * Filters the todo list to only include incomplete to dos
   * @return a List of Todo objects
   */
  private void filterIncompleteToDos() {
    List<Todo> res = new ArrayList<>();
    for(Todo currentTodo: this.toDoList){
      if(!currentTodo.isCompleted()){
        // if not complete, add to list
        res.add(currentTodo);
      }
    }
    this.toDoList = res;
  }


  /**
   * Filters the todo list to only include todos from a particular String category
   * @param category the category of the todo, a String
   * @return a List of Todo objects
   */
  private void filterToDoByCategory(String category) {
    List<Todo> res = new ArrayList<>();
    for(Todo currentTodo: this.toDoList){
      if(currentTodo.getCategory().equals(category)){
        res.add(currentTodo);
      }
    }
    this.toDoList = res;
  }

  /**
   * Sorts the list of Todo objects by date using the Date Comparator
   * @return a List of Todo objects
   */
  private void sortTodoByDate() {
    Collections.sort(this.toDoList, new DateComparator());
  }

  /**
   * Sorts the list of Todo objects by priority using the Priority Comparator
   * @return a List of Todo objects
   */
  private void sortTodoByPriority() {
    Collections.sort(this.toDoList, new PriorityComparator());
  }


}
