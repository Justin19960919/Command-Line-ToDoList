package problem1;

import java.util.Objects;

/**
 * Represents a residential property, inherits from Abstract properties
 */
public class Residential extends AbstractProperties {

  private Integer numOfBedRooms;
  private Double numOfBathRooms;

  /**
   * Constructor of residential property
   * @param address the address of the property, a String
   * @param sizeInSqft the size in square feet of the property, a non negative Integer
   * @param numOfBedRooms number of bedrooms of the property, a non negative Integer
   * @param numOfBathRooms number of bathrooms of the property, a non negative Double
   * @throws ValueOutOfRangeException when one of the values is negative
   */
  public Residential(String address, Integer sizeInSqft, Integer numOfBedRooms,
      Double numOfBathRooms) throws ValueOutOfRangeException {
    super(address, sizeInSqft);

    this.checkValue(numOfBedRooms);   // non-negative
    this.checkValue(numOfBathRooms);  // non-negative

    this.numOfBedRooms = numOfBedRooms;
    this.numOfBathRooms = numOfBathRooms;
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
    Residential that = (Residential) o;
    return Objects.equals(this.numOfBedRooms, that.numOfBedRooms) && Objects
        .equals(this.numOfBathRooms, that.numOfBathRooms);
  }

  /**
   * Calculate the hashcode of this object
   * @return the hashcode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numOfBedRooms, this.numOfBathRooms);
  }

  /**
   * Returns a string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "Residential" +
        super.toString() +
        "numOfBedRooms=" + this.numOfBedRooms +
        ", numOfBathRooms=" + this.numOfBathRooms +
        '}';
  }
}
