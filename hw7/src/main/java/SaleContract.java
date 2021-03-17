public class SaleContract extends AbstractContract{

  public SaleContract(Integer askingPrice, boolean negotiableOrNot) throws NegativeValueException {
    super(askingPrice, negotiableOrNot);
  }

}
