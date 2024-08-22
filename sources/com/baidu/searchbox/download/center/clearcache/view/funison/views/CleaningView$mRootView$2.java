package com.baidu.searchbox.download.center.clearcache.view.funison.views;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.searchbox.clearcache.business.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CleaningView.kt */
final class CleaningView$mRootView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ CleaningView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CleaningView$mRootView$2(CleaningView cleaningView) {
        super(0);
        this.this$0 = cleaningView;
    }

    public final View invoke() {
        return LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.clear_cache_cleaning_layout, this.this$0, true);
    }
}
