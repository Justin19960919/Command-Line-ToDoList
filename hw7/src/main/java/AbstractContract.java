import java.util.Objects;

/**
 * A class that represents a contract, covering a sales contract and a rental contract.
 */
public abstract class AbstractContract implements IContract{

  protected Double askingPrice;
  protected boolean negotiableOrNot;

  /**
   * Constructor for the AbstractContract class
   * @param askingPrice  the asking price, a non negative integer
   * @param negotiableOrNot whether or not the price is negotiable, a boolean flag
   * @throws ValueOutOfRangeException when asking price is negative
   */
  public AbstractContract(Double askingPrice, boolean negotiableOrNot) throws ValueOutOfRangeException {
    if(askingPrice < 0){
      throw new ValueOutOfRangeException("Value can not be less than 0.");
    }

    this.askingPrice = askingPrice;   // non negative
    this.negotiableOrNot = negotiableOrNot;
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
    AbstractContract that = (AbstractContract) o;
    return this.negotiableOrNot == that.negotiableOrNot && Objects
        .equals(this.askingPrice, that.askingPrice);
  }

  /**
   * Calculate the hashcode of this object
   * @return the hashcode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.askingPrice, this.negotiableOrNot);
  }

  /**
   * Returns a string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "AbstractContract{" +
        "askingPrice=" + this.askingPrice +
        ", negotiableOrNot=" + this.negotiableOrNot +
        '}';
  }
}
