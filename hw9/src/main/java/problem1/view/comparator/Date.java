package problem1.view.comparator;

import java.util.Objects;

/**
 * A Date class that represents a due date in the todo list
 */
public class Date implements Comparable<Date>{

  private Integer month;
  private Integer day;
  private Integer year;

  /**
   * The constructor for the Date class.
   * @param month month of Date, a String
   * @param day day of Date, a String
   * @param year a String
   */
  public Date(String month, String day, String year){
    this.month = Integer.parseInt(month);
    this.day = Integer.parseInt(day);
    this.year = Integer.parseInt(year);
  }

  /**
   * Getter of month of date
   * @return the month, an Integer
   */
  public Integer getMonth() {
    return month;
  }

  /**
   * Getter of day of date
   * @return the day, an Integer
   */
  public Integer getDay() {
    return day;
  }

  /**
   * Getter of the year of date
   * @return the year, an Integer
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Equals function
   * @param o another object
   * @return a boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Date date1 = (Date) o;
    return Objects.equals(getMonth(), date1.getMonth()) && Objects
        .equals(getDay(), date1.getDay()) && Objects.equals(getYear(), date1.getYear());
  }

  /**
   * Hashcode function
   * @return an int
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMonth(), getDay(), getYear());
  }

  /**
   * Compares two dates according to the month, date, and year fields.
   * If all are equal return 0
   * If date is less than other, return -1
   * If month is less than other, return -1
   * If year is less than other, return -1
   * else, return 1
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it from being compared to
   *                              this object.
   */
  @Override
  public int compareTo(Date otherDate) {
    if(this.equals(otherDate)){
      return 0;   // two dates have exactly the same fields
    }
    if(this.day.compareTo(otherDate.getDay()) < 0){
      return -1;
    }
    if(this.day.equals(otherDate.getDay()) &&
        this.month.compareTo(otherDate.getMonth()) < 0){
      return -1;
    }
    if(this.day.equals(otherDate.getDay()) &&
        this.month.equals(otherDate.getMonth()) &&
        this.year.compareTo(otherDate.getYear()) < 0
        ){
      return -1;
    }
    return 1;
  }
}
