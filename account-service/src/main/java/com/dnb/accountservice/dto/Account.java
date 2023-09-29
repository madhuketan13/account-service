package com.dnb.accountservice.dto;

import java.time.LocalDate;

import javax.naming.InvalidNameException;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.accountservice.utils.CustomAccountIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@GenericGenerator(name = "account_seq", strategy = "com.dnb.accountservice.utils.CustomAccountIdGenerator",
	parameters = {@Parameter(name = CustomAccountIdGenerator.INCREMENT_PARAM, value = "50"),
	@Parameter(name = CustomAccountIdGenerator.VALUE_PREFIX_PARAMETER, value = "A_"),
	@Parameter(name = CustomAccountIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	
    @Column String accountId;
	
	
	@Column(nullable = false)
	@NotBlank(message = "Account holder name should not be blank")
	private String accountHolderName;
	
	@Column private String accountType;
	
	@Min(value = 0, message = "Balance must be more than 0")
	@Column private float balance;
	
	@Column(nullable = false)
	//@Length(min = 10 , max = 10)
	@jakarta.validation.constraints.Pattern(regexp = "^[0-9]{10}$",message = "Wrong phoneNumber input")
	private String contactNumber;
	
	@NotBlank(message = "Address should not be blank")
	@Column private String address;
	
	@Column private LocalDate accountCreatedDate = LocalDate.now();
	
	@NotNull(message = "Date must be provided")
	
	@Column private LocalDate dob;
 
	@Transient
	@Column private boolean accountStatus;
	
	private int customerId;
    
    
    public Account(String accountHolderName,String accountType,float balance,String contactNumber,String address,LocalDate accountCreatedDate, LocalDate dob, boolean accountStatus) throws InvalidNameException

	{

		super();

		this.setAccountHolderName(accountHolderName);
		this.setAccountCreatedDate(accountCreatedDate);
		this.setAccountStatus(accountStatus);
		this.setAccountType(accountType);
		this.setAddress(address);
		this.setBalance(balance);
		this.setContactNumber(contactNumber);
		//this.setCustomer(customer);
		this.setDob(dob);

	}
}
