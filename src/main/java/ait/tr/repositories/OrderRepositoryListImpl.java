package ait.tr.repositories;

import ait.tr.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryListImpl implements OrderRepository {

    private List<Order> ordersPerDay = new ArrayList<>(List.of(
            new Order(), new Order(), new Order()
    ));



    @Override
    public void save(Order order) {
        ordersPerDay.add(order);
    }

    @Override
    public Order findById(String id) {
        for (Order order: ordersPerDay
        ) {
            if(order.getId().equals(id)){
                return order;
            }
        }
        throw new NullPointerException("Order is not found");
    }

    //TODO
    @Override
    public void remove(Order order) {

    }
}
