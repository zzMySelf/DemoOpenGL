package com.baidu.searchbox.download.center.clearcache.view.funison.local;

import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheStatistic;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheUbcConstant;
import com.baidu.searchbox.uarm.UARInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/download/center/clearcache/view/funison/local/AbsClearCachePhoneActivity$showDeleteConfirmDialog$1", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsClearCachePhoneActivity.kt */
public final class AbsClearCachePhoneActivity$showDeleteConfirmDialog$1 implements BdAlertDialog.OnItemClickListener {
    final /* synthetic */ AbsClearCachePhoneActivity this$0;

    AbsClearCachePhoneActivity$showDeleteConfirmDialog$1(AbsClearCachePhoneActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        ClearCacheStatistic.doCacheClickUbc$default(ClearCacheStatistic.INSTANCE, ClearCacheUbcConstant.UBC_VALUE_SOURCE_DIALOG_CANCLE, this.this$0.getCachePage(), (String) null, (JSONObject) null, 12, (Object) null);
        UARInterface uarInterface = (UARInterface) ServiceManager.getService(UARInterface.Companion.getReference());
        if (uarInterface != null) {
            uarInterface.clearCache((JSONObject) null);
        }
    }
}
