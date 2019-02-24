package com.franm.mongowebapp;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello, " + name +"!" + "\nThis has been called " + this.counter.getAndIncrement() + " times!";
    }
}
