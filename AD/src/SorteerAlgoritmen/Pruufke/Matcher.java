import java.util.List;

public interface Matcher {

    public List<Pair> match(List<Jar> jars, List<Lid> lids);

    public class Jar implements Comparable<Lid> {
        // Accessible by Lid because both are inner classes of
        // Matcher. Don't try this at home.
        private final int size;

        public Jar(int size) {
            this.size = size;
        }

        @Override
        public int compareTo(Lid lid) {
            return Integer.compare(size, lid.size);
        }

    }

    public class Lid implements Comparable<Jar> {
        // Accessible by Jar because both are inner classes of
        // Matcher. Don't try this at home.
        private final int size;

        public Lid(int size) {
            this.size = size;
        }

        @Override
        public int compareTo(Jar jar) {
            return Integer.compare(size, jar.size);
        }
    }

}
