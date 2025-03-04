package Week2.Feestje;

public class Interval implements Comparable<Interval> {

    /* Omdat Interval Comparable<Interval> implementeert, zal een interval
     * vergelijkbaar zijn met andere intervallen. Dit geeft mogelijkheid tot
     * het gebruik van een hoop ingebouwde methoden in java. Lees meer in de
     * Java 9 API:
     *
     * - https://docs.oracle.com/javase/9/docs/api/java/lang/Comparable.html
     * - https://docs.oracle.com/javase/9/docs/api/java/util/Collections.html#sort-java.util.List-
     * - https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#sort-java.lang.Object:A-
     */

    private final int start, stop;

    public Interval(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + stop + "]";
    }

    /* De compareTo methode zorgt ervoor dat we dit interval kunnen
     * vergelijken met een ander interval. De methode geeft een getal terug
     * dat kleiner, gelijk of groter dan nul is als dit object respectievelijk
     * kleiner, gelijk of groter is dan het andere object.
     */
    @Override
    public int compareTo(Interval that) {
        return this.start - that.start;
    }

}
