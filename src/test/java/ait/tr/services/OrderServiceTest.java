package ait.tr.services;

import ait.tr.models.Burger;
import ait.tr.models.Order;
import ait.tr.repositories.OrderRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp(){
        this.orderService = new OrderServiceImpl(new OrderRepositoryListImpl());
    }


///TODO
    @Test
    void confirmOrder() {
        Order order = new Order("456",2,
                new ArrayList<>(List.of(new Burger("Hamburger",1.2,
                        96.0,false,false,253,
                        "beef","ketchup"))), false);

        boolean actual = orderService.confirmOrder(order);
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

        double actual = orderService.getTotalSumOfOrder(order);
        double expected = 1.2;
        assertEquals(expected,actual);
    }

    @Test
    void getTotalSumOrderIfNull() {
        Order order = new Order();
        double actual = orderService.getTotalSumOfOrder(order);
        double expected = 0.0;
        assertEquals(expected,actual);
    }

}