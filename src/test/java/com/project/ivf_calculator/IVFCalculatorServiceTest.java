package com.project.ivf_calculator;

import com.project.ivf_calculator.Model.Formula;
import com.project.ivf_calculator.Model.UserInput;
import com.project.ivf_calculator.Service.FormulaSelector;
import com.project.ivf_calculator.Service.IVFCalculatorService;
import com.project.ivf_calculator.exceptions.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class IVFCalculatorServiceTest {

    @Autowired
    private IVFCalculatorService ivfCalculatorService;

    @Mock
    private FormulaSelector formulaSelector;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ivfCalculatorService = new IVFCalculatorService(formulaSelector); // Pass mocked dependency
    }

    @Test
    void calculateSuccessRate_validInputs_returnsSuccessRate() {
        UserInput input = new UserInput();
        input.setAge(30);
        input.setHeightFeet(5);
        input.setHeightInches(8);
        input.setWeight(150);
        input.setUsingOwnEggs(true);
        input.setAttemptedIVFPreviously("true");
        input.setReasonForInfertilityKnown(true);
        input.setTubalFactor(true);

        Formula formula = new Formula();
        formula.setIntercept(0.5);
        formula.setAgeLinearCoefficient(0.1);
        formula.setAgePowerCoefficient(0.05);
        formula.setAgePowerFactor(2);
        formula.setBmiLinearCoefficient(0.2);
        formula.setBmiPowerCoefficient(0.1);
        formula.setBmiPowerFactor(2);
        formula.setTubalFactorTrueValue(0.3);
        formula.setTubalFactorFalseValue(0);

        when(formulaSelector.selectFormula(true, "true", true)).thenReturn(formula);

        double successRate = ivfCalculatorService.calculateSuccessRate(input);
        assertTrue(successRate > 0 && successRate <= 1);
    }

    @Test
    void validatePregnanciesAndLiveBirths_invalidInputs_throwsException() {
        UserInput input = new UserInput();
        input.setPriorPregnancies(0);
        input.setPriorLiveBirths(1);

        ValidationException exception = assertThrows(ValidationException.class, () ->
                ivfCalculatorService.validatePregnanciesAndLiveBirths(input));
        assertEquals("If prior pregnancies are 0, prior live births must also be 0.", exception.getMessage());
    }
}
