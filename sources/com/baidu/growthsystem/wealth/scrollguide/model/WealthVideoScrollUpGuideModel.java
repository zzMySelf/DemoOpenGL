package com.baidu.growthsystem.wealth.scrollguide.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/growthsystem/wealth/scrollguide/model/WealthVideoScrollUpGuideModel;", "", "firstLineText", "", "secondLineText", "secondLineIconUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirstLineText", "()Ljava/lang/String;", "getSecondLineIconUrl", "getSecondLineText", "checkIntegrity", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoScrollUpGuideModel.kt */
public final class WealthVideoScrollUpGuideModel {
    private final String firstLineText;
    private final String secondLineIconUrl;
    private final String secondLineText;

    public static /* synthetic */ WealthVideoScrollUpGuideModel copy$default(WealthVideoScrollUpGuideModel wealthVideoScrollUpGuideModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = wealthVideoScrollUpGuideModel.firstLineText;
        }
        if ((i2 & 2) != 0) {
            str2 = wealthVideoScrollUpGuideModel.secondLineText;
        }
        if ((i2 & 4) != 0) {
            str3 = wealthVideoScrollUpGuideModel.secondLineIconUrl;
        }
        return wealthVideoScrollUpGuideModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.firstLineText;
    }

    public final String component2() {
        return this.secondLineText;
    }

    public final String component3() {
        return this.secondLineIconUrl;
    }

    public final WealthVideoScrollUpGuideModel copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "firstLineText");
        Intrinsics.checkNotNullParameter(str2, "secondLineText");
        Intrinsics.checkNotNullParameter(str3, "secondLineIconUrl");
        return new WealthVideoScrollUpGuideModel(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WealthVideoScrollUpGuideModel)) {
            return false;
        }
        WealthVideoScrollUpGuideModel wealthVideoScrollUpGuideModel = (WealthVideoScrollUpGuideModel) obj;
        return Intrinsics.areEqual((Object) this.firstLineText, (Object) wealthVideoScrollUpGuideModel.firstLineText) && Intrinsics.areEqual((Object) this.secondLineText, (Object) wealthVideoScrollUpGuideModel.secondLineText) && Intrinsics.areEqual((Object) this.secondLineIconUrl, (Object) wealthVideoScrollUpGuideModel.secondLineIconUrl);
    }

    public int hashCode() {
        return (((this.firstLineText.hashCode() * 31) + this.secondLineText.hashCode()) * 31) + this.secondLineIconUrl.hashCode();
    }

    public String toString() {
        return "WealthVideoScrollUpGuideModel(firstLineText=" + this.firstLineText + ", secondLineText=" + this.secondLineText + ", secondLineIconUrl=" + this.secondLineIconUrl + ')';
    }

    public WealthVideoScrollUpGuideModel(String firstLineText2, String secondLineText2, String secondLineIconUrl2) {
        Intrinsics.checkNotNullParameter(firstLineText2, "firstLineText");
        Intrinsics.checkNotNullParameter(secondLineText2, "secondLineText");
        Intrinsics.checkNotNullParameter(secondLineIconUrl2, "secondLineIconUrl");
        this.firstLineText = firstLineText2;
        this.secondLineText = secondLineText2;
        this.secondLineIconUrl = secondLineIconUrl2;
    }

    public final String getFirstLineText() {
        return this.firstLineText;
    }

    public final String getSecondLineText() {
        return this.secondLineText;
    }

    public final String getSecondLineIconUrl() {
        return this.secondLineIconUrl;
    }

    public final boolean checkIntegrity() {
        String[] strArr = {this.firstLineText, this.secondLineText, this.secondLineIconUrl};
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!(strArr[i2].length() > 0)) {
                return false;
            }
        }
        return true;
    }
}
