package org.example;

import org.javamoney.moneta.FastMoney;

import javax.money.*;

public class Currencies {
    private MonetaryAmount createCurrency(String currencyCode){
        CurrencyQuery query = CurrencyQueryBuilder.of().setCurrencyCodes(currencyCode).build();
        CurrencyUnit cu = Monetary.getCurrency(query);
        return FastMoney.of(0, cu);
    }

    private MonetaryAmount usdAmount = createCurrency("USD");
    private MonetaryAmount eurAmount = createCurrency("EUR");
    private MonetaryAmount plnAmount = createCurrency("PLN");

    protected MonetaryAmount usdAmount() {
        return usdAmount;
    }

    protected void setUsdAmount(Number value) {
        usdAmount = FastMoney.of(value, usdAmount.getCurrency());
    }

    protected MonetaryAmount eurAmount() {
        return eurAmount;
    }

    protected void setEurAmount(Number value) {
        eurAmount = FastMoney.of(value, eurAmount.getCurrency());
    }

    protected MonetaryAmount plnAmount() {
        return plnAmount;
    }

    protected MonetaryAmount setPlnAmount(Number value) {
        return FastMoney.of(value, plnAmount.getCurrency());
    }
}
