public abstract class AbstractProperties {
  protected String address;
  protected Integer sizeInSqft; // non negative

  public AbstractProperties(String address, Integer sizeInSqft) throws NegativeValueException{
    this.address = address;
    // Checks
    this.checkValue(sizeInSqft);  // Non = negative
    this.sizeInSqft = sizeInSqft;
  }

  protected void checkValue(Integer value) throws NegativeValueException{
    if(value < 0){
      throw new NegativeValueException();
    }
  }

  protected void checkValue(Double value) throws NegativeValueException{
    if(value < 0){
      throw new NegativeValueException();
    }
  }


}
