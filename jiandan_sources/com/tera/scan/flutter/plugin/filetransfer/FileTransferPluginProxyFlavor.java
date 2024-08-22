package com.tera.scan.flutter.plugin.filetransfer;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import com.tera.scan.permission.util.ReadImagesPermissionHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H\u0002\u001a7\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\r2!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H\u0000¨\u0006\u000e"}, d2 = {"getStoragePermissionRequest", "Lcom/tera/scan/flutter/plugin/filetransfer/IStoragePermissionRequest;", "Lcom/tera/scan/flutter/plugin/filetransfer/FileTransferPluginProxy;", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "permissionRequest", "Landroid/app/Activity;", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "FileTransferPluginProxyFlavor")
public final class FileTransferPluginProxyFlavor {

    public static final class qw implements IStoragePermissionRequest {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f6940ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<ReadImagesPermissionHelper> f6941de;
        public final /* synthetic */ FragmentActivity qw;

        public qw(FragmentActivity fragmentActivity, Function1<? super Boolean, Unit> function1, Ref.ObjectRef<ReadImagesPermissionHelper> objectRef) {
            this.qw = fragmentActivity;
            this.f6940ad = function1;
            this.f6941de = objectRef;
        }

        public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
            ReadImagesPermissionHelper readImagesPermissionHelper = (ReadImagesPermissionHelper) this.f6941de.element;
            if (readImagesPermissionHelper != null) {
                readImagesPermissionHelper.uk(i2, i3, intent);
            }
        }

        public void onRequestPermissionsResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(strArr, "permissions");
            Intrinsics.checkNotNullParameter(iArr, "grantResults");
            ReadImagesPermissionHelper readImagesPermissionHelper = (ReadImagesPermissionHelper) this.f6941de.element;
            if (readImagesPermissionHelper != null) {
                readImagesPermissionHelper.i(i2, strArr, iArr);
            }
        }

        public void qw() {
            if (Build.VERSION.SDK_INT < 34 || !new fe.mmm.qw.eee.qw(this.qw).ad(new String[]{"android.permission.READ_MEDIA_VISUAL_USER_SELECTED"})) {
                ReadImagesPermissionHelper readImagesPermissionHelper = (ReadImagesPermissionHelper) this.f6941de.element;
                boolean z = true;
                if (readImagesPermissionHelper == null || !readImagesPermissionHelper.yj()) {
                    z = false;
                }
                if (z) {
                    this.f6940ad.invoke(Boolean.TRUE);
                    return;
                }
                ReadImagesPermissionHelper readImagesPermissionHelper2 = (ReadImagesPermissionHelper) this.f6941de.element;
                if (readImagesPermissionHelper2 != null) {
                    readImagesPermissionHelper2.o();
                    return;
                }
                return;
            }
            this.f6940ad.invoke(Boolean.TRUE);
        }
    }

    public static final void ad(@NotNull FileTransferPluginProxy fileTransferPluginProxy, @NotNull Activity activity, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fileTransferPluginProxy, "<this>");
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(function1, "callback");
        if (activity instanceof FragmentActivity) {
            fileTransferPluginProxy.m763switch(qw(fileTransferPluginProxy, (FragmentActivity) activity, new FileTransferPluginProxyFlavor$permissionRequest$1(function1, fileTransferPluginProxy)));
            IStoragePermissionRequest pf2 = fileTransferPluginProxy.pf();
            if (pf2 != null) {
                pf2.qw();
                return;
            }
            return;
        }
        String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                ActivityCompat.requestPermissions(activity, (String[]) array, 101);
                function1.invoke(Boolean.FALSE);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        function1.invoke(Boolean.TRUE);
    }

    public static final IStoragePermissionRequest qw(FileTransferPluginProxy fileTransferPluginProxy, FragmentActivity fragmentActivity, Function1<? super Boolean, Unit> function1) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ReadImagesPermissionHelper(fragmentActivity, new FileTransferPluginProxyFlavor$getStoragePermissionRequest$1(function1, objectRef), (Function0) null, (Function0) null, new FileTransferPluginProxyFlavor$getStoragePermissionRequest$2(function1, objectRef), 12, (DefaultConstructorMarker) null);
        return new qw(fragmentActivity, function1, objectRef);
    }
}
