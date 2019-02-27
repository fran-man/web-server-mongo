package com.franm.mongowebapp;

import java.time.LocalDateTime;

public class RequestLog {

    private final LocalDateTime ldt;
    private final String content;
    private final String endpoint;
    private final long requestNumber;

    public RequestLog(String content, long requestNumber, String endpoint) {
        this.ldt = LocalDateTime.now();
        this.content = "Hello, " + content + "!";
        this.requestNumber = requestNumber;
        this.endpoint = endpoint;
    }

    public LocalDateTime getLdt() {
        return this.ldt;
    }

    public String getContent() {
        return this.content;
    }

    public long getRequestNumber() {
        return this.requestNumber;
    }

    public String getEndpoint() {
        return this.endpoint;
    }
}
