package problem1;

import java.util.List;

/**
 * An problem1.Email class that inherits the Abstract template class.
 * Represents an email that is sent to the supporters.
 */
public class Email extends AbstractTemplate {
  /**
   * Constructor of the problem1.Email class
   * @param fileName The message in the problem1.Email, a String
   * @param supporters THe recipient of the email, a problem1.Supporter object
   */
  public Email(String fileName, List<Supporter> supporters, String outputDir) {
    super(fileName, supporters, outputDir);
  }

  /**
   * get the output file name
   * @param name name of the supporter
   * @return the output file name
   */
  @Override
  public String getFileName(String name) {
    return "Email To " + name + ".txt";
  }



}


