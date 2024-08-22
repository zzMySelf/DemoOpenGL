package com.baidu.searchbox.flowvideo.praise.repos;

import com.baidu.searchbox.feed.detail.ext.common.RequestParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/flowvideo/praise/repos/PraiseParam;", "Lcom/baidu/searchbox/feed/detail/ext/common/RequestParam;", "nid", "", "isPraised", "", "praiseCount", "", "ext", "strategyInfo", "(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;)V", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "()Z", "setPraised", "(Z)V", "getNid", "setNid", "getPraiseCount", "()I", "setPraiseCount", "(I)V", "getStrategyInfo", "setStrategyInfo", "toJson", "Lorg/json/JSONObject;", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseParam.kt */
public final class PraiseParam extends RequestParam {
    private String ext;
    private boolean isPraised;
    private String nid;
    private int praiseCount;
    private String strategyInfo;

    public PraiseParam(String nid2, boolean isPraised2, int praiseCount2, String ext2, String strategyInfo2) {
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(ext2, "ext");
        Intrinsics.checkNotNullParameter(strategyInfo2, "strategyInfo");
        this.nid = nid2;
        this.isPraised = isPraised2;
        this.praiseCount = praiseCount2;
        this.ext = ext2;
        this.strategyInfo = strategyInfo2;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getNid() {
        return this.nid;
    }

    public final int getPraiseCount() {
        return this.praiseCount;
    }

    public final String getStrategyInfo() {
        return this.strategyInfo;
    }

    public final boolean isPraised() {
        return this.isPraised;
    }

    public final void setExt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext = str;
    }

    public final void setNid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nid = str;
    }

    public final void setPraiseCount(int i2) {
        this.praiseCount = i2;
    }

    public final void setPraised(boolean z) {
        this.isPraised = z;
    }

    public final void setStrategyInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.strategyInfo = str;
    }

    public JSONObject toJson() {
        addExtParams("nid", this.nid);
        addExtParams("type", this.isPraised ? "1" : "0");
        addExtParams("ext", this.ext);
        addExtParams("strategy_info", this.strategyInfo);
        return super.toJson();
    }
}
