package com.karimerri.aladin_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karimerri.aladin_api.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
