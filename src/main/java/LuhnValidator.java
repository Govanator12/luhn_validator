import java.util.ArrayList;

public class LuhnValidator {

    public LuhnValidator() {
    }

    boolean isValid(String candidate) {

        ArrayList<Integer> newNumber = new ArrayList<>();

        for (int i = 0; i < candidate.length(); i++) {

            if (Character.isDigit(candidate.charAt(i))) {
                newNumber.add(Character.getNumericValue(candidate.charAt(i)));
            } else if (candidate.charAt(i) == ' '){
                continue;
            } else {
                return false;
            }
        }

        if (newNumber.size() <= 1) {
            return false;
        }

        int finalSum = 0;
        int loopNumber = 1;

        for (int i = newNumber.size() - 1; i >= 0; i--) {
            int n = newNumber.get(i);

            if (loopNumber % 2 == 0) {
                n *= 2;

                if (n > 9) {
                    n -= 9;
                }
            }

            finalSum += n;
            loopNumber++;
        }

        if (finalSum % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
