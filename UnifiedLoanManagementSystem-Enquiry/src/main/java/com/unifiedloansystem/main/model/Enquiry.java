package com.unifiedloansystem.main.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.unifiedloansystem.main.enums.EnquiryStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enquiryId;
    private String customerFullName;
    private String contactNumber;
    private String email;
    private String loanType; // Housing, Small Business, Microservices, Car Loan
    private int age;
    private String panCard;
    
    @CreationTimestamp
    private Date registeredOn;
    private EnquiryStatus enquiryStatus; // REGISTERED, PRIMARY_VERIFIED, REJECTED, APPROVED
    
    @OneToOne(cascade = CascadeType.MERGE.REFRESH.REMOVE.DETACH)
    private CibilDetails cibilDetails;
	
}
