package com.vivek.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.insurance.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
