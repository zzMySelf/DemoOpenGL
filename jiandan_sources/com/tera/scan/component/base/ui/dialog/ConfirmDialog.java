package com.tera.scan.component.base.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.ui.view.widget.UIButton;
import fe.mmm.qw.th.qw.rg.qw.ad;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/tera/scan/component/base/ui/dialog/ConfirmDialog;", "Lcom/tera/scan/component/base/ui/dialog/ScanBaseDialogFragment;", "builder", "Lcom/tera/scan/component/base/ui/dialog/ConfirmDialog$Builder;", "(Lcom/tera/scan/component/base/ui/dialog/ConfirmDialog$Builder;)V", "onCancelChange", "Lkotlin/Function0;", "", "getOnCancelChange", "()Lkotlin/jvm/functions/Function0;", "setOnCancelChange", "(Lkotlin/jvm/functions/Function0;)V", "onConfirmChange", "getOnConfirmChange", "setOnConfirmChange", "onDismiss", "getOnDismiss", "setOnDismiss", "getLayoutId", "", "initView", "dialog", "Landroid/content/DialogInterface;", "Builder", "component-base_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfirmDialog extends ScanBaseDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final qw builder;
    @Nullable
    public Function0<Unit> onCancelChange;
    @Nullable
    public Function0<Unit> onConfirmChange;
    @Nullable
    public Function0<Unit> onDismiss;

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f6831ad = -1;
        @NotNull

        /* renamed from: de  reason: collision with root package name */
        public String f6832de = "";

        /* renamed from: fe  reason: collision with root package name */
        public int f6833fe = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f6834i = -1;

        /* renamed from: if  reason: not valid java name */
        public boolean f281if = true;

        /* renamed from: o  reason: collision with root package name */
        public int f6835o = -1;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f6836pf;
        @NotNull
        public String qw = "";
        @NotNull

        /* renamed from: rg  reason: collision with root package name */
        public String f6837rg = "";

        /* renamed from: th  reason: collision with root package name */
        public int f6838th = -1;
        @NotNull

        /* renamed from: uk  reason: collision with root package name */
        public String f6839uk = "";

        /* renamed from: yj  reason: collision with root package name */
        public int f6840yj = -1;

        @NotNull
        public final qw ad(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.f6837rg = str;
            return this;
        }

        @NotNull
        public final qw de(boolean z) {
            this.f281if = z;
            return this;
        }

        @NotNull
        public final qw fe(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.f6839uk = str;
            return this;
        }

        @NotNull
        public final String ggg() {
            return this.qw;
        }

        public final boolean i() {
            return this.f281if;
        }

        /* renamed from: if  reason: not valid java name */
        public final int m750if() {
            return this.f6834i;
        }

        public final int o() {
            return this.f6835o;
        }

        @NotNull
        public final String pf() {
            return this.f6839uk;
        }

        public final boolean ppp() {
            return this.f6836pf;
        }

        @NotNull
        public final ConfirmDialog qw() {
            return new ConfirmDialog(this);
        }

        @NotNull
        public final qw rg(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.f6832de = str;
            return this;
        }

        @NotNull
        /* renamed from: switch  reason: not valid java name */
        public final String m751switch() {
            return this.f6832de;
        }

        public final int th() {
            return this.f6840yj;
        }

        public final int uk() {
            return this.f6838th;
        }

        public final int vvv() {
            return this.f6831ad;
        }

        public final int when() {
            return this.f6833fe;
        }

        @NotNull
        public final qw xxx(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.qw = str;
            return this;
        }

        @NotNull
        public final String yj() {
            return this.f6837rg;
        }
    }

    public ConfirmDialog(@NotNull qw qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, "builder");
        this.builder = qwVar;
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m748initView$lambda3(ConfirmDialog confirmDialog, View view) {
        Intrinsics.checkNotNullParameter(confirmDialog, "this$0");
        confirmDialog.dismiss();
        Function0<Unit> function0 = confirmDialog.onCancelChange;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: initView$lambda-5  reason: not valid java name */
    public static final void m749initView$lambda5(ConfirmDialog confirmDialog, View view) {
        Intrinsics.checkNotNullParameter(confirmDialog, "this$0");
        confirmDialog.dismiss();
        Function0<Unit> function0 = confirmDialog.onConfirmChange;
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

    public int getLayoutId() {
        return R.layout.dialog_confirm;
    }

    @Nullable
    public final Function0<Unit> getOnCancelChange() {
        return this.onCancelChange;
    }

    @Nullable
    public final Function0<Unit> getOnConfirmChange() {
        return this.onConfirmChange;
    }

    @Nullable
    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public void initView() {
        TextView textView = (TextView) findViewById(R.id.alert_message);
        boolean z = true;
        if (textView != null) {
            textView.setVisibility(this.builder.ggg().length() > 0 ? 0 : 8);
            textView.setText(this.builder.ggg());
            if (this.builder.vvv() != -1) {
                textView.setTextColor(this.builder.vvv());
            }
        }
        TextView textView2 = (TextView) findViewById(R.id.tv_alert_desc);
        if (textView2 != null) {
            textView2.setVisibility(this.builder.m751switch().length() > 0 ? 0 : 8);
            textView2.setText(this.builder.m751switch());
            if (this.builder.when() != -1) {
                textView2.setTextColor(this.builder.when());
            }
        }
        UIButton uIButton = (UIButton) findViewById(R.id.btn_cancel);
        if (uIButton != null) {
            if (this.builder.ppp()) {
                uIButton.setVisibility(8);
            }
            if (this.builder.yj().length() > 0) {
                uIButton.setText(this.builder.yj());
            }
            if (this.builder.uk() != -1) {
                uIButton.setTextColor(this.builder.uk());
            }
            if (this.builder.th() != -1) {
                uIButton.getHelper().b(this.builder.th());
            }
            uIButton.setOnClickListener(new fe.mmm.qw.th.qw.rg.qw.qw(this));
        }
        UIButton uIButton2 = (UIButton) findViewById(R.id.btn_confirm);
        if (uIButton2 != null) {
            if (this.builder.pf().length() <= 0) {
                z = false;
            }
            if (z) {
                uIButton2.setText(this.builder.pf());
            }
            if (this.builder.m750if() != -1) {
                uIButton2.setTextColor(this.builder.m750if());
            }
            if (this.builder.o() != -1) {
                uIButton2.getHelper().b(this.builder.o());
            }
            uIButton2.setOnClickListener(new ad(this));
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(this.builder.i());
        }
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

    public final void setOnCancelChange(@Nullable Function0<Unit> function0) {
        this.onCancelChange = function0;
    }

    public final void setOnConfirmChange(@Nullable Function0<Unit> function0) {
        this.onConfirmChange = function0;
    }

    public final void setOnDismiss(@Nullable Function0<Unit> function0) {
        this.onDismiss = function0;
    }
}
