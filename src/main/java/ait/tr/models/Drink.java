package ait.tr.models;

public class Drink extends Food{

 private double size ;
 private boolean isAlcoholic;

  public Drink(String title, double size, double price, double weight, boolean isVegan, boolean isForKids,
      int calories) {
    super(title, price, weight, isVegan, isForKids, calories);
    this.size = size;
  }
}
