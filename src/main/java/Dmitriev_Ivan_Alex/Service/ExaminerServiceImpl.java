package Dmitriev_Ivan_Alex.Service;

import Dmitriev_Ivan_Alex.Exeption.QuestionAmountMismatchException;
import Dmitriev_Ivan_Alex.Question;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionServiceImpl questionServiceImpl;

    public ExaminerServiceImpl(QuestionServiceImpl questionServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionServiceImpl.getFullList().size()) {
            throw new QuestionAmountMismatchException("Количество вопросов не соответствует!");
        }
        Set<Question> newAmountQuestions = new HashSet<>();
        while (newAmountQuestions.size() < amount) {   // while - делаем до тех пор пока не выполним условие.
            newAmountQuestions.add(questionServiceImpl.getRandomQuestion());
        }
        return newAmountQuestions;
    }

}

