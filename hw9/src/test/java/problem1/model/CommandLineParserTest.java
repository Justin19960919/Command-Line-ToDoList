package problem1.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest {
  private CommandLineParser parser;
  private String[] args;
  private CommandLineParser parser1;
  private String[] args1;
  private CommandLineParser parser2;
  private Options options;

  @Before
  public void setUp() throws Exception {
    args = new String[]{
        "--add-todo", "--todo-text", "finish bytedance OA", "--priority", "1", "--csv-file", "data.csv"};
    args1 = new String[]{
        "--add-todo", "--todo-text", "finish bytedance OA", "--due", "04/25/2021", "--category", "coding", "--completed", "--display", "--sort-by-date", "--csv-file", "data.csv"};
    options = new Options();
    parser = new CommandLineParser(options, args);
    parser1 = new CommandLineParser(options, args);
    parser2 = new CommandLineParser(options, args1);
  }


  @Test(expected = InvalidArgumentException.class)
  public void noCsv() throws InvalidArgumentException {
    args = new String[]{
        "--add-todo", "--todo-text", "finish bytedance OA", "--priority", "1"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void noTodoText() throws InvalidArgumentException {
    args = new String[]{
        "--add-todo", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void noDisplay() throws InvalidArgumentException {
    args = new String[]{
        "--add-todo", "--todo-text", "finish bytedance OA", "--priority", "1", "--csv-file", "data.csv", "--show_incomplete"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void twoSorts() throws InvalidArgumentException {
    args = new String[]{
        "--add-todo", "--todo-text", "finish bytedance OA", "--priority", "1", "--csv-file", "data.csv",
        "--display", "--sort-by-date", "--sort-by-priority"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void leftOverArgs() throws InvalidArgumentException {
    args = new String[]{
        "--add-todo", "--todo-text", "finish bytedance OA", "--priority", "1", "--csv-file", "data.csv",
        "--copy"};
    parser = new CommandLineParser(options, args);
  }
  @Test
  public void getCsvFile() {
    assertEquals("data.csv", parser.getCsvFile());
  }

  @Test
  public void getAddTodo() {
    assertEquals(true, parser.getAddTodo());
  }

  @Test
  public void getTodoText() {
    assertEquals("finish bytedance OA", parser.getTodoText());
  }

  @Test
  public void getCompleted() {
    assertEquals(false, parser.getCompleted());
    assertEquals(true, parser2.getCompleted());
  }

  @Test
  public void getDueDate() {
    assertEquals(null, parser.getDueDate());
    assertEquals("04/25/2021", parser2.getDueDate());
  }

  @Test
  public void getPriority() {
    assertEquals("1", parser.getPriority());
    assertEquals(null, parser2.getPriority());
  }

  @Test
  public void getCategory() {
    assertEquals(null, parser.getCategory());
    assertEquals("coding", parser2.getCategory());
  }

  @Test
  public void getCompleteTodos() {
    assertEquals(null, parser.getCompleteTodos());
  }

  @Test
  public void getDisplay() {
    assertEquals(false, parser.getDisplay());
    assertEquals(true, parser2.getDisplay());
  }

  @Test
  public void getShowCategory() {
    assertEquals(null, parser.getShowCategory());
  }

  @Test
  public void getShowIncomplete() {
    assertEquals(false, parser.getShowIncomplete());
  }

  @Test
  public void getSortByDate() {
    assertEquals(false, parser.getSortByDate());
    assertEquals(true, parser2.getSortByDate());
  }

  @Test
  public void getSortByPriority() {
    assertEquals(false, parser.getSortByPriority());
  }

  @Test
  public void testEquals1() {
    assertTrue(parser.equals(parser1));
  }

  @Test
  public void testEquals2() {
    assertTrue(parser.equals(parser));
  }
  @Test
  public void testHashCode() {
    assertEquals(parser.hashCode(), parser1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "CommandLineParser{arguments={--add-todo=null, --csv-file=[data.csv], --priority=[1], --todo-text=[finish bytedance OA]}, processedArgs=7}";
    assertEquals(s, parser.toString());
  }
}