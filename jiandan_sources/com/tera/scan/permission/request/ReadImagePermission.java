package com.tera.scan.permission.request;

import android.content.Intent;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import com.tera.scan.permission.IPermission;
import com.tera.scan.permission.ui.dialog.ScanPermissionDialog;
import fe.mmm.qw.eee.qw;
import fe.mmm.qw.th.qw.th.o;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Bb\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001f\u001a\u00020\nJ\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0002J \u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'J+\u0010(\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u0006J\b\u00100\u001a\u00020\u0006H\u0002J\b\u00101\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R,\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u00063"}, d2 = {"Lcom/tera/scan/permission/request/ReadImagePermission;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "onDisplay", "Lkotlin/Function0;", "", "onAllowClick", "onRefuseClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "hasUserVisualPermission", "hasPermissionBlock", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getHasPermissionBlock", "()Lkotlin/jvm/functions/Function0;", "setHasPermissionBlock", "(Lkotlin/jvm/functions/Function0;)V", "isRequesting", "getOnAllowClick", "getOnDisplay", "getOnRefuseClick", "()Lkotlin/jvm/functions/Function1;", "permissionPresenter", "Lcom/tera/scan/permission/PermissionPresenter;", "getPermissionPresenter", "()Lcom/tera/scan/permission/PermissionPresenter;", "permissionPresenter$delegate", "Lkotlin/Lazy;", "hasPermission", "isReadImagesPermissionGranted", "isVisualUserSelectedGranted", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestReadImagesPermission", "requestReadImagesPermissions", "showOpenSystemPermissionSettingsDialog", "showUserDenyPermissionTips", "lib_permission_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReadImagePermission {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Function0<Unit> f7155ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Function0<Unit> f7156de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final Function1<Boolean, Unit> f7157fe;
    @NotNull
    public final FragmentActivity qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public Function0<Unit> f7158rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Lazy f7159th = LazyKt__LazyJVMKt.lazy(new ReadImagePermission$permissionPresenter$2(this));

    /* renamed from: yj  reason: collision with root package name */
    public boolean f7160yj;

    public ReadImagePermission(@NotNull FragmentActivity fragmentActivity, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function1<? super Boolean, Unit> function1, @NotNull Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(function0, "onDisplay");
        Intrinsics.checkNotNullParameter(function02, "onAllowClick");
        Intrinsics.checkNotNullParameter(function1, "onRefuseClick");
        Intrinsics.checkNotNullParameter(function03, "hasPermissionBlock");
        this.qw = fragmentActivity;
        this.f7155ad = function0;
        this.f7156de = function02;
        this.f7157fe = function1;
        this.f7158rg = function03;
    }

    public final void ggg() {
        this.f7160yj = false;
        o.rg(R.string.permission_all_file_user_refuse);
    }

    public final boolean i() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 0 && i2 < 33) {
            qw yj2 = yj();
            String[] strArr = IPermission.qw;
            Intrinsics.checkNotNullExpressionValue(strArr, "STORAGE_GROUP_PERMISSION");
            return yj2.ad(strArr);
        } else if (i2 == 33) {
            return yj().ad(new String[]{"android.permission.READ_MEDIA_IMAGES"});
        } else {
            boolean ad2 = yj().ad(new String[]{"android.permission.READ_MEDIA_IMAGES"});
            boolean ad3 = yj().ad(new String[]{"android.permission.READ_MEDIA_VISUAL_USER_SELECTED"});
            if (!ad2 || !ad3) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m888if(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (this.f7160yj) {
            this.f7160yj = false;
            if (i2 != 2223) {
                return;
            }
            if (i() || o()) {
                this.f7158rg.invoke();
                this.f7156de.invoke();
                fe.mmm.qw.eee.de.qw.ad(this.qw);
                return;
            }
            ppp();
        }
    }

    public final boolean o() {
        return Build.VERSION.SDK_INT >= 34 && yj().ad(new String[]{"android.permission.READ_MEDIA_VISUAL_USER_SELECTED"});
    }

    public final void pf(int i2, int i3, @Nullable Intent intent) {
        if (this.f7160yj) {
            this.f7160yj = false;
            if (i2 != 2223 && i2 != 5000) {
                return;
            }
            if (i() || o()) {
                this.f7158rg.invoke();
                this.f7156de.invoke();
                fe.mmm.qw.eee.de.qw.ad(this.qw);
            } else if (i2 == 5000) {
                ggg();
                fe.mmm.qw.eee.de.qw.ad(this.qw);
                this.f7157fe.invoke(Boolean.valueOf(o()));
            }
        }
    }

    public final void ppp() {
        Object obj;
        ScanPermissionDialog scanPermissionDialog = new ScanPermissionDialog();
        scanPermissionDialog.setCancelable(false);
        scanPermissionDialog.setOnAllowPermission(new ReadImagePermission$showOpenSystemPermissionSettingsDialog$1(this, scanPermissionDialog));
        scanPermissionDialog.setOnNotAllowPermission(new ReadImagePermission$showOpenSystemPermissionSettingsDialog$2(this, scanPermissionDialog));
        scanPermissionDialog.setOnDismiss(new ReadImagePermission$showOpenSystemPermissionSettingsDialog$3(this));
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
    }

    @NotNull
    public final Function0<Unit> rg() {
        return this.f7158rg;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m889switch() {
        if (!this.f7160yj) {
            this.f7160yj = true;
            if (i()) {
                this.f7160yj = false;
                this.f7158rg.invoke();
                return;
            }
            when();
            this.f7155ad.invoke();
        }
    }

    @NotNull
    public final Function1<Boolean, Unit> th() {
        return this.f7157fe;
    }

    public final boolean uk() {
        return i();
    }

    public final void when() {
        FragmentActivity fragmentActivity = this.qw;
        String string = fragmentActivity.getResources().getString(R.string.permission_desc_title_in_image);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt…sion_desc_title_in_image)");
        String string2 = this.qw.getResources().getString(R.string.permission_desc_detail_in_image);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt…ion_desc_detail_in_image)");
        fe.mmm.qw.eee.de.qw.qw(fragmentActivity, string, string2);
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i2 >= 0 && i2 < 33) {
            z = true;
        }
        if (z) {
            qw yj2 = yj();
            String[] strArr = IPermission.qw;
            Intrinsics.checkNotNullExpressionValue(strArr, "STORAGE_GROUP_PERMISSION");
            yj2.rg(strArr, 2223);
        } else if (i2 == 33) {
            yj().rg(new String[]{"android.permission.READ_MEDIA_IMAGES"}, 2223);
        } else if (yj().ad(new String[]{"android.permission.READ_MEDIA_IMAGES"}) || !yj().ad(new String[]{"android.permission.READ_MEDIA_VISUAL_USER_SELECTED"})) {
            yj().rg(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"}, 2223);
        } else {
            this.f7158rg.invoke();
            ppp();
        }
    }

    public final qw yj() {
        return (qw) this.f7159th.getValue();
    }
}
