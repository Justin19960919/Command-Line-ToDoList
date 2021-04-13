package problem1.view.comparator;

import java.util.Objects;

public class Date implements Comparable<Date>{

  private Integer month;
  private Integer date;
  private Integer year;

  public Date(String month, String date, String year){
    this.month = Integer.parseInt(month);
    this.date = Integer.parseInt(date);
    this.year = Integer.parseInt(year);
  }

  public Integer getMonth() {
    return month;
  }

  public Integer getDate() {
    return date;
  }

  public Integer getYear() {
    return year;
  }

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
        .equals(getDate(), date1.getDate()) && Objects.equals(getYear(), date1.getYear());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMonth(), getDate(), getYear());
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
    if(this.date.compareTo(otherDate.getDate()) < 0){
      return -1;
    }
    if(this.date.equals(otherDate.getDate()) &&
        this.month.compareTo(otherDate.getMonth()) < 0){
      return -1;
    }
    if(this.date.equals(otherDate.getDate()) &&
        this.month.equals(otherDate.getMonth()) &&
        this.year.compareTo(otherDate.getYear()) < 0
        ){
      return -1;
    }
    return 1;
  }
}
