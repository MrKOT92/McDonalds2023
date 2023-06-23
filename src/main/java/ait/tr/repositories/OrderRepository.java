package ait.tr.repositories;

import ait.tr.models.Order;

public interface OrderRepository {
    void save(Order order);
    Order findById(String id);
    void remove(Order order);
}
