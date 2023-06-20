package ait.tr.repositories;

import ait.tr.models.Burger;
import ait.tr.models.Drink;
import ait.tr.models.Food;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FoodRepositoryBurger implements FoodRepository{


  private String fileName;

  public  FoodRepositoryBurger(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public List<Food> findAll() {
    List<Food> burgers = new ArrayList<>();

    try (FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader = new BufferedReader(fileReader)) {

      String line = bufferedReader.readLine();

      while (line != null) {
        Burger burger = parseLine(line);
        burgers.add(burger);
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      System.err.println("Произошла ошибка");
    }

    return burgers;
  }
  private static Burger parseLine(String line) {
    String[] parsed = line.split("\\|");
    String title = parsed[0];
    double price = Double.parseDouble(parsed[1]);
    double weight = Double.parseDouble(parsed[2]);
    boolean isVegan = Boolean.parseBoolean(parsed[3]);
    boolean isForKids = Boolean.parseBoolean(parsed[4]);
    int calories = Integer.parseInt(parsed[5]);
    String cutletType = parsed[6];
    String sauce = parsed[7];
    return new Burger(title,price,weight,isVegan,isForKids,calories,cutletType,sauce);

  }
}
