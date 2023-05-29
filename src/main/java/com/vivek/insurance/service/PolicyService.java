package com.vivek.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.insurance.model.Policy;
import com.vivek.insurance.repository.PolicyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Optional<Policy> getPolicyById(Long id) {
        return policyRepository.findById(id);
    }

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public void deletePolicyById(Long id) {
        policyRepository.deleteById(id);
    }

    public Policy updatePolicy(Long id, Policy policy) {
        return null;
    }
}
