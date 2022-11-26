package ru.mishe1.homeworks.hw23.rusnumberformatter;

public class RusNumberFormatter {
    private final String wordFormForZero;
    private final String wordFormForOne;
    private final String wordFormForMany;

    public RusNumberFormatter(String wordFormForZero, String wordFormForOne, String wordFormForMany) {
        this.wordFormForZero = wordFormForZero;
        this.wordFormForOne = wordFormForOne;
        this.wordFormForMany = wordFormForMany;
    }

    public String suffixForValue(int x) {
        x = Math.abs(x);
        final var twoLastDigit = x % 100;
        if (twoLastDigit > 10 && twoLastDigit < 20) return wordFormForZero;

        final var lastDigit = x % 10;
        if (lastDigit == 1) return wordFormForOne;
        if (lastDigit >= 2 && lastDigit <= 4) return wordFormForMany;

        return wordFormForZero;
    }
}
