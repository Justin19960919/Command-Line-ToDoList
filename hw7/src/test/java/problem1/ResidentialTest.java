package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ResidentialTest {
  private Residential residential;

  @Before
  public void setUp() throws Exception {
    residential = new Residential("1 Moo St", 1200, 3, 2.5);
  }

  @Test
  public void testEquals() throws ValueOutOfRangeException {
    Residential residential1 = new Residential("1 Moo St", 1200, 3, 2.5);
    assertTrue(residential.equals(residential1));
  }

  @Test
  public void testNotEqualsSuper() throws ValueOutOfRangeException {
    Residential residential1 = new Residential("1 Moo St", 1100, 3, 2.5);
    assertFalse(residential.equals(residential1));
  }

  @Test
  public void testNotEquals() throws ValueOutOfRangeException {
    Residential residential1 = new Residential("1 Moo St", 1200, 2, 2.5);
    assertFalse(residential.equals(residential1));
  }

  @Test
  public void testHashCode() throws ValueOutOfRangeException {
    Residential residential1 = new Residential("1 Moo St", 1200, 3, 2.5);
    assertEquals(residential.hashCode(), residential1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "ResidentialProperties{address='1 Moo St', sizeInSqft=1200}numOfBedRooms=3, numOfBathRooms=2.5}";
    assertEquals(s, residential.toString());
  }
}