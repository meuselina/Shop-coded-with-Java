/**
 * Shared base class for every product in the shop.
 *
 * Originally each category (pants, tops, ...) had its own copy of the same
 * fields and methods. With inheritance they now live here once, and every
 * category inherits them.
 */
public abstract class Product {

  private String color = "";
  private String material = "";
  private String productType = "";
  private int price;
  private int size;
  private String manufactureDate = "";
  private boolean available;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getManufactureDate() {
    return manufactureDate;
  }

  public void setManufactureDate(String manufactureDate) {
    this.manufactureDate = manufactureDate;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  /** Text shown in the description box of the shop window. */
  public String getDescription() {
    return "Product type: " + productType
        + "\nColor: " + color
        + "\nMaterial: " + material
        + "\nPrice: €" + price
        + "\nSize: " + size
        + "\nManufactured: " + manufactureDate
        + "\nIn stock: " + (available ? "yes" : "no");
  }

  @Override
  public String toString() {
    return productType;
  }
}
