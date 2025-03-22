package SorteerAlgoritmen.SortingDishes;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyTripleSorter implements TripleSorter{
    @Override
    public List<Dish> sorteer(List<Dish> list, Evaluator evaluator) {
        LinkedList<Dish> sortedList = new LinkedList<>();
        // Initialize the first 3 elements
        int m = evaluator.middleOf(list.get(0), list.get(1), list.get(2));
        sortedList.add(list.get((m + 1) % 3)); // First
        sortedList.add(list.get(m));           // Middle
        sortedList.add(list.get((m + 2) % 3)); // Last

        for (int dishIdx = 3; dishIdx < list.size(); dishIdx++) {
            Dish dish = list.get(dishIdx);
            boolean inserted = false;
            ListIterator<Dish> iterator = sortedList.listIterator();
            Dish prev = iterator.hasNext() ? iterator.next() : null;

            while (iterator.hasNext()) {
                Dish current = iterator.next();
                int middle = evaluator.middleOf(dish, prev, current);

                if (middle == 0) {
                    // Insert between prev and current
                    iterator.previous(); // Move back to "current"
                    iterator.add(dish);
                    inserted = true;
                    break;
                } else if (middle == 1) {
                    // Dish is smaller than the first element
                    sortedList.addFirst(dish);
                    inserted = true;
                    break;
                }
                prev = current; // Move to next pair
            }

            if (!inserted) {
                // Add to the end if not inserted yet
                sortedList.addLast(dish);
            }
        }

        return sortedList;
    }


}
