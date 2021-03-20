/**
 * Represents a residential property, inherits from Abstract properties
 */
public class Residential extends AbstractProperties{

  private Integer numOfBedRooms;
  private Double numOfBathRooms;

  /**
   * Constructor of residential property
   * @param address the address of the property, a String
   * @param sizeInSqft the size in square feet of the property, a non negative Integer
   * @param numOfBedRooms number of bedrooms of the property, a non negative Integer
   * @param numOfBathRooms number of bathrooms of the property, a non negative Double
   * @throws NegativeValueException when one of the values is negative
   */
  public Residential(String address, Integer sizeInSqft, Integer numOfBedRooms,
      Double numOfBathRooms) throws NegativeValueException {
    super(address, sizeInSqft);

    this.checkValue(numOfBedRooms);   // non-negative
    this.checkValue(numOfBathRooms);  // non-negative

    this.numOfBedRooms = numOfBedRooms;
    this.numOfBathRooms = numOfBathRooms;
  }



}
