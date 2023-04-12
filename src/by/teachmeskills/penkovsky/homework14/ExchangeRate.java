package by.teachmeskills.penkovsky.homework14;

import java.math.BigDecimal;

public class ExchangeRate {
    private final Currency currency;
    private final BigDecimal rate;

    public ExchangeRate(Currency currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getRate() {
        return rate;
    }
}