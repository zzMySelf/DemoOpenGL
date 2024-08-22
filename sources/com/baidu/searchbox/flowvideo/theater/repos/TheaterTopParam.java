package com.baidu.searchbox.flowvideo.theater.repos;

import com.baidu.searchbox.feed.detail.ext.common.RequestParam;
import com.baidu.searchbox.rewardsystem.newtimer.net.TimerStatusInfoRequester;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/flowvideo/theater/repos/TheaterTopParam;", "Lcom/baidu/searchbox/feed/detail/ext/common/RequestParam;", "pd", "", "from", "page", "requestFrom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getPage", "setPage", "getPd", "getRequestFrom", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TheaterTopParam.kt */
public final class TheaterTopParam extends RequestParam {
    private String from;
    private String page;
    private final String pd;
    private final String requestFrom;

    public static /* synthetic */ TheaterTopParam copy$default(TheaterTopParam theaterTopParam, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = theaterTopParam.pd;
        }
        if ((i2 & 2) != 0) {
            str2 = theaterTopParam.from;
        }
        if ((i2 & 4) != 0) {
            str3 = theaterTopParam.page;
        }
        if ((i2 & 8) != 0) {
            str4 = theaterTopParam.requestFrom;
        }
        return theaterTopParam.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.pd;
    }

    public final String component2() {
        return this.from;
    }

    public final String component3() {
        return this.page;
    }

    public final String component4() {
        return this.requestFrom;
    }

    public final TheaterTopParam copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "pd");
        Intrinsics.checkNotNullParameter(str2, "from");
        Intrinsics.checkNotNullParameter(str3, "page");
        Intrinsics.checkNotNullParameter(str4, "requestFrom");
        return new TheaterTopParam(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TheaterTopParam)) {
            return false;
        }
        TheaterTopParam theaterTopParam = (TheaterTopParam) obj;
        return Intrinsics.areEqual((Object) this.pd, (Object) theaterTopParam.pd) && Intrinsics.areEqual((Object) this.from, (Object) theaterTopParam.from) && Intrinsics.areEqual((Object) this.page, (Object) theaterTopParam.page) && Intrinsics.areEqual((Object) this.requestFrom, (Object) theaterTopParam.requestFrom);
    }

    public int hashCode() {
        return (((((this.pd.hashCode() * 31) + this.from.hashCode()) * 31) + this.page.hashCode()) * 31) + this.requestFrom.hashCode();
    }

    public String toString() {
        return "TheaterTopParam(pd=" + this.pd + ", from=" + this.from + ", page=" + this.page + ", requestFrom=" + this.requestFrom + ')';
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getPage() {
        return this.page;
    }

    public final String getPd() {
        return this.pd;
    }

    public final String getRequestFrom() {
        return this.requestFrom;
    }

    public final void setFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.from = str;
    }

    public final void setPage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.page = str;
    }

    public TheaterTopParam(String pd2, String from2, String page2, String requestFrom2) {
        Intrinsics.checkNotNullParameter(pd2, "pd");
        Intrinsics.checkNotNullParameter(from2, "from");
        Intrinsics.checkNotNullParameter(page2, "page");
        Intrinsics.checkNotNullParameter(requestFrom2, "requestFrom");
        this.pd = pd2;
        this.from = from2;
        this.page = page2;
        this.requestFrom = requestFrom2;
    }

    public JSONObject toJson() {
        addExtParams("pd", this.pd);
        addExtParams("from", this.from);
        addExtParams("page", this.page);
        addExtParams(TimerStatusInfoRequester.REQUEST_FROM_KEY, this.requestFrom);
        return super.toJson();
    }
}
