package com.wgcisotto;

import com.wgcisotto.model.Person;

import java.util.*;

public class PlayWithMapFilterReduce {

    public static void main(String[] args) {

        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);
        Person jamesBis = new Person("James", 26);

        List<Person> people = Arrays.asList(mary, john, linda, james, jamesBis);

        final double average = people.stream()
                .mapToInt(p -> p.getAge())
                .filter(age -> age > 30)
                .average()
                .getAsDouble();

        System.out.println(average);

        final IntSummaryStatistics summary = people.stream()
                .mapToInt(p -> p.getAge())
                .filter(age -> age > 20)
                .summaryStatistics();


        System.out.println(summary);


    }

}
