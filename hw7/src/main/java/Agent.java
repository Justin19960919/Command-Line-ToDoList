import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A generic class that represents an agent that deals with listings
 */
public class Agent <P extends AbstractProperties, C extends AbstractContract>{
  private String name;
  private List<Listing<P, C>> collectionOfCurrentListings;
  private double commissionRate;
  private double totalEarnings = 0;

  /**
   * Constructor of the agent class
   * @param name the name of the agent, a string
   * @param commissionRate the commission rate of the agent, a double
   */
  public Agent(String name, double commissionRate) {
    this.name = name;
    this.collectionOfCurrentListings = new ArrayList<>();
    this.commissionRate = commissionRate;
    this.totalEarnings = 0;
  }

  // Agent methods

  void addListing(Listing<P, C> listing){
    return;
  }

  void completeListing(){}

  void dropListing(){}

  double getTotalPortfolioValue(){}

}
