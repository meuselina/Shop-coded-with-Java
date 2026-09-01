import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
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
  // Instanzvariable für die Artikel-Liste
  private LinkedList<Object> items;
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
    JPanel backgroundPanel = new JPanel() {
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
          Image img = ImageIO.read(new File("laser.jpg"));
          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null); // Skaliere das Bild auf die Größe des Panels
        } catch (IOException e) {
          e.printStackTrace();
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
    Suchtextfeld.setText("Search...");
    Suchtextfeld.setFont(new Font("Dialog", Font.BOLD, 18));
    backgroundPanel.add(Suchtextfeld);
    
    bPreisASC1.setBounds(784, 24, 72, 48);
    bPreisASC1.setText("PreisASC");
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
    bPreisDESC1.setText("PreisDESC");
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
    jList2.setFont(new Font("Bodoni MT", Font.BOLD, 26));
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
    
    zeigeKategorie(kategorie);
    // Ende Komponenten
    setVisible(true);
  }
  
  
  // Methode zum Zeigen der Kategorie
  // Anfang Methoden
  private void zeigeKategorie(String kategorie) {
    jList2Model.clear();  // Vorherige Einträge in der JList löschen
    // Auswahl der Kategorie
    if (kategorie.equalsIgnoreCase("oberteile")) {
      items = (LinkedList<Object>) (LinkedList<?>) shop.getOberteile();
    } if (kategorie.equalsIgnoreCase("hosen")) {
      items = (LinkedList<Object>) (LinkedList<?>) shop.getHosen();
    }  if (kategorie.equalsIgnoreCase("accessoires")) {
      items = (LinkedList<Object>) (LinkedList<?>) shop.getAccessoires();
    }  if (kategorie.equalsIgnoreCase("tracksuits")) {
      items = (LinkedList<Object>) (LinkedList<?>) shop.getTracksuits();
    }  if (kategorie.equalsIgnoreCase("schuhe")) {
      items = (LinkedList<Object>) (LinkedList<?>) shop.getSchuhe();
    }
    
    // Liste für die "getArt" Werte erstellen
    LinkedList<String> artList = new LinkedList<>();
    
    // Wenn die Kategorie gefunden wurde, die Artikel durchlaufen und "getArt" Werte sammeln
    if (items != null) {
      for (int i = 0; i < items.size(); i++) {  
        try {
          Object item = items.get(i);  // Holen des Items anhand des Index
          String art = (String) item.getClass().getMethod("getProdukttyp").invoke(item);
          artList.add(art);  // "getArt" Wert zur Liste hinzufügen
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      // Die gesammelten "getProdukttyp" Werte in das JList2Model übertragen
      for (int i = 0; i < artList.size(); i++) {
        jList2Model.addElement(artList.get(i));
      }
    } else {
      jList2Model.addElement("Kategorie nicht verfügbar.");
    }
    
    // ListSelectionListener hinzufügen, um Artikel auszuwählen und Informationen anzuzeigen
    jList2.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent ereignis) {
        int ausgewählterIndex = jList2.getSelectedIndex();
        if (ausgewählterIndex >= 0) {
          // Holt das ausgewählte Item
          Object ausgewähltesItem = items.get(ausgewählterIndex);
          try {
            // Zeigt Produktinformationen im jTextArea1 an
            String informationen = "Farbe: " + ausgewähltesItem.getClass().getMethod("getFarbe").invoke(ausgewähltesItem) +
            "\nMaterial: " + ausgewähltesItem.getClass().getMethod("getMaterial").invoke(ausgewähltesItem) +
            "\nProdukttyp: " + ausgewähltesItem.getClass().getMethod("getProdukttyp").invoke(ausgewähltesItem) +
            "\nPreis: " + ausgewähltesItem.getClass().getMethod("getPreis").invoke(ausgewähltesItem) +
            "\nGröße: " + ausgewähltesItem.getClass().getMethod("getGroesse").invoke(ausgewähltesItem) +
            "\nHerstellungsdatum: " + ausgewähltesItem.getClass().getMethod("getHerstellungsdatum").invoke(ausgewähltesItem) +
            "\nVerfügbarkeit: " + ausgewähltesItem.getClass().getMethod("getVerfuegbarkeit").invoke(ausgewähltesItem);
            jTextArea1.setText(informationen);   
            // Bild laden und im Canvas anzeigen
            String produkttyp = ausgewähltesItem.getClass().getMethod("getProdukttyp").invoke(ausgewähltesItem).toString();
            // Prüfen, ob Produkttyp "TShirt" ist
            if (produkttyp.equalsIgnoreCase("t-shirt")) {
              File bildDatei = new File("tshirttt.png");
              if (bildDatei.exists()) {
                currentImage = ImageIO.read(bildDatei); // Bild laden
              } else {
                currentImage = null; // Kein Bild verfügbar
              }
            } else {
              currentImage = null; // Kein Bild anzeigen, wenn der Produkttyp nicht passt
            }
            canvas1.repaint(); // Canvas neu zeichnen
          } catch (Exception ex) {
            ex.printStackTrace();
          }
          
        }
      }
    });
  }
  
  // Methode zum Filtern der Produkte basierend auf dem Suchtext
  private void filterProdukte(String suchbegriff) {
    // Leere die Liste der angezeigten Produkte
    jList2Model.clear();
    
    // Liste der gefilterten Artikel basierend auf dem Suchbegriff
    LinkedList<String> gefilterteArtList = new LinkedList<>();
    
    // Wenn die Kategorie gefunden wurde, die Artikel durchlaufen und nach Produkttyp filtern
    if (items != null) {
      for (int i = 0; i < items.size(); i++) {
        try {
          Object item = items.get(i);  // Holen des Items anhand des Index
          String produkttyp = (String) item.getClass().getMethod("getProdukttyp").invoke(item);
          
          // Prüfen, ob der Produkttyp den Suchbegriff enthält (case-insensitive)
          if (produkttyp.toLowerCase().contains(suchbegriff.toLowerCase())) {
            gefilterteArtList.add(produkttyp);  // Passende Produkte zur Liste hinzufügen
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      
      // Die gefilterten Produkttypen in die JList einfügen
      for (int i = 0; i < gefilterteArtList.size(); i++) {
        jList2Model.addElement(gefilterteArtList.get(i));  // Ändern der Schleife ohne :
      }
      
      // Wenn keine Produkte gefunden wurden
      if (gefilterteArtList.isEmpty()) {
        jList2Model.addElement("Keine Produkte gefunden.");
      }
    }
  }
  
  // Aktion für den "Suchen"-Button
  private void bsuchen1_ActionPerformed(ActionEvent evt) {
    // Holen des Suchtextes aus dem Textfeld
    String suchbegriff = Suchtextfeld.getText().trim();
    
    // Wenn der Suchbegriff nicht leer ist, wird die Liste gefiltert
    if (!suchbegriff.isEmpty()) {
      filterProdukte(suchbegriff);
    } else {
      // Wenn das Suchfeld leer ist, alle Produkte anzeigen
      zeigeKategorie("oberteile");  // Kann entsprechend angepasst werden, um die aktuelle Kategorie anzuzeigen
    }
  }
  
  
  // Methode zur Produktsortierung nach Preis (aufsteigend)
  
  private void sortiereProdukteNachPreisAufsteigend() {
    int n = items.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        try {
          double preis1 = Double.parseDouble(items.get(j).getClass().getMethod("getPreis").invoke(items.get(j)).toString());
          double preis2 = Double.parseDouble(items.get(j + 1).getClass().getMethod("getPreis").invoke(items.get(j + 1)).toString());
          
          // Aufsteigend sortieren
          if (preis1 > preis2) {
            Object temp = items.get(j);
            items.set(j, items.get(j + 1));
            items.set(j + 1, temp);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    
    aktualisiereJList();
  }
  
  private void sortiereProdukteNachPreisAbsteigend() {
    int n = items.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        try {
          double preis1 = Double.parseDouble(items.get(j).getClass().getMethod("getPreis").invoke(items.get(j)).toString());
          double preis2 = Double.parseDouble(items.get(j + 1).getClass().getMethod("getPreis").invoke(items.get(j + 1)).toString());
          
          // Absteigend sortieren
          if (preis1 < preis2) {
            Object temp = items.get(j);
            items.set(j, items.get(j + 1));
            items.set(j + 1, temp);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    
    aktualisiereJList();
  }
  
  private void aktualisiereJList() {
    jList2Model.clear();
    for (Object item : items) {
      try {
        String produkttyp = item.getClass().getMethod("getProdukttyp").invoke(item).toString();
        jList2Model.addElement(produkttyp);
      } catch (Exception e) {
        e.printStackTrace();
      }
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