package ait.tr.repositories;

import ait.tr.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryListImpl implements OrderRepository {

    private List<Order> dayOrders = new ArrayList<>(List.of(
            new Order(), new Order(), new Order()
    ));



    @Override
    public void save(Order order) {
        dayOrders.add(order);
    }

    @Override
    public Order findById(String id) {
        for (Order order: dayOrders
        ) {
            if(order.getId().equals(id)){
                return order;
            }
        }
        throw new NullPointerException("Order is not found");
    }

    @Override
    public Order findByIdFile(String id) {
        return null;
    }

    @Override
    public void remove(String id) {

    }
    public List<Order> findAllOrders(){
        return null;
    }
}
