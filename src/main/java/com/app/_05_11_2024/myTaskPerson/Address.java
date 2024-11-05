package com.app._05_11_2024.myTaskPerson;

import java.util.Objects;

public class Address implements Comparable<Address>{
    private int id;
    private String street;
    private int houseNumber;
    private String postCode;

    public Address(int id, String street, int houseNumber, String postCode) {
        this.id = id;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && houseNumber == address.houseNumber && Objects.equals(postCode,address.postCode) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, houseNumber, postCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", postCode=" + postCode +
                '}';
    }

    @Override
    public int compareTo(Address another) {
        int result = Integer.compare(id, another.id);
        if (result == 0) {
            result = street.compareTo(another.street);
        }
        if (result == 0) {
            result = Integer.compare(houseNumber, another.houseNumber);
        }
        if (result == 0) {
            result = postCode.compareTo(another.postCode);
        }
        return result;
    }
}
