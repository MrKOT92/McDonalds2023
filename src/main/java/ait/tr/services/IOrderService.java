package ait.tr.services;

import ait.tr.models.Food;
import ait.tr.models.Order;

public interface IOrderService {

    Order createOrder();
    void addFoodToOrder(Order order, Food food);
    void showOrder(Order order);
    void confirmOrderAndPay(Order order);
    void payment();
    double totalSumOrder(Order order);
    void clearOrder();


}
