package ait.tr.services;

import ait.tr.models.Food;
import ait.tr.models.Order;

public interface OrderService {

    Order createOrder();
    void addFoodToOrder(Order order, Food food);
    boolean confirmOrder(Order order, String confirmation);
    void payment(Order order);
    double getTotalSumOrder(Order order);
    void clearOrder(Order order);

}
