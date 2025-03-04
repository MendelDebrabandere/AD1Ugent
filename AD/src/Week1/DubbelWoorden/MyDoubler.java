package Week1.DubbelWoorden;

import java.util.ArrayList;

public class MyDoubler implements Doubler {
    @Override
    public boolean isDouble(String str) {

        String newstr = str.toLowerCase();

        ArrayList<Character> checkedChars = new ArrayList<Character>();

        for (int i = 0; i < newstr.length(); i++) {
            char ch = newstr.charAt(i);

            if (!checkedChars.contains(ch)) {
                String substr1 = newstr.substring(i+1);
                int secondidx = substr1.indexOf(ch);
                if (secondidx == -1)
                    return false;
                String substr2 = newstr.substring(secondidx+i+2);
                if (substr2.indexOf(ch) != -1)
                    return false;

                checkedChars.add(ch);
            }
        }

        return true;
    }
}
