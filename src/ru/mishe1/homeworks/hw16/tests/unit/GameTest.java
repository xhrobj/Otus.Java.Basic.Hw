package ru.mishe1.homeworks.hw16.tests.unit;

import ru.mishe1.homeworks.hw16.assertions.Assertions;
import ru.mishe1.homeworks.hw16.otus.game.*;
import ru.mishe1.homeworks.hw16.tests.unit.fakes.*;

public class GameTest {
    public void testGameWinPlayer1() {
        String scenario = "Первый игрок выигрывает";

        final int[] diceValues = {6, 5, 4, 3, 2, 1}; // NOTE: Игрок, бросивший кубик первым, выигрывает
        final var diceFakeSpy = new DiceFakeSpy(diceValues);
        final var winnerPrinterSpy = new GameWinnerConsoleSpy();
        final var game = new Game(diceFakeSpy, winnerPrinterSpy);
        final var player1 = new Player("player1");
        final var player2 = new Player("player2");

        try {
            game.playGame(player1, player2);
            final var actual = winnerPrinterSpy.getLastWinner().getName();
            final var expected = player1.getName();

            Assertions.assertEquals(expected, actual);
            Assertions.printPassed(scenario);
        } catch (Throwable e) {
            Assertions.printFails(
                    scenario,
                    e.getMessage() + "; Бросков кубика: " + diceFakeSpy.getRollCounter()
            );
        }
    }
    public void testGameWinPlayer2() {
        String scenario = "Второй игрок выигрывает";

        final int[] diceValues = {1, 2, 3, 4, 5, 6}; // NOTE: Игрок, бросивший кубик последним, выигрывает
        final var diceFakeSpy = new DiceFakeSpy(diceValues);
        final var winnerPrinterSpy = new GameWinnerConsoleSpy();
        final var game = new Game(diceFakeSpy, winnerPrinterSpy);
        final var player1 = new Player("player1");
        final var player2 = new Player("player2");

        game.playGame(player1, player2);
        final var actual = winnerPrinterSpy.getLastWinner().getName();
        final var expected = player2.getName();

        try {
            Assertions.assertEquals(expected, actual);
            Assertions.printPassed(scenario);
        } catch (Throwable e) {
            Assertions.printFails(
                    scenario,
                    e.getMessage() + "; Бросков кубика: " + diceFakeSpy.getRollCounter()
            );
        }
    }

    public void testGameTie() {
        String scenario = "Ничья";

        /*
            NOTE: в условии не описана ситуация, когда оба игрока выбрасывают (один или несколько раз) одинаковое
            число. Непонятно как в этом случае определять победителя и надо ли перебрасывать (и сколько раз) кубик.
            Но делаем предположение, что ни один из игроков в этом случае не должен быть объявлен победителем.
         */

        final int[] diceValues = {};
        final var diceFakeSpy = new DiceFakeSpy(diceValues);
        final var winnerPrinterSpy = new GameWinnerConsoleSpy();
        final var game = new Game(diceFakeSpy, winnerPrinterSpy);
        final var player1 = new Player("player1");
        final var player2 = new Player("player2");

        try {
            game.playGame(player1, player2);
            final var actual = winnerPrinterSpy.getLastWinner().getName();

            Assertions.assertNotEquals(player1.getName(), actual);
            Assertions.assertNotEquals(player2.getName(), actual);
            Assertions.printPassed(scenario);
        } catch (Throwable e) {
            Assertions.printFails(
                    scenario,
                    e.getMessage() + "; Бросков кубика: " + diceFakeSpy.getRollCounter()
            );
        }
    }
}
