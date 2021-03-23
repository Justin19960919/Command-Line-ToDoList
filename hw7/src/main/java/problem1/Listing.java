package problem1;

import java.util.Objects;

/**
 * A problem1.Listing class that has fields: properties and contract.
 * @param <T> A property with an upper bound of Abstract Properties
 * @param <U> A contract with an upper bound of Abstract Contract
 */
public class Listing <T extends AbstractProperties, U extends AbstractContract> {

  private T property;
  private U contract;

  /**
   * Constructor for problem1.Listing
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
   * Getter of contract
   * @return the contract of the listing
   */
  public U getContract() {
    return contract;
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
    Listing<?, ?> listing = (Listing<?, ?>) o;
    return Objects.equals(this.property, listing.property) && Objects
        .equals(this.contract, listing.contract);
  }

  /**
   * Calculate the hashcode of this object
   * @return the hashcode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.property, this.contract);
  }

  /**
   * Returns a string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "Listing{" +
        "property=" + this.property +
        ", contract=" + this.contract +
        '}';
  }
}
