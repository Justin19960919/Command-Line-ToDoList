package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListingTest {
  private Listing<AbstractProperties, AbstractContract> listing;
  private Residential residential;
  private RentalContract contract;

  @Before
  public void setUp() throws Exception {
    residential = new Residential("1 Moo St", 1000, 2, 2.0);
    contract = new RentalContract(2300.0, false, 10);
    listing = new Listing<>(residential, contract);
  }

  @Test
  public void getProperty() {
    assertEquals(residential, listing.getProperty());
  }

  @Test
  public void getContract() {
    assertEquals(contract, listing.getContract());
  }

  @Test
  public void testNotEquals() {
    assertFalse(listing.equals(contract));
  }

  @Test
  public void testEquals() {
    Listing<AbstractProperties, AbstractContract> listing1 = new Listing<>(residential, contract);
    assertTrue(listing.equals(listing1));
  }

  @Test
  public void testHashCode() {
    Listing<AbstractProperties, AbstractContract> listing1 = new Listing<>(residential, contract);
    assertEquals(listing.hashCode(), listing1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Listing{property=ResidentialProperties{address='1 Moo St', sizeInSqft=1000}numOfBedRooms=2, numOfBathRooms=2.0}, contract=RentalContract{askingPrice=2300.0, negotiableOrNot=false}, termInMonths=10}}";
    assertEquals(s, listing.toString());
  }
}