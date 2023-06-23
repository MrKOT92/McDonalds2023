package ait.tr.menus;

import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.*;
import ait.tr.services.FoodServiceImpl;
import ait.tr.services.OrderServiceImpl;

import java.util.Scanner;

public class SubMenu {

  private FoodRepositoryBurger foodRepositoryBurger;
  private MenuView menu;
  static Scanner scanner= new Scanner(System.in);

  public static void displayMenu() {
    System.out.println("1. Choose a burger");
    System.out.println("2. Choose a dessert");
    System.out.println("3. Choose a drink");
    System.out.println("4. Go to order confirmation and payment");
    System.out.println("0. Exit");
  }

  //TODO ????
  public static void chooseFromMenu(int subChoice, FoodServiceImpl service,
                                    OrderServiceImpl orderService, FoodRepositoryBurger foodRepositoryBurger, MenuView menu) {


    Order order = orderService.createOrder(); //Order{id='63694687-671e-417a-a9a8-b56598867283', number=1, orderlist=[], isPayed=false}


    while (true) {
      // Handle sub-menu choices here based on the selected subChoice
      switch (subChoice) {
        case 1:
          try {
            menu.printMenuBurger();
            int choiceOfBurger = scanner.nextInt();
            Food food = service.chooseBurger(choiceOfBurger);
            orderService.addFoodToOrder(order, food);
          } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue; // Retry with the same subChoice
          } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect input. Please select the correct option.");
            continue; // Retry with the same subChoice
          }
          break;
        case 2:
          try{
            menu.printMenuDessert();
            int choiceOfDessert = scanner.nextInt();
            Food food = service.chooseDessert(choiceOfDessert);
            orderService.addFoodToOrder(order, food);}
          catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue; // Retry with the same subChoice
          } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect input. Please select the correct option.");
            continue; // Retry with the same subChoice
          }
          break;

        case 3:
          try {
            menu.printMenuDrink();
            int choiceOfDrink = scanner.nextInt();
            Food food = service.chooseDrink(choiceOfDrink);
            //add to order
            orderService.addFoodToOrder(order, food);
          }
          catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue; // Retry with the same subChoice
          } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect input. Please select the correct option.");
            continue; // Retry with the same subChoice
          }
          break;


        case 4:
          displayChosenPositions();
          try {


            int chosenPositions = Integer.parseInt(scanner.nextLine());
            confirmChosenPositions(chosenPositions, orderService, order, menu);
          } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
          }
          break;

        case 0:
          System.out.println("Goodbye!");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid input");
          break;
      }


      displayMenu();
      try {
        subChoice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    }
  }
  public static void displayChosenPositions() {
    System.out.println("1. Please check your order and payment");
    System.out.println("0. Back to menu");  ///
  }

  //TODO after 1. return to displayMenu
  public static void confirmChosenPositions(int chosenPositions, OrderServiceImpl orderService, Order order, MenuView menu) {
    switch (chosenPositions) {
      case 1:
        //TODO Logic for checking the order
        menu.printOrder(order);
        boolean confirmation = orderService.confirmOrder(order);
        if (confirmation){
          menu.finalMessage(order);
        }
        else {
          System.out.println("Sorry, your order has not been payed");
        }
        break;

      //TODO case 0  = back to displayMenu()

      case 0:
        //displayMenu();

        // Logic for going back to the main menu
        break;
      default:
        System.out.println("Invalid input");
        break;
    }
  }

}