package problem1.controller;

public class Todo {

  private final int ID;
  private final String text;
  private boolean isCompleted;//default:false
  private final String dueDate;
  private final int priority;//default 4
  private final String category;


  /**
   * @param ID          id of the to do
   * @param text        content of to do
   * @param isCompleted whether the to do is completed or not
   * @param dueDate     due date of the to do
   * @param priority    priority of the to do
   * @param category    category of the to do
   */
  public Todo(int ID, String text, boolean isCompleted, String dueDate, int priority,
      String category) {
    this.ID = ID;
    this.text = text;
    this.isCompleted = isCompleted;
    this.dueDate = dueDate;
    this.priority = priority;
    this.category = category;
  }

  /**
   * @return id of the to do
   */
  public int getID() {
    return this.ID;
  }

  /**
   * @return content of to do
   */
  public String getText() {
    return this.text;
  }

  /**
   * @return whether the to do is completed or not
   */
  public boolean isCompleted() {
    return this.isCompleted;
  }

  /**
   * @return due date of the to do
   */
  public String getDueDate() {
    return this.dueDate;
  }

  /**
   * @return priority of the to do
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * @return category of the to do
   */
  public String getCategory() {
    return this.category;
  }

  /**
   * set the complete status of to do to true
   */
  public void setCompleted() {
    this.isCompleted = true;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Todo{");
    sb.append("ID=").append(ID);
    sb.append(", text='").append(text).append('\'');
    sb.append(", isCompleted=").append(isCompleted);
    sb.append(", dueDate='").append(dueDate).append('\'');
    sb.append(", priority=").append(priority);
    sb.append(", category='").append(category).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
