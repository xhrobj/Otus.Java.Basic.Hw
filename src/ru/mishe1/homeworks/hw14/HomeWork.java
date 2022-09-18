/*
    Описание/Пошаговая инструкция выполнения домашнего задания:
    Придумать несколько взаимосвязанных классов, в которых можно использовать три способа обработки исключений (вывод ошибки, rethrow и еще один, на выбор)
    А так же использована конструкция try-with-resource
    Вместо обращения к реальным ресурсам можно использовать классы-заглушки
    Результатом выполнения задания является код на гитхабе оформленный в виде pull request.
 */

package ru.mishe1.homeworks.hw14;

public class HomeWork {
    private static final int guessTheNumberGameUpperBound = 100;

    public static void main(String[] args) throws Exception {
        try (final var game = new GuessTheNumberGame(guessTheNumberGameUpperBound)) {
            game.start();
        }
    }
}
