package com.baidu.chatsearch.aisearch.resultpage.graph;

import android.widget.ProgressBar;
import com.baidu.chatsearch.resultpage.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ProgressBar;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareStatusPopupWindow.kt */
final class ShareStatusPopupWindow$pbLoading$2 extends Lambda implements Function0<ProgressBar> {
    final /* synthetic */ ShareStatusPopupWindow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareStatusPopupWindow$pbLoading$2(ShareStatusPopupWindow shareStatusPopupWindow) {
        super(0);
        this.this$0 = shareStatusPopupWindow;
    }

    public final ProgressBar invoke() {
        return (ProgressBar) this.this$0.getContentView().findViewById(R.id.pb_loading);
    }
}
