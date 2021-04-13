package problem1.view;

import problem1.controller.TodoApplication;
import problem1.view.comparator.*;


public class Display implements IDisplay{

  private TodoApplication toDoApp;

  public Display(TodoApplication todoApp){
    this.toDoApp = todoApp;
  }


  @Override
  public void displayAll() {

  }

  @Override
  public void filterIncompleteToDos() {

  }

  @Override
  public void filterToDoByCategory(String category) {

  }

  @Override
  public void sortTodoByDate() {

  }

  @Override
  public void sortTodoByPriority() {

  }
}
