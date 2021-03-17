public class RentalContract extends AbstractContract{
  private Integer termOnMonths;   // > 0

  public RentalContract(Integer askingPrice, boolean negotiableOrNot, Integer termOnMonths)
      throws NegativeValueException {
    super(askingPrice, negotiableOrNot);
    this.termOnMonths = termOnMonths;
  }

  
}
