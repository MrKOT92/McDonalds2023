package ait.tr.repositories;

import ait.tr.models.Food;
import java.util.List;

public interface FoodRepository {


  //TODO use stream API
  List<Food> findAll();
}
