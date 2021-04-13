// Just for testing
package problem1.view;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import problem1.controller.Todo;

public class Main_temp {


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


  public static void main(String[] args){

    Todo td1 = new Todo(1, "abcd", true, "3/22/2020", 1, "a");
    Todo td2 = new Todo(2, "efgh", false, "2/28/2020", 2, "b");
    Todo td3 = new Todo(3, "ijkl", true, "3/22/2020", 3, "c");
    List<Todo> todolist = Arrays.asList(td1,td2,td3);



  }
}
