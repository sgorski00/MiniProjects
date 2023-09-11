package org.example;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    Operations op = new Operations();
    final List<MonetaryAmount> allMoney = new ArrayList<>();
    Map<Integer, Money> listOfCurrencies = new HashMap<>();
    Money usd = op.usdAmount();
    Money eur = op.eurAmount();
    Money pln = op.setPlnAmount(1000);

//    String walletName;
//    int walletPin;
//    Map<walletname, money>

    {
        allMoney.add(usd);
        allMoney.add(eur);
        allMoney.add(pln);
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
