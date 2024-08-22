package com.baidu.searchbox.video.feedflow.view;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\n"}, d2 = {"DEFAULT_ALPHA_ANIM_DURATION", "", "DEFAULT_BOTTOM_COVER_ALPHA_COVER", "", "", "[Ljava/lang/Float;", "DEFAULT_BOTTOM_COVER_ALPHA_TRANSLUCENT", "DEFAULT_COVER_COLOR", "", "DEFAULT_TOP_COVER_ALPHA", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopCoverView.kt */
public final class TopCoverViewKt {
    private static final long DEFAULT_ALPHA_ANIM_DURATION = 300;
    /* access modifiers changed from: private */
    public static final Float[] DEFAULT_BOTTOM_COVER_ALPHA_COVER;
    /* access modifiers changed from: private */
    public static final Float[] DEFAULT_BOTTOM_COVER_ALPHA_TRANSLUCENT;
    private static final String DEFAULT_COVER_COLOR = "#000000";
    /* access modifiers changed from: private */
    public static final Float[] DEFAULT_TOP_COVER_ALPHA;

    static {
        Float valueOf = Float.valueOf(1.0f);
        DEFAULT_TOP_COVER_ALPHA = new Float[]{valueOf};
        Float valueOf2 = Float.valueOf(0.0f);
        DEFAULT_BOTTOM_COVER_ALPHA_TRANSLUCENT = new Float[]{Float.valueOf(0.5f), valueOf2};
        DEFAULT_BOTTOM_COVER_ALPHA_COVER = new Float[]{valueOf, valueOf2};
    }
}
