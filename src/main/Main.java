package main;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    String fileName = "GroceryList.txt";
    ManipulateGroceryList manipulateGroceryList = new ManipulateGroceryList();
    PrintGroceryList printGroceryList = new PrintGroceryList();
    SaveGroceryList saveGroceryList = new SaveGroceryList();

    manipulateGroceryList.addItem(new GroceryShop(1, "Bathing Soap", LocalDate.of(2023, 12, 12), 20));
    manipulateGroceryList.addItem(new GroceryShop(2, "Hair oil", LocalDate.of(2025, 1, 7), 120));
    manipulateGroceryList.addItem(new GroceryShop(3, "Sugar", LocalDate.of(2024, 8, 1), 40));

    printGroceryList.printItems(manipulateGroceryList.getGroceryList());
    saveGroceryList.save(fileName, manipulateGroceryList.getGroceryList());

    manipulateGroceryList.removeItem(2);

    System.out.println("*****************************");
    printGroceryList.printItems(manipulateGroceryList.getGroceryList());
  }
}
