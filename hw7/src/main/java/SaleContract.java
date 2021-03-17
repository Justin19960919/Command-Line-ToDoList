/**
 * A class that represents a sales contract
 */
public class SaleContract extends AbstractContract{

  /**
   * Constructor for a sales contract
   * @param askingPrice  the asking price, a non negative integer
   * @param negotiableOrNot whether or not the price is negotiable, a boolean flag
   * @throws NegativeValueException when asking price is negative
   */
  public SaleContract(Double askingPrice, boolean negotiableOrNot) throws NegativeValueException {
    super(askingPrice, negotiableOrNot);
  }

}
