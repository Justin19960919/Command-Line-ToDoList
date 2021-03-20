public class NonexistentListingException extends Exception{
  public NonexistentListingException(){
    super("The agent does not have such listing!");
  }
}
