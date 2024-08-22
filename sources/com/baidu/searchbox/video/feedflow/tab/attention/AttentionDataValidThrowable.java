package com.baidu.searchbox.video.feedflow.tab.attention;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/attention/AttentionDataValidThrowable;", "", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AttentionFlowMiddleware.kt */
public final class AttentionDataValidThrowable extends Throwable {
    public static final AttentionDataValidThrowable INSTANCE = new AttentionDataValidThrowable();

    private AttentionDataValidThrowable() {
        super("AttentionFlowMiddleware: response data is error");
    }
}
