/*
    Описание/Пошаговая инструкция выполнения домашнего задания:
    Написать систему тестирования.
    На экран выводится вопрос и варианты ответа, с клавиатуры вводится номер ответа.
    Вопросы и ответы должны быть зашиты в коде, внешнего хранения в файлах или базах данных не нужно.
    Должно быть три вопроса, каждый с 3-5 вариантами ответов.
    Все вопросы с одним правильным вариантом ответа.
    После прохождения теста отображается результат.
    Использовать только циклы, массивы, условия и другие структуры, которые были пройдены на данный момент в рамках курса.
    В этом задании не нужно использовать ООП (создавать классы), вопросы и варианты ответов надо хранить в массиве (массивах).
 */

package ru.mishe1.homeworks.hw6;

import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        final var questions = new String[] {
                "В файл с каким расширением компилируется java-файл?",
                "С помощью какой команды git можно получить полную копию удалённого репозитория?",
                "Какой цикл применяется, когда не известно число операций?"
        };

        final var answers = new String[][] {
                {"ss", "java", "class", "exe"},
                {"commit", "push", "clone", "copy"},
                {"while", "for", "loop"}
        };

        final var correctAnswersNumbers = new int[] {3, 3, 1};

        final var scanner = new Scanner(System.in);

        var correctAnswersCount = 0;
        var wrongAnswersCount = 0;

        for (var questionsIndex = 0; questionsIndex < questions.length; questionsIndex++) {
            println("\n" + questions[questionsIndex]);

            for (var answersIndex = 0; answersIndex < answers[questionsIndex].length; answersIndex++) {
                final var answersNumber = answersIndex + 1;
                println(answersNumber + ". " + answers[questionsIndex][answersIndex]);
            }

            print("\n" + "Ваш ответ: ");

            final var userAnswerString = scanner.nextLine();
            final var userAnswerNumber = Integer.parseInt(userAnswerString);
            final var isCorrectAnswer = userAnswerNumber == correctAnswersNumbers[questionsIndex];

            if (isCorrectAnswer) {
                correctAnswersCount++;
                println("Правильно");
            } else {
                wrongAnswersCount++;
                println("Неправильно");
            }
        }

        println("\n" + "Результат: правильно " + correctAnswersCount + ", неправильно " + wrongAnswersCount);
    }

    private static void println(String text) {
        System.out.println(text);
    }

    private static void print(String text) {
        System.out.print(text);
    }
}