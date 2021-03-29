package problem1;

import java.util.HashMap;
import problem1.AbstractTemplate;

/**
 * An problem1.Email class that inherits the Abstract template class.
 * Represents an email that is sent to the supporters.
 */
public class Email extends AbstractTemplate {

  private String message;
  private Supporter supporter;

  /**
   * Constructor of the problem1.Email class
   * @param message The message in the problem1.Email, a String
   * @param supporter THe recipient of the email, a problem1.Supporter object
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

    // problem1.Email header
    StringBuilder email = new StringBuilder("To:");
    email.append(supporterInfo.get("email")).append("\n");
    email.append("Subject: Spring sale!");
    email.append("Dear ").append(supporterInfo.get("first_name")).append(" ")
        .append(supporterInfo.get("last_name")).append("\n");

    // problem1.Email message
    // Specify the message to pass in in the Generate Output class
    email.append(this.message);
    return email.toString();

  }






}


