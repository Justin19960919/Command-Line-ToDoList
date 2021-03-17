public class AbstractContract {

  protected Integer askingPrice;
  protected boolean negotiableOrNot;

  public AbstractContract(Integer askingPrice, boolean negotiableOrNot) throws NegativeValueException{
    if(askingPrice < 0){
      throw new NegativeValueException();
    }
    this.askingPrice = askingPrice;   // non negative
    this.negotiableOrNot = negotiableOrNot;
  }



}
