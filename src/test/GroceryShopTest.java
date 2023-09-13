package test;

import main.GroceryShop;
import main.ManipulateGroceryList;
import main.SaveGroceryList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GroceryShopTest {
  private ManipulateGroceryList manipulateGroceryList;
  private SaveGroceryList saveGroceryList;

  @BeforeEach
  public void setUp() {
    manipulateGroceryList = new ManipulateGroceryList();
    saveGroceryList = new SaveGroceryList();
  }

  @Test
  public void testAddItem() {
    manipulateGroceryList.addItem(new GroceryShop(1, "Milk", LocalDate.of(2023, 12, 31), 2));
    assertEquals(1, manipulateGroceryList.getGroceryList().size());
  }

  @Test
  public void testRemoveItem() {

    manipulateGroceryList.addItem(new GroceryShop(1, "Milk", LocalDate.of(2023, 12, 31), 2));
    manipulateGroceryList.addItem(new GroceryShop(2, "Bread", LocalDate.of(2023, 11, 30), 1));

    manipulateGroceryList.removeItem(1);
    assertEquals(1, manipulateGroceryList.getGroceryList().size());
    assertEquals("Bread", manipulateGroceryList.getGroceryList().get(0).getItemName());
  }

  @Test
  public void testSave() throws IOException {
    String fileName = "GroceryList.txt";

    manipulateGroceryList.addItem(new GroceryShop(1, "Milk", LocalDate.of(2023, 12, 31), 2));
    manipulateGroceryList.addItem(new GroceryShop(2, "Bread", LocalDate.of(2023, 11, 30), 1));

    try {
      saveGroceryList.save(fileName, manipulateGroceryList.getGroceryList());
    } catch (FileNotFoundException e) {
      fail("Exception not expected");
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      int lineNumber = 0;
      String[] expectedLines = {
        "GroceryShop{itemId=1, itemName='Milk', expiryDate=2023-12-31, price=2}",
        "GroceryShop{itemId=2, itemName='Bread', expiryDate=2023-11-30, price=1}"
      };

      while ((line = reader.readLine()) != null && lineNumber < expectedLines.length) {
        assertEquals(expectedLines[lineNumber], line);
        lineNumber++;
      }
      assertEquals(expectedLines.length, lineNumber);
    }
  }
}
