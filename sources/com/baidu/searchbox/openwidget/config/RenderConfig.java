package com.baidu.searchbox.openwidget.config;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/openwidget/config/RenderConfig;", "", "abortOnBdResError", "", "abortOnTpResError", "(ZZ)V", "getAbortOnBdResError", "()Z", "getAbortOnTpResError", "toString", "", "Companion", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderConfig.kt */
public final class RenderConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final RenderConfig DEFAULT = new RenderConfig(true, true);
    private final boolean abortOnBdResError;
    private final boolean abortOnTpResError;

    public RenderConfig(boolean abortOnBdResError2, boolean abortOnTpResError2) {
        this.abortOnBdResError = abortOnBdResError2;
        this.abortOnTpResError = abortOnTpResError2;
    }

    public final boolean getAbortOnBdResError() {
        return this.abortOnBdResError;
    }

    public final boolean getAbortOnTpResError() {
        return this.abortOnTpResError;
    }

    public String toString() {
        return "RenderConfig(abortOnBdResError=" + this.abortOnBdResError + ", abortOnTpResError=" + this.abortOnTpResError + ')';
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\n\u0010\r\u001a\u00020\t*\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/openwidget/config/RenderConfig$Companion;", "", "()V", "DEFAULT", "Lcom/baidu/searchbox/openwidget/config/RenderConfig;", "getDEFAULT", "()Lcom/baidu/searchbox/openwidget/config/RenderConfig;", "fromJson", "json", "Lorg/json/JSONObject;", "fromJsonStr", "jsonString", "", "toJson", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RenderConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RenderConfig getDEFAULT() {
            return RenderConfig.DEFAULT;
        }

        public final RenderConfig fromJsonStr(String jsonString) {
            Object obj;
            if (jsonString == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                obj = Result.m8971constructorimpl(new JSONObject(jsonString));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m8977isFailureimpl(obj)) {
                obj = null;
            }
            JSONObject json = (JSONObject) obj;
            if (json == null) {
                return null;
            }
            return fromJson(json);
        }

        public final RenderConfig fromJson(JSONObject json) {
            if (json == null) {
                return null;
            }
            boolean z = true;
            boolean z2 = json.optInt("abort_bdsubres_err", 1) == 1;
            if (json.optInt("abort_tpsubres_err", 1) != 1) {
                z = false;
            }
            return new RenderConfig(z2, z);
        }

        public final JSONObject toJson(RenderConfig $this$toJson) {
            Intrinsics.checkNotNullParameter($this$toJson, "<this>");
            JSONObject jSONObject = new JSONObject();
            JSONObject $this$toJson_u24lambda_u2d1 = jSONObject;
            $this$toJson_u24lambda_u2d1.put("abort_bdsubres_err", $this$toJson.getAbortOnBdResError() ? 1 : 0);
            $this$toJson_u24lambda_u2d1.put("abort_tpsubres_err", $this$toJson.getAbortOnTpResError() ? 1 : 0);
            return jSONObject;
        }
    }
}
