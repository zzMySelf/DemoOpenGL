package com.baidu.searchbox.feed.attention.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE_USE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/feed/attention/utils/FeedBarClickType;", "", "Companion", "lib-feed-attention_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: AttentionStatHelper.kt */
public @interface FeedBarClickType {
    public static final String COLLECT_CANCEL_CLK = "collect_cancel_clk";
    public static final String COLLECT_CLK = "collect_clk";
    public static final String COMMENT_CLK = "comment";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String PRAISE_CANCEL_CLK = "praise_cancel_clk";
    public static final String PRAISE_CLK = "praise_clk";
    public static final String SHARE_CLK = "share";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/attention/utils/FeedBarClickType$Companion;", "", "()V", "COLLECT_CANCEL_CLK", "", "COLLECT_CLK", "COMMENT_CLK", "PRAISE_CANCEL_CLK", "PRAISE_CLK", "SHARE_CLK", "lib-feed-attention_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AttentionStatHelper.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String COLLECT_CANCEL_CLK = "collect_cancel_clk";
        public static final String COLLECT_CLK = "collect_clk";
        public static final String COMMENT_CLK = "comment";
        public static final String PRAISE_CANCEL_CLK = "praise_cancel_clk";
        public static final String PRAISE_CLK = "praise_clk";
        public static final String SHARE_CLK = "share";

        private Companion() {
        }
    }
}
