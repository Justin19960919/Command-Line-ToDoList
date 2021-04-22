package problem1.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.model.Todo;

public class TodoTest {
  Todo td1;
  Todo td2;
  Todo td3;
  Todo td4;
  Todo td5;
  Todo td6;

  @Before
  public void setUp() throws Exception {
    td1 = new Todo(2,"eat", false, "2/2/2021", 2, "?");
    td2 = new Todo(1,"sleep", true, "4/4/2021", 1, "daily");
    td3 = new Todo(2,"eat", true, "2/2/2021", 2, "?");
    td4 = new Todo(2,"eat", false, "2/2/2021", 1, "?");
    td5 = new Todo(2,"eat", false, "2/2/2021", 2, "yeee");
    td6 = new Todo(2,"eat", false, "4/4/2021", 2, "?");
  }

  @Test
  public void getID() {
    assertEquals(2,td1.getID());
    assertEquals(1,td2.getID());
  }

  @Test
  public void getText() {
    assertEquals("eat", td1.getText());
    assertEquals("sleep", td2.getText());
  }

  @Test
  public void isCompleted() {
    assertFalse(td1.isCompleted());
    assertTrue(td2.isCompleted());
  }

  @Test
  public void getDueDate() {
    assertEquals("2/2/2021", td1.getDueDate());
    assertEquals("4/4/2021", td2.getDueDate());
  }

  @Test
  public void getPriority() {
    assertEquals(2, td1.getPriority());
    assertEquals(1, td2.getPriority());
  }

  @Test
  public void getCategory() {
    assertEquals("?", td1.getCategory());
    assertEquals("daily", td2.getCategory());
  }

  @Test
  public void setCompleted() {
    td1.setCompleted();
    assertTrue(td1.isCompleted());
  }

  @Test
  public void testToString() {
    assertEquals("Todo{ID=2, text='eat', isCompleted=false, dueDate='2/2/2021', priority=2, category='?'}", td1.toString());
  }

  @Test
  public void testEquals(){
    assertEquals(td1, td1);
    assertNotEquals(td1, td2);
    assertNotEquals(td1, td3);
    assertNotEquals(td1, td4);
    assertNotEquals(td1, td5);
    assertNotEquals(td1, td6);
    assertNotEquals(td1, null);
    assertEquals(td1.hashCode(), td1.hashCode());
    assertNotEquals(td1.hashCode(), td2.hashCode());
  }
}