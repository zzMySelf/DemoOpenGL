package com.baidu.searchbox.dns.transmit.task;

public class TaskDispatcherFactory {
    public static final int PRIORITY_DISPATCHER = 1;
    public static final int SIMPLE_DISPATCHER = 0;

    public static Dispatcher createDispatcher(int type) {
        switch (type) {
            case 0:
                return new SimpleDispatcher();
            case 1:
                return new PriorityDispatcher();
            default:
                return new SimpleDispatcher();
        }
    }
}
