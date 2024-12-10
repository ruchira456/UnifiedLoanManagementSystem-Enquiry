package com.unifiedloansystem.main.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifiedloansystem.main.enums.EnquiryStatus;
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
	

    public List<Enquiry> getEnquiriesByStatus(EnquiryStatus enquiryStatus) {
        return enquiryRepository.findByEnquiryStatus(enquiryStatus);
    }

	@Override
	public Enquiry updateEnquiryStatus(int enquiryId, EnquiryStatus newStatus) {
        // Find enquiry by ID
        Enquiry enquiry = enquiryRepository.findById(enquiryId)
                .orElseThrow(() -> new NoSuchElementException("Enquiry not found with ID: " + enquiryId));

        // Update status
        enquiry.setEnquiryStatus(newStatus);

        // Save updated enquiry
        return enquiryRepository.save(enquiry);
    }
}
