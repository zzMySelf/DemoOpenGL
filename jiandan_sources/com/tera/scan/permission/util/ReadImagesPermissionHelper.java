package com.tera.scan.permission.util;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import com.tera.scan.permission.request.ReadImagePermission;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bb\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001e\u001a\u00020\u000bJ \u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$J+\u0010%\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*¢\u0006\u0002\u0010+J\u0006\u0010,\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R,\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/tera/scan/permission/util/ReadImagesPermissionHelper;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "hasPermissionBlock", "Lkotlin/Function0;", "", "onDisplay", "onAllowClick", "onRefuseClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "hasUserVisualPermission", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getHasPermissionBlock", "()Lkotlin/jvm/functions/Function0;", "setHasPermissionBlock", "(Lkotlin/jvm/functions/Function0;)V", "getOnAllowClick", "getOnDisplay", "getOnRefuseClick", "()Lkotlin/jvm/functions/Function1;", "readImagePermission", "Lcom/tera/scan/permission/request/ReadImagePermission;", "getReadImagePermission", "()Lcom/tera/scan/permission/request/ReadImagePermission;", "readImagePermission$delegate", "Lkotlin/Lazy;", "hasPermission", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestReadImagesPermission", "lib_permission_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReadImagesPermissionHelper {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public Function0<Unit> f7166ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Function0<Unit> f7167de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final Function0<Unit> f7168fe;
    @NotNull
    public final FragmentActivity qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final Function1<Boolean, Unit> f7169rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Lazy f7170th;

    public ReadImagesPermissionHelper(@NotNull FragmentActivity fragmentActivity, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(function0, "hasPermissionBlock");
        Intrinsics.checkNotNullParameter(function02, "onDisplay");
        Intrinsics.checkNotNullParameter(function03, "onAllowClick");
        Intrinsics.checkNotNullParameter(function1, "onRefuseClick");
        this.qw = fragmentActivity;
        this.f7166ad = function0;
        this.f7167de = function02;
        this.f7168fe = function03;
        this.f7169rg = function1;
        this.f7170th = LazyKt__LazyJVMKt.lazy(new ReadImagesPermissionHelper$readImagePermission$2(this));
    }

    @NotNull
    public final Function0<Unit> ad() {
        return this.f7166ad;
    }

    @NotNull
    public final Function0<Unit> de() {
        return this.f7168fe;
    }

    @NotNull
    public final Function0<Unit> fe() {
        return this.f7167de;
    }

    public final void i(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        th().m888if(i2, strArr, iArr);
    }

    public final void o() {
        th().m889switch();
    }

    public final void pf(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.f7166ad = function0;
    }

    @NotNull
    public final Function1<Boolean, Unit> rg() {
        return this.f7169rg;
    }

    public final ReadImagePermission th() {
        return (ReadImagePermission) this.f7170th.getValue();
    }

    public final void uk(int i2, int i3, @Nullable Intent intent) {
        th().pf(i2, i3, intent);
    }

    public final boolean yj() {
        return th().uk();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReadImagesPermissionHelper(FragmentActivity fragmentActivity, Function0 function0, Function0 function02, Function0 function03, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, (i2 & 2) != 0 ? AnonymousClass1.INSTANCE : function0, (i2 & 4) != 0 ? AnonymousClass2.INSTANCE : function02, (i2 & 8) != 0 ? AnonymousClass3.INSTANCE : function03, (i2 & 16) != 0 ? AnonymousClass4.INSTANCE : function1);
    }
}
