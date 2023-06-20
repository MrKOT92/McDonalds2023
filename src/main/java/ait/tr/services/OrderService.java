package ait.tr.services;
import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.OrderRepository;

import java.util.List;

public class OrderService implements IOrderService{

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

    public void confirmOrderAndPay(Order order){
        showOrder(order);
        double totalSum = totalSumOrder(order);
        System.out.println("Sum: " + totalSum);
        ///if yes =
        orderRepository.save(order);
        //boolean
    }

    public void payment(){
        //isPayd = true
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

    public void clearOrder(){
        ///list.clear
    }
}
