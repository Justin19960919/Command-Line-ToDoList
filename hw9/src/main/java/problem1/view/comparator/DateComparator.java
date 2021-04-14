package problem1.view.comparator;
import java.util.Comparator;
import problem1.controller.Todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Compares two Todo objects based on Date
 */
public class DateComparator implements Comparator<Todo>{


  /**
   * Compares the due dates of two Todo objects
   * @param td1 the first object to be compared.
   * @param td2 the second object to be compared.
   * @return a negative integer, zero, or a positive integer as the first argument is less than,
   * equal to, or greater than the second.
   * @throws NullPointerException if an argument is null and this comparator does not permit null
   *                              arguments
   * @throws ClassCastException   if the arguments' types prevent them from being compared by this
   *                              comparator.
   */
  @Override
  public int compare(Todo td1, Todo td2) {
//    System.out.println(td1.toString());
//    System.out.println(td2.toString());



    // if td1 is null, then it should come after td2
    if (td1.getDueDate() == null && td2.getDueDate()!= null) {
      return 1;
    }
    // if td2 is null, then it should come after td1
    if (td1.getDueDate() != null && td2.getDueDate() == null) {
      return -1;
    }
    // if both null, they are equal
    if (td1.getDueDate() == null && td2.getDueDate() == null) {
      return 0;
    }
    // else, make into date object
    String td1Due = td1.getDueDate();
    String td2Due = td2.getDueDate();
    String[] td1DateRes = td1Due.split("/");
    String[] td2DateRes = td1Due.split("/");

    // Not caring about invalid formatting yet here
    // if both not null ,we create a date object, and let it compare themselves
    Date td1Date = new Date(td1DateRes[0],td1DateRes[1],td1DateRes[2]);
    Date td2Date = new Date(td2DateRes[0],td2DateRes[1],td2DateRes[2]);

    return td1Date.compareTo(td2Date);


  }





}
