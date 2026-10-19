import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/** Lets the user pick one of the five product categories. */
public class CategoryFrame extends JFrame {
  private JButton topsButton = new JButton();
  private JButton pantsButton = new JButton();
  private JButton accessoriesButton = new JButton();
  private JButton shoesButton = new JButton();
  private JButton tracksuitsButton = new JButton();
  private JLabel titleLabel = new JLabel();
  private JLabel topsLabel = new JLabel();
  private JLabel pantsLabel = new JLabel();
  private JLabel accessoriesLabel = new JLabel();
  private JLabel shoesLabel = new JLabel();
  private JLabel tracksuitsLabel = new JLabel();

  public CategoryFrame() {
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1000;
    int frameHeight = 700;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Categories");
    setResizable(false);

    // Custom JPanel for the background
    BackgroundPanel cp = new BackgroundPanel();
    cp.setLayout(null);

    // Category buttons
    topsButton.setBounds(48, 280, 152, 288);
    topsButton.setIcon(new ImageIcon("oberteill.jpg"));
    topsButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openShopFrame("tops");
      }
    });
    cp.add(topsButton);

    pantsButton.setBounds(232, 280, 152, 288);
    pantsButton.setIcon(new ImageIcon("hoseee.jpg"));
    pantsButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openShopFrame("pants");
      }
    });
    cp.add(pantsButton);

    accessoriesButton.setBounds(416, 280, 152, 288);
    accessoriesButton.setIcon(new ImageIcon("schmuckkkk.jpg"));
    accessoriesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openShopFrame("accessories");
      }
    });
    cp.add(accessoriesButton);

    shoesButton.setBounds(600, 280, 152, 288);
    shoesButton.setIcon(new ImageIcon("schuheeee.jpg"));
    shoesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openShopFrame("shoes");
      }
    });
    cp.add(shoesButton);

    tracksuitsButton.setBounds(784, 280, 152, 288);
    tracksuitsButton.setIcon(new ImageIcon("trackkkk.jpg"));
    tracksuitsButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openShopFrame("tracksuits");
      }
    });
    cp.add(tracksuitsButton);

    // Title
    titleLabel.setBounds(56, 96, 872, 104);
    titleLabel.setText("Choose a category!");
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 55));
    cp.add(titleLabel);

    // Category labels
    styleCategoryLabel(topsLabel, "Tops", 48, new Color(0x352F51));
    cp.add(topsLabel);
    styleCategoryLabel(pantsLabel, "Pants", 232, new Color(0x48446F));
    cp.add(pantsLabel);
    styleCategoryLabel(accessoriesLabel, "Accessories", 416, new Color(0x605B84));
    cp.add(accessoriesLabel);
    styleCategoryLabel(shoesLabel, "Shoes", 600, new Color(0x7B7B9D));
    cp.add(shoesLabel);
    styleCategoryLabel(tracksuitsLabel, "Tracksuits", 784, new Color(0x9995B3));
    cp.add(tracksuitsLabel);

    setContentPane(cp);
    setVisible(true);
  }

  // Gives a category label its text, position and colors
  private static void styleCategoryLabel(JLabel label, String text, int x, Color background) {
    label.setBounds(x, 256, 152, 24);
    label.setText(text);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setBackground(background);
    label.setFont(new Font("Dialog", Font.BOLD, 16));
    label.setForeground(Color.WHITE);
    label.setOpaque(true);
  }

  // Opens the shop window for the chosen category
  private void openShopFrame(String category) {
    new ShopFrame(category);
    dispose(); // close the category window
  }

  // Panel that paints the background image
  class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel() {
      try {
        backgroundImage = ImageIO.read(new File("neonnn.jpg"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
  }

  public static void main(String[] args) {
    new CategoryFrame();
  }
}
