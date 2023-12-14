package com.umass.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.umass.controller.ShiftController;
import com.umass.model.Shift;
import com.umass.repository.ShiftRepository;
import com.umass.util.DateTimeUtil;

@Service
public class ShiftService implements ShiftController {
	@Autowired
	private ShiftRepository shiftRepository;

//	@Override
//	public ResponseEntity<Shift> fetchShift(String startTime, String endTime) {
//		Shift shift = shiftRepository.findByStartTimeBetween(DateTimeUtil.parseDateString(startTime,Optional.empty()),
//				DateTimeUtil.parseDateString(endTime,Optional.empty()));
//		System.out.println(shift);
//		return ResponseEntity.ok().body(shift);
//	}
	
	@Override
	public ResponseEntity<Shift> fetchShift(Date startTime, Date endTime) {
		Shift shift = shiftRepository.findByStartTimeBetween(startTime, endTime);
		System.out.println(shift);
		return ResponseEntity.ok().body(shift);
	}

	@Override
	public ResponseEntity<Shift> createShift(Shift shift) {
		shiftRepository.save(shift);
		return null;
	}

	@Override
	public ResponseEntity<String> updateShift(Shift shift) {
		Optional<Shift> shiftOptional = shiftRepository.findById(shift.getId());
		if (shiftOptional.isPresent()) {
			shiftRepository.save(shift);
			return ResponseEntity.ok().body("Shift updated");
		}
		return ResponseEntity.ok().body("Shift Not updated");
	}

	@Override
	public ResponseEntity<String> deleteShift(String id) {
		Optional<Shift> shiftOptional = shiftRepository.findById(id);
		if (shiftOptional.isPresent()) {
			shiftRepository.deleteById(id);
			return ResponseEntity.ok().body("Shift deleted");
		}
		return ResponseEntity.ok().body("Shift Not deleted");
	}

}
