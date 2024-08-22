package com.baidu.searchbox.sport.page.schedule.model;

import com.baidu.searchbox.sport.page.match.model.DataSource;
import java.util.ArrayList;
import java.util.List;

public class ScheduleListModel {
    private DataSource dataSource;
    ScheduleExtInfo extInfo;
    boolean hasMore;
    List<DailySchedule> schedules;
    ScheduleItem scrollTarget;
    private final List<ScheduleTabInfo> tabInfoList = new ArrayList();

    public List<DailySchedule> getSchedules() {
        return this.schedules;
    }

    public ScheduleExtInfo getExtInfo() {
        return this.extInfo;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public ScheduleItem getScrollTarget() {
        return this.scrollTarget;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(DataSource dataSource2) {
        this.dataSource = dataSource2;
    }

    public void setTabInfoList(List<ScheduleTabInfo> tabInfoList2) {
        this.tabInfoList.clear();
        this.tabInfoList.addAll(tabInfoList2);
    }

    public List<ScheduleTabInfo> getTabInfoList() {
        return this.tabInfoList;
    }
}
