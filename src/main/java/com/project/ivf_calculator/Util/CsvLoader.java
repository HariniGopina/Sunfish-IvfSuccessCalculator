package com.project.ivf_calculator.Util;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.project.ivf_calculator.Model.Formula;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

//Utility class to load formulas from a CSV file.
@Component
public class CsvLoader {

    private static final Logger logger = LoggerFactory.getLogger(CsvLoader.class);

    private final List<Formula> formulas = new ArrayList<>();

    @PostConstruct
    public void loadCsv() {
        logger.info("Starting to load IVF formulas from CSV file.");
        try (Reader reader = new InputStreamReader(
                getClass().getResourceAsStream("/ivf_success_formulas.csv"))) {
            logger.debug("CSV file successfully located.");
            CsvToBean<Formula> csvToBean = new CsvToBeanBuilder<Formula>(reader)
                    .withType(Formula.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            formulas.addAll(csvToBean.parse());
            logger.info("Successfully loaded {} formulas from CSV file.", formulas.size());
        } catch (Exception e) {
            logger.error("Error occurred while loading CSV file: {}", e.getMessage(), e);
            throw new RuntimeException("Error loading CSV file", e);
        }
    }

    public List<Formula> getFormulas() {
        logger.debug("Returning {} loaded formulas.", formulas.size());
        return formulas;
    }
}
