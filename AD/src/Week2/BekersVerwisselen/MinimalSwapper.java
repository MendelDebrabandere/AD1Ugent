package Week2.BekersVerwisselen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimalSwapper implements Swapper{
    @Override
    public int minimalNumberOfSwaps(List<Integer> start, List<Integer> goal) {

        int numberOfSwaps = 0;

        ArrayList<Integer> workList = new ArrayList<Integer>(start);

        for (int i = 0; i < workList.size(); i++) {
            if (!workList.get(i).equals(goal.get(i))) {
                int bestSwapIdx = findBestSwapIdx(i, workList, goal);
                if (bestSwapIdx == -1) return -1;
                else {
                    Collections.swap(workList, i, bestSwapIdx);
                    numberOfSwaps++;
                    i--; // i must stay the same in case the newly placed cup at idx i is also in the wrong spot
                }
            }
        }

        return numberOfSwaps;
    }



    private int findBestSwapIdx(int i, List<Integer> working, List<Integer> goal) {

        int cupColor = working.get(i);

        // look for the best optimal swap that would fix 2 birds with one stone
        for (int j = i+1; j < goal.size(); j++) {
            if (goal.get(j).equals(cupColor) && goal.get(i).equals(working.get(j))) return j;
        }

        // if thats not found, look for a normal swap that at least would put 1 cup in the right spot
        for (int j = i+1; j < goal.size(); j++) {
            if (goal.get(j).equals(cupColor) && !working.get(j).equals(cupColor)) return j;
        }

        // no swap found that would fix the cup at idx i
        return -1;
    }
}
