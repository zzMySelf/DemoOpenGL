package com.tera.scan.upgrade.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.dialog.ScanBaseDialogFragment;
import com.tera.scan.ui.view.widget.UIButton;
import com.tera.scan.ui.view.widget.UIImageView;
import com.tera.scan.ui.view.widget.UITextView;
import fe.mmm.qw.g.ad.ad;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006!"}, d2 = {"Lcom/tera/scan/upgrade/ui/UpgradeDialog;", "Lcom/tera/scan/component/base/ui/dialog/ScanBaseDialogFragment;", "builder", "Lcom/tera/scan/upgrade/ui/UpgradeDialog$Builder;", "(Lcom/tera/scan/upgrade/ui/UpgradeDialog$Builder;)V", "confirmBtn", "Lcom/tera/scan/ui/view/widget/UIButton;", "lastClickTime", "", "onCancelChange", "Lkotlin/Function0;", "", "getOnCancelChange", "()Lkotlin/jvm/functions/Function0;", "setOnCancelChange", "(Lkotlin/jvm/functions/Function0;)V", "onConfirmChange", "getOnConfirmChange", "setOnConfirmChange", "onDismiss", "getOnDismiss", "setOnDismiss", "getLayoutId", "", "initView", "isShowing", "", "dialog", "Landroid/content/DialogInterface;", "onDownloadStatusChange", "status", "progress", "Builder", "app-upgrade_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpgradeDialog extends ScanBaseDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final qw builder;
    @Nullable
    public UIButton confirmBtn;
    public long lastClickTime;
    @Nullable
    public Function0<Unit> onCancelChange;
    @Nullable
    public Function0<Unit> onConfirmChange;
    @Nullable
    public Function0<Unit> onDismiss;

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f7438ad = -1;
        @NotNull

        /* renamed from: de  reason: collision with root package name */
        public String f7439de = "";

        /* renamed from: fe  reason: collision with root package name */
        public int f7440fe = -1;

        /* renamed from: i  reason: collision with root package name */
        public boolean f7441i = true;
        @NotNull
        public String qw = "";
        @NotNull

        /* renamed from: rg  reason: collision with root package name */
        public String f7442rg = "";

        /* renamed from: th  reason: collision with root package name */
        public int f7443th = -1;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f7444uk;

        /* renamed from: yj  reason: collision with root package name */
        public int f7445yj = -1;

        @NotNull
        public final qw ad(boolean z) {
            this.f7441i = z;
            return this;
        }

        @NotNull
        public final qw de(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.f7442rg = str;
            return this;
        }

        @NotNull
        public final qw fe(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.f7439de = str;
            return this;
        }

        @NotNull
        public final String i() {
            return this.f7439de;
        }

        @NotNull
        /* renamed from: if  reason: not valid java name */
        public final String m936if() {
            return this.qw;
        }

        public final int o() {
            return this.f7440fe;
        }

        public final boolean pf() {
            return this.f7444uk;
        }

        @NotNull
        public final qw ppp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.qw = str;
            return this;
        }

        @NotNull
        public final UpgradeDialog qw() {
            return new UpgradeDialog(this);
        }

        public final boolean rg() {
            return this.f7441i;
        }

        /* renamed from: switch  reason: not valid java name */
        public final int m937switch() {
            return this.f7438ad;
        }

        public final int th() {
            return this.f7445yj;
        }

        public final int uk() {
            return this.f7443th;
        }

        @NotNull
        public final qw when(boolean z) {
            this.f7444uk = z;
            return this;
        }

        @NotNull
        public final String yj() {
            return this.f7442rg;
        }
    }

    public UpgradeDialog(@NotNull qw qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, "builder");
        this.builder = qwVar;
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m934initView$lambda3(UpgradeDialog upgradeDialog, View view) {
        Intrinsics.checkNotNullParameter(upgradeDialog, "this$0");
        upgradeDialog.dismiss();
        Function0<Unit> function0 = upgradeDialog.onCancelChange;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: initView$lambda-5  reason: not valid java name */
    public static final void m935initView$lambda5(UpgradeDialog upgradeDialog, View view) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(upgradeDialog, "this$0");
        if (System.currentTimeMillis() - upgradeDialog.lastClickTime >= 1000 && (function0 = upgradeDialog.onConfirmChange) != null) {
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
        return R.layout.dialog_upgrade;
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
        UITextView uITextView = (UITextView) findViewById(R.id.tv_dialog_upgrade_title);
        boolean z = true;
        if (uITextView != null) {
            uITextView.setVisibility(this.builder.m936if().length() > 0 ? 0 : 8);
            uITextView.setText(this.builder.m936if());
            if (this.builder.m937switch() != -1) {
                uITextView.setTextColor(this.builder.m937switch());
            }
        }
        UITextView uITextView2 = (UITextView) findViewById(R.id.tv_dialog_upgrade_content);
        if (uITextView2 != null) {
            uITextView2.setVisibility(this.builder.i().length() > 0 ? 0 : 8);
            uITextView2.setText(this.builder.i());
            if (this.builder.o() != -1) {
                uITextView2.setTextColor(this.builder.o());
            }
        }
        UIImageView uIImageView = (UIImageView) findViewById(R.id.iv_dialog_upgrade_close);
        if (uIImageView != null) {
            if (this.builder.pf()) {
                uIImageView.setVisibility(8);
            }
            uIImageView.setOnClickListener(new ad(this));
        }
        UIButton uIButton = (UIButton) findViewById(R.id.btn_dialog_upgrade);
        if (uIButton != null) {
            if (this.builder.yj().length() <= 0) {
                z = false;
            }
            if (z) {
                uIButton.setText(this.builder.yj());
            }
            if (this.builder.uk() != -1) {
                uIButton.setTextColor(this.builder.uk());
            }
            if (this.builder.th() != -1) {
                uIButton.getHelper().b(this.builder.th());
            }
            this.confirmBtn = uIButton;
            uIButton.setOnClickListener(new fe.mmm.qw.g.ad.qw(this));
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(this.builder.rg());
        }
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
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

    public final void onDownloadStatusChange(int i2, int i3) {
        String str;
        if (i2 != 0) {
            String str2 = null;
            if (i2 == 1) {
                UIButton uIButton = this.confirmBtn;
                if (uIButton != null) {
                    Context context = uIButton.getContext();
                    if (context != null) {
                        str2 = context.getString(R.string.install_now);
                    }
                    uIButton.setText(str2);
                    uIButton.setTextColor(uIButton.getResources().getColor(R.color.upgrade_dialog_text_color));
                    uIButton.setEnabled(true);
                }
            } else if (i2 != 2) {
                UIButton uIButton2 = this.confirmBtn;
                if (uIButton2 != null) {
                    Context context2 = uIButton2.getContext();
                    if (context2 != null) {
                        str2 = context2.getString(R.string.update_now);
                    }
                    uIButton2.setText(str2);
                    uIButton2.setTextColor(uIButton2.getResources().getColor(R.color.upgrade_dialog_text_color));
                    uIButton2.setEnabled(true);
                }
            } else {
                UIButton uIButton3 = this.confirmBtn;
                if (uIButton3 != null) {
                    Context context3 = uIButton3.getContext();
                    if (context3 != null) {
                        str2 = context3.getString(R.string.retry_download);
                    }
                    uIButton3.setText(str2);
                    uIButton3.setTextColor(uIButton3.getResources().getColor(R.color.upgrade_dialog_text_color));
                    uIButton3.setEnabled(true);
                }
            }
        } else {
            UIButton uIButton4 = this.confirmBtn;
            if (uIButton4 != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Context context4 = uIButton4.getContext();
                if (context4 == null || (str = context4.getString(R.string.downloading)) == null) {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(str, "context?.getString(R.string.downloading) ?: \"\"");
                String format = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(i3), "%"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                uIButton4.setText(format);
                uIButton4.setTextColor(uIButton4.getResources().getColor(R.color.upgrade_dialog_text_color_downloading));
                uIButton4.setEnabled(false);
            }
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
