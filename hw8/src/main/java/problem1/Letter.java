package problem1;

import java.util.HashMap;
import problem1.AbstractTemplate;

/**
 * An problem1.Letter class that inherits the Abstract template class.
 * Represents an letter that is sent to the supporters.
 */
public class Letter extends AbstractTemplate {

  private String message;
  private Supporter supporter;

  /**
   * Constructor of the problem1.Letter class
   * @param message The message in the problem1.Letter, a String
   * @param supporter The recipient of the letter, a problem1.Supporter object
   */
  public Letter(String message, Supporter supporter) {
    super(message, supporter);
  }


  /**
   * Generates the letter template with corresponding fields of the supporter,
   * and fill the rest with the message.
   * @return a finished letter, a String
   */
  public String toTemplate(){
    HashMap<String, String> supporterInfo = this.supporter.getSupporterInformation();

    // problem1.Letter header
    StringBuilder letter = new StringBuilder();
    letter.append(supporterInfo.get("first_name ")).append(supporterInfo.get("last_name"))
        .append("\n");
    letter.append(supporterInfo.get("address ")).append("\n");
    letter.append(supporterInfo.get("city")).append(", ").append(supporterInfo.get("state"))
        .append(", ").append(supporterInfo.get("zip"));
    letter.append("Dear ").append(supporterInfo.get("first_name")).append(" ").
        append(supporterInfo.get("last_name")).append(",\n");

    // problem1.Letter message
    // Specify the message to pass in in the Generate Output class
    letter.append(this.message);
    return letter.toString();
  }

}
