package ait.tr.menus;

import ait.tr.repositories.OrderRepositoryImpl;
import ait.tr.services.OrderServiceImpl;

import static ait.tr.menus.SubMenu.scanner;

public class AdminMenu {

    OrderRepositoryImpl orderRepository = new OrderRepositoryImpl("orders.txt");
    OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Print all orders");
            System.out.println("2. Delete an order");
            System.out.println("3. Delete position from order");
            System.out.println("0. Exit");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> {System.out.println("1. Print all orders");}
                case 2 -> {System.out.println("2. Delete an order");}
                case 3 -> {System.out.println("3. Delete position from order");}
                case 0 -> {
                    System.out.println("Exit");
                    System.exit(0);
                }
                default -> System.out.println("Command is not recognized");
            }
        }


    }

}
