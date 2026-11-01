package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FuzzyFinderTest {
    private FuzzyFinder finder;
    private FuzzyListGenerator generator;

    @BeforeEach
    void setUp() {
        finder = new FuzzyFinder();
        generator = new FuzzyListGenerator();
    }

    @Test
    void linearSearchFindsGoldInSortedList() {
        ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();

        assertEquals(1000, finder.linearSearch(fuzzies));
    }

    @Test
    void binarySearchFindsGoldInSortedList() {
        ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();

        assertEquals(1000, finder.binarySearch(fuzzies));
    }


    @Test
    void searchesReturnMinusOneWhenGoldIsAbsent() {
        ArrayList<Fuzzy> fuzzies = new ArrayList<>(List.of(
                new Fuzzy("blue"), new Fuzzy("green"), new Fuzzy("red")));

        assertEquals(-1, finder.linearSearch(fuzzies));
        assertEquals(-1, finder.binarySearch(fuzzies));
    }

    @Test
    void searchesFindSingleGoldFuzzy() {
        ArrayList<Fuzzy> fuzzies = new ArrayList<>(List.of(new Fuzzy("gold")));

        assertEquals(0, finder.linearSearch(fuzzies));
        assertEquals(0, finder.binarySearch(fuzzies));
    }
}