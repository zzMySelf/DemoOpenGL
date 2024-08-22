package com.baidu.searchbox.behavior;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjustSmartSchedule {
    private static final Map<String, List<String>> DEPENDENCY_BUSINESS_MAP;
    private static final List<String> INTERRUPT_SCHEDULE_STRATEGY_ID_LIST = Arrays.asList(new String[]{"bdwindow", "swan"});

    static {
        HashMap hashMap = new HashMap(1);
        DEPENDENCY_BUSINESS_MAP = hashMap;
        hashMap.put("bdwindow", Arrays.asList(new String[]{"swan"}));
    }

    public void checkIfNeededAdjustSmartSchedule(String businessId) {
        if (INTERRUPT_SCHEDULE_STRATEGY_ID_LIST.contains(businessId)) {
            BdEventBus.Companion.getDefault().post(new AdjustSmartScheduleEvent(0, businessId));
        }
    }

    public static List<String> getDependencyTasks(String businessId) {
        Map<String, List<String>> map = DEPENDENCY_BUSINESS_MAP;
        if (map.containsKey(businessId)) {
            return map.get(businessId);
        }
        return null;
    }
}
