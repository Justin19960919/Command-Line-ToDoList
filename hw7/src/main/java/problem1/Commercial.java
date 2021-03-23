package problem1;

import java.util.Objects;

/**
 * Represents a commercial property, inherits from Abstract properties
 */
public class Commercial extends AbstractProperties {

  private Integer numOfOffices;
  private boolean suitableForRental;

  /**
   * Constructor of commercial property
   * @param address the address of the property, a String
   * @param sizeInSqft the size in square feet of the property, a non negative Integer
   * @param numOfOffices number of offices of the property, a non negative Integer
   * @param suitableForRental whether the property is suitable for rental if not, a boolean flag
   * @throws ValueOutOfRangeException when numOfOffices is negative
   */
  public Commercial(String address, Integer sizeInSqft, Integer numOfOffices,
      boolean suitableForRental) throws ValueOutOfRangeException {
    super(address, sizeInSqft);
    this.checkValue(numOfOffices);  // non-negative

    this.numOfOffices = numOfOffices;
    this.suitableForRental = suitableForRental;
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
    Commercial that = (Commercial) o;
    return this.suitableForRental == that.suitableForRental && Objects
        .equals(this.numOfOffices, that.numOfOffices);
  }

  /**
   * Calculate the hashcode of this object
   * @return the hashcode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numOfOffices, this.suitableForRental);
  }

  /**
   * Returns a string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "problem1.Commercial" +
        super.toString() +
        "numOfOffices=" + this.numOfOffices +
        ", suitableForRental=" + this.suitableForRental +
        '}';
  }
}
