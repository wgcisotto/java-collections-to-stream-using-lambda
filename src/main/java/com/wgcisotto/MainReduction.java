package com.wgcisotto;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainReduction {

    private static int reduce(List<Integer> values,
                              int valueIfEmpty,
                              BinaryOperator<Integer> reduction) {

        int result = valueIfEmpty;
        for (int value: values) {
            result = reduction.apply(result, value);
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        // above simulating the multi core operation
        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);

        BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
        BinaryOperator<Integer> max = (i1, i2) -> Integer.max(i1, i2);

        BinaryOperator<Integer> otherOperation = (i1, i2) -> (i1 + i2) * (i1 + i2); // non associative

        int reductionSum =  reduce(ints, 0, sum);
        int reductionMax =  reduce(ints, 0, max);
        int reductionNotAssociative =  reduce(ints, 0, otherOperation);

        System.out.println("Reduction SUM: " + reductionSum);
        System.out.println("Reduction MAX: " + reductionMax);
        System.out.println("Reduction not Associative: " + reductionNotAssociative);

        System.out.println("\nIn parallel: \n");

        int reduction1 = reduce(ints1, 0, sum);
        int reduction2 = reduce(ints2, 0, sum);
        int reduction3 = reduce(Arrays.asList(reduction1, reduction2), 0, sum);

        reduction1 = reduce(ints1, 0, max);
        reduction2 = reduce(ints2, 0, max);
        int reduction4 = reduce(Arrays.asList(reduction1, reduction2), 0, max);

        reduction1 = reduce(ints1, 0, otherOperation);
        reduction2 = reduce(ints2, 0, otherOperation);
        int reduction5 = reduce(Arrays.asList(reduction1, reduction2), 0, otherOperation);

        System.out.println("Reduction in SUM: " + reduction3);
        System.out.println("Reduction in MAX: " + reduction4);
        System.out.println("Reduction no Associative: " + reduction5);


    }

}
