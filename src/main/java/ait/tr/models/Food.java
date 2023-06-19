package ait.tr.models;

public class Food {

  private String title;
  private double price;
  private double weight;
  private boolean isVegan;
  private boolean isForKids;
  private int calories;

  public Food(String title, double price, double weight, boolean isVegan, boolean isForKids,
      int calories) {
    this.title = title;
    this.price = price;
    this.weight = weight;
    this.isVegan = isVegan;
    this.isForKids = isForKids;
    this.calories = calories;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public boolean isVegan() {
    return isVegan;
  }

  public void setVegan(boolean vegan) {
    isVegan = vegan;
  }

  public boolean isForKids() {
    return isForKids;
  }

  public void setForKids(boolean forKids) {
    isForKids = forKids;
  }

  public int getCalories() {
    return calories;
  }

  public void setCalories(int calories) {
    this.calories = calories;
  }

  @Override
  public String toString() {
    return "Food{" +
        "title='" + title + '\'' +
        ", price=" + price +
        ", weight=" + weight +
        ", isVegan=" + isVegan +
        ", isForKids=" + isForKids +
        ", calories=" + calories +
        '}';
  }
}
