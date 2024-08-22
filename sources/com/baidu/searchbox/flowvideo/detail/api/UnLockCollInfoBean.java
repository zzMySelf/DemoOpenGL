package com.baidu.searchbox.flowvideo.detail.api;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/api/UnLockCollInfoBean;", "Lcom/baidu/searchbox/NoProGuard;", "playLetUnids", "", "unLockText", "autoUnLockText", "countdownTime", "unLockCollSwitch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAutoUnLockText", "()Ljava/lang/String;", "getCountdownTime", "getPlayLetUnids", "getUnLockCollSwitch", "getUnLockText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailBean.kt */
public final class UnLockCollInfoBean implements NoProGuard {
    private final String autoUnLockText;
    private final String countdownTime;
    private final String playLetUnids;
    private final String unLockCollSwitch;
    private final String unLockText;

    public UnLockCollInfoBean() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UnLockCollInfoBean copy$default(UnLockCollInfoBean unLockCollInfoBean, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = unLockCollInfoBean.playLetUnids;
        }
        if ((i2 & 2) != 0) {
            str2 = unLockCollInfoBean.unLockText;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = unLockCollInfoBean.autoUnLockText;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = unLockCollInfoBean.countdownTime;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = unLockCollInfoBean.unLockCollSwitch;
        }
        return unLockCollInfoBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.playLetUnids;
    }

    public final String component2() {
        return this.unLockText;
    }

    public final String component3() {
        return this.autoUnLockText;
    }

    public final String component4() {
        return this.countdownTime;
    }

    public final String component5() {
        return this.unLockCollSwitch;
    }

    public final UnLockCollInfoBean copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "playLetUnids");
        Intrinsics.checkNotNullParameter(str2, "unLockText");
        Intrinsics.checkNotNullParameter(str3, "autoUnLockText");
        Intrinsics.checkNotNullParameter(str4, "countdownTime");
        Intrinsics.checkNotNullParameter(str5, "unLockCollSwitch");
        return new UnLockCollInfoBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnLockCollInfoBean)) {
            return false;
        }
        UnLockCollInfoBean unLockCollInfoBean = (UnLockCollInfoBean) obj;
        return Intrinsics.areEqual((Object) this.playLetUnids, (Object) unLockCollInfoBean.playLetUnids) && Intrinsics.areEqual((Object) this.unLockText, (Object) unLockCollInfoBean.unLockText) && Intrinsics.areEqual((Object) this.autoUnLockText, (Object) unLockCollInfoBean.autoUnLockText) && Intrinsics.areEqual((Object) this.countdownTime, (Object) unLockCollInfoBean.countdownTime) && Intrinsics.areEqual((Object) this.unLockCollSwitch, (Object) unLockCollInfoBean.unLockCollSwitch);
    }

    public int hashCode() {
        return (((((((this.playLetUnids.hashCode() * 31) + this.unLockText.hashCode()) * 31) + this.autoUnLockText.hashCode()) * 31) + this.countdownTime.hashCode()) * 31) + this.unLockCollSwitch.hashCode();
    }

    public String toString() {
        return "UnLockCollInfoBean(playLetUnids=" + this.playLetUnids + ", unLockText=" + this.unLockText + ", autoUnLockText=" + this.autoUnLockText + ", countdownTime=" + this.countdownTime + ", unLockCollSwitch=" + this.unLockCollSwitch + ')';
    }

    public UnLockCollInfoBean(String playLetUnids2, String unLockText2, String autoUnLockText2, String countdownTime2, String unLockCollSwitch2) {
        Intrinsics.checkNotNullParameter(playLetUnids2, "playLetUnids");
        Intrinsics.checkNotNullParameter(unLockText2, "unLockText");
        Intrinsics.checkNotNullParameter(autoUnLockText2, "autoUnLockText");
        Intrinsics.checkNotNullParameter(countdownTime2, "countdownTime");
        Intrinsics.checkNotNullParameter(unLockCollSwitch2, "unLockCollSwitch");
        this.playLetUnids = playLetUnids2;
        this.unLockText = unLockText2;
        this.autoUnLockText = autoUnLockText2;
        this.countdownTime = countdownTime2;
        this.unLockCollSwitch = unLockCollSwitch2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnLockCollInfoBean(String str, String str2, String str3, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5);
    }

    public final String getPlayLetUnids() {
        return this.playLetUnids;
    }

    public final String getUnLockText() {
        return this.unLockText;
    }

    public final String getAutoUnLockText() {
        return this.autoUnLockText;
    }

    public final String getCountdownTime() {
        return this.countdownTime;
    }

    public final String getUnLockCollSwitch() {
        return this.unLockCollSwitch;
    }
}
