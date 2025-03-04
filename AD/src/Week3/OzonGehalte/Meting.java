package Week3.OzonGehalte;

public class Meting {
    
    private String naam;
    private double ozonGehalte;
    
    public Meting(String naam, double ozonGehalte){
        this.naam = naam;
        this.ozonGehalte = ozonGehalte;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public double getOzonGehalte(){
        return ozonGehalte;
    }
}
