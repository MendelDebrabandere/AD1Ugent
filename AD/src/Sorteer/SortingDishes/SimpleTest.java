package Sorteer.SortingDishes;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTest {

    @Test
    public void test1(){
        ArrayList<Dish> dishes = Stream.of("Kaas", "Appel", "Spaghetti", "Brood", "Yoghurt", "Rijst")
                .map(SimpleDish::new).collect(Collectors.toCollection(ArrayList::new));

        TripleSorter sorteerder = new MyTripleSorter();
        List<Dish> gesorteerd = sorteerder.sorteer(new ArrayList<>(dishes), new AlphabeticEvaluator());

        dishes.sort(Comparator.comparing(Dish::name));
        Assert.assertTrue("Wrong order: expected " + dishes + " or its reverse, but was " + gesorteerd,
                gesorteerd.equals(dishes) || gesorteerd.equals(dishes.reversed()));
    }


    @Test
    public void test2(){
        ArrayList<Dish> dishes = Stream.of("Pudding", "Zalm", "Linzen", "Kwark", "Puree", "Ravioli", "Pesto", "Mozarella")
                .map(SimpleDish::new).collect(Collectors.toCollection(ArrayList::new));

        TripleSorter sorteerder = new MyTripleSorter();
        List<Dish> gesorteerd = sorteerder.sorteer(new ArrayList<>(dishes), new AlphabeticEvaluator());

        dishes.sort(Comparator.comparing(Dish::name));
        Assert.assertTrue("Wrong order: expected " + dishes + " or its reverse, but was " + gesorteerd,
        gesorteerd.equals(dishes) || gesorteerd.equals(dishes.reversed()));
    }


    @Test
    public void test3(){
        ArrayList<Dish> dishes = Stream.of("Wijn", "Abrikoos", "Taart", "Boomschors", "Schnitzel", "Erwten", "Pastinaak", "Zetmeel", "Tomaat", "Roomsoep")
                .map(SimpleDish::new).collect(Collectors.toCollection(ArrayList::new));

        TripleSorter sorteerder = new MyTripleSorter();
        List<Dish> gesorteerd = sorteerder.sorteer(new ArrayList<>(dishes), new AlphabeticEvaluator());

        dishes.sort(Comparator.comparing(Dish::name));
        Assert.assertTrue("Wrong order: expected " + dishes + " or its reverse, but was " + gesorteerd,
                gesorteerd.equals(dishes) || gesorteerd.equals(dishes.reversed()));
    }


    @Test
    public void test4(){
        ArrayList<Dish> dishes = Stream.of("K", "E", "L", "M", "X", "G", "C", "S", "Y", "R", "W", "A", "B", "V", "T", "I", "Q", "N", "P", "Z", "F", "H", "U", "O", "D", "J")
                .map(SimpleDish::new).collect(Collectors.toCollection(ArrayList::new));

        TripleSorter sorteerder = new MyTripleSorter();
        List<Dish> gesorteerd = sorteerder.sorteer(new ArrayList<>(dishes), new AlphabeticEvaluator());

        dishes.sort(Comparator.comparing(Dish::name));
        Assert.assertTrue("Wrong order: expected " + dishes + " or its reverse, but was " + gesorteerd,
                gesorteerd.equals(dishes) || gesorteerd.equals(dishes.reversed()));
    }


    //Let op: enkel de SimpleTest maakt gebruik van alfabetische evaluatie!
    private static class AlphabeticEvaluator implements Evaluator{
        public int middleOf(Dish x0, Dish x1, Dish x2) {
            if (x0.name().compareTo(x1.name()) * x0.name().compareTo(x2.name()) < 0) {
                return 0;
            }
            if (x1.name().compareTo(x2.name()) * x1.name().compareTo(x0.name()) < 0) {
                return 1;
            }else{
                return 2;
            }
        }
    }

    private static class SimpleDish implements Dish {
        private final String name;

        public SimpleDish(String name) {
            this.name = name;
        }

        public String name(){
            return name;
        }

        @Override
        public String toString() {
            return name();
        }
    }

}
