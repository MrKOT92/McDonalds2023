package ait.tr.services;

import ait.tr.models.Food;

import ait.tr.models.Order;
import ait.tr.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodService implements IFoodService{

  private FoodRepositoryBurger foodRepositoryBurger;
  private FoodRepositoryDrink foodRepositoryDrink;
  private FoodRepositoryDessert foodRepositoryDessert;


  public FoodService(FoodRepositoryBurger foodRepositoryBurger,
                     FoodRepositoryDrink foodRepositoryDrink,
                     FoodRepositoryDessert foodRepositoryDessert){
    this.foodRepositoryBurger = foodRepositoryBurger;
    this.foodRepositoryDrink = foodRepositoryDrink;
    this.foodRepositoryDessert = foodRepositoryDessert;

  }

  Scanner scanner = new Scanner(System.in);

  //        case 4 -> {service.chooseDrink(drinkRepository);
  @Override
  public Food chooseDrink(){
//    List<Food> allDrinks = foodRepositoryDrink.findAll();
//    System.out.println("---- Menu of Drinks ----");
//    for (Food drink : allDrinks) {
//      System.out.println(allDrinks.indexOf(drink)+1 + ". " +
//              drink.getTitle()+ " " + drink.getPrice());
//    }
//    int choice = scanner.nextInt();
//    System.out.println();
//    //addFoodToOrder(createOrder(), allDrinks.get(choice-1));
//    return allDrinks.get(choice);
    return null;
  }

  //case 2 -> {service.chooseBurger(burgerRepository);
  @Override
  public Food chooseBurger(){
//    List<Food> allBurgers = foodRepositoryBurger.findAll();
//    System.out.println("---- Menu of Burgers ----");
//    for (Food burger : allBurgers) {
//      System.out.println(allBurgers.indexOf(burger)+1 + ". " +
//              burger.getTitle() + " " + burger.getPrice());
//    }
//    int choice = scanner.nextInt();
//    System.out.println();
//    //addFoodToOrder(createOrder(), allBurgers.get(choice-1));
//    return allBurgers.get(choice);
    return null;
  }

  //        case 3 -> {service.chooseDessert(dessertRepository);
  @Override
  public Food chooseDessert(){
    List<Food> allDessert = foodRepositoryDessert.findAll();
    printDessertMenu(allDessert);
    int choice = scanner.nextInt();
    System.out.println();
    return allDessert.get(choice-1);

  }
  private void printDessertMenu(List<Food> allDessert){
    System.out.println("---- Menu Dessert ----");
    for (Food dessert : allDessert) {
      System.out.println(allDessert.indexOf(dessert)+1 + ". " +
              dessert.getTitle() + " " + dessert.getPrice());
    }
  }

  @Override
  public void finalMessage(){};


}

//  OrderRepository orderRepository = new OrderRepository("orders.txt");
//  FoodRepositoryBurger burgerRepository = new FoodRepositoryBurger("burger.txt");
//  FoodRepositoryDessert dessertRepository = new FoodRepositoryDessert("dessert.txt");
//  FoodRepositoryDrink drinkRepository = new FoodRepositoryDrink("drink.txt");
//
//  FoodService service = new FoodService(burgerRepository, drinkRepository,
//          dessertRepository, orderRepository);


//case 2 -> {service.chooseBurger(burgerRepository);
//        }
//        case 3 -> {service.chooseDessert(dessertRepository);
//        }
//        case 4 -> {service.chooseDrink(drinkRepository);