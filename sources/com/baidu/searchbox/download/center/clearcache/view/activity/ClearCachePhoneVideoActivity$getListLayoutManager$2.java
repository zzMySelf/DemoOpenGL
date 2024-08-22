package com.baidu.searchbox.download.center.clearcache.view.activity;

import com.baidu.searchbox.download.center.clearcache.view.funison.local.AbsClearCachePhoneAdapter;
import com.baidu.searchbox.download.center.clearcache.view.funison.local.ClearCacheFolderAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "position", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCachePhoneVideoActivity.kt */
final class ClearCachePhoneVideoActivity$getListLayoutManager$2 extends Lambda implements Function1<Integer, Integer> {
    final /* synthetic */ ClearCachePhoneVideoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClearCachePhoneVideoActivity$getListLayoutManager$2(ClearCachePhoneVideoActivity clearCachePhoneVideoActivity) {
        super(1);
        this.this$0 = clearCachePhoneVideoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).intValue());
    }

    public final Integer invoke(int position) {
        int i2 = 4;
        if (this.this$0.mCacheFileAdapter instanceof ClearCacheFolderAdapter) {
            AbsClearCachePhoneAdapter access$getMCacheFileAdapter$p = this.this$0.mCacheFileAdapter;
            ClearCacheFolderAdapter clearCacheFolderAdapter = access$getMCacheFileAdapter$p instanceof ClearCacheFolderAdapter ? (ClearCacheFolderAdapter) access$getMCacheFileAdapter$p : null;
            if (clearCacheFolderAdapter != null) {
                i2 = clearCacheFolderAdapter.getItemViewType(position);
            }
        }
        return Integer.valueOf(i2);
    }
}
