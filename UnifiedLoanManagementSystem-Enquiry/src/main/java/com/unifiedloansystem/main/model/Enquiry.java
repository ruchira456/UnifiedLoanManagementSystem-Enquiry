package com.unifiedloansystem.main.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.unifiedloansystem.main.enums.EnquiryStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    private Long enquiryId;

    @NotBlank(message = "Customer full name is required")
    @NotEmpty
    @NotNull
    private String customerFullName;

   // @NotBlank(message = "Contact number is required")
   // @Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits")
    private long contactNumber;

    @Email(message = "Invalid email format")
    @NotEmpty
    @NotNull
    private String email;

    @NotBlank(message = "Loan type is required")
    @NotEmpty
    @NotNull
    private String loanType; // Housing, Small Business, Microservices, Car Loan

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must not exceed 70")
    private int age;

    @NotBlank(message = "PAN card is required")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]", message = "Invalid PAN card format")
    @NotEmpty
    @NotNull
    private String panCard;

    @CreationTimestamp
    private Date registeredOn;

    @Enumerated(EnumType.STRING)
    private EnquiryStatus enquiryStatus; // REGISTERED, PRIMARY_VERIFIED, REJECTED, APPROVED

    @OneToOne(cascade = CascadeType.MERGE.REFRESH.REMOVE.DETACH)
    private CibilDetails cibilDetails;
	
}
