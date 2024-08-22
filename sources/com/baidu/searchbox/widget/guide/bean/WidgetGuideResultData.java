package com.baidu.searchbox.widget.guide.bean;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.widget.net.WidgetNetConstatsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/widget/guide/bean/WidgetGuideResultData;", "", "()V", "data", "Lcom/baidu/searchbox/widget/guide/bean/WidgetGuideResultData$Data;", "getData", "()Lcom/baidu/searchbox/widget/guide/bean/WidgetGuideResultData$Data;", "setData", "(Lcom/baidu/searchbox/widget/guide/bean/WidgetGuideResultData$Data;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "version", "", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "parseFromJson", "", "json", "Data", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetGuideResultData.kt */
public final class WidgetGuideResultData {
    private Data data;
    private int resultCode = -1;
    private String version = "";

    public final int getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(int i2) {
        this.resultCode = i2;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/widget/guide/bean/WidgetGuideResultData$Data;", "", "()V", "isShow", "", "()Ljava/lang/String;", "setShow", "(Ljava/lang/String;)V", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WidgetGuideResultData.kt */
    public static final class Data {
        private String isShow = "";

        public final String isShow() {
            return this.isShow;
        }

        public final void setShow(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.isShow = str;
        }
    }

    public final void parseFromJson(String json) {
        JSONObject optJSONObject;
        CharSequence charSequence = json;
        if (!(charSequence == null || charSequence.length() == 0)) {
            try {
                JSONObject resultJO = new JSONObject(json);
                int optInt = resultJO.optInt("errno", -1);
                this.resultCode = optInt;
                if (optInt == 0) {
                    JSONObject optJSONObject2 = resultJO.optJSONObject("data");
                    JSONObject widgetJO = (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(WidgetNetConstatsKt.KEY_RESPONSE_3014)) == null) ? null : optJSONObject.optJSONObject("icon_widget");
                    if (widgetJO != null) {
                        String optString = widgetJO.optString("version");
                        Intrinsics.checkNotNullExpressionValue(optString, "widgetJO.optString(VERSION)");
                        this.version = optString;
                        JSONObject dataJO = widgetJO.optJSONObject("data");
                        if (dataJO != null) {
                            Data $this$parseFromJson_u24lambda_u2d0 = new Data();
                            String optString2 = dataJO.optString("is_show");
                            Intrinsics.checkNotNullExpressionValue(optString2, "dataJO.optString(IS_SHOW)");
                            $this$parseFromJson_u24lambda_u2d0.setShow(optString2);
                            this.data = $this$parseFromJson_u24lambda_u2d0;
                        }
                    }
                }
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
