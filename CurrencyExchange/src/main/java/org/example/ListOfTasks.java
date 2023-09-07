package org.example;

import java.util.HashMap;
import java.util.Map;

public class ListOfTasks {
    Operations op = new Operations();
    Map<Integer, String> tasks = new HashMap<>();
    Wallet wallet = new Wallet();
    Input scanner = new Input();

    private void printTasks() {
        System.out.println("Hello! What would you like to do?");
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

    void userChoice() {
        int choice = 0;
        do {
            printTasks();
            choice = (int) scanner.scannerNumber();
            switch (choice) {
                case 1 -> {
                    System.out.printf("%s%n%s%n%s%n", wallet.usd, wallet.eur, wallet.pln);
                    //press any button to continue
                }
                case 2 -> {
                    wallet.loadAndPrintListOfCurrencies();
                    int i = (int) scanner.scannerNumber();
                    if (i < wallet.listOfCurrencies.size() + 1) {
                        op.getSumOfMoney(wallet.allMoney, wallet.listOfCurrencies.get(i));
                    } else {
                        System.out.println("Wrong number");
                    }
                }
                case 3 -> {
                    wallet.loadAndPrintListOfCurrencies();
                    int i = (int) scanner.scannerNumber();
                    System.out.println("Eneter amount of money:");
                    double amount = scanner.scannerNumber();
                    op.addMoney(amount, wallet.listOfCurrencies.get(i));
                    //it should modificate value in MonetaryAmount and in Map.
                    System.out.println(wallet.listOfCurrencies.get(i));
                }
                case 7 -> System.out.println("The program has ended");
            }
        } while (choice != 7);
    }

}
