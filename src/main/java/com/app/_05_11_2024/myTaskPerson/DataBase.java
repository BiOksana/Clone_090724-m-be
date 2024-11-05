package com.app._05_11_2024.myTaskPerson;

import com.github.javafaker.Faker;

import java.util.*;

public class DataBase {

    public static Set<Person> getPersonsTreeSet(List<Person> list) {
        return new TreeSet<>(list);
    }

    public static List<Person> getPersonsLinkedListWithAgeMoreThanParam(List<Person> list, int targetAge) {
        List<Person> personLinkedList = new LinkedList<>();
        for (Person person : list) {
            if (person.getAge() > targetAge) {
                personLinkedList.add(person);
            }
        }
        return personLinkedList;
    }

    public static List<Person> generatePerson(int personCount) {
        List<Person> list = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 1; i <= personCount; i++) {

            list.add(new Person(faker.name().firstName(),
                                faker.name().lastName(),
                                (int) (Math.random() * (65 - 18 + 1) + 18),
                                faker.demographic().sex(),
                                faker.internet().emailAddress(),
                                new Address(faker.idNumber().hashCode(),
                                            faker.address().streetName(),
                                            Integer.parseInt(faker.address().buildingNumber()),
                                            faker.address().zipCode())));
        }
        return list;
    }

    public static void main(String[] args) {
        List<Person> list = DataBase.generatePerson(40);
        System.out.println("list.size() = " + list.size() + " : ");
        for (Person person : list) {
            System.out.println(person.getName() + " " + person.getSurname() + ", age " + person.getAge());
        }
        System.out.println();

        Set<Person> personsTreeSet = DataBase.getPersonsTreeSet(list);
        System.out.println("Persons from TreeSet: ");
        for (Person person : personsTreeSet) {
            System.out.println(person.getName() + " " + person.getSurname() + ", age " + person.getAge());
        }
        System.out.println();

        List<Person> personLinkedList = DataBase.getPersonsLinkedListWithAgeMoreThanParam(list, 25);
        System.out.println("personLinkedList.size() = " + personLinkedList.size());
        for (Person person : personLinkedList) {
            System.out.println(person.getName() + " " + person.getSurname() + ", age " + person.getAge());
        }
    }
}
