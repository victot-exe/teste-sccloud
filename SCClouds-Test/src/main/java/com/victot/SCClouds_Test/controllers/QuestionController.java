package com.victot.SCClouds_Test.controllers;

import com.victot.SCClouds_Test.model.TypeOfTheMethod;
import com.victot.SCClouds_Test.services.QuestionsService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class QuestionController {

    private final QuestionsService questionsService;

    public QuestionController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping("fibonacci")
    public BigInteger fibonnaci(@RequestParam int n, @RequestParam TypeOfTheMethod type) {

        if(type == TypeOfTheMethod.LINEAR)
            return questionsService.fibonacciLinear(n);
        else
            return questionsService.fibonacciRecursive(n);
    }

    @GetMapping("prime-numbers")
    public List<Integer> primeNumbers(@RequestParam int n, @RequestParam TypeOfTheMethod type) {
        if (type == TypeOfTheMethod.LINEAR)
            return questionsService.primosAteNLinear(n);
        else
            return questionsService.primosAteNRecursive(n);
    }

    @GetMapping("test")
    public String test() {
        return "Hello World";
    }
}
