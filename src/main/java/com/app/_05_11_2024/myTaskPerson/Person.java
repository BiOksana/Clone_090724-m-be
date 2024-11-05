package com.app._05_11_2024.myTaskPerson;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;
    private String surname;
    private int age;
    private String sex;
    private String email;
    private Address address;

    public Person(String name, String surname, int age, String sex, String email, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(sex, person.sex) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, sex, email);
    }


    @Override
    public int compareTo(Person another) {
        int result = this.name.compareTo(another.name);
        if (result == 0) {
            result = this.surname.compareTo(another.surname);
        }
        if (result == 0) {
            result = Integer.compare(this.age, another.age);
        }
        if (result == 0) {
            result = this.address.compareTo(another.address);
        }
        return result;
    }
}
