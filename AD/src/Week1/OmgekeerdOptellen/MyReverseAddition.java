package Week1.OmgekeerdOptellen;

public class MyReverseAddition implements ReverseAddition {
    @Override
    public int add(int a, int b) {
        return omkeren(omkeren(a) + omkeren(b));
    }

    private int omkeren(int input) {
        String getal = Integer.toString(input);
        int rev = 0;
        int inc = 1;
        for (int i = 0; i < getal.length(); i++) {
            rev += (getal.charAt(i) - '0') * inc;
            inc *= 10;
        }
        return rev;
    }
}
