package com.hkdev.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

@Service
public class HealthService implements HealthIndicator {

    private Counter counter;

    @Override
    public Health health() {
        boolean isWeak = counter.isWeak();

        if(isWeak) {
            return Health.outOfService().withDetail("Too many requests", "OutOfService").build();
        }

        return Health.up().build();
    }

    public void updateHealthCounter() {
        if(counter == null || counter.isExpired()) {
            counter = new Counter();
        }
        counter.increment();
    }
}
