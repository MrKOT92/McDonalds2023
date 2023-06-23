package ait.tr.app;

import static ait.tr.menus.SubMenu.displayMenu;
import static ait.tr.menus.SubMenu.chooseFromMenu;

import ait.tr.menus.MenuView;
import ait.tr.repositories.*;
import ait.tr.services.FoodServiceImpl;
import ait.tr.services.OrderServiceImpl;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static int typeOfOrder;


  public static void main(String[] args) throws FileNotFoundException {

    Scanner scanner = new Scanner(System.in);

    FoodRepositoryBurger burgerRepository = new FoodRepositoryBurger("burger.txt");
    FoodRepositoryDessert dessertRepository = new FoodRepositoryDessert("dessert.txt");
    FoodRepositoryDrink drinkRepository = new FoodRepositoryDrink("drink.txt");

    FoodServiceImpl service = new FoodServiceImpl(burgerRepository, drinkRepository, dessertRepository);
    OrderRepositoryImpl orderRepository = new OrderRepositoryImpl("orders.txt");
    OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);
    MenuView menu = new MenuView(burgerRepository, drinkRepository,dessertRepository);



    //TODO exit in every menu
    //TODO tests
    //FoodService usersService = new UsersServiceImpl(usersRepository);

//TODO int command and typeOfOrder, subChoice only numbers...Cristian
    //TODO rename Methods and var
    while (true) {
      System.out.println("1. Hello! Welcome to our McDonald's!");
      System.out.println("0. Exit");

      int command;
      try {
        command = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
        continue;
      }

      switch (command) {
        case 1:
          int typeOfOrder;
          while (true) {
            System.out.println("Where would you like to eat? Press: 1-Here, 2-To Go");
            try {
              typeOfOrder = Integer.parseInt(scanner.nextLine());
              if (typeOfOrder == 1 || typeOfOrder == 2) {
                break;
              } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
              }
            } catch (NumberFormatException e) {
              System.out.println("Invalid input. Please enter a number.");
            }
          }

          displayMenu();

          int subChoice;
          try {
            subChoice = Integer.parseInt(scanner.nextLine());
          } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue;
          }

          chooseFromMenu(subChoice, service, orderService, burgerRepository, menu);
          break;
        case 0:
          System.out.println("Goodbye!");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid input");
          break;
      }
    }
  }
}