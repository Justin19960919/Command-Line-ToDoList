// import regex
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
  //  regex match for split
  //"([^"]|\n)*"

  public static void main(String[] args) {
    String test;
    StringBuilder msg = new StringBuilder();
    msg.append("\"Chauncey\",").append("\"Motley\",").append("\"Affiliated With Travelodge\",").append("\"63 E Aurora Dr\",").append("\"Orlando\"");
    test = msg.toString();

    System.out.println(test);
    // regex

    Pattern re = Pattern.compile("\"([^\"]|\n)*\"");
    Matcher m = re.matcher(test);
    // split successfully
    while (m.find()){
      System.out.println(
        test.substring(m.start(), m.end())
        );
    }


    // split failed
    /*
    String[] results = test.split("\"([^\"]|\n)*\"");
    System.out.println("Count:  "+ results.length);

    for(String r: results) {
      System.out.print(r);
    }
    */

  }






}
