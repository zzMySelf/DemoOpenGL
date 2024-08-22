package fe.mmm.qw.k.o;

import androidx.fragment.app.FragmentActivity;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.ui.view.IBaseView;
import fe.fe.when.qw.qw.de;
import fe.mmm.qw.m.ggg.fe.ad;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Tag("HybridActionPayProduct")
public final class qw extends fe.mmm.qw.m.ggg.qw.qw {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qw(@NotNull IBaseView iBaseView) {
        super(iBaseView);
        Intrinsics.checkNotNullParameter(iBaseView, "baseView");
    }

    public final void ad(String str) {
        FragmentActivity fragmentActivity = null;
        boolean z = true;
        LoggerKt.d$default("payProduct:" + str + " this:" + this, (Object) null, 1, (Object) null);
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z = false;
        }
        if (z) {
            handleHybridCallback(this.mHybridParam, 0, "params error", new JSONObject());
            return;
        }
        FragmentActivity activity = this.mBaseView.getActivity();
        if (activity instanceof FragmentActivity) {
            fragmentActivity = activity;
        }
        if (fragmentActivity == null) {
            handleHybridCallback(this.mHybridParam, 0, "page error", new JSONObject());
        } else {
            new de().fe(fragmentActivity, str, new fe.mmm.qw.k.i.qw(this.mBaseView, this));
        }
    }

    public final void de() {
        try {
            Result.Companion companion = Result.Companion;
            TradeAccount.ggg(TradeAccount.f913rg, (Function0) null, 1, (Object) null);
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public void onAction(@Nullable ad adVar) {
        if (!isDestroy()) {
            this.mHybridParam = adVar;
            String str = null;
            LoggerKt.d$default("param:" + adVar, (Object) null, 1, (Object) null);
            if (adVar != null) {
                str = adVar.f8046de;
            }
            if (Intrinsics.areEqual((Object) str, (Object) "payProduct")) {
                ad(adVar.f8047fe);
            } else if (Intrinsics.areEqual((Object) str, (Object) "syncProduct")) {
                de();
            } else {
                handleRecognizeSchemeError(adVar);
            }
        }
    }

    public final void qw(@NotNull fe.fe.when.qw.qw.yj.ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "result");
        LoggerKt.d$default("actionResult:" + adVar, (Object) null, 1, (Object) null);
        if (adVar.fe()) {
            TradeAccount.ggg(TradeAccount.f913rg, (Function0) null, 1, (Object) null);
            handleHybridCallback(this.mHybridParam, 1, "pay success", new JSONObject());
        } else if (adVar.ad()) {
            handleHybridCallback(this.mHybridParam, 0, "", new JSONObject());
        } else {
            handleHybridCallback(this.mHybridParam, 2, "", new JSONObject());
        }
    }
}
