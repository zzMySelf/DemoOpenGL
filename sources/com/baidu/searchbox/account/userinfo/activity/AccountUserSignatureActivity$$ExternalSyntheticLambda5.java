package com.baidu.searchbox.account.userinfo.activity;

import android.view.View;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.account.R;
import com.baidu.searchbox.common.runtime.AppRuntime;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AccountUserSignatureActivity$$ExternalSyntheticLambda5 implements View.OnClickListener {
    public final void onClick(View view2) {
        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.user_info_save_no_network).show();
    }
}
