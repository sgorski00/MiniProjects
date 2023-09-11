package org.example;

import org.javamoney.moneta.Money;

import java.util.HashMap;
import java.util.Map;

public class Wallet {
    Operations op = new Operations();
    Map<Integer, Money> listOfCurrencies = new HashMap<>();
    private final Money usd = op.usdAmount();
    private final Money eur = op.eurAmount();
    private final Money pln = op.plnAmount();

//    String walletName;
//    int walletPin;
//    Map<walletname, money>

    {
        listOfCurrencies.put(1, pln);
        listOfCurrencies.put(2, usd);
        listOfCurrencies.put(3, eur);
    }

    void printListOfCurrencies(){
        for(int i = 1; i<=listOfCurrencies.size(); i++){
            System.out.printf("%d. %s%n", i, listOfCurrencies.get(i).getCurrency());
        }
    }

    void printListOfAmmountOfCurrencies(){
        for(int i = 1; i<=listOfCurrencies.size(); i++){
            System.out.printf("%d. %s%n", i, listOfCurrencies.get(i));
        }
    }
}
