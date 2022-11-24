package ru.mishe1.homeworks.hw16.assertions;

public class Assertions {
    public static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
        }
    }

    public static void assertNotEquals(String notExpected, String actual) {
        if (notExpected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" != \"%s\"", notExpected, actual));
        }
    }

    public static void assertBetween(int lesser, int greater, int actual) {
        if (lesser > actual) {
            throw new AssertionError(String.format("Expected %d <= %d", lesser, actual));
        }
        if (greater < actual) {
            throw new AssertionError(String.format("Expected %d <= %d", actual, greater));
        }
    }

    public static void printPassed(String scenario) {
        System.out.printf("Тест \"%s\" --> \uD83D\uDC4D passed %n", scenario);
    }

    public static void printFails(String scenario, String message) {
        System.err.printf("Тест \"%s\" --> \uD83D\uDCA9 fails with message \"%s\" %n", scenario, message);
    }
}
