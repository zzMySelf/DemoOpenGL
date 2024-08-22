package com.baidu.searchbox.feed.br;

import com.baidu.searchbox.feed.FeedPreferenceUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"ACTION_VALUE", "", "KEY_SWITCH", "SP_KEY_BR_SUPPORT_SWITCH", "SP_KEY_VERSION", "isSupportBr", "", "lib-feed-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBrSupportListener.kt */
public final class FeedBr {
    private static final String ACTION_VALUE = "br_support";
    private static final String KEY_SWITCH = "switch";
    public static final String SP_KEY_BR_SUPPORT_SWITCH = "br_support_switch";
    private static final String SP_KEY_VERSION = "br_support_v";

    public static final boolean isSupportBr() {
        return FeedPreferenceUtils.getInt(SP_KEY_BR_SUPPORT_SWITCH, 0) == 1;
    }
}
