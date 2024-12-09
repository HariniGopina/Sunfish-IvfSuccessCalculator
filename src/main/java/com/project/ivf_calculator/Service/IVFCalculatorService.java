package com.project.ivf_calculator.Service;

import com.project.ivf_calculator.Model.Formula;
import com.project.ivf_calculator.Model.UserInput;
import com.project.ivf_calculator.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IVFCalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(IVFCalculatorService.class);

    private final FormulaSelector formulaSelector;

    public IVFCalculatorService(FormulaSelector formulaSelector) {
        this.formulaSelector = formulaSelector;
    }

    public double calculateSuccessRate(UserInput userInput) {

        logger.info("Calculating IVF success rate for input: {}", userInput);
        try {
            validatePregnanciesAndLiveBirths(userInput);
            validateReasonForInfertility(userInput);
        } catch (ValidationException ex) {
            logger.error("Validation error: {}", ex.getMessage());
            throw ex;
        }

        double bmi = calculateBmi(userInput.getHeightFeet(), userInput.getHeightInches(), userInput.getWeight());
        logger.debug("Calculated BMI: {}", bmi);

        Formula formula = formulaSelector.selectFormula(
                userInput.isUsingOwnEggs(),
                userInput.getAttemptedIVFPreviously(),
                userInput.isReasonForInfertilityKnown()
        );
        logger.debug("Selected formula: {}", formula);
        try {
            double score = formula.getIntercept()
                    + (formula.getAgeLinearCoefficient() * userInput.getAge())
                    + (formula.getAgePowerCoefficient() * Math.pow(userInput.getAge(), formula.getAgePowerFactor()))
                    + (formula.getBmiLinearCoefficient() * bmi)
                    + (formula.getBmiPowerCoefficient() * Math.pow(bmi, formula.getBmiPowerFactor()))
                    + getPregnancyValue(userInput.getPriorPregnancies(), formula)
                    + getLiveBirthValue(userInput.getPriorLiveBirths(), formula)
                    + (userInput.isTubalFactor() ? formula.getTubalFactorTrueValue() : formula.getTubalFactorFalseValue())
                    + (userInput.isMaleFactorInfertility() ? formula.getMaleFactorInfertilityTrueValue() : formula.getMaleFactorInfertilityFalseValue())
                    + (userInput.isEndometriosis() ? formula.getEndometriosisTrueValue() : formula.getEndometriosisFalseValue())
                    + (userInput.isOvulatoryDisorder() ? formula.getOvulatoryDisorderTrueValue() : formula.getOvulatoryDisorderFalseValue())
                    + (userInput.isDiminishedOvarianReserve() ? formula.getDiminishedOvarianReserveTrueValue() : formula.getDiminishedOvarianReserveFalseValue())
                    + (userInput.isUterineFactor() ? formula.getUterineFactorTrueValue() : formula.getUterineFactorFalseValue())
                    + (userInput.isOtherReason() ? formula.getOtherReasonTrueValue() : formula.getOtherReasonFalseValue())
                    + (userInput.isUnexplainedInfertility() ? formula.getUnexplainedInfertilityTrueValue() : formula.getUnexplainedInfertilityFalseValue());

            double successRate = transformScoreToSuccessRate(score);
            logger.info("Calculated success rate: {}", successRate);

            return successRate;

        } catch (ValidationException ex) {
            logger.error("Validation error during success rate calculation: {}", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            logger.error("Unexpected error during success rate calculation. UserInput: {}, Formula: {}", userInput, formula, ex);
            throw new RuntimeException("An unexpected error occurred during success rate calculation. Please contact support.", ex);
        }
    }

    private double calculateBmi(int heightFeet, int heightInches, double weight) {
        double totalHeightInInches = (heightFeet * 12) + heightInches;
        return (weight / (totalHeightInInches * totalHeightInInches)) * 703;
    }

    private double getPregnancyValue(int priorPregnancies, Formula formula) {
        if (priorPregnancies == 0) {
            return formula.getPriorPregnancies0Value();
        } else if (priorPregnancies == 1) {
            return formula.getPriorPregnancies1Value();
        } else {
            return formula.getPriorPregnancies2PlusValue();
        }
    }

    private double getLiveBirthValue(int priorLiveBirths, Formula formula) {
        if (priorLiveBirths == 0) {
            return formula.getPriorLiveBirths0Value();
        } else if (priorLiveBirths == 1) {
            return formula.getPriorLiveBirths1Value();
        } else {
            return formula.getPriorLiveBirths2PlusValue();
        }
    }


    private double transformScoreToSuccessRate(double score) {

        return Math.exp(score) / (1 + Math.exp(score));
    }

    public void validatePregnanciesAndLiveBirths(UserInput userInput) {
        int priorPregnancies = userInput.getPriorPregnancies();
        int priorLiveBirths = userInput.getPriorLiveBirths();

        if (priorPregnancies == 0 && priorLiveBirths > 0) {
            throw new ValidationException("If prior pregnancies are 0, prior live births must also be 0.");
        }

        if (priorPregnancies == 1 && priorLiveBirths > 1) {
            throw new ValidationException("If prior pregnancies are 1, prior live births cannot exceed 1.");
        }
    }

    public void validateReasonForInfertility(UserInput userInput) {
        boolean reasonKnown = userInput.isReasonForInfertilityKnown();

        boolean hasSelectedReason = userInput.isTubalFactor() ||
                userInput.isMaleFactorInfertility() ||
                userInput.isEndometriosis() ||
                userInput.isOvulatoryDisorder() ||
                userInput.isDiminishedOvarianReserve() ||
                userInput.isUterineFactor() ||
                userInput.isOtherReason();

        if (reasonKnown && !hasSelectedReason) {
            throw new ValidationException("If the reason for infertility is known, at least one reason must be selected.");
        }

        if (!reasonKnown && hasSelectedReason) {
            throw new ValidationException("If the reason for infertility is not known, no reasons should be selected.");
        }
    }
}
