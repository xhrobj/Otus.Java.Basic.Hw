package ru.mishe1.homeworks.hw16.tests.unit;

import ru.mishe1.homeworks.hw16.assertions.Assertions;
import ru.mishe1.homeworks.hw16.otus.game.Player;

public class PlayerTest {
    public void testPlayerName() {

        // NOTE: в других тестах используется эта особенность класса Player, потому протестируем ее

        String scenario = "Имя, заданное при создании игрока, возвращается в неизменном виде";

        try {
            final var playerName = "Player1";
            final var player = new Player(playerName);
            final var actual = player.getName();

            Assertions.assertEquals(playerName, actual);
            Assertions.printPassed(scenario);
        } catch (Throwable e) {
            Assertions.printFails(scenario, e.getMessage());
        }
    }
}
