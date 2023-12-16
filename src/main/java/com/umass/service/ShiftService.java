package com.umass.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.umass.controller.ShiftController;
import com.umass.model.Shift;
import com.umass.repository.ShiftRepository;
import com.umass.util.DateTimeUtil;

import io.micrometer.common.util.StringUtils;

@Service
public class ShiftService implements ShiftController {
	@Autowired
	private ShiftRepository shiftRepository;

	@Override
	public ResponseEntity<List<Shift>> fetchShift(@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime) {
		List<Shift> shiftresut = shiftRepository.findByStartTimeBetween(DateTimeUtil.parseDateString(startTime, Optional.empty()), 
				DateTimeUtil.parseDateString(endTime, Optional.empty()));
		return ResponseEntity.ok().body(shiftresut);
	}

	@Override
	public ResponseEntity<Shift> createShift(Shift shift) {
		if(StringUtils.isBlank(shift.getId())) {
			shift.setId(String.valueOf(System.currentTimeMillis()));
		}
		return ResponseEntity.ok().body(shiftRepository.save(shift));
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
