package com.baidu.searchbox.flowvideo.detail.repos;

import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.video.feedflow.flow.tts.VideoFlowTtsDataProviderFactory;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bJ\n\u0002\u0010\u0000\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B©\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\b\b\u0002\u0010$\u001a\u00020\n\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010&\u001a\u00020\n¢\u0006\u0002\u0010'J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\nHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010S\u001a\u00020\nHÆ\u0003J\t\u0010T\u001a\u00020\nHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010V\u001a\u00020\nHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020!HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\nHÆ\u0003J\t\u0010_\u001a\u00020\nHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010a\u001a\u00020\nHÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J!\u0010c\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\bHÆ\u0003J\t\u0010d\u001a\u00020\nHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010g\u001a\u00020\nHÆ\u0003J\t\u0010h\u001a\u00020\nHÆ\u0003J­\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010&\u001a\u00020\nHÆ\u0001J\u0013\u0010j\u001a\u00020!2\b\u0010k\u001a\u0004\u0018\u00010lHÖ\u0003J\t\u0010m\u001a\u00020\u0003HÖ\u0001J\u0006\u0010n\u001a\u00020!J\u0006\u0010o\u001a\u00020!J\u0006\u0010p\u001a\u00020!J\u0006\u0010q\u001a\u00020!J\u0006\u0010r\u001a\u00020!J\u0006\u0010s\u001a\u00020!J\u0006\u0010t\u001a\u00020!J\t\u0010u\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010%\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010$\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0011\u0010&\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0011\u0010#\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R2\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bG\u0010+R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bH\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u00101R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006v"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailConfigModel;", "Lcom/baidu/searchbox/NoProGuard;", "showHighLightText", "", "hitLiveComponent", "horizontalPlayerBtnSwitch", "playerBtn", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "residenceTime", "", "thirdLog", "Lcom/baidu/searchbox/flowvideo/detail/repos/ThirdLogModel;", "recommendNextContentCard", "Lcom/baidu/searchbox/flowvideo/detail/repos/RecommendNextContentModel;", "hotComment", "middlePageLandscapeSwitch", "rumorIcon", "relateModel", "Lcom/baidu/searchbox/flowvideo/detail/repos/RelateModel;", "commentSlide", "liveGuideAttentionSwitch", "noScaleIntervene", "recommendReason", "celebrityRecognitionConfig", "Lcom/baidu/searchbox/flowvideo/detail/repos/CelebrityRecognitionConfigModel;", "labelMountPolicy", "Lcom/baidu/searchbox/flowvideo/detail/repos/LabelMountPolicyModel;", "homeMiddlePage", "Lcom/baidu/searchbox/flowvideo/detail/repos/HomeMiddlePageModel;", "followArouse", "Lcom/baidu/searchbox/flowvideo/detail/repos/FollowArouseModel;", "showWealthDialog", "", "newDislike", "newDislikeInteractionMode", "goodsCardStyle", "commentVideoShare", "loop", "(IIILjava/util/ArrayList;Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/detail/repos/ThirdLogModel;Lcom/baidu/searchbox/flowvideo/detail/repos/RecommendNextContentModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/detail/repos/RelateModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/detail/repos/CelebrityRecognitionConfigModel;Lcom/baidu/searchbox/flowvideo/detail/repos/LabelMountPolicyModel;Lcom/baidu/searchbox/flowvideo/detail/repos/HomeMiddlePageModel;Lcom/baidu/searchbox/flowvideo/detail/repos/FollowArouseModel;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCelebrityRecognitionConfig", "()Lcom/baidu/searchbox/flowvideo/detail/repos/CelebrityRecognitionConfigModel;", "getCommentSlide", "()Ljava/lang/String;", "getCommentVideoShare", "getFollowArouse", "()Lcom/baidu/searchbox/flowvideo/detail/repos/FollowArouseModel;", "getGoodsCardStyle", "getHitLiveComponent", "()I", "getHomeMiddlePage", "()Lcom/baidu/searchbox/flowvideo/detail/repos/HomeMiddlePageModel;", "getHorizontalPlayerBtnSwitch", "getHotComment", "getLabelMountPolicy", "()Lcom/baidu/searchbox/flowvideo/detail/repos/LabelMountPolicyModel;", "getLiveGuideAttentionSwitch", "getLoop", "getMiddlePageLandscapeSwitch", "getNewDislike", "getNewDislikeInteractionMode", "getNoScaleIntervene", "getPlayerBtn", "()Ljava/util/ArrayList;", "setPlayerBtn", "(Ljava/util/ArrayList;)V", "getRecommendNextContentCard", "()Lcom/baidu/searchbox/flowvideo/detail/repos/RecommendNextContentModel;", "getRecommendReason", "getRelateModel", "()Lcom/baidu/searchbox/flowvideo/detail/repos/RelateModel;", "getResidenceTime", "getRumorIcon", "getShowHighLightText", "getShowWealthDialog", "()Z", "getThirdLog", "()Lcom/baidu/searchbox/flowvideo/detail/repos/ThirdLogModel;", "setThirdLog", "(Lcom/baidu/searchbox/flowvideo/detail/repos/ThirdLogModel;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "isDirectlyDisplayNewDislike", "isForceLoop", "isMiddlePageLandscapeEnable", "isNewDislikeStyle", "isShowHighLight", "isShowLiveBanner", "isShowLiveFollowGuide", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class FlowDetailConfigModel implements NoProGuard {
    private final CelebrityRecognitionConfigModel celebrityRecognitionConfig;
    private final String commentSlide;
    private final String commentVideoShare;
    private final FollowArouseModel followArouse;
    private final String goodsCardStyle;
    private final int hitLiveComponent;
    private final HomeMiddlePageModel homeMiddlePage;
    private final int horizontalPlayerBtnSwitch;
    private final String hotComment;
    private final LabelMountPolicyModel labelMountPolicy;
    private final String liveGuideAttentionSwitch;
    private final String loop;
    private final String middlePageLandscapeSwitch;
    private final int newDislike;
    private final String newDislikeInteractionMode;
    private final String noScaleIntervene;
    private ArrayList<Integer> playerBtn;
    private final RecommendNextContentModel recommendNextContentCard;
    private final String recommendReason;
    private final RelateModel relateModel;
    private final String residenceTime;
    private final String rumorIcon;
    private final int showHighLightText;
    private final boolean showWealthDialog;
    private ThirdLogModel thirdLog;

    public FlowDetailConfigModel() {
        this(0, 0, 0, (ArrayList) null, (String) null, (ThirdLogModel) null, (RecommendNextContentModel) null, (String) null, (String) null, (String) null, (RelateModel) null, (String) null, (String) null, (String) null, (String) null, (CelebrityRecognitionConfigModel) null, (LabelMountPolicyModel) null, (HomeMiddlePageModel) null, (FollowArouseModel) null, false, 0, (String) null, (String) null, (String) null, (String) null, 33554431, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlowDetailConfigModel copy$default(FlowDetailConfigModel flowDetailConfigModel, int i2, int i3, int i4, ArrayList arrayList, String str, ThirdLogModel thirdLogModel, RecommendNextContentModel recommendNextContentModel, String str2, String str3, String str4, RelateModel relateModel2, String str5, String str6, String str7, String str8, CelebrityRecognitionConfigModel celebrityRecognitionConfigModel, LabelMountPolicyModel labelMountPolicyModel, HomeMiddlePageModel homeMiddlePageModel, FollowArouseModel followArouseModel, boolean z, int i5, String str9, String str10, String str11, String str12, int i6, Object obj) {
        FlowDetailConfigModel flowDetailConfigModel2 = flowDetailConfigModel;
        int i7 = i6;
        return flowDetailConfigModel.copy((i7 & 1) != 0 ? flowDetailConfigModel2.showHighLightText : i2, (i7 & 2) != 0 ? flowDetailConfigModel2.hitLiveComponent : i3, (i7 & 4) != 0 ? flowDetailConfigModel2.horizontalPlayerBtnSwitch : i4, (i7 & 8) != 0 ? flowDetailConfigModel2.playerBtn : arrayList, (i7 & 16) != 0 ? flowDetailConfigModel2.residenceTime : str, (i7 & 32) != 0 ? flowDetailConfigModel2.thirdLog : thirdLogModel, (i7 & 64) != 0 ? flowDetailConfigModel2.recommendNextContentCard : recommendNextContentModel, (i7 & 128) != 0 ? flowDetailConfigModel2.hotComment : str2, (i7 & 256) != 0 ? flowDetailConfigModel2.middlePageLandscapeSwitch : str3, (i7 & 512) != 0 ? flowDetailConfigModel2.rumorIcon : str4, (i7 & 1024) != 0 ? flowDetailConfigModel2.relateModel : relateModel2, (i7 & 2048) != 0 ? flowDetailConfigModel2.commentSlide : str5, (i7 & 4096) != 0 ? flowDetailConfigModel2.liveGuideAttentionSwitch : str6, (i7 & 8192) != 0 ? flowDetailConfigModel2.noScaleIntervene : str7, (i7 & 16384) != 0 ? flowDetailConfigModel2.recommendReason : str8, (i7 & 32768) != 0 ? flowDetailConfigModel2.celebrityRecognitionConfig : celebrityRecognitionConfigModel, (i7 & 65536) != 0 ? flowDetailConfigModel2.labelMountPolicy : labelMountPolicyModel, (i7 & 131072) != 0 ? flowDetailConfigModel2.homeMiddlePage : homeMiddlePageModel, (i7 & 262144) != 0 ? flowDetailConfigModel2.followArouse : followArouseModel, (i7 & 524288) != 0 ? flowDetailConfigModel2.showWealthDialog : z, (i7 & 1048576) != 0 ? flowDetailConfigModel2.newDislike : i5, (i7 & 2097152) != 0 ? flowDetailConfigModel2.newDislikeInteractionMode : str9, (i7 & 4194304) != 0 ? flowDetailConfigModel2.goodsCardStyle : str10, (i7 & 8388608) != 0 ? flowDetailConfigModel2.commentVideoShare : str11, (i7 & 16777216) != 0 ? flowDetailConfigModel2.loop : str12);
    }

    public final int component1() {
        return this.showHighLightText;
    }

    public final String component10() {
        return this.rumorIcon;
    }

    public final RelateModel component11() {
        return this.relateModel;
    }

    public final String component12() {
        return this.commentSlide;
    }

    public final String component13() {
        return this.liveGuideAttentionSwitch;
    }

    public final String component14() {
        return this.noScaleIntervene;
    }

    public final String component15() {
        return this.recommendReason;
    }

    public final CelebrityRecognitionConfigModel component16() {
        return this.celebrityRecognitionConfig;
    }

    public final LabelMountPolicyModel component17() {
        return this.labelMountPolicy;
    }

    public final HomeMiddlePageModel component18() {
        return this.homeMiddlePage;
    }

    public final FollowArouseModel component19() {
        return this.followArouse;
    }

    public final int component2() {
        return this.hitLiveComponent;
    }

    public final boolean component20() {
        return this.showWealthDialog;
    }

    public final int component21() {
        return this.newDislike;
    }

    public final String component22() {
        return this.newDislikeInteractionMode;
    }

    public final String component23() {
        return this.goodsCardStyle;
    }

    public final String component24() {
        return this.commentVideoShare;
    }

    public final String component25() {
        return this.loop;
    }

    public final int component3() {
        return this.horizontalPlayerBtnSwitch;
    }

    public final ArrayList<Integer> component4() {
        return this.playerBtn;
    }

    public final String component5() {
        return this.residenceTime;
    }

    public final ThirdLogModel component6() {
        return this.thirdLog;
    }

    public final RecommendNextContentModel component7() {
        return this.recommendNextContentCard;
    }

    public final String component8() {
        return this.hotComment;
    }

    public final String component9() {
        return this.middlePageLandscapeSwitch;
    }

    public final FlowDetailConfigModel copy(int i2, int i3, int i4, ArrayList<Integer> arrayList, String str, ThirdLogModel thirdLogModel, RecommendNextContentModel recommendNextContentModel, String str2, String str3, String str4, RelateModel relateModel2, String str5, String str6, String str7, String str8, CelebrityRecognitionConfigModel celebrityRecognitionConfigModel, LabelMountPolicyModel labelMountPolicyModel, HomeMiddlePageModel homeMiddlePageModel, FollowArouseModel followArouseModel, boolean z, int i5, String str9, String str10, String str11, String str12) {
        Intrinsics.checkNotNullParameter(str, "residenceTime");
        Intrinsics.checkNotNullParameter(str2, VideoFlowTtsDataProviderFactory.TTS_FLOW_HOT_COMMENT);
        Intrinsics.checkNotNullParameter(str3, "middlePageLandscapeSwitch");
        Intrinsics.checkNotNullParameter(str4, "rumorIcon");
        Intrinsics.checkNotNullParameter(str5, "commentSlide");
        Intrinsics.checkNotNullParameter(str6, "liveGuideAttentionSwitch");
        Intrinsics.checkNotNullParameter(str8, "recommendReason");
        Intrinsics.checkNotNullParameter(str9, "newDislikeInteractionMode");
        Intrinsics.checkNotNullParameter(str10, "goodsCardStyle");
        Intrinsics.checkNotNullParameter(str12, "loop");
        return new FlowDetailConfigModel(i2, i3, i4, arrayList, str, thirdLogModel, recommendNextContentModel, str2, str3, str4, relateModel2, str5, str6, str7, str8, celebrityRecognitionConfigModel, labelMountPolicyModel, homeMiddlePageModel, followArouseModel, z, i5, str9, str10, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowDetailConfigModel)) {
            return false;
        }
        FlowDetailConfigModel flowDetailConfigModel = (FlowDetailConfigModel) obj;
        return this.showHighLightText == flowDetailConfigModel.showHighLightText && this.hitLiveComponent == flowDetailConfigModel.hitLiveComponent && this.horizontalPlayerBtnSwitch == flowDetailConfigModel.horizontalPlayerBtnSwitch && Intrinsics.areEqual((Object) this.playerBtn, (Object) flowDetailConfigModel.playerBtn) && Intrinsics.areEqual((Object) this.residenceTime, (Object) flowDetailConfigModel.residenceTime) && Intrinsics.areEqual((Object) this.thirdLog, (Object) flowDetailConfigModel.thirdLog) && Intrinsics.areEqual((Object) this.recommendNextContentCard, (Object) flowDetailConfigModel.recommendNextContentCard) && Intrinsics.areEqual((Object) this.hotComment, (Object) flowDetailConfigModel.hotComment) && Intrinsics.areEqual((Object) this.middlePageLandscapeSwitch, (Object) flowDetailConfigModel.middlePageLandscapeSwitch) && Intrinsics.areEqual((Object) this.rumorIcon, (Object) flowDetailConfigModel.rumorIcon) && Intrinsics.areEqual((Object) this.relateModel, (Object) flowDetailConfigModel.relateModel) && Intrinsics.areEqual((Object) this.commentSlide, (Object) flowDetailConfigModel.commentSlide) && Intrinsics.areEqual((Object) this.liveGuideAttentionSwitch, (Object) flowDetailConfigModel.liveGuideAttentionSwitch) && Intrinsics.areEqual((Object) this.noScaleIntervene, (Object) flowDetailConfigModel.noScaleIntervene) && Intrinsics.areEqual((Object) this.recommendReason, (Object) flowDetailConfigModel.recommendReason) && Intrinsics.areEqual((Object) this.celebrityRecognitionConfig, (Object) flowDetailConfigModel.celebrityRecognitionConfig) && Intrinsics.areEqual((Object) this.labelMountPolicy, (Object) flowDetailConfigModel.labelMountPolicy) && Intrinsics.areEqual((Object) this.homeMiddlePage, (Object) flowDetailConfigModel.homeMiddlePage) && Intrinsics.areEqual((Object) this.followArouse, (Object) flowDetailConfigModel.followArouse) && this.showWealthDialog == flowDetailConfigModel.showWealthDialog && this.newDislike == flowDetailConfigModel.newDislike && Intrinsics.areEqual((Object) this.newDislikeInteractionMode, (Object) flowDetailConfigModel.newDislikeInteractionMode) && Intrinsics.areEqual((Object) this.goodsCardStyle, (Object) flowDetailConfigModel.goodsCardStyle) && Intrinsics.areEqual((Object) this.commentVideoShare, (Object) flowDetailConfigModel.commentVideoShare) && Intrinsics.areEqual((Object) this.loop, (Object) flowDetailConfigModel.loop);
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.showHighLightText) * 31) + Integer.hashCode(this.hitLiveComponent)) * 31) + Integer.hashCode(this.horizontalPlayerBtnSwitch)) * 31;
        ArrayList<Integer> arrayList = this.playerBtn;
        int i2 = 0;
        int hashCode2 = (((hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31) + this.residenceTime.hashCode()) * 31;
        ThirdLogModel thirdLogModel = this.thirdLog;
        int hashCode3 = (hashCode2 + (thirdLogModel == null ? 0 : thirdLogModel.hashCode())) * 31;
        RecommendNextContentModel recommendNextContentModel = this.recommendNextContentCard;
        int hashCode4 = (((((((hashCode3 + (recommendNextContentModel == null ? 0 : recommendNextContentModel.hashCode())) * 31) + this.hotComment.hashCode()) * 31) + this.middlePageLandscapeSwitch.hashCode()) * 31) + this.rumorIcon.hashCode()) * 31;
        RelateModel relateModel2 = this.relateModel;
        int hashCode5 = (((((hashCode4 + (relateModel2 == null ? 0 : relateModel2.hashCode())) * 31) + this.commentSlide.hashCode()) * 31) + this.liveGuideAttentionSwitch.hashCode()) * 31;
        String str = this.noScaleIntervene;
        int hashCode6 = (((hashCode5 + (str == null ? 0 : str.hashCode())) * 31) + this.recommendReason.hashCode()) * 31;
        CelebrityRecognitionConfigModel celebrityRecognitionConfigModel = this.celebrityRecognitionConfig;
        int hashCode7 = (hashCode6 + (celebrityRecognitionConfigModel == null ? 0 : celebrityRecognitionConfigModel.hashCode())) * 31;
        LabelMountPolicyModel labelMountPolicyModel = this.labelMountPolicy;
        int hashCode8 = (hashCode7 + (labelMountPolicyModel == null ? 0 : labelMountPolicyModel.hashCode())) * 31;
        HomeMiddlePageModel homeMiddlePageModel = this.homeMiddlePage;
        int hashCode9 = (hashCode8 + (homeMiddlePageModel == null ? 0 : homeMiddlePageModel.hashCode())) * 31;
        FollowArouseModel followArouseModel = this.followArouse;
        int hashCode10 = (hashCode9 + (followArouseModel == null ? 0 : followArouseModel.hashCode())) * 31;
        boolean z = this.showWealthDialog;
        if (z) {
            z = true;
        }
        int hashCode11 = (((((((hashCode10 + (z ? 1 : 0)) * 31) + Integer.hashCode(this.newDislike)) * 31) + this.newDislikeInteractionMode.hashCode()) * 31) + this.goodsCardStyle.hashCode()) * 31;
        String str2 = this.commentVideoShare;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode11 + i2) * 31) + this.loop.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlowDetailConfigModel(showHighLightText=").append(this.showHighLightText).append(", hitLiveComponent=").append(this.hitLiveComponent).append(", horizontalPlayerBtnSwitch=").append(this.horizontalPlayerBtnSwitch).append(", playerBtn=").append(this.playerBtn).append(", residenceTime=").append(this.residenceTime).append(", thirdLog=").append(this.thirdLog).append(", recommendNextContentCard=").append(this.recommendNextContentCard).append(", hotComment=").append(this.hotComment).append(", middlePageLandscapeSwitch=").append(this.middlePageLandscapeSwitch).append(", rumorIcon=").append(this.rumorIcon).append(", relateModel=").append(this.relateModel).append(", commentSlide=");
        sb.append(this.commentSlide).append(", liveGuideAttentionSwitch=").append(this.liveGuideAttentionSwitch).append(", noScaleIntervene=").append(this.noScaleIntervene).append(", recommendReason=").append(this.recommendReason).append(", celebrityRecognitionConfig=").append(this.celebrityRecognitionConfig).append(", labelMountPolicy=").append(this.labelMountPolicy).append(", homeMiddlePage=").append(this.homeMiddlePage).append(", followArouse=").append(this.followArouse).append(", showWealthDialog=").append(this.showWealthDialog).append(", newDislike=").append(this.newDislike).append(", newDislikeInteractionMode=").append(this.newDislikeInteractionMode).append(", goodsCardStyle=").append(this.goodsCardStyle);
        sb.append(", commentVideoShare=").append(this.commentVideoShare).append(", loop=").append(this.loop).append(')');
        return sb.toString();
    }

    public FlowDetailConfigModel(int showHighLightText2, int hitLiveComponent2, int horizontalPlayerBtnSwitch2, ArrayList<Integer> playerBtn2, String residenceTime2, ThirdLogModel thirdLog2, RecommendNextContentModel recommendNextContentCard2, String hotComment2, String middlePageLandscapeSwitch2, String rumorIcon2, RelateModel relateModel2, String commentSlide2, String liveGuideAttentionSwitch2, String noScaleIntervene2, String recommendReason2, CelebrityRecognitionConfigModel celebrityRecognitionConfig2, LabelMountPolicyModel labelMountPolicy2, HomeMiddlePageModel homeMiddlePage2, FollowArouseModel followArouse2, boolean showWealthDialog2, int newDislike2, String newDislikeInteractionMode2, String goodsCardStyle2, String commentVideoShare2, String loop2) {
        String str = residenceTime2;
        String str2 = hotComment2;
        String str3 = middlePageLandscapeSwitch2;
        String str4 = rumorIcon2;
        String str5 = commentSlide2;
        String str6 = liveGuideAttentionSwitch2;
        String str7 = recommendReason2;
        String str8 = newDislikeInteractionMode2;
        String str9 = goodsCardStyle2;
        String str10 = loop2;
        Intrinsics.checkNotNullParameter(str, "residenceTime");
        Intrinsics.checkNotNullParameter(str2, VideoFlowTtsDataProviderFactory.TTS_FLOW_HOT_COMMENT);
        Intrinsics.checkNotNullParameter(str3, "middlePageLandscapeSwitch");
        Intrinsics.checkNotNullParameter(str4, "rumorIcon");
        Intrinsics.checkNotNullParameter(str5, "commentSlide");
        Intrinsics.checkNotNullParameter(str6, "liveGuideAttentionSwitch");
        Intrinsics.checkNotNullParameter(str7, "recommendReason");
        Intrinsics.checkNotNullParameter(str8, "newDislikeInteractionMode");
        Intrinsics.checkNotNullParameter(str9, "goodsCardStyle");
        Intrinsics.checkNotNullParameter(str10, "loop");
        this.showHighLightText = showHighLightText2;
        this.hitLiveComponent = hitLiveComponent2;
        this.horizontalPlayerBtnSwitch = horizontalPlayerBtnSwitch2;
        this.playerBtn = playerBtn2;
        this.residenceTime = str;
        this.thirdLog = thirdLog2;
        this.recommendNextContentCard = recommendNextContentCard2;
        this.hotComment = str2;
        this.middlePageLandscapeSwitch = str3;
        this.rumorIcon = str4;
        this.relateModel = relateModel2;
        this.commentSlide = str5;
        this.liveGuideAttentionSwitch = str6;
        this.noScaleIntervene = noScaleIntervene2;
        this.recommendReason = str7;
        this.celebrityRecognitionConfig = celebrityRecognitionConfig2;
        this.labelMountPolicy = labelMountPolicy2;
        this.homeMiddlePage = homeMiddlePage2;
        this.followArouse = followArouse2;
        this.showWealthDialog = showWealthDialog2;
        this.newDislike = newDislike2;
        this.newDislikeInteractionMode = str8;
        this.goodsCardStyle = str9;
        this.commentVideoShare = commentVideoShare2;
        this.loop = str10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FlowDetailConfigModel(int r27, int r28, int r29, java.util.ArrayList r30, java.lang.String r31, com.baidu.searchbox.flowvideo.detail.repos.ThirdLogModel r32, com.baidu.searchbox.flowvideo.detail.repos.RecommendNextContentModel r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, com.baidu.searchbox.flowvideo.detail.repos.RelateModel r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, com.baidu.searchbox.flowvideo.detail.repos.CelebrityRecognitionConfigModel r42, com.baidu.searchbox.flowvideo.detail.repos.LabelMountPolicyModel r43, com.baidu.searchbox.flowvideo.detail.repos.HomeMiddlePageModel r44, com.baidu.searchbox.flowvideo.detail.repos.FollowArouseModel r45, boolean r46, int r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
        /*
            r26 = this;
            r0 = r52
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r27
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r28
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r29
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r30
        L_0x0022:
            r7 = r0 & 16
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x002a
            r7 = r8
            goto L_0x002c
        L_0x002a:
            r7 = r31
        L_0x002c:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0032
            r9 = 0
            goto L_0x0034
        L_0x0032:
            r9 = r32
        L_0x0034:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003a
            r10 = 0
            goto L_0x003c
        L_0x003a:
            r10 = r33
        L_0x003c:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0042
            r11 = r8
            goto L_0x0044
        L_0x0042:
            r11 = r34
        L_0x0044:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004a
            r12 = r8
            goto L_0x004c
        L_0x004a:
            r12 = r35
        L_0x004c:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0052
            r13 = r8
            goto L_0x0054
        L_0x0052:
            r13 = r36
        L_0x0054:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005a
            r14 = 0
            goto L_0x005c
        L_0x005a:
            r14 = r37
        L_0x005c:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0062
            r15 = r8
            goto L_0x0064
        L_0x0062:
            r15 = r38
        L_0x0064:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x006a
            r2 = r8
            goto L_0x006c
        L_0x006a:
            r2 = r39
        L_0x006c:
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0072
            r6 = 0
            goto L_0x0074
        L_0x0072:
            r6 = r40
        L_0x0074:
            r28 = r8
            r8 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x007d
            r8 = r28
            goto L_0x007f
        L_0x007d:
            r8 = r41
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0089
            r16 = 0
            goto L_0x008b
        L_0x0089:
            r16 = r42
        L_0x008b:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0094
            r17 = 0
            goto L_0x0096
        L_0x0094:
            r17 = r43
        L_0x0096:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009f
            r18 = 0
            goto L_0x00a1
        L_0x009f:
            r18 = r44
        L_0x00a1:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00aa
            r19 = 0
            goto L_0x00ac
        L_0x00aa:
            r19 = r45
        L_0x00ac:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b5
            r20 = 0
            goto L_0x00b7
        L_0x00b5:
            r20 = r46
        L_0x00b7:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00c0
            r21 = 0
            goto L_0x00c2
        L_0x00c0:
            r21 = r47
        L_0x00c2:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00cb
            r22 = r28
            goto L_0x00cd
        L_0x00cb:
            r22 = r48
        L_0x00cd:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d6
            r23 = r28
            goto L_0x00d8
        L_0x00d6:
            r23 = r49
        L_0x00d8:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00e1
            r24 = 0
            goto L_0x00e3
        L_0x00e1:
            r24 = r50
        L_0x00e3:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r25
            if (r0 == 0) goto L_0x00ec
            r0 = r28
            goto L_0x00ee
        L_0x00ec:
            r0 = r51
        L_0x00ee:
            r27 = r1
            r28 = r3
            r29 = r4
            r30 = r5
            r31 = r7
            r32 = r9
            r33 = r10
            r34 = r11
            r35 = r12
            r36 = r13
            r37 = r14
            r38 = r15
            r39 = r2
            r40 = r6
            r41 = r8
            r42 = r16
            r43 = r17
            r44 = r18
            r45 = r19
            r46 = r20
            r47 = r21
            r48 = r22
            r49 = r23
            r50 = r24
            r51 = r0
            r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailConfigModel.<init>(int, int, int, java.util.ArrayList, java.lang.String, com.baidu.searchbox.flowvideo.detail.repos.ThirdLogModel, com.baidu.searchbox.flowvideo.detail.repos.RecommendNextContentModel, java.lang.String, java.lang.String, java.lang.String, com.baidu.searchbox.flowvideo.detail.repos.RelateModel, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.baidu.searchbox.flowvideo.detail.repos.CelebrityRecognitionConfigModel, com.baidu.searchbox.flowvideo.detail.repos.LabelMountPolicyModel, com.baidu.searchbox.flowvideo.detail.repos.HomeMiddlePageModel, com.baidu.searchbox.flowvideo.detail.repos.FollowArouseModel, boolean, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getShowHighLightText() {
        return this.showHighLightText;
    }

    public final int getHitLiveComponent() {
        return this.hitLiveComponent;
    }

    public final int getHorizontalPlayerBtnSwitch() {
        return this.horizontalPlayerBtnSwitch;
    }

    public final ArrayList<Integer> getPlayerBtn() {
        return this.playerBtn;
    }

    public final void setPlayerBtn(ArrayList<Integer> arrayList) {
        this.playerBtn = arrayList;
    }

    public final String getResidenceTime() {
        return this.residenceTime;
    }

    public final ThirdLogModel getThirdLog() {
        return this.thirdLog;
    }

    public final void setThirdLog(ThirdLogModel thirdLogModel) {
        this.thirdLog = thirdLogModel;
    }

    public final RecommendNextContentModel getRecommendNextContentCard() {
        return this.recommendNextContentCard;
    }

    public final String getHotComment() {
        return this.hotComment;
    }

    public final String getMiddlePageLandscapeSwitch() {
        return this.middlePageLandscapeSwitch;
    }

    public final String getRumorIcon() {
        return this.rumorIcon;
    }

    public final RelateModel getRelateModel() {
        return this.relateModel;
    }

    public final String getCommentSlide() {
        return this.commentSlide;
    }

    public final String getLiveGuideAttentionSwitch() {
        return this.liveGuideAttentionSwitch;
    }

    public final String getNoScaleIntervene() {
        return this.noScaleIntervene;
    }

    public final String getRecommendReason() {
        return this.recommendReason;
    }

    public final CelebrityRecognitionConfigModel getCelebrityRecognitionConfig() {
        return this.celebrityRecognitionConfig;
    }

    public final LabelMountPolicyModel getLabelMountPolicy() {
        return this.labelMountPolicy;
    }

    public final HomeMiddlePageModel getHomeMiddlePage() {
        return this.homeMiddlePage;
    }

    public final FollowArouseModel getFollowArouse() {
        return this.followArouse;
    }

    public final boolean getShowWealthDialog() {
        return this.showWealthDialog;
    }

    public final int getNewDislike() {
        return this.newDislike;
    }

    public final String getNewDislikeInteractionMode() {
        return this.newDislikeInteractionMode;
    }

    public final String getGoodsCardStyle() {
        return this.goodsCardStyle;
    }

    public final String getCommentVideoShare() {
        return this.commentVideoShare;
    }

    public final String getLoop() {
        return this.loop;
    }

    public final boolean isShowHighLight() {
        return this.showHighLightText == 1;
    }

    public final boolean isShowLiveBanner() {
        return this.hitLiveComponent == 1;
    }

    public final boolean isNewDislikeStyle() {
        return this.newDislike == 1;
    }

    public final boolean isDirectlyDisplayNewDislike() {
        return TextUtils.equals(this.newDislikeInteractionMode, "1");
    }

    public final boolean isForceLoop() {
        return Intrinsics.areEqual((Object) this.loop, (Object) "1");
    }

    public final boolean isMiddlePageLandscapeEnable() {
        return Intrinsics.areEqual((Object) this.middlePageLandscapeSwitch, (Object) "1");
    }

    public final boolean isShowLiveFollowGuide() {
        return Intrinsics.areEqual((Object) this.liveGuideAttentionSwitch, (Object) "1");
    }
}
