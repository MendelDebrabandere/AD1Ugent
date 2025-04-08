package Stapels.GrootteVanHaakjes;

import java.util.EmptyStackException;
import java.util.Stack;

public class MySizeCalculator implements SizeCalculator {
    @Override
    public int[] calculateSize(boolean[] opening) {

        int[] result = new int[opening.length];
        Stack<Integer> prevIndices = new Stack<>();
        Stack<Integer> depth = new Stack<>();

        for (int i = 0; i < opening.length; ++i) {

            if (opening[i]) {
                depth.push(0);
                prevIndices.push(i);
            } else {
                int d = depth.pop();
                result[i] = d;
                result[prevIndices.pop()] = d;
                int e = 0;
                try {
                    e = depth.pop();
                } catch (EmptyStackException except) {
                    System.out.println(except.getMessage());
                }
                depth.push(Math.max(e, d+1));
            }

        }

        return result;
    }

}

