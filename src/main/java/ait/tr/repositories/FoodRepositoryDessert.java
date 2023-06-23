package ait.tr.repositories;

import ait.tr.models.Food;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodRepositoryDessert implements FoodRepository{
  private final String fileName;
  public FoodRepositoryDessert(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public List<Food> findAll() {
    List<Food> desserts = new ArrayList<>();

    try (FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {

      String line = bufferedReader.readLine();

      while (line != null) {
        Food dessert = parseLine(line);
        desserts.add(dessert);
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      System.err.println("Произошла ошибка");
    }

    return desserts;
  }
  private static Food parseLine(String line) {
    String[] parsed = line.split("\\|");
    String title = parsed[0];
    double price = Double.parseDouble(parsed[1]);
    double weight = Double.parseDouble(parsed[2]);
    boolean isVegan = Boolean.parseBoolean(parsed[3]);
    boolean isForKids = Boolean.parseBoolean(parsed[4]);
    int calories = Integer.parseInt(parsed[5]);

    return new Food(
        title, price, weight, isVegan, isForKids,calories
    );
  }

}
//  public void saveNewUser(Food dessert) {
//
//    try (
//        FileWriter fileWriter = new FileWriter(fileName, true);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {;
//      bufferedWriter.write(dessert.getTitle() + "|" + dessert.getPrice() + "|" + dessert.getWeight()
//          + "|" + dessert.isVegan() + "|" + dessert.isForKids() + "|" + dessert.getCalories());
//      bufferedWriter.newLine();
//
//    } catch (Exception e) {
//      System.out.println("Произошла ошибка");
//    }
//  }

