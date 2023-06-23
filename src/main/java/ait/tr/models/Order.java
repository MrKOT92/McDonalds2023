package ait.tr.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private String id;
    private int number;
    private static int countOrdersNumberPerDay = 1;
    private List<Food> orderList;
    private boolean isPayed;

    public Order(String id, int number, List<Food> orderList, boolean isPayed) {
      this.id = id;
      this.number = number;
      this.orderList = orderList;
      this.isPayed = isPayed;
    }
    public Order() {
        this.id = UUID.randomUUID().toString();
        this.number = countOrdersNumberPerDay;
        this.orderList = new ArrayList<>();
        this.countOrdersNumberPerDay++;
        this.isPayed = false;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public List<Food> getOrderList() {
        return orderList;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public boolean isPayed() {
        return isPayed;
    }
}
