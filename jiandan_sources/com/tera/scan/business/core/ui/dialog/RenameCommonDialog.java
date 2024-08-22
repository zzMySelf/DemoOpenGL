package com.tera.scan.business.core.ui.dialog;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import fe.mmm.qw.j.xxx.ad;
import fe.mmm.qw.rg.qw.ad.qw.de;
import fe.mmm.qw.rg.qw.ad.qw.fe;
import fe.mmm.qw.rg.qw.ad.qw.rg;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/tera/scan/business/core/ui/dialog/RenameCommonDialog;", "Lcom/tera/scan/business/core/ui/dialog/ScanBaseBottomDialogFragment;", "fileName", "", "cancelBtnText", "confirmBtnText", "maxNameLength", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "onCancel", "Lkotlin/Function0;", "", "getOnCancel", "()Lkotlin/jvm/functions/Function0;", "setOnCancel", "(Lkotlin/jvm/functions/Function0;)V", "onConfirm", "Lkotlin/Function1;", "getOnConfirm", "()Lkotlin/jvm/functions/Function1;", "setOnConfirm", "(Lkotlin/jvm/functions/Function1;)V", "getLayoutId", "initView", "view", "Landroid/view/View;", "onFileNameChange", "s", "", "business-core_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RenameCommonDialog extends ScanBaseBottomDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    public final String cancelBtnText;
    @Nullable
    public final String confirmBtnText;
    @NotNull
    public final String fileName;
    public final int maxNameLength;
    @NotNull
    public Function0<Unit> onCancel;
    @NotNull
    public Function1<? super String, Unit> onConfirm;

    public static final class qw implements TextWatcher {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ RenameCommonDialog f6819ad;

        public qw(RenameCommonDialog renameCommonDialog) {
            this.f6819ad = renameCommonDialog;
        }

        public void afterTextChanged(@Nullable Editable editable) {
        }

        public void beforeTextChanged(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
            this.f6819ad.onFileNameChange(charSequence);
        }
    }

    public RenameCommonDialog(@NotNull String str, @Nullable String str2, @Nullable String str3, int i2) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        this._$_findViewCache = new LinkedHashMap();
        this.fileName = str;
        this.cancelBtnText = str2;
        this.confirmBtnText = str3;
        this.maxNameLength = i2;
        this.onConfirm = RenameCommonDialog$onConfirm$1.INSTANCE;
        this.onCancel = RenameCommonDialog$onCancel$1.INSTANCE;
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m725initView$lambda0(RenameCommonDialog renameCommonDialog) {
        Intrinsics.checkNotNullParameter(renameCommonDialog, "this$0");
        ((EditText) renameCommonDialog._$_findCachedViewById(R.id.et_dialog_file_name)).requestFocus();
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m726initView$lambda1(RenameCommonDialog renameCommonDialog, View view) {
        Intrinsics.checkNotNullParameter(renameCommonDialog, "this$0");
        ((EditText) renameCommonDialog._$_findCachedViewById(R.id.et_dialog_file_name)).setText("");
        ((EditText) renameCommonDialog._$_findCachedViewById(R.id.et_dialog_file_name)).requestFocus();
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m727initView$lambda2(RenameCommonDialog renameCommonDialog, View view) {
        Intrinsics.checkNotNullParameter(renameCommonDialog, "this$0");
        renameCommonDialog.dismiss();
        renameCommonDialog.onCancel.invoke();
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m728initView$lambda3(RenameCommonDialog renameCommonDialog, String str, String str2, View view) {
        String str3;
        String obj;
        String obj2;
        Intrinsics.checkNotNullParameter(renameCommonDialog, "this$0");
        renameCommonDialog.dismiss();
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_rename_dialog_confirm_click", (List) null, 2, (Object) null);
        Editable text = ((EditText) renameCommonDialog._$_findCachedViewById(R.id.et_dialog_file_name)).getText();
        String str4 = "";
        if (text == null || (str3 = text.toString()) == null) {
            str3 = str4;
        }
        if (!Intrinsics.areEqual((Object) str, (Object) str3)) {
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_rename_dialog_rename_click", (List) null, 2, (Object) null);
        }
        if (TextUtils.isEmpty(str2)) {
            Editable text2 = ((EditText) renameCommonDialog._$_findCachedViewById(R.id.et_dialog_file_name)).getText();
            if (!(text2 == null || (obj2 = text2.toString()) == null)) {
                str4 = obj2;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            Editable text3 = ((EditText) renameCommonDialog._$_findCachedViewById(R.id.et_dialog_file_name)).getText();
            if (!(text3 == null || (obj = text3.toString()) == null)) {
                str4 = obj;
            }
            sb.append(str4);
            sb.append('.');
            sb.append(str2);
            str4 = sb.toString();
        }
        renameCommonDialog.onConfirm.invoke(str4);
    }

    /* renamed from: initView$lambda-6  reason: not valid java name */
    public static final void m729initView$lambda6(RenameCommonDialog renameCommonDialog) {
        Object obj;
        Intrinsics.checkNotNullParameter(renameCommonDialog, "this$0");
        try {
            Result.Companion companion = Result.Companion;
            EditText editText = (EditText) renameCommonDialog._$_findCachedViewById(R.id.et_dialog_file_name);
            Editable text = ((EditText) renameCommonDialog._$_findCachedViewById(R.id.et_dialog_file_name)).getText();
            editText.setSelection(text != null ? text.length() : 0);
            obj = Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r2 = Result.m1158exceptionOrNullimpl(obj);
        if (r2 != null) {
            LoggerKt.e$default(r2, (Object) null, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r7 = r7.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onFileNameChange(java.lang.CharSequence r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0012
            java.lang.String r0 = r7.toString()
            if (r0 == 0) goto L_0x0012
            java.lang.CharSequence r0 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r0)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0014
        L_0x0012:
            java.lang.String r0 = ""
        L_0x0014:
            int r1 = r0.length()
            int r2 = r0.length()
            r3 = 0
            if (r7 == 0) goto L_0x002a
            java.lang.String r7 = r7.toString()
            if (r7 == 0) goto L_0x002a
            int r7 = r7.length()
            goto L_0x002b
        L_0x002a:
            r7 = 0
        L_0x002b:
            r4 = 1
            if (r2 == r7) goto L_0x005c
            r7 = 2131362399(0x7f0a025f, float:1.8344577E38)
            android.view.View r1 = r6._$_findCachedViewById(r7)
            android.widget.EditText r1 = (android.widget.EditText) r1
            r1.setText(r0)
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            if (r4 == 0) goto L_0x0052
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.EditText r7 = (android.widget.EditText) r7
            int r0 = r0.length()
            r7.setSelection(r0)
            goto L_0x005b
        L_0x0052:
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.EditText r7 = (android.widget.EditText) r7
            r7.setSelection(r3)
        L_0x005b:
            return
        L_0x005c:
            r7 = 2131363644(0x7f0a073c, float:1.8347103E38)
            android.view.View r0 = r6._$_findCachedViewById(r7)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r5 = 47
            r2.append(r5)
            int r5 = r6.maxNameLength
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.setText(r2)
            r0 = 2131363645(0x7f0a073d, float:1.8347105E38)
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r1 != 0) goto L_0x008b
            r2 = 0
            goto L_0x008d
        L_0x008b:
            r2 = 8
        L_0x008d:
            r0.setVisibility(r2)
            r0 = 2131363639(0x7f0a0737, float:1.8347093E38)
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r4 > r1) goto L_0x00a0
            int r2 = r6.maxNameLength
            if (r1 > r2) goto L_0x00a0
            r3 = 1
        L_0x00a0:
            r0.setEnabled(r3)
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r0 = r6.maxNameLength
            if (r1 > r0) goto L_0x00b5
            android.content.res.Resources r0 = r6.getResources()
            r1 = 2131100373(0x7f0602d5, float:1.7813126E38)
            goto L_0x00bc
        L_0x00b5:
            android.content.res.Resources r0 = r6.getResources()
            r1 = 2131100374(0x7f0602d6, float:1.7813128E38)
        L_0x00bc:
            int r0 = r0.getColor(r1)
            r7.setTextColor(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.business.core.ui.dialog.RenameCommonDialog.onFileNameChange(java.lang.CharSequence):void");
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

    public int getLayoutId() {
        return R.layout.dialog_rename_file;
    }

    @NotNull
    public final Function0<Unit> getOnCancel() {
        return this.onCancel;
    }

    @NotNull
    public final Function1<String, Unit> getOnConfirm() {
        return this.onConfirm;
    }

    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ((EditText) _$_findCachedViewById(R.id.et_dialog_file_name)).addTextChangedListener(new qw(this));
        String str = ad.m981switch(this.fileName);
        String str2 = ad.m980if(this.fileName);
        ((EditText) _$_findCachedViewById(R.id.et_dialog_file_name)).post(new fe.mmm.qw.rg.qw.ad.qw.ad(this));
        ((ImageView) _$_findCachedViewById(R.id.iv_text_clear)).setOnClickListener(new de(this));
        ((TextView) _$_findCachedViewById(R.id.tv_dialog_cancel)).setOnClickListener(new rg(this));
        ((TextView) _$_findCachedViewById(R.id.tv_dialog_confirm)).setOnClickListener(new fe.mmm.qw.rg.qw.ad.qw.qw(this, str, str2));
        ((EditText) _$_findCachedViewById(R.id.et_dialog_file_name)).setText(str);
        ((EditText) _$_findCachedViewById(R.id.et_dialog_file_name)).post(new fe(this));
        String str3 = this.cancelBtnText;
        boolean z = false;
        if (!(str3 == null || str3.length() == 0)) {
            ((TextView) _$_findCachedViewById(R.id.tv_dialog_cancel)).setText(this.cancelBtnText);
        }
        String str4 = this.confirmBtnText;
        if (str4 == null || str4.length() == 0) {
            z = true;
        }
        if (!z) {
            ((TextView) _$_findCachedViewById(R.id.tv_dialog_confirm)).setText(this.confirmBtnText);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setOnCancel(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onCancel = function0;
    }

    public final void setOnConfirm(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onConfirm = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RenameCommonDialog(String str, String str2, String str3, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? 30 : i2);
    }
}
