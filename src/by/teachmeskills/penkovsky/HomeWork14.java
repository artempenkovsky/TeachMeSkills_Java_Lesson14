package by.teachmeskills.penkovsky.homework14;

import java.math.BigDecimal;
import java.util.Scanner;

public class HomeWork14 {
    public static void main(String[] args) {
        ExchangeService exchangeService = new ExchangeService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие: ");
        System.out.println("1. Вывод курсов валют на сегодня.");
        System.out.println("2. Калькулятор валют.");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                ExchangeRate[] rates = exchangeService.getTodayRates();
                System.out.printf("%-20s%-10s%-20s%n", "Название валюты", "Код", "Курс к BYN");
                for (ExchangeRate rate : rates) {
                    System.out.printf("%-20s%-10s%-20f%n", rate.getCurrency().getName(), rate.getCurrency().getCode(), rate.getRate());
                }
                break;
            case 2:
                System.out.println("Введите код валюты, которую хотите обменять:");
                String fromCurrencyCode = scanner.next();
                Currency fromCurrency = Currency.getByCode(fromCurrencyCode);

                System.out.println("Введите количество валюты, которую хотите обменять:");
                BigDecimal amount = scanner.nextBigDecimal();

                System.out.println("Введите код валюты, на которую хотите обменять:");
                String toCurrencyCode = scanner.next();
                Currency toCurrency = Currency.getByCode(toCurrencyCode);

                BigDecimal result = exchangeService.exchange(fromCurrency, amount, toCurrency);
                System.out.printf("%s %s = %s %s%n", amount.toString(), fromCurrency.getName(), result.toString(),
                        toCurrency.getName());
                break;
        }
    }
}
