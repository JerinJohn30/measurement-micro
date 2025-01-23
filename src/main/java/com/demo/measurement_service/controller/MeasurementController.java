package com.demo.measurement_service.controller;

import com.demo.measurement_service.entity.MeasurementEntity;
import com.demo.measurement_service.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    // Get measurement by customerId
    @GetMapping("/{customerId}")
    public ResponseEntity<MeasurementEntity> getMeasurement(@PathVariable Long customerId) {
        
        return measurementService.getMeasurementsByCustomerId(customerId)
                .map(measurement -> new ResponseEntity<>(measurement, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add new measurement for the customer
    @PostMapping("")
    public ResponseEntity<MeasurementEntity> addMeasurement(@RequestBody MeasurementEntity newMeasurement) {
        MeasurementEntity createdMeasurement = measurementService.addMeasurementByCustomerId(newMeasurement);
        return new ResponseEntity<>(createdMeasurement, HttpStatus.CREATED);
    }

    // Update existing measurement for a given customerId
    @PutMapping("/{customerId}")
    public ResponseEntity<MeasurementEntity> updateMeasurement(
            @PathVariable Long customerId,
            @RequestBody MeasurementEntity updatedMeasurement) {
        
        try {
            MeasurementEntity updated = measurementService.updateMeasurementByCustomerId(customerId, updatedMeasurement);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Measurement not found
        }
    }
}
