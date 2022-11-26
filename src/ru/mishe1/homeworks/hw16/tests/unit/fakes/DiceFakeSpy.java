package ru.mishe1.homeworks.hw16.tests.unit.fakes;

import ru.mishe1.homeworks.hw16.otus.game.Dice;

public class DiceFakeSpy implements Dice {
    static private final int DEFAULT_VALUE = 1;
    private int rollCounter = 0;

    private int[] values;

    public DiceFakeSpy(int[] values) {
        this.values = values;
    }

    @Override
    public int roll() {
        if (values.length <= rollCounter) {
            ++rollCounter;
            return DEFAULT_VALUE;
        }
        return values[rollCounter++];
    }

    public int getRollCounter() {
        return rollCounter;
    }
}