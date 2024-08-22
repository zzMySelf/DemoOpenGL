package com.baidu.searchbox.flowvideo.hot.api;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/flowvideo/hot/api/CommonListPanelPoliciesBean;", "Lcom/baidu/searchbox/NoProGuard;", "rotationInterval", "", "panelAutoPreloadUp", "panelAutoPreloadDown", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPanelAutoPreloadDown", "()Ljava/lang/String;", "getPanelAutoPreloadUp", "getRotationInterval", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonListPanelBean.kt */
public final class CommonListPanelPoliciesBean implements NoProGuard {
    @SerializedName("panel_auto_preload_down")
    private final String panelAutoPreloadDown;
    @SerializedName("panel_auto_preload_up")
    private final String panelAutoPreloadUp;
    private final String rotationInterval;

    public CommonListPanelPoliciesBean() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommonListPanelPoliciesBean copy$default(CommonListPanelPoliciesBean commonListPanelPoliciesBean, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commonListPanelPoliciesBean.rotationInterval;
        }
        if ((i2 & 2) != 0) {
            str2 = commonListPanelPoliciesBean.panelAutoPreloadUp;
        }
        if ((i2 & 4) != 0) {
            str3 = commonListPanelPoliciesBean.panelAutoPreloadDown;
        }
        return commonListPanelPoliciesBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.rotationInterval;
    }

    public final String component2() {
        return this.panelAutoPreloadUp;
    }

    public final String component3() {
        return this.panelAutoPreloadDown;
    }

    public final CommonListPanelPoliciesBean copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "rotationInterval");
        Intrinsics.checkNotNullParameter(str2, "panelAutoPreloadUp");
        Intrinsics.checkNotNullParameter(str3, "panelAutoPreloadDown");
        return new CommonListPanelPoliciesBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonListPanelPoliciesBean)) {
            return false;
        }
        CommonListPanelPoliciesBean commonListPanelPoliciesBean = (CommonListPanelPoliciesBean) obj;
        return Intrinsics.areEqual((Object) this.rotationInterval, (Object) commonListPanelPoliciesBean.rotationInterval) && Intrinsics.areEqual((Object) this.panelAutoPreloadUp, (Object) commonListPanelPoliciesBean.panelAutoPreloadUp) && Intrinsics.areEqual((Object) this.panelAutoPreloadDown, (Object) commonListPanelPoliciesBean.panelAutoPreloadDown);
    }

    public int hashCode() {
        return (((this.rotationInterval.hashCode() * 31) + this.panelAutoPreloadUp.hashCode()) * 31) + this.panelAutoPreloadDown.hashCode();
    }

    public String toString() {
        return "CommonListPanelPoliciesBean(rotationInterval=" + this.rotationInterval + ", panelAutoPreloadUp=" + this.panelAutoPreloadUp + ", panelAutoPreloadDown=" + this.panelAutoPreloadDown + ')';
    }

    public CommonListPanelPoliciesBean(String rotationInterval2, String panelAutoPreloadUp2, String panelAutoPreloadDown2) {
        Intrinsics.checkNotNullParameter(rotationInterval2, "rotationInterval");
        Intrinsics.checkNotNullParameter(panelAutoPreloadUp2, "panelAutoPreloadUp");
        Intrinsics.checkNotNullParameter(panelAutoPreloadDown2, "panelAutoPreloadDown");
        this.rotationInterval = rotationInterval2;
        this.panelAutoPreloadUp = panelAutoPreloadUp2;
        this.panelAutoPreloadDown = panelAutoPreloadDown2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonListPanelPoliciesBean(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getRotationInterval() {
        return this.rotationInterval;
    }

    public final String getPanelAutoPreloadUp() {
        return this.panelAutoPreloadUp;
    }

    public final String getPanelAutoPreloadDown() {
        return this.panelAutoPreloadDown;
    }
}
