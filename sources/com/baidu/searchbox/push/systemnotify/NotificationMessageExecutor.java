package com.baidu.searchbox.push.systemnotify;

import android.os.Bundle;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.push.systemnotify.data.NotificationMessageItem;

public abstract class NotificationMessageExecutor {
    protected static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    protected static final String TAG = "NotificationMessageExecutor";

    public abstract boolean execute(NotificationMessageItem notificationMessageItem);

    public abstract NotificationMessageItem parse(Bundle bundle);
}
