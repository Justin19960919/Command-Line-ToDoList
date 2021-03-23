package problem1;

import java.util.Objects;

/**
 * A class that represents a rental contract
 */
public class RentalContract extends AbstractContract {
  private Integer termInMonths;   // > 0

  /**
   * Constructor for a rental contract
   * @param askingPrice the asking price, a non negative integer
   * @param negotiableOrNot whether or not the price is negotiable, a boolean flag
   * @param termOnMonths term in months
   * @throws ValueOutOfRangeException when asking price is negative
   */
  public RentalContract(Double askingPrice, boolean negotiableOrNot, Integer termOnMonths)
      throws ValueOutOfRangeException {
    super(askingPrice, negotiableOrNot);

    // Check
    if(termOnMonths <= 0){
      throw new ValueOutOfRangeException("Value has to be greater than 0.");
    }
    this.termInMonths = termOnMonths;
  }

  /**
   * calculate the total price of this contract
   *
   * @return the total amount of the contract
   */
  @Override
  public double getTotalPrice() {
    return this.askingPrice * this.termInMonths;
  }

  /**
   * Compare this object with the given object
   * @param o - the given object to compare
   * @return true if the given object is equals to this object
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    RentalContract that = (RentalContract) o;
    return Objects.equals(this.termInMonths, that.termInMonths);
  }

  /**
   * Calculate the hashcode of this object
   * @return the hashcode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.termInMonths);
  }

  /**
   * Returns a string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "Rental" +
        super.toString() +
        ", termInMonths=" + this.termInMonths +
        '}';
  }
}
