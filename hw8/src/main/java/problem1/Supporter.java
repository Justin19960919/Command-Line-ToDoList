package problem1;

import java.util.HashMap;
import java.util.Objects;

/**
 * A problem1.Supporter class that represents a supporter of the non-profit organization
 */
public class Supporter {

  HashMap <String, String> supporterInformation;

  /**
   * Constructor of the problem1.Supporter class.
   * Uses a HashMap to save the information of the supporters in key-value pairs.
   */
  public Supporter(){
    this.supporterInformation = new HashMap<String, String>();
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
   * @return a HashMap that describes the problem1.Supporter
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
    final StringBuilder sb = new StringBuilder("problem1.Supporter{");
    sb.append("supporterInformation=");
    // loop over hashmap
    for(String i: this.supporterInformation.keySet()){
      sb.append(i).append(":").append(this.supporterInformation.get(i)).append(";");
    }
    sb.append('}');
    return sb.toString();
  }

  /**
   * Equals method
   * @param o another object
   * @return a boolean (True/ False)
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Supporter supporter = (Supporter) o;
    return this.getSupporterInformation().equals(supporter.getSupporterInformation());
  }

  /**
   * Hashcode() method
   * @return an integer, the hashcode of the supporter
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getSupporterInformation());
  }
}
