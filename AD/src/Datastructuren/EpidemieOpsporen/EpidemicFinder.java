package Datastructuren.EpidemieOpsporen;

import java.util.Collection;
import java.util.List;

public interface EpidemicFinder {

    public Collection<String> findEpidemics(List<Diagnosis> diagnoses, int k, int n);

}
