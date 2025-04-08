package Sorteer.CountingInversions;

public class MyInversionCounter implements InversionCounter {

    private int inversions = 0;

    @Override
    public int countInversions(int[] rij) {
        inversions = 0;
        mergeSort(rij);
        return inversions;
    }

    private void mergeSort(int[] list) {
        if (list.length <= 1) return;

        // Split into left and right subarrays
        int mid = list.length / 2;
        int[] left = new int[mid];
        int[] right = new int[list.length - mid];
        System.arraycopy(list, 0, left, 0, mid);
        System.arraycopy(list, mid, right, 0, list.length - mid);

        // Recursively sort subarrays
        mergeSort(left);
        mergeSort(right);

        // Merge and count inversions
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                list[k++] = left[i++];
            } else {
                list[k++] = right[j++];
                inversions += left.length - i;
            }
        }

        // Copy remaining elements
        while (i < left.length) list[k++] = left[i++];
        while (j < right.length) list[k++] = right[j++];
    }
}