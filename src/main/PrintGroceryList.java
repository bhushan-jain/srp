package main;

import java.util.List;

public class PrintGroceryList {

  public void printItems(List<GroceryShop> groceryList) {
    groceryList.forEach(System.out::println);
  }
}
