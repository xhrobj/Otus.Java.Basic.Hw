/*
    Описание/Пошаговая инструкция выполнения домашнего задания:
    Переписать в ООП-стиле задание по разработке программы для тестирования из занятия "Java синтаксис: массивы, условные операторы, циклы".
    Продумать структуру классов и как они будут между собой взаимодействовать (какие будут методы в классах).
 */

package ru.mishe1.homeworks.hw8;

public class HomeWork {
    public static void main(String[] args) {
        final var questions = new Question[] {
                new Question(
                        "В файл с каким расширением компилируется java-файл?",
                        new String[] {"ss", "java", "class", "exe"},
                        3
                ),
                new Question(
                        "С помощью какой команды git можно получить полную копию удалённого репозитория?",
                        new String[]{"commit", "push", "clone", "copy"},
                        3
                ),
                new Question(
                        "Какой цикл применяется, когда не известно число операций?",
                        new String[]{"while", "for", "loop"},
                        1
                )
        };

        final var quiz = new Quiz(questions, new UserInput(), new UserOutput());
        quiz.start();
    }
}
