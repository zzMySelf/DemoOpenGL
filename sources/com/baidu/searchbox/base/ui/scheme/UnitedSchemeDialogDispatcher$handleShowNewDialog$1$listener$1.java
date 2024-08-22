package com.baidu.searchbox.base.ui.scheme;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/base/ui/scheme/UnitedSchemeDialogDispatcher$handleShowNewDialog$1$listener$1", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "base-ui-scheme_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnitedSchemeDialogDispatcher.kt */
public final class UnitedSchemeDialogDispatcher$handleShowNewDialog$1$listener$1 implements BdAlertDialog.OnItemClickListener {
    final /* synthetic */ String $buttonScheme;
    final /* synthetic */ CallbackHandler $callbackHandler;
    final /* synthetic */ String $cb;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $index;
    final /* synthetic */ String $ubcExt;
    final /* synthetic */ String $ubcSource;
    final /* synthetic */ UnitedSchemeDialogDispatcher this$0;

    UnitedSchemeDialogDispatcher$handleShowNewDialog$1$listener$1(UnitedSchemeDialogDispatcher $receiver, String $ubcSource2, int $index2, String $ubcExt2, String $cb2, CallbackHandler $callbackHandler2, String $buttonScheme2, Context $context2) {
        this.this$0 = $receiver;
        this.$ubcSource = $ubcSource2;
        this.$index = $index2;
        this.$ubcExt = $ubcExt2;
        this.$cb = $cb2;
        this.$callbackHandler = $callbackHandler2;
        this.$buttonScheme = $buttonScheme2;
        this.$context = $context2;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        UnitedSchemeDialogDispatcher unitedSchemeDialogDispatcher = this.this$0;
        String str = this.$ubcSource;
        Intrinsics.checkNotNullExpressionValue(str, "ubcSource");
        unitedSchemeDialogDispatcher.dialogUbcEvent("click", str, String.valueOf(this.$index), this.$ubcExt);
        if (!TextUtils.isEmpty(this.$cb)) {
            JSONObject cbJson = new JSONObject();
            cbJson.put("action", "click");
            cbJson.put("position", String.valueOf(this.$index));
            CallbackHandler callbackHandler = this.$callbackHandler;
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.$cb, cbJson.toString());
            }
        }
        if (!TextUtils.isEmpty(this.$buttonScheme)) {
            BaseRouter.invoke(this.$context, this.$buttonScheme);
        }
    }
}
