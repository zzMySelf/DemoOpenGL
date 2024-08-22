package com.tera.scan.permission.request;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.dialog.ConfirmDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rJ&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rJ&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/permission/request/PermissionDialogAfterRefuseDialogInternal;", "", "()V", "show", "", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "title", "", "permissionDesc", "onDismiss", "Lkotlin/Function0;", "showCameraPermissionDialog", "showNotificationPermissionDialog", "lib_permission_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PermissionDialogAfterRefuseDialogInternal {
    public final void ad(@NotNull Context context, @NotNull FragmentManager fragmentManager, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        String string = context.getResources().getString(R.string.open_system_camera_permission_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…_permission_dialog_title)");
        String string2 = context.getResources().getString(R.string.open_system_camera_permission_dialog_content);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr…ermission_dialog_content)");
        qw(context, fragmentManager, string, string2, function0);
    }

    public final void de(@NotNull Context context, @NotNull FragmentManager fragmentManager, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        String string = context.getResources().getString(R.string.open_system_notification_permission_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…_permission_dialog_title)");
        String string2 = context.getResources().getString(R.string.open_system_notification_permission_dialog_content);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr…ermission_dialog_content)");
        qw(context, fragmentManager, string, string2, function0);
    }

    public final void qw(@NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull String str, @NotNull String str2, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "permissionDesc");
        ConfirmDialog.qw qwVar = new ConfirmDialog.qw();
        qwVar.xxx(str);
        qwVar.rg(str2);
        String string = context.getResources().getString(R.string.button_allow_open_system_permission_setting);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ystem_permission_setting)");
        qwVar.fe(string);
        qwVar.de(true);
        ConfirmDialog qw = qwVar.qw();
        qw.setOnConfirmChange(new PermissionDialogAfterRefuseDialogInternal$show$1(context));
        qw.setOnDismiss(function0);
        qw.setCancelable(false);
        qw.show(fragmentManager, "PermissionDialogAfterRefuseDialog");
    }
}
