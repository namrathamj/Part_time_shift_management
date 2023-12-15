package com.umass.model;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Bookings")
@EntityScan
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    
	@Id
	private String id;
	private String userId;
	private ShiftType type;
	private String shiftId;
	private BookingStatus status;
	private Date startTime;
	private Date endTime;
	private String approverUsername;
	
}
