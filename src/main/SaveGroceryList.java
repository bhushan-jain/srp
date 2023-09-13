package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class SaveGroceryList {

  public void save(String fileName, List<GroceryShop> groceryList) throws FileNotFoundException {
    try (PrintWriter printWriter = new PrintWriter(fileName)) {
      groceryList.forEach(printWriter::println);
    }
  }
}
