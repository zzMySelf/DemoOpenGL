package com.baidu.searchbox.flowvideo.flow.repos;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0005\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0004\u001a\u0012\u0010\n\u001a\u00020\b*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"KEY_REQUEST_TIME", "", "KEY_RESPONSE_TIME", "getRequestTime", "", "Lcom/baidu/searchbox/flowvideo/flow/repos/FlowListParam;", "getResponseTime", "setRequestTime", "", "time", "setResponseTime", "lib-flow-domain_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowListParamExt.kt */
public final class FlowListParamExt {
    private static final String KEY_REQUEST_TIME = "request_time";
    private static final String KEY_RESPONSE_TIME = "response_time";

    public static final void setRequestTime(FlowListParam $this$setRequestTime, long time) {
        Intrinsics.checkNotNullParameter($this$setRequestTime, "<this>");
        $this$setRequestTime.getExtMap().put("request_time", Long.valueOf(time));
    }

    public static final long getRequestTime(FlowListParam $this$getRequestTime) {
        Intrinsics.checkNotNullParameter($this$getRequestTime, "<this>");
        Object obj = $this$getRequestTime.getExtMap().get((Object) "request_time");
        Long l = obj instanceof Long ? (Long) obj : null;
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    public static final void setResponseTime(FlowListParam $this$setResponseTime, long time) {
        Intrinsics.checkNotNullParameter($this$setResponseTime, "<this>");
        $this$setResponseTime.getExtMap().put("response_time", Long.valueOf(time));
    }

    public static final long getResponseTime(FlowListParam $this$getResponseTime) {
        Intrinsics.checkNotNullParameter($this$getResponseTime, "<this>");
        Object obj = $this$getResponseTime.getExtMap().get((Object) "response_time");
        Long l = obj instanceof Long ? (Long) obj : null;
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }
}
