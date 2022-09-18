package ru.mishe1.homeworks.hw14;

class GuessTheNumberGame implements AutoCloseable {
    private static final int exitStatusCode = 42;
    private static final String byeByeSmile = "\uD83D\uDC4B";
    private static final String congratsSmile = "\uD83E\uDD73";

    private int upperBound;
    private RandomNumber randomNumber;
    private UserInput console;

    GuessTheNumberGame(int upperBound) {
        this.upperBound = upperBound;
        this.randomNumber = new RandomNumber(upperBound);
        this.console = new UserInput();
    }

    void start() {
        System.out.printf("Угадай число от 1 до %d\n", upperBound );

        while (true) {
            System.out.print("\nВведи число или \"exit\": ");

            try {
                final var number = console.getNumber();
                final var compareResult = randomNumber.compareNumber(number);

                if (compareResult == 0) {
                    System.out.println("Правильно! " + congratsSmile);
                    break;
                }

                System.out.println(compareResult < 0 ? "Больше >" : "Меньше <");
            } catch (RuntimeException e) {
                // NOTE: rethrow ("заворачиваем", сохраняя stacktrace и передаем выше), в итоге увидим ошибку в консоли
                throw new RuntimeException("\uD83D\uDC49 Ошибка в рантайме", e);
            } catch (UserInputExitException e) {
                // NOTE: обрабатываем исключение и выходим из приложения
                System.out.println(byeByeSmile);
                System.exit(exitStatusCode);
            } catch (UserInputNotNumberException e) {
                // NOTE: обрабатываем исключение и продолжаем работу приложения
                System.out.println("\uD83D\uDCA9 Это не число ☹️");
                continue;
            }
        }
    }

    public void close() throws Exception {
        System.out.printf("\n%s и даже в этом случае мы не забудем попрощаться %s\n\n", byeByeSmile, congratsSmile);
    }
}
