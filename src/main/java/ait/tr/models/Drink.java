package ait.tr.models;

public class Drink extends Food{


 private boolean isAlcohol;

  public Drink(String title, double price, double weight, boolean isVegan, boolean isForKids,
      int calories, boolean isAlcohol) {
    super(title, price, weight, isVegan, isForKids, calories);
    this.isAlcohol = isAlcohol;
  }

    public boolean isAlcohol() {
        return isAlcohol;
    }

}
