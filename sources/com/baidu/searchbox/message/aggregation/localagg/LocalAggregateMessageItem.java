package com.baidu.searchbox.message.aggregation.localagg;

import com.baidu.searchbox.push.MyMessageItem;
import com.baidu.searchbox.push.mymessagefragment.IMSessionViewGuideManager;

public class LocalAggregateMessageItem extends MyMessageItem {
    public String appId = null;
    public long paId = -1;
    public String skipAddr = "";
    public int skipType = -1;
    public int state = -1;
    public String thirdId = "";

    public LocalAggregateMessageItem() {
        this.type = -113;
    }

    public boolean isSameItem(MyMessageItem item) {
        if (item != null && this.category == item.category && this.contacter == item.contacter && this.classType == item.classType) {
            return true;
        }
        return false;
    }

    public void onExecuteResult() {
    }

    public boolean notSupportDelete() {
        return this.classType == 15;
    }

    public boolean guideAble() {
        return this.classType == 15;
    }

    public String getGuidePrefKey() {
        if (this.classType == 15) {
            return IMSessionViewGuideManager.PREF_MESSAGE_ECOMMERCE_AGG_GUIDE_BUBBLE;
        }
        return "";
    }
}
