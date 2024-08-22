package com.baidu.searchbox.mvp.util;

import android.view.View;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.mvp.util.MvpAccountUtil;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MvpAccountUtil$$ExternalSyntheticLambda0 implements ILoginResultListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ Store f$1;
    public final /* synthetic */ MvpAccountUtil.IAccountListener f$2;

    public /* synthetic */ MvpAccountUtil$$ExternalSyntheticLambda0(View view2, Store store, MvpAccountUtil.IAccountListener iAccountListener) {
        this.f$0 = view2;
        this.f$1 = store;
        this.f$2 = iAccountListener;
    }

    public final void onResult(int i2) {
        MvpAccountUtil.m1491fastLogin$lambda1(this.f$0, this.f$1, this.f$2, i2);
    }
}
