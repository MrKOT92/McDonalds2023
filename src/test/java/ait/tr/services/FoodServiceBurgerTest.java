package ait.tr.services;

import ait.tr.models.Drink;
import ait.tr.models.Food;
import ait.tr.repositories.forTest.FoodRepositoryListBurger;
import ait.tr.services.forTest.FoodServiceBurger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodServiceBurgerTest {


    private FoodServiceBurger foodServiceBurger;
    private FoodRepositoryListBurger foodRepositoryListBurger;

    // Выполнение необходимых действий перед каждым тестовым методом
    // Например, инициализация объектов
    //setUp() будет вызываться перед каждым
    // выполнением тестовых методов, что позволяет гарантировать одинаковое начальное состояние перед каждым тестом.
    @BeforeEach
    void setUp() {
        this.foodServiceBurger = new FoodServiceBurger(new FoodRepositoryListBurger());


    }

    @Test
    void TestPositive_chooseBurger() {
        Food actual = new Food(foodServiceBurger.chooseBurger().getTitle(),
                foodServiceBurger.chooseBurger().getPrice(),
                foodServiceBurger.chooseBurger().getWeight(),
                foodServiceBurger.chooseBurger().isVegan(),
                foodServiceBurger.chooseBurger().isForKids(),
                foodServiceBurger.chooseBurger().getCalories());
        Food expected = new Food("Drink", 0.5, 150, true, false, 100);
        assertEquals(expected,actual);


    }

    @Test
    void finalMessage() {

    }
}