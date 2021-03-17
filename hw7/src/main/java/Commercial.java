public class Commercial extends AbstractProperties{


  private Integer numOfOffices;
  private boolean suitableForRental;

  public Commercial(String address, Integer sizeInSqft, Integer numOfOffices,
      boolean suitableForRental) throws NegativeValueException {
    super(address, sizeInSqft);

    // Checks
    this.checkValue(numOfOffices); // Non = negative

    this.numOfOffices = numOfOffices;
    this.suitableForRental = suitableForRental;
  }
}
