package com.baidu.searchbox.personal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.aipersonal.AiPersonalUtils;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.fragment.HomeBaseFragment;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.eventmessage.HomeTabClickEvent;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.download.center.statistic.PersonalCenterDurationUbc;
import com.baidu.searchbox.downloadcenter.service.IDownloadCenterFun;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.home.theme.IHomeThemeFun;
import com.baidu.searchbox.home.theme.IThemeApplyListener;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterDataWrapper;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.TipsType;
import com.baidu.searchbox.kmm.personalcenter.processors.PersonalCenterTabClickInfoProcessorKt;
import com.baidu.searchbox.newpersonalcenter.CustomLinearLayoutManager;
import com.baidu.searchbox.newpersonalcenter.GesturesRecyclerView;
import com.baidu.searchbox.newpersonalcenter.activity.PersonalActivity;
import com.baidu.searchbox.newpersonalcenter.adapter.PersonalAdapterWithHeader;
import com.baidu.searchbox.newpersonalcenter.listener.ISwanCardLiftCycleObserver;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.newpersonalcenter.managerpage.TemplateManagerCacheHelper;
import com.baidu.searchbox.newpersonalcenter.timer.PersonalTimerHelper;
import com.baidu.searchbox.newpersonalcenter.viewholder.BaseHolder;
import com.baidu.searchbox.personal.bubble.BubbleGuideManager;
import com.baidu.searchbox.personal.container.IPersonalizedContainerEventListener;
import com.baidu.searchbox.personal.header.PersonCenterHeaderView;
import com.baidu.searchbox.personal.manager.IPersonalizedDataListener;
import com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper;
import com.baidu.searchbox.personal.manager.UpgradeMgr;
import com.baidu.searchbox.personal.publish.PublishHelper;
import com.baidu.searchbox.personal.sidebar.SidebarWindowLayout;
import com.baidu.searchbox.personalcenter.PersonalCenterStateUtils;
import com.baidu.searchbox.personalcenter.PersonalCenterUbc;
import com.baidu.searchbox.personalcenter.PersonalDataChangeCallback;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.personalcenter.bubble.PersonalCenterBubbleModel;
import com.baidu.searchbox.personalcenter.commandlistener.PersonalNormalPublishSchemeListener;
import com.baidu.searchbox.personalcenter.ioc.PersonalCenterRuntime;
import com.baidu.searchbox.personalcenter.listener.IPersonalEventListener;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import com.baidu.searchbox.utils.PersonalCenterSpUtils;
import com.baidu.searchbox.utils.PersonalCenterUtils;
import com.baidu.searchbox.widget.ImmersionHelper;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0018\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020\fH\u0016J\u0012\u0010=\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010>\u001a\u00020:H\u0014J\u0010\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020!H\u0002J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020\u0011H\u0002J\b\u0010C\u001a\u00020:H\u0002J\u0010\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020\u0011H\u0017J\b\u0010F\u001a\u00020:H\u0002J\b\u0010G\u001a\u00020:H\u0002J\b\u0010H\u001a\u00020:H\u0002J\b\u0010I\u001a\u00020:H\u0002J\u0012\u0010J\u001a\u00020:2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0012\u0010M\u001a\u00020:2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\"\u0010P\u001a\u00020:2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020!H\u0016J\"\u0010U\u001a\u00020:2\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020!2\u0006\u0010T\u001a\u00020!H\u0016J\u0010\u0010Y\u001a\u00020:2\u0006\u0010Z\u001a\u00020[H\u0016J\u0012\u0010\\\u001a\u00020:2\b\u0010K\u001a\u0004\u0018\u00010LH\u0017J&\u0010]\u001a\u0004\u0018\u00010#2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010b\u001a\u00020:H\u0016J\b\u0010c\u001a\u00020:H\u0016J\u0018\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020\f2\u0006\u0010f\u001a\u00020\u0011H\u0016J\b\u0010g\u001a\u00020:H\u0016J\u001a\u0010h\u001a\u00020\u00112\u0006\u0010i\u001a\u00020!2\b\u0010j\u001a\u0004\u0018\u00010kH\u0016J\u001a\u0010l\u001a\u00020:2\b\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010f\u001a\u00020\u0011H\u0017J\u0018\u0010o\u001a\u00020:2\u0006\u0010p\u001a\u00020\u00112\u0006\u0010q\u001a\u00020\u0011H\u0016J\b\u0010r\u001a\u00020:H\u0016J\b\u0010s\u001a\u00020:H\u0016J\u0010\u0010t\u001a\u00020:2\u0006\u0010u\u001a\u00020!H\u0016J\u0010\u0010v\u001a\u00020:2\u0006\u0010w\u001a\u00020\u0011H\u0017J*\u0010x\u001a\u00020:2\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010S\u001a\u00020!2\u0006\u0010y\u001a\u00020!2\u0006\u0010T\u001a\u00020!H\u0016J\b\u0010z\u001a\u00020:H\u0016J\b\u0010{\u001a\u00020:H\u0016J\b\u0010|\u001a\u00020:H\u0016J\b\u0010}\u001a\u00020:H\u0016J\b\u0010~\u001a\u00020:H\u0016J+\u0010\u001a\u00020:2\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010S\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!2\u0006\u0010T\u001a\u00020!H\u0016J\t\u0010\u0001\u001a\u00020:H\u0016J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0001\u001a\u00020:H\u0007J\t\u0010\u0001\u001a\u00020:H\u0002J\t\u0010\u0001\u001a\u00020:H\u0002J\t\u0010\u0001\u001a\u00020:H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\u001a\u001a\u0004\b/\u00100R\u000e\u00102\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f05X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/baidu/searchbox/personal/PersonalizedFragment;", "Lcom/baidu/searchbox/appframework/fragment/HomeBaseFragment;", "Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "Lcom/baidu/searchbox/personal/container/IPersonalizedContainerEventListener;", "Lcom/baidu/searchbox/account/IAccountStatusChangedListener;", "Lcom/baidu/searchbox/personal/manager/IPersonalizedDataListener;", "Lcom/baidu/searchbox/personalcenter/PersonalDataChangeCallback;", "()V", "accountManager", "Lcom/baidu/searchbox/account/BoxAccountManager;", "attachedCardHistory", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mCenterHeaderView", "Lcom/baidu/searchbox/personal/header/PersonCenterHeaderView;", "mHasTheme", "", "mItemGroupAdapter", "Lcom/baidu/searchbox/newpersonalcenter/adapter/PersonalAdapterWithHeader;", "mLightStatusBar", "mListScrollListener", "Lcom/baidu/searchbox/personal/PersonalizedListScrollListener;", "getMListScrollListener", "()Lcom/baidu/searchbox/personal/PersonalizedListScrollListener;", "mListScrollListener$delegate", "Lkotlin/Lazy;", "mPageDurationUbc", "Lcom/baidu/searchbox/download/center/statistic/PersonalCenterDurationUbc;", "mPersonalEventListenerList", "", "Lcom/baidu/searchbox/personalcenter/listener/IPersonalEventListener;", "mPreActivityWidth", "", "mRootView", "Landroid/view/View;", "mSidebarWindow", "Lcom/baidu/searchbox/personal/sidebar/SidebarWindowLayout;", "mSource", "getMSource", "()Ljava/lang/String;", "setMSource", "(Ljava/lang/String;)V", "mThemeApplyListener", "Lcom/baidu/searchbox/home/theme/IThemeApplyListener;", "mVerticalScrollUbcTrigger", "Lcom/baidu/searchbox/personal/NewVerticalScrollUbcTrigger;", "getMVerticalScrollUbcTrigger", "()Lcom/baidu/searchbox/personal/NewVerticalScrollUbcTrigger;", "mVerticalScrollUbcTrigger$delegate", "needToast", "notifyDataSetChangedCount", "observerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/baidu/searchbox/newpersonalcenter/listener/ISwanCardLiftCycleObserver;", "sFirstResume", "topBackView", "addLiftCycleObserver", "", "observer", "groupId", "addToHistoryIfFirstAttached", "applyImmersion", "centerHeaderViewOnScrolled", "scrollY", "changeUseLightStatusBar", "lightStatusBar", "filterInvalidObserver", "notifyDataChange", "isOnlyRefreshCommonFun", "notifyDataSetChanged", "notifyObserversOnDestroy", "notifyObserversOnPause", "notifyObserversOnResume", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAddCardClickListener", "personalCenterGroupModel", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterGroupModel;", "onChildItemClickListener", "itemInfoModel", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "position", "cardPosition", "onClickMoreListener", "personalCenterTabModel", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "tabIndex", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onFailedCallback", "failToast", "isInitLocalData", "onFontSizeChange", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLoadSucceedCallback", "dataWrapper", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterDataWrapper;", "onLoginStatusChanged", "oldStatus", "newStatus", "onNestedChildScrolled", "onNestedScrollStopped", "onNestedScrolling", "dy", "onNightModeChanged", "isNightMode", "onPagerScrolledListener", "pageCount", "onPause", "onRefreshManagerData", "onResume", "onStart", "onStop", "onTabSelectedListener", "tabCount", "openPersonalSlide", "setUserVisibleHint", "isVisibleToUser", "stableApiStub", "tryShowPersonalCenterBubbleGuide", "tryShowPublishIcon", "useImmersion", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalizedFragment.kt */
public final class PersonalizedFragment extends HomeBaseFragment implements ModuleActionListener, IPersonalizedContainerEventListener, IAccountStatusChangedListener, IPersonalizedDataListener, PersonalDataChangeCallback {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private BoxAccountManager accountManager;
    private final HashSet<String> attachedCardHistory = new HashSet<>();
    /* access modifiers changed from: private */
    public PersonCenterHeaderView mCenterHeaderView;
    /* access modifiers changed from: private */
    public boolean mHasTheme;
    /* access modifiers changed from: private */
    public PersonalAdapterWithHeader mItemGroupAdapter;
    private boolean mLightStatusBar;
    private final Lazy mListScrollListener$delegate = LazyKt.lazy(new PersonalizedFragment$mListScrollListener$2(this));
    private final PersonalCenterDurationUbc mPageDurationUbc = new PersonalCenterDurationUbc();
    private List<? extends IPersonalEventListener> mPersonalEventListenerList;
    private int mPreActivityWidth;
    private View mRootView;
    /* access modifiers changed from: private */
    public SidebarWindowLayout mSidebarWindow;
    private String mSource = "wode";
    private final IThemeApplyListener mThemeApplyListener = new PersonalizedFragment$mThemeApplyListener$1(this);
    private final Lazy mVerticalScrollUbcTrigger$delegate = LazyKt.lazy(PersonalizedFragment$mVerticalScrollUbcTrigger$2.INSTANCE);
    private boolean needToast;
    private int notifyDataSetChangedCount;
    private final ConcurrentHashMap<ISwanCardLiftCycleObserver, String> observerMap = new ConcurrentHashMap<>();
    private boolean sFirstResume = true;
    private View topBackView;

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

    @StableApi
    public final void stableApiStub() {
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
        PersonalizedDataManagerWrapper.INSTANCE.registerListener(this);
        boolean z = false;
        PersonalizedDataManagerWrapper.loadDataSync$default(PersonalizedDataManagerWrapper.INSTANCE, false, (String) null, 2, (Object) null);
        if (UpgradeMgr.INSTANCE.shouldCheckUpgrade$lib_personal_center_release()) {
            UpgradeMgr.INSTANCE.setCanShowEntranceBubble(true);
            UpgradeMgr.INSTANCE.registerCallback$lib_personal_center_release("personal_upgrade", new PersonalizedFragment$onCreate$2(this));
            UpgradeMgr.INSTANCE.checkUpgradeIfNeed$lib_personal_center_release(getActivity());
        }
        IHomeThemeFun iHomeThemeFun = (IHomeThemeFun) ServiceManager.getService(IHomeThemeFun.SERVICE_REFERENCE);
        if (iHomeThemeFun != null) {
            iHomeThemeFun.addThemeListener(this.mThemeApplyListener);
        }
        BdEventBus.Companion.getDefault().register(this, HomeTabClickEvent.class, 1, new PersonalizedFragment$$ExternalSyntheticLambda1(this));
        BdEventBus.Companion.getDefault().register(this, PersonalDataChangeEvent.class, 1, new PersonalizedFragment$$ExternalSyntheticLambda2(this));
        NewPersonalItemNewTip.getInstance().setTipChangeListener(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z = arguments.getBoolean(PersonalActivity.NEED_SWITCH_TOAST);
        }
        this.needToast = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m2011onCreate$lambda2(PersonalizedFragment this$0, HomeTabClickEvent homeTabClickEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(homeTabClickEvent, "homeTabClickEvent");
        List<? extends IPersonalEventListener> $this$forEach$iv = this$0.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.homeTabClickEvent(homeTabClickEvent);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m2012onCreate$lambda3(PersonalizedFragment this$0, PersonalDataChangeEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        PersonalDataChangeCallback.DefaultImpls.notifyDataChange$default(this$0, false, 1, (Object) null);
        SidebarWindowLayout sidebarWindowLayout = this$0.mSidebarWindow;
        if (sidebarWindowLayout != null) {
            sidebarWindowLayout.setData(PersonalizedDataManagerWrapper.INSTANCE.getSlideGroupsData());
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View findViewById;
        View findViewById2;
        GesturesRecyclerView gesturesRecyclerView;
        GesturesRecyclerView gesturesRecyclerView2;
        GesturesRecyclerView gesturesRecyclerView3;
        GesturesRecyclerView gesturesRecyclerView4;
        GesturesRecyclerView gesturesRecyclerView5;
        GesturesRecyclerView gesturesRecyclerView6;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewGroup.LayoutParams layoutParams = null;
        Context contextActual = container != null ? container.getContext() : null;
        if (contextActual == null) {
            return null;
        }
        if (this.mRootView == null) {
            this.mRootView = inflater.inflate(R.layout.personal_center_fragment, container, false);
            PersonalAdapterWithHeader personalAdapterWithHeader = new PersonalAdapterWithHeader(contextActual);
            this.mItemGroupAdapter = personalAdapterWithHeader;
            personalAdapterWithHeader.setModuleActionListener(this);
            View view2 = this.mRootView;
            if (!(view2 == null || (gesturesRecyclerView6 = (GesturesRecyclerView) view2.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
                gesturesRecyclerView6.setItemViewCacheSize(20);
            }
            View view3 = this.mRootView;
            if (!(view3 == null || (gesturesRecyclerView5 = (GesturesRecyclerView) view3.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
                gesturesRecyclerView5.setBackgroundColor(ContextCompat.getColor(contextActual, R.color.GC108));
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
            PersonCenterHeaderView personCenterHeaderView = new PersonCenterHeaderView(getContext());
            this.mCenterHeaderView = personCenterHeaderView;
            PersonalAdapterWithHeader personalAdapterWithHeader2 = this.mItemGroupAdapter;
            if (personalAdapterWithHeader2 != null) {
                personalAdapterWithHeader2.addHeaderView(personCenterHeaderView);
            }
            PersonalAdapterWithHeader personalAdapterWithHeader3 = this.mItemGroupAdapter;
            if (personalAdapterWithHeader3 != null) {
                personalAdapterWithHeader3.setData(PersonalizedDataManagerWrapper.INSTANCE.getMergedGroupModels());
            }
            View view9 = this.mRootView;
            GesturesRecyclerView gesturesRecyclerView8 = view9 != null ? (GesturesRecyclerView) view9.findViewById(R.id.personalCenterGesturesRecyclerView) : null;
            if (gesturesRecyclerView8 != null) {
                gesturesRecyclerView8.setAdapter(this.mItemGroupAdapter);
            }
            View view10 = this.mRootView;
            if (!(view10 == null || (findViewById2 = view10.findViewById(R.id.personalCenterStatusBarBackground)) == null)) {
                findViewById2.setBackgroundColor(ContextCompat.getColor(contextActual, R.color.GC9));
            }
            View view11 = this.mRootView;
            if (!(view11 == null || (findViewById = view11.findViewById(R.id.personalCenterStatusBarBackground)) == null)) {
                layoutParams = findViewById.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.height = DeviceUtils.ScreenInfo.getStatusBarHeight();
            }
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
        tryShowPublishIcon();
        return this.mRootView;
    }

    private final void tryShowPublishIcon() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4 = null;
        if (!PersonalCenterSpUtils.getBoolean(PersonalNormalPublishSchemeListener.NORMAL_PERSONAL_SHOW_PUBLISH_BUTTON_KEY, true)) {
            View view2 = this.mRootView;
            if (view2 != null) {
                imageView4 = (ImageView) view2.findViewById(R.id.publish_icon);
            }
            if (imageView4 != null) {
                imageView4.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.mRootView;
        ImageView imageView5 = view3 != null ? (ImageView) view3.findViewById(R.id.publish_icon) : null;
        if (imageView5 != null) {
            imageView5.setVisibility(0);
        }
        View view4 = this.mRootView;
        if (!(view4 == null || (imageView3 = (ImageView) view4.findViewById(R.id.publish_icon)) == null)) {
            imageView3.setImageResource(R.drawable.personal_publish_icon);
        }
        float dimension = getResources().getDimension(R.dimen.personal_feed_publish_width);
        View view5 = this.mRootView;
        FontSizeViewExtKt.setScaledSize$default(view5 != null ? (ImageView) view5.findViewById(R.id.publish_icon) : null, 2, dimension, dimension, 0, 8, (Object) null);
        Bundle arguments = getArguments();
        if (arguments != null ? arguments.getBoolean(PersonalActivity.PERSONAL_IS_FROM_MENU) : false) {
            View view6 = this.mRootView;
            ViewGroup.LayoutParams layoutParams = (view6 == null || (imageView2 = (ImageView) view6.findViewById(R.id.publish_icon)) == null) ? null : imageView2.getLayoutParams();
            RelativeLayout.LayoutParams publishParams = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if (publishParams != null) {
                publishParams.setMargins(0, 0, DeviceUtils.ScreenInfo.dp2px(getContext(), 14.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 24.0f));
            }
            View view7 = this.mRootView;
            if (view7 != null) {
                imageView4 = (ImageView) view7.findViewById(R.id.publish_icon);
            }
            if (imageView4 != null) {
                imageView4.setLayoutParams(publishParams);
            }
        }
        View view8 = this.mRootView;
        if (!(view8 == null || (imageView = (ImageView) view8.findViewById(R.id.publish_icon)) == null)) {
            imageView.setOnClickListener(new PersonalizedFragment$$ExternalSyntheticLambda3(this));
        }
        PersonCenterUBCStatistic.statisticUBCWithoutSource("fabu", "show", (JSONObject) null, "wode", "192", "normal");
    }

    /* access modifiers changed from: private */
    /* renamed from: tryShowPublishIcon$lambda-5  reason: not valid java name */
    public static final void m2014tryShowPublishIcon$lambda5(PersonalizedFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isDetached() && this$0.getContext() != null) {
            PersonCenterUBCStatistic.statisticUBCWithoutSource("fabu", "click", (JSONObject) null, "wode", "192", "normal");
            PublishHelper.INSTANCE.onNormalPersonalPublishIconClick(this$0.getContext());
        }
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

    public void onStart() {
        super.onStart();
        if (UpgradeMgr.INSTANCE.shouldCheckUpgrade$lib_personal_center_release()) {
            UpgradeMgr.INSTANCE.setCanShowEntranceBubble(true);
        }
    }

    public void onResume() {
        View view2;
        GesturesRecyclerView gesturesRecyclerView;
        super.onResume();
        PersonalCenterStateUtils.INSTANCE.setPersonalFragmentVisible(true);
        if (!this.sFirstResume) {
            PersonalizedDataManagerWrapper.loadDataSync$default(PersonalizedDataManagerWrapper.INSTANCE, false, (String) null, 2, (Object) null);
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
        Context it = getContext();
        if (!(it == null || (view2 = this.mRootView) == null || (gesturesRecyclerView = (GesturesRecyclerView) view2.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
            gesturesRecyclerView.setBackgroundColor(ContextCompat.getColor(it, R.color.GC108));
        }
        PersonCenterHeaderView personCenterHeaderView = this.mCenterHeaderView;
        if (personCenterHeaderView != null) {
            personCenterHeaderView.onResume();
        }
        notifyObserversOnResume();
        getMVerticalScrollUbcTrigger().setVisible(true);
        this.mPageDurationUbc.beginDurationFlow("my_home");
        PersonalCenterUbc.showPersonalMixPageUbc(this.mSource, getContext());
        PersonalTimerHelper.INSTANCE.startTimer();
        this.notifyDataSetChangedCount = 0;
        if (this.needToast || PersonalActivity.Companion.getMENU_CHANGE_PERSONAL()) {
            if (PersonalActivity.Companion.getMENU_CHANGE_PERSONAL_COUNT() == 0) {
                Context it2 = getContext();
                if (it2 != null) {
                    UniversalToast.makeText(it2, (CharSequence) getString(R.string.personal_change_to_common)).setOverFloatWindow(true).show();
                }
            } else {
                PersonalActivity.Companion.setMENU_CHANGE_PERSONAL(false);
                PersonalActivity.Companion.setMENU_CHANGE_PERSONAL_COUNT(0);
            }
            this.needToast = false;
            if (PersonalActivity.Companion.getMENU_CHANGE_PERSONAL()) {
                PersonalActivity.Companion companion = PersonalActivity.Companion;
                companion.setMENU_CHANGE_PERSONAL_COUNT(companion.getMENU_CHANGE_PERSONAL_COUNT() + 1);
            }
        }
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it3 : $this$forEach$iv) {
                it3.onResume();
            }
        }
    }

    public void onPause() {
        super.onPause();
        PersonalizedDataManagerWrapper.INSTANCE.setMIsRequestReturn(false);
        if (UpgradeMgr.INSTANCE.getUpgradeCheckResult$lib_personal_center_release() == null) {
            UpgradeMgr.INSTANCE.setUpgradeResultReturn(false);
        }
        BubbleGuideManager.INSTANCE.dismissBubble();
        PersonalCenterStateUtils.INSTANCE.setPersonalFragmentVisible(false);
        PersonCenterHeaderView personCenterHeaderView = this.mCenterHeaderView;
        if (personCenterHeaderView != null) {
            personCenterHeaderView.onPause();
        }
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onPause();
            }
        }
        notifyObserversOnPause();
        getMVerticalScrollUbcTrigger().setVisible(false);
        this.mPageDurationUbc.endDurationFlow("my_home");
        PersonalTimerHelper.INSTANCE.pauseTimer();
    }

    public void onStop() {
        super.onStop();
        PersonCenterHeaderView personCenterHeaderView = this.mCenterHeaderView;
        if (personCenterHeaderView != null) {
            personCenterHeaderView.onStop();
        }
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onStop();
            }
        }
        getMVerticalScrollUbcTrigger().clear();
        this.attachedCardHistory.clear();
    }

    public void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDestroy() {
        super.onDestroy();
        PersonCenterHeaderView personCenterHeaderView = this.mCenterHeaderView;
        if (personCenterHeaderView != null) {
            personCenterHeaderView.onDestroy();
        }
        List<? extends IPersonalEventListener> $this$forEach$iv = this.mPersonalEventListenerList;
        if ($this$forEach$iv != null) {
            for (IPersonalEventListener it : $this$forEach$iv) {
                it.onDestroy();
            }
        }
        notifyObserversOnDestroy();
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
        UpgradeMgr.INSTANCE.removeCallback$lib_personal_center_release("personal_upgrade");
        SidebarWindowLayout sidebarWindowLayout = this.mSidebarWindow;
        if (sidebarWindowLayout != null) {
            sidebarWindowLayout.setDimissCallback((Function0<Unit>) null);
        }
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
    }

    /* access modifiers changed from: protected */
    public void applyImmersion() {
        useImmersion();
    }

    private final void useImmersion() {
        FragmentActivity activity;
        GesturesRecyclerView gesturesRecyclerView;
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
            View firstVisiableChildView = null;
            LinearLayoutManager layoutManager = (LinearLayoutManager) ((view2 == null || (gesturesRecyclerView = (GesturesRecyclerView) view2.findViewById(R.id.personalCenterGesturesRecyclerView)) == null) ? null : gesturesRecyclerView.getLayoutManager());
            int firstVisibleItemPosition = layoutManager != null ? layoutManager.findFirstVisibleItemPosition() : -1;
            if (firstVisibleItemPosition == 0) {
                if (layoutManager != null) {
                    firstVisiableChildView = layoutManager.findViewByPosition(0);
                }
                int scrollY = -(firstVisiableChildView != null ? firstVisiableChildView.getTop() : 0);
                PersonCenterHeaderView personCenterHeaderView = this.mCenterHeaderView;
                if (personCenterHeaderView != null) {
                    statusBarAnimEnd = personCenterHeaderView.getStatusBarAnimEnd();
                }
                if (scrollY < statusBarAnimEnd || !this.mHasTheme) {
                    this.mImmersionHelper.getConfig().setUseLightStatusBar(isLightStatusBar);
                } else {
                    changeUseLightStatusBar(true);
                }
            } else if (firstVisibleItemPosition >= 1) {
                if (this.mHasTheme) {
                    changeUseLightStatusBar(true);
                } else {
                    this.mImmersionHelper.getConfig().setUseLightStatusBar(isLightStatusBar);
                }
                View view3 = this.mRootView;
                if (view3 != null) {
                    firstVisiableChildView = view3.findViewById(R.id.personalCenterStatusBarBackground);
                }
                if (firstVisiableChildView != null) {
                    firstVisiableChildView.setAlpha(1.0f);
                }
            } else {
                this.mImmersionHelper.getConfig().setUseLightStatusBar(isLightStatusBar);
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
        PersonCenterHeaderView personCenterHeaderView = this.mCenterHeaderView;
        if (personCenterHeaderView != null) {
            if (personCenterHeaderView != null) {
                personCenterHeaderView.onScrolled(scrollY);
            }
            PersonCenterHeaderView personCenterHeaderView2 = this.mCenterHeaderView;
            int loginViewAnimEnd = personCenterHeaderView2 != null ? personCenterHeaderView2.getHeaderLoginViewAnimEnd() : 0;
            PersonCenterHeaderView personCenterHeaderView3 = this.mCenterHeaderView;
            int statusBarAnimEnd = personCenterHeaderView3 != null ? personCenterHeaderView3.getStatusBarAnimEnd() : 0;
            int distance = statusBarAnimEnd - loginViewAnimEnd;
            View view2 = null;
            if (scrollY < loginViewAnimEnd) {
                View view3 = this.mRootView;
                if (view3 != null) {
                    view2 = view3.findViewById(R.id.personalCenterStatusBarBackground);
                }
                if (view2 != null) {
                    view2.setAlpha(0.0f);
                }
            } else if (scrollY <= statusBarAnimEnd) {
                float rate = ((float) (scrollY - loginViewAnimEnd)) / (((float) distance) * 1.0f);
                View view4 = this.mRootView;
                if (view4 != null) {
                    view2 = view4.findViewById(R.id.personalCenterStatusBarBackground);
                }
                if (view2 != null) {
                    view2.setAlpha(rate);
                }
            } else {
                View view5 = this.mRootView;
                if (view5 != null) {
                    view2 = view5.findViewById(R.id.personalCenterStatusBarBackground);
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
            PersonCenterHeaderView personCenterHeaderView4 = this.mCenterHeaderView;
            if (scrollY < (personCenterHeaderView4 != null ? personCenterHeaderView4.getMHeaderOtherViewAnimEnd() : 0)) {
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
        r0 = (com.baidu.searchbox.newpersonalcenter.GesturesRecyclerView) r0.findViewById(com.baidu.searchbox.personalcenter.R.id.personalCenterGesturesRecyclerView);
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
            int r2 = com.baidu.searchbox.personalcenter.R.id.personalCenterGesturesRecyclerView
            android.view.View r0 = r0.findViewById(r2)
            com.baidu.searchbox.newpersonalcenter.GesturesRecyclerView r0 = (com.baidu.searchbox.newpersonalcenter.GesturesRecyclerView) r0
            if (r0 == 0) goto L_0x0032
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            if (r0 == 0) goto L_0x0040
            int r2 = r0.findFirstVisibleItemPosition()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0041
        L_0x0040:
            r2 = r1
        L_0x0041:
            if (r2 != 0) goto L_0x0044
            goto L_0x0061
        L_0x0044:
            int r3 = r2.intValue()
            if (r3 != 0) goto L_0x0061
            r1 = 0
            android.view.View r3 = r0.findViewByPosition(r1)
            if (r3 == 0) goto L_0x0055
            int r1 = r3.getTop()
        L_0x0055:
            int r1 = -r1
            r6.centerHeaderViewOnScrolled(r1)
            com.baidu.searchbox.personal.header.PersonCenterHeaderView r4 = r6.mCenterHeaderView
            if (r4 == 0) goto L_0x007b
            r4.disMissBubble()
            goto L_0x007b
        L_0x0061:
            boolean r3 = r6.mHasTheme
            if (r3 == 0) goto L_0x0069
            r3 = 1
            r6.changeUseLightStatusBar(r3)
        L_0x0069:
            android.view.View r3 = r6.mRootView
            if (r3 == 0) goto L_0x0073
            int r1 = com.baidu.searchbox.personalcenter.R.id.personalCenterStatusBarBackground
            android.view.View r1 = r3.findViewById(r1)
        L_0x0073:
            if (r1 != 0) goto L_0x0076
            goto L_0x007b
        L_0x0076:
            r3 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r3)
        L_0x007b:
            com.baidu.searchbox.personal.bubble.BubbleGuideManager r1 = com.baidu.searchbox.personal.bubble.BubbleGuideManager.INSTANCE
            r1.dismissBubble()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.PersonalizedFragment.onNestedScrolling(int):void");
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
                personalAdapterWithHeader.setData(PersonalizedDataManagerWrapper.INSTANCE.getMergedGroupModels());
            }
            PersonalAdapterWithHeader personalAdapterWithHeader2 = this.mItemGroupAdapter;
            if (personalAdapterWithHeader2 != null) {
                personalAdapterWithHeader2.notifyDataSetChanged();
            }
        } else {
            notifyDataSetChanged();
        }
        UiThreadUtils.runOnUiThread(new PersonalizedFragment$$ExternalSyntheticLambda5(this), 1000);
        if (!isInitLocalData) {
            filterInvalidObserver();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onLoadSucceedCallback$lambda-18  reason: not valid java name */
    public static final void m2013onLoadSucceedCallback$lambda18(PersonalizedFragment this$0) {
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
        ImageView it;
        View view2;
        ImageView imageView;
        GesturesRecyclerView gesturesRecyclerView;
        View findViewById;
        super.onNightModeChanged(isNightMode);
        PersonCenterHeaderView personCenterHeaderView = this.mCenterHeaderView;
        if (personCenterHeaderView != null) {
            personCenterHeaderView.onNightModeChanged(isNightMode);
        }
        Context it2 = getContext();
        if (it2 != null) {
            View view3 = this.mRootView;
            if (!(view3 == null || (findViewById = view3.findViewById(R.id.personalCenterStatusBarBackground)) == null)) {
                findViewById.setBackgroundColor(ContextCompat.getColor(it2, R.color.GC9));
            }
            View view4 = this.mRootView;
            if (!(view4 == null || (gesturesRecyclerView = (GesturesRecyclerView) view4.findViewById(R.id.personalCenterGesturesRecyclerView)) == null)) {
                gesturesRecyclerView.setBackgroundColor(ContextCompat.getColor(it2, R.color.GC108));
            }
        }
        PersonalizedDataManagerWrapper.INSTANCE.getManager().updateNightModeData(isNightMode, new PersonalizedFragment$onNightModeChanged$2(this));
        View view5 = this.mRootView;
        if (view5 != null && (it = (ImageView) view5.findViewById(R.id.publish_icon)) != null && it.getVisibility() != 8 && (view2 = this.mRootView) != null && (imageView = (ImageView) view2.findViewById(R.id.publish_icon)) != null) {
            imageView.setImageResource(R.drawable.personal_publish_icon);
        }
    }

    public void onChildItemClickListener(PersonalCenterTabItemModel itemInfoModel, int position, int cardPosition) {
        String ubcType;
        if (itemInfoModel != null) {
            if (cardPosition > 0) {
                try {
                    ubcType = String.valueOf(cardPosition);
                } catch (Exception e2) {
                }
            } else {
                ubcType = itemInfoModel.getUbcType();
            }
            PersonCenterUBCStatistic.statisticUBC(ubcType, NewVerticalScrollUbcTrigger.getTipsSource(itemInfoModel), NewVerticalScrollUbcTrigger.getValue(itemInfoModel, "click"), NewVerticalScrollUbcTrigger.getExt(itemInfoModel), NewVerticalScrollUbcTrigger.getFrom((PersonalCenterTabModel) null, itemInfoModel), itemInfoModel.getUbcEventId(), NewVerticalScrollUbcTrigger.getPage(itemInfoModel, position));
            if (TextUtils.equals(itemInfoModel.getKeyId(), "liuchangbo")) {
                ((IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE)).updateLCBClickTime();
            }
            AiPersonalUtils aiPersonalUtils = AiPersonalUtils.INSTANCE;
            String keyId = itemInfoModel.getKeyId();
            String simpleName = PersonalizedFragment.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "PersonalizedFragment::class.java.simpleName");
            aiPersonalUtils.updateNetDiskClickTime(keyId, simpleName);
            itemInfoModel.setTipsType(TipsType.NONE);
            itemInfoModel.setTipText("");
            NewPersonalItemNewTip.getInstance().setItemRead(itemInfoModel.getKeyId());
            String groupId = itemInfoModel.getGroupId();
            String clickTime = String.valueOf(System.currentTimeMillis() / ((long) 1000));
            TemplateManagerCacheHelper.INSTANCE.updateSelectedTabsClickTime(groupId, clickTime);
            PersonalCenterTabClickInfoProcessorKt.updatePersonalisedTabsClickTime(PersonalizedDataManagerWrapper.INSTANCE.getManager(), groupId, clickTime);
        }
    }

    public void onTabSelectedListener(PersonalCenterTabModel personalCenterTabModel, int position, int tabCount, int cardPosition) {
    }

    public void onPagerScrolledListener(PersonalCenterTabModel personalCenterTabModel, int position, int pageCount, int cardPosition) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022 A[Catch:{ Exception -> 0x000a }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[Catch:{ Exception -> 0x000a }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[Catch:{ Exception -> 0x000a }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[Catch:{ Exception -> 0x000a }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClickMoreListener(com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r10, int r11, int r12) {
        /*
            r9 = this;
            r0 = 0
            if (r12 <= 0) goto L_0x000c
            java.lang.String r1 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x000a }
        L_0x0008:
            r2 = r1
            goto L_0x0014
        L_0x000a:
            r1 = move-exception
            goto L_0x0038
        L_0x000c:
            if (r10 == 0) goto L_0x0013
            java.lang.String r1 = r10.getUbcType()     // Catch:{ Exception -> 0x000a }
            goto L_0x0008
        L_0x0013:
            r2 = r0
        L_0x0014:
            java.lang.String r3 = com.baidu.searchbox.personal.NewVerticalScrollUbcTrigger.getTabTipsSource(r10)     // Catch:{ Exception -> 0x000a }
            java.lang.String r4 = "click"
            org.json.JSONObject r5 = com.baidu.searchbox.personal.NewVerticalScrollUbcTrigger.getExt((com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r10)     // Catch:{ Exception -> 0x000a }
            if (r10 == 0) goto L_0x0028
            java.lang.String r1 = r10.getUbcFrom()     // Catch:{ Exception -> 0x000a }
            r6 = r1
            goto L_0x0029
        L_0x0028:
            r6 = r0
        L_0x0029:
            if (r10 == 0) goto L_0x0031
            java.lang.String r1 = r10.getUbcId()     // Catch:{ Exception -> 0x000a }
            r7 = r1
            goto L_0x0032
        L_0x0031:
            r7 = r0
        L_0x0032:
            java.lang.String r8 = "more"
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBC(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x000a }
        L_0x0038:
            if (r10 != 0) goto L_0x003b
            goto L_0x0040
        L_0x003b:
            com.baidu.searchbox.kmm.personalcenter.entities.constants.TipsType r1 = com.baidu.searchbox.kmm.personalcenter.entities.constants.TipsType.NONE
            r10.setTipsType(r1)
        L_0x0040:
            com.baidu.searchbox.personal.NewPersonalItemNewTip r1 = com.baidu.searchbox.personal.NewPersonalItemNewTip.getInstance()
            if (r10 == 0) goto L_0x004b
            java.lang.String r2 = r10.getTabId()
            goto L_0x004c
        L_0x004b:
            r2 = r0
        L_0x004c:
            r1.setItemRead(r2)
            if (r10 == 0) goto L_0x0055
            java.lang.String r0 = r10.getGroupId()
        L_0x0055:
            if (r0 == 0) goto L_0x0073
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, float:1.401E-42)
            long r3 = (long) r3
            long r1 = r1 / r3
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.baidu.searchbox.newpersonalcenter.managerpage.TemplateManagerCacheHelper r2 = com.baidu.searchbox.newpersonalcenter.managerpage.TemplateManagerCacheHelper.INSTANCE
            r2.updateSelectedTabsClickTime(r0, r1)
            com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper r2 = com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper.INSTANCE
            com.baidu.searchbox.kmm.personalcenter.PersonalCenterDataMgr r2 = r2.getManager()
            com.baidu.searchbox.kmm.personalcenter.processors.PersonalCenterTabClickInfoProcessorKt.updatePersonalisedTabsClickTime(r2, r0, r1)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.PersonalizedFragment.onClickMoreListener(com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel, int, int):void");
    }

    public void onAddCardClickListener(PersonalCenterGroupModel personalCenterGroupModel) {
    }

    public void onRefreshManagerData() {
    }

    public void addLiftCycleObserver(ISwanCardLiftCycleObserver observer, String groupId) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        if (!TextUtils.isEmpty(groupId)) {
            this.observerMap.put(observer, groupId);
        }
    }

    private final void notifyObserversOnResume() {
        Set<ISwanCardLiftCycleObserver> keySet = this.observerMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "observerMap.keys");
        if (!keySet.isEmpty()) {
            for (ISwanCardLiftCycleObserver observer : keySet) {
                observer.onResume();
            }
        }
    }

    private final void notifyObserversOnPause() {
        Set<ISwanCardLiftCycleObserver> keySet = this.observerMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "observerMap.keys");
        if (!keySet.isEmpty()) {
            for (ISwanCardLiftCycleObserver observer : keySet) {
                observer.onPause();
            }
        }
    }

    private final void notifyObserversOnDestroy() {
        Set<ISwanCardLiftCycleObserver> keySet = this.observerMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "observerMap.keys");
        if (!keySet.isEmpty()) {
            for (ISwanCardLiftCycleObserver observer : keySet) {
                observer.onDestroy();
                this.observerMap.remove(observer);
            }
        }
    }

    public boolean addToHistoryIfFirstAttached(String groupId) {
        if (this.attachedCardHistory.contains(groupId)) {
            return false;
        }
        this.attachedCardHistory.add(groupId);
        return true;
    }

    public void openPersonalSlide() {
        SidebarWindowLayout sidebarWindowLayout;
        PersonCenterHeaderView personCenterHeaderView = this.mCenterHeaderView;
        if (personCenterHeaderView != null) {
            personCenterHeaderView.disMissBubble();
        }
        BubbleGuideManager.INSTANCE.dismissBubble();
        if (getContext() != null && (getContext() instanceof Activity)) {
            List<PersonalCenterTabModel> slideGroupsData = PersonalizedDataManagerWrapper.INSTANCE.getSlideGroupsData();
            Collection collection = slideGroupsData;
            if (!(collection == null || collection.isEmpty())) {
                if (this.mSidebarWindow == null) {
                    Context context = getContext();
                    if (context != null) {
                        this.mSidebarWindow = new SidebarWindowLayout((Activity) context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                }
                SidebarWindowLayout sidebarWindowLayout2 = this.mSidebarWindow;
                if ((sidebarWindowLayout2 != null ? sidebarWindowLayout2.getDimissCallback() : null) == null && (sidebarWindowLayout = this.mSidebarWindow) != null) {
                    sidebarWindowLayout.setDimissCallback(new PersonalizedFragment$openPersonalSlide$1(this));
                }
                SidebarWindowLayout sidebarWindowLayout3 = this.mSidebarWindow;
                if (sidebarWindowLayout3 != null) {
                    sidebarWindowLayout3.setData(slideGroupsData);
                }
                SidebarWindowLayout sidebarWindowLayout4 = this.mSidebarWindow;
                if (sidebarWindowLayout4 != null) {
                    sidebarWindowLayout4.showView();
                }
            }
        }
    }

    private final void filterInvalidObserver() {
        Set iSwanCardLiftCycleObservers = this.observerMap.keySet();
        Intrinsics.checkNotNullExpressionValue(iSwanCardLiftCycleObservers, "observerMap.keys");
        for (ISwanCardLiftCycleObserver observer : iSwanCardLiftCycleObservers) {
            if (!PersonalizedDataManagerWrapper.INSTANCE.getManager().hasGroupData(this.observerMap.get(observer))) {
                observer.onDestroy();
                this.observerMap.remove(observer);
            }
        }
    }

    public void notifyDataChange(boolean isOnlyRefreshCommonFun) {
        notifyDataSetChanged();
    }

    private final void notifyDataSetChanged() {
        this.notifyDataSetChangedCount++;
        if (AppConfig.isDebug()) {
            Log.d("NewPersonal", "notifyDataSetChangedCount" + this.notifyDataSetChangedCount);
        }
        UiThreadUtils.runOnUiThread(new PersonalizedFragment$$ExternalSyntheticLambda4(this), 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: notifyDataSetChanged$lambda-22  reason: not valid java name */
    public static final void m2009notifyDataSetChanged$lambda22(PersonalizedFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.notifyDataSetChangedCount == 1) {
            if (AppConfig.isDebug()) {
                Log.d("NewPersonal", "notifyDataSetChangedCount = 1 可以刷新");
            }
            this$0.notifyDataSetChangedCount = 0;
            PersonalAdapterWithHeader personalAdapterWithHeader = this$0.mItemGroupAdapter;
            if (personalAdapterWithHeader != null) {
                personalAdapterWithHeader.setData(PersonalizedDataManagerWrapper.INSTANCE.getMergedGroupModels());
            }
            PersonalAdapterWithHeader personalAdapterWithHeader2 = this$0.mItemGroupAdapter;
            if (personalAdapterWithHeader2 != null) {
                personalAdapterWithHeader2.notifyDataSetChanged();
            }
            if (PersonalizedDataManagerWrapper.INSTANCE.getMIsRequestReturn()) {
                UiThreadUtils.getMainHandler().post(new PersonalizedFragment$$ExternalSyntheticLambda0(this$0));
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
    public static final void m2010notifyDataSetChanged$lambda22$lambda21(PersonalizedFragment this$0) {
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
        ImageView it;
        PersonalAdapterWithHeader personalAdapterWithHeader = this.mItemGroupAdapter;
        if (personalAdapterWithHeader != null) {
            personalAdapterWithHeader.notifyDataSetChanged();
        }
        SidebarWindowLayout sidebarWindowLayout = this.mSidebarWindow;
        if (sidebarWindowLayout != null) {
            sidebarWindowLayout.updateUI();
        }
        View view2 = this.mRootView;
        if (view2 != null && (it = (ImageView) view2.findViewById(R.id.publish_icon)) != null && it.getVisibility() != 8) {
            float dimension = getResources().getDimension(R.dimen.personal_feed_publish_width);
            View view3 = this.mRootView;
            FontSizeViewExtKt.setScaledSize$default(view3 != null ? (ImageView) view3.findViewById(R.id.publish_icon) : null, 2, dimension, dimension, 0, 8, (Object) null);
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        SidebarWindowLayout sidebarWindowLayout;
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser && (sidebarWindowLayout = this.mSidebarWindow) != null) {
            sidebarWindowLayout.dismissView();
        }
    }

    /* access modifiers changed from: private */
    public final void tryShowPersonalCenterBubbleGuide() {
        List<PersonalCenterGroupModel> $this$forEachIndexed$iv;
        List<PersonalCenterTabItemModel> $this$forEachIndexed$iv2;
        int i2;
        PersonalizedFragment $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d26;
        PersonalCenterBubbleModel bubbleModel = BubbleGuideManager.INSTANCE.getBubbleToShow();
        if (bubbleModel != null) {
            Ref.ObjectRef anchorView = new Ref.ObjectRef();
            if (Intrinsics.areEqual((Object) bubbleModel.getBubbleClass(), (Object) "4")) {
                PersonCenterHeaderView personCenterHeaderView = this.mCenterHeaderView;
                if (personCenterHeaderView != null) {
                    personCenterHeaderView.tryToShowGuide(bubbleModel);
                    return;
                }
                return;
            }
            PersonCenterHeaderView personCenterHeaderView2 = this.mCenterHeaderView;
            if (personCenterHeaderView2 != null) {
                personCenterHeaderView2.checkShowSideDataTips();
            }
            PersonalizedFragment $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262 = this;
            int i3 = false;
            PersonalAdapterWithHeader personalAdapterWithHeader = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262.mItemGroupAdapter;
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
                                $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d26 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262;
                                i2 = i3;
                            } else {
                                i2 = i3;
                                if (TextUtils.equals(itemModel.getKeyId(), bubbleModel.getTargetItemId())) {
                                    View view2 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262.mRootView;
                                    GesturesRecyclerView recyclerView = view2 != null ? (GesturesRecyclerView) view2.findViewById(R.id.personalCenterGesturesRecyclerView) : null;
                                    if (recyclerView != null) {
                                        RecyclerView.ViewHolder holder = recyclerView.findViewHolderForAdapterPosition(indexGroup);
                                        if (holder == null) {
                                            GesturesRecyclerView gesturesRecyclerView = recyclerView;
                                            PersonalizedFragment personalizedFragment = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262;
                                            int i5 = index$iv2;
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(holder, "recyclerView?.findViewHo…indexGroup) ?: return@run");
                                            if (holder instanceof BaseHolder) {
                                                GesturesRecyclerView gesturesRecyclerView2 = recyclerView;
                                                PersonalizedFragment personalizedFragment2 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262;
                                                anchorView.element = ((BaseHolder) holder).getBubbleAnchorView(index$iv2, bubbleModel.getTargetItemId());
                                            } else {
                                                PersonalizedFragment personalizedFragment3 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262;
                                                int i6 = index$iv2;
                                            }
                                        }
                                    } else {
                                        PersonalizedFragment personalizedFragment4 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262;
                                        int i7 = index$iv2;
                                    }
                                } else {
                                    $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d26 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262;
                                    int i8 = index$iv2;
                                }
                            }
                            index$iv2 = index$iv3;
                            $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d26;
                            i3 = i2;
                        }
                        continue;
                    }
                    indexGroup = index$iv;
                    $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262 = $this$tryShowPersonalCenterBubbleGuide_u24lambda_u2d262;
                    i3 = i3;
                }
            }
            if (anchorView.element != null && !BubbleGuideManager.INSTANCE.isBubbleShowing()) {
                PopupExclusionManagerMap.getInstance().display(PopupExclusionManagerMap.SCENE_MY, new PersonalizedFragment$tryShowPersonalCenterBubbleGuide$2(anchorView, bubbleModel, ExclusionType.MY_SETTING_GUIDE));
            }
        }
    }
}
