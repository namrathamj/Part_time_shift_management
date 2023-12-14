package com.umass.model;

import java.util.Date;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.umass.util.DateTimeUtil;

import lombok.Builder;
import lombok.Data;

@Document(collection = "Shifts")
@EntityScan
@Builder
@Data
public class Shift {

	@Id
	private String id;

	@Field
	private Date startTime;
	@Field
	private Date endTime;
	@Field
	private ShiftType type;
	@Field
	private Integer capacity;

	public void setStartTimeString(String startTimeString) {
		this.startTime = DateTimeUtil.parseDateString(startTimeString, Optional.empty());
	}

	public void setEndTimeString(String endTimeString) {
		this.endTime = DateTimeUtil.parseDateString(endTimeString, Optional.empty());
	}
}
