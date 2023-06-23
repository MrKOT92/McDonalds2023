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
  private MenuView menu;
  static Scanner scanner= new Scanner(System.in);

  public static void displayMenu() {
    System.out.println("1. Choose Burger");
    System.out.println("2. Choose Dessert");
    System.out.println("3. Choose Drink");
    System.out.println("4. Go to confirm order and payment");
    System.out.println("0. Exit");
  }

  //TODO ????
  public static void handleSubMenu(int subChoice, FoodService service,
      OrderService orderService, FoodRepositoryBurger foodRepositoryBurger, MenuView menu) {

    Order order = orderService.createOrder(); // Order{id='63694687-671e-417a-a9a8-b56598867283', number=1, orderlist=[], isPayed=false}

    while (true) {

      switch (subChoice) {
        case 1:
          try {
            menu.printMenuBurger();
            int choiceBurger = Integer.parseInt(scanner.nextLine());
            Food food = service.chooseBurger(choiceBurger);
            orderService.addFoodToOrder(order, food);
          } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue; // Retry with the same subChoice
          } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid choice. Please choose a valid option.");
            continue; // Retry with the same subChoice
          }
          break;
        case 2:
          try {
            menu.printMenuDessert();
            int choiceDessert = Integer.parseInt(scanner.nextLine());
            Food food = service.chooseDessert(choiceDessert);
            orderService.addFoodToOrder(order, food);
          } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue; // Retry with the same subChoice
          } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid choice. Please choose a valid option.");
            continue; // Retry with the same subChoice
          }
          break;
        case 3:
          try {
            menu.printMenuDrink();
            int choiceDrink = Integer.parseInt(scanner.nextLine());
            Food food = service.chooseDrink(choiceDrink);
            // Add to order
            orderService.addFoodToOrder(order, food);
          } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue; // Retry with the same subChoice
          } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid choice. Please choose a valid option.");
            continue; // Retry with the same subChoice
          }
          break;
        case 4:
          displayOrderMenu();
          try {
            int orderMenuChoice = Integer.parseInt(scanner.nextLine());
            handleOrderMenu(orderMenuChoice, orderService, order, menu);
            if (orderMenuChoice == 0) {
             return; // Return to the main menu
            }
          } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
          }
          break;
        case 0:
          System.out.println("Goodbye!");
          return; // Return to the main menu
        default:
          System.out.println("Invalid choice");
          break;
      }

      displayMenu();
      try {
        subChoice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      }catch (IndexOutOfBoundsException e) {
        System.out.println("Invalid choice. Please choose a valid option.");
      }
      }
    }

  public static void displayOrderMenu() {
    System.out.println("1. Check your order and payment");
    System.out.println("0. Back to menu");  ///
  }

  //TODO after 1. return to displayMenu
  public static void handleOrderMenu(int orderMenuChoice, OrderService orderService, Order order, MenuView menu) {
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