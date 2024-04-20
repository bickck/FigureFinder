package com.find.figurefinder.schedule;

import com.find.figurefinder.common.GlobalValiue;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LanguageTransSchedule {

    @Scheduled(cron = "0 0 0 24 * * ?")
    public void run() {
        GlobalValiue.setLanguageTransCount(0);
    }

}
