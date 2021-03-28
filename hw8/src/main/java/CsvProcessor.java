// File IO
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// regex
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * A class that processes a csv file given a relative path to the csv file.
 */
public class CsvProcessor{

  private ArrayList<Supporter> arrayOfSupporters;
  private String csvRoute;

  /**
   * Constructor of the CsvProcessor class. Given an input path to the csv file,
   * output a ArrayList of supporters, which are rows in the csv
   * @param csvRoute The csv file's path, a String
   * @throws LengthUnequalException when the length of the fields, and the length
   * of the data entries differ
   */
  public CsvProcessor(String csvRoute) throws LengthUnequalException{
    this.csvRoute = csvRoute;
    this.arrayOfSupporters = this.process();
  }

  /**
   * Main function to process the csv file and output an ArrayList of Supporters
   * @return an ArrayList of Supporters
   * @throws LengthUnequalException when the length of the fields, and the length
   * of the data entries differ when processing
   */
  private ArrayList<Supporter> process() throws LengthUnequalException{
    ArrayList<Supporter> supporters = new ArrayList<>();

    // process the csv route
    // System.out.println(System.getProperty("user.dir")); // Sanity check

    try (BufferedReader inputFile = new BufferedReader(new FileReader(this.csvRoute));
    ){

      /////// Main processing here ///////

      String dataEntry;     // a row of data
      String firstline = inputFile.readLine();
      // String array
      String[] parameters = firstline.split(",");
      int count = 0;
      while ((dataEntry = inputFile.readLine()) != null) {

        // if first line, then it is the header, we skip
        if(count == 0){
          count ++;
          continue;
        }
        // regex split
        ArrayList<String> splitResults = this.regexSplit(dataEntry);
        // create supporter
        Supporter supporter = createSupporter(parameters, splitResults);
        // validate (print out supporter information)
        System.out.println(supporter.toString());

        // add supporter to Arraylist
        supporters.add(supporter);
        // increment
        count ++;
      }
      //////////////////////////////////////
    }catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
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
   * and returns a Supporter
   * @param fields The fields of the csv file, a String array
   * @param data The data of the corresponding fields, an ArrayList of Strings
   * @return a Supporter object
   * @throws LengthUnequalException when the length of the fields, and the length
   * of the data entries differ when processing
   */
  private Supporter createSupporter(String[] fields, ArrayList<String> data)
      throws LengthUnequalException{

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

}



