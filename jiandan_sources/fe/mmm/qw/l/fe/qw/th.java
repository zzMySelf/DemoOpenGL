package fe.mmm.qw.l.fe.qw;

import com.baidu.sapi2.views.SmsLoginView;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.framework.ui.view.IBaseView;
import com.tera.scan.webview.hybrid.action.IWebView;
import com.tera.scan.webview.hybrid.action.IWebViewCallback;
import fe.mmm.qw.m.ggg.fe.ad;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class th extends fe.mmm.qw.m.ggg.qw.qw implements IWebViewCallback {
    @Nullable
    public final IWebView qw;

    public static final class qw {
        @SerializedName("w")

        /* renamed from: ad  reason: collision with root package name */
        public final int f8017ad;
        @SerializedName("page_count")
        @Nullable

        /* renamed from: de  reason: collision with root package name */
        public final Integer f8018de;
        @SerializedName("status_bar_type")
        @Nullable

        /* renamed from: fe  reason: collision with root package name */
        public final Integer f8019fe;
        @SerializedName("h")
        public final int qw;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof qw)) {
                return false;
            }
            qw qwVar = (qw) obj;
            return this.qw == qwVar.qw && this.f8017ad == qwVar.f8017ad && Intrinsics.areEqual((Object) this.f8018de, (Object) qwVar.f8018de) && Intrinsics.areEqual((Object) this.f8019fe, (Object) qwVar.f8019fe);
        }

        public int hashCode() {
            int i2 = ((this.qw * 31) + this.f8017ad) * 31;
            Integer num = this.f8018de;
            int i3 = 0;
            int hashCode = (i2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.f8019fe;
            if (num2 != null) {
                i3 = num2.hashCode();
            }
            return hashCode + i3;
        }

        @Nullable
        public final Integer qw() {
            return this.f8019fe;
        }

        @NotNull
        public String toString() {
            return "WebViewData(h=" + this.qw + ", w=" + this.f8017ad + ", pageCount=" + this.f8018de + ", statusBarType=" + this.f8019fe + ')';
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public th(@NotNull IBaseView iBaseView, @Nullable IWebView iWebView) {
        super(iBaseView);
        Intrinsics.checkNotNullParameter(iBaseView, "baseView");
        this.qw = iWebView;
        if (iWebView != null) {
            iWebView.setCallback(this);
        }
    }

    public void onAction(@Nullable ad adVar) {
        this.mHybridParam = adVar;
        if (Intrinsics.areEqual((Object) adVar != null ? adVar.f8046de : null, (Object) "content_offset_top")) {
            qw(adVar);
        } else {
            handleRecognizeSchemeError(adVar);
        }
    }

    public final void qw(ad adVar) {
        Object obj;
        Integer num;
        LoggerKt.d$default("setBarColorAndGetHeight " + adVar, (Object) null, 1, (Object) null);
        if (adVar != null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m1155constructorimpl((qw) new Gson().fromJson(adVar.f8047fe, qw.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m1161isFailureimpl(obj)) {
                obj = null;
            }
            qw qwVar = (qw) obj;
            int i2 = 0;
            if (qwVar == null) {
                handleHybridCallback(adVar, 0, "params error", new JSONObject());
                return;
            }
            IWebView iWebView = this.qw;
            if (iWebView != null) {
                Integer qw2 = qwVar.qw();
                num = Integer.valueOf(iWebView.setBarColorAndGetHeight(qw2 != null ? qw2.intValue() : 0));
            } else {
                num = null;
            }
            LoggerKt.d$default("setBarColorAndGetHeight barHeight:" + num, (Object) null, 1, (Object) null);
            JSONObject jSONObject = new JSONObject();
            if (num != null) {
                i2 = num.intValue();
            }
            jSONObject.put("content_offset_top", i2);
            Unit unit = Unit.INSTANCE;
            handleHybridCallback(adVar, 1, SmsLoginView.f.k, jSONObject);
        }
    }
}
