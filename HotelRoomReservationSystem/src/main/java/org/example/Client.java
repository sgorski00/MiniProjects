package org.example;

import java.util.Date;

public class Client {
    int pesel;
    String firstName;
    String lastName;
    String nationality;
    Date dateOfBirth;
    public Client(){}

    public Client(int pesel, String firstName, String lastName, String nationality, Date dateOfBirth){
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
    }
}
