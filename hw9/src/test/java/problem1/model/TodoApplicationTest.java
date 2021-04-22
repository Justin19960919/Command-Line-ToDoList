package problem1.model;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.controller.CommandLineParser;
import problem1.controller.InvalidArgumentException;
import problem1.controller.Options;
import problem1.controller.TodoApplication;
import problem1.model.Todo;

public class TodoApplicationTest {
  Todo td1;
  Todo td2;
  CommandLineParser parser;
  String[] args;
  Options options;
  TodoApplication tda;

  @Before
  public void setUp() throws Exception {
    td1 = new Todo(2,"eat", false, "2/2/2021", 2, "?");
    td2 = new Todo(1,"sleep", true, "4/4/2021", 1, "daily");
    options = Options.getInstance();
    args = new String[8];
    args[0] = "--csv-file"; args[1] = "test_todo_application.csv"; args[2] = "--complete-todo";
    args[3] = "1"; args[4] = "--display";
    args[5] = "--add-todo"; args[6] = "--todo-text"; args[7] = "eat";
    parser = new CommandLineParser(options, args);
    tda = new TodoApplication(parser);
//    tda.writeFile();
  }

  @Test
  public void addTodo() {
    assertEquals(2, tda.getTodoList().size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setCompleteInvalidId() throws InvalidArgumentException {
    String[] args2 = new String[8];
    args2[0] = "--csv-file"; args2[1] = "test_todo_application.csv"; args2[2] = "--complete-todo";
    args2[3] = "0"; args2[4] = "--display";
    args2[5] = "--add-todo"; args2[6] = "--todo-text"; args2[7] = "eat";
    CommandLineParser parser2 = new CommandLineParser(options, args2);
    TodoApplication tda2 = new TodoApplication(parser2);
    tda2.setComplete();
  }

  @Test
  public void setComplete() {
//    assertFalse(tda.getTodoList().get(0).isCompleted());
    tda.setComplete();
    assertTrue(tda.getTodoList().get(0).isCompleted());
  }

  @Test
  public void getTodoList() {
    assertEquals(2, tda.getTodoList().size());
  }

  @Test
  public void getParser() {
    assertEquals(parser, tda.getParser());
  }

  @Test
  public void writeFile() {
    tda.writeFile();
    List<String> l = new ArrayList<>();
    BufferedReader inputFile = null;
    try {
      inputFile = new BufferedReader(new FileReader("test_todo_application.csv"));

      String line;
      while ((line = inputFile.readLine()) != null) {
        l.add(line);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println("Failed to close input stream");
        }
      }
    }
    assertEquals(3, l.size());
    assertTrue(l.get(2).contains("eat"));
  }

  @Test
  public void testEquals(){
    assertEquals(tda, tda);
    TodoApplication tda2 = new TodoApplication(parser);
    assertEquals(tda, tda2);
  }
}