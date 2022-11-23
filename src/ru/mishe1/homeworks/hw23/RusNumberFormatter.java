package ru.mishe1.homeworks.hw23;

class RusNumberFormatter {
    private final String wordFormForZero;
    private final String wordFormForOne;
    private final String wordFormForMany;

    RusNumberFormatter(String wordFormForZero, String wordFormForOne, String wordFormForMany) {
        this.wordFormForZero = wordFormForZero;
        this.wordFormForOne = wordFormForOne;
        this.wordFormForMany = wordFormForMany;
    }

    String suffixForValue(int value) {
        value = Math.abs(value);
        final var twoLastDigit = value % 100;
        if (twoLastDigit > 10 && twoLastDigit < 20) return wordFormForZero;

        final var lastDigit = value % 10;
        if (lastDigit == 1) return wordFormForOne;
        if (lastDigit >= 2 && lastDigit <= 4) return wordFormForMany;

        return wordFormForZero;
    }
}
