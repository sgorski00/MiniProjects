package org.example;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

import javax.money.*;

public class Currencies {
    private MonetaryAmount createCurrency(String currencyCode){
        CurrencyQuery query = CurrencyQueryBuilder.of().setCurrencyCodes(currencyCode).build();
        CurrencyUnit cu = Monetary.getCurrency(query);
        return FastMoney.of(0, cu);
    }

    private final Money usdAmount = Money.from(createCurrency("USD"));
    private final Money eurAmount = Money.from(createCurrency("EUR"));
    private final Money plnAmount = Money.from(createCurrency("PLN"));

    protected Money usdAmount() {
        return usdAmount;
    }

    protected Money eurAmount() {
        return eurAmount;
    }

    protected Money plnAmount() {
        return plnAmount;
    }
}
