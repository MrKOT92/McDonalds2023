package ait.tr.menus;

import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.*;
import ait.tr.services.FoodServiceImpl;
import ait.tr.services.OrderServiceImpl;

import java.util.Scanner;

public class SubMenu {

  private MenuView menu;
  public static Scanner scanner = new Scanner(System.in);

  public static void displayMenu() {
    System.out.println("1. Choose a Burger");
    System.out.println("2. Choose a Dessert");
    System.out.println("3. Choose a Drink");
    System.out.println("4. Go to confirmation of order and payment");
    System.out.println("0. Exit");
  }

  public static void chooseFromMenu(int subChoice, FoodServiceImpl service,
      OrderServiceImpl orderServiceImpl, FoodRepositoryBurger foodRepositoryBurger, MenuView menu) {
    Order order = orderServiceImpl.createOrder();
    while (true) {
      try {
        switch (subChoice) {
          case 1:
            menu.printMenuBurger();
            int choiceBurger = Integer.parseInt(scanner.nextLine());
            Food burger = service.chooseBurger(choiceBurger);
            orderServiceImpl.addFoodToOrder(order, burger);
            break;
          case 2:
            menu.printMenuDessert();
            int choiceDessert = Integer.parseInt(scanner.nextLine());
            Food dessert = service.chooseDessert(choiceDessert);
            orderServiceImpl.addFoodToOrder(order, dessert);
            break;
          case 3:
            menu.printMenuDrink();
            int choiceDrink = Integer.parseInt(scanner.nextLine());
            Food drink = service.chooseDrink(choiceDrink);
            orderServiceImpl.addFoodToOrder(order, drink);
            break;
          case 4:
            int orderMenuChoice = displayChosenPositions();
            if (orderMenuChoice == 1) {
              confirmChosenPositions(orderMenuChoice, orderServiceImpl, order, menu);
            } else if (orderMenuChoice == 0) {
              break;
            } else {
              System.out.println("Invalid input. Please enter a valid option.");
              chooseFromMenu(subChoice, service, orderServiceImpl, foodRepositoryBurger, menu);
            }
            break;
          case 0:
            System.out.println("Goodbye");
            System.exit(0);
          default:
            System.out.println("Invalid choice");
            break;
        }

        displayMenu();
        subChoice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Invalid choice. Please choose a valid option.");
      }
    }
  }

  public static int displayChosenPositions() {
    boolean validChoice = false;
    int choice = 0;

    while (!validChoice) {
      System.out.println("1. Please check your order and payment");
      System.out.println("0. Back to menu");
      try {
        choice = Integer.parseInt(scanner.nextLine());
        if (choice == 0 || choice == 1) {
          validChoice = true;
        } else {
          System.out.println("Invalid input. Please enter a valid option.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    }

    return choice;
  }

  public static int confirmChosenPositions(int chosenPositions, OrderServiceImpl orderServiceImpl, Order order, MenuView menu) {
    boolean validChoice = false;

    while (!validChoice) {
      switch (chosenPositions) {
        case 1:
          menu.printOrder(order);
          System.out.printf("Sum: %.2f euro%n", orderServiceImpl.getTotalSumOrder(order));
          System.out.println("Confirm and pay please (Y/N):");
          String choice = scanner.nextLine();

          try {
            if (choice.equalsIgnoreCase("Y")) {
              boolean confirmation = orderServiceImpl.confirmOrder(order, choice);
              if (confirmation) {
                menu.finalMessage(order);
                System.out.println("Goodbye, we'll be glad to see you again!!!");
                System.exit(0);
              } else {
                System.out.println("Sorry, your order was not paid, try again...");
                validChoice = true;
              }
            } else if (choice.equalsIgnoreCase("N")) {
              System.out.println("An error occurred during payment, please choose again...");
              validChoice = true;
              return 0;
            } else {
              System.out.println("Invalid choice. Please enter Y or N.");
            }
          } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
            validChoice = true;
          }

          break;
        case 0:
          validChoice = true;
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
    }
    return chosenPositions;
  }
}
