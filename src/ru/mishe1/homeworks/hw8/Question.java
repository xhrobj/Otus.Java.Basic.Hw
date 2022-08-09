package ru.mishe1.homeworks.hw8;

class Question {
    private String question;
    private String[] answers;
    private int correctAnswerNumber;

    Question(String question, String[] answers, int correctAnswerNumber) {
        this.question = question;
        this.answers = answers;
        this.correctAnswerNumber = correctAnswerNumber;
    }

    String getQuestion() {
        return question;
    }

    int getAnswersQuantity() {
        return answers.length;
    }

    String getAnswerWithNumber(int number) {
        if (number < 1 || number > answers.length) return "";
        return answers[number - 1];
    }

    boolean isCorrectAnswerNumber(int number) {
        return number == correctAnswerNumber;
    }
}
