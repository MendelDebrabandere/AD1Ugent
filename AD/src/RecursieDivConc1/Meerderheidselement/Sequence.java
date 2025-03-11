package RecursieDivConc1.Meerderheidselement;

import java.util.Arrays;

public class Sequence {

    protected final int[] numbers;
    protected final int start;
    protected final int stop;

    public Sequence(int... numbers) {
        this.numbers = numbers;
        this.start = 0;
        this.stop = numbers.length;
    }

    protected Sequence(int[] numbers, int start, int stop) {
        this.numbers = numbers;
        this.start = start;
        this.stop = stop;
    }

    public int size() {
        return stop - start;
    }

    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return numbers[this.start + index];
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOfRange(numbers, start, stop));
    }

    public Sequence subSequence(int start, int stop) {
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException();
        }
        return new Sequence(numbers, this.start + start, this.start + stop);
    }


}


