package org.concept.streams.ex13;

import java.util.*;
import java.util.stream.Collectors;

public class StreamUserClass {

    private static List<Person> peopleList = new LinkedList<>();

    static {
        peopleList.addAll(
                Arrays.asList(
                        new Person("UserM70", 70, Gender.MALE),
                        new Person("UserF60", 60, Gender.FEMALE),
                        new Person("UserM40", 40, Gender.MALE),
                        new Person("UserF35", 35, Gender.FEMALE),
                        new Person("UserF25", 25, Gender.FEMALE),
                        new Person("UserM30", 30, Gender.MALE),
                        new Person("UserF25", 25, Gender.FEMALE),
                        new Person("UserM20", 20, Gender.MALE),
                        new Person("UserN15", 15, Gender.NA),
                        new Person("UserN10", 10, Gender.NA)
                )
        );
    }

    public static void main(String[] args) {
        doImperativeApproachEx11();
        doDeclarativeApproachEx12();
        doSortFemaleEx13();
        checkComparatorComparingEx13();
        checkMatchEx14();
        doGroupByEx15();
        doOptionalComparatorEx16();
    }

    private static void doImperativeApproachEx11() {
        List<Person> femalesList = new ArrayList<>();
        for (Person person : peopleList) {
            if (person.getGender().equals(Gender.FEMALE)) {
                femalesList.add(person);
            }
        }
        femalesList.forEach(x -> System.out.println(x));
    }

    private static void doDeclarativeApproachEx12() {
        List<Person> females = peopleList.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(x -> System.out.println(x));
    }

    private static void doSortFemaleEx13() {
        List<Person> sorted = peopleList.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getGender)
                        .reversed())
                .collect(Collectors.toList());
        sorted.forEach(x -> System.out.println(x));
    }

    private static void checkComparatorComparingEx13() {
        peopleList.stream()
                .max(Comparator.comparing(Person::getAge)).ifPresent(x -> System.out.println(x));
        peopleList.stream()
                .min(Comparator.comparing(Person::getAge)).ifPresent(x -> System.out.println(x));
    }

    private static void checkMatchEx14() {
        boolean allMatch = peopleList.stream()
                .allMatch(person -> person.getAge() > 20);
        System.out.println(allMatch);

        boolean anyMatch = peopleList.stream()
                .anyMatch(person -> person.getAge() > 50);
        System.out.println(anyMatch);

        boolean noneMatch = peopleList.stream()
                .noneMatch(person -> person.getName().equals("KoKo"));
        System.out.println(noneMatch);
    }

    private static void doGroupByEx15() {
        Map<Gender, List<Person>> groupByGender = peopleList.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people) -> {
            System.out.println(gender);
            people.forEach(System.out::println);
            System.out.println();
        });
    }

    private static void doOptionalComparatorEx16(){
        Optional<String> oldestFemaleAge = peopleList.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemaleAge.ifPresent(System.out::println);
    }
}
