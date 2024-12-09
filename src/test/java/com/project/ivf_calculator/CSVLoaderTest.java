package com.project.ivf_calculator;

import com.project.ivf_calculator.Model.Formula;
import com.project.ivf_calculator.Util.CsvLoader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CSVLoaderTest {

    @Test
    public void testLoadCsv() {
        CsvLoader csvLoader = new CsvLoader();
        csvLoader.loadCsv();

        List<Formula> formulas = csvLoader.getFormulas();
        assertFalse(formulas.isEmpty(), "CSV data should be loaded");
    }
}
