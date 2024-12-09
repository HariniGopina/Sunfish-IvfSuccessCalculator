package com.project.ivf_calculator.Controller;

import com.project.ivf_calculator.Model.UserInput;
import com.project.ivf_calculator.Service.IVFCalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/ivf")
public class IVFCalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(IVFCalculatorController.class);

    @Autowired
    private IVFCalculatorService ivfCalculatorService;

    @PostMapping("/calculate")
    @Operation(summary = "Calculate IVF success rate based on user inputs")
    @ApiResponse(responseCode = "200", description = "Success rate calculated successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input provided")
    public ResponseEntity<?> calculateSuccessRate(@Valid @RequestBody UserInput input) {
        try {
            double successRate = ivfCalculatorService.calculateSuccessRate(input);
            logger.info("Successfully calculated success rate: {}", successRate);
            return ResponseEntity.ok(successRate);
        } catch (RuntimeException ex) {
            logger.error("Error occurred: {}", ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
