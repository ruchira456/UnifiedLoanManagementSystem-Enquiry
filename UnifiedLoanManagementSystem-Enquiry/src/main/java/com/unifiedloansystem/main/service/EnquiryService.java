package com.unifiedloansystem.main.service;

import java.util.List;

import com.unifiedloansystem.main.model.Enquiry;

public interface EnquiryService {

	public Enquiry saveEnquiry(Enquiry enquiry);

	public List<Enquiry> getAllEnquiries();

}
