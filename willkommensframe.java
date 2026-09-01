import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class willkommensframe extends JFrame {
    // Anfang Attribute
  private JButton bstart1 = new JButton();
  private Image backgroundImage;
  private JLabel lShamishop2 = new JLabel();
  private JLabel lWillkommenim1 = new JLabel();
  // Ende Attribute
  
  public willkommensframe() {
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
    setTitle("willkommensframe");
    setResizable(false);
    
    // bild
    try {
      backgroundImage = ImageIO.read(new File("mannanledwand.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    //JPanel mit custom paintComponent für background image
    JPanel backgroundPanel = new JPanel() {
    
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
          g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
      }
    };
    backgroundPanel.setLayout(null); // Custom layout
    setContentPane(backgroundPanel); // custom panel als content pane
    
    // Anfang Komponenten
    bstart1.setBounds(144, 312, 110, 96);
    bstart1.setText("start");
    bstart1.setMargin(new Insets(2, 2, 2, 2));
    bstart1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bstart1_ActionPerformed(evt);
      }
    });
    bstart1.setBackground(new Color(0x000040));
    bstart1.setForeground(Color.WHITE);
    bstart1.setFont(new Font("Cambria", Font.BOLD, 36));
    backgroundPanel.add(bstart1); // button zu backgroundPanel
    
    lShamishop2.setBounds(72, 208, 256, 96);
    lShamishop2.setText("Shamishop");
    lShamishop2.setForeground(Color.WHITE);
    lShamishop2.setFont(new Font("Edwardian Script ITC", Font.BOLD, 68));
    backgroundPanel.add(lShamishop2); // label zu backgroundPanel
    
    lWillkommenim1.setBounds(24, 136, 376, 80);
    lWillkommenim1.setText("Willkommen im");
    lWillkommenim1.setFont(new Font("Edwardian Script ITC", Font.BOLD, 68));
    lWillkommenim1.setForeground(Color.WHITE);
    backgroundPanel.add(lWillkommenim1); // label zu backgroundPanel
    
    // Ende Komponenten
    showLoadingScreen(this); 
    setVisible(true);
  } // end of public willkommensframe
  
  // Anfang Methoden
  
  private static void showLoadingScreen(JFrame frame) {
    //  JProgressBar  Erstellung
    JProgressBar progressBar = new JProgressBar();
    progressBar.setMinimum(0);
    progressBar.setMaximum(50);
    progressBar.setForeground(new Color(255, 105, 180)); // Neonpink Farbe
    
    // JOptionPane mit der JProgressBar
    JOptionPane optionPane = new JOptionPane(progressBar, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
    
    // JDialog, um das JOptionPane anzuzeigen          https://www.java-blog-buch.de/13-02-01-jframe-und-jdialog/ 
    // Dialoge unterscheiden sich von normalen Frames im Grunde nur dadurch, dass das Hauptfenster eines Programmes deaktiviert ist, solange der Dialog offen ist.         
    JDialog dialog = new JDialog(frame, null, true);
    dialog.setUndecorated(true);                       // Leiste oben entfernen
    dialog.setContentPane(optionPane);
    //    dialog.getContentPane().setBackground(new Color(255, 182, 193)); // Rosa Farbe
    dialog.pack();
    dialog.setLocationRelativeTo(frame);
    
    // Timer zum Aktualisieren des Fortschrittsbalkens
    Timer timer = new Timer(5, new ActionListener() {
      private int progress = 0;
      
      public void actionPerformed(ActionEvent e) {
        progressBar.setValue(progress);
        progress++;                               //Progress Erhöhung
        if (progress > 100) {
          dialog.dispose(); //  Schleißen des Dialogfensters, wenn der Fortschrittsbalken vollständig gefüllt ist
        }
      }
    });
    timer.start(); // Timer staten
    
    dialog.setVisible(true); // Anzeigen des Dialogfensters
  }
  
  public static void main(String[] args) {
    new willkommensframe();
  } // end of main
  
  public void bstart1_ActionPerformed(ActionEvent evt) {
    new kategorien(); // Öffnet das kategorien-Fenster
    dispose(); // Schließt das aktuelle willkommensframe-Fenster
  } // end of bstart1_ActionPerformed
  
  // Ende Methoden
} // end of class willkommensframe