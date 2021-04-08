package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest {
  private CommandLineParser parser;
  private String[] args;
  private CommandLineParser parser1;
  private Options options;

  @Before
  public void setUp() throws Exception {
    args = new String[]{
        "--email", "--email-template", "email-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    options = new Options();
    parser = new CommandLineParser(options, args);
    parser1 = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void noOutputOrCsv() throws InvalidArgumentException {
    args = new String[]{
        "--email", "--email-template", "email-template.txt", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
  }

  @Test
  public void getLetterTemplate() throws InvalidArgumentException {
    args = new String[]{
        "--letter", "--letter-template", "letter-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
    assertEquals("letter-template.txt", parser.getLetterTemplate());
  }

  @Test
  public void getOutput() {
    assertEquals("output/", parser.getOutput());
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidOutput() throws InvalidArgumentException {
    args = new String[] {
        "--email", "--email-template", "email-template.txt", "--output-dir", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
  }
  @Test
  public void getEmailTemplate() {
    assertEquals("email-template.txt", parser.getEmailTemplate());
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidEmail() throws InvalidArgumentException {
    args = new String[]{
        "--email", "email-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidEmail2() throws InvalidArgumentException {
    args = new String[]{
        "--email-template", "email-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidEmail3() throws InvalidArgumentException {
    args = new String[]{
        "--email", "--email-template", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidLetter() throws InvalidArgumentException {
    args = new String[]{
        "--letter", "letter-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidLetter2() throws InvalidArgumentException {
    args = new String[]{
        "--letter-template", "letter-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidLetter3() throws InvalidArgumentException {
    args = new String[]{
        "--letter", "--letter-template", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(options, args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidCsv() throws InvalidArgumentException {
    args = new String[]{
        "--email", "--email-template", "email-template.txt", "--output-dir", "output/", "--csv-file"};
    parser = new CommandLineParser(options, args);
  }

  @Test
  public void getCsv() {
    assertEquals("data.csv", parser.getCsv());
  }

  @Test
  public void testEquals() {
    assertTrue(parser.equals(parser1));
  }

  @Test
  public void testEquals2() {
    assertTrue(parser.equals(parser));
  }


  @Test
  public void testEqualsNull() {
    assertFalse(parser.equals(null));
  }

  @Test
  public void testNotEqual() {
    assertFalse(parser.equals(args));
  }
  @Test
  public void testHashCode() {
    assertEquals(parser.hashCode(), parser1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "CommandLineParser{options=Options{options=[Option{cmd='--email', takeValue=false}, Option{cmd='--email-template', takeValue=true}, Option{cmd='--letter', takeValue=false}, Option{cmd='--letter-template', takeValue=true}, Option{cmd='--output-dir', takeValue=true}, Option{cmd='--csv-file', takeValue=true}]}, cmdArgs=[], arguments={--email-template=email-template.txt, --csv-file=data.csv, --email=null, --output-dir=output/}}";
    assertEquals(s, parser.toString());
  }
}