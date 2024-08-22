package com.baidu.searchbox.account.event;

import android.content.ContentValues;
import com.baidu.searchbox.NoProGuard;

public class AccountQuickLoginEvent implements NoProGuard {
    public static final int EVENT_TYPE_QUICKVIEW_SHOW = 1;
    public static final String PARAM_SOURCE = "source";
    private int mEventType;
    private ContentValues mParams = new ContentValues();

    public void setEventType(int eventType) {
        this.mEventType = eventType;
    }

    public int getEventType() {
        return this.mEventType;
    }

    public void putParam(String key, String value) {
        if (this.mParams == null) {
            this.mParams = new ContentValues();
        }
        this.mParams.put(key, value);
    }

    public ContentValues getAllParams() {
        return this.mParams;
    }

    public Object getParam(String key) {
        return this.mParams.get(key);
    }
}
