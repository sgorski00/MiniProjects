package org.example.persons;

import org.example.NumberCheck;

class Person {
    private String firstName;
    private String lastName;

    protected Person(String firstName, String lastName) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("First or last name is empty");
        } else if (NumberCheck.doesContainsNumber(firstName) || NumberCheck.doesContainsNumber(lastName)) {
            throw new IllegalArgumentException("Name contains a digit");
        }
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String lastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
