package com.vivek.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.insurance.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
