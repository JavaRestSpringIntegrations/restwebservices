package com.rest.webservices.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping("/filtering")
    public SomeBean someBean() {
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> someListBean() {
        return Arrays.asList(new SomeBean("value1","value2","value3"),
                new SomeBean("value11","value12","value13"));
    }
}
