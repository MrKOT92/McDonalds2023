package ait.tr.services;

import ait.tr.models.Food;

import ait.tr.repositories.*;

import java.util.List;

public class FoodServiceImpl implements FoodService {

  private FoodRepositoryBurger foodRepositoryBurger;
  private FoodRepositoryDrink foodRepositoryDrink;
  private FoodRepositoryDessert foodRepositoryDessert;


  public FoodServiceImpl(FoodRepositoryBurger foodRepositoryBurger,
                         FoodRepositoryDrink foodRepositoryDrink,
                         FoodRepositoryDessert foodRepositoryDessert) {
    this.foodRepositoryBurger = foodRepositoryBurger;
    this.foodRepositoryDrink = foodRepositoryDrink;
    this.foodRepositoryDessert = foodRepositoryDessert;

  }

  @Override
  public Food chooseDrink(int choice) {
    List<Food> allDrinks = foodRepositoryDrink.findAll();
    if (choice > allDrinks.size()) {
      throw new IndexOutOfBoundsException("Invalid input, please try again");
    }
    return allDrinks.get(choice - 1);
  }


  @Override
  public Food chooseBurger(int choice) {
    List<Food> allBurgers = foodRepositoryBurger.findAll();
    if (choice > allBurgers.size()) {
      throw new IndexOutOfBoundsException("Invalid input, please try again");
    }

    return allBurgers.get(choice - 1);
  }

  @Override
  public Food chooseDessert(int choice) {
    List<Food> allDessert = foodRepositoryDessert.findAll();
    if (choice > allDessert.size()) {
      throw new IndexOutOfBoundsException("Invalid input, please try again");
    }
    return allDessert.get(choice - 1);

  }

}
