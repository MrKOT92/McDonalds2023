package ait.tr.services;
import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
 Scanner scanner = new Scanner(System.in);
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;

    }

    public Order createOrder(){
        return new Order();
    }

    public void addFoodToOrder(Order order, Food food){
        order.getOrderList().add(food);
    }

    //TODO remove to Main
    public boolean confirmOrder(Order order) {
        //showOrder(order);
        double totalSum = getTotalSumOfOrder(order);

        String confirmation;
        boolean validConfirmation = false;

        while (!validConfirmation) {
            System.out.println("Sum: " + totalSum + System.lineSeparator() + "Please confirm (Y/N):");
            confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                validConfirmation = true;
                orderRepository.save(order);
                payment(order);
                return true;
            } else if (confirmation.equalsIgnoreCase("N")) {
                validConfirmation = true;
                clearOrder(order);
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }

        return false;
    }


    public void payment(Order order){
        order.setPayed(true);
    }


    //TODO Throw new Exception "Mistake"
    public double getTotalSumOfOrder(Order order) {
        List<Food> list = order.getOrderList();
        double totalSum = 0;
        if (list.isEmpty()){
            System.out.println("Mistake");
        } else {
            for (Food food : list) {
                totalSum += food.getPrice();
            }
        }
        return totalSum;
    }

    public void clearOrder(Order order){
        order.getOrderList().clear();
    }

}
