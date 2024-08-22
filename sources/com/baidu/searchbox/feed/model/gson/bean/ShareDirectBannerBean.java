package com.baidu.searchbox.feed.model.gson.bean;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/feed/model/gson/bean/ShareDirectBannerBean;", "Lcom/baidu/searchbox/NoProGuard;", "channel", "", "(Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareDirectBannerBean.kt */
public final class ShareDirectBannerBean implements NoProGuard {
    private final String channel;

    public ShareDirectBannerBean() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShareDirectBannerBean copy$default(ShareDirectBannerBean shareDirectBannerBean, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = shareDirectBannerBean.channel;
        }
        return shareDirectBannerBean.copy(str);
    }

    public final String component1() {
        return this.channel;
    }

    public final ShareDirectBannerBean copy(String str) {
        Intrinsics.checkNotNullParameter(str, "channel");
        return new ShareDirectBannerBean(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShareDirectBannerBean) && Intrinsics.areEqual((Object) this.channel, (Object) ((ShareDirectBannerBean) obj).channel);
    }

    public int hashCode() {
        return this.channel.hashCode();
    }

    public String toString() {
        return "ShareDirectBannerBean(channel=" + this.channel + ')';
    }

    public ShareDirectBannerBean(String channel2) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.channel = channel2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareDirectBannerBean(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str);
    }

    public final String getChannel() {
        return this.channel;
    }
}
