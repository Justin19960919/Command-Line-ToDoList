public class Residential extends AbstractProperties{

  private Integer numOfBedRooms;
  private Double numOfBathRooms;

  public Residential(String address, Integer sizeInSqft, Integer numOfBedRooms,
      Double numOfBathRooms) throws NegativeValueException {
    super(address, sizeInSqft);
    // Checks
    this.checkValue(numOfBedRooms);   // Non = negative
    this.checkValue(numOfBathRooms);  // Non = negative

    this.numOfBedRooms = numOfBedRooms;
    this.numOfBathRooms = numOfBathRooms;
  }



}
