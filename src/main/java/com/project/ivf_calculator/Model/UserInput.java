package com.project.ivf_calculator.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserInput {

    @NotNull(message = "Using own eggs must be specified")
    private boolean usingOwnEggs;

    @NotBlank(message = "Attempted IVF previously must be specified")
    private String attemptedIVFPreviously;

    @NotNull(message = "Reason for infertility knowledge must be specified")
    private boolean reasonForInfertilityKnown;

    @Min(value = 20, message = "Age must be at least 20")
    @Max(value = 50, message = "Age must not exceed 50")
    private int age;

    @Min(value = 80, message = "Weight must be at least 80 lbs")
    @Max(value = 300, message = "Weight must not exceed 300 lbs")
    private double weight;

    @Min(value = 0, message = "Height (feet) must not be negative")
    @Max(value = 6, message = "Height (feet) must not exceed 8")
    @NotNull(message = "height must be entered")
    private int heightFeet;

    @Min(value = 0, message = "Height (inches) must not be negative")
    @Max(value = 11, message = "Height (inches) must not exceed 11")
    private int heightInches;


    private boolean tubalFactor;
    private boolean maleFactorInfertility;
    private boolean endometriosis;
    private boolean ovulatoryDisorder;
    private boolean diminishedOvarianReserve;
    private boolean uterineFactor;
    private boolean otherReason;
    private boolean unexplainedInfertility;

    @Min(value = 0, message = "Prior pregnancies must not be negative")
    private int priorPregnancies;

    @Min(value = 0, message = "Prior live births must not be negative")
    private int priorLiveBirths;


    @NotNull(message = "Using own eggs must be specified")
    public boolean isUsingOwnEggs() {
        return usingOwnEggs;
    }

    public void setUsingOwnEggs(@NotNull(message = "Using own eggs must be specified") boolean usingOwnEggs) {
        this.usingOwnEggs = usingOwnEggs;
    }

    public @NotBlank(message = "Attempted IVF previously must be specified") String getAttemptedIVFPreviously() {
        return attemptedIVFPreviously;
    }

    public void setAttemptedIVFPreviously(@NotBlank(message = "Attempted IVF previously must be specified") String attemptedIVFPreviously) {
        this.attemptedIVFPreviously = attemptedIVFPreviously;
    }

    @NotNull(message = "Reason for infertility knowledge must be specified")
    public boolean isReasonForInfertilityKnown() {
        return reasonForInfertilityKnown;
    }

    public void setReasonForInfertilityKnown(@NotNull(message = "Reason for infertility knowledge must be specified") boolean reasonForInfertilityKnown) {
        this.reasonForInfertilityKnown = reasonForInfertilityKnown;
    }

    @Min(value = 20, message = "Age must be at least 20")
    @Max(value = 50, message = "Age must not exceed 50")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 20, message = "Age must be at least 20") @Max(value = 50, message = "Age must not exceed 50") int age) {
        this.age = age;
    }

    @Min(value = 0, message = "Height (feet) must not be negative")
    @Max(value = 8, message = "Height (feet) must not exceed 8")
    public int getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(@Min(value = 0, message = "Height (feet) must not be negative") @Max(value = 8, message = "Height (feet) must not exceed 8") int heightFeet) {
        this.heightFeet = heightFeet;
    }

    @Min(value = 0, message = "Height (inches) must not be negative")
    @Max(value = 11, message = "Height (inches) must not exceed 11")
    public int getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(@Min(value = 0, message = "Height (inches) must not be negative") @Max(value = 11, message = "Height (inches) must not exceed 11") int heightInches) {
        this.heightInches = heightInches;
    }

    @Min(value = 80, message = "Weight must be at least 80 lbs")
    @Max(value = 300, message = "Weight must not exceed 300 lbs")
    public double getWeight() {
        return weight;
    }

    public void setWeight(@Min(value = 80, message = "Weight must be at least 80 lbs") @Max(value = 300, message = "Weight must not exceed 300 lbs") double weight) {
        this.weight = weight;
    }

    public boolean isTubalFactor() {
        return tubalFactor;
    }

    public void setTubalFactor(boolean tubalFactor) {
        this.tubalFactor = tubalFactor;
    }

    public boolean isMaleFactorInfertility() {
        return maleFactorInfertility;
    }

    public void setMaleFactorInfertility(boolean maleFactorInfertility) {
        this.maleFactorInfertility = maleFactorInfertility;
    }

    public boolean isEndometriosis() {
        return endometriosis;
    }

    public void setEndometriosis(boolean endometriosis) {
        this.endometriosis = endometriosis;
    }

    public boolean isOvulatoryDisorder() {
        return ovulatoryDisorder;
    }

    public void setOvulatoryDisorder(boolean ovulatoryDisorder) {
        this.ovulatoryDisorder = ovulatoryDisorder;
    }

    public boolean isUterineFactor() {
        return uterineFactor;
    }

    public void setUterineFactor(boolean uterineFactor) {
        this.uterineFactor = uterineFactor;
    }

    public boolean isDiminishedOvarianReserve() {
        return diminishedOvarianReserve;
    }

    public void setDiminishedOvarianReserve(boolean diminishedOvarianReserve) {
        this.diminishedOvarianReserve = diminishedOvarianReserve;
    }

    public boolean isOtherReason() {
        return otherReason;
    }

    public void setOtherReason(boolean otherReason) {
        this.otherReason = otherReason;
    }

    public boolean isUnexplainedInfertility() {
        return unexplainedInfertility;
    }

    public void setUnexplainedInfertility(boolean unexplainedInfertility) {
        this.unexplainedInfertility = unexplainedInfertility;
    }

    @Min(value = 0, message = "Prior pregnancies must not be negative")
    public int getPriorPregnancies() {
        return priorPregnancies;
    }

    public void setPriorPregnancies(@Min(value = 0, message = "Prior pregnancies must not be negative") int priorPregnancies) {
        this.priorPregnancies = priorPregnancies;
    }

    @Min(value = 0, message = "Prior live births must not be negative")
    public int getPriorLiveBirths() {
        return priorLiveBirths;
    }

    public void setPriorLiveBirths(@Min(value = 0, message = "Prior live births must not be negative") int priorLiveBirths) {
        this.priorLiveBirths = priorLiveBirths;
    }
}
