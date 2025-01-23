package com.demo.measurement_service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.measurement_service.entity.MeasurementEntity;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity,Long> {
    Optional<MeasurementEntity> findByCustomerId(Long customerId);
}
