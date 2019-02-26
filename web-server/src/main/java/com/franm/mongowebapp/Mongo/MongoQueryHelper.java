package com.franm.mongowebapp.Mongo;

import com.franm.mongowebapp.RequestLog;
import org.bson.Document;
import com.mongodb.client.MongoCollection;

public class MongoQueryHelper{

  private MongoCollection<Document> mongoCollection;
  public MongoQueryHelper(MongoCollection<Document> mongoCollection){
    this.mongoCollection = mongoCollection;
  }

  public void InsertRequestRecord(RequestLog reqLog){
    this.mongoCollection.insertOne(new Document("content", reqLog.getContent()).append("timestamp", reqLog.getLdt().toString()).append("requestNo", reqLog.getRequestNumber()));
  }
}
