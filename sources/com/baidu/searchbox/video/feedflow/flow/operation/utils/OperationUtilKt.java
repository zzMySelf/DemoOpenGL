package com.baidu.searchbox.video.feedflow.flow.operation.utils;

import com.baidu.searchbox.video.detail.utils.gson.VideoGsonFactory;
import com.baidu.searchbox.video.detail.utils.gson.VideoGsonFactoryKt;
import com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimer;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"parseActivityTimerModel", "Lcom/baidu/searchbox/video/feedflow/flow/operation/timer/ActivityTimer;", "", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OperationUtil.kt */
public final class OperationUtilKt {
    public static final ActivityTimer parseActivityTimerModel(String $this$parseActivityTimerModel) {
        Intrinsics.checkNotNullParameter($this$parseActivityTimerModel, "<this>");
        if (StringsKt.isBlank($this$parseActivityTimerModel)) {
            return null;
        }
        Type type = new OperationUtilKt$parseActivityTimerModel$type$1().getType();
        Gson build = VideoGsonFactory.build();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        return (ActivityTimer) VideoGsonFactoryKt.safeFromJson(build, $this$parseActivityTimerModel, type);
    }
}
