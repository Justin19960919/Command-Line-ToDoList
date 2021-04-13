package problem1.view;
import java.util.List;
import java.util.ArrayList;
import problem1.controller.TodoApplication;
import problem1.controller.Todo;
import problem1.view.comparator.*;
import java.util.Collections;

public class Display{

  private TodoApplication toDoApp;

  public Display(TodoApplication todoApp){
    this.toDoApp = todoApp;
    this.display();
  }


  /**
   * This just prints out all the todo objects in the todolist for now
   */
  public void display(){
    // if the parser contains display
    this.printHeader();
    for(Todo td: this.toDoApp.getTodoList()){
      System.out.println(this.formatTodo(td));
    }
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


  private void printHeader(){
    for(int i=0; i < 100; i++) {
      System.out.print("#");
    }
    System.out.println();

    System.out.println("priority \t\t due date \t\t Completed \t\t Category \t\t text \t\t ");
  }

  /**
   * Filters the todo list to only include incomplete to dos
   * @return a List of Todo objects
   */
  private List<Todo> filterIncompleteToDos() {
    List<Todo> res = new ArrayList<>();
    for(Todo currentTodo: this.toDoApp.getTodoList()){
      if(!currentTodo.isCompleted()){
        // if not complete, add to list
        res.add(currentTodo);
      }
    }
    return res;
  }


  /**
   * Filters the todo list to only include todos from a particular String category
   * @param category the category of the todo, a String
   * @return a List of Todo objects
   */
  private List<Todo> filterToDoByCategory(String category) {
    List<Todo> res = new ArrayList<>();
    for(Todo currentTodo: this.toDoApp.getTodoList()){
      if(currentTodo.getCategory().equals(category)){
        res.add(currentTodo);
      }
    }
    return res;
  }

  /**
   * Sorts the list of Todo objects by date using the Date Comparator
   * @return a List of Todo objects
   */
  private List<Todo> sortTodoByDate() {
    List<Todo> toDoList = this.toDoApp.getTodoList();
    Collections.sort(toDoList, new DateComparator());
    return toDoList;
  }

  /**
   * Sorts the list of Todo objects by priority using the Priority Comparator
   * @return a List of Todo objects
   */
  private List<Todo> sortTodoByPriority() {
    List<Todo> toDoList = this.toDoApp.getTodoList();
    Collections.sort(toDoList, new PriorityComparator());
    return toDoList;
  }


}
