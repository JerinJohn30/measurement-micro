package com.demo.measurement_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="measurement_details")
public class MeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="measurement_id")
    private Long measurementId;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name="neck_size")
    private Double neckSize;
    @Column(name="chest_size")
    private Double chestSize;
    @Column(name="shoulder_length")
    private Double shoulderLength;
    @Column(name="sleeve_length")
    private Double sleeveLength;
    @Column(name="jacket_length")
    private Double jacketLength;
    @Column(name="waist_size")
    private Double waistSize;
    @Column(name="hip_size")
    private Double hipSize;
    @Column(name="pant_length")
    private Double pantLength;
    
}
