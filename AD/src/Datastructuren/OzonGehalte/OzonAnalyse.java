package Datastructuren.OzonGehalte;

import java.util.Collection;
import java.util.List;


public interface OzonAnalyse {
    
    public Collection<String> risicoGebieden(List<Meting> metingen, int k, double kritischeWaarde);
    
}
