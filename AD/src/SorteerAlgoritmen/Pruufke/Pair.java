
public class Pair {

    private final Matcher.Jar jar;
    private final Matcher.Lid lid;

    public Pair(Matcher.Jar jar, Matcher.Lid lid) {
        this.jar = jar;
        this.lid = lid;
    }

    public Matcher.Jar getJar() {
        return jar;
    }

    public Matcher.Lid getLid() {
        return lid;
    }

    public String toString() {
        return String.format("(%s,%s)", jar, lid);
    }

    public boolean equals(Object o) {
        if(!(o instanceof Pair)) return false;
        if(o == this) return true;

        Pair that = (Pair) o;
        // should be ==, not equals!
        return this.jar == that.jar && this.lid == that.lid;
    }

}
