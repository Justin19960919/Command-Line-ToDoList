import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A generic class that represents an agent that deals with listings
 */
public class Agent<P extends AbstractProperties, C extends AbstractContract> {

  private String name;
  private List<Listing<P, C>> collectionOfCurrentListings;
  private double commissionRate;
  private double totalEarnings;

  /**
   * Constructor of the agent class
   *
   * @param name           the name of the agent, a string
   * @param commissionRate the commission rate of the agent, a double
   */
  public Agent(String name, double commissionRate) {
    this.name = name;
    this.collectionOfCurrentListings = new ArrayList<>();
    this.commissionRate = commissionRate;
    this.totalEarnings = 0;
  }

  /**
   * Constructor of the agent class
   *
   * @param name           the name of the agent, a string
   * @param list           the agent's collection of listing
   * @param commissionRate the commission rate of the agent, a double
   */
  public Agent(String name, List<Listing<P, C>> list, double commissionRate) {
    this.name = name;
    this.collectionOfCurrentListings = list;
    this.commissionRate = commissionRate;
    this.totalEarnings = 0;
  }

  /**
   * add a new listing to the agent's collection
   *
   * @param listing a listing
   */
  void addListing(Listing<P, C> listing) {
    this.collectionOfCurrentListings.add(listing);
  }

  /**
   * Agent successfully make a sale/rental - remove a new listing from the agent's collection and
   * add the commission to the total earning
   *
   * @param listing a listing
   * @throws NonexistentListingException when the listing passed to method is not present in the
   *                                     Agent’s collection.
   */
  void completeListing(Listing<P, C> listing) throws NonexistentListingException {
    for (Listing<P, C> l : this.collectionOfCurrentListings) {
      if (l.equals(listing)) {
        this.totalEarnings += l.getContract().getTotalPrice() * this.commissionRate;
        this.collectionOfCurrentListings.remove(l);
        return;
      }
    }
    throw new NonexistentListingException();
  }

  /**
   * drop a listing from the agent's collection
   *
   * @param listing a listing
   * @throws NonexistentListingException when the listing passed to method is not present in the *
   *                                     Agent’s collection.
   */
  void dropListing(Listing<P, C> listing) throws NonexistentListingException {
    for (Listing<P, C> l : this.collectionOfCurrentListings) {
      if (l.equals(listing)) {
        this.collectionOfCurrentListings.remove(l);
        return;
      }
    }
    throw new NonexistentListingException();
  }

  /**
   * @return the amount of money the Agent would make if they successfully completed all listings in
   * their collection
   * @throws NonexistentListingException when the listing passed to method is not present in the *
   *                                     Agent’s collection.
   */
  double getTotalPortfolioValue() throws NonexistentListingException {
    double total = 0.0;
    for (Listing<P, C> l : this.collectionOfCurrentListings) {
      total += l.getContract().getTotalPrice();
    }
    return total;
  }

}
