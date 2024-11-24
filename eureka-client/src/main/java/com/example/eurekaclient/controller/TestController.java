package com.example.eurekaclient.controller;

import com.example.eurekaclient.model.Tmodel;
import com.example.eurekaclient.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import io.micrometer.tracing.annotation.NewSpan;
import io.micrometer.tracing.annotation.SpanTag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/test")
    @NewSpan("test-span")
    public List<Tmodel> test(){
        return testService.returnTest();
    }

    @PostMapping("/test2")
    @NewSpan("test2-span")
    public void saveM(@RequestBody Tmodel tmodel){
        testService.saveProduct(tmodel);
    }
}

