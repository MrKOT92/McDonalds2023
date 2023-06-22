package ait.tr.services;

import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.FoodRepositoryBurger;
import ait.tr.repositories.FoodRepositoryDessert;
import ait.tr.repositories.FoodRepositoryDrink;

public interface IFoodService {
  Food chooseDrink(int choice);
  Food chooseBurger(int choice);
  Food chooseDessert(int choice);


}



