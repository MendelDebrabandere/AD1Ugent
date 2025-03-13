package SorteerAlgoritmen.SortingDishes;

import java.util.LinkedList;
import java.util.List;

public class MyTripleSorter implements TripleSorter{
    @Override
    public List<Dish> sorteer(List<Dish> list, Evaluator evaluator) {

        List<Dish> sortedList = new LinkedList<>();
        int m = evaluator.middleOf(list.get(0), list.get(1), list.get(2));
        sortedList.add(list.get((m+1)%3)); // first
        sortedList.add(list.get(m));
        sortedList.add(list.get((m+2)%3)); // last

        for (int dishIdx = 3; dishIdx < list.size(); dishIdx++) {
            Dish dish = list.get(dishIdx);

            for (int sortedIdx = 0; sortedIdx < sortedList.size() - 1 ; sortedIdx++) {

                int middle = evaluator.middleOf(dish, sortedList.get(sortedIdx), sortedList.get(sortedIdx+1));

                if (middle == 0) {
                    sortedList.add(sortedIdx+1, dish);
                    break;
                } else if (sortedIdx == 0 && middle == 1) {
                    sortedList.addFirst( dish);
                    break;
                } else if (sortedIdx == sortedList.size()-2) {
                    sortedList.addLast(dish);
                    break;
                }

            }
        }

        return sortedList;
    }
}
