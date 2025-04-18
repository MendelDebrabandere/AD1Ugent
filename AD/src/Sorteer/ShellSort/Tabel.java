package Sorteer.ShellSort;

import java.util.Arrays;

public class Tabel {

    private final int[] tabel;

    public Tabel(int[] tabel) {
        this.tabel = tabel;
    }

    public int size() {
        return tabel.length;
    }

    public int get(int index) {
        return tabel[index];
    }

    public void swap(int i, int j) {
        int swapValue = tabel[i];
        tabel[i] = tabel[j];
        tabel[j] = swapValue;
    }

    @Override
    public String toString() {
        return Arrays.toString(tabel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tabel tabel1 = (Tabel) o;

        return Arrays.equals(tabel, tabel1.tabel);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tabel);
    }

}

