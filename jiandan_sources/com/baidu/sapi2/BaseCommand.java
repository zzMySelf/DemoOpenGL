package com.baidu.sapi2;

import java.util.ArrayList;
import java.util.List;

public class BaseCommand {
    public String actionName;
    public List<String> actionParams = new ArrayList();
    public long endTime;
    public String errno = "0";
    public boolean isUpgrade = false;
    public String key;
    public String originCommand;
    public long startTime = System.currentTimeMillis();

    public String getActionName() {
        return this.actionName;
    }

    public List<String> getActionParams() {
        return this.actionParams;
    }

    public String getDurtime() {
        return String.valueOf(Math.max((int) (this.endTime - this.startTime), 0));
    }

    public String getErrno() {
        return this.errno;
    }

    public String getKey() {
        return this.key;
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }
}
