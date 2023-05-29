package com.vivek.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vivek.insurance.model.Policy;
import com.vivek.insurance.service.PolicyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public ResponseEntity<List<Policy>> getAllInsurancePolicies() {
        List<Policy> policies = policyService.getAllPolicies();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getInsurancePolicyById(@PathVariable Long id) {
        Optional<Policy> policy = policyService.getPolicyById(id);
        return policy.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveThePolicy")
    public ResponseEntity<Policy> createInsurancePolicy(@RequestBody Policy policy) {
        Policy savedPolicy = policyService.savePolicy(policy);
        return new ResponseEntity<>(savedPolicy, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> updateInsurancePolicy(@PathVariable Long id, @RequestBody Policy policy) {
        Policy updatedPolicy = policyService.updatePolicy(id, policy);
        if (updatedPolicy != null) {
            return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurancePolicyById(@PathVariable Long id) {
        policyService.deletePolicyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
