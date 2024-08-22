package com.baidu.searchbox.account.userinfo.utils;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.devicescore.IDeviceScore;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"isLowScoreDevice", "", "context", "Landroid/content/Context;", "lib-userinfo_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceScoreUtils.kt */
public final class DeviceScoreUtilsKt {
    public static final boolean isLowScoreDevice(Context context) {
        if (context == null) {
            return false;
        }
        IDeviceScore deviceScore = (IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE);
        float score = 1.0f;
        if (deviceScore != null) {
            score = deviceScore.getFinalScore(context);
        }
        if (Float.compare(score, 0.37f) < 0) {
            return true;
        }
        return false;
    }
}
