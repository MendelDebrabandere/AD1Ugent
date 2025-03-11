package Inleiding2.Feestje;

import java.util.List;

public class MyParty implements Party{
    @Override
    public boolean check(List<Interval> helpers, int start, int stop) {

        helpers.sort(Interval::compareTo);

        int gooduntil = start;

        for (Interval helper : helpers) {
            if (helper.getStart() <= gooduntil && helper.getStop() >= gooduntil) {
                gooduntil = helper.getStop();
            }
        }

        return gooduntil >= stop;
    }
}
