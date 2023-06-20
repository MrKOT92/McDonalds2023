package ait.tr.repositories;

import ait.tr.models.Drink;
import ait.tr.models.Food;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodRepositoryDrink implements FoodRepository{


  private String fileName;

  public  FoodRepositoryDrink(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public List<Food> findAll() {
    List<Food> drinks = new ArrayList<>();

    try (FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {

      String line = bufferedReader.readLine();

      while (line != null) {
        Drink drink = parseLine(line);
        drinks.add(drink);
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      System.err.println("Произошла ошибка");
    }

    return drinks;
  }
  private static Drink parseLine(String line) {
    String[] parsed = line.split("\\|");
    String title = parsed[0];
    double price = Double.parseDouble(parsed[1]);
    double weight = Double.parseDouble(parsed[2]);
    boolean isVegan = Boolean.parseBoolean(parsed[3]);
    boolean isForKids = Boolean.parseBoolean(parsed[4]);
    int calories = Integer.parseInt(parsed[5]);
    boolean isAlcohol = Boolean.parseBoolean(parsed[6]);
    return new Drink(
        title,  price, weight, isVegan, isForKids, calories, isAlcohol
    );
  }
}
