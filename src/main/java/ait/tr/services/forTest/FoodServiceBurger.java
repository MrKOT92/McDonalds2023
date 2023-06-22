package ait.tr.services.forTest;

import ait.tr.models.Food;
import ait.tr.repositories.FoodRepository;
import ait.tr.repositories.forTest.FoodRepositoryListBurger;
import ait.tr.services.IFoodService;

import java.util.List;

public class FoodServiceBurger implements IFoodService {

    private FoodRepositoryListBurger foodRepository;

    public FoodServiceBurger(FoodRepositoryListBurger foodRepository){
        this.foodRepository = foodRepository;
    }

    @Override
    public Food chooseDrink() {
        return null;
    }

    @Override
    public Food chooseBurger() {
        List<Food> allBurgers = foodRepository.findAll();
        //printMenu(allBurgers);
        int choice = 3;
        return allBurgers.get(choice-1);
    }

    @Override
    public Food chooseDessert() {
        List<Food> allBurgers = foodRepository.findAll();
        //printMenu(allBurgers);
        int choice = 4;
        if (choice > allBurgers.size()-1){
            throw new IndexOutOfBoundsException("NON in menu");
        }
        return allBurgers.get(choice-1);
    }

    @Override
    public void finalMessage() {
        System.out.println("Thank you");
    }

    private void printMenu(List<Food> list){
        System.out.println("---- Menu ----");
        for (Food food : list) {
            System.out.println(list.indexOf(food)+1 + ". " +
                    food.getTitle() + " " + food.getPrice());
        }
    }
}
