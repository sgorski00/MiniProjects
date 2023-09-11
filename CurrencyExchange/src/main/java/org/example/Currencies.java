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

    private Money usdAmount = Money.from(createCurrency("USD"));
    private Money eurAmount = Money.from(createCurrency("EUR"));
    private Money plnAmount = Money.from(createCurrency("PLN"));

    protected Money usdAmount() {
        return usdAmount;
    }

    protected void setUsdAmount(Number value) {
        usdAmount = Money.of(value, usdAmount.getCurrency());
    }

    protected Money eurAmount() {
        return eurAmount;
    }

    protected void setEurAmount(Number value) {
        eurAmount = Money.of(value, eurAmount.getCurrency());
    }

    protected Money plnAmount() {
        return plnAmount;
    }

    protected Money setPlnAmount(Number value) {
        return Money.of(value, plnAmount.getCurrency());
    }
}
