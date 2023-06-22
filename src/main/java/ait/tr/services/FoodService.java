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

    //Scanner scanner = new Scanner(System.in);

    @Override
    public Food chooseDrink(int choice) {
        List<Food> allDrinks = foodRepositoryDrink.findAll();
        //foodRepositoryDrink.printMenu();
        //int choice = scanner.nextInt();
        if (choice > allDrinks.size() - 1) {
            throw new IndexOutOfBoundsException("NON in menu");
        }
        return allDrinks.get(choice - 1);
    }


    @Override
    public Food chooseBurger(int choice) {
        List<Food> allBurgers = foodRepositoryBurger.findAll();
        //foodRepositoryBurger.printMenu();
        //int choice = scanner.nextInt();
        if (choice > allBurgers.size() - 1) {
            throw new IndexOutOfBoundsException("NON in menu");
        }

        return allBurgers.get(choice - 1);
    }

    @Override
    public Food chooseDessert(int choice) {
        List<Food> allDessert = foodRepositoryDessert.findAll();
        //foodRepositoryDrink.printMenu();
        //int choice = scanner.nextInt();
        if (choice > allDessert.size() - 1) {
            throw new IndexOutOfBoundsException("NON in menu");
        }
        return allDessert.get(choice - 1);

    }



}

