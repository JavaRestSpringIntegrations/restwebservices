package com.rest.webservices.helloworld;

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
        System.out.println(name);
        if (name == String.format("test")) // have to tweak this part
            throw new NameInvalidException("name-"+ name);
        return new HelloWorld(String.format("Hello Word, %s",name));
    }

}
