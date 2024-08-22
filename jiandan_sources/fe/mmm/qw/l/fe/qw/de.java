package fe.mmm.qw.l.fe.qw;

import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.ubc.UBCManager;
import com.google.gson.Gson;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.ui.view.IBaseView;
import fe.mmm.qw.m.ggg.fe.ad;
import fe.mmm.qw.m.ggg.qw.qw;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Tag("HybridActionForward")
public final class de extends qw {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public de(@NotNull IBaseView iBaseView) {
        super(iBaseView);
        Intrinsics.checkNotNullParameter(iBaseView, "baseView");
    }

    public final void ad(ad adVar) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl((fe.mmm.qw.l.fe.ad.qw) new Gson().fromJson(adVar != null ? adVar.f8047fe : null, fe.mmm.qw.l.fe.ad.qw.class));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1158exceptionOrNullimpl(obj) == null) {
            fe.mmm.qw.l.fe.ad.qw qwVar = (fe.mmm.qw.l.fe.ad.qw) obj;
            LoggerKt.d$default("WebForwardProvider jump url:" + qwVar.qw, (Object) null, 1, (Object) null);
            String str = qwVar.qw;
            if ((str == null || str.length() == 0) || !fe.mmm.qw.l.de.ad(this.mBaseView.getActivity(), qwVar.qw)) {
                handleHybridCallback(adVar, 0, "params error", new JSONObject());
                return;
            }
            de(Intrinsics.areEqual((Object) qwVar.f8014ad, (Object) "1"));
            handleHybridCallback(adVar, 1, SmsLoginView.f.k, new JSONObject());
        }
    }

    public void callH5Function(@Nullable String str, int i2, @Nullable String str2, @Nullable JSONObject jSONObject) {
        super.callH5Function(str, i2, str2, jSONObject);
    }

    public final void de(boolean z) {
        if (!z) {
            try {
                Result.Companion companion = Result.Companion;
                this.mBaseView.getActivity().finish();
                Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    public void handleHybridCallback(@Nullable ad adVar, int i2, @Nullable String str, @Nullable JSONObject jSONObject) {
        super.handleHybridCallback(adVar, i2, str, jSONObject);
    }

    public void handleNewHybridCallback(@Nullable String str, int i2, @Nullable String str2, @Nullable JSONObject jSONObject) {
        super.handleNewHybridCallback(str, i2, str2, jSONObject);
    }

    public void handleRecognizeSchemeError(@Nullable ad adVar) {
        super.handleRecognizeSchemeError(adVar);
    }

    public void onAction(@Nullable ad adVar) {
        if (!isDestroy()) {
            this.mHybridParam = adVar;
            StringBuilder sb = new StringBuilder();
            sb.append("HybridActionForward param:");
            String str = null;
            sb.append(adVar != null ? adVar.f8047fe : null);
            LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
            if (adVar != null) {
                str = adVar.f8046de;
            }
            if (Intrinsics.areEqual((Object) "open", (Object) str)) {
                qw(adVar);
                LoggerKt.d(Unit.INSTANCE, "HybridActionForward result");
                return;
            }
            handleRecognizeSchemeError(adVar);
        }
    }

    public final void qw(ad adVar) {
        Object obj;
        if (adVar != null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m1155constructorimpl(new JSONObject(adVar.f8047fe).optString(UBCManager.CONTENT_KEY_PAGE));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m1161isFailureimpl(obj)) {
                obj = null;
            }
            String str = (String) obj;
            if (str == null || str.length() == 0) {
                handleHybridCallback(this.mHybridParam, 0, "params error", new JSONObject());
            } else if (Intrinsics.areEqual((Object) str, (Object) "wappage")) {
                ad(adVar);
            } else {
                handleHybridCallback(this.mHybridParam, 0, "params error", new JSONObject());
            }
        }
    }
}
