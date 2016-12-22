package com.hkdev.health;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.LongAdder;

public class Counter {

    private LongAdder counter;
    private int threshold = 3;
    private LocalDateTime expiry;

    public Counter() {
        this.counter = new LongAdder();
        this.expiry = LocalDateTime.now(Clock.systemUTC());
        this.expiry = this.expiry.plusMinutes(1L);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiry);
    }

    public boolean isWeak() {
        return counter.intValue() > threshold;
    }

    public void increment() {
        counter.increment();
    }
}
