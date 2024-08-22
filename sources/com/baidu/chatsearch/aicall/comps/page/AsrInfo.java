package com.baidu.chatsearch.aicall.comps.page;

import com.baidu.chatsearch.aicall.scheme.SchemeExtKt;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.nacomp.extension.util.JSONExtKt;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/page/AsrInfo;", "Ljava/io/Serializable;", "Lcom/baidu/searchbox/NoProGuard;", "pid", "", "key", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getPid", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AICallPageParams.kt */
public final class AsrInfo implements Serializable, NoProGuard {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("key")
    private final String key;
    @SerializedName("pid")
    private final String pid;
    @SerializedName("url")
    private final String url;

    public static /* synthetic */ AsrInfo copy$default(AsrInfo asrInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = asrInfo.pid;
        }
        if ((i2 & 2) != 0) {
            str2 = asrInfo.key;
        }
        if ((i2 & 4) != 0) {
            str3 = asrInfo.url;
        }
        return asrInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.pid;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.url;
    }

    public final AsrInfo copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "pid");
        Intrinsics.checkNotNullParameter(str2, "key");
        Intrinsics.checkNotNullParameter(str3, "url");
        return new AsrInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrInfo)) {
            return false;
        }
        AsrInfo asrInfo = (AsrInfo) obj;
        return Intrinsics.areEqual((Object) this.pid, (Object) asrInfo.pid) && Intrinsics.areEqual((Object) this.key, (Object) asrInfo.key) && Intrinsics.areEqual((Object) this.url, (Object) asrInfo.url);
    }

    public int hashCode() {
        return (((this.pid.hashCode() * 31) + this.key.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "AsrInfo(pid=" + this.pid + ", key=" + this.key + ", url=" + this.url + ')';
    }

    public AsrInfo(String pid2, String key2, String url2) {
        Intrinsics.checkNotNullParameter(pid2, "pid");
        Intrinsics.checkNotNullParameter(key2, "key");
        Intrinsics.checkNotNullParameter(url2, "url");
        this.pid = pid2;
        this.key = key2;
        this.url = url2;
    }

    public final String getPid() {
        return this.pid;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getUrl() {
        return this.url;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/page/AsrInfo$Companion;", "", "()V", "fromJson", "Lcom/baidu/chatsearch/aicall/comps/page/AsrInfo;", "json", "Lorg/json/JSONObject;", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AICallPageParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AsrInfo fromJson(JSONObject json) {
            if (json == null) {
                return null;
            }
            String pid = JSONExtKt.optStringIgnoreNulls(json, "pid", "");
            boolean z = true;
            if (pid.length() == 0) {
                return null;
            }
            String key = JSONExtKt.optStringIgnoreNulls(json, "key", "");
            if (key.length() != 0) {
                z = false;
            }
            if (z) {
                return null;
            }
            String url = JSONExtKt.optStringIgnoreNulls(json, "url", "");
            if (!SchemeExtKt.validUrlParam(url)) {
                return null;
            }
            return new AsrInfo(pid, key, url);
        }
    }
}
