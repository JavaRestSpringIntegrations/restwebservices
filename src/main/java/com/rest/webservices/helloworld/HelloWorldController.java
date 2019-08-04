package com.rest.webservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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

    @GetMapping("/greeting")
    public String greetingInternationalized(@RequestHeader(name = "Accept-Language",required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message",null,locale);
    }

    @GetMapping("/greeting-locale")
    public String greetingInternalizedWithoutParameter() {
        return messageSource.getMessage("good.morning.message",null,
                LocaleContextHolder.getLocale());
    }

}
