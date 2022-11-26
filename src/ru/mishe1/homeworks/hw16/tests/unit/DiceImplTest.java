package ru.mishe1.homeworks.hw16.tests.unit;

import ru.mishe1.homeworks.hw16.assertions.Assertions;
import ru.mishe1.homeworks.hw16.otus.game.DiceImpl;

public class DiceImplTest {
    private final DiceImpl dice = new DiceImpl();

    public void testDiceImplRollFrom1To6() {

        // NOTE: в условии явно описано, что значение при броске кубика может быть от 1 до 6

        final var scenario = "Игровая кость выпадает гранями 1-6";
        try {
            for (var i = 0; i++ < 10_000;) {
                final var actual = dice.roll();
                Assertions.assertBetween(1, 6, actual);
            }
            Assertions.printPassed(scenario);
        } catch (Throwable e) {
            Assertions.printFails(scenario, e.getMessage());
        }
    }
}
