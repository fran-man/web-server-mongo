package com.franm.mongowebapp;

import java.time.LocalDateTime;

public class RequestLog {

    private final LocalDateTime ldt;
    private final String content;
    private final long requestNumber;

    public RequestLog(String content, long requestNumber) {
        this.ldt = LocalDateTime.now();
        this.content = "Hello, " + content + "!";
        this.requestNumber = requestNumber;
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
}
