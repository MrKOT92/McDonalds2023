package ait.tr.menus;

import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.*;
import ait.tr.services.FoodService;
import ait.tr.services.IOrderService;
import ait.tr.services.OrderService;

import java.util.Scanner;

public class SubMenu {

  private FoodRepositoryBurger foodRepositoryBurger;
  private Menu menu;
static Scanner scanner= new Scanner(System.in);

  public static void displayMenu() {
    System.out.println("1. Choose Burger");
    System.out.println("2. Choose Dessert");
    System.out.println("3. Choose Drink");
    //System.out.println("4. Go to confirm order and payment");
    System.out.println("0. Exit");
  }

//TODO ????
  public static void handleSubMenu(int subChoice, FoodService service,
                                  OrderService orderService, FoodRepositoryBurger foodRepositoryBurger, Menu menu) {

    Order order = orderService.createOrder(); //Order{id='63694687-671e-417a-a9a8-b56598867283', number=1, orderlist=[], isPayed=false}

    // Handle sub-menu choices here based on the selected subChoice
    switch (subChoice) {
      case 1:

        menu.printMenuBurger();
        int choiceBurger = scanner.nextInt();
        Food food = service.chooseBurger(choiceBurger);
        //add to order
        orderService.addFoodToOrder(order,food);
        //break;
      case 2:
        menu.printMenuDessert();
        int choiceDessert = scanner.nextInt();
        food = service.chooseDessert(choiceDessert);
        //add to order
        orderService.addFoodToOrder(order,food);
        //break;

      case 3:
        menu.printMenuDrink();
        int choiceDrink = scanner.nextInt();
        food = service.chooseDrink(choiceDrink);
        //add to order
        orderService.addFoodToOrder(order,food);
        //break
      case 4:
        displayOrderMenu();
        int orderMenuChoice = scanner.nextInt();
        handleOrderMenu(orderMenuChoice, orderService, order, menu);
        // Handle order menu choices
        //TODO ??? return displayOrderMenu
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
    System.out.println("1. Check your order and payment");
    System.out.println("0. Back to menu");  ///
  }

  //TODO after 1. return to displayMenu
  public static void handleOrderMenu(int orderMenuChoice, OrderService orderService, Order order, Menu menu) {
    switch (orderMenuChoice) {
      case 1:
        //TODO Logic for checking the order
        menu.printOrder(order);
        boolean confirmation = orderService.confirmOrder(order);
         if (confirmation){
           menu.finalMessage(order);
         }
         else {
           System.out.println("Sorry you order not payed");
         }
        break;

        //TODO case 0  = back to displayMenu()

      case 0:
        //displayMenu();

        // Logic for going back to the main menu
        break;
      default:
        System.out.println("Invalid choice");
        break;
    }
  }

}