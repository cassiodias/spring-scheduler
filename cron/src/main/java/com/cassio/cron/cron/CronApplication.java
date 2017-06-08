package com.cassio.cron.cron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Configuration
public class CronApplication {

    public static void main(String[] args) {
        SpringApplication.run(CronApplication.class, args);
    }

    @Bean
    ParkedPivotManager parkedPivotManager() {
        ParkedPivotManager parkedPivotManager = new ParkedPivotManager();
        parkedPivotManager.add(new ParkedPivot(1, new Pivot(1)));
        parkedPivotManager.add(new ParkedPivot(2, new Pivot(2)));
        parkedPivotManager.add(new ParkedPivot(3, new Pivot(3)));
        return parkedPivotManager;
    }

}
