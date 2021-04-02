package problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class GenerateOutput {
  private StringBuilder output;
  private Supporter supporter;

  public GenerateOutput(Supporter supporter){
    output = new StringBuilder();
    this.supporter = supporter;
  }

  public void readTemplate(String fileName) {
    BufferedReader inputFile = null;

    try {
      inputFile = new BufferedReader(new FileReader(fileName));

      String line;
      while ((line = inputFile.readLine()) != null) {

        output.append(line);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println("Failed to close input stream");
        }
      }
    }

  }

  public String generateOutput(String fileName) {
    HashMap<String, String> supporterInfo = this.supporter.getSupporterInformation();
    String leftBracket = "[";
    String rightBracket = "]";
    while(output.indexOf(leftBracket) != -1){
      int start = output.indexOf(leftBracket);
      int end = output.indexOf(rightBracket) + 1;
      String key = output.substring(start+2, end-1);
      output.replace(start, end, supporterInfo.get(key));
    }
    return output.toString();
  }





//  // Message to put into problem1.Email and problem1.Letter
//  public static void main(String[] args){
//    StringBuilder message = new StringBuilder();
//    // message
//    // put message in main
//    message.append("Everything in our store will be 20% off between now and the end of April! "
//        + "Stock up on our logo mugs, T shirts, and water bottles to show your support and help "
//        + "raise awareness. Our magnets, plushies, and picture books, also make great gifts "
//        + "for the children in your life.").append("\n");
//
//    message.append("Remember, all proceeds go to support our work and, "
//        + "if we can reach our goal of $10,000 in sales by the end of April, "
//        + "an anonymous donor has pledged to match every $1 you spend. "
//        + "Want to help out but don’t want to buy stuff? Visit our website to make a donation.").append("\n");
//
//    message.append("Sincerely,").append("\n");
//    message.append("Non-Profit Director");
//
//    System.out.println(message);
//
//  }






}
