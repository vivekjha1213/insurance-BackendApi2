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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

  // constructors, getters, setters
@Table(name = "claims")
public class Claim {

  @Id
 // @GeneratedValue(strategy = GenerationType.IDENTITY)
  String claimId;
  String policyNumber;
  String StringclaimAmount;
  String claimDescription;
  String claimStatus;
  String Pending;

}
