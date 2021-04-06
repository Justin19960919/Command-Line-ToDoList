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
  protected String fileName;
  protected List<Supporter> supporters;
  protected String outputDir;

  /**
   * Constructor of Abstract Template.
   * @param fileName Message for the template
   * @param supporters A list of supporters object to use the fields to fill in spaces in the template
   */
  public AbstractTemplate(String fileName, List<Supporter> supporters, String outputDir) {
    this.fileName = fileName;
    this.supporters = supporters;
    this.outputDir = outputDir;
  }


  /**
   * read the file and convert it to a Paragraph as a string
   * @return the context of the file as a string
   */
  public String readTemplate() {
    StringBuilder template = new StringBuilder();
    BufferedReader inputFile = null;
    try {
      inputFile = new BufferedReader(new FileReader(this.fileName));

      String line;
      while ((line = inputFile.readLine()) != null) {

        template.append(line);
        template.append("\n");
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
    return template.toString();
  }

  /**
   * get the name of the the supporter, if not found, use number instead.
   * @param s support object
   * @param i rank of the supporter, used if name not found
   * @return the first name of the supporter
   */
  protected String getName(Supporter s, int i){
    for(String str :s.getSupporterInformation().keySet()){
      if(str.contains("first") && str.contains("name")){
        return s.getSupporterInformation().get(str).replace("\"", "");//remove double quotation mark
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
    int i = 1;
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
      }catch (FileNotFoundException fnfe) {
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
    StringBuilder template = new StringBuilder(this.readTemplate());
    String leftBracket = "[";
    String rightBracket = "]";
    while(template.indexOf(leftBracket) != -1){
      int start = template.indexOf(leftBracket);
      int end = template.indexOf(rightBracket) + 2;
      String key = "\"" + template.substring(start+2, end-2) + "\"";
      template.replace(start, end, s.getSupporterInformation().get(key));
    }
    return template.toString();
  }

  public String getDir(){
    return outputDir;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractTemplate that = (AbstractTemplate) o;
    return fileName.equals(that.fileName) &&
        supporters.equals(that.supporters) &&
        outputDir.equals(that.outputDir);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileName, supporters, outputDir);
  }

  @Override
  public String toString() {
    return "AbstractTemplate{" +
        "fileName='" + fileName + '\'' +
        ", supporters=" + supporters +
        ", outputDir='" + outputDir + '\'' +
        '}';
  }
}
