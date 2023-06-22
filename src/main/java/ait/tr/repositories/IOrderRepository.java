package ait.tr.repositories;

import ait.tr.models.Order;

public interface IOrderRepository {
    void save(Order order);
    Order findById(String id);
    void remove(Order order);
}
