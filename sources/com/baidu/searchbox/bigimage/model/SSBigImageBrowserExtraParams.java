package com.baidu.searchbox.bigimage.model;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.bigimage.utils.BigImageTcUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u0000\n\u0002\b\b\b\b\u0018\u0000 c2\u00020\u0001:\u0005cdefgBÅ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0019J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010W\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010Y\u001a\u00020\bHÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003JÎ\u0001\u0010\\\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010]J\u0013\u0010^\u001a\u00020\b2\b\u0010_\u001a\u0004\u0018\u00010`HÖ\u0003J\t\u0010a\u001a\u00020\u0003HÖ\u0001J\t\u0010b\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010.\"\u0004\b<\u00100R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010.\"\u0004\b@\u00100R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010 \"\u0004\bF\u0010\"R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010.\"\u0004\bH\u00100R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010 \"\u0004\bJ\u0010\"¨\u0006h"}, d2 = {"Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams;", "Lcom/baidu/searchbox/NoProGuard;", "source", "", "query", "", "shituJumpUrlPrefix", "firstWindowInfoIsShow", "", "canScrollToSecondWindow", "fromRelativeImgs", "needH5Load", "invokeId", "timeoutThreshold", "loadMoreTest", "schemeVolume", "extLog", "special", "Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$Special;", "logInfo", "Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$LogInfo;", "commonLog", "Lorg/json/JSONObject;", "tcLog", "urlLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/String;IIILjava/lang/String;Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$Special;Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$LogInfo;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "getCanScrollToSecondWindow", "()Ljava/lang/Boolean;", "setCanScrollToSecondWindow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCommonLog", "()Lorg/json/JSONObject;", "setCommonLog", "(Lorg/json/JSONObject;)V", "getExtLog", "()Ljava/lang/String;", "setExtLog", "(Ljava/lang/String;)V", "getFirstWindowInfoIsShow", "setFirstWindowInfoIsShow", "getFromRelativeImgs", "setFromRelativeImgs", "getInvokeId", "setInvokeId", "getLoadMoreTest", "()I", "setLoadMoreTest", "(I)V", "getLogInfo", "()Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$LogInfo;", "setLogInfo", "(Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$LogInfo;)V", "getNeedH5Load", "()Z", "setNeedH5Load", "(Z)V", "getQuery", "setQuery", "getSchemeVolume", "setSchemeVolume", "getShituJumpUrlPrefix", "setShituJumpUrlPrefix", "getSource", "setSource", "getSpecial", "()Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$Special;", "setSpecial", "(Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$Special;)V", "getTcLog", "setTcLog", "getTimeoutThreshold", "setTimeoutThreshold", "getUrlLog", "setUrlLog", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/String;IIILjava/lang/String;Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$Special;Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$LogInfo;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams;", "equals", "other", "", "hashCode", "toString", "Companion", "LogInfo", "PicRecognizeInfo", "RelevantSearch", "Special", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigImageBrowserExtraParams.kt */
public final class SSBigImageBrowserExtraParams implements NoProGuard {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int IMAGE_PREVIEW_NONE = 0;
    public static final int IMAGE_PREVIEW_WALLPAPER = 1;
    private Boolean canScrollToSecondWindow;
    private JSONObject commonLog;
    private String extLog;
    private Boolean firstWindowInfoIsShow;
    private Boolean fromRelativeImgs;
    private String invokeId;
    private int loadMoreTest;
    private LogInfo logInfo;
    private boolean needH5Load;
    private String query;
    private int schemeVolume;
    private String shituJumpUrlPrefix;
    private int source;
    private Special special;
    private JSONObject tcLog;
    private int timeoutThreshold;
    private JSONObject urlLog;

    public SSBigImageBrowserExtraParams() {
        this(0, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, false, (String) null, 0, 0, 0, (String) null, (Special) null, (LogInfo) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, 131071, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SSBigImageBrowserExtraParams copy$default(SSBigImageBrowserExtraParams sSBigImageBrowserExtraParams, int i2, String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, boolean z, String str3, int i3, int i4, int i5, String str4, Special special2, LogInfo logInfo2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i6, Object obj) {
        SSBigImageBrowserExtraParams sSBigImageBrowserExtraParams2 = sSBigImageBrowserExtraParams;
        int i7 = i6;
        return sSBigImageBrowserExtraParams.copy((i7 & 1) != 0 ? sSBigImageBrowserExtraParams2.source : i2, (i7 & 2) != 0 ? sSBigImageBrowserExtraParams2.query : str, (i7 & 4) != 0 ? sSBigImageBrowserExtraParams2.shituJumpUrlPrefix : str2, (i7 & 8) != 0 ? sSBigImageBrowserExtraParams2.firstWindowInfoIsShow : bool, (i7 & 16) != 0 ? sSBigImageBrowserExtraParams2.canScrollToSecondWindow : bool2, (i7 & 32) != 0 ? sSBigImageBrowserExtraParams2.fromRelativeImgs : bool3, (i7 & 64) != 0 ? sSBigImageBrowserExtraParams2.needH5Load : z, (i7 & 128) != 0 ? sSBigImageBrowserExtraParams2.invokeId : str3, (i7 & 256) != 0 ? sSBigImageBrowserExtraParams2.timeoutThreshold : i3, (i7 & 512) != 0 ? sSBigImageBrowserExtraParams2.loadMoreTest : i4, (i7 & 1024) != 0 ? sSBigImageBrowserExtraParams2.schemeVolume : i5, (i7 & 2048) != 0 ? sSBigImageBrowserExtraParams2.extLog : str4, (i7 & 4096) != 0 ? sSBigImageBrowserExtraParams2.special : special2, (i7 & 8192) != 0 ? sSBigImageBrowserExtraParams2.logInfo : logInfo2, (i7 & 16384) != 0 ? sSBigImageBrowserExtraParams2.commonLog : jSONObject, (i7 & 32768) != 0 ? sSBigImageBrowserExtraParams2.tcLog : jSONObject2, (i7 & 65536) != 0 ? sSBigImageBrowserExtraParams2.urlLog : jSONObject3);
    }

    public final int component1() {
        return this.source;
    }

    public final int component10() {
        return this.loadMoreTest;
    }

    public final int component11() {
        return this.schemeVolume;
    }

    public final String component12() {
        return this.extLog;
    }

    public final Special component13() {
        return this.special;
    }

    public final LogInfo component14() {
        return this.logInfo;
    }

    public final JSONObject component15() {
        return this.commonLog;
    }

    public final JSONObject component16() {
        return this.tcLog;
    }

    public final JSONObject component17() {
        return this.urlLog;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.shituJumpUrlPrefix;
    }

    public final Boolean component4() {
        return this.firstWindowInfoIsShow;
    }

    public final Boolean component5() {
        return this.canScrollToSecondWindow;
    }

    public final Boolean component6() {
        return this.fromRelativeImgs;
    }

    public final boolean component7() {
        return this.needH5Load;
    }

    public final String component8() {
        return this.invokeId;
    }

    public final int component9() {
        return this.timeoutThreshold;
    }

    public final SSBigImageBrowserExtraParams copy(int i2, String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, boolean z, String str3, int i3, int i4, int i5, String str4, Special special2, LogInfo logInfo2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Intrinsics.checkNotNullParameter(str3, "invokeId");
        return new SSBigImageBrowserExtraParams(i2, str, str2, bool, bool2, bool3, z, str3, i3, i4, i5, str4, special2, logInfo2, jSONObject, jSONObject2, jSONObject3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SSBigImageBrowserExtraParams)) {
            return false;
        }
        SSBigImageBrowserExtraParams sSBigImageBrowserExtraParams = (SSBigImageBrowserExtraParams) obj;
        return this.source == sSBigImageBrowserExtraParams.source && Intrinsics.areEqual((Object) this.query, (Object) sSBigImageBrowserExtraParams.query) && Intrinsics.areEqual((Object) this.shituJumpUrlPrefix, (Object) sSBigImageBrowserExtraParams.shituJumpUrlPrefix) && Intrinsics.areEqual((Object) this.firstWindowInfoIsShow, (Object) sSBigImageBrowserExtraParams.firstWindowInfoIsShow) && Intrinsics.areEqual((Object) this.canScrollToSecondWindow, (Object) sSBigImageBrowserExtraParams.canScrollToSecondWindow) && Intrinsics.areEqual((Object) this.fromRelativeImgs, (Object) sSBigImageBrowserExtraParams.fromRelativeImgs) && this.needH5Load == sSBigImageBrowserExtraParams.needH5Load && Intrinsics.areEqual((Object) this.invokeId, (Object) sSBigImageBrowserExtraParams.invokeId) && this.timeoutThreshold == sSBigImageBrowserExtraParams.timeoutThreshold && this.loadMoreTest == sSBigImageBrowserExtraParams.loadMoreTest && this.schemeVolume == sSBigImageBrowserExtraParams.schemeVolume && Intrinsics.areEqual((Object) this.extLog, (Object) sSBigImageBrowserExtraParams.extLog) && Intrinsics.areEqual((Object) this.special, (Object) sSBigImageBrowserExtraParams.special) && Intrinsics.areEqual((Object) this.logInfo, (Object) sSBigImageBrowserExtraParams.logInfo) && Intrinsics.areEqual((Object) this.commonLog, (Object) sSBigImageBrowserExtraParams.commonLog) && Intrinsics.areEqual((Object) this.tcLog, (Object) sSBigImageBrowserExtraParams.tcLog) && Intrinsics.areEqual((Object) this.urlLog, (Object) sSBigImageBrowserExtraParams.urlLog);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.source) * 31;
        String str = this.query;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.shituJumpUrlPrefix;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.firstWindowInfoIsShow;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.canScrollToSecondWindow;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.fromRelativeImgs;
        int hashCode6 = (hashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        boolean z = this.needH5Load;
        if (z) {
            z = true;
        }
        int hashCode7 = (((((((((hashCode6 + (z ? 1 : 0)) * 31) + this.invokeId.hashCode()) * 31) + Integer.hashCode(this.timeoutThreshold)) * 31) + Integer.hashCode(this.loadMoreTest)) * 31) + Integer.hashCode(this.schemeVolume)) * 31;
        String str3 = this.extLog;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Special special2 = this.special;
        int hashCode9 = (hashCode8 + (special2 == null ? 0 : special2.hashCode())) * 31;
        LogInfo logInfo2 = this.logInfo;
        int hashCode10 = (hashCode9 + (logInfo2 == null ? 0 : logInfo2.hashCode())) * 31;
        JSONObject jSONObject = this.commonLog;
        int hashCode11 = (hashCode10 + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        JSONObject jSONObject2 = this.tcLog;
        int hashCode12 = (hashCode11 + (jSONObject2 == null ? 0 : jSONObject2.hashCode())) * 31;
        JSONObject jSONObject3 = this.urlLog;
        if (jSONObject3 != null) {
            i2 = jSONObject3.hashCode();
        }
        return hashCode12 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SSBigImageBrowserExtraParams(source=").append(this.source).append(", query=").append(this.query).append(", shituJumpUrlPrefix=").append(this.shituJumpUrlPrefix).append(", firstWindowInfoIsShow=").append(this.firstWindowInfoIsShow).append(", canScrollToSecondWindow=").append(this.canScrollToSecondWindow).append(", fromRelativeImgs=").append(this.fromRelativeImgs).append(", needH5Load=").append(this.needH5Load).append(", invokeId=").append(this.invokeId).append(", timeoutThreshold=").append(this.timeoutThreshold).append(", loadMoreTest=").append(this.loadMoreTest).append(", schemeVolume=").append(this.schemeVolume).append(", extLog=");
        sb.append(this.extLog).append(", special=").append(this.special).append(", logInfo=").append(this.logInfo).append(", commonLog=").append(this.commonLog).append(", tcLog=").append(this.tcLog).append(", urlLog=").append(this.urlLog).append(')');
        return sb.toString();
    }

    public SSBigImageBrowserExtraParams(int source2, String query2, String shituJumpUrlPrefix2, Boolean firstWindowInfoIsShow2, Boolean canScrollToSecondWindow2, Boolean fromRelativeImgs2, boolean needH5Load2, String invokeId2, int timeoutThreshold2, int loadMoreTest2, int schemeVolume2, String extLog2, Special special2, LogInfo logInfo2, JSONObject commonLog2, JSONObject tcLog2, JSONObject urlLog2) {
        String str = invokeId2;
        Intrinsics.checkNotNullParameter(str, "invokeId");
        this.source = source2;
        this.query = query2;
        this.shituJumpUrlPrefix = shituJumpUrlPrefix2;
        this.firstWindowInfoIsShow = firstWindowInfoIsShow2;
        this.canScrollToSecondWindow = canScrollToSecondWindow2;
        this.fromRelativeImgs = fromRelativeImgs2;
        this.needH5Load = needH5Load2;
        this.invokeId = str;
        this.timeoutThreshold = timeoutThreshold2;
        this.loadMoreTest = loadMoreTest2;
        this.schemeVolume = schemeVolume2;
        this.extLog = extLog2;
        this.special = special2;
        this.logInfo = logInfo2;
        this.commonLog = commonLog2;
        this.tcLog = tcLog2;
        this.urlLog = urlLog2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SSBigImageBrowserExtraParams(int r19, java.lang.String r20, java.lang.String r21, java.lang.Boolean r22, java.lang.Boolean r23, java.lang.Boolean r24, boolean r25, java.lang.String r26, int r27, int r28, int r29, java.lang.String r30, com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams.Special r31, com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams.LogInfo r32, org.json.JSONObject r33, org.json.JSONObject r34, org.json.JSONObject r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            if (r1 == 0) goto L_0x000d
            r1 = r2
            goto L_0x000f
        L_0x000d:
            r1 = r19
        L_0x000f:
            r4 = r0 & 2
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0017
            r4 = r5
            goto L_0x0019
        L_0x0017:
            r4 = r20
        L_0x0019:
            r6 = r0 & 4
            if (r6 == 0) goto L_0x001f
            r6 = r5
            goto L_0x0021
        L_0x001f:
            r6 = r21
        L_0x0021:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0027
            r7 = r3
            goto L_0x0029
        L_0x0027:
            r7 = r22
        L_0x0029:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002f
            r8 = r3
            goto L_0x0031
        L_0x002f:
            r8 = r23
        L_0x0031:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r3 = r24
        L_0x0038:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003e
            r9 = r2
            goto L_0x0040
        L_0x003e:
            r9 = r25
        L_0x0040:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r5 = r26
        L_0x0047:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004d
            r10 = r2
            goto L_0x004f
        L_0x004d:
            r10 = r27
        L_0x004f:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0055
            r11 = -1
            goto L_0x0057
        L_0x0055:
            r11 = r28
        L_0x0057:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r2 = r29
        L_0x005e:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0064
            r12 = 0
            goto L_0x0066
        L_0x0064:
            r12 = r30
        L_0x0066:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006c
            r14 = 0
            goto L_0x006e
        L_0x006c:
            r14 = r31
        L_0x006e:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0074
            r15 = 0
            goto L_0x0076
        L_0x0074:
            r15 = r32
        L_0x0076:
            r13 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x007c
            r13 = 0
            goto L_0x007e
        L_0x007c:
            r13 = r33
        L_0x007e:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0088
            r16 = 0
            goto L_0x008a
        L_0x0088:
            r16 = r34
        L_0x008a:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x0092
            r0 = 0
            goto L_0x0094
        L_0x0092:
            r0 = r35
        L_0x0094:
            r19 = r1
            r20 = r4
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r3
            r25 = r9
            r26 = r5
            r27 = r10
            r28 = r11
            r29 = r2
            r30 = r12
            r31 = r14
            r32 = r15
            r33 = r13
            r34 = r16
            r35 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams.<init>(int, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, boolean, java.lang.String, int, int, int, java.lang.String, com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams$Special, com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams$LogInfo, org.json.JSONObject, org.json.JSONObject, org.json.JSONObject, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getSource() {
        return this.source;
    }

    public final void setSource(int i2) {
        this.source = i2;
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String str) {
        this.query = str;
    }

    public final String getShituJumpUrlPrefix() {
        return this.shituJumpUrlPrefix;
    }

    public final void setShituJumpUrlPrefix(String str) {
        this.shituJumpUrlPrefix = str;
    }

    public final Boolean getFirstWindowInfoIsShow() {
        return this.firstWindowInfoIsShow;
    }

    public final void setFirstWindowInfoIsShow(Boolean bool) {
        this.firstWindowInfoIsShow = bool;
    }

    public final Boolean getCanScrollToSecondWindow() {
        return this.canScrollToSecondWindow;
    }

    public final void setCanScrollToSecondWindow(Boolean bool) {
        this.canScrollToSecondWindow = bool;
    }

    public final Boolean getFromRelativeImgs() {
        return this.fromRelativeImgs;
    }

    public final void setFromRelativeImgs(Boolean bool) {
        this.fromRelativeImgs = bool;
    }

    public final boolean getNeedH5Load() {
        return this.needH5Load;
    }

    public final void setNeedH5Load(boolean z) {
        this.needH5Load = z;
    }

    public final String getInvokeId() {
        return this.invokeId;
    }

    public final void setInvokeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.invokeId = str;
    }

    public final int getTimeoutThreshold() {
        return this.timeoutThreshold;
    }

    public final void setTimeoutThreshold(int i2) {
        this.timeoutThreshold = i2;
    }

    public final int getLoadMoreTest() {
        return this.loadMoreTest;
    }

    public final void setLoadMoreTest(int i2) {
        this.loadMoreTest = i2;
    }

    public final int getSchemeVolume() {
        return this.schemeVolume;
    }

    public final void setSchemeVolume(int i2) {
        this.schemeVolume = i2;
    }

    public final String getExtLog() {
        return this.extLog;
    }

    public final void setExtLog(String str) {
        this.extLog = str;
    }

    public final Special getSpecial() {
        return this.special;
    }

    public final void setSpecial(Special special2) {
        this.special = special2;
    }

    public final LogInfo getLogInfo() {
        return this.logInfo;
    }

    public final void setLogInfo(LogInfo logInfo2) {
        this.logInfo = logInfo2;
    }

    public final JSONObject getCommonLog() {
        return this.commonLog;
    }

    public final void setCommonLog(JSONObject jSONObject) {
        this.commonLog = jSONObject;
    }

    public final JSONObject getTcLog() {
        return this.tcLog;
    }

    public final void setTcLog(JSONObject jSONObject) {
        this.tcLog = jSONObject;
    }

    public final JSONObject getUrlLog() {
        return this.urlLog;
    }

    public final void setUrlLog(JSONObject jSONObject) {
        this.urlLog = jSONObject;
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bL\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010R\u001a\u00020\tHÆ\u0003J\u0011\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\tHÆ\u0003J\t\u0010Z\u001a\u00020\tHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010]\u001a\u00020\tHÆ\u0003J\t\u0010^\u001a\u00020\u001dHÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010b\u001a\u00020\tHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0002\u0010g\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\t2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010h\u001a\u00020\u001d2\b\u0010i\u001a\u0004\u0018\u00010jHÖ\u0003J\t\u0010k\u001a\u00020\tHÖ\u0001J\t\u0010l\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\u001a\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R\u0011\u0010\u001b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010!\"\u0004\b4\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010-\"\u0004\b:\u0010/R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010!R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010!\"\u0004\bC\u0010#R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010!\"\u0004\bE\u0010#R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010!\"\u0004\bG\u0010#R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010!\"\u0004\bI\u0010#R\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010-\"\u0004\bK\u0010/R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bL\u0010-R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010!\"\u0004\bN\u0010#R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P¨\u0006m"}, d2 = {"Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$Special;", "Lcom/baidu/searchbox/NoProGuard;", "feedBackUrl", "", "imageSetRequestUrlPrefix", "loadMoreApiUrl", "loadMoreParams", "Lorg/json/JSONObject;", "loadMoreRn", "", "hasReadApiUrl", "collectApiUrl", "collectPageUrl", "gsm", "shootdata", "rsArray", "", "Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$RelevantSearch;", "rsUrlPrefix", "rsSaPrefix", "shareApiUrl", "storeStateApiUrl", "secondScreenApiUrl", "imagePreviewType", "showGestureGuide", "picRecognizeInfo", "Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$PicRecognizeInfo;", "initGoodsCount", "yyLive", "", "materialQuery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$PicRecognizeInfo;IZLjava/lang/String;)V", "getCollectApiUrl", "()Ljava/lang/String;", "setCollectApiUrl", "(Ljava/lang/String;)V", "getCollectPageUrl", "setCollectPageUrl", "getFeedBackUrl", "setFeedBackUrl", "getGsm", "setGsm", "getHasReadApiUrl", "setHasReadApiUrl", "getImagePreviewType", "()I", "setImagePreviewType", "(I)V", "getImageSetRequestUrlPrefix", "setImageSetRequestUrlPrefix", "getInitGoodsCount", "getLoadMoreApiUrl", "setLoadMoreApiUrl", "getLoadMoreParams", "()Lorg/json/JSONObject;", "setLoadMoreParams", "(Lorg/json/JSONObject;)V", "getLoadMoreRn", "setLoadMoreRn", "getMaterialQuery", "getPicRecognizeInfo", "()Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$PicRecognizeInfo;", "getRsArray", "()Ljava/util/List;", "setRsArray", "(Ljava/util/List;)V", "getRsSaPrefix", "setRsSaPrefix", "getRsUrlPrefix", "setRsUrlPrefix", "getSecondScreenApiUrl", "setSecondScreenApiUrl", "getShareApiUrl", "setShareApiUrl", "getShootdata", "setShootdata", "getShowGestureGuide", "getStoreStateApiUrl", "setStoreStateApiUrl", "getYyLive", "()Z", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BigImageBrowserExtraParams.kt */
    public static final class Special implements NoProGuard {
        private String collectApiUrl;
        private String collectPageUrl;
        private String feedBackUrl;
        private String gsm;
        private String hasReadApiUrl;
        private int imagePreviewType;
        private String imageSetRequestUrlPrefix;
        private final int initGoodsCount;
        private String loadMoreApiUrl;
        private JSONObject loadMoreParams;
        private int loadMoreRn;
        private final String materialQuery;
        private final PicRecognizeInfo picRecognizeInfo;
        private List<RelevantSearch> rsArray;
        private String rsSaPrefix;
        private String rsUrlPrefix;
        private String secondScreenApiUrl;
        private String shareApiUrl;
        private int shootdata;
        private final int showGestureGuide;
        private String storeStateApiUrl;
        private final boolean yyLive;

        public static /* synthetic */ Special copy$default(Special special, String str, String str2, String str3, JSONObject jSONObject, int i2, String str4, String str5, String str6, String str7, int i3, List list, String str8, String str9, String str10, String str11, String str12, int i4, int i5, PicRecognizeInfo picRecognizeInfo2, int i6, boolean z, String str13, int i7, Object obj) {
            Special special2 = special;
            int i8 = i7;
            return special.copy((i8 & 1) != 0 ? special2.feedBackUrl : str, (i8 & 2) != 0 ? special2.imageSetRequestUrlPrefix : str2, (i8 & 4) != 0 ? special2.loadMoreApiUrl : str3, (i8 & 8) != 0 ? special2.loadMoreParams : jSONObject, (i8 & 16) != 0 ? special2.loadMoreRn : i2, (i8 & 32) != 0 ? special2.hasReadApiUrl : str4, (i8 & 64) != 0 ? special2.collectApiUrl : str5, (i8 & 128) != 0 ? special2.collectPageUrl : str6, (i8 & 256) != 0 ? special2.gsm : str7, (i8 & 512) != 0 ? special2.shootdata : i3, (i8 & 1024) != 0 ? special2.rsArray : list, (i8 & 2048) != 0 ? special2.rsUrlPrefix : str8, (i8 & 4096) != 0 ? special2.rsSaPrefix : str9, (i8 & 8192) != 0 ? special2.shareApiUrl : str10, (i8 & 16384) != 0 ? special2.storeStateApiUrl : str11, (i8 & 32768) != 0 ? special2.secondScreenApiUrl : str12, (i8 & 65536) != 0 ? special2.imagePreviewType : i4, (i8 & 131072) != 0 ? special2.showGestureGuide : i5, (i8 & 262144) != 0 ? special2.picRecognizeInfo : picRecognizeInfo2, (i8 & 524288) != 0 ? special2.initGoodsCount : i6, (i8 & 1048576) != 0 ? special2.yyLive : z, (i8 & 2097152) != 0 ? special2.materialQuery : str13);
        }

        public final String component1() {
            return this.feedBackUrl;
        }

        public final int component10() {
            return this.shootdata;
        }

        public final List<RelevantSearch> component11() {
            return this.rsArray;
        }

        public final String component12() {
            return this.rsUrlPrefix;
        }

        public final String component13() {
            return this.rsSaPrefix;
        }

        public final String component14() {
            return this.shareApiUrl;
        }

        public final String component15() {
            return this.storeStateApiUrl;
        }

        public final String component16() {
            return this.secondScreenApiUrl;
        }

        public final int component17() {
            return this.imagePreviewType;
        }

        public final int component18() {
            return this.showGestureGuide;
        }

        public final PicRecognizeInfo component19() {
            return this.picRecognizeInfo;
        }

        public final String component2() {
            return this.imageSetRequestUrlPrefix;
        }

        public final int component20() {
            return this.initGoodsCount;
        }

        public final boolean component21() {
            return this.yyLive;
        }

        public final String component22() {
            return this.materialQuery;
        }

        public final String component3() {
            return this.loadMoreApiUrl;
        }

        public final JSONObject component4() {
            return this.loadMoreParams;
        }

        public final int component5() {
            return this.loadMoreRn;
        }

        public final String component6() {
            return this.hasReadApiUrl;
        }

        public final String component7() {
            return this.collectApiUrl;
        }

        public final String component8() {
            return this.collectPageUrl;
        }

        public final String component9() {
            return this.gsm;
        }

        public final Special copy(String str, String str2, String str3, JSONObject jSONObject, int i2, String str4, String str5, String str6, String str7, int i3, List<RelevantSearch> list, String str8, String str9, String str10, String str11, String str12, int i4, int i5, PicRecognizeInfo picRecognizeInfo2, int i6, boolean z, String str13) {
            Intrinsics.checkNotNullParameter(str13, "materialQuery");
            return new Special(str, str2, str3, jSONObject, i2, str4, str5, str6, str7, i3, list, str8, str9, str10, str11, str12, i4, i5, picRecognizeInfo2, i6, z, str13);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Special)) {
                return false;
            }
            Special special = (Special) obj;
            return Intrinsics.areEqual((Object) this.feedBackUrl, (Object) special.feedBackUrl) && Intrinsics.areEqual((Object) this.imageSetRequestUrlPrefix, (Object) special.imageSetRequestUrlPrefix) && Intrinsics.areEqual((Object) this.loadMoreApiUrl, (Object) special.loadMoreApiUrl) && Intrinsics.areEqual((Object) this.loadMoreParams, (Object) special.loadMoreParams) && this.loadMoreRn == special.loadMoreRn && Intrinsics.areEqual((Object) this.hasReadApiUrl, (Object) special.hasReadApiUrl) && Intrinsics.areEqual((Object) this.collectApiUrl, (Object) special.collectApiUrl) && Intrinsics.areEqual((Object) this.collectPageUrl, (Object) special.collectPageUrl) && Intrinsics.areEqual((Object) this.gsm, (Object) special.gsm) && this.shootdata == special.shootdata && Intrinsics.areEqual((Object) this.rsArray, (Object) special.rsArray) && Intrinsics.areEqual((Object) this.rsUrlPrefix, (Object) special.rsUrlPrefix) && Intrinsics.areEqual((Object) this.rsSaPrefix, (Object) special.rsSaPrefix) && Intrinsics.areEqual((Object) this.shareApiUrl, (Object) special.shareApiUrl) && Intrinsics.areEqual((Object) this.storeStateApiUrl, (Object) special.storeStateApiUrl) && Intrinsics.areEqual((Object) this.secondScreenApiUrl, (Object) special.secondScreenApiUrl) && this.imagePreviewType == special.imagePreviewType && this.showGestureGuide == special.showGestureGuide && Intrinsics.areEqual((Object) this.picRecognizeInfo, (Object) special.picRecognizeInfo) && this.initGoodsCount == special.initGoodsCount && this.yyLive == special.yyLive && Intrinsics.areEqual((Object) this.materialQuery, (Object) special.materialQuery);
        }

        public int hashCode() {
            String str = this.feedBackUrl;
            int i2 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.imageSetRequestUrlPrefix;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.loadMoreApiUrl;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            JSONObject jSONObject = this.loadMoreParams;
            int hashCode4 = (((hashCode3 + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31) + Integer.hashCode(this.loadMoreRn)) * 31;
            String str4 = this.hasReadApiUrl;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.collectApiUrl;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.collectPageUrl;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.gsm;
            int hashCode8 = (((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Integer.hashCode(this.shootdata)) * 31;
            List<RelevantSearch> list = this.rsArray;
            int hashCode9 = (hashCode8 + (list == null ? 0 : list.hashCode())) * 31;
            String str8 = this.rsUrlPrefix;
            int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.rsSaPrefix;
            int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.shareApiUrl;
            int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.storeStateApiUrl;
            int hashCode13 = (hashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.secondScreenApiUrl;
            int hashCode14 = (((((hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31) + Integer.hashCode(this.imagePreviewType)) * 31) + Integer.hashCode(this.showGestureGuide)) * 31;
            PicRecognizeInfo picRecognizeInfo2 = this.picRecognizeInfo;
            if (picRecognizeInfo2 != null) {
                i2 = picRecognizeInfo2.hashCode();
            }
            int hashCode15 = (((hashCode14 + i2) * 31) + Integer.hashCode(this.initGoodsCount)) * 31;
            boolean z = this.yyLive;
            if (z) {
                z = true;
            }
            return ((hashCode15 + (z ? 1 : 0)) * 31) + this.materialQuery.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Special(feedBackUrl=").append(this.feedBackUrl).append(", imageSetRequestUrlPrefix=").append(this.imageSetRequestUrlPrefix).append(", loadMoreApiUrl=").append(this.loadMoreApiUrl).append(", loadMoreParams=").append(this.loadMoreParams).append(", loadMoreRn=").append(this.loadMoreRn).append(", hasReadApiUrl=").append(this.hasReadApiUrl).append(", collectApiUrl=").append(this.collectApiUrl).append(", collectPageUrl=").append(this.collectPageUrl).append(", gsm=").append(this.gsm).append(", shootdata=").append(this.shootdata).append(", rsArray=").append(this.rsArray).append(", rsUrlPrefix=");
            sb.append(this.rsUrlPrefix).append(", rsSaPrefix=").append(this.rsSaPrefix).append(", shareApiUrl=").append(this.shareApiUrl).append(", storeStateApiUrl=").append(this.storeStateApiUrl).append(", secondScreenApiUrl=").append(this.secondScreenApiUrl).append(", imagePreviewType=").append(this.imagePreviewType).append(", showGestureGuide=").append(this.showGestureGuide).append(", picRecognizeInfo=").append(this.picRecognizeInfo).append(", initGoodsCount=").append(this.initGoodsCount).append(", yyLive=").append(this.yyLive).append(", materialQuery=").append(this.materialQuery).append(')');
            return sb.toString();
        }

        public Special(String feedBackUrl2, String imageSetRequestUrlPrefix2, String loadMoreApiUrl2, JSONObject loadMoreParams2, int loadMoreRn2, String hasReadApiUrl2, String collectApiUrl2, String collectPageUrl2, String gsm2, int shootdata2, List<RelevantSearch> rsArray2, String rsUrlPrefix2, String rsSaPrefix2, String shareApiUrl2, String storeStateApiUrl2, String secondScreenApiUrl2, int imagePreviewType2, int showGestureGuide2, PicRecognizeInfo picRecognizeInfo2, int initGoodsCount2, boolean yyLive2, String materialQuery2) {
            String str = materialQuery2;
            Intrinsics.checkNotNullParameter(str, "materialQuery");
            this.feedBackUrl = feedBackUrl2;
            this.imageSetRequestUrlPrefix = imageSetRequestUrlPrefix2;
            this.loadMoreApiUrl = loadMoreApiUrl2;
            this.loadMoreParams = loadMoreParams2;
            this.loadMoreRn = loadMoreRn2;
            this.hasReadApiUrl = hasReadApiUrl2;
            this.collectApiUrl = collectApiUrl2;
            this.collectPageUrl = collectPageUrl2;
            this.gsm = gsm2;
            this.shootdata = shootdata2;
            this.rsArray = rsArray2;
            this.rsUrlPrefix = rsUrlPrefix2;
            this.rsSaPrefix = rsSaPrefix2;
            this.shareApiUrl = shareApiUrl2;
            this.storeStateApiUrl = storeStateApiUrl2;
            this.secondScreenApiUrl = secondScreenApiUrl2;
            this.imagePreviewType = imagePreviewType2;
            this.showGestureGuide = showGestureGuide2;
            this.picRecognizeInfo = picRecognizeInfo2;
            this.initGoodsCount = initGoodsCount2;
            this.yyLive = yyLive2;
            this.materialQuery = str;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Special(java.lang.String r27, java.lang.String r28, java.lang.String r29, org.json.JSONObject r30, int r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, java.util.List r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, int r43, int r44, com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams.PicRecognizeInfo r45, int r46, boolean r47, java.lang.String r48, int r49, kotlin.jvm.internal.DefaultConstructorMarker r50) {
            /*
                r26 = this;
                r0 = r49
                r1 = r0 & 1
                java.lang.String r2 = ""
                if (r1 == 0) goto L_0x000a
                r4 = r2
                goto L_0x000c
            L_0x000a:
                r4 = r27
            L_0x000c:
                r1 = r0 & 2
                if (r1 == 0) goto L_0x0012
                r5 = r2
                goto L_0x0014
            L_0x0012:
                r5 = r28
            L_0x0014:
                r1 = r0 & 4
                if (r1 == 0) goto L_0x001a
                r6 = 0
                goto L_0x001c
            L_0x001a:
                r6 = r29
            L_0x001c:
                r1 = r0 & 8
                if (r1 == 0) goto L_0x0022
                r7 = 0
                goto L_0x0024
            L_0x0022:
                r7 = r30
            L_0x0024:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x002c
                r1 = 30
                r8 = r1
                goto L_0x002e
            L_0x002c:
                r8 = r31
            L_0x002e:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0034
                r9 = 0
                goto L_0x0036
            L_0x0034:
                r9 = r32
            L_0x0036:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x003c
                r10 = 0
                goto L_0x003e
            L_0x003c:
                r10 = r33
            L_0x003e:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L_0x0044
                r11 = 0
                goto L_0x0046
            L_0x0044:
                r11 = r34
            L_0x0046:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x004c
                r12 = 0
                goto L_0x004e
            L_0x004c:
                r12 = r35
            L_0x004e:
                r1 = r0 & 512(0x200, float:7.175E-43)
                r13 = 0
                if (r1 == 0) goto L_0x0055
                r1 = r13
                goto L_0x0057
            L_0x0055:
                r1 = r36
            L_0x0057:
                r14 = r0 & 1024(0x400, float:1.435E-42)
                if (r14 == 0) goto L_0x005d
                r14 = 0
                goto L_0x005f
            L_0x005d:
                r14 = r37
            L_0x005f:
                r15 = r0 & 2048(0x800, float:2.87E-42)
                if (r15 == 0) goto L_0x0065
                r15 = 0
                goto L_0x0067
            L_0x0065:
                r15 = r38
            L_0x0067:
                r3 = r0 & 4096(0x1000, float:5.74E-42)
                if (r3 == 0) goto L_0x006e
                r16 = 0
                goto L_0x0070
            L_0x006e:
                r16 = r39
            L_0x0070:
                r3 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r3 == 0) goto L_0x0077
                r17 = 0
                goto L_0x0079
            L_0x0077:
                r17 = r40
            L_0x0079:
                r3 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r3 == 0) goto L_0x0080
                r18 = 0
                goto L_0x0082
            L_0x0080:
                r18 = r41
            L_0x0082:
                r3 = 32768(0x8000, float:4.5918E-41)
                r3 = r3 & r0
                if (r3 == 0) goto L_0x008b
                r19 = 0
                goto L_0x008d
            L_0x008b:
                r19 = r42
            L_0x008d:
                r3 = 65536(0x10000, float:9.18355E-41)
                r3 = r3 & r0
                if (r3 == 0) goto L_0x0095
                r20 = r13
                goto L_0x0097
            L_0x0095:
                r20 = r43
            L_0x0097:
                r3 = 131072(0x20000, float:1.83671E-40)
                r3 = r3 & r0
                if (r3 == 0) goto L_0x009f
                r21 = r13
                goto L_0x00a1
            L_0x009f:
                r21 = r44
            L_0x00a1:
                r3 = 262144(0x40000, float:3.67342E-40)
                r3 = r3 & r0
                if (r3 == 0) goto L_0x00a9
                r22 = 0
                goto L_0x00ab
            L_0x00a9:
                r22 = r45
            L_0x00ab:
                r3 = 524288(0x80000, float:7.34684E-40)
                r3 = r3 & r0
                if (r3 == 0) goto L_0x00b4
                r3 = 4
                r23 = r3
                goto L_0x00b6
            L_0x00b4:
                r23 = r46
            L_0x00b6:
                r3 = 2097152(0x200000, float:2.938736E-39)
                r0 = r0 & r3
                if (r0 == 0) goto L_0x00be
                r25 = r2
                goto L_0x00c0
            L_0x00be:
                r25 = r48
            L_0x00c0:
                r3 = r26
                r13 = r1
                r24 = r47
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams.Special.<init>(java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams$PicRecognizeInfo, int, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getFeedBackUrl() {
            return this.feedBackUrl;
        }

        public final void setFeedBackUrl(String str) {
            this.feedBackUrl = str;
        }

        public final String getImageSetRequestUrlPrefix() {
            return this.imageSetRequestUrlPrefix;
        }

        public final void setImageSetRequestUrlPrefix(String str) {
            this.imageSetRequestUrlPrefix = str;
        }

        public final String getLoadMoreApiUrl() {
            return this.loadMoreApiUrl;
        }

        public final void setLoadMoreApiUrl(String str) {
            this.loadMoreApiUrl = str;
        }

        public final JSONObject getLoadMoreParams() {
            return this.loadMoreParams;
        }

        public final void setLoadMoreParams(JSONObject jSONObject) {
            this.loadMoreParams = jSONObject;
        }

        public final int getLoadMoreRn() {
            return this.loadMoreRn;
        }

        public final void setLoadMoreRn(int i2) {
            this.loadMoreRn = i2;
        }

        public final String getHasReadApiUrl() {
            return this.hasReadApiUrl;
        }

        public final void setHasReadApiUrl(String str) {
            this.hasReadApiUrl = str;
        }

        public final String getCollectApiUrl() {
            return this.collectApiUrl;
        }

        public final void setCollectApiUrl(String str) {
            this.collectApiUrl = str;
        }

        public final String getCollectPageUrl() {
            return this.collectPageUrl;
        }

        public final void setCollectPageUrl(String str) {
            this.collectPageUrl = str;
        }

        public final String getGsm() {
            return this.gsm;
        }

        public final void setGsm(String str) {
            this.gsm = str;
        }

        public final int getShootdata() {
            return this.shootdata;
        }

        public final void setShootdata(int i2) {
            this.shootdata = i2;
        }

        public final List<RelevantSearch> getRsArray() {
            return this.rsArray;
        }

        public final void setRsArray(List<RelevantSearch> list) {
            this.rsArray = list;
        }

        public final String getRsUrlPrefix() {
            return this.rsUrlPrefix;
        }

        public final void setRsUrlPrefix(String str) {
            this.rsUrlPrefix = str;
        }

        public final String getRsSaPrefix() {
            return this.rsSaPrefix;
        }

        public final void setRsSaPrefix(String str) {
            this.rsSaPrefix = str;
        }

        public final String getShareApiUrl() {
            return this.shareApiUrl;
        }

        public final void setShareApiUrl(String str) {
            this.shareApiUrl = str;
        }

        public final String getStoreStateApiUrl() {
            return this.storeStateApiUrl;
        }

        public final void setStoreStateApiUrl(String str) {
            this.storeStateApiUrl = str;
        }

        public final String getSecondScreenApiUrl() {
            return this.secondScreenApiUrl;
        }

        public final void setSecondScreenApiUrl(String str) {
            this.secondScreenApiUrl = str;
        }

        public final int getImagePreviewType() {
            return this.imagePreviewType;
        }

        public final void setImagePreviewType(int i2) {
            this.imagePreviewType = i2;
        }

        public final int getShowGestureGuide() {
            return this.showGestureGuide;
        }

        public final PicRecognizeInfo getPicRecognizeInfo() {
            return this.picRecognizeInfo;
        }

        public final int getInitGoodsCount() {
            return this.initGoodsCount;
        }

        public final boolean getYyLive() {
            return this.yyLive;
        }

        public final String getMaterialQuery() {
            return this.materialQuery;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$RelevantSearch;", "Lcom/baidu/searchbox/NoProGuard;", "rsQuery", "", "passLog", "thumbUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPassLog", "()Ljava/lang/String;", "setPassLog", "(Ljava/lang/String;)V", "getRsQuery", "setRsQuery", "getThumbUrl", "setThumbUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BigImageBrowserExtraParams.kt */
    public static final class RelevantSearch implements NoProGuard {
        private String passLog;
        private String rsQuery;
        private String thumbUrl;

        public RelevantSearch() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ RelevantSearch copy$default(RelevantSearch relevantSearch, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = relevantSearch.rsQuery;
            }
            if ((i2 & 2) != 0) {
                str2 = relevantSearch.passLog;
            }
            if ((i2 & 4) != 0) {
                str3 = relevantSearch.thumbUrl;
            }
            return relevantSearch.copy(str, str2, str3);
        }

        public final String component1() {
            return this.rsQuery;
        }

        public final String component2() {
            return this.passLog;
        }

        public final String component3() {
            return this.thumbUrl;
        }

        public final RelevantSearch copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "rsQuery");
            Intrinsics.checkNotNullParameter(str2, "passLog");
            Intrinsics.checkNotNullParameter(str3, "thumbUrl");
            return new RelevantSearch(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelevantSearch)) {
                return false;
            }
            RelevantSearch relevantSearch = (RelevantSearch) obj;
            return Intrinsics.areEqual((Object) this.rsQuery, (Object) relevantSearch.rsQuery) && Intrinsics.areEqual((Object) this.passLog, (Object) relevantSearch.passLog) && Intrinsics.areEqual((Object) this.thumbUrl, (Object) relevantSearch.thumbUrl);
        }

        public int hashCode() {
            return (((this.rsQuery.hashCode() * 31) + this.passLog.hashCode()) * 31) + this.thumbUrl.hashCode();
        }

        public String toString() {
            return "RelevantSearch(rsQuery=" + this.rsQuery + ", passLog=" + this.passLog + ", thumbUrl=" + this.thumbUrl + ')';
        }

        public RelevantSearch(String rsQuery2, String passLog2, String thumbUrl2) {
            Intrinsics.checkNotNullParameter(rsQuery2, "rsQuery");
            Intrinsics.checkNotNullParameter(passLog2, "passLog");
            Intrinsics.checkNotNullParameter(thumbUrl2, "thumbUrl");
            this.rsQuery = rsQuery2;
            this.passLog = passLog2;
            this.thumbUrl = thumbUrl2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RelevantSearch(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
        }

        public final String getRsQuery() {
            return this.rsQuery;
        }

        public final void setRsQuery(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.rsQuery = str;
        }

        public final String getPassLog() {
            return this.passLog;
        }

        public final void setPassLog(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.passLog = str;
        }

        public final String getThumbUrl() {
            return this.thumbUrl;
        }

        public final void setThumbUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.thumbUrl = str;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bD\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J©\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001J\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020\u0003HÖ\u0001J\t\u0010O\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\"\"\u0004\b2\u0010$R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018¨\u0006P"}, d2 = {"Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$LogInfo;", "Lcom/baidu/searchbox/NoProGuard;", "naCacheSample", "", "matchCondition", "subject", "", "pu", "tcreq4log", "lid", "applid", "detailfr", "q", "querycate", "stpl", "pd", "tn", "sa", "atn", "frameMod", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplid", "()Ljava/lang/String;", "setApplid", "(Ljava/lang/String;)V", "getAtn", "setAtn", "getDetailfr", "setDetailfr", "getFrameMod", "setFrameMod", "getLid", "setLid", "getMatchCondition", "()I", "setMatchCondition", "(I)V", "getNaCacheSample", "setNaCacheSample", "getPd", "setPd", "getPu", "setPu", "getQ", "setQ", "getQuerycate", "setQuerycate", "getSa", "setSa", "getStpl", "setStpl", "getSubject", "setSubject", "getTcreq4log", "setTcreq4log", "getTn", "setTn", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BigImageBrowserExtraParams.kt */
    public static final class LogInfo implements NoProGuard {
        private String applid;
        private String atn;
        private String detailfr;
        private String frameMod;
        private String lid;
        private int matchCondition;
        private int naCacheSample;
        private String pd;
        private String pu;
        private String q;
        private int querycate;
        private String sa;
        private int stpl;
        private String subject;
        private String tcreq4log;
        private String tn;

        public LogInfo() {
            this(0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 65535, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ LogInfo copy$default(LogInfo logInfo, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i4, int i5, String str8, String str9, String str10, String str11, String str12, int i6, Object obj) {
            LogInfo logInfo2 = logInfo;
            int i7 = i6;
            return logInfo.copy((i7 & 1) != 0 ? logInfo2.naCacheSample : i2, (i7 & 2) != 0 ? logInfo2.matchCondition : i3, (i7 & 4) != 0 ? logInfo2.subject : str, (i7 & 8) != 0 ? logInfo2.pu : str2, (i7 & 16) != 0 ? logInfo2.tcreq4log : str3, (i7 & 32) != 0 ? logInfo2.lid : str4, (i7 & 64) != 0 ? logInfo2.applid : str5, (i7 & 128) != 0 ? logInfo2.detailfr : str6, (i7 & 256) != 0 ? logInfo2.q : str7, (i7 & 512) != 0 ? logInfo2.querycate : i4, (i7 & 1024) != 0 ? logInfo2.stpl : i5, (i7 & 2048) != 0 ? logInfo2.pd : str8, (i7 & 4096) != 0 ? logInfo2.tn : str9, (i7 & 8192) != 0 ? logInfo2.sa : str10, (i7 & 16384) != 0 ? logInfo2.atn : str11, (i7 & 32768) != 0 ? logInfo2.frameMod : str12);
        }

        public final int component1() {
            return this.naCacheSample;
        }

        public final int component10() {
            return this.querycate;
        }

        public final int component11() {
            return this.stpl;
        }

        public final String component12() {
            return this.pd;
        }

        public final String component13() {
            return this.tn;
        }

        public final String component14() {
            return this.sa;
        }

        public final String component15() {
            return this.atn;
        }

        public final String component16() {
            return this.frameMod;
        }

        public final int component2() {
            return this.matchCondition;
        }

        public final String component3() {
            return this.subject;
        }

        public final String component4() {
            return this.pu;
        }

        public final String component5() {
            return this.tcreq4log;
        }

        public final String component6() {
            return this.lid;
        }

        public final String component7() {
            return this.applid;
        }

        public final String component8() {
            return this.detailfr;
        }

        public final String component9() {
            return this.q;
        }

        public final LogInfo copy(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i4, int i5, String str8, String str9, String str10, String str11, String str12) {
            Intrinsics.checkNotNullParameter(str, "subject");
            Intrinsics.checkNotNullParameter(str2, "pu");
            Intrinsics.checkNotNullParameter(str3, "tcreq4log");
            Intrinsics.checkNotNullParameter(str4, "lid");
            Intrinsics.checkNotNullParameter(str5, "applid");
            Intrinsics.checkNotNullParameter(str6, BigImageTcUtilsKt.BIG_IMAGE_EXTRA_DETAILFR);
            Intrinsics.checkNotNullParameter(str7, "q");
            Intrinsics.checkNotNullParameter(str8, "pd");
            Intrinsics.checkNotNullParameter(str9, "tn");
            Intrinsics.checkNotNullParameter(str10, "sa");
            Intrinsics.checkNotNullParameter(str11, "atn");
            Intrinsics.checkNotNullParameter(str12, BigImageTcUtilsKt.BIG_IMAGE_EXTRA_FRAMEMOD);
            return new LogInfo(i2, i3, str, str2, str3, str4, str5, str6, str7, i4, i5, str8, str9, str10, str11, str12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LogInfo)) {
                return false;
            }
            LogInfo logInfo = (LogInfo) obj;
            return this.naCacheSample == logInfo.naCacheSample && this.matchCondition == logInfo.matchCondition && Intrinsics.areEqual((Object) this.subject, (Object) logInfo.subject) && Intrinsics.areEqual((Object) this.pu, (Object) logInfo.pu) && Intrinsics.areEqual((Object) this.tcreq4log, (Object) logInfo.tcreq4log) && Intrinsics.areEqual((Object) this.lid, (Object) logInfo.lid) && Intrinsics.areEqual((Object) this.applid, (Object) logInfo.applid) && Intrinsics.areEqual((Object) this.detailfr, (Object) logInfo.detailfr) && Intrinsics.areEqual((Object) this.q, (Object) logInfo.q) && this.querycate == logInfo.querycate && this.stpl == logInfo.stpl && Intrinsics.areEqual((Object) this.pd, (Object) logInfo.pd) && Intrinsics.areEqual((Object) this.tn, (Object) logInfo.tn) && Intrinsics.areEqual((Object) this.sa, (Object) logInfo.sa) && Intrinsics.areEqual((Object) this.atn, (Object) logInfo.atn) && Intrinsics.areEqual((Object) this.frameMod, (Object) logInfo.frameMod);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((Integer.hashCode(this.naCacheSample) * 31) + Integer.hashCode(this.matchCondition)) * 31) + this.subject.hashCode()) * 31) + this.pu.hashCode()) * 31) + this.tcreq4log.hashCode()) * 31) + this.lid.hashCode()) * 31) + this.applid.hashCode()) * 31) + this.detailfr.hashCode()) * 31) + this.q.hashCode()) * 31) + Integer.hashCode(this.querycate)) * 31) + Integer.hashCode(this.stpl)) * 31) + this.pd.hashCode()) * 31) + this.tn.hashCode()) * 31) + this.sa.hashCode()) * 31) + this.atn.hashCode()) * 31) + this.frameMod.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LogInfo(naCacheSample=").append(this.naCacheSample).append(", matchCondition=").append(this.matchCondition).append(", subject=").append(this.subject).append(", pu=").append(this.pu).append(", tcreq4log=").append(this.tcreq4log).append(", lid=").append(this.lid).append(", applid=").append(this.applid).append(", detailfr=").append(this.detailfr).append(", q=").append(this.q).append(", querycate=").append(this.querycate).append(", stpl=").append(this.stpl).append(", pd=");
            sb.append(this.pd).append(", tn=").append(this.tn).append(", sa=").append(this.sa).append(", atn=").append(this.atn).append(", frameMod=").append(this.frameMod).append(')');
            return sb.toString();
        }

        public LogInfo(int naCacheSample2, int matchCondition2, String subject2, String pu2, String tcreq4log2, String lid2, String applid2, String detailfr2, String q2, int querycate2, int stpl2, String pd2, String tn2, String sa2, String atn2, String frameMod2) {
            String str = subject2;
            String str2 = pu2;
            String str3 = tcreq4log2;
            String str4 = lid2;
            String str5 = applid2;
            String str6 = detailfr2;
            String str7 = q2;
            String str8 = pd2;
            String str9 = tn2;
            String str10 = sa2;
            String str11 = atn2;
            String str12 = frameMod2;
            Intrinsics.checkNotNullParameter(str, "subject");
            Intrinsics.checkNotNullParameter(str2, "pu");
            Intrinsics.checkNotNullParameter(str3, "tcreq4log");
            Intrinsics.checkNotNullParameter(str4, "lid");
            Intrinsics.checkNotNullParameter(str5, "applid");
            Intrinsics.checkNotNullParameter(str6, BigImageTcUtilsKt.BIG_IMAGE_EXTRA_DETAILFR);
            Intrinsics.checkNotNullParameter(str7, "q");
            Intrinsics.checkNotNullParameter(str8, "pd");
            Intrinsics.checkNotNullParameter(str9, "tn");
            Intrinsics.checkNotNullParameter(str10, "sa");
            Intrinsics.checkNotNullParameter(str11, "atn");
            Intrinsics.checkNotNullParameter(str12, BigImageTcUtilsKt.BIG_IMAGE_EXTRA_FRAMEMOD);
            this.naCacheSample = naCacheSample2;
            this.matchCondition = matchCondition2;
            this.subject = str;
            this.pu = str2;
            this.tcreq4log = str3;
            this.lid = str4;
            this.applid = str5;
            this.detailfr = str6;
            this.q = str7;
            this.querycate = querycate2;
            this.stpl = stpl2;
            this.pd = str8;
            this.tn = str9;
            this.sa = str10;
            this.atn = str11;
            this.frameMod = str12;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ LogInfo(int r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, int r27, int r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
            /*
                r17 = this;
                r0 = r34
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r1 = r2
                goto L_0x000b
            L_0x0009:
                r1 = r18
            L_0x000b:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0011
                r3 = r2
                goto L_0x0013
            L_0x0011:
                r3 = r19
            L_0x0013:
                r4 = r0 & 4
                java.lang.String r5 = ""
                if (r4 == 0) goto L_0x001b
                r4 = r5
                goto L_0x001d
            L_0x001b:
                r4 = r20
            L_0x001d:
                r6 = r0 & 8
                if (r6 == 0) goto L_0x0023
                r6 = r5
                goto L_0x0025
            L_0x0023:
                r6 = r21
            L_0x0025:
                r7 = r0 & 16
                if (r7 == 0) goto L_0x002c
                java.lang.String r7 = "1"
                goto L_0x002e
            L_0x002c:
                r7 = r22
            L_0x002e:
                r8 = r0 & 32
                if (r8 == 0) goto L_0x0034
                r8 = r5
                goto L_0x0036
            L_0x0034:
                r8 = r23
            L_0x0036:
                r9 = r0 & 64
                if (r9 == 0) goto L_0x003c
                r9 = r5
                goto L_0x003e
            L_0x003c:
                r9 = r24
            L_0x003e:
                r10 = r0 & 128(0x80, float:1.794E-43)
                if (r10 == 0) goto L_0x0044
                r10 = r5
                goto L_0x0046
            L_0x0044:
                r10 = r25
            L_0x0046:
                r11 = r0 & 256(0x100, float:3.59E-43)
                if (r11 == 0) goto L_0x004c
                r11 = r5
                goto L_0x004e
            L_0x004c:
                r11 = r26
            L_0x004e:
                r12 = r0 & 512(0x200, float:7.175E-43)
                if (r12 == 0) goto L_0x0054
                r12 = r2
                goto L_0x0056
            L_0x0054:
                r12 = r27
            L_0x0056:
                r13 = r0 & 1024(0x400, float:1.435E-42)
                if (r13 == 0) goto L_0x005b
                goto L_0x005d
            L_0x005b:
                r2 = r28
            L_0x005d:
                r13 = r0 & 2048(0x800, float:2.87E-42)
                if (r13 == 0) goto L_0x0065
                java.lang.String r13 = "image_content"
                goto L_0x0067
            L_0x0065:
                r13 = r29
            L_0x0067:
                r14 = r0 & 4096(0x1000, float:5.74E-42)
                if (r14 == 0) goto L_0x006d
                r14 = r5
                goto L_0x006f
            L_0x006d:
                r14 = r30
            L_0x006f:
                r15 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r15 == 0) goto L_0x0075
                r15 = r5
                goto L_0x0077
            L_0x0075:
                r15 = r31
            L_0x0077:
                r18 = r5
                r5 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r5 == 0) goto L_0x0080
                r5 = r18
                goto L_0x0082
            L_0x0080:
                r5 = r32
            L_0x0082:
                r16 = 32768(0x8000, float:4.5918E-41)
                r0 = r0 & r16
                if (r0 == 0) goto L_0x008c
                r0 = r18
                goto L_0x008e
            L_0x008c:
                r0 = r33
            L_0x008e:
                r18 = r1
                r19 = r3
                r20 = r4
                r21 = r6
                r22 = r7
                r23 = r8
                r24 = r9
                r25 = r10
                r26 = r11
                r27 = r12
                r28 = r2
                r29 = r13
                r30 = r14
                r31 = r15
                r32 = r5
                r33 = r0
                r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams.LogInfo.<init>(int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final int getNaCacheSample() {
            return this.naCacheSample;
        }

        public final void setNaCacheSample(int i2) {
            this.naCacheSample = i2;
        }

        public final int getMatchCondition() {
            return this.matchCondition;
        }

        public final void setMatchCondition(int i2) {
            this.matchCondition = i2;
        }

        public final String getSubject() {
            return this.subject;
        }

        public final void setSubject(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subject = str;
        }

        public final String getPu() {
            return this.pu;
        }

        public final void setPu(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pu = str;
        }

        public final String getTcreq4log() {
            return this.tcreq4log;
        }

        public final void setTcreq4log(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tcreq4log = str;
        }

        public final String getLid() {
            return this.lid;
        }

        public final void setLid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lid = str;
        }

        public final String getApplid() {
            return this.applid;
        }

        public final void setApplid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.applid = str;
        }

        public final String getDetailfr() {
            return this.detailfr;
        }

        public final void setDetailfr(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.detailfr = str;
        }

        public final String getQ() {
            return this.q;
        }

        public final void setQ(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.q = str;
        }

        public final int getQuerycate() {
            return this.querycate;
        }

        public final void setQuerycate(int i2) {
            this.querycate = i2;
        }

        public final int getStpl() {
            return this.stpl;
        }

        public final void setStpl(int i2) {
            this.stpl = i2;
        }

        public final String getPd() {
            return this.pd;
        }

        public final void setPd(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pd = str;
        }

        public final String getTn() {
            return this.tn;
        }

        public final void setTn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tn = str;
        }

        public final String getSa() {
            return this.sa;
        }

        public final void setSa(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sa = str;
        }

        public final String getAtn() {
            return this.atn;
        }

        public final void setAtn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.atn = str;
        }

        public final String getFrameMod() {
            return this.frameMod;
        }

        public final void setFrameMod(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.frameMod = str;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$PicRecognizeInfo;", "", "tips", "", "category", "", "preClickExpiresTime", "", "clickedExpiresTime", "(Ljava/lang/String;IJJ)V", "getCategory", "()I", "getClickedExpiresTime", "()J", "getPreClickExpiresTime", "getTips", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BigImageBrowserExtraParams.kt */
    public static final class PicRecognizeInfo {
        private final int category;
        private final long clickedExpiresTime;
        private final long preClickExpiresTime;
        private final String tips;

        public static /* synthetic */ PicRecognizeInfo copy$default(PicRecognizeInfo picRecognizeInfo, String str, int i2, long j2, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = picRecognizeInfo.tips;
            }
            if ((i3 & 2) != 0) {
                i2 = picRecognizeInfo.category;
            }
            int i4 = i2;
            if ((i3 & 4) != 0) {
                j2 = picRecognizeInfo.preClickExpiresTime;
            }
            long j4 = j2;
            if ((i3 & 8) != 0) {
                j3 = picRecognizeInfo.clickedExpiresTime;
            }
            return picRecognizeInfo.copy(str, i4, j4, j3);
        }

        public final String component1() {
            return this.tips;
        }

        public final int component2() {
            return this.category;
        }

        public final long component3() {
            return this.preClickExpiresTime;
        }

        public final long component4() {
            return this.clickedExpiresTime;
        }

        public final PicRecognizeInfo copy(String str, int i2, long j2, long j3) {
            Intrinsics.checkNotNullParameter(str, "tips");
            return new PicRecognizeInfo(str, i2, j2, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PicRecognizeInfo)) {
                return false;
            }
            PicRecognizeInfo picRecognizeInfo = (PicRecognizeInfo) obj;
            return Intrinsics.areEqual((Object) this.tips, (Object) picRecognizeInfo.tips) && this.category == picRecognizeInfo.category && this.preClickExpiresTime == picRecognizeInfo.preClickExpiresTime && this.clickedExpiresTime == picRecognizeInfo.clickedExpiresTime;
        }

        public int hashCode() {
            return (((((this.tips.hashCode() * 31) + Integer.hashCode(this.category)) * 31) + Long.hashCode(this.preClickExpiresTime)) * 31) + Long.hashCode(this.clickedExpiresTime);
        }

        public String toString() {
            return "PicRecognizeInfo(tips=" + this.tips + ", category=" + this.category + ", preClickExpiresTime=" + this.preClickExpiresTime + ", clickedExpiresTime=" + this.clickedExpiresTime + ')';
        }

        public PicRecognizeInfo(String tips2, int category2, long preClickExpiresTime2, long clickedExpiresTime2) {
            Intrinsics.checkNotNullParameter(tips2, "tips");
            this.tips = tips2;
            this.category = category2;
            this.preClickExpiresTime = preClickExpiresTime2;
            this.clickedExpiresTime = clickedExpiresTime2;
        }

        public final String getTips() {
            return this.tips;
        }

        public final int getCategory() {
            return this.category;
        }

        public final long getPreClickExpiresTime() {
            return this.preClickExpiresTime;
        }

        public final long getClickedExpiresTime() {
            return this.clickedExpiresTime;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams$Companion;", "", "()V", "IMAGE_PREVIEW_NONE", "", "IMAGE_PREVIEW_WALLPAPER", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BigImageBrowserExtraParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
