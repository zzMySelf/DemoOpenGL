package com.tera.scan.scanner.ocr.widget;

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

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/tera/scan/scanner/ocr/widget/ChangeScanTabDialog;", "", "isIdCardsControl", "", "(Z)V", "onCancelChange", "Lkotlin/Function0;", "", "getOnCancelChange", "()Lkotlin/jvm/functions/Function0;", "setOnCancelChange", "(Lkotlin/jvm/functions/Function0;)V", "onConfirmChange", "getOnConfirmChange", "setOnConfirmChange", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChangeScanTabDialog {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public Function0<Unit> f7296ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public Function0<Unit> f7297de;
    public final boolean qw;

    public ChangeScanTabDialog(boolean z) {
        this.qw = z;
    }

    @Nullable
    public final Function0<Unit> ad() {
        return this.f7297de;
    }

    public final void de(@Nullable Function0<Unit> function0) {
        this.f7296ad = function0;
    }

    public final void fe(@Nullable Function0<Unit> function0) {
        this.f7297de = function0;
    }

    @Nullable
    public final Function0<Unit> qw() {
        return this.f7296ad;
    }

    public final void rg(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        String str2;
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        if (this.qw) {
            str2 = ad.qw(R.string.give_up_take_idcard_dialog_title);
        } else {
            str2 = ad.qw(R.string.give_up_take_dialog_title);
        }
        ConfirmDialog.qw qwVar = new ConfirmDialog.qw();
        qwVar.xxx(str2);
        qwVar.rg(ad.qw(R.string.give_up_take_dialog_message));
        qwVar.fe(ad.qw(R.string.give_up_take_dialog_confirm));
        qwVar.ad(ad.qw(R.string.give_up_take_dialog_cancel));
        qwVar.de(true);
        ConfirmDialog qw2 = qwVar.qw();
        qw2.setOnConfirmChange(new ChangeScanTabDialog$show$1(this));
        qw2.setOnCancelChange(new ChangeScanTabDialog$show$2(this));
        qw2.show(fragmentManager, str);
    }
}
