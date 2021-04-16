package problem1.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OptionTest {
  private Option option;
  private Option option1;

  @Before
  public void setUp() throws Exception {
    option = new Option("--email", false);
  }

  @Test
  public void getCmd() {
    assertEquals("--email", option.getCmd());
  }

  @Test
  public void getTakeValue() {
    assertEquals(false, option.getTakeValue());
  }

  @Test
  public void testEquals() {
    option1 = new Option("--email", false);
    assertTrue(option.equals(option1));
  }

  @Test
  public void testEqualsSelf() {
    assertTrue(option.equals(option));
  }

  @Test
  public void testNotEqualsNull() {
    assertFalse(option.equals(null));
  }

  @Test
  public void testNotEquals() {
    option1 = new Option("--email", true);
    assertFalse(option.equals(option1));
  }

  @Test
  public void testHashCode() {
    option1 = new Option("--email", false);
    assertEquals(option.hashCode(), option1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Option{cmd='--email', takeValue=false}";
    assertEquals(s, option.toString());
  }

}