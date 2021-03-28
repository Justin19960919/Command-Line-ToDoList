import java.util.HashMap;

/**
 * A Supporter class that represents a supporter of the non-profit organization
 */
public class Supporter {

  HashMap <String, String> supporterInformation = new HashMap<String, String>();

  /**
   * Constructor of the Supporter class.
   * Uses a HashMap to save the information of the supporters in key-value pairs.
   */
  public Supporter(){
    this.supporterInformation = supporterInformation;
  }

  /**
   * Adds a key value pair to the supporters information, which is a hashmap.
   * @param key The field to add to, a String.
   * @param value The value of the field, a String.
   */
  public void addItem(String key, String value){
    supporterInformation.put(key, value);
  }

  /**
   * Getter of the supporters information
   * @return a HashMap that describes the Supporter
   */
  public HashMap<String, String> getSupporterInformation() {
    return supporterInformation;
  }


  /**
   * toString method to print out all the key value pairs of the supporter
   * @return a String
   */
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Supporter{");
    sb.append("supporterInformation=");
    // loop over hashmap
    for(String i: this.supporterInformation.keySet()){
      sb.append(i).append(" ").append(this.supporterInformation.get(i)).append("\n");
    }
    sb.append('}');
    return sb.toString();
  }

}
