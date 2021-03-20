import java.util.List;

public class CommercialAgent<P extends Commercial, C extends AbstractContract> extends Agent<P, C> {

  /**
   * Constructor of the agent class
   *
   * @param name           the name of the agent, a string
   * @param commissionRate the commission rate of the agent, a double
   */
  public CommercialAgent(String name, double commissionRate) {
    super(name, commissionRate);
  }

  /**
   * Constructor of the agent class
   *
   * @param name           the name of the agent, a string
   * @param list           the agent's collection of listing
   * @param commissionRate the commission rate of the agent, a double
   */
  public CommercialAgent(String name, List<Listing<P, C>> list, double commissionRate) {
    super(name, list, commissionRate);
  }
}
