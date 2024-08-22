package com.baidu.searchbox.home.tabs;

import com.baidu.android.common.menu.CommonSetDefaultTabDialog;
import com.baidu.searchbox.home.tabs.extend.CommonSetDefaultTabClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SetDefaultTab.kt */
final class SetDefaultTab$showDialog$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SetDefaultTab this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SetDefaultTab$showDialog$1$2(SetDefaultTab setDefaultTab) {
        super(0);
        this.this$0 = setDefaultTab;
    }

    public final void invoke() {
        CommonSetDefaultTabClickListener mListener = this.this$0.getMListener();
        if (mListener != null) {
            mListener.closeCallBack();
        }
        this.this$0.setMDialog((CommonSetDefaultTabDialog) null);
    }
}
