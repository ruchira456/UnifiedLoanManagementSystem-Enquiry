package com.unifiedloansystem.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifiedloansystem.main.enums.EnquiryStatus;
import com.unifiedloansystem.main.model.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {


	    List<Enquiry> findByEnquiryStatus(EnquiryStatus enquiryStatus);
	}

