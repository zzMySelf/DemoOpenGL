package com.baidu.searchbox.feed.dynamicdetail;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: EDynamicImmersiveActivity.kt */
final class EDynamicImmersiveActivity$initView$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EDynamicImmersiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EDynamicImmersiveActivity$initView$2(EDynamicImmersiveActivity eDynamicImmersiveActivity) {
        super(0);
        this.this$0 = eDynamicImmersiveActivity;
    }

    public final void invoke() {
        RecyclerView recyclerView;
        DynamicImmersivePage access$getMListPage$p = this.this$0.mListPage;
        if (access$getMListPage$p != null && (recyclerView = access$getMListPage$p.getRecyclerView()) != null) {
            recyclerView.post(new EDynamicImmersiveActivity$initView$2$$ExternalSyntheticLambda0(this.this$0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m18607invoke$lambda0(EDynamicImmersiveActivity this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        EDynamicImmersiveActivity.scrollPositionToTop$default(this$02, DynamicCachesRecoveryManager.INSTANCE.getRestoreFirstPos(), false, 2, (Object) null);
    }
}
