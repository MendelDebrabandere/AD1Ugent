package Sorteer.ShellSort;

public class ShellSorteerder implements Sorteerder{

    private final int[] incrementreeks;

    public ShellSorteerder(int[] incrementreeks) {
        this.incrementreeks = incrementreeks;
    }


    @Override
    public void sorteer(Tabel tabel) {

        // voor elke increment
        for (int i = incrementreeks.length - 1; i >= 0; i--) {
            int increment = incrementreeks[i];

            // voor elke subrij met die increment
            for (int offset = 0; offset < increment; offset++) {

                // bubble sort de subrij
                // Doe dit n keer
                for (int j = 0; j < tabel.size(); j++) {
                    boolean isSorted = true;
                    // voor elk element dat nog niet gesorteerd is op einde
                    for (int idx = offset; idx < tabel.size() - increment - j; idx += increment) {
                        // swap if needed
                        if (tabel.get(idx) > tabel.get(idx+increment)) {
                            tabel.swap(idx, idx+increment);
                            isSorted = false;
                        }
                    }
                    if (isSorted) break;
                }
            }

        }


    }
}
