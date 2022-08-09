package ru.mishe1.homeworks.hw8;

class Quiz {
    private UserInput userInput;
    private UserOutput userOutput;
    private Question[] questions;
    private int questionsQuantity = 0;
    private int correctAnswersCount = 0;
    private int wrongAnswersCount = 0;
    private int currentQuestionIndex = 0;

    Quiz(Question[] questions, UserInput userInput, UserOutput userOutput) {
        this.questions = questions;
        this.questionsQuantity = questions.length;
        this.userInput = userInput;
        this.userOutput = userOutput;
    }

    void start() {
        resetCounters();

        while (isQuestion()) {
            askQuestion(getCurrentQuestion());
            nextQuestion();
        }

        showResult();
    }

    private void resetCounters() {
        correctAnswersCount = 0;
        wrongAnswersCount = 0;
        currentQuestionIndex = 0;
    }

    private void askQuestion(Question question) {
        userOutput.println("\n" + question.getQuestion());

        final var answersQuantity = question.getAnswersQuantity();
        for (var answersIndex = 0; answersIndex < answersQuantity; answersIndex++) {
            final var answersNumber = answersIndex + 1;
            userOutput.println(answersNumber + ". " + question.getAnswerWithNumber(answersNumber));
        }

        userOutput.print("\n" + "Ваш ответ: ");

        final var userAnswerNumber = userInput.getNumber();

        if (question.isCorrectAnswerNumber(userAnswerNumber)) {
            correctAnswersCount++;
            userOutput.println("Правильно");
        } else {
            wrongAnswersCount++;
            userOutput.println("Неправильно");
        }
    }

    private void showResult() {
        userOutput.println("\n" + "Результат: правильно " + correctAnswersCount + ", неправильно " + wrongAnswersCount);
    }

    private boolean isQuestion() {
        return questions.length == 0 ? false :  currentQuestionIndex < questions.length;
    }

    private Question getCurrentQuestion() {
        return questions[currentQuestionIndex];
    }

    private void nextQuestion() {
        currentQuestionIndex++;
    }
}
