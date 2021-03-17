/**
 * Represents a commerical property, inherits from Abstract properties
 */
public class Commercial extends AbstractProperties{

  private Integer numOfOffices;
  private boolean suitableForRental;

  /**
   * Constructor of commerical property
   * @param address the address of the property, a String
   * @param sizeInSqft the size in square feet of the property, a non negative Integer
   * @param numOfOffices number of offices of the property, a non negative Integer
   * @param suitableForRental whether the property is suitable for rental if not, a boolean flag
   * @throws NegativeValueException when numOfOffices is negative
   */
  public Commercial(String address, Integer sizeInSqft, Integer numOfOffices,
      boolean suitableForRental) throws NegativeValueException {
    super(address, sizeInSqft);
    this.checkValue(numOfOffices);  // non-negative

    this.numOfOffices = numOfOffices;
    this.suitableForRental = suitableForRental;
  }
}
