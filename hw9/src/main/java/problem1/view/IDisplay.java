package problem1.view;

public interface IDisplay{

  void displayAll();

  void filterIncompleteToDos();

  void filterToDoByCategory(String category);

  void sortTodoByDate();

  void sortTodoByPriority();

}
