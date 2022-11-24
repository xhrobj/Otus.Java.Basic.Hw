package ru.mishe1.homeworks.hw23.tests.unit;

import ru.mishe1.homeworks.hw23.assertions.Assertions;
import ru.mishe1.homeworks.hw23.rusnumberformatter.RusNumberFormatter;

public class RusNumberFormatterTest {
    public void testRubblesСurrency() {
        String scenario = "Написание слова рубль/рублей/рубля после числа";

        final var rublesRusNumberFormatter = new RusNumberFormatter(
                "рублей",
                "рубль",
                "рубля"
        );

        final int[] sums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 50, 100, 101};
        final String[] expectedValues = {
                "рублей", // 0
                "рубль", // 1
                "рубля", // 2
                "рубля", // 3
                "рубля", // 4
                "рублей", // 5
                "рублей", // 6
                "рублей", // 7
                "рублей", // 8
                "рублей", // 9

                "рублей", // 10
                "рублей", // 11
                "рублей", // 12
                "рублей", // 13
                "рублей", // 14
                "рублей", // 15
                "рублей", // 16
                "рублей", // 17
                "рублей", // 18
                "рублей", // 19

                "рублей", // 20
                "рубль", // 21
                "рублей", // 50
                "рублей", // 100
                "рубль" // 101
        };

        try {
            for (var i = 0; i < sums.length; i++) {
                final var actual = rublesRusNumberFormatter.suffixForValue(sums[i]);
                Assertions.assertEquals(expectedValues[i], actual);
            }

            Assertions.printPassed(scenario);
        } catch (Throwable e) {
            Assertions.printFails(scenario, e.getMessage());
        }
    }
}
