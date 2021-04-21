package problem1.view.comparator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.model.comparator.Date;

public class DateTest {

  Date d1;
  Date d2;
  Date d3;
  Date d4;
  Date d5;
  Date d6;
  Integer i;

  @Before
  public void setUp() throws Exception {
    d1 = new Date("1","1","2020");
    d2 = new Date("2","1","2020");
    d3 = new Date("1","2","2020");
    d4 = new Date("1","1","2021");
    d5 = new Date("12","2","2019");
    d6 = new Date("12","2","2019");
    i = 0;
  }

  @Test
  public void getMonth() {
    assertEquals(1, d1.getMonth().intValue());
    assertEquals(2, d2.getMonth().intValue());
    assertEquals(1, d3.getMonth().intValue());
    assertEquals(1, d4.getMonth().intValue());
    assertEquals(12, d5.getMonth().intValue());

  }

  @Test
  public void getDay() {
    assertEquals(1, d1.getDay().intValue());
    assertEquals(1, d2.getDay().intValue());
    assertEquals(2, d3.getDay().intValue());
    assertEquals(1, d4.getDay().intValue());
    assertEquals(2, d5.getDay().intValue());
  }

  @Test
  public void getYear() {
    assertEquals(2020, d1.getYear().intValue());
    assertEquals(2020, d2.getYear().intValue());
    assertEquals(2020, d3.getYear().intValue());
    assertEquals(2021, d4.getYear().intValue());
    assertEquals(2019, d5.getYear().intValue());
  }

  @Test
  public void testEquals() {
    assertFalse(d1.equals(null));
    assertTrue(d1.equals(d1));
    assertFalse(d1.equals(d2));
    assertTrue(d5.equals(d6));
    assertFalse(d1.equals(i));
  }

  @Test
  public void testHashCode() {
    assertEquals(d5.hashCode(), d6.hashCode());
    assertNotEquals(d5.hashCode(), d4.hashCode());
    assertNotEquals(d5.hashCode(), null);
  }

  @Test
  public void testToString() {
    assertEquals("Date{month=1, day=1, year=2020}", d1.toString());
    assertEquals("Date{month=2, day=1, year=2020}", d2.toString());
    assertEquals("Date{month=1, day=2, year=2020}", d3.toString());
    assertEquals("Date{month=1, day=1, year=2021}", d4.toString());
  }

  @Test
  public void compareTo(){
    assertEquals(0, d5.compareTo(d6));
    assertEquals(-1, d5.compareTo(d1));
    assertEquals(-1, d1.compareTo(d2));
    assertEquals(-1, d1.compareTo(d3));
    assertEquals(1, d1.compareTo(d6));
  }



}