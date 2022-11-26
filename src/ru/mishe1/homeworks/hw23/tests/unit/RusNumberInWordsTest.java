package ru.mishe1.homeworks.hw23.tests.unit;

import ru.mishe1.homeworks.hw23.assertions.Assertions;
import ru.mishe1.homeworks.hw23.rusnumberformatter.RusNumberInWords;

public class RusNumberInWordsTest {
    public void testCheckNumbersToInWords() {
        String scenario = "Написания чисел прописью";

        final int[] numbers = {0, 1, 2, 3, 5, 11, 42, 99, 100, 500, 1000, 100_500, 1_000_000, Integer.MAX_VALUE};
        final String[] expectedValues = {
                "ноль", // 0
                "один", // 1
                "два", // 2
                "три", // 3
                "пять", // 5
                "одиннадцать", // 11
                "сорок два", // 42
                "девяносто девять", // 99
                "сто", // 100
                "пятьсот", // 500
                "тысяча", // 1000
                "сто тысяч пятьсот", // 100_500
                "один миллион", // 1_000_000
                "два миллиарда сто сорок семь миллионов четыреста восемьдесят три тысячи шестьсот сорок семь" // 2_147_483_647
        };

        try {
            for (var i = 0; i < numbers.length; i++) {
                final var actual = new RusNumberInWords(numbers[i]).inWords();
                Assertions.assertEquals(expectedValues[i], actual);
            }

            Assertions.printPassed(scenario);
        } catch (Throwable e) {
            Assertions.printFails(scenario, e.getMessage());
        }
    }
}
