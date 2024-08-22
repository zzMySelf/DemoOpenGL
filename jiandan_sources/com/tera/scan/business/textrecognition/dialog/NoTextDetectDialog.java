package com.tera.scan.business.textrecognition.dialog;

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

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n¨\u0006\f"}, d2 = {"Lcom/tera/scan/business/textrecognition/dialog/NoTextDetectDialog;", "", "()V", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "context", "Landroid/content/Context;", "onConfirmChange", "Lkotlin/Function0;", "onCancelChange", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NoTextDetectDialog {
    public final void qw(@NotNull FragmentManager fragmentManager, @NotNull Context context, @Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(R.string.retry);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ness.core.R.string.retry)");
        String string2 = context.getResources().getString(R.string.cancel_recognition);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr…tring.cancel_recognition)");
        String string3 = context.getResources().getString(R.string.no_text_detected);
        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr….string.no_text_detected)");
        ConfirmDialog.qw qwVar = new ConfirmDialog.qw();
        qwVar.de(false);
        qwVar.rg(string3);
        qwVar.fe(string);
        qwVar.ad(string2);
        ConfirmDialog qw = qwVar.qw();
        qw.setOnCancelChange(new NoTextDetectDialog$show$1(function02));
        qw.setOnConfirmChange(new NoTextDetectDialog$show$2(function0));
        qw.show(fragmentManager, "NoTextDetectDialog");
    }
}
