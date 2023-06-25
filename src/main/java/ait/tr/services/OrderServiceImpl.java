package ait.tr.services;
import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;

    }

    public Order createOrder(){
        return new Order();
    }

    public void addFoodToOrder(Order order, Food food){
        order.getOrderlist().add(food);
    }

    public boolean confirmOrder(Order order, String confirmation) {
        if (confirmation.equalsIgnoreCase("Y")){
            payment(order);
            orderRepository.save(order);
            return true;
        } else {
            clearOrder(order);
            return false;
        }
    }


    public void payment(Order order){
        order.setPayed(true);
    }

    public double getTotalSumOrder(Order order) {
        List<Food> list = order.getOrderlist();
        double totalSum = 0;
        if (list.isEmpty()){
            System.out.println("Error!!!");
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
