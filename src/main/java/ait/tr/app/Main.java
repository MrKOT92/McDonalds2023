package ait.tr.app;

import static ait.tr.menus.SubMenu.displayMenu;
import static ait.tr.menus.SubMenu.handleSubMenu;

import ait.tr.models.Order;
import ait.tr.repositories.*;
import ait.tr.services.FoodService;
import ait.tr.services.OrderService;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
 public static int typeOfOrder;


  public static void main(String[] args) throws FileNotFoundException {

    Scanner scanner = new Scanner(System.in);


    FoodRepositoryBurger burgerRepository = new FoodRepositoryBurger("burger.txt");
    FoodRepositoryDessert dessertRepository = new FoodRepositoryDessert("dessert.txt");
    FoodRepositoryDrink drinkRepository = new FoodRepositoryDrink("drink.txt");

    FoodService service = new FoodService(burgerRepository, drinkRepository, dessertRepository);
    OrderRepository orderRepository = new OrderRepository("orders.txt");
    OrderService orderService = new OrderService(orderRepository);

    //TODO tests
    //FoodService usersService = new UsersServiceImpl(usersRepository);




    while (true) {
      System.out.println("1. Hello, Welcome to our Restaurant!");
      System.out.println("0. Exit");

      int command = scanner.nextInt();
      switch (command) {
        case 1:
          System.out.println("Where will you eat? Press: 1-Here, 2-To Go");
          typeOfOrder = scanner.nextInt();
          displayMenu();

          int subChoice = scanner.nextInt();
          handleSubMenu(subChoice, service, drinkRepository, burgerRepository,dessertRepository, orderService);
          break;
        case 0:
          System.out.println("Goodbye!");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
    }
  }
}
