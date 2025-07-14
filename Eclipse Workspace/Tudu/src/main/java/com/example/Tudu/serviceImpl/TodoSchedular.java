package com.example.Tudu.serviceImpl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TodoSchedular {
	
	private static final Logger log = LoggerFactory.getLogger(TodoSchedular.class);
	
	@Scheduled(fixedRate = 50000)
	public void reportCurrentTime() {
		log.info("the time is now {}", LocalDateTime.now());
	}
	
	@Scheduled(cron = "0 15 10 * * ?")
    public void dailyTask() {
        log.info("Running daily scheduled task");
    }

}
