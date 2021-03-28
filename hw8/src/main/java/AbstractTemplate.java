public abstract class AbstractTemplate {

  protected String message;
  protected Supporter supporter;

  public AbstractTemplate(String message, Supporter supporter) {
    this.message = message;
    this.supporter = supporter;
  }

  public abstract String toTemplate();


}
