package Week3.EerstDubbelZoeken;

import java.util.HashMap;

public class MijnEersteDubbel implements EersteDubbel{
    @Override
    public int eersteDubbel(int[] rij) {

        HashMap<Integer, Integer> occurences = new HashMap<>();

        // init de map met alle values van de rij
        for (int getal : rij) {
            occurences.put(getal, occurences.getOrDefault(getal, 0) + 1);
        }

        // zoek de eerste dubbele waarde
        for (int getal : rij) {
            if (occurences.get(getal) >= 2) {
                return getal;
            }
        }

        return -1;
    }
}
