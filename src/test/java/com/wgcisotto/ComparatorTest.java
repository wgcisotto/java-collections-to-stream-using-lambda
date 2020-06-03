package com.wgcisotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ComparatorTest {

    @Test
    void solvingProblemUsingComparator(){
        List<Integer> a = Arrays.asList(17,28,30);
        List<Integer> b = Arrays.asList(99,16,8);
        System.out.println(compareTriplets(a, b));
    }

    private static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        Integer alice = 0;
        Integer bob = 0;
        for (int i = 0; i < a.size(); i++ ){
            if (a.get(i) > b.get(i)) {
                alice++;
            } else if (a.get(i) != b.get(i)){
                bob++;
            }
        };
        return Arrays.asList(alice,bob);
    }

}
