package ait.tr.services;

import ait.tr.models.Food;

import ait.tr.models.Order;
import ait.tr.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodService implements IFoodService {

    private FoodRepositoryBurger foodRepositoryBurger;
    private FoodRepositoryDrink foodRepositoryDrink;
    private FoodRepositoryDessert foodRepositoryDessert;


    public FoodService(FoodRepositoryBurger foodRepositoryBurger,
                       FoodRepositoryDrink foodRepositoryDrink,
                       FoodRepositoryDessert foodRepositoryDessert) {
        this.foodRepositoryBurger = foodRepositoryBurger;
        this.foodRepositoryDrink = foodRepositoryDrink;
        this.foodRepositoryDessert = foodRepositoryDessert;

    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public Food chooseDrink() {
        List<Food> allDrinks = foodRepositoryDrink.findAll();
        printMenu(allDrinks);
        int choice = scanner.nextInt();
        if (choice > allDrinks.size() - 1) {
            throw new IndexOutOfBoundsException("NON in menu");
        }
        return allDrinks.get(choice - 1);

    }


    @Override
    public Food chooseBurger() {
        List<Food> allBurgers = foodRepositoryBurger.findAll();
        printMenu(allBurgers);
        int choice = scanner.nextInt();
        if (choice > allBurgers.size() - 1) {
            throw new IndexOutOfBoundsException("NON in menu");
        }

        return allBurgers.get(choice - 1);
    }

    @Override
    public Food chooseDessert() {
        List<Food> allDessert = foodRepositoryDessert.findAll();
        printMenu(allDessert);
        int choice = scanner.nextInt();
        if (choice > allDessert.size() - 1) {
            throw new IndexOutOfBoundsException("NON in menu");
        }
        return allDessert.get(choice - 1);

    }

    private void printMenu(List<Food> list) {
        System.out.println("---- Menu ----");
        for (Food food : list) {
            System.out.println(list.indexOf(food) + 1 + ". " +
                    food.getTitle() + " " + food.getPrice());
        }
    }

    //TODO
    @Override
    public void finalMessage() {
        System.out.println("Thank you");
    }



}

