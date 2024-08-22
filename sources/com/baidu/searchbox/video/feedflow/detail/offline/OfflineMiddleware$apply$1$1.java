package com.baidu.searchbox.video.feedflow.detail.offline;

import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.ToastRightAreaStyle;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.toast.ToastAction;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OfflineMiddleware.kt */
final class OfflineMiddleware$apply$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Store<CommonState> $store;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfflineMiddleware$apply$1$1(Store<CommonState> store) {
        super(0);
        this.$store = store;
    }

    public final void invoke() {
        this.$store.dispatch(new ToastAction.SolidShow(R.string.video_flow_offline_text, (CharSequence) null, 0, (ToastAction) null, (ToastLocation) null, (ToastTemplate) null, 0, 0, (CharSequence) null, (ToastRightAreaStyle) null, (Action) null, 2046, (DefaultConstructorMarker) null));
    }
}
