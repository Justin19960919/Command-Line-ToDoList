package problem1;

import static org.junit.Assert.*;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode.Op;
import org.junit.Before;
import org.junit.Test;

public class OptionsTest {
  private Options options;

  @Before
  public void setUp() throws Exception {
    options = new Options();
  }

  @Test
  public void getOptions() {
    assertEquals(6, options.getOptions().size());
  }

  @Test
  public void testEqualsSelf() {
    assertTrue(options.equals(options));
  }

  @Test
  public void testNotEqualsNull() {
    assertFalse(options.equals(null));
  }

  @Test
  public void testEquals() {
    Options options1 = new Options();
    assertTrue(options.equals(options1));
  }

  @Test
  public void testHashCode() {
    Options options1 = new Options();
    assertEquals(options.hashCode(), options1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Options{options=[Option{cmd='--email', takeValue=false}, Option{cmd='--email-template', takeValue=true}, Option{cmd='--letter', takeValue=false}, Option{cmd='--letter-template', takeValue=true}, Option{cmd='--output-dir', takeValue=true}, Option{cmd='--csv-file', takeValue=true}]}";
    assertEquals(s, options.toString());
  }
}