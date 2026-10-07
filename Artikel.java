/**
 * Gemeinsame Basisklasse fuer alle Produkte im Shop.
 *
 * Vorher hatte jede Kategorie (Hosen, Oberteile, ...) eine eigene Kopie
 * derselben Attribute und Methoden. Durch Vererbung stehen sie jetzt nur
 * noch einmal hier, und jede Kategorie erbt sie.
 */
public abstract class Artikel {

  private String farbe = "";
  private String material = "";
  private String produkttyp = "";
  private int preis;
  private int groesse;
  private String herstellungsdatum = "";
  private boolean verfuegbarkeit;

  public String getFarbe() {
    return farbe;
  }

  public void setFarbe(String farbeNeu) {
    farbe = farbeNeu;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String materialNeu) {
    material = materialNeu;
  }

  public String getProdukttyp() {
    return produkttyp;
  }

  public void setProdukttyp(String produkttypNeu) {
    produkttyp = produkttypNeu;
  }

  public int getPreis() {
    return preis;
  }

  public void setPreis(int preisNeu) {
    preis = preisNeu;
  }

  public int getGroesse() {
    return groesse;
  }

  public void setGroesse(int groesseNeu) {
    groesse = groesseNeu;
  }

  public String getHerstellungsdatum() {
    return herstellungsdatum;
  }

  public void setHerstellungsdatum(String herstellungsdatumNeu) {
    herstellungsdatum = herstellungsdatumNeu;
  }

  public boolean getVerfuegbarkeit() {
    return verfuegbarkeit;
  }

  public void setVerfuegbarkeit(boolean verfuegbarkeitNeu) {
    verfuegbarkeit = verfuegbarkeitNeu;
  }

  /** Text fuer die Beschreibung im Shop-Fenster. */
  public String getBeschreibung() {
    return "Produkttyp: " + produkttyp
        + "\nFarbe: " + farbe
        + "\nMaterial: " + material
        + "\nPreis: " + preis + " €"
        + "\nGröße: " + groesse
        + "\nHerstellungsdatum: " + herstellungsdatum
        + "\nVerfügbar: " + (verfuegbarkeit ? "ja" : "nein");
  }

  @Override
  public String toString() {
    return produkttyp;
  }
}
