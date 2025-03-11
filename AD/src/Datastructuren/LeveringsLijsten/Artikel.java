package Datastructuren.LeveringsLijsten;

public class Artikel {
    
    private String naam;
    private Leverancier leverancier;
    
    public Artikel(String naam, Leverancier leverancier){
        this.naam = naam;
        this.leverancier = leverancier;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public Leverancier getLeverancier(){
        return leverancier;
    }

    @Override
    public String toString() {
        return naam;
    }
    
    
    
}
