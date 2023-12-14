package com.umass.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "Bookings")
@EntityScan
@Builder
@Data
public class Booking {

	private String id;
	private String userId;
	private String departmentId;
	private String shiftId;
	private String status;
	private String startTime;
	private String endTime;
	
}
