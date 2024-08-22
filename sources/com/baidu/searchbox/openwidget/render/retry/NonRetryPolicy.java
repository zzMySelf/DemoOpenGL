package com.baidu.searchbox.openwidget.render.retry;

import com.baidu.searchbox.openwidget.render.RenderJobInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/openwidget/render/retry/NonRetryPolicy;", "Lcom/baidu/searchbox/openwidget/render/retry/IRetryPolicy;", "()V", "shouldRetry", "", "jobInfo", "Lcom/baidu/searchbox/openwidget/render/RenderJobInfo;", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NonRetryPolicy.kt */
public final class NonRetryPolicy implements IRetryPolicy {
    public boolean shouldRetry(RenderJobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        return false;
    }
}
