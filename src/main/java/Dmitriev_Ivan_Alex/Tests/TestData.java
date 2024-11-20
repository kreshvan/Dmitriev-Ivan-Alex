package Dmitriev_Ivan_Alex.Tests;

import Dmitriev_Ivan_Alex.Question;

import java.util.Collection;
import java.util.List;

public class TestData {
    final static Question RANDOM_QUESTION_1 = new Question("aaa", "111");
    final static Question RANDOM_QUESTION_2 = new Question("bbb", "222");
    final static Question RANDOM_QUESTION_3 = new Question("ccc", "333");

    public static Collection<Question> getFullList() {

        return List.of(RANDOM_QUESTION_1, RANDOM_QUESTION_2, RANDOM_QUESTION_3);
    }
}
