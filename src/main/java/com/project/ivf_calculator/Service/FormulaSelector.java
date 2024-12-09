package com.project.ivf_calculator.Service;

import com.project.ivf_calculator.Model.Formula;
import com.project.ivf_calculator.Util.CsvLoader;
import com.project.ivf_calculator.exceptions.FormulaNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class FormulaSelector {

    private static final Logger logger = LoggerFactory.getLogger(FormulaSelector.class);

    private final CsvLoader csvLoader;

    public FormulaSelector(CsvLoader csvLoader) {
        this.csvLoader = csvLoader;
    }

    public Formula selectFormula(boolean usingOwnEggs, String attemptedIVFPreviously, boolean reasonForInfertilityKnown) {
        logger.info("Selecting formula with usingOwnEggs: {}, attemptedIVFPreviously: {}, reasonForInfertilityKnown: {}",
                usingOwnEggs, attemptedIVFPreviously, reasonForInfertilityKnown);
        List<Formula> formulas = csvLoader.getFormulas();

        Optional<Formula> matchingFormula = formulas.stream()
                .filter(f -> f.isUsingOwnEggs() == usingOwnEggs)
                .filter(f -> {
                    if (!usingOwnEggs) {
                        return true;
                    }
                    return f.getAttemptedIVFPreviously().equalsIgnoreCase(attemptedIVFPreviously);
                })
                .filter(f -> f.isReasonForInfertilityKnown() == reasonForInfertilityKnown)
                .findFirst();

        if (matchingFormula.isPresent()) {
            logger.debug("Formula matched: {}", matchingFormula.get());
            return matchingFormula.get();
        } else {
            logger.error("No matching formula found for inputs");
            throw new FormulaNotFoundException("No matching formula found for the provided inputs");
        }
    }
}
