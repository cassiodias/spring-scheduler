package com.cassio.cron.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronManager {

    @Autowired
    ParkedPivotManager parkedPivotManager;

    @Scheduled(fixedDelay=5000)
    void proceed(){
        if (parkedPivotManager.waitingPivots() > 0) {
            parkedPivotManager.deleteOverdue();
        }
    }

}
