public class RentalContract extends AbstractContract{
  private Integer termOnMonths;

  public RentalContract(Integer askingPrice, boolean negotiableOrNot, Integer termOnMonths)
      throws NegativeValueException, ZeroOrNegativeException{
    super(askingPrice, negotiableOrNot);
    /* Can mayber create an interface for checking for non negative values*/
    if(termOnMonths <= 0){
      throw new ZeroOrNegativeException();
    }
    this.termOnMonths = termOnMonths;  // larger than 0
  }


}
