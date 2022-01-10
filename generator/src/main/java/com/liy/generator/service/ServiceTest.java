package com.liy.generator.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Future;

@Service
public class ServiceTest {

    public Integer execute01() {
        System.out.println("01    " + new Date());
        return 1;
    }

    @Async
    public Integer execute02() {
        sleep(10);
        System.out.println("02    " + new Date());
        return 2;
    }

    @Async
    public Future<Integer> execute01AsyncWithFuture() {
        return AsyncResult.forValue(this.execute01());
    }

    @Async
    public Future<Integer> execute02AsyncWithFuture() {
        return AsyncResult.forValue(this.execute02());
    }

    private static void sleep( int seconds ) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
