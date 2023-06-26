package ait.tr.services;

import ait.tr.models.Burger;
import ait.tr.models.Order;
import ait.tr.repositories.OrderRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    private OrderServiceImpl orderServiceImpl;

    @BeforeEach
    public void setUp(){
        this.orderServiceImpl = new OrderServiceImpl(new OrderRepositoryListImpl());
    }


///TODO
    @Test
    void confirmOrder() {
        String confirmation = "Y";
        Order order = new Order("456",2,
                new ArrayList<>(List.of(new Burger("Hamburger",1.2,
                        96.0,false,false,253,
                        "beef","ketchup"))), false);

        boolean actual = orderServiceImpl.confirmOrder(order, confirmation);
        boolean expected = true;
        assertEquals(expected,actual);

    }

    @Test
    void payment() {
    }

    @Test
    void getTotalSumOrder() {
        Order order = new Order("456",2,
                new ArrayList<>(List.of(new Burger("Hamburger",1.2,
                        96.0,false,false,253,
                        "beef","ketchup"))), false);

        double actual = orderServiceImpl.getTotalSumOrder(order);
        double expected = 1.2;
        assertEquals(expected,actual);
    }

    @Test
    void getTotalSumOrderIfNull() {
        Order order = new Order();
        double actual = orderServiceImpl.getTotalSumOrder(order);
        double expected = 0.0;
        assertEquals(expected,actual);
    }

}