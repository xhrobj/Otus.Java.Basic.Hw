package ru.mishe1.homeworks.hw8;

import java.util.Scanner;

class UserInput {
    private static Scanner scanner;

    UserInput() {
         this.scanner = new Scanner(System.in);
    }

    int getNumber() {
        int number = scanner.nextInt();
        return number;
    }
}
