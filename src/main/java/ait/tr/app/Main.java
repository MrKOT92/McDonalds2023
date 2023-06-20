package ait.tr.app;

import ait.tr.menus.SubMenu;
import ait.tr.models.Food;
import ait.tr.repositories.FoodRepository;
import ait.tr.repositories.FoodRepositoryBurger;
import ait.tr.repositories.FoodRepositoryDessert;
import ait.tr.repositories.FoodRepositoryDrink;
import ait.tr.services.FoodService;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
 public static int typeOfOrder;


  public static void main(String[] args) throws FileNotFoundException {

    Scanner scanner = new Scanner(System.in);
    FoodService service = new FoodService();

   // FoodRepository burgerRepository = new FoodRepositoryBurger("burger.txt");
   // FoodRepository dessertRepository = new FoodRepositoryDessert("dessert.txt");
     FoodRepository drinkRepository = new FoodRepositoryDrink("drink.txt");

    // FoodService usersService = new UsersServiceImpl(usersRepository);

    while (true) {
      System.out.println("1. Choice, eat here or to go?");
      // comment create new orders / id / here or to go

      System.out.println("0. Exit");

      int command = scanner.nextInt();
      switch (command) {
        case 1:
          System.out.println("(1-Here, 2-To Go)");
          typeOfOrder = scanner.nextInt();
          while (true) {
            SubMenu subMenu = new SubMenu();
            int subChoice = scanner.nextInt();
            subMenu.HandleSubMenu(subChoice, service, drinkRepository);
          }

        case 4:
         service.chooseDrink(drinkRepository);
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }

//      switch (command) {
//        case 1 -> {
//
//        }
//      }

    }
  }
}