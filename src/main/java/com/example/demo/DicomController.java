package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DicomController {

	@Autowired
	private DicomService dicomService;

	@GetMapping("/processDicom")
	public String processDicom() {
		dicomService.readAndWriteDicom();
		return "DICOM file processed successfully!";
	}
}
