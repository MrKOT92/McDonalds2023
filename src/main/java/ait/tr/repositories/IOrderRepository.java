package ait.tr.repositories;

import ait.tr.models.Order;

public interface IOrderRepository {
    public void save(Order order);
    public Order findById(String id);
}
