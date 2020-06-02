package com.wgcisotto;

import com.wgcisotto.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PlayWithArrays {

    public static void main(String[] args) {

        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);
        Person jamesBis = new Person("James", 26);

        List<Person> people = new ArrayList<>();
//                new ArrayList(Arrays.asList(mary, john, linda, james, jamesBis));

        people.add(mary);
        people.add(john);
        people.add(linda);
        people.add(james);
        people.add(jamesBis);

        people.sort((java.util.Comparator
                .comparing(Person::getName)
                .thenComparing(Person::getAge)));

        people.forEach(System.out::println);

        people.removeIf(p -> p.getAge() > 27);

        System.out.println();

        people.forEach(System.out::println);

        people.replaceAll((p) -> new Person("Outro nome qualquer", p.getAge()));

        System.out.println();

        people.forEach(System.out::println);

    }

}
