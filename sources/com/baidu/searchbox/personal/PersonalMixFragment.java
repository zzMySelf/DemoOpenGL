package com.baidu.searchbox.personal;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.fragment.HomeBaseFragment;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.config.eventmessage.HomeTabClickEvent;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.datachannel.DataChannel;
import com.baidu.searchbox.download.center.statistic.PersonalCenterDurationUbc;
import com.baidu.searchbox.download.center.ui.fusion.manager.decoder.ParseJsonKey;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.feed.container.FeedContainer;
import com.baidu.searchbox.feed.container.IFeedContainerDelegate;
import com.baidu.searchbox.feed.listener.ManualScrollChangeListener;
import com.baidu.searchbox.feed.tab.SlidingTabLayout;
import com.baidu.searchbox.feed.tab.TabViewPager;
import com.baidu.searchbox.feed.tab.fragment.FeedBaseFragment;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.feed.widget.feedflow.IPagerView;
import com.baidu.searchbox.home.theme.IHomeThemeFun;
import com.baidu.searchbox.home.theme.IThemeApplyListener;
import com.baidu.searchbox.kmm.personalcenter.PersonalCenterDataMgrFusionExtKt;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterDataWrapper;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.newpersonalcenter.CustomLinearLayoutManager;
import com.baidu.searchbox.newpersonalcenter.CustomRelativeLayout;
import com.baidu.searchbox.newpersonalcenter.GesturesRecyclerView;
import com.baidu.searchbox.newpersonalcenter.MixNestedScrollView;
import com.baidu.searchbox.newpersonalcenter.activity.PersonalActivity;
import com.baidu.searchbox.newpersonalcenter.adapter.PersonalAdapterWithHeader;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.newpersonalcenter.viewholder.BaseHolder;
import com.baidu.searchbox.personal.bubble.BubbleGuideManager;
import com.baidu.searchbox.personal.container.IPersonalizedContainerEventListener;
import com.baidu.searchbox.personal.container.PersonalizedContainer;
import com.baidu.searchbox.personal.feed.FeedTabHelper;
import com.baidu.searchbox.personal.feed.FeedTabUpdateCallback;
import com.baidu.searchbox.personal.feed.FeedViewHelper;
import com.baidu.searchbox.personal.feed.PersonalCenterWebPageView;
import com.baidu.searchbox.personal.feed.common.CommonRefreshableListPage;
import com.baidu.searchbox.personal.fuse.PersonalCenterNaUbcUtils;
import com.baidu.searchbox.personal.fuse.PersonalCenterRequest;
import com.baidu.searchbox.personal.fuse.PersonalCenterViewCreator;
import com.baidu.searchbox.personal.header.PersonMixCenterHeaderView;
import com.baidu.searchbox.personal.manager.IPersonalizedDataListener;
import com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper;
import com.baidu.searchbox.personal.manager.UpgradeMgr;
import com.baidu.searchbox.personal.publish.PublishConfigBubbleAnimationManager;
import com.baidu.searchbox.personal.publish.PublishHelper;
import com.baidu.searchbox.personal.sidebar.SidebarWindowLayout;
import com.baidu.searchbox.personalcenter.PersonalCenterStateUtils;
import com.baidu.searchbox.personalcenter.PersonalCenterUbc;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.PersonalDataChangeCallback;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.personalcenter.bubble.PersonalCenterBubbleModel;
import com.baidu.searchbox.personalcenter.ioc.PersonalCenterRuntime;
import com.baidu.searchbox.personalcenter.listener.IPersonalEventListener;
import com.baidu.searchbox.personalcenter.personal.IPersonalizedContent;
import com.baidu.searchbox.personalcenter.utils.LoginUtilKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import com.baidu.searchbox.utils.PersonalCenterUtils;
import com.baidu.searchbox.utils.SideBarDataProcessorKt;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import com.facebook.drawee.view.SimpleDraweeView;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002¶\u0001B\u0005¢\u0006\u0002\u0010\bJ\b\u0010[\u001a\u00020\\H\u0014J\u0010\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u000fH\u0002J\u0010\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020\u001dH\u0002J\b\u0010a\u001a\u00020\\H\u0002J\n\u0010b\u001a\u0004\u0018\u00010cH\u0002J\r\u0010d\u001a\u00020\nH\u0000¢\u0006\u0002\beJ\b\u0010f\u001a\u00020\nH\u0002J\b\u0010g\u001a\u00020\nH\u0002J\b\u0010h\u001a\u00020\\H\u0002J\u0010\u0010i\u001a\u00020\u001d2\u0006\u0010j\u001a\u00020\u000fH\u0016J\u0010\u0010k\u001a\u00020\\2\u0006\u0010l\u001a\u00020\u001dH\u0017J\b\u0010m\u001a\u00020\\H\u0002J\u0012\u0010n\u001a\u00020\\2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J\u0010\u0010q\u001a\u00020\\2\u0006\u0010r\u001a\u00020sH\u0016J\u0012\u0010t\u001a\u00020\\2\b\u0010o\u001a\u0004\u0018\u00010pH\u0017J&\u0010u\u001a\u0004\u0018\u00010\u00182\u0006\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010y2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J\b\u0010z\u001a\u00020\\H\u0016J\b\u0010{\u001a\u00020\\H\u0016J\u0018\u0010|\u001a\u00020\\2\u0006\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\u001dH\u0016J\b\u0010\u001a\u00020\\H\u0016J\u001e\u0010\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u000f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020\\2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010~\u001a\u00020\u001dH\u0017J\u001b\u0010\u0001\u001a\u00020\\2\u0007\u0010\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u0001\u001a\u00020\\H\u0016J\t\u0010\u0001\u001a\u00020\\H\u0016J\u0012\u0010\u0001\u001a\u00020\\2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u0001\u001a\u00020\\2\u0007\u0010\u0001\u001a\u00020\u001dH\u0017J\t\u0010\u0001\u001a\u00020\\H\u0016J\u0012\u0010\u0001\u001a\u00020\\2\u0007\u0010\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0001\u001a\u00020\\H\u0016J\t\u0010\u0001\u001a\u00020\\H\u0016J\t\u0010\u0001\u001a\u00020\\H\u0016J\u0019\u0010\u0001\u001a\u00020\\2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\\0\u0001H\u0002J\u0019\u0010\u0001\u001a\u00020\\2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\\0\u0001H\u0002J\t\u0010\u0001\u001a\u00020\\H\u0002J\t\u0010\u0001\u001a\u00020\\H\u0016J\u0012\u0010\u0001\u001a\u00020\\2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u001f\u0010\u0001\u001a\u00020\u001d2\t\u0010\u0001\u001a\u0004\u0018\u00010\n2\t\b\u0002\u0010 \u0001\u001a\u00020\u001dH\u0002J\u0012\u0010¡\u0001\u001a\u00020\\2\u0007\u0010¢\u0001\u001a\u00020\u001dH\u0016J\t\u0010£\u0001\u001a\u00020\\H\u0007J\t\u0010¤\u0001\u001a\u00020\\H\u0002J\u0012\u0010¥\u0001\u001a\u00020\\2\u0007\u0010¦\u0001\u001a\u00020\u000fH\u0016J\t\u0010§\u0001\u001a\u00020\\H\u0002J\t\u0010¨\u0001\u001a\u00020\\H\u0002J\t\u0010©\u0001\u001a\u00020\\H\u0002J\u0011\u0010ª\u0001\u001a\u00020\\2\u0006\u0010~\u001a\u00020\u001dH\u0002J\f\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0002J\u0011\u0010­\u0001\u001a\u00020\\2\u0006\u0010~\u001a\u00020\u001dH\u0002J\t\u0010®\u0001\u001a\u00020\\H\u0002J\t\u0010¯\u0001\u001a\u00020\\H\u0002J\u0018\u0010°\u0001\u001a\u00020\\2\r\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020#0\u0016H\u0016J\t\u0010²\u0001\u001a\u00020\\H\u0002J\u0018\u0010³\u0001\u001a\u00020\\2\r\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020#0\u0016H\u0016J\t\u0010µ\u0001\u001a\u00020\\H\u0002R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020#0\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0002¢\u0006\f\n\u0004\b@\u0010,\u001a\u0004\b>\u0010?R\u000e\u0010A\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8BX\u0002¢\u0006\f\n\u0004\bG\u0010,\u001a\u0004\bE\u0010FR\u0010\u0010H\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010I\u001a\u00020J8BX\u0002¢\u0006\f\n\u0004\bM\u0010,\u001a\u0004\bK\u0010LR\u0010\u0010N\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u0002\n\u0000¨\u0006·\u0001"}, d2 = {"Lcom/baidu/searchbox/personal/PersonalMixFragment;", "Lcom/baidu/searchbox/appframework/fragment/HomeBaseFragment;", "Lcom/baidu/searchbox/personal/container/IPersonalizedContainerEventListener;", "Lcom/baidu/searchbox/account/IAccountStatusChangedListener;", "Lcom/baidu/searchbox/personal/manager/IPersonalizedDataListener;", "Lcom/baidu/searchbox/personalcenter/PersonalDataChangeCallback;", "Lcom/baidu/searchbox/personalcenter/personal/IPersonalizedContent;", "Lcom/baidu/searchbox/personal/feed/FeedTabUpdateCallback;", "()V", "PAGE_REFRESH_DATA_CHANNEL", "", "PAGE_SHOW_SKELETON_DATA_CHANNEL", "accountManager", "Lcom/baidu/searchbox/account/BoxAccountManager;", "curSelectedPage", "", "curTabId", "getCurTabId", "()Ljava/lang/String;", "setCurTabId", "(Ljava/lang/String;)V", "dynamicRefreshTabs", "", "emptyView", "Landroid/view/View;", "feedContainer", "Lcom/baidu/searchbox/feed/container/FeedContainer;", "feedView", "fromTabClick", "", "isFromMenu", "mCenterHeaderView", "Lcom/baidu/searchbox/personal/header/PersonMixCenterHeaderView;", "mHasTheme", "mHideTabList", "Lcom/baidu/searchbox/feed/tab/update/MultiTabItemInfo;", "mItemGroupAdapter", "Lcom/baidu/searchbox/newpersonalcenter/adapter/PersonalAdapterWithHeader;", "mLightStatusBar", "mListScrollListener", "Lcom/baidu/searchbox/personal/PersonalizedListScrollListener;", "getMListScrollListener", "()Lcom/baidu/searchbox/personal/PersonalizedListScrollListener;", "mListScrollListener$delegate", "Lkotlin/Lazy;", "mPageDurationUbc", "Lcom/baidu/searchbox/download/center/statistic/PersonalCenterDurationUbc;", "mPersonalEventListenerList", "Lcom/baidu/searchbox/personalcenter/listener/IPersonalEventListener;", "mPreActivityWidth", "mRestoredTabId", "mRootView", "mSidebarWindow", "Lcom/baidu/searchbox/personal/sidebar/SidebarWindowLayout;", "mSource", "getMSource", "setMSource", "mTabList", "mThemeApplyListener", "Lcom/baidu/searchbox/home/theme/IThemeApplyListener;", "mVerticalScrollUbcTrigger", "Lcom/baidu/searchbox/personal/NewVerticalScrollUbcTrigger;", "getMVerticalScrollUbcTrigger", "()Lcom/baidu/searchbox/personal/NewVerticalScrollUbcTrigger;", "mVerticalScrollUbcTrigger$delegate", "needToast", "notifyDataSetChangedCount", "personalPageRequest", "Lcom/baidu/searchbox/personal/fuse/PersonalCenterRequest;", "getPersonalPageRequest", "()Lcom/baidu/searchbox/personal/fuse/PersonalCenterRequest;", "personalPageRequest$delegate", "publishBubbleTitle", "publishConfigBubbleAnimationManager", "Lcom/baidu/searchbox/personal/publish/PublishConfigBubbleAnimationManager;", "getPublishConfigBubbleAnimationManager", "()Lcom/baidu/searchbox/personal/publish/PublishConfigBubbleAnimationManager;", "publishConfigBubbleAnimationManager$delegate", "publisherView", "sFirstResume", "sFirstShowBubble", "shutUpLayout", "slidingTabLayout", "Lcom/baidu/searchbox/feed/tab/SlidingTabLayout;", "tabPageFlow", "Lcom/baidu/ubc/Flow;", "topBackView", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "userEntity", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterFusionHomeModel;", "applyImmersion", "", "centerHeaderViewOnScrolled", "scrollY", "changeUseLightStatusBar", "lightStatusBar", "endTabFlow", "getBoxAccount", "Lcom/baidu/searchbox/account/data/BoxAccount;", "getPersonalPageId", "getPersonalPageId$lib_personal_center_release", "getUbcPage", "getUserType", "initFeed", "isCanScrollVertically", "direction", "notifyDataChange", "isOnlyRefreshCommonFun", "notifyDataSetChanged", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onFailedCallback", "failToast", "isInitLocalData", "onFontSizeChange", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLoadSucceedCallback", "dataWrapper", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterDataWrapper;", "onLoginStatusChanged", "oldStatus", "newStatus", "onNestedChildScrolled", "onNestedScrollStopped", "onNestedScrolling", "dy", "onNightModeChanged", "isNightMode", "onPause", "onPublishSucceed", "isVideo", "onResume", "onStart", "onStop", "publishConfigBubbleInAnimation", "onInAnimationEnd", "Lkotlin/Function0;", "publishConfigBubbleOutAnimation", "onOutAnimationEnd", "resetPublishIcon", "restoredTabId", "scrollContentBy", "selectTabById", "targetId", "smoothScroll", "setUserVisibleHint", "isVisibleToUser", "stableApiStub", "startTabContentFlow", "stopContentNestedScroll", "type", "tryAddPublisherView", "tryShowPersonalCenterBubbleGuide", "tryShowPublishConfigGuideBubble", "tryShowPublishIcon", "ubcExtBubbleJSONObject", "Lorg/json/JSONObject;", "updateFeed", "updateFeedNight", "updateFeedSize", "updateFeedTab", "tabList", "updateFeedTabs", "updateHideTab", "hideTabList", "useImmersion", "PersonalContainerDelegate", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalMixFragment.kt */
public final class PersonalMixFragment extends HomeBaseFragment implements IPersonalizedContainerEventListener, IAccountStatusChangedListener, IPersonalizedDataListener, PersonalDataChangeCallback, IPersonalizedContent, FeedTabUpdateCallback {
    private final String PAGE_REFRESH_DATA_CHANNEL = "com.baidu.personal.channel.page.refresh";
    private final String PAGE_SHOW_SKELETON_DATA_CHANNEL = "com.baidu.personal.channel.page.showSkeleton";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private BoxAccountManager accountManager;
    /* access modifiers changed from: private */
    public int curSelectedPage;
    private String curTabId = "main";
    private final List<String> dynamicRefreshTabs;
    private View emptyView;
    private FeedContainer feedContainer;
    private View feedView;
    private boolean fromTabClick;
    private boolean isFromMenu;
    /* access modifiers changed from: private */
    public PersonMixCenterHeaderView mCenterHeaderView;
    /* access modifiers changed from: private */
    public boolean mHasTheme;
    private List<? extends MultiTabItemInfo> mHideTabList = CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public PersonalAdapterWithHeader mItemGroupAdapter;
    private boolean mLightStatusBar;
    private final Lazy mListScrollListener$delegate = LazyKt.lazy(new PersonalMixFragment$mListScrollListener$2(this));
    private final PersonalCenterDurationUbc mPageDurationUbc = new PersonalCenterDurationUbc();
    private List<? extends IPersonalEventListener> mPersonalEventListenerList;
    private int mPreActivityWidth;
    private String mRestoredTabId = "";
    /* access modifiers changed from: private */
    public View mRootView;
    /* access modifiers changed from: private */
    public SidebarWindowLayout mSidebarWindow;
    private String mSource = "wode";
    /* access modifiers changed from: private */
    public List<? extends MultiTabItemInfo> mTabList = CollectionsKt.emptyList();
    private final IThemeApplyListener mThemeApplyListener = new PersonalMixFragment$mThemeApplyListener$1(this);
    private final Lazy mVerticalScrollUbcTrigger$delegate = LazyKt.lazy(PersonalMixFragment$mVerticalScrollUbcTrigger$2.INSTANCE);
    private boolean needToast;
    private int notifyDataSetChangedCount;
    private final Lazy personalPageRequest$delegate = LazyKt.lazy(PersonalMixFragment$personalPageRequest$2.INSTANCE);
    /* access modifiers changed from: private */
    public String publishBubbleTitle;
    private final Lazy publishConfigBubbleAnimationManager$delegate = LazyKt.lazy(PersonalMixFragment$publishConfigBubbleAnimationManager$2.INSTANCE);
    /* access modifiers changed from: private */
    public View publisherView;
    private boolean sFirstResume = true;
    /* access modifiers changed from: private */
    public boolean sFirstShowBubble = true;
    private View shutUpLayout;
    private SlidingTabLayout slidingTabLayout;
    private Flow tabPageFlow;
    private View topBackView;
    private final UBCManager ubcManager;
    private PersonalCenterFusionHomeModel userEntity;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View view3 = getView();
        if (view3 == null || (findViewById = view3.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public PersonalMixFragment() {
        Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
        this.ubcManager = (UBCManager) service;
        this.dynamicRefreshTabs = CollectionsKt.listOf("main", "image", "dynamic", "shipin");
    }

    private final NewVerticalScrollUbcTrigger getMVerticalScrollUbcTrigger() {
        return (NewVerticalScrollUbcTrigger) this.mVerticalScrollUbcTrigger$delegate.getValue();
    }

    private final PersonalizedListScrollListener getMListScrollListener() {
        return (PersonalizedListScrollListener) this.mListScrollListener$delegate.getValue();
    }

    public final String getMSource() {
        return this.mSource;
    }

    public final void setMSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSource = str;
    }

    /* access modifiers changed from: private */
    public final PublishConfigBubbleAnimationManager getPublishConfigBubbleAnimationManager() {
        return (PublishConfigBubbleAnimationManager) this.publishConfigBubbleAnimationManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PersonalCenterRequest getPersonalPageRequest() {
        return (PersonalCenterRequest) this.personalPageRequest$delegate.getValue();
    }

    @StableApi
    public final void stableApiStub() {
    }

    public void onStart() {
        super.onStart();
        FeedContainer feedContainer2 = this.feedContainer;
        if (feedContainer2 != null) {
            feedContainer2.onViewStart();
        }
        if (UpgradeMgr.INSTANCE.shouldCheckUpgrade$lib_personal_center_release()) {
            UpgradeMgr.INSTANCE.setCanShowEntranceBubble(true);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<IPersonalEventListener> $this$forEach$iv = PersonalCenterRuntime.getPersonalCenterContext().createCommonPersonalEventListenerList(this);
        this.mPersonalEventListenerList = $this$forEach$iv;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onCreate();
            }
        }
        BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        this.accountManager = boxAccountManager;
        if (boxAccountManager != null) {
            boxAccountManager.addLoginStatusChangedListener(this);
        }
        NightModeHelper.subscribeNightModeChangeEvent(this, this);
        SideBarDataProcessorKt.setMixPersonalCenter(true);
        PersonalizedDataManagerWrapper.INSTANCE.registerListener(this);
        boolean z = false;
        PersonalizedDataManagerWrapper.loadMixDataSync$default(PersonalizedDataManagerWrapper.INSTANCE, false, (String) null, 2, (Object) null);
        if (UpgradeMgr.INSTANCE.shouldCheckUpgrade$lib_personal_center_release()) {
            UpgradeMgr.INSTANCE.setCanShowEntranceBubble(true);
            UpgradeMgr.INSTANCE.registerCallback$lib_personal_center_release("personal_upgrade", new PersonalMixFragment$onCreate$2(this));
            UpgradeMgr.INSTANCE.checkUpgradeIfNeed$lib_personal_center_release(getActivity());
        }
        IHomeThemeFun iHomeThemeFun = (IHomeThemeFun) ServiceManager.getService(IHomeThemeFun.SERVICE_REFERENCE);
        if (iHomeThemeFun != null) {
            iHomeThemeFun.addThemeListener(this.mThemeApplyListener);
        }
        BdEventBus.Companion.getDefault().register(this, HomeTabClickEvent.class, 1, new PersonalMixFragment$$ExternalSyntheticLambda0(this));
        BdEventBus.Companion.getDefault().register(this, PersonalDataChangeEvent.class, 1, new PersonalMixFragment$$ExternalSyntheticLambda1(this));
        NewPersonalItemNewTip.getInstance().setTipChangeListener(this);
        Bundle arguments = getArguments();
        this.needToast = arguments != null ? arguments.getBoolean(PersonalActivity.NEED_SWITCH_TOAST) : false;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            z = arguments2.getBoolean(PersonalActivity.PERSONAL_IS_FROM_MENU);
        }
        this.isFromMenu = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m1989onCreate$lambda3(PersonalMixFragment this$0, HomeTabClickEvent homeTabClickEvent) {
        JSONArray rawTabsList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(homeTabClickEvent, "homeTabClickEvent");
        if (!ActivityUtils.isDestroyed(this$0.getActivity())) {
            boolean z = true;
            if (!Intrinsics.areEqual((Object) "Personal", (Object) homeTabClickEvent.mClickTabTag)) {
                FeedContainer feedContainer2 = this$0.feedContainer;
                String it = null;
                FeedBaseFragment currentFragment = feedContainer2 != null ? feedContainer2.getCurrentFragment() : null;
                IPagerView pageView = currentFragment != null ? currentFragment.getPagerViewImpl() : null;
                if (pageView instanceof PersonalCenterWebPageView) {
                    ((PersonalCenterWebPageView) pageView).showLoadingView();
                } else if (pageView instanceof CommonRefreshableListPage) {
                    ((CommonRefreshableListPage) pageView).showLoadingView();
                }
                if (currentFragment == null || !currentFragment.isRN()) {
                    z = false;
                }
                if (z) {
                    PersonalCenterFusionHomeModel personalCenterFusionHomeModel = this$0.userEntity;
                    if (!(personalCenterFusionHomeModel == null || (rawTabsList = personalCenterFusionHomeModel.getRawTabsList()) == null)) {
                        it = rawTabsList.toString();
                    }
                    DataChannel.Sender.sendBroadcast(this$0.getContext(), this$0.PAGE_SHOW_SKELETON_DATA_CHANNEL, it);
                }
            } else {
                this$0.fromTabClick = true;
            }
            Iterable<IPersonalEventListener> $this$forEach$iv = this$0.mPersonalEventListenerList;
            if ($this$forEach$iv != null) {
                for (IPersonalEventListener it2 : $this$forEach$iv) {
                    it2.homeTabClickEvent(homeTabClickEvent);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m1990onCreate$lambda4(PersonalMixFragment this$0, PersonalDataChangeEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        PersonalDataChangeCallback.DefaultImpls.notifyDataChange$default(this$0, false, 1, (Object) null);
        SidebarWindowLayout sidebarWindowLayout = this$0.mSidebarWindow;
        if (sidebarWindowLayout != null) {
            sidebarWindowLayout.setData(PersonalizedDataManagerWrapper.INSTANCE.getFusionSlideGroupData());
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout contentCountLayout;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        ImageView imageView2;
        ImageView imageView3;
        View findViewById;
        View findViewById2;
        GesturesRecyclerView gesturesRecyclerView;
        GesturesRecyclerView gesturesRecyclerView2;
        GesturesRecyclerView gesturesRecyclerView3;
        GesturesRecyclerView gesturesRecyclerView4;
        GesturesRecyclerView gesturesRecyclerView5;
        GesturesRecyclerView gesturesRecyclerView6;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ConstraintLayout constraintLayout2 = null;
        Context contextActual = container != null ? container.getContext() : null;
        if (contextActual == null) {
            return null;
        }
        if (this.mRootView == null) {
            this.mRootView = inflater.inflate(R.layout.personal_center_fuse_fragment, container, false);
            this.mItemGroupAdapter = new PersonalAdapterWithHeader(contextActual);
            View view2 = this.mRootView;
            if (!(view2 == null || (gesturesRecyclerView6 = (GesturesRecyclerView) view2.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
                gesturesRecyclerView6.setItemViewCacheSize(20);
            }
            View view3 = this.mRootView;
            if (!(view3 == null || (gesturesRecyclerView5 = (GesturesRecyclerView) view3.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
                gesturesRecyclerView5.setBackgroundColor(getResources().getColor(R.color.GC108));
            }
            View view4 = this.mRootView;
            GesturesRecyclerView gesturesRecyclerView7 = view4 != null ? (GesturesRecyclerView) view4.findViewById(R.id.personalCenterGesturesRecyclerView) : null;
            if (gesturesRecyclerView7 != null) {
                gesturesRecyclerView7.setLayoutManager(new CustomLinearLayoutManager(contextActual));
            }
            View view5 = this.mRootView;
            if (!(view5 == null || (gesturesRecyclerView4 = (GesturesRecyclerView) view5.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
                gesturesRecyclerView4.removeOnScrollListener(getMVerticalScrollUbcTrigger());
            }
            View view6 = this.mRootView;
            if (!(view6 == null || (gesturesRecyclerView3 = (GesturesRecyclerView) view6.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
                gesturesRecyclerView3.addOnScrollListener(getMVerticalScrollUbcTrigger());
            }
            View view7 = this.mRootView;
            if (!(view7 == null || (gesturesRecyclerView2 = (GesturesRecyclerView) view7.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
                gesturesRecyclerView2.removeOnScrollListener(getMListScrollListener());
            }
            View view8 = this.mRootView;
            if (!(view8 == null || (gesturesRecyclerView = (GesturesRecyclerView) view8.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
                gesturesRecyclerView.addOnScrollListener(getMListScrollListener());
            }
            PersonMixCenterHeaderView personMixCenterHeaderView = new PersonMixCenterHeaderView(getContext());
            this.mCenterHeaderView = personMixCenterHeaderView;
            PersonalAdapterWithHeader personalAdapterWithHeader = this.mItemGroupAdapter;
            if (personalAdapterWithHeader != null) {
                personalAdapterWithHeader.addHeaderView(personMixCenterHeaderView);
            }
            View view9 = this.mRootView;
            PersonalizedContainer personalizedContainer = view9 != null ? (PersonalizedContainer) view9.findViewById(R.id.personalizedContainer) : null;
            if (personalizedContainer != null) {
                personalizedContainer.setEventListener(this);
            }
            PersonalAdapterWithHeader personalAdapterWithHeader2 = this.mItemGroupAdapter;
            if (personalAdapterWithHeader2 != null) {
                personalAdapterWithHeader2.setModuleActionListener(new PersonalMixFragment$onCreateView$1(this));
            }
            PersonalAdapterWithHeader personalAdapterWithHeader3 = this.mItemGroupAdapter;
            if (personalAdapterWithHeader3 != null) {
                personalAdapterWithHeader3.setData(PersonalizedDataManagerWrapper.INSTANCE.getMixFusionData());
            }
            View view10 = this.mRootView;
            GesturesRecyclerView gesturesRecyclerView8 = view10 != null ? (GesturesRecyclerView) view10.findViewById(R.id.personalCenterGesturesRecyclerView) : null;
            if (gesturesRecyclerView8 != null) {
                gesturesRecyclerView8.setAdapter(this.mItemGroupAdapter);
            }
            View view11 = this.mRootView;
            if (!(view11 == null || (findViewById2 = view11.findViewById(R.id.personalizedStatusBarBackground)) == null)) {
                findViewById2.setBackgroundColor(getResources().getColor(R.color.GC9));
            }
            View view12 = this.mRootView;
            ViewGroup.LayoutParams layoutParams = (view12 == null || (findViewById = view12.findViewById(R.id.personalizedStatusBarBackground)) == null) ? null : findViewById.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = DeviceUtils.ScreenInfo.getStatusBarHeight();
            }
            initFeed();
            View view13 = this.mRootView;
            PersonalizedContainer personalizedContainer2 = view13 != null ? (PersonalizedContainer) view13.findViewById(R.id.personalizedContainer) : null;
            if (personalizedContainer2 != null) {
                personalizedContainer2.setMIPersonalizedContent(this);
            }
            View view14 = this.mRootView;
            if (!(view14 == null || (imageView3 = (ImageView) view14.findViewById(R.id.tab_search_view)) == null)) {
                imageView3.setOnClickListener(new PersonalMixFragment$$ExternalSyntheticLambda2(this));
            }
            View view15 = this.mRootView;
            if (!(view15 == null || (imageView2 = (ImageView) view15.findViewById(R.id.publish_icon)) == null)) {
                imageView2.setImageResource(R.drawable.personal_publish_icon);
            }
            if (this.isFromMenu) {
                View view16 = this.mRootView;
                ViewGroup.LayoutParams layoutParams2 = (view16 == null || (constraintLayout = (ConstraintLayout) view16.findViewById(R.id.publish_icon_layout)) == null) ? null : constraintLayout.getLayoutParams();
                RelativeLayout.LayoutParams publishParams = layoutParams2 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams2 : null;
                if (publishParams != null) {
                    publishParams.setMargins(0, 0, DeviceUtils.ScreenInfo.dp2px(getContext(), 14.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 24.0f));
                }
                View view17 = this.mRootView;
                if (view17 != null) {
                    constraintLayout2 = (ConstraintLayout) view17.findViewById(R.id.publish_icon_layout);
                }
                if (constraintLayout2 != null) {
                    constraintLayout2.setLayoutParams(publishParams);
                }
            }
            View view18 = this.mRootView;
            if (!(view18 == null || (imageView = (ImageView) view18.findViewById(R.id.publish_icon)) == null)) {
                imageView.setOnClickListener(new PersonalMixFragment$$ExternalSyntheticLambda3(this));
            }
            this.publisherView = PublishHelper.INSTANCE.initPublishProgressContainer(getContext(), this, new PersonalMixFragment$onCreateView$4(this), new PersonalMixFragment$onCreateView$5(this), new PersonalMixFragment$onCreateView$6(this));
        }
        PersonMixCenterHeaderView personMixCenterHeaderView2 = this.mCenterHeaderView;
        if (!(personMixCenterHeaderView2 == null || (contentCountLayout = personMixCenterHeaderView2.getContentCountLayout()) == null)) {
            contentCountLayout.setOnClickListener(new PersonalMixFragment$$ExternalSyntheticLambda4(this));
        }
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onCreateView();
            }
        }
        if (immersionEnabled()) {
            this.mRootView = initImmersion(this.mRootView);
        }
        return this.mRootView;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-5  reason: not valid java name */
    public static final void m1991onCreateView$lambda5(PersonalMixFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringBuilder append = new StringBuilder().append(HostConfig.getSearchboxHostForHttps()).append("/webpage?type=newhome&action=searchpage&uk=");
        BoxAccount boxAccount = this$0.getBoxAccount();
        Router.invoke(this$0.getContext(), "baiduboxapp://v1/easybrowse/open?url=" + URLEncoder.encode(append.append(boxAccount != null ? boxAccount.getUk() : null).toString(), "UTF-8") + "&style={\"toolbaricons\":{\"tids\":[\"3\"]}}&newbrowser=1");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-6  reason: not valid java name */
    public static final void m1992onCreateView$lambda6(PersonalMixFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isDetached() && this$0.getContext() != null) {
            PersonCenterUBCStatistic.statisticUBCWithoutSource("fabu", "click", (JSONObject) null, "wode", "192", PersonalConstants.PAGE_ZHUYE);
            PublishHelper.INSTANCE.onPublishIconClick(this$0.getContext());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-7  reason: not valid java name */
    public static final void m1993onCreateView$lambda7(PersonalMixFragment this$0, View it) {
        PersonalizedContainer personalizedContainer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.mRootView;
        if (!(view2 == null || (personalizedContainer = (PersonalizedContainer) view2.findViewById(R.id.personalizedContainer)) == null)) {
            personalizedContainer.scrollToTop();
        }
        if (this$0.mHasTheme) {
            this$0.changeUseLightStatusBar(true);
        }
        View view3 = this$0.mRootView;
        View findViewById = view3 != null ? view3.findViewById(R.id.personalizedStatusBarBackground) : null;
        if (findViewById != null) {
            findViewById.setAlpha(1.0f);
        }
        PersonCenterUBCStatistic.statisticUBC(PersonalConstants.NEI_RONG, (String) null, "wode", "179");
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onActivityCreated(savedInstanceState);
            }
        }
        if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
            FragmentActivity activity = getActivity();
            this.topBackView = activity != null ? activity.findViewById(com.baidu.searchbox.common.unifiedtoolbar.R.id.unified_top_back) : null;
        }
    }

    public void onResume() {
        GesturesRecyclerView gesturesRecyclerView;
        super.onResume();
        PersonalCenterStateUtils.INSTANCE.setPersonalFragmentVisible(true);
        if (!this.sFirstResume) {
            PersonalizedDataManagerWrapper.loadMixDataSync$default(PersonalizedDataManagerWrapper.INSTANCE, false, (String) null, 2, (Object) null);
            if (UpgradeMgr.INSTANCE.shouldCheckUpgrade$lib_personal_center_release()) {
                UpgradeMgr.INSTANCE.checkUpgradeIfNeed$lib_personal_center_release(getActivity());
            }
        }
        if (!this.sFirstResume) {
            applyImmersion();
        }
        if (this.sFirstResume) {
            this.sFirstResume = false;
        }
        this.mPreActivityWidth = PersonalCenterUtils.getActivityWidth(getActivity());
        View view2 = this.mRootView;
        if (!(view2 == null || (gesturesRecyclerView = (GesturesRecyclerView) view2.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
            gesturesRecyclerView.setBackgroundColor(getResources().getColor(R.color.GC108));
        }
        PersonMixCenterHeaderView personMixCenterHeaderView = this.mCenterHeaderView;
        if (personMixCenterHeaderView != null) {
            personMixCenterHeaderView.onResume();
        }
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onResume();
            }
        }
        FeedContainer feedContainer2 = this.feedContainer;
        if (feedContainer2 != null) {
            feedContainer2.onViewResume();
        }
        getMVerticalScrollUbcTrigger().setVisible(true);
        this.mPageDurationUbc.beginDurationFlow("my_home");
        PersonalCenterUbc.showPersonalMixPageUbc(this.mSource, getContext());
        startTabContentFlow();
        if (this.needToast) {
            Context it2 = getContext();
            if (it2 != null) {
                UniversalToast.makeText(it2, (CharSequence) getString(R.string.personal_change_to_mix)).setOverFloatWindow(true).show();
            }
            this.needToast = false;
        }
    }

    public void onPause() {
        super.onPause();
        PersonalizedDataManagerWrapper.INSTANCE.setMIsRequestReturn(false);
        if (UpgradeMgr.INSTANCE.getUpgradeCheckResult$lib_personal_center_release() == null) {
            UpgradeMgr.INSTANCE.setUpgradeResultReturn(false);
        }
        BubbleGuideManager.INSTANCE.dismissBubble();
        this.fromTabClick = false;
        PersonalCenterStateUtils.INSTANCE.setPersonalFragmentVisible(false);
        PersonMixCenterHeaderView personMixCenterHeaderView = this.mCenterHeaderView;
        if (personMixCenterHeaderView != null) {
            personMixCenterHeaderView.onPause();
        }
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onPause();
            }
        }
        FeedContainer feedContainer2 = this.feedContainer;
        if (feedContainer2 != null) {
            feedContainer2.onViewPause();
        }
        getMVerticalScrollUbcTrigger().setVisible(false);
        this.mPageDurationUbc.endDurationFlow("my_home");
        endTabFlow();
    }

    public void onStop() {
        super.onStop();
        PersonMixCenterHeaderView personMixCenterHeaderView = this.mCenterHeaderView;
        if (personMixCenterHeaderView != null) {
            personMixCenterHeaderView.onStop();
        }
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onStop();
            }
        }
        getMVerticalScrollUbcTrigger().clear();
        FeedContainer feedContainer2 = this.feedContainer;
        if (feedContainer2 != null) {
            feedContainer2.onViewStop();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDestroy() {
        super.onDestroy();
        this.sFirstResume = true;
        this.sFirstShowBubble = false;
        PersonMixCenterHeaderView personMixCenterHeaderView = this.mCenterHeaderView;
        if (personMixCenterHeaderView != null) {
            personMixCenterHeaderView.onDestroy();
        }
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onDestroy();
            }
        }
        BoxAccountManager boxAccountManager = this.accountManager;
        if (boxAccountManager != null) {
            boxAccountManager.removeLoginStatusChangedListener(this);
        }
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        IHomeThemeFun iHomeThemeFun = (IHomeThemeFun) ServiceManager.getService(IHomeThemeFun.SERVICE_REFERENCE);
        if (iHomeThemeFun != null) {
            iHomeThemeFun.removeThemeListener(this.mThemeApplyListener);
        }
        PopupExclusionManagerMap.getInstance().remove(PopupExclusionManagerMap.SCENE_MY);
        BdEventBus.Companion.getDefault().unregister(this);
        PersonalAdapterWithHeader personalAdapterWithHeader = this.mItemGroupAdapter;
        if (personalAdapterWithHeader != null) {
            personalAdapterWithHeader.setModuleActionListener((ModuleActionListener) null);
        }
        PersonalizedDataManagerWrapper.INSTANCE.unregisterListener(this);
        PersonalCenterNaUbcUtils.INSTANCE.clearUbcRecord();
        FeedContainer feedContainer2 = this.feedContainer;
        if (feedContainer2 != null) {
            feedContainer2.onViewDestroy();
        }
        UpgradeMgr.INSTANCE.removeCallback$lib_personal_center_release("personal_upgrade");
        SidebarWindowLayout sidebarWindowLayout = this.mSidebarWindow;
        if (sidebarWindowLayout != null) {
            sidebarWindowLayout.setDimissCallback((Function0<Unit>) null);
        }
        getPublishConfigBubbleAnimationManager().stopAnimation();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int activityWidth = PersonalCenterUtils.getActivityWidth(getActivity());
        if (activityWidth != this.mPreActivityWidth) {
            this.mPreActivityWidth = activityWidth;
            View view2 = this.mRootView;
            GesturesRecyclerView gesturesRecyclerView = view2 != null ? (GesturesRecyclerView) view2.findViewById(R.id.personalCenterGesturesRecyclerView) : null;
            if (gesturesRecyclerView != null) {
                gesturesRecyclerView.setAdapter(this.mItemGroupAdapter);
            }
            SidebarWindowLayout sidebarWindowLayout = this.mSidebarWindow;
            if (sidebarWindowLayout != null) {
                sidebarWindowLayout.updateScreenChange();
            }
        }
    }

    public void onLoginStatusChanged(boolean oldStatus, boolean newStatus) {
        MultiTabItemInfo curTabItem;
        PersonalizedDataManagerWrapper.INSTANCE.onLoginStatusChanged();
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onLoginStatusChanged();
            }
        }
        SidebarWindowLayout sidebarWindowLayout = this.mSidebarWindow;
        if (sidebarWindowLayout != null) {
            sidebarWindowLayout.dismissView();
        }
        this.mTabList = new FeedViewHelper().createDefaultFeedTabs();
        if (LoginUtilKt.isLogin$default(false, 1, (Object) null) && (curTabItem = (MultiTabItemInfo) CollectionsKt.firstOrNull(this.mTabList)) != null) {
            curTabItem.clearCachePageWhenUpdate = true;
        }
        updateFeedTabs();
        if (LoginUtilKt.isLogin$default(false, 1, (Object) null)) {
            PersonalizedDataManagerWrapper.loadMixDataSync$default(PersonalizedDataManagerWrapper.INSTANCE, false, (String) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void applyImmersion() {
        useImmersion();
    }

    private final void useImmersion() {
        FragmentActivity activity;
        PersonalizedContainer personalizedContainer;
        int statusBarAnimEnd = 0;
        boolean isLightStatusBar = !this.mHasTheme && !NightModeHelper.getNightModeSwitcherState();
        this.mLightStatusBar = isLightStatusBar;
        setEnableImmerison(true);
        if (immersionEnabled() && (activity = getActivity()) != null) {
            if (this.mImmersionHelper == null) {
                this.mImmersionHelper = new ImmersionHelper(activity);
            }
            this.mImmersionHelper.getConfig().setIsShowStatusBar(false);
            View view2 = this.mRootView;
            int rootScrollY = (view2 == null || (personalizedContainer = (PersonalizedContainer) view2.findViewById(R.id.personalizedContainer)) == null) ? 0 : personalizedContainer.getScrollY();
            PersonMixCenterHeaderView personMixCenterHeaderView = this.mCenterHeaderView;
            if (personMixCenterHeaderView != null) {
                statusBarAnimEnd = personMixCenterHeaderView.getStatusBarAnimEnd();
            }
            if (rootScrollY == 0 || statusBarAnimEnd == 0 || rootScrollY < statusBarAnimEnd || !this.mHasTheme) {
                this.mImmersionHelper.getConfig().setUseLightStatusBar(isLightStatusBar);
            } else {
                changeUseLightStatusBar(true);
            }
            this.mImmersionHelper.setImmersion();
            ((BaseActivity) activity).setImmersionHelper(this.mImmersionHelper);
        }
    }

    private final void changeUseLightStatusBar(boolean lightStatusBar) {
        FragmentActivity activity;
        if (this.mLightStatusBar != lightStatusBar && this.mImmersionHelper != null && (activity = getActivity()) != null) {
            this.mImmersionHelper.getConfig().setUseLightStatusBar(lightStatusBar && !NightModeHelper.isNightMode());
            ((BaseActivity) activity).setImmersionHelper(this.mImmersionHelper);
            this.mLightStatusBar = lightStatusBar;
        }
    }

    private final void centerHeaderViewOnScrolled(int scrollY) {
        PersonMixCenterHeaderView personMixCenterHeaderView = this.mCenterHeaderView;
        if (personMixCenterHeaderView != null) {
            if (personMixCenterHeaderView != null) {
                personMixCenterHeaderView.onScrolled(scrollY);
            }
            PersonMixCenterHeaderView personMixCenterHeaderView2 = this.mCenterHeaderView;
            int loginViewAnimEnd = personMixCenterHeaderView2 != null ? personMixCenterHeaderView2.getHeaderLoginViewAnimEnd() : 0;
            PersonMixCenterHeaderView personMixCenterHeaderView3 = this.mCenterHeaderView;
            int statusBarAnimEnd = personMixCenterHeaderView3 != null ? personMixCenterHeaderView3.getStatusBarAnimEnd() : 0;
            int distance = statusBarAnimEnd - loginViewAnimEnd;
            View view2 = null;
            if (scrollY < loginViewAnimEnd) {
                View view3 = this.mRootView;
                if (view3 != null) {
                    view2 = view3.findViewById(R.id.personalizedStatusBarBackground);
                }
                if (view2 != null) {
                    view2.setAlpha(0.0f);
                }
            } else if (scrollY <= statusBarAnimEnd) {
                float rate = ((float) (scrollY - loginViewAnimEnd)) / (((float) distance) * 1.0f);
                View view4 = this.mRootView;
                if (view4 != null) {
                    view2 = view4.findViewById(R.id.personalizedStatusBarBackground);
                }
                if (view2 != null) {
                    view2.setAlpha(rate);
                }
            } else {
                View view5 = this.mRootView;
                if (view5 != null) {
                    view2 = view5.findViewById(R.id.personalizedStatusBarBackground);
                }
                if (view2 != null) {
                    view2.setAlpha(1.0f);
                }
            }
            if (this.mHasTheme) {
                if (scrollY >= statusBarAnimEnd) {
                    changeUseLightStatusBar(true);
                } else {
                    changeUseLightStatusBar(false);
                }
            }
            PersonMixCenterHeaderView personMixCenterHeaderView4 = this.mCenterHeaderView;
            if (scrollY < (personMixCenterHeaderView4 != null ? personMixCenterHeaderView4.getMHeaderOtherViewAnimEnd() : 0)) {
                View view6 = this.topBackView;
                if (view6 != null) {
                    view6.setVisibility(8);
                    return;
                }
                return;
            }
            View view7 = this.topBackView;
            if (view7 != null) {
                view7.setVisibility(0);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r0 = (com.baidu.searchbox.personal.container.PersonalizedContainer) r0.findViewById(com.baidu.searchbox.personalcenter.R.id.personalizedContainer);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNestedScrolling(int r7) {
        /*
            r6 = this;
            java.util.List<? extends com.baidu.searchbox.personalcenter.listener.IPersonalEventListener> r0 = r6.mPersonalEventListenerList
            if (r0 == 0) goto L_0x001e
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x000b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x001d
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.baidu.searchbox.personalcenter.listener.IPersonalEventListener r4 = (com.baidu.searchbox.personalcenter.listener.IPersonalEventListener) r4
            r5 = 0
            r4.onNestedScrolling(r7)
            goto L_0x000b
        L_0x001d:
        L_0x001e:
            android.view.View r0 = r6.mRootView
            r1 = 0
            if (r0 == 0) goto L_0x0032
            int r2 = com.baidu.searchbox.personalcenter.R.id.personalizedContainer
            android.view.View r0 = r0.findViewById(r2)
            com.baidu.searchbox.personal.container.PersonalizedContainer r0 = (com.baidu.searchbox.personal.container.PersonalizedContainer) r0
            if (r0 == 0) goto L_0x0032
            int r0 = r0.getScrollY()
            goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            com.baidu.searchbox.personal.header.PersonMixCenterHeaderView r2 = r6.mCenterHeaderView
            if (r2 == 0) goto L_0x003b
            int r1 = r2.getMeasuredHeight()
        L_0x003b:
            if (r0 >= r1) goto L_0x0048
            r6.centerHeaderViewOnScrolled(r0)
            com.baidu.searchbox.personal.header.PersonMixCenterHeaderView r1 = r6.mCenterHeaderView
            if (r1 == 0) goto L_0x0064
            r1.disMissBubble()
            goto L_0x0064
        L_0x0048:
            boolean r1 = r6.mHasTheme
            if (r1 == 0) goto L_0x0050
            r1 = 1
            r6.changeUseLightStatusBar(r1)
        L_0x0050:
            android.view.View r1 = r6.mRootView
            if (r1 == 0) goto L_0x005b
            int r2 = com.baidu.searchbox.personalcenter.R.id.personalizedStatusBarBackground
            android.view.View r1 = r1.findViewById(r2)
            goto L_0x005c
        L_0x005b:
            r1 = 0
        L_0x005c:
            if (r1 != 0) goto L_0x005f
            goto L_0x0064
        L_0x005f:
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r2)
        L_0x0064:
            com.baidu.searchbox.personal.bubble.BubbleGuideManager r1 = com.baidu.searchbox.personal.bubble.BubbleGuideManager.INSTANCE
            r1.dismissBubble()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.PersonalMixFragment.onNestedScrolling(int):void");
    }

    public void onNestedChildScrolled() {
    }

    public void onNestedScrollStopped() {
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onNestedScrollStopped();
            }
        }
    }

    public void onLoadSucceedCallback(PersonalCenterDataWrapper dataWrapper, boolean isInitLocalData) {
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onPersonalizedDataChanged();
            }
        }
        if (isInitLocalData) {
            PersonalAdapterWithHeader personalAdapterWithHeader = this.mItemGroupAdapter;
            if (personalAdapterWithHeader != null) {
                personalAdapterWithHeader.setData(PersonalizedDataManagerWrapper.INSTANCE.getMixFusionData());
            }
            PersonalAdapterWithHeader personalAdapterWithHeader2 = this.mItemGroupAdapter;
            if (personalAdapterWithHeader2 != null) {
                personalAdapterWithHeader2.notifyDataSetChanged();
            }
        } else {
            notifyDataSetChanged();
        }
        updateFeed(isInitLocalData);
        UiThreadUtils.runOnUiThread(new PersonalMixFragment$$ExternalSyntheticLambda8(this), 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: onLoadSucceedCallback$lambda-20  reason: not valid java name */
    public static final void m1994onLoadSucceedCallback$lambda20(PersonalMixFragment this$0) {
        View view2;
        GesturesRecyclerView it;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded() && this$0.isVisible() && (view2 = this$0.mRootView) != null && (it = (GesturesRecyclerView) view2.findViewById(R.id.personalCenterGesturesRecyclerView)) != null) {
            this$0.getMVerticalScrollUbcTrigger().refreshStatistic(it);
        }
    }

    public void onFailedCallback(String failToast, boolean isInitLocalData) {
        Intrinsics.checkNotNullParameter(failToast, "failToast");
        if (!TextUtils.isEmpty(failToast)) {
            UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) failToast).show();
        }
        updateFeed(false);
        if (!isInitLocalData) {
            BubbleGuideManager.INSTANCE.parseBubbleData((JSONObject) null);
        }
        if (!PersonalizedDataManagerWrapper.INSTANCE.getMIsRequestReturn()) {
            return;
        }
        if (!UpgradeMgr.INSTANCE.shouldCheckUpgrade$lib_personal_center_release() || UpgradeMgr.INSTANCE.isUpgradeResultReturn()) {
            tryShowPersonalCenterBubbleGuide();
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        GesturesRecyclerView gesturesRecyclerView;
        View findViewById;
        super.onNightModeChanged(isNightMode);
        PersonMixCenterHeaderView personMixCenterHeaderView = this.mCenterHeaderView;
        if (personMixCenterHeaderView != null) {
            personMixCenterHeaderView.onNightModeChanged(isNightMode);
        }
        View view2 = this.mRootView;
        if (!(view2 == null || (findViewById = view2.findViewById(R.id.personalizedStatusBarBackground)) == null)) {
            findViewById.setBackgroundColor(getResources().getColor(R.color.GC9));
        }
        View view3 = this.mRootView;
        if (!(view3 == null || (gesturesRecyclerView = (GesturesRecyclerView) view3.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
            gesturesRecyclerView.setBackgroundColor(getResources().getColor(R.color.GC108));
        }
        PersonalizedDataManagerWrapper.INSTANCE.getManager().updateNightModeData(isNightMode, new PersonalMixFragment$onNightModeChanged$1(this));
        updateFeedNight();
        PublishHelper.INSTANCE.updatePublishNight();
    }

    public void notifyDataChange(boolean isOnlyRefreshCommonFun) {
        notifyDataSetChanged();
    }

    private final void notifyDataSetChanged() {
        this.notifyDataSetChangedCount++;
        if (AppConfig.isDebug()) {
            Log.d("NewPersonal", "notifyDataSetChangedCount" + this.notifyDataSetChangedCount);
        }
        UiThreadUtils.runOnUiThread(new PersonalMixFragment$$ExternalSyntheticLambda7(this), 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: notifyDataSetChanged$lambda-22  reason: not valid java name */
    public static final void m1987notifyDataSetChanged$lambda22(PersonalMixFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.notifyDataSetChangedCount == 1) {
            if (AppConfig.isDebug()) {
                Log.d("NewPersonal", "notifyDataSetChangedCount = 1 可以刷新");
            }
            this$0.notifyDataSetChangedCount = 0;
            PersonalAdapterWithHeader personalAdapterWithHeader = this$0.mItemGroupAdapter;
            if (personalAdapterWithHeader != null) {
                personalAdapterWithHeader.setData(PersonalizedDataManagerWrapper.INSTANCE.getMixFusionData());
            }
            PersonalAdapterWithHeader personalAdapterWithHeader2 = this$0.mItemGroupAdapter;
            if (personalAdapterWithHeader2 != null) {
                personalAdapterWithHeader2.notifyDataSetChanged();
            }
            if (PersonalizedDataManagerWrapper.INSTANCE.getMIsRequestReturn()) {
                UiThreadUtils.getMainHandler().post(new PersonalMixFragment$$ExternalSyntheticLambda9(this$0));
                return;
            }
            return;
        }
        if (AppConfig.isDebug()) {
            Log.d("NewPersonal", "notifyDataSetChangedCount 不等于 1 等待下次刷新");
        }
        int i2 = this$0.notifyDataSetChangedCount;
        if (i2 > 0) {
            this$0.notifyDataSetChangedCount = i2 - 1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: notifyDataSetChanged$lambda-22$lambda-21  reason: not valid java name */
    public static final void m1988notifyDataSetChanged$lambda22$lambda21(PersonalMixFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!UpgradeMgr.INSTANCE.shouldCheckUpgrade$lib_personal_center_release() || UpgradeMgr.INSTANCE.isUpgradeResultReturn()) {
            this$0.tryShowPersonalCenterBubbleGuide();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        SidebarWindowLayout sidebarWindowLayout;
        if (keyCode == 4 && (sidebarWindowLayout = this.mSidebarWindow) != null) {
            boolean z = false;
            if (sidebarWindowLayout != null && sidebarWindowLayout.getMIsShowing()) {
                z = true;
            }
            if (z) {
                SidebarWindowLayout sidebarWindowLayout2 = this.mSidebarWindow;
                if (sidebarWindowLayout2 != null) {
                    sidebarWindowLayout2.dismissView();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onFontSizeChange() {
        PersonalAdapterWithHeader personalAdapterWithHeader = this.mItemGroupAdapter;
        if (personalAdapterWithHeader != null) {
            personalAdapterWithHeader.notifyDataSetChanged();
        }
        SidebarWindowLayout sidebarWindowLayout = this.mSidebarWindow;
        if (sidebarWindowLayout != null) {
            sidebarWindowLayout.updateUI();
        }
        updateFeedSize();
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        SidebarWindowLayout sidebarWindowLayout;
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser && (sidebarWindowLayout = this.mSidebarWindow) != null) {
            sidebarWindowLayout.dismissView();
        }
    }

    private final void initFeed() {
        FrameLayout frameLayout;
        View view2;
        FrameLayout frameLayout2;
        LinearLayout linearLayout;
        if (!isDetached() && getContext() != null) {
            Context mContext = getContext();
            if (mContext != null) {
                if (this.slidingTabLayout == null) {
                    SlidingTabLayout $this$initFeed_u24lambda_u2d27_u24lambda_u2d23 = new SlidingTabLayout(mContext);
                    $this$initFeed_u24lambda_u2d27_u24lambda_u2d23.setIsResponseFontSize(true);
                    this.slidingTabLayout = $this$initFeed_u24lambda_u2d27_u24lambda_u2d23;
                    $this$initFeed_u24lambda_u2d27_u24lambda_u2d23.setSmoothScroll(false);
                    SlidingTabLayout slidingTabLayout2 = this.slidingTabLayout;
                    if (slidingTabLayout2 != null) {
                        slidingTabLayout2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.personal_page_sliding_tab_bg, (Resources.Theme) null));
                    }
                    SlidingTabLayout slidingTabLayout3 = this.slidingTabLayout;
                    ViewParent parent = slidingTabLayout3 != null ? slidingTabLayout3.getParent() : null;
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(this.slidingTabLayout);
                    }
                    View view3 = this.mRootView;
                    if (!(view3 == null || (linearLayout = (LinearLayout) view3.findViewById(R.id.tab_container)) == null)) {
                        LinearLayout.LayoutParams $this$initFeed_u24lambda_u2d27_u24lambda_u2d24 = new LinearLayout.LayoutParams(0, -2);
                        $this$initFeed_u24lambda_u2d27_u24lambda_u2d24.weight = 1.0f;
                        Unit unit = Unit.INSTANCE;
                        linearLayout.addView(this.slidingTabLayout, 0, $this$initFeed_u24lambda_u2d27_u24lambda_u2d24);
                    }
                    SlidingTabLayout slidingTabLayout4 = this.slidingTabLayout;
                    if (slidingTabLayout4 != null) {
                        slidingTabLayout4.setTabClickListener(new PersonalMixFragment$$ExternalSyntheticLambda5(this));
                    }
                }
                if (this.feedContainer == null) {
                    if (this.mTabList.isEmpty()) {
                        this.mTabList = new FeedViewHelper().createDefaultFeedTabs();
                    }
                    FeedContainer.Builder context = new FeedContainer.Builder().context(mContext);
                    FragmentManager childFragmentManager = getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    FeedContainer.Builder containerDelegate = context.fragmentManager(childFragmentManager).tabList(this.mTabList).containerDelegate(new PersonalContainerDelegate());
                    PersonalCenterViewCreator $this$initFeed_u24lambda_u2d27_u24lambda_u2d26 = new PersonalCenterViewCreator();
                    $this$initFeed_u24lambda_u2d27_u24lambda_u2d26.setPersonalPageFragment(this);
                    Unit unit2 = Unit.INSTANCE;
                    this.feedContainer = containerDelegate.pageViewCreator($this$initFeed_u24lambda_u2d27_u24lambda_u2d26).loadingViewCreator(new PersonalMixFragment$initFeed$1$5()).build();
                }
                FeedContainer feedContainer2 = this.feedContainer;
                this.feedView = feedContainer2 != null ? feedContainer2.createView() : null;
                FeedContainer feedContainer3 = this.feedContainer;
                TabViewPager viewPager = feedContainer3 != null ? feedContainer3.getViewPager() : null;
                if (viewPager != null) {
                    viewPager.setId(R.id.personal_fuse_feed_viewpager);
                }
                if (!(this.feedView == null || (view2 = this.mRootView) == null || (frameLayout2 = (FrameLayout) view2.findViewById(R.id.content_layout)) == null)) {
                    frameLayout2.addView(this.feedView, -1, -2);
                }
                SlidingTabLayout slidingTabLayout5 = this.slidingTabLayout;
                if (slidingTabLayout5 != null) {
                    slidingTabLayout5.setViewPager(viewPager);
                }
                if (this.emptyView == null) {
                    this.emptyView = LayoutInflater.from(getContext()).inflate(R.layout.personal_mix_empty_feed, (ViewGroup) null, false);
                }
                int height = (DeviceUtils.ScreenInfo.getRealScreenHeight(getContext()) - DeviceUtils.ScreenInfo.getStatusBarHeight()) - DeviceUtils.ScreenInfo.dp2px(getContext(), 80.0f);
                View view4 = this.emptyView;
                ViewParent parent2 = view4 != null ? view4.getParent() : null;
                ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.emptyView);
                }
                View view5 = this.mRootView;
                if (!(view5 == null || (frameLayout = (FrameLayout) view5.findViewById(R.id.content_layout)) == null)) {
                    frameLayout.addView(this.emptyView, new FrameLayout.LayoutParams(-1, height));
                }
            }
            View view6 = this.mRootView;
            PersonalizedContainer personalizedContainer = view6 != null ? (PersonalizedContainer) view6.findViewById(R.id.personalizedContainer) : null;
            if (personalizedContainer != null) {
                View view7 = this.mRootView;
                personalizedContainer.setMTabBarView(view7 != null ? (LinearLayout) view7.findViewById(R.id.feed_header_container) : null);
            }
            if (LoginUtilKt.isLogin$default(false, 1, (Object) null)) {
                View view8 = this.feedView;
                if (view8 != null) {
                    view8.setVisibility(0);
                }
                View view9 = this.emptyView;
                if (view9 != null) {
                    view9.setVisibility(8);
                }
            } else {
                View view10 = this.feedView;
                if (view10 != null) {
                    view10.setVisibility(8);
                }
                View view11 = this.emptyView;
                if (view11 != null) {
                    view11.setVisibility(0);
                }
            }
            updateFeedSize();
            updateFeedNight();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initFeed$lambda-27$lambda-25  reason: not valid java name */
    public static final void m1986initFeed$lambda27$lambda25(PersonalMixFragment this$0, int position) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.curSelectedPage == position) {
            FeedContainer feedContainer2 = this$0.feedContainer;
            IPagerView pageView = null;
            FeedBaseFragment currentFragment = feedContainer2 != null ? feedContainer2.getCurrentFragment() : null;
            if (currentFragment != null) {
                pageView = currentFragment.getPagerViewImpl();
            }
            if (pageView instanceof CommonRefreshableListPage) {
                ((CommonRefreshableListPage) pageView).scrollToTop();
            } else if (pageView instanceof PersonalCenterWebPageView) {
                ((PersonalCenterWebPageView) pageView).scrollToTop();
            } else {
                boolean z = true;
                if (currentFragment == null || !currentFragment.isRN()) {
                    z = false;
                }
                if (z && (recyclerView = new FeedViewHelper().findVerticalScrollableViewByBFS(currentFragment.getRootView())) != null) {
                    recyclerView.scrollToPosition(0);
                }
            }
        }
    }

    private final void updateFeedNight() {
        View view2;
        TextView textView;
        ImageView imageView;
        TextView textView2;
        View findViewById;
        ImageView imageView2;
        TextView textView3;
        BdBaseImageView bdBaseImageView;
        ImageView imageView3;
        ImageView imageView4;
        Context it = getContext();
        if (it != null) {
            View view3 = this.mRootView;
            View view4 = null;
            CustomRelativeLayout customRelativeLayout = view3 != null ? (CustomRelativeLayout) view3.findViewById(R.id.personalizedRootView) : null;
            if (customRelativeLayout != null) {
                customRelativeLayout.setBackground(ContextCompat.getDrawable(it, com.baidu.android.common.ui.style.R.color.GC108));
            }
            View view5 = this.mRootView;
            MixNestedScrollView mixNestedScrollView = view5 != null ? (MixNestedScrollView) view5.findViewById(R.id.feed_nest_container) : null;
            if (mixNestedScrollView != null) {
                mixNestedScrollView.setBackground(ContextCompat.getDrawable(it, R.drawable.personal_page_sliding_tab_bg));
            }
            View view6 = this.mRootView;
            LinearLayout linearLayout = view6 != null ? (LinearLayout) view6.findViewById(R.id.feed_header_container) : null;
            if (linearLayout != null) {
                linearLayout.setBackground(ContextCompat.getDrawable(it, R.drawable.personal_page_sliding_tab_bg));
            }
            View view7 = this.mRootView;
            RelativeLayout relativeLayout = view7 != null ? (RelativeLayout) view7.findViewById(R.id.tab_parent) : null;
            if (relativeLayout != null) {
                relativeLayout.setBackground(ContextCompat.getDrawable(it, R.drawable.personal_page_sliding_tab_bg));
            }
            SlidingTabLayout slidingTabLayout2 = this.slidingTabLayout;
            if (slidingTabLayout2 != null) {
                slidingTabLayout2.updateUi();
            }
            SlidingTabLayout slidingTabLayout3 = this.slidingTabLayout;
            if (slidingTabLayout3 != null) {
                slidingTabLayout3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.personal_page_sliding_tab_bg, (Resources.Theme) null));
            }
            View view8 = this.mRootView;
            View findViewById2 = view8 != null ? view8.findViewById(R.id.sliding_tab_divider) : null;
            if (findViewById2 != null) {
                findViewById2.setBackground(ContextCompat.getDrawable(it, com.baidu.android.common.ui.style.R.color.GC34));
            }
            View view9 = this.mRootView;
            if (!(view9 == null || (imageView4 = (ImageView) view9.findViewById(R.id.tab_search_view)) == null)) {
                imageView4.setImageDrawable(ContextCompat.getDrawable(it, R.drawable.personal_mix_search_icon));
            }
            View view10 = this.mRootView;
            if (!(view10 == null || (imageView3 = (ImageView) view10.findViewById(R.id.publish_icon)) == null)) {
                imageView3.setImageDrawable(ContextCompat.getDrawable(it, R.drawable.personal_publish_icon));
            }
            View view11 = this.mRootView;
            View findViewById3 = view11 != null ? view11.findViewById(R.id.publish_config_bubble) : null;
            if (findViewById3 != null) {
                findViewById3.setBackground(ContextCompat.getDrawable(it, R.drawable.personal_publish_icon_config_bubble_bg));
            }
            FeedTabHelper.INSTANCE.updateEditTabIcon();
            View view12 = this.emptyView;
            if (view12 != null) {
                view12.setBackgroundColor(ResourcesCompat.getColor(getResources(), com.baidu.android.common.ui.style.R.color.GC9, (Resources.Theme) null));
            }
            View view13 = this.emptyView;
            if (!(view13 == null || (bdBaseImageView = (BdBaseImageView) view13.findViewById(R.id.empty_image)) == null)) {
                bdBaseImageView.setImageDrawable(ContextCompat.getDrawable(it, R.drawable.personal_empty_icon_document));
            }
            View view14 = this.emptyView;
            if (!(view14 == null || (textView3 = (TextView) view14.findViewById(R.id.empty_text)) == null)) {
                textView3.setTextColor(ContextCompat.getColor(it, com.baidu.android.common.ui.style.R.color.GC4));
            }
            View view15 = this.emptyView;
            if (view15 != null) {
                view4 = view15.findViewById(R.id.shut_up_layout);
            }
            if (view4 != null) {
                view4.setBackground(ContextCompat.getDrawable(it, R.drawable.personal_shut_up_layout_background));
            }
            View view16 = this.emptyView;
            if (!(view16 == null || (findViewById = view16.findViewById(R.id.shut_up_layout)) == null || (imageView2 = (ImageView) findViewById.findViewById(R.id.shut_up_icon)) == null)) {
                imageView2.setImageDrawable(ContextCompat.getDrawable(it, R.drawable.personal_shut_up_icon));
            }
            View view17 = this.emptyView;
            if (!(view17 == null || (textView2 = (TextView) view17.findViewById(R.id.shut_up_text)) == null)) {
                textView2.setTextColor(ContextCompat.getColor(it, com.baidu.android.common.ui.style.R.color.GC8));
            }
            View view18 = this.shutUpLayout;
            if (view18 != null) {
                view18.setBackground(ContextCompat.getDrawable(it, R.drawable.personal_shut_up_layout_background));
            }
            View view19 = this.shutUpLayout;
            if (!(view19 == null || (imageView = (ImageView) view19.findViewById(R.id.shut_up_icon)) == null)) {
                imageView.setImageDrawable(ContextCompat.getDrawable(it, R.drawable.personal_shut_up_icon));
            }
            View view20 = this.shutUpLayout;
            if (!(view20 == null || (textView = (TextView) view20.findViewById(R.id.shut_up_text)) == null)) {
                textView.setTextColor(ContextCompat.getColor(it, com.baidu.android.common.ui.style.R.color.GC8));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                View view21 = this.publisherView;
                boolean z = true;
                if (view21 == null || !view21.isAttachedToWindow()) {
                    z = false;
                }
                if (z && (view2 = this.publisherView) != null) {
                    view2.setBackground(ContextCompat.getDrawable(it, com.baidu.android.common.ui.style.R.color.GC10));
                    return;
                }
                return;
            }
            View view22 = this.publisherView;
            if (view22 != null) {
                view22.setBackground(ContextCompat.getDrawable(it, com.baidu.android.common.ui.style.R.color.GC10));
            }
        }
    }

    private final void updateFeedSize() {
        int heightDimen;
        TextView textView;
        View findViewById;
        TextView textView2;
        View findViewById2;
        switch (FontSizeHelper.getFontSizeType()) {
            case 0:
                heightDimen = R.dimen.personal_feed_tab_height_s;
                break;
            case 1:
                heightDimen = R.dimen.personal_feed_tab_height;
                break;
            case 2:
                heightDimen = R.dimen.personal_feed_tab_height_b;
                break;
            case 3:
                heightDimen = R.dimen.personal_feed_tab_height_vb;
                break;
            case 4:
                heightDimen = R.dimen.personal_feed_tab_height_eb;
                break;
            default:
                heightDimen = R.dimen.personal_feed_tab_height;
                break;
        }
        View view2 = this.mRootView;
        ImageView imageView = null;
        FontSizeViewExtKt.setScaledHeight$default(view2 != null ? (RelativeLayout) view2.findViewById(R.id.tab_parent) : null, 2, getResources().getDimension(heightDimen), 0, 4, (Object) null);
        float width = getResources().getDimension(R.dimen.personal_edit_tab_icon_size);
        View view3 = this.mRootView;
        float f2 = width;
        float f3 = width;
        FontSizeViewExtKt.setScaledSize$default(view3 != null ? (ImageView) view3.findViewById(R.id.tab_search_view) : null, 2, f2, f3, 0, 8, (Object) null);
        FontSizeViewExtKt.setScaledSize$default(FeedTabHelper.INSTANCE.getEditTabIcon(), 2, f2, f3, 0, 8, (Object) null);
        float dimension = getResources().getDimension(R.dimen.personal_feed_publish_width);
        View view4 = this.mRootView;
        FontSizeViewExtKt.setScaledSize$default(view4 != null ? (ImageView) view4.findViewById(R.id.publish_icon) : null, 2, dimension, dimension, 0, 8, (Object) null);
        View view5 = this.mRootView;
        FontSizeViewExtKt.setScaledRightMargin$default(view5 != null ? (FrameLayout) view5.findViewById(R.id.publish_config_bubble_layout) : null, 2, dimension / ((float) 2), 0, 4, (Object) null);
        View view6 = this.mRootView;
        FontSizeTextViewExtKt.setScaledSizeRes$default(view6 != null ? (TextView) view6.findViewById(R.id.publish_config_bubble_text) : null, 2, R.dimen.publish_config_bubble_text_size, 0, 4, (Object) null);
        View view7 = this.mRootView;
        FontSizeViewExtKt.setScaledSizeRes$default(view7 != null ? (SimpleDraweeView) view7.findViewById(R.id.publish_config_image) : null, 2, R.dimen.publish_config_bubble_image_size, R.dimen.publish_config_bubble_image_size, 0, 8, (Object) null);
        View view8 = this.emptyView;
        FontSizeViewExtKt.setScaledSize$default((view8 == null || (findViewById2 = view8.findViewById(R.id.shut_up_layout)) == null) ? null : (ImageView) findViewById2.findViewById(R.id.shut_up_icon), 2, DeviceUtils.ScreenInfo.dp2pxf(getContext(), 13.0f), DeviceUtils.ScreenInfo.dp2pxf(getContext(), 13.0f), 0, 8, (Object) null);
        View view9 = this.emptyView;
        if (!(view9 == null || (findViewById = view9.findViewById(R.id.shut_up_layout)) == null || (textView2 = (TextView) findViewById.findViewById(R.id.shut_up_text)) == null)) {
            FontSizeTextViewExtKt.setScaledSize$default(textView2, 2, 1, 11.0f, 0, 8, (Object) null);
        }
        View view10 = this.shutUpLayout;
        if (view10 != null) {
            imageView = (ImageView) view10.findViewById(R.id.shut_up_icon);
        }
        FontSizeViewExtKt.setScaledSize$default(imageView, 2, DeviceUtils.ScreenInfo.dp2pxf(getContext(), 13.0f), DeviceUtils.ScreenInfo.dp2pxf(getContext(), 13.0f), 0, 8, (Object) null);
        View view11 = this.shutUpLayout;
        if (view11 != null && (textView = (TextView) view11.findViewById(R.id.shut_up_text)) != null) {
            FontSizeTextViewExtKt.setScaledSize$default(textView, 2, 1, 11.0f, 0, 8, (Object) null);
        }
    }

    public final String getPersonalPageId$lib_personal_center_release() {
        return String.valueOf(hashCode());
    }

    public boolean isCanScrollVertically(int direction) {
        return new FeedViewHelper().isCanScrollVertically(this.feedContainer, direction);
    }

    public void scrollContentBy(int dy) {
        new FeedViewHelper().scrollContentBy(this.feedContainer, dy);
    }

    public void stopContentNestedScroll(int type) {
        new FeedViewHelper().stopContentNestedScroll(this.feedContainer, type);
    }

    private final void updateFeed(boolean isInitLocalData) {
        FragmentManager fragmentManager;
        Iterable<Fragment> $this$forEach$iv;
        JSONArray rawTabsList;
        List it;
        PersonalCenterFusionHomeModel personalCenterFusionHomeModel;
        List list;
        Object obj;
        PersonalCenterDataWrapper fusionData = PersonalCenterDataMgrFusionExtKt.getFusionData(PersonalizedDataManagerWrapper.INSTANCE.getManager());
        this.userEntity = fusionData != null ? fusionData.getFusionHomeModel() : null;
        tryAddPublisherView();
        if (!(!LoginUtilKt.isLogin$default(false, 1, (Object) null) || (personalCenterFusionHomeModel = this.userEntity) == null || (list = personalCenterFusionHomeModel.getTabsList()) == null)) {
            MultiTabItemInfo curTabItem = (MultiTabItemInfo) CollectionsKt.getOrNull(this.mTabList, this.curSelectedPage);
            this.mTabList = FeedTabHelper.INSTANCE.transformFeedTabs(list);
            FeedTabHelper.INSTANCE.tryShowEditTabIcon(getActivity(), this.mRootView, this.userEntity, this);
            if (curTabItem != null) {
                Iterator it2 = this.mTabList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (Intrinsics.areEqual((Object) ((MultiTabItemInfo) obj).mId, (Object) curTabItem.mId)) {
                        break;
                    }
                }
                MultiTabItemInfo latestTabItem = (MultiTabItemInfo) obj;
                if (latestTabItem != null && !curTabItem.hasRNInfo() && latestTabItem.hasRNInfo()) {
                    latestTabItem.clearCachePageWhenUpdate = true;
                }
                String str = curTabItem.mId;
                Intrinsics.checkNotNullExpressionValue(str, "curTabItem.mId");
                this.mRestoredTabId = str;
            }
        }
        updateFeedTabs();
        PersonalCenterFusionHomeModel personalCenterFusionHomeModel2 = this.userEntity;
        if (!(personalCenterFusionHomeModel2 == null || (it = personalCenterFusionHomeModel2.getHideTabsList()) == null)) {
            this.mHideTabList = FeedTabHelper.INSTANCE.transformFeedTabs(it);
        }
        if (!isInitLocalData && LoginUtilKt.isLogin$default(false, 1, (Object) null) && !this.sFirstResume && this.fromTabClick) {
            PersonalCenterFusionHomeModel personalCenterFusionHomeModel3 = this.userEntity;
            DataChannel.Sender.sendBroadcast(getContext(), this.PAGE_REFRESH_DATA_CHANNEL, (personalCenterFusionHomeModel3 == null || (rawTabsList = personalCenterFusionHomeModel3.getRawTabsList()) == null) ? null : rawTabsList.toString());
            FeedContainer feedContainer2 = this.feedContainer;
            if (!(feedContainer2 == null || (fragmentManager = feedContainer2.getFragmentManager()) == null || ($this$forEach$iv = fragmentManager.getFragments()) == null)) {
                for (Fragment it3 : $this$forEach$iv) {
                    FeedBaseFragment feedBaseFragment = it3 instanceof FeedBaseFragment ? (FeedBaseFragment) it3 : null;
                    IPagerView pageView = feedBaseFragment != null ? feedBaseFragment.getPagerViewImpl() : null;
                    if (pageView instanceof PersonalCenterWebPageView) {
                        ((PersonalCenterWebPageView) pageView).notifyRefresh();
                    } else if (pageView instanceof CommonRefreshableListPage) {
                        ((CommonRefreshableListPage) pageView).notifyRefresh();
                    }
                }
            }
        }
        tryShowPublishIcon(isInitLocalData);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0147, code lost:
        if ((r3.length() == 0) == true) goto L_0x014b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateFeedTabs() {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            boolean r3 = com.baidu.searchbox.personalcenter.utils.LoginUtilKt.isLogin$default(r0, r1, r2)
            r4 = 8
            if (r3 == 0) goto L_0x0249
            android.view.View r3 = r12.mRootView
            if (r3 == 0) goto L_0x0018
            int r5 = com.baidu.searchbox.personalcenter.R.id.tab_search_view
            android.view.View r3 = r3.findViewById(r5)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            goto L_0x0019
        L_0x0018:
            r3 = r2
        L_0x0019:
            if (r3 != 0) goto L_0x001c
            goto L_0x001f
        L_0x001c:
            r3.setVisibility(r0)
        L_0x001f:
            android.view.View r3 = r12.feedView
            if (r3 != 0) goto L_0x0024
            goto L_0x0027
        L_0x0024:
            r3.setVisibility(r0)
        L_0x0027:
            android.view.View r3 = r12.emptyView
            if (r3 != 0) goto L_0x002c
            goto L_0x002f
        L_0x002c:
            r3.setVisibility(r4)
        L_0x002f:
            android.view.View r3 = r12.emptyView
            if (r3 == 0) goto L_0x003a
            int r5 = com.baidu.searchbox.personalcenter.R.id.shut_up_layout
            android.view.View r3 = r3.findViewById(r5)
            goto L_0x003b
        L_0x003a:
            r3 = r2
        L_0x003b:
            if (r3 != 0) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r3.setVisibility(r4)
        L_0x0041:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r3 = r12.userEntity
            if (r3 == 0) goto L_0x004a
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel$FusionHomeBjhStatus r3 = r3.getHomeBannedType()
            goto L_0x004b
        L_0x004a:
            r3 = r2
        L_0x004b:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel$FusionHomeBjhStatus r5 = com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel.FusionHomeBjhStatus.FORBID
            if (r3 != r5) goto L_0x010f
            android.view.View r3 = r12.feedView
            if (r3 != 0) goto L_0x0054
            goto L_0x0057
        L_0x0054:
            r3.setVisibility(r4)
        L_0x0057:
            android.view.View r3 = r12.emptyView
            if (r3 != 0) goto L_0x005c
            goto L_0x005f
        L_0x005c:
            r3.setVisibility(r0)
        L_0x005f:
            android.view.View r3 = r12.emptyView
            if (r3 == 0) goto L_0x006a
            int r4 = com.baidu.searchbox.personalcenter.R.id.shut_up_layout
            android.view.View r3 = r3.findViewById(r4)
            goto L_0x006b
        L_0x006a:
            r3 = r2
        L_0x006b:
            if (r3 != 0) goto L_0x006e
            goto L_0x0071
        L_0x006e:
            r3.setVisibility(r0)
        L_0x0071:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r3 = r12.userEntity
            if (r3 == 0) goto L_0x008a
            java.lang.String r3 = r3.getBannedDescription()
            if (r3 == 0) goto L_0x008a
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0085
            r3 = r1
            goto L_0x0086
        L_0x0085:
            r3 = r0
        L_0x0086:
            if (r3 != r1) goto L_0x008a
            r3 = r1
            goto L_0x008b
        L_0x008a:
            r3 = r0
        L_0x008b:
            if (r3 == 0) goto L_0x00b2
            android.view.View r3 = r12.emptyView
            if (r3 == 0) goto L_0x00a2
            int r4 = com.baidu.searchbox.personalcenter.R.id.shut_up_layout
            android.view.View r3 = r3.findViewById(r4)
            if (r3 == 0) goto L_0x00a2
            int r4 = com.baidu.searchbox.personalcenter.R.id.shut_up_text
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x00a3
        L_0x00a2:
            r3 = r2
        L_0x00a3:
            if (r3 != 0) goto L_0x00a6
            goto L_0x00da
        L_0x00a6:
            int r4 = com.baidu.searchbox.personalcenter.R.string.personal_account_forbid_default_text
            java.lang.String r4 = r12.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x00da
        L_0x00b2:
            android.view.View r3 = r12.emptyView
            if (r3 == 0) goto L_0x00c7
            int r4 = com.baidu.searchbox.personalcenter.R.id.shut_up_layout
            android.view.View r3 = r3.findViewById(r4)
            if (r3 == 0) goto L_0x00c7
            int r4 = com.baidu.searchbox.personalcenter.R.id.shut_up_text
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x00c8
        L_0x00c7:
            r3 = r2
        L_0x00c8:
            if (r3 != 0) goto L_0x00cb
            goto L_0x00da
        L_0x00cb:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r4 = r12.userEntity
            if (r4 == 0) goto L_0x00d4
            java.lang.String r4 = r4.getBannedDescription()
            goto L_0x00d5
        L_0x00d4:
            r4 = r2
        L_0x00d5:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x00da:
            android.view.View r3 = r12.emptyView
            if (r3 == 0) goto L_0x00e7
            int r4 = com.baidu.searchbox.personalcenter.R.id.empty_text
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x00e8
        L_0x00e7:
            r3 = r2
        L_0x00e8:
            if (r3 != 0) goto L_0x00eb
            goto L_0x00f6
        L_0x00eb:
            int r4 = com.baidu.searchbox.personalcenter.R.string.personal_shut_down_forbid_text
            java.lang.String r4 = r12.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x00f6:
            android.view.View r3 = r12.shutUpLayout
            if (r3 == 0) goto L_0x00ff
            android.view.ViewParent r3 = r3.getParent()
            goto L_0x0100
        L_0x00ff:
            r3 = r2
        L_0x0100:
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x0107
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            goto L_0x0108
        L_0x0107:
            r3 = r2
        L_0x0108:
            if (r3 == 0) goto L_0x010f
            android.view.View r4 = r12.shutUpLayout
            r3.removeView(r4)
        L_0x010f:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r3 = r12.userEntity
            if (r3 == 0) goto L_0x0118
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel$FusionHomeBjhStatus r3 = r3.getHomeBannedType()
            goto L_0x0119
        L_0x0118:
            r3 = r2
        L_0x0119:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel$FusionHomeBjhStatus r4 = com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel.FusionHomeBjhStatus.MUTE
            if (r3 != r4) goto L_0x0220
            android.view.View r3 = r12.shutUpLayout
            if (r3 != 0) goto L_0x0132
            android.content.Context r3 = r12.getContext()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            int r4 = com.baidu.searchbox.personalcenter.R.layout.personal_shut_up_layout
            android.view.View r3 = r3.inflate(r4, r2)
            r12.shutUpLayout = r3
        L_0x0132:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r3 = r12.userEntity
            if (r3 == 0) goto L_0x014a
            java.lang.String r3 = r3.getBannedDescription()
            if (r3 == 0) goto L_0x014a
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0146
            r3 = r1
            goto L_0x0147
        L_0x0146:
            r3 = r0
        L_0x0147:
            if (r3 != r1) goto L_0x014a
            goto L_0x014b
        L_0x014a:
            r1 = r0
        L_0x014b:
            if (r1 == 0) goto L_0x016a
            android.view.View r1 = r12.shutUpLayout
            if (r1 == 0) goto L_0x015a
            int r3 = com.baidu.searchbox.personalcenter.R.id.shut_up_text
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x015b
        L_0x015a:
            r1 = r2
        L_0x015b:
            if (r1 != 0) goto L_0x015e
            goto L_0x018a
        L_0x015e:
            int r3 = com.baidu.searchbox.personalcenter.R.string.personal_account_mute_default_text
            java.lang.String r3 = r12.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            goto L_0x018a
        L_0x016a:
            android.view.View r1 = r12.shutUpLayout
            if (r1 == 0) goto L_0x0177
            int r3 = com.baidu.searchbox.personalcenter.R.id.shut_up_text
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0178
        L_0x0177:
            r1 = r2
        L_0x0178:
            if (r1 != 0) goto L_0x017b
            goto L_0x018a
        L_0x017b:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r3 = r12.userEntity
            if (r3 == 0) goto L_0x0184
            java.lang.String r3 = r3.getBannedDescription()
            goto L_0x0185
        L_0x0184:
            r3 = r2
        L_0x0185:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
        L_0x018a:
            boolean r1 = r12.isDetached()
            if (r1 != 0) goto L_0x021f
            android.content.Context r1 = r12.getContext()
            if (r1 != 0) goto L_0x0198
            goto L_0x021f
        L_0x0198:
            android.view.View r1 = r12.shutUpLayout
            if (r1 == 0) goto L_0x01a1
            android.view.ViewParent r1 = r1.getParent()
            goto L_0x01a2
        L_0x01a1:
            r1 = r2
        L_0x01a2:
            android.view.View r3 = r12.mRootView
            if (r3 == 0) goto L_0x01af
            int r4 = com.baidu.searchbox.personalcenter.R.id.feed_header_container
            android.view.View r3 = r3.findViewById(r4)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            goto L_0x01b0
        L_0x01af:
            r3 = r2
        L_0x01b0:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x01b7
            return
        L_0x01b7:
            android.view.View r1 = r12.shutUpLayout
            if (r1 == 0) goto L_0x01c0
            android.view.ViewParent r1 = r1.getParent()
            goto L_0x01c1
        L_0x01c0:
            r1 = r2
        L_0x01c1:
            boolean r3 = r1 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x01c8
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            goto L_0x01c9
        L_0x01c8:
            r1 = r2
        L_0x01c9:
            if (r1 == 0) goto L_0x01d0
            android.view.View r3 = r12.shutUpLayout
            r1.removeView(r3)
        L_0x01d0:
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            r3 = -1
            android.content.Context r4 = r12.getContext()
            r5 = 1108082688(0x420c0000, float:35.0)
            int r4 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.dp2px(r4, r5)
            r1.<init>(r3, r4)
            android.content.Context r3 = r12.getContext()
            r4 = 1097859072(0x41700000, float:15.0)
            int r3 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.dp2px(r3, r4)
            android.content.Context r5 = r12.getContext()
            r6 = 1092616192(0x41200000, float:10.0)
            int r5 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.dp2px(r5, r6)
            android.content.Context r7 = r12.getContext()
            int r4 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.dp2px(r7, r4)
            android.content.Context r7 = r12.getContext()
            int r6 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.dp2px(r7, r6)
            r1.setMargins(r3, r5, r4, r6)
            android.view.View r3 = r12.mRootView
            if (r3 == 0) goto L_0x0220
            int r4 = com.baidu.searchbox.personalcenter.R.id.feed_header_container
            android.view.View r3 = r3.findViewById(r4)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            if (r3 == 0) goto L_0x0220
            android.view.View r4 = r12.shutUpLayout
            r5 = r1
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r3.addView(r4, r5)
            goto L_0x0220
        L_0x021f:
            return
        L_0x0220:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r1 = r12.userEntity
            if (r1 == 0) goto L_0x0229
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel$FusionHomeBjhStatus r1 = r1.getHomeBannedType()
            goto L_0x022a
        L_0x0229:
            r1 = r2
        L_0x022a:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel$FusionHomeBjhStatus r3 = com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel.FusionHomeBjhStatus.NORMAL
            if (r1 != r3) goto L_0x02af
            android.view.View r1 = r12.shutUpLayout
            if (r1 == 0) goto L_0x0237
            android.view.ViewParent r1 = r1.getParent()
            goto L_0x0238
        L_0x0237:
            r1 = r2
        L_0x0238:
            boolean r3 = r1 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x023f
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            goto L_0x0240
        L_0x023f:
            r1 = r2
        L_0x0240:
            if (r1 == 0) goto L_0x02af
            android.view.View r3 = r12.shutUpLayout
            r1.removeView(r3)
            goto L_0x02af
        L_0x0249:
            android.view.View r1 = r12.feedView
            if (r1 != 0) goto L_0x024e
            goto L_0x0251
        L_0x024e:
            r1.setVisibility(r4)
        L_0x0251:
            android.view.View r1 = r12.emptyView
            if (r1 != 0) goto L_0x0256
            goto L_0x0259
        L_0x0256:
            r1.setVisibility(r0)
        L_0x0259:
            android.view.View r1 = r12.emptyView
            if (r1 == 0) goto L_0x0266
            int r3 = com.baidu.searchbox.personalcenter.R.id.empty_text
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0267
        L_0x0266:
            r1 = r2
        L_0x0267:
            if (r1 != 0) goto L_0x026a
            goto L_0x0275
        L_0x026a:
            int r3 = com.baidu.searchbox.personalcenter.R.string.personal_feed_mix_login_hint
            java.lang.String r3 = r12.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
        L_0x0275:
            android.view.View r1 = r12.mRootView
            if (r1 == 0) goto L_0x0282
            int r3 = com.baidu.searchbox.personalcenter.R.id.tab_search_view
            android.view.View r1 = r1.findViewById(r3)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x0283
        L_0x0282:
            r1 = r2
        L_0x0283:
            if (r1 != 0) goto L_0x0286
            goto L_0x0289
        L_0x0286:
            r1.setVisibility(r4)
        L_0x0289:
            android.view.View r1 = r12.emptyView
            if (r1 == 0) goto L_0x0294
            int r3 = com.baidu.searchbox.personalcenter.R.id.shut_up_layout
            android.view.View r1 = r1.findViewById(r3)
            goto L_0x0295
        L_0x0294:
            r1 = r2
        L_0x0295:
            if (r1 != 0) goto L_0x0298
            goto L_0x029b
        L_0x0298:
            r1.setVisibility(r4)
        L_0x029b:
            com.baidu.searchbox.personal.feed.FeedTabHelper r1 = com.baidu.searchbox.personal.feed.FeedTabHelper.INSTANCE
            android.widget.ImageView r1 = r1.getEditTabIcon()
            if (r1 != 0) goto L_0x02a4
            goto L_0x02a7
        L_0x02a4:
            r1.setVisibility(r4)
        L_0x02a7:
            android.view.View r1 = r12.publisherView
            if (r1 != 0) goto L_0x02ac
            goto L_0x02af
        L_0x02ac:
            r1.setVisibility(r4)
        L_0x02af:
            com.baidu.searchbox.feed.container.FeedContainer r1 = r12.feedContainer
            if (r1 != 0) goto L_0x02b4
            return
        L_0x02b4:
            java.lang.String r3 = "main"
            r12.curTabId = r3
            if (r1 == 0) goto L_0x02c0
            java.util.List<? extends com.baidu.searchbox.feed.tab.update.MultiTabItemInfo> r3 = r12.mTabList
            r1.updateTabList(r3)
        L_0x02c0:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x02da }
            r1 = r12
            com.baidu.searchbox.personal.PersonalMixFragment r1 = (com.baidu.searchbox.personal.PersonalMixFragment) r1     // Catch:{ all -> 0x02da }
            r3 = 0
            java.lang.String r4 = r1.mRestoredTabId     // Catch:{ all -> 0x02da }
            boolean r0 = r1.selectTabById(r4, r0)     // Catch:{ all -> 0x02da }
            java.lang.String r4 = ""
            r1.mRestoredTabId = r4     // Catch:{ all -> 0x02da }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x02da }
            kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x02da }
            goto L_0x02e4
        L_0x02da:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
        L_0x02e4:
            com.baidu.searchbox.feed.tab.SlidingTabLayout r0 = r12.slidingTabLayout
            if (r0 != 0) goto L_0x02e9
            goto L_0x02f6
        L_0x02e9:
            com.baidu.searchbox.feed.container.FeedContainer r1 = r12.feedContainer
            if (r1 == 0) goto L_0x02f1
            com.baidu.searchbox.feed.tab.TabViewPager r2 = r1.getViewPager()
        L_0x02f1:
            androidx.viewpager.widget.ViewPager r2 = (androidx.viewpager.widget.ViewPager) r2
            r0.setViewPager(r2)
        L_0x02f6:
            java.util.List<? extends com.baidu.searchbox.feed.tab.update.MultiTabItemInfo> r0 = r12.mTabList
            java.util.Iterator r0 = r0.iterator()
        L_0x02fc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x031c
            java.lang.Object r1 = r0.next()
            com.baidu.searchbox.feed.tab.update.MultiTabItemInfo r1 = (com.baidu.searchbox.feed.tab.update.MultiTabItemInfo) r1
            com.baidu.searchbox.personal.fuse.PersonalCenterNaUbcUtils r2 = com.baidu.searchbox.personal.fuse.PersonalCenterNaUbcUtils.INSTANCE
            r3 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = r1.mId
            r8 = 0
            r9 = 0
            r10 = 109(0x6d, float:1.53E-43)
            r11 = 0
            java.lang.String r4 = "tab_view"
            com.baidu.searchbox.personal.fuse.PersonalCenterNaUbcUtils.doPersonalPageNaUbcWithFilter$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x02fc
        L_0x031c:
            r12.updateFeedNight()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.PersonalMixFragment.updateFeedTabs():void");
    }

    static /* synthetic */ boolean selectTabById$default(PersonalMixFragment personalMixFragment, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return personalMixFragment.selectTabById(str, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean selectTabById(java.lang.String r11, boolean r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            if (r11 == 0) goto L_0x0014
            r2 = r11
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r0
        L_0x0010:
            if (r2 != r1) goto L_0x0014
            r2 = r1
            goto L_0x0015
        L_0x0014:
            r2 = r0
        L_0x0015:
            if (r2 == 0) goto L_0x0047
            java.util.List<? extends com.baidu.searchbox.feed.tab.update.MultiTabItemInfo> r2 = r10.mTabList
            r3 = 0
            r4 = 0
            java.util.Iterator r5 = r2.iterator()
        L_0x001f:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x003a
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.baidu.searchbox.feed.tab.update.MultiTabItemInfo r7 = (com.baidu.searchbox.feed.tab.update.MultiTabItemInfo) r7
            r8 = 0
            java.lang.String r9 = r7.mId
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r7 == 0) goto L_0x0036
            goto L_0x003c
        L_0x0036:
            int r4 = r4 + 1
            goto L_0x001f
        L_0x003a:
            r5 = -1
            r4 = r5
        L_0x003c:
            r2 = r4
            if (r2 < 0) goto L_0x0047
            com.baidu.searchbox.feed.container.FeedContainer r0 = r10.feedContainer
            if (r0 == 0) goto L_0x0046
            r0.setCurrentItem(r2, r12)
        L_0x0046:
            return r1
        L_0x0047:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.PersonalMixFragment.selectTabById(java.lang.String, boolean):boolean");
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v7, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void tryShowPublishIcon(boolean r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            boolean r1 = com.baidu.searchbox.personalcenter.utils.LoginUtilKt.isLogin$default(r0, r1, r2)
            if (r1 == 0) goto L_0x0063
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r1 = r9.userEntity
            if (r1 == 0) goto L_0x0012
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel$FusionHomeBjhStatus r1 = r1.getHomeBannedType()
            goto L_0x0013
        L_0x0012:
            r1 = r2
        L_0x0013:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel$FusionHomeBjhStatus r3 = com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel.FusionHomeBjhStatus.NORMAL
            if (r1 == r3) goto L_0x002d
            android.view.View r0 = r9.mRootView
            if (r0 == 0) goto L_0x0024
            int r1 = com.baidu.searchbox.personalcenter.R.id.publish_icon_layout
            android.view.View r0 = r0.findViewById(r1)
            r2 = r0
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
        L_0x0024:
            if (r2 != 0) goto L_0x0027
            goto L_0x0095
        L_0x0027:
            r0 = 8
            r2.setVisibility(r0)
            goto L_0x0095
        L_0x002d:
            android.view.View r1 = r9.mRootView
            if (r1 == 0) goto L_0x003a
            int r2 = com.baidu.searchbox.personalcenter.R.id.publish_icon_layout
            android.view.View r1 = r1.findViewById(r2)
            r2 = r1
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
        L_0x003a:
            if (r2 != 0) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            r2.setVisibility(r0)
        L_0x0040:
            org.json.JSONObject r5 = r9.ubcExtBubbleJSONObject()
            java.lang.String r3 = "fabu"
            java.lang.String r4 = "show"
            java.lang.String r6 = "wode"
            java.lang.String r7 = "192"
            java.lang.String r8 = "zhuye"
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBCWithoutSource(r3, r4, r5, r6, r7, r8)
            if (r10 != 0) goto L_0x0095
            boolean r0 = r9.sFirstShowBubble
            if (r0 == 0) goto L_0x0095
            r9.tryShowPublishConfigGuideBubble()
            goto L_0x0095
        L_0x0063:
            android.view.View r1 = r9.mRootView
            if (r1 == 0) goto L_0x0070
            int r2 = com.baidu.searchbox.personalcenter.R.id.publish_icon_layout
            android.view.View r1 = r1.findViewById(r2)
            r2 = r1
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
        L_0x0070:
            if (r2 != 0) goto L_0x0073
            goto L_0x0076
        L_0x0073:
            r2.setVisibility(r0)
        L_0x0076:
            r5 = 0
            java.lang.String r3 = "fabu"
            java.lang.String r4 = "show"
            java.lang.String r6 = "wode"
            java.lang.String r7 = "192"
            java.lang.String r8 = "zhuye"
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBCWithoutSource(r3, r4, r5, r6, r7, r8)
            if (r10 != 0) goto L_0x0095
            boolean r0 = r9.sFirstShowBubble
            if (r0 == 0) goto L_0x0095
            r9.tryShowPublishConfigGuideBubble()
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.PersonalMixFragment.tryShowPublishIcon(boolean):void");
    }

    private final void tryAddPublisherView() {
        LinearLayout linearLayout;
        if (!isDetached() && getContext() != null) {
            View view2 = this.publisherView;
            ViewGroup viewGroup = null;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            View view3 = this.mRootView;
            if (!Intrinsics.areEqual((Object) parent, (Object) view3 != null ? (LinearLayout) view3.findViewById(R.id.feed_header_container) : null)) {
                View view4 = this.publisherView;
                ViewParent parent2 = view4 != null ? view4.getParent() : null;
                if (parent2 instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent2;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(this.publisherView);
                }
                View view5 = this.mRootView;
                if (!(view5 == null || (linearLayout = (LinearLayout) view5.findViewById(R.id.feed_header_container)) == null)) {
                    linearLayout.addView(this.publisherView);
                }
                int hPadding = getResources().getDimensionPixelOffset(R.dimen.personal_feed_publisher_h_padding);
                int vPadding = getResources().getDimensionPixelOffset(R.dimen.personal_feed_publisher_v_padding);
                View view6 = this.publisherView;
                if (view6 != null) {
                    view6.setPadding(hPadding, vPadding, hPadding, vPadding);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [com.baidu.searchbox.feed.widget.feedflow.IPagerView] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPublishSucceed(boolean r9) {
        /*
            r8 = this;
            java.util.List<java.lang.String> r0 = r8.dynamicRefreshTabs
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x0009:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x003f
            java.lang.Object r3 = r2.next()
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            r6 = 0
            com.baidu.searchbox.feed.container.FeedContainer r7 = r8.feedContainer
            if (r7 == 0) goto L_0x0026
            com.baidu.searchbox.feed.tab.fragment.FeedBaseFragment r7 = r7.getFragmentByTabId(r5)
            if (r7 == 0) goto L_0x0026
            com.baidu.searchbox.feed.widget.feedflow.IPagerView r4 = r7.getPagerViewImpl()
        L_0x0026:
            boolean r7 = r4 instanceof com.baidu.searchbox.personal.feed.PersonalCenterWebPageView
            if (r7 == 0) goto L_0x0031
            r7 = r4
            com.baidu.searchbox.personal.feed.PersonalCenterWebPageView r7 = (com.baidu.searchbox.personal.feed.PersonalCenterWebPageView) r7
            r7.notifyRefresh()
            goto L_0x003d
        L_0x0031:
            boolean r7 = r4 instanceof com.baidu.searchbox.personal.feed.PersonalCenterVideoPageView
            if (r7 == 0) goto L_0x003d
            if (r9 == 0) goto L_0x003d
            r7 = r4
            com.baidu.searchbox.personal.feed.PersonalCenterVideoPageView r7 = (com.baidu.searchbox.personal.feed.PersonalCenterVideoPageView) r7
            r7.notifyRefresh()
        L_0x003d:
            goto L_0x0009
        L_0x003f:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r0 = r8.userEntity
            if (r0 == 0) goto L_0x004e
            org.json.JSONArray r0 = r0.getRawTabsList()
            if (r0 == 0) goto L_0x004e
            java.lang.String r4 = r0.toString()
        L_0x004e:
            r0 = r4
            r1 = 0
            android.content.Context r2 = r8.getContext()
            java.lang.String r3 = r8.PAGE_REFRESH_DATA_CHANNEL
            com.baidu.searchbox.datachannel.DataChannel.Sender.sendBroadcast(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.PersonalMixFragment.onPublishSucceed(boolean):void");
    }

    public void updateFeedTab(List<? extends MultiTabItemInfo> tabList) {
        Intrinsics.checkNotNullParameter(tabList, ParseJsonKey.GROUP_TAB_LIST);
        this.mTabList = tabList;
        updateFeedTabs();
    }

    public void updateHideTab(List<? extends MultiTabItemInfo> hideTabList) {
        Intrinsics.checkNotNullParameter(hideTabList, "hideTabList");
        this.mHideTabList = hideTabList;
    }

    public void restoredTabId() {
        MultiTabItemInfo multiTabItemInfo = (MultiTabItemInfo) CollectionsKt.getOrNull(this.mTabList, this.curSelectedPage);
        String str = multiTabItemInfo != null ? multiTabItemInfo.mId : null;
        if (str == null) {
            str = "";
        }
        this.mRestoredTabId = str;
    }

    /* access modifiers changed from: private */
    public final void startTabContentFlow() {
        View view2 = this.feedView;
        boolean z = false;
        if (view2 != null && view2.getVisibility() == 0) {
            z = true;
        }
        if (z && this.tabPageFlow == null) {
            this.tabPageFlow = this.ubcManager.beginFlow("4971");
        }
    }

    /* access modifiers changed from: private */
    public final void endTabFlow() {
        Flow it = this.tabPageFlow;
        if (it != null) {
            PersonalCenterNaUbcUtils.flowSetValueWithDuration$default(PersonalCenterNaUbcUtils.INSTANCE, it, (String) null, (String) null, this.mSource, getUbcPage(), this.curTabId, (JSONObject) null, 6, (Object) null);
            this.ubcManager.flowEnd(it);
            this.tabPageFlow = null;
        }
    }

    private final String getUbcPage() {
        return getUserType();
    }

    private final String getUserType() {
        BoxAccount boxAccount = getBoxAccount();
        String userType = boxAccount != null ? boxAccount.getUserType() : null;
        if (Intrinsics.areEqual((Object) userType, (Object) "1")) {
            return "ugcbjh";
        }
        if (Intrinsics.areEqual((Object) userType, (Object) "2")) {
            return "star";
        }
        return "ugcsimple";
    }

    private final BoxAccount getBoxAccount() {
        BoxAccountManager manager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (manager.isLogin(2)) {
            return manager.getBoxAccount();
        }
        return null;
    }

    public final String getCurTabId() {
        return this.curTabId;
    }

    public final void setCurTabId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.curTabId = str;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/personal/PersonalMixFragment$PersonalContainerDelegate;", "Lcom/baidu/searchbox/feed/container/IFeedContainerDelegate;", "(Lcom/baidu/searchbox/personal/PersonalMixFragment;)V", "feedContainer", "Lcom/baidu/searchbox/feed/container/FeedContainer;", "getFeedContainer", "()Lcom/baidu/searchbox/feed/container/FeedContainer;", "setFeedContainer", "(Lcom/baidu/searchbox/feed/container/FeedContainer;)V", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalMixFragment.kt */
    public final class PersonalContainerDelegate implements IFeedContainerDelegate {
        public FeedContainer feedContainer;

        public PersonalContainerDelegate() {
        }

        public <T> T asInstanceOrNull(Class<T> clazz) {
            return IFeedContainerDelegate.DefaultImpls.asInstanceOrNull(this, clazz);
        }

        public int getDefaultPos() {
            return IFeedContainerDelegate.DefaultImpls.getDefaultPos(this);
        }

        public boolean isManualDragging() {
            return IFeedContainerDelegate.DefaultImpls.isManualDragging(this);
        }

        public void onViewCreate() {
            IFeedContainerDelegate.DefaultImpls.onViewCreate(this);
        }

        public void onViewDestroy() {
            IFeedContainerDelegate.DefaultImpls.onViewDestroy(this);
        }

        public void onViewPause() {
            IFeedContainerDelegate.DefaultImpls.onViewPause(this);
        }

        public void onViewResume() {
            IFeedContainerDelegate.DefaultImpls.onViewResume(this);
        }

        public void onViewStart() {
            IFeedContainerDelegate.DefaultImpls.onViewStart(this);
        }

        public void onViewStop() {
            IFeedContainerDelegate.DefaultImpls.onViewStop(this);
        }

        public <T> T queryInterface(Class<T> clazz) {
            return IFeedContainerDelegate.DefaultImpls.queryInterface(this, clazz);
        }

        public void setContainer(FeedContainer feedContainer2) {
            IFeedContainerDelegate.DefaultImpls.setContainer(this, feedContainer2);
        }

        public void setManualScrollChangeListener(ManualScrollChangeListener listener) {
            IFeedContainerDelegate.DefaultImpls.setManualScrollChangeListener(this, listener);
        }

        public FeedContainer getFeedContainer() {
            FeedContainer feedContainer2 = this.feedContainer;
            if (feedContainer2 != null) {
                return feedContainer2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("feedContainer");
            return null;
        }

        public void setFeedContainer(FeedContainer feedContainer2) {
            Intrinsics.checkNotNullParameter(feedContainer2, "<set-?>");
            this.feedContainer = feedContainer2;
        }

        public void onPageSelected(int position) {
            RecyclerView recyclerView;
            PersonalizedContainer personalizedContainer;
            int i2 = position;
            PersonalMixFragment.this.endTabFlow();
            Intrinsics.areEqual((Object) PersonalMixFragment.this.getCurTabId(), (Object) "shipin");
            PersonalMixFragment.this.curSelectedPage = i2;
            PersonalMixFragment personalMixFragment = PersonalMixFragment.this;
            MultiTabItemInfo multiTabItemInfo = (MultiTabItemInfo) CollectionsKt.getOrNull(personalMixFragment.mTabList, i2);
            String str = multiTabItemInfo != null ? multiTabItemInfo.mId : null;
            if (str == null) {
                str = "main";
            }
            personalMixFragment.setCurTabId(str);
            PersonalMixFragment.this.startTabContentFlow();
            View access$getMRootView$p = PersonalMixFragment.this.mRootView;
            if (Intrinsics.areEqual((Object) (access$getMRootView$p == null || (personalizedContainer = (PersonalizedContainer) access$getMRootView$p.findViewById(R.id.personalizedContainer)) == null) ? null : Boolean.valueOf(personalizedContainer.isInCeilingState()), (Object) false)) {
                Iterable<Fragment> $this$forEach$iv = getFeedContainer().getFragmentManager().getFragments();
                Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "feedContainer.fragmentManager.fragments");
                for (Fragment currentFragment : $this$forEach$iv) {
                    FeedBaseFragment feedBaseFragment = currentFragment instanceof FeedBaseFragment ? (FeedBaseFragment) currentFragment : null;
                    IPagerView pageView = feedBaseFragment != null ? feedBaseFragment.getPagerViewImpl() : null;
                    if (pageView instanceof CommonRefreshableListPage) {
                        ((CommonRefreshableListPage) pageView).scrollToTop();
                    } else if (pageView instanceof PersonalCenterWebPageView) {
                        ((PersonalCenterWebPageView) pageView).scrollToTop();
                    } else {
                        boolean z = true;
                        if (feedBaseFragment == null || !feedBaseFragment.isRN()) {
                            z = false;
                        }
                        if (z && (recyclerView = new FeedViewHelper().findVerticalScrollableViewByBFS(((FeedBaseFragment) currentFragment).getRootView())) != null) {
                            recyclerView.scrollToPosition(0);
                        }
                    }
                }
            }
            PersonalCenterNaUbcUtils.doPersonalPageNaUbc$default(PersonalCenterNaUbcUtils.INSTANCE, (String) null, "tab_click", (String) null, PersonalMixFragment.this.getCurTabId(), (JSONObject) null, (String) null, 53, (Object) null);
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            IFeedContainerDelegate.DefaultImpls.onPageScrolled(this, position, positionOffset, positionOffsetPixels);
        }

        public void onPageScrollStateChanged(int state) {
            IFeedContainerDelegate.DefaultImpls.onPageScrollStateChanged(this, state);
        }
    }

    /* access modifiers changed from: private */
    public final void tryShowPersonalCenterBubbleGuide() {
        List<PersonalCenterGroupModel> $this$forEachIndexed$iv;
        List<PersonalCenterTabItemModel> $this$forEachIndexed$iv2;
        int i2;
        PersonalMixFragment $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d41;
        PersonalCenterBubbleModel bubbleModel = BubbleGuideManager.INSTANCE.getBubbleToShow();
        if (bubbleModel != null) {
            Ref.ObjectRef anchorView = new Ref.ObjectRef();
            if (Intrinsics.areEqual((Object) bubbleModel.getBubbleClass(), (Object) "4")) {
                PersonMixCenterHeaderView personMixCenterHeaderView = this.mCenterHeaderView;
                if (personMixCenterHeaderView != null) {
                    personMixCenterHeaderView.tryToShowGuide(bubbleModel);
                    return;
                }
                return;
            }
            PersonMixCenterHeaderView personMixCenterHeaderView2 = this.mCenterHeaderView;
            if (personMixCenterHeaderView2 != null) {
                personMixCenterHeaderView2.checkShowSideDataTips();
            }
            PersonalMixFragment $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412 = this;
            int i3 = false;
            PersonalAdapterWithHeader personalAdapterWithHeader = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412.mItemGroupAdapter;
            if (personalAdapterWithHeader != null && ($this$forEachIndexed$iv = personalAdapterWithHeader.getData()) != null) {
                int indexGroup = 0;
                Iterator it = $this$forEachIndexed$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        int i4 = i3;
                        break;
                    }
                    Object item$iv = it.next();
                    int index$iv = indexGroup + 1;
                    if (indexGroup < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    PersonalCenterTabModel tabModel = (PersonalCenterTabModel) CollectionsKt.getOrNull(((PersonalCenterGroupModel) item$iv).getPersonalCenterTabs(), 0);
                    if (!(tabModel == null || ($this$forEachIndexed$iv2 = tabModel.getBody()) == null)) {
                        int index$iv2 = 0;
                        for (Object item$iv2 : $this$forEachIndexed$iv2) {
                            int index$iv3 = index$iv2 + 1;
                            if (index$iv2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            PersonalCenterTabItemModel itemModel = (PersonalCenterTabItemModel) item$iv2;
                            if (itemModel.getKeyId() == null) {
                                $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d41 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412;
                                i2 = i3;
                            } else {
                                i2 = i3;
                                if (TextUtils.equals(itemModel.getKeyId(), bubbleModel.getTargetItemId())) {
                                    View view2 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412.mRootView;
                                    GesturesRecyclerView recyclerView = view2 != null ? (GesturesRecyclerView) view2.findViewById(R.id.personalCenterGesturesRecyclerView) : null;
                                    if (recyclerView != null) {
                                        RecyclerView.ViewHolder holder = recyclerView.findViewHolderForAdapterPosition(indexGroup);
                                        if (holder == null) {
                                            GesturesRecyclerView gesturesRecyclerView = recyclerView;
                                            PersonalMixFragment personalMixFragment = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412;
                                            int i5 = index$iv2;
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(holder, "recyclerView?.findViewHo…indexGroup) ?: return@run");
                                            if (holder instanceof BaseHolder) {
                                                GesturesRecyclerView gesturesRecyclerView2 = recyclerView;
                                                PersonalMixFragment personalMixFragment2 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412;
                                                anchorView.element = ((BaseHolder) holder).getBubbleAnchorView(index$iv2, bubbleModel.getTargetItemId());
                                            } else {
                                                PersonalMixFragment personalMixFragment3 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412;
                                                int i6 = index$iv2;
                                            }
                                        }
                                    } else {
                                        PersonalMixFragment personalMixFragment4 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412;
                                        int i7 = index$iv2;
                                    }
                                } else {
                                    $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d41 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412;
                                    int i8 = index$iv2;
                                }
                            }
                            index$iv2 = index$iv3;
                            $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d41;
                            i3 = i2;
                        }
                        continue;
                    }
                    indexGroup = index$iv;
                    $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d412;
                    i3 = i3;
                }
            }
            if (anchorView.element != null && !BubbleGuideManager.INSTANCE.isBubbleShowing()) {
                PopupExclusionManagerMap.getInstance().display(PopupExclusionManagerMap.SCENE_MY, new PersonalMixFragment$tryShowPersonalCenterBubbleGuide$2(anchorView, bubbleModel, ExclusionType.MY_SETTING_GUIDE));
            }
        }
    }

    private final void tryShowPublishConfigGuideBubble() {
        ConstraintLayout constraintLayout;
        View view2 = this.mRootView;
        boolean z = false;
        if (!(view2 == null || (constraintLayout = (ConstraintLayout) view2.findViewById(R.id.publish_icon_layout)) == null || constraintLayout.getVisibility() != 0)) {
            z = true;
        }
        if (z) {
            getPersonalPageRequest().reqPublishConfigBubble(new PersonalMixFragment$tryShowPublishConfigGuideBubble$1(this));
        }
    }

    /* JADX WARNING: type inference failed for: r0v16, types: [android.view.View] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void resetPublishIcon() {
        /*
            r4 = this;
            android.view.View r0 = r4.mRootView
            r1 = 0
            if (r0 == 0) goto L_0x000e
            int r2 = com.baidu.searchbox.personalcenter.R.id.publish_config_bubble_text_layout
            android.view.View r0 = r0.findViewById(r2)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            r2 = 8
            if (r0 != 0) goto L_0x0014
            goto L_0x0017
        L_0x0014:
            r0.setVisibility(r2)
        L_0x0017:
            android.view.View r0 = r4.mRootView
            if (r0 == 0) goto L_0x0024
            int r3 = com.baidu.searchbox.personalcenter.R.id.publish_config_image
            android.view.View r0 = r0.findViewById(r3)
            com.facebook.drawee.view.SimpleDraweeView r0 = (com.facebook.drawee.view.SimpleDraweeView) r0
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            if (r0 != 0) goto L_0x0028
            goto L_0x002b
        L_0x0028:
            r0.setVisibility(r2)
        L_0x002b:
            android.view.View r0 = r4.mRootView
            if (r0 == 0) goto L_0x0038
            int r3 = com.baidu.searchbox.personalcenter.R.id.publish_config_bubble_text
            android.view.View r0 = r0.findViewById(r3)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0039
        L_0x0038:
            r0 = r1
        L_0x0039:
            if (r0 != 0) goto L_0x003c
            goto L_0x003f
        L_0x003c:
            r0.setVisibility(r2)
        L_0x003f:
            android.view.View r0 = r4.mRootView
            if (r0 == 0) goto L_0x004c
            int r3 = com.baidu.searchbox.personalcenter.R.id.publish_config_bubble_layout
            android.view.View r0 = r0.findViewById(r3)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x004d
        L_0x004c:
            r0 = r1
        L_0x004d:
            if (r0 != 0) goto L_0x0050
            goto L_0x0053
        L_0x0050:
            r0.setVisibility(r2)
        L_0x0053:
            android.view.View r0 = r4.mRootView
            if (r0 == 0) goto L_0x005e
            int r3 = com.baidu.searchbox.personalcenter.R.id.publish_config_bubble
            android.view.View r0 = r0.findViewById(r3)
            goto L_0x005f
        L_0x005e:
            r0 = r1
        L_0x005f:
            if (r0 != 0) goto L_0x0062
            goto L_0x0065
        L_0x0062:
            r0.setVisibility(r2)
        L_0x0065:
            android.view.View r0 = r4.mRootView
            if (r0 == 0) goto L_0x0076
            int r2 = com.baidu.searchbox.personalcenter.R.id.publish_config_bubble_layout
            android.view.View r0 = r0.findViewById(r2)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            if (r0 == 0) goto L_0x0076
            r0.setOnClickListener(r1)
        L_0x0076:
            android.view.View r0 = r4.mRootView
            if (r0 == 0) goto L_0x0083
            int r1 = com.baidu.searchbox.personalcenter.R.id.publish_icon
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x0083:
            if (r1 != 0) goto L_0x0086
            goto L_0x008a
        L_0x0086:
            r0 = 1
            r1.setClickable(r0)
        L_0x008a:
            android.view.View r0 = r4.mRootView
            if (r0 == 0) goto L_0x00a0
            int r1 = com.baidu.searchbox.personalcenter.R.id.publish_icon
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x00a0
            com.baidu.searchbox.personal.PersonalMixFragment$$ExternalSyntheticLambda6 r1 = new com.baidu.searchbox.personal.PersonalMixFragment$$ExternalSyntheticLambda6
            r1.<init>(r4)
            r0.setOnClickListener(r1)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.PersonalMixFragment.resetPublishIcon():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: resetPublishIcon$lambda-42  reason: not valid java name */
    public static final void m1995resetPublishIcon$lambda42(PersonalMixFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isDetached() && this$0.getContext() != null) {
            PersonCenterUBCStatistic.statisticUBCWithoutSource("fabu", "click", this$0.ubcExtBubbleJSONObject(), "wode", "192", PersonalConstants.PAGE_ZHUYE);
            PublishHelper.INSTANCE.onPublishIconClick(this$0.getContext());
        }
    }

    /* access modifiers changed from: private */
    public final void publishConfigBubbleInAnimation(Function0<Unit> onInAnimationEnd) {
        FrameLayout frameLayout;
        PublishConfigBubbleAnimationManager publishConfigBubbleAnimationManager = getPublishConfigBubbleAnimationManager();
        View view2 = this.mRootView;
        View findViewById = view2 != null ? view2.findViewById(R.id.publish_config_bubble) : null;
        View view3 = this.mRootView;
        publishConfigBubbleAnimationManager.doPublishConfigBubbleInAnimation(findViewById, (view3 == null || (frameLayout = (FrameLayout) view3.findViewById(R.id.publish_config_bubble_layout)) == null) ? 0.0f : (float) frameLayout.getWidth(), new PersonalMixFragment$publishConfigBubbleInAnimation$1(this, onInAnimationEnd));
    }

    /* access modifiers changed from: private */
    public final void publishConfigBubbleOutAnimation(Function0<Unit> onOutAnimationEnd) {
        View findViewById;
        PublishConfigBubbleAnimationManager publishConfigBubbleAnimationManager = getPublishConfigBubbleAnimationManager();
        View view2 = this.mRootView;
        View findViewById2 = view2 != null ? view2.findViewById(R.id.publish_config_bubble) : null;
        View view3 = this.mRootView;
        publishConfigBubbleAnimationManager.doPublishConfigBubbleOutAnimation(findViewById2, (view3 == null || (findViewById = view3.findViewById(R.id.publish_config_bubble)) == null) ? 0.0f : (float) findViewById.getWidth(), new PersonalMixFragment$publishConfigBubbleOutAnimation$1(this, onOutAnimationEnd));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v3, types: [org.json.JSONObject] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject ubcExtBubbleJSONObject() {
        /*
            r4 = this;
            java.lang.String r0 = r4.publishBubbleTitle
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x000f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            r1 = 0
            if (r0 != 0) goto L_0x003d
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r2 = "bubble_content"
            java.lang.String r3 = r4.publishBubbleTitle     // Catch:{ JSONException -> 0x0031 }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r2 = "uk"
            com.baidu.searchbox.account.data.BoxAccount r3 = r4.getBoxAccount()     // Catch:{ JSONException -> 0x0031 }
            if (r3 == 0) goto L_0x002d
            java.lang.String r1 = r3.getUk()     // Catch:{ JSONException -> 0x0031 }
        L_0x002d:
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0031 }
            goto L_0x003b
        L_0x0031:
            r1 = move-exception
            boolean r2 = com.baidu.searchbox.lightbrowser.RuntimeKt.isDebug()
            if (r2 == 0) goto L_0x003b
            r1.printStackTrace()
        L_0x003b:
            r1 = r0
            goto L_0x0040
        L_0x003d:
            r0 = r1
            org.json.JSONObject r0 = (org.json.JSONObject) r0
        L_0x0040:
            r0 = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.PersonalMixFragment.ubcExtBubbleJSONObject():org.json.JSONObject");
    }
}
