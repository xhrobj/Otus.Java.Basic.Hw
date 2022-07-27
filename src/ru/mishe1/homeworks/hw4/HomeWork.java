// Зарегистрироваться на github.com
// Установить git
// Установить JDK и среду разработки
// Открыть данный класс в IDE
// Скомпилировать данный класс с помощью команды javac.
// Запустить программу на выполнение с помощью команды java
// Запустить программу на выполнение с помощью среды разработки
// Когда программа запросит - введите свое имя латиницей
// Сделайте pull-request с программой.
// Отправить в чат задания ссылку на pull-request

package ru.mishe1.homeworks.hw4;

import java.util.Base64;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        final var name = fetchName();
        System.out.println("Program result: " + getBase64Encoded(name));
    }

    private static String fetchName() {
        final var scanner = new Scanner(System.in);
        System.out.println("Please enter your full name");
        return scanner.nextLine();
    }

    private static String getBase64Encoded(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}