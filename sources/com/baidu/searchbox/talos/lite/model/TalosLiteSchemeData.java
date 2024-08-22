package com.baidu.searchbox.talos.lite.model;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/talos/lite/model/TalosLiteSchemeData;", "", "paramsJsonStr", "", "(Ljava/lang/String;)V", "alert", "Lcom/baidu/searchbox/talos/lite/model/TalosLiteSchemeData$AlertConfig;", "getAlert", "()Lcom/baidu/searchbox/talos/lite/model/TalosLiteSchemeData$AlertConfig;", "setAlert", "(Lcom/baidu/searchbox/talos/lite/model/TalosLiteSchemeData$AlertConfig;)V", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "AlertConfig", "lib-talos-lite-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosLiteSchemeData.kt */
public final class TalosLiteSchemeData {
    private AlertConfig alert;
    private String url = "";

    public TalosLiteSchemeData(String paramsJsonStr) {
        Intrinsics.checkNotNullParameter(paramsJsonStr, "paramsJsonStr");
        try {
            Result.Companion companion = Result.Companion;
            TalosLiteSchemeData $this$_init__u24lambda_u2d2 = this;
            JSONObject $this$lambda_u2d2_u24lambda_u2d1 = new JSONObject(paramsJsonStr);
            String optString = $this$lambda_u2d2_u24lambda_u2d1.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"url\")");
            $this$_init__u24lambda_u2d2.url = optString;
            AlertConfig alertConfig = new AlertConfig();
            JSONObject $this$lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = $this$lambda_u2d2_u24lambda_u2d1.optJSONObject("alert");
            if ($this$lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 != null) {
                Intrinsics.checkNotNullExpressionValue($this$lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0, "optJSONObject(\"alert\")");
                alertConfig.setLeftMargin($this$lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.optInt("leftMargin"));
                alertConfig.setRightMargin($this$lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.optInt("rightMargin", alertConfig.getLeftMargin()));
                alertConfig.setTopMargin($this$lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.optInt("topMargin", -1));
                alertConfig.setBottomMargin($this$lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.optInt("bottomMargin", -1));
                alertConfig.setAnimationType($this$lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.optInt("animationType"));
            }
            $this$_init__u24lambda_u2d2.alert = alertConfig;
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final AlertConfig getAlert() {
        return this.alert;
    }

    public final void setAlert(AlertConfig alertConfig) {
        this.alert = alertConfig;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/talos/lite/model/TalosLiteSchemeData$AlertConfig;", "", "()V", "animationType", "", "getAnimationType", "()I", "setAnimationType", "(I)V", "bottomMargin", "getBottomMargin", "setBottomMargin", "leftMargin", "getLeftMargin", "setLeftMargin", "rightMargin", "getRightMargin", "setRightMargin", "topMargin", "getTopMargin", "setTopMargin", "lib-talos-lite-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TalosLiteSchemeData.kt */
    public static final class AlertConfig {
        private int animationType;
        private int bottomMargin = -1;
        private int leftMargin;
        private int rightMargin;
        private int topMargin = -1;

        public final int getLeftMargin() {
            return this.leftMargin;
        }

        public final void setLeftMargin(int i2) {
            this.leftMargin = i2;
        }

        public final int getBottomMargin() {
            return this.bottomMargin;
        }

        public final void setBottomMargin(int i2) {
            this.bottomMargin = i2;
        }

        public final int getTopMargin() {
            return this.topMargin;
        }

        public final void setTopMargin(int i2) {
            this.topMargin = i2;
        }

        public final int getRightMargin() {
            return this.rightMargin;
        }

        public final void setRightMargin(int i2) {
            this.rightMargin = i2;
        }

        public final int getAnimationType() {
            return this.animationType;
        }

        public final void setAnimationType(int i2) {
            this.animationType = i2;
        }
    }
}
