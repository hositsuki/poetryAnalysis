package edu.dhu.poetryanalysis.controller;

import edu.dhu.poetryanalysis.domain.Test;
import edu.dhu.poetryanalysis.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Value("${test.hello:test}")
    private String hello;

    @Resource
    private TestService testService;

    @RequestMapping("/hello")
    public String Hello() {
        return "Hello World!" + hello;
    }

    @GetMapping("/test")
    public List<Test> Test() {
        return testService.list();
    }
}
