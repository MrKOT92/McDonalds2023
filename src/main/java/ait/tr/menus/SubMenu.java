package ait.tr.menus;

import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.*;
import ait.tr.services.FoodService;
import ait.tr.services.IOrderService;
import ait.tr.services.OrderService;

import java.util.Scanner;

public class SubMenu {
static Scanner scanner= new Scanner(System.in);

  public static void handleSubMenu(int subChoice, FoodService service, FoodRepositoryDrink drinkRepository,
                                   FoodRepositoryBurger burgerRepository,
                                   FoodRepositoryDessert dessertRepository, OrderService orderService) {

    Order order = orderService.createOrder();
    //String idNumber = order.getId();

    // Handle sub-menu choices here based on the selected subChoice
    switch (subChoice) {
      case 1:
        Food food = service.chooseBurger();
        //add to order
        orderService.addFoodToOrder(order,food);
        break;
      case 2:
        food = service.chooseDessert();
        //add to order
        orderService.addFoodToOrder(order,food);
        break;
      case 3:
        food = service.chooseDrink();
        //add to order
        orderService.addFoodToOrder(order,food);
        break;
      case 4:
        displayOrderMenu();
        int orderMenuChoice = scanner.nextInt();
        handleOrderMenu(orderMenuChoice);
        // Handle order menu choices

        break;
      case 0:
        System.out.println("GoodBye");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice");
        break;
    }
  }

  public static void displayOrderMenu() {
    System.out.println("1. Check your order");
    System.out.println("2. Payment");
    System.out.println("0. Back to menu");
  }

  public static void handleOrderMenu(int orderMenuChoice, FoodService service, FoodRepositoryDrink drinkRepository,
                                     FoodRepositoryBurger burgerRepository,
                                     FoodRepositoryDessert dessertRepository, OrderService orderService) {
    switch (orderMenuChoice) {
      case 1:
        //TODO Logic for checking the order

        //boolean confirmation = orderService.confirmOrder(order);

        break;
      case 2:
        // Logic for payment

        break;
      case 0:
        // Logic for going back to the main menu
        break;
      default:
        System.out.println("Invalid choice");
        break;
    }
  }
  public static void displayMenu() {
    System.out.println("1. Choose Burger");
    System.out.println("2. Choose Dessert");
    System.out.println("3. Choose Drink");
    System.out.println("4. Next");
    System.out.println("0. Exit");
  }
}