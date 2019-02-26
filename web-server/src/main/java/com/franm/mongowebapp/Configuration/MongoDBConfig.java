package com.franm.mongowebapp.Configuration;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.franm.mongowebapp.Mongo.MongoQueryHelper;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfig {
    @Bean
    public MongoClient mongodbClient(){
      return new MongoClient("localhost", 27017);
    }

    @Bean
    public MongoDatabase mongodb(MongoClient mongoClient){
      return mongoClient.getDatabase("AccessLog");
    }

    @Bean
    public MongoCollection<Document> mongoCollection(MongoDatabase mongodb){
      return mongodb.getCollection("logColl");
    }

    @Bean
    public MongoQueryHelper qryHelper(MongoCollection<Document> mongocoll){
      return new MongoQueryHelper(mongocoll);
    }
}
