package problem1;

import java.util.List;

/**
 * An problem1.Letter class that inherits the Abstract template class.
 * Represents an letter that is sent to the supporters.
 */
public class Letter extends AbstractTemplate {
  /**
   * Constructor of the problem1.Letter class
   * @param fileName The message in the problem1.Letter, a String
   * @param supporters The recipient of the letter, a problem1.Supporter object
   */
  public Letter(String fileName, List<Supporter> supporters, String outputDir) {
    super(fileName, supporters, outputDir);
  }


  /**
   * get the output file name
   * @param name name of the supporter
   * @return the output file name
   */
  @Override
  public String getFileName(String name) {
    return "Letter To " + name + ".txt";
  }

}
