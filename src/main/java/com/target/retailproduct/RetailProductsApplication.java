package com.target.retailproduct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

@SpringBootApplication
public class RetailProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailProductsApplication.class, args);
	}
	
	@Value("${com.target.retail.mongo.db.name}")
    private String mongoDbName;
	
	@Value("${com.target.retail.mongo.db.connect.timeout}")
	private int connectTimeout;
	
	@Value("${com.target.retail.mongo.db.host}")
	private String host;
	
	@Value("${com.target.retailproduct.readtimeout}")
	private int timeout;
	
	@Bean
	public MongoClient getMongoClient(){
		MongoClientOptions mco = MongoClientOptions.builder().connectTimeout(connectTimeout).serverSelectionTimeout(connectTimeout).build();
		return new MongoClient(host,mco);
	}
	
	@Bean
	public MongoDbFactory getMongoDbFactory(){
		return new SimpleMongoDbFactory(getMongoClient(),mongoDbName);
	}
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(clientHttpRequestFactory());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(timeout);
        factory.setConnectTimeout(500);
        return factory;
    }
	
}

