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
    FoodService service = new FoodService();

    FoodRepository burgerRepository = new FoodRepositoryBurger("burger.txt");
    FoodRepository dessertRepository = new FoodRepositoryDessert("dessert.txt");
    FoodRepository drinkRepository = new FoodRepositoryDrink("drink.txt");

    OrderRepository orderRepository = new OrderRepository("orders.txt");
    OrderService orderService = new OrderService(orderRepository);


    //FoodService usersService = new UsersServiceImpl(usersRepository);


    Order order = orderService.createOrder();
    String idNumber = order.getId();

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
          handleSubMenu(subChoice, service, drinkRepository, burgerRepository,dessertRepository);
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
