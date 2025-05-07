package com.example.jeera_.practice.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReminderScheduler {
    public static int count=1;

    // Every 1 minute
    @Scheduled(fixedRate = 1000)
    public void sendReminders() {
        System.out.println("Sending task reminders to users... "+ count);
        count++;
    }
}
