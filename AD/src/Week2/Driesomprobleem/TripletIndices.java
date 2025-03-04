package Week2.Driesomprobleem;

/**
 * Stelt de indices voor van drie verschillende elementen uit een invoerlijst.
 */
//Deze klasse mag niet gewijzigd worden!
public class TripletIndices {

    private int index0;

    private int index1;

    private int index2;

    public TripletIndices(int index0, int index1, int index2) {
        this.index0 = index0;
        this.index1 = index1;
        this.index2 = index2;

        if(index0 >= index1 || index1 >= index2)
            throw new RuntimeException("Er moet gelden: index0 < index1 < index2!");
    }

    public int getIndex0() {
        return index0;
    }

    public int getIndex1() {
        return index1;
    }

    public int getIndex2() {
        return index2;
    }

    @Override
    public String toString() {
        return "index0=" + index0 + ", index1=" + index1 + ", index2=" + index2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.index0;
        hash = 97 * hash + this.index1;
        hash = 97 * hash + this.index2;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TripletIndices other = (TripletIndices) obj;
        if (this.index0 != other.index0) {
            return false;
        }
        if (this.index1 != other.index1) {
            return false;
        }
        if (this.index2 != other.index2) {
            return false;
        }
        return true;
    }
    

}