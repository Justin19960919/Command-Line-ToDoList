package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommercialTest {
  private Commercial commercial;

  @Before
  public void setUp() throws Exception {
    commercial = new Commercial("123 Moo St", 1000, 2, true);
  }

  @Test
  public void testEqualsSelf() {
    assertTrue(commercial.equals(commercial));
  }

  @Test
  public void testNotEqualsNull() {
    assertFalse(commercial.equals(null));
  }

  @Test
  public void testNotEqualsOtherClass() throws ValueOutOfRangeException {
    SaleContract saleContract = new SaleContract(550000.0, true);
    Listing<Commercial, SaleContract> listing = new Listing<>(commercial, saleContract);
    assertFalse(commercial.equals(listing));
  }

  @Test
  public void testEquals() throws ValueOutOfRangeException {
    Commercial commercial1 = new Commercial("123 Moo St", 1000, 2, true);
    assertTrue(commercial.equals(commercial1));
  }

  @Test
  public void testNotEquals() throws ValueOutOfRangeException {
    Commercial commercial1 = new Commercial("123 Moo St", 1500, 2, true);
    assertFalse(commercial.equals(commercial1));
  }

  @Test
  public void testNotEquals2() throws ValueOutOfRangeException {
    Commercial commercial1 = new Commercial("123 Moo St", 1000, 2, false);
    assertFalse(commercial.equals(commercial1));
  }

  @Test
  public void testHashCode() throws ValueOutOfRangeException {
    Commercial commercial1 = new Commercial("123 Moo St", 1000, 2, true);
    assertEquals(commercial.hashCode(), commercial1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "CommercialProperties{address='123 Moo St', sizeInSqft=1000}numOfOffices=2, suitableForRental=true}";
    assertEquals(s, commercial.toString());
  }
}