package com.baidu.nadcore.model;

import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideActionManifestKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J;\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/nadcore/model/ExtPolicy;", "", "invokeTaskId", "", "backCmd", "sdkSwitch", "defaultLimit", "completeInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackCmd", "()Ljava/lang/String;", "getCompleteInfo", "getDefaultLimit", "getInvokeTaskId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewardData.kt */
public final class ExtPolicy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String backCmd;
    private final String completeInfo;
    private final String defaultLimit;
    private final String invokeTaskId;
    public String sdkSwitch;

    public static /* synthetic */ ExtPolicy copy$default(ExtPolicy extPolicy, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = extPolicy.invokeTaskId;
        }
        if ((i2 & 2) != 0) {
            str2 = extPolicy.backCmd;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = extPolicy.sdkSwitch;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = extPolicy.defaultLimit;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = extPolicy.completeInfo;
        }
        return extPolicy.copy(str, str6, str7, str8, str5);
    }

    @JvmStatic
    public static final ExtPolicy fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    @JvmStatic
    public static final ExtPolicy newInstance() {
        return Companion.newInstance();
    }

    @JvmStatic
    public static final JSONObject toJson(ExtPolicy extPolicy) {
        return Companion.toJson(extPolicy);
    }

    public final String component1() {
        return this.invokeTaskId;
    }

    public final String component2() {
        return this.backCmd;
    }

    public final String component3() {
        return this.sdkSwitch;
    }

    public final String component4() {
        return this.defaultLimit;
    }

    public final String component5() {
        return this.completeInfo;
    }

    public final ExtPolicy copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "invokeTaskId");
        Intrinsics.checkNotNullParameter(str2, "backCmd");
        Intrinsics.checkNotNullParameter(str3, "sdkSwitch");
        Intrinsics.checkNotNullParameter(str4, "defaultLimit");
        Intrinsics.checkNotNullParameter(str5, ShortPlayPaymentGuideActionManifestKt.EVENT_BUS_AD_COMPLETE_DATA);
        return new ExtPolicy(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtPolicy)) {
            return false;
        }
        ExtPolicy extPolicy = (ExtPolicy) obj;
        return Intrinsics.areEqual((Object) this.invokeTaskId, (Object) extPolicy.invokeTaskId) && Intrinsics.areEqual((Object) this.backCmd, (Object) extPolicy.backCmd) && Intrinsics.areEqual((Object) this.sdkSwitch, (Object) extPolicy.sdkSwitch) && Intrinsics.areEqual((Object) this.defaultLimit, (Object) extPolicy.defaultLimit) && Intrinsics.areEqual((Object) this.completeInfo, (Object) extPolicy.completeInfo);
    }

    public int hashCode() {
        return (((((((this.invokeTaskId.hashCode() * 31) + this.backCmd.hashCode()) * 31) + this.sdkSwitch.hashCode()) * 31) + this.defaultLimit.hashCode()) * 31) + this.completeInfo.hashCode();
    }

    public String toString() {
        return "ExtPolicy(invokeTaskId=" + this.invokeTaskId + ", backCmd=" + this.backCmd + ", sdkSwitch=" + this.sdkSwitch + ", defaultLimit=" + this.defaultLimit + ", completeInfo=" + this.completeInfo + ')';
    }

    public ExtPolicy(String invokeTaskId2, String backCmd2, String sdkSwitch2, String defaultLimit2, String completeInfo2) {
        Intrinsics.checkNotNullParameter(invokeTaskId2, "invokeTaskId");
        Intrinsics.checkNotNullParameter(backCmd2, "backCmd");
        Intrinsics.checkNotNullParameter(sdkSwitch2, "sdkSwitch");
        Intrinsics.checkNotNullParameter(defaultLimit2, "defaultLimit");
        Intrinsics.checkNotNullParameter(completeInfo2, ShortPlayPaymentGuideActionManifestKt.EVENT_BUS_AD_COMPLETE_DATA);
        this.invokeTaskId = invokeTaskId2;
        this.backCmd = backCmd2;
        this.sdkSwitch = sdkSwitch2;
        this.defaultLimit = defaultLimit2;
        this.completeInfo = completeInfo2;
    }

    public final String getInvokeTaskId() {
        return this.invokeTaskId;
    }

    public final String getBackCmd() {
        return this.backCmd;
    }

    public final String getDefaultLimit() {
        return this.defaultLimit;
    }

    public final String getCompleteInfo() {
        return this.completeInfo;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/baidu/nadcore/model/ExtPolicy$Companion;", "", "()V", "fromJson", "Lcom/baidu/nadcore/model/ExtPolicy;", "jsonObject", "Lorg/json/JSONObject;", "newInstance", "toJson", "extPolicy", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RewardData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExtPolicy newInstance() {
            return new ExtPolicy("", "", "0", "1", "");
        }

        @JvmStatic
        public final ExtPolicy fromJson(JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            JSONObject $this$fromJson_u24lambda_u2d0 = jsonObject;
            String optString = $this$fromJson_u24lambda_u2d0.optString("invoke_task_id");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"invoke_task_id\")");
            String optString2 = $this$fromJson_u24lambda_u2d0.optString("back_cmd");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"back_cmd\")");
            String optString3 = $this$fromJson_u24lambda_u2d0.optString("sdk_switch", "0");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"sdk_switch\", \"0\")");
            String optString4 = $this$fromJson_u24lambda_u2d0.optString("default_upper_limit", "1");
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"default_upper_limit\", \"1\")");
            String optString5 = $this$fromJson_u24lambda_u2d0.optString("complete_info");
            Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"complete_info\")");
            return new ExtPolicy(optString, optString2, optString3, optString4, optString5);
        }

        @JvmStatic
        public final JSONObject toJson(ExtPolicy extPolicy) {
            String str;
            JSONObject extPolicyJson = new JSONObject();
            String str2 = null;
            if (extPolicy != null) {
                try {
                    str = extPolicy.getInvokeTaskId();
                } catch (JSONException e2) {
                }
            } else {
                str = null;
            }
            JSONObject put = extPolicyJson.put("invoke_task_id", str).put("back_cmd", extPolicy != null ? extPolicy.getBackCmd() : null).put("sdk_switch", extPolicy != null ? extPolicy.sdkSwitch : null);
            if (extPolicy != null) {
                str2 = extPolicy.getCompleteInfo();
            }
            put.put("complete_info", str2);
            return extPolicyJson;
        }
    }
}
