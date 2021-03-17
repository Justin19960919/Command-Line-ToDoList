/**
 * A class that represents a rental contract
 */
public class RentalContract extends AbstractContract{
  private Integer termInMonths;   // > 0

  /**
   * Constructor for a rental contract
   * @param askingPrice the asking price, a non negative integer
   * @param negotiableOrNot whether or not the price is negotiable, a boolean flag
   * @param termOnMonths term in months
   * @throws NegativeValueException when asking price is negative
   * @throws ZeroOrNegativeException when term in month is less than or equal to 0
   */
  public RentalContract(Double askingPrice, boolean negotiableOrNot, Integer termOnMonths)
      throws NegativeValueException, ZeroOrNegativeException{
    super(askingPrice, negotiableOrNot);

    // Check
    if(termOnMonths <= 0){
      throw new ZeroOrNegativeException();
    }
    this.termInMonths = termInMonths;
  }


}
