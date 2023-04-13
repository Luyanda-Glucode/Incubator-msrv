package com.Incubatormsrv.Incubatormsrv.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Component
public class ThreadExecutor {
    private final ExecutorService executor;

    public ThreadExecutor(@Value("${weather.noOfThreads}") int thread) {
        this.executor =  Executors.newFixedThreadPool(thread);
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
