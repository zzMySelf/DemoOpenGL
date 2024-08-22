package com.tera.scan.main.welcome;

import android.app.Dialog;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.dialog.ScanBaseDialogFragment;
import fe.mmm.qw.xxx.vvv.ad;
import fe.mmm.qw.xxx.vvv.th;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/tera/scan/main/welcome/PrivacyAgreementDialog;", "Lcom/tera/scan/component/base/ui/dialog/ScanBaseDialogFragment;", "()V", "content", "Landroid/text/SpannableString;", "getContent", "()Landroid/text/SpannableString;", "setContent", "(Landroid/text/SpannableString;)V", "dialogContent", "Landroid/widget/TextView;", "onCancelChange", "Lkotlin/Function0;", "", "getOnCancelChange", "()Lkotlin/jvm/functions/Function0;", "setOnCancelChange", "(Lkotlin/jvm/functions/Function0;)V", "onConfirmChange", "getOnConfirmChange", "setOnConfirmChange", "getLayoutId", "", "initView", "onStart", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyAgreementDialog extends ScanBaseDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public SpannableString content;
    @Nullable
    public TextView dialogContent;
    @Nullable
    public Function0<Unit> onCancelChange;
    @Nullable
    public Function0<Unit> onConfirmChange;

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m836initView$lambda0(PrivacyAgreementDialog privacyAgreementDialog, View view) {
        Intrinsics.checkNotNullParameter(privacyAgreementDialog, "this$0");
        privacyAgreementDialog.dismiss();
        Function0<Unit> function0 = privacyAgreementDialog.onCancelChange;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m837initView$lambda1(PrivacyAgreementDialog privacyAgreementDialog, View view) {
        Intrinsics.checkNotNullParameter(privacyAgreementDialog, "this$0");
        privacyAgreementDialog.dismiss();
        Function0<Unit> function0 = privacyAgreementDialog.onConfirmChange;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Nullable
    public final SpannableString getContent() {
        return this.content;
    }

    public int getLayoutId() {
        return R.layout.dialog_privacy_agreement;
    }

    @Nullable
    public final Function0<Unit> getOnCancelChange() {
        return this.onCancelChange;
    }

    @Nullable
    public final Function0<Unit> getOnConfirmChange() {
        return this.onConfirmChange;
    }

    public void initView() {
        View findViewById = findViewById(R.id.btn_cancel_change);
        if (findViewById != null) {
            findViewById.setOnClickListener(new ad(this));
        }
        View findViewById2 = findViewById(R.id.btn_confirm_change);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new th(this));
        }
        TextView textView = (TextView) findViewById(R.id.alert_message);
        this.dialogContent = textView;
        if (textView != null) {
            textView.setText(this.content);
        }
        TextView textView2 = this.dialogContent;
        if (textView2 != null) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView3 = this.dialogContent;
        if (textView3 != null) {
            textView3.setHighlightColor(0);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            try {
                Result.Companion companion = Result.Companion;
                if (dialog.getWindow() != null) {
                    Window window = dialog.getWindow();
                    if (window != null) {
                        window.setGravity(80);
                    }
                    Window window2 = dialog.getWindow();
                    if (window2 != null) {
                        window2.setLayout(-1, -2);
                    }
                }
                Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    public final void setContent(@Nullable SpannableString spannableString) {
        this.content = spannableString;
    }

    public final void setOnCancelChange(@Nullable Function0<Unit> function0) {
        this.onCancelChange = function0;
    }

    public final void setOnConfirmChange(@Nullable Function0<Unit> function0) {
        this.onConfirmChange = function0;
    }
}
