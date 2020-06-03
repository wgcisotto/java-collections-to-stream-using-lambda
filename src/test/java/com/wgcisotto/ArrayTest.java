package com.wgcisotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

    @Test
    void testSumItemsInArray(){
        Random r = new Random();

        int a = r.nextInt(32);
        System.out.println(a);

        int b = r.nextInt(32);
        System.out.println(b);

        int[] ar = {a,b};

        simpleArraySum(ar);

    }

    static int simpleArraySum(int[] ar) {
        final int sum = Arrays.stream(ar).sum();
        System.out.println(sum);
        return sum;
    }


}
