package com.baidu.searchbox.video.feedflow.di;

import com.baidu.searchbox.collectiondetail.repos.CollectionDetailRepository;
import com.baidu.searchbox.flowvideo.assessment.repos.AssessmentCardRepository;
import com.baidu.searchbox.flowvideo.authentication.repos.AuthenticationRepository;
import com.baidu.searchbox.flowvideo.collection.recommend.CollectionRecommendFlowListRepository;
import com.baidu.searchbox.flowvideo.collection.repos.CollectionFlowListRepository;
import com.baidu.searchbox.flowvideo.collection.repos.CollectionQueryRepository;
import com.baidu.searchbox.flowvideo.detail.repos.FlowBatchRepository;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailRepository;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailRepository;
import com.baidu.searchbox.flowvideo.flow.repos.FlowListRepository;
import com.baidu.searchbox.flowvideo.flow.repos.SmartInsertRepository;
import com.baidu.searchbox.flowvideo.follow.repos.FollowOneToNRepository;
import com.baidu.searchbox.flowvideo.graphicgenre.repos.GraphicGenreDetailRepository;
import com.baidu.searchbox.flowvideo.hot.repos.CommonListPanelRepository;
import com.baidu.searchbox.flowvideo.hot.repos.HotFlowListRepository;
import com.baidu.searchbox.flowvideo.interest.repos.InterestTagsRepository;
import com.baidu.searchbox.flowvideo.kuaishoucommand.KuaishouCommandRepository;
import com.baidu.searchbox.flowvideo.livebanner.repos.LiveBannerRepository;
import com.baidu.searchbox.flowvideo.livestatus.repos.LiveStatusRepository;
import com.baidu.searchbox.flowvideo.payment.repos.PaymentSubscribeStateRepository;
import com.baidu.searchbox.flowvideo.paymentpanel.repos.PaymentDetailPanelRepository;
import com.baidu.searchbox.flowvideo.paymentpanelset.repos.PaymentDetailPanelSetsRepository;
import com.baidu.searchbox.flowvideo.paymentsubscribe.repos.FollowPaymentSubscribeRepository;
import com.baidu.searchbox.flowvideo.personalizedcontent.repos.PersonalizedContentRepository;
import com.baidu.searchbox.flowvideo.praise.repos.PraiseRepository;
import com.baidu.searchbox.flowvideo.queryspecial.repos.QuerySpecialRepository;
import com.baidu.searchbox.flowvideo.recognition.repos.CelebrityRecognitionRepository;
import com.baidu.searchbox.flowvideo.recommend.repos.RelatedRecommendPanelRepository;
import com.baidu.searchbox.flowvideo.searchrecommend.repo.SearchRecommendRepository;
import com.baidu.searchbox.flowvideo.shortplayautounlock.repos.ShortPlayAutoUnlockRepository;
import com.baidu.searchbox.flowvideo.shortplaymore.repos.ShortPlayMoreRepository;
import com.baidu.searchbox.flowvideo.shortplaypayment.repos.ShortPlayPaymentRepository;
import com.baidu.searchbox.flowvideo.similarcollection.repos.SimilarCollectionListRepository;
import com.baidu.searchbox.flowvideo.simulate.VideoSimulateCUIDRepository;
import com.baidu.searchbox.flowvideo.simulate.VideoSimulateRepository;
import com.baidu.searchbox.flowvideo.theater.repos.TheaterFlowRepository;
import com.baidu.searchbox.flowvideo.thirdparty.repos.PddThirdPartyRepository;
import com.baidu.searchbox.flowvideo.thirdparty.repos.ThirdPartyRepository;
import com.baidu.searchbox.flowvideo.ufo.repos.UfoRepository;
import com.baidu.searchbox.flowvideo.videoauthentication.repos.VideoAuthenticationRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001WJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\n\u0010 \u001a\u0004\u0018\u00010!H&J\n\u0010\"\u001a\u0004\u0018\u00010#H&J\n\u0010$\u001a\u0004\u0018\u00010%H&J\n\u0010&\u001a\u0004\u0018\u00010'H&J\n\u0010(\u001a\u0004\u0018\u00010)H&J\n\u0010*\u001a\u0004\u0018\u00010+H&J\n\u0010,\u001a\u0004\u0018\u00010-H&J\n\u0010.\u001a\u0004\u0018\u00010/H&J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H&J\n\u00104\u001a\u0004\u0018\u000105H&J\n\u00106\u001a\u0004\u0018\u000107H&J\n\u00108\u001a\u0004\u0018\u000109H&J\n\u0010:\u001a\u0004\u0018\u00010;H&J\n\u0010<\u001a\u0004\u0018\u00010=H&J\n\u0010>\u001a\u0004\u0018\u00010?H&J\n\u0010@\u001a\u0004\u0018\u00010AH&J\n\u0010B\u001a\u0004\u0018\u00010CH&J\n\u0010D\u001a\u0004\u0018\u00010EH&J\n\u0010F\u001a\u0004\u0018\u00010GH&J\n\u0010H\u001a\u0004\u0018\u00010IH&J\n\u0010J\u001a\u0004\u0018\u00010KH&J\u0012\u0010L\u001a\u0004\u0018\u00010\u001d2\u0006\u0010M\u001a\u00020NH&J\n\u0010O\u001a\u0004\u0018\u00010PH&J\n\u0010Q\u001a\u0004\u0018\u00010RH&J\n\u0010S\u001a\u0004\u0018\u00010TH&J\n\u0010U\u001a\u0004\u0018\u00010VH&¨\u0006X"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/di/RepositoryFactory;", "", "getAssessmentCardRepos", "Lcom/baidu/searchbox/flowvideo/assessment/repos/AssessmentCardRepository;", "getDynamicDetailRepos", "Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicDetailRepository;", "getFlowDetailRepos", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailRepository;", "getLiveBannerRepos", "Lcom/baidu/searchbox/flowvideo/livebanner/repos/LiveBannerRepository;", "getLiveStatusRepos", "Lcom/baidu/searchbox/flowvideo/livestatus/repos/LiveStatusRepository;", "makeAuthenticationRepos", "Lcom/baidu/searchbox/flowvideo/authentication/repos/AuthenticationRepository;", "makeCelebrityRecognitionRepos", "Lcom/baidu/searchbox/flowvideo/recognition/repos/CelebrityRecognitionRepository;", "makeCollectionDetailRepos", "Lcom/baidu/searchbox/collectiondetail/repos/CollectionDetailRepository;", "makeCollectionFlowRepos", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionFlowListRepository;", "makeCollectionQueryRepos", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionQueryRepository;", "makeCollectionRecommendFlowRepos", "Lcom/baidu/searchbox/flowvideo/collection/recommend/CollectionRecommendFlowListRepository;", "makeCommonListPanelRepos", "Lcom/baidu/searchbox/flowvideo/hot/repos/CommonListPanelRepository;", "makeFlowBatchRepos", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowBatchRepository;", "makeFlowRepos", "Lcom/baidu/searchbox/flowvideo/flow/repos/FlowListRepository;", "makeFollowPaymentSubscribeRepos", "Lcom/baidu/searchbox/flowvideo/paymentsubscribe/repos/FollowPaymentSubscribeRepository;", "makeGraphicGenreDetailRepos", "Lcom/baidu/searchbox/flowvideo/graphicgenre/repos/GraphicGenreDetailRepository;", "makeHotFlowRepos", "Lcom/baidu/searchbox/flowvideo/hot/repos/HotFlowListRepository;", "makeInterestTagsRepos", "Lcom/baidu/searchbox/flowvideo/interest/repos/InterestTagsRepository;", "makeKuaishouCommandRepos", "Lcom/baidu/searchbox/flowvideo/kuaishoucommand/KuaishouCommandRepository;", "makeOneToNRepos", "Lcom/baidu/searchbox/flowvideo/follow/repos/FollowOneToNRepository;", "makePaymentPanelDetailRepos", "Lcom/baidu/searchbox/flowvideo/paymentpanel/repos/PaymentDetailPanelRepository;", "makePaymentPanelSetsRepos", "Lcom/baidu/searchbox/flowvideo/paymentpanelset/repos/PaymentDetailPanelSetsRepository;", "makePaymentSubscribeStateRepos", "Lcom/baidu/searchbox/flowvideo/payment/repos/PaymentSubscribeStateRepository;", "makePddThirdPartyRepos", "Lcom/baidu/searchbox/flowvideo/thirdparty/repos/PddThirdPartyRepository;", "type", "", "makePersonalizedContentRepos", "Lcom/baidu/searchbox/flowvideo/personalizedcontent/repos/PersonalizedContentRepository;", "makePraiseRepos", "Lcom/baidu/searchbox/flowvideo/praise/repos/PraiseRepository;", "makeQuerySpecialRepos", "Lcom/baidu/searchbox/flowvideo/queryspecial/repos/QuerySpecialRepository;", "makeRelatedRecommendRepos", "Lcom/baidu/searchbox/flowvideo/recommend/repos/RelatedRecommendPanelRepository;", "makeSearchRecommendRepos", "Lcom/baidu/searchbox/flowvideo/searchrecommend/repo/SearchRecommendRepository;", "makeShortPlayAutoUnlockRepos", "Lcom/baidu/searchbox/flowvideo/shortplayautounlock/repos/ShortPlayAutoUnlockRepository;", "makeShortPlayMoreRepos", "Lcom/baidu/searchbox/flowvideo/shortplaymore/repos/ShortPlayMoreRepository;", "makeShortPlayPaymentRepos", "Lcom/baidu/searchbox/flowvideo/shortplaypayment/repos/ShortPlayPaymentRepository;", "makeSimilarCollectionFlowRepos", "Lcom/baidu/searchbox/flowvideo/similarcollection/repos/SimilarCollectionListRepository;", "makeSmartInsertRepos", "Lcom/baidu/searchbox/flowvideo/flow/repos/SmartInsertRepository;", "makeTheaterFlowRepos", "Lcom/baidu/searchbox/flowvideo/theater/repos/TheaterFlowRepository;", "makeThirdPartyRepos", "Lcom/baidu/searchbox/flowvideo/thirdparty/repos/ThirdPartyRepository;", "makeTtsFlowRepos", "isRecommend", "", "makeUfoRepos", "Lcom/baidu/searchbox/flowvideo/ufo/repos/UfoRepository;", "makeVideoAuthenticationRepos", "Lcom/baidu/searchbox/flowvideo/videoauthentication/repos/VideoAuthenticationRepository;", "makeVideoSimulateCUIDRepos", "Lcom/baidu/searchbox/flowvideo/simulate/VideoSimulateCUIDRepository;", "makeVideoSimulateRepos", "Lcom/baidu/searchbox/flowvideo/simulate/VideoSimulateRepository;", "Empty", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RepositoryFactory.kt */
public interface RepositoryFactory {
    AssessmentCardRepository getAssessmentCardRepos();

    DynamicDetailRepository getDynamicDetailRepos();

    FlowDetailRepository getFlowDetailRepos();

    LiveBannerRepository getLiveBannerRepos();

    LiveStatusRepository getLiveStatusRepos();

    AuthenticationRepository makeAuthenticationRepos();

    CelebrityRecognitionRepository makeCelebrityRecognitionRepos();

    CollectionDetailRepository makeCollectionDetailRepos();

    CollectionFlowListRepository makeCollectionFlowRepos();

    CollectionQueryRepository makeCollectionQueryRepos();

    CollectionRecommendFlowListRepository makeCollectionRecommendFlowRepos();

    CommonListPanelRepository makeCommonListPanelRepos();

    FlowBatchRepository makeFlowBatchRepos();

    FlowListRepository makeFlowRepos();

    FollowPaymentSubscribeRepository makeFollowPaymentSubscribeRepos();

    GraphicGenreDetailRepository makeGraphicGenreDetailRepos();

    HotFlowListRepository makeHotFlowRepos();

    InterestTagsRepository makeInterestTagsRepos();

    KuaishouCommandRepository makeKuaishouCommandRepos();

    FollowOneToNRepository makeOneToNRepos();

    PaymentDetailPanelRepository makePaymentPanelDetailRepos();

    PaymentDetailPanelSetsRepository makePaymentPanelSetsRepos();

    PaymentSubscribeStateRepository makePaymentSubscribeStateRepos();

    PddThirdPartyRepository makePddThirdPartyRepos(String str);

    PersonalizedContentRepository makePersonalizedContentRepos();

    PraiseRepository makePraiseRepos();

    QuerySpecialRepository makeQuerySpecialRepos();

    RelatedRecommendPanelRepository makeRelatedRecommendRepos();

    SearchRecommendRepository makeSearchRecommendRepos();

    ShortPlayAutoUnlockRepository makeShortPlayAutoUnlockRepos();

    ShortPlayMoreRepository makeShortPlayMoreRepos();

    ShortPlayPaymentRepository makeShortPlayPaymentRepos();

    SimilarCollectionListRepository makeSimilarCollectionFlowRepos();

    SmartInsertRepository makeSmartInsertRepos();

    TheaterFlowRepository makeTheaterFlowRepos();

    ThirdPartyRepository makeThirdPartyRepos();

    FlowListRepository makeTtsFlowRepos(boolean z);

    UfoRepository makeUfoRepos();

    VideoAuthenticationRepository makeVideoAuthenticationRepos();

    VideoSimulateCUIDRepository makeVideoSimulateCUIDRepos();

    VideoSimulateRepository makeVideoSimulateRepos();

    @Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\n\u00107\u001a\u0004\u0018\u000108H\u0016J\n\u00109\u001a\u0004\u0018\u00010:H\u0016J\n\u0010;\u001a\u0004\u0018\u00010<H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\n\u0010?\u001a\u0004\u0018\u00010@H\u0016J\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\n\u0010C\u001a\u0004\u0018\u00010DH\u0016J\n\u0010E\u001a\u0004\u0018\u00010FH\u0016J\n\u0010G\u001a\u0004\u0018\u00010HH\u0016J\n\u0010I\u001a\u0004\u0018\u00010JH\u0016J\n\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0012\u0010M\u001a\u0004\u0018\u00010\u001e2\u0006\u0010N\u001a\u00020OH\u0016J\n\u0010P\u001a\u0004\u0018\u00010QH\u0016J\n\u0010R\u001a\u0004\u0018\u00010SH\u0016J\n\u0010T\u001a\u0004\u0018\u00010UH\u0016J\n\u0010V\u001a\u0004\u0018\u00010WH\u0016¨\u0006X"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/di/RepositoryFactory$Empty;", "Lcom/baidu/searchbox/video/feedflow/di/RepositoryFactory;", "()V", "getAssessmentCardRepos", "Lcom/baidu/searchbox/flowvideo/assessment/repos/AssessmentCardRepository;", "getDynamicDetailRepos", "Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicDetailRepository;", "getFlowDetailRepos", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailRepository;", "getLiveBannerRepos", "Lcom/baidu/searchbox/flowvideo/livebanner/repos/LiveBannerRepository;", "getLiveStatusRepos", "Lcom/baidu/searchbox/flowvideo/livestatus/repos/LiveStatusRepository;", "makeAuthenticationRepos", "Lcom/baidu/searchbox/flowvideo/authentication/repos/AuthenticationRepository;", "makeCelebrityRecognitionRepos", "Lcom/baidu/searchbox/flowvideo/recognition/repos/CelebrityRecognitionRepository;", "makeCollectionDetailRepos", "Lcom/baidu/searchbox/collectiondetail/repos/CollectionDetailRepository;", "makeCollectionFlowRepos", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionFlowListRepository;", "makeCollectionQueryRepos", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionQueryRepository;", "makeCollectionRecommendFlowRepos", "Lcom/baidu/searchbox/flowvideo/collection/recommend/CollectionRecommendFlowListRepository;", "makeCommonListPanelRepos", "Lcom/baidu/searchbox/flowvideo/hot/repos/CommonListPanelRepository;", "makeFlowBatchRepos", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowBatchRepository;", "makeFlowRepos", "Lcom/baidu/searchbox/flowvideo/flow/repos/FlowListRepository;", "makeFollowPaymentSubscribeRepos", "Lcom/baidu/searchbox/flowvideo/paymentsubscribe/repos/FollowPaymentSubscribeRepository;", "makeGraphicGenreDetailRepos", "Lcom/baidu/searchbox/flowvideo/graphicgenre/repos/GraphicGenreDetailRepository;", "makeHotFlowRepos", "Lcom/baidu/searchbox/flowvideo/hot/repos/HotFlowListRepository;", "makeInterestTagsRepos", "Lcom/baidu/searchbox/flowvideo/interest/repos/InterestTagsRepository;", "makeKuaishouCommandRepos", "Lcom/baidu/searchbox/flowvideo/kuaishoucommand/KuaishouCommandRepository;", "makeOneToNRepos", "Lcom/baidu/searchbox/flowvideo/follow/repos/FollowOneToNRepository;", "makePaymentPanelDetailRepos", "Lcom/baidu/searchbox/flowvideo/paymentpanel/repos/PaymentDetailPanelRepository;", "makePaymentPanelSetsRepos", "Lcom/baidu/searchbox/flowvideo/paymentpanelset/repos/PaymentDetailPanelSetsRepository;", "makePaymentSubscribeStateRepos", "Lcom/baidu/searchbox/flowvideo/payment/repos/PaymentSubscribeStateRepository;", "makePddThirdPartyRepos", "Lcom/baidu/searchbox/flowvideo/thirdparty/repos/PddThirdPartyRepository;", "type", "", "makePersonalizedContentRepos", "Lcom/baidu/searchbox/flowvideo/personalizedcontent/repos/PersonalizedContentRepository;", "makePraiseRepos", "Lcom/baidu/searchbox/flowvideo/praise/repos/PraiseRepository;", "makeQuerySpecialRepos", "Lcom/baidu/searchbox/flowvideo/queryspecial/repos/QuerySpecialRepository;", "makeRelatedRecommendRepos", "Lcom/baidu/searchbox/flowvideo/recommend/repos/RelatedRecommendPanelRepository;", "makeSearchRecommendRepos", "Lcom/baidu/searchbox/flowvideo/searchrecommend/repo/SearchRecommendRepository;", "makeShortPlayAutoUnlockRepos", "Lcom/baidu/searchbox/flowvideo/shortplayautounlock/repos/ShortPlayAutoUnlockRepository;", "makeShortPlayMoreRepos", "Lcom/baidu/searchbox/flowvideo/shortplaymore/repos/ShortPlayMoreRepository;", "makeShortPlayPaymentRepos", "Lcom/baidu/searchbox/flowvideo/shortplaypayment/repos/ShortPlayPaymentRepository;", "makeSimilarCollectionFlowRepos", "Lcom/baidu/searchbox/flowvideo/similarcollection/repos/SimilarCollectionListRepository;", "makeSmartInsertRepos", "Lcom/baidu/searchbox/flowvideo/flow/repos/SmartInsertRepository;", "makeTheaterFlowRepos", "Lcom/baidu/searchbox/flowvideo/theater/repos/TheaterFlowRepository;", "makeThirdPartyRepos", "Lcom/baidu/searchbox/flowvideo/thirdparty/repos/ThirdPartyRepository;", "makeTtsFlowRepos", "isRecommend", "", "makeUfoRepos", "Lcom/baidu/searchbox/flowvideo/ufo/repos/UfoRepository;", "makeVideoAuthenticationRepos", "Lcom/baidu/searchbox/flowvideo/videoauthentication/repos/VideoAuthenticationRepository;", "makeVideoSimulateCUIDRepos", "Lcom/baidu/searchbox/flowvideo/simulate/VideoSimulateCUIDRepository;", "makeVideoSimulateRepos", "Lcom/baidu/searchbox/flowvideo/simulate/VideoSimulateRepository;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RepositoryFactory.kt */
    public static final class Empty implements RepositoryFactory {
        public FlowListRepository makeFlowRepos() {
            return null;
        }

        public CollectionFlowListRepository makeCollectionFlowRepos() {
            return null;
        }

        public SimilarCollectionListRepository makeSimilarCollectionFlowRepos() {
            return null;
        }

        public HotFlowListRepository makeHotFlowRepos() {
            return null;
        }

        public TheaterFlowRepository makeTheaterFlowRepos() {
            return null;
        }

        public CommonListPanelRepository makeCommonListPanelRepos() {
            return null;
        }

        public CollectionDetailRepository makeCollectionDetailRepos() {
            return null;
        }

        public FlowDetailRepository getFlowDetailRepos() {
            return null;
        }

        public PraiseRepository makePraiseRepos() {
            return null;
        }

        public UfoRepository makeUfoRepos() {
            return null;
        }

        public FollowOneToNRepository makeOneToNRepos() {
            return null;
        }

        public SmartInsertRepository makeSmartInsertRepos() {
            return null;
        }

        public FlowBatchRepository makeFlowBatchRepos() {
            return null;
        }

        public PddThirdPartyRepository makePddThirdPartyRepos(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return null;
        }

        public InterestTagsRepository makeInterestTagsRepos() {
            return null;
        }

        public AuthenticationRepository makeAuthenticationRepos() {
            return null;
        }

        public DynamicDetailRepository getDynamicDetailRepos() {
            return null;
        }

        public AssessmentCardRepository getAssessmentCardRepos() {
            return null;
        }

        public LiveStatusRepository getLiveStatusRepos() {
            return null;
        }

        public LiveBannerRepository getLiveBannerRepos() {
            return null;
        }

        public ThirdPartyRepository makeThirdPartyRepos() {
            return null;
        }

        public PaymentSubscribeStateRepository makePaymentSubscribeStateRepos() {
            return null;
        }

        public FollowPaymentSubscribeRepository makeFollowPaymentSubscribeRepos() {
            return null;
        }

        public RelatedRecommendPanelRepository makeRelatedRecommendRepos() {
            return null;
        }

        public FlowListRepository makeTtsFlowRepos(boolean isRecommend) {
            return null;
        }

        public SearchRecommendRepository makeSearchRecommendRepos() {
            return null;
        }

        public VideoSimulateRepository makeVideoSimulateRepos() {
            return null;
        }

        public VideoSimulateCUIDRepository makeVideoSimulateCUIDRepos() {
            return null;
        }

        public KuaishouCommandRepository makeKuaishouCommandRepos() {
            return null;
        }

        public CollectionRecommendFlowListRepository makeCollectionRecommendFlowRepos() {
            return null;
        }

        public ShortPlayPaymentRepository makeShortPlayPaymentRepos() {
            return null;
        }

        public ShortPlayAutoUnlockRepository makeShortPlayAutoUnlockRepos() {
            return null;
        }

        public ShortPlayMoreRepository makeShortPlayMoreRepos() {
            return null;
        }

        public PaymentDetailPanelRepository makePaymentPanelDetailRepos() {
            return null;
        }

        public PaymentDetailPanelSetsRepository makePaymentPanelSetsRepos() {
            return null;
        }

        public CelebrityRecognitionRepository makeCelebrityRecognitionRepos() {
            return null;
        }

        public QuerySpecialRepository makeQuerySpecialRepos() {
            return null;
        }

        public PersonalizedContentRepository makePersonalizedContentRepos() {
            return null;
        }

        public VideoAuthenticationRepository makeVideoAuthenticationRepos() {
            return null;
        }

        public GraphicGenreDetailRepository makeGraphicGenreDetailRepos() {
            return null;
        }

        public CollectionQueryRepository makeCollectionQueryRepos() {
            return null;
        }
    }
}
