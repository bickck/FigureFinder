package com.find.figurefinder;

import com.find.figurefinder.common.GlobalValiue;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.HashMap;

public class ApplicationInitRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        GlobalValiue.setTodayExchageRate(new HashMap<>());
        GlobalValiue.setLanguageTransCount(0);
    }
}
