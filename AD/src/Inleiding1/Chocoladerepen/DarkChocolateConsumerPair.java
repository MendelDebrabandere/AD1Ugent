package Inleiding1.Chocoladerepen;

public class DarkChocolateConsumerPair implements ChocolateConsumerPair {
    @Override
    public int consume(int[] bars) {

        if (bars.length == 0) return 0;

        int bobidx = bars.length - 1;
        int aliceidx = 0;

        int barsEatenByAlice = 0;
        boolean finished = false;

        while (!finished)
        {
            // eat from the bar
            bars[aliceidx]--;
            bars[bobidx]--;

            // if bar is empty, move on
            if (bars[aliceidx] <= 0) {
                aliceidx++;
                barsEatenByAlice++;
                if (aliceidx == bobidx) {
                    finished = true;
                }
            }
            if (bars[bobidx] <= 0) {
                bobidx--;
                if (aliceidx == bobidx) {
                    finished = true;
                    barsEatenByAlice++;
                }
            }

            // end if all is done
            if (aliceidx > bobidx) {
                finished = true;
            }

        }
        return barsEatenByAlice;
    }
}
