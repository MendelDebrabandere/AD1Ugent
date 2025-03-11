package Datastructuren.StapelsAfbreken;

import java.util.*;

public class GreedyStackSmasher implements StackSmasher {

    private final int n; // number of stacks
    private final int h; // max stack height

    private final Map<Integer, LinkedList<String>> stacks;
    private final Map<String, Integer> playerScores;
    private final TreeMap<Integer, Set<Integer>> heightToStacks; // (hoogte -> lijst van stapelIndices)

    public GreedyStackSmasher(int n, int h) {
        this.n = n;
        this.h = h;

        stacks = new HashMap<>();
        playerScores = new HashMap<>();
        heightToStacks = new TreeMap<>(Collections.reverseOrder()); // Zorgt ervoor dat hoogste eerst komt
    }

    @Override
    public void registerMove(int tower, String player) {
        stacks.putIfAbsent(tower, new LinkedList<>());

        LinkedList<String> stack = stacks.get(tower);
        int prevSize = stack.size();
        stack.add(player);

        playerScores.putIfAbsent(player, 0);
        playerScores.put(player, playerScores.get(player) + stack.size());

        // Update hoogte mapping
        updateHeightMapping(tower, prevSize, stack.size());
    }

    @Override
    public int destructHighest() {
        if (heightToStacks.isEmpty()) return -1;

        // Haal de hoogste stapel eruit
        int highestHeight = heightToStacks.firstKey();
        Iterator<Integer> it = heightToStacks.get(highestHeight).iterator();
        int hIdx = it.next();
        it.remove(); // Verwijder de stapel uit de set

        // Verwijder de entry als de set leeg is
        if (heightToStacks.get(highestHeight).isEmpty()) {
            heightToStacks.remove(highestHeight);
        }

        // Reduceer spelerscores
        LinkedList<String> stack = stacks.remove(hIdx);
        for (int i = 0; i < stack.size(); i++) {
            String player = stack.get(i);
            playerScores.put(player, playerScores.get(player) - (i + 1));
        }

        return hIdx;
    }

    @Override
    public int score(String player) {
        return playerScores.getOrDefault(player, -1);
    }

    // Helper methode om hoogte-mapping efficiënt te updaten
    private void updateHeightMapping(int tower, int oldHeight, int newHeight) {
        if (oldHeight > 0) {
            heightToStacks.get(oldHeight).remove(tower);
            if (heightToStacks.get(oldHeight).isEmpty()) {
                heightToStacks.remove(oldHeight);
            }
        }
        heightToStacks.putIfAbsent(newHeight, new HashSet<>());
        heightToStacks.get(newHeight).add(tower);
    }
}
