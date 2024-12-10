package com.unifiedloansystem.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifiedloansystem.main.enums.EnquiryStatus;
import com.unifiedloansystem.main.model.Enquiry;
import com.unifiedloansystem.main.service.EnquiryService;

import jakarta.validation.Valid;

@RequestMapping("/enquiry")
@RestController
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;
	 
	@PostMapping("/save-enquiry")
	 public ResponseEntity<?> onSaveEnquiry(@Valid @RequestBody Enquiry enquiry, BindingResult bindingResult)
	{
        if (bindingResult.hasErrors()) 
        {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Enquiry enquiryRef = enquiryService.saveEnquiry(enquiry);
        return new ResponseEntity<Enquiry>(enquiryRef, HttpStatus.CREATED);
	}
	
	 @GetMapping("/expose-enquiries")
	    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
	        List<Enquiry> enquiries = enquiryService.getAllEnquiries();
	        return ResponseEntity.ok(enquiries);
	    }

	 @GetMapping("/expose-enquiries/{enquiryStatus}")
	    public ResponseEntity<List<Enquiry>> getEnquiriesByStatus(@PathVariable("enquiryStatus") String enquiryStatus) {
	        try {
	            EnquiryStatus status = EnquiryStatus.valueOf(enquiryStatus.toUpperCase()); // Validate and convert input to enum
	            List<Enquiry> filteredEnquiries = enquiryService.getEnquiriesByStatus(status);

	            if (filteredEnquiries.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No enquiries found for the given status
	            }
	            return new ResponseEntity<>(filteredEnquiries, HttpStatus.OK);
	        } catch (IllegalArgumentException e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid status provided
	        }
	    }
	 
	  @PatchMapping("/update-enquiry-status/{enquiryId}/{enquiryStatus}")
	    public ResponseEntity<Enquiry> updateEnquiryStatus(
	            @PathVariable("enquiryId") int enquiryId,
	            @PathVariable("enquiryStatus") String enquiryStatus) {
	        try {
	            EnquiryStatus status = EnquiryStatus.valueOf(enquiryStatus.toUpperCase()); // Validate status
	            Enquiry updatedEnquiry = enquiryService.updateEnquiryStatus(enquiryId, status);

	            return new ResponseEntity<>(updatedEnquiry, HttpStatus.OK);
	        } catch (IllegalArgumentException e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid status
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Enquiry not found
	        }
	    }
	
}
