package com.baidu.wallet.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.core.ActLifecycleCbs;
import com.baidu.wallet.utils.BdWalletUtils;

public class PollInitUtils implements ActLifecycleCbs.a {
    public static int INTERVAL_TIME = 120000;
    public static final String TAG = "PollInitUtils";
    public Boolean a = Boolean.TRUE;

    public static final class a {
        public static final PollInitUtils a = new PollInitUtils();
    }

    public static final PollInitUtils getInstance() {
        return a.a;
    }

    public boolean onInvoke(Context context, ActLifecycleCbs.FROM from) {
        if (!this.a.booleanValue()) {
            return false;
        }
        LogUtil.d(TAG, "pollinit-触发请求init接口");
        BdWalletUtils.getInitForPoll(context);
        return true;
    }

    public void registerListener() {
        ActLifecycleCbs.a().a((ActLifecycleCbs.a) this, (long) INTERVAL_TIME);
    }

    public void updateIntervalTime(String str) {
        INTERVAL_TIME = Integer.valueOf(str).intValue();
        LogUtil.d(TAG, "pollinit-更新间隔时间:" + str);
        ActLifecycleCbs.a().a((ActLifecycleCbs.a) this, Long.valueOf(str).longValue());
    }

    public void updatePollingSwitch(String str) {
        if (TextUtils.isEmpty(str) || !"false".equals(str)) {
            this.a = Boolean.TRUE;
        } else {
            this.a = Boolean.FALSE;
        }
    }
}
