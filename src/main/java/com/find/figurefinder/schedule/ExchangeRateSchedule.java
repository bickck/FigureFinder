package com.find.figurefinder.schedule;

import com.find.figurefinder.common.GlobalValiue;
import com.find.figurefinder.transformation.ExchangeRateTransformation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExchangeRateSchedule {


    @Scheduled(cron = "0 0 8 * * ?")
    public void run() {

        ExchangeRateTransformation exchangeRateTransformation = new ExchangeRateTransformation();

        Map<Object, Object> todayExchangeRate = exchangeRateTransformation.requestTransExchangeRate();

        GlobalValiue.setTodayExchageRate(todayExchangeRate);

    }
}
