/**
 * A class that represents a sales contract
 */
public class SaleContract extends AbstractContract {

  /**
   * Constructor for a sale contract
   *
   * @param askingPrice     the asking price, a non negative integer
   * @param negotiableOrNot whether or not the price is negotiable, a boolean flag
   * @throws ValueOutOfRangeException when asking price is negative
   */
  public SaleContract(Double askingPrice, boolean negotiableOrNot) throws ValueOutOfRangeException {
    super(askingPrice, negotiableOrNot);
  }

  /**
   * Calculate the total price of the contract
   *
   * @return the total amount of the contract
   */
  @Override
  public double getTotalPrice() {
    return this.askingPrice;
  }
}
