package com.umass.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umass.model.Shift;

@RestController
public interface ShiftController {

//	@GetMapping(path = "/private/api/shifts", produces = "application/json")
//	public ResponseEntity<Shift> fetchShift(@RequestParam(value = "startTime", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startTime,
//			@RequestParam(value = "endTime", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endTime);

	@GetMapping(path = "/private/api/shifts", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<Shift>> fetchShift(@RequestBody Shift shift);
	
	@PostMapping(path = "/private/api/shifts", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Shift> createShift(@RequestBody Shift shift);

	@PutMapping(path = "/private/api/shifts", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> updateShift(@RequestBody Shift shift);

	@DeleteMapping(path = "/private/api/shifts", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> deleteShift(@RequestParam String id);

}
