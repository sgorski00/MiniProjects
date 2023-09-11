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
        tasks.put(7, "Exit");
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
                    wallet.printListOfCurrencies();
                    int choosedCurrency = (int) scanner.scannerNumber();
                    op.getSumOfMoney(wallet.listOfCurrencies, choosedCurrency);
                    scanner.pressEnterToContinue();
                }
                case 3 -> {
                    wallet.printListOfCurrencies();
                    int i = (int) scanner.scannerNumber();
                    System.out.println("Enter amount of money:");
                    double amount = scanner.scannerNumber();
                    if(wallet.listOfCurrencies.containsKey(i)){
                        Money temp = op.addMoney(amount, wallet.listOfCurrencies.get(i));
                        wallet.listOfCurrencies.put(i, temp);
                    }
                    System.out.printf("%s %s %s%n", "Added",amount, wallet.listOfCurrencies.get(i).getCurrency());
                    scanner.pressEnterToContinue();
                }
                case 4 -> {
                    wallet.printListOfCurrencies();
                    int i = (int) scanner.scannerNumber();
                    System.out.println("Enter amount of money:");
                    double amount = scanner.scannerNumber();
                    if(wallet.listOfCurrencies.containsKey(i)){
                        Money temp = op.removeMoney(amount, wallet.listOfCurrencies.get(i));
                        wallet.listOfCurrencies.put(i, temp);
                    }
                    System.out.printf("%s %s %s%n", "Removed",amount, wallet.listOfCurrencies.get(i).getCurrency());
                    scanner.pressEnterToContinue();
                }
                case 5 -> {
                    wallet.printListOfCurrencies();
                    int i = (int) scanner.scannerNumber();
                    System.out.println("Enter amount of money:");
                    int amount = (int) scanner.scannerNumber();

                }
                case 7 -> System.out.println("The program has ended");
            }
        } while (choice != 7);
    }

}
