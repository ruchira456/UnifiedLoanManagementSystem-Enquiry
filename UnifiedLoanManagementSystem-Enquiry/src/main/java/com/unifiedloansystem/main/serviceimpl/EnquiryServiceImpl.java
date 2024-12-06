package com.unifiedloansystem.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifiedloansystem.main.model.Enquiry;
import com.unifiedloansystem.main.repository.EnquiryRepository;
import com.unifiedloansystem.main.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Override
	public Enquiry saveEnquiry(Enquiry enquiry) {
		
		return enquiryRepository.save(enquiry);
	}

	@Override
	public List<Enquiry> getAllEnquiries() {
		return enquiryRepository.findAll();         // Fetches all enquiries from the database
	}
	
}
