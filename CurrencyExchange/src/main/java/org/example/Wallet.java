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
        usd = op.addMoney(1000, usd);
        eur = op.addMoney(500, eur);
        allMoney.add(usd);
        allMoney.add(eur);
        allMoney.add(pln);
    }

    void loadAndPrintListOfCurrencies(){
        listOfCurrencies.put(1, pln);
        listOfCurrencies.put(2, usd);
        listOfCurrencies.put(3, eur);

        System.out.println("Select currency:");
        for(int i = 1; i<listOfCurrencies.size()+1; i++){
            System.out.printf("%d. %s%n", i, listOfCurrencies.get(i).getCurrency());
        }
    }
}
