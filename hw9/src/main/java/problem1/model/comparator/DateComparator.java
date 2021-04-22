package problem1.model.comparator;
import java.util.Comparator;
import problem1.model.Todo;

/**
 * Compares two Todo objects based on Date
 */
public class DateComparator implements Comparator<Todo>{
  protected static final int LESS = -1;
  protected static final int EQUAL = 0;
  protected static final int GREATER = 1;
  private static final int MONTH_INDEX = 0;
  private static final int DAY_INDEX = 1;
  private static final int YEAR_INDEX = 2;


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

    // if td1 is null, then it should come after td2
    if (td1.getDueDate() == null && td2.getDueDate()!= null) {
      return GREATER;
    }
    // if td2 is null, then it should come after td1
    if (td1.getDueDate() != null && td2.getDueDate() == null) {
      return LESS;
    }
    // if both null, they are equal
    if (td1.getDueDate() == null && td2.getDueDate() == null) {
      return EQUAL;
    }
    // else, make into date object
    String td1Due = td1.getDueDate();
    String td2Due = td2.getDueDate();
    String[] td1DateRes = td1Due.split("/");
    String[] td2DateRes = td2Due.split("/");

    // Not caring about invalid formatting yet here
    // if both not null ,we create a date object, and let it compare themselves
    Date td1Date = new Date(td1DateRes[MONTH_INDEX],td1DateRes[DAY_INDEX],td1DateRes[YEAR_INDEX]);
    Date td2Date = new Date(td2DateRes[MONTH_INDEX],td2DateRes[DAY_INDEX],td2DateRes[YEAR_INDEX]);

    return td1Date.compareTo(td2Date);
  }





}
