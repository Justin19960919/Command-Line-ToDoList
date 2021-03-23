package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RentalContractTest {
  private RentalContract contract;

  @Before
  public void setUp() throws Exception {
    contract = new RentalContract(2100.0, true, 10);
  }

  @Test
  public void getTotalPrice() {
    assertEquals(21000, contract.getTotalPrice(), 0.01);
  }

  @Test
  public void testEqualsSelf() {
    assertTrue(contract.equals(contract));
  }

  @Test
  public void testNotEqualsNull() {
    assertFalse(contract.equals(null));
  }

  @Test
  public void testNotEqualsOtherClass() throws ValueOutOfRangeException {
    SaleContract saleContract = new SaleContract(250000.0, true);
    assertFalse(contract.equals(saleContract));
  }

  @Test
  public void testEquals() throws ValueOutOfRangeException {
    RentalContract contract1 = new RentalContract(2100.0, true, 10);
    assertTrue(contract.equals(contract1));
  }

  @Test
  public void testNotEquals() throws ValueOutOfRangeException {
    RentalContract contract1 = new RentalContract(2100.0, true, 15);
    assertFalse(contract.equals(contract1));
  }

  @Test
  public void testHashcode() throws ValueOutOfRangeException {
    RentalContract contract1 = new RentalContract(2100.0, true, 10);
    assertEquals(contract.hashCode(), contract1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "RentalContract{askingPrice=2100.0, negotiableOrNot=true}, termInMonths=10}";
    assertEquals(s, contract.toString());
  }

}