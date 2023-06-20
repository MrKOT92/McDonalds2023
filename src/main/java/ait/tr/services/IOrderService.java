package ait.tr.services;

import ait.tr.models.Food;
import ait.tr.models.Order;

public interface IOrderService {

    Order createOrder();
    void addFoodToOrder(Order order, Food food);
    void showOrder(Order order);
    boolean confirmOrder(Order order);
    void payment(Order order);
    double totalSumOrder(Order order);
    void clearOrder(Order order);


}
