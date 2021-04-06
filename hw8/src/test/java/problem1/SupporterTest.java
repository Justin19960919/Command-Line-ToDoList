package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SupporterTest {

  Supporter supporter;
  Supporter supporter2;

  @Before
  public void setUp() throws Exception {
    supporter = new Supporter();
    supporter.addItem("A","B");
    supporter.addItem("C","D");
    supporter.addItem("E","F");
    //
    supporter2 = new Supporter();
  }

  @Test
  public void addItem() {
    assertEquals(3, supporter.getSupporterInformation().size());
    supporter.addItem("G", "H");
    assertEquals(4, supporter.getSupporterInformation().size());
    assertEquals(supporter.getSupporterInformation().get("G"), "H");
  }

  @Test
  public void getSupporterInformation() {
    Supporter supporter3 = new Supporter();
    assertEquals(supporter3, supporter2);

    Supporter supporter4 = new Supporter();
    supporter4.addItem("A", "B");
    supporter3.addItem("A", "B");
    assertEquals(supporter4, supporter3);
  }

  @Test
  public void testToString() {
    assertEquals("problem1.Supporter{supporterInformation=A:B;C:D;E:F;}", supporter.toString());
    assertEquals("problem1.Supporter{supporterInformation=}", supporter2.toString());
  }
}