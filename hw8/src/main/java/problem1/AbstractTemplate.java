package problem1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * An abstract class that represents a template that is generated for supporters.
 */
public abstract class AbstractTemplate {
  private static final int INITIAL = 1;
  private static final int INVALID_INDEX = -1;
  private static final int OFFSET = 2;

  protected String fileName;
  protected List<Supporter> supporters;
  protected String outputDir;
  protected StringBuilder template;

  /**
   * Constructor of Abstract Template.
   * @param fileName Message for the template
   * @param supporters A list of supporters object to use the fields to fill in spaces in the template
   * @param outputDir output file directory
   */
  public AbstractTemplate(String fileName, List<Supporter> supporters, String outputDir) {
    this.fileName = fileName;
    this.supporters = supporters;
    this.outputDir = outputDir;
    this.template = new StringBuilder();
    this.readTemplate();
  }


  /**
   * read the file and convert it to a Paragraph as a string
   */
  public final void readTemplate() {
    BufferedReader inputFile = null;
    try {
      inputFile = new BufferedReader(new FileReader(this.fileName));

      String line;
      while ((line = inputFile.readLine()) != null) {

        this.template.append(line);
        this.template.append("\n");
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

  /**
   * get the name of the the supporter, if not found, use number instead.
   * @param s support object
   * @param i rank of the supporter, used if name not found
   * @return the first name of the supporter
   */
  private String getName(Supporter s, int i){
    for(String str :s.getSupporterInformation().keySet()){
      if(str.contains("first") && str.contains("name")){
        return s.getSupporterInformation().get(str).replace("\"", "");
      }
    }
    return String.valueOf(i);
  }

  /**
   * get the output file name
   * @param name name of the supporter
   * @return the output file name
   */
  public abstract String getFileName(String name);

  /**
   * create a new file and write the output to it
   */
  public void writeOutput(){
    int i = INITIAL;
    for(Supporter s : this.supporters){
      String name = this.getName(s, i++);
      try{
        File f = new File(getDir(), this.getFileName(name));
        f.createNewFile();
        FileWriter file = new FileWriter(f);

        String[] lines = this.generateOutput(s).split("\\n");
        for(String line: lines) {
          file.write(line + "\n");
          file.flush();
        }
      } catch (FileNotFoundException fnfe) {
        System.out.println("A file was not found : " + fnfe.getMessage());
        fnfe.printStackTrace();
      } catch (IOException ioe) {
        System.out.println("Something went wrong! : " + ioe.getMessage());
        ioe.printStackTrace();
      }
    }
  }

  /**
   * generate the output by replacing the all placeholders with the appropriate value
   * @param s supporter object
   * @return the output after all placeholders replaced
   */
  public String generateOutput(Supporter s) {
    StringBuilder template = new StringBuilder(this.template);
    String leftBracket = "[";
    String rightBracket = "]";
    while(template.indexOf(leftBracket) != INVALID_INDEX){
      int start = template.indexOf(leftBracket);
      int end = template.indexOf(rightBracket) + OFFSET;
      String key = "\"" + template.substring(start + OFFSET, end - OFFSET) + "\"";
      template.replace(start, end, s.getSupporterInformation().get(key));
    }
    return template.toString();
  }

  /**
   * Get the output directory
   *
   * @return the output directory
   */
  public String getDir(){
    return this.outputDir;
  }

  /**
   * Compare this object with the given object.
   *
   * @param o - the given object to compare with
   * @return - true if this is equal to the given object
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    AbstractTemplate that = (AbstractTemplate) o;
    return this.fileName.equals(that.fileName) &&
        this.supporters.equals(that.supporters) &&
        this.outputDir.equals(that.outputDir);
  }

  /**
   * Calculate the hashcode of this object.
   *
   * @return - the hash code of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.fileName, this.supporters, this.outputDir);
  }

  /**
   * Get string representation of this object.
   *
   * @return - string representation of this object.
   */
  @Override
  public String toString() {
    return "AbstractTemplate{" +
        "fileName='" + this.fileName + '\'' +
        ", supporters=" + this.supporters +
        ", outputDir='" + this.outputDir + '\'' +
        '}';
  }
}
