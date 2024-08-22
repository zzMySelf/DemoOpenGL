package fe.mmm.qw.l.fe.qw;

import com.baidu.sapi2.views.SmsLoginView;
import com.google.gson.Gson;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.ui.view.IBaseView;
import com.tera.scan.web.hybrid.ablity.IActionTitleBar;
import fe.mmm.qw.m.ggg.fe.ad;
import fe.mmm.qw.m.ggg.qw.qw;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Tag("HybridActionTitleBar")
public final class rg extends qw {
    @NotNull
    public final IActionTitleBar qw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rg(@NotNull IBaseView iBaseView, @NotNull IActionTitleBar iActionTitleBar) {
        super(iBaseView);
        Intrinsics.checkNotNullParameter(iBaseView, "baseView");
        Intrinsics.checkNotNullParameter(iActionTitleBar, "actionTitleBar");
        this.qw = iActionTitleBar;
    }

    public void onAction(@Nullable ad adVar) {
        LoggerKt.d(String.valueOf(adVar), "onAction");
        if (!isDestroy()) {
            this.mHybridParam = adVar;
            if (Intrinsics.areEqual((Object) adVar != null ? adVar.f8046de : null, (Object) "controllerRightBtn")) {
                qw();
            } else {
                handleRecognizeSchemeError(adVar);
            }
        }
    }

    public final void qw() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl((fe.mmm.qw.l.fe.ad.ad) new Gson().fromJson(this.mHybridParam.f8047fe, fe.mmm.qw.l.fe.ad.ad.class));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        fe.mmm.qw.l.fe.ad.ad adVar = (fe.mmm.qw.l.fe.ad.ad) obj;
        if (adVar != null) {
            String fe2 = adVar.fe();
            if (!(fe2 == null || fe2.length() == 0)) {
                this.qw.controlRightBtn(adVar);
                handleHybridCallback(this.mHybridParam, 1, SmsLoginView.f.k, new JSONObject());
                return;
            }
        }
        handleHybridCallback(this.mHybridParam, 0, "params error", new JSONObject());
    }
}
