package RecursieDivConc.MaximumInCirculairVerschovenRij;

import java.util.Arrays;

public class MijnMaximumBepaler implements MaximumBepaler{
    @Override
    public int bepaalMaximum(int... rij) {

        if (rij.length == 0) {
            throw new IllegalArgumentException("lege lijst");
        }
        if (rij.length == 1) return rij[0];

        int middenste = rij[rij.length / 2];

        if (middenste < rij[rij.length / 2 - 1]) {
            return rij[rij.length / 2 - 1];
        }

        if (middenste < rij[0]) // ga naar links
            return bepaalMaximum(Arrays.copyOfRange(rij,0,rij.length / 2));

        else if (middenste > rij[rij.length-1]) // ga naar rechts
            return bepaalMaximum(Arrays.copyOfRange(rij,rij.length / 2,rij.length));



        else return rij[rij.length-1]; // k = 0, staat mooi gesorteerd

    }
}
