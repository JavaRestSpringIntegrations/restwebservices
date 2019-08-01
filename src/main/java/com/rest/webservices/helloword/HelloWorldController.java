package com.rest.webservices.helloword;

import com.rest.webservices.helloword.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // == hello-world bean
    @GetMapping("/hello-world-path/{name}")
    public HelloWorld helloWorldBeanPath(@PathVariable String name) {

        return new HelloWorld(String.format("Hello Word, %s",name));
    }
}
