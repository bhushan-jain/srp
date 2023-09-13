package main;

import java.time.LocalDate;

public class GroceryShop {
  private int itemId;
  private String itemName;
  private LocalDate expiryDate;
  private int price;

  public GroceryShop() {}

  public GroceryShop(int itemId, String itemName, LocalDate expiryDate, int price) {
    this.itemId = itemId;
    this.itemName = itemName;
    this.expiryDate = expiryDate;
    this.price = price;
  }

  public String getItemName() {
    return itemName;
  }

  @Override
  public String toString() {
    return "GroceryShop{"
        + "itemId="
        + itemId
        + ", itemName='"
        + itemName
        + '\''
        + ", expiryDate="
        + expiryDate
        + ", price="
        + price
        + '}';
  }
}
