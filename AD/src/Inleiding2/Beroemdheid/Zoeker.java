package Inleiding2.Beroemdheid;

import java.util.List;

public interface Zoeker {

    /**
     * Spoort een beroemdheid op in de gegeven groep personen.
     * Als er geen beroemdheid is, geeft deze methode <code>null</code> terug.
     *
     * @param groep lijst met personen
     * @return beroemd persoon, als deze bestaat; anders <code>null</code>
     */
    public Persoon zoekBeroemdheid(List<Persoon> groep);

}
