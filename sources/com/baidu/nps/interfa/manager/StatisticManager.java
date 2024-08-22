package com.baidu.nps.interfa.manager;

import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.interfa.IStatisticManager_StatisticManager_Provider;
import com.baidu.pyramid.annotation.component.DefaultHolder;
import com.baidu.pyramid.annotation.component.Holder;

public class StatisticManager {
    private static StatisticManager sInstance = new StatisticManager();
    public Holder<IStatisticManager> statisticManagerHolder;

    public void initstatisticManagerHolder() {
        DefaultHolder create = DefaultHolder.create();
        this.statisticManagerHolder = create;
        create.set(new IStatisticManager_StatisticManager_Provider());
    }

    public StatisticManager() {
        initstatisticManagerHolder();
    }

    public static StatisticManager getInstance() {
        return sInstance;
    }

    public IStatisticManager getStatisticManager() {
        return this.statisticManagerHolder.get();
    }
}
