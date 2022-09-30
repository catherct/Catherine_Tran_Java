package com.company.controller;

import com.company.model.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {

    // wiring in the MockMVC project
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // testing POST /magic
    @Test
    public void shouldReturnAnswerOnPostRequest() throws Exception {

        // ARRANGE
        Answer inputAnswer = new Answer();
        inputAnswer.setQuestion("Is the Queen dead?");

        // convert Java Object to JSON
        String userQuestion = mapper.writeValueAsString(inputAnswer);

        // ACT
        mockMvc.perform(
                    post("/magic")
                            .content(userQuestion)
                            .contentType(MediaType.APPLICATION_JSON)
            )
                .andDo(print())
                .andExpect(status().isCreated());   // HTTP STATUS 201
    }
}