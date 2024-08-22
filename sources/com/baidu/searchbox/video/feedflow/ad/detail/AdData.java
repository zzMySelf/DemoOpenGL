package com.baidu.searchbox.video.feedflow.ad.detail;

import com.baidu.browser.core.data.BdDXXmlParser;
import com.baidu.nadcore.aiInteraction.model.NadAiInteractionItemModel;
import com.baidu.nadcore.carousel.NadCarouselItemModel;
import com.baidu.nadcore.model.NadFullScreenModel;
import com.baidu.nadcore.model.NadMountTagModel;
import com.baidu.nadcore.model.NadRotationPopModel;
import com.baidu.nadcore.model.NadSlidingTagModel;
import com.baidu.nadcore.model.NadStructureTagModel;
import com.baidu.nadcore.tailframe.NadImageTailFrameModel;
import com.baidu.nadcore.videoextra.model.NadHighLightTextModel;
import com.baidu.searchbox.ad.charge.AdAreaInfo;
import com.baidu.searchbox.ad.model.AdNormandyModel;
import com.baidu.searchbox.ad.model.FeedAdOperate;
import com.baidu.searchbox.ad.model.NadRecTag;
import com.baidu.searchbox.ad.model.NadSicilyModel;
import com.baidu.searchbox.ad.model.NadTag;
import com.baidu.searchbox.feed.ad.model.AdExt;
import com.baidu.searchbox.feed.ad.model.AdInfo;
import com.baidu.searchbox.feed.ad.model.AdLpParams;
import com.baidu.searchbox.feed.ad.model.CommentNadTitleData;
import com.baidu.searchbox.feed.ad.model.ExtData;
import com.baidu.searchbox.feed.ad.model.NadDoubleButtonsModel;
import com.baidu.searchbox.feed.ad.model.TailFrame;
import com.baidu.searchbox.flowvideo.ad.api.SvButton;
import com.baidu.searchbox.flowvideo.detail.repos.LiveEntranceModel;
import com.baidu.searchbox.flowvideo.detail.repos.LiveInteractModel;
import com.baidu.searchbox.nps.INpsPluginLoaderKt;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.ad.adextend.AdExtend;
import com.baidu.searchbox.video.feedflow.ad.adreminder.NadReminderModel;
import com.baidu.searchbox.video.feedflow.ad.bottombanner.NadBottomBannerModel;
import com.baidu.searchbox.video.feedflow.ad.componenttypeswitch.ComponentTypeSwitchModel;
import com.baidu.searchbox.video.feedflow.ad.dynamic.NadDynamicModel;
import com.baidu.searchbox.video.feedflow.ad.landscape.background.LandscapeBg;
import com.baidu.searchbox.video.feedflow.ad.lottie.FlowAdLottieModel;
import com.baidu.searchbox.video.feedflow.ad.lottie.guidelottie.NadGuideLottieModel;
import com.baidu.searchbox.video.feedflow.ad.summary.NadSummaryTitleModel;
import com.baidu.searchbox.video.feedflow.ad.summary.expand.NadExpandHotAreaModel;
import com.baidu.searchbox.video.feedflow.ad.timeinvoke.AdTimeInvokeCmdModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000«\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\bÙ\u0001\b\b\u0018\u00002\u00020\u0001B£\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010$\u001a\u00020\u0016\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010'\u001a\u00020\u0016\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*\u0012\b\b\u0002\u0010+\u001a\u00020\u0016\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010*\u0012\b\b\u0002\u00101\u001a\u00020\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010:\u001a\u00020;\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010>\u001a\u00020;\u0012\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010B\u001a\u00020;\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010F\u001a\u00020;\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010J\u001a\u00020\u0016\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010M\u001a\u00020\u0003\u0012\b\b\u0002\u0010N\u001a\u00020;\u0012\b\b\u0002\u0010O\u001a\u00020;\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010W\u001a\u00020;\u0012\b\b\u0002\u0010X\u001a\u00020;\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\\u0012\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010*\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a\u0012\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*\u0012\b\b\u0002\u0010c\u001a\u00020;\u0012\b\b\u0002\u0010d\u001a\u00020;\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010f\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h\u0012\b\b\u0002\u0010i\u001a\u00020\u0016\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010k\u0012\u0010\b\u0002\u0010l\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010*\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010o\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010q\u0012\b\b\u0002\u0010r\u001a\u00020\u0003\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010t\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010v\u001a\u00020\u0016\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010x¢\u0006\u0002\u0010yJ\u0012\u0010ý\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0003\u0010ø\u0001J\f\u0010þ\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0016HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0016HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010 HÆ\u0003J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0003\u0010ø\u0001J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0016HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010&HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0016HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0012\u0010\u0002\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010*HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u000103HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u000105HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u000107HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u000109HÆ\u0003J\n\u0010\u0002\u001a\u00020;HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010=HÆ\u0003J\n\u0010\u0002\u001a\u00020;HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0012\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*HÆ\u0003J\f\u0010 \u0002\u001a\u0004\u0018\u00010AHÆ\u0003J\n\u0010¡\u0002\u001a\u00020;HÆ\u0003J\f\u0010¢\u0002\u001a\u0004\u0018\u00010DHÆ\u0003J\f\u0010£\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\n\u0010¤\u0002\u001a\u00020;HÆ\u0003J\u0012\u0010¥\u0002\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*HÆ\u0003J\f\u0010¦\u0002\u001a\u0004\u0018\u00010IHÆ\u0003J\n\u0010§\u0002\u001a\u00020\u0016HÆ\u0003J\f\u0010¨\u0002\u001a\u0004\u0018\u00010LHÆ\u0003J\f\u0010©\u0002\u001a\u0004\u0018\u00010\nHÆ\u0003J\n\u0010ª\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010«\u0002\u001a\u00020;HÆ\u0003J\n\u0010¬\u0002\u001a\u00020;HÆ\u0003J\f\u0010­\u0002\u001a\u0004\u0018\u00010QHÆ\u0003J\f\u0010®\u0002\u001a\u0004\u0018\u00010SHÆ\u0003J\f\u0010¯\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010°\u0002\u001a\u0004\u0018\u00010VHÆ\u0003J\n\u0010±\u0002\u001a\u00020;HÆ\u0003J\n\u0010²\u0002\u001a\u00020;HÆ\u0003J\f\u0010³\u0002\u001a\u0004\u0018\u00010ZHÆ\u0003J\n\u0010´\u0002\u001a\u00020\u0003HÆ\u0003J\f\u0010µ\u0002\u001a\u0004\u0018\u00010\\HÆ\u0003J\u0012\u0010¶\u0002\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010*HÆ\u0003J\f\u0010·\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010¸\u0002\u001a\u0004\u0018\u00010aHÆ\u0003J\u0012\u0010¹\u0002\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*HÆ\u0003J\n\u0010º\u0002\u001a\u00020;HÆ\u0003J\n\u0010»\u0002\u001a\u00020;HÆ\u0003J\f\u0010¼\u0002\u001a\u0004\u0018\u00010fHÆ\u0003J\f\u0010½\u0002\u001a\u0004\u0018\u00010hHÆ\u0003J\n\u0010¾\u0002\u001a\u00020\u0016HÆ\u0003J\n\u0010¿\u0002\u001a\u00020\u0003HÆ\u0003J\f\u0010À\u0002\u001a\u0004\u0018\u00010kHÆ\u0003J\u0012\u0010Á\u0002\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010*HÆ\u0003J\f\u0010Â\u0002\u001a\u0004\u0018\u00010oHÆ\u0003J\f\u0010Ã\u0002\u001a\u0004\u0018\u00010qHÆ\u0003J\n\u0010Ä\u0002\u001a\u00020\u0003HÆ\u0003J\f\u0010Å\u0002\u001a\u0004\u0018\u00010tHÆ\u0003J\f\u0010Æ\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\n\u0010Ç\u0002\u001a\u00020\u0016HÆ\u0003J\f\u0010È\u0002\u001a\u0004\u0018\u00010xHÆ\u0003J\f\u0010É\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\f\u0010Ê\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003J®\u0007\u0010Ë\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u00162\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010'\u001a\u00020\u00162\b\b\u0002\u0010(\u001a\u00020\u00032\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\u00162\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010*2\b\b\u0002\u00101\u001a\u00020\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\b\b\u0002\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010>\u001a\u00020;2\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\b\b\u0002\u0010B\u001a\u00020;2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010F\u001a\u00020;2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\b\b\u0002\u0010J\u001a\u00020\u00162\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\b\b\u0002\u0010M\u001a\u00020\u00032\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010S2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V2\b\b\u0002\u0010W\u001a\u00020;2\b\b\u0002\u0010X\u001a\u00020;2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010*2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*2\b\b\u0002\u0010c\u001a\u00020;2\b\b\u0002\u0010d\u001a\u00020;2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010f2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\b\b\u0002\u0010i\u001a\u00020\u00162\n\b\u0002\u0010j\u001a\u0004\u0018\u00010k2\u0010\b\u0002\u0010l\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010*2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010q2\b\b\u0002\u0010r\u001a\u00020\u00032\n\b\u0002\u0010s\u001a\u0004\u0018\u00010t2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010v\u001a\u00020\u00162\n\b\u0002\u0010w\u001a\u0004\u0018\u00010xHÆ\u0001¢\u0006\u0003\u0010Ì\u0002J\u0015\u0010Í\u0002\u001a\u00020;2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010Ï\u0002\u001a\u00020\u0003HÖ\u0001J\n\u0010Ð\u0002\u001a\u00020\u0016HÖ\u0001R\u0013\u0010g\u001a\u0004\u0018\u00010h¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0013\u0010U\u001a\u0004\u0018\u00010V¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b~\u0010R\u0015\u0010e\u001a\u0004\u0018\u00010f¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010C\u001a\u0004\u0018\u00010D¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010j\u001a\u0004\u0018\u00010k¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0013\u0010(\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R&\u0010l\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010*X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0013\u0010+\u001a\u00020\u0016¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010P\u001a\u0004\u0018\u00010Q¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0013\u00101\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0013\u0010X\u001a\u00020;¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R \u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0013\u0010:\u001a\u00020;¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0015\u0010K\u001a\u0004\u0018\u00010L¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010 \u0001R\u0015\u0010.\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010\u0001R\u0015\u0010,\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010\u0001R\u0015\u0010<\u001a\u0004\u0018\u00010=¢\u0006\n\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001R\u0013\u0010J\u001a\u00020\u0016¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010\u0001R \u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R\u0015\u0010E\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0000\u001a\u0006\bª\u0001\u0010\u0001R\u0013\u0010i\u001a\u00020\u0016¢\u0006\n\n\u0000\u001a\u0006\b«\u0001\u0010\u0001R\u001b\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\b¬\u0001\u0010\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0000\u001a\u0006\b­\u0001\u0010®\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001R\u0013\u0010M\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b±\u0001\u0010\u0001R\u0013\u0010d\u001a\u00020;¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010\u0001R\u0013\u0010c\u001a\u00020;¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010\u0001R\u0015\u0010`\u001a\u0004\u0018\u00010a¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001R\u0015\u0010s\u001a\u0004\u0018\u00010t¢\u0006\n\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001R\u0013\u0010N\u001a\u00020;¢\u0006\n\n\u0000\u001a\u0006\b¸\u0001\u0010\u0001R\u0015\u0010p\u001a\u0004\u0018\u00010q¢\u0006\n\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001R\u0012\u0010W\u001a\u00020;¢\u0006\t\n\u0000\u001a\u0005\bW\u0010\u0001R\u0012\u0010O\u001a\u00020;¢\u0006\t\n\u0000\u001a\u0005\bO\u0010\u0001R\u0012\u0010'\u001a\u00020\u0016¢\u0006\t\n\u0000\u001a\u0005\b'\u0010\u0001R\u0015\u0010w\u001a\u0004\u0018\u00010x¢\u0006\n\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0000\u001a\u0006\b½\u0001\u0010\u0001R\u0013\u0010>\u001a\u00020;¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010\u0001R\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001R\u0015\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0015\u0010_\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0000\u001a\u0006\bÃ\u0001\u0010\u0001R\u0015\u0010u\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0000\u001a\u0006\bÄ\u0001\u0010\u0001R\u0013\u0010!\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010\u0001R\u0013\u0010$\u001a\u00020\u0016¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010\u0001R\u0015\u0010@\u001a\u0004\u0018\u00010A¢\u0006\n\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001R\u0013\u0010\u001c\u001a\u00020\u0016¢\u0006\n\n\u0000\u001a\u0006\bÉ\u0001\u0010\u0001R\u0013\u0010r\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\bÊ\u0001\u0010\u0001R \u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R\u0013\u0010B\u001a\u00020;¢\u0006\n\n\u0000\u001a\u0006\bÏ\u0001\u0010\u0001R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0000\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0000\u001a\u0006\bÒ\u0001\u0010Ó\u0001R \u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R\u0013\u0010v\u001a\u00020\u0016¢\u0006\n\n\u0000\u001a\u0006\bØ\u0001\u0010\u0001R\u001b\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\bÙ\u0001\u0010\u0001R\u0013\u0010\u001b\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\bÚ\u0001\u0010\u0001R\u001b\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\bÛ\u0001\u0010\u0001R\u0015\u0010-\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0000\u001a\u0006\bÜ\u0001\u0010\u0001R\u001b\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\bÝ\u0001\u0010\u0001R\u0015\u0010T\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0000\u001a\u0006\bÞ\u0001\u0010\u0001R\u0015\u0010R\u001a\u0004\u0018\u00010S¢\u0006\n\n\u0000\u001a\u0006\bß\u0001\u0010à\u0001R\u0015\u00104\u001a\u0004\u0018\u000105¢\u0006\n\n\u0000\u001a\u0006\bá\u0001\u0010â\u0001R\u0015\u00106\u001a\u0004\u0018\u000107¢\u0006\n\n\u0000\u001a\u0006\bã\u0001\u0010ä\u0001R \u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bå\u0001\u0010æ\u0001\"\u0006\bç\u0001\u0010è\u0001R\u0013\u0010F\u001a\u00020;¢\u0006\n\n\u0000\u001a\u0006\bé\u0001\u0010\u0001R\u0015\u00102\u001a\u0004\u0018\u000103¢\u0006\n\n\u0000\u001a\u0006\bê\u0001\u0010ë\u0001R \u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bì\u0001\u0010í\u0001\"\u0006\bî\u0001\u0010ï\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0000\u001a\u0006\bð\u0001\u0010ñ\u0001R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\bò\u0001\u0010\u0001R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\bó\u0001\u0010\u0001R\u001b\u0010]\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\bô\u0001\u0010\u0001R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0000\u001a\u0006\bõ\u0001\u0010\u0001R\u001b\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\bö\u0001\u0010\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\r\n\u0003\u0010ù\u0001\u001a\u0006\b÷\u0001\u0010ø\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\r\n\u0003\u0010ù\u0001\u001a\u0006\bú\u0001\u0010ø\u0001R\u0015\u0010n\u001a\u0004\u0018\u00010o¢\u0006\n\n\u0000\u001a\u0006\bû\u0001\u0010ü\u0001¨\u0006Ñ\u0002"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/detail/AdData;", "", "videoWidth", "", "videoHeight", "operate", "Lcom/baidu/searchbox/ad/model/FeedAdOperate;", "extraInfo", "Lcom/baidu/searchbox/feed/ad/model/AdExt;", "extraData", "Lcom/baidu/searchbox/feed/ad/model/ExtData;", "tailShow", "tailShowAutoPlay", "tailFrame", "Lcom/baidu/searchbox/feed/ad/model/TailFrame;", "enhancement", "Lcom/baidu/searchbox/feed/ad/model/AdLpParams$EnhanceModel;", "normandy", "Lcom/baidu/searchbox/ad/model/AdNormandyModel;", "adInfo", "Lcom/baidu/searchbox/feed/ad/model/AdInfo;", "cmd", "", "popover", "Lcom/baidu/searchbox/feed/ad/model/AdLpParams$PopoverModel;", "areaInfo", "Lcom/baidu/searchbox/ad/charge/AdAreaInfo;", "prefetchUpload", "lpRealUrl", "leftSlideCmd", "titleCmd", "buttons", "Lcom/baidu/searchbox/feed/ad/model/NadDoubleButtonsModel;", "liveState", "liveInteract", "Lcom/baidu/searchbox/flowvideo/detail/repos/LiveInteractModel;", "liveTagText", "liveEntrance", "Lcom/baidu/searchbox/flowvideo/detail/repos/LiveEntranceModel;", "isVerticalScreen", "adVTag", "transformPortraitCmdList", "", "authorCmd", "commentTopSwitch", "prerenderScheme", "commentTop", "recTagList", "Lcom/baidu/searchbox/ad/model/NadRecTag;", "buttonIconExpSwitch", "svButton", "Lcom/baidu/searchbox/flowvideo/ad/api/SvButton;", "sicilyPop", "Lcom/baidu/searchbox/ad/model/NadSicilyModel;", "slidingTag", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "svTitle", "Lcom/baidu/nadcore/videoextra/model/NadHighLightTextModel;", "chargeByAreaOfflineAbSwitch", "", "componentTypeSwitch", "Lcom/baidu/searchbox/video/feedflow/ad/componenttypeswitch/ComponentTypeSwitchModel;", "leftSlideRequestClickUrlSwitch", "prefetchUrlList", "lottieModel", "Lcom/baidu/searchbox/video/feedflow/ad/lottie/FlowAdLottieModel;", "nextCardShow", "adTag", "Lcom/baidu/searchbox/ad/model/NadTag;", "etrade", "supportHorizontalSwitch", "preRenderSchemeList", "mountTag", "Lcom/baidu/nadcore/model/NadMountTagModel;", "contextExt", "commentTitleMount", "Lcom/baidu/searchbox/feed/ad/model/CommentNadTitleData;", "forbidAutoPlayNext", "hasInteractionStrategy", "isScheduledDownload", "bottomEntry", "Lcom/baidu/searchbox/video/feedflow/ad/bottombanner/NadBottomBannerModel;", "rotationPop", "Lcom/baidu/nadcore/model/NadRotationPopModel;", "roomId", "adExtend", "Lcom/baidu/searchbox/video/feedflow/ad/adextend/AdExtend;", "isFromLanscape", "canFollowMove", "structureTag", "Lcom/baidu/nadcore/model/NadStructureTagModel;", "carouselTile", "Lcom/baidu/nadcore/carousel/NadCarouselItemModel;", "timeInvokeCmdList", "Lcom/baidu/searchbox/video/feedflow/ad/timeinvoke/AdTimeInvokeCmdModel;", "liveMataInfo", "fullScreen", "Lcom/baidu/nadcore/model/NadFullScreenModel;", "extendTags", "forbidTailAnim", "forbidPosterWhenShowTail", "adReminder", "Lcom/baidu/searchbox/video/feedflow/ad/adreminder/NadReminderModel;", "adDynamic", "Lcom/baidu/searchbox/video/feedflow/ad/dynamic/NadDynamicModel;", "extLog", "adTitleZone", "Lcom/baidu/searchbox/video/feedflow/ad/summary/NadSummaryTitleModel;", "aiInteractions", "Lcom/baidu/nadcore/aiInteraction/model/NadAiInteractionItemModel;", "zoomClickArea", "Lcom/baidu/searchbox/video/feedflow/ad/summary/expand/NadExpandHotAreaModel;", "imageTailFrame", "Lcom/baidu/nadcore/tailframe/NadImageTailFrameModel;", "materialType", "guideLottie", "Lcom/baidu/searchbox/video/feedflow/ad/lottie/guidelottie/NadGuideLottieModel;", "liveNid", "poster", "landscapeBg", "Lcom/baidu/searchbox/video/feedflow/ad/landscape/background/LandscapeBg;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/baidu/searchbox/ad/model/FeedAdOperate;Lcom/baidu/searchbox/feed/ad/model/AdExt;Lcom/baidu/searchbox/feed/ad/model/ExtData;IILcom/baidu/searchbox/feed/ad/model/TailFrame;Lcom/baidu/searchbox/feed/ad/model/AdLpParams$EnhanceModel;Lcom/baidu/searchbox/ad/model/AdNormandyModel;Lcom/baidu/searchbox/feed/ad/model/AdInfo;Ljava/lang/String;Lcom/baidu/searchbox/feed/ad/model/AdLpParams$PopoverModel;Lcom/baidu/searchbox/ad/charge/AdAreaInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/feed/ad/model/NadDoubleButtonsModel;ILcom/baidu/searchbox/flowvideo/detail/repos/LiveInteractModel;Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/detail/repos/LiveEntranceModel;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/baidu/searchbox/flowvideo/ad/api/SvButton;Lcom/baidu/searchbox/ad/model/NadSicilyModel;Lcom/baidu/nadcore/model/NadSlidingTagModel;Lcom/baidu/nadcore/videoextra/model/NadHighLightTextModel;ZLcom/baidu/searchbox/video/feedflow/ad/componenttypeswitch/ComponentTypeSwitchModel;ZLjava/util/List;Lcom/baidu/searchbox/video/feedflow/ad/lottie/FlowAdLottieModel;ZLcom/baidu/searchbox/ad/model/NadTag;Ljava/lang/String;ZLjava/util/List;Lcom/baidu/nadcore/model/NadMountTagModel;Ljava/lang/String;Lcom/baidu/searchbox/feed/ad/model/CommentNadTitleData;IZZLcom/baidu/searchbox/video/feedflow/ad/bottombanner/NadBottomBannerModel;Lcom/baidu/nadcore/model/NadRotationPopModel;Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/ad/adextend/AdExtend;ZZLcom/baidu/nadcore/model/NadStructureTagModel;Lcom/baidu/nadcore/carousel/NadCarouselItemModel;Ljava/util/List;Ljava/lang/String;Lcom/baidu/nadcore/model/NadFullScreenModel;Ljava/util/List;ZZLcom/baidu/searchbox/video/feedflow/ad/adreminder/NadReminderModel;Lcom/baidu/searchbox/video/feedflow/ad/dynamic/NadDynamicModel;Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/ad/summary/NadSummaryTitleModel;Ljava/util/List;Lcom/baidu/searchbox/video/feedflow/ad/summary/expand/NadExpandHotAreaModel;Lcom/baidu/nadcore/tailframe/NadImageTailFrameModel;ILcom/baidu/searchbox/video/feedflow/ad/lottie/guidelottie/NadGuideLottieModel;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/ad/landscape/background/LandscapeBg;)V", "getAdDynamic", "()Lcom/baidu/searchbox/video/feedflow/ad/dynamic/NadDynamicModel;", "getAdExtend", "()Lcom/baidu/searchbox/video/feedflow/ad/adextend/AdExtend;", "getAdInfo", "()Lcom/baidu/searchbox/feed/ad/model/AdInfo;", "getAdReminder", "()Lcom/baidu/searchbox/video/feedflow/ad/adreminder/NadReminderModel;", "getAdTag", "()Lcom/baidu/searchbox/ad/model/NadTag;", "getAdTitleZone", "()Lcom/baidu/searchbox/video/feedflow/ad/summary/NadSummaryTitleModel;", "getAdVTag", "()I", "getAiInteractions", "()Ljava/util/List;", "setAiInteractions", "(Ljava/util/List;)V", "getAreaInfo", "()Lcom/baidu/searchbox/ad/charge/AdAreaInfo;", "getAuthorCmd", "()Ljava/lang/String;", "getBottomEntry", "()Lcom/baidu/searchbox/video/feedflow/ad/bottombanner/NadBottomBannerModel;", "getButtonIconExpSwitch", "getButtons", "()Lcom/baidu/searchbox/feed/ad/model/NadDoubleButtonsModel;", "getCanFollowMove", "()Z", "getCarouselTile", "()Lcom/baidu/nadcore/carousel/NadCarouselItemModel;", "setCarouselTile", "(Lcom/baidu/nadcore/carousel/NadCarouselItemModel;)V", "getChargeByAreaOfflineAbSwitch", "getCmd", "setCmd", "(Ljava/lang/String;)V", "getCommentTitleMount", "()Lcom/baidu/searchbox/feed/ad/model/CommentNadTitleData;", "getCommentTop", "getCommentTopSwitch", "getComponentTypeSwitch", "()Lcom/baidu/searchbox/video/feedflow/ad/componenttypeswitch/ComponentTypeSwitchModel;", "getContextExt", "getEnhancement", "()Lcom/baidu/searchbox/feed/ad/model/AdLpParams$EnhanceModel;", "setEnhancement", "(Lcom/baidu/searchbox/feed/ad/model/AdLpParams$EnhanceModel;)V", "getEtrade", "getExtLog", "getExtendTags", "getExtraData", "()Lcom/baidu/searchbox/feed/ad/model/ExtData;", "getExtraInfo", "()Lcom/baidu/searchbox/feed/ad/model/AdExt;", "getForbidAutoPlayNext", "getForbidPosterWhenShowTail", "getForbidTailAnim", "getFullScreen", "()Lcom/baidu/nadcore/model/NadFullScreenModel;", "getGuideLottie", "()Lcom/baidu/searchbox/video/feedflow/ad/lottie/guidelottie/NadGuideLottieModel;", "getHasInteractionStrategy", "getImageTailFrame", "()Lcom/baidu/nadcore/tailframe/NadImageTailFrameModel;", "getLandscapeBg", "()Lcom/baidu/searchbox/video/feedflow/ad/landscape/background/LandscapeBg;", "getLeftSlideCmd", "getLeftSlideRequestClickUrlSwitch", "getLiveEntrance", "()Lcom/baidu/searchbox/flowvideo/detail/repos/LiveEntranceModel;", "getLiveInteract", "()Lcom/baidu/searchbox/flowvideo/detail/repos/LiveInteractModel;", "getLiveMataInfo", "getLiveNid", "getLiveState", "getLiveTagText", "getLottieModel", "()Lcom/baidu/searchbox/video/feedflow/ad/lottie/FlowAdLottieModel;", "getLpRealUrl", "getMaterialType", "getMountTag", "()Lcom/baidu/nadcore/model/NadMountTagModel;", "setMountTag", "(Lcom/baidu/nadcore/model/NadMountTagModel;)V", "getNextCardShow", "getNormandy", "()Lcom/baidu/searchbox/ad/model/AdNormandyModel;", "getOperate", "()Lcom/baidu/searchbox/ad/model/FeedAdOperate;", "getPopover", "()Lcom/baidu/searchbox/feed/ad/model/AdLpParams$PopoverModel;", "setPopover", "(Lcom/baidu/searchbox/feed/ad/model/AdLpParams$PopoverModel;)V", "getPoster", "getPreRenderSchemeList", "getPrefetchUpload", "getPrefetchUrlList", "getPrerenderScheme", "getRecTagList", "getRoomId", "getRotationPop", "()Lcom/baidu/nadcore/model/NadRotationPopModel;", "getSicilyPop", "()Lcom/baidu/searchbox/ad/model/NadSicilyModel;", "getSlidingTag", "()Lcom/baidu/nadcore/model/NadSlidingTagModel;", "getStructureTag", "()Lcom/baidu/nadcore/model/NadStructureTagModel;", "setStructureTag", "(Lcom/baidu/nadcore/model/NadStructureTagModel;)V", "getSupportHorizontalSwitch", "getSvButton", "()Lcom/baidu/searchbox/flowvideo/ad/api/SvButton;", "getSvTitle", "()Lcom/baidu/nadcore/videoextra/model/NadHighLightTextModel;", "setSvTitle", "(Lcom/baidu/nadcore/videoextra/model/NadHighLightTextModel;)V", "getTailFrame", "()Lcom/baidu/searchbox/feed/ad/model/TailFrame;", "getTailShow", "getTailShowAutoPlay", "getTimeInvokeCmdList", "getTitleCmd", "getTransformPortraitCmdList", "getVideoHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVideoWidth", "getZoomClickArea", "()Lcom/baidu/searchbox/video/feedflow/ad/summary/expand/NadExpandHotAreaModel;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/baidu/searchbox/ad/model/FeedAdOperate;Lcom/baidu/searchbox/feed/ad/model/AdExt;Lcom/baidu/searchbox/feed/ad/model/ExtData;IILcom/baidu/searchbox/feed/ad/model/TailFrame;Lcom/baidu/searchbox/feed/ad/model/AdLpParams$EnhanceModel;Lcom/baidu/searchbox/ad/model/AdNormandyModel;Lcom/baidu/searchbox/feed/ad/model/AdInfo;Ljava/lang/String;Lcom/baidu/searchbox/feed/ad/model/AdLpParams$PopoverModel;Lcom/baidu/searchbox/ad/charge/AdAreaInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/feed/ad/model/NadDoubleButtonsModel;ILcom/baidu/searchbox/flowvideo/detail/repos/LiveInteractModel;Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/detail/repos/LiveEntranceModel;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/baidu/searchbox/flowvideo/ad/api/SvButton;Lcom/baidu/searchbox/ad/model/NadSicilyModel;Lcom/baidu/nadcore/model/NadSlidingTagModel;Lcom/baidu/nadcore/videoextra/model/NadHighLightTextModel;ZLcom/baidu/searchbox/video/feedflow/ad/componenttypeswitch/ComponentTypeSwitchModel;ZLjava/util/List;Lcom/baidu/searchbox/video/feedflow/ad/lottie/FlowAdLottieModel;ZLcom/baidu/searchbox/ad/model/NadTag;Ljava/lang/String;ZLjava/util/List;Lcom/baidu/nadcore/model/NadMountTagModel;Ljava/lang/String;Lcom/baidu/searchbox/feed/ad/model/CommentNadTitleData;IZZLcom/baidu/searchbox/video/feedflow/ad/bottombanner/NadBottomBannerModel;Lcom/baidu/nadcore/model/NadRotationPopModel;Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/ad/adextend/AdExtend;ZZLcom/baidu/nadcore/model/NadStructureTagModel;Lcom/baidu/nadcore/carousel/NadCarouselItemModel;Ljava/util/List;Ljava/lang/String;Lcom/baidu/nadcore/model/NadFullScreenModel;Ljava/util/List;ZZLcom/baidu/searchbox/video/feedflow/ad/adreminder/NadReminderModel;Lcom/baidu/searchbox/video/feedflow/ad/dynamic/NadDynamicModel;Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/ad/summary/NadSummaryTitleModel;Ljava/util/List;Lcom/baidu/searchbox/video/feedflow/ad/summary/expand/NadExpandHotAreaModel;Lcom/baidu/nadcore/tailframe/NadImageTailFrameModel;ILcom/baidu/searchbox/video/feedflow/ad/lottie/guidelottie/NadGuideLottieModel;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/ad/landscape/background/LandscapeBg;)Lcom/baidu/searchbox/video/feedflow/ad/detail/AdData;", "equals", "other", "hashCode", "toString", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdData.kt */
public final class AdData {
    private final NadDynamicModel adDynamic;
    private final AdExtend adExtend;
    private final AdInfo adInfo;
    private final NadReminderModel adReminder;
    private final NadTag adTag;
    private final NadSummaryTitleModel adTitleZone;
    private final int adVTag;
    private List<NadAiInteractionItemModel> aiInteractions;
    private final AdAreaInfo areaInfo;
    private final String authorCmd;
    private final NadBottomBannerModel bottomEntry;
    private final int buttonIconExpSwitch;
    private final NadDoubleButtonsModel buttons;
    private final boolean canFollowMove;
    private NadCarouselItemModel carouselTile;
    private final boolean chargeByAreaOfflineAbSwitch;
    private String cmd;
    private final CommentNadTitleData commentTitleMount;
    private final String commentTop;
    private final String commentTopSwitch;
    private final ComponentTypeSwitchModel componentTypeSwitch;
    private final String contextExt;
    private AdLpParams.EnhanceModel enhancement;
    private final String etrade;
    private final String extLog;
    private final List<String> extendTags;
    private final ExtData extraData;
    private final AdExt extraInfo;
    private final int forbidAutoPlayNext;
    private final boolean forbidPosterWhenShowTail;
    private final boolean forbidTailAnim;
    private final NadFullScreenModel fullScreen;
    private final NadGuideLottieModel guideLottie;
    private final boolean hasInteractionStrategy;
    private final NadImageTailFrameModel imageTailFrame;
    private final boolean isFromLanscape;
    private final boolean isScheduledDownload;
    private final String isVerticalScreen;
    private final LandscapeBg landscapeBg;
    private final String leftSlideCmd;
    private final boolean leftSlideRequestClickUrlSwitch;
    private final LiveEntranceModel liveEntrance;
    private final LiveInteractModel liveInteract;
    private final String liveMataInfo;
    private final String liveNid;
    private final int liveState;
    private final String liveTagText;
    private final FlowAdLottieModel lottieModel;
    private final String lpRealUrl;
    private final int materialType;
    private NadMountTagModel mountTag;
    private final boolean nextCardShow;
    private final AdNormandyModel normandy;
    private final FeedAdOperate operate;
    private AdLpParams.PopoverModel popover;
    private final String poster;
    private final List<String> preRenderSchemeList;
    private final int prefetchUpload;
    private final List<String> prefetchUrlList;
    private final String prerenderScheme;
    private final List<NadRecTag> recTagList;
    private final String roomId;
    private final NadRotationPopModel rotationPop;
    private final NadSicilyModel sicilyPop;
    private final NadSlidingTagModel slidingTag;
    private NadStructureTagModel structureTag;
    private final boolean supportHorizontalSwitch;
    private final SvButton svButton;
    private NadHighLightTextModel svTitle;
    private final TailFrame tailFrame;
    private final int tailShow;
    private final int tailShowAutoPlay;
    private final List<AdTimeInvokeCmdModel> timeInvokeCmdList;
    private final String titleCmd;
    private final List<String> transformPortraitCmdList;
    private final Integer videoHeight;
    private final Integer videoWidth;
    private final NadExpandHotAreaModel zoomClickArea;

    public AdData() {
        this((Integer) null, (Integer) null, (FeedAdOperate) null, (AdExt) null, (ExtData) null, 0, 0, (TailFrame) null, (AdLpParams.EnhanceModel) null, (AdNormandyModel) null, (AdInfo) null, (String) null, (AdLpParams.PopoverModel) null, (AdAreaInfo) null, 0, (String) null, (String) null, (String) null, (NadDoubleButtonsModel) null, 0, (LiveInteractModel) null, (String) null, (LiveEntranceModel) null, (String) null, 0, (List) null, (String) null, (String) null, (String) null, (String) null, (List) null, 0, (SvButton) null, (NadSicilyModel) null, (NadSlidingTagModel) null, (NadHighLightTextModel) null, false, (ComponentTypeSwitchModel) null, false, (List) null, (FlowAdLottieModel) null, false, (NadTag) null, (String) null, false, (List) null, (NadMountTagModel) null, (String) null, (CommentNadTitleData) null, 0, false, false, (NadBottomBannerModel) null, (NadRotationPopModel) null, (String) null, (AdExtend) null, false, false, (NadStructureTagModel) null, (NadCarouselItemModel) null, (List) null, (String) null, (NadFullScreenModel) null, (List) null, false, false, (NadReminderModel) null, (NadDynamicModel) null, (String) null, (NadSummaryTitleModel) null, (List) null, (NadExpandHotAreaModel) null, (NadImageTailFrameModel) null, 0, (NadGuideLottieModel) null, (String) null, (String) null, (LandscapeBg) null, -1, -1, BdDXXmlParser.BYTE_2_PROPERTY, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdData copy$default(AdData adData, Integer num, Integer num2, FeedAdOperate feedAdOperate, AdExt adExt, ExtData extData, int i2, int i3, TailFrame tailFrame2, AdLpParams.EnhanceModel enhanceModel, AdNormandyModel adNormandyModel, AdInfo adInfo2, String str, AdLpParams.PopoverModel popoverModel, AdAreaInfo adAreaInfo, int i4, String str2, String str3, String str4, NadDoubleButtonsModel nadDoubleButtonsModel, int i5, LiveInteractModel liveInteractModel, String str5, LiveEntranceModel liveEntranceModel, String str6, int i6, List list, String str7, String str8, String str9, String str10, List list2, int i7, SvButton svButton2, NadSicilyModel nadSicilyModel, NadSlidingTagModel nadSlidingTagModel, NadHighLightTextModel nadHighLightTextModel, boolean z, ComponentTypeSwitchModel componentTypeSwitchModel, boolean z2, List list3, FlowAdLottieModel flowAdLottieModel, boolean z3, NadTag nadTag, String str11, boolean z4, List list4, NadMountTagModel nadMountTagModel, String str12, CommentNadTitleData commentNadTitleData, int i8, boolean z5, boolean z6, NadBottomBannerModel nadBottomBannerModel, NadRotationPopModel nadRotationPopModel, String str13, AdExtend adExtend2, boolean z7, boolean z8, NadStructureTagModel nadStructureTagModel, NadCarouselItemModel nadCarouselItemModel, List list5, String str14, NadFullScreenModel nadFullScreenModel, List list6, boolean z9, boolean z10, NadReminderModel nadReminderModel, NadDynamicModel nadDynamicModel, String str15, NadSummaryTitleModel nadSummaryTitleModel, List list7, NadExpandHotAreaModel nadExpandHotAreaModel, NadImageTailFrameModel nadImageTailFrameModel, int i9, NadGuideLottieModel nadGuideLottieModel, String str16, String str17, LandscapeBg landscapeBg2, int i10, int i11, int i12, Object obj) {
        AdData adData2 = adData;
        int i13 = i10;
        int i14 = i11;
        int i15 = i12;
        return adData.copy((i13 & 1) != 0 ? adData2.videoWidth : num, (i13 & 2) != 0 ? adData2.videoHeight : num2, (i13 & 4) != 0 ? adData2.operate : feedAdOperate, (i13 & 8) != 0 ? adData2.extraInfo : adExt, (i13 & 16) != 0 ? adData2.extraData : extData, (i13 & 32) != 0 ? adData2.tailShow : i2, (i13 & 64) != 0 ? adData2.tailShowAutoPlay : i3, (i13 & 128) != 0 ? adData2.tailFrame : tailFrame2, (i13 & 256) != 0 ? adData2.enhancement : enhanceModel, (i13 & 512) != 0 ? adData2.normandy : adNormandyModel, (i13 & 1024) != 0 ? adData2.adInfo : adInfo2, (i13 & 2048) != 0 ? adData2.cmd : str, (i13 & 4096) != 0 ? adData2.popover : popoverModel, (i13 & 8192) != 0 ? adData2.areaInfo : adAreaInfo, (i13 & 16384) != 0 ? adData2.prefetchUpload : i4, (i13 & 32768) != 0 ? adData2.lpRealUrl : str2, (i13 & 65536) != 0 ? adData2.leftSlideCmd : str3, (i13 & 131072) != 0 ? adData2.titleCmd : str4, (i13 & 262144) != 0 ? adData2.buttons : nadDoubleButtonsModel, (i13 & 524288) != 0 ? adData2.liveState : i5, (i13 & 1048576) != 0 ? adData2.liveInteract : liveInteractModel, (i13 & 2097152) != 0 ? adData2.liveTagText : str5, (i13 & 4194304) != 0 ? adData2.liveEntrance : liveEntranceModel, (i13 & 8388608) != 0 ? adData2.isVerticalScreen : str6, (i13 & 16777216) != 0 ? adData2.adVTag : i6, (i13 & INpsPluginLoaderKt.CACHE_MODE_IOC) != 0 ? adData2.transformPortraitCmdList : list, (i13 & 67108864) != 0 ? adData2.authorCmd : str7, (i13 & SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0 ? adData2.commentTopSwitch : str8, (i13 & 268435456) != 0 ? adData2.prerenderScheme : str9, (i13 & 536870912) != 0 ? adData2.commentTop : str10, (i13 & 1073741824) != 0 ? adData2.recTagList : list2, (i13 & Integer.MIN_VALUE) != 0 ? adData2.buttonIconExpSwitch : i7, (i14 & 1) != 0 ? adData2.svButton : svButton2, (i14 & 2) != 0 ? adData2.sicilyPop : nadSicilyModel, (i14 & 4) != 0 ? adData2.slidingTag : nadSlidingTagModel, (i14 & 8) != 0 ? adData2.svTitle : nadHighLightTextModel, (i14 & 16) != 0 ? adData2.chargeByAreaOfflineAbSwitch : z, (i14 & 32) != 0 ? adData2.componentTypeSwitch : componentTypeSwitchModel, (i14 & 64) != 0 ? adData2.leftSlideRequestClickUrlSwitch : z2, (i14 & 128) != 0 ? adData2.prefetchUrlList : list3, (i14 & 256) != 0 ? adData2.lottieModel : flowAdLottieModel, (i14 & 512) != 0 ? adData2.nextCardShow : z3, (i14 & 1024) != 0 ? adData2.adTag : nadTag, (i14 & 2048) != 0 ? adData2.etrade : str11, (i14 & 4096) != 0 ? adData2.supportHorizontalSwitch : z4, (i14 & 8192) != 0 ? adData2.preRenderSchemeList : list4, (i14 & 16384) != 0 ? adData2.mountTag : nadMountTagModel, (i14 & 32768) != 0 ? adData2.contextExt : str12, (i14 & 65536) != 0 ? adData2.commentTitleMount : commentNadTitleData, (i14 & 131072) != 0 ? adData2.forbidAutoPlayNext : i8, (i14 & 262144) != 0 ? adData2.hasInteractionStrategy : z5, (i14 & 524288) != 0 ? adData2.isScheduledDownload : z6, (i14 & 1048576) != 0 ? adData2.bottomEntry : nadBottomBannerModel, (i14 & 2097152) != 0 ? adData2.rotationPop : nadRotationPopModel, (i14 & 4194304) != 0 ? adData2.roomId : str13, (i14 & 8388608) != 0 ? adData2.adExtend : adExtend2, (i14 & 16777216) != 0 ? adData2.isFromLanscape : z7, (i14 & INpsPluginLoaderKt.CACHE_MODE_IOC) != 0 ? adData2.canFollowMove : z8, (i14 & 67108864) != 0 ? adData2.structureTag : nadStructureTagModel, (i14 & SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0 ? adData2.carouselTile : nadCarouselItemModel, (i14 & 268435456) != 0 ? adData2.timeInvokeCmdList : list5, (i14 & 536870912) != 0 ? adData2.liveMataInfo : str14, (i14 & 1073741824) != 0 ? adData2.fullScreen : nadFullScreenModel, (i14 & Integer.MIN_VALUE) != 0 ? adData2.extendTags : list6, (i15 & 1) != 0 ? adData2.forbidTailAnim : z9, (i15 & 2) != 0 ? adData2.forbidPosterWhenShowTail : z10, (i15 & 4) != 0 ? adData2.adReminder : nadReminderModel, (i15 & 8) != 0 ? adData2.adDynamic : nadDynamicModel, (i15 & 16) != 0 ? adData2.extLog : str15, (i15 & 32) != 0 ? adData2.adTitleZone : nadSummaryTitleModel, (i15 & 64) != 0 ? adData2.aiInteractions : list7, (i15 & 128) != 0 ? adData2.zoomClickArea : nadExpandHotAreaModel, (i15 & 256) != 0 ? adData2.imageTailFrame : nadImageTailFrameModel, (i15 & 512) != 0 ? adData2.materialType : i9, (i15 & 1024) != 0 ? adData2.guideLottie : nadGuideLottieModel, (i15 & 2048) != 0 ? adData2.liveNid : str16, (i15 & 4096) != 0 ? adData2.poster : str17, (i15 & 8192) != 0 ? adData2.landscapeBg : landscapeBg2);
    }

    public final Integer component1() {
        return this.videoWidth;
    }

    public final AdNormandyModel component10() {
        return this.normandy;
    }

    public final AdInfo component11() {
        return this.adInfo;
    }

    public final String component12() {
        return this.cmd;
    }

    public final AdLpParams.PopoverModel component13() {
        return this.popover;
    }

    public final AdAreaInfo component14() {
        return this.areaInfo;
    }

    public final int component15() {
        return this.prefetchUpload;
    }

    public final String component16() {
        return this.lpRealUrl;
    }

    public final String component17() {
        return this.leftSlideCmd;
    }

    public final String component18() {
        return this.titleCmd;
    }

    public final NadDoubleButtonsModel component19() {
        return this.buttons;
    }

    public final Integer component2() {
        return this.videoHeight;
    }

    public final int component20() {
        return this.liveState;
    }

    public final LiveInteractModel component21() {
        return this.liveInteract;
    }

    public final String component22() {
        return this.liveTagText;
    }

    public final LiveEntranceModel component23() {
        return this.liveEntrance;
    }

    public final String component24() {
        return this.isVerticalScreen;
    }

    public final int component25() {
        return this.adVTag;
    }

    public final List<String> component26() {
        return this.transformPortraitCmdList;
    }

    public final String component27() {
        return this.authorCmd;
    }

    public final String component28() {
        return this.commentTopSwitch;
    }

    public final String component29() {
        return this.prerenderScheme;
    }

    public final FeedAdOperate component3() {
        return this.operate;
    }

    public final String component30() {
        return this.commentTop;
    }

    public final List<NadRecTag> component31() {
        return this.recTagList;
    }

    public final int component32() {
        return this.buttonIconExpSwitch;
    }

    public final SvButton component33() {
        return this.svButton;
    }

    public final NadSicilyModel component34() {
        return this.sicilyPop;
    }

    public final NadSlidingTagModel component35() {
        return this.slidingTag;
    }

    public final NadHighLightTextModel component36() {
        return this.svTitle;
    }

    public final boolean component37() {
        return this.chargeByAreaOfflineAbSwitch;
    }

    public final ComponentTypeSwitchModel component38() {
        return this.componentTypeSwitch;
    }

    public final boolean component39() {
        return this.leftSlideRequestClickUrlSwitch;
    }

    public final AdExt component4() {
        return this.extraInfo;
    }

    public final List<String> component40() {
        return this.prefetchUrlList;
    }

    public final FlowAdLottieModel component41() {
        return this.lottieModel;
    }

    public final boolean component42() {
        return this.nextCardShow;
    }

    public final NadTag component43() {
        return this.adTag;
    }

    public final String component44() {
        return this.etrade;
    }

    public final boolean component45() {
        return this.supportHorizontalSwitch;
    }

    public final List<String> component46() {
        return this.preRenderSchemeList;
    }

    public final NadMountTagModel component47() {
        return this.mountTag;
    }

    public final String component48() {
        return this.contextExt;
    }

    public final CommentNadTitleData component49() {
        return this.commentTitleMount;
    }

    public final ExtData component5() {
        return this.extraData;
    }

    public final int component50() {
        return this.forbidAutoPlayNext;
    }

    public final boolean component51() {
        return this.hasInteractionStrategy;
    }

    public final boolean component52() {
        return this.isScheduledDownload;
    }

    public final NadBottomBannerModel component53() {
        return this.bottomEntry;
    }

    public final NadRotationPopModel component54() {
        return this.rotationPop;
    }

    public final String component55() {
        return this.roomId;
    }

    public final AdExtend component56() {
        return this.adExtend;
    }

    public final boolean component57() {
        return this.isFromLanscape;
    }

    public final boolean component58() {
        return this.canFollowMove;
    }

    public final NadStructureTagModel component59() {
        return this.structureTag;
    }

    public final int component6() {
        return this.tailShow;
    }

    public final NadCarouselItemModel component60() {
        return this.carouselTile;
    }

    public final List<AdTimeInvokeCmdModel> component61() {
        return this.timeInvokeCmdList;
    }

    public final String component62() {
        return this.liveMataInfo;
    }

    public final NadFullScreenModel component63() {
        return this.fullScreen;
    }

    public final List<String> component64() {
        return this.extendTags;
    }

    public final boolean component65() {
        return this.forbidTailAnim;
    }

    public final boolean component66() {
        return this.forbidPosterWhenShowTail;
    }

    public final NadReminderModel component67() {
        return this.adReminder;
    }

    public final NadDynamicModel component68() {
        return this.adDynamic;
    }

    public final String component69() {
        return this.extLog;
    }

    public final int component7() {
        return this.tailShowAutoPlay;
    }

    public final NadSummaryTitleModel component70() {
        return this.adTitleZone;
    }

    public final List<NadAiInteractionItemModel> component71() {
        return this.aiInteractions;
    }

    public final NadExpandHotAreaModel component72() {
        return this.zoomClickArea;
    }

    public final NadImageTailFrameModel component73() {
        return this.imageTailFrame;
    }

    public final int component74() {
        return this.materialType;
    }

    public final NadGuideLottieModel component75() {
        return this.guideLottie;
    }

    public final String component76() {
        return this.liveNid;
    }

    public final String component77() {
        return this.poster;
    }

    public final LandscapeBg component78() {
        return this.landscapeBg;
    }

    public final TailFrame component8() {
        return this.tailFrame;
    }

    public final AdLpParams.EnhanceModel component9() {
        return this.enhancement;
    }

    public final AdData copy(Integer num, Integer num2, FeedAdOperate feedAdOperate, AdExt adExt, ExtData extData, int i2, int i3, TailFrame tailFrame2, AdLpParams.EnhanceModel enhanceModel, AdNormandyModel adNormandyModel, AdInfo adInfo2, String str, AdLpParams.PopoverModel popoverModel, AdAreaInfo adAreaInfo, int i4, String str2, String str3, String str4, NadDoubleButtonsModel nadDoubleButtonsModel, int i5, LiveInteractModel liveInteractModel, String str5, LiveEntranceModel liveEntranceModel, String str6, int i6, List<String> list, String str7, String str8, String str9, String str10, List<NadRecTag> list2, int i7, SvButton svButton2, NadSicilyModel nadSicilyModel, NadSlidingTagModel nadSlidingTagModel, NadHighLightTextModel nadHighLightTextModel, boolean z, ComponentTypeSwitchModel componentTypeSwitchModel, boolean z2, List<String> list3, FlowAdLottieModel flowAdLottieModel, boolean z3, NadTag nadTag, String str11, boolean z4, List<String> list4, NadMountTagModel nadMountTagModel, String str12, CommentNadTitleData commentNadTitleData, int i8, boolean z5, boolean z6, NadBottomBannerModel nadBottomBannerModel, NadRotationPopModel nadRotationPopModel, String str13, AdExtend adExtend2, boolean z7, boolean z8, NadStructureTagModel nadStructureTagModel, NadCarouselItemModel nadCarouselItemModel, List<AdTimeInvokeCmdModel> list5, String str14, NadFullScreenModel nadFullScreenModel, List<String> list6, boolean z9, boolean z10, NadReminderModel nadReminderModel, NadDynamicModel nadDynamicModel, String str15, NadSummaryTitleModel nadSummaryTitleModel, List<NadAiInteractionItemModel> list7, NadExpandHotAreaModel nadExpandHotAreaModel, NadImageTailFrameModel nadImageTailFrameModel, int i9, NadGuideLottieModel nadGuideLottieModel, String str16, String str17, LandscapeBg landscapeBg2) {
        Intrinsics.checkNotNullParameter(str, "cmd");
        Intrinsics.checkNotNullParameter(str2, "lpRealUrl");
        Intrinsics.checkNotNullParameter(str5, "liveTagText");
        Intrinsics.checkNotNullParameter(str6, "isVerticalScreen");
        Intrinsics.checkNotNullParameter(str7, "authorCmd");
        Intrinsics.checkNotNullParameter(str12, "contextExt");
        Intrinsics.checkNotNullParameter(str15, IntentData.Protocol.KEY_EXT_LOG);
        Intrinsics.checkNotNullParameter(str17, "poster");
        return new AdData(num, num2, feedAdOperate, adExt, extData, i2, i3, tailFrame2, enhanceModel, adNormandyModel, adInfo2, str, popoverModel, adAreaInfo, i4, str2, str3, str4, nadDoubleButtonsModel, i5, liveInteractModel, str5, liveEntranceModel, str6, i6, list, str7, str8, str9, str10, list2, i7, svButton2, nadSicilyModel, nadSlidingTagModel, nadHighLightTextModel, z, componentTypeSwitchModel, z2, list3, flowAdLottieModel, z3, nadTag, str11, z4, list4, nadMountTagModel, str12, commentNadTitleData, i8, z5, z6, nadBottomBannerModel, nadRotationPopModel, str13, adExtend2, z7, z8, nadStructureTagModel, nadCarouselItemModel, list5, str14, nadFullScreenModel, list6, z9, z10, nadReminderModel, nadDynamicModel, str15, nadSummaryTitleModel, list7, nadExpandHotAreaModel, nadImageTailFrameModel, i9, nadGuideLottieModel, str16, str17, landscapeBg2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) obj;
        return Intrinsics.areEqual((Object) this.videoWidth, (Object) adData.videoWidth) && Intrinsics.areEqual((Object) this.videoHeight, (Object) adData.videoHeight) && Intrinsics.areEqual((Object) this.operate, (Object) adData.operate) && Intrinsics.areEqual((Object) this.extraInfo, (Object) adData.extraInfo) && Intrinsics.areEqual((Object) this.extraData, (Object) adData.extraData) && this.tailShow == adData.tailShow && this.tailShowAutoPlay == adData.tailShowAutoPlay && Intrinsics.areEqual((Object) this.tailFrame, (Object) adData.tailFrame) && Intrinsics.areEqual((Object) this.enhancement, (Object) adData.enhancement) && Intrinsics.areEqual((Object) this.normandy, (Object) adData.normandy) && Intrinsics.areEqual((Object) this.adInfo, (Object) adData.adInfo) && Intrinsics.areEqual((Object) this.cmd, (Object) adData.cmd) && Intrinsics.areEqual((Object) this.popover, (Object) adData.popover) && Intrinsics.areEqual((Object) this.areaInfo, (Object) adData.areaInfo) && this.prefetchUpload == adData.prefetchUpload && Intrinsics.areEqual((Object) this.lpRealUrl, (Object) adData.lpRealUrl) && Intrinsics.areEqual((Object) this.leftSlideCmd, (Object) adData.leftSlideCmd) && Intrinsics.areEqual((Object) this.titleCmd, (Object) adData.titleCmd) && Intrinsics.areEqual((Object) this.buttons, (Object) adData.buttons) && this.liveState == adData.liveState && Intrinsics.areEqual((Object) this.liveInteract, (Object) adData.liveInteract) && Intrinsics.areEqual((Object) this.liveTagText, (Object) adData.liveTagText) && Intrinsics.areEqual((Object) this.liveEntrance, (Object) adData.liveEntrance) && Intrinsics.areEqual((Object) this.isVerticalScreen, (Object) adData.isVerticalScreen) && this.adVTag == adData.adVTag && Intrinsics.areEqual((Object) this.transformPortraitCmdList, (Object) adData.transformPortraitCmdList) && Intrinsics.areEqual((Object) this.authorCmd, (Object) adData.authorCmd) && Intrinsics.areEqual((Object) this.commentTopSwitch, (Object) adData.commentTopSwitch) && Intrinsics.areEqual((Object) this.prerenderScheme, (Object) adData.prerenderScheme) && Intrinsics.areEqual((Object) this.commentTop, (Object) adData.commentTop) && Intrinsics.areEqual((Object) this.recTagList, (Object) adData.recTagList) && this.buttonIconExpSwitch == adData.buttonIconExpSwitch && Intrinsics.areEqual((Object) this.svButton, (Object) adData.svButton) && Intrinsics.areEqual((Object) this.sicilyPop, (Object) adData.sicilyPop) && Intrinsics.areEqual((Object) this.slidingTag, (Object) adData.slidingTag) && Intrinsics.areEqual((Object) this.svTitle, (Object) adData.svTitle) && this.chargeByAreaOfflineAbSwitch == adData.chargeByAreaOfflineAbSwitch && Intrinsics.areEqual((Object) this.componentTypeSwitch, (Object) adData.componentTypeSwitch) && this.leftSlideRequestClickUrlSwitch == adData.leftSlideRequestClickUrlSwitch && Intrinsics.areEqual((Object) this.prefetchUrlList, (Object) adData.prefetchUrlList) && Intrinsics.areEqual((Object) this.lottieModel, (Object) adData.lottieModel) && this.nextCardShow == adData.nextCardShow && Intrinsics.areEqual((Object) this.adTag, (Object) adData.adTag) && Intrinsics.areEqual((Object) this.etrade, (Object) adData.etrade) && this.supportHorizontalSwitch == adData.supportHorizontalSwitch && Intrinsics.areEqual((Object) this.preRenderSchemeList, (Object) adData.preRenderSchemeList) && Intrinsics.areEqual((Object) this.mountTag, (Object) adData.mountTag) && Intrinsics.areEqual((Object) this.contextExt, (Object) adData.contextExt) && Intrinsics.areEqual((Object) this.commentTitleMount, (Object) adData.commentTitleMount) && this.forbidAutoPlayNext == adData.forbidAutoPlayNext && this.hasInteractionStrategy == adData.hasInteractionStrategy && this.isScheduledDownload == adData.isScheduledDownload && Intrinsics.areEqual((Object) this.bottomEntry, (Object) adData.bottomEntry) && Intrinsics.areEqual((Object) this.rotationPop, (Object) adData.rotationPop) && Intrinsics.areEqual((Object) this.roomId, (Object) adData.roomId) && Intrinsics.areEqual((Object) this.adExtend, (Object) adData.adExtend) && this.isFromLanscape == adData.isFromLanscape && this.canFollowMove == adData.canFollowMove && Intrinsics.areEqual((Object) this.structureTag, (Object) adData.structureTag) && Intrinsics.areEqual((Object) this.carouselTile, (Object) adData.carouselTile) && Intrinsics.areEqual((Object) this.timeInvokeCmdList, (Object) adData.timeInvokeCmdList) && Intrinsics.areEqual((Object) this.liveMataInfo, (Object) adData.liveMataInfo) && Intrinsics.areEqual((Object) this.fullScreen, (Object) adData.fullScreen) && Intrinsics.areEqual((Object) this.extendTags, (Object) adData.extendTags) && this.forbidTailAnim == adData.forbidTailAnim && this.forbidPosterWhenShowTail == adData.forbidPosterWhenShowTail && Intrinsics.areEqual((Object) this.adReminder, (Object) adData.adReminder) && Intrinsics.areEqual((Object) this.adDynamic, (Object) adData.adDynamic) && Intrinsics.areEqual((Object) this.extLog, (Object) adData.extLog) && Intrinsics.areEqual((Object) this.adTitleZone, (Object) adData.adTitleZone) && Intrinsics.areEqual((Object) this.aiInteractions, (Object) adData.aiInteractions) && Intrinsics.areEqual((Object) this.zoomClickArea, (Object) adData.zoomClickArea) && Intrinsics.areEqual((Object) this.imageTailFrame, (Object) adData.imageTailFrame) && this.materialType == adData.materialType && Intrinsics.areEqual((Object) this.guideLottie, (Object) adData.guideLottie) && Intrinsics.areEqual((Object) this.liveNid, (Object) adData.liveNid) && Intrinsics.areEqual((Object) this.poster, (Object) adData.poster) && Intrinsics.areEqual((Object) this.landscapeBg, (Object) adData.landscapeBg);
    }

    public int hashCode() {
        Integer num = this.videoWidth;
        int i2 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.videoHeight;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        FeedAdOperate feedAdOperate = this.operate;
        int hashCode3 = (hashCode2 + (feedAdOperate == null ? 0 : feedAdOperate.hashCode())) * 31;
        AdExt adExt = this.extraInfo;
        int hashCode4 = (hashCode3 + (adExt == null ? 0 : adExt.hashCode())) * 31;
        ExtData extData = this.extraData;
        int hashCode5 = (((((hashCode4 + (extData == null ? 0 : extData.hashCode())) * 31) + Integer.hashCode(this.tailShow)) * 31) + Integer.hashCode(this.tailShowAutoPlay)) * 31;
        TailFrame tailFrame2 = this.tailFrame;
        int hashCode6 = (hashCode5 + (tailFrame2 == null ? 0 : tailFrame2.hashCode())) * 31;
        AdLpParams.EnhanceModel enhanceModel = this.enhancement;
        int hashCode7 = (hashCode6 + (enhanceModel == null ? 0 : enhanceModel.hashCode())) * 31;
        AdNormandyModel adNormandyModel = this.normandy;
        int hashCode8 = (hashCode7 + (adNormandyModel == null ? 0 : adNormandyModel.hashCode())) * 31;
        AdInfo adInfo2 = this.adInfo;
        int hashCode9 = (((hashCode8 + (adInfo2 == null ? 0 : adInfo2.hashCode())) * 31) + this.cmd.hashCode()) * 31;
        AdLpParams.PopoverModel popoverModel = this.popover;
        int hashCode10 = (hashCode9 + (popoverModel == null ? 0 : popoverModel.hashCode())) * 31;
        AdAreaInfo adAreaInfo = this.areaInfo;
        int hashCode11 = (((((hashCode10 + (adAreaInfo == null ? 0 : adAreaInfo.hashCode())) * 31) + Integer.hashCode(this.prefetchUpload)) * 31) + this.lpRealUrl.hashCode()) * 31;
        String str = this.leftSlideCmd;
        int hashCode12 = (hashCode11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.titleCmd;
        int hashCode13 = (hashCode12 + (str2 == null ? 0 : str2.hashCode())) * 31;
        NadDoubleButtonsModel nadDoubleButtonsModel = this.buttons;
        int hashCode14 = (((hashCode13 + (nadDoubleButtonsModel == null ? 0 : nadDoubleButtonsModel.hashCode())) * 31) + Integer.hashCode(this.liveState)) * 31;
        LiveInteractModel liveInteractModel = this.liveInteract;
        int hashCode15 = (((hashCode14 + (liveInteractModel == null ? 0 : liveInteractModel.hashCode())) * 31) + this.liveTagText.hashCode()) * 31;
        LiveEntranceModel liveEntranceModel = this.liveEntrance;
        int hashCode16 = (((((hashCode15 + (liveEntranceModel == null ? 0 : liveEntranceModel.hashCode())) * 31) + this.isVerticalScreen.hashCode()) * 31) + Integer.hashCode(this.adVTag)) * 31;
        List<String> list = this.transformPortraitCmdList;
        int hashCode17 = (((hashCode16 + (list == null ? 0 : list.hashCode())) * 31) + this.authorCmd.hashCode()) * 31;
        String str3 = this.commentTopSwitch;
        int hashCode18 = (hashCode17 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.prerenderScheme;
        int hashCode19 = (hashCode18 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.commentTop;
        int hashCode20 = (hashCode19 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<NadRecTag> list2 = this.recTagList;
        int hashCode21 = (((hashCode20 + (list2 == null ? 0 : list2.hashCode())) * 31) + Integer.hashCode(this.buttonIconExpSwitch)) * 31;
        SvButton svButton2 = this.svButton;
        int hashCode22 = (hashCode21 + (svButton2 == null ? 0 : svButton2.hashCode())) * 31;
        NadSicilyModel nadSicilyModel = this.sicilyPop;
        int hashCode23 = (hashCode22 + (nadSicilyModel == null ? 0 : nadSicilyModel.hashCode())) * 31;
        NadSlidingTagModel nadSlidingTagModel = this.slidingTag;
        int hashCode24 = (hashCode23 + (nadSlidingTagModel == null ? 0 : nadSlidingTagModel.hashCode())) * 31;
        NadHighLightTextModel nadHighLightTextModel = this.svTitle;
        int hashCode25 = (hashCode24 + (nadHighLightTextModel == null ? 0 : nadHighLightTextModel.hashCode())) * 31;
        boolean z = this.chargeByAreaOfflineAbSwitch;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (hashCode25 + (z ? 1 : 0)) * 31;
        ComponentTypeSwitchModel componentTypeSwitchModel = this.componentTypeSwitch;
        int hashCode26 = (i3 + (componentTypeSwitchModel == null ? 0 : componentTypeSwitchModel.hashCode())) * 31;
        boolean z3 = this.leftSlideRequestClickUrlSwitch;
        if (z3) {
            z3 = true;
        }
        int i4 = (hashCode26 + (z3 ? 1 : 0)) * 31;
        List<String> list3 = this.prefetchUrlList;
        int hashCode27 = (i4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        FlowAdLottieModel flowAdLottieModel = this.lottieModel;
        int hashCode28 = (hashCode27 + (flowAdLottieModel == null ? 0 : flowAdLottieModel.hashCode())) * 31;
        boolean z4 = this.nextCardShow;
        if (z4) {
            z4 = true;
        }
        int i5 = (hashCode28 + (z4 ? 1 : 0)) * 31;
        NadTag nadTag = this.adTag;
        int hashCode29 = (i5 + (nadTag == null ? 0 : nadTag.hashCode())) * 31;
        String str6 = this.etrade;
        int hashCode30 = (hashCode29 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z5 = this.supportHorizontalSwitch;
        if (z5) {
            z5 = true;
        }
        int i6 = (hashCode30 + (z5 ? 1 : 0)) * 31;
        List<String> list4 = this.preRenderSchemeList;
        int hashCode31 = (i6 + (list4 == null ? 0 : list4.hashCode())) * 31;
        NadMountTagModel nadMountTagModel = this.mountTag;
        int hashCode32 = (((hashCode31 + (nadMountTagModel == null ? 0 : nadMountTagModel.hashCode())) * 31) + this.contextExt.hashCode()) * 31;
        CommentNadTitleData commentNadTitleData = this.commentTitleMount;
        int hashCode33 = (((hashCode32 + (commentNadTitleData == null ? 0 : commentNadTitleData.hashCode())) * 31) + Integer.hashCode(this.forbidAutoPlayNext)) * 31;
        boolean z6 = this.hasInteractionStrategy;
        if (z6) {
            z6 = true;
        }
        int i7 = (hashCode33 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.isScheduledDownload;
        if (z7) {
            z7 = true;
        }
        int i8 = (i7 + (z7 ? 1 : 0)) * 31;
        NadBottomBannerModel nadBottomBannerModel = this.bottomEntry;
        int hashCode34 = (i8 + (nadBottomBannerModel == null ? 0 : nadBottomBannerModel.hashCode())) * 31;
        NadRotationPopModel nadRotationPopModel = this.rotationPop;
        int hashCode35 = (hashCode34 + (nadRotationPopModel == null ? 0 : nadRotationPopModel.hashCode())) * 31;
        String str7 = this.roomId;
        int hashCode36 = (hashCode35 + (str7 == null ? 0 : str7.hashCode())) * 31;
        AdExtend adExtend2 = this.adExtend;
        int hashCode37 = (hashCode36 + (adExtend2 == null ? 0 : adExtend2.hashCode())) * 31;
        boolean z8 = this.isFromLanscape;
        if (z8) {
            z8 = true;
        }
        int i9 = (hashCode37 + (z8 ? 1 : 0)) * 31;
        boolean z9 = this.canFollowMove;
        if (z9) {
            z9 = true;
        }
        int i10 = (i9 + (z9 ? 1 : 0)) * 31;
        NadStructureTagModel nadStructureTagModel = this.structureTag;
        int hashCode38 = (i10 + (nadStructureTagModel == null ? 0 : nadStructureTagModel.hashCode())) * 31;
        NadCarouselItemModel nadCarouselItemModel = this.carouselTile;
        int hashCode39 = (hashCode38 + (nadCarouselItemModel == null ? 0 : nadCarouselItemModel.hashCode())) * 31;
        List<AdTimeInvokeCmdModel> list5 = this.timeInvokeCmdList;
        int hashCode40 = (hashCode39 + (list5 == null ? 0 : list5.hashCode())) * 31;
        String str8 = this.liveMataInfo;
        int hashCode41 = (hashCode40 + (str8 == null ? 0 : str8.hashCode())) * 31;
        NadFullScreenModel nadFullScreenModel = this.fullScreen;
        int hashCode42 = (hashCode41 + (nadFullScreenModel == null ? 0 : nadFullScreenModel.hashCode())) * 31;
        List<String> list6 = this.extendTags;
        int hashCode43 = (hashCode42 + (list6 == null ? 0 : list6.hashCode())) * 31;
        boolean z10 = this.forbidTailAnim;
        if (z10) {
            z10 = true;
        }
        int i11 = (hashCode43 + (z10 ? 1 : 0)) * 31;
        boolean z11 = this.forbidPosterWhenShowTail;
        if (!z11) {
            z2 = z11;
        }
        int i12 = (i11 + (z2 ? 1 : 0)) * 31;
        NadReminderModel nadReminderModel = this.adReminder;
        int hashCode44 = (i12 + (nadReminderModel == null ? 0 : nadReminderModel.hashCode())) * 31;
        NadDynamicModel nadDynamicModel = this.adDynamic;
        int hashCode45 = (((hashCode44 + (nadDynamicModel == null ? 0 : nadDynamicModel.hashCode())) * 31) + this.extLog.hashCode()) * 31;
        NadSummaryTitleModel nadSummaryTitleModel = this.adTitleZone;
        int hashCode46 = (hashCode45 + (nadSummaryTitleModel == null ? 0 : nadSummaryTitleModel.hashCode())) * 31;
        List<NadAiInteractionItemModel> list7 = this.aiInteractions;
        int hashCode47 = (hashCode46 + (list7 == null ? 0 : list7.hashCode())) * 31;
        NadExpandHotAreaModel nadExpandHotAreaModel = this.zoomClickArea;
        int hashCode48 = (hashCode47 + (nadExpandHotAreaModel == null ? 0 : nadExpandHotAreaModel.hashCode())) * 31;
        NadImageTailFrameModel nadImageTailFrameModel = this.imageTailFrame;
        int hashCode49 = (((hashCode48 + (nadImageTailFrameModel == null ? 0 : nadImageTailFrameModel.hashCode())) * 31) + Integer.hashCode(this.materialType)) * 31;
        NadGuideLottieModel nadGuideLottieModel = this.guideLottie;
        int hashCode50 = (hashCode49 + (nadGuideLottieModel == null ? 0 : nadGuideLottieModel.hashCode())) * 31;
        String str9 = this.liveNid;
        int hashCode51 = (((hashCode50 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.poster.hashCode()) * 31;
        LandscapeBg landscapeBg2 = this.landscapeBg;
        if (landscapeBg2 != null) {
            i2 = landscapeBg2.hashCode();
        }
        return hashCode51 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdData(videoWidth=").append(this.videoWidth).append(", videoHeight=").append(this.videoHeight).append(", operate=").append(this.operate).append(", extraInfo=").append(this.extraInfo).append(", extraData=").append(this.extraData).append(", tailShow=").append(this.tailShow).append(", tailShowAutoPlay=").append(this.tailShowAutoPlay).append(", tailFrame=").append(this.tailFrame).append(", enhancement=").append(this.enhancement).append(", normandy=").append(this.normandy).append(", adInfo=").append(this.adInfo).append(", cmd=");
        sb.append(this.cmd).append(", popover=").append(this.popover).append(", areaInfo=").append(this.areaInfo).append(", prefetchUpload=").append(this.prefetchUpload).append(", lpRealUrl=").append(this.lpRealUrl).append(", leftSlideCmd=").append(this.leftSlideCmd).append(", titleCmd=").append(this.titleCmd).append(", buttons=").append(this.buttons).append(", liveState=").append(this.liveState).append(", liveInteract=").append(this.liveInteract).append(", liveTagText=").append(this.liveTagText).append(", liveEntrance=").append(this.liveEntrance);
        sb.append(", isVerticalScreen=").append(this.isVerticalScreen).append(", adVTag=").append(this.adVTag).append(", transformPortraitCmdList=").append(this.transformPortraitCmdList).append(", authorCmd=").append(this.authorCmd).append(", commentTopSwitch=").append(this.commentTopSwitch).append(", prerenderScheme=").append(this.prerenderScheme).append(", commentTop=").append(this.commentTop).append(", recTagList=").append(this.recTagList).append(", buttonIconExpSwitch=").append(this.buttonIconExpSwitch).append(", svButton=").append(this.svButton).append(", sicilyPop=").append(this.sicilyPop).append(", slidingTag=");
        sb.append(this.slidingTag).append(", svTitle=").append(this.svTitle).append(", chargeByAreaOfflineAbSwitch=").append(this.chargeByAreaOfflineAbSwitch).append(", componentTypeSwitch=").append(this.componentTypeSwitch).append(", leftSlideRequestClickUrlSwitch=").append(this.leftSlideRequestClickUrlSwitch).append(", prefetchUrlList=").append(this.prefetchUrlList).append(", lottieModel=").append(this.lottieModel).append(", nextCardShow=").append(this.nextCardShow).append(", adTag=").append(this.adTag).append(", etrade=").append(this.etrade).append(", supportHorizontalSwitch=").append(this.supportHorizontalSwitch).append(", preRenderSchemeList=").append(this.preRenderSchemeList);
        sb.append(", mountTag=").append(this.mountTag).append(", contextExt=").append(this.contextExt).append(", commentTitleMount=").append(this.commentTitleMount).append(", forbidAutoPlayNext=").append(this.forbidAutoPlayNext).append(", hasInteractionStrategy=").append(this.hasInteractionStrategy).append(", isScheduledDownload=").append(this.isScheduledDownload).append(", bottomEntry=").append(this.bottomEntry).append(", rotationPop=").append(this.rotationPop).append(", roomId=").append(this.roomId).append(", adExtend=").append(this.adExtend).append(", isFromLanscape=").append(this.isFromLanscape).append(", canFollowMove=");
        sb.append(this.canFollowMove).append(", structureTag=").append(this.structureTag).append(", carouselTile=").append(this.carouselTile).append(", timeInvokeCmdList=").append(this.timeInvokeCmdList).append(", liveMataInfo=").append(this.liveMataInfo).append(", fullScreen=").append(this.fullScreen).append(", extendTags=").append(this.extendTags).append(", forbidTailAnim=").append(this.forbidTailAnim).append(", forbidPosterWhenShowTail=").append(this.forbidPosterWhenShowTail).append(", adReminder=").append(this.adReminder).append(", adDynamic=").append(this.adDynamic).append(", extLog=").append(this.extLog);
        sb.append(", adTitleZone=").append(this.adTitleZone).append(", aiInteractions=").append(this.aiInteractions).append(", zoomClickArea=").append(this.zoomClickArea).append(", imageTailFrame=").append(this.imageTailFrame).append(", materialType=").append(this.materialType).append(", guideLottie=").append(this.guideLottie).append(", liveNid=").append(this.liveNid).append(", poster=").append(this.poster).append(", landscapeBg=").append(this.landscapeBg).append(')');
        return sb.toString();
    }

    public AdData(Integer videoWidth2, Integer videoHeight2, FeedAdOperate operate2, AdExt extraInfo2, ExtData extraData2, int tailShow2, int tailShowAutoPlay2, TailFrame tailFrame2, AdLpParams.EnhanceModel enhancement2, AdNormandyModel normandy2, AdInfo adInfo2, String cmd2, AdLpParams.PopoverModel popover2, AdAreaInfo areaInfo2, int prefetchUpload2, String lpRealUrl2, String leftSlideCmd2, String titleCmd2, NadDoubleButtonsModel buttons2, int liveState2, LiveInteractModel liveInteract2, String liveTagText2, LiveEntranceModel liveEntrance2, String isVerticalScreen2, int adVTag2, List<String> transformPortraitCmdList2, String authorCmd2, String commentTopSwitch2, String prerenderScheme2, String commentTop2, List<NadRecTag> recTagList2, int buttonIconExpSwitch2, SvButton svButton2, NadSicilyModel sicilyPop2, NadSlidingTagModel slidingTag2, NadHighLightTextModel svTitle2, boolean chargeByAreaOfflineAbSwitch2, ComponentTypeSwitchModel componentTypeSwitch2, boolean leftSlideRequestClickUrlSwitch2, List<String> prefetchUrlList2, FlowAdLottieModel lottieModel2, boolean nextCardShow2, NadTag adTag2, String etrade2, boolean supportHorizontalSwitch2, List<String> preRenderSchemeList2, NadMountTagModel mountTag2, String contextExt2, CommentNadTitleData commentTitleMount2, int forbidAutoPlayNext2, boolean hasInteractionStrategy2, boolean isScheduledDownload2, NadBottomBannerModel bottomEntry2, NadRotationPopModel rotationPop2, String roomId2, AdExtend adExtend2, boolean isFromLanscape2, boolean canFollowMove2, NadStructureTagModel structureTag2, NadCarouselItemModel carouselTile2, List<AdTimeInvokeCmdModel> timeInvokeCmdList2, String liveMataInfo2, NadFullScreenModel fullScreen2, List<String> extendTags2, boolean forbidTailAnim2, boolean forbidPosterWhenShowTail2, NadReminderModel adReminder2, NadDynamicModel adDynamic2, String extLog2, NadSummaryTitleModel adTitleZone2, List<NadAiInteractionItemModel> aiInteractions2, NadExpandHotAreaModel zoomClickArea2, NadImageTailFrameModel imageTailFrame2, int materialType2, NadGuideLottieModel guideLottie2, String liveNid2, String poster2, LandscapeBg landscapeBg2) {
        String str = cmd2;
        String str2 = lpRealUrl2;
        String str3 = liveTagText2;
        String str4 = isVerticalScreen2;
        String str5 = authorCmd2;
        String str6 = contextExt2;
        String str7 = extLog2;
        String str8 = poster2;
        Intrinsics.checkNotNullParameter(str, "cmd");
        Intrinsics.checkNotNullParameter(str2, "lpRealUrl");
        Intrinsics.checkNotNullParameter(str3, "liveTagText");
        Intrinsics.checkNotNullParameter(str4, "isVerticalScreen");
        Intrinsics.checkNotNullParameter(str5, "authorCmd");
        Intrinsics.checkNotNullParameter(str6, "contextExt");
        Intrinsics.checkNotNullParameter(str7, IntentData.Protocol.KEY_EXT_LOG);
        Intrinsics.checkNotNullParameter(str8, "poster");
        this.videoWidth = videoWidth2;
        this.videoHeight = videoHeight2;
        this.operate = operate2;
        this.extraInfo = extraInfo2;
        this.extraData = extraData2;
        this.tailShow = tailShow2;
        this.tailShowAutoPlay = tailShowAutoPlay2;
        this.tailFrame = tailFrame2;
        this.enhancement = enhancement2;
        this.normandy = normandy2;
        this.adInfo = adInfo2;
        this.cmd = str;
        this.popover = popover2;
        this.areaInfo = areaInfo2;
        this.prefetchUpload = prefetchUpload2;
        this.lpRealUrl = str2;
        this.leftSlideCmd = leftSlideCmd2;
        this.titleCmd = titleCmd2;
        this.buttons = buttons2;
        this.liveState = liveState2;
        this.liveInteract = liveInteract2;
        this.liveTagText = str3;
        this.liveEntrance = liveEntrance2;
        this.isVerticalScreen = str4;
        this.adVTag = adVTag2;
        this.transformPortraitCmdList = transformPortraitCmdList2;
        this.authorCmd = str5;
        this.commentTopSwitch = commentTopSwitch2;
        this.prerenderScheme = prerenderScheme2;
        this.commentTop = commentTop2;
        this.recTagList = recTagList2;
        this.buttonIconExpSwitch = buttonIconExpSwitch2;
        this.svButton = svButton2;
        this.sicilyPop = sicilyPop2;
        this.slidingTag = slidingTag2;
        this.svTitle = svTitle2;
        this.chargeByAreaOfflineAbSwitch = chargeByAreaOfflineAbSwitch2;
        this.componentTypeSwitch = componentTypeSwitch2;
        this.leftSlideRequestClickUrlSwitch = leftSlideRequestClickUrlSwitch2;
        this.prefetchUrlList = prefetchUrlList2;
        this.lottieModel = lottieModel2;
        this.nextCardShow = nextCardShow2;
        this.adTag = adTag2;
        this.etrade = etrade2;
        this.supportHorizontalSwitch = supportHorizontalSwitch2;
        this.preRenderSchemeList = preRenderSchemeList2;
        this.mountTag = mountTag2;
        this.contextExt = str6;
        this.commentTitleMount = commentTitleMount2;
        this.forbidAutoPlayNext = forbidAutoPlayNext2;
        this.hasInteractionStrategy = hasInteractionStrategy2;
        this.isScheduledDownload = isScheduledDownload2;
        this.bottomEntry = bottomEntry2;
        this.rotationPop = rotationPop2;
        this.roomId = roomId2;
        this.adExtend = adExtend2;
        this.isFromLanscape = isFromLanscape2;
        this.canFollowMove = canFollowMove2;
        this.structureTag = structureTag2;
        this.carouselTile = carouselTile2;
        this.timeInvokeCmdList = timeInvokeCmdList2;
        this.liveMataInfo = liveMataInfo2;
        this.fullScreen = fullScreen2;
        this.extendTags = extendTags2;
        this.forbidTailAnim = forbidTailAnim2;
        this.forbidPosterWhenShowTail = forbidPosterWhenShowTail2;
        this.adReminder = adReminder2;
        this.adDynamic = adDynamic2;
        this.extLog = str7;
        this.adTitleZone = adTitleZone2;
        this.aiInteractions = aiInteractions2;
        this.zoomClickArea = zoomClickArea2;
        this.imageTailFrame = imageTailFrame2;
        this.materialType = materialType2;
        this.guideLottie = guideLottie2;
        this.liveNid = liveNid2;
        this.poster = str8;
        this.landscapeBg = landscapeBg2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdData(java.lang.Integer r64, java.lang.Integer r65, com.baidu.searchbox.ad.model.FeedAdOperate r66, com.baidu.searchbox.feed.ad.model.AdExt r67, com.baidu.searchbox.feed.ad.model.ExtData r68, int r69, int r70, com.baidu.searchbox.feed.ad.model.TailFrame r71, com.baidu.searchbox.feed.ad.model.AdLpParams.EnhanceModel r72, com.baidu.searchbox.ad.model.AdNormandyModel r73, com.baidu.searchbox.feed.ad.model.AdInfo r74, java.lang.String r75, com.baidu.searchbox.feed.ad.model.AdLpParams.PopoverModel r76, com.baidu.searchbox.ad.charge.AdAreaInfo r77, int r78, java.lang.String r79, java.lang.String r80, java.lang.String r81, com.baidu.searchbox.feed.ad.model.NadDoubleButtonsModel r82, int r83, com.baidu.searchbox.flowvideo.detail.repos.LiveInteractModel r84, java.lang.String r85, com.baidu.searchbox.flowvideo.detail.repos.LiveEntranceModel r86, java.lang.String r87, int r88, java.util.List r89, java.lang.String r90, java.lang.String r91, java.lang.String r92, java.lang.String r93, java.util.List r94, int r95, com.baidu.searchbox.flowvideo.ad.api.SvButton r96, com.baidu.searchbox.ad.model.NadSicilyModel r97, com.baidu.nadcore.model.NadSlidingTagModel r98, com.baidu.nadcore.videoextra.model.NadHighLightTextModel r99, boolean r100, com.baidu.searchbox.video.feedflow.ad.componenttypeswitch.ComponentTypeSwitchModel r101, boolean r102, java.util.List r103, com.baidu.searchbox.video.feedflow.ad.lottie.FlowAdLottieModel r104, boolean r105, com.baidu.searchbox.ad.model.NadTag r106, java.lang.String r107, boolean r108, java.util.List r109, com.baidu.nadcore.model.NadMountTagModel r110, java.lang.String r111, com.baidu.searchbox.feed.ad.model.CommentNadTitleData r112, int r113, boolean r114, boolean r115, com.baidu.searchbox.video.feedflow.ad.bottombanner.NadBottomBannerModel r116, com.baidu.nadcore.model.NadRotationPopModel r117, java.lang.String r118, com.baidu.searchbox.video.feedflow.ad.adextend.AdExtend r119, boolean r120, boolean r121, com.baidu.nadcore.model.NadStructureTagModel r122, com.baidu.nadcore.carousel.NadCarouselItemModel r123, java.util.List r124, java.lang.String r125, com.baidu.nadcore.model.NadFullScreenModel r126, java.util.List r127, boolean r128, boolean r129, com.baidu.searchbox.video.feedflow.ad.adreminder.NadReminderModel r130, com.baidu.searchbox.video.feedflow.ad.dynamic.NadDynamicModel r131, java.lang.String r132, com.baidu.searchbox.video.feedflow.ad.summary.NadSummaryTitleModel r133, java.util.List r134, com.baidu.searchbox.video.feedflow.ad.summary.expand.NadExpandHotAreaModel r135, com.baidu.nadcore.tailframe.NadImageTailFrameModel r136, int r137, com.baidu.searchbox.video.feedflow.ad.lottie.guidelottie.NadGuideLottieModel r138, java.lang.String r139, java.lang.String r140, com.baidu.searchbox.video.feedflow.ad.landscape.background.LandscapeBg r141, int r142, int r143, int r144, kotlin.jvm.internal.DefaultConstructorMarker r145) {
        /*
            r63 = this;
            r0 = r142
            r1 = r143
            r2 = r144
            r3 = r0 & 1
            if (r3 == 0) goto L_0x000c
            r3 = 0
            goto L_0x000e
        L_0x000c:
            r3 = r64
        L_0x000e:
            r5 = r0 & 2
            if (r5 == 0) goto L_0x0014
            r5 = 0
            goto L_0x0016
        L_0x0014:
            r5 = r65
        L_0x0016:
            r6 = r0 & 4
            if (r6 == 0) goto L_0x001c
            r6 = 0
            goto L_0x001e
        L_0x001c:
            r6 = r66
        L_0x001e:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0024
            r7 = 0
            goto L_0x0026
        L_0x0024:
            r7 = r67
        L_0x0026:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002c
            r8 = 0
            goto L_0x002e
        L_0x002c:
            r8 = r68
        L_0x002e:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0034
            r9 = 0
            goto L_0x0036
        L_0x0034:
            r9 = r69
        L_0x0036:
            r11 = r0 & 64
            if (r11 == 0) goto L_0x003c
            r11 = 0
            goto L_0x003e
        L_0x003c:
            r11 = r70
        L_0x003e:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0044
            r12 = 0
            goto L_0x0046
        L_0x0044:
            r12 = r71
        L_0x0046:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x004c
            r13 = 0
            goto L_0x004e
        L_0x004c:
            r13 = r72
        L_0x004e:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0054
            r14 = 0
            goto L_0x0056
        L_0x0054:
            r14 = r73
        L_0x0056:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x005c
            r15 = 0
            goto L_0x005e
        L_0x005c:
            r15 = r74
        L_0x005e:
            r4 = r0 & 2048(0x800, float:2.87E-42)
            java.lang.String r16 = ""
            if (r4 == 0) goto L_0x0067
            r4 = r16
            goto L_0x0069
        L_0x0067:
            r4 = r75
        L_0x0069:
            r10 = r0 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x006f
            r10 = 0
            goto L_0x0071
        L_0x006f:
            r10 = r76
        L_0x0071:
            r76 = r10
            r10 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x0079
            r10 = 0
            goto L_0x007b
        L_0x0079:
            r10 = r77
        L_0x007b:
            r77 = r10
            r10 = r0 & 16384(0x4000, float:2.2959E-41)
            r17 = -1
            if (r10 == 0) goto L_0x0086
            r10 = r17
            goto L_0x0088
        L_0x0086:
            r10 = r78
        L_0x0088:
            r18 = 32768(0x8000, float:4.5918E-41)
            r19 = r0 & r18
            if (r19 == 0) goto L_0x0092
            r19 = r16
            goto L_0x0094
        L_0x0092:
            r19 = r79
        L_0x0094:
            r20 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r20
            if (r21 == 0) goto L_0x009d
            r21 = 0
            goto L_0x009f
        L_0x009d:
            r21 = r80
        L_0x009f:
            r22 = 131072(0x20000, float:1.83671E-40)
            r23 = r0 & r22
            if (r23 == 0) goto L_0x00a8
            r23 = 0
            goto L_0x00aa
        L_0x00a8:
            r23 = r81
        L_0x00aa:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00b3
            r24 = 0
            goto L_0x00b5
        L_0x00b3:
            r24 = r82
        L_0x00b5:
            r25 = 524288(0x80000, float:7.34684E-40)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00bc
            goto L_0x00be
        L_0x00bc:
            r17 = r83
        L_0x00be:
            r25 = 1048576(0x100000, float:1.469368E-39)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00c7
            r25 = 0
            goto L_0x00c9
        L_0x00c7:
            r25 = r84
        L_0x00c9:
            r26 = 2097152(0x200000, float:2.938736E-39)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00d2
            r26 = r16
            goto L_0x00d4
        L_0x00d2:
            r26 = r85
        L_0x00d4:
            r27 = 4194304(0x400000, float:5.877472E-39)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00dd
            r27 = 0
            goto L_0x00df
        L_0x00dd:
            r27 = r86
        L_0x00df:
            r28 = 8388608(0x800000, float:1.17549435E-38)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00e8
            r28 = r16
            goto L_0x00ea
        L_0x00e8:
            r28 = r87
        L_0x00ea:
            r29 = 16777216(0x1000000, float:2.3509887E-38)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00f3
            r29 = 0
            goto L_0x00f5
        L_0x00f3:
            r29 = r88
        L_0x00f5:
            r30 = 33554432(0x2000000, float:9.403955E-38)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x00fe
            r30 = 0
            goto L_0x0100
        L_0x00fe:
            r30 = r89
        L_0x0100:
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0109
            r31 = r16
            goto L_0x010b
        L_0x0109:
            r31 = r90
        L_0x010b:
            r32 = 134217728(0x8000000, float:3.85186E-34)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x0114
            r32 = 0
            goto L_0x0116
        L_0x0114:
            r32 = r91
        L_0x0116:
            r33 = 268435456(0x10000000, float:2.5243549E-29)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x011f
            r33 = 0
            goto L_0x0121
        L_0x011f:
            r33 = r92
        L_0x0121:
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            r34 = r0 & r34
            if (r34 == 0) goto L_0x012a
            r34 = 0
            goto L_0x012c
        L_0x012a:
            r34 = r93
        L_0x012c:
            r35 = 1073741824(0x40000000, float:2.0)
            r35 = r0 & r35
            if (r35 == 0) goto L_0x0135
            r35 = 0
            goto L_0x0137
        L_0x0135:
            r35 = r94
        L_0x0137:
            r36 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r36
            if (r0 == 0) goto L_0x013f
            r0 = 0
            goto L_0x0141
        L_0x013f:
            r0 = r95
        L_0x0141:
            r36 = r1 & 1
            if (r36 == 0) goto L_0x0148
            r36 = 0
            goto L_0x014a
        L_0x0148:
            r36 = r96
        L_0x014a:
            r37 = r1 & 2
            if (r37 == 0) goto L_0x0151
            r37 = 0
            goto L_0x0153
        L_0x0151:
            r37 = r97
        L_0x0153:
            r38 = r1 & 4
            if (r38 == 0) goto L_0x015a
            r38 = 0
            goto L_0x015c
        L_0x015a:
            r38 = r98
        L_0x015c:
            r39 = r1 & 8
            if (r39 == 0) goto L_0x0163
            r39 = 0
            goto L_0x0165
        L_0x0163:
            r39 = r99
        L_0x0165:
            r40 = r1 & 16
            if (r40 == 0) goto L_0x016c
            r40 = 0
            goto L_0x016e
        L_0x016c:
            r40 = r100
        L_0x016e:
            r41 = r1 & 32
            if (r41 == 0) goto L_0x0175
            r41 = 0
            goto L_0x0177
        L_0x0175:
            r41 = r101
        L_0x0177:
            r42 = r1 & 64
            if (r42 == 0) goto L_0x017e
            r42 = 0
            goto L_0x0180
        L_0x017e:
            r42 = r102
        L_0x0180:
            r95 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0188
            r0 = 0
            goto L_0x018a
        L_0x0188:
            r0 = r103
        L_0x018a:
            r103 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0192
            r0 = 0
            goto L_0x0194
        L_0x0192:
            r0 = r104
        L_0x0194:
            r104 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x019c
            r0 = 0
            goto L_0x019e
        L_0x019c:
            r0 = r105
        L_0x019e:
            r105 = r0
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01a6
            r0 = 0
            goto L_0x01a8
        L_0x01a6:
            r0 = r106
        L_0x01a8:
            r106 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01b0
            r0 = 0
            goto L_0x01b2
        L_0x01b0:
            r0 = r107
        L_0x01b2:
            r107 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01ba
            r0 = 0
            goto L_0x01bc
        L_0x01ba:
            r0 = r108
        L_0x01bc:
            r108 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01c4
            r0 = 0
            goto L_0x01c6
        L_0x01c4:
            r0 = r109
        L_0x01c6:
            r109 = r0
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01ce
            r0 = 0
            goto L_0x01d0
        L_0x01ce:
            r0 = r110
        L_0x01d0:
            r18 = r1 & r18
            if (r18 == 0) goto L_0x01d7
            r18 = r16
            goto L_0x01d9
        L_0x01d7:
            r18 = r111
        L_0x01d9:
            r20 = r1 & r20
            if (r20 == 0) goto L_0x01e0
            r20 = 0
            goto L_0x01e2
        L_0x01e0:
            r20 = r112
        L_0x01e2:
            r22 = r1 & r22
            if (r22 == 0) goto L_0x01e9
            r22 = 0
            goto L_0x01eb
        L_0x01e9:
            r22 = r113
        L_0x01eb:
            r43 = 262144(0x40000, float:3.67342E-40)
            r43 = r1 & r43
            if (r43 == 0) goto L_0x01f4
            r43 = 0
            goto L_0x01f6
        L_0x01f4:
            r43 = r114
        L_0x01f6:
            r44 = 524288(0x80000, float:7.34684E-40)
            r44 = r1 & r44
            if (r44 == 0) goto L_0x01ff
            r44 = 0
            goto L_0x0201
        L_0x01ff:
            r44 = r115
        L_0x0201:
            r45 = 1048576(0x100000, float:1.469368E-39)
            r45 = r1 & r45
            if (r45 == 0) goto L_0x020a
            r45 = 0
            goto L_0x020c
        L_0x020a:
            r45 = r116
        L_0x020c:
            r46 = 2097152(0x200000, float:2.938736E-39)
            r46 = r1 & r46
            if (r46 == 0) goto L_0x0215
            r46 = 0
            goto L_0x0217
        L_0x0215:
            r46 = r117
        L_0x0217:
            r47 = 4194304(0x400000, float:5.877472E-39)
            r47 = r1 & r47
            if (r47 == 0) goto L_0x0220
            r47 = 0
            goto L_0x0222
        L_0x0220:
            r47 = r118
        L_0x0222:
            r48 = 8388608(0x800000, float:1.17549435E-38)
            r48 = r1 & r48
            if (r48 == 0) goto L_0x022b
            r48 = 0
            goto L_0x022d
        L_0x022b:
            r48 = r119
        L_0x022d:
            r49 = 16777216(0x1000000, float:2.3509887E-38)
            r49 = r1 & r49
            if (r49 == 0) goto L_0x0236
            r49 = 0
            goto L_0x0238
        L_0x0236:
            r49 = r120
        L_0x0238:
            r50 = 33554432(0x2000000, float:9.403955E-38)
            r50 = r1 & r50
            if (r50 == 0) goto L_0x0241
            r50 = 1
            goto L_0x0243
        L_0x0241:
            r50 = r121
        L_0x0243:
            r51 = 67108864(0x4000000, float:1.5046328E-36)
            r51 = r1 & r51
            if (r51 == 0) goto L_0x024c
            r51 = 0
            goto L_0x024e
        L_0x024c:
            r51 = r122
        L_0x024e:
            r52 = 134217728(0x8000000, float:3.85186E-34)
            r52 = r1 & r52
            if (r52 == 0) goto L_0x0257
            r52 = 0
            goto L_0x0259
        L_0x0257:
            r52 = r123
        L_0x0259:
            r53 = 268435456(0x10000000, float:2.5243549E-29)
            r53 = r1 & r53
            if (r53 == 0) goto L_0x0267
            java.util.ArrayList r53 = new java.util.ArrayList
            r53.<init>()
            java.util.List r53 = (java.util.List) r53
            goto L_0x0269
        L_0x0267:
            r53 = r124
        L_0x0269:
            r54 = 536870912(0x20000000, float:1.0842022E-19)
            r54 = r1 & r54
            if (r54 == 0) goto L_0x0272
            r54 = 0
            goto L_0x0274
        L_0x0272:
            r54 = r125
        L_0x0274:
            r55 = 1073741824(0x40000000, float:2.0)
            r55 = r1 & r55
            if (r55 == 0) goto L_0x027d
            r55 = 0
            goto L_0x027f
        L_0x027d:
            r55 = r126
        L_0x027f:
            r56 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r56
            if (r1 == 0) goto L_0x0287
            r1 = 0
            goto L_0x0289
        L_0x0287:
            r1 = r127
        L_0x0289:
            r56 = r2 & 1
            if (r56 == 0) goto L_0x0290
            r56 = 0
            goto L_0x0292
        L_0x0290:
            r56 = r128
        L_0x0292:
            r57 = r2 & 2
            if (r57 == 0) goto L_0x0299
            r57 = 0
            goto L_0x029b
        L_0x0299:
            r57 = r129
        L_0x029b:
            r58 = r2 & 4
            if (r58 == 0) goto L_0x02a2
            r58 = 0
            goto L_0x02a4
        L_0x02a2:
            r58 = r130
        L_0x02a4:
            r59 = r2 & 8
            if (r59 == 0) goto L_0x02ab
            r59 = 0
            goto L_0x02ad
        L_0x02ab:
            r59 = r131
        L_0x02ad:
            r60 = r2 & 16
            if (r60 == 0) goto L_0x02b4
            r60 = r16
            goto L_0x02b6
        L_0x02b4:
            r60 = r132
        L_0x02b6:
            r61 = r2 & 32
            if (r61 == 0) goto L_0x02bd
            r61 = 0
            goto L_0x02bf
        L_0x02bd:
            r61 = r133
        L_0x02bf:
            r62 = r2 & 64
            if (r62 == 0) goto L_0x02c6
            r62 = 0
            goto L_0x02c8
        L_0x02c6:
            r62 = r134
        L_0x02c8:
            r127 = r1
            r1 = r2 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x02d0
            r1 = 0
            goto L_0x02d2
        L_0x02d0:
            r1 = r135
        L_0x02d2:
            r135 = r1
            r1 = r2 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x02da
            r1 = 0
            goto L_0x02dc
        L_0x02da:
            r1 = r136
        L_0x02dc:
            r136 = r1
            r1 = r2 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x02e4
            r1 = 0
            goto L_0x02e6
        L_0x02e4:
            r1 = r137
        L_0x02e6:
            r137 = r1
            r1 = r2 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x02ee
            r1 = 0
            goto L_0x02f0
        L_0x02ee:
            r1 = r138
        L_0x02f0:
            r138 = r1
            r1 = r2 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x02f8
            r1 = 0
            goto L_0x02fa
        L_0x02f8:
            r1 = r139
        L_0x02fa:
            r139 = r1
            r1 = r2 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0301
            goto L_0x0303
        L_0x0301:
            r16 = r140
        L_0x0303:
            r1 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0309
            r1 = 0
            goto L_0x030b
        L_0x0309:
            r1 = r141
        L_0x030b:
            r64 = r3
            r65 = r5
            r66 = r6
            r67 = r7
            r68 = r8
            r69 = r9
            r70 = r11
            r71 = r12
            r72 = r13
            r73 = r14
            r74 = r15
            r75 = r4
            r78 = r10
            r79 = r19
            r80 = r21
            r81 = r23
            r82 = r24
            r83 = r17
            r84 = r25
            r85 = r26
            r86 = r27
            r87 = r28
            r88 = r29
            r89 = r30
            r90 = r31
            r91 = r32
            r92 = r33
            r93 = r34
            r94 = r35
            r96 = r36
            r97 = r37
            r98 = r38
            r99 = r39
            r100 = r40
            r101 = r41
            r102 = r42
            r110 = r0
            r111 = r18
            r112 = r20
            r113 = r22
            r114 = r43
            r115 = r44
            r116 = r45
            r117 = r46
            r118 = r47
            r119 = r48
            r120 = r49
            r121 = r50
            r122 = r51
            r123 = r52
            r124 = r53
            r125 = r54
            r126 = r55
            r128 = r56
            r129 = r57
            r130 = r58
            r131 = r59
            r132 = r60
            r133 = r61
            r134 = r62
            r140 = r16
            r141 = r1
            r63.<init>(r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.detail.AdData.<init>(java.lang.Integer, java.lang.Integer, com.baidu.searchbox.ad.model.FeedAdOperate, com.baidu.searchbox.feed.ad.model.AdExt, com.baidu.searchbox.feed.ad.model.ExtData, int, int, com.baidu.searchbox.feed.ad.model.TailFrame, com.baidu.searchbox.feed.ad.model.AdLpParams$EnhanceModel, com.baidu.searchbox.ad.model.AdNormandyModel, com.baidu.searchbox.feed.ad.model.AdInfo, java.lang.String, com.baidu.searchbox.feed.ad.model.AdLpParams$PopoverModel, com.baidu.searchbox.ad.charge.AdAreaInfo, int, java.lang.String, java.lang.String, java.lang.String, com.baidu.searchbox.feed.ad.model.NadDoubleButtonsModel, int, com.baidu.searchbox.flowvideo.detail.repos.LiveInteractModel, java.lang.String, com.baidu.searchbox.flowvideo.detail.repos.LiveEntranceModel, java.lang.String, int, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, com.baidu.searchbox.flowvideo.ad.api.SvButton, com.baidu.searchbox.ad.model.NadSicilyModel, com.baidu.nadcore.model.NadSlidingTagModel, com.baidu.nadcore.videoextra.model.NadHighLightTextModel, boolean, com.baidu.searchbox.video.feedflow.ad.componenttypeswitch.ComponentTypeSwitchModel, boolean, java.util.List, com.baidu.searchbox.video.feedflow.ad.lottie.FlowAdLottieModel, boolean, com.baidu.searchbox.ad.model.NadTag, java.lang.String, boolean, java.util.List, com.baidu.nadcore.model.NadMountTagModel, java.lang.String, com.baidu.searchbox.feed.ad.model.CommentNadTitleData, int, boolean, boolean, com.baidu.searchbox.video.feedflow.ad.bottombanner.NadBottomBannerModel, com.baidu.nadcore.model.NadRotationPopModel, java.lang.String, com.baidu.searchbox.video.feedflow.ad.adextend.AdExtend, boolean, boolean, com.baidu.nadcore.model.NadStructureTagModel, com.baidu.nadcore.carousel.NadCarouselItemModel, java.util.List, java.lang.String, com.baidu.nadcore.model.NadFullScreenModel, java.util.List, boolean, boolean, com.baidu.searchbox.video.feedflow.ad.adreminder.NadReminderModel, com.baidu.searchbox.video.feedflow.ad.dynamic.NadDynamicModel, java.lang.String, com.baidu.searchbox.video.feedflow.ad.summary.NadSummaryTitleModel, java.util.List, com.baidu.searchbox.video.feedflow.ad.summary.expand.NadExpandHotAreaModel, com.baidu.nadcore.tailframe.NadImageTailFrameModel, int, com.baidu.searchbox.video.feedflow.ad.lottie.guidelottie.NadGuideLottieModel, java.lang.String, java.lang.String, com.baidu.searchbox.video.feedflow.ad.landscape.background.LandscapeBg, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getVideoWidth() {
        return this.videoWidth;
    }

    public final Integer getVideoHeight() {
        return this.videoHeight;
    }

    public final FeedAdOperate getOperate() {
        return this.operate;
    }

    public final AdExt getExtraInfo() {
        return this.extraInfo;
    }

    public final ExtData getExtraData() {
        return this.extraData;
    }

    public final int getTailShow() {
        return this.tailShow;
    }

    public final int getTailShowAutoPlay() {
        return this.tailShowAutoPlay;
    }

    public final TailFrame getTailFrame() {
        return this.tailFrame;
    }

    public final AdLpParams.EnhanceModel getEnhancement() {
        return this.enhancement;
    }

    public final void setEnhancement(AdLpParams.EnhanceModel enhanceModel) {
        this.enhancement = enhanceModel;
    }

    public final AdNormandyModel getNormandy() {
        return this.normandy;
    }

    public final AdInfo getAdInfo() {
        return this.adInfo;
    }

    public final String getCmd() {
        return this.cmd;
    }

    public final void setCmd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cmd = str;
    }

    public final AdLpParams.PopoverModel getPopover() {
        return this.popover;
    }

    public final void setPopover(AdLpParams.PopoverModel popoverModel) {
        this.popover = popoverModel;
    }

    public final AdAreaInfo getAreaInfo() {
        return this.areaInfo;
    }

    public final int getPrefetchUpload() {
        return this.prefetchUpload;
    }

    public final String getLpRealUrl() {
        return this.lpRealUrl;
    }

    public final String getLeftSlideCmd() {
        return this.leftSlideCmd;
    }

    public final String getTitleCmd() {
        return this.titleCmd;
    }

    public final NadDoubleButtonsModel getButtons() {
        return this.buttons;
    }

    public final int getLiveState() {
        return this.liveState;
    }

    public final LiveInteractModel getLiveInteract() {
        return this.liveInteract;
    }

    public final String getLiveTagText() {
        return this.liveTagText;
    }

    public final LiveEntranceModel getLiveEntrance() {
        return this.liveEntrance;
    }

    public final String isVerticalScreen() {
        return this.isVerticalScreen;
    }

    public final int getAdVTag() {
        return this.adVTag;
    }

    public final List<String> getTransformPortraitCmdList() {
        return this.transformPortraitCmdList;
    }

    public final String getAuthorCmd() {
        return this.authorCmd;
    }

    public final String getCommentTopSwitch() {
        return this.commentTopSwitch;
    }

    public final String getPrerenderScheme() {
        return this.prerenderScheme;
    }

    public final String getCommentTop() {
        return this.commentTop;
    }

    public final List<NadRecTag> getRecTagList() {
        return this.recTagList;
    }

    public final int getButtonIconExpSwitch() {
        return this.buttonIconExpSwitch;
    }

    public final SvButton getSvButton() {
        return this.svButton;
    }

    public final NadSicilyModel getSicilyPop() {
        return this.sicilyPop;
    }

    public final NadSlidingTagModel getSlidingTag() {
        return this.slidingTag;
    }

    public final NadHighLightTextModel getSvTitle() {
        return this.svTitle;
    }

    public final void setSvTitle(NadHighLightTextModel nadHighLightTextModel) {
        this.svTitle = nadHighLightTextModel;
    }

    public final boolean getChargeByAreaOfflineAbSwitch() {
        return this.chargeByAreaOfflineAbSwitch;
    }

    public final ComponentTypeSwitchModel getComponentTypeSwitch() {
        return this.componentTypeSwitch;
    }

    public final boolean getLeftSlideRequestClickUrlSwitch() {
        return this.leftSlideRequestClickUrlSwitch;
    }

    public final List<String> getPrefetchUrlList() {
        return this.prefetchUrlList;
    }

    public final FlowAdLottieModel getLottieModel() {
        return this.lottieModel;
    }

    public final boolean getNextCardShow() {
        return this.nextCardShow;
    }

    public final NadTag getAdTag() {
        return this.adTag;
    }

    public final String getEtrade() {
        return this.etrade;
    }

    public final boolean getSupportHorizontalSwitch() {
        return this.supportHorizontalSwitch;
    }

    public final List<String> getPreRenderSchemeList() {
        return this.preRenderSchemeList;
    }

    public final NadMountTagModel getMountTag() {
        return this.mountTag;
    }

    public final void setMountTag(NadMountTagModel nadMountTagModel) {
        this.mountTag = nadMountTagModel;
    }

    public final String getContextExt() {
        return this.contextExt;
    }

    public final CommentNadTitleData getCommentTitleMount() {
        return this.commentTitleMount;
    }

    public final int getForbidAutoPlayNext() {
        return this.forbidAutoPlayNext;
    }

    public final boolean getHasInteractionStrategy() {
        return this.hasInteractionStrategy;
    }

    public final boolean isScheduledDownload() {
        return this.isScheduledDownload;
    }

    public final NadBottomBannerModel getBottomEntry() {
        return this.bottomEntry;
    }

    public final NadRotationPopModel getRotationPop() {
        return this.rotationPop;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final AdExtend getAdExtend() {
        return this.adExtend;
    }

    public final boolean isFromLanscape() {
        return this.isFromLanscape;
    }

    public final boolean getCanFollowMove() {
        return this.canFollowMove;
    }

    public final NadStructureTagModel getStructureTag() {
        return this.structureTag;
    }

    public final void setStructureTag(NadStructureTagModel nadStructureTagModel) {
        this.structureTag = nadStructureTagModel;
    }

    public final NadCarouselItemModel getCarouselTile() {
        return this.carouselTile;
    }

    public final void setCarouselTile(NadCarouselItemModel nadCarouselItemModel) {
        this.carouselTile = nadCarouselItemModel;
    }

    public final List<AdTimeInvokeCmdModel> getTimeInvokeCmdList() {
        return this.timeInvokeCmdList;
    }

    public final String getLiveMataInfo() {
        return this.liveMataInfo;
    }

    public final NadFullScreenModel getFullScreen() {
        return this.fullScreen;
    }

    public final List<String> getExtendTags() {
        return this.extendTags;
    }

    public final boolean getForbidTailAnim() {
        return this.forbidTailAnim;
    }

    public final boolean getForbidPosterWhenShowTail() {
        return this.forbidPosterWhenShowTail;
    }

    public final NadReminderModel getAdReminder() {
        return this.adReminder;
    }

    public final NadDynamicModel getAdDynamic() {
        return this.adDynamic;
    }

    public final String getExtLog() {
        return this.extLog;
    }

    public final NadSummaryTitleModel getAdTitleZone() {
        return this.adTitleZone;
    }

    public final List<NadAiInteractionItemModel> getAiInteractions() {
        return this.aiInteractions;
    }

    public final void setAiInteractions(List<NadAiInteractionItemModel> list) {
        this.aiInteractions = list;
    }

    public final NadExpandHotAreaModel getZoomClickArea() {
        return this.zoomClickArea;
    }

    public final NadImageTailFrameModel getImageTailFrame() {
        return this.imageTailFrame;
    }

    public final int getMaterialType() {
        return this.materialType;
    }

    public final NadGuideLottieModel getGuideLottie() {
        return this.guideLottie;
    }

    public final String getLiveNid() {
        return this.liveNid;
    }

    public final String getPoster() {
        return this.poster;
    }

    public final LandscapeBg getLandscapeBg() {
        return this.landscapeBg;
    }
}
