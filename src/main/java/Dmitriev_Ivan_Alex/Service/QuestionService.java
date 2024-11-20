package Dmitriev_Ivan_Alex.Service;

import Dmitriev_Ivan_Alex.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(Question question);

    Question add(String question, String answer);

    Question remove(Question question);

    Question remove(String question, String answer);

    Collection<Question> getFullList();

    Question getRandomQuestion();
}
