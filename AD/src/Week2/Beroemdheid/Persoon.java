package Week2.Beroemdheid;

import java.util.HashSet;
import java.util.Set;

public class Persoon {

    private final Set<Persoon> kennissen;

    public Persoon(){
        kennissen = new HashSet<>();
    }

    public boolean kent(Persoon p){
        return kennissen.contains(p);
    }

    public void registreerKennis(Persoon p){
        kennissen.add(p);
    }

}
