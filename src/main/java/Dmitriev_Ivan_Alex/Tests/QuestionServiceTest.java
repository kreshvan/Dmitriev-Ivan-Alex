package Dmitriev_Ivan_Alex.Tests;

import Dmitriev_Ivan_Alex.Exeption.NoQuestionException;
import Dmitriev_Ivan_Alex.Exeption.OversizeException;
import Dmitriev_Ivan_Alex.Exeption.SimilarQuestionException;
import Dmitriev_Ivan_Alex.Question;
import Dmitriev_Ivan_Alex.Service.QuestionServiceImpl;
import org.junit.Test;

import java.util.Collection;

import static Dmitriev_Ivan_Alex.Tests.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class QuestionServiceTest {
    QuestionServiceImpl questionServiceImpl = new QuestionServiceImpl();

    @Test
    public void check_ForAddingQuestion_thenAdd() {

        Question actual = questionServiceImpl.add(RANDOM_QUESTION_1);
        assertThat(actual).isEqualTo(RANDOM_QUESTION_1);
    }

    @Test
    public void check_ForAddingQuestion_thenAdd_thenThrowException() {
        questionServiceImpl.add(RANDOM_QUESTION_1);
        assertThatExceptionOfType(SimilarQuestionException.class)
                .isThrownBy(() -> questionServiceImpl.add(RANDOM_QUESTION_1));

    }

    @Test
    public void check_ForAddingQuestionAndAnswer_thenAdd() {
        Question Addquestion = questionServiceImpl.add
                (RANDOM_QUESTION_1.getQuestion(), RANDOM_QUESTION_1.getAnswer());
        assertThat(Addquestion).isEqualTo(RANDOM_QUESTION_1);

    }

    @Test
    public void check_ForAddingQuestionAndAnswer_thenAdd_thenThrowException() {
        questionServiceImpl.add(RANDOM_QUESTION_1.getQuestion(), RANDOM_QUESTION_1.getAnswer());
        assertThatExceptionOfType(SimilarQuestionException.class)
                .isThrownBy(() -> questionServiceImpl.add(RANDOM_QUESTION_1));

    }

    @Test
    public void checkingForObjectDeletion_thenRemove() {
        questionServiceImpl.add(RANDOM_QUESTION_1);
//Test
        Question removeQuestion = questionServiceImpl.remove(RANDOM_QUESTION_1);
//Check
        Collection<Question> result = questionServiceImpl.getFullList();
        assertThat(result).isEmpty();
        assertThat(removeQuestion).isEqualTo(RANDOM_QUESTION_1);

    }

    @Test
    public void checkingForQuestionDeletion_thenRemove_thenThrowException() {
        assertThatExceptionOfType(NoQuestionException.class)
                .isThrownBy(() -> questionServiceImpl.remove(RANDOM_QUESTION_1));
    }


    @Test
    public void getFullList() {

        questionServiceImpl.add(RANDOM_QUESTION_1);
        questionServiceImpl.add(RANDOM_QUESTION_2);
        questionServiceImpl.add(RANDOM_QUESTION_3);

        //test
        Collection<Question> actual = questionServiceImpl.getFullList();


    }


}
