package com.project.ivf_calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ivf_calculator.Model.UserInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
public class IVFCalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void calculateSuccessRate_validInput_returnsSuccessRate() throws Exception {
        UserInput input = new UserInput();
        input.setAge(30);
        input.setHeightFeet(5);
        input.setHeightInches(6);
        input.setWeight(150);
        input.setUsingOwnEggs(true);
        input.setAttemptedIVFPreviously("true");
        input.setReasonForInfertilityKnown(true);
        input.setTubalFactor(true);
        input.setPriorPregnancies(1);
        input.setPriorLiveBirths(0);

        mockMvc.perform(post("/api/ivf/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("0.4629")));
    }

    @Test
    void calculateSuccessRate_invalidInput_returnsValidationErrors() throws Exception {
        UserInput input = new UserInput();
        input.setAge(55);

        mockMvc.perform(post("/api/ivf/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.age").value("Age must not exceed 50"));
    }
}
