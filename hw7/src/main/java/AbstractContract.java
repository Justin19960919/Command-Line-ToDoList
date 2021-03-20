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
   * @throws NegativeValueException when asking price is negative
   */
  public AbstractContract(Double askingPrice, boolean negotiableOrNot) throws NegativeValueException{
    if(askingPrice < 0){
      throw new NegativeValueException();
    }

    this.askingPrice = askingPrice;   // non negative
    this.negotiableOrNot = negotiableOrNot;
  }



}
