package org.example;

import org.javamoney.moneta.Money;

import java.util.HashMap;
import java.util.Map;

public class ListOfTasks {
    Operations op = new Operations();
    Map<Integer, String> tasks = new HashMap<>();
    Wallet wallet = new Wallet();
    Input scanner = new Input();

    private void printTasks() {
        System.out.println("Enter number");
        loadTasksList();
        for (Integer i : tasks.keySet()) {
            System.out.printf("%d. %s%n", i, tasks.get(i));
        }
    }

    private void loadTasksList() {
        tasks.put(1, "Show account balance");
        tasks.put(2, "Show sum of money");
        tasks.put(3, "Add money");
        tasks.put(4, "Remove money");
        tasks.put(5, "Set money");
        tasks.put(6, "Transfer money");
        tasks.put(7, "Actual exchange rates");
        tasks.put(8, "Exit");
    }

    void menu() {
        int choice;
        do {
            printTasks();
            choice = (int) scanner.scannerNumber();
            switch (choice) {
                case 1 -> {
                    wallet.printListOfAmmountOfCurrencies();
                    scanner.pressEnterToContinue();
                }
                case 2 -> {
                    System.out.println("Select the currency, in which You want to see your total account balance.");
                    wallet.printListOfCurrencies();
                    int choosedCurrency = (int) scanner.scannerNumber();
                    op.getSumOfMoney(choosedCurrency);
                    scanner.pressEnterToContinue();
                }
                case 3 -> {
                    wallet.printListOfCurrencies();
                    int choosedCurrency = (int) scanner.scannerNumber();
                    System.out.println("Enter amount of money:");
                    double amount = scanner.scannerNumber();
                    if(Wallet.listOfCurrencies.containsKey(choosedCurrency)){
                        Money temp = Money.of(amount, Wallet.listOfCurrencies.get(choosedCurrency).getCurrency());
                        Wallet.listOfCurrencies.put(choosedCurrency, Wallet.listOfCurrencies.get(choosedCurrency).add(temp));
                    }
                    System.out.printf("%s %s %s%n", "Added",amount, Wallet.listOfCurrencies.get(choosedCurrency).getCurrency());
                    scanner.pressEnterToContinue();
                }
                case 4 -> {
                    wallet.printListOfCurrencies();
                    int choosedCurrency = (int) scanner.scannerNumber();
                    System.out.println("Enter amount of money:");
                    double amount = scanner.scannerNumber();
                    if(Wallet.listOfCurrencies.containsKey(choosedCurrency)){
                        Money temp = op.removeMoney(amount, Wallet.listOfCurrencies.get(choosedCurrency));
                        Wallet.listOfCurrencies.put(choosedCurrency, temp);
                    }
                    System.out.printf("%s %s %s%n", "Removed",amount, Wallet.listOfCurrencies.get(choosedCurrency).getCurrency());
                    scanner.pressEnterToContinue();
                }
                case 5 -> {
                    wallet.printListOfCurrencies();
                    int choosedCurrency = (int) scanner.scannerNumber();
                    System.out.println("Enter amount of money:");
                    double amount = scanner.scannerNumber();
                    if(Wallet.listOfCurrencies.containsKey(choosedCurrency)){
                        Money temp = op.setMoney(amount, Wallet.listOfCurrencies.get(choosedCurrency));
                        Wallet.listOfCurrencies.put(choosedCurrency, temp);
                    }
                    System.out.printf("%s %s %s %s%n", "The amount of", Wallet.listOfCurrencies.get(choosedCurrency).getCurrency(), "has been set to", amount);
                    scanner.pressEnterToContinue();
                }
                case 6 -> {
                    System.out.println("Convert currency from:");
                    wallet.printListOfAmmountOfCurrencies();
                    int firstCu = (int) scanner.scannerNumber();
                    System.out.println("Enter amount of money to convert:");
                    double amount = scanner.scannerNumber();
                    System.out.println("Convert currency to:");
                    wallet.printListOfAmmountOfCurrencies();
                    int secondCu = (int) scanner.scannerNumber();
                    op.convertCurrency(firstCu, secondCu, amount);
                    wallet.printListOfAmmountOfCurrencies();
                    scanner.pressEnterToContinue();
                }
                case 7 ->{
                    System.out.println("Select default currency:");
                    wallet.printListOfCurrencies();
                    int currency = (int) scanner.scannerNumber();
                    op.printExchangeRates(currency);
                    scanner.pressEnterToContinue();
                }
                case 8 -> System.out.println("The program has ended");
            }
        } while (choice != 8);
    }

}
