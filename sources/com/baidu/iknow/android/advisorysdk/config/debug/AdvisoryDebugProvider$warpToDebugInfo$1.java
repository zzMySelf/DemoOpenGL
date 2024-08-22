package com.baidu.iknow.android.advisorysdk.config.debug;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.debug.data.ViewFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/iknow/android/advisorysdk/config/debug/AdvisoryDebugProvider$warpToDebugInfo$1", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "fetchView", "Landroid/view/View;", "context", "Landroid/content/Context;", "advisorysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdvisoryDebugProvider.kt */
public final class AdvisoryDebugProvider$warpToDebugInfo$1 implements ViewFetcher {
    final /* synthetic */ View $this_warpToDebugInfo;

    AdvisoryDebugProvider$warpToDebugInfo$1(View $receiver) {
        this.$this_warpToDebugInfo = $receiver;
    }

    public View fetchView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.$this_warpToDebugInfo;
    }
}
