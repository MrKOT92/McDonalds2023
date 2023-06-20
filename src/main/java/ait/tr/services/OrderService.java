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

    public Order createOrder(){
        Order order = new Order();
        //orderRepository.save(order);
        return order;
    }

    public void addFoodToOrder(Order order, Food food){
        order.getOrderlist().add(food);
    }

    //TODO better
    public void showOrder(Order order){
        System.out.println(order);
    }

    public boolean confirmOrder(Order order){
        showOrder(order);
        double totalSum = totalSumOrder(order);
        System.out.println("Sum: " + totalSum + System.lineSeparator() + "Confirm please(Y/N):");
        String confirmation = scanner.nextLine();
        if(confirmation.equalsIgnoreCase("y")){
            orderRepository.save(order);
            payment(order);
            return true;
        }
        clearOrder(order);
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
