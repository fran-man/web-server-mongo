package com.franm.mongowebapp.Configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfig {
    @Bean
    public MongoClient mongodbClient(){
      return new MongoClient("localhost", 27017);
    }
}
