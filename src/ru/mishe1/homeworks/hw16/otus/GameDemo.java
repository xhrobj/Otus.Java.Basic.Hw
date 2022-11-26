package ru.mishe1.homeworks.hw16.otus;

import ru.mishe1.homeworks.hw16.otus.game.*;

public class GameDemo {
    public static void main(String[] args) {
        Dice dice = new DiceImpl();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));
    }
}
