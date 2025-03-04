package Week2.ZoekenInGesorteerdeTabel;

public class MijnTabelControle implements TabelControle{
    @Override
    public boolean controleer(int[][] matrix, int x) {

        final int m = matrix.length;
        final int n = matrix[0].length;

        int i = 0;
        int j = n-1;

        while (i < m && j >= 0) {
            if (x > matrix[i][j]) i++;
            else if (x < matrix[i][j]) j--;
            else return true;
        }
        return false;
    }
}
