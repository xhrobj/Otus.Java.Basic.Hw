package ru.mishe1.homeworks.hw16.tests.unit.fakes;

import ru.mishe1.homeworks.hw16.otus.game.GameWinnerPrinter;
import ru.mishe1.homeworks.hw16.otus.game.Player;

public class GameWinnerConsoleSpy implements GameWinnerPrinter {
    private Player lastWinner;

    @Override
    public void printWinner(Player winner) {
        lastWinner = winner;
    }

    public Player getLastWinner() {
        return lastWinner;
    }
}