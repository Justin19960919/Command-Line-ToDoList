/**
 * A Listing class that has fields: properties and contract.
 * @param <T> A property with an upper bound of Abstract Properties
 * @param <U> A contract with an upper bound of Abstract Contract
 */
public class Listing <T extends AbstractProperties, U extends AbstractContract>{

  private T property;
  private U contract;

  /**
   * Constructor for Listing
   * @param property Any class with super class of Abstract Properties
   * @param contract Any class with super class of Abstract Contract
   */
  public Listing(T property, U contract) {
    this.property = property;
    this.contract = contract;
  }

  /**
   * Getter of property
   * @return the property of the listing
   */
  public T getProperty() {
    return property;
  }

  /**
   * Setter of the property
   * @param property A property object with a super class of abstract properties
   */
  public void setProperty(T property) {
    this.property = property;
  }

  /**
   * Getter of contract
   * @return the contract of the listing
   */
  public U getContract() {
    return contract;
  }

  /**
   * Setter of the contract
   * @param contract A contract object with a super class of abstract contract
   */
  public void setContract(U contract) {
    this.contract = contract;
  }




}
