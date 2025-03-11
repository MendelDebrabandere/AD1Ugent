package Inleiding2.Driesomprobleem;

import java.util.List;

public class MijnDrieSomProbleem implements DrieSomProbleem{
    @Override
    public TripletIndices zoekNulSomTriplet(List<Integer> gesorteerdeInvoer) {



        for (int i = 0; i < gesorteerdeInvoer.size() - 2; i++) {
            int p = i + 1;
            int q = gesorteerdeInvoer.size() - 1;

            while (p != q) {
                int result = gesorteerdeInvoer.get(p) + gesorteerdeInvoer.get(q);
                int ival = gesorteerdeInvoer.get(i);
                if (result == -ival) return new TripletIndices(i, p, q);
                else if (result < -ival) p++;
                else if (result > -ival) q--;
            }
        }

        return null;
    }
}
