public class GenerateOutput {









  // Message to put into Email and Letter
  public static void main(String[] args){
    StringBuilder message = new StringBuilder();
    // message
    // put message in main
    message.append("Everything in our store will be 20% off between now and the end of April! "
        + "Stock up on our logo mugs, T shirts, and water bottles to show your support and help "
        + "raise awareness. Our magnets, plushies, and picture books, also make great gifts "
        + "for the children in your life.").append("\n");

    message.append("Remember, all proceeds go to support our work and, "
        + "if we can reach our goal of $10,000 in sales by the end of April, "
        + "an anonymous donor has pledged to match every $1 you spend. "
        + "Want to help out but don’t want to buy stuff? Visit our website to make a donation.").append("\n");

    message.append("Sincerely,").append("\n");
    message.append("Non-Profit Director");

    System.out.println(message);

  }






}
