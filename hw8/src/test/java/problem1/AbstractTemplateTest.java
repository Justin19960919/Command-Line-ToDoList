package problem1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class AbstractTemplateTest {

  List<Supporter> supporters;
  Supporter s1;
  Letter l;
  Email e;

  @Before
  public void setUp() throws Exception {
    supporters = new ArrayList<>();
    s1 = new Supporter();
    s1.addItem("\"first_name\"", "ZZZ"); //double quotation mark!!
    s1.addItem("\"last_name\"", "YYY");
    supporters.add(s1);
    l = new Letter("letter-template-test.txt", supporters, "output/");
    e = new Email("email-template-test.txt", supporters, "output/");
  }

  @Test
  public void testGetFileName() {
    assertEquals("LetterToZZZ.txt", l.getFileName("ZZZ"));
    assertEquals("EmailToYYY.txt", e.getFileName("YYY"));
  }

  @Test
  public void testWriteOutput() {
    e.writeOutput();
    StringBuilder sb = new StringBuilder();
    BufferedReader inputFile = null;
    try {
      inputFile = new BufferedReader(new FileReader(e.outputDir + "EmailToZZZYYY.txt"));

      String line;
      while ((line = inputFile.readLine()) != null) {

        sb.append(line);
        sb.append("\n");
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
    System.out.println(sb.toString());
    assertEquals("ZZZ YYY for testing email\n", sb.toString());

  }

  @Test
  public void testGenerateOutput() {
    String letter = "ZZZ YYY for testing letter\n";
    String email = "ZZZ YYY for testing email\n";
    assertEquals(letter, l.generateOutput(s1));
    assertEquals(email, e.generateOutput(s1));
  }

  @Test
  public void testGetDir() {
    assertEquals("output/", e.getDir());
    assertEquals("output/", l.getDir());
  }

  @Test
  public void testTestEquals() {
    Letter ll = new Letter("letter-template-test.txt", supporters, "output/");
    assertEquals(ll, l);
    Email ee = new Email("email-template-test.txt", supporters, "output/");
    assertEquals(ee, e);
  }

  @Test
  public void testTestHashCode() {
    Letter ll = new Letter("letter-template-test.txt", supporters, "output/");
    assertEquals(ll.hashCode(), l.hashCode());
    Email ee = new Email("email-template-test.txt", supporters, "output/");
    assertEquals(ee.hashCode(), e.hashCode());
    Letter lll = new Letter("letter-template-test.txt", supporters, "dir/");
    assertNotEquals(lll, l);
    assertNotEquals(e, l);
    assertEquals(l,l);
  }

  @Test
  public void testTestToString() {
    assertEquals("AbstractTemplate{fileName='email-template-test.txt', supporters=[problem1.Supporter{supporterInformation=\"first_name\":ZZZ;\"last_name\":YYY;}], outputDir='output/'}", e.toString());
  }
}