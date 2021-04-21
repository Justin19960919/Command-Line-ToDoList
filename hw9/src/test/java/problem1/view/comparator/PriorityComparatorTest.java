package problem1.view.comparator;

import problem1.controller.Todo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityComparatorTest {

  Todo td1;
  Todo td2;
  Todo td3;
  Todo td4;
  Todo td5;
  PriorityComparator pc;

  @Before
  public void setUp() throws Exception {
    td1 = new Todo(1,"A",true, "3/21/2020", 1, "hw9");
    td2 = new Todo(2,"B",false, "3/22/2020", 2, "hw9");
    td3 = new Todo(3,"C",true, "3/23/2020", 3, "hw9");
    td4 = new Todo(4,"D",false, "3/24/2020", 4, "hw9");
    td5 = new Todo(4,"D",false, "3/24/2020", 3, "hw9");
    pc = new PriorityComparator();
  }

  @Test
  public void compare() {
    assertEquals(-1, pc.compare(td1,td2));
    assertEquals(-1, pc.compare(td2,td3));
    assertEquals(1, pc.compare(td4,td3));
    assertEquals(0, pc.compare(td5,td3));
  }


}