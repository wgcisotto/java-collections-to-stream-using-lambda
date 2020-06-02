package com.wgcisotto;

import com.wgcisotto.model.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayWithMaps {

    public static void main(String[] args) {

        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);
        Person jamesBis = new Person("James", 26);

        Map<String, Person> people = new HashMap<>();
        
        people.put("A", mary);
        people.put("B", john);
        people.put("C", linda);
        people.put("D", james);
        people.put("E", jamesBis);

        printMap(people);

        System.out.println(people.getOrDefault("W", new Person("Default", 0)));
        System.out.println();

        people.replace("A", new Person("new Person", 0));

        people.replace("B", john, jamesBis);
        people.replace("B", john, linda); //wont replace because the second argument its not the real value of B

        printMap(people);

        people.replaceAll((key, value) -> {
            value.setName(value.getName() + "_REPLACED");
            return value;
        } );

        printMap(people);

        mergeSample();

        people.computeIfAbsent("W", key -> new Person("William", 28));

        printMap(people);
    }

    private static void printMap(Map<String, Person> people){
        people.forEach((key, value)-> {
            System.out.println("Key of person: " + key +
                    " Person: " + value);
        });
        System.out.println();
    }

    private static void mergeSample(){
        Map<String, List<Person>> map1 = new HashMap<>();
        Map<String, List<Person>> map2 = new HashMap<>();
        map2.put("SP", Arrays.asList(new Person("Person to merge", 0)));

        map1.forEach((k,v)-> {
            System.out.println("Key: " + k + " value: " + v);
        });

        map2.forEach((key, value) ->
            map1.merge(key, value, (existingValueMap1, newValueMap2) -> {
                            existingValueMap1.addAll(newValueMap2);
                            return existingValueMap1;
                        }
                    )
        );

        map1.forEach((k,v)-> {
            System.out.println("Key: " + k + " value: " + v);
        });
    }
    
}
