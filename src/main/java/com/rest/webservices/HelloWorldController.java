package com.rest.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // == methods ==
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    // == hello-world bean
    @GetMapping("/hello-world-bean")
    public HelloWorld helloWorldBean() {
        return new HelloWorld("Hello Word");
    }
}
