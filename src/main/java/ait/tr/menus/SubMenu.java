package ait.tr.menus;

import ait.tr.models.Food;
import ait.tr.repositories.FoodRepository;
import ait.tr.services.FoodService;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SubMenu {
static Scanner scanner= new Scanner(System.in);

  public static void handleSubMenu(int subChoice, FoodService service, FoodRepository drinkRepository) {
    // Handle sub-menu choices here based on the selected subChoice
    switch (subChoice) {
      case 1:
        // Logic for choosing a burger
        break;
      case 2:
        // Logic for choosing a dessert
        break;
      case 3:
        // Logic for choosing a drink
        break;
      case 4:
        displayOrderMenu();
        int orderMenuChoice = scanner.nextInt();
        handleOrderMenu(orderMenuChoice); // Handle order menu choices
        break;
      case 0:
        // Logic for exiting the sub-menu
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

  public static void handleOrderMenu(int orderMenuChoice) {
    switch (orderMenuChoice) {
      case 1:
        // Logic for checking the order
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