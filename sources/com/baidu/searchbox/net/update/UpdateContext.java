package com.baidu.searchbox.net.update;

import com.baidu.searchbox.net.update.ioc.IUpdateContext;
import com.baidu.searchbox.net.update.statistics.UpdateUBCUtil;
import java.util.List;
import org.json.JSONObject;

public class UpdateContext implements IUpdateContext {
    public List<String> getCustomUpdateBlackList() {
        return UpdateRequestListManager.getUpdateRequestWhiteList();
    }

    public void doStatistics(int commandFrom, JSONObject reportInfo) {
        UpdateUBCUtil.doStatistics(commandFrom, reportInfo);
    }
}
