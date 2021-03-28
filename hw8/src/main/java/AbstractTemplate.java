/**
 * An abstract class that represents a template that is generated for supporters.
 */
public abstract class AbstractTemplate {

  protected String message;
  protected Supporter supporter;

  /**
   * Constructor of Abstract Template.
   * @param message Message for the template
   * @param supporter A supporter object to use the fields to fill in spaces in the template
   */
  public AbstractTemplate(String message, Supporter supporter) {
    this.message = message;
    this.supporter = supporter;
  }

  /**
   * Abstract method that generates the whole template
   * @return a String, which is the information inside the template
   */
  public abstract String toTemplate();


}
