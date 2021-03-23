package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AgentTest {
  private Agent<Residential, AbstractContract> agent;
  private Residential residential;
  private AbstractContract contract;
  private RentalContract contract1;
  private Listing<Residential, AbstractContract> listing;
  private Listing<Residential, AbstractContract> listing1;

  @Before
  public void setUp() throws Exception {
    agent = new Agent<> ("Bog", 0.03);
    residential = new Residential("123 South St", 1000, 2, 2.0);
    contract = new SaleContract(550000.0, true);
    contract1 = new RentalContract(2400.0, false, 12);
    listing1 = new Listing<>(residential, contract1);
    listing = new Listing<>(residential, contract);
  }

  @Test(expected = ValueOutOfRangeException.class)
  public void setUpAgent() throws ValueOutOfRangeException {
    agent = new Agent<>("bob", 1.1);
  }


  @Test
  public void addListing() throws ValueOutOfRangeException {
    agent.addListing(listing);
    assertEquals(1, agent.getCollectionOfCurrentListings().size());
  }

  @Test
  public void completeListing() throws ValueOutOfRangeException, NonexistentListingException {
    agent.addListing(listing1);
    agent.addListing(listing);
    agent.completeListing(listing);
    assertTrue(agent.getTotalEarnings() == 16500);
    assertTrue(agent.getCollectionOfCurrentListings().size() == 1);
  }

  @Test(expected = NonexistentListingException.class)
  public void invalidCompleteListing() throws ValueOutOfRangeException, NonexistentListingException {
    agent.addListing(listing1);
    agent.completeListing(listing);
  }

  @Test
  public void getTotalPortfolioValue() throws ValueOutOfRangeException {
    agent.addListing(listing1);
    agent.addListing(listing);
    assertEquals(17364, agent.getTotalPortfolioValue(), 0.01);
  }

  @Test
  public void testEqualsSelf() {
    assertTrue(agent.equals(agent));
  }

  @Test
  public void testEqualsNotSameClass() {
    assertFalse(agent.equals(contract));
  }

  @Test
  public void testNotEquals() throws ValueOutOfRangeException {
    Agent agent1 = new Agent<AbstractProperties, AbstractContract>("Loo", 0.03);
    assertFalse(agent.equals(agent1));
  }

  @Test
  public void testEquals() throws ValueOutOfRangeException {
    Agent agent1 = new Agent<Residential, AbstractContract>("Bog", 0.03);
    assertTrue(agent.equals(agent1));
  }

  @Test
  public void testHashCode() throws ValueOutOfRangeException {
    Agent agent1 = new Agent<Residential, AbstractContract>("Bog", 0.03);
    assertEquals(agent.hashCode(), agent1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Agent{name='Bog', collectionOfCurrentListings=[], commissionRate=0.03, totalEarnings=0.0}";
    assertEquals(s, agent.toString());
  }
}