package com.baidu.searchbox.flowvideo.flow.api;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/flowvideo/flow/api/ShowLessGuideBean;", "Lcom/baidu/searchbox/NoProGuard;", "isShowLessUser", "", "isShowGuide", "(Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowListBean.kt */
public final class ShowLessGuideBean implements NoProGuard {
    @SerializedName("is_show")
    private final String isShowGuide;
    @SerializedName("is_yindao_dibar")
    private final String isShowLessUser;

    public ShowLessGuideBean() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShowLessGuideBean copy$default(ShowLessGuideBean showLessGuideBean, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = showLessGuideBean.isShowLessUser;
        }
        if ((i2 & 2) != 0) {
            str2 = showLessGuideBean.isShowGuide;
        }
        return showLessGuideBean.copy(str, str2);
    }

    public final String component1() {
        return this.isShowLessUser;
    }

    public final String component2() {
        return this.isShowGuide;
    }

    public final ShowLessGuideBean copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "isShowLessUser");
        Intrinsics.checkNotNullParameter(str2, "isShowGuide");
        return new ShowLessGuideBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowLessGuideBean)) {
            return false;
        }
        ShowLessGuideBean showLessGuideBean = (ShowLessGuideBean) obj;
        return Intrinsics.areEqual((Object) this.isShowLessUser, (Object) showLessGuideBean.isShowLessUser) && Intrinsics.areEqual((Object) this.isShowGuide, (Object) showLessGuideBean.isShowGuide);
    }

    public int hashCode() {
        return (this.isShowLessUser.hashCode() * 31) + this.isShowGuide.hashCode();
    }

    public String toString() {
        return "ShowLessGuideBean(isShowLessUser=" + this.isShowLessUser + ", isShowGuide=" + this.isShowGuide + ')';
    }

    public ShowLessGuideBean(String isShowLessUser2, String isShowGuide2) {
        Intrinsics.checkNotNullParameter(isShowLessUser2, "isShowLessUser");
        Intrinsics.checkNotNullParameter(isShowGuide2, "isShowGuide");
        this.isShowLessUser = isShowLessUser2;
        this.isShowGuide = isShowGuide2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShowLessGuideBean(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String isShowLessUser() {
        return this.isShowLessUser;
    }

    public final String isShowGuide() {
        return this.isShowGuide;
    }
}
