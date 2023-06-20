package ait.tr.menus;

import ait.tr.models.Food;
import ait.tr.repositories.FoodRepository;
import ait.tr.services.FoodService;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

public class SubMenu {
  public static List<Food> order = new ArrayList<Food>();
  public SubMenu() {
    System.out.println("2. Choose Burger"); // add foodToOrder
    System.out.println("3. Choose Dessert");
    System.out.println("4. Choose Drink");

    System.out.println("5. Check your order");// show order in console + totalSumOrder

    System.out.println("6. Payment"); // confirmOrderAndPay
    System.out.println("7. Exit");
     //message + ID
  }
  public void HandleSubMenu(int command, FoodService service, FoodRepository drinkRepository){
      switch (command) {
        case 2:
          break;
        case 3:
          break;
        case 4:
          Food drink = service.chooseDrink(drinkRepository);
          order.add(drink);
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }

  }
}
