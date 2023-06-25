package ait.tr.models;

public class Burger extends Food{

  private String cutletType;
  private String sauce;

  public Burger(String title, double price, double weight, boolean isVegan, boolean isForKids,
      int calories, String cutletType, String sauce) {
    super(title, price, weight, isVegan, isForKids, calories);
    this.cutletType = cutletType;
    this.sauce = sauce;

  }


}