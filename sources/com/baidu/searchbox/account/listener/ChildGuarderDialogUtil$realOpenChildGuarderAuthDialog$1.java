package com.baidu.searchbox.account.listener;

import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.searchbox.account.childguarder.ChildTeenagerConstants;
import com.baidu.searchbox.account.childguarder.ChildTeenagerUbcHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/account/listener/ChildGuarderDialogUtil$realOpenChildGuarderAuthDialog$1", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChildGuarderDialogUtil.kt */
public final class ChildGuarderDialogUtil$realOpenChildGuarderAuthDialog$1 implements BdAlertDialog.OnItemClickListener {
    final /* synthetic */ String $page;

    ChildGuarderDialogUtil$realOpenChildGuarderAuthDialog$1(String $page2) {
        this.$page = $page2;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        ChildTeenagerUbcHelper.INSTANCE.ubc("click", this.$page, "logout", ChildTeenagerConstants.UBC_FROM_CHILD_TIPS);
        ChildGuarderDialogUtil.INSTANCE.showLogoutDialog(this.$page);
    }
}
