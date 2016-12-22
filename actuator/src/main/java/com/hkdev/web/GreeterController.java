package com.hkdev.web;

import com.hkdev.health.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {

    @Autowired
    private HealthService healthService;

    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    @RequestMapping
    public String greet() {
        healthService.updateHealthCounter();
        counterService.increment("greet.count");
        gaugeService.submit("greet.customgauge", 1.0);
        return "Hello World!";
    }
}
