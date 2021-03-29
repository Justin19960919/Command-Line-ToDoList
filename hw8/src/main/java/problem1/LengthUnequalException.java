package problem1;

/**
 * Represents an exception when two arrays have unequal lengths,
 * used when we iterate using the array length
 */
public class LengthUnequalException extends Exception{

  /**
   * Constructor for the Length Unequal exception.
   */
  public LengthUnequalException(){
    super("Length of arrays don't match");
  }

}
