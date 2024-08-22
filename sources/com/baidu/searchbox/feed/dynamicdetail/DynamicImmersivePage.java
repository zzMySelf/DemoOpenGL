package com.baidu.searchbox.feed.dynamicdetail;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.time.CountDownTimer;
import com.baidu.searchbox.ad.util.CollectionUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.datachannel.Contract;
import com.baidu.searchbox.datachannel.DataChannel;
import com.baidu.searchbox.feed.FeedApi;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.ioc.INadDynamicImmersiveInsertManager;
import com.baidu.searchbox.feed.apm.fluency.FluencyInfoTracer;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.hot.IDynamicAutoPlay;
import com.baidu.searchbox.feed.controller.FeedRecyclerViewDelegate;
import com.baidu.searchbox.feed.controller.ILinkageOperation;
import com.baidu.searchbox.feed.controller.mutevideo.MuteVideoPlayController;
import com.baidu.searchbox.feed.dynamicdetail.DynamicTplStartController;
import com.baidu.searchbox.feed.dynamicdetail.context.DynamicRuntime;
import com.baidu.searchbox.feed.dynamicdetail.linkage.DynamicImmersiveNAReceiver;
import com.baidu.searchbox.feed.dynamicdetail.net.DynamicListPreFetcher;
import com.baidu.searchbox.feed.dynamicdetail.net.DynamicReadInsertRequestManager;
import com.baidu.searchbox.feed.dynamicdetail.net.DynamicRequestManager;
import com.baidu.searchbox.feed.dynamicdetail.net.DynamicRequestManagerKt;
import com.baidu.searchbox.feed.dynamicdetail.prefetch.DynamicPrefetchProcessor;
import com.baidu.searchbox.feed.dynamicdetail.prefetch.db.DynamicDBProvider;
import com.baidu.searchbox.feed.dynamicdetail.statistics.DynamicImmersiveDisplayMeasure;
import com.baidu.searchbox.feed.dynamicdetail.statistics.DynamicImmersiveReportInfoUploadManager;
import com.baidu.searchbox.feed.dynamicdetail.tts.DynamicImmersiveTtsManager;
import com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicFeedTemplateStatistics;
import com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper;
import com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicTemplateProvider;
import com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicTemplateStatistics;
import com.baidu.searchbox.feed.dynamicdetail.ubc.arrival.DynamicArrivalProcessor;
import com.baidu.searchbox.feed.dynamicdetail.ubc.firstscreen.FSPStatisticsProcessor;
import com.baidu.searchbox.feed.dynamicdetail.ubc.firstscreen.FirstScreenPerformanceHelper;
import com.baidu.searchbox.feed.dynamicdetail.utils.DynamicUtilsKt;
import com.baidu.searchbox.feed.dynamicdetail.utils.PrefetchSelectUtils;
import com.baidu.searchbox.feed.event.NewLinkageDataEvent;
import com.baidu.searchbox.feed.ioc.IFeedAgility;
import com.baidu.searchbox.feed.list.RefreshableListPage;
import com.baidu.searchbox.feed.list.adapter.PageAdapter;
import com.baidu.searchbox.feed.list.cache.StrategyDataManager;
import com.baidu.searchbox.feed.list.cache.strategy.DataMgrStrategy;
import com.baidu.searchbox.feed.list.controller.ListController;
import com.baidu.searchbox.feed.list.policy.FeedMainProcessorDispatcher;
import com.baidu.searchbox.feed.list.policy.process.base.FeedBaseDataProcessor;
import com.baidu.searchbox.feed.list.requester.IRefreshAction;
import com.baidu.searchbox.feed.list.requester.paramter.ParamAssembler;
import com.baidu.searchbox.feed.list.widget.CommonFooterView;
import com.baidu.searchbox.feed.list.widget.IRefreshFooter;
import com.baidu.searchbox.feed.list.widget.StateLayoutManager;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBaseModelHelper;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataHotStripe;
import com.baidu.searchbox.feed.model.FeedItemDataStar;
import com.baidu.searchbox.feed.model.FeedItemDataStarThreeExpandImg;
import com.baidu.searchbox.feed.model.FeedPolicyModel;
import com.baidu.searchbox.feed.model.FeedRuntimeStatus;
import com.baidu.searchbox.feed.parser.IFeedDataParser;
import com.baidu.searchbox.feed.statistic.FeedDisplayReport;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.tab.interaction.IFeedAdapter;
import com.baidu.searchbox.feed.tab.view.FeedThickDividerPolicy;
import com.baidu.searchbox.feed.template.ChattingRoomEntranceViewKt;
import com.baidu.searchbox.feed.template.FeedAdBaseView;
import com.baidu.searchbox.feed.template.FeedTemplateUtil;
import com.baidu.searchbox.feed.template.NewsFeedBaseView;
import com.baidu.searchbox.feed.template.statistic.FeedTemplateStatTable;
import com.baidu.searchbox.feed.template.statistic.ITemplateStatistics;
import com.baidu.searchbox.feed.template.statistic.TemplateStatisticsTable;
import com.baidu.searchbox.feed.template.tplinterface.IBindableData;
import com.baidu.searchbox.feed.template.utils.FeedHotTemplateUtils;
import com.baidu.searchbox.feed.template.utils.FeedItemImgClickListenerTable;
import com.baidu.searchbox.feed.util.ReadingRecord;
import com.baidu.searchbox.feed.widget.newsfeedback.FeedbackPop;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.ShimmerFrameLayout;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Ç\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001M\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006£\u0002¤\u0002¥\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u0001\u001a\u00020T2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020T2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\u0015\u0010\u0001\u001a\u00020T2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\u0015\u0010\u0001\u001a\u00020T2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\t\u0010\u0001\u001a\u00020TH\u0014J\u0012\u0010\u0001\u001a\u0002032\u0007\u0010\u0001\u001a\u00020cH\u0002J\t\u0010\u0001\u001a\u00020TH\u0002J\u0012\u0010\u0001\u001a\u00020T2\u0007\u0010\u0001\u001a\u00020*H\u0002J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010O\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u000203H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u0002032\u0007\u0010\u0001\u001a\u00020*H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u001b\u0010\u0001\u001a\u00020T2\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u000203H\u0002J\u0012\u0010\u0001\u001a\u00020T2\u0007\u0010\u0001\u001a\u000203H\u0002J\u001b\u0010\u0001\u001a\u00020T2\u0007\u0010 \u0001\u001a\u00020\u00062\u0007\u0010¡\u0001\u001a\u00020*H\u0016J\u0019\u0010¢\u0001\u001a\u00020T2\u0010\u0010£\u0001\u001a\u000b\u0012\u0004\u0012\u00020j\u0018\u00010¤\u0001J\u0010\u0010¥\u0001\u001a\u00020T2\u0007\u0010¦\u0001\u001a\u00020\u0006J\u0014\u0010§\u0001\u001a\u00020T2\t\b\u0001\u0010¨\u0001\u001a\u00020\u0006H\u0002J\t\u0010©\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010ª\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010«\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010¬\u0001\u001a\u0002032\t\u0010­\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J6\u0010®\u0001\u001a\u00020T2\u0006\u0010O\u001a\u00020\u00062#\u0010¯\u0001\u001a\u001e\u0012\u0014\u0012\u00120*¢\u0006\r\bR\u0012\t\bS\u0012\u0005\b\b(°\u0001\u0012\u0004\u0012\u00020T0QH\u0002J\n\u0010±\u0001\u001a\u00030²\u0001H\u0016J\t\u0010³\u0001\u001a\u00020TH\u0002J\u0014\u0010´\u0001\u001a\u00020T2\t\u0010µ\u0001\u001a\u0004\u0018\u00010jH\u0002J\u001f\u0010¶\u0001\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010c2\t\u0010µ\u0001\u001a\u0004\u0018\u00010jH\u0002J\u001f\u0010·\u0001\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010c2\t\u0010µ\u0001\u001a\u0004\u0018\u00010jH\u0002J&\u0010¸\u0001\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010c2\u0007\u0010µ\u0001\u001a\u00020j2\u0007\u0010\u0001\u001a\u000203H\u0002J1\u0010¹\u0001\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010c2\t\u0010º\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010»\u0001\u001a\u0002032\u0007\u0010¼\u0001\u001a\u00020*H\u0002J\t\u0010½\u0001\u001a\u00020TH\u0002J\t\u0010¾\u0001\u001a\u00020TH\u0002J\t\u0010¿\u0001\u001a\u00020TH\u0002J\t\u0010À\u0001\u001a\u00020TH\u0002J\t\u0010Á\u0001\u001a\u00020TH\u0002J\t\u0010Â\u0001\u001a\u00020TH\u0002J\t\u0010Ã\u0001\u001a\u00020TH\u0002J\t\u0010Ä\u0001\u001a\u00020TH\u0002Jh\u0010Å\u0001\u001a\u00020T2\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0006\u0010O\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010x\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020\u00062\t\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0006\u0010y\u001a\u00020\u00062\u0006\u0010A\u001a\u00020*2\u0007\u0010É\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020*2\u0006\u00106\u001a\u00020\u0006J\t\u0010Ê\u0001\u001a\u00020TH\u0002J\t\u0010Ë\u0001\u001a\u00020TH\u0002J\t\u0010Ì\u0001\u001a\u00020TH\u0002J\u0012\u0010Í\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020cH\u0002J\t\u0010Î\u0001\u001a\u00020*H\u0002J\u0012\u0010Ï\u0001\u001a\u00020*2\u0007\u0010º\u0001\u001a\u00020jH\u0002J\u000e\u0010Ð\u0001\u001a\u00070Ñ\u0001R\u00020\u0001H\u0014J\t\u0010Ò\u0001\u001a\u00020TH\u0007J\t\u0010Ó\u0001\u001a\u00020TH\u0002J\u0010\u0010Ô\u0001\u001a\u00020T2\u0007\u0010Õ\u0001\u001a\u000203J\u0014\u0010Ö\u0001\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010cH\u0016J\u0014\u0010×\u0001\u001a\u00020T2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010cH\u0016J\u0013\u0010Ù\u0001\u001a\u00020T2\b\u0010Ú\u0001\u001a\u00030Û\u0001H\u0002J\u0007\u0010Ü\u0001\u001a\u00020TJ'\u0010Ý\u0001\u001a\u000b\u0012\u0004\u0012\u00020j\u0018\u00010Þ\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010ß\u0001\u001a\u00020*H\u0014J'\u0010à\u0001\u001a\u000b\u0012\u0004\u0012\u00020j\u0018\u00010Þ\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010ß\u0001\u001a\u00020*H\u0014J*\u0010á\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010â\u00012\u0010\u0010ã\u0001\u001a\u000b\u0012\u0004\u0012\u00020j\u0018\u00010Þ\u0001H\u0014J\u001b\u0010ä\u0001\u001a\u00020T2\u0007\u0010å\u0001\u001a\u00020j2\u0007\u0010æ\u0001\u001a\u00020*H\u0014J\u0012\u0010ç\u0001\u001a\u00020T2\u0007\u0010è\u0001\u001a\u00020*H\u0016J\u0012\u0010é\u0001\u001a\u00020T2\u0007\u0010ê\u0001\u001a\u000203H\u0002J(\u0010ë\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!0â\u00012\u0010\u0010ã\u0001\u001a\u000b\u0012\u0004\u0012\u00020j\u0018\u00010Þ\u0001H\u0014J\t\u0010ì\u0001\u001a\u00020TH\u0014J\u001c\u0010í\u0001\u001a\u00020T2\b\u0010î\u0001\u001a\u00030²\u00012\u0007\u0010ï\u0001\u001a\u000203H\u0016J%\u0010ð\u0001\u001a\u00020T2\b\u0010î\u0001\u001a\u00030²\u00012\u0007\u0010ñ\u0001\u001a\u0002032\u0007\u0010Õ\u0001\u001a\u000203H\u0016J(\u0010ò\u0001\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010c2\t\u0010ó\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010\u0001\u001a\u000203H\u0014J(\u0010ô\u0001\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010c2\t\u0010µ\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010\u0001\u001a\u000203H\u0014J9\u0010õ\u0001\u001a\u00020T2\u0007\u0010ö\u0001\u001a\u00020*2'\b\u0002\u0010÷\u0001\u001a \u0012\u0014\u0012\u001203¢\u0006\r\bR\u0012\t\bS\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020T\u0018\u00010QJ(\u0010ø\u0001\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010c2\t\u0010º\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010\u0001\u001a\u000203H\u0014J\t\u0010ù\u0001\u001a\u00020TH\u0016J\t\u0010ú\u0001\u001a\u00020TH\u0016J\t\u0010û\u0001\u001a\u00020TH\u0016J\t\u0010ü\u0001\u001a\u00020TH\u0002J\t\u0010ý\u0001\u001a\u00020TH\u0002J\t\u0010þ\u0001\u001a\u00020TH\u0002J\u0011\u0010ÿ\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0\u0018H\u0016J\t\u0010\u0002\u001a\u00020TH\u0002J\u0012\u0010\u0002\u001a\u00020T2\u0007\u0010\u0002\u001a\u00020\u0006H\u0002J\t\u0010\u0002\u001a\u00020TH\u0002J\t\u0010\u0002\u001a\u00020TH\u0002J\u0014\u0010\u0002\u001a\u00020T2\t\u0010µ\u0001\u001a\u0004\u0018\u00010jH\u0002J1\u0010\u0002\u001a\u00020T2\u0007\u0010\u0002\u001a\u0002032\n\u0010\u0002\u001a\u0005\u0018\u00010\u00022\u0011\u0010\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u0002H\u0016J\u0015\u0010\u0002\u001a\u00020T2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J(\u0010\u0002\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010c2\t\u0010º\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010\u0001\u001a\u000203H\u0002J\u0012\u0010\u0002\u001a\u00020T2\u0007\u0010ß\u0001\u001a\u00020*H\u0002J\u0013\u0010\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0002H\u0016J\u0007\u0010\u0002\u001a\u00020TJ\t\u0010\u0002\u001a\u00020TH\u0002J\t\u0010\u0002\u001a\u00020TH\u0002J\t\u0010\u0002\u001a\u00020TH\u0002J\t\u0010\u0002\u001a\u00020TH\u0002J\u0010\u0010\u0002\u001a\u00020T2\u0007\u0010\u0002\u001a\u000203J\u0012\u0010\u0002\u001a\u00020T2\u0007\u0010\u0002\u001a\u000203H\u0002J\t\u0010\u0002\u001a\u00020TH\u0002J\u0012\u0010\u0002\u001a\u00020T2\u0007\u0010\u0002\u001a\u00020\u0006H\u0002J\t\u0010\u0002\u001a\u00020*H\u0002J\u0012\u0010\u0002\u001a\u00020*2\u0007\u0010É\u0001\u001a\u00020\u0006H\u0002J\t\u0010\u0002\u001a\u00020TH\u0002J\u0012\u0010 \u0002\u001a\u00020T2\u0007\u0010\u0002\u001a\u00020\u0006H\u0002J\u001b\u0010¡\u0002\u001a\u00020T2\u0010\u0010¢\u0002\u001a\u000b\u0012\u0004\u0012\u00020j\u0018\u00010¤\u0001H\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010D\u001a\n F*\u0004\u0018\u00010E0EX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u00020MX\u0004¢\u0006\u0004\n\u0002\u0010NR\u000e\u0010O\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R9\u0010P\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020T\u0018\u00010QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Y\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010_\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\\\"\u0004\ba\u0010^R\u001c\u0010b\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u000e\u0010h\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020j0\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010m\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u000e\u0010r\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010s\u001a\u0004\u0018\u00010tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010z\u001a\u0004\u0018\u00010{8BX\u0002¢\u0006\f\n\u0004\b~\u0010\u001a\u0004\b|\u0010}R\u001f\u0010\u0001\u001a\u000203X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006¦\u0002"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage;", "Lcom/baidu/searchbox/feed/list/RefreshableListPage;", "Lcom/baidu/searchbox/skin/callback/NightModeChangeListener;", "Lcom/baidu/searchbox/feed/list/widget/StateLayoutManager$OnCommonClickListener;", "Lcom/baidu/searchbox/feed/dynamicdetail/statistics/DynamicImmersiveDisplayMeasure$MeasuredPage;", "assignId", "", "(Ljava/lang/String;)V", "actionBarVisibilityListener", "Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage$ActionBarVisibilityListener;", "getActionBarVisibilityListener", "()Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage$ActionBarVisibilityListener;", "setActionBarVisibilityListener", "(Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage$ActionBarVisibilityListener;)V", "adInsertManager", "Lcom/baidu/searchbox/feed/ad/ioc/INadDynamicImmersiveInsertManager;", "arrivalProcessor", "Lcom/baidu/searchbox/feed/dynamicdetail/ubc/arrival/DynamicArrivalProcessor;", "getArrivalProcessor", "()Lcom/baidu/searchbox/feed/dynamicdetail/ubc/arrival/DynamicArrivalProcessor;", "setArrivalProcessor", "(Lcom/baidu/searchbox/feed/dynamicdetail/ubc/arrival/DynamicArrivalProcessor;)V", "authorId", "bannerList", "Ljava/util/ArrayList;", "Landroidx/viewpager/widget/ViewPager;", "getBannerList", "()Ljava/util/ArrayList;", "setBannerList", "(Ljava/util/ArrayList;)V", "coldRestoreReportTimer", "Lcom/baidu/android/util/time/CountDownTimer;", "collectKey", "", "curPlayTemplate", "Lcom/baidu/searchbox/feed/base/hot/IDynamicAutoPlay;", "currentFeedId", "displayMeasure", "Lcom/baidu/searchbox/feed/dynamicdetail/statistics/DynamicImmersiveDisplayMeasure;", "dynamicItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "existPrefetch", "", "extRequest", "feedPolicyModel", "Lcom/baidu/searchbox/feed/model/FeedPolicyModel;", "getFeedPolicyModel", "()Lcom/baidu/searchbox/feed/model/FeedPolicyModel;", "setFeedPolicyModel", "(Lcom/baidu/searchbox/feed/model/FeedPolicyModel;)V", "firstScreenTplTotalHeight", "", "fluencyInfoTracer", "Lcom/baidu/searchbox/feed/apm/fluency/FluencyInfoTracer;", "fromChannel", "fspStatisticsProcessor", "Lcom/baidu/searchbox/feed/dynamicdetail/ubc/firstscreen/FSPStatisticsProcessor;", "getFspStatisticsProcessor", "()Lcom/baidu/searchbox/feed/dynamicdetail/ubc/firstscreen/FSPStatisticsProcessor;", "setFspStatisticsProcessor", "(Lcom/baidu/searchbox/feed/dynamicdetail/ubc/firstscreen/FSPStatisticsProcessor;)V", "handlePullDataCount", "hasReportColdRestoreDau", "hasStaticsDAU", "interactiveStr", "isColdRestore", "isItemDeleted", "isRequestInsertData", "mAgility", "Lcom/baidu/searchbox/feed/ioc/IFeedAgility;", "kotlin.jvm.PlatformType", "mIFeedTplContainer", "Lcom/baidu/searchbox/feed/controller/FeedRecyclerViewDelegate;", "naReceiver", "Lcom/baidu/searchbox/feed/dynamicdetail/linkage/DynamicImmersiveNAReceiver;", "netDataFullScreen", "netWorkChangeReceiver", "com/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage$netWorkChangeReceiver$1", "Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage$netWorkChangeReceiver$1;", "nid", "onFirstItemRealShowCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnFirstItemRealShowCallback", "()Lkotlin/jvm/functions/Function1;", "setOnFirstItemRealShowCallback", "(Lkotlin/jvm/functions/Function1;)V", "onItemDeletedCallback", "Lkotlin/Function0;", "getOnItemDeletedCallback", "()Lkotlin/jvm/functions/Function0;", "setOnItemDeletedCallback", "(Lkotlin/jvm/functions/Function0;)V", "onPageRecoveryCallback", "getOnPageRecoveryCallback", "setOnPageRecoveryCallback", "pageView", "Landroid/view/View;", "getPageView", "()Landroid/view/View;", "setPageView", "(Landroid/view/View;)V", "preFetchTplShow", "prefetchList", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "prefetchProcessor", "Lcom/baidu/searchbox/feed/dynamicdetail/prefetch/DynamicPrefetchProcessor;", "pullRefreshSuccess", "getPullRefreshSuccess", "()Z", "setPullRefreshSuccess", "(Z)V", "refreshCount", "reportInfoManager", "Lcom/baidu/searchbox/feed/dynamicdetail/statistics/DynamicImmersiveReportInfoUploadManager;", "shimmerLayout", "Lcom/baidu/searchbox/ui/ShimmerFrameLayout;", "slideCount", "source", "strategyType", "ttsManager", "Lcom/baidu/searchbox/feed/dynamicdetail/tts/DynamicImmersiveTtsManager;", "getTtsManager", "()Lcom/baidu/searchbox/feed/dynamicdetail/tts/DynamicImmersiveTtsManager;", "ttsManager$delegate", "Lkotlin/Lazy;", "visibleZoomHeight", "getVisibleZoomHeight", "()I", "setVisibleZoomHeight", "(I)V", "addHistory", "feedFlowModel", "Lcom/baidu/searchbox/feed/model/FeedFlowModel;", "applyPolicyAfterLoadComplete", "applyPolicyBeforeLoadDataHandle", "applyPolicyBeforePullDataHandle", "beforePullRequestDataParse", "calculationTemplateViewHeight", "view", "clearDataManager", "configPage", "needPullRefresh", "createCommentParam", "Lorg/json/JSONObject;", "num", "createCommonTextParam", "content", "createLikeParam", "count", "status", "createReadParam", "deleteBindTemplate", "currentTemplateId", "position", "displayReport", "actionType", "doRefreshing", "refreshSource", "useAnim", "doShowPublishDisplay", "displayItems", "", "floatNextPageStatistics", "type", "genDbPrefetchData", "prefetchData", "getChannelId", "getFeedBaseModeById", "uKey", "getPositionById", "id", "getPrefetchDynamicData", "prefetchStatusCallback", "success", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "handleDauStatisticIfNeed", "handleInsertAfterRead", "feed", "handleNetDataStatics", "handlePrefetchDataStatics", "handleTemplateShowStatistics", "handleTplScrollEvent", "model", "index", "isExpand", "hideBlankView", "initAdInsertModule", "initArrivalStatisticsModule", "initColdRestoreReport", "initDisplayMeasure", "initEventNotificationModule", "initFSPStatisticsModule", "initFluencyManager", "initPage", "context", "Landroid/app/Activity;", "interactiveData", "scene", "initPrefetchModule", "initReportInfoManager", "initStatisticsModule", "isCompleteVisible", "isPlayingAd", "isSpecialTpl", "newListItemCreator", "Lcom/baidu/searchbox/feed/list/RefreshableListPage$RefreshableItemCreator;", "notifyDataSetChanged", "notifyPrefetchUi", "onContentScrolled", "dy", "onEmptyClick", "onErrorClick", "textView", "onEvent", "event", "Lcom/baidu/searchbox/config/eventmessage/FontSizeChangeMessage;", "onForegroundToBackground", "onHandleLoadData", "", "isSuccess", "onHandlePullData", "onLoadComplete", "", "newFeeds", "onLoadMoreAction", "last", "isPrefetch", "onNightModeChanged", "isNightMode", "onPrefetchData", "state", "onPullComplete", "onPullRefreshAction", "onScrollStateChanged", "recyclerView", "newState", "onScrolled", "dx", "onTemplateClick", "baseModel", "onTemplateShow", "onTtsIconClick", "isPlayingTts", "scrollItem", "onUnlikeClick", "onViewDestroy", "onViewPause", "onViewResume", "pausePlayAd", "prerenderAd", "processDataLinkages", "queryVisibleViewList", "registerLinkageEvent", "registerNAReceive", "channelId", "registerNetWorkChangeReceiver", "reportColdRestoreFeedDauIfNeed", "reportPageShowStatistics", "requestData", "requestType", "paramAssembler", "Lcom/baidu/searchbox/feed/list/requester/paramter/ParamAssembler;", "callback", "Lcom/baidu/searchbox/http/callback/StatResponseCallback;", "saveFeedPolicyModel", "scrollTemplateTop", "setRefreshCount", "setRefreshFooter", "footerView", "Lcom/baidu/searchbox/feed/list/widget/IRefreshFooter;", "showBlankView", "startLoadData", "startPlayAdIfNeeded", "startPlayIfNeeded", "stopPlayAd", "stopPlayCurVideoTemplate", "stopType", "stopPlayGifTemplate", "stopScrolledGifPlay", "tplShowInfosUploadReport", "reportType", "tryInsertPrefetchData", "tryRecoveryPage", "unRegisterNetWorkChangeReceiver", "unregisterNAReceive", "updateTtsStatusByPrefetch", "newList", "ActionBarVisibilityListener", "DynamicControllerCB", "FullScreenType", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersivePage.kt */
public class DynamicImmersivePage extends RefreshableListPage implements NightModeChangeListener, StateLayoutManager.OnCommonClickListener, DynamicImmersiveDisplayMeasure.MeasuredPage {
    private ActionBarVisibilityListener actionBarVisibilityListener;
    /* access modifiers changed from: private */
    public INadDynamicImmersiveInsertManager adInsertManager;
    private DynamicArrivalProcessor arrivalProcessor;
    /* access modifiers changed from: private */
    public String authorId = "";
    private ArrayList<ViewPager> bannerList = new ArrayList<>();
    private CountDownTimer coldRestoreReportTimer;
    private Object collectKey;
    /* access modifiers changed from: private */
    public IDynamicAutoPlay curPlayTemplate;
    private String currentFeedId = "";
    private DynamicImmersiveDisplayMeasure displayMeasure;
    private RecyclerView.ItemDecoration dynamicItemDecoration;
    private boolean existPrefetch;
    /* access modifiers changed from: private */
    public String extRequest = "";
    private FeedPolicyModel feedPolicyModel;
    private int firstScreenTplTotalHeight;
    private final FluencyInfoTracer fluencyInfoTracer = new FluencyInfoTracer();
    private String fromChannel = "";
    private FSPStatisticsProcessor fspStatisticsProcessor;
    private int handlePullDataCount;
    private boolean hasReportColdRestoreDau;
    private boolean hasStaticsDAU;
    private String interactiveStr = "";
    private boolean isColdRestore;
    private boolean isItemDeleted;
    /* access modifiers changed from: private */
    public boolean isRequestInsertData;
    private final IFeedAgility mAgility = FeedRuntime.getIFeedAgility();
    /* access modifiers changed from: private */
    public final FeedRecyclerViewDelegate mIFeedTplContainer = new FeedRecyclerViewDelegate();
    private DynamicImmersiveNAReceiver naReceiver;
    private boolean netDataFullScreen;
    private final DynamicImmersivePage$netWorkChangeReceiver$1 netWorkChangeReceiver = new DynamicImmersivePage$netWorkChangeReceiver$1(this);
    /* access modifiers changed from: private */
    public String nid = "";
    private Function1<? super String, Unit> onFirstItemRealShowCallback;
    private Function0<Unit> onItemDeletedCallback;
    private Function0<Unit> onPageRecoveryCallback;
    private View pageView;
    private boolean preFetchTplShow;
    private ArrayList<FeedBaseModel> prefetchList = new ArrayList<>();
    private DynamicPrefetchProcessor prefetchProcessor;
    private boolean pullRefreshSuccess;
    private int refreshCount = 1;
    private DynamicImmersiveReportInfoUploadManager reportInfoManager;
    private ShimmerFrameLayout shimmerLayout;
    private int slideCount;
    /* access modifiers changed from: private */
    public String source = "";
    /* access modifiers changed from: private */
    public String strategyType = "";
    private final Lazy ttsManager$delegate = LazyKt.lazy(new DynamicImmersivePage$ttsManager$2(this));
    private int visibleZoomHeight;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage$ActionBarVisibilityListener;", "", "getActionBarVisibility", "", "hideActionBar", "", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicImmersivePage.kt */
    public interface ActionBarVisibilityListener {
        boolean getActionBarVisibility();

        void hideActionBar();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage$FullScreenType;", "", "(Ljava/lang/String;I)V", "FULL_FIRST", "FULL_REPEAT", "NOT_FULL", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicImmersivePage.kt */
    public enum FullScreenType {
        FULL_FIRST,
        FULL_REPEAT,
        NOT_FULL
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicImmersivePage(String assignId) {
        super(assignId);
        Intrinsics.checkNotNullParameter(assignId, "assignId");
    }

    public final View getPageView() {
        return this.pageView;
    }

    public final void setPageView(View view2) {
        this.pageView = view2;
    }

    public final ArrayList<ViewPager> getBannerList() {
        return this.bannerList;
    }

    public final void setBannerList(ArrayList<ViewPager> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bannerList = arrayList;
    }

    public final Function1<String, Unit> getOnFirstItemRealShowCallback() {
        return this.onFirstItemRealShowCallback;
    }

    public final void setOnFirstItemRealShowCallback(Function1<? super String, Unit> function1) {
        this.onFirstItemRealShowCallback = function1;
    }

    public final Function0<Unit> getOnPageRecoveryCallback() {
        return this.onPageRecoveryCallback;
    }

    public final void setOnPageRecoveryCallback(Function0<Unit> function0) {
        this.onPageRecoveryCallback = function0;
    }

    public final Function0<Unit> getOnItemDeletedCallback() {
        return this.onItemDeletedCallback;
    }

    public final void setOnItemDeletedCallback(Function0<Unit> function0) {
        this.onItemDeletedCallback = function0;
    }

    public final ActionBarVisibilityListener getActionBarVisibilityListener() {
        return this.actionBarVisibilityListener;
    }

    public final void setActionBarVisibilityListener(ActionBarVisibilityListener actionBarVisibilityListener2) {
        this.actionBarVisibilityListener = actionBarVisibilityListener2;
    }

    public final FSPStatisticsProcessor getFspStatisticsProcessor() {
        return this.fspStatisticsProcessor;
    }

    public final void setFspStatisticsProcessor(FSPStatisticsProcessor fSPStatisticsProcessor) {
        this.fspStatisticsProcessor = fSPStatisticsProcessor;
    }

    public final DynamicArrivalProcessor getArrivalProcessor() {
        return this.arrivalProcessor;
    }

    public final void setArrivalProcessor(DynamicArrivalProcessor dynamicArrivalProcessor) {
        this.arrivalProcessor = dynamicArrivalProcessor;
    }

    public final boolean getPullRefreshSuccess() {
        return this.pullRefreshSuccess;
    }

    public final void setPullRefreshSuccess(boolean z) {
        this.pullRefreshSuccess = z;
    }

    public final int getVisibleZoomHeight() {
        return this.visibleZoomHeight;
    }

    public final void setVisibleZoomHeight(int i2) {
        this.visibleZoomHeight = i2;
    }

    public final FeedPolicyModel getFeedPolicyModel() {
        return this.feedPolicyModel;
    }

    public final void setFeedPolicyModel(FeedPolicyModel feedPolicyModel2) {
        this.feedPolicyModel = feedPolicyModel2;
    }

    /* access modifiers changed from: private */
    public final DynamicImmersiveTtsManager getTtsManager() {
        return (DynamicImmersiveTtsManager) this.ttsManager$delegate.getValue();
    }

    public static /* synthetic */ void initPage$default(DynamicImmersivePage dynamicImmersivePage, Activity activity, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, boolean z2, String str8, int i2, Object obj) {
        String str9;
        if (obj == null) {
            if ((i2 & 16) != 0) {
                str9 = "";
            } else {
                str9 = str4;
            }
            dynamicImmersivePage.initPage(activity, str, str2, str3, str9, str5, str6, z, str7, z2, str8);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initPage");
    }

    public final void initPage(Activity context, String nid2, String authorId2, String source2, String extRequest2, String interactiveData, String strategyType2, boolean isColdRestore2, String scene, boolean needPullRefresh, String fromChannel2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(authorId2, "authorId");
        Intrinsics.checkNotNullParameter(source2, "source");
        Intrinsics.checkNotNullParameter(extRequest2, IntentData.Protocol.KEY_EXT_REQUEST);
        Intrinsics.checkNotNullParameter(strategyType2, "strategyType");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(fromChannel2, "fromChannel");
        init(context, (String) null, (String) null, (Bundle) null);
        this.nid = nid2;
        this.source = source2;
        this.authorId = authorId2;
        this.interactiveStr = interactiveData;
        this.isColdRestore = isColdRestore2;
        this.strategyType = strategyType2;
        this.extRequest = extRequest2;
        this.fromChannel = fromChannel2;
        clearDataManager();
        this.pageView = onCreateView(context, (Bundle) null);
        configPage(needPullRefresh);
        initAdInsertModule();
        initFSPStatisticsModule();
        initArrivalStatisticsModule();
        if (!tryRecoveryPage(scene)) {
            if (!tryInsertPrefetchData()) {
                showBlankView();
            }
            startLoadData();
        }
        initStatisticsModule();
        initEventNotificationModule();
        initPrefetchModule();
        initFluencyManager();
    }

    private final void initFluencyManager() {
        this.fluencyInfoTracer.init("10030");
    }

    private final void configPage(boolean needPullRefresh) {
        addItemViewWindowRelationListener(new DynamicImmersivePage$$ExternalSyntheticLambda6(this));
        this.mRecyclerView.setOverScrollMode(2);
        this.mRefreshView.setPullRefreshEnable(needPullRefresh);
        if (this.mAdapter instanceof IFeedAdapter) {
            PageAdapter pageAdapter = this.mAdapter;
            if (pageAdapter != null) {
                RecyclerView.ItemDecoration dynamicItemDecoration2 = new DynamicItemDecoration((IFeedAdapter) pageAdapter);
                this.dynamicItemDecoration = dynamicItemDecoration2;
                setItemDecoration(dynamicItemDecoration2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.tab.interaction.IFeedAdapter");
            }
        }
        this.mRecyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        changeLayoutManager(new DynamicLayoutManager(this.mContext));
        setLoadMoreTriggerLimit(3);
        awakenUnifiedClicker();
        awakenTemplateShowListener();
        getController().setHasLoadedAllDbDataOnce(true);
        getController().setLastRefreshTime(0);
        this.mStateLayoutManager.setOnClickLister(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: configPage$lambda-0  reason: not valid java name */
    public static final void m18578configPage$lambda0(DynamicImmersivePage this$0, View view2, int i2, FeedTemplate itemTemplate, Boolean isAttached) {
        DynamicImmersiveDisplayMeasure dynamicImmersiveDisplayMeasure;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual((Object) isAttached, (Object) true)) {
            DynamicImmersiveDisplayMeasure dynamicImmersiveDisplayMeasure2 = this$0.displayMeasure;
            if (dynamicImmersiveDisplayMeasure2 != null) {
                dynamicImmersiveDisplayMeasure2.onViewAttach(itemTemplate);
            }
        } else if (Intrinsics.areEqual((Object) isAttached, (Object) false) && (dynamicImmersiveDisplayMeasure = this$0.displayMeasure) != null) {
            dynamicImmersiveDisplayMeasure.onViewDetach(itemTemplate);
        }
    }

    private final void initAdInsertModule() {
        INadDynamicImmersiveInsertManager $this$initAdInsertModule_u24lambda_u2d1 = FeedRuntime.getNadDynamicImmersiveInsertManager();
        this.adInsertManager = $this$initAdInsertModule_u24lambda_u2d1;
        if ($this$initAdInsertModule_u24lambda_u2d1 != null) {
            $this$initAdInsertModule_u24lambda_u2d1.init(this.mDataManager.getDisplayCacheList(), getChannelId(), new DynamicImmersivePage$initAdInsertModule$1$callback$1(this));
            $this$initAdInsertModule_u24lambda_u2d1.initPostParams(DynamicRequestManager.INSTANCE.getRequestParams());
        }
    }

    private final void initFSPStatisticsModule() {
        this.fspStatisticsProcessor = new FSPStatisticsProcessor(getChannelId());
    }

    private final void initArrivalStatisticsModule() {
        this.arrivalProcessor = new DynamicArrivalProcessor(this.source);
    }

    private final boolean tryRecoveryPage(String scene) {
        if (!Intrinsics.areEqual((Object) scene, (Object) "recovery")) {
            return false;
        }
        ArrayList<FeedBaseModel> caches = DynamicCachesRecoveryManager.INSTANCE.getCaches();
        if (caches.isEmpty()) {
            return false;
        }
        this.mDataManager.insertData(caches, 0, DataMgrStrategy.DEFAULT);
        notifyDataSetChanged();
        stopPlayCurVideoTemplate(6);
        stopPlayGifTemplate(6);
        FeedPolicyModel feedPolicyModel2 = this.feedPolicyModel;
        setLoadMoreTriggerLimit(feedPolicyModel2 != null ? feedPolicyModel2.feedListPreLoadPosition : 4);
        IRefreshFooter footerView = this.mRefreshView.getFooterView();
        if (footerView != null) {
            footerView.onStateChanged(0, (Map<String, Object>) null);
        }
        Function0<Unit> function0 = this.onPageRecoveryCallback;
        if (function0 == null) {
            return true;
        }
        function0.invoke();
        return true;
    }

    private final void initStatisticsModule() {
        if (this.isColdRestore) {
            initColdRestoreReport();
        }
        TemplateStatisticsTable.getInstance().put(getChannelId(), new DynamicTemplateStatistics(this.source, this.strategyType));
        FeedTemplateStatTable.getInstance().put(getChannelId(), new DynamicFeedTemplateStatistics(this.source, this.strategyType, "immersive"));
        DynamicStatisticsHelper.INSTANCE.pageScrollStatistics(this.source, this.slideCount, DynamicStatisticsHelper.UBC_VALUE_SLIDE, this.nid);
        initDisplayMeasure();
        initReportInfoManager();
    }

    private final void initColdRestoreReport() {
        CountDownTimer $this$initColdRestoreReport_u24lambda_u2d2 = new CountDownTimer(5000, 1000).setStatusListener(new DynamicImmersivePage$initColdRestoreReport$1(this));
        $this$initColdRestoreReport_u24lambda_u2d2.start();
        this.coldRestoreReportTimer = $this$initColdRestoreReport_u24lambda_u2d2;
    }

    private final void initDisplayMeasure() {
        StrategyDataManager strategyDataManager = this.mDataManager;
        Intrinsics.checkNotNullExpressionValue(strategyDataManager, "mDataManager");
        this.displayMeasure = new DynamicImmersiveDisplayMeasure(strategyDataManager, this);
    }

    private final void initReportInfoManager() {
        this.reportInfoManager = new DynamicImmersiveReportInfoUploadManager(this.mDataManager);
    }

    private final void startLoadData() {
        this.mRefreshView.getHeaderView().onStateChanged(3, (Map<String, Object>) null);
        doRefreshing("4", false);
    }

    private final void initEventNotificationModule() {
        FeedItemImgClickListenerTable.getInstance().put(getAssignId(), new DynamicImmersivePage$initEventNotificationModule$1(this));
        registerLinkageEvent();
        registerNAReceive(getChannelId());
        NightModeHelper.subscribeNightModeChangeEvent(this, this);
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 0, new DynamicImmersivePage$$ExternalSyntheticLambda0(this));
        registerNetWorkChangeReceiver();
    }

    /* access modifiers changed from: private */
    /* renamed from: initEventNotificationModule$lambda-3  reason: not valid java name */
    public static final void m18582initEventNotificationModule$lambda3(DynamicImmersivePage this$0, FontSizeChangeMessage event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        this$0.onEvent(event);
    }

    private final void initPrefetchModule() {
        IRefreshAction iRefreshAction = this.mRefreshAction;
        Intrinsics.checkNotNullExpressionValue(iRefreshAction, "mRefreshAction");
        StrategyDataManager strategyDataManager = this.mDataManager;
        Intrinsics.checkNotNullExpressionValue(strategyDataManager, "mDataManager");
        this.prefetchProcessor = new DynamicPrefetchProcessor(iRefreshAction, strategyDataManager);
    }

    public void doRefreshing(String refreshSource, boolean useAnim) {
        Intrinsics.checkNotNullParameter(refreshSource, "refreshSource");
        getController().setCurRefreshSource(refreshSource);
        super.doRefreshing(refreshSource, useAnim);
    }

    /* access modifiers changed from: protected */
    public void onPullRefreshAction() {
        getController().setCurRefreshSource("0");
        super.onPullRefreshAction();
    }

    /* access modifiers changed from: protected */
    public void onLoadMoreAction(FeedBaseModel last, boolean isPrefetch) {
        Intrinsics.checkNotNullParameter(last, FeedItemDataHotStripe.POSITION_LAST);
        getController().setCurRefreshSource("7");
        super.onLoadMoreAction(last, isPrefetch);
    }

    public void requestData(int requestType, ParamAssembler paramAssembler, StatResponseCallback<FeedFlowModel> callback) {
        StatResponseCallback<FeedFlowModel> statResponseCallback = callback;
        Intrinsics.checkNotNullParameter(statResponseCallback, "callback");
        boolean z = true;
        if (requestType == 0 && this.refreshCount == 1 && DynamicListPreFetcher.INSTANCE.obtain(this.nid, statResponseCallback)) {
            DynamicImmersivePageKt.requestTag = DynamicListPreFetcher.PRE_REQUEST_TAG;
            return;
        }
        FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor != null) {
            fSPStatisticsProcessor.onPullDataRequest();
        }
        HashMap paramsMap = MapsKt.hashMapOf(TuplesKt.to("nid", this.nid), TuplesKt.to("from", DynamicUtilsKt.getFromValueBySource(this.source)));
        if (this.extRequest.length() <= 0) {
            z = false;
        }
        if (z) {
            paramsMap.put("ext_request", this.extRequest);
        }
        DynamicImmersivePageKt.requestTag = DynamicRequestManagerKt.REQUEST_TAG;
        DynamicRequestManager dynamicRequestManager = DynamicRequestManager.INSTANCE;
        String str = this.authorId;
        int i2 = this.refreshCount;
        String str2 = this.strategyType;
        ListController controller = getController();
        Intrinsics.checkNotNullExpressionValue(controller, "controller");
        DynamicRequestManager.requestDynamicData$default(dynamicRequestManager, paramsMap, str, i2, requestType, str2, controller, callback, DynamicImmersivePageKt.requestTag, false, DynamicUtilsKt.getDynamicConnectPolicy(), 256, (Object) null);
        INadDynamicImmersiveInsertManager iNadDynamicImmersiveInsertManager = this.adInsertManager;
        if (iNadDynamicImmersiveInsertManager != null) {
            iNadDynamicImmersiveInsertManager.initPostParams(DynamicRequestManager.INSTANCE.getRequestParams());
        }
        DynamicArrivalProcessor dynamicArrivalProcessor = this.arrivalProcessor;
        if (dynamicArrivalProcessor != null) {
            dynamicArrivalProcessor.requestData();
        }
    }

    /* access modifiers changed from: protected */
    public void beforePullRequestDataParse() {
        FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor != null) {
            fSPStatisticsProcessor.onPullDataBack();
        }
    }

    /* access modifiers changed from: protected */
    public List<FeedBaseModel> onHandlePullData(FeedFlowModel feedFlowModel, boolean isSuccess) {
        hideBlankView();
        if (Intrinsics.areEqual((Object) feedFlowModel != null ? feedFlowModel.error : null, (Object) DynamicUtilsKt.REQUEST_DELETE_ERROR_CODE)) {
            clearDataManager();
            notifyDataSetChanged();
            this.isItemDeleted = true;
            Function0<Unit> function0 = this.onItemDeletedCallback;
            if (function0 != null) {
                function0.invoke();
            }
            DynamicArrivalProcessor dynamicArrivalProcessor = this.arrivalProcessor;
            if (dynamicArrivalProcessor != null) {
                dynamicArrivalProcessor.setShieldReportStatus(true);
            }
            return null;
        }
        int i2 = this.handlePullDataCount + 1;
        this.handlePullDataCount = i2;
        FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor != null) {
            fSPStatisticsProcessor.onPullDataParse(feedFlowModel, isSuccess, i2 == 1);
        }
        DynamicArrivalProcessor dynamicArrivalProcessor2 = this.arrivalProcessor;
        if (dynamicArrivalProcessor2 != null) {
            dynamicArrivalProcessor2.onPullDataParse(feedFlowModel, isSuccess);
        }
        if (isSuccess) {
            if (this.handlePullDataCount == 1) {
                DynamicStatisticsHelper.INSTANCE.pageScrollStatistics(this.source, this.refreshCount - 1, DynamicStatisticsHelper.UBC_VALUE_LOAD, this.nid);
                addHistory(feedFlowModel);
            }
            DynamicPrefetchProcessor dynamicPrefetchProcessor = this.prefetchProcessor;
            if (dynamicPrefetchProcessor != null) {
                dynamicPrefetchProcessor.setPrefetchConfig(feedFlowModel);
            }
            setRefreshCount(isSuccess);
            IRefreshFooter footerView = this.mRefreshView.getFooterView();
            if (footerView != null) {
                footerView.setForceVisibility(0);
            }
            this.pullRefreshSuccess = true;
        } else if (this.existPrefetch) {
            this.mRefreshView.setHasMore(false);
        }
        DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "success: " + isSuccess + " refreshCount " + this.refreshCount + " data_response_time: " + System.currentTimeMillis());
        return super.onHandlePullData(feedFlowModel, isSuccess);
    }

    /* access modifiers changed from: protected */
    public List<FeedBaseModel> onHandleLoadData(FeedFlowModel feedFlowModel, boolean isSuccess) {
        DynamicStatisticsHelper.INSTANCE.pageScrollStatistics(this.source, this.refreshCount - 1, DynamicStatisticsHelper.UBC_VALUE_LOAD, this.nid);
        setRefreshCount(isSuccess);
        DynamicImmersiveDisplayMeasure dynamicImmersiveDisplayMeasure = this.displayMeasure;
        if (dynamicImmersiveDisplayMeasure != null) {
            dynamicImmersiveDisplayMeasure.onRefreshEnd();
        }
        tplShowInfosUploadReport("refresh");
        return super.onHandleLoadData(feedFlowModel, isSuccess);
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> onPullComplete(List<FeedBaseModel> newFeeds) {
        if (this.isItemDeleted) {
            return new HashMap<>();
        }
        stopPlayCurVideoTemplate(6);
        stopPlayGifTemplate(6);
        FeedPolicyModel feedPolicyModel2 = this.feedPolicyModel;
        setLoadMoreTriggerLimit(feedPolicyModel2 != null ? feedPolicyModel2.feedListPreLoadPosition : 4);
        IRefreshFooter footerView = this.mRefreshView.getFooterView();
        if (footerView != null) {
            footerView.onStateChanged(0, (Map<String, Object>) null);
        }
        Map<String, Object> onPullComplete = super.onPullComplete(newFeeds);
        if (onPullComplete != null) {
            HashMap extra = (HashMap) onPullComplete;
            if (newFeeds != null && (newFeeds.isEmpty() ^ true)) {
                onPrefetchData(0);
            } else if (this.mDataManager.displayCacheSize() == 0) {
                this.mStateLayoutManager.showError();
            }
            this.mRefreshView.setIsFetching(false);
            INadDynamicImmersiveInsertManager iNadDynamicImmersiveInsertManager = this.adInsertManager;
            if (iNadDynamicImmersiveInsertManager != null) {
                iNadDynamicImmersiveInsertManager.resetState();
            }
            if (this.refreshCount == 1) {
                DynamicListPreFetcher.INSTANCE.clearRecord();
            }
            DynamicImmersiveTtsManager ttsManager = getTtsManager();
            if (ttsManager != null) {
                ttsManager.updateDataSource(newFeeds, 0);
            }
            return extra;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
    }

    /* access modifiers changed from: protected */
    public void saveFeedPolicyModel(FeedFlowModel feedFlowModel) {
        this.feedPolicyModel = feedFlowModel != null ? feedFlowModel.feedPolicyModel : null;
    }

    /* access modifiers changed from: protected */
    public RefreshableListPage.RefreshableItemCreator newListItemCreator() {
        DynamicImmersivePage$newListItemCreator$creator$1 creator = new DynamicImmersivePage$newListItemCreator$creator$1(this);
        creator.setUserDataFactory(new DynamicListItemCreator());
        return creator;
    }

    private final void addHistory(FeedFlowModel feedFlowModel) {
        ArrayList $this$addHistory_u24lambda_u2d7;
        FeedBaseModel it;
        if (feedFlowModel != null && ($this$addHistory_u24lambda_u2d7 = feedFlowModel.feedBaseModelList) != null) {
            FeedBaseModel data = null;
            if (!(!$this$addHistory_u24lambda_u2d7.isEmpty())) {
                $this$addHistory_u24lambda_u2d7 = null;
            }
            if ($this$addHistory_u24lambda_u2d7 != null && (it = $this$addHistory_u24lambda_u2d7.get(0)) != null) {
                if (Intrinsics.areEqual((Object) it.id, (Object) this.nid)) {
                    data = it;
                }
                if (data != null) {
                    ReadingRecord.Companion.add(data);
                }
            }
        }
    }

    private final void clearDataManager() {
        this.mDataManager.clearData(DataMgrStrategy.DEFAULT);
    }

    public RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.mRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mRecyclerView");
        return recyclerView;
    }

    public ArrayList<View> queryVisibleViewList() {
        ArrayList<View> currentVisibleViewList = getCurrentVisibleViewList();
        Intrinsics.checkNotNullExpressionValue(currentVisibleViewList, "currentVisibleViewList");
        return currentVisibleViewList;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState == 0 && !this.mRefreshAction.isFetching()) {
            this.slideCount++;
            DynamicStatisticsHelper.INSTANCE.pageScrollStatistics(this.source, this.slideCount, DynamicStatisticsHelper.UBC_VALUE_SLIDE, this.nid);
            if (this.mRecyclerView.getTop() == 0) {
                startPlayIfNeeded();
                startPlayAdIfNeeded();
            }
            onPrefetchData(2);
            displayReport(1);
            prerenderAd();
        } else if (newState == 1) {
            reportColdRestoreFeedDauIfNeed();
            onPrefetchData(1);
        }
        this.fluencyInfoTracer.onListScrollStateChanged(newState);
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        IDynamicAutoPlay it = this.curPlayTemplate;
        if (it != null && it.needStopPlay(this.mRecyclerView.getHeight())) {
            stopPlayCurVideoTemplate(3);
        }
        stopScrolledGifPlay();
        for (View view2 : queryVisibleViewList()) {
            if (view2 instanceof FeedAdBaseView) {
                ((FeedAdBaseView) view2).onScroll(recyclerView, dx, dy);
            }
        }
    }

    public void setRefreshFooter(IRefreshFooter footerView) {
        Intrinsics.checkNotNullParameter(footerView, "footerView");
        CommonFooterView $this$setRefreshFooter_u24lambda_u2d12 = footerView instanceof CommonFooterView ? (CommonFooterView) footerView : null;
        if ($this$setRefreshFooter_u24lambda_u2d12 != null) {
            View rightCircleIconView = $this$setRefreshFooter_u24lambda_u2d12.getRightCircleIconView();
            if (rightCircleIconView != null) {
                rightCircleIconView.setVisibility(8);
            }
            $this$setRefreshFooter_u24lambda_u2d12.setCommonBackgroundColor(R.color.GC9);
            $this$setRefreshFooter_u24lambda_u2d12.getStyleMap().put(1996555042, R.string.dynamic_list_no_more_data);
            $this$setRefreshFooter_u24lambda_u2d12.getStyleMap().put(1996686114, R.color.GC1);
            $this$setRefreshFooter_u24lambda_u2d12.getStyleMap().put(1996685315, R.color.GC1);
            $this$setRefreshFooter_u24lambda_u2d12.getStyleMap().put(1996685312, R.color.GC1);
            $this$setRefreshFooter_u24lambda_u2d12.setOnStateChangedListener(new DynamicImmersivePage$$ExternalSyntheticLambda4($this$setRefreshFooter_u24lambda_u2d12));
            View rootView = $this$setRefreshFooter_u24lambda_u2d12.getRootView();
            if (rootView != null) {
                rootView.setOnClickListener(new DynamicImmersivePage$$ExternalSyntheticLambda5(this));
            }
            if (this.mDataManager.displayCacheSize() <= this.prefetchList.size()) {
                $this$setRefreshFooter_u24lambda_u2d12.setForceVisibility(8);
            }
        }
        super.setRefreshFooter(footerView);
    }

    /* access modifiers changed from: private */
    /* renamed from: setRefreshFooter$lambda-12$lambda-10  reason: not valid java name */
    public static final void m18585setRefreshFooter$lambda12$lambda10(CommonFooterView $this_apply, int it) {
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        boolean hasMore = it != 802;
        View rootView = $this_apply.getRootView();
        if (rootView != null) {
            rootView.setClickable(hasMore);
        }
        View rootView2 = $this_apply.getRootView();
        if (rootView2 != null) {
            rootView2.setEnabled(hasMore);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setRefreshFooter$lambda-12$lambda-11  reason: not valid java name */
    public static final void m18586setRefreshFooter$lambda12$lambda11(DynamicImmersivePage this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mRefreshView.getFooterView().getState() == 803) {
            ArrayList feedList = this$0.mDataManager.getDisplayCacheList();
            int feedListSize = feedList.size();
            if (feedListSize > 1) {
                FeedBaseModel feedBaseModel = feedList.get(feedListSize - 1);
                Intrinsics.checkNotNullExpressionValue(feedBaseModel, "feedList[feedListSize - 1]");
                this$0.onLoadMoreAction(feedBaseModel, false);
                return;
            }
            this$0.doRefreshing("3", false);
        }
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [java.lang.String] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTemplateClick(android.view.View r15, com.baidu.searchbox.feed.model.FeedBaseModel r16, int r17) {
        /*
            r14 = this;
            r0 = r14
            r9 = r16
            r10 = r17
            boolean r1 = com.baidu.android.util.android.FastClickUtils.isFastDoubleClick()
            if (r1 == 0) goto L_0x000c
            return
        L_0x000c:
            r11 = 1
            r12 = 0
            if (r15 == 0) goto L_0x001a
            int r1 = r15.getId()
            int r2 = com.baidu.searchbox.feed.core.R.id.feed_id_radio_icon_tag
            if (r1 != r2) goto L_0x001a
            r1 = r11
            goto L_0x001b
        L_0x001a:
            r1 = r12
        L_0x001b:
            r2 = 0
            if (r1 == 0) goto L_0x0092
            com.baidu.searchbox.feed.dynamicdetail.tts.DynamicImmersiveTtsManager r1 = r14.getTtsManager()
            if (r1 == 0) goto L_0x002f
            com.baidu.searchbox.feed.list.cache.StrategyDataManager r3 = r0.mDataManager
            java.util.ArrayList r3 = r3.getDisplayCacheList()
            java.util.List r3 = (java.util.List) r3
            r1.togglePlay(r9, r3)
        L_0x002f:
            com.baidu.searchbox.feed.dynamicdetail.tts.DynamicImmersiveTtsManager r1 = r14.getTtsManager()
            if (r1 == 0) goto L_0x003e
            int r1 = r1.getTtsStatus(r9)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            if (r1 != 0) goto L_0x0042
            goto L_0x004c
        L_0x0042:
            int r3 = r1.intValue()
            if (r3 != r11) goto L_0x004c
            java.lang.String r1 = "pause"
            goto L_0x0064
        L_0x004c:
            r3 = 2
            if (r1 != 0) goto L_0x0050
            goto L_0x0057
        L_0x0050:
            int r4 = r1.intValue()
            if (r4 != r3) goto L_0x0057
        L_0x0056:
            goto L_0x0061
        L_0x0057:
            if (r1 != 0) goto L_0x005a
            goto L_0x0056
        L_0x005a:
            int r1 = r1.intValue()
            if (r1 != 0) goto L_0x0056
            goto L_0x0056
        L_0x0061:
            java.lang.String r1 = "play"
        L_0x0064:
            if (r9 == 0) goto L_0x006c
            com.baidu.searchbox.feed.tts.model.IFeedTTSModel r3 = r16.getTtsModel()
            goto L_0x006d
        L_0x006c:
            r3 = r2
        L_0x006d:
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.model.FeedTtsModel
            if (r4 == 0) goto L_0x0074
            r2 = r3
            com.baidu.searchbox.feed.model.FeedTtsModel r2 = (com.baidu.searchbox.feed.model.FeedTtsModel) r2
        L_0x0074:
            if (r2 == 0) goto L_0x007d
            boolean r2 = r2.isVideoTts()
            if (r2 != r11) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r11 = r12
        L_0x007e:
            if (r11 == 0) goto L_0x0084
            java.lang.String r2 = "kt_video_btn"
            goto L_0x0087
        L_0x0084:
            java.lang.String r2 = "kt_tts_btn"
        L_0x0087:
            java.lang.String r3 = "active"
            java.lang.String r4 = "immersive"
            com.baidu.searchbox.feed.statistic.FeedStatisticCenter.reportRalModeClickEvent(r9, r1, r3, r2, r4)
            return
        L_0x0092:
            if (r9 == 0) goto L_0x0097
            com.baidu.searchbox.feed.model.FeedItemData r1 = r9.data
            goto L_0x0098
        L_0x0097:
            r1 = r2
        L_0x0098:
            if (r1 != 0) goto L_0x009b
            return
        L_0x009b:
            r13 = r1
            boolean r1 = r13 instanceof com.baidu.searchbox.feed.model.FeedItemDataStar
            if (r1 == 0) goto L_0x00a4
            r1 = r13
            com.baidu.searchbox.feed.model.FeedItemDataStar r1 = (com.baidu.searchbox.feed.model.FeedItemDataStar) r1
            goto L_0x00a5
        L_0x00a4:
            r1 = r2
        L_0x00a5:
            if (r1 == 0) goto L_0x00ad
            com.baidu.searchbox.feed.model.FeedItemDataStar$RenderStrategy r1 = r1.renderStrategy
            if (r1 == 0) goto L_0x00ad
            java.lang.String r2 = r1.titleCollapseSwitch
        L_0x00ad:
            java.lang.String r1 = "1"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x00cb
            boolean r1 = r13.isNeedFold
            if (r1 == 0) goto L_0x00cb
            boolean r1 = r13.isFolded
            r1 = r1 ^ r11
            r13.isFolded = r1
            com.baidu.searchbox.feed.model.FeedRuntimeStatus r1 = r9.runtimeStatus
            r1.isRead = r12
            com.baidu.searchbox.feed.list.adapter.PageAdapter r1 = r0.mAdapter
            r1.notifyItemChanged(r10)
            r14.scrollTemplateTop(r15, r16, r17)
            return
        L_0x00cb:
            com.baidu.searchbox.feed.model.CString r1 = r13.cmd
            java.lang.String r1 = r1.get()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00de
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00dc
            goto L_0x00de
        L_0x00dc:
            r1 = r12
            goto L_0x00df
        L_0x00de:
            r1 = r11
        L_0x00df:
            if (r1 == 0) goto L_0x00e2
            return
        L_0x00e2:
            com.baidu.searchbox.feed.ad.util.AdDataReduceUtils.replaceDataCmdExt(r16)
            com.baidu.searchbox.feed.model.FeedItemData r1 = r9.data
            boolean r1 = com.baidu.searchbox.feed.ad.util.FeedAdUtil.isAdItem(r1)
            if (r1 == 0) goto L_0x00f0
            com.baidu.searchbox.feed.ad.util.FeedAdUtil.cacheAdParams(r16)
        L_0x00f0:
            android.content.Context r1 = r0.mContext
            com.baidu.searchbox.feed.model.CString r2 = r13.cmd
            java.lang.String r2 = r2.get()
            com.baidu.searchbox.feed.util.FeedRouter.invoke(r1, r2, r12)
            com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper r1 = com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper.INSTANCE
            java.lang.String r4 = r0.source
            r5 = 0
            r6 = 0
            r7 = 24
            r8 = 0
            java.lang.String r3 = "wenzi"
            r2 = r16
            com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper.handleTemplateClick$default(r1, r2, r3, r4, r5, r6, r7, r8)
            com.baidu.searchbox.feed.model.FeedRuntimeStatus r1 = r9.runtimeStatus
            r1.isRead = r11
            com.baidu.searchbox.feed.base.FeedTemplate r1 = com.baidu.searchbox.feed.base.TplViewCaster.castToTemplate(r15)
            if (r1 == 0) goto L_0x0121
            com.baidu.searchbox.feed.template.common.ExtraData r2 = com.baidu.searchbox.feed.template.common.ExtraData.newInstance(r12, r12)
            java.util.Map r2 = (java.util.Map) r2
            r1.update(r9, r2)
        L_0x0121:
            com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper r1 = com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper.INSTANCE
            java.lang.String r2 = r0.strategyType
            r1.clickTemplateCmdReport(r9, r10, r2)
            com.baidu.searchbox.feed.dynamicdetail.utils.DynamicInsertUtils.recordExeCmdTimeAndId(r16)
            r14.handleInsertAfterRead(r9)
            com.baidu.searchbox.feed.dynamicdetail.prefetch.DynamicPrefetchProcessor r1 = r0.prefetchProcessor
            if (r1 == 0) goto L_0x0138
            r2 = 3
            int r3 = r10 + 1
            r1.onPrefetchData(r2, r10, r3)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.dynamicdetail.DynamicImmersivePage.onTemplateClick(android.view.View, com.baidu.searchbox.feed.model.FeedBaseModel, int):void");
    }

    /* access modifiers changed from: protected */
    public void onTemplateShow(View view2, FeedBaseModel feed, int position) {
        super.onTemplateShow(view2, feed, position);
        if (feed != null && !isSpecialTpl(feed)) {
            handleTemplateShowStatistics(view2, feed, position);
            startPlayIfNeeded();
            startPlayAdIfNeeded();
            INadDynamicImmersiveInsertManager iNadDynamicImmersiveInsertManager = this.adInsertManager;
            if (iNadDynamicImmersiveInsertManager != null) {
                iNadDynamicImmersiveInsertManager.saveViewHeight(position, view2 != null ? view2.getHeight() : 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a A[Catch:{ all -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0040 A[Catch:{ all -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleInsertAfterRead(com.baidu.searchbox.feed.model.FeedBaseModel r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0083 }
            r1 = r10
            com.baidu.searchbox.feed.dynamicdetail.DynamicImmersivePage r1 = (com.baidu.searchbox.feed.dynamicdetail.DynamicImmersivePage) r1     // Catch:{ all -> 0x0083 }
            r2 = 0
            java.lang.String r3 = r11.id     // Catch:{ all -> 0x0083 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0083 }
            r4 = 1
            if (r3 == 0) goto L_0x001a
            int r3 = r3.length()     // Catch:{ all -> 0x0083 }
            if (r3 != 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r3 = r0
            goto L_0x001b
        L_0x001a:
            r3 = r4
        L_0x001b:
            if (r3 != 0) goto L_0x0026
            com.baidu.searchbox.feed.ioc.IFeedAgility r3 = r1.mAgility     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x0026
            java.lang.String r5 = r11.id     // Catch:{ all -> 0x0083 }
            r3.bindClickedId(r5)     // Catch:{ all -> 0x0083 }
        L_0x0026:
            com.baidu.searchbox.feed.model.FeedItemData r3 = r11.data     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x0082
            java.lang.String r3 = r11.id     // Catch:{ all -> 0x0083 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x0039
            int r3 = r3.length()     // Catch:{ all -> 0x0083 }
            if (r3 != 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r3 = r0
            goto L_0x003a
        L_0x0039:
            r3 = r4
        L_0x003a:
            if (r3 != 0) goto L_0x0082
            boolean r3 = r1.isRequestInsertData     // Catch:{ all -> 0x0083 }
            if (r3 != 0) goto L_0x0082
            java.lang.String r3 = r11.id     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r1.currentFeedId     // Catch:{ all -> 0x0083 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x004b
            goto L_0x0082
        L_0x004b:
            java.lang.String r3 = r11.clickThreshold     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x0059
            java.lang.String r5 = "clickThreshold"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x0083 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x0083 }
            goto L_0x005a
        L_0x0059:
            r3 = r0
        L_0x005a:
            if (r3 > 0) goto L_0x005d
            return
        L_0x005d:
            r1.isRequestInsertData = r4     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = r11.id     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = "feed.id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x0083 }
            r1.currentFeedId = r4     // Catch:{ all -> 0x0083 }
            android.os.Handler r4 = com.baidu.searchbox.feed.FeedRuntime.getFeedHandler()     // Catch:{ all -> 0x0083 }
            com.baidu.searchbox.feed.dynamicdetail.DynamicImmersivePage$$ExternalSyntheticLambda3 r5 = new com.baidu.searchbox.feed.dynamicdetail.DynamicImmersivePage$$ExternalSyntheticLambda3     // Catch:{ all -> 0x0083 }
            r5.<init>(r1, r11, r10)     // Catch:{ all -> 0x0083 }
            long r6 = (long) r3     // Catch:{ all -> 0x0083 }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r8
            boolean r4 = r4.postDelayed(r5, r6)     // Catch:{ all -> 0x0083 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0083 }
            java.lang.Object r1 = kotlin.Result.m8971constructorimpl(r1)     // Catch:{ all -> 0x0083 }
            goto L_0x008e
        L_0x0082:
            return
        L_0x0083:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m8971constructorimpl(r1)
        L_0x008e:
            java.lang.Throwable r1 = kotlin.Result.m8974exceptionOrNullimpl(r1)
            if (r1 == 0) goto L_0x0099
            r2 = 0
            r10.isRequestInsertData = r0
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.dynamicdetail.DynamicImmersivePage.handleInsertAfterRead(com.baidu.searchbox.feed.model.FeedBaseModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleInsertAfterRead$lambda-14$lambda-13  reason: not valid java name */
    public static final void m18579handleInsertAfterRead$lambda14$lambda13(DynamicImmersivePage $this_runCatching, FeedBaseModel $feed, DynamicImmersivePage this$0) {
        int refreshC;
        Intrinsics.checkNotNullParameter($this_runCatching, "$this_runCatching");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int pos = $this_runCatching.mDataManager.indexOf($feed.id, DataMgrStrategy.DEFAULT);
        if (pos >= 1) {
            pos--;
        }
        int refreshC2 = $this_runCatching.refreshCount - 1;
        if (refreshC2 < 1) {
            refreshC = 1;
        } else {
            refreshC = refreshC2;
        }
        DynamicReadInsertRequestManager dynamicReadInsertRequestManager = DynamicReadInsertRequestManager.INSTANCE;
        String str = $feed.id;
        Intrinsics.checkNotNullExpressionValue(str, "feed.id");
        String valueOf = String.valueOf(refreshC);
        JSONArray addDupUploadListData = $this_runCatching.getController().addDupUploadListData();
        Intrinsics.checkNotNullExpressionValue(addDupUploadListData, "controller.addDupUploadListData()");
        dynamicReadInsertRequestManager.requestInsertData(str, pos, valueOf, addDupUploadListData, new DynamicImmersivePage$handleInsertAfterRead$1$1$1($this_runCatching, this$0, $feed));
    }

    /* access modifiers changed from: private */
    public final void handleTplScrollEvent(View view2, FeedBaseModel model, int index, boolean isExpand) {
        if (FeedHotTemplateUtils.isExpandBanner(model) && view2 != null) {
            View $this$handleTplScrollEvent_u24lambda_u2d16 = view2;
            Rect rectL = new Rect();
            Rect rectG = new Rect();
            $this$handleTplScrollEvent_u24lambda_u2d16.getLocalVisibleRect(rectL);
            $this$handleTplScrollEvent_u24lambda_u2d16.getGlobalVisibleRect(rectG);
            if (rectL.top > 0) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.smoothScrollBy(0, -(rectL.top + DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 66.0f)));
                }
                ActionBarVisibilityListener actionBarVisibilityListener2 = this.actionBarVisibilityListener;
                if (actionBarVisibilityListener2 != null) {
                    actionBarVisibilityListener2.hideActionBar();
                }
            } else if (!isExpand) {
                FeedItemData feedItemData = model != null ? model.data : null;
                if (feedItemData != null) {
                    float height = ((float) FeedTemplateUtil.getCalculateWidth(FeedRuntime.getAppContext())) / FeedHotTemplateUtils.calcVpWHRatio(((FeedItemDataStarThreeExpandImg) feedItemData).expandImages, index);
                    if (((float) rectG.top) + height > ((float) FeedTemplateUtil.getCalculateHeight(FeedRuntime.getAppContext()))) {
                        float distanceY = ((((float) rectG.top) + height) - ((float) FeedTemplateUtil.getCalculateHeight(FeedRuntime.getAppContext()))) - ((float) DeviceUtils.ScreenInfo.getStatusBarHeight());
                        RecyclerView recyclerView2 = this.mRecyclerView;
                        if (recyclerView2 != null) {
                            recyclerView2.smoothScrollBy(0, (int) distanceY);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedItemDataStarThreeExpandImg");
            }
        }
    }

    private final void handleTemplateShowStatistics(View view2, FeedBaseModel feed, int position) {
        DynamicTemplateProvider.INSTANCE.templateShowStatistics(this.mDataManager.getDisplayCacheList(), feed, this.source, position, this.strategyType, this.adInsertManager);
        reportPageShowStatistics(feed);
        if (position == 0) {
            handleDauStatisticIfNeed();
            if (!this.existPrefetch || this.preFetchTplShow) {
                Function1<? super String, Unit> function1 = this.onFirstItemRealShowCallback;
                if (function1 != null) {
                    function1.invoke(feed.id);
                }
            } else {
                this.preFetchTplShow = true;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.post(new DynamicImmersivePage$$ExternalSyntheticLambda7(this, view2, feed));
                }
                DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "onTemplateShow pos: " + position + " id: " + feed.id + " prefetch");
                return;
            }
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.post(new DynamicImmersivePage$$ExternalSyntheticLambda8(this, view2, feed));
        }
        DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "onTemplateShow pos: " + position + " id: " + feed.id);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleTemplateShowStatistics$lambda-17  reason: not valid java name */
    public static final void m18580handleTemplateShowStatistics$lambda17(DynamicImmersivePage this$0, View $view, FeedBaseModel $feed) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($feed, "$feed");
        this$0.handlePrefetchDataStatics($view, $feed);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleTemplateShowStatistics$lambda-18  reason: not valid java name */
    public static final void m18581handleTemplateShowStatistics$lambda18(DynamicImmersivePage this$0, View $view, FeedBaseModel $feed) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($feed, "$feed");
        this$0.handleNetDataStatics($view, $feed);
    }

    private final void handlePrefetchDataStatics(View view2, FeedBaseModel feed) {
        if (this.visibleZoomHeight <= 0) {
            FirstScreenPerformanceHelper.get().cancel();
            DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "handlePrefetchDataStatics visibleZoomHeight <= 0 return");
            return;
        }
        boolean isFullScreen = false;
        if ((view2 != null ? calculationTemplateViewHeight(view2) : 0) >= this.visibleZoomHeight) {
            isFullScreen = true;
        }
        FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor != null) {
            fSPStatisticsProcessor.handlePrefetchDataStatics(isFullScreen, feed);
        }
    }

    private final void handleNetDataStatics(View view2, FeedBaseModel feed) {
        if (view2 != null) {
            if (this.visibleZoomHeight <= 0) {
                DynamicArrivalProcessor dynamicArrivalProcessor = this.arrivalProcessor;
                if (dynamicArrivalProcessor != null) {
                    dynamicArrivalProcessor.absentStatistics();
                }
                FirstScreenPerformanceHelper.get().cancel();
                DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "handleNetDataStatics visibleZoomHeight <= 0 return");
            } else if (this.netDataFullScreen) {
                DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "handleNetDataStatics netDataFullScreen return");
            } else {
                int calculationTemplateViewHeight = this.firstScreenTplTotalHeight + calculationTemplateViewHeight(view2);
                this.firstScreenTplTotalHeight = calculationTemplateViewHeight;
                this.netDataFullScreen = calculationTemplateViewHeight >= this.visibleZoomHeight;
                DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "handleNetDataStatics TplTotalHeight: " + this.firstScreenTplTotalHeight + " visibleZoomHeight: " + this.visibleZoomHeight);
                if (this.netDataFullScreen) {
                    FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
                    if (fSPStatisticsProcessor != null) {
                        fSPStatisticsProcessor.handleFullScreen(feed);
                    }
                    DynamicArrivalProcessor dynamicArrivalProcessor2 = this.arrivalProcessor;
                    if (dynamicArrivalProcessor2 != null) {
                        dynamicArrivalProcessor2.handleFullScreen();
                        return;
                    }
                    return;
                }
                FSPStatisticsProcessor fSPStatisticsProcessor2 = this.fspStatisticsProcessor;
                if (fSPStatisticsProcessor2 != null) {
                    fSPStatisticsProcessor2.handleNotFullScreen(feed);
                }
            }
        }
    }

    private final int calculationTemplateViewHeight(View view2) {
        int templateHeight = view2.getHeight();
        if (FeedThickDividerPolicy.getDefault().getDividerWidth() > 0) {
            return templateHeight + FeedThickDividerPolicy.getDefault().getDividerWidth();
        }
        return templateHeight;
    }

    public final void floatNextPageStatistics(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        DynamicStatisticsHelper.INSTANCE.floatNextPageUBC(type, "immersive");
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void reportPageShowStatistics(com.baidu.searchbox.feed.model.FeedBaseModel r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0005
            com.baidu.searchbox.feed.model.FeedItemData r0 = r4.data
            goto L_0x0006
        L_0x0005:
            r0 = 0
        L_0x0006:
            boolean r1 = r0 instanceof com.baidu.searchbox.feed.model.FeedItemDataStar
            if (r1 == 0) goto L_0x001c
            r1 = r0
            com.baidu.searchbox.feed.model.FeedItemDataStar r1 = (com.baidu.searchbox.feed.model.FeedItemDataStar) r1
            boolean r1 = r1.isFirstCard
            if (r1 == 0) goto L_0x001c
            boolean r1 = r3.pullRefreshSuccess
            if (r1 == 0) goto L_0x001c
            com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper r1 = com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper.INSTANCE
            java.lang.String r2 = r3.source
            r1.pageShowStatistics(r2, r4)
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.dynamicdetail.DynamicImmersivePage.reportPageShowStatistics(com.baidu.searchbox.feed.model.FeedBaseModel):void");
    }

    private final void handleDauStatisticIfNeed() {
        if (!this.hasStaticsDAU) {
            this.hasStaticsDAU = true;
            DynamicStatisticsHelper.INSTANCE.handleDauStatisticsIfNeed(this.source);
        }
    }

    private final void updateTtsStatusByPrefetch(List<? extends FeedBaseModel> newList) {
        Collection collection = newList;
        if (!(collection == null || collection.isEmpty()) && !this.prefetchList.isEmpty()) {
            for (FeedBaseModel feedBaseModel : newList) {
                Iterator<FeedBaseModel> it = this.prefetchList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        FeedBaseModel prefetchModel = it.next();
                        if (Intrinsics.areEqual((Object) feedBaseModel.id, (Object) prefetchModel.id)) {
                            feedBaseModel.getTtsModel().setTtsState(prefetchModel.getTtsModel().getTtsState());
                            return;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void applyPolicyBeforePullDataHandle(FeedFlowModel feedFlowModel) {
        if ((feedFlowModel != null ? feedFlowModel.feedBaseModelList : null) != null) {
            updateTtsStatusByPrefetch(feedFlowModel.feedBaseModelList);
            FeedBaseDataProcessor.ExtendData extendData = new FeedBaseDataProcessor.ExtendData();
            extendData.mAssignId = this.mAssignId;
            FeedMainProcessorDispatcher.getInstance().preProcess(feedFlowModel, this.mDataManager, 0, extendData);
        }
    }

    /* access modifiers changed from: protected */
    public void applyPolicyBeforeLoadDataHandle(FeedFlowModel feedFlowModel) {
        if ((feedFlowModel != null ? feedFlowModel.feedBaseModelList : null) != null) {
            FeedBaseDataProcessor.ExtendData extendData = new FeedBaseDataProcessor.ExtendData();
            extendData.mAssignId = this.mAssignId;
            FeedMainProcessorDispatcher.getInstance().preProcess(feedFlowModel, this.mDataManager, 1, extendData);
        }
    }

    /* access modifiers changed from: protected */
    public void applyPolicyAfterLoadComplete(FeedFlowModel feedFlowModel) {
        super.applyPolicyAfterLoadComplete(feedFlowModel);
        if (feedFlowModel == null) {
            this.mRefreshView.updateFootView(803);
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> onLoadComplete(List<FeedBaseModel> newFeeds) {
        FeedPolicyModel feedPolicyModel2 = this.feedPolicyModel;
        setLoadMoreTriggerLimit(feedPolicyModel2 != null ? feedPolicyModel2.feedListPreLoadPosition : 4);
        if (newFeeds != null) {
            int index = (this.mDataManager.displayCacheSize() - newFeeds.size()) - 1;
            if (index < 0 || index >= this.mDataManager.displayCacheSize()) {
                notifyDataSetChanged();
            } else {
                this.mAdapter.notifyItemRangeChanged(index, newFeeds.size());
            }
        }
        DynamicImmersiveTtsManager ttsManager = getTtsManager();
        if (ttsManager == null) {
            return null;
        }
        ttsManager.updateDataSource(newFeeds, 1);
        return null;
    }

    private final boolean tryInsertPrefetchData() {
        if (Intrinsics.areEqual((Object) this.strategyType, (Object) "1")) {
            return false;
        }
        getPrefetchDynamicData(this.nid, new DynamicImmersivePage$tryInsertPrefetchData$1(this));
        return true;
    }

    private final void getPrefetchDynamicData(String nid2, Function1<? super Boolean, Unit> prefetchStatusCallback) {
        if (PrefetchSelectUtils.INSTANCE.queryPrefetchData(this.fromChannel, nid2) != null) {
            FeedBaseModel prefetchModel = PrefetchSelectUtils.INSTANCE.getModifyPrefetchData();
            ArrayList<FeedBaseModel> displayCacheList = this.mDataManager.getDisplayCacheList();
            boolean z = false;
            if (displayCacheList != null && displayCacheList.isEmpty()) {
                z = true;
            }
            if (z) {
                String str = null;
                FeedRuntimeStatus feedRuntimeStatus = prefetchModel != null ? prefetchModel.runtimeStatus : null;
                if (feedRuntimeStatus != null) {
                    feedRuntimeStatus.channelId = getChannelId();
                }
                FeedItemData feedItemData = prefetchModel != null ? prefetchModel.data : null;
                FeedItemDataStar feedItemDataStar = feedItemData instanceof FeedItemDataStar ? (FeedItemDataStar) feedItemData : null;
                if (feedItemDataStar != null) {
                    feedItemDataStar.isPrefetch = true;
                }
                if (prefetchModel != null) {
                    this.prefetchList.add(prefetchModel);
                }
                String tag = DynamicImmersivePageKt.getTAG();
                StringBuilder append = new StringBuilder().append("memory_data: template_layout: ").append(prefetchModel != null ? prefetchModel.layout : null).append(" template_id: ");
                if (prefetchModel != null) {
                    str = prefetchModel.id;
                }
                DynamicUtilsKt.dynamicOnLineLog(tag, append.append(str).toString());
                prefetchStatusCallback.invoke(true);
                return;
            }
            return;
        }
        DynamicDBProvider.INSTANCE.getPrefetchData(nid2, new DynamicImmersivePage$getPrefetchDynamicData$2(this, prefetchStatusCallback));
    }

    /* access modifiers changed from: private */
    public final void genDbPrefetchData(String prefetchData) {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            DynamicImmersivePage dynamicImmersivePage = this;
            obj = Result.m8971constructorimpl(new JSONArray(prefetchData));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        JSONArray jsonArray = (JSONArray) obj;
        if (jsonArray != null && jsonArray.length() > 0) {
            IFeedDataParser parser = FeedApi.DataParsers.defaultBaseModelConfig().build();
            int length = jsonArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String json = jsonArray.get(i2).toString();
                if (json.length() > 0) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        DynamicImmersivePage dynamicImmersivePage2 = this;
                        obj2 = Result.m8971constructorimpl(new JSONObject(json));
                    } catch (Throwable th3) {
                        Result.Companion companion4 = Result.Companion;
                        obj2 = Result.m8971constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (Result.m8977isFailureimpl(obj2)) {
                        obj2 = null;
                    }
                    JSONObject jsonObject = (JSONObject) obj2;
                    if (jsonObject != null) {
                        Object parse = parser.parse(jsonObject);
                        Intrinsics.checkNotNullExpressionValue(parse, "parser.parse(jsonObject)");
                        FeedBaseModel feedBaseModel = (FeedBaseModel) parse;
                        feedBaseModel.runtimeStatus.channelId = getChannelId();
                        FeedBaseModel feedBaseModel2 = PrefetchSelectUtils.INSTANCE.modifyPrefetchData(feedBaseModel, this.nid, this.source, this.interactiveStr);
                        FeedItemData feedItemData = feedBaseModel2.data;
                        FeedItemDataStar feedItemDataStar = feedItemData instanceof FeedItemDataStar ? (FeedItemDataStar) feedItemData : null;
                        if (feedItemDataStar != null) {
                            feedItemDataStar.isPrefetch = true;
                        }
                        this.prefetchList.add(feedBaseModel2);
                        DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "DB_data: template_layout: " + feedBaseModel2.layout + " template_id: " + feedBaseModel2.id);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void notifyPrefetchUi() {
        FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor != null) {
            fSPStatisticsProcessor.initPrefetchFirstScreenP(this.prefetchList);
        }
        FeedBaseModel skeletonModel = FeedBaseModel.create();
        FeedBaseModel $this$notifyPrefetchUi_u24lambda_u2d22 = skeletonModel;
        $this$notifyPrefetchUi_u24lambda_u2d22.layout = DynamicImmersivePageKt.SKELETON_SCREEN_LAYOUT;
        $this$notifyPrefetchUi_u24lambda_u2d22.setHelper(new FeedBaseModelHelper($this$notifyPrefetchUi_u24lambda_u2d22));
        Intrinsics.checkNotNullExpressionValue(skeletonModel, "create().apply {\n       …delHelper(this)\n        }");
        this.prefetchList.add(skeletonModel);
        this.mDataManager.insertData(this.prefetchList, 0, DataMgrStrategy.DEFAULT);
        DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "insert data : complete list size: " + this.prefetchList.size() + " modify_time: " + System.currentTimeMillis());
        notifyDataSetChanged();
        DynamicUtilsKt.dynamicOnLineLog(DynamicImmersivePageKt.getTAG(), "handled notifyChanged");
        this.existPrefetch = true;
        FSPStatisticsProcessor fSPStatisticsProcessor2 = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor2 != null) {
            fSPStatisticsProcessor2.setExistPrefetch(true);
        }
        DynamicArrivalProcessor dynamicArrivalProcessor = this.arrivalProcessor;
        if (dynamicArrivalProcessor != null) {
            dynamicArrivalProcessor.setPrefetchStatus(true);
        }
    }

    private final void setRefreshCount(boolean isSuccess) {
        if (isSuccess) {
            this.refreshCount++;
        }
    }

    private final void startPlayIfNeeded() {
        if (this.mRecyclerView != null && !isPlayingAd()) {
            Context context = this.mContext;
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            } else if (((Activity) context).getRequestedOrientation() != 1) {
                IDynamicAutoPlay iDynamicAutoPlay = this.curPlayTemplate;
                if (iDynamicAutoPlay != null) {
                    iDynamicAutoPlay.startPlay();
                }
            } else {
                DynamicTplStartController.getInstance().cleanVideoPlayMap();
                DynamicTplStartController.getInstance().cleanGifPlayMap();
                int firstPosition = findFirstVisibleItemPosition();
                int lastPosition = findLastVisibleItemPosition();
                int i2 = firstPosition;
                if (i2 <= lastPosition) {
                    while (i2 < this.mAdapter.getItemCount()) {
                        View findViewByPosition = this.mLayoutManager.findViewByPosition(i2);
                        FeedItemData itemData = null;
                        IDynamicAutoPlay it = findViewByPosition instanceof IDynamicAutoPlay ? (IDynamicAutoPlay) findViewByPosition : null;
                        if (it != null && it.couldStartPlay(this.mRecyclerView.getHeight()) && i2 < this.mDataManager.displayCacheSize()) {
                            FeedBaseModel feedBaseModel = this.mDataManager.getDisplayCacheList().get(i2);
                            if (feedBaseModel != null) {
                                itemData = feedBaseModel.data;
                            }
                            if (!(itemData instanceof FeedItemDataStar) || !Intrinsics.areEqual((Object) ((FeedItemDataStar) itemData).type, (Object) "video")) {
                                HashMap<Integer, IDynamicAutoPlay> gifPlayMap = DynamicTplStartController.getInstance().getGifPlayMap();
                                Intrinsics.checkNotNullExpressionValue(gifPlayMap, "getInstance().gifPlayMap");
                                gifPlayMap.put(Integer.valueOf(i2), it);
                            } else {
                                SortedMap<Integer, IDynamicAutoPlay> videoPlayMap = DynamicTplStartController.getInstance().getVideoPlayMap();
                                Intrinsics.checkNotNullExpressionValue(videoPlayMap, "getInstance().videoPlayMap");
                                videoPlayMap.put(Integer.valueOf(i2), it);
                            }
                        }
                        if (i2 != lastPosition) {
                            i2++;
                        }
                    }
                    return;
                }
                DynamicTplStartController.getInstance().startVideoPlay(this.curPlayTemplate, this.mRecyclerView, new DynamicControllerCB(this));
                DynamicTplStartController.getInstance().startGifPlay();
            }
        }
    }

    public final void stopPlayCurVideoTemplate(int stopType) {
        if (this.curPlayTemplate != null) {
            Context context = this.mContext;
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            } else if (((Activity) context).getRequestedOrientation() == 1) {
                DynamicTplStartController.getInstance().removeCurPlayTplFromPlayMap(this.curPlayTemplate);
                IDynamicAutoPlay iDynamicAutoPlay = this.curPlayTemplate;
                if (iDynamicAutoPlay != null) {
                    iDynamicAutoPlay.stopPlay(stopType);
                }
                this.curPlayTemplate = null;
            } else {
                IDynamicAutoPlay iDynamicAutoPlay2 = this.curPlayTemplate;
                if (iDynamicAutoPlay2 != null) {
                    iDynamicAutoPlay2.stopPlay(stopType);
                }
            }
        }
    }

    private final void stopPlayGifTemplate(int stopType) {
        DynamicTplStartController.getInstance().removeGifFromPlayMap(stopType);
    }

    private final void stopScrolledGifPlay() {
        DynamicTplStartController.getInstance().stopScrolledGifFromPlayMap(this.mRecyclerView.getHeight(), 3);
    }

    public void onViewResume() {
        super.onViewResume();
        startPlayIfNeeded();
        startPlayAdIfNeeded();
        DynamicImmersiveDisplayMeasure dynamicImmersiveDisplayMeasure = this.displayMeasure;
        if (dynamicImmersiveDisplayMeasure != null) {
            dynamicImmersiveDisplayMeasure.onShowOrResume();
        }
        CountDownTimer countDownTimer = this.coldRestoreReportTimer;
        if (countDownTimer != null) {
            countDownTimer.resume();
        }
        IFeedAgility iFeedAgility = this.mAgility;
        if (iFeedAgility != null) {
            iFeedAgility.tryUpdateListOnResume(this.mIFeedTplContainer, this.mDataManager.getDisplayCacheList());
        }
        this.fluencyInfoTracer.onEnterPage();
    }

    public void onViewPause() {
        super.onViewPause();
        stopPlayCurVideoTemplate(5);
        stopPlayGifTemplate(5);
        pausePlayAd();
        DynamicImmersiveDisplayMeasure dynamicImmersiveDisplayMeasure = this.displayMeasure;
        if (dynamicImmersiveDisplayMeasure != null) {
            dynamicImmersiveDisplayMeasure.onHintOrPause();
        }
        CountDownTimer countDownTimer = this.coldRestoreReportTimer;
        if (countDownTimer != null) {
            countDownTimer.pause();
        }
        displayReport(2);
        FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor != null) {
            fSPStatisticsProcessor.onViewPause();
        }
        this.fluencyInfoTracer.onLeavePage();
    }

    private final void tplShowInfosUploadReport(String reportType) {
        DynamicImmersiveReportInfoUploadManager $this$tplShowInfosUploadReport_u24lambda_u2d24 = this.reportInfoManager;
        if ($this$tplShowInfosUploadReport_u24lambda_u2d24 != null) {
            FeedStatisticCenter.reportUploadIds("10030", reportType, $this$tplShowInfosUploadReport_u24lambda_u2d24.getUBCUploadIds(), "dtlandimmersive");
        }
    }

    public void onViewDestroy() {
        super.onViewDestroy();
        processDataLinkages();
        tplShowInfosUploadReport(FeedStatisticConstants.UBC_UPLOAD_IDS_BACK_TO_MAIN_FEED);
        DynamicTplStartController.getInstance().cleanVideoPlayMap();
        DynamicTplStartController.getInstance().cleanGifPlayMap();
        unregisterNAReceive(getChannelId());
        unRegisterNetWorkChangeReceiver();
        BdEventBus.Companion.getDefault().unregister(this);
        stopPlayAd();
        CountDownTimer countDownTimer = this.coldRestoreReportTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        String tag = DynamicImmersivePageKt.getTAG();
        StringBuilder append = new StringBuilder().append("onDestroy_data_size: ").append(this.mDataManager.displayCacheSize()).append(" adapter_item_count : ");
        PageAdapter pageAdapter = this.mAdapter;
        DynamicUtilsKt.dynamicOnLineLog(tag, append.append(pageAdapter != null ? Integer.valueOf(pageAdapter.getItemCount()) : null).toString());
        this.actionBarVisibilityListener = null;
        FeedItemImgClickListenerTable.getInstance().remove(getAssignId());
        DynamicCachesRecoveryManager dynamicCachesRecoveryManager = DynamicCachesRecoveryManager.INSTANCE;
        ArrayList<FeedBaseModel> displayCacheList = this.mDataManager.getDisplayCacheList();
        Intrinsics.checkNotNullExpressionValue(displayCacheList, "mDataManager.displayCacheList");
        dynamicCachesRecoveryManager.saveCaches(displayCacheList);
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        LinearLayoutManager it = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (it != null) {
            DynamicCachesRecoveryManager.INSTANCE.saveRestoreFirstPos(it.findFirstVisibleItemPosition());
        }
        INadDynamicImmersiveInsertManager iNadDynamicImmersiveInsertManager = this.adInsertManager;
        if (iNadDynamicImmersiveInsertManager != null) {
            iNadDynamicImmersiveInsertManager.destroy();
        }
        this.adInsertManager = null;
        this.pageView = null;
        FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor != null) {
            fSPStatisticsProcessor.onViewDestroy();
        }
        DynamicArrivalProcessor dynamicArrivalProcessor = this.arrivalProcessor;
        if (dynamicArrivalProcessor != null) {
            dynamicArrivalProcessor.onViewDestroy();
        }
        HttpManager.getDefault(DynamicRuntime.INSTANCE.getAppContext()).cancelTag(DynamicImmersivePageKt.requestTag);
        DynamicImmersiveTtsManager ttsManager = getTtsManager();
        if (ttsManager != null) {
            ttsManager.release();
        }
        this.fluencyInfoTracer.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onUnlikeClick(View view2, FeedBaseModel model, int position) {
        if (model != null) {
            FeedBaseModelHelper helper = model.getHelper();
            Intrinsics.checkNotNullExpressionValue(helper, "model.helper");
            CharSequence reportScheme = helper.getReportScheme();
            boolean isReportEnable = !(reportScheme == null || reportScheme.length() == 0);
            ITemplateStatistics templateStatistics = TemplateStatisticsTable.getInstance().get(getChannelId());
            if (this.mUnifiedClicker != null) {
                FeedbackPop.FeedbackPopParams params = new FeedbackPop.FeedbackPopParams();
                params.context = this.mContext;
                params.type = 0;
                params.anchorView = view2;
                params.position = position;
                params.model = model;
                params.source = "other";
                params.isReportEnable = isReportEnable;
                params.callback = new DynamicImmersivePage$onUnlikeClick$1(this, model, position, templateStatistics);
                this.mUnifiedClicker.mLastUnlikePop = FeedbackPop.makePopUp(params);
                this.mUnifiedClicker.mLastUnlikePop.show();
            }
            if (templateStatistics != null) {
                templateStatistics.dislikeClick(getChannelId(), model);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void deleteBindTemplate(String currentTemplateId, int position) {
        ArrayList caches = this.mDataManager.getDisplayCacheList();
        boolean z = true;
        if (!(currentTemplateId.length() == 0) && !caches.isEmpty() && position >= 0 && position < caches.size()) {
            FeedBaseModel feedBaseModel = caches.get(position);
            IBindableData bindTemplate = null;
            FeedItemData feedItemData = feedBaseModel != null ? feedBaseModel.data : null;
            if (feedItemData instanceof IBindableData) {
                bindTemplate = (IBindableData) feedItemData;
            }
            if (bindTemplate == null || !bindTemplate.isBind(currentTemplateId)) {
                z = false;
            }
            if (z) {
                this.mDataManager.deleteData(feedBaseModel, DataMgrStrategy.DEFAULT);
            }
        }
    }

    private final void onPrefetchData(int state) {
        DynamicPrefetchProcessor dynamicPrefetchProcessor = this.prefetchProcessor;
        if (dynamicPrefetchProcessor != null) {
            dynamicPrefetchProcessor.onPrefetchData(state, findFirstVisibleItemPosition(), findLastVisibleItemPosition() + 1);
        }
    }

    private final void registerNAReceive(String channelId) {
        DynamicImmersiveNAReceiver it = new DynamicImmersiveNAReceiver(channelId);
        this.naReceiver = it;
        DataChannel.Registry.registerNAReceiver(channelId, (String) null, Contract.TOOL_BAR_LIKE_INFO_UPDATE_ACTION, it);
        DataChannel.Registry.registerNAReceiver(channelId, (String) null, "com.baidu.channel.foundation.followchanged", it);
        DataChannel.Registry.registerNAReceiver(channelId, (String) null, Contract.FORWARD_NUM_ACTION, it);
        DataChannel.Registry.registerNAReceiver(channelId, (String) null, "com.baidu.channel.comment.num", it);
        DataChannel.Registry.registerNAReceiver(channelId, (String) null, Contract.LANDPAGE_READ_COUNT_ACTION, it);
        DataChannel.Registry.registerNAReceiver(channelId, (String) null, "com.baidu.channel.feed.assistmessage", it);
        DataChannel.Registry.registerNAReceiver(channelId, (String) null, Contract.MINI_DETAIL_POSTNOTIFICATIONTYPE_PRAISE, it);
        it.setDataChangedCallback(new DynamicImmersivePage$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerNAReceive$lambda-27$lambda-26  reason: not valid java name */
    public static final void m18584registerNAReceive$lambda27$lambda26(DynamicImmersivePage this$0, int pos, int i2, FeedBaseModel feedBaseModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pos < this$0.mAdapter.getItemCount()) {
            this$0.notifyDataSetChanged();
        }
    }

    private final void registerNetWorkChangeReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
        Context context = this.mContext;
        if (context != null) {
            context.registerReceiver(this.netWorkChangeReceiver, filter);
        }
    }

    private final void unRegisterNetWorkChangeReceiver() {
        Context context = this.mContext;
        if (context != null) {
            context.unregisterReceiver(this.netWorkChangeReceiver);
        }
    }

    private final void registerLinkageEvent() {
        BdEventBus.Companion.getDefault().register(this, NewLinkageDataEvent.class, 1, new DynamicImmersivePage$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerLinkageEvent$lambda-28  reason: not valid java name */
    public static final void m18583registerLinkageEvent$lambda28(DynamicImmersivePage this$0, NewLinkageDataEvent it) {
        FeedItemDataStar.RenderStrategy renderStrategy;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual((Object) it.getData().type, (Object) "favor")) {
            int start = this$0.findFirstVisibleItemPosition();
            int end = this$0.findLastVisibleItemPosition();
            FeedBaseModel model = this$0.mAdapter.getItem(start);
            Boolean isExp = null;
            FeedItemData feedItemData = model != null ? model.data : null;
            FeedItemDataStar feedItemDataStar = feedItemData instanceof FeedItemDataStar ? (FeedItemDataStar) feedItemData : null;
            if (!(feedItemDataStar == null || (renderStrategy = feedItemDataStar.renderStrategy) == null)) {
                isExp = Boolean.valueOf(renderStrategy.isDynamicFeedBar());
            }
            if (start != -1 && end != -1 && Intrinsics.areEqual((Object) isExp, (Object) true)) {
                this$0.mAdapter.notifyItemRangeChanged(start, (end - start) + 1);
            }
        }
    }

    private final void unregisterNAReceive(String channelId) {
        DataChannel.Registry.unregisterReceiver(channelId, (String) null, Contract.TOOL_BAR_LIKE_INFO_UPDATE_ACTION);
        DataChannel.Registry.unregisterReceiver(channelId, (String) null, "com.baidu.channel.foundation.followchanged");
        DataChannel.Registry.unregisterReceiver(channelId, (String) null, Contract.FORWARD_NUM_ACTION);
        DataChannel.Registry.unregisterReceiver(channelId, (String) null, "com.baidu.channel.comment.num");
        DataChannel.Registry.unregisterReceiver(channelId, (String) null, Contract.LANDPAGE_READ_COUNT_ACTION);
        DataChannel.Registry.unregisterReceiver(channelId, (String) null, "com.baidu.channel.feed.assistmessage");
        DataChannel.Registry.unregisterReceiver(channelId, (String) null, Contract.MINI_DETAIL_POSTNOTIFICATIONTYPE_PRAISE);
        DataChannel.Registry.unregisterReceiver(ChattingRoomEntranceViewKt.ROOM_STATUS_HOST, (String) null, "com.baidu.channel.feedchatroom");
    }

    public void onNightModeChanged(boolean isNightMode) {
        notifyDataSetChanged();
        this.mRecyclerView.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.GC9));
        RecyclerView.ItemDecoration itemDecoration = this.dynamicItemDecoration;
        DynamicItemDecoration dynamicItemDecoration2 = itemDecoration instanceof DynamicItemDecoration ? (DynamicItemDecoration) itemDecoration : null;
        if (dynamicItemDecoration2 != null) {
            dynamicItemDecoration2.onFeedNightModeChanged(isNightMode);
        }
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showBlankView() {
        /*
            r5 = this;
            android.content.Context r0 = r5.mContext
            boolean r1 = r0 instanceof android.app.Activity
            r2 = 0
            if (r1 == 0) goto L_0x000a
            android.app.Activity r0 = (android.app.Activity) r0
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 == 0) goto L_0x0016
            int r1 = com.baidu.searchbox.feed.dynamicdetail.R.id.shimmer_layout
            android.view.View r0 = r0.findViewById(r1)
            com.baidu.searchbox.ui.ShimmerFrameLayout r0 = (com.baidu.searchbox.ui.ShimmerFrameLayout) r0
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            r5.shimmerLayout = r0
            if (r0 != 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            r1 = 1
            r0.setAutoStart(r1)
        L_0x0020:
            int r0 = com.baidu.android.common.loading.R.drawable.white_shimmer_loading
            android.graphics.drawable.Drawable r0 = com.baidu.android.util.bitmap.PreloadUIResUtils.getPreloadedDrawable(r0)
            if (r0 != 0) goto L_0x0034
            android.content.Context r1 = r5.mContext
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.baidu.android.common.loading.R.drawable.white_shimmer_loading
            android.graphics.drawable.Drawable r0 = androidx.core.content.res.ResourcesCompat.getDrawable(r1, r3, r2)
        L_0x0034:
            com.baidu.searchbox.ui.ShimmerFrameLayout r1 = r5.shimmerLayout
            if (r1 == 0) goto L_0x0041
            int r2 = com.baidu.searchbox.feed.dynamicdetail.R.id.shimmer_content
            android.view.View r1 = r1.findViewById(r2)
            r2 = r1
            android.widget.ImageView r2 = (android.widget.ImageView) r2
        L_0x0041:
            r1 = r2
            if (r1 == 0) goto L_0x0047
            r1.setImageDrawable(r0)
        L_0x0047:
            com.baidu.searchbox.ui.ShimmerFrameLayout r2 = r5.shimmerLayout
            if (r2 != 0) goto L_0x004c
            goto L_0x0051
        L_0x004c:
            com.baidu.searchbox.ui.ShimmerFrameLayout$MaskShape r3 = com.baidu.searchbox.ui.ShimmerFrameLayout.MaskShape.LINEAR
            r2.setMaskShape(r3)
        L_0x0051:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = -2
            r2.<init>(r3, r3)
            r3 = 17
            r2.gravity = r3
            com.baidu.searchbox.ui.ShimmerFrameLayout r3 = r5.shimmerLayout
            if (r3 != 0) goto L_0x0060
            goto L_0x0066
        L_0x0060:
            r4 = r2
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            r3.setLayoutParams(r4)
        L_0x0066:
            com.baidu.searchbox.ui.ShimmerFrameLayout r3 = r5.shimmerLayout
            if (r3 != 0) goto L_0x006b
            goto L_0x006f
        L_0x006b:
            r4 = 0
            r3.setVisibility(r4)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.dynamicdetail.DynamicImmersivePage.showBlankView():void");
    }

    private final void hideBlankView() {
        ShimmerFrameLayout shimmerFrameLayout = this.shimmerLayout;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.stopShimmerAnimation();
        }
        ShimmerFrameLayout shimmerFrameLayout2 = this.shimmerLayout;
        if (shimmerFrameLayout2 != null) {
            shimmerFrameLayout2.setVisibility(8);
        }
    }

    public void onErrorClick(View textView) {
        FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor != null) {
            fSPStatisticsProcessor.onPageRefresh();
        }
        doRefreshing("3", false);
    }

    public void onEmptyClick(View view2) {
    }

    private final void startPlayAdIfNeeded() {
        if (this.curPlayTemplate == null) {
            MuteVideoPlayController.getInstance().play("dynamic_immersive" + this.nid);
        } else {
            pausePlayAd();
        }
    }

    private final void pausePlayAd() {
        MuteVideoPlayController.getInstance().pause("dynamic_immersive" + this.nid);
    }

    private final void stopPlayAd() {
        MuteVideoPlayController.getInstance().stop("dynamic_immersive" + this.nid);
    }

    private final boolean isPlayingAd() {
        return MuteVideoPlayController.getInstance().isMutePlaying("dynamic_immersive" + this.nid);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage$DynamicControllerCB;", "Lcom/baidu/searchbox/feed/dynamicdetail/DynamicTplStartController$ControllerCallback;", "page", "Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage;", "(Lcom/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage;)V", "weakReferencePage", "Ljava/lang/ref/WeakReference;", "needStopAndResetCurTpl", "", "stopType", "", "resetTpl", "Lcom/baidu/searchbox/feed/base/hot/IDynamicAutoPlay;", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicImmersivePage.kt */
    public static final class DynamicControllerCB implements DynamicTplStartController.ControllerCallback {
        private WeakReference<DynamicImmersivePage> weakReferencePage;

        public DynamicControllerCB(DynamicImmersivePage page) {
            Intrinsics.checkNotNullParameter(page, "page");
            this.weakReferencePage = new WeakReference<>(page);
        }

        public void needStopAndResetCurTpl(int stopType, IDynamicAutoPlay resetTpl) {
            DynamicImmersivePage dynamicImmersivePage;
            IDynamicAutoPlay access$getCurPlayTemplate$p;
            DynamicImmersivePage dynamicImmersivePage2;
            WeakReference<DynamicImmersivePage> weakReference = this.weakReferencePage;
            if (!(weakReference == null || (dynamicImmersivePage2 = (DynamicImmersivePage) weakReference.get()) == null)) {
                dynamicImmersivePage2.stopPlayCurVideoTemplate(stopType);
            }
            WeakReference<DynamicImmersivePage> weakReference2 = this.weakReferencePage;
            DynamicImmersivePage dynamicImmersivePage3 = weakReference2 != null ? (DynamicImmersivePage) weakReference2.get() : null;
            if (dynamicImmersivePage3 != null) {
                dynamicImmersivePage3.curPlayTemplate = resetTpl;
            }
            WeakReference<DynamicImmersivePage> weakReference3 = this.weakReferencePage;
            if (weakReference3 != null && (dynamicImmersivePage = (DynamicImmersivePage) weakReference3.get()) != null && (access$getCurPlayTemplate$p = dynamicImmersivePage.curPlayTemplate) != null) {
                access$getCurPlayTemplate$p.startPlay();
            }
        }
    }

    public static /* synthetic */ void onTtsIconClick$default(DynamicImmersivePage dynamicImmersivePage, boolean z, Function1 function1, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                function1 = null;
            }
            dynamicImmersivePage.onTtsIconClick(z, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTtsIconClick");
    }

    public final void onTtsIconClick(boolean isPlayingTts, Function1<? super Integer, Unit> scrollItem) {
        ArrayList<FeedBaseModel> displayCacheList = this.mDataManager.getDisplayCacheList();
        int pos = findFirstVisibleItemPosition();
        DynamicImmersiveTtsManager ttsManager = getTtsManager();
        if (ttsManager != null) {
            ttsManager.ttsIconClick(isPlayingTts, pos, displayCacheList, scrollItem);
        }
    }

    private final int getPositionById(String id) {
        CharSequence charSequence = id;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return -1;
        }
        ArrayList<FeedBaseModel> $this$forEachIndexed$iv = this.mDataManager.getDisplayCacheList();
        Intrinsics.checkNotNullExpressionValue($this$forEachIndexed$iv, "mDataManager.displayCacheList");
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual((Object) ((FeedBaseModel) item$iv).id, (Object) id)) {
                return index;
            }
            index = index$iv;
        }
        return -1;
    }

    private final FeedBaseModel getFeedBaseModeById(String uKey) {
        ArrayList<FeedBaseModel> feedsCacheList = this.mDataManager.getDisplayCacheList();
        Intrinsics.checkNotNullExpressionValue(feedsCacheList, "mDataManager.displayCacheList");
        for (FeedBaseModel model : feedsCacheList) {
            if (Intrinsics.areEqual((Object) model.id, (Object) uKey)) {
                return model;
            }
        }
        return null;
    }

    private final void processDataLinkages() {
        FeedBaseModel model = getFeedBaseModeById(this.nid);
        FeedBar.Comment comment = null;
        if ((model != null ? model.data : null) != null) {
            JSONObject paramsJson = new JSONObject();
            JSONArray paramsArray = new JSONArray();
            try {
                Result.Companion companion = Result.Companion;
                DynamicImmersivePage $this$processDataLinkages_u24lambda_u2d30 = this;
                paramsJson.put($this$processDataLinkages_u24lambda_u2d30.nid, paramsArray);
                String str = model.data.commonText;
                Intrinsics.checkNotNullExpressionValue(str, "model.data.commonText");
                paramsArray.put($this$processDataLinkages_u24lambda_u2d30.createCommonTextParam(str));
                String str2 = model.data.commentNum;
                Intrinsics.checkNotNullExpressionValue(str2, "model.data.commentNum");
                paramsArray.put($this$processDataLinkages_u24lambda_u2d30.createReadParam(str2));
                FeedBar feedBar = model.data.feedBar;
                FeedBar.Like like = feedBar != null ? feedBar.like : null;
                if (like != null) {
                    paramsArray.put($this$processDataLinkages_u24lambda_u2d30.createLikeParam(like.count, like.status));
                }
                Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            DataChannel.Sender.sendBroadcast(this.mContext, "com.baidu.channel.feed.assistmessage", paramsJson.toString());
            FeedBar feedBar2 = model.data.feedBar;
            if (feedBar2 != null) {
                comment = feedBar2.comment;
            }
            if (comment != null) {
                DataChannel.Sender.sendBroadcast(this.mContext, "com.baidu.channel.comment.num", createCommentParam(this.nid, comment.count).toString());
            }
        }
    }

    private final JSONObject createCommonTextParam(String content) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$createCommonTextParam_u24lambda_u2d31 = jSONObject;
        try {
            $this$createCommonTextParam_u24lambda_u2d31.put("type", "common_text");
            $this$createCommonTextParam_u24lambda_u2d31.put("content", content);
        } catch (Exception e$iv) {
            Exception exc = e$iv;
        }
        return jSONObject;
    }

    private final JSONObject createReadParam(String count) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$createReadParam_u24lambda_u2d32 = jSONObject;
        try {
            $this$createReadParam_u24lambda_u2d32.put("type", ILinkageOperation.TYPE_DT_READ);
            $this$createReadParam_u24lambda_u2d32.put("count", count);
        } catch (Exception e$iv) {
            Exception exc = e$iv;
        }
        return jSONObject;
    }

    private final JSONObject createLikeParam(int count, boolean status) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$createLikeParam_u24lambda_u2d33 = jSONObject;
        try {
            $this$createLikeParam_u24lambda_u2d33.put("type", "pro");
            $this$createLikeParam_u24lambda_u2d33.put("status", status ? "1" : "0");
            $this$createLikeParam_u24lambda_u2d33.put("count", count);
        } catch (Exception e$iv) {
            Exception exc = e$iv;
        }
        return jSONObject;
    }

    private final JSONObject createCommentParam(String nid2, int num) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$createCommentParam_u24lambda_u2d34 = jSONObject;
        try {
            $this$createCommentParam_u24lambda_u2d34.put("nid", nid2);
            $this$createCommentParam_u24lambda_u2d34.put("num", num);
        } catch (Exception e$iv) {
            Exception exc = e$iv;
        }
        return jSONObject;
    }

    public final void onForegroundToBackground() {
        tplShowInfosUploadReport("background");
        FSPStatisticsProcessor fSPStatisticsProcessor = this.fspStatisticsProcessor;
        if (fSPStatisticsProcessor != null) {
            fSPStatisticsProcessor.onForegroundToBackground();
        }
    }

    public final void onContentScrolled(int dy) {
        DynamicImmersiveDisplayMeasure dynamicImmersiveDisplayMeasure;
        if (dy != 0 && (dynamicImmersiveDisplayMeasure = this.displayMeasure) != null) {
            dynamicImmersiveDisplayMeasure.onScrolled();
        }
    }

    private final void displayReport(int actionType) {
        if (this.mDataManager.displayCacheSize() > 0) {
            if (!Intrinsics.areEqual((Object) this.strategyType, (Object) "1")) {
                FeedBaseModel feedBaseModel = this.mDataManager.getDisplayCacheList().get(0);
                FeedRuntimeStatus feedRuntimeStatus = feedBaseModel != null ? feedBaseModel.runtimeStatus : null;
                if (feedRuntimeStatus != null) {
                    feedRuntimeStatus.hasRecorded = true;
                }
            }
            FeedDisplayReport.getUtil(getChannelId(), DynamicUtilsKt.getFromValueBySource(this.source)).reportFeedDisplay(this.mDataManager.getDisplayCacheList(), actionType, true);
        }
    }

    private final void onEvent(FontSizeChangeMessage event) {
        if (event.messageId == 1) {
            notifyDataSetChanged();
        }
    }

    private final void scrollTemplateTop(View view2, FeedBaseModel model, int position) {
        View view3 = view2;
        FeedBaseModel feedBaseModel = model;
        int i2 = position;
        FeedItemData itemData = feedBaseModel != null ? feedBaseModel.data : null;
        if (itemData != null) {
            if (itemData.isFolded) {
                DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, model, DynamicStatisticsHelper.UBC_VALUE_TEXT_CLICK, this.source, false, (String) null, 24, (Object) null);
                DynamicStatisticsHelper.INSTANCE.clickTemplateCmdReport(model, i2, this.strategyType);
            } else if (view3 instanceof NewsFeedBaseView) {
                View titleBar = ((NewsFeedBaseView) view3).findViewById(com.baidu.searchbox.feed.template.R.id.feed_star_title_bar_id);
                Intrinsics.checkNotNullExpressionValue(titleBar, "view.findViewById(com.ba…d.feed_star_title_bar_id)");
                if (!isCompleteVisible(titleBar)) {
                    this.mRecyclerView.scrollToPosition(i2);
                    ActionBarVisibilityListener actionBarVisibilityListener2 = this.actionBarVisibilityListener;
                    boolean z = true;
                    if (actionBarVisibilityListener2 == null || !actionBarVisibilityListener2.getActionBarVisibility()) {
                        z = false;
                    }
                    if (z) {
                        this.mRecyclerView.scrollBy(0, DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), -38.0f));
                    }
                }
            }
        }
    }

    private final boolean isCompleteVisible(View view2) {
        Rect rect = new Rect();
        return view2.getLocalVisibleRect(rect) && rect.height() == view2.getMeasuredHeight();
    }

    /* access modifiers changed from: private */
    public final void reportColdRestoreFeedDauIfNeed() {
        if (this.isColdRestore && !this.hasReportColdRestoreDau) {
            DynamicStatisticsHelper.INSTANCE.coldRestoreFeedDauReport(this.nid);
            this.hasReportColdRestoreDau = true;
            CountDownTimer countDownTimer = this.coldRestoreReportTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }

    private final boolean isSpecialTpl(FeedBaseModel model) {
        return Intrinsics.areEqual((Object) model.layout, (Object) DynamicImmersivePageKt.SKELETON_SCREEN_LAYOUT);
    }

    /* access modifiers changed from: private */
    public final String getChannelId() {
        return DynamicUtilsKt.getListAssignId(this.source, this.nid, this.strategyType);
    }

    public final void notifyDataSetChanged() {
        PageAdapter pageAdapter = this.mAdapter;
        if (pageAdapter != null) {
            pageAdapter.notifyDataSetChanged();
        }
    }

    private final void prerenderAd() {
        StrategyDataManager strategyDataManager = this.mDataManager;
        List it = CollectionUtils.subListContainEnd(strategyDataManager != null ? strategyDataManager.getDisplayCacheList() : null, findFirstVisibleItemPosition(), findLastVisibleItemPosition());
        if (it != null) {
            AdRuntimeHolder.getAdPreRender().preRenderAdList(it);
        }
    }

    public final void doShowPublishDisplay(List<? extends FeedBaseModel> displayItems) {
        Collection collection = displayItems;
        boolean z = false;
        if (!(collection == null || collection.isEmpty())) {
            int first = findFirstVisibleItemPosition();
            int last = findLastVisibleItemPosition();
            int firstComplete = findFirstCompletelyVisibleItemPosition();
            int pos = -1;
            if ((first == last && first != -1 && firstComplete == -1) || (first == firstComplete && firstComplete != -1)) {
                pos = first;
            } else if (first != -1) {
                pos = first + 1;
            }
            if (pos >= 0 && pos <= getController().obtainDataManager().displayCacheSize()) {
                z = true;
            }
            if (z) {
                getController().obtainDataManager().insertData(displayItems, pos, DataMgrStrategy.DEFAULT);
                getAdapter().notifyItemRangeInserted(pos, displayItems.size());
                if (pos == 0) {
                    this.mRecyclerView.scrollToPosition(pos);
                }
            }
        }
    }
}
