package Dmitriev_Ivan_Alex.Service;

import Dmitriev_Ivan_Alex.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
