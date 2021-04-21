package problem1.view;

import problem1.controller.TodoApplication;
import problem1.controller.CommandLineParser;
import problem1.controller.InvalidArgumentException;
import problem1.controller.Options;


public class Main {

  private static Options options = new Options(); // singleton pattern

  /**
   * The main function to carry out the whole process
   *
   * @param args - the command line arguments
   * @throws InvalidArgumentException - throw exception if argument is invalid
   */
  public static void main(String[] args) throws InvalidArgumentException {
    try {
      CommandLineParser parser = new CommandLineParser(options, args);
      TodoApplication tda = new TodoApplication(parser);
      tda.writeFile();
      Display view = new Display(tda);
      view.display();
    } catch (InvalidArgumentException e) {
      System.out.print(e.getMessage());
    }
  }
}
