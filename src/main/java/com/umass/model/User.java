package com.umass.model;

import java.util.Set;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;


@Document(collection = "Users")
@EntityScan
@Builder
@Data
public class User {
	
	@Id
	private String id;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private String username;

	@Field("password")
	private String password;
	
	private Set<String> roles;
}
