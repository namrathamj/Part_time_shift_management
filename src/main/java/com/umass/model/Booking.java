package com.umass.model;

import java.util.Date;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.umass.util.DateTimeUtil;

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

	public void setStartTimeString(String startTimeString) {
		this.startTime = DateTimeUtil.parseDateString(startTimeString, Optional.empty());
	}

	public void setEndTimeString(String endTimeString) {
		this.endTime = DateTimeUtil.parseDateString(endTimeString, Optional.empty());
	}

}
