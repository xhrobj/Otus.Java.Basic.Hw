package ru.mishe1.homeworks.hw23.tests;

import ru.mishe1.homeworks.hw23.tests.unit.*;

public class AllTests {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        new RusNumberFormatterTest().testRubblesСurrency();
        new RusNumberInWordsTest().testCheckNumbersToInWords();
    }
}
