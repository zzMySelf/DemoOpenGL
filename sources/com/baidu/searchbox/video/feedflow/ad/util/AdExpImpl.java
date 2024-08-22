package com.baidu.searchbox.video.feedflow.ad.util;

import com.baidu.searchbox.video.feedflow.abtest.IAdExp;
import com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/util/AdExpImpl;", "Lcom/baidu/searchbox/video/feedflow/abtest/IAdExp;", "()V", "collAdaptInterval", "", "collConsumeCountFloor", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdExpImpl.kt */
public final class AdExpImpl implements IAdExp {
    public boolean collConsumeCountFloor() {
        return AdReduxExpManager.INSTANCE.getCollConsumeCountFloorSwitch();
    }

    public boolean collAdaptInterval() {
        return AdReduxExpManager.INSTANCE.getIntervalCollAdaptSwitch();
    }
}
