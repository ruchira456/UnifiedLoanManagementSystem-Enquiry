package com.unifiedloansystem.main.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CibilDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cbilId;
	private int cbilScore;
	private String remark;
	@CreationTimestamp
	private Date generatedOn;

}
