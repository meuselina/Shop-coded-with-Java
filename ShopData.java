import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/** Holds the product catalog of the shop, one list per category. */
public class ShopData {
  private LinkedList<Tops> tops = new LinkedList<>();
  private LinkedList<Pants> pants = new LinkedList<>();
  private LinkedList<Accessories> accessories = new LinkedList<>();
  private LinkedList<Tracksuits> tracksuits = new LinkedList<>();
  private LinkedList<Shoes> shoes = new LinkedList<>();

  public ShopData() {
    // Tops
    tops.add(create(new Tops(), "Cardigan", "black", "cotton", 36, 39, "2024-03-12"));
    tops.add(create(new Tops(), "Cardigan", "gray", "cotton", 36, 35, "2024-05-12"));
    tops.add(create(new Tops(), "T-shirt", "blue", "polyester", 38, 25, "2024-04-14"));
    tops.add(create(new Tops(), "Blouse", "white", "silk", 40, 45, "2024-01-10"));
    tops.add(create(new Tops(), "Top", "red", "cotton", 34, 20, "2024-03-15"));
    tops.add(create(new Tops(), "Hoodie", "green", "fleece", 42, 50, "2024-02-20"));
    tops.add(create(new Tops(), "Pullover", "yellow", "wool", 36, 55, "2024-02-18"));
    tops.add(create(new Tops(), "Jacket", "purple", "cotton", 40, 60, "2024-06-12"));
    tops.add(create(new Tops(), "Tank top", "pink", "viscose", 32, 18, "2024-03-22"));
    tops.add(create(new Tops(), "Sweater", "black", "cotton", 44, 70, "2024-04-05"));

    // Pants
    pants.add(create(new Pants(), "Jeans", "dark blue", "denim", 38, 60, "2024-06-03"));
    pants.add(create(new Pants(), "Trousers", "black", "cotton", 38, 50, "2024-07-03"));
    pants.add(create(new Pants(), "Cargo pants", "brown", "corduroy", 36, 45, "2024-06-05"));
    pants.add(create(new Pants(), "Summer pants", "white", "linen", 34, 40, "2024-06-10"));
    pants.add(create(new Pants(), "Sweatpants", "gray", "polyester", 40, 35, "2024-04-02"));
    pants.add(create(new Pants(), "Skinny jeans", "light blue", "denim", 32, 70, "2024-05-08"));
    pants.add(create(new Pants(), "Chinos", "green", "cotton", 38, 55, "2024-03-18"));
    pants.add(create(new Pants(), "Trousers", "red", "silk", 36, 80, "2024-02-25"));
    pants.add(create(new Pants(), "Business pants", "black", "wool", 40, 65, "2024-03-13"));
    pants.add(create(new Pants(), "Casual pants", "beige", "cotton", 38, 60, "2024-01-17"));

    // Shoes
    shoes.add(create(new Shoes(), "High heels", "dark blue", "denim", 38, 60, "2024-06-03"));
    shoes.add(create(new Shoes(), "Kitten heels", "burgundy", "leather", 37, 70, "2024-08-03"));
    shoes.add(create(new Shoes(), "Sneakers", "black", "faux leather", 40, 50, "2024-07-10"));
    shoes.add(create(new Shoes(), "Sandals", "white", "textile", 39, 30, "2024-05-15"));
    shoes.add(create(new Shoes(), "Flip-flops", "red", "rubber", 36, 15, "2024-06-22"));
    shoes.add(create(new Shoes(), "Boots", "brown", "suede", 42, 85, "2024-09-03"));
    shoes.add(create(new Shoes(), "Slip-ons", "gray", "canvas", 38, 40, "2024-04-28"));
    shoes.add(create(new Shoes(), "Ballet flats", "yellow", "fabric", 37, 45, "2024-03-14"));
    shoes.add(create(new Shoes(), "Oxfords", "black", "leather", 41, 90, "2024-02-02"));
    shoes.add(create(new Shoes(), "Moccasins", "green", "velvet", 39, 65, "2024-08-18"));

    // Accessories (size 0 means one size)
    accessories.add(create(new Accessories(), "Hair band", "dark blue", "denim", 0, 40, "2024-06-03"));
    accessories.add(create(new Accessories(), "Belt", "black", "leather", 95, 25, "2024-05-10")); // belt length in cm
    accessories.add(create(new Accessories(), "Bracelet", "silver", "silver", 0, 60, "2024-03-15"));
    accessories.add(create(new Accessories(), "Neckerchief", "red", "fabric", 0, 20, "2024-06-05"));
    accessories.add(create(new Accessories(), "Sunglasses", "black", "plastic", 0, 35, "2024-07-01"));
    accessories.add(create(new Accessories(), "Scarf", "blue", "fabric", 0, 30, "2024-04-25"));
    accessories.add(create(new Accessories(), "Necklace", "gold", "gold", 0, 75, "2024-06-12"));
    accessories.add(create(new Accessories(), "Gloves", "white", "cotton", 0, 15, "2024-02-15"));
    accessories.add(create(new Accessories(), "Headband", "green", "polyester", 0, 18, "2024-03-10"));
    accessories.add(create(new Accessories(), "Wristwatch", "purple", "fabric", 0, 80, "2024-04-23"));

    // Tracksuits
    tracksuits.add(create(new Tracksuits(), "Jogging suit", "dark blue", "cotton", 39, 160, "2024-06-03"));
    tracksuits.add(create(new Tracksuits(), "Sports tracksuit", "gray", "polyester", 40, 140, "2024-05-12"));
    tracksuits.add(create(new Tracksuits(), "Training suit", "black", "cotton", 42, 150, "2024-03-10"));
    tracksuits.add(create(new Tracksuits(), "Casual tracksuit", "red", "cotton", 38, 155, "2024-04-18"));
    tracksuits.add(create(new Tracksuits(), "Jogging suit", "blue", "polyester", 39, 145, "2024-02-20"));
    tracksuits.add(create(new Tracksuits(), "Winter tracksuit", "green", "fleece", 40, 175, "2024-01-30"));
    tracksuits.add(create(new Tracksuits(), "Summer tracksuit", "black", "cotton", 41, 130, "2024-05-28"));
    tracksuits.add(create(new Tracksuits(), "Luxury tracksuit", "white", "silk", 39, 200, "2024-06-05"));
    tracksuits.add(create(new Tracksuits(), "Sports tracksuit", "orange", "polyester", 37, 145, "2024-03-17"));
    tracksuits.add(create(new Tracksuits(), "Training suit", "purple", "cotton", 42, 160, "2024-04-13"));
  }

  /** Fills in all attributes of a product and returns it. Every product starts out in stock. */
  private static <T extends Product> T create(T product, String productType, String color,
      String material, int size, int price, String manufactureDate) {
    product.setProductType(productType);
    product.setColor(color);
    product.setMaterial(material);
    product.setSize(size);
    product.setPrice(price);
    product.setManufactureDate(manufactureDate);
    product.setAvailable(true);
    return product;
  }

  /** Returns the products of a category ("tops", "pants", ...), or null if the category is unknown. */
  public LinkedList<? extends Product> getCategory(String category) {
    if (category.equalsIgnoreCase("tops")) {
      return tops;
    } else if (category.equalsIgnoreCase("pants")) {
      return pants;
    } else if (category.equalsIgnoreCase("accessories")) {
      return accessories;
    } else if (category.equalsIgnoreCase("tracksuits")) {
      return tracksuits;
    } else if (category.equalsIgnoreCase("shoes")) {
      return shoes;
    }
    return null;
  }

  /** Returns the products whose type, color or material contains the search term (case-insensitive). */
  public static LinkedList<Product> search(List<? extends Product> products, String searchTerm) {
    LinkedList<Product> results = new LinkedList<>();
    String term = searchTerm.toLowerCase();
    for (Product product : products) {
      String text = (product.getProductType() + " " + product.getColor() + " " + product.getMaterial()).toLowerCase();
      if (text.contains(term)) {
        results.add(product);
      }
    }
    return results;
  }

  /** Sorts the list in place by price. */
  public static void sortByPrice(List<Product> products, boolean ascending) {
    Comparator<Product> byPrice = Comparator.comparingInt(Product::getPrice);
    products.sort(ascending ? byPrice : byPrice.reversed());
  }

  public LinkedList<Tops> getTops() {
    return tops;
  }

  public LinkedList<Pants> getPants() {
    return pants;
  }

  public LinkedList<Accessories> getAccessories() {
    return accessories;
  }

  public LinkedList<Tracksuits> getTracksuits() {
    return tracksuits;
  }

  public LinkedList<Shoes> getShoes() {
    return shoes;
  }
}
