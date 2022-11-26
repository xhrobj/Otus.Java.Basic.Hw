/*
    Проект "Цена прописью"

    Цель:
        Применить полученные на курсе знания.
        Функционал "Цена прописью" довольно часто встречается в задачах автоматизации бизнеса.

    Описание/Пошаговая инструкция выполнения домашнего задания:
        Цена прописью.
        Надо запрограммировать программу, которая считывает с консоли число и выводит это значение прописью с добавлением «рублей».
        Например.
        Ввод с консоли: 5
        Вывод программы: пять рублей
        Ввод с консоли: 3
        Вывод программы: три рубля
        Ввод с консоли: 45
        Вывод программы: сорок пять рублей.

        Надо не забыть написать тесты.
        Т.е. основная часть программы должна быть написана так, чтобы можно было легко передать значение, полученное из консоли или из тестовых данных.
        Помните, что тесты – это важная и обязательная часть работы.

        Программа должна быть написана так, чтобы добавление другой валюты не привело к переписыванию всего приложения "с нуля".
*/

package ru.mishe1.homeworks.hw23;

import ru.mishe1.homeworks.hw23.rusnumberformatter.*;

public class Homework {
    public static void main(String[] agrs) {

        // NOTE: 🇷🇺

        final var rublesRusNumberFormatter = new RusNumberFormatter(
                "рублей",
                "рубль",
                "рубля"
        );

        for (var x = 0; x <= 101; x++) {
            final var number = new RusNumberInWords(x);
            System.out.println(x + " -> " + number.inWords() + " " + rublesRusNumberFormatter.suffixForValue(x));
            if (x % 10 == 0) System.out.println();
        }

        System.out.println();

        var x = 5;
        var number = new RusNumberInWords(x);
        System.out.println(x + " -> " + number.inWords() + " " + rublesRusNumberFormatter.suffixForValue(x));

        x = 3;
        number = new RusNumberInWords(x);
        System.out.println(x + " -> " + number.inWords() + " " + rublesRusNumberFormatter.suffixForValue(x));

        x = 45;
        number = new RusNumberInWords(x);
        System.out.println(x + " -> " + number.inWords() + " " + rublesRusNumberFormatter.suffixForValue(x));

        System.out.println();

        x = Integer.MAX_VALUE;
        number = new RusNumberInWords(x);
        System.out.println("\uD83C\uDDF7\uD83C\uDDFA " + x + " -> " + number.inWords() + " " + rublesRusNumberFormatter.suffixForValue(x));

        // NOTE: 🇺🇸

        final var usdNumberFormatter = new RusNumberFormatter(
                "долларов",
                "доллар",
                "доллара"
        );

        final var sum = 1_065_007_325;
        number = new RusNumberInWords(sum);
        System.out.println("\uD83C\uDDFA\uD83C\uDDF8 " +  sum + " -> " + number.inWords() + " " + usdNumberFormatter.suffixForValue(sum));
    }
}
