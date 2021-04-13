package problem1.Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import problem1.model.CommandLineParser;

public class TodoApplication {

  private List<Todo> todoList;
  private CommandLineParser parser;
  private static final int OFFSET = 1;

  /**
   * constructor of the class
   *
   * @param parser command line parser
   */
  public TodoApplication(CommandLineParser parser) {
    this.parser = parser;
    this.todoList = new ArrayList<>();
    this.process();
  }

  /**
   * if the command line has --addtodo argument, create a new to do and add to the list.
   */
  public void addTodo() {
    if (this.parser.getAddTodo()) {
      List<String> newTodo = new ArrayList<>();
      newTodo.add(String.valueOf(this.todoList.size()));//ID
      newTodo.add(this.parser.getTodoText());//text
      newTodo.add(String.valueOf(this.parser.getCompleted()));//completed
      newTodo.add(this.parser.getDueDate());
      newTodo.add(this.parser.getPriority());
      newTodo.add(this.parser.getCategory());
      Todo td = createTodo(newTodo);
      todoList.add(td);
    }
    //options:
    //1. append one row on csv file
    //2. rewrite everything
  }

  /**
   * for each to do in the completed list, set the complete status to true
   */
  public void setComplete() {
    for (String td : this.parser.getCompleteTodos()) {
      todoList.get(Integer.parseInt(td) - OFFSET).setCompleted();
    }
    //options:
    //1. erase everything and rewrite the csv file
    //2. modify the complete status on csv file
  }

  /**
   * get todoList updated, and then overwrite everything into the file
   */
  public void writeFile() {
    this.addTodo();
    this.setComplete();
    try {
      FileWriter file = new FileWriter(this.parser.getCsvFile(), false);//false - overwrite the file
      file.write(generateHeader() + "\n");
      file.flush();
      for (Todo td : this.todoList) {
        file.write(generateOutput(td) + "\n");
        file.flush();
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  /**
   * @return the header of the file as a string
   */
  private String generateHeader() {
    return "\"id\",\"text\",\"completed\",\"due\",\"priority\",\"category\"";
  }

  /**
   * generate the output of a to do using StringBuilder
   *
   * @param td a to do object
   * @return the output as a string
   */
  private String generateOutput(Todo td) {
    StringBuilder line = new StringBuilder();
    String comma = ",";
    String doubleQuote = "\"";
    line.append(doubleQuote).append(td.getID()).append(doubleQuote).append(comma);//id
    line.append(doubleQuote).append(td.getText()).append(doubleQuote).append(comma);//text
    line.append(doubleQuote).append(td.isCompleted()).append(doubleQuote)
        .append(comma);//complete status
    line.append(doubleQuote).append(td.getDueDate() == null ? "?" : td.getDueDate())
        .append(doubleQuote).append(comma);//due date -  if it's null, append "?"
    line.append(doubleQuote).append(td.getPriority()).append(doubleQuote).append(comma);//priority
    line.append(doubleQuote).append(td.getCategory() == null ? "?" : td.getCategory())
        .append(doubleQuote);//category -  if it's null, append "?"
    return line.toString();
  }

  /**
   * Helper method that process the csv file and add each to do to the todoList
   */
  private void process() {
    // process the csv route
    try (BufferedReader inputFile = new BufferedReader(new FileReader(this.parser.getCsvFile()))
    ) {
      String dataEntry;     // a row of data
      String firstLine = inputFile.readLine();
      // String array
      String[] parameters = firstLine.split(",");
      while ((dataEntry = inputFile.readLine()) != null) {
        // regex split
        ArrayList<String> splitResults = this.regexSplit(dataEntry);
        // create To do
        Todo td = this.createTodo(splitResults);
        // add to do to Arraylist
        this.todoList.add(td);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  /**
   * Private helper function of process(). Transforms a row in the csv file to an ArrayList of
   * strings that have the data corresponding to the fields of the csv file.
   *
   * @param input a row in the csv file, a String
   * @return an ArrayList of Strings.
   */
  private ArrayList<String> regexSplit(String input) {
    ArrayList<String> results = new ArrayList<>();
    Pattern re = Pattern.compile("\"([^\"]|\n)*\"");
    Matcher m = re.matcher(input);
    // split successfully
    while (m.find()) {
      String s = input.substring(m.start(), m.end());
      results.add(s);
    }
    return results;
  }

  /**
   * Create a to do object based on the given list of info
   * for category and due date, if not given set to null
   * for complete status, if not given, set to false
   * for priority, if not given, set to 3 (least)
   *
   * @param data a list that contains the info of the to do
   * @return the to do object created
   */
  private Todo createTodo(List<String> data) {
    int ID = Integer.parseInt(data.get(0));//id
    String text = data.get(1);//text
    boolean isCompleted = data.get(2).equals("?") ? false : Boolean.parseBoolean(data.get(2));//complete
    String dueDate = data.get(3).equals("?") ? null : data.get(2);//due date
    int priority = data.get(4).equals("?") ? 3 : Integer.parseInt(data.get(4));//priority
    String category = data.get(5).equals("?") ? null : data.get(5);//category
    return new Todo(ID, text, isCompleted, dueDate, priority, category);
  }
}
