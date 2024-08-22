package com.baidu.searchbox.video.collectionflow.detail.lazy;

import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.api.LazyLayoutManager;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.lazy.ComponentHolder;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.common.downgrade.LazyInflateHelper;
import com.baidu.searchbox.video.feedflow.common.downgrade.LazyInflateWrap;
import com.baidu.searchbox.video.feedflow.detail.barrage.BarrageState;
import com.baidu.searchbox.video.feedflow.detail.barrage.InflateBarrageAction;
import com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState;
import com.baidu.searchbox.video.feedflow.detail.challenge.ChallengeState;
import com.baidu.searchbox.video.feedflow.detail.chat.ChatroomEntranceState;
import com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleState;
import com.baidu.searchbox.video.feedflow.detail.defaultcombopraise.DefaultComboPraiseState;
import com.baidu.searchbox.video.feedflow.detail.error.NetErrorState;
import com.baidu.searchbox.video.feedflow.detail.exclusivelabel.ExclusiveLabelState;
import com.baidu.searchbox.video.feedflow.detail.favorbottomtoast.FavorBottomToastState;
import com.baidu.searchbox.video.feedflow.detail.hotcomment.HotCommentState;
import com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState;
import com.baidu.searchbox.video.feedflow.detail.lazy.VideoItemLazyInflateState;
import com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedState;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrSummaryState;
import com.baidu.searchbox.video.feedflow.detail.offline.OfflineState;
import com.baidu.searchbox.video.feedflow.detail.oneton.OneToNState;
import com.baidu.searchbox.video.feedflow.detail.poster.PosterState;
import com.baidu.searchbox.video.feedflow.detail.preview.PreviewState;
import com.baidu.searchbox.video.feedflow.detail.recognition.CelebrityRecognitionState;
import com.baidu.searchbox.video.feedflow.detail.recognitionbig.CelebrityRecognitionBigCardState;
import com.baidu.searchbox.video.feedflow.detail.reward.RewardState;
import com.baidu.searchbox.video.feedflow.detail.riskwarning.DangerHintState;
import com.baidu.searchbox.video.feedflow.detail.rumor.RumorState;
import com.baidu.searchbox.video.feedflow.detail.videopk.VideoPkState;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryState;
import com.baidu.searchbox.video.feedflow.detail.vote.VoteInfoState;
import com.baidu.searchbox.video.feedflow.flow.collection.backguide.CollectionBackGuideState;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010v\u001a\u0004\u0018\u00010wJ\b\u0010x\u001a\u0004\u0018\u00010wJ\b\u0010y\u001a\u0004\u0018\u00010wJ\b\u0010z\u001a\u0004\u0018\u00010wJ\b\u0010{\u001a\u0004\u0018\u00010wJ\b\u0010|\u001a\u0004\u0018\u00010wJ\b\u0010}\u001a\u0004\u0018\u00010wJ\b\u0010~\u001a\u0004\u0018\u00010wJ\b\u0010\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ\t\u0010\u0001\u001a\u0004\u0018\u00010wJ%\u0010\u0001\u001a\u00030\u00012\u0011\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000bR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000bR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0018\u0010\u000bR!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001c\u0010\u000bR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\b8BX\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b \u0010\u000bR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\b8BX\u0002¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b$\u0010\u000bR!\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\b8BX\u0002¢\u0006\f\n\u0004\b)\u0010\r\u001a\u0004\b(\u0010\u000bR!\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\b8BX\u0002¢\u0006\f\n\u0004\b-\u0010\r\u001a\u0004\b,\u0010\u000bR!\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\b8BX\u0002¢\u0006\f\n\u0004\b1\u0010\r\u001a\u0004\b0\u0010\u000bR!\u00102\u001a\b\u0012\u0004\u0012\u0002030\b8BX\u0002¢\u0006\f\n\u0004\b5\u0010\r\u001a\u0004\b4\u0010\u000bR!\u00106\u001a\b\u0012\u0004\u0012\u0002070\b8BX\u0002¢\u0006\f\n\u0004\b9\u0010\r\u001a\u0004\b8\u0010\u000bR!\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\b8BX\u0002¢\u0006\f\n\u0004\b=\u0010\r\u001a\u0004\b<\u0010\u000bR!\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\b8BX\u0002¢\u0006\f\n\u0004\bA\u0010\r\u001a\u0004\b@\u0010\u000bR!\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\b8BX\u0002¢\u0006\f\n\u0004\bE\u0010\r\u001a\u0004\bD\u0010\u000bR\u000e\u0010F\u001a\u00020GX\u0004¢\u0006\u0002\n\u0000R!\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\b8BX\u0002¢\u0006\f\n\u0004\bK\u0010\r\u001a\u0004\bJ\u0010\u000bR!\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\b8BX\u0002¢\u0006\f\n\u0004\bO\u0010\r\u001a\u0004\bN\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR!\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\b8BX\u0002¢\u0006\f\n\u0004\bU\u0010\r\u001a\u0004\bT\u0010\u000bR!\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\b8BX\u0002¢\u0006\f\n\u0004\bY\u0010\r\u001a\u0004\bX\u0010\u000bR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\b8BX\u0002¢\u0006\f\n\u0004\b]\u0010\r\u001a\u0004\b\\\u0010\u000bR!\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\b8BX\u0002¢\u0006\f\n\u0004\ba\u0010\r\u001a\u0004\b`\u0010\u000bR!\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\b8BX\u0002¢\u0006\f\n\u0004\be\u0010\r\u001a\u0004\bd\u0010\u000bR!\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\b8BX\u0002¢\u0006\f\n\u0004\bi\u0010\r\u001a\u0004\bh\u0010\u000bR!\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\b8BX\u0002¢\u0006\f\n\u0004\bm\u0010\r\u001a\u0004\bl\u0010\u000bR!\u0010n\u001a\b\u0012\u0004\u0012\u00020o0\b8BX\u0002¢\u0006\f\n\u0004\bq\u0010\r\u001a\u0004\bp\u0010\u000bR!\u0010r\u001a\b\u0012\u0004\u0012\u00020s0\b8BX\u0002¢\u0006\f\n\u0004\bu\u0010\r\u001a\u0004\bt\u0010\u000b¨\u0006\u0001"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/detail/lazy/SecondaryPageVideoItemLazyInflateHelper;", "", "layoutManager", "Lcom/baidu/searchbox/feed/detail/arch/api/LazyLayoutManager;", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "(Lcom/baidu/searchbox/feed/detail/arch/api/LazyLayoutManager;Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;)V", "barrageHolder", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/LazyInflateWrap;", "Lcom/baidu/searchbox/video/feedflow/detail/barrage/BarrageState;", "getBarrageHolder", "()Lcom/baidu/searchbox/video/feedflow/common/downgrade/LazyInflateWrap;", "barrageHolder$delegate", "Lkotlin/Lazy;", "bottomBannerHolder", "Lcom/baidu/searchbox/video/feedflow/detail/bottombanner/BottomBannerState;", "getBottomBannerHolder", "bottomBannerHolder$delegate", "celebrityRecognitionBigCardHolder", "Lcom/baidu/searchbox/video/feedflow/detail/recognitionbig/CelebrityRecognitionBigCardState;", "getCelebrityRecognitionBigCardHolder", "celebrityRecognitionBigCardHolder$delegate", "celebrityRecognitionHolder", "Lcom/baidu/searchbox/video/feedflow/detail/recognition/CelebrityRecognitionState;", "getCelebrityRecognitionHolder", "celebrityRecognitionHolder$delegate", "challengeHolder", "Lcom/baidu/searchbox/video/feedflow/detail/challenge/ChallengeState;", "getChallengeHolder", "challengeHolder$delegate", "chatroomEntranceHolder", "Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomEntranceState;", "getChatroomEntranceHolder", "chatroomEntranceHolder$delegate", "collectionBackGuideHolder", "Lcom/baidu/searchbox/video/feedflow/flow/collection/backguide/CollectionBackGuideState;", "getCollectionBackGuideHolder", "collectionBackGuideHolder$delegate", "commentBubbleHolder", "Lcom/baidu/searchbox/video/feedflow/detail/commentbubble/CommentBubbleState;", "getCommentBubbleHolder", "commentBubbleHolder$delegate", "contentSummaryHolder", "Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrSummaryState;", "getContentSummaryHolder", "contentSummaryHolder$delegate", "dangerHintHolder", "Lcom/baidu/searchbox/video/feedflow/detail/riskwarning/DangerHintState;", "getDangerHintHolder", "dangerHintHolder$delegate", "defaultPraiseHolder", "Lcom/baidu/searchbox/video/feedflow/detail/defaultcombopraise/DefaultComboPraiseState;", "getDefaultPraiseHolder", "defaultPraiseHolder$delegate", "errorHolder", "Lcom/baidu/searchbox/video/feedflow/detail/error/NetErrorState;", "getErrorHolder", "errorHolder$delegate", "exclusiveLabelHolder", "Lcom/baidu/searchbox/video/feedflow/detail/exclusivelabel/ExclusiveLabelState;", "getExclusiveLabelHolder", "exclusiveLabelHolder$delegate", "favorBottomToastHolder", "Lcom/baidu/searchbox/video/feedflow/detail/favorbottomtoast/FavorBottomToastState;", "getFavorBottomToastHolder", "favorBottomToastHolder$delegate", "hotCommentHolder", "Lcom/baidu/searchbox/video/feedflow/detail/hotcomment/HotCommentState;", "getHotCommentHolder", "hotCommentHolder$delegate", "inflateHelper", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/LazyInflateHelper;", "landscapeFoldViewHolder", "Lcom/baidu/searchbox/video/feedflow/detail/landscapefold/LandscapeFoldState;", "getLandscapeFoldViewHolder", "landscapeFoldViewHolder$delegate", "longPressSpeedHolder", "Lcom/baidu/searchbox/video/feedflow/detail/longpressspeed/LongPressSpeedState;", "getLongPressSpeedHolder", "longPressSpeedHolder$delegate", "getManager", "()Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "newVideoSummaryHolder", "Lcom/baidu/searchbox/video/feedflow/detail/videosummary/VideoSummaryState;", "getNewVideoSummaryHolder", "newVideoSummaryHolder$delegate", "offlineHolder", "Lcom/baidu/searchbox/video/feedflow/detail/offline/OfflineState;", "getOfflineHolder", "offlineHolder$delegate", "oneToNHolder", "Lcom/baidu/searchbox/video/feedflow/detail/oneton/OneToNState;", "getOneToNHolder", "oneToNHolder$delegate", "posterHolder", "Lcom/baidu/searchbox/video/feedflow/detail/poster/PosterState;", "getPosterHolder", "posterHolder$delegate", "rewardBubbledHolder", "Lcom/baidu/searchbox/video/feedflow/detail/reward/RewardState;", "getRewardBubbledHolder", "rewardBubbledHolder$delegate", "rumorHolder", "Lcom/baidu/searchbox/video/feedflow/detail/rumor/RumorState;", "getRumorHolder", "rumorHolder$delegate", "seekBarPreviewHolder", "Lcom/baidu/searchbox/video/feedflow/detail/preview/PreviewState;", "getSeekBarPreviewHolder", "seekBarPreviewHolder$delegate", "videoPkHolder", "Lcom/baidu/searchbox/video/feedflow/detail/videopk/VideoPkState;", "getVideoPkHolder", "videoPkHolder$delegate", "voteHolder", "Lcom/baidu/searchbox/video/feedflow/detail/vote/VoteInfoState;", "getVoteHolder", "voteHolder$delegate", "inflateCelebrityRecognitionBigCardHolder", "Lcom/baidu/searchbox/feed/detail/lazy/ComponentHolder;", "inflateCelebrityRecognitionHolder", "lazyInflateBarrageHolder", "lazyInflateBottomBannerHolder", "lazyInflateChallengeHolder", "lazyInflateChatroomEntranceHolder", "lazyInflateCollectionBackGuideHolder", "lazyInflateCommentBubbleHolder", "lazyInflateContentSummaryHolder", "lazyInflateDangerHintHolder", "lazyInflateDefaultPraise", "lazyInflateErrorHolder", "lazyInflateExclusiveLabelHolder", "lazyInflateFavorBottomToastHolder", "lazyInflateHotCommentHolder", "lazyInflateLandscapeFoldView", "lazyInflateLongPressSpeedHolder", "lazyInflateNewVideoSummaryHolder", "lazyInflateOfflineHolder", "lazyInflateOneToNHolder", "lazyInflatePosterHolder", "lazyInflateRewardBubbledHolder", "lazyInflateRumorHolder", "lazyInflateSeekBarPreviewHolder", "lazyInflateVideoPkHolder", "lazyInflateVoteHolder", "subscriber", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecondaryPageVideoItemLazyInflateHelper.kt */
public final class SecondaryPageVideoItemLazyInflateHelper {
    private final Lazy barrageHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$barrageHolder$2(this));
    private final Lazy bottomBannerHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$bottomBannerHolder$2(this));
    private final Lazy celebrityRecognitionBigCardHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$celebrityRecognitionBigCardHolder$2(this));
    private final Lazy celebrityRecognitionHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$celebrityRecognitionHolder$2(this));
    private final Lazy challengeHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$challengeHolder$2(this));
    private final Lazy chatroomEntranceHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$chatroomEntranceHolder$2(this));
    private final Lazy collectionBackGuideHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$collectionBackGuideHolder$2(this));
    private final Lazy commentBubbleHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$commentBubbleHolder$2(this));
    private final Lazy contentSummaryHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$contentSummaryHolder$2(this));
    private final Lazy dangerHintHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$dangerHintHolder$2(this));
    private final Lazy defaultPraiseHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$defaultPraiseHolder$2(this));
    private final Lazy errorHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$errorHolder$2(this));
    private final Lazy exclusiveLabelHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$exclusiveLabelHolder$2(this));
    private final Lazy favorBottomToastHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$favorBottomToastHolder$2(this));
    private final Lazy hotCommentHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$hotCommentHolder$2(this));
    /* access modifiers changed from: private */
    public final LazyInflateHelper inflateHelper;
    private final Lazy landscapeFoldViewHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$landscapeFoldViewHolder$2(this));
    private final Lazy longPressSpeedHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$longPressSpeedHolder$2(this));
    private final ComponentArchManager manager;
    private final Lazy newVideoSummaryHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$newVideoSummaryHolder$2(this));
    private final Lazy offlineHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$offlineHolder$2(this));
    private final Lazy oneToNHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$oneToNHolder$2(this));
    private final Lazy posterHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$posterHolder$2(this));
    private final Lazy rewardBubbledHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$rewardBubbledHolder$2(this));
    private final Lazy rumorHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$rumorHolder$2(this));
    private final Lazy seekBarPreviewHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$seekBarPreviewHolder$2(this));
    private final Lazy videoPkHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$videoPkHolder$2(this));
    private final Lazy voteHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageVideoItemLazyInflateHelper$voteHolder$2(this));

    public SecondaryPageVideoItemLazyInflateHelper(LazyLayoutManager<?> layoutManager, ComponentArchManager manager2) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(manager2, FeedStatisticConstants.UBC_TYPE_PLUS);
        this.manager = manager2;
        this.inflateHelper = new LazyInflateHelper(layoutManager, manager2);
    }

    public final ComponentArchManager getManager() {
        return this.manager;
    }

    private final LazyInflateWrap<DefaultComboPraiseState> getDefaultPraiseHolder() {
        return (LazyInflateWrap) this.defaultPraiseHolder$delegate.getValue();
    }

    private final LazyInflateWrap<HotCommentState> getHotCommentHolder() {
        return (LazyInflateWrap) this.hotCommentHolder$delegate.getValue();
    }

    private final LazyInflateWrap<CollectionBackGuideState> getCollectionBackGuideHolder() {
        return (LazyInflateWrap) this.collectionBackGuideHolder$delegate.getValue();
    }

    private final LazyInflateWrap<CommentBubbleState> getCommentBubbleHolder() {
        return (LazyInflateWrap) this.commentBubbleHolder$delegate.getValue();
    }

    private final LazyInflateWrap<PosterState> getPosterHolder() {
        return (LazyInflateWrap) this.posterHolder$delegate.getValue();
    }

    private final LazyInflateWrap<RewardState> getRewardBubbledHolder() {
        return (LazyInflateWrap) this.rewardBubbledHolder$delegate.getValue();
    }

    private final LazyInflateWrap<VoteInfoState> getVoteHolder() {
        return (LazyInflateWrap) this.voteHolder$delegate.getValue();
    }

    private final LazyInflateWrap<ChallengeState> getChallengeHolder() {
        return (LazyInflateWrap) this.challengeHolder$delegate.getValue();
    }

    private final LazyInflateWrap<OneToNState> getOneToNHolder() {
        return (LazyInflateWrap) this.oneToNHolder$delegate.getValue();
    }

    private final LazyInflateWrap<ChatroomEntranceState> getChatroomEntranceHolder() {
        return (LazyInflateWrap) this.chatroomEntranceHolder$delegate.getValue();
    }

    private final LazyInflateWrap<ExclusiveLabelState> getExclusiveLabelHolder() {
        return (LazyInflateWrap) this.exclusiveLabelHolder$delegate.getValue();
    }

    private final LazyInflateWrap<RumorState> getRumorHolder() {
        return (LazyInflateWrap) this.rumorHolder$delegate.getValue();
    }

    private final LazyInflateWrap<OcrSummaryState> getContentSummaryHolder() {
        return (LazyInflateWrap) this.contentSummaryHolder$delegate.getValue();
    }

    private final LazyInflateWrap<VideoSummaryState> getNewVideoSummaryHolder() {
        return (LazyInflateWrap) this.newVideoSummaryHolder$delegate.getValue();
    }

    private final LazyInflateWrap<BarrageState> getBarrageHolder() {
        return (LazyInflateWrap) this.barrageHolder$delegate.getValue();
    }

    private final LazyInflateWrap<DangerHintState> getDangerHintHolder() {
        return (LazyInflateWrap) this.dangerHintHolder$delegate.getValue();
    }

    private final LazyInflateWrap<OfflineState> getOfflineHolder() {
        return (LazyInflateWrap) this.offlineHolder$delegate.getValue();
    }

    private final LazyInflateWrap<NetErrorState> getErrorHolder() {
        return (LazyInflateWrap) this.errorHolder$delegate.getValue();
    }

    private final LazyInflateWrap<BottomBannerState> getBottomBannerHolder() {
        return (LazyInflateWrap) this.bottomBannerHolder$delegate.getValue();
    }

    private final LazyInflateWrap<LandscapeFoldState> getLandscapeFoldViewHolder() {
        return (LazyInflateWrap) this.landscapeFoldViewHolder$delegate.getValue();
    }

    private final LazyInflateWrap<LongPressSpeedState> getLongPressSpeedHolder() {
        return (LazyInflateWrap) this.longPressSpeedHolder$delegate.getValue();
    }

    private final LazyInflateWrap<PreviewState> getSeekBarPreviewHolder() {
        return (LazyInflateWrap) this.seekBarPreviewHolder$delegate.getValue();
    }

    private final LazyInflateWrap<VideoPkState> getVideoPkHolder() {
        return (LazyInflateWrap) this.videoPkHolder$delegate.getValue();
    }

    private final LazyInflateWrap<CelebrityRecognitionState> getCelebrityRecognitionHolder() {
        return (LazyInflateWrap) this.celebrityRecognitionHolder$delegate.getValue();
    }

    private final LazyInflateWrap<CelebrityRecognitionBigCardState> getCelebrityRecognitionBigCardHolder() {
        return (LazyInflateWrap) this.celebrityRecognitionBigCardHolder$delegate.getValue();
    }

    private final LazyInflateWrap<FavorBottomToastState> getFavorBottomToastHolder() {
        return (LazyInflateWrap) this.favorBottomToastHolder$delegate.getValue();
    }

    public final ComponentHolder lazyInflateDefaultPraise() {
        return getDefaultPraiseHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateHotCommentHolder() {
        return getHotCommentHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateCollectionBackGuideHolder() {
        return getCollectionBackGuideHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateCommentBubbleHolder() {
        return getCommentBubbleHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflatePosterHolder() {
        return getPosterHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateRewardBubbledHolder() {
        return getRewardBubbledHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateVoteHolder() {
        return getVoteHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateChallengeHolder() {
        return getChallengeHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateOneToNHolder() {
        return getOneToNHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateChatroomEntranceHolder() {
        return getChatroomEntranceHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateExclusiveLabelHolder() {
        return getExclusiveLabelHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateRumorHolder() {
        return getRumorHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateNewVideoSummaryHolder() {
        return getNewVideoSummaryHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateContentSummaryHolder() {
        return getContentSummaryHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateBarrageHolder() {
        return getBarrageHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateDangerHintHolder() {
        return getDangerHintHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateOfflineHolder() {
        return getOfflineHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateErrorHolder() {
        return getErrorHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateBottomBannerHolder() {
        return getBottomBannerHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateLandscapeFoldView() {
        return getLandscapeFoldViewHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateLongPressSpeedHolder() {
        return getLongPressSpeedHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateSeekBarPreviewHolder() {
        return getSeekBarPreviewHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateVideoPkHolder() {
        return getVideoPkHolder().lazyInflate();
    }

    public final ComponentHolder inflateCelebrityRecognitionHolder() {
        return getCelebrityRecognitionHolder().lazyInflate();
    }

    public final ComponentHolder inflateCelebrityRecognitionBigCardHolder() {
        return getCelebrityRecognitionBigCardHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateFavorBottomToastHolder() {
        return getFavorBottomToastHolder().lazyInflate();
    }

    public final void subscriber(Store<CommonState> store, LifecycleOwner owner) {
        VideoItemLazyInflateState $this$subscriber_u24lambda_u2d26;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (store != null && ($this$subscriber_u24lambda_u2d26 = (VideoItemLazyInflateState) store.subscribe((Class<T>) VideoItemLazyInflateState.class)) != null) {
            $this$subscriber_u24lambda_u2d26.getInflateDefaultComboPraise().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda0(this));
            $this$subscriber_u24lambda_u2d26.getInflateHotComment().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda2(this));
            $this$subscriber_u24lambda_u2d26.getInflateRewardBubble().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda9(this));
            $this$subscriber_u24lambda_u2d26.getInflatePoster().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda10(this));
            $this$subscriber_u24lambda_u2d26.getInflateCmpCollectionBackGuide().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda12(this));
            $this$subscriber_u24lambda_u2d26.getInflateCommentBubble().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda13(this));
            $this$subscriber_u24lambda_u2d26.getInflateVote().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda14(this));
            $this$subscriber_u24lambda_u2d26.getInflateChallenge().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda15(this));
            $this$subscriber_u24lambda_u2d26.getInflateOneToN().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda16(this));
            $this$subscriber_u24lambda_u2d26.getInflateChatroomEntrance().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda17(this));
            $this$subscriber_u24lambda_u2d26.getInflateExclusiveLabel().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda11(this));
            $this$subscriber_u24lambda_u2d26.getInflateRumor().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda18(this));
            $this$subscriber_u24lambda_u2d26.getInflateCmpContentSummary().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda19(this));
            $this$subscriber_u24lambda_u2d26.getInflateNewVideoSummary().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda20(this));
            $this$subscriber_u24lambda_u2d26.getInflateBarrage().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda21(this, store));
            $this$subscriber_u24lambda_u2d26.getInflateDangerHint().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda22(this));
            $this$subscriber_u24lambda_u2d26.getInflateOffline().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda23(this));
            $this$subscriber_u24lambda_u2d26.getInflateNetError().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda24(this));
            $this$subscriber_u24lambda_u2d26.getInflateBottomBanner().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda25(this));
            $this$subscriber_u24lambda_u2d26.getInflateLandscapeFold().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda1(this));
            $this$subscriber_u24lambda_u2d26.getInflateLongPressSpeed().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda3(this));
            $this$subscriber_u24lambda_u2d26.getInflateSeekbarPreview().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda4(this));
            $this$subscriber_u24lambda_u2d26.getInflateVideoPk().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda5(this));
            $this$subscriber_u24lambda_u2d26.getInflateCelebrityRecognition().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda6(this));
            $this$subscriber_u24lambda_u2d26.getInflateCelebrityRecognitionBigCard().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda7(this));
            $this$subscriber_u24lambda_u2d26.getInflateFavorBottomToast().observe(owner, new SecondaryPageVideoItemLazyInflateHelper$$ExternalSyntheticLambda8(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-0  reason: not valid java name */
    public static final void m5140subscriber$lambda26$lambda0(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDefaultPraiseHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-1  reason: not valid java name */
    public static final void m5141subscriber$lambda26$lambda1(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getHotCommentHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-2  reason: not valid java name */
    public static final void m5152subscriber$lambda26$lambda2(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getRewardBubbledHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-3  reason: not valid java name */
    public static final void m5159subscriber$lambda26$lambda3(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPosterHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-4  reason: not valid java name */
    public static final void m5160subscriber$lambda26$lambda4(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCollectionBackGuideHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-5  reason: not valid java name */
    public static final void m5161subscriber$lambda26$lambda5(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCommentBubbleHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-6  reason: not valid java name */
    public static final void m5162subscriber$lambda26$lambda6(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getVoteHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-7  reason: not valid java name */
    public static final void m5163subscriber$lambda26$lambda7(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getChallengeHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-8  reason: not valid java name */
    public static final void m5164subscriber$lambda26$lambda8(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOneToNHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-9  reason: not valid java name */
    public static final void m5165subscriber$lambda26$lambda9(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getChatroomEntranceHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-10  reason: not valid java name */
    public static final void m5142subscriber$lambda26$lambda10(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getExclusiveLabelHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-11  reason: not valid java name */
    public static final void m5143subscriber$lambda26$lambda11(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getRumorHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-12  reason: not valid java name */
    public static final void m5144subscriber$lambda26$lambda12(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getContentSummaryHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-13  reason: not valid java name */
    public static final void m5145subscriber$lambda26$lambda13(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getNewVideoSummaryHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-14  reason: not valid java name */
    public static final void m5146subscriber$lambda26$lambda14(SecondaryPageVideoItemLazyInflateHelper this$0, Store $store, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBarrageHolder().onInflate();
        StoreExtKt.post($store, InflateBarrageAction.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-15  reason: not valid java name */
    public static final void m5147subscriber$lambda26$lambda15(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDangerHintHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-16  reason: not valid java name */
    public static final void m5148subscriber$lambda26$lambda16(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOfflineHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-17  reason: not valid java name */
    public static final void m5149subscriber$lambda26$lambda17(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getErrorHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-18  reason: not valid java name */
    public static final void m5150subscriber$lambda26$lambda18(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBottomBannerHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-19  reason: not valid java name */
    public static final void m5151subscriber$lambda26$lambda19(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLandscapeFoldViewHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-20  reason: not valid java name */
    public static final void m5153subscriber$lambda26$lambda20(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLongPressSpeedHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-21  reason: not valid java name */
    public static final void m5154subscriber$lambda26$lambda21(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSeekBarPreviewHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-22  reason: not valid java name */
    public static final void m5155subscriber$lambda26$lambda22(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getVideoPkHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-23  reason: not valid java name */
    public static final void m5156subscriber$lambda26$lambda23(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCelebrityRecognitionHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-24  reason: not valid java name */
    public static final void m5157subscriber$lambda26$lambda24(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCelebrityRecognitionBigCardHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-26$lambda-25  reason: not valid java name */
    public static final void m5158subscriber$lambda26$lambda25(SecondaryPageVideoItemLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFavorBottomToastHolder().onInflate();
    }
}
