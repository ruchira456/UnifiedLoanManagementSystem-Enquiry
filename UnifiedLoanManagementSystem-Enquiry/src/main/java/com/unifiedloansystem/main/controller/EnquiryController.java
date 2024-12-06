package com.unifiedloansystem.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	
}
