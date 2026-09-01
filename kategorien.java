import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class kategorien extends JFrame {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private JButton jButton4 = new JButton();
  private JButton jButton5 = new JButton();
  private JLabel lWaehlenSieeineKategorieaus1 = new JLabel();
  private JLabel lOberteile1 = new JLabel();
  private JLabel lHosen1 = new JLabel();
  private JLabel lAccessoires1 = new JLabel();
  private JLabel lSchuhe1 = new JLabel();                                                                         
  private JLabel lTracksuits1 = new JLabel();
  // Ende Attribute
  
  public kategorien() {
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1000;
    int frameHeight = 700;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("kategorien");
    setResizable(false);
    
    // Custom JPanel für den Hintergrund
    BackgroundPanel cp = new BackgroundPanel();
    cp.setLayout(null);
    
    // Anfang Komponenten
    jButton1.setBounds(48, 280, 152, 288);
    jButton1.setIcon(new ImageIcon("oberteill.jpg"));
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openTheshamishopFrame("oberteile");
      }
    });
    cp.add(jButton1);
    
    jButton2.setBounds(232, 280, 152, 288);
    jButton2.setIcon(new ImageIcon("hoseee.jpg"));
    jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openTheshamishopFrame("hosen");
      }
    });
    cp.add(jButton2);
    
    jButton3.setBounds(416, 280, 152, 288);
    jButton3.setIcon(new ImageIcon("schmuckkkk.jpg"));
    jButton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openTheshamishopFrame("accessoires");
      }
    });
    cp.add(jButton3);
    
    jButton4.setBounds(600, 280, 152, 288);
    jButton4.setIcon(new ImageIcon("schuheeee.jpg"));
    jButton4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openTheshamishopFrame("schuhe");
      }
    });
    cp.add(jButton4);
    
    jButton5.setBounds(784, 280, 152, 288);
    jButton5.setIcon(new ImageIcon("trackkkk.jpg"));
    jButton5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        openTheshamishopFrame("tracksuits");
      }
    });
    cp.add(jButton5);
    
    // Titel
    lWaehlenSieeineKategorieaus1.setBounds(56, 96, 872, 104);
    lWaehlenSieeineKategorieaus1.setText("Wählen Sie eine Kategorie aus!");
    lWaehlenSieeineKategorieaus1.setForeground(Color.WHITE);
    lWaehlenSieeineKategorieaus1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 55));
    cp.add(lWaehlenSieeineKategorieaus1);
    
    // Labels für Kategorien
    lOberteile1.setBounds(48, 256, 152, 24);
    lOberteile1.setText("Oberteile");
    lOberteile1.setHorizontalAlignment(SwingConstants.CENTER);
    lOberteile1.setBackground(new Color(0x352F51));
    lOberteile1.setFont(new Font("Dialog", Font.BOLD, 16));
    lOberteile1.setForeground(Color.WHITE);
    lOberteile1.setOpaque(true);
    cp.add(lOberteile1);
    
    lHosen1.setBounds(232, 256, 152, 24);
    lHosen1.setText("Hosen");
    lHosen1.setHorizontalAlignment(SwingConstants.CENTER);
    lHosen1.setBackground(new Color(0x48446F));
    lHosen1.setFont(new Font("Dialog", Font.BOLD, 16));
    lHosen1.setForeground(Color.WHITE);
    lHosen1.setOpaque(true);
    cp.add(lHosen1);
    
    lAccessoires1.setBounds(416, 256, 152, 24);
    lAccessoires1.setText("Accessoires");
    lAccessoires1.setHorizontalAlignment(SwingConstants.CENTER);
    lAccessoires1.setBackground(new Color(0x605B84));
    lAccessoires1.setFont(new Font("Dialog", Font.BOLD, 16));
    lAccessoires1.setForeground(Color.WHITE);
    lAccessoires1.setOpaque(true);
    cp.add(lAccessoires1);
    
    lSchuhe1.setBounds(600, 256, 152, 24);
    lSchuhe1.setText("Schuhe");
    lSchuhe1.setHorizontalAlignment(SwingConstants.CENTER);
    lSchuhe1.setBackground(new Color(0x7B7B9D));
    lSchuhe1.setFont(new Font("Dialog", Font.BOLD, 16));
    lSchuhe1.setForeground(Color.WHITE);
    lSchuhe1.setOpaque(true);
    cp.add(lSchuhe1);
    
    lTracksuits1.setBounds(784, 256, 152, 24);
    lTracksuits1.setText("Tracksuits");
    lTracksuits1.setHorizontalAlignment(SwingConstants.CENTER);
    lTracksuits1.setBackground(new Color(0x9995B3));
    lTracksuits1.setFont(new Font("Dialog", Font.BOLD, 16));
    lTracksuits1.setForeground(Color.WHITE);
    lTracksuits1.setOpaque(true);
    cp.add(lTracksuits1);
    
    setContentPane(cp);
    setVisible(true);
  }

    // Methode, die das theshamishop-Frame öffnet
  private void openTheshamishopFrame(String kategorie) {
    new theshamishop(kategorie); // Öffnet theshamishop und übergibt die Kategorie
    dispose(); // Schließt das aktuelle kategorien-Fenster
  }

    // Hintergrundpanel mit benutzerdefiniertem Bild
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
    new kategorien();
  }
}