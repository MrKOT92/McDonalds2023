package ait.tr.repositories;

import ait.tr.models.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    Order findById(String id);
    Order findByIdFile(String id);
    void remove(String id);
    List<Order> findAllOrders();
}
