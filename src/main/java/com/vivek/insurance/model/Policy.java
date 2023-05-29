package com.vivek.insurance.model;


import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "policies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Policy {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    String policyNumber;
    String policyHolderName;
    String policyType;
    String policyStatus;
    String coverageAmount;

}
