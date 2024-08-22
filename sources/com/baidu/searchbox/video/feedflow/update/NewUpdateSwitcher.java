package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.video.detail.export.IVideoAppConfig;
import com.baidu.searchbox.video.detail.switcher.AbsSwitcher;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowSpHelperByDebug;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\r\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/update/NewUpdateSwitcher;", "T", "Lcom/baidu/searchbox/video/detail/switcher/AbsSwitcher;", "key", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "getCloudSwitcherValue", "()Ljava/lang/Object;", "getDebugSwitcherValue", "isDebug", "", "isSelectedByDebug", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewUpdateSwitcher.kt */
public final class NewUpdateSwitcher<T> extends AbsSwitcher<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewUpdateSwitcher(String key, T defaultValue) {
        super(key, defaultValue);
        Intrinsics.checkNotNullParameter(key, "key");
    }

    public T getCloudSwitcherValue() {
        return NewUpdateSwitcherKt.getCloudSwitcherValue(getKey(), getDefaultValue());
    }

    public T getDebugSwitcherValue() {
        return NewUpdateSwitcherKt.getDebugSwitcherValue(getKey(), getDefaultValue());
    }

    public boolean isSelectedByDebug() {
        return VideoFlowSpHelperByDebug.INSTANCE.getBoolean(generateDebugSelectedKey(), false);
    }

    public boolean isDebug() {
        return IVideoAppConfig.Impl.get().isDebug();
    }
}
