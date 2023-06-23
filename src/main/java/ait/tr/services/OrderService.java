package ait.tr.services;

import ait.tr.models.Food;
import ait.tr.models.Order;

public interface OrderService {

    Order createOrder();
    void addFoodToOrder(Order order, Food food);
    boolean confirmOrder(Order order);
    void payment(Order order);
    double getTotalSumOfOrder(Order order);
    void clearOrder(Order order);

}
