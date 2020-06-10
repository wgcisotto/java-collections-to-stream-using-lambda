package com.wgcisotto;

import com.wgcisotto.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayWithStream {

    public static void main(String[] args) {

        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);
        Person jamesBis = new Person("James", 26);

        List<Person> people = new ArrayList(Arrays.asList(mary, john, linda, james, jamesBis));

        people.stream()
                .peek(System.out::println)
                .filter(p -> p.getAge() > 30)
                .forEach(System.out::println);

        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);

        Stream<Integer> stream1 = ints.stream();
        Stream<Integer> stream2 = Stream.of(0,1,2,3,4);

        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);

        Stream<String> streamOfStrings = Stream.generate(()-> "one");
        streamOfStrings.limit(5).forEach(System.out::println);

        Stream<String> streamOfStrings2 = Stream.iterate("+", s -> s + "+");
        streamOfStrings2.limit(20).forEach(System.out::println);

        IntStream streamOfInt = ThreadLocalRandom.current().ints();
        streamOfInt.limit(5).forEach(System.out::println);





    }

}
