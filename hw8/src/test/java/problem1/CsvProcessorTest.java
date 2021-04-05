package problem1;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

// Three test files to test CsvProcessor
// test1.csv: Normal
// test2.csv: Empty
// test3.csv: has an additional "error" on the last line, should throw LengthUnequalException


public class CsvProcessorTest {

  CsvProcessor csv1;
  Supporter supporter1;

  @Before
  public void setUp() throws Exception {
    csv1 = new CsvProcessor("test1.csv");
    supporter1 = new Supporter();
  }


  @Test (expected = LengthUnequalException.class)
  public void extraColumn() throws LengthUnequalException{
    CsvProcessor csv3 = new CsvProcessor("test3.csv");
  }

  @Test
  public void sameCSV() throws LengthUnequalException{
    CsvProcessor test1 = new CsvProcessor("test1.csv");
    CsvProcessor test4 = new CsvProcessor("test4.csv");
    assertEquals(test1.getArrayOfSupporters(), test4.getArrayOfSupporters());
  }


  @Test
  public void getArrayOfSupporters() {
    // create the supporter in the test1.csv file
    ArrayList<Supporter> supporters = new ArrayList<>();

    supporter1.addItem("\"first_name\"", "\"James\"");
    supporter1.addItem("\"last_name\"", "\"Butt\"");
    supporter1.addItem("\"company_name\"", "\"Benton, John B Jr\"");
    supporter1.addItem("\"address\"", "\"6649 N Blue Gum St\"");
    supporter1.addItem("\"city\"", "\"New Orleans\"");
    supporter1.addItem("\"county\"", "\"Orleans\"");
    supporter1.addItem("\"state\"", "\"LA\"");
    supporter1.addItem("\"zip\"", "\"70116\"");
    supporter1.addItem("\"phone1\"", "\"504-621-8927\"");
    supporter1.addItem("\"phone2\"", "\"504-845-1427\"");
    supporter1.addItem("\"email\"", "\"jbutt@gmail.com\"");
    supporter1.addItem("\"web\"", "\"http://www.bentonjohnbjr.com\"");
    supporters.add(supporter1);
    System.out.println(supporters.size());
    System.out.println(csv1.getArrayOfSupporters().size());
    assertEquals(supporters, csv1.getArrayOfSupporters());
  }



}