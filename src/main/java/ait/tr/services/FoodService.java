package ait.tr.services;

import ait.tr.models.Food;

import ait.tr.repositories.FoodRepository;
import ait.tr.repositories.FoodRepositoryDrink;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodService implements IFoodService{
  Scanner scanner = new Scanner(System.in);
  public void createOrder(){
    List<Food> order = new ArrayList<Food>();
  };
  public void addFoodToOrder(){};

  public void showOrder(){};

  public void confirmOrderAndPay(){};

  public void totalSumOrder() {
    List<Food> clientsOrder = new ArrayList<>();
    double totalSum = 0;
    if (clientsOrder.isEmpty()){
      System.out.println("Mistake");
    } else {
      for (Food food : clientsOrder) {
        totalSum += food.getPrice();
      }
    }
  }
  @Override
  public void finalMessage(){};

  public Food chooseDrink(FoodRepository drinkRepository){
    List<Food> allDrinks = drinkRepository.findAll();
    System.out.println("---- List of Drinks ----");
    for (Food drink : allDrinks) {
      System.out.println(allDrinks.indexOf(drink));
      System.out.println("Title: " + drink.getTitle());
      System.out.println("Price: " + drink.getPrice());
      System.out.println();
    }
    int choice = scanner.nextInt();
    return allDrinks.get(choice);
  };
}
