package org.example;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;
import java.util.Map;

public class Operations extends Currencies {

    public Money addMoney(double value, MonetaryAmount amountCurrency) {
        return Money.from(amountCurrency.add(Money.of(value, amountCurrency.getCurrency())));
    }

    public Money removeMoney(double value, MonetaryAmount amountCurrency) {
        return Money.from(amountCurrency.subtract(Money.of(value, amountCurrency.getCurrency())));
    }

    private CurrencyConversion convertTo(MonetaryAmount currency) {
        ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider();
        return rateProvider.getCurrencyConversion(currency.getCurrency());
    }

    public void getSumOfMoney(Map<Integer, Money> a, int covertToCurrency){
        Money sum = Money.of(0, a.get(covertToCurrency).getCurrency());
        for(Money m:a.values()){
            Money amountInDefaultCurrency = Money.from(m.with(convertTo(sum)));
            sum = sum.add(amountInDefaultCurrency);
        }
        System.out.println("Total amount of money: " + sum);
    }
}
