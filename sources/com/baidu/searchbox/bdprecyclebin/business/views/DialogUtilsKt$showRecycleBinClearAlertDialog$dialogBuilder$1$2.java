package com.baidu.searchbox.bdprecyclebin.business.views;

import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.searchbox.bdprecyclebin.business.RecycleBinUbc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/bdprecyclebin/business/views/DialogUtilsKt$showRecycleBinClearAlertDialog$dialogBuilder$1$2", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-bdprecyclebin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DialogUtils.kt */
public final class DialogUtilsKt$showRecycleBinClearAlertDialog$dialogBuilder$1$2 implements BdAlertDialog.OnItemClickListener {
    final /* synthetic */ Function0<Unit> $onClearButtonClicked;

    DialogUtilsKt$showRecycleBinClearAlertDialog$dialogBuilder$1$2(Function0<Unit> $onClearButtonClicked2) {
        this.$onClearButtonClicked = $onClearButtonClicked2;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        RecycleBinUbc.INSTANCE.doClearAllDialogClickUbc("empty");
        this.$onClearButtonClicked.invoke();
    }
}
