package SorteerAlgoritmen.SortingDishes;

public interface Evaluator {

    /*
    Compare three items.
    Will return 0, 1 or 2, if respectively x0, x1 or x2 is the middle element of the three provided.
    Comparing equal elements is undefined.
     */
    int middleOf(Dish x0, Dish x1, Dish x2);
}
