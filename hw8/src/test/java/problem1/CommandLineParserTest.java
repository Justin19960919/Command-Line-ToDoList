package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest {
  private CommandLineParser parser;
  private String[] args;
  private CommandLineParser parser1;

  @Before
  public void setUp() throws Exception {
    args = new String[]{
        "--email", "--email-template", "email-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(args);
    parser1 = new CommandLineParser(args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void noOutputOrCsv() throws InvalidArgumentException {
    args = new String[]{
        "--email", "--email-template", "email-template.txt", "--csv-file", "data.csv"};
    parser = new CommandLineParser(args);
  }

  @Test
  public void getLetterTemplate() throws InvalidArgumentException {
    args = new String[]{
        "--letter", "--letter-template", "letter-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(args);
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
    parser = new CommandLineParser(args);
  }
  @Test
  public void getEmailTemplate() {
    assertEquals("email-template.txt", parser.getEmailTemplate());
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidEmail() throws InvalidArgumentException {
    args = new String[]{
        "--email", "email-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidEmail2() throws InvalidArgumentException {
    args = new String[]{
        "--email-template", "email-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidEmail3() throws InvalidArgumentException {
    args = new String[]{
        "--email", "--email-template", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidLetter() throws InvalidArgumentException {
    args = new String[]{
        "--letter", "letter-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidLetter2() throws InvalidArgumentException {
    args = new String[]{
        "--letter-template", "letter-template.txt", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidLetter3() throws InvalidArgumentException {
    args = new String[]{
        "--letter", "--letter-template", "--output-dir", "output/", "--csv-file", "data.csv"};
    parser = new CommandLineParser(args);
  }

  @Test(expected = InvalidArgumentException.class)
  public void invalidCsv() throws InvalidArgumentException {
    args = new String[]{
        "--email", "--email-template", "email-template.txt", "--output-dir", "output/", "--csv-file"};
    parser = new CommandLineParser(args);
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
    String s = "CommandLineParser{output='output/', csv='data.csv', emailTemplate='email-template.txt', letterTemplate='null'}";
    assertEquals(s, parser.toString());
  }
}