package ait.tr.repositories;

import ait.tr.models.Burger;
import ait.tr.models.Dessert;
import ait.tr.models.Drink;
import ait.tr.models.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodRepositoryListBurger implements FoodRepository{



    private List<Food> foods = new ArrayList<>(List.of(
            new Burger("Burger", 1.5, 300, false, false, 300, "beef","ketchup"),
            new Dessert("Dessert", 2.0, 100, true, false, 250),
            new Drink("Drink", 0.5, 150, true, false, 100, false)
    ));

    @Override
    public List<Food> findAll() {
        return null;
    }
}
