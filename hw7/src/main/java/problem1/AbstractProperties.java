package problem1;

import java.util.Objects;

/**
 * A class that represents all properties.
 */
public abstract class AbstractProperties {
  protected String address;
  protected Integer sizeInSqft; // non-negative

  /**
   * Constructor of the abstract properties class
   * @param address The address of the property, a String
   * @param sizeInSqft The size in square feet of the property, an Integer
   * @throws ValueOutOfRangeException throw exception when sizeInSqft is negative
   */
  public AbstractProperties(String address, Integer sizeInSqft) throws ValueOutOfRangeException {
    this.address = address;
    this.checkInteger(sizeInSqft);  // checks if sizeInSqft is non negative
    this.sizeInSqft = sizeInSqft;
  }

  /**
   * Checks if the input value is less than 0, if yes, throw exception
   * @param value an Integer
   * @throws ValueOutOfRangeException when value is less than 0
   */
  protected static void checkInteger(Integer value) throws ValueOutOfRangeException {
    if(value < 0){
      throw new ValueOutOfRangeException("Value can not be less than 0.");
    }
  }


  /**
   * Compare this object with the given object
   * @param o - the given object to compare
   * @return true if the given object is equals to this object
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    AbstractProperties that = (AbstractProperties) o;
    return Objects.equals(this.address, that.address) && Objects
        .equals(this.sizeInSqft, that.sizeInSqft);
  }

  /**
   * Calculate the hashcode of this object
   * @return the hashcode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.address, this.sizeInSqft);
  }

  /**
   * Returns a string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "Properties{" +
        "address='" + this.address + '\'' +
        ", sizeInSqft=" + this.sizeInSqft +
        '}';
  }
}
