package com.baidu.searchbox.ad.lp.reward.data;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0006\u0010 \u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/ad/lp/reward/data/WatchAgainData;", "", "againDuration", "", "delayDuration", "againRewardTips", "", "againRewardCmd", "welfareText", "welfareTextColor", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgainDuration", "()I", "getAgainRewardCmd", "()Ljava/lang/String;", "getAgainRewardTips", "setAgainRewardTips", "(Ljava/lang/String;)V", "getDelayDuration", "getWelfareText", "getWelfareTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "isAgainTaskAvailable", "tipsFormat", "", "coin", "toString", "Companion", "lib-ad-lp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WatchAgainData.kt */
public final class WatchAgainData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int againDuration;
    private final String againRewardCmd;
    private String againRewardTips;
    private final int delayDuration;
    private final String welfareText;
    private final String welfareTextColor;

    public static /* synthetic */ WatchAgainData copy$default(WatchAgainData watchAgainData, int i2, int i3, String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = watchAgainData.againDuration;
        }
        if ((i4 & 2) != 0) {
            i3 = watchAgainData.delayDuration;
        }
        int i5 = i3;
        if ((i4 & 4) != 0) {
            str = watchAgainData.againRewardTips;
        }
        String str5 = str;
        if ((i4 & 8) != 0) {
            str2 = watchAgainData.againRewardCmd;
        }
        String str6 = str2;
        if ((i4 & 16) != 0) {
            str3 = watchAgainData.welfareText;
        }
        String str7 = str3;
        if ((i4 & 32) != 0) {
            str4 = watchAgainData.welfareTextColor;
        }
        return watchAgainData.copy(i2, i5, str5, str6, str7, str4);
    }

    @JvmStatic
    public static final WatchAgainData fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final int component1() {
        return this.againDuration;
    }

    public final int component2() {
        return this.delayDuration;
    }

    public final String component3() {
        return this.againRewardTips;
    }

    public final String component4() {
        return this.againRewardCmd;
    }

    public final String component5() {
        return this.welfareText;
    }

    public final String component6() {
        return this.welfareTextColor;
    }

    public final WatchAgainData copy(int i2, int i3, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "againRewardTips");
        Intrinsics.checkNotNullParameter(str2, "againRewardCmd");
        Intrinsics.checkNotNullParameter(str3, "welfareText");
        Intrinsics.checkNotNullParameter(str4, "welfareTextColor");
        return new WatchAgainData(i2, i3, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchAgainData)) {
            return false;
        }
        WatchAgainData watchAgainData = (WatchAgainData) obj;
        return this.againDuration == watchAgainData.againDuration && this.delayDuration == watchAgainData.delayDuration && Intrinsics.areEqual((Object) this.againRewardTips, (Object) watchAgainData.againRewardTips) && Intrinsics.areEqual((Object) this.againRewardCmd, (Object) watchAgainData.againRewardCmd) && Intrinsics.areEqual((Object) this.welfareText, (Object) watchAgainData.welfareText) && Intrinsics.areEqual((Object) this.welfareTextColor, (Object) watchAgainData.welfareTextColor);
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.againDuration) * 31) + Integer.hashCode(this.delayDuration)) * 31) + this.againRewardTips.hashCode()) * 31) + this.againRewardCmd.hashCode()) * 31) + this.welfareText.hashCode()) * 31) + this.welfareTextColor.hashCode();
    }

    public String toString() {
        return "WatchAgainData(againDuration=" + this.againDuration + ", delayDuration=" + this.delayDuration + ", againRewardTips=" + this.againRewardTips + ", againRewardCmd=" + this.againRewardCmd + ", welfareText=" + this.welfareText + ", welfareTextColor=" + this.welfareTextColor + ')';
    }

    public WatchAgainData(int againDuration2, int delayDuration2, String againRewardTips2, String againRewardCmd2, String welfareText2, String welfareTextColor2) {
        Intrinsics.checkNotNullParameter(againRewardTips2, "againRewardTips");
        Intrinsics.checkNotNullParameter(againRewardCmd2, "againRewardCmd");
        Intrinsics.checkNotNullParameter(welfareText2, "welfareText");
        Intrinsics.checkNotNullParameter(welfareTextColor2, "welfareTextColor");
        this.againDuration = againDuration2;
        this.delayDuration = delayDuration2;
        this.againRewardTips = againRewardTips2;
        this.againRewardCmd = againRewardCmd2;
        this.welfareText = welfareText2;
        this.welfareTextColor = welfareTextColor2;
    }

    public final int getAgainDuration() {
        return this.againDuration;
    }

    public final int getDelayDuration() {
        return this.delayDuration;
    }

    public final String getAgainRewardTips() {
        return this.againRewardTips;
    }

    public final void setAgainRewardTips(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.againRewardTips = str;
    }

    public final String getAgainRewardCmd() {
        return this.againRewardCmd;
    }

    public final String getWelfareText() {
        return this.welfareText;
    }

    public final String getWelfareTextColor() {
        return this.welfareTextColor;
    }

    public final boolean isAgainTaskAvailable() {
        if (this.againDuration > 0 && this.delayDuration > 0) {
            if (this.againRewardCmd.length() > 0) {
                if (this.againRewardTips.length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void tipsFormat(String coin) {
        Intrinsics.checkNotNullParameter(coin, "coin");
        this.againRewardTips = StringsKt.replace$default(this.againRewardTips, "__REWARD__", coin, false, 4, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/ad/lp/reward/data/WatchAgainData$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/ad/lp/reward/data/WatchAgainData;", "jsonObject", "Lorg/json/JSONObject;", "lib-ad-lp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WatchAgainData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WatchAgainData fromJson(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            JSONObject $this$fromJson_u24lambda_u2d0 = jsonObject;
            int optInt = $this$fromJson_u24lambda_u2d0.optInt("again_duration");
            int optInt2 = $this$fromJson_u24lambda_u2d0.optInt("delay_duration");
            String optString = $this$fromJson_u24lambda_u2d0.optString("again_reward_tips");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"again_reward_tips\")");
            String optString2 = $this$fromJson_u24lambda_u2d0.optString("again_reward_cmd");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"again_reward_cmd\")");
            String optString3 = $this$fromJson_u24lambda_u2d0.optString("welfare_text");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"welfare_text\")");
            String optString4 = $this$fromJson_u24lambda_u2d0.optString("welfare_text_color");
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"welfare_text_color\")");
            return new WatchAgainData(optInt, optInt2, optString, optString2, optString3, optString4);
        }
    }
}
