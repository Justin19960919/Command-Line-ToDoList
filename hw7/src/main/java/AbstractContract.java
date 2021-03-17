public class AbstractContract {

  protected Integer askingPrice;
  protected boolean negotiableOrNot;

  public AbstractContract(Integer askingPrice, boolean negotiableOrNot) throws NegativeValueException{
    this.checkValue(askingPrice);
    this.askingPrice = askingPrice;
    this.negotiableOrNot = negotiableOrNot;
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
