package ait.tr.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private String id;
    private int number;
    private static int countDayOrders = 1;
    private List<Food> orderlist;

    public Order() {
        this.id = UUID.randomUUID().toString();
        this.number = countDayOrders;
        this.orderlist = new ArrayList<>();
        this.countDayOrders++;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public List<Food> getOrderlist() {
        return orderlist;
    }
}
