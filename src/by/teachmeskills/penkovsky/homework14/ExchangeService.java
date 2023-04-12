package by.teachmeskills.penkovsky.homework14;

import java.math.BigDecimal;

public class ExchangeService {
    private ExchangeRate[] exchangeRates;

    public ExchangeService() {
        exchangeRates = getTodayRates();
    }

    public ExchangeRate[] getTodayRates() {
        ExchangeRate[] rates = {
                new ExchangeRate(Currency.BYN, BigDecimal.ONE),
                new ExchangeRate(Currency.USD, BigDecimal.valueOf(2.8538)),
                new ExchangeRate(Currency.EUR, BigDecimal.valueOf(3.1064)),
                new ExchangeRate(Currency.GBP, BigDecimal.valueOf(3.5299)),
                new ExchangeRate(Currency.RUB, BigDecimal.valueOf(0.0341)),
                new ExchangeRate(Currency.CNY, BigDecimal.valueOf(0.4157))
        };
        return rates;
    }

    public BigDecimal exchange(Currency fromCurrency, BigDecimal amount, Currency toCurrency) {
        BigDecimal fromRate = null;
        BigDecimal toRate = null;
        for (ExchangeRate rate : exchangeRates) {
            if (rate.getCurrency() == fromCurrency) {
                fromRate = rate.getRate();
            } else if (rate.getCurrency() == toCurrency) {
                toRate = rate.getRate();
            }
            if (fromRate != null && toRate != null) {
                break;
            }
        }
        if (fromRate == null) {
            throw new IllegalArgumentException("Unknown from currency");
        }
        if (toRate == null) {
            throw new IllegalArgumentException("Unknown to currency");
        }
        return amount.multiply(fromRate).divide(toRate, 4, BigDecimal.ROUND_HALF_UP);
    }
}

