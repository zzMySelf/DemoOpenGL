package com.baidu.searchbox.feed.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.ad.IAdHistoryRuntime;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.command.CommandEntity;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.feed.FeedConfig;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.util.AdDataReduceUtils;
import com.baidu.searchbox.feed.ad.util.FeedAdUtil;
import com.baidu.searchbox.feed.base.FeedSpecialTemplates;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.controller.FeedSearchBackManager;
import com.baidu.searchbox.feed.controller.mutevideo.MuteVideoPlayController;
import com.baidu.searchbox.feed.event.FeedFlowRefreshEvent;
import com.baidu.searchbox.feed.event.FeedToTopEvent;
import com.baidu.searchbox.feed.event.MuteAutoPlayEvent;
import com.baidu.searchbox.feed.event.OnFeedUIReadyEvent;
import com.baidu.searchbox.feed.event.TabRefreshEvent;
import com.baidu.searchbox.feed.event.WidgetActionEvent;
import com.baidu.searchbox.feed.flow.RefreshablePage;
import com.baidu.searchbox.feed.flow.assistants.TemplateAssistant;
import com.baidu.searchbox.feed.flow.impl.RecyclerRefreshablePage;
import com.baidu.searchbox.feed.flow.ui.CapsulesAbility;
import com.baidu.searchbox.feed.flow.ui.UpdateAbility;
import com.baidu.searchbox.feed.flow.ui.ViewAbility;
import com.baidu.searchbox.feed.ioc.IFeedFavor;
import com.baidu.searchbox.feed.listpage.domain.Channel;
import com.baidu.searchbox.feed.model.BatchFollowHScrollItemData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBiserialCollectionChildData;
import com.baidu.searchbox.feed.model.FeedBiserialCollectionData;
import com.baidu.searchbox.feed.model.FeedEvolutionDetailItemModel;
import com.baidu.searchbox.feed.model.FeedEvolutionDetailModel;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.model.FeedItemDataMiniVideo;
import com.baidu.searchbox.feed.model.FeedItemDataStarScroll;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.model.FeedItemEvolutionModel;
import com.baidu.searchbox.feed.model.FeedPolicyModel;
import com.baidu.searchbox.feed.model.FeedPolyHScrollModel;
import com.baidu.searchbox.feed.model.FeedRuntimeStatus;
import com.baidu.searchbox.feed.model.FollowHScrollItemData;
import com.baidu.searchbox.feed.model.commoncontent.CommonContentInfo;
import com.baidu.searchbox.feed.model.commoncontent.FeedItemDataComCont;
import com.baidu.searchbox.feed.model.utils.FeedModelFactory;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.feed.statistic.FeedSpeedStats;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.statistic.PerformanceStats;
import com.baidu.searchbox.feed.tab.model.UserGestureInfo;
import com.baidu.searchbox.feed.tab.utils.FeedCloudTabUtil;
import com.baidu.searchbox.feed.template.common.ExtraData;
import com.baidu.searchbox.feed.template.interfaces.IFeedVRTemplate;
import com.baidu.searchbox.feed.template.tplinterface.IVideoPlayerControl;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.feed.video.preview.IVideoPreViewProcess;
import com.baidu.searchbox.feed.video.preview.VideoPreViewManager;
import com.baidu.searchbox.feed.video.statistic.VideoStatisticUtil;
import com.baidu.searchbox.feed.widget.tabfloat.TabFloatControl;
import com.baidu.searchbox.home.feed.CeilingScene;
import com.baidu.searchbox.home.feed.CeilingSceneKt;
import com.baidu.searchbox.lightbrowser.model.SubTagItem;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.video.detail.controller.BackVideoDetailManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class PageViewHelper {
    public static final String RAL_MODE = "ral_mode";
    private static final int SLOW_SCROLL_DY = 6;
    private static final String TAG = "PageViewHelper";

    public static boolean innerItemClick(Context context, WidgetActionEvent event, String channelId, boolean isUnableClickInTTSState, int feedState, TemplateAssistant assistant) {
        if (event.clickWrapper != null) {
            return event.clickWrapper.itemClick(context, event, channelId, getFirstClickIntervalTime(assistant));
        }
        switch (event.type) {
            case 5:
                starScrollItemClick(context, event, channelId);
                break;
            case 8:
                commonItemClick(context, event, channelId);
                break;
            case 10:
                followItemClick(context, event, channelId);
                break;
            case 11:
                batFollowItemClick(context, event, channelId);
                break;
            case 22:
                polyScrollItemClick(context, event, channelId, getFirstClickIntervalTime(assistant));
                break;
            case 23:
                evolutionItemClick(context, event, channelId, getFirstClickIntervalTime(assistant));
                break;
            case 37:
                biserialCollectionItemClick(context, event, channelId);
                break;
        }
        return true;
    }

    private static void biserialCollectionItemClick(Context context, WidgetActionEvent event, String channelId) {
        WidgetActionEvent widgetActionEvent = event;
        if (widgetActionEvent.object instanceof FeedBaseModel) {
            if (TextUtils.equals(channelId, widgetActionEvent.tabId)) {
                FeedBaseModel model = (FeedBaseModel) widgetActionEvent.object;
                if (model.data instanceof FeedBiserialCollectionData) {
                    List<FeedBiserialCollectionChildData> items = ((FeedBiserialCollectionData) model.data).getItems();
                    if (widgetActionEvent.position < items.size()) {
                        FeedBiserialCollectionChildData item = items.get(widgetActionEvent.position);
                        FeedBaseModel feedBaseModel = item.getFeedBaseModel();
                        if (feedBaseModel == null) {
                            Context context2 = context;
                        } else if (feedBaseModel.data == null) {
                            Context context3 = context;
                        } else {
                            FeedRouter.invoke(context, feedBaseModel.data.cmd.get(), false);
                            FeedDataReportUtils.reportFeedHScrollClick(model.id, item.id, model.runtimeStatus.viewPosition, widgetActionEvent.position, item.ext, 0, "clk", "index");
                            BdEventBus.Companion.getDefault().post(new FeedToTopEvent(true, false, new CeilingScene(CeilingSceneKt.CEILING_SOURCE_CLICK_FEED_ITEM, "layout")));
                            FeedStatisticCenter.ubcFeedDauActionWithType(CeilingSceneKt.CEILING_SOURCE_CLICK_FEED_ITEM, "layout", "");
                        }
                    }
                }
            } else {
                Context context4 = context;
            }
        } else {
            Context context5 = context;
            String str = channelId;
        }
    }

    private static long getFirstClickIntervalTime(TemplateAssistant assistant) {
        if (assistant == null) {
            return 0;
        }
        return assistant.calculateFirstClickIntervalTime();
    }

    private static void polyScrollItemClick(Context context, WidgetActionEvent event, String channelId, long time) {
        WidgetActionEvent widgetActionEvent = event;
        if (widgetActionEvent.object instanceof FeedBaseModel) {
            if (TextUtils.equals(channelId, widgetActionEvent.tabId)) {
                FeedBaseModel model = (FeedBaseModel) widgetActionEvent.object;
                FeedPolyHScrollModel.ItemData item = ((FeedPolyHScrollModel) model.data).getItemList().get(widgetActionEvent.position);
                FeedRouter.invoke(context, item.getCmd(), true);
                if (NetWorkUtils.isNetworkConnected()) {
                    FeedDataReportUtils.reportFeedHScrollClick(model.id, item.id, model.runtimeStatus.viewPosition, widgetActionEvent.position, item.ext, time, "clk", "index");
                    return;
                }
                return;
            }
            Context context2 = context;
            return;
        }
        Context context3 = context;
        String str = channelId;
    }

    private static void evolutionItemClick(Context context, WidgetActionEvent event, String channelId, long time) {
        WidgetActionEvent widgetActionEvent = event;
        if (widgetActionEvent.object instanceof FeedBaseModel) {
            if (TextUtils.equals(channelId, widgetActionEvent.tabId)) {
                FeedBaseModel model = (FeedBaseModel) widgetActionEvent.object;
                if (model.data instanceof FeedItemEvolutionModel) {
                    FeedEvolutionDetailModel detailModel = ((FeedItemEvolutionModel) model.data).getDetail();
                    if (detailModel != null) {
                        if (detailModel.getList() == null || widgetActionEvent.position < 0) {
                            Context context2 = context;
                        } else if (widgetActionEvent.position < detailModel.getList().size()) {
                            FeedEvolutionDetailItemModel itemModel = detailModel.getList().get(widgetActionEvent.position);
                            if (itemModel != null) {
                                FeedRouter.invoke(context, TextUtils.isEmpty(itemModel.getCmd()) ? detailModel.getCmd() : itemModel.getCmd(), true);
                                FeedDataReportUtils.reportFeedHScrollClick(model.id, itemModel.getId(), model.runtimeStatus.viewPosition, widgetActionEvent.position, itemModel.getExt(), time, "clk", "index");
                            }
                        } else {
                            Context context3 = context;
                        }
                    }
                } else {
                    Context context4 = context;
                }
            } else {
                Context context5 = context;
            }
        } else {
            Context context6 = context;
            String str = channelId;
        }
    }

    private static void batFollowItemClick(Context context, WidgetActionEvent event, String channelId) {
        if ((event.object instanceof FeedBaseModel) && TextUtils.equals(channelId, event.tabId)) {
            FeedBaseModel model = (FeedBaseModel) event.object;
            int pos = event.position;
            int i2 = event.index;
            BatchFollowHScrollItemData.CardData cardData = ((BatchFollowHScrollItemData) model.data).cardDataList.get(pos);
            Router.invoke(context, cardData.mItemList.get(i2).cmd);
            if (NetWorkUtils.isNetworkConnected()) {
                FeedDataReportUtils.reportFeedbackItemClick(cardData.mItemList.get(i2).id, model.runtimeStatus.viewPosition, cardData.mItemList.get(i2).ext, "clk", "index");
            }
        }
    }

    private static void followItemClick(Context context, WidgetActionEvent event, String channelId) {
        if ((event.object instanceof FeedBaseModel) && TextUtils.equals(channelId, event.tabId)) {
            FeedBaseModel model = (FeedBaseModel) event.object;
            int pos = event.position;
            int i2 = event.index;
            FollowHScrollItemData.ItemData itemData = ((FollowHScrollItemData) model.data).itemDataList.get(pos);
            Router.invoke(context, itemData.mCmdArr[i2]);
            if (NetWorkUtils.isNetworkConnected()) {
                FeedDataReportUtils.reportFeedbackItemClick(itemData.mIdArr[i2], model.runtimeStatus.viewPosition, itemData.mExtArr[i2], "clk", "index");
            }
        }
    }

    private static void commonItemClick(Context context, WidgetActionEvent event, String channelId) {
        CommonContentInfo contentInfo;
        if ((event.object instanceof FeedBaseModel) && TextUtils.equals(channelId, event.tabId)) {
            FeedBaseModel model = (FeedBaseModel) event.object;
            int p = event.position;
            if (model.data instanceof FeedItemDataMiniVideo) {
                contentInfo = ((FeedItemDataMiniVideo) model.data).commonContentInfos.get(p);
            } else {
                List itemList = ((FeedItemDataComCont) model.data).commonContentInfos;
                if (itemList != null && p >= 0 && p < itemList.size()) {
                    contentInfo = itemList.get(p);
                } else {
                    return;
                }
            }
            Router.invoke(context, contentInfo.cmd);
            if (NetWorkUtils.isNetworkConnected()) {
                FeedDataReportUtils.reportFeedbackItemClick(contentInfo.id, p, contentInfo.ext, "clk", "index");
            }
            FeedStatisticCenter.doStartVideoStatistics(model);
        }
    }

    private static void starScrollItemClick(Context context, WidgetActionEvent event, String channelId) {
        if ((event.object instanceof FeedBaseModel) && TextUtils.equals(channelId, event.tabId)) {
            int p = event.position;
            FeedItemDataStarScroll.StarScrollItemData itemData = ((FeedItemDataStarScroll) ((FeedBaseModel) event.object).data).itemDataList.get(p);
            Router.invoke(context, itemData.cmd);
            if (NetWorkUtils.isNetworkConnected()) {
                FeedDataReportUtils.reportFeedbackItemClick(itemData.id, p, itemData.ext, "clk", "index");
            }
        }
    }

    public static void handleCmdAction(Context context, FeedDataManager dataManager, FeedBaseModel model, FeedTemplate feedTemplate, Intent intent, boolean isUnableClickInTTSState) {
        if (model != null && model.data != null && dataManager != null && feedTemplate != null) {
            if (VideoStatisticUtil.isClickedShortVideoTemplate(model)) {
                VideoStatisticUtil.startRouter(model.id);
            }
            AdDataReduceUtils.replaceDeferredCmd(model);
            String realCmd = model.data.cmd.get();
            handleVideoDetailAction(realCmd);
            String realCmd2 = TTSRuntime.getInstance().handleSchemeByVideoCache(model.id, realCmd);
            extraFeedNewsInfo(intent);
            if (FeedFilter.checkAdFeed(model)) {
                String openAppOrDeepLinkCmd = FeedAdUtil.getAdCmdByPkgName(model.data, FeedAdUtil.getAdCmd(model.data, realCmd2, true), true);
                if (!TextUtils.isEmpty(openAppOrDeepLinkCmd) && !TextUtils.equals(realCmd2, openAppOrDeepLinkCmd)) {
                    realCmd2 = openAppOrDeepLinkCmd;
                    intent = null;
                }
                FeedAdUtil.cacheAdParams(model);
                realCmd2 = FeedAdUtil.appendCKInfoToUrl(model, realCmd2);
                IAdHistoryRuntime.Impl.get().addAdHistory(model, realCmd2);
                if (intent != null && AdRuntimeHolder.getNadTransition().doTransition(model, feedTemplate, intent)) {
                    AdRuntimeHolder.getNadTransition().handleTransition(context, intent, model, feedTemplate);
                }
            }
            if (!TextUtils.isEmpty(model.data.expendCmd)) {
                realCmd2 = model.data.expendCmd;
            }
            if (feedTemplate instanceof IVideoPreViewProcess) {
                VideoPreViewManager.handlePreView(context, VideoPreViewManager.getVideoPreViewConfig((IVideoPreViewProcess) feedTemplate, realCmd2), new PageViewHelper$$ExternalSyntheticLambda0(context, intent));
            } else {
                invokeScheme(context, realCmd2, intent);
            }
            FeedUtil.refreshLog("handleCmdAction", "模板点击 nid:" + model.id + " 标题:" + model.data.title);
            FeedRuntimeStatus runtimeStatus = model.runtimeStatus;
            if (!runtimeStatus.isRead) {
                runtimeStatus.isRead = true;
                runtimeStatus.reportInfo.clickTime = System.currentTimeMillis();
                model.getTtsModel().setRalState(1);
                dataManager.markFeed(model);
                feedTemplate.update(model, ExtraData.newInstance(true, isUnableClickInTTSState));
                dataManager.updateFeedReadFlag(model, runtimeStatus.isRead);
            }
            if (VideoStatisticUtil.isClickedShortVideoTemplate(model)) {
                VideoStatisticUtil.endRouter(model.id);
                VideoStatisticUtil.startHandleClick(model.id);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void invokeScheme(Context context, String scheme, Intent intent) {
        if (intent != null) {
            CommandUtils.invokeCommand(context, new CommandEntity(scheme, intent));
        } else {
            FeedRouter.invoke(context, scheme, false);
        }
    }

    private static void extraFeedNewsInfo(Intent intent) {
        if (intent != null) {
            intent.putExtra("clickts", System.currentTimeMillis() + "");
            intent.putExtra("source_frame", "feed");
            intent.putExtra("sub_source_frame", "");
        }
    }

    public static void handleVideoTplAction(FeedTemplate view2, FeedBaseModel model, int position, boolean isUnableClickInTTSState, List<View> visibleList) {
        if (!isUnableClickInTTSState) {
            IVideoPlayerControl currentView = (IVideoPlayerControl) view2;
            if (!currentView.hasClicked()) {
                stopVisibleViewPlaying(false, visibleList);
                currentView.startPlay();
                String actionId = "clk";
                if (model != null && (model.data instanceof FeedItemDataTabVideo) && ((FeedItemDataTabVideo) model.data).mIsAutoPlay) {
                    actionId = "video_auto_play";
                }
                FeedDataReportUtils.reportFeedbackAction(model, (HashMap<String, String>) null, actionId, position, (List<SubTagItem>) null);
                if (TextUtils.equals(actionId, "clk")) {
                    IFeedFavor.Impl.get().addHistory(FeedUtil.favorParamsFrom(model));
                }
            }
        }
    }

    public static void stopVisibleViewPlaying(boolean isForced, List<View> visibleList) {
        if (visibleList != null) {
            for (View child : visibleList) {
                if ((child instanceof IVideoPlayerControl) && (((IVideoPlayerControl) child).isPlaying() || isAdView(child))) {
                    if (isForced) {
                        ((IVideoPlayerControl) child).forceStopPlay();
                    } else {
                        ((IVideoPlayerControl) child).stopPlay();
                    }
                }
            }
        }
    }

    private static boolean isAdView(View view2) {
        return FeedRuntime.getFeedAd().isAdFeedView(view2);
    }

    public static boolean isShowInterestDoor(String channelId) {
        return TextUtils.equals(channelId, "1") && FeedInterestConf.isShowInterestDoor();
    }

    public static void checkAdPreRenderItem(List<FeedBaseModel> feedList, int firstItemPosition, int lastItemPosition) {
        if (feedList != null && firstItemPosition != -1 && lastItemPosition != -1 && firstItemPosition <= feedList.size() && lastItemPosition + 1 <= feedList.size()) {
            AdRuntimeHolder.getAdPreRender().preRenderAdList(new ArrayList<>(feedList.subList(firstItemPosition, lastItemPosition + 1)));
        }
    }

    public static void startRenderVr(boolean scrollingUp, List<View> visibleViewList) {
        if (visibleViewList.isEmpty()) {
            return;
        }
        if (scrollingUp) {
            for (View view2 : visibleViewList) {
                if (view2 instanceof IFeedVRTemplate) {
                    ((IFeedVRTemplate) view2).processRenderVr();
                }
            }
            return;
        }
        for (int i2 = visibleViewList.size() - 1; i2 >= 0; i2--) {
            View view3 = visibleViewList.get(i2);
            if (view3 instanceof IFeedVRTemplate) {
                ((IFeedVRTemplate) view3).processRenderVr();
            }
        }
    }

    public static void clearGivenView(View view2) {
        if (view2 != null) {
            ViewParent p = view2.getParent();
            if (p instanceof ViewGroup) {
                ((ViewGroup) p).removeView(view2);
            }
        }
    }

    public static void addTimeLineModel(List<FeedBaseModel> feeds, FeedDataManager dataManager) {
        if (feeds != null && dataManager != null) {
            FeedBaseModel timeLineModel = FeedModelFactory.createNormalBaseModel();
            String name = FeedSpecialTemplates.SERVICE.getTimeLine().getName();
            timeLineModel.id = name;
            timeLineModel.layout = name;
            timeLineModel.runtimeStatus.rankEnable = false;
            feeds.add(timeLineModel);
            dataManager.deleteTimeLineModelIfNeed();
        }
    }

    public static void addHeaderLoginModel(List<FeedBaseModel> feeds, FeedDataManager dataManager) {
        if (feeds != null && dataManager != null) {
            FeedBaseModel headerLoginModel = FeedModelFactory.createNormalBaseModel();
            String name = FeedSpecialTemplates.SERVICE.getHeaderLogin().getName();
            headerLoginModel.id = name;
            headerLoginModel.layout = name;
            headerLoginModel.runtimeStatus.rankEnable = false;
            feeds.add(0, headerLoginModel);
            dataManager.deleteHeaderLoginModelIfNeed();
        }
    }

    public static void addSearchBackModel(boolean needNotify, FeedDataManager dataManager, UpdateAbility adapter) {
        if (dataManager != null && adapter != null && dataManager.getCachedFeeds() != null && dataManager.getCachedFeeds().size() > 0) {
            dataManager.deleteSearchBackIfNeed();
            FeedBaseModel searchBackModel = FeedModelFactory.createNormalBaseModel();
            String name = FeedSpecialTemplates.SERVICE.getSearchBack().getName();
            searchBackModel.id = name;
            searchBackModel.layout = name;
            searchBackModel.runtimeStatus.rankEnable = false;
            dataManager.insertFeedToCache(0, searchBackModel);
            FeedSearchBackManager.INSTANCE.getInfo(dataManager.getTabId()).setSearchBackAdded(true);
            if (needNotify) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public static void addSearchBackModel(List<FeedBaseModel> newFeeds, FeedDataManager dataManager) {
        if (dataManager != null && newFeeds != null) {
            dataManager.deleteSearchBackIfNeed();
            FeedBaseModel searchBackModel = FeedModelFactory.createNormalBaseModel();
            String name = FeedSpecialTemplates.SERVICE.getSearchBack().getName();
            searchBackModel.id = name;
            searchBackModel.layout = name;
            newFeeds.add(0, searchBackModel);
            FeedSearchBackManager.INSTANCE.getInfo(dataManager.getTabId()).setSearchBackAdded(true);
        }
    }

    public static void handleSearchBack(String infoStr, FeedDataManager dataManager, UpdateAbility adapter) {
        if (dataManager != null && adapter != null) {
            if (!TextUtils.equals(TabFloatControl.getInstance().getCurTabId(), dataManager.getTabId()) || (!TabFloatControl.getInstance().isShowingFloatViewByType(1) && !TabFloatControl.getInstance().shouldShowShiftFloatView())) {
                TabFloatControl.getInstance().hideWithAnim();
                if (!TextUtils.isEmpty(infoStr)) {
                    try {
                        JSONObject infoJson = new JSONObject(infoStr);
                        if (TextUtils.equals("1", infoJson.optString(FeedSearchBackManager.SHOW_SEARCH_BACK, "0"))) {
                            String query = infoJson.optString(FeedSearchBackManager.SEARCH_BACK_QUERY);
                            String queryScheme = infoJson.optString(FeedSearchBackManager.SEARCH_BACK_SCHEME);
                            if (!TextUtils.isEmpty(query) && !TextUtils.isEmpty(queryScheme)) {
                                FeedSearchBackManager.SearchBackInfo info = new FeedSearchBackManager.SearchBackInfo();
                                info.setSearchBackQuery(query);
                                info.setSearchBackScheme(queryScheme);
                                info.setSearchBackAdded(false);
                                info.setSearchBackShowed(false);
                                FeedSearchBackManager.INSTANCE.saveInfo(dataManager.getTabId(), info);
                                addSearchBackModel(true, dataManager, adapter);
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static Rect getRecyclerViewLocation(RecyclerView recyclerView) {
        Rect rVLocation = new Rect();
        if (recyclerView == null) {
            return rVLocation;
        }
        int[] xy = new int[2];
        recyclerView.getLocationOnScreen(xy);
        rVLocation.left = xy[0];
        rVLocation.top = xy[1];
        rVLocation.right = xy[0] + recyclerView.getWidth();
        rVLocation.bottom = xy[1] + recyclerView.getHeight();
        return rVLocation;
    }

    public static void handleVideoDetailAction(String scheme) {
        if (!TextUtils.isEmpty(scheme) && isInvokeVideoLandingPageScheme(scheme)) {
            FeedPreferenceUtils.putString(BackVideoDetailManager.VIDEO_BACK_NA_DETAIL_SCHEME_SP_KEY, scheme);
            FeedPreferenceUtils.putString(BackVideoDetailManager.OPEN_VIDEO_DETAIL_SCHEME_SP_KEY, "");
            FeedPreferenceUtils.putInt(BackVideoDetailManager.BACK_DETAIL_REFRESH_TIMES_SP_KEY, 0);
        }
    }

    public static boolean isInvokeVideoLandingPageScheme(String scheme) {
        return TextUtils.equals("invokeVideoLandingPage", UnitedSchemeUtility.getAction(Uri.parse(scheme)));
    }

    public static void autoPlayNextMute(MuteAutoPlayEvent event, String channelId) {
        MuteVideoPlayController.getInstance().play(channelId);
    }

    public static String createHotPictureParams(View view2, UserGestureInfo userGestureInfo) {
        if (userGestureInfo == null) {
            return "";
        }
        return AdUtil.createHotParams(view2, userGestureInfo.touchStartXY[0], userGestureInfo.touchStartXY[1]);
    }

    public static boolean isAdClickAreaValid(Context context, UserGestureInfo userGestureInfo) {
        if (userGestureInfo == null) {
            return true;
        }
        return FeedAdUtil.isAdClickAreaValid(context, (float) userGestureInfo.touchStartXY[0]);
    }

    public static void notifyHomeIfNeed(int newFeedCount, int currentPullState) {
        if (currentPullState == 0) {
            FeedFlowRefreshEvent event = new FeedFlowRefreshEvent();
            event.state = 0;
            event.refreshCount = newFeedCount;
            BdEventBus.Companion.getDefault().post(event);
        }
    }

    public static void fillFeedRemainDatas(List<FeedBaseModel> originFeedList, Map<String, FeedBaseModel> fillFeedList) {
        if (originFeedList != null && originFeedList.size() > 0 && fillFeedList != null && fillFeedList.size() > 0) {
            for (int i2 = 0; i2 < originFeedList.size(); i2++) {
                FeedBaseModel model = originFeedList.get(i2);
                FeedBaseModel fillModel = fillFeedList.get(model.id);
                if (model != null && fillModel != null && TextUtils.equals(model.id, fillModel.id) && TextUtils.equals(model.layout, fillModel.layout)) {
                    model.runtimeStatus.isSimpleLoaded = fillModel.runtimeStatus.isSimpleLoaded;
                    model.feedback = fillModel.feedback;
                    model.data = fillModel.data;
                }
            }
            int k = 0;
            while (k < originFeedList.size()) {
                FeedBaseModel model2 = originFeedList.get(k);
                if (model2 == null || model2.runtimeStatus.isSimpleLoaded || FeedBaseModel.checkValidate(model2).isNotOk()) {
                    originFeedList.remove(model2);
                    k--;
                }
                k++;
            }
        }
    }

    public static void scrollToTop(final RefreshablePage page) {
        page.postDelayed(new Runnable() {
            public void run() {
                RefreshablePage.this.scrollToPosition(0, false);
            }
        }, 0);
    }

    public static void performanceMonitor(List<FeedBaseModel> newFeeds, String channelId, FeedDataManager dataManager, RefreshablePage page) {
        if (newFeeds != null && !TextUtils.isEmpty(channelId) && dataManager != null && page != null) {
            boolean needFirstScreen = TextUtils.equals(channelId, "178") || FeedAbtestManager.isHitFeedPerformanceImgFix();
            if (!needFirstScreen) {
                PerformanceStats.getStatsImpl(channelId).findSampleData(page, newFeeds, false);
            }
            final boolean z = needFirstScreen;
            final String str = channelId;
            final RefreshablePage refreshablePage = page;
            final List<FeedBaseModel> list = newFeeds;
            final boolean isEmpty = newFeeds.isEmpty();
            final FeedDataManager feedDataManager = dataManager;
            page.execOnViewTreeChangedOnce(1, new ViewAbility.OnObservableCallback() {
                private long mCallbackCounter = 0;

                public void onObservableChanged(boolean isActive) {
                    if (z) {
                        PerformanceStats.getStatsImpl(str).findSampleData(refreshablePage, list, true);
                    }
                    PerformanceStats.Impl statsImpl = PerformanceStats.getStatsImpl(str);
                    if (isActive) {
                        if (this.mCallbackCounter == 0) {
                            statsImpl.addEvent("P4");
                            if (TextUtils.equals(str, FeedCloudTabUtil.getRealColdBootTab())) {
                                FeedSpeedStats.getStatsImpl(str).setFeedPreDrawTime();
                            }
                            statsImpl.mIsDrawingEnd = true;
                            if (isEmpty) {
                                statsImpl.reset(true);
                            }
                            boolean isImageAllLoaded = statsImpl.isEnd();
                            if (isImageAllLoaded) {
                                statsImpl.end();
                            }
                            if (!feedDataManager.isFeedUIReady() && TextUtils.equals(str, FeedCloudTabUtil.getRealColdBootTab())) {
                                UiThreadUtil.runOnUiThread(new Runnable() {
                                    public void run() {
                                        OnFeedUIReadyEvent.registerLaunchFeedUIReadyEventTasks();
                                    }
                                }, isImageAllLoaded ? 300 : 800);
                                feedDataManager.setIsFeedUIReady(true);
                            }
                        } else {
                            statsImpl.reset(true);
                            if (!feedDataManager.isFeedUIReady() && (feedDataManager.isMainChannel() || feedDataManager.isYouthFeedChannel() || FeedConfig.isTeenagerMode())) {
                                OnFeedUIReadyEvent.registerLaunchFeedUIReadyEventTasks();
                                feedDataManager.setIsFeedUIReady(true);
                            }
                        }
                        this.mCallbackCounter++;
                    }
                }
            });
        }
    }

    public static long parseRefreshTime(FeedFlowModel feedFlowModel, Channel channel) {
        long refreshTime = System.currentTimeMillis();
        if (feedFlowModel == null) {
            return refreshTime;
        }
        long refreshTime2 = FeedUtil.convertRefreshTime(feedFlowModel.timestamp);
        if (TextUtils.equals(feedFlowModel.error, "0")) {
            return refreshTime2;
        }
        if (TextUtils.equals(feedFlowModel.error, "100")) {
            long refreshTime3 = FeedUtil.convertRefreshTime(feedFlowModel.timestamp);
            channel.getPolicyStorage().saveLastRefreshTime(refreshTime3);
            return refreshTime3;
        }
        FeedStatisticCenter.reliabilityCodeError(feedFlowModel, channel.getChannelId());
        return refreshTime2;
    }

    public static void fillFeedInfo(List<FeedBaseModel> newFeeds, FeedDataManager dataManager) {
        if (newFeeds != null && dataManager != null) {
            dataManager.fillFeedModelData(newFeeds, true);
        }
    }

    public static void fillFeedPos(List<FeedBaseModel> newFeeds) {
        if (newFeeds != null) {
            int originPos = 0;
            for (FeedBaseModel model : newFeeds) {
                if (model != null && model.data != null && !TextUtils.equals(model.runtimeStatus.dataFrom, FeedRuntimeStatus.DATA_FROM_READ_INSERT) && !TextUtils.equals(model.runtimeStatus.dataFrom, FeedRuntimeStatus.DATA_FROM_SEARCH_INSERT)) {
                    model.data.relativePosition = originPos;
                    originPos++;
                }
            }
        }
    }

    public static void processSpecialFeed(FeedPolicyModel feedPolicyModel, FeedDataManager dataManager, String refreshState, List<FeedBaseModel> newFeeds, long lastRefreshTime, IFeedFontSettingTplControl feedFontSetting) {
        if (dataManager != null && newFeeds != null) {
            if (feedPolicyModel != null) {
                dataManager.saveLoadHistorySwitch(feedPolicyModel.loadHistory);
            }
            if (dataManager.isMainChannel() && feedFontSetting != null) {
                dataManager.getTplStateManager().deleteSpecialModelInCacheByLayout(FeedSpecialTemplates.SERVICE.getFeedFontSettingView().getName());
                dataManager.getTplStateManager().deleteSpecialModelInHisByLayout(FeedSpecialTemplates.SERVICE.getFeedFontSettingView().getName());
                feedFontSetting.addFontSettingModelIfNeed(newFeeds, FontSettingInsertScene.REFRESH);
            }
            if (!newFeeds.isEmpty() && dataManager.isLoadHistorySwitchOpen() && dataManager.hasHistory()) {
                addTimeLineModel(newFeeds, dataManager);
            }
            dataManager.setTimeLineShowed(false);
            dataManager.setFooterViewShowed(false);
            dataManager.setHeaderShowed(false);
            if (dataManager.isMainChannel()) {
                FeedHeaderManager.getsInstance().adjustWhenColdBoost();
            }
            if (!FeedHeaderManager.getsInstance().headerCanBeShow(lastRefreshTime, refreshState) || !dataManager.isMainChannel() || FeedHeaderManager.getsInstance().showHeaderLogin(lastRefreshTime, refreshState)) {
                dataManager.deleteHeaderLoginModelIfNeed();
            } else {
                addHeaderLoginModel(newFeeds, dataManager);
            }
            if (!FeedSearchBackManager.INSTANCE.getInfo(dataManager.getTabId()).isSearchBackAdded() || (!TextUtils.equals(refreshState, "4") && !TextUtils.equals(refreshState, "11") && !TextUtils.equals(refreshState, "15"))) {
                dataManager.deleteSearchBackIfNeed();
            } else {
                addSearchBackModel(newFeeds, dataManager);
            }
            if (dataManager.isHisRemindViewShow()) {
                dataManager.deleteHisRemindIfNeed();
                dataManager.setHisRemindViewShowState(false);
            }
            dataManager.deleteNewHisRemindIfNeed();
        }
    }

    public static void reliabilityDuplicate(List<FeedBaseModel> newFeeds, int newFeedSize, int originalSize, String channelId) {
        if (originalSize != newFeedSize && newFeeds != null && newFeeds.isEmpty()) {
            FeedStatisticCenter.reliabilityDuplicate(channelId);
        }
    }

    public static void sendTabRefreshEvent(String refreshSource) {
        if (!TextUtils.equals("4", refreshSource)) {
            BdEventBus.Companion.getDefault().post(new TabRefreshEvent(1));
        }
    }

    public static boolean addHistoryRemindModel(List<FeedBaseModel> feeds, FeedDataManager dataManager) {
        if (feeds == null || dataManager == null || dataManager.getCachedFeeds() == null || dataManager.getCachedFeeds().size() <= 0) {
            return false;
        }
        FeedBaseModel remindModel = FeedModelFactory.createNormalBaseModel();
        String name = FeedSpecialTemplates.SERVICE.getHisRemindView().getName();
        remindModel.id = name;
        remindModel.layout = name;
        remindModel.runtimeStatus.rankEnable = false;
        feeds.add(0, remindModel);
        dataManager.setHisRemindViewShowState(true);
        return true;
    }

    public static void hideCapsule(SpecialTplStateManager tplStateManager, CapsulesAbility capsulesAbility) {
        if (tplStateManager != null && capsulesAbility != null && tplStateManager.findSpecialTemplateByLayout(FeedSpecialTemplates.SERVICE.getFeedNewRefreshHisRemindView().getName())) {
            capsulesAbility.hideCapsulesUI();
        }
    }

    public static boolean isLastNormalFeedComplete(RefreshablePage page, FeedDataManager dataManager) {
        if (!(page instanceof RecyclerRefreshablePage) || dataManager == null) {
            return true;
        }
        int lastVisibleItemPosition = page.findLastVisibleItemPosition();
        int originSize = dataManager.getCachedFeeds().size();
        FeedUtil.refreshLog("isLastNormalFeedComplete", "lastVisibleItemPosition:" + lastVisibleItemPosition + "originSize:" + originSize);
        if (lastVisibleItemPosition > 0 && originSize > 0 && lastVisibleItemPosition <= originSize) {
            if (lastVisibleItemPosition == originSize) {
                FeedUtil.refreshLog("isLastNormalFeedComplete", "last view is footer");
                return true;
            } else if (lastVisibleItemPosition == originSize - 1) {
                View lastView = page.findViewByPosition(lastVisibleItemPosition);
                RecyclerView recyclerView = ((RecyclerRefreshablePage) page).getRecyclerView();
                if (!(lastView == null || recyclerView == null)) {
                    if (lastView.getBottom() <= recyclerView.getBottom()) {
                        FeedUtil.refreshLog("isLastNormalFeedComplete", "last view is complete");
                        return true;
                    }
                    FeedUtil.refreshLog("isLastNormalFeedComplete", "last view is not complete");
                    return false;
                }
            } else {
                FeedUtil.refreshLog("isLastNormalFeedComplete", "last view is not last feed");
                return false;
            }
        }
        return true;
    }
}
