package com.baidu.searchbox.flowvideo.similarcollection.api;

import androidx.collection.ArrayMap;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.flowvideo.detail.api.AssetBean;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bë\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0011HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003Jï\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÆ\u0001J\u0013\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010)\u001a\u0004\u0018\u0001HV\"\u0004\b\u0000\u0010V2\u0006\u0010W\u001a\u00020\u0003¢\u0006\u0002\u0010XJ\t\u0010Y\u001a\u00020\u0011HÖ\u0001J\u0018\u0010Z\u001a\u00020[2\u0006\u0010W\u001a\u00020\u00032\b\u0010\\\u001a\u0004\u0018\u00010\u0019J\t\u0010]\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010$R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010$R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001f¨\u0006^"}, d2 = {"Lcom/baidu/searchbox/flowvideo/similarcollection/api/SimilarCollectionItemDataBean;", "Lcom/baidu/searchbox/NoProGuard;", "videoWidth", "", "videoHeight", "resourceType", "title", "playCnt", "videoInfo", "videoSeries", "Lcom/baidu/searchbox/video/plugin/videoplayer/model/BdVideoSeries;", "prefetch", "ext", "extRequest", "searchExtLog", "timeLength", "position", "", "poster", "stateLabel", "actionType", "cmdStr", "collCmdStr", "extData", "Landroidx/collection/ArrayMap;", "", "collId", "asset", "Lcom/baidu/searchbox/flowvideo/detail/api/AssetBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/video/plugin/videoplayer/model/BdVideoSeries;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/collection/ArrayMap;Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/detail/api/AssetBean;)V", "getActionType", "()Ljava/lang/String;", "getAsset", "()Lcom/baidu/searchbox/flowvideo/detail/api/AssetBean;", "getCmdStr", "setCmdStr", "(Ljava/lang/String;)V", "getCollCmdStr", "setCollCmdStr", "getCollId", "getExt", "getExtData", "()Landroidx/collection/ArrayMap;", "getExtRequest", "getPlayCnt", "getPosition", "()I", "getPoster", "getPrefetch", "getResourceType", "getSearchExtLog", "getStateLabel", "getTimeLength", "getTitle", "getVideoHeight", "getVideoInfo", "getVideoSeries", "()Lcom/baidu/searchbox/video/plugin/videoplayer/model/BdVideoSeries;", "setVideoSeries", "(Lcom/baidu/searchbox/video/plugin/videoplayer/model/BdVideoSeries;)V", "getVideoWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "hashCode", "putExtData", "", "data", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimilarCollectionListBean.kt */
public final class SimilarCollectionItemDataBean implements NoProGuard {
    private final String actionType;
    private final AssetBean asset;
    private String cmdStr;
    private String collCmdStr;
    private final String collId;
    private final String ext;
    private final transient ArrayMap<String, Object> extData;
    private final String extRequest;
    private final String playCnt;
    private final int position;
    private final String poster;
    private final String prefetch;
    private final String resourceType;
    private final String searchExtLog;
    private final String stateLabel;
    private final String timeLength;
    private final String title;
    private final String videoHeight;
    private final String videoInfo;
    private BdVideoSeries videoSeries;
    private final String videoWidth;

    public SimilarCollectionItemDataBean() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (BdVideoSeries) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayMap) null, (String) null, (AssetBean) null, 2097151, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SimilarCollectionItemDataBean copy$default(SimilarCollectionItemDataBean similarCollectionItemDataBean, String str, String str2, String str3, String str4, String str5, String str6, BdVideoSeries bdVideoSeries, String str7, String str8, String str9, String str10, String str11, int i2, String str12, String str13, String str14, String str15, String str16, ArrayMap arrayMap, String str17, AssetBean assetBean, int i3, Object obj) {
        SimilarCollectionItemDataBean similarCollectionItemDataBean2 = similarCollectionItemDataBean;
        int i4 = i3;
        return similarCollectionItemDataBean.copy((i4 & 1) != 0 ? similarCollectionItemDataBean2.videoWidth : str, (i4 & 2) != 0 ? similarCollectionItemDataBean2.videoHeight : str2, (i4 & 4) != 0 ? similarCollectionItemDataBean2.resourceType : str3, (i4 & 8) != 0 ? similarCollectionItemDataBean2.title : str4, (i4 & 16) != 0 ? similarCollectionItemDataBean2.playCnt : str5, (i4 & 32) != 0 ? similarCollectionItemDataBean2.videoInfo : str6, (i4 & 64) != 0 ? similarCollectionItemDataBean2.videoSeries : bdVideoSeries, (i4 & 128) != 0 ? similarCollectionItemDataBean2.prefetch : str7, (i4 & 256) != 0 ? similarCollectionItemDataBean2.ext : str8, (i4 & 512) != 0 ? similarCollectionItemDataBean2.extRequest : str9, (i4 & 1024) != 0 ? similarCollectionItemDataBean2.searchExtLog : str10, (i4 & 2048) != 0 ? similarCollectionItemDataBean2.timeLength : str11, (i4 & 4096) != 0 ? similarCollectionItemDataBean2.position : i2, (i4 & 8192) != 0 ? similarCollectionItemDataBean2.poster : str12, (i4 & 16384) != 0 ? similarCollectionItemDataBean2.stateLabel : str13, (i4 & 32768) != 0 ? similarCollectionItemDataBean2.actionType : str14, (i4 & 65536) != 0 ? similarCollectionItemDataBean2.cmdStr : str15, (i4 & 131072) != 0 ? similarCollectionItemDataBean2.collCmdStr : str16, (i4 & 262144) != 0 ? similarCollectionItemDataBean2.extData : arrayMap, (i4 & 524288) != 0 ? similarCollectionItemDataBean2.collId : str17, (i4 & 1048576) != 0 ? similarCollectionItemDataBean2.asset : assetBean);
    }

    public final String component1() {
        return this.videoWidth;
    }

    public final String component10() {
        return this.extRequest;
    }

    public final String component11() {
        return this.searchExtLog;
    }

    public final String component12() {
        return this.timeLength;
    }

    public final int component13() {
        return this.position;
    }

    public final String component14() {
        return this.poster;
    }

    public final String component15() {
        return this.stateLabel;
    }

    public final String component16() {
        return this.actionType;
    }

    public final String component17() {
        return this.cmdStr;
    }

    public final String component18() {
        return this.collCmdStr;
    }

    public final ArrayMap<String, Object> component19() {
        return this.extData;
    }

    public final String component2() {
        return this.videoHeight;
    }

    public final String component20() {
        return this.collId;
    }

    public final AssetBean component21() {
        return this.asset;
    }

    public final String component3() {
        return this.resourceType;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.playCnt;
    }

    public final String component6() {
        return this.videoInfo;
    }

    public final BdVideoSeries component7() {
        return this.videoSeries;
    }

    public final String component8() {
        return this.prefetch;
    }

    public final String component9() {
        return this.ext;
    }

    public final SimilarCollectionItemDataBean copy(String str, String str2, String str3, String str4, String str5, String str6, BdVideoSeries bdVideoSeries, String str7, String str8, String str9, String str10, String str11, int i2, String str12, String str13, String str14, String str15, String str16, ArrayMap<String, Object> arrayMap, String str17, AssetBean assetBean) {
        String str18 = str;
        Intrinsics.checkNotNullParameter(str18, IntentData.Protocol.KEY_VIDEO_WIDTH);
        Intrinsics.checkNotNullParameter(str2, IntentData.Protocol.KEY_VIDEO_HEIGHT);
        Intrinsics.checkNotNullParameter(str3, "resourceType");
        Intrinsics.checkNotNullParameter(str4, "title");
        Intrinsics.checkNotNullParameter(str5, "playCnt");
        Intrinsics.checkNotNullParameter(str6, "videoInfo");
        Intrinsics.checkNotNullParameter(str7, "prefetch");
        Intrinsics.checkNotNullParameter(str8, "ext");
        Intrinsics.checkNotNullParameter(str9, IntentData.Protocol.KEY_EXT_REQUEST);
        Intrinsics.checkNotNullParameter(str10, "searchExtLog");
        Intrinsics.checkNotNullParameter(str11, "timeLength");
        Intrinsics.checkNotNullParameter(str12, "poster");
        Intrinsics.checkNotNullParameter(str13, "stateLabel");
        Intrinsics.checkNotNullParameter(str14, "actionType");
        Intrinsics.checkNotNullParameter(arrayMap, "extData");
        Intrinsics.checkNotNullParameter(str17, "collId");
        return new SimilarCollectionItemDataBean(str18, str2, str3, str4, str5, str6, bdVideoSeries, str7, str8, str9, str10, str11, i2, str12, str13, str14, str15, str16, arrayMap, str17, assetBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimilarCollectionItemDataBean)) {
            return false;
        }
        SimilarCollectionItemDataBean similarCollectionItemDataBean = (SimilarCollectionItemDataBean) obj;
        return Intrinsics.areEqual((Object) this.videoWidth, (Object) similarCollectionItemDataBean.videoWidth) && Intrinsics.areEqual((Object) this.videoHeight, (Object) similarCollectionItemDataBean.videoHeight) && Intrinsics.areEqual((Object) this.resourceType, (Object) similarCollectionItemDataBean.resourceType) && Intrinsics.areEqual((Object) this.title, (Object) similarCollectionItemDataBean.title) && Intrinsics.areEqual((Object) this.playCnt, (Object) similarCollectionItemDataBean.playCnt) && Intrinsics.areEqual((Object) this.videoInfo, (Object) similarCollectionItemDataBean.videoInfo) && Intrinsics.areEqual((Object) this.videoSeries, (Object) similarCollectionItemDataBean.videoSeries) && Intrinsics.areEqual((Object) this.prefetch, (Object) similarCollectionItemDataBean.prefetch) && Intrinsics.areEqual((Object) this.ext, (Object) similarCollectionItemDataBean.ext) && Intrinsics.areEqual((Object) this.extRequest, (Object) similarCollectionItemDataBean.extRequest) && Intrinsics.areEqual((Object) this.searchExtLog, (Object) similarCollectionItemDataBean.searchExtLog) && Intrinsics.areEqual((Object) this.timeLength, (Object) similarCollectionItemDataBean.timeLength) && this.position == similarCollectionItemDataBean.position && Intrinsics.areEqual((Object) this.poster, (Object) similarCollectionItemDataBean.poster) && Intrinsics.areEqual((Object) this.stateLabel, (Object) similarCollectionItemDataBean.stateLabel) && Intrinsics.areEqual((Object) this.actionType, (Object) similarCollectionItemDataBean.actionType) && Intrinsics.areEqual((Object) this.cmdStr, (Object) similarCollectionItemDataBean.cmdStr) && Intrinsics.areEqual((Object) this.collCmdStr, (Object) similarCollectionItemDataBean.collCmdStr) && Intrinsics.areEqual((Object) this.extData, (Object) similarCollectionItemDataBean.extData) && Intrinsics.areEqual((Object) this.collId, (Object) similarCollectionItemDataBean.collId) && Intrinsics.areEqual((Object) this.asset, (Object) similarCollectionItemDataBean.asset);
    }

    public int hashCode() {
        int hashCode = ((((((((((this.videoWidth.hashCode() * 31) + this.videoHeight.hashCode()) * 31) + this.resourceType.hashCode()) * 31) + this.title.hashCode()) * 31) + this.playCnt.hashCode()) * 31) + this.videoInfo.hashCode()) * 31;
        BdVideoSeries bdVideoSeries = this.videoSeries;
        int i2 = 0;
        int hashCode2 = (((((((((((((((((((hashCode + (bdVideoSeries == null ? 0 : bdVideoSeries.hashCode())) * 31) + this.prefetch.hashCode()) * 31) + this.ext.hashCode()) * 31) + this.extRequest.hashCode()) * 31) + this.searchExtLog.hashCode()) * 31) + this.timeLength.hashCode()) * 31) + Integer.hashCode(this.position)) * 31) + this.poster.hashCode()) * 31) + this.stateLabel.hashCode()) * 31) + this.actionType.hashCode()) * 31;
        String str = this.cmdStr;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.collCmdStr;
        int hashCode4 = (((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.extData.hashCode()) * 31) + this.collId.hashCode()) * 31;
        AssetBean assetBean = this.asset;
        if (assetBean != null) {
            i2 = assetBean.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SimilarCollectionItemDataBean(videoWidth=").append(this.videoWidth).append(", videoHeight=").append(this.videoHeight).append(", resourceType=").append(this.resourceType).append(", title=").append(this.title).append(", playCnt=").append(this.playCnt).append(", videoInfo=").append(this.videoInfo).append(", videoSeries=").append(this.videoSeries).append(", prefetch=").append(this.prefetch).append(", ext=").append(this.ext).append(", extRequest=").append(this.extRequest).append(", searchExtLog=").append(this.searchExtLog).append(", timeLength=");
        sb.append(this.timeLength).append(", position=").append(this.position).append(", poster=").append(this.poster).append(", stateLabel=").append(this.stateLabel).append(", actionType=").append(this.actionType).append(", cmdStr=").append(this.cmdStr).append(", collCmdStr=").append(this.collCmdStr).append(", extData=").append(this.extData).append(", collId=").append(this.collId).append(", asset=").append(this.asset).append(')');
        return sb.toString();
    }

    public SimilarCollectionItemDataBean(String videoWidth2, String videoHeight2, String resourceType2, String title2, String playCnt2, String videoInfo2, BdVideoSeries videoSeries2, String prefetch2, String ext2, String extRequest2, String searchExtLog2, String timeLength2, int position2, String poster2, String stateLabel2, String actionType2, String cmdStr2, String collCmdStr2, ArrayMap<String, Object> extData2, String collId2, AssetBean asset2) {
        String str = videoWidth2;
        String str2 = videoHeight2;
        String str3 = resourceType2;
        String str4 = title2;
        String str5 = playCnt2;
        String str6 = videoInfo2;
        String str7 = prefetch2;
        String str8 = ext2;
        String str9 = extRequest2;
        String str10 = searchExtLog2;
        String str11 = timeLength2;
        String str12 = poster2;
        String str13 = stateLabel2;
        String str14 = actionType2;
        String str15 = collId2;
        Intrinsics.checkNotNullParameter(str, IntentData.Protocol.KEY_VIDEO_WIDTH);
        Intrinsics.checkNotNullParameter(str2, IntentData.Protocol.KEY_VIDEO_HEIGHT);
        Intrinsics.checkNotNullParameter(str3, "resourceType");
        Intrinsics.checkNotNullParameter(str4, "title");
        Intrinsics.checkNotNullParameter(str5, "playCnt");
        Intrinsics.checkNotNullParameter(str6, "videoInfo");
        Intrinsics.checkNotNullParameter(str7, "prefetch");
        Intrinsics.checkNotNullParameter(str8, "ext");
        Intrinsics.checkNotNullParameter(str9, IntentData.Protocol.KEY_EXT_REQUEST);
        Intrinsics.checkNotNullParameter(str10, "searchExtLog");
        Intrinsics.checkNotNullParameter(str11, "timeLength");
        Intrinsics.checkNotNullParameter(str12, "poster");
        Intrinsics.checkNotNullParameter(str13, "stateLabel");
        Intrinsics.checkNotNullParameter(str14, "actionType");
        Intrinsics.checkNotNullParameter(extData2, "extData");
        String str16 = collId2;
        Intrinsics.checkNotNullParameter(str16, "collId");
        this.videoWidth = str;
        this.videoHeight = str2;
        this.resourceType = str3;
        this.title = str4;
        this.playCnt = str5;
        this.videoInfo = str6;
        this.videoSeries = videoSeries2;
        this.prefetch = str7;
        this.ext = str8;
        this.extRequest = str9;
        this.searchExtLog = str10;
        this.timeLength = str11;
        this.position = position2;
        this.poster = str12;
        this.stateLabel = str13;
        this.actionType = str14;
        this.cmdStr = cmdStr2;
        this.collCmdStr = collCmdStr2;
        this.extData = extData2;
        this.collId = str16;
        this.asset = asset2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SimilarCollectionItemDataBean(java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, int r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, androidx.collection.ArrayMap r41, java.lang.String r42, com.baidu.searchbox.flowvideo.detail.api.AssetBean r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
        /*
            r22 = this;
            r0 = r44
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r23
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r24
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r25
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r26
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r2
            goto L_0x002c
        L_0x002a:
            r6 = r27
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            r7 = r2
            goto L_0x0034
        L_0x0032:
            r7 = r28
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = 0
            goto L_0x003c
        L_0x003a:
            r8 = r29
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r2
            goto L_0x0044
        L_0x0042:
            r10 = r30
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = r2
            goto L_0x004c
        L_0x004a:
            r11 = r31
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = r2
            goto L_0x0054
        L_0x0052:
            r12 = r32
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = r2
            goto L_0x005c
        L_0x005a:
            r13 = r33
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = r2
            goto L_0x0064
        L_0x0062:
            r14 = r34
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006a
            r15 = -1
            goto L_0x006c
        L_0x006a:
            r15 = r35
        L_0x006c:
            r9 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x0072
            r9 = r2
            goto L_0x0074
        L_0x0072:
            r9 = r36
        L_0x0074:
            r45 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007d
            r2 = r45
            goto L_0x007f
        L_0x007d:
            r2 = r37
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0089
            r16 = r45
            goto L_0x008b
        L_0x0089:
            r16 = r38
        L_0x008b:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0094
            r17 = 0
            goto L_0x0096
        L_0x0094:
            r17 = r39
        L_0x0096:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009f
            r18 = 0
            goto L_0x00a1
        L_0x009f:
            r18 = r40
        L_0x00a1:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00ad
            androidx.collection.ArrayMap r19 = new androidx.collection.ArrayMap
            r19.<init>()
            goto L_0x00af
        L_0x00ad:
            r19 = r41
        L_0x00af:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b8
            r20 = r45
            goto L_0x00ba
        L_0x00b8:
            r20 = r42
        L_0x00ba:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r21
            if (r0 == 0) goto L_0x00c2
            r0 = 0
            goto L_0x00c4
        L_0x00c2:
            r0 = r43
        L_0x00c4:
            r23 = r1
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r6
            r28 = r7
            r29 = r8
            r30 = r10
            r31 = r11
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r15
            r36 = r9
            r37 = r2
            r38 = r16
            r39 = r17
            r40 = r18
            r41 = r19
            r42 = r20
            r43 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.flowvideo.similarcollection.api.SimilarCollectionItemDataBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, androidx.collection.ArrayMap, java.lang.String, com.baidu.searchbox.flowvideo.detail.api.AssetBean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getVideoWidth() {
        return this.videoWidth;
    }

    public final String getVideoHeight() {
        return this.videoHeight;
    }

    public final String getResourceType() {
        return this.resourceType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getPlayCnt() {
        return this.playCnt;
    }

    public final String getVideoInfo() {
        return this.videoInfo;
    }

    public final BdVideoSeries getVideoSeries() {
        return this.videoSeries;
    }

    public final void setVideoSeries(BdVideoSeries bdVideoSeries) {
        this.videoSeries = bdVideoSeries;
    }

    public final String getPrefetch() {
        return this.prefetch;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getExtRequest() {
        return this.extRequest;
    }

    public final String getSearchExtLog() {
        return this.searchExtLog;
    }

    public final String getTimeLength() {
        return this.timeLength;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getPoster() {
        return this.poster;
    }

    public final String getStateLabel() {
        return this.stateLabel;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getCmdStr() {
        return this.cmdStr;
    }

    public final void setCmdStr(String str) {
        this.cmdStr = str;
    }

    public final String getCollCmdStr() {
        return this.collCmdStr;
    }

    public final void setCollCmdStr(String str) {
        this.collCmdStr = str;
    }

    public final ArrayMap<String, Object> getExtData() {
        return this.extData;
    }

    public final String getCollId() {
        return this.collId;
    }

    public final AssetBean getAsset() {
        return this.asset;
    }

    public final <T> T getExtData(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.extData.get(key);
    }

    public final void putExtData(String key, Object data) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!StringsKt.isBlank(key) && data != null) {
            this.extData.put(key, data);
        }
    }
}
