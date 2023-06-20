package ait.tr.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private String id;
    private int number;
    private static int COUNTDAYORDERS = 1;
    private List<Food> orderlist;

    public Order() {
        this.id = UUID.randomUUID().toString();
        this.number = COUNTDAYORDERS;
        this.orderlist = new ArrayList<>();
        this.COUNTDAYORDERS++;
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
