package Week3.EpidemieOpsporen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MyEpidemicFinder implements EpidemicFinder{
    @Override
    public Collection<String> findEpidemics(List<Diagnosis> diagnoses, int k, int n) {

        ArrayList<String> epidemics = new ArrayList<>();


        // Key = disease => 2de map: Key = dag, Value = amount
        HashMap<Disease, HashMap<Integer, Integer>> diseases = new HashMap<>();

        int lowestDay = diagnoses.get(0).getDay();
        int highestDay = diagnoses.get(0).getDay();

        // fill up map with data
        for (Diagnosis diagnose : diagnoses) {

            Disease disease = diagnose.getDisease();

            if (!diseases.containsKey(disease)) {
                diseases.put(disease, new HashMap<>());
            }

            int day = diagnose.getDay();

            if (lowestDay > day) lowestDay = day;
            else if (highestDay < day) highestDay = day;

            diseases.get(disease).put(
                    day,
                    diseases.get(disease).getOrDefault(day, 0) + 1
            );


        }


        // find epidemic in map
        for (Disease disease : diseases.keySet()) {

            int currK = 0;

            HashMap<Integer, Integer> currDiseaseMap = diseases.get(disease);

            for (int day = lowestDay; day <= highestDay; day++) {
                if (currDiseaseMap.getOrDefault(day,0) > n) {
                    currK++;
                    if (currK >= k) {
                        epidemics.add(disease.getName());
                        break;
                    }
                }
                else {
                    currK = 0;
                }
            }

        }


        return epidemics;

    }
}
