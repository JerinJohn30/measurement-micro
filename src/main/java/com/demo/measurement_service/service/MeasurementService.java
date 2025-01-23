package com.demo.measurement_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.measurement_service.entity.MeasurementEntity;
import com.demo.measurement_service.repo.MeasurementRepository;

import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    // Get measurement by customerId
    public Optional<MeasurementEntity> getMeasurementsByCustomerId(Long customerId) {
        return measurementRepository.findByCustomerId(customerId);
    }

    // Add new measurement for the customer
    public MeasurementEntity addMeasurementByCustomerId(MeasurementEntity newMeasurement) {
        return measurementRepository.saveAndFlush(newMeasurement);
    }

    // Update measurement for a customer by customerId
    public MeasurementEntity updateMeasurementByCustomerId(Long customerId, MeasurementEntity updatedMeasurement) {
        // Retrieve the existing measurement for the given customerId
        MeasurementEntity existingMeasurement = measurementRepository.findByCustomerId(customerId).orElse(null); 
        // Update fields only if the updated values are not null
        if (updatedMeasurement.getNeckSize() != null) {
            existingMeasurement.setNeckSize(updatedMeasurement.getNeckSize());
        }
        if (updatedMeasurement.getChestSize() != null) {
            existingMeasurement.setChestSize(updatedMeasurement.getChestSize());
        }
        if (updatedMeasurement.getShoulderLength() != null) {
            existingMeasurement.setShoulderLength(updatedMeasurement.getShoulderLength());
        }
        if (updatedMeasurement.getSleeveLength() != null) {
            existingMeasurement.setSleeveLength(updatedMeasurement.getSleeveLength());
        }
        if (updatedMeasurement.getJacketLength() != null) {
            existingMeasurement.setJacketLength(updatedMeasurement.getJacketLength());
        }
        if (updatedMeasurement.getWaistSize() != null) {
            existingMeasurement.setWaistSize(updatedMeasurement.getWaistSize());
        }
        if (updatedMeasurement.getHipSize() != null) {
            existingMeasurement.setHipSize(updatedMeasurement.getHipSize());
        }
        if (updatedMeasurement.getPantLength() != null) {
            existingMeasurement.setPantLength(updatedMeasurement.getPantLength());
        }

        // Save and return the updated entity
        return measurementRepository.save(existingMeasurement);
    }
}
