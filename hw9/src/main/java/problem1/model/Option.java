package problem1.model;

import java.util.Objects;

/**
 * Represent a commandline argument that the program can process
 */
public class Option {
  private String cmd;
  private Boolean takeValue;

  /**
   * Construct a new option object with given parameters.
   * @param cmd - the name of the command
   * @param takeValue - if this command takes value
   */
  public Option(String cmd, Boolean takeValue) {
    this.cmd = cmd;
    this.takeValue = takeValue;
  }

  /**
   * Get the cmd of the Option
   *
   * @return - the cmd of the Option
   */
  public String getCmd() {
    return this.cmd;
  }

  /**
   * Get the value of the Option
   *
   * @return - the value of the Option
   */
  public Boolean getTakeValue() {
    return this.takeValue;
  }

  /**
   * Compare this object with the given object.
   *
   * @param o - the given object to compare with
   * @return - true if this is equal to the given object
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Option option = (Option) o;
    return Objects.equals(this.cmd, option.cmd) && Objects
        .equals(this.takeValue, option.takeValue);
  }

  /**
   * Calculate the hashcode of this object.
   *
   * @return - the hash code of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.cmd, this.takeValue);
  }

  /**
   * Get string representation of this object.
   *
   * @return - string representation of this object.
   */
  @Override
  public String toString() {
    return "Option{" +
        "cmd='" + this.cmd + '\'' +
        ", takeValue=" + this.takeValue +
        '}';
  }
}