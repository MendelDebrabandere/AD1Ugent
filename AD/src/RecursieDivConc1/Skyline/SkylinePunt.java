
public class SkylinePunt {

    private final int x, h;

    public SkylinePunt(int x, int h) {
        this.x = x;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getH() {
        return h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkylinePunt that = (SkylinePunt) o;

        if (x != that.x) return false;
        return h == that.h;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + h;
        return result;
    }

    @Override
    public String toString() {
        return String.format("new SkylinePunt(%d, %d)", x, h);
    }

}
