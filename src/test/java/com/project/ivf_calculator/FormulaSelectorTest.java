package com.project.ivf_calculator;

import com.project.ivf_calculator.Model.Formula;
import com.project.ivf_calculator.Service.FormulaSelector;
import com.project.ivf_calculator.Util.CsvLoader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class FormulaSelectorTest {

    @Test
    public void testSelectFormulaWithNACase() {

        CsvLoader csvLoader = Mockito.mock(CsvLoader.class);

        List<Formula> formulas = new ArrayList<>();
        Formula formula = new Formula();
        formula.setUsingOwnEggs(false);
        formula.setAttemptedIVFPreviously("N/A");
        formula.setReasonForInfertilityKnown(true);
        formulas.add(formula);

        when(csvLoader.getFormulas()).thenReturn(formulas);

        FormulaSelector formulaSelector = new FormulaSelector(csvLoader);
        Formula selectedFormula = formulaSelector.selectFormula(false, "N/A", true);

        assertEquals(formula, selectedFormula);
    }

    @Test
    public void selectFormula_matchingFormulaFound_returnsFormula() {

        CsvLoader csvLoader = Mockito.mock(CsvLoader.class);

        Formula formula = new Formula();
        formula.setUsingOwnEggs(true);
        formula.setAttemptedIVFPreviously("true");
        formula.setReasonForInfertilityKnown(true);


        when(csvLoader.getFormulas()).thenReturn(Collections.singletonList(formula));

        FormulaSelector formulaSelector = new FormulaSelector(csvLoader);

        Formula result = formulaSelector.selectFormula(true, "true", true);
        assertEquals(formula, result);
    }

    @Test
    public void testSelectFormula_NoMatch() {
        CsvLoader csvLoader = Mockito.mock(CsvLoader.class);

        when(csvLoader.getFormulas()).thenReturn(new ArrayList<>());

        FormulaSelector formulaSelector = new FormulaSelector(csvLoader);

        assertThrows(RuntimeException.class, () -> formulaSelector.selectFormula(true, "true", true));
    }
}
