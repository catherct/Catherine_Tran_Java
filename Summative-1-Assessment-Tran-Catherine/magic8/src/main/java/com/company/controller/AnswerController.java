package com.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.company.model.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class AnswerController {

    private List<String> answerList;

    private static int idCounter = 1;

    public AnswerController() {
        answerList = new ArrayList<>();

        answerList.add("Try again.");
        answerList.add("Don't count on it.");
        answerList.add("Absolutely.");
        answerList.add("Perhaps.");
        answerList.add("Highly doubt it.");
        answerList.add("Most likely.");
        answerList.add("Signs point to no.");
        answerList.add("Signs point to yes.");
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer askMagicEight(@RequestBody Answer answer) {

        Random rand = new Random();

        answer.setId(idCounter);
        answer.setAnswer(answerList.get(rand.nextInt(8)));

            return answer;
        }
    }

