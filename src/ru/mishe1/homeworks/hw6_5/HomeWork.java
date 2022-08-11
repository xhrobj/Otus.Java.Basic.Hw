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

package ru.mishe1.homeworks.hw6_5;

/*
    1. Сделать так чтобы все данные вопросов/ ответов / правильных ответов - хранились бы в одном массиве.
       (тут будет скорей всего 3-х мерный) String[][][]

    2. после того как ты сделаешь 1-й пункт и проверишь что он работает.
       сделай так чтобы тип ответы был не String а Integer то есть вместо "3" будет 3
 */

import java.util.Scanner;

public class HomeWork {
    private static final int QUESTION_INDEX = 0;
    private static final int CORRECT_ANSWER_INDEX = 1;
    private static final int ANSWERS_INDEX = 2;

    public static void main(String[] args) {
        final var questions = new Object[][] {
                {"В файл с каким расширением компилируется java-файл?", 3, "ss", "java", "class", "exe"},
                {"С помощью какой команды git можно получить полную копию удалённого репозитория?", 3, "commit", "push", "clone", "copy"},
                {"Какой цикл применяется, когда не известно число операций?", 1, "while", "for", "loop"}
        };

        final var scanner = new Scanner(System.in);

        var correctAnswersCount = 0;
        var wrongAnswersCount = 0;

        for (var questionsIndex = 0; questionsIndex < questions.length; questionsIndex++) {
            println("\n" + questions[questionsIndex][QUESTION_INDEX]);

            for (var answersIndex = ANSWERS_INDEX; answersIndex < questions[questionsIndex].length; answersIndex++) {
                final var answersNumber = answersIndex - ANSWERS_INDEX + 1;
                println(answersNumber + ". " + questions[questionsIndex][answersIndex]);
            }

            print("\n" + "Ваш ответ: ");

            final var userAnswer = Integer.valueOf(scanner.nextLine());
            final var isCorrectAnswer = userAnswer.equals(questions[questionsIndex][CORRECT_ANSWER_INDEX]);

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
