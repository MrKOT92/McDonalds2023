package ait.tr.repositories.forTest;

import ait.tr.models.Burger;
import ait.tr.models.Dessert;
import ait.tr.models.Drink;
import ait.tr.models.Food;
import ait.tr.repositories.FoodRepository;

import java.util.ArrayList;
import java.util.List;

public class FoodRepositoryListBurger implements FoodRepository {


    private List<Food> foods;

    public FoodRepositoryListBurger() {
        this.foods = new ArrayList<>(List.of(
                new Food("Burger", 1.5, 300, false, false, 300),
                new Food("Dessert", 2.0, 100, true, false, 250),
                new Food("Drink", 0.5, 150, true, false, 100)
        ));
    }

    @Override
    public List<Food> findAll() {
        return foods;
    }
}
