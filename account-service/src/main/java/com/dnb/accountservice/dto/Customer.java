package com.dnb.accountservice.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Customer {
	
	
	public Integer customerId;
	private String customerName;
	private String customerContactNumber;
	private String customerAddress;
	private String customerPAN;
	private String customerUUID;
	
	//@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "customer")
	//@JsonIgnoreProperties("customer")
//	@JsonIgnore
//	private List<Account> accountList = new ArrayList<>();
  

}
