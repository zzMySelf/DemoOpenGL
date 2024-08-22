package com.baidu.searchbox.aisearch.comps.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.searchbox.aisearch.R;
import com.baidu.searchbox.aisearch.utils.AnyScene;
import com.baidu.searchbox.aisearch.utils.ResExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/dialog/GeneralAlertDialog;", "", "()V", "showDialog", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;", "context", "Landroid/content/Context;", "message", "", "confimCallback", "Lkotlin/Function0;", "", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@AnyScene
/* compiled from: LoginChangeDialog.kt */
public final class GeneralAlertDialog {
    public static final GeneralAlertDialog INSTANCE = new GeneralAlertDialog();

    private GeneralAlertDialog() {
    }

    public final BdAlertDialog showDialog(Context context, String message, Function0<Unit> confimCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(confimCallback, "confimCallback");
        BdAlertDialog dialog = new BdAlertDialog.Builder(context).setTitle(ResExtKt.getString(R.string.dialog_login_change_title)).setMessageGravity(17).setMessage(message).setButton(new BdAlertDialog.ButtonItem((CharSequence) ResExtKt.getString(R.string.dialog_login_change_confim_bt), R.color.dialog_login_confim_text, (BdAlertDialog.OnItemClickListener) null)).setOnDismissListener(new GeneralAlertDialog$$ExternalSyntheticLambda0(confimCallback)).create();
        dialog.show();
        return dialog;
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-0  reason: not valid java name */
    public static final void m15737showDialog$lambda0(Function0 $confimCallback, DialogInterface it) {
        Intrinsics.checkNotNullParameter($confimCallback, "$confimCallback");
        $confimCallback.invoke();
    }
}
