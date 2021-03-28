import java.util.HashMap;
public class Email extends AbstractTemplate{

  private String message;
  private Supporter supporter;

  public Email(String message, Supporter supporter) {
    super(message, supporter);
  }

  // TODO throw exception if key is not in the hashmap
  public String toTemplate(){
    HashMap<String, String> supporterInfo = this.supporter.getSupporterInformation();

    // Email header
    StringBuilder email = new StringBuilder("To:");
    email.append(supporterInfo.get("email")).append("\n");
    email.append("Subject: Spring sale!");
    email.append("Dear ").append(supporterInfo.get("first_name")).append(" ")
        .append(supporterInfo.get("last_name")).append("\n");

    // append message specified in GenerateOutput
    email.append(this.message);
    return email.toString();

  }






}


