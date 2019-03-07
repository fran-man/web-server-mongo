package com.franm.mongowebapp.Controllers;

import com.franm.mongowebapp.Mongo.MongoQueryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.franm.mongowebapp.RequestLog;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.bson.Document;
import java.util.List;

@RestController
public class HelloWorldController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private MongoQueryHelper queryHelper;

    private static final String GREETING_ENDPOINT = "/greeting";
    private static final String LOG_ENDPOINT = "/log";

    @RequestMapping(value = GREETING_ENDPOINT, method = RequestMethod.GET)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        RequestLog reqLog = new RequestLog(name, counter.incrementAndGet(), GREETING_ENDPOINT);
        queryHelper.InsertRequestRecord(reqLog);
        return "Hello, " + name + "!";
    }

    @RequestMapping(value = LOG_ENDPOINT, method = RequestMethod.GET)
    public List<Document> getLogs(@RequestParam(value="count", defaultValue="10") String count) {
        RequestLog reqLog = new RequestLog(count, counter.incrementAndGet(), LOG_ENDPOINT);
        queryHelper.InsertRequestRecord(reqLog);
        return this.queryHelper.FetchLogs(Integer.parseInt(count));
    }
}
