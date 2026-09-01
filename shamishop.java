import java.util.LinkedList;
public class shamishop {
  // Anfang Attribute
  public LinkedList<oberteile> o = new LinkedList<>();
  public LinkedList<Hosen> h = new LinkedList<>();
  public LinkedList<accessoires> a = new LinkedList<>();
  public LinkedList<tracksuits> t = new LinkedList<>();
  public LinkedList<schuhe> s = new LinkedList<>();
  // Ende Attribute
  
  public shamishop() {
    
    oberteile o1 = new oberteile();
    o1.setFarbe("schwarz");
    o1.setProdukttyp("cardigan");
    o1.setMaterial("baumwolle");
    o1.setGroesse(36);
    o1.setPreis(39);
    o1.setHerstellungsdatum("12.03.2024");
    o1.setVerfuegbarkeit(true);
    
    oberteile o2 = new oberteile();
    o2.setFarbe("grau");
    o2.setProdukttyp("cardigan");
    o2.setMaterial("baumwolle");
    o2.setGroesse(36);
    o2.setPreis(35);
    o2.setHerstellungsdatum("12.05.2024");
    o2.setVerfuegbarkeit(true);
    
    oberteile o3 = new oberteile();
    o3.setFarbe("blau");
    o3.setProdukttyp("t-shirt");
    o3.setMaterial("polyester");
    o3.setGroesse(38);
    o3.setPreis(25);
    o3.setHerstellungsdatum("14.04.2024");
    o3.setVerfuegbarkeit(true);
    
    oberteile o4 = new oberteile();
    o4.setFarbe("weiß");
    o4.setProdukttyp("bluse");
    o4.setMaterial("seide");
    o4.setGroesse(40);
    o4.setPreis(45);
    o4.setHerstellungsdatum("10.01.2024");
    o4.setVerfuegbarkeit(true);
    
    oberteile o5 = new oberteile();
    o5.setFarbe("rot");
    o5.setProdukttyp("top");
    o5.setMaterial("baumwolle");
    o5.setGroesse(34);
    o5.setPreis(20);
    o5.setHerstellungsdatum("15.03.2024");
    o5.setVerfuegbarkeit(true);
    
    oberteile o6 = new oberteile();
    o6.setFarbe("grün");
    o6.setProdukttyp("hoodie");
    o6.setMaterial("fleece");
    o6.setGroesse(42);
    o6.setPreis(50);
    o6.setHerstellungsdatum("20.02.2024");
    o6.setVerfuegbarkeit(true);
    
    oberteile o7 = new oberteile();
    o7.setFarbe("gelb");
    o7.setProdukttyp("pullover");
    o7.setMaterial("wolle");
    o7.setGroesse(36);
    o7.setPreis(55);
    o7.setHerstellungsdatum("18.02.2024");
    o7.setVerfuegbarkeit(true);
    
    oberteile o8 = new oberteile();
    o8.setFarbe("lila");
    o8.setProdukttyp("jacke");
    o8.setMaterial("baumwolle");
    o8.setGroesse(40);
    o8.setPreis(60);
    o8.setHerstellungsdatum("12.06.2024");
    o8.setVerfuegbarkeit(true);
    
    oberteile o9 = new oberteile();
    o9.setFarbe("pink");
    o9.setProdukttyp("tanktop");
    o9.setMaterial("viskose");
    o9.setGroesse(32);
    o9.setPreis(18);
    o9.setHerstellungsdatum("22.03.2024");
    o9.setVerfuegbarkeit(true);
    
    oberteile o10 = new oberteile();
    o10.setFarbe("schwarz");
    o10.setProdukttyp("sweater");
    o10.setMaterial("baumwolle");
    o10.setGroesse(44);
    o10.setPreis(70);
    o10.setHerstellungsdatum("05.04.2024");
    o10.setVerfuegbarkeit(true);
    
    o.add(o1); o.add(o2); o.add(o3); o.add(o4); o.add(o5); 
    o.add(o6); o.add(o7); o.add(o8); o.add(o9); o.add(o10);
    /////////////////////////////////////////////////////////////////
    
    
    Hosen h1 = new Hosen();
    h1.setMaterial("jeans");
    h1.setFarbe("dunkelblau");
    h1.setProdukttyp("Jeans");
    h1.setPreis(60);
    h1.setGroesse(38);
    h1.setHerstellungsdatum("3.06.2024");
    h1.setVerfuegbarkeit(true);
    
    Hosen h2 = new Hosen();
    h2.setMaterial("baumwolle");
    h2.setFarbe("schwarz");   
    h2.setProdukttyp("Stoffhose");
    h2.setPreis(50);
    h2.setGroesse(38);
    h2.setHerstellungsdatum("3.07.2024");
    h2.setVerfuegbarkeit(true);
    
    Hosen h3 = new Hosen();
    h3.setMaterial("cord");
    h3.setFarbe("braun");
    h3.setProdukttyp("Cargohose");
    h3.setPreis(45);
    h3.setGroesse(36);
    h3.setHerstellungsdatum("5.06.2024");
    h3.setVerfuegbarkeit(true);
    
    Hosen h4 = new Hosen();
    h4.setMaterial("leinen");
    h4.setFarbe("weiß");
    h4.setProdukttyp("Sommerhose");
    h4.setPreis(40);
    h4.setGroesse(34);
    h4.setHerstellungsdatum("10.06.2024");
    h4.setVerfuegbarkeit(true);
    
    Hosen h5 = new Hosen();
    h5.setMaterial("polyester");
    h5.setFarbe("grau");
    h5.setProdukttyp("Jogginghose");
    h5.setPreis(35);
    h5.setGroesse(40);
    h5.setHerstellungsdatum("2.04.2024");
    h5.setVerfuegbarkeit(true);
    
    Hosen h6 = new Hosen();
    h6.setMaterial("jeans");
    h6.setFarbe("hellblau");
    h6.setProdukttyp("Skinny Jeans");
    h6.setPreis(70);
    h6.setGroesse(32);
    h6.setHerstellungsdatum("8.05.2024");
    h6.setVerfuegbarkeit(true);
    
    Hosen h7 = new Hosen();
    h7.setMaterial("baumwolle");
    h7.setFarbe("grün");
    h7.setProdukttyp("Chino");
    h7.setPreis(55);
    h7.setGroesse(38);
    h7.setHerstellungsdatum("18.03.2024");
    h7.setVerfuegbarkeit(true);
    
    Hosen h8 = new Hosen();
    h8.setMaterial("seide");
    h8.setFarbe("rot");
    h8.setProdukttyp("Stoffhose");
    h8.setPreis(80);
    h8.setGroesse(36);
    h8.setHerstellungsdatum("25.02.2024");
    h8.setVerfuegbarkeit(true);
    
    Hosen h9 = new Hosen();
    h9.setMaterial("wolle");
    h9.setFarbe("schwarz");
    h9.setProdukttyp("Businesshose");
    h9.setPreis(65);
    h9.setGroesse(40);
    h9.setHerstellungsdatum("13.03.2024");
    h9.setVerfuegbarkeit(true);
    
    Hosen h10 = new Hosen();
    h10.setMaterial("baumwolle");
    h10.setFarbe("beige");
    h10.setProdukttyp("Freizeithose");
    h10.setPreis(60);
    h10.setGroesse(38);
    h10.setHerstellungsdatum("17.01.2024");
    h10.setVerfuegbarkeit(true);
    
    h.add(h1); h.add(h2); h.add(h3); h.add(h4); h.add(h5); 
    h.add(h6); h.add(h7); h.add(h8); h.add(h9); h.add(h10);
    //////////////////////////////////////////////////////////////////////
    
    schuhe s1 = new schuhe();
    s1.setMaterial("jeans");
    s1.setFarbe("dunkelblau");
    s1.setProdukttyp("highheels");
    s1.setPreis(60);
    s1.setGroesse(38);
    s1.setHerstellungsdatum("3.06.2024");
    s1.setVerfuegbarkeit(true);
    
    schuhe s2 = new schuhe();
    s2.setMaterial("leder");
    s2.setFarbe("bordeo rot");
    s2.setProdukttyp("kittenheels");
    s2.setPreis(70);
    s2.setGroesse(37);
    s2.setHerstellungsdatum("3.08.2024");
    s2.setVerfuegbarkeit(true);
    
    schuhe s3 = new schuhe();
    s3.setMaterial("kunstleder");
    s3.setFarbe("schwarz");
    s3.setProdukttyp("sneakers");
    s3.setPreis(50);
    s3.setGroesse(40);
    s3.setHerstellungsdatum("10.07.2024");
    s3.setVerfuegbarkeit(true);
    
    schuhe s4 = new schuhe();
    s4.setMaterial("textil");
    s4.setFarbe("weiß");
    s4.setProdukttyp("sandalen");
    s4.setPreis(30);
    s4.setGroesse(39);
    s4.setHerstellungsdatum("15.05.2024");
    s4.setVerfuegbarkeit(true);
    
    schuhe s5 = new schuhe();
    s5.setMaterial("gummi");
    s5.setFarbe("rot");
    s5.setProdukttyp("flip-flops");
    s5.setPreis(15);
    s5.setGroesse(36);
    s5.setHerstellungsdatum("22.06.2024");
    s5.setVerfuegbarkeit(true);
    
    schuhe s6 = new schuhe();
    s6.setMaterial("wildleder");
    s6.setFarbe("braun");
    s6.setProdukttyp("boots");
    s6.setPreis(85);
    s6.setGroesse(42);
    s6.setHerstellungsdatum("03.09.2024");
    s6.setVerfuegbarkeit(true);
    
    schuhe s7 = new schuhe();
    s7.setMaterial("canvas");
    s7.setFarbe("grau");
    s7.setProdukttyp("slip-ons");
    s7.setPreis(40);
    s7.setGroesse(38);
    s7.setHerstellungsdatum("28.04.2024");
    s7.setVerfuegbarkeit(true);
    
    schuhe s8 = new schuhe();
    s8.setMaterial("stoff");
    s8.setFarbe("gelb");
    s8.setProdukttyp("ballet flats");
    s8.setPreis(45);
    s8.setGroesse(37);
    s8.setHerstellungsdatum("14.03.2024");
    s8.setVerfuegbarkeit(true);
    
    schuhe s9 = new schuhe();
    s9.setMaterial("leder");
    s9.setFarbe("schwarz");
    s9.setProdukttyp("oxfords");
    s9.setPreis(90);
    s9.setGroesse(41);
    s9.setHerstellungsdatum("02.02.2024");
    s9.setVerfuegbarkeit(true);
    
    schuhe s10 = new schuhe();
    s10.setMaterial("samt");
    s10.setFarbe("grün");
    s10.setProdukttyp("mokassins");
    s10.setPreis(65);
    s10.setGroesse(39);
    s10.setHerstellungsdatum("18.08.2024");
    s10.setVerfuegbarkeit(true);
    
    s.add(s1); s.add(s2); s.add(s3); s.add(s4); s.add(s5); 
    s.add(s6); s.add(s7); s.add(s8); s.add(s9); s.add(s10);
    ////////////////////////////////////////////////////////////////////
    
    accessoires a1 = new accessoires();
    a1.setMaterial("jeans");
    a1.setFarbe("dunkelblau");
    a1.setProdukttyp("Haarreif");
    a1.setPreis(40);
    a1.setGroesse(0);
    a1.setHerstellungsdatum("3.06.2024");
    a1.setVerfuegbarkeit(true);
    
    accessoires a2 = new accessoires();
    a2.setMaterial("leder");
    a2.setFarbe("schwarz");
    a2.setProdukttyp("Gürtel");
    a2.setPreis(25);
    a2.setGroesse(95);  // Gürtelgröße in cm
    a2.setHerstellungsdatum("10.05.2024");
    a2.setVerfuegbarkeit(true);
    
    accessoires a3 = new accessoires();
    a3.setMaterial("silber");
    a3.setFarbe("silber");
    a3.setProdukttyp("Armband");
    a3.setPreis(60);
    a3.setGroesse(0);
    a3.setHerstellungsdatum("15.03.2024");
    a3.setVerfuegbarkeit(true);
    
    accessoires a4 = new accessoires();
    a4.setMaterial("stoff");
    a4.setFarbe("rot");
    a4.setProdukttyp("Halstuch");
    a4.setPreis(20);
    a4.setGroesse(0);
    a4.setHerstellungsdatum("5.06.2024");
    a4.setVerfuegbarkeit(true);
    
    accessoires a5 = new accessoires();
    a5.setMaterial("plastik");
    a5.setFarbe("schwarz");
    a5.setProdukttyp("Sonnenbrille");
    a5.setPreis(35);
    a5.setGroesse(0);
    a5.setHerstellungsdatum("1.07.2024");
    a5.setVerfuegbarkeit(true);
    
    accessoires a6 = new accessoires();
    a6.setMaterial("stoff");
    a6.setFarbe("blau");
    a6.setProdukttyp("Schal");
    a6.setPreis(30);
    a6.setGroesse(0);
    a6.setHerstellungsdatum("25.04.2024");
    a6.setVerfuegbarkeit(true);
    
    accessoires a7 = new accessoires();
    a7.setMaterial("gold");
    a7.setFarbe("gold");
    a7.setProdukttyp("Kette");
    a7.setPreis(75);
    a7.setGroesse(0);
    a7.setHerstellungsdatum("12.06.2024");
    a7.setVerfuegbarkeit(true);
    
    accessoires a8 = new accessoires();
    a8.setMaterial("baumwolle");
    a8.setFarbe("weiß");
    a8.setProdukttyp("Handschuhe");
    a8.setPreis(15);
    a8.setGroesse(0);
    a8.setHerstellungsdatum("15.02.2024");
    a8.setVerfuegbarkeit(true);
    
    accessoires a9 = new accessoires();
    a9.setMaterial("polyester");
    a9.setFarbe("grün");
    a9.setProdukttyp("Stirnband");
    a9.setPreis(18);
    a9.setGroesse(0);
    a9.setHerstellungsdatum("10.03.2024");
    a9.setVerfuegbarkeit(true);
    
    accessoires a10 = new accessoires();
    a10.setMaterial("stoff");
    a10.setFarbe("lila");
    a10.setProdukttyp("Armbanduhr");
    a10.setPreis(80);
    a10.setGroesse(0);
    a10.setHerstellungsdatum("23.04.2024");
    a10.setVerfuegbarkeit(true);
    
    a.add(a1); a.add(a2); a.add(a3); a.add(a4); a.add(a5); 
    a.add(a6); a.add(a7); a.add(a8); a.add(a9); a.add(a10);
    //////////////////////////////////////////////////////////////////////
    
    tracksuits t1 = new tracksuits();
    t1.setMaterial("baumwolle");
    t1.setFarbe("dunkelblau");
    t1.setProdukttyp("Jogginganzug");
    t1.setPreis(160);
    t1.setGroesse(39);
    t1.setHerstellungsdatum("3.06.2024");
    t1.setVerfuegbarkeit(true);
    
    tracksuits t2 = new tracksuits();
    t2.setMaterial("polyester");
    t2.setFarbe("grau");
    t2.setProdukttyp("Sportanzug");
    t2.setPreis(140);
    t2.setGroesse(40);
    t2.setHerstellungsdatum("12.05.2024");
    t2.setVerfuegbarkeit(true);
    
    tracksuits t3 = new tracksuits();
    t3.setMaterial("baumwolle");
    t3.setFarbe("schwarz");
    t3.setProdukttyp("Trainingsanzug");
    t3.setPreis(150);
    t3.setGroesse(42);
    t3.setHerstellungsdatum("10.03.2024");
    t3.setVerfuegbarkeit(true);
    
    tracksuits t4 = new tracksuits();
    t4.setMaterial("baumwolle");
    t4.setFarbe("rot");
    t4.setProdukttyp("Freizeitanzug");
    t4.setPreis(155);
    t4.setGroesse(38);
    t4.setHerstellungsdatum("18.04.2024");
    t4.setVerfuegbarkeit(true);
    
    tracksuits t5 = new tracksuits();
    t5.setMaterial("polyester");
    t5.setFarbe("blau");
    t5.setProdukttyp("Jogginganzug");
    t5.setPreis(145);
    t5.setGroesse(39);
    t5.setHerstellungsdatum("20.02.2024");
    t5.setVerfuegbarkeit(true);
    
    tracksuits t6 = new tracksuits();
    t6.setMaterial("fleece");
    t6.setFarbe("grün");
    t6.setProdukttyp("Winteranzug");
    t6.setPreis(175);
    t6.setGroesse(40);
    t6.setHerstellungsdatum("30.01.2024");
    t6.setVerfuegbarkeit(true);
    
    tracksuits t7 = new tracksuits();
    t7.setMaterial("baumwolle");
    t7.setFarbe("schwarz");
    t7.setProdukttyp("Sommeranzug");
    t7.setPreis(130);
    t7.setGroesse(41);
    t7.setHerstellungsdatum("28.05.2024");
    t7.setVerfuegbarkeit(true);
    
    tracksuits t8 = new tracksuits();
    t8.setMaterial("seide");
    t8.setFarbe("weiß");
    t8.setProdukttyp("Luxus-Anzug");
    t8.setPreis(200);
    t8.setGroesse(39);
    t8.setHerstellungsdatum("05.06.2024");
    t8.setVerfuegbarkeit(true);
    
    tracksuits t9 = new tracksuits();
    t9.setMaterial("polyester");
    t9.setFarbe("orange");
    t9.setProdukttyp("Sportanzug");
    t9.setPreis(145);
    t9.setGroesse(37);
    t9.setHerstellungsdatum("17.03.2024");
    t9.setVerfuegbarkeit(true);
    
    tracksuits t10 = new tracksuits();
    t10.setMaterial("baumwolle");
    t10.setFarbe("lila");
    t10.setProdukttyp("Trainingsanzug");
    t10.setPreis(160);
    t10.setGroesse(42);
    t10.setHerstellungsdatum("13.04.2024");
    t10.setVerfuegbarkeit(true);
    
    t.add(t1); t.add(t2); t.add(t3); t.add(t4); t.add(t5); 
    t.add(t6); t.add(t7); t.add(t8); t.add(t9); t.add(t10);
    
//    //ausdrucken
//    for (int i=0;i<s.size() ;i++ ) {
//      
//      System.out.println(s.get(i).getProdukttyp());
//      System.out.println(s.get(i).getFarbe());
//      System.out.println(s.get(i).getMaterial());
//      System.out.println(s.get(i).getPreis());
//      System.out.println(s.get(i).getGroesse());
//      System.out.println(s.get(i).getHerstellungsdatum()); 
//      
//    }
  }
   // Getter-Methoden, um auf die Listen zuzugreifen
  // Anfang Methoden
    public LinkedList<oberteile> getOberteile() {
        return o;
    }

    public LinkedList<Hosen> getHosen() {
        return h;
    }

    public LinkedList<accessoires> getAccessoires() {
        return a;
    }

    public LinkedList<tracksuits> getTracksuits() {
        return t;
    }

    public LinkedList<schuhe> getSchuhe() {
        return s;
    }


//  public static boolean sucheProdukt(String suchname, LinkedList<oberteile> o, LinkedList<Hosen> h, LinkedList<schuhe> s, LinkedList<accessoires> a, LinkedList<tracksuits> t) {
//    
//    for (int i = 0; i < o.size(); i++) {
//      if (o.get(i).getArt().equalsIgnoreCase(suchname)) {
//        printProductDetails("Oberteil", o.get(i).getArt(), o.get(i).getFarbe(), o.get(i).getMaterial(), o.get(i).getPreis(), o.get(i).getGroesse(), o.get(i).getHertsellungsdatum());
//        return true;
//      }
//    }
//    
//    // Search in "Hosen" list
//    for (int i = 0; i < h.size(); i++) {
//      if (h.get(i).getProdukttyp().equalsIgnoreCase(suchname)) {
//        printProductDetails("Hose", h.get(i).getProdukttyp(), h.get(i).getFarbe(), h.get(i).getMaterial(), h.get(i).getPreis(), h.get(i).getGroesse(), h.get(i).getHerstellungsdatum());
//        return true;
//      }
//    }
//    
//    // Search in "schuhe" list
//    for (int i = 0; i < s.size(); i++) {
//      if (s.get(i).getProdukttyp().equalsIgnoreCase(suchname)) {
//        printProductDetails("Schuh", s.get(i).getProdukttyp(), s.get(i).getFarbe(), s.get(i).getMaterial(), s.get(i).getPreis(), s.get(i).getGroesse(), s.get(i).getHerstellungsdatum());
//        return true;
//      }
//    }
//    
//    // Search in "accessoires" list
//    for (int i = 0; i < a.size(); i++) {
//      if (a.get(i).getProdukttyp().equalsIgnoreCase(suchname)) {
//        printProductDetails("Accessoire", a.get(i).getProdukttyp(), a.get(i).getFarbe(), a.get(i).getMaterial(), a.get(i).getPreis(), a.get(i).getGroesse(), a.get(i).getHerstellungsdatum());
//        return true;
//      }
//    }
//    
//    // Search in "tracksuits" list
//    for (int i = 0; i < t.size(); i++) {
//      if (t.get(i).getProdukttyp().equalsIgnoreCase(suchname)) {
//        printProductDetails("Tracksuit", t.get(i).getProdukttyp(), t.get(i).getFarbe(), t.get(i).getMaterial(), t.get(i).getPreis(), t.get(i).getGroesse(), t.get(i).getHerstellungsdatum());
//        return true;
//      }
//    }
//    
//    // If no product found, return false
//    return false;
//  }
//
//  private static void printProductDetails(String category, String produkttyp, String farbe, String material, int preis, int groesse, String herstellungsdatum) {
//    System.out.println("Kategorie: " + category);
//    System.out.println("Produkttyp: " + produkttyp);
//    System.out.println("Farbe: " + farbe);
//    System.out.println("Material: " + material);
//    System.out.println("Preis: " + preis);
//    System.out.println("Größe: " + groesse);
//    System.out.println("Herstellungsdatum: " + herstellungsdatum);
//    System.out.println();
//  }

  // Ende Methoden
}