package ait.tr.menus;

import ait.tr.models.Food;
import ait.tr.models.Order;
import ait.tr.repositories.FoodRepositoryBurger;
import ait.tr.repositories.FoodRepositoryDessert;
import ait.tr.repositories.FoodRepositoryDrink;
import ait.tr.repositories.OrderRepository;
import ait.tr.services.OrderService;

import java.util.List;

public class MenuView {

    private FoodRepositoryBurger foodRepositoryBurger;
    private FoodRepositoryDrink foodRepositoryDrink;
    private FoodRepositoryDessert foodRepositoryDessert;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public MenuView(FoodRepositoryBurger foodRepositoryBurger, FoodRepositoryDrink foodRepositoryDrink,
                    FoodRepositoryDessert foodRepositoryDessert, OrderService orderService,
                    OrderRepository orderRepository) {

        this.foodRepositoryBurger = foodRepositoryBurger;
        this.foodRepositoryDessert = foodRepositoryDessert;
        this.foodRepositoryDrink = foodRepositoryDrink;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public void printMenuDrink() {
        List<Food> list = foodRepositoryDrink.findAll();
        System.out.println("---- Drinks menu ----");
        for (Food food : list) {
            System.out.println(list.indexOf(food) + 1 + ". " +
                    food.getTitle() + " " + food.getPrice());
        }
    }

    public void printMenuDessert() {
        List<Food> list = foodRepositoryDessert.findAll();
        System.out.println("---- Desserts menu ----");
        for (Food food : list) {
            System.out.println(list.indexOf(food) + 1 + ". " +
                    food.getTitle() + " " + food.getPrice());
        }
    }

    public void printMenuBurger() {
        List<Food> list = foodRepositoryBurger.findAll();
        System.out.println("----Burgers menu ----");
        for (Food food : list) {
            System.out.println(list.indexOf(food) + 1 + ". " +
                    food.getTitle() + " " + food.getPrice());
        }
    }

    public void finalMessage(Order order) {
        System.out.println("Thank you, you payment was successful. " + System.lineSeparator() +
                "Pick up the order number: " + order.getNumber());
    }

    public void printOrder(Order order){
        System.out.println("_________________");
        System.out.println("Your order number: " + order.getNumber());
        List<Food> list = order.getOrderlist();
        for (Food food: list
        ) {
            System.out.println(food.getTitle() + " " + food.getPrice());
        }
        System.out.println("_________________");

    }


    public void printAllOrders(){
        List<Order> orders = orderRepository.findAllOrders();
        for (Order order: orders
             ) {
            System.out.println("id - " + order.getId() + System.lineSeparator() +
                    "N - " + order.getNumber() + System.lineSeparator() +
                    (order.isPayed()?"payed":"NOT payed"));
            System.out.println("_________________");
            System.out.println("_________________");

        }
    }

    public void printListOfFoods(List <Food> foods){
        System.out.println("LIST OF FOODS:");
        for (Food food: foods
             ) {System.out.println(food);}
    }

}