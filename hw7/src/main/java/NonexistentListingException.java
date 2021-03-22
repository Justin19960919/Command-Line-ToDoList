/**
 * Represents a non existent listing exception.
 */
public class NonexistentListingException extends Exception{

  /**
   * Create a new NonexistentListingException.
   */
  public NonexistentListingException(){
    super("The agent does not have such listing!");
  }
}
