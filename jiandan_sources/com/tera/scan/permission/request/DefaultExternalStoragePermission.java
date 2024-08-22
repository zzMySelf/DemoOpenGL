package com.tera.scan.permission.request;

import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.permission.ui.dialog.ScanPermissionDialog;
import fe.mmm.qw.eee.de.qw;
import fe.mmm.qw.th.qw.th.o;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\u0006\u0010\u001a\u001a\u00020\u0010J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 J+\u0010!\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u0006J\b\u0010)\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lcom/tera/scan/permission/request/DefaultExternalStoragePermission;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "onDisplay", "Lkotlin/Function0;", "", "onAllowClick", "onRefuseClick", "hasPermissionBlock", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getHasPermissionBlock", "()Lkotlin/jvm/functions/Function0;", "setHasPermissionBlock", "(Lkotlin/jvm/functions/Function0;)V", "isRequesting", "", "getOnAllowClick", "getOnDisplay", "getOnRefuseClick", "permissionPresenter", "Lcom/tera/scan/permission/PermissionPresenter;", "getPermissionPresenter", "()Lcom/tera/scan/permission/PermissionPresenter;", "permissionPresenter$delegate", "Lkotlin/Lazy;", "hasPermission", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestExternalStoragePermission", "showReqPermissionDialog", "showUserDenyPermissionTips", "lib_permission_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultExternalStoragePermission {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Function0<Unit> f7149ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Function0<Unit> f7150de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final Function0<Unit> f7151fe;
    @NotNull
    public final FragmentActivity qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public Function0<Unit> f7152rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Lazy f7153th = LazyKt__LazyJVMKt.lazy(new DefaultExternalStoragePermission$permissionPresenter$2(this));

    /* renamed from: yj  reason: collision with root package name */
    public boolean f7154yj;

    public DefaultExternalStoragePermission(@NotNull FragmentActivity fragmentActivity, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03, @NotNull Function0<Unit> function04) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(function0, "onDisplay");
        Intrinsics.checkNotNullParameter(function02, "onAllowClick");
        Intrinsics.checkNotNullParameter(function03, "onRefuseClick");
        Intrinsics.checkNotNullParameter(function04, "hasPermissionBlock");
        this.qw = fragmentActivity;
        this.f7149ad = function0;
        this.f7150de = function02;
        this.f7151fe = function03;
        this.f7152rg = function04;
    }

    public final void i() {
        if (!this.f7154yj) {
            this.f7154yj = true;
            if (Build.VERSION.SDK_INT >= 30) {
                if (Environment.isExternalStorageManager()) {
                    this.f7154yj = false;
                    this.f7152rg.invoke();
                    return;
                }
                o();
            } else if (th().de()) {
                this.f7154yj = false;
                this.f7152rg.invoke();
            } else {
                o();
            }
        }
    }

    public final void o() {
        Object obj;
        this.f7149ad.invoke();
        FragmentActivity fragmentActivity = this.qw;
        String string = fragmentActivity.getResources().getString(R.string.permission_desc_title_in_file);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt…ssion_desc_title_in_file)");
        String string2 = this.qw.getResources().getString(R.string.permission_desc_detail_in_file);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt…sion_desc_detail_in_file)");
        qw.qw(fragmentActivity, string, string2);
        ScanPermissionDialog scanPermissionDialog = new ScanPermissionDialog();
        scanPermissionDialog.setOnAllowPermission(new DefaultExternalStoragePermission$showReqPermissionDialog$1(this, scanPermissionDialog));
        scanPermissionDialog.setDescription(this.qw.getResources().getString(R.string.manage_all_file_permission_simple_description), this.qw.getResources().getString(R.string.manage_all_file_permission_detail_description));
        scanPermissionDialog.setOnNotAllowPermission(new DefaultExternalStoragePermission$showReqPermissionDialog$2(this, scanPermissionDialog));
        scanPermissionDialog.setOnDismiss(new DefaultExternalStoragePermission$showReqPermissionDialog$3(this));
        scanPermissionDialog.setCancelable(false);
        try {
            Result.Companion companion = Result.Companion;
            FragmentManager supportFragmentManager = this.qw.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            scanPermissionDialog.show(supportFragmentManager, "PermissionDialog");
            obj = Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r0 = Result.m1158exceptionOrNullimpl(obj);
        if (r0 != null) {
            r0.printStackTrace();
        }
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "require_files_reading_save_dialog_show", (List) null, 2, (Object) null);
    }

    public final void pf() {
        this.f7154yj = false;
        o.rg(R.string.permission_all_file_user_refuse);
    }

    @NotNull
    public final Function0<Unit> rg() {
        return this.f7151fe;
    }

    public final fe.mmm.qw.eee.qw th() {
        return (fe.mmm.qw.eee.qw) this.f7153th.getValue();
    }

    public final void uk(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (this.f7154yj) {
            this.f7154yj = false;
            if (i2 == 2223) {
                qw.ad(this.qw);
                if (th().de()) {
                    this.f7152rg.invoke();
                    this.f7150de.invoke();
                    return;
                }
                pf();
                this.f7151fe.invoke();
            }
        }
    }

    public final void yj(int i2, int i3, @Nullable Intent intent) {
        if (this.f7154yj) {
            this.f7154yj = false;
            if (i2 == 2222) {
                qw.ad(this.qw);
                if (Build.VERSION.SDK_INT < 30) {
                    return;
                }
                if (Environment.isExternalStorageManager()) {
                    this.f7152rg.invoke();
                    this.f7150de.invoke();
                    return;
                }
                pf();
                this.f7151fe.invoke();
            }
        }
    }
}
