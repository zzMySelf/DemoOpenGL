package com.baidu.searchbox.flowvideo.shortplayautounlock.api;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/flowvideo/shortplayautounlock/api/ShortPlayAutoUnlockBean;", "Lcom/baidu/searchbox/NoProGuard;", "errno", "", "errmsg", "", "logid", "data", "Lcom/baidu/searchbox/flowvideo/shortplayautounlock/api/ShortPlayAutoUnlockDataBean;", "(ILjava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/shortplayautounlock/api/ShortPlayAutoUnlockDataBean;)V", "getData", "()Lcom/baidu/searchbox/flowvideo/shortplayautounlock/api/ShortPlayAutoUnlockDataBean;", "getErrmsg", "()Ljava/lang/String;", "getErrno", "()I", "getLogid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayAutoUnlockBean.kt */
public final class ShortPlayAutoUnlockBean implements NoProGuard {
    private final ShortPlayAutoUnlockDataBean data;
    private final String errmsg;
    private final int errno;
    @SerializedName("log_id")
    private final String logid;

    public ShortPlayAutoUnlockBean() {
        this(0, (String) null, (String) null, (ShortPlayAutoUnlockDataBean) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShortPlayAutoUnlockBean copy$default(ShortPlayAutoUnlockBean shortPlayAutoUnlockBean, int i2, String str, String str2, ShortPlayAutoUnlockDataBean shortPlayAutoUnlockDataBean, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = shortPlayAutoUnlockBean.errno;
        }
        if ((i3 & 2) != 0) {
            str = shortPlayAutoUnlockBean.errmsg;
        }
        if ((i3 & 4) != 0) {
            str2 = shortPlayAutoUnlockBean.logid;
        }
        if ((i3 & 8) != 0) {
            shortPlayAutoUnlockDataBean = shortPlayAutoUnlockBean.data;
        }
        return shortPlayAutoUnlockBean.copy(i2, str, str2, shortPlayAutoUnlockDataBean);
    }

    public final int component1() {
        return this.errno;
    }

    public final String component2() {
        return this.errmsg;
    }

    public final String component3() {
        return this.logid;
    }

    public final ShortPlayAutoUnlockDataBean component4() {
        return this.data;
    }

    public final ShortPlayAutoUnlockBean copy(int i2, String str, String str2, ShortPlayAutoUnlockDataBean shortPlayAutoUnlockDataBean) {
        Intrinsics.checkNotNullParameter(str, "errmsg");
        Intrinsics.checkNotNullParameter(str2, "logid");
        return new ShortPlayAutoUnlockBean(i2, str, str2, shortPlayAutoUnlockDataBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortPlayAutoUnlockBean)) {
            return false;
        }
        ShortPlayAutoUnlockBean shortPlayAutoUnlockBean = (ShortPlayAutoUnlockBean) obj;
        return this.errno == shortPlayAutoUnlockBean.errno && Intrinsics.areEqual((Object) this.errmsg, (Object) shortPlayAutoUnlockBean.errmsg) && Intrinsics.areEqual((Object) this.logid, (Object) shortPlayAutoUnlockBean.logid) && Intrinsics.areEqual((Object) this.data, (Object) shortPlayAutoUnlockBean.data);
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.errno) * 31) + this.errmsg.hashCode()) * 31) + this.logid.hashCode()) * 31;
        ShortPlayAutoUnlockDataBean shortPlayAutoUnlockDataBean = this.data;
        return hashCode + (shortPlayAutoUnlockDataBean == null ? 0 : shortPlayAutoUnlockDataBean.hashCode());
    }

    public String toString() {
        return "ShortPlayAutoUnlockBean(errno=" + this.errno + ", errmsg=" + this.errmsg + ", logid=" + this.logid + ", data=" + this.data + ')';
    }

    public ShortPlayAutoUnlockBean(int errno2, String errmsg2, String logid2, ShortPlayAutoUnlockDataBean data2) {
        Intrinsics.checkNotNullParameter(errmsg2, "errmsg");
        Intrinsics.checkNotNullParameter(logid2, "logid");
        this.errno = errno2;
        this.errmsg = errmsg2;
        this.logid = logid2;
        this.data = data2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShortPlayAutoUnlockBean(int i2, String str, String str2, ShortPlayAutoUnlockDataBean shortPlayAutoUnlockDataBean, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? null : shortPlayAutoUnlockDataBean);
    }

    public final int getErrno() {
        return this.errno;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final String getLogid() {
        return this.logid;
    }

    public final ShortPlayAutoUnlockDataBean getData() {
        return this.data;
    }
}
