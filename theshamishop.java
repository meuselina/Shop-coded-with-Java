import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Comparator;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class theshamishop extends JFrame {
  // Anfang Attribute
  private shamishop shop;
  private JButton bsuchen1 = new JButton();
  private JTextField Suchtextfeld = new JTextField();
  private JButton bPreisASC1 = new JButton();
  private JButton bPreisDESC1 = new JButton();
  private JList<String> jList2 = new JList<>();
  private DefaultListModel<String> jList2Model = new DefaultListModel<>();
  private JScrollPane jList2ScrollPane = new JScrollPane(jList2);
  private JButton bback1 = new JButton();
  private JTextArea jTextArea1 = new JTextArea();  // JTextField durch JTextArea ersetzt
  private JLabel lBeschreibung1 = new JLabel();
  private Canvas canvas1 = new Canvas();
  private Image currentImage = null;
  // Alle Artikel der aktuellen Kategorie
  private LinkedList<Artikel> items = new LinkedList<>();
  // Die Artikel, die gerade in der Liste angezeigt werden (nach Suche/Sortierung)
  private LinkedList<Artikel> angezeigteItems = new LinkedList<>();
  private String aktuelleKategorie;
  private Image hintergrundBild;
  private static final String PLATZHALTER = "Search...";
  // Ende Attribute
  
  // Konstruktor
  public theshamishop(String kategorie) { 
    super();
    shop = new shamishop();
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
    
    // Container für das Hauptfenster
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    // Erstelle das Panel für das Hintergrundbild
    // Hintergrundbild nur einmal laden (vorher bei jedem Neuzeichnen)
    try {
      hintergrundBild = ImageIO.read(new File("laser.jpg"));
    } catch (IOException e) {
      hintergrundBild = null;
    }
    JPanel backgroundPanel = new JPanel() {
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (hintergrundBild != null) {
          g.drawImage(hintergrundBild, 0, 0, this.getWidth(), this.getHeight(), null); // Skaliere das Bild auf die Größe des Panels
        }
      }
    };
    backgroundPanel.setBounds(0, 0, frameWidth, frameHeight);
    backgroundPanel.setLayout(null); // Verwende null Layout für manuelle Positionierung der Komponenten
    
    // Alle Komponenten werden in das backgroundPanel eingefügt
    cp.add(backgroundPanel);  // Hintergrundpanel zum Haupt-Container hinzufügen
    
    // Setze die Button- und Textfeld-Eigenschaften
    bsuchen1.setBounds(416, 24, 64, 48);
    bsuchen1.setText("suchen");
    bsuchen1.setMargin(new Insets(2, 2, 2, 2));
    bsuchen1.setBackground(new Color(0x536382));
    bsuchen1.setFont(new Font("Dialog", Font.BOLD, 14));
    bsuchen1.setForeground(Color.WHITE);
    backgroundPanel.add(bsuchen1);
    bsuchen1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bsuchen1_ActionPerformed(evt);
      }
    });
    
    Suchtextfeld.setBounds(112, 24, 304, 48);
    Suchtextfeld.setText(PLATZHALTER);
    Suchtextfeld.setFont(new Font("Dialog", Font.BOLD, 18));
    // Platzhalter beim Klicken ins Feld entfernen
    Suchtextfeld.addFocusListener(new FocusAdapter() {
      public void focusGained(FocusEvent e) {
        if (Suchtextfeld.getText().equals(PLATZHALTER)) {
          Suchtextfeld.setText("");
        }
      }
    });
    // Enter im Suchfeld startet die Suche
    Suchtextfeld.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bsuchen1_ActionPerformed(evt);
      }
    });
    backgroundPanel.add(Suchtextfeld);
    
    bPreisASC1.setBounds(784, 24, 72, 48);
    bPreisASC1.setText("Preis \u2191");
    bPreisASC1.setMargin(new Insets(2, 2, 2, 2));
    bPreisASC1.setFont(new Font("Dialog", Font.BOLD, 12));
    bPreisASC1.setForeground(Color.WHITE);
    bPreisASC1.setBackground(new Color(0x555E79));
    backgroundPanel.add(bPreisASC1);
    bPreisASC1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        sortiereProdukteNachPreisAufsteigend(); // Aufsteigende Sortierung
      }
    });
    
    bPreisDESC1.setBounds(872, 24, 72, 48);
    bPreisDESC1.setText("Preis \u2193");
    bPreisDESC1.setMargin(new Insets(2, 2, 2, 2));
    bPreisDESC1.setFont(new Font("Dialog", Font.BOLD, 12));
    bPreisDESC1.setForeground(Color.WHITE);
    bPreisDESC1.setBackground(new Color(0x525C78));
    backgroundPanel.add(bPreisDESC1);
    bPreisDESC1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        sortiereProdukteNachPreisAbsteigend(); // Absteigende Sortierung
      }
    });
    
    // JList konfigurieren
    jList2.setModel(jList2Model);
    jList2ScrollPane.setBounds(40, 136, 224, 472);
    jList2.setFont(new Font("Bodoni MT", Font.BOLD, 20));
    jList2.setBackground(new Color(0xD5D7E3));
    backgroundPanel.add(jList2ScrollPane);
    
    bback1.setBounds(40, 24, 56, 48);
    bback1.setText("back");
    bback1.setMargin(new Insets(2, 2, 2, 2));
    bback1.setFont(new Font("Dialog", Font.BOLD, 14));
    bback1.setForeground(Color.WHITE);
    bback1.setBackground(new Color(0x5C6681));
    bback1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bback1_ActionPerformed(evt);
      }
    });
    backgroundPanel.add(bback1);
    
    // Setze das JTextArea für die Produktbeschreibung
    jTextArea1.setBounds(304, 176, 320, 432);
    jTextArea1.setBackground(new Color(0xD2D2DD));
    jTextArea1.setFont(new Font("Dialog", Font.BOLD, 18));
    jTextArea1.setMargin(new Insets(8, 10, 8, 10));
    jTextArea1.setEditable(false);  // Setze das JTextArea auf nicht bearbeitbar
    jTextArea1.setLineWrap(true);    // Zeilenumbruch aktivieren
    jTextArea1.setWrapStyleWord(true); // Wortweises Umbruchverhalten
    backgroundPanel.add(jTextArea1);
    
    // Setze das Label für die Beschreibung
    lBeschreibung1.setBounds(304, 136, 320, 40);
    lBeschreibung1.setText("Beschreibung");
    lBeschreibung1.setBackground(new Color(0x58597E));  // Setzt die Hintergrundfarbe des Labels
    lBeschreibung1.setOpaque(true);  // Setzt das Label auf undurchsichtig, sodass die Hintergrundfarbe sichtbar wird
    lBeschreibung1.setForeground(Color.WHITE);  // Weißer Text
    lBeschreibung1.setHorizontalAlignment(SwingConstants.CENTER);
    lBeschreibung1.setFont(new Font("Bodoni MT", Font.BOLD, 28));
    backgroundPanel.add(lBeschreibung1);
    
    canvas1 = new Canvas() {
      public void paint(Graphics g) {
        super.paint(g);
        if (currentImage != null) {
          g.drawImage(currentImage, 0, 0, getWidth(), getHeight(), this);
        }
      }
    };
    canvas1.setBounds(664, 136, 280, 472);
    canvas1.setBackground(new Color(0xD1D3E0));
    backgroundPanel.add(canvas1);
    
    // Auswahl-Listener nur EINMAL registrieren (vorher bei jedem Kategorie-Wechsel erneut)
    jList2.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent ereignis) {
        if (!ereignis.getValueIsAdjusting()) {
          zeigeDetails(jList2.getSelectedIndex());
        }
      }
    });
    
    zeigeKategorie(kategorie);
    // Ende Komponenten
    setVisible(true);
  }
  
  
  // Methode zum Zeigen der Kategorie
  // Anfang Methoden
  private void zeigeKategorie(String kategorie) {
    aktuelleKategorie = kategorie;
    LinkedList<? extends Artikel> liste = null;
    if (kategorie.equalsIgnoreCase("oberteile")) {
      liste = shop.getOberteile();
    } else if (kategorie.equalsIgnoreCase("hosen")) {
      liste = shop.getHosen();
    } else if (kategorie.equalsIgnoreCase("accessoires")) {
      liste = shop.getAccessoires();
    } else if (kategorie.equalsIgnoreCase("tracksuits")) {
      liste = shop.getTracksuits();
    } else if (kategorie.equalsIgnoreCase("schuhe")) {
      liste = shop.getSchuhe();
    }
    
    items = new LinkedList<>();
    if (liste != null) {
      items.addAll(liste);  // Kopie, damit das Sortieren die Originaldaten nicht veraendert
    }
    angezeigteItems = new LinkedList<>(items);
    aktualisiereJList();
    if (liste == null) {
      jList2Model.addElement("Kategorie nicht verfügbar.");
    }
  }
  
  // Zeigt Beschreibung und Bild des ausgewaehlten Artikels
  private void zeigeDetails(int index) {
    if (index < 0 || index >= angezeigteItems.size()) {
      return;
    }
    // Wichtig: angezeigteItems statt items, sonst passt nach einer Suche
    // der Index nicht mehr zum angezeigten Produkt
    Artikel artikel = angezeigteItems.get(index);
    jTextArea1.setText(artikel.getBeschreibung());
    currentImage = ladeBild(artikel);
    canvas1.repaint();
  }
  
  // Sucht ein passendes Bild: zuerst fuer den Produkttyp, sonst fuer die Kategorie
  private Image ladeBild(Artikel artikel) {
    String datei;
    if (artikel.getProdukttyp().equalsIgnoreCase("t-shirt")) {
      datei = "tshirttt.png";
    } else if (artikel.getProdukttyp().equalsIgnoreCase("cardigan")) {
      datei = "cardi.png";
    } else if (artikel instanceof oberteile) {
      datei = "oberteill.jpg";
    } else if (artikel instanceof Hosen) {
      datei = "hoseee.jpg";
    } else if (artikel instanceof accessoires) {
      datei = "schmuckkkk.jpg";
    } else if (artikel instanceof schuhe) {
      datei = "schuheeee.jpg";
    } else {
      datei = "trackkkk.jpg";
    }
    try {
      File bildDatei = new File(datei);
      return bildDatei.exists() ? ImageIO.read(bildDatei) : null;
    } catch (IOException e) {
      return null;
    }
  }
  
  // Methode zum Filtern der Produkte basierend auf dem Suchtext
  private void filterProdukte(String suchbegriff) {
    angezeigteItems = new LinkedList<>();
    for (Artikel artikel : items) {
      String text = (artikel.getProdukttyp() + " " + artikel.getFarbe() + " " + artikel.getMaterial()).toLowerCase();
      if (text.contains(suchbegriff.toLowerCase())) {
        angezeigteItems.add(artikel);
      }
    }
    aktualisiereJList();
    if (angezeigteItems.isEmpty()) {
      jList2Model.addElement("Keine Produkte gefunden.");
    }
  }
  
  // Aktion für den "Suchen"-Button
  private void bsuchen1_ActionPerformed(ActionEvent evt) {
    String suchbegriff = Suchtextfeld.getText().trim();
    if (suchbegriff.isEmpty() || suchbegriff.equals(PLATZHALTER)) {
      // Leere Suche: wieder alle Produkte der AKTUELLEN Kategorie zeigen
      zeigeKategorie(aktuelleKategorie);
    } else {
      filterProdukte(suchbegriff);
    }
  }
  
  // Sortiert die angezeigten Produkte nach Preis
  private void sortiereProdukteNachPreisAufsteigend() {
    angezeigteItems.sort(Comparator.comparingInt(Artikel::getPreis));
    aktualisiereJList();
  }
  
  private void sortiereProdukteNachPreisAbsteigend() {
    angezeigteItems.sort(Comparator.comparingInt(Artikel::getPreis).reversed());
    aktualisiereJList();
  }
  
  private void aktualisiereJList() {
    jList2Model.clear();
    jTextArea1.setText("");
    currentImage = null;
    canvas1.repaint();
    for (Artikel artikel : angezeigteItems) {
      jList2Model.addElement(artikel.getProdukttyp() + "  (" + artikel.getPreis() + " \u20ac)");
    }
  }
  // Aktion für den Zurück-Button
  private void bback1_ActionPerformed(ActionEvent evt) {
    this.dispose();
    new kategorien(); // Hier wird die Instanz von 'kategorien' erstellt, der nächste Bildschirm
  }
  
  // Main-Methode
  public static void main(String[] args) {
    new theshamishop("oberteile");
  }
  // Ende Methoden
} 