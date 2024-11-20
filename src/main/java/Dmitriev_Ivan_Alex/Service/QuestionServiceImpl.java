package Dmitriev_Ivan_Alex.Service;

import Dmitriev_Ivan_Alex.Exeption.NoQuestionException;
import Dmitriev_Ivan_Alex.Exeption.OversizeException;
import Dmitriev_Ivan_Alex.Exeption.SimilarQuestionException;
import Dmitriev_Ivan_Alex.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    static final long maxQuestion = 1000;
    Random random = new Random();
    Set<Question> questionsSet = new HashSet<Question>();

    @Override
    public Question add(Question question) {  //Contains -содержит
        if (questionsSet.size() > maxQuestion) {
            throw new OversizeException("Превышено количество вопросов!");
        }
        if (questionsSet.contains(question)) {
            throw new SimilarQuestionException("Такой вопрос уже существует!");
        }
        questionsSet.add(question);
        return question;
    }

    @Override
    public Question add(String question, String answer) {  //Contains -содержит
        Question questionNew = new Question(question, answer);
        if (questionsSet.size() > maxQuestion) {
            throw new OversizeException("Превышено количество вопросов и ответов!");
        }
        if (questionsSet.contains(questionNew)) {
            throw new SimilarQuestionException("Такой вопрос уже существует!");
        }
        questionsSet.add(questionNew);
        return questionNew;
    }

    @Override
    public Question remove(Question question) {  //Contains -содержит
        if (!(questionsSet.contains(question))) {
            throw new NoQuestionException("Такого вопроса нет! ");
        }
        questionsSet.remove(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionNew = new Question(question, answer);
        if (!questionsSet.contains(questionNew)) {
            throw new NoQuestionException("Нет такого вопроса!");
        }
        questionsSet.remove(questionNew);
        return questionNew;
    }

    @Override
    public Collection<Question> getFullList() {

        return Collections.unmodifiableSet(questionsSet); //unmodifiableSet - неизменяемая коллекция
        // (выводит весь список).
    }


    @Override
    public Question getRandomQuestion() {

        return questionsSet.toArray(new Question[0])[random.nextInt(questionsSet.size())];
        //переводим в массив с помощью toArray ,
        //в массиве каждый вопрос имеет порядковый номер [0,1 и тд.
        // random
        //nextInt - показывает из какого интервала
        //(questionsSet.size())] - показываем интервал.
    }

}
