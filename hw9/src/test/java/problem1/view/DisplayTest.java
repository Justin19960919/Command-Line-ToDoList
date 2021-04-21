package problem1.view;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import problem1.controller.TodoApplication;
import problem1.model.CommandLineParser;
import problem1.model.Options;


import org.junit.Before;
import org.junit.Test;

public class DisplayTest {

  CommandLineParser parser1;
  CommandLineParser parser2;
  CommandLineParser parser3;
  CommandLineParser parser4;
  CommandLineParser parser5;

  String[] argument1 = {"--csv-file","todos.csv","--display"};
  String[] argument2 = {"--csv-file","todos.csv","--display", "--show-incomplete"};
  String[] argument3 = {"--csv-file","todos.csv","--display", "--show-incomplete", "--show-category","home"};
  String[] argument4 = {"--csv-file","todos.csv","--display", "--sort-by-date"};
  String[] argument5 = {"--csv-file","todos.csv","--display", "--sort-by-priority"};

  Options options;
  TodoApplication tda1;
  TodoApplication tda2;
  TodoApplication tda3;
  TodoApplication tda4;
  TodoApplication tda5;

  Display display1;
  Display display2;
  Display display3;
  Display display4;
  Display display5;

  @Before
  public void setUp() throws Exception {
    options = new Options();
    parser1 = new CommandLineParser(options, argument1);
    parser2 = new CommandLineParser(options, argument2);
    parser3 = new CommandLineParser(options, argument3);
    parser4 = new CommandLineParser(options, argument4);
    parser5 = new CommandLineParser(options, argument5);
    tda1 = new TodoApplication(parser1);
    tda2 = new TodoApplication(parser2);
    tda3 = new TodoApplication(parser3);
    tda4 = new TodoApplication(parser4);
    tda5 = new TodoApplication(parser5);
  }


  @Test
  public void displayAll() {
    display1 = new Display(tda1);
    display1.display();
  }

  @Test
  public void displayIncomplete() {
    display2 = new Display(tda2);
    display2.display();
  }

  @Test
  public void displayIncompleteAndHome() {
    display3 = new Display(tda3);
    display3.display();
  }

  @Test
  public void displaySortByDate() {
    display4 = new Display(tda4);
    display4.display();
  }

  @Test
  public void displaySortByPriority() {
    display5 = new Display(tda5);
    display5.display();
  }


}