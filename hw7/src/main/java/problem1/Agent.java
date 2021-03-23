package problem1;

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

/* /**
   * Constructor of the agent class
   *
   * @param name           the name of the agent, a string
   * @param list           the agent's collection of listing
   * @param commissionRate the commission rate of the agent, a double
   *//*
  public Agent(String name, List<Listing<P, C>> list, double commissionRate) {
    this.name = name;
    this.collectionOfCurrentListings = list;
    this.commissionRate = commissionRate;
    this.totalEarnings = 0;
  }*/

  /**
   * Get the collectionOfCurrentListings;
   *
   * @return the collectionOfCurrentListings
   */
  public List<Listing<P, C>> getCollectionOfCurrentListings() {
    return this.collectionOfCurrentListings;
  }

  /**
   * Get the total earnings
   * @return the total earnings
   */
  public double getTotalEarnings() {
    return this.totalEarnings;
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
   * problem1.Agent successfully make a sale/rental - remove a new listing from the agent's collection and
   * add the commission to the total earning
   *
   * @param listing a listing
   * @throws NonexistentListingException when the listing passed to method is not present in the
   *                                     problem1.Agent’s collection.
   */
  void completeListing(Listing<P, C> listing) throws NonexistentListingException {
    dropListing(listing);
    this.totalEarnings += listing.getContract().getTotalPrice() * this.commissionRate;
  }

  /**
   * drop a listing from the agent's collection
   *
   * @param listing a listing
   * @throws NonexistentListingException when the listing passed to method is not present in the *
   *                                     problem1.Agent’s collection.
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
   * Calculate total portfolio value of the agent.
   *
   * @return the amount of money the problem1.Agent would make if they successfully completed all listings in
   * their collection.
   */
  double getTotalPortfolioValue(){
    double total = 0.0;
    for (Listing<P, C> l : this.collectionOfCurrentListings) {
      total += l.getContract().getTotalPrice() * this.commissionRate;
    }
    return total;
  }

  /**
   * Compare this object with the given object
   * @param o - the given object to compare
   * @return true if the given object is equals to this object
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Agent<?, ?> agent = (Agent<?, ?>) o;
    return Double.compare(agent.commissionRate, this.commissionRate) == 0
        && Double.compare(agent.totalEarnings, this.totalEarnings) == 0 && Objects
        .equals(this.name, agent.name) && Objects
        .equals(this.collectionOfCurrentListings, agent.collectionOfCurrentListings);
  }

  /**
   * Calculate the hashcode of this object
   * @return the hashcode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.collectionOfCurrentListings, this.commissionRate, this.totalEarnings);
  }

  /**
   * Returns a string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "Agent{" +
        "name='" + this.name + '\'' +
        ", collectionOfCurrentListings=" + this.collectionOfCurrentListings +
        ", commissionRate=" + this.commissionRate +
        ", totalEarnings=" + this.totalEarnings +
        '}';
  }
}
