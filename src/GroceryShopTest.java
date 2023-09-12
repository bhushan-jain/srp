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

  private GroceryShop groceryShop;

  @BeforeEach
  public void setUp() {
    groceryShop = new GroceryShop();
  }

  @Test
  public void testAddItem() {
    GroceryShop item = new GroceryShop(1, "Milk", LocalDate.of(2023, 12, 31), 2);
    groceryShop.addItem(item);
    assertEquals(1, groceryShop.getGroceryList().size());
  }

  @Test
  public void testRemoveItem() {
    GroceryShop item1 = new GroceryShop(1, "Milk", LocalDate.of(2023, 12, 31), 2);
    GroceryShop item2 = new GroceryShop(2, "Bread", LocalDate.of(2023, 11, 30), 1);
    groceryShop.addItem(item1);
    groceryShop.addItem(item2);

    groceryShop.removeItem(1);
    assertEquals(1, groceryShop.getGroceryList().size());
    assertEquals("Bread", groceryShop.getGroceryList().get(0).getItemName());
  }

  @Test
  public void testSave() throws IOException {
    String fileName = "GroceryList.txt";
    GroceryShop item1 = new GroceryShop(1, "Milk", LocalDate.of(2023, 12, 31), 2);
    GroceryShop item2 = new GroceryShop(2, "Bread", LocalDate.of(2023, 11, 30), 1);
    groceryShop.addItem(item1);
    groceryShop.addItem(item2);

    try {
      groceryShop.save(fileName);
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
