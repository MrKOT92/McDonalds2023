package ait.tr.repositories;

import ait.tr.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> dayOrders = new ArrayList<>();

    private String fileName;

    public OrderRepository(String fileName) {
        this.fileName = fileName;
    }

    //TODO realise
    public void save(Order order) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
//            writer.write(order.getId() + "|" +
//                    order.getNumber());
//            writer.newLine();
//        } catch (IOException e) {
//            throw new IllegalStateException("Проблемы с файлом");
//        }
        dayOrders.add(order);

    }
    public Order findById(String id) {
        for (Order order: dayOrders
        ) {
            if(order.getId().equals(id)){
                return order;
            }
        }
        throw new NullPointerException("Order is not found");
    }
}
