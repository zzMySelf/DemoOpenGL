package com.baidu.searchbox.download.center.clearcache.guide;

import android.content.Context;
import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.searchbox.download.center.clearcache.guide.data.ClearCacheGuideModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/download/center/clearcache/guide/HomeClearCacheGuide$showDialog$5", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-clearcache-guide_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeClearCacheGuide.kt */
public final class HomeClearCacheGuide$showDialog$5 implements BdAlertDialog.OnItemClickListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ ClearCacheGuideModel.FreeLimit $freeLimit;
    final /* synthetic */ HomeClearCacheGuide this$0;

    HomeClearCacheGuide$showDialog$5(HomeClearCacheGuide $receiver, Context $context2, ClearCacheGuideModel.FreeLimit $freeLimit2) {
        this.this$0 = $receiver;
        this.$context = $context2;
        this.$freeLimit = $freeLimit2;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.this$0.onRightClick(this.$context, this.$freeLimit);
    }
}
