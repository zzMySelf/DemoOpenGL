package com.baidu.growthsystem.wealth.common.task.core;

import com.baidu.growthsystem.wealth.common.task.impl.WealthPacketPraiseActionListener;
import com.baidu.growthsystem.wealth.common.task.impl.WealthPacketTaskActionListener;
import com.baidu.growthsystem.wealth.common.task.impl.WealthShortPlayGuideTaskActionListener;
import com.baidu.pyramid.annotation.Provider;
import java.util.ArrayList;

public class IWealthTaskActionListener_WealthTaskActionRuntime_ListProvider implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WealthPacketPraiseActionListener());
        arrayList.add(new WealthPacketTaskActionListener());
        arrayList.add(new WealthShortPlayGuideTaskActionListener());
        return arrayList;
    }
}
