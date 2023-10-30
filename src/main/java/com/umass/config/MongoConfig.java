package com.umass.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	private static final String CONNECTION_STRING = "mongodb://localhost:27017";

	@Override
	protected String getDatabaseName() {
		return "ShiftManagement";
	}

	@Override
	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

}
