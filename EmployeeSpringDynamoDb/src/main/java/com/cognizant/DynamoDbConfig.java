package com.cognizant;


import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;



@Configuration
@EnableDynamoDBRepositories("com.cognizant")
public class DynamoDbConfig {
	
	@Value("${endpoint}")
	private String dynamoDbEndPoint;
	
	@Value("${accessKey}")
	private String awsAccessKey;
	
	@Value("${secretKey}")
	private String awsSecretKey;
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB amazonDynamoDB= new AmazonDynamoDBClient(credentials());
		if(!ObjectUtils.isEmpty(amazonDynamoDB)) {
			amazonDynamoDB.setEndpoint(dynamoDbEndPoint);
		}
		
		return amazonDynamoDB;
		
	}
	
	@Bean
	public AWSCredentials credentials() {
		
		return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
	}
}
