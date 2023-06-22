package ait.tr.services;
import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class OrderService implements IOrderService{
 Scanner scanner = new Scanner(System.in);
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;

    }
//TODO
    public Order createOrder(){
        Order order = new Order();
        //orderRepository.save(order);
        System.out.println(order);
        return order;
    }

    public void addFoodToOrder(Order order, Food food){
        order.getOrderlist().add(food);
    }

    public void showOrder(Order order){
        System.out.println("_________________");
        System.out.println("Your order number: " + order.getNumber());
        List<Food> list = order.getOrderlist();
        for (Food food: list
             ) {
            System.out.println(food.getTitle() + " " + food.getPrice());
        }
        System.out.println("_________________");
    }


    //TODO check NO YES anna
    //TODO del sout
//    public boolean confirmOrder(Order order){
//        showOrder(order);
//        double totalSum = totalSumOrder(order);
//        System.out.println("Total sum: " + totalSum + System.lineSeparator() + "Confirm please and pay(Y/N):");
//        String confirmation = scanner.nextLine();
//        if(confirmation.equalsIgnoreCase("y")){
//            orderRepository.save(order);
//            System.out.println(orderRepository); /// del
//            payment(order);
//            return true;
//        }
//        clearOrder(order);
//        return false;
//
//    }

    public boolean confirmOrder(Order order) {
        showOrder(order);
        double totalSum = totalSumOrder(order);

        String confirmation;
        boolean validConfirmation = false;

        while (!validConfirmation) {
            System.out.println("Sum: " + totalSum + System.lineSeparator() + "Confirm please (Y/N):");
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

    public double totalSumOrder(Order order) {
        List<Food> list = order.getOrderlist();
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
        order.getOrderlist().clear();
    }
}
