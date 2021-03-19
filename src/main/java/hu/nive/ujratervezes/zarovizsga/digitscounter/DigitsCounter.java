package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (isBlankOrNull(s)) {
            return 0;
        }
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 47 && s.charAt(i) < 58) {
                result.add(s.charAt(i));
            }
        }
        return result.size();
    }

    private boolean isBlankOrNull(String str) {
        return (str == null || str.isBlank());
    }
}
