package org.example;

import org.javamoney.moneta.FastMoney;

import javax.money.MonetaryAmount;

public class Operations extends Currencies {
    public MonetaryAmount addMoney(double value, MonetaryAmount amountCurrency){
        FastMoney startValue = (FastMoney) amountCurrency;
        FastMoney endValue = startValue.add(FastMoney.of(value, amountCurrency.getCurrency()));
        return endValue;
    }

    public MonetaryAmount removeMoney(double value, MonetaryAmount amountCurrency){
        return amountCurrency.subtract(FastMoney.of(value, amountCurrency.getCurrency()));
    }
    //transfer currencies
    //remove some money
    //change main currency
    //exit wallet
}
