import java.util.HashMap;


public class Supporter {

  HashMap <String, String> supporterInformation = new HashMap<String, String>();
  public Supporter(){
    this.supporterInformation = supporterInformation;
  }


  public void addItem(String key, String value){
    supporterInformation.put(key, value);
  }



  public HashMap<String, String> getSupporterInformation() {
    return supporterInformation;
  }



}
