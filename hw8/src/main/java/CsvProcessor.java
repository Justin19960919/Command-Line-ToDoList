// File IO
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// regex
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CsvProcessor{

  private ArrayList<Supporter> arrayOfSupporters;

  public CsvProcessor(String csvRoute) throws LengthUnequalException{
    this.arrayOfSupporters = this.process(csvRoute);
  }



  private ArrayList<Supporter> process(String csvRoute) throws LengthUnequalException{
    ArrayList<Supporter> supporters = new ArrayList<Supporter>();

    // process the csv route
    System.out.println(System.getProperty("user.dir")); // Sanity check
    try (BufferedReader inputFile = new BufferedReader(new FileReader(csvRoute));
    ){
      // Main processing here
      String line;

      String firstline = inputFile.readLine();
      System.out.println("first line:" + firstline);

      //      string array
      String[] parameters = firstline.split(",");
      for(String p: parameters){
        System.out.println(p);
      }
      int numberOfParameters = parameters.length;



      int count = 0;
      while ((line = inputFile.readLine()) != null) {
        // if first line
        if(count == 0){
          count ++;
          continue;
        }
        // else
        System.out.println("Read : " + line);
        // regex split
        ArrayList<String> splitResults = this.regexSplit(line);

        // check if length is equal
        if(splitResults.size() != numberOfParameters){
          throw new LengthUnequalException();
        }
        // else if length is equal
        // create supporter
        Supporter supporter = new Supporter();
        for(int i = 0; i < numberOfParameters; i++){
          supporter.addItem(parameters[i], splitResults.get(i));
        }
        // add to arraylist
        supporters.add(supporter);
        count ++;
      }
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



  private ArrayList<String> regexSplit(String input){
    ArrayList<String> results = new ArrayList<>();
    Pattern re = Pattern.compile("\"([^\"]|\n)*\"");
    Matcher m = re.matcher(input);
    // split successfully
    while (m.find()){
      String s = input.substring(m.start(), m.end());
      System.out.println(s);
      results.add(s);
    }
    return results;
  }


  public ArrayList<Supporter> getArrayOfSupporters() {
    return arrayOfSupporters;
  }

}



