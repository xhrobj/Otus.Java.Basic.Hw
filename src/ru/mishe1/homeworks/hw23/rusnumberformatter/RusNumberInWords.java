package ru.mishe1.homeworks.hw23.rusnumberformatter;

public class RusNumberInWords {
    private static final RusNumberFormatter[] THOUSANDS = {
            new RusNumberFormatter("миллиардов", "миллиард", "миллиарда"),
            new RusNumberFormatter("миллионов", "миллион", "миллиона"),
            new RusNumberFormatter("тысяч", "тысяча", "тысячи")
    };

    private static final String[] HUNDREDS = {
            "-",
            "сто",
            "двести",
            "триста",
            "четыреста",
            "пятьсот",
            "шестьсот",
            "семьсот",
            "восемьсот",
            "девятьсот",
            "тысяча"
    };

    private static final String[] DOZENS = {
            "-",
            "-",
            "двадцать",
            "тридцать",
            "сорок",
            "пятьдесят",
            "шестьдесят",
            "семьдесят",
            "восемьдесят",
            "девяносто"
    };

    private static final String[] ONES = {
            "ноль",
            "один",
            "два",
            "три",
            "четыре",
            "пять",
            "шесть",
            "семь",
            "восемь",
            "девять",
            "десять",
            "одиннадцать",
            "двенадцать",
            "тринадцать",
            "четырнадцать",
            "пятнадцать",
            "шестнадцать",
            "семнадцать",
            "восемнадцать",
            "девятнадцать"
    };

    private final int number;

    public RusNumberInWords(int number) {
        this.number = Math.abs(number);
    }

    @Override
    public String toString() {
        return inWords();
    }

    public String inWords() {
        final var multiplier = 1_000;
        int[] remains = {0, 0, 0, 0};
        var x = number;
        var divider = 1_000_000_000;
        var i = 0;
        while (x > multiplier) {
            remains[i++] = x / divider;
            x %= divider;
            divider /= multiplier;
        }
        remains[3] = x;

        var result = "";
        for (i = 0; i < 3; i++) {
            if (remains[i] == 0) continue;
            result = addSpaceIfNedeed(result);
            result += inWordsForNumberUnder1000(remains[i]) + " " + THOUSANDS[i].suffixForValue(remains[i]);
        }

        if (remains[3] > 0 || result.isEmpty()) {
            result = addSpaceIfNedeed(result);
            result += inWordsForNumberUnder1000(remains[3]);
        }

        return result;
    }

    private String inWordsForNumberUnder1000(int x) {
        final var multiplier = 10;
        int[] remains = {0, 0, 0};
        var divider = 100;
        var i = 0;
        while (x > multiplier) {
            remains[i++] = x / divider;
            x %= divider;
            divider /= multiplier;
        }
        remains[2] = x;

        var result = "";
        if (remains[0] > 0) {
            result += HUNDREDS[remains[0]];
        }
        if (remains[1] > 1) {
            result = addSpaceIfNedeed(result);
            result += DOZENS[remains[1]];
            if (remains[2] > 0) {
                result = addSpaceIfNedeed(result);
                result += ONES[remains[2]];
            }
        } else {
            x = remains[1] * 10 + remains[2];
            if (x > 0) {
                result = addSpaceIfNedeed(result);
                result += ONES[x];
            }
        }

        if (result.isEmpty()) {
            result = ONES[0];
        }

        return result;
    }

    private String addSpaceIfNedeed(String str) {
        return str.isEmpty() ? str : str + " ";
    }
}
