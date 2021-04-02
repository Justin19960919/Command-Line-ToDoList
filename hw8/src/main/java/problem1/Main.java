package problem1;

public class Main {

  // Testing for Csv processor
  public static void main(String[] args) throws LengthUnequalException, InvalidArgumentException {
    CommandLineParser parser = new CommandLineParser(args);
    CsvProcessor csv = new CsvProcessor("nonprofit-supporters.csv");
    AbstractTemplate at = new Letter(parser.getTemplate(), csv.getArrayOfSupporters(), parser.getOutput());
    at.writeOutput();
  }





}
