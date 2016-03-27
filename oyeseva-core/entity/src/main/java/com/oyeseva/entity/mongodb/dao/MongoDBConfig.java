package com.oyeseva.entity.mongodb.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

@Configuration
@ComponentScan
@EnableMongoRepositories
public class MongoDBConfig {

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		Mongo mongo = new Mongo("localhost", 27017);
		String databaseName = "demo";
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo,
				databaseName, null);// userCredentials);
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
		mongoTemplate.setWriteConcern(WriteConcern.SAFE);
		System.out.println(mongoTemplate.collectionExists("test"));
		return mongoTemplate;
	}

	public static void main(String[] args) {
		try {
			new MongoDBConfig().mongoTemplate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
