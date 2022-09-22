package ru.mishe1.homeworks.hw14;

import java.util.Random;

class RandomNumber {
    private int bound;
    private int number;

    RandomNumber(int bound) {
        this.bound = bound;
        this.number = getRandomNumber(bound);
    }

    int compareNumber(int number) {
        if (number < 0 || number > bound) {
            throw new RandomNumberOutOfBoundsException("\uD83D\uDC49 Ошибка - вышли за границы угадываемого диапазона \uD83D\uDE05");
        }
        return this.number == number ? 0 : this.number < number ? 1 : -1;
    }

    private int getRandomNumber(int bound) {
        final var random = new Random();
        return random.nextInt(bound) + 1;
    }
}
