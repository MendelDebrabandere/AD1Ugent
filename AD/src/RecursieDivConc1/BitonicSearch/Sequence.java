import java.util.Arrays;

public class Sequence {

    private int[] numbers;

    public Sequence(int... numbers) {
        this.numbers = numbers;
    }

    public int size() {
        return numbers.length;
    }

    public int get(int index) {
        return numbers[index];
    }

    @Override
    public String toString(){
        return Arrays.toString(numbers);
    }

}

