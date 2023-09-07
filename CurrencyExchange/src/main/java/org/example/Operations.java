package org.example;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;
import java.net.SocketTimeoutException;
import java.util.List;

public class Operations extends Currencies {
    public Money addMoney(double value, MonetaryAmount amountCurrency) {
        return Money.from(amountCurrency.add(Money.of(value, amountCurrency.getCurrency())));
    }

    public Money removeMoney(double value, MonetaryAmount amountCurrency) {
        return Money.from(amountCurrency.subtract(Money.of(value, amountCurrency.getCurrency())));
    }

    public CurrencyConversion covertTo(MonetaryAmount currency) {
        ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider();
        return rateProvider.getCurrencyConversion(currency.getCurrency());
    }

    public void getSumOfMoney(List<MonetaryAmount> allMoney, Money defaultCurrency) {
        MonetaryAmount sumMoney = defaultCurrency;
        for (MonetaryAmount money : allMoney) {
            Money amountInPln = Money.from(money.with(covertTo(defaultCurrency)));
            sumMoney = sumMoney.add(amountInPln);
        }
        System.out.println(sumMoney);
    }
    //change main currency
    //exit wallet
}
