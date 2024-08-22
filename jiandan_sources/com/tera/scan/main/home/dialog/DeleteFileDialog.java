package com.tera.scan.main.home.dialog;

import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.dialog.ConfirmDialog;
import fe.mmm.qw.p030switch.th.de.ad.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/tera/scan/main/home/dialog/DeleteFileDialog;", "", "()V", "onDeleteCancel", "Lkotlin/Function0;", "", "getOnDeleteCancel", "()Lkotlin/jvm/functions/Function0;", "setOnDeleteCancel", "(Lkotlin/jvm/functions/Function0;)V", "onDeleteConfirm", "getOnDeleteConfirm", "setOnDeleteConfirm", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeleteFileDialog {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public Function0<Unit> f6969ad;
    @Nullable
    public Function0<Unit> qw;

    @Nullable
    public final Function0<Unit> ad() {
        return this.f6969ad;
    }

    public final void de(@Nullable Function0<Unit> function0) {
        this.f6969ad = function0;
    }

    public final void fe(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        ConfirmDialog.qw qwVar = new ConfirmDialog.qw();
        qwVar.rg(ad.qw(R.string.delete_dialog_content));
        qwVar.fe(ad.qw(R.string.confirm_delete));
        qwVar.ad(ad.qw(R.string.cancel_delete));
        qwVar.de(true);
        ConfirmDialog qw2 = qwVar.qw();
        qw2.setOnConfirmChange(new DeleteFileDialog$show$1(this));
        qw2.setOnCancelChange(new DeleteFileDialog$show$2(this));
        qw2.show(fragmentManager, str);
    }

    @Nullable
    public final Function0<Unit> qw() {
        return this.qw;
    }
}
