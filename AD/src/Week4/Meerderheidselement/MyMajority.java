package Week4.Meerderheidselement;

public class MyMajority implements Majority{
    @Override
    public int findMajority(Sequence numbers) {

        int size = numbers.size();

        // 1 element
        if(size == 1) return numbers.get(0);

        // meer dan 1 element: opsplitsen
        Sequence seq1 = numbers.subSequence(0, size / 2);
        Sequence seq2 = numbers.subSequence(size/2, size);
        int m1 = findMajority(seq1);
        int m2 = findMajority(seq2);

        // zelfde majority
        if (m1 == m2) return m1;

        // verschillende majority

        // tel hoeveel major1 voorkomt
        if (m1 != -1) {
            if (countFrequencyOfNumber(m1, seq1, seq2) > size/2) return m1;
        }

        // tel hoeveel major2 voorkomt
        if (m2 != -1) {
            if (countFrequencyOfNumber(m2, seq1, seq2) > size/2) return m2;
        }

        return -1;
    }

    int countFrequencyOfNumber(int num, Sequence s1, Sequence s2) {
        int freq = 0;
        for (int i = 0; i < s1.size(); i++) {
            if (s1.get(i) == num) freq++;
        }
        for (int i = 0; i < s2.size(); i++) {
            if (s2.get(i) == num) freq++;
        }
        return freq;
    }


}
