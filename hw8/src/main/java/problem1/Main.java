package problem1;

public class Main {

  /**
   * The main function to carry out the whole process
   *
   * @param args - the command line arguments
   * @throws LengthUnequalException - throw exception if length is unequal
   * @throws InvalidArgumentException - throw exception if argument is invalid
   */
  public static void main(String[] args) throws LengthUnequalException, InvalidArgumentException {
    try {
      Options options = new Options();
      CommandLineParser parser = new CommandLineParser(options, args);
      CsvProcessor csv = new CsvProcessor(parser.getCsv());
      if (parser.getLetterTemplate() != null) {
        AbstractTemplate letters = new Letter(parser.getLetterTemplate(), csv.getArrayOfSupporters(), parser.getOutput());
        letters.writeOutput();
      }
      if (parser.getEmailTemplate() != null) {
        AbstractTemplate emails = new Email(parser.getEmailTemplate(), csv.getArrayOfSupporters(), parser.getOutput());
        emails.writeOutput();
      }
    } catch (InvalidArgumentException e) {
      System.out.print(e.getMessage());
    }

  }





}
