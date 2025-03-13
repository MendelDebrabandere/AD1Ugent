package SorteerAlgoritmen.CountingInversions;

import java.util.ArrayList;
import java.util.List;

public class MyInversionCounter implements InversionCounter{

    private int inversions = 0;

    @Override
    public int countInversions(int[] rij) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int e : rij) {
            list.add(e);
        }

        mergeSort(list);


        return inversions;
    }

    public List<Integer> mergeSort(List<Integer> list) {

        // base case
        if (list.size() == 1) return list;

        // sort 2 sublists
        List<Integer> list1 = mergeSort(list.subList(0, list.size()/2));
        List<Integer> list2 = mergeSort(list.subList(list.size()/2,list.size()));

        // merge
        List<Integer> sorted = new ArrayList<Integer>();

        while (!list1.isEmpty() || !list2.isEmpty()) {

            if (list1.isEmpty()) {
                sorted.add(list2.removeFirst());
                inversions += list2.size();
            } else if (list2.isEmpty()) {
                sorted.add(list1.removeFirst());
            } else if (list1.getFirst() <= list2.getFirst()) {
                sorted.add(list1.removeFirst());
            } else if (list1.getFirst() > list2.getFirst()) {
                sorted.add(list2.removeFirst());
                inversions += list2.size();
            }

        }


        return sorted;

    }


}
