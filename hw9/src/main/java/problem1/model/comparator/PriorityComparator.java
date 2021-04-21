package problem1.model.comparator;
import java.util.Comparator;
import problem1.model.Todo;

/**
 * Comparator of two Todo objects using the priority
 */
public class PriorityComparator implements Comparator<Todo>{

  /**
   * Compares the priority of two Todo objects.
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
    // priority in todo object is int
    Integer td1Priority = td1.getPriority();
    Integer td2Priority = td2.getPriority();
    return td1Priority.compareTo(td2Priority);

  }




}
