package com.baidu.searchbox.video.prefetch;

import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.prefetch.tasks.AbstractPrefetch;
import com.baidu.searchbox.video.util.VideoUtils;

public class AdVideoPrefetchTask extends AbstractPrefetch {
    /* access modifiers changed from: protected */
    public boolean isNeedPrefetch() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int getTaskPriority() {
        return -1;
    }

    public String getTaskType() {
        return "type_ad_video";
    }

    public void run() {
        if (this.mData.getPrefetchVideo() != null && NetWorkUtils.isWifiNetworkConnected()) {
            VideoUtils.prefetchVideo(this.mData.getPrefetchVideo(), Integer.toString(23), false);
        }
    }
}
