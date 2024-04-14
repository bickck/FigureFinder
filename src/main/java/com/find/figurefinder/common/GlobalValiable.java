package com.find.figurefinder.common;

import java.util.Map;

public class GlobalValiable {

    private static int limitLanguageTransCount = 500000;

    private static int languageTransCount = 0;

    private static Map<Object, Object> todayExchageRate;

    public static int getLimitLanguageTransCount() {
        return limitLanguageTransCount;
    }

    public static void setLimitLanguageTransCount(int limitLanguageTransCount) {
        GlobalValiable.limitLanguageTransCount = limitLanguageTransCount;
    }

    public static int getLanguageTransCount() {
        return languageTransCount;
    }

    public static void setLanguageTransCount(int languageTransCount) {
        GlobalValiable.languageTransCount = languageTransCount;
    }

    public static Map<Object, Object> getTodayExchageRate() {
        return todayExchageRate;
    }

    public static void setTodayExchageRate(Map<Object, Object> todayExchageRate) {
        GlobalValiable.todayExchageRate = todayExchageRate;
    }


}
