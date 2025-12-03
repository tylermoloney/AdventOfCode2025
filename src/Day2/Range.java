package Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Range {
    public long start;
    public long end;
    public String textRange;

    public Range(String textRange) {
        this.start = Long.parseLong(textRange.split("-")[0]);
        this.end = Long.parseLong(textRange.split("-")[1]);
        this.textRange = textRange;
    }

    public List<Long> getInvalidIds(Range range) {
        List<Long> invalidIds = new ArrayList<>();
        for (long i = range.start; i <= range.end; i++) {
            String current = String.valueOf(i);

//          If a number has an odd number of digits it cannot consist of digits repeated twice
            if (current.length() % 2 != 0) {
                continue;
            }

            if (hasIdenticalHalves(current)) {
                invalidIds.add(i);
            }
        }
        return invalidIds;
    }

    public List<Long> getInvalidIdsPartTwo(Range range) {
        List<Long> invalidIds = new ArrayList<>();
        for (long i = range.start; i <= range.end; i++) {
            String current = String.valueOf(i);
            Set<Integer> factors = getFactors(current.length());

//            Values that have a length that is prime must consist of
//            a single digit repeated for the entire length to be considered invalid

//          Covers values with a length of 1, 2, 3, 5, 7, 11
            if (factors.size() == 1) {
                if (isSingleDigitRepeated(current)) {
                    invalidIds.add(i);
                }
            } else

//            Values with a length of 9 can be invalid if:
//            1) It consists of the same digit repeated entirely i.e. 666666666
//            2) It consists of a trio of digits repeated three times i.e. 123123123
            if (current.length() == 9) {
                if (isSingleDigitRepeated(current) || isTrioRepeated(current)) {
                    invalidIds.add(i);
                }
            } else {
//                Covers values with lengths of 4, 6, 8, 10
                if (isSingleDigitRepeated(current) || isPairRepeated(current) || hasIdenticalHalves(current)) {
                    invalidIds.add(i);
                }
            }
        }
        return invalidIds;
    }

    private Set<Integer> getFactors(int n) {
//        Technically this isn't returning all factors of the int, but we're going to be splitting the values up in increments of their factors
//        in which case, breaking a value up by its entire length is pointless.
        return switch (n) {
            case 1, 2, 3, 5, 7, 11 -> Set.of(1);
            case 4 -> Set.of(1, 2);
            case 6 -> Set.of(1, 2, 3);
            case 8 -> Set.of(1, 2, 4);
            case 9 -> Set.of(1, 3);
            case 10 -> Set.of(1, 2, 5);
            default -> Set.of();
        };
    }

    private boolean isSingleDigitRepeated(String value) {
        return value.matches("(.)\\1+");
    }

    private boolean hasIdenticalHalves(String value) {
        String firstHalf = value.substring(0, (value.length() / 2));
        String secondHalf = value.substring(value.length() / 2);
        return firstHalf.equals(secondHalf);
    }

    private boolean isPairRepeated(String value) {
        String pair = value.substring(0, 2);
        return value.equals(pair.repeat(value.length() / 2));

    }

    private boolean isTrioRepeated(String value) {
        String trio = value.substring(0, 3);
        return value.equals(trio + trio + trio);
    }
}
