package com.baidu.searchbox.video.detail.core.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/detail/core/model/SchemeVideoSummaryModel;", "", "()V", "show", "", "getShow", "()I", "setShow", "(I)V", "Companion", "lib-support_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchemeVideoSummaryModel.kt */
public final class SchemeVideoSummaryModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int show;

    @JvmStatic
    public static final SchemeVideoSummaryModel parseData(String str) {
        return Companion.parseData(str);
    }

    public final int getShow() {
        return this.show;
    }

    public final void setShow(int i2) {
        this.show = i2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/detail/core/model/SchemeVideoSummaryModel$Companion;", "", "()V", "parseData", "Lcom/baidu/searchbox/video/detail/core/model/SchemeVideoSummaryModel;", "summaryInfo", "", "lib-support_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchemeVideoSummaryModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SchemeVideoSummaryModel parseData(String summaryInfo) {
            CharSequence charSequence = summaryInfo;
            if (charSequence == null || charSequence.length() == 0) {
                SchemeVideoSummaryModel schemeVideoSummaryModel = null;
                return null;
            }
            try {
                SchemeVideoSummaryModel $this$parseData_u24lambda_u2d0 = new SchemeVideoSummaryModel();
                $this$parseData_u24lambda_u2d0.setShow(new JSONObject(summaryInfo).optInt("show"));
                return $this$parseData_u24lambda_u2d0;
            } catch (JSONException e2) {
                SchemeVideoSummaryModel schemeVideoSummaryModel2 = null;
                return null;
            }
        }
    }
}
