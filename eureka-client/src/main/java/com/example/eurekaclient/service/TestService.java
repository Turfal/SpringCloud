package com.example.eurekaclient.service;

import com.example.eurekaclient.model.Tmodel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.tracing.annotation.NewSpan;
import io.micrometer.tracing.annotation.SpanTag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final List<Tmodel> tmodels;

    public TestService(List<Tmodel> tmodels) {
        this.tmodels = tmodels;
    }

    @NewSpan("test")
    @CircuitBreaker(name = "backendService", fallbackMethod = "fallback")
    public List<Tmodel> returnTest(){
            return tmodels;
    }
    @NewSpan("test2")
    public void saveProduct(Tmodel tmodel){
        tmodels.add(tmodel);
    }
    public String fallback(Exception e) {
        return "Сервис временно недоступен";
    }
}
