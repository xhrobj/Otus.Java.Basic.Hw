package ru.mishe1.homeworks.hw16.tests;

import ru.mishe1.homeworks.hw16.tests.unit.*;

public class AllTests {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        new DiceImplTest().testDiceImplRollFrom1To6();
        new PlayerTest().testPlayerName();
        new GameTest().testGameWinPlayer1();
        new GameTest().testGameWinPlayer2();
        new GameTest().testGameTie();
    }
}
