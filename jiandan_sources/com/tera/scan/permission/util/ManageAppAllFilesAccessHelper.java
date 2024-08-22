package com.tera.scan.permission.util;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import com.tera.scan.permission.request.DefaultExternalStoragePermission;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\u0006\u0010\u0018\u001a\u00020\u0019J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ+\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006("}, d2 = {"Lcom/tera/scan/permission/util/ManageAppAllFilesAccessHelper;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "onDisplay", "Lkotlin/Function0;", "", "onAllowClick", "onRefuseClick", "hasPermissionBlock", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "externalStoragePermission", "Lcom/tera/scan/permission/request/DefaultExternalStoragePermission;", "getExternalStoragePermission", "()Lcom/tera/scan/permission/request/DefaultExternalStoragePermission;", "externalStoragePermission$delegate", "Lkotlin/Lazy;", "getHasPermissionBlock", "()Lkotlin/jvm/functions/Function0;", "setHasPermissionBlock", "(Lkotlin/jvm/functions/Function0;)V", "getOnAllowClick", "getOnDisplay", "getOnRefuseClick", "hasPermission", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestAllFilesAccessPermission", "lib_permission_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ManageAppAllFilesAccessHelper {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Function0<Unit> f7161ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Function0<Unit> f7162de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final Function0<Unit> f7163fe;
    @NotNull
    public final FragmentActivity qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public Function0<Unit> f7164rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Lazy f7165th;

    public ManageAppAllFilesAccessHelper(@NotNull FragmentActivity fragmentActivity, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03, @NotNull Function0<Unit> function04) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(function0, "onDisplay");
        Intrinsics.checkNotNullParameter(function02, "onAllowClick");
        Intrinsics.checkNotNullParameter(function03, "onRefuseClick");
        Intrinsics.checkNotNullParameter(function04, "hasPermissionBlock");
        this.qw = fragmentActivity;
        this.f7161ad = function0;
        this.f7162de = function02;
        this.f7163fe = function03;
        this.f7164rg = function04;
        this.f7165th = LazyKt__LazyJVMKt.lazy(new ManageAppAllFilesAccessHelper$externalStoragePermission$2(this));
    }

    public final DefaultExternalStoragePermission ad() {
        return (DefaultExternalStoragePermission) this.f7165th.getValue();
    }

    @NotNull
    public final Function0<Unit> de() {
        return this.f7164rg;
    }

    @NotNull
    public final Function0<Unit> fe() {
        return this.f7162de;
    }

    public final void i() {
        ad().i();
    }

    public final void o(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.f7164rg = function0;
    }

    @NotNull
    public final Function0<Unit> rg() {
        return this.f7161ad;
    }

    @NotNull
    public final Function0<Unit> th() {
        return this.f7163fe;
    }

    public final void uk(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        ad().uk(i2, strArr, iArr);
    }

    public final void yj(int i2, int i3, @Nullable Intent intent) {
        ad().yj(i2, i3, intent);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ManageAppAllFilesAccessHelper(FragmentActivity fragmentActivity, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, (i2 & 2) != 0 ? AnonymousClass1.INSTANCE : function0, (i2 & 4) != 0 ? AnonymousClass2.INSTANCE : function02, (i2 & 8) != 0 ? AnonymousClass3.INSTANCE : function03, (i2 & 16) != 0 ? AnonymousClass4.INSTANCE : function04);
    }
}
