package org.example;

import javax.money.CurrencyUnit;
import java.util.*;

public class Main {
    private static final Input scanner = new Input();
    private static final List<User> listOfUsers = new ArrayList<>();
    private static final Map<User, Wallet> walletOfUser = new HashMap<>();
    static{
        User sgorski00 = new User("sgorski00", "12345");
        User latuszka = new User("latuszka", "Latka@@@");
        User daga33 = new User("daga33", "qwertyuiop");
        User yomenik = new User("yomenik", "zaq1@WSX");
        listOfUsers.add(sgorski00);
        listOfUsers.add(daga33);
        listOfUsers.add(latuszka);
        listOfUsers.add(yomenik);
    }
    public static void main(String[] args) {
        logIn();
        //your sum of money in wallet:
        //what would you like to do?
        //list of operations to choose

    }

    private static void logIn() {
        boolean isValid = false;
        String login;
        String password;
        while(!isValid){
            System.out.println("====================");
            System.out.println("Enter login:");
            login = scanner.scannerText();
            for (User userName:listOfUsers) {
                if(login.equals(userName.login())){
                    System.out.println("Enter password:");
                    password = scanner.scannerText();
                    if(password.equals(userName.password())){
                        System.out.printf("%s %s!%n", "You are in", userName.login());
                        System.out.println("====================");
                        isValid = true;
                    }
                }
            }
        }
    }
}