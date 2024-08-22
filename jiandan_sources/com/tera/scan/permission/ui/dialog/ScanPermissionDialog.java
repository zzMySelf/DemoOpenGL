package com.tera.scan.permission.ui.dialog;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.dialog.ScanBaseDialogFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001e\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tera/scan/permission/ui/dialog/ScanPermissionDialog;", "Lcom/tera/scan/component/base/ui/dialog/ScanBaseDialogFragment;", "()V", "detailDescription", "", "onAllowPermission", "Lkotlin/Function0;", "", "getOnAllowPermission", "()Lkotlin/jvm/functions/Function0;", "setOnAllowPermission", "(Lkotlin/jvm/functions/Function0;)V", "onDismiss", "getOnDismiss", "setOnDismiss", "onNotAllowPermission", "getOnNotAllowPermission", "setOnNotAllowPermission", "simpleDescription", "getLayoutId", "", "initView", "dialog", "Landroid/content/DialogInterface;", "setDescription", "simple", "detail", "lib_permission_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanPermissionDialog extends ScanBaseDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public String detailDescription;
    @Nullable
    public Function0<Unit> onAllowPermission;
    @Nullable
    public Function0<Unit> onDismiss;
    @Nullable
    public Function0<Unit> onNotAllowPermission;
    @Nullable
    public String simpleDescription;

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m890initView$lambda0(ScanPermissionDialog scanPermissionDialog, View view) {
        Intrinsics.checkNotNullParameter(scanPermissionDialog, "this$0");
        Function0<Unit> function0 = scanPermissionDialog.onAllowPermission;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m891initView$lambda1(ScanPermissionDialog scanPermissionDialog, View view) {
        Intrinsics.checkNotNullParameter(scanPermissionDialog, "this$0");
        Function0<Unit> function0 = scanPermissionDialog.onNotAllowPermission;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void setDescription$default(ScanPermissionDialog scanPermissionDialog, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        scanPermissionDialog.setDescription(str, str2);
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
        return R.layout.dialog_permission_scan;
    }

    @Nullable
    public final Function0<Unit> getOnAllowPermission() {
        return this.onAllowPermission;
    }

    @Nullable
    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    @Nullable
    public final Function0<Unit> getOnNotAllowPermission() {
        return this.onNotAllowPermission;
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [android.view.View] */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007d, code lost:
        if ((r0.length() > 0) == true) goto L_0x0081;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
            r5 = this;
            android.view.View r0 = r5.getContentView()
            if (r0 == 0) goto L_0x0017
            r1 = 2131363719(0x7f0a0787, float:1.8347255E38)
            android.view.View r0 = r0.findViewById(r1)
            if (r0 == 0) goto L_0x0017
            fe.mmm.qw.eee.de.de.qw r1 = new fe.mmm.qw.eee.de.de.qw
            r1.<init>(r5)
            r0.setOnClickListener(r1)
        L_0x0017:
            android.view.View r0 = r5.getContentView()
            if (r0 == 0) goto L_0x002e
            r1 = 2131363721(0x7f0a0789, float:1.8347259E38)
            android.view.View r0 = r0.findViewById(r1)
            if (r0 == 0) goto L_0x002e
            fe.mmm.qw.eee.de.de.ad r1 = new fe.mmm.qw.eee.de.de.ad
            r1.<init>(r5)
            r0.setOnClickListener(r1)
        L_0x002e:
            android.view.View r0 = r5.getContentView()
            if (r0 == 0) goto L_0x0040
            r1 = 2131362574(0x7f0a030e, float:1.8344932E38)
            android.view.View r0 = r0.findViewById(r1)
            if (r0 == 0) goto L_0x0040
            fe.mmm.qw.eee.de.ad.qw(r0)
        L_0x0040:
            java.lang.String r0 = r5.simpleDescription
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0053
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x004e
            r0 = 1
            goto L_0x004f
        L_0x004e:
            r0 = 0
        L_0x004f:
            if (r0 != r1) goto L_0x0053
            r0 = 1
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            r3 = 0
            if (r0 == 0) goto L_0x0070
            android.view.View r0 = r5.getContentView()
            if (r0 == 0) goto L_0x0067
            r4 = 2131363722(0x7f0a078a, float:1.834726E38)
            android.view.View r0 = r0.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0068
        L_0x0067:
            r0 = r3
        L_0x0068:
            if (r0 != 0) goto L_0x006b
            goto L_0x0070
        L_0x006b:
            java.lang.String r4 = r5.simpleDescription
            r0.setText(r4)
        L_0x0070:
            java.lang.String r0 = r5.detailDescription
            if (r0 == 0) goto L_0x0080
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x007c
            r0 = 1
            goto L_0x007d
        L_0x007c:
            r0 = 0
        L_0x007d:
            if (r0 != r1) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r1 = 0
        L_0x0081:
            if (r1 == 0) goto L_0x009b
            android.view.View r0 = r5.getContentView()
            if (r0 == 0) goto L_0x0093
            r1 = 2131363720(0x7f0a0788, float:1.8347257E38)
            android.view.View r0 = r0.findViewById(r1)
            r3 = r0
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x0093:
            if (r3 != 0) goto L_0x0096
            goto L_0x009b
        L_0x0096:
            java.lang.String r0 = r5.detailDescription
            r3.setText(r0)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.permission.ui.dialog.ScanPermissionDialog.initView():void");
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setDescription(@Nullable String str, @Nullable String str2) {
        this.simpleDescription = str;
        this.detailDescription = str2;
    }

    public final void setOnAllowPermission(@Nullable Function0<Unit> function0) {
        this.onAllowPermission = function0;
    }

    public final void setOnDismiss(@Nullable Function0<Unit> function0) {
        this.onDismiss = function0;
    }

    public final void setOnNotAllowPermission(@Nullable Function0<Unit> function0) {
        this.onNotAllowPermission = function0;
    }
}
