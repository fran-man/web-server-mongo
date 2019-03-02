package com.franm.mongowebapp.Mongo;

import static com.mongodb.client.model.Sorts.*;
import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.FindIterable;
import java.util.List;
import java.util.ArrayList;
import com.mongodb.Block;
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

  public List<Document> FetchLogs(int count){
    List<Document> documents = new ArrayList<>();
    FindIterable<Document> findResult;
    if(count > 0){
      findResult = this.mongoCollection.find().sort(descending("_id")).limit(count);
    }
    else {
      findResult = this.mongoCollection.find().sort(descending("_id"));
    }

    findResult.forEach(new Block<Document>() {
      @Override
      public void apply(Document doc){
        documents.add(doc);
      }
    });

    return documents;
  }
}
