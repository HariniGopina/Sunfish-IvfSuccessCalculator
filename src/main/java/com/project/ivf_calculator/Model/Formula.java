package com.project.ivf_calculator.Model;

import com.opencsv.bean.CsvBindByName;

public class Formula {

    @CsvBindByName(column = "param_using_own_eggs")
    private boolean usingOwnEggs;

    @CsvBindByName(column = "param_attempted_ivf_previously")
    private String attemptedIVFPreviously;

    @CsvBindByName(column = "param_is_reason_for_infertility_known")
    private boolean reasonForInfertilityKnown;

    @CsvBindByName(column = "cdc_formula")
    private String formulaId;

    @CsvBindByName(column = "formula_intercept")
    private double intercept;

    @CsvBindByName(column = "formula_age_linear_coefficient")
    private double ageLinearCoefficient;

    @CsvBindByName(column = "formula_age_power_coefficient")
    private double agePowerCoefficient;

    @CsvBindByName(column = "formula_age_power_factor")
    private double agePowerFactor;

    @CsvBindByName(column = "formula_bmi_linear_coefficient")
    private double bmiLinearCoefficient;

    @CsvBindByName(column = "formula_bmi_power_coefficient")
    private double bmiPowerCoefficient;

    @CsvBindByName(column = "formula_bmi_power_factor")
    private double bmiPowerFactor;

    @CsvBindByName(column = "formula_tubal_factor_true_value")
    private double tubalFactorTrueValue;

    @CsvBindByName(column = "formula_tubal_factor_false_value")
    private double tubalFactorFalseValue;

    @CsvBindByName(column = "formula_male_factor_infertility_true_value")
    private double maleFactorInfertilityTrueValue;

    @CsvBindByName(column = "formula_male_factor_infertility_false_value")
    private double maleFactorInfertilityFalseValue;

    @CsvBindByName(column = "formula_endometriosis_true_value")
    private double endometriosisTrueValue;

    @CsvBindByName(column = "formula_endometriosis_false_value")
    private double endometriosisFalseValue;

    @CsvBindByName(column = "formula_ovulatory_disorder_true_value")
    private double ovulatoryDisorderTrueValue;

    @CsvBindByName(column = "formula_ovulatory_disorder_false_value")
    private double ovulatoryDisorderFalseValue;

    @CsvBindByName(column = "formula_diminished_ovarian_reserve_true_value")
    private double diminishedOvarianReserveTrueValue;

    @CsvBindByName(column = "formula_diminished_ovarian_reserve_false_value")
    private double diminishedOvarianReserveFalseValue;

    @CsvBindByName(column = "formula_uterine_factor_true_value")
    private double uterineFactorTrueValue;

    @CsvBindByName(column = "formula_uterine_factor_false_value")
    private double uterineFactorFalseValue;

    @CsvBindByName(column = "formula_other_reason_true_value")
    private double otherReasonTrueValue;

    @CsvBindByName(column = "formula_other_reason_false_value")
    private double otherReasonFalseValue;

    @CsvBindByName(column = "formula_unexplained_infertility_true_value")
    private double unexplainedInfertilityTrueValue;

    @CsvBindByName(column = "formula_unexplained_infertility_false_value")
    private double unexplainedInfertilityFalseValue;

    @CsvBindByName(column = "formula_prior_pregnancies_0_value")
    private double priorPregnancies0Value;

    @CsvBindByName(column = "formula_prior_pregnancies_1_value")
    private double priorPregnancies1Value;

    @CsvBindByName(column = "formula_prior_pregnancies_2+_value")
    private double priorPregnancies2PlusValue;

    @CsvBindByName(column = "formula_prior_live_births_0_value")
    private double priorLiveBirths0Value;

    @CsvBindByName(column = "formula_prior_live_births_1_value")
    private double priorLiveBirths1Value;

    @CsvBindByName(column = "formula_prior_live_births_2+_value")
    private double priorLiveBirths2PlusValue;


    public boolean isUsingOwnEggs() {
        return usingOwnEggs;
    }

    public void setUsingOwnEggs(boolean usingOwnEggs) {
        this.usingOwnEggs = usingOwnEggs;
    }

    public double getAgeLinearCoefficient() {
        return ageLinearCoefficient;
    }

    public void setAgeLinearCoefficient(double ageLinearCoefficient) {
        this.ageLinearCoefficient = ageLinearCoefficient;
    }

    public String getAttemptedIVFPreviously() {
        return attemptedIVFPreviously;
    }

    public void setAttemptedIVFPreviously(String attemptedIVFPreviously) {
        this.attemptedIVFPreviously = attemptedIVFPreviously;
    }

    public boolean isReasonForInfertilityKnown() {
        return reasonForInfertilityKnown;
    }

    public void setReasonForInfertilityKnown(boolean reasonForInfertilityKnown) {
        this.reasonForInfertilityKnown = reasonForInfertilityKnown;
    }

    public double getIntercept() {
        return intercept;
    }

    public void setIntercept(double intercept) {
        this.intercept = intercept;
    }

    public String getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(String formulaId) {
        this.formulaId = formulaId;
    }

    public double getAgePowerCoefficient() {
        return agePowerCoefficient;
    }

    public void setAgePowerCoefficient(double agePowerCoefficient) {
        this.agePowerCoefficient = agePowerCoefficient;
    }

    public double getAgePowerFactor() {
        return agePowerFactor;
    }

    public void setAgePowerFactor(double agePowerFactor) {
        this.agePowerFactor = agePowerFactor;
    }

    public double getBmiLinearCoefficient() {
        return bmiLinearCoefficient;
    }

    public void setBmiLinearCoefficient(double bmiLinearCoefficient) {
        this.bmiLinearCoefficient = bmiLinearCoefficient;
    }

    public double getBmiPowerCoefficient() {
        return bmiPowerCoefficient;
    }

    public void setBmiPowerCoefficient(double bmiPowerCoefficient) {
        this.bmiPowerCoefficient = bmiPowerCoefficient;
    }

    public double getBmiPowerFactor() {
        return bmiPowerFactor;
    }

    public void setBmiPowerFactor(double bmiPowerFactor) {
        this.bmiPowerFactor = bmiPowerFactor;
    }

    public double getTubalFactorTrueValue() {
        return tubalFactorTrueValue;
    }

    public void setTubalFactorTrueValue(double tubalFactorTrueValue) {
        this.tubalFactorTrueValue = tubalFactorTrueValue;
    }

    public double getTubalFactorFalseValue() {
        return tubalFactorFalseValue;
    }

    public void setTubalFactorFalseValue(double tubalFactorFalseValue) {
        this.tubalFactorFalseValue = tubalFactorFalseValue;
    }

    public double getMaleFactorInfertilityTrueValue() {
        return maleFactorInfertilityTrueValue;
    }

    public void setMaleFactorInfertilityTrueValue(double maleFactorInfertilityTrueValue) {
        this.maleFactorInfertilityTrueValue = maleFactorInfertilityTrueValue;
    }

    public double getMaleFactorInfertilityFalseValue() {
        return maleFactorInfertilityFalseValue;
    }

    public void setMaleFactorInfertilityFalseValue(double maleFactorInfertilityFalseValue) {
        this.maleFactorInfertilityFalseValue = maleFactorInfertilityFalseValue;
    }

    public double getEndometriosisTrueValue() {
        return endometriosisTrueValue;
    }

    public void setEndometriosisTrueValue(double endometriosisTrueValue) {
        this.endometriosisTrueValue = endometriosisTrueValue;
    }

    public double getEndometriosisFalseValue() {
        return endometriosisFalseValue;
    }

    public void setEndometriosisFalseValue(double endometriosisFalseValue) {
        this.endometriosisFalseValue = endometriosisFalseValue;
    }

    public double getOvulatoryDisorderTrueValue() {
        return ovulatoryDisorderTrueValue;
    }

    public void setOvulatoryDisorderTrueValue(double ovulatoryDisorderTrueValue) {
        this.ovulatoryDisorderTrueValue = ovulatoryDisorderTrueValue;
    }

    public double getDiminishedOvarianReserveTrueValue() {
        return diminishedOvarianReserveTrueValue;
    }

    public void setDiminishedOvarianReserveTrueValue(double diminishedOvarianReserveTrueValue) {
        this.diminishedOvarianReserveTrueValue = diminishedOvarianReserveTrueValue;
    }

    public double getOvulatoryDisorderFalseValue() {
        return ovulatoryDisorderFalseValue;
    }

    public void setOvulatoryDisorderFalseValue(double ovulatoryDisorderFalseValue) {
        this.ovulatoryDisorderFalseValue = ovulatoryDisorderFalseValue;
    }

    public double getDiminishedOvarianReserveFalseValue() {
        return diminishedOvarianReserveFalseValue;
    }

    public void setDiminishedOvarianReserveFalseValue(double diminishedOvarianReserveFalseValue) {
        this.diminishedOvarianReserveFalseValue = diminishedOvarianReserveFalseValue;
    }

    public double getUterineFactorTrueValue() {
        return uterineFactorTrueValue;
    }

    public void setUterineFactorTrueValue(double uterineFactorTrueValue) {
        this.uterineFactorTrueValue = uterineFactorTrueValue;
    }

    public double getUterineFactorFalseValue() {
        return uterineFactorFalseValue;
    }

    public void setUterineFactorFalseValue(double uterineFactorFalseValue) {
        this.uterineFactorFalseValue = uterineFactorFalseValue;
    }

    public double getOtherReasonTrueValue() {
        return otherReasonTrueValue;
    }

    public void setOtherReasonTrueValue(double otherReasonTrueValue) {
        this.otherReasonTrueValue = otherReasonTrueValue;
    }

    public double getOtherReasonFalseValue() {
        return otherReasonFalseValue;
    }

    public void setOtherReasonFalseValue(double otherReasonFalseValue) {
        this.otherReasonFalseValue = otherReasonFalseValue;
    }

    public double getUnexplainedInfertilityTrueValue() {
        return unexplainedInfertilityTrueValue;
    }

    public void setUnexplainedInfertilityTrueValue(double unexplainedInfertilityTrueValue) {
        this.unexplainedInfertilityTrueValue = unexplainedInfertilityTrueValue;
    }

    public double getUnexplainedInfertilityFalseValue() {
        return unexplainedInfertilityFalseValue;
    }

    public void setUnexplainedInfertilityFalseValue(double unexplainedInfertilityFalseValue) {
        this.unexplainedInfertilityFalseValue = unexplainedInfertilityFalseValue;
    }

    public double getPriorPregnancies0Value() {
        return priorPregnancies0Value;
    }

    public void setPriorPregnancies0Value(double priorPregnancies0Value) {
        this.priorPregnancies0Value = priorPregnancies0Value;
    }

    public double getPriorPregnancies1Value() {
        return priorPregnancies1Value;
    }

    public void setPriorPregnancies1Value(double priorPregnancies1Value) {
        this.priorPregnancies1Value = priorPregnancies1Value;
    }

    public double getPriorPregnancies2PlusValue() {
        return priorPregnancies2PlusValue;
    }

    public void setPriorPregnancies2PlusValue(double priorPregnancies2PlusValue) {
        this.priorPregnancies2PlusValue = priorPregnancies2PlusValue;
    }

    public double getPriorLiveBirths0Value() {
        return priorLiveBirths0Value;
    }

    public void setPriorLiveBirths0Value(double priorLiveBirths0Value) {
        this.priorLiveBirths0Value = priorLiveBirths0Value;
    }

    public double getPriorLiveBirths1Value() {
        return priorLiveBirths1Value;
    }

    public void setPriorLiveBirths1Value(double priorLiveBirths1Value) {
        this.priorLiveBirths1Value = priorLiveBirths1Value;
    }

    public double getPriorLiveBirths2PlusValue() {
        return priorLiveBirths2PlusValue;
    }

    public void setPriorLiveBirths2PlusValue(double priorLiveBirths2PlusValue) {
        this.priorLiveBirths2PlusValue = priorLiveBirths2PlusValue;
    }
}
