package enums;

public enum Currency {
    RUB("RUB"),
    EUR("EUR");

    private final String code;

    Currency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
