import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GroceryShop {
  private int itemId;
  private String itemName;
  private LocalDate expiryDate;
  private int price;

  private final List<GroceryShop> groceryList = new ArrayList<>();

  public GroceryShop() {}

  public GroceryShop(int itemId, String itemName, LocalDate expiryDate, int price) {
    this.itemId = itemId;
    this.itemName = itemName;
    this.expiryDate = expiryDate;
    this.price = price;
  }

  public void addItem(GroceryShop item) {
    groceryList.add(item);
  }

  public void removeItem(int number) {
    groceryList.remove(--number);
  }

  public void printItems() {
    groceryList.forEach(System.out::println);
  }

  public void save(String fileName) throws FileNotFoundException {
    try (PrintWriter printWriter = new PrintWriter(fileName)) {
      groceryList.forEach(printWriter::println);
    }
  }

  public List<GroceryShop> getGroceryList() {
    return groceryList;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
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
