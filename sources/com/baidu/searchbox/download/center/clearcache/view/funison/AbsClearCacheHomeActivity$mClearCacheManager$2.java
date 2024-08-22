package com.baidu.searchbox.download.center.clearcache.view.funison;

import com.baidu.searchbox.download.center.clearcache.view.funison.manager.ClearCacheManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/manager/ClearCacheManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsClearCacheHomeActivity.kt */
final class AbsClearCacheHomeActivity$mClearCacheManager$2 extends Lambda implements Function0<ClearCacheManager> {
    final /* synthetic */ AbsClearCacheHomeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbsClearCacheHomeActivity$mClearCacheManager$2(AbsClearCacheHomeActivity absClearCacheHomeActivity) {
        super(0);
        this.this$0 = absClearCacheHomeActivity;
    }

    public final ClearCacheManager invoke() {
        AbsClearCacheHomeActivity absClearCacheHomeActivity = this.this$0;
        return new ClearCacheManager(absClearCacheHomeActivity, absClearCacheHomeActivity.getMClearCacheUbcController());
    }
}
