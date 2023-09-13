package main;

import java.util.ArrayList;
import java.util.List;

public class ManipulateGroceryList {

  private final List<GroceryShop> groceryList = new ArrayList<>();

  public List<GroceryShop> getGroceryList() {
    return groceryList;
  }

  public void addItem(GroceryShop item) {
    groceryList.add(item);
  }

  public void removeItem(int number) {
    groceryList.remove(--number);
  }
}
