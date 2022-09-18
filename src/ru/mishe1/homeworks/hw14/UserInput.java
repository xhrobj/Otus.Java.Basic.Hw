package ru.mishe1.homeworks.hw14;

import java.util.Scanner;

class UserInput {
    private static final String exitCommand = "exit";
    private static Scanner scanner;

    UserInput() {
        this.scanner = new Scanner(System.in);
    }

    int getNumber() throws UserInputExitException, UserInputNotNumberException {
        final var input = scanner.next();

        if (input.equalsIgnoreCase(exitCommand)) throw new UserInputExitException();

        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException exception) {
            throw new UserInputNotNumberException();
        }
    }
}
