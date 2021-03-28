public class Letter {

  private Supporter supporter;

  public Letter(Supporter supporter) {
    this.supporter = supporter;
  }

  public String toLetter(){

    StringBuilder letter = new StringBuilder();
    letter.append(this.supporter.getFirst_name()).append(" ").append(this.supporter.getLast_name()).append("\n");
    letter.append(this.supporter.getAddress()).append("\n");
    letter.append(this.supporter.getCity()).append(", ").append(this.supporter.getState()).append(", ").append(this.supporter.getZip());
    letter.append("Dear ").append(this.supporter.getFirst_name()).append(" ").append(this.supporter.getLast_name()).append(",\n");

    letter.append("Everything in our store will be 20% off between now and the end of April! "
        + "Stock up on our logo mugs, T shirts, and water bottles to show your support and help "
        + "raise awareness. Our magnets, plushies, and picture books, also make great gifts "
        + "for the children in your life.").append("\n");

    letter.append("Remember, all proceeds go to support our work and, "
        + "if we can reach our goal of $10,000 in sales by the end of April, "
        + "an anonymous donor has pledged to match every $1 you spend. "
        + "Want to help out but don’t want to buy stuff? Visit our website to make a donation.").append("\n");

    letter.append("Sincerely,").append("\n");
    letter.append("Non-Profit Director");
    return letter.toString();
  }
}
