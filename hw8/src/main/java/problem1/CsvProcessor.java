package problem1;// File IO
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// regex
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * A class that processes a csv file given a relative path to the csv file.
 */
public class CsvProcessor{

  private ArrayList<Supporter> arrayOfSupporters;
  private String csvRoute;

  /**
   * Constructor of the problem1.CsvProcessor class. Given an input path to the csv file,
   * output a ArrayList of supporters, which are rows in the csv
   * @param csvRoute The csv file's path, a String
   * @throws LengthUnequalException when the length of the fields, and the length
   * of the data entries differ
   */
  public CsvProcessor(String csvRoute) throws LengthUnequalException {
    this.csvRoute = csvRoute;
    this.arrayOfSupporters = this.process();
  }

  /**
   * problem1.Main function to process the csv file and output an ArrayList of Supporters
   * @return an ArrayList of Supporters
   * @throws LengthUnequalException when the length of the fields, and the length
   * of the data entries differ when processing
   */
  private ArrayList<Supporter> process() throws LengthUnequalException {
    ArrayList<Supporter> supporters = new ArrayList<>();

    // process the csv route
    try (BufferedReader inputFile = new BufferedReader(new FileReader(this.csvRoute))
    ){

      /////// problem1.Main processing here ///////

      String dataEntry;     // a row of data
      String firstLine = inputFile.readLine();
      // String array
      String[] parameters = firstLine.split(",");
      while ((dataEntry = inputFile.readLine()) != null) {
        // regex split
        ArrayList<String> splitResults = this.regexSplit(dataEntry);
        // create supporter
        Supporter supporter = createSupporter(parameters, splitResults);
        // add supporter to Arraylist
        supporters.add(supporter);
      }
      //////////////////////////////////////
    }catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
    // return results
    return supporters;
  }

  /**
   * Private helper function to the process() function, which takes a String array
   * of fields and an ArrayList of Strings that are the data points of that field,
   * and returns a problem1.Supporter
   * @param fields The fields of the csv file, a String array
   * @param data The data of the corresponding fields, an ArrayList of Strings
   * @return a problem1.Supporter object
   * @throws LengthUnequalException when the length of the fields, and the length
   * of the data entries differ when processing
   */
  private Supporter createSupporter(String[] fields, ArrayList<String> data)
      throws LengthUnequalException {
    // check if length is equal
    int numberOfParameters = fields.length;
    if(data.size() != numberOfParameters){
      throw new LengthUnequalException();
    }
    // else, create supporter
    Supporter supporter = new Supporter();
    for(int i = 0; i < numberOfParameters; i++){
      supporter.addItem(fields[i], data.get(i));
    }

    return supporter;
  }


  /**
   * Private helper function of process(). Transforms a row in the
   * csv file to an ArrayList of strings that have the data
   * corresponding to the fields of the csv file.
   * @param input a row in the csv file, a String
   * @return an ArrayList of Strings.
   */
  private ArrayList<String> regexSplit(String input){
    ArrayList<String> results = new ArrayList<>();
    Pattern re = Pattern.compile("\"([^\"]|\n)*\"");
    Matcher m = re.matcher(input);
    // split successfully
    while (m.find()){
      String s = input.substring(m.start(), m.end());
      results.add(s);
    }
    return results;
  }

  /**
   * Getter of the ArrayList of supporters
   * @return an ArrayList of supporters
   */
  public ArrayList<Supporter> getArrayOfSupporters() {
    return arrayOfSupporters;
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
    CsvProcessor that = (CsvProcessor) o;
    return Objects.equals(this.arrayOfSupporters, that.arrayOfSupporters) && Objects
        .equals(this.csvRoute, that.csvRoute);
  }

  /**
   * Calculate the hashcode of this object.
   *
   * @return - the hash code of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.arrayOfSupporters, this.csvRoute);
  }

  /**
   * Get string representation of this object.
   *
   * @return - string representation of this object.
   */
  @Override
  public String toString() {
    return "CsvProcessor{" +
        "arrayOfSupporters=" + this.arrayOfSupporters +
        ", csvRoute='" + this.csvRoute + '\'' +
        '}';
  }
}



