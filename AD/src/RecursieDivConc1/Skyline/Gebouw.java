
public class Gebouw {

    private final int l, r, h;

    public Gebouw(int l, int r, int h) {
        this.l = l;
        this.r = r;
        this.h = h;
    }

    public int getL() {
        return l;
    }

    public int getR() {
        return r;
    }

    public int getH() {
        return h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gebouw gebouw = (Gebouw) o;

        if (l != gebouw.l) return false;
        if (r != gebouw.r) return false;
        return h == gebouw.h;

    }

    @Override
    public int hashCode() {
        int result = l;
        result = 31 * result + r;
        result = 31 * result + h;
        return result;
    }

    @Override
    public String toString() {
        return String.format("new Gebouw(%d,%d,%d)", l, r, h);
    }

}
