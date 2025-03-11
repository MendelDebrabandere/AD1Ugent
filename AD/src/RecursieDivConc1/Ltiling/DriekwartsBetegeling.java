package RecursieDivConc1.Ltiling;

public class DriekwartsBetegeling implements Betegeling {

    public DriekwartsBetegeling(int k) {
        /* ... */
    }

    public int zijde() {
        /* ... */
        return 0;
    }

    public int tegelnummer(int r, int c) {
        /* ... */
        return 0;
    }

    public void plaatsTegel(int r, int c, int d) {
        /* ... */
    }

    public void betegel(int r, int c) {
        /* ... */
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        String crlf = System.lineSeparator();
        for(int r = 0; r < zijde(); r++) {
            for(int c = 0; c < zijde(); c++) {
                s.append('+');
                if(1 > r || tegelnummer(r - 1, c) != tegelnummer(r, c)) s.append("--");
                else s.append("  ");
            }
            s.append('+');
            s.append(crlf);
            for(int c = 0; c < zijde(); c++) {
                if(1 > c || tegelnummer(r, c - 1) != tegelnummer(r, c)) s.append("|");
                else s.append(" ");
                s.append(String.format("%2d", tegelnummer(r, c) % 100));
            }
            s.append('|');
            s.append(crlf);
        }
        for(int c = 0; c < zijde(); c++) {
            s.append("+--");
        }
        s.append('+');
        s.append(crlf);
        return s.toString();
    }

}
