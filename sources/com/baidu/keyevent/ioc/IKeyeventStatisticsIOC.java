package com.baidu.keyevent.ioc;

public interface IKeyeventStatisticsIOC {
    public static final IKeyeventStatisticsIOC EMPTY = new IKeyeventStatisticsIOC() {
        public String getProcessName() {
            return null;
        }

        public String getSessionId() {
            return null;
        }

        public long getAppStartTime() {
            return 0;
        }
    };

    long getAppStartTime();

    String getProcessName();

    String getSessionId();
}
