import java.util.HashMap;

public class Letter extends AbstractTemplate{

  private String message;
  private Supporter supporter;

  public Letter(String message, Supporter supporter) {
    super(message, supporter);
  }

  // TODO throw exception if key is not in the hashmap
  public String toTemplate(){
    HashMap<String, String> supporterInfo = this.supporter.getSupporterInformation();

    // Letter header
    StringBuilder letter = new StringBuilder();
    letter.append(supporterInfo.get("first_name ")).append(supporterInfo.get("last_name"))
        .append("\n");
    letter.append(supporterInfo.get("address ")).append("\n");
    letter.append(supporterInfo.get("city")).append(", ").append(supporterInfo.get("state"))
        .append(", ").append(supporterInfo.get("zip"));
    letter.append("Dear ").append(supporterInfo.get("first_name")).append(" ").
        append(supporterInfo.get("last_name")).append(",\n");


    // append message specified in GenerateOutput
    letter.append(this.message);
    return letter.toString();
  }

}
