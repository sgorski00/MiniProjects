package org.example;

import org.javamoney.moneta.FastMoney;

import javax.money.*;

public class Currency {
    void getCurrency(){
        CurrencyQuery query = CurrencyQueryBuilder.of().setCurrencyCodes("USD").build();
        CurrencyUnit cu = Monetary.getCurrency(query);
        MonetaryAmount amount = FastMoney.of(0, cu);
    }
}
