package com.find.figurefinder;

import com.find.figurefinder.common.GlobalValiable;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.HashMap;

public class ApplicationInitRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        GlobalValiable.setTodayExchageRate(new HashMap<>());
        GlobalValiable.setLanguageTransCount(0);
    }
}
