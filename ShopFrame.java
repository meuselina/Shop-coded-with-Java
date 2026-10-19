import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/** Main shop window: product list, search, price sorting and product details. */
public class ShopFrame extends JFrame {
  private ShopData shop;
  private JButton searchButton = new JButton();
  private JTextField searchField = new JTextField();
  private JButton sortAscendingButton = new JButton();
  private JButton sortDescendingButton = new JButton();
  private JList<String> productList = new JList<>();
  private DefaultListModel<String> productListModel = new DefaultListModel<>();
  private JScrollPane productListScrollPane = new JScrollPane(productList);
  private JButton backButton = new JButton();
  private JTextArea descriptionArea = new JTextArea();
  private JLabel descriptionLabel = new JLabel();
  private Canvas imageCanvas = new Canvas();
  private Image currentImage = null;
  // All products of the current category
  private LinkedList<Product> items = new LinkedList<>();
  // The products currently shown in the list (after search or sorting)
  private LinkedList<Product> displayedItems = new LinkedList<>();
  private String currentCategory;
  private Image backgroundImage;
  private static final String PLACEHOLDER = "Search...";

  public ShopFrame(String category) {
    super();
    shop = new ShopData();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1000;
    int frameHeight = 700;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("theshamishop");
    setResizable(false);

    Container cp = getContentPane();
    cp.setLayout(null);

    // Load the background image once instead of on every repaint
    try {
      backgroundImage = ImageIO.read(new File("laser.jpg"));
    } catch (IOException e) {
      backgroundImage = null;
    }
    JPanel backgroundPanel = new JPanel() {
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
          g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null); // scale to panel size
        }
      }
    };
    backgroundPanel.setBounds(0, 0, frameWidth, frameHeight);
    backgroundPanel.setLayout(null); // absolute positioning

    // All components go into the background panel
    cp.add(backgroundPanel);

    searchButton.setBounds(416, 24, 64, 48);
    searchButton.setText("search");
    searchButton.setMargin(new Insets(2, 2, 2, 2));
    searchButton.setBackground(new Color(0x536382));
    searchButton.setFont(new Font("Dialog", Font.BOLD, 14));
    searchButton.setForeground(Color.WHITE);
    backgroundPanel.add(searchButton);
    searchButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        searchButtonActionPerformed(evt);
      }
    });

    searchField.setBounds(112, 24, 304, 48);
    searchField.setText(PLACEHOLDER);
    searchField.setFont(new Font("Dialog", Font.BOLD, 18));
    // Clear the placeholder when the user clicks into the field
    searchField.addFocusListener(new FocusAdapter() {
      public void focusGained(FocusEvent e) {
        if (searchField.getText().equals(PLACEHOLDER)) {
          searchField.setText("");
        }
      }
    });
    // Pressing Enter in the search field starts the search
    searchField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        searchButtonActionPerformed(evt);
      }
    });
    backgroundPanel.add(searchField);

    sortAscendingButton.setBounds(784, 24, 72, 48);
    sortAscendingButton.setText("Price ↑");
    sortAscendingButton.setMargin(new Insets(2, 2, 2, 2));
    sortAscendingButton.setFont(new Font("Dialog", Font.BOLD, 12));
    sortAscendingButton.setForeground(Color.WHITE);
    sortAscendingButton.setBackground(new Color(0x555E79));
    backgroundPanel.add(sortAscendingButton);
    sortAscendingButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        sortByPrice(true);
      }
    });

    sortDescendingButton.setBounds(872, 24, 72, 48);
    sortDescendingButton.setText("Price ↓");
    sortDescendingButton.setMargin(new Insets(2, 2, 2, 2));
    sortDescendingButton.setFont(new Font("Dialog", Font.BOLD, 12));
    sortDescendingButton.setForeground(Color.WHITE);
    sortDescendingButton.setBackground(new Color(0x525C78));
    backgroundPanel.add(sortDescendingButton);
    sortDescendingButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        sortByPrice(false);
      }
    });

    // Product list
    productList.setModel(productListModel);
    productListScrollPane.setBounds(40, 136, 224, 472);
    productList.setFont(new Font("Bodoni MT", Font.BOLD, 20));
    productList.setBackground(new Color(0xD5D7E3));
    backgroundPanel.add(productListScrollPane);

    backButton.setBounds(40, 24, 56, 48);
    backButton.setText("back");
    backButton.setMargin(new Insets(2, 2, 2, 2));
    backButton.setFont(new Font("Dialog", Font.BOLD, 14));
    backButton.setForeground(Color.WHITE);
    backButton.setBackground(new Color(0x5C6681));
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        backButtonActionPerformed(evt);
      }
    });
    backgroundPanel.add(backButton);

    // Text area for the product description
    descriptionArea.setBounds(304, 176, 320, 432);
    descriptionArea.setBackground(new Color(0xD2D2DD));
    descriptionArea.setFont(new Font("Dialog", Font.BOLD, 18));
    descriptionArea.setMargin(new Insets(8, 10, 8, 10));
    descriptionArea.setEditable(false);
    descriptionArea.setLineWrap(true);
    descriptionArea.setWrapStyleWord(true);
    backgroundPanel.add(descriptionArea);

    // Heading above the description
    descriptionLabel.setBounds(304, 136, 320, 40);
    descriptionLabel.setText("Description");
    descriptionLabel.setBackground(new Color(0x58597E));
    descriptionLabel.setOpaque(true); // opaque, so the background color is visible
    descriptionLabel.setForeground(Color.WHITE);
    descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
    descriptionLabel.setFont(new Font("Bodoni MT", Font.BOLD, 28));
    backgroundPanel.add(descriptionLabel);

    imageCanvas = new Canvas() {
      public void paint(Graphics g) {
        super.paint(g);
        if (currentImage != null) {
          g.drawImage(currentImage, 0, 0, getWidth(), getHeight(), this);
        }
      }
    };
    imageCanvas.setBounds(664, 136, 280, 472);
    imageCanvas.setBackground(new Color(0xD1D3E0));
    backgroundPanel.add(imageCanvas);

    // Register the selection listener only once
    productList.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {
          showDetails(productList.getSelectedIndex());
        }
      }
    });

    showCategory(category);
    setVisible(true);
  }

  // Shows all products of a category
  private void showCategory(String category) {
    currentCategory = category;
    LinkedList<? extends Product> list = shop.getCategory(category);

    items = new LinkedList<>();
    if (list != null) {
      items.addAll(list); // copy, so sorting does not change the original data
    }
    displayedItems = new LinkedList<>(items);
    refreshList();
    if (list == null) {
      productListModel.addElement("Category not available.");
    }
  }

  // Shows description and picture of the selected product
  private void showDetails(int index) {
    if (index < 0 || index >= displayedItems.size()) {
      return;
    }
    // Use displayedItems, not items, otherwise the index no longer
    // matches the shown product after a search
    Product product = displayedItems.get(index);
    descriptionArea.setText(product.getDescription());
    currentImage = loadImage(product);
    imageCanvas.repaint();
  }

  // Picks a matching picture: first by product type, otherwise by category
  private Image loadImage(Product product) {
    String fileName;
    if (product.getProductType().equalsIgnoreCase("t-shirt")) {
      fileName = "tshirttt.png";
    } else if (product.getProductType().equalsIgnoreCase("cardigan")) {
      fileName = "cardi.png";
    } else if (product instanceof Tops) {
      fileName = "oberteill.jpg";
    } else if (product instanceof Pants) {
      fileName = "hoseee.jpg";
    } else if (product instanceof Accessories) {
      fileName = "schmuckkkk.jpg";
    } else if (product instanceof Shoes) {
      fileName = "schuheeee.jpg";
    } else {
      fileName = "trackkkk.jpg";
    }
    try {
      File imageFile = new File(fileName);
      return imageFile.exists() ? ImageIO.read(imageFile) : null;
    } catch (IOException e) {
      return null;
    }
  }

  // Filters the products of the current category by the search term
  private void filterProducts(String searchTerm) {
    displayedItems = ShopData.search(items, searchTerm);
    refreshList();
    if (displayedItems.isEmpty()) {
      productListModel.addElement("No products found.");
    }
  }

  // Action for the search button (and Enter in the search field)
  private void searchButtonActionPerformed(ActionEvent evt) {
    String searchTerm = searchField.getText().trim();
    if (searchTerm.isEmpty() || searchTerm.equals(PLACEHOLDER)) {
      // Empty search: show all products of the CURRENT category again
      showCategory(currentCategory);
    } else {
      filterProducts(searchTerm);
    }
  }

  // Sorts the displayed products by price
  private void sortByPrice(boolean ascending) {
    ShopData.sortByPrice(displayedItems, ascending);
    refreshList();
  }

  private void refreshList() {
    productListModel.clear();
    descriptionArea.setText("");
    currentImage = null;
    imageCanvas.repaint();
    for (Product product : displayedItems) {
      productListModel.addElement(product.getProductType() + "  (€" + product.getPrice() + ")");
    }
  }

  // Action for the back button
  private void backButtonActionPerformed(ActionEvent evt) {
    this.dispose();
    new CategoryFrame(); // go back to the category selection
  }

  public static void main(String[] args) {
    new ShopFrame("tops");
  }
}
