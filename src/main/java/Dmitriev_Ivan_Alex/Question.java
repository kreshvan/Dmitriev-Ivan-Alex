package Dmitriev_Ivan_Alex;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String setAnswer(String answer) {
        return answer;
    }

    public String setQuestion(String question) {
        return question;
    }

    @Override
    public String toString() {
        return question + ": " + answer;
    }

    @Override//переопределить
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Question question1))
            return false;
        //Оператор instanceof позволяет проверить, принадлежит ли объект указанному классу
        return Objects.equals(question, question1.question)
                && Objects.equals(answer, question1.answer);
    }

}
