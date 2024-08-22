package com.baidu.searchbox.sport.page.schedule.comp;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.browser.core.util.BdDateUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.container.creator.PageParams;
import com.baidu.searchbox.nacomp.extension.util.RecyclerViewHelper;
import com.baidu.searchbox.nacomp.extension.widget.ptr.BilateralRecyclerView;
import com.baidu.searchbox.nacomp.recycler.base.MappingRVViewModel;
import com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData;
import com.baidu.searchbox.nacomp.util.CollectionUtils;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.R;
import com.baidu.searchbox.sport.event.OpenUrlEvent;
import com.baidu.searchbox.sport.ioc.ISportRenderStat;
import com.baidu.searchbox.sport.model.MatchInfo;
import com.baidu.searchbox.sport.model.SubscribeInfo;
import com.baidu.searchbox.sport.model.SubscribeInfoKt;
import com.baidu.searchbox.sport.model.TabInfo;
import com.baidu.searchbox.sport.model.XcxParams;
import com.baidu.searchbox.sport.page.chatroom.ChatRoomFragment;
import com.baidu.searchbox.sport.page.match.model.DataSource;
import com.baidu.searchbox.sport.page.schedule.ScheduleModel;
import com.baidu.searchbox.sport.page.schedule.event.MatchSubStatusChangeEvent;
import com.baidu.searchbox.sport.page.schedule.item.IScheduleDate;
import com.baidu.searchbox.sport.page.schedule.item.baseschedule.BaseScheduleItemModel;
import com.baidu.searchbox.sport.page.schedule.item.date.ScheduleDateModel;
import com.baidu.searchbox.sport.page.schedule.item.footer.FooterStatus;
import com.baidu.searchbox.sport.page.schedule.item.footer.ScheduleGrpFooterModel;
import com.baidu.searchbox.sport.page.schedule.item.match.ScheduleItemModel;
import com.baidu.searchbox.sport.page.schedule.item.matchdescription.ScheduleItemDescriptionModel;
import com.baidu.searchbox.sport.page.schedule.model.DailySchedule;
import com.baidu.searchbox.sport.page.schedule.model.ScheduleItem;
import com.baidu.searchbox.sport.page.schedule.model.ScheduleListModel;
import com.baidu.searchbox.sport.page.schedule.model.ScheduleTabInfo;
import com.baidu.searchbox.sport.page.schedule.repo.ScheduleRepo;
import com.baidu.searchbox.sport.scheme.SportSchemeRouterKt;
import com.baidu.searchbox.sport.statistic.SportStats;
import com.baidu.searchbox.sport.subscribe.SubscribeRepo;
import com.baidu.searchbox.sport.utils.LoginUtils;
import com.baidu.searchbox.sport.utils.SportMatchUtilKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.Single;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class ScheduleViewModel extends MappingRVViewModel {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "ScheduleViewModel";
    private ScheduleTabInfo curSelTabInfo;
    private final LinkedHashMap<String, DailySchedule> dailyScheduleMap = new LinkedHashMap<>();
    private final int dateIndicatorHeight;
    final MutableLiveData<Integer> dateIndicatorYScroll = new MutableLiveData<>();
    private ScheduleItem defaultAnchorItem;
    private final LinkedHashMap<ScheduleItem, ScheduleGrpFooterModel> grpScheduleMap = new LinkedHashMap<>();
    final MutableLiveData<Boolean> hasMoreHistory = new MutableLiveData<>();
    final MutableLiveData<Boolean> hasMoreNews = new MutableLiveData<>();
    private final CompositeSubscription historySubscription = new CompositeSubscription();
    final MutableLiveData<DailySchedule> indicatorDailySchedule = new MutableLiveData<>();
    final MutableLiveData<Boolean> isInitErr = new MutableLiveData<>();
    final MutableLiveData<Boolean> loadHistoryErr = new MutableLiveData<>();
    final MutableLiveData<Boolean> loadNewsErr = new MutableLiveData<>();
    private final CompositeSubscription newsSubscription = new CompositeSubscription();
    final MutableLiveData<Boolean> removeHead = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public ScheduleRepo repo;
    /* access modifiers changed from: private */
    public ScheduleModel scheduleModel = new ScheduleModel();
    final MutableLiveData<Integer> scrollPosition = new MutableLiveData<>();
    final MutableLiveData<Boolean> showDateIndicator = new MutableLiveData<>();
    final MutableLiveData<Boolean> showInitLoading = new MutableLiveData<>();
    private final SubscribeLogin subscribeLogin = new SubscribeLogin();
    private final SubscribeRepo subscribeRepo = new SubscribeRepo();
    private final CompositeSubscription subscribeSubscription = new CompositeSubscription();
    final MutableLiveData<Integer> subscribeToast = new MutableLiveData<>();
    final MutableLiveData<Boolean> supportDateIndicator = new MutableLiveData<>();
    final MutableLiveData<List<ScheduleTabInfo>> tabList = new MutableLiveData<>();
    protected UniqueId token;
    private final CompositeSubscription updateSubscription = new CompositeSubscription();

    /* access modifiers changed from: protected */
    public void subscribeSchedule(ScheduleItem scheduleItem) {
        if (LoginUtils.isLogin()) {
            subscribeWithLogin(scheduleItem);
            return;
        }
        this.subscribeLogin.setScheduleItem(scheduleItem);
        LoginUtils.funcWithLogin(this.subscribeLogin);
    }

    /* access modifiers changed from: private */
    public void subscribeWithLogin(final ScheduleItem scheduleItem) {
        final SubscribeInfo subInfo = scheduleItem.getSubscribeInfo();
        if (subInfo != null) {
            scheduleItem.setSubscribeRequesting(true);
            updateMapping(scheduleItem);
            this.subscribeSubscription.clear();
            this.subscribeSubscription.add(this.subscribeRepo.subscribe(subInfo).subscribe(new Action1<SubscribeInfo>() {
                public void call(SubscribeInfo info) {
                    scheduleItem.setSubscribeRequesting(false);
                    scheduleItem.setSubscribeInfo(SubscribeInfoKt.copyParams(subInfo, info));
                    ScheduleViewModel.this.updateMapping(scheduleItem);
                    BdEventBus.Companion.getDefault().post(new MatchSubStatusChangeEvent(scheduleItem.getMatchInfo(), scheduleItem.getSubscribeInfo()));
                    SportStats.of(ScheduleViewModel.this.token).onScheduleSubEvent(info, ScheduleViewModel.this.scheduleModel.getPage());
                }
            }, new Action1<Throwable>() {
                public void call(Throwable throwable) {
                    scheduleItem.setSubscribeRequesting(false);
                    ScheduleViewModel.this.updateMapping(scheduleItem);
                    if (subInfo.isSubscribed()) {
                        ScheduleViewModel.this.subscribeToast.setValue(Integer.valueOf(R.string.sport_unsubscribe_failed));
                    } else {
                        ScheduleViewModel.this.subscribeToast.setValue(Integer.valueOf(R.string.sport_subscribe_failed));
                    }
                }
            }));
        }
    }

    public void updateScheduleSubStatus(MatchInfo matchInfo, SubscribeInfo subInfo) {
        int size = getDataCount();
        for (int i2 = 0; i2 < size; i2++) {
            IAdapterData data = getData(i2);
            if (data instanceof ScheduleItemModel) {
                ScheduleItem scheduleItem = ((ScheduleItemModel) data).getScheduleItem();
                if (matchInfo.equals(scheduleItem.getMatchInfo())) {
                    SubscribeInfo subscribeInfo = scheduleItem.getSubscribeInfo();
                    if (subscribeInfo != null) {
                        scheduleItem.setSubscribeInfo(SubscribeInfoKt.copyParams(subscribeInfo, subInfo));
                        updateMapping(scheduleItem);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public ScheduleViewModel(Application application) {
        super(application);
        this.dateIndicatorHeight = application.getResources().getDimensionPixelOffset(R.dimen.sport_dimen_schedule_date_height);
    }

    /* access modifiers changed from: package-private */
    public void setToken(UniqueId token2) {
        this.token = token2;
    }

    /* access modifiers changed from: package-private */
    public void setScheduleModel(ScheduleModel model) {
        this.scheduleModel = model;
        ScheduleRepo of = ScheduleRepo.of(model.getMatchName(), this.scheduleModel.getTeamId(), this.scheduleModel.isHot(), this.scheduleModel.getPlayerId(), model.getVsId());
        this.repo = of;
        of.setScheduleFilters(this.scheduleModel.getScheduleFilters());
        this.supportDateIndicator.setValue(Boolean.valueOf(model.isSupportDateIndicator()));
    }

    public void onStart() {
        observeListUpdate();
    }

    /* access modifiers changed from: package-private */
    public void setSelTabInfo(ScheduleTabInfo tabInfo) {
        this.curSelTabInfo = tabInfo;
    }

    /* access modifiers changed from: package-private */
    public void onReloadData() {
        clearData();
        ScheduleRepo scheduleRepo = this.repo;
        if (scheduleRepo != null) {
            scheduleRepo.setScheduleFilters(createTabReqParams(this.curSelTabInfo));
        }
        loadNewScheduleList(true);
    }

    private String createTabReqParams(ScheduleTabInfo tabInfo) {
        if (tabInfo == null) {
            return null;
        }
        try {
            JSONArray array = new JSONArray();
            JSONObject param = new JSONObject();
            param.put("key", tabInfo.getKey());
            param.put("value", tabInfo.getValue());
            array.put(param);
            return array.toString();
        } catch (Throwable th2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void loadNewScheduleList(boolean isInit) {
        Single<ScheduleListModel> reqObservable;
        if (this.token != null && this.repo != null) {
            if (isInit) {
                this.grpScheduleMap.clear();
                this.showInitLoading.setValue(true);
            }
            this.newsSubscription.clear();
            long startTime = ISportRenderStat.Companion.getImpl().getTime();
            String tabId = this.scheduleModel.getTabId();
            if (isInit) {
                reqObservable = this.repo.getInitialSchedules(this.scheduleModel.getDate());
            } else {
                reqObservable = this.repo.getSchedulesAfter(getLatestScheduleDate());
            }
            final long j2 = startTime;
            final String str = tabId;
            final boolean z = isInit;
            this.newsSubscription.add(reqObservable.subscribe(new Action1<ScheduleListModel>() {
                public void call(ScheduleListModel scheduleListModel) {
                    SportStats.of(ScheduleViewModel.this.token).onUpdateNaTabTraceResult(j2, str, true, scheduleListModel.getDataSource(), (Throwable) null);
                    ScheduleViewModel.this.onNewScheduleReturn(scheduleListModel.getSchedules());
                    if (z) {
                        ScheduleViewModel.this.hasMoreHistory.setValue(true);
                        int defaultPos = ScheduleViewModel.this.getScrollPosition(scheduleListModel.getScrollTarget());
                        ScheduleViewModel.this.scrollPosition.setValue(Integer.valueOf(defaultPos));
                        ScheduleViewModel.this.initDefaultItem(defaultPos);
                        ScheduleViewModel.this.tabList.setValue(scheduleListModel.getTabInfoList());
                    }
                    ScheduleViewModel.this.isInitErr.setValue(false);
                    ScheduleViewModel.this.hasMoreNews.setValue(Boolean.valueOf(scheduleListModel.hasMore()));
                    ScheduleViewModel.this.showInitLoading.setValue(false);
                }
            }, new Action1<Throwable>() {
                public void call(Throwable throwable) {
                    SportStats.of(ScheduleViewModel.this.token).onUpdateNaTabTraceResult(j2, str, false, (DataSource) null, throwable);
                    ScheduleViewModel.this.isInitErr.setValue(Boolean.valueOf(z));
                    ScheduleViewModel.this.loadNewsErr.setValue(Boolean.valueOf(!z));
                    ScheduleViewModel.this.showInitLoading.setValue(false);
                }
            }));
        }
    }

    /* access modifiers changed from: package-private */
    public void anchorToDefaultPos() {
        ScheduleItem scheduleItem = this.defaultAnchorItem;
        if (scheduleItem != null) {
            this.scrollPosition.setValue(Integer.valueOf(getScrollPosition(scheduleItem)));
        }
    }

    /* access modifiers changed from: private */
    public void initDefaultItem(int pos) {
        Object defaultItem = getMappingKeyAt(pos);
        if (defaultItem instanceof ScheduleItem) {
            this.defaultAnchorItem = (ScheduleItem) defaultItem;
        }
    }

    /* access modifiers changed from: private */
    public int getScrollPosition(ScheduleItem item) {
        return Math.max(0, indexOfKey(item));
    }

    /* access modifiers changed from: private */
    public String getLatestScheduleDate() {
        IAdapterData mappingValueAt = getMappingValueAt(getDataCount() - 1);
        if (mappingValueAt instanceof IScheduleDate) {
            return ((IScheduleDate) mappingValueAt).getScheduleDate();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void onNewScheduleReturn(List<DailySchedule> dailySchedules) {
        if (!CollectionUtils.isEmpty(dailySchedules)) {
            for (DailySchedule schedule : dailySchedules) {
                appendNewSchedule(schedule);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void appendNewSchedule(DailySchedule schedule) {
        if (!CollectionUtils.isEmpty(schedule.getItemList()) && this.token != null) {
            this.dailyScheduleMap.put(schedule.getDate(), schedule);
            addMapping(schedule, new ScheduleDateModel(this.token, schedule));
            for (ScheduleItem item : schedule.getItemList()) {
                if (2 == SportMatchUtilKt.getMatchType(item.getMatchInfo().getMatchDescription())) {
                    addMapping(item, new ScheduleItemDescriptionModel(this.token, item));
                } else {
                    addMapping(item, new ScheduleItemModel(this.token, item));
                    if (item.isGroup()) {
                        ScheduleGrpFooterModel footerModel = new ScheduleGrpFooterModel(item);
                        addMapping(footerModel, footerModel);
                        this.grpScheduleMap.put(item, footerModel);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void loadHistoryScheduleList() {
        if (this.token != null && this.repo != null) {
            this.historySubscription.clear();
            this.historySubscription.add(this.repo.getSchedulesBefore(getEldestScheduleDate()).subscribe(new Action1<ScheduleListModel>() {
                public void call(ScheduleListModel scheduleListModel) {
                    ScheduleViewModel.this.removeHead.setValue(true);
                    ScheduleViewModel.this.hasMoreHistory.setValue(Boolean.valueOf(scheduleListModel.hasMore()));
                    ScheduleViewModel.this.onHistoryScheduleReturn(scheduleListModel.getSchedules());
                }
            }, new Action1<Throwable>() {
                public void call(Throwable throwable) {
                    ScheduleViewModel.this.loadHistoryErr.setValue(true);
                }
            }));
        }
    }

    private String getEldestScheduleDate() {
        Object data = getMappingKeyAt(0);
        if (data instanceof DailySchedule) {
            return ((DailySchedule) data).getDate();
        }
        if (data instanceof ScheduleItem) {
            return ((ScheduleItem) data).getDate();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void onHistoryScheduleReturn(List<DailySchedule> dailySchedules) {
        if (!CollectionUtils.isEmpty(dailySchedules)) {
            for (int i2 = dailySchedules.size() - 1; i2 >= 0; i2--) {
                appendHistorySchedule(dailySchedules.get(i2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void appendHistorySchedule(DailySchedule schedule) {
        if (!CollectionUtils.isEmpty(schedule.getItemList()) && this.token != null) {
            this.dailyScheduleMap.put(schedule.getDate(), schedule);
            int i2 = schedule.getItemList().size();
            while (true) {
                i2--;
                if (i2 >= 0) {
                    ScheduleItem item = schedule.getItemList().get(i2);
                    if (2 == SportMatchUtilKt.getMatchType(item.getMatchInfo().getMatchDescription())) {
                        insertMapping(0, item, new ScheduleItemDescriptionModel(this.token, item));
                    } else {
                        ScheduleItemModel scheduleModel2 = new ScheduleItemModel(this.token, item);
                        if (item.isGroup()) {
                            ScheduleGrpFooterModel footerModel = new ScheduleGrpFooterModel(item);
                            insertMapping(0, footerModel, footerModel);
                            this.grpScheduleMap.put(item, footerModel);
                        }
                        insertMapping(0, item, scheduleModel2);
                    }
                } else {
                    insertMapping(0, schedule, new ScheduleDateModel(this.token, schedule));
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onListScrolled(BilateralRecyclerView rcyList) {
        if (this.scheduleModel.isSupportDateIndicator()) {
            observeListScroll(rcyList);
            updateDateIndicatorData(rcyList);
        }
    }

    private void observeListScroll(BilateralRecyclerView rcyList) {
        View dateIndicatorView;
        int index = RecyclerViewHelper.getRcyFirstVisiblePosition(rcyList.getRecyclerView()) + 1;
        if (!(getMappingValueAt(index - rcyList.getHeadCount()) instanceof ScheduleDateModel)) {
            this.dateIndicatorYScroll.setValue(0);
            return;
        }
        RecyclerView.ViewHolder viewHolder = rcyList.getRecyclerView().findViewHolderForAdapterPosition(index);
        if (viewHolder == null || (dateIndicatorView = viewHolder.itemView) == null) {
            this.dateIndicatorYScroll.setValue(0);
            return;
        }
        this.dateIndicatorYScroll.setValue(Integer.valueOf(Math.max(-this.dateIndicatorHeight, Math.min(0, dateIndicatorView.getTop() - this.dateIndicatorHeight))));
    }

    private void updateDateIndicatorData(BilateralRecyclerView rcyList) {
        int position = RecyclerViewHelper.getRcyFirstVisiblePosition(rcyList.getRecyclerView()) - rcyList.getHeadCount();
        IAdapterData data = getMappingValueAt(position);
        if (data instanceof ScheduleDateModel) {
            this.indicatorDailySchedule.setValue(((ScheduleDateModel) data).getDailySchedule());
        } else if (data instanceof BaseScheduleItemModel) {
            this.indicatorDailySchedule.setValue(this.dailyScheduleMap.get(((BaseScheduleItemModel) data).getScheduleItem().getDate()));
        } else if (DEBUG) {
            Log.d(TAG, "--->>updateDateIndicatorData failed:invalid item type");
        }
        if (this.scheduleModel.isSupportDateIndicator()) {
            this.showDateIndicator.setValue(Boolean.valueOf(position > 0));
        }
    }

    private void observeListUpdate() {
        if (this.repo != null) {
            this.updateSubscription.clear();
            this.updateSubscription.add(this.repo.onScheduleUpdated().subscribe(new Action1<List<ScheduleItem>>() {
                public void call(List<ScheduleItem> scheduleItems) {
                    for (ScheduleItem item : scheduleItems) {
                        IAdapterData data = ScheduleViewModel.this.getMapping(item);
                        if (data instanceof BaseScheduleItemModel) {
                            ((BaseScheduleItemModel) data).setScheduleItem(item);
                        }
                        ScheduleViewModel.this.updateMapping(item);
                    }
                }
            }, (Action1<Throwable>) new Action1<Throwable>() {
                public void call(Throwable throwable) {
                    if (ScheduleViewModel.DEBUG) {
                        Log.d(ScheduleViewModel.TAG, "--->>observe schedule list update error:  " + throwable.getMessage());
                        throwable.printStackTrace();
                    }
                }
            }));
        }
    }

    /* access modifiers changed from: package-private */
    public void onReloadAfterErr() {
        this.isInitErr.setValue(false);
        loadNewScheduleList(true);
    }

    /* access modifiers changed from: package-private */
    public void jumpToDetail(ScheduleItem item) {
        if (this.token != null) {
            SportStats.of(this.token).onClickEvent(this.scheduleModel.getPage(), SportStats.MATCH_CLICK, (String) null, SportMatchUtilKt.buildEventTypeExt((JSONObject) null, SportMatchUtilKt.getEventType(item.getMatchInfo().getMatchDescription())));
            XcxParams params = item.getMatchInfo().getXcxParams();
            if (params != null && !TextUtils.isEmpty(params.getXcxUrl())) {
                BdEventBus.Companion.getDefault().post(new OpenUrlEvent(this.token, params.getXcxUrl()));
            } else if (params == null || TextUtils.isEmpty(params.getWiseUrl())) {
                BdEventBus.Companion.getDefault().post(new OpenUrlEvent(this.token, buildScheme(item)));
            } else {
                BdEventBus.Companion.getDefault().post(new OpenUrlEvent(this.token, params.getWiseUrl()));
            }
        }
    }

    private String buildScheme(ScheduleItem item) {
        JSONObject params = new JSONObject();
        try {
            params.put(ChatRoomFragment.INVOKE_PARAM_MATCH_ID, item.getMatchInfo().getId());
            Iterator<TabInfo> it = item.getTabList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TabInfo info = it.next();
                if (info.isDefault()) {
                    params.put(PageParams.KEY_TAB_INFO, info.toJson());
                    break;
                }
            }
            if (!TextUtils.isEmpty(this.scheduleModel.getSid())) {
                JSONObject ext = new JSONObject();
                ext.put("sid", this.scheduleModel.getSid());
                params.put("ext", ext);
            }
        } catch (Throwable e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return new Uri.Builder().scheme("baiduboxapp").authority("browser").appendEncodedPath(SportSchemeRouterKt.ACTION_INVOKE_MATCH_DETAIL).appendQueryParameter("params", params.toString()).build().toString();
    }

    public void updateGrpScheduleList(ScheduleItem grpSchedule) {
        boolean result;
        ScheduleGrpFooterModel footerModel = this.grpScheduleMap.get(grpSchedule);
        if (footerModel != null) {
            if (footerModel.getFooterStatus() == FooterStatus.FOLD) {
                result = unfoldGrpList(grpSchedule, footerModel);
            } else {
                result = foldGrpList(grpSchedule);
            }
            if (result) {
                updateGrpFooter(footerModel);
            }
        }
    }

    private boolean unfoldGrpList(ScheduleItem grpSchedule, ScheduleGrpFooterModel grpFooter) {
        int startInsertPosition;
        List<ScheduleItem> sublist = grpSchedule.getSubList();
        if (CollectionUtils.isEmpty(sublist) || this.token == null || (startInsertPosition = indexOfKey(grpFooter)) < 0) {
            return false;
        }
        for (ScheduleItem item : sublist) {
            ScheduleItemModel itemModel = new ScheduleItemModel(this.token, item);
            itemModel.setIsSubSchedule(true);
            insertMapping(startInsertPosition, item, itemModel);
        }
        return true;
    }

    private boolean foldGrpList(ScheduleItem grpSchedule) {
        List<ScheduleItem> sublist = grpSchedule.getSubList();
        if (CollectionUtils.isEmpty(sublist)) {
            return false;
        }
        removeMappingList(sublist);
        return true;
    }

    private void updateGrpFooter(ScheduleGrpFooterModel footerModel) {
        footerModel.setFooterStatus(footerModel.getFooterStatus() == FooterStatus.FOLD ? FooterStatus.UNFOLD : FooterStatus.FOLD);
        updateMapping(footerModel);
    }

    /* access modifiers changed from: package-private */
    public int getScrollOffset(int scrollPosition2) {
        if (getMappingValueAt(scrollPosition2) instanceof ScheduleDateModel) {
            return 0;
        }
        return this.dateIndicatorHeight;
    }

    public void onStop() {
        this.updateSubscription.clear();
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.grpScheduleMap.clear();
        this.newsSubscription.unsubscribe();
        this.historySubscription.unsubscribe();
        this.updateSubscription.unsubscribe();
        this.subscribeSubscription.unsubscribe();
    }

    private class SubscribeLogin implements LoginUtils.OnAllowFuncListener {
        private ScheduleItem scheduleItem;

        private SubscribeLogin() {
        }

        public ScheduleItem getScheduleItem() {
            return this.scheduleItem;
        }

        public void setScheduleItem(ScheduleItem scheduleItem2) {
            this.scheduleItem = scheduleItem2;
        }

        public void allowFunc() {
            String date = ScheduleViewModel.this.scheduleModel.getDate();
            if (TextUtils.isEmpty(date)) {
                date = BdDateUtils.getDate();
            }
            setItemSubRequesting(true);
            updateDataUntilLatestDate(date);
        }

        public void onLoginFail(int failCode) {
        }

        /* access modifiers changed from: private */
        public void updateDataUntilLatestDate(final String dateStr) {
            if (ScheduleViewModel.this.repo == null) {
                setItemSubRequesting(false);
                return;
            }
            final String latestDateStr = ScheduleViewModel.this.getLatestScheduleDate();
            ScheduleViewModel.this.repo.getInitialSchedules(dateStr).subscribe(new Action1<ScheduleListModel>() {
                public void call(ScheduleListModel scheduleListModel) {
                    SubscribeLogin.this.updateSchedules(scheduleListModel);
                    if (TextUtils.isEmpty(latestDateStr) || TextUtils.isEmpty(dateStr)) {
                        SubscribeLogin.this.setItemSubRequesting(false);
                    } else if (dateStr.compareTo(latestDateStr) >= 0) {
                        SubscribeLogin.this.subscribeAfterLogin();
                        SubscribeLogin.this.setItemSubRequesting(false);
                    } else {
                        int lastIndex = scheduleListModel.getSchedules().size() - 1;
                        if (lastIndex < 0) {
                            SubscribeLogin.this.setItemSubRequesting(false);
                            return;
                        }
                        String nextDate = scheduleListModel.getSchedules().get(lastIndex).getDate();
                        if (TextUtils.isEmpty(nextDate)) {
                            SubscribeLogin.this.setItemSubRequesting(false);
                        } else {
                            SubscribeLogin.this.updateDataUntilLatestDate(nextDate);
                        }
                    }
                }
            }, new Action1<Throwable>() {
                public void call(Throwable throwable) {
                    if (ScheduleViewModel.DEBUG) {
                        Log.e(ScheduleViewModel.TAG, "update data failed: date = " + dateStr, throwable);
                    }
                    SubscribeLogin.this.setItemSubRequesting(false);
                }
            });
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
            r1 = ((com.baidu.searchbox.sport.page.schedule.item.match.ScheduleItemModel) r0).getScheduleItem();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribeAfterLogin() {
            /*
                r4 = this;
                com.baidu.searchbox.sport.page.schedule.comp.ScheduleViewModel r0 = com.baidu.searchbox.sport.page.schedule.comp.ScheduleViewModel.this
                com.baidu.searchbox.sport.page.schedule.model.ScheduleItem r1 = r4.scheduleItem
                com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData r0 = r0.getMapping(r1)
                boolean r1 = r0 instanceof com.baidu.searchbox.sport.page.schedule.item.match.ScheduleItemModel
                if (r1 == 0) goto L_0x0024
                r1 = r0
                com.baidu.searchbox.sport.page.schedule.item.match.ScheduleItemModel r1 = (com.baidu.searchbox.sport.page.schedule.item.match.ScheduleItemModel) r1
                com.baidu.searchbox.sport.page.schedule.model.ScheduleItem r1 = r1.getScheduleItem()
                com.baidu.searchbox.sport.model.SubscribeInfo r2 = r1.getSubscribeInfo()
                if (r2 == 0) goto L_0x0024
                boolean r3 = r2.isSubscribed()
                if (r3 != 0) goto L_0x0024
                com.baidu.searchbox.sport.page.schedule.comp.ScheduleViewModel r3 = com.baidu.searchbox.sport.page.schedule.comp.ScheduleViewModel.this
                r3.subscribeWithLogin(r1)
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.sport.page.schedule.comp.ScheduleViewModel.SubscribeLogin.subscribeAfterLogin():void");
        }

        /* access modifiers changed from: private */
        public void updateSchedules(ScheduleListModel scheduleListModel) {
            for (DailySchedule schedules : scheduleListModel.getSchedules()) {
                for (ScheduleItem scheduleItem2 : schedules.getItemList()) {
                    IAdapterData data = ScheduleViewModel.this.getMapping(scheduleItem2);
                    if (data instanceof BaseScheduleItemModel) {
                        ((BaseScheduleItemModel) data).getScheduleItem().setSubscribeInfo(scheduleItem2.getSubscribeInfo());
                        ((BaseScheduleItemModel) data).getScheduleItem().setSubscribeRequesting(false);
                        ScheduleViewModel.this.updateMapping(scheduleItem2);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void setItemSubRequesting(boolean isRequesting) {
            int dataCount = ScheduleViewModel.this.getDataCount();
            for (int i2 = 0; i2 < dataCount; i2++) {
                IAdapterData data = ScheduleViewModel.this.getData(i2);
                if (data instanceof ScheduleItemModel) {
                    ((ScheduleItemModel) data).getScheduleItem().setSubscribeRequesting(isRequesting);
                    ScheduleViewModel.this.updateMapping(data);
                }
            }
        }
    }
}
