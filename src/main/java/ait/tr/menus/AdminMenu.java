package ait.tr.menus;

import ait.tr.repositories.OrderRepository;
import ait.tr.services.OrderService;

import java.util.List;

import static ait.tr.menus.SubMenu.scanner;

public class AdminMenu {

    OrderRepository orderRepository = new OrderRepository("orders.txt");
    OrderService orderService = new OrderService(orderRepository);

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. print all orders");
            System.out.println("2. delete order");
            System.out.println("3. delete food from order");
            System.out.println("0. Exit");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> {System.out.println("1.print all orders");}
                case 2 -> {System.out.println("2. del order");}
                case 3 -> {System.out.println("3. delete food from order");}
                case 0 -> {
                    System.out.println("Выход");
                    System.exit(0);
                }
                default -> System.out.println("Команда не распознана");
            }
        }


    }

}
