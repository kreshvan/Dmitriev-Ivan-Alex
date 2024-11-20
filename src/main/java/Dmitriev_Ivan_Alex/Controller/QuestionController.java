package Dmitriev_Ivan_Alex.Controller;

import Dmitriev_Ivan_Alex.Question;
import Dmitriev_Ivan_Alex.Service.QuestionService;
import Dmitriev_Ivan_Alex.Service.QuestionServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class QuestionController {

    private final QuestionServiceImpl questionServiceImpl;

    public QuestionController(QuestionServiceImpl questionServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
    }


    @PostMapping("/add")
    public Question add(Question question) {
        return questionServiceImpl.add(question);
    }

    @PostMapping("/add/string")
    public Question addString(String question, String answer) {
        return questionServiceImpl.add(question, answer);
    }

    @DeleteMapping("/remove")
    public Question remove(Question question) {
        return questionServiceImpl.add(question);
    }

    @DeleteMapping("/remove/string")
    public Question removeString(String question, String answer) {
        return questionServiceImpl.add(question, answer);
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return questionServiceImpl.getFullList();
    }


}
