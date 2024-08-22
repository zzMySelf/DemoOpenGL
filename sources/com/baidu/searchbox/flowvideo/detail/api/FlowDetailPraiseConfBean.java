package com.baidu.searchbox.flowvideo.detail.api;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/api/FlowDetailPraiseConfBean;", "Lcom/baidu/searchbox/NoProGuard;", "iconAnimation", "", "contentAnimation", "iconShape", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContentAnimation", "()Ljava/lang/String;", "setContentAnimation", "(Ljava/lang/String;)V", "getIconAnimation", "setIconAnimation", "getIconShape", "setIconShape", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailBean.kt */
public final class FlowDetailPraiseConfBean implements NoProGuard {
    @SerializedName("content_animation")
    private String contentAnimation;
    @SerializedName("icon_animation")
    private String iconAnimation;
    @SerializedName("icon_shape")
    private String iconShape;

    public FlowDetailPraiseConfBean() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlowDetailPraiseConfBean copy$default(FlowDetailPraiseConfBean flowDetailPraiseConfBean, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = flowDetailPraiseConfBean.iconAnimation;
        }
        if ((i2 & 2) != 0) {
            str2 = flowDetailPraiseConfBean.contentAnimation;
        }
        if ((i2 & 4) != 0) {
            str3 = flowDetailPraiseConfBean.iconShape;
        }
        return flowDetailPraiseConfBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.iconAnimation;
    }

    public final String component2() {
        return this.contentAnimation;
    }

    public final String component3() {
        return this.iconShape;
    }

    public final FlowDetailPraiseConfBean copy(String str, String str2, String str3) {
        return new FlowDetailPraiseConfBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowDetailPraiseConfBean)) {
            return false;
        }
        FlowDetailPraiseConfBean flowDetailPraiseConfBean = (FlowDetailPraiseConfBean) obj;
        return Intrinsics.areEqual((Object) this.iconAnimation, (Object) flowDetailPraiseConfBean.iconAnimation) && Intrinsics.areEqual((Object) this.contentAnimation, (Object) flowDetailPraiseConfBean.contentAnimation) && Intrinsics.areEqual((Object) this.iconShape, (Object) flowDetailPraiseConfBean.iconShape);
    }

    public int hashCode() {
        String str = this.iconAnimation;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.contentAnimation;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconShape;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "FlowDetailPraiseConfBean(iconAnimation=" + this.iconAnimation + ", contentAnimation=" + this.contentAnimation + ", iconShape=" + this.iconShape + ')';
    }

    public FlowDetailPraiseConfBean(String iconAnimation2, String contentAnimation2, String iconShape2) {
        this.iconAnimation = iconAnimation2;
        this.contentAnimation = contentAnimation2;
        this.iconShape = iconShape2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowDetailPraiseConfBean(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getIconAnimation() {
        return this.iconAnimation;
    }

    public final void setIconAnimation(String str) {
        this.iconAnimation = str;
    }

    public final String getContentAnimation() {
        return this.contentAnimation;
    }

    public final void setContentAnimation(String str) {
        this.contentAnimation = str;
    }

    public final String getIconShape() {
        return this.iconShape;
    }

    public final void setIconShape(String str) {
        this.iconShape = str;
    }
}
