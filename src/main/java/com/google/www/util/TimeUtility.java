package com.google.www.util;

import java.util.concurrent.Callable;

public class TimeUtility {

    static Boolean allMessagesProcessed = true;

    private TimeUtility() {
    }

    public static Callable<Boolean> sucessfulCondition() {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return allMessagesProcessed;
            }
        };
    }
}
