package problem1.model.comparator;
import problem1.model.Todo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.model.comparator.DateComparator;

public class DateComparatorTest {

  Todo td1;
  Todo td2;
  Todo td3;
  Todo td4;
  Todo td5;
  Todo td6;
  Todo td7;
  DateComparator dc;


  @Before
  public void setUp() throws Exception {

    td1 = new Todo(1,"A",true, "3/21/2020", 1, "hw9");
    td2 = new Todo(2,"B",false, "3/22/2020", 2, "hw9");
    td3 = new Todo(3,"C",true, "3/23/2020", 3, "hw9");
    td4 = new Todo(4,"D",false, "3/24/2020", 4, "hw9");
    td5 = new Todo(4,"D",false, "3/24/2020", 3, "hw9");
    td6 = new Todo(4,"D",false, null, 3, "hw9");
    td7 = new Todo(4,"D",false, null, 4, "hw9");
    dc = new DateComparator();

  }

  @Test
  public void compare() {
    assertEquals(-1, dc.compare(td1, td2));
    assertEquals(-1, dc.compare(td2, td3));
    assertEquals(-1, dc.compare(td3, td4));
    assertEquals(0, dc.compare(td4, td5));
    assertEquals(1, dc.compare(td5, td1));
    assertEquals(0, dc.compare(td6, td7));
    assertEquals(-1, dc.compare(td1, td7));
    assertEquals(1, dc.compare(td6, td1));
  }



}