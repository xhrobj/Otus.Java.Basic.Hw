/*
    Домашнее задание: Сортировка чисел
    Цель: Потренироваться в применении стандартных коллекций.
    Описание/Пошаговая инструкция выполнения домашнего задания:
    Реализовать сортировку массива чисел используя любой алгоритм из представленных на занятии (или свой, но с комментариями).
 */

package ru.mishe1.homeworks.hw11;

import java.util.ArrayList;

class HomeWork {
    public static void main(String[] args) {
        sortArrayOfInts();
        sortArrayListOfIntegers();
        sortArrayListOfStrings();
    }

    private static void sortArrayOfInts() {
        System.out.println("\n\uD83D\uDE0A Сортировка массива целых примитивов:");
        final var xx = new int[] { 4, 1, 42, 11, 16, 12, 5, 0, -7, 1, 16 };

        printArrayOfInt(xx);
        Sorter.bubbleSort(xx);
        printArrayOfInt(xx);
    }

    private static void sortArrayListOfIntegers() {
        System.out.println("\n\uD83D\uDE0A Сортировка ArrayList с Integer внутри:");
        final var xx = new ArrayList<Comparable>();
        xx.add(4);
        xx.add(1);
        xx.add(42);
        xx.add(11);
        xx.add(16);
        xx.add(12);
        xx.add(5);
        xx.add(0);
        xx.add(-7);
        xx.add(1);
        xx.add(16);

        System.out.println(xx);
        Sorter.bubbleSort(xx);
        System.out.println(xx);
    }

    private static void sortArrayListOfStrings() {
        System.out.println("\n\uD83D\uDE0A Сортировка ArrayList со String внутри:");
        final var xx = new ArrayList<Comparable>();
        xx.add("Marina");
        xx.add("Nikita");
        xx.add("Mikhail");
        xx.add("Barry");
        xx.add("Anna");

        System.out.println(xx);
        Sorter.bubbleSort(xx);
        System.out.println(xx);
    }

    private static void printArrayOfInt(int[] xx) {
        for (var i = 0; i < xx.length; i++) {
            System.out.print(xx[i] + (i < (xx.length - 1) ? ", " : ""));
        }
        System.out.println();
    }
}
