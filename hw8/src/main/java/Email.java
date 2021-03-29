import java.util.HashMap;

/**
 * An Email class that inherits the Abstract template class.
 * Represents an email that is sent to the supporters.
 */
public class Email extends AbstractTemplate{

  private String message;
  private Supporter supporter;

  /**
   * Constructor of the Email class
   * @param message The message in the Email, a String
   * @param supporter THe recipient of the email, a Supporter object
   */
  public Email(String message, Supporter supporter) {
    super(message, supporter);
  }


  /**
   * Generates the email template with corresponding fields of the supporter,
   * and fill the rest with the message.
   * @return a finished email, a String
   */
  public String toTemplate(){
    HashMap<String, String> supporterInfo = this.supporter.getSupporterInformation();

    // Email header
    StringBuilder email = new StringBuilder("To:");
    email.append(supporterInfo.get("email")).append("\n");
    email.append("Subject: Spring sale!");
    email.append("Dear ").append(supporterInfo.get("first_name")).append(" ")
        .append(supporterInfo.get("last_name")).append("\n");

    // Email message
    // Specify the message to pass in in the Generate Output class
    email.append(this.message);
    return email.toString();

  }






}


