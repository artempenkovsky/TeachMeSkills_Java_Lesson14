package by.teachmeskills.penkovsky.homework14;

public enum Currency {
    BYN("Белорусский рубль"),
    USD("Доллар США"),
    EUR("Евро"),
    GBP("Фунт стерлингов"),
    RUB("Российский рубль"),
    CNY("Китайский юань");

    private final String name;
    private final String code;

    Currency(String name) {
        this.name = name;
        this.code = name().toUpperCase();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static Currency getByCode(String code) {
        for (Currency currency : Currency.values()) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return currency;
            }
        }
        throw new IllegalArgumentException("Неизвестный код валюты: " + code);
    }
}

