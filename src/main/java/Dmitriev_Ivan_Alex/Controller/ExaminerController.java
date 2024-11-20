package Dmitriev_Ivan_Alex.Controller;

import Dmitriev_Ivan_Alex.Question;
import Dmitriev_Ivan_Alex.Service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class ExaminerController {
    private final ExaminerServiceImpl examinerServiceImpl;

    public ExaminerController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerServiceImpl.getQuestions((amount));
    }
}
