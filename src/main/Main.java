package main;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    String fileName = "GroceryList.txt";
    GroceryShop groceryShop = new GroceryShop();

    GroceryShop item1 = new GroceryShop(1, "Bathing Soap", LocalDate.of(2023, 12, 12), 20);
    GroceryShop item2 = new GroceryShop(2, "Hair oil", LocalDate.of(2025, 1, 7), 120);
    GroceryShop item3 = new GroceryShop(3, "Sugar", LocalDate.of(2024, 8, 1), 40);

    groceryShop.addItem(item1);
    groceryShop.addItem(item2);
    groceryShop.addItem(item3);

    groceryShop.printItems();
    groceryShop.save(fileName);

    groceryShop.removeItem(2);

    System.out.println("*****************************");
    groceryShop.printItems();
  }
}
