package ait.tr.app;

import ait.tr.repositories.FoodRepository;
import ait.tr.repositories.FoodRepositoryBurger;
import ait.tr.repositories.FoodRepositoryDessert;
import ait.tr.repositories.FoodRepositoryDrink;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    FoodRepository burgerRepository = new FoodRepositoryBurger("burger.txt");
    FoodRepository dessertRepository = new FoodRepositoryDessert("dessert.txt");
    FoodRepository drinkRepository = new FoodRepositoryDrink("drink.txt");

    // FoodService usersService = new UsersServiceImpl(usersRepository);

    while (true) {
      System.out.println("1. Choice, eat here or to go?");
      // comment create new orders / id / here or to go

      System.out.println("2. Choose Burger"); // add foodToOrder
      System.out.println("3. Choose Dessert");
      System.out.println("4. Choose Drink");

      System.out.println("4. Check your order");// show order in console + totalSumOrder

      System.out.println("5. Payment"); // confirmOrderAndPay

      System.out.println("6. Thank you"); //message + ID

      System.out.println("0. Exit");

      int command = scanner.nextInt();
      scanner.nextLine();

      switch (command) {
        case 1 -> {

        }
      }

      default -> System.out.println("Команда не распознана");

    }
  }
}