package Week3.OzonGehalte;

import java.util.*;

public class MijnOzonAnalyse implements OzonAnalyse{
    @Override
    public Collection<String> risicoGebieden(List<Meting> metingen, int k, double kritischeWaarde) {

        HashMap<String, Integer> dagenInRisico = new HashMap<>();

        // map all metingen
        for (Meting meting : metingen) {
            if (meting.getOzonGehalte() > kritischeWaarde) {
                dagenInRisico.put(
                        meting.getNaam(),
                        dagenInRisico.getOrDefault(meting.getNaam(), 0) + 1
                );
            }
        }

        Set<String> kritischeZones = new HashSet<>();
        for (String naam : dagenInRisico.keySet()) {
            if (dagenInRisico.get(naam) > k) {
                kritischeZones.add(naam);
            }
        }

        return kritischeZones;
    }
}
