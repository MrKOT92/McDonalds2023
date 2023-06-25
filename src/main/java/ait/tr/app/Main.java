package ait.tr.app;

import ait.tr.menus.MenuView;
import ait.tr.repositories.*;
import ait.tr.services.FoodServiceImpl;
import ait.tr.services.OrderServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

import static ait.tr.menus.SubMenu.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FoodRepositoryBurger burgerRepository = new FoodRepositoryBurger("burger.txt");
        FoodRepositoryDessert dessertRepository = new FoodRepositoryDessert("dessert.txt");
        FoodRepositoryDrink drinkRepository = new FoodRepositoryDrink("drink.txt");

        FoodServiceImpl service = new FoodServiceImpl(burgerRepository, drinkRepository, dessertRepository);
        OrderRepositoryImpl orderRepositoryImpl = new OrderRepositoryImpl("orders.txt");
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl(orderRepositoryImpl);
        MenuView menu = new MenuView(burgerRepository, drinkRepository, dessertRepository, orderServiceImpl, orderRepositoryImpl);
        System.out.println("Hello, we present to you the simple project created by group 1, from the school ait-tr.de, group Cohort 25.");
        System.out.println("So let's start :)");
        int clientOrAdmin;
        while (true) {

            System.out.println("IF YOU ARE CLIENT input 1:");
            System.out.println("IF YOU ARE ADMIN input 0:");

            try {
                clientOrAdmin = scanner.nextInt();
                scanner.nextLine();

                if (clientOrAdmin == 1 || clientOrAdmin == 0) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 1 or 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        if (clientOrAdmin == 1) {
            while (true) {
                System.out.println("1. Hello, Welcome to our McDonald's!");
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
                            System.out.println("Where will you eat? Press: 1-Here, 2-To Go");
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

                        chooseFromMenu(subChoice, service, orderServiceImpl, burgerRepository, menu);
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
        } else {
            while (true) {
                System.out.println("CHOOSE ACTION:");
                System.out.println("1. Print all orders");
                System.out.println("2. Delete order by id");
                System.out.println("0. Exit");

                int command;
                try {
                    command = scanner.nextInt();
                    scanner.nextLine();

                    switch (command) {
                        case 1:
                            menu.printAllOrders();
                            break;
                        case 2:
                            System.out.println("input the order id which you can delete:");
                            String id = scanner.nextLine();
                            orderRepositoryImpl.remove(id);
                            break;
                        case 0:
                            System.out.println("Exit");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid input. Please enter a number");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
        }
    }
}


