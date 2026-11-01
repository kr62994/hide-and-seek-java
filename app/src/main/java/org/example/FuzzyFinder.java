package org.example;

import java.util.ArrayList;

public class FuzzyFinder {
    private static final String GOLD = "gold";

    public int linearSearch(ArrayList<Fuzzy> fuzzies) {
        for (int i = 0; i < fuzzies.size(); i++) {
            if (GOLD.equals(fuzzies.get(i).color)) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(ArrayList<Fuzzy> fuzzies) {
        int low = 0;
        int high = fuzzies.size() - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int comparison = fuzzies.get(middle).color.compareTo(GOLD);

            if (comparison == 0) {
                return middle;
            } else if (comparison < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
