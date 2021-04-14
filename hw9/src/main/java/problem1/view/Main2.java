package problem1.view;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import problem1.model.InvalidArgumentException;

public class Main2 {


  public static void main(String[] args){
    String test = "\"1\",\"Finish HW9\",\"false\",\"3/22/2020\",\"1\",\"school\"";
    ArrayList<String> results = new ArrayList<>();
    Pattern re = Pattern.compile("\"([^\"]|\n)*\"");
    Matcher m = re.matcher(test);
    // split successfully
    while (m.find()) {
      String s = test.substring(m.start()+1, m.end()-1);
      results.add(s);
    }
    for(String r: results){
      System.out.println(r);
    }


  }



}
