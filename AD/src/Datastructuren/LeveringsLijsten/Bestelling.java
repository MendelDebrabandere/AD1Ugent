package Datastructuren.LeveringsLijsten;

public class Bestelling {
    private Klant klant;
    private Artikel artikel;
    
    public Bestelling(Klant klant, Artikel artikel){
        this.klant = klant;
        this.artikel = artikel;
    }
    
    public Klant getKlant(){
        return klant;
    }
    
    public Artikel getArtikel(){
        return artikel;
    }
}
