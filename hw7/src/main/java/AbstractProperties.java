/**
 * A class that represents all properties.
 */
public abstract class AbstractProperties {
  protected String address;
  protected Integer sizeInSqft; // non-negative

  /**
   * Constructor of the abstract properties class
   * @param address The address of the property, a String
   * @param sizeInSqft The size in square feet of the property, an Integer
   * @throws NegativeValueException
   */
  public AbstractProperties(String address, Integer sizeInSqft) throws NegativeValueException{
    this.address = address;
    this.checkValue(sizeInSqft);  // checks if sizeInSqft is non negative
    this.sizeInSqft = sizeInSqft;
  }

  /**
   * Checks if the input value is less than 0, if yes, throw exception
   * @param value an Integer
   * @throws NegativeValueException when value is less than 0
   */
  protected void checkValue(Integer value) throws NegativeValueException{
    if(value < 0){
      throw new NegativeValueException();
    }
  }

  /**
   * Checks if the input value is less than 0, if yes, throw exception
   * @param value a Double
   * @throws NegativeValueException when value is less than 0
   */
  protected void checkValue(Double value) throws NegativeValueException{
    if(value < 0){
      throw new NegativeValueException();
    }
  }


}
