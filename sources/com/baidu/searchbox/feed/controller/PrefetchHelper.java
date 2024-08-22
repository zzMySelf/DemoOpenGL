package com.baidu.searchbox.feed.controller;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.search.basic.statistic.SearchSpeedUbcManagerKt;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.ad.prefetch.AdPrefetchCacheUtils;
import com.baidu.searchbox.feed.ad.prefetch.AdPrefetchConstants;
import com.baidu.searchbox.feed.ad.util.FeedAdUtil;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.TplViewCaster;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBaseModelHelper;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.machinefit.perf.strategy.PerformanceStrategy;
import com.baidu.searchbox.machinefit.perf.strategy.model.RunnableTask;
import com.baidu.searchbox.minivideo.dispatcher.MiniVideoSchemeAction;
import com.baidu.searchbox.prefetch.PreFetcher;
import com.baidu.searchbox.prefetch.base.PrefetchItemData;
import com.baidu.searchbox.prefetch.config.PrefetchTaskType;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefetchHelper {
    public static final String MAP_DO_SR_VALUE = "1";
    public static final String MAP_KEY_SR_FLAG = "key_do_sr_flag";
    private static final int PRE_FETCH_DEFAULT_COUNT = 2;
    private static final int PRE_FETCH_DELAY_MILLIS = 300;
    private static final String TAG = "PrefetchHelper";
    private static Map<String, String> prefetchTypeMappingTable;
    private PerformanceStrategy mPerformanceStrategy = new PerformanceStrategy(FeedRuntime.getAppContext(), "Feed");
    private Handler mPreFetchHandler = new Handler();
    private Runnable mPreFetchRunnable;

    public static Map<String, String> generateSrFlagMap() {
        Map<String, String> map = new HashMap<>(1);
        map.put(MAP_KEY_SR_FLAG, "1");
        return map;
    }

    static {
        HashMap hashMap = new HashMap();
        prefetchTypeMappingTable = hashMap;
        hashMap.put("0", PrefetchTaskType.TYPE_HTML);
        prefetchTypeMappingTable.put("1", PrefetchTaskType.TYPE_TEXT);
        prefetchTypeMappingTable.put("2", PrefetchTaskType.TYPE_IMAGE);
        prefetchTypeMappingTable.put("3", PrefetchTaskType.TYPE_ATLAS);
        prefetchTypeMappingTable.put("4", PrefetchTaskType.TYPE_AUTO_VIDEO);
        prefetchTypeMappingTable.put("5", PrefetchTaskType.TYPE_VIDEO);
        prefetchTypeMappingTable.put("7", "type_ad_html");
        prefetchTypeMappingTable.put("8", PrefetchTaskType.TYPE_IFRAME);
        prefetchTypeMappingTable.put("9", PrefetchTaskType.TYPE_SMART_APP);
        prefetchTypeMappingTable.put("10", "type_ad_video");
        prefetchTypeMappingTable.put("11", PrefetchTaskType.TYPE_MINI_VIDEO);
        prefetchTypeMappingTable.put("12", PrefetchTaskType.TYPE_DYNAMIC);
    }

    public void prefetchDataWithStrategy(List<FeedBaseModel> displayList, boolean isFetching, int state, int start, int end) {
        PerformanceStrategy performanceStrategy = this.mPerformanceStrategy;
        if (performanceStrategy != null) {
            final List<FeedBaseModel> list = displayList;
            final boolean z = isFetching;
            final int i2 = state;
            final int i3 = start;
            final int i4 = end;
            performanceStrategy.registerAsyncDelayTask("feedListPrefetchData", new RunnableTask() {
                public void run() {
                    if (WarmTipsManager.isPermissionGrantedForProcess()) {
                        PrefetchHelper.this.onPrefetchData(list, z, i2, i3, i4);
                    }
                }
            });
        }
    }

    public void onPrefetchData(final List<FeedBaseModel> displayList, boolean isFetching, int state, final int start, final int end) {
        if (TextUtils.equals(FeedPolicy.getPrefetchSwitch(), "1") && NetWorkUtils.isHighNetworkConnected()) {
            switch (state) {
                case 0:
                    List<PrefetchItemData> prefetchItems = generatePrefetchData(start, end + 2, displayList, NetWorkUtils.isWifiNetworkConnected(), false);
                    if (prefetchItems.size() > 0) {
                        PreFetcher.getInstance().statePrefetch(0, prefetchItems);
                        return;
                    }
                    return;
                case 1:
                    Handler handler = this.mPreFetchHandler;
                    if (handler != null) {
                        handler.removeCallbacks(this.mPreFetchRunnable);
                    }
                    PreFetcher.getInstance().statePrefetch(1, (List<PrefetchItemData>) null);
                    return;
                case 2:
                    if (!isFetching) {
                        AnonymousClass2 r0 = new Runnable() {
                            public void run() {
                                List<PrefetchItemData> prefetchItems = PrefetchHelper.this.generatePrefetchData(start, end, displayList, NetWorkUtils.isWifiNetworkConnected(), false);
                                if (prefetchItems.size() > 0) {
                                    PreFetcher.getInstance().statePrefetch(2, prefetchItems);
                                }
                            }
                        };
                        this.mPreFetchRunnable = r0;
                        Handler handler2 = this.mPreFetchHandler;
                        if (handler2 != null) {
                            handler2.postDelayed(r0, 300);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    Handler handler3 = this.mPreFetchHandler;
                    if (handler3 != null) {
                        handler3.removeCallbacks(this.mPreFetchRunnable);
                    }
                    List<PrefetchItemData> prefetchItems2 = generatePrefetchData(start, end, displayList, NetWorkUtils.isWifiNetworkConnected(), true);
                    if (prefetchItems2.size() > 0) {
                        PreFetcher.getInstance().statePrefetch(3, prefetchItems2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public List<PrefetchItemData> generatePrefetchData(int start, int end, List<FeedBaseModel> feedList, boolean isWifi, boolean isClick) {
        ArrayList<FeedBaseModel> tmpList;
        int start2;
        int videoDiffCount;
        int i2 = end;
        boolean z = isClick;
        List<PrefetchItemData> prefetchData = new ArrayList<>();
        if (feedList == null) {
        } else if (feedList.size() == 0) {
            int i3 = start;
        } else {
            int videoDiffCount2 = FeedPolicy.getPrefetchVideoCount();
            int videoRangeEnd = i2 + videoDiffCount2;
            int start3 = Math.max(0, start);
            int end2 = Math.min(i2, feedList.size());
            int videoRangeEnd2 = Math.min(videoRangeEnd, feedList.size());
            ArrayList<FeedBaseModel> tmpList2 = cloneSubFeedList((ArrayList) feedList, start3, end2);
            ArrayList<FeedBaseModel> videoTmpList = cloneSubFeedList((ArrayList) feedList, start3, videoRangeEnd2);
            if (tmpList2 == null) {
                return prefetchData;
            }
            int i4 = 0;
            while (i4 < tmpList2.size()) {
                if (tmpList2.get(i4) != null) {
                    FeedBaseModel model = tmpList2.get(i4);
                    FeedBaseModelHelper helper = model.getHelper();
                    if (TextUtils.isEmpty(model.id)) {
                        videoDiffCount = videoDiffCount2;
                        start2 = start3;
                        tmpList = tmpList2;
                    } else if (FeedFilter.checkAdFeed(model)) {
                        FeedAdUtil.prefetchAdPopFormUrl(model);
                        if (model.runtimeStatus.isAdPrefetch || !FeedAdUtil.isAdPrefetch(model)) {
                            videoDiffCount = videoDiffCount2;
                            start2 = start3;
                            tmpList = tmpList2;
                        } else {
                            model.runtimeStatus.isAdPrefetch = true;
                            String extraParams = "";
                            Map<String, String> params = new HashMap<>();
                            if (model.data.ad.ext != null && !TextUtils.isEmpty(model.data.ad.ext.extraParams)) {
                                extraParams = model.data.ad.ext.extraParams;
                            }
                            videoDiffCount = videoDiffCount2;
                            start2 = start3;
                            if (helper.getPrefetchType() == 100) {
                                params.put(SearchSpeedUbcManagerKt.EXT_PREFETCH_TYPE, "2");
                            } else {
                                params.put(SearchSpeedUbcManagerKt.EXT_PREFETCH_TYPE, helper.getPrefetchType() + "");
                            }
                            params.put("ext", extraParams);
                            params.put("lp_real_url", helper.getLpRealUrl());
                            PrefetchItemData.Builder builder = new PrefetchItemData.Builder().key(model.id).url(helper.getPrefetchHtmlUrl(true)).params(params);
                            if (helper.getPrefetchType() == 100) {
                                builder.type(PrefetchTaskType.TYPE_AD_NON_ESCROW);
                            } else {
                                builder.type("type_ad_html");
                            }
                            prefetchData.add(builder.build());
                            if (TextUtils.equals(model.layout, AdPrefetchConstants.LAYOUT_AD_VIDEO) || TextUtils.equals(model.layout, "image1") || TextUtils.equals(model.layout, "ad_vertical_video") || TextUtils.equals(model.layout, AdPrefetchConstants.LAYOUT_AD_AI_VIDEO)) {
                                PrefetchItemData.Builder builder2 = builder;
                                tmpList = tmpList2;
                                String str = extraParams;
                                AdPrefetchCacheUtils.putParam2Cache(model.id, new AdPrefetchCacheUtils.AdPrefetchParams(helper.getLpRealUrl(), helper.getPrefetchType() + ""));
                            } else {
                                tmpList = tmpList2;
                            }
                        }
                    } else {
                        videoDiffCount = videoDiffCount2;
                        start2 = start3;
                        tmpList = tmpList2;
                        if (!z || !FeedAbtestManager.isPrefetchInTouchDown()) {
                            if (!TextUtils.isEmpty(helper.getPrefetchHtmlUrl(isWifi || z))) {
                                prefetchData.add(new PrefetchItemData.Builder().key(model.id).url(helper.getPrefetchHtmlUrl(isWifi || z)).type(PrefetchTaskType.TYPE_HTML).build());
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(helper.getPrefetchUrl()) && !TextUtils.isEmpty(model.id)) {
                        prefetchData.add(new PrefetchItemData.Builder().key(model.id).url(helper.getPrefetchUrl()).type(PrefetchTaskType.TYPE_TEXT).build());
                    }
                    if (!TextUtils.isEmpty(helper.getPrefetchAlbumJson()) && !TextUtils.isEmpty(model.id)) {
                        prefetchData.add(new PrefetchItemData.Builder().key(model.id).url(helper.getPrefetchAlbumJson()).type(PrefetchTaskType.TYPE_TEXT).build());
                    }
                    if ((!z || !FeedAbtestManager.isPrefetchInTouchDown()) && ((isWifi || z) && !TextUtils.isEmpty(helper.getPrefetchImgUrl()) && !TextUtils.isEmpty(model.id))) {
                        prefetchData.add(new PrefetchItemData.Builder().key(model.id).url(helper.getPrefetchImgUrl()).type(FeedFilter.checkAtlasFeed(model) ? PrefetchTaskType.TYPE_ATLAS : PrefetchTaskType.TYPE_IMAGE).params(generateSrFlagMap()).build());
                    }
                    if ((isWifi || z) && !TextUtils.isEmpty(helper.getPrefetchImgUrl()) && FeedFilter.checkVideoFeed(model)) {
                        prefetchData.add(new PrefetchItemData.Builder().key(model.id).url(helper.getPrefetchImgUrl()).type(PrefetchTaskType.TYPE_IMAGE).build());
                    }
                    if (!TextUtils.isEmpty(helper.getPrefetchSmartAppUrl()) && !TextUtils.isEmpty(model.id) && (FeedFilter.checkSmartAppFeed(model) || FeedFilter.checkAdFeed(model))) {
                        prefetchData.add(new PrefetchItemData.Builder().key(model.id).url(helper.getPrefetchSmartAppUrl()).type(PrefetchTaskType.TYPE_SMART_APP).clicked(z).build());
                    }
                    if (!TextUtils.isEmpty(helper.getDynamicPrefetchInfo()) && !TextUtils.isEmpty(model.id)) {
                        prefetchData.add(new PrefetchItemData.Builder().key(model.id).url(helper.getDynamicPrefetchInfo()).type(PrefetchTaskType.TYPE_DYNAMIC).clicked(z).build());
                    }
                    if (FeedFilter.checkLiveTemplate(model)) {
                        prefetchData.add(new PrefetchItemData.Builder().key(model.id).type(PrefetchTaskType.TYPE_LIVE).params(helper.getLivePrefetchInfo()).clicked(z).build());
                    }
                } else {
                    videoDiffCount = videoDiffCount2;
                    start2 = start3;
                    tmpList = tmpList2;
                }
                i4++;
                tmpList2 = tmpList;
                videoDiffCount2 = videoDiffCount;
                start3 = start2;
            }
            appendVideoPrefetchData(prefetchData, videoTmpList, videoRangeEnd2 - end2, z);
            return prefetchData;
        }
        return prefetchData;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x012f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void appendVideoPrefetchData(java.util.List<com.baidu.searchbox.prefetch.base.PrefetchItemData> r17, java.util.List<com.baidu.searchbox.feed.model.FeedBaseModel> r18, int r19, boolean r20) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            boolean r2 = com.baidu.android.util.devices.NetWorkUtils.isHighNetworkConnected()
            if (r2 == 0) goto L_0x0136
            if (r1 == 0) goto L_0x0136
            if (r20 == 0) goto L_0x0012
            r12 = r16
            goto L_0x0138
        L_0x0012:
            int r2 = r18.size()
            r3 = 0
        L_0x0017:
            if (r3 >= r2) goto L_0x0133
            java.lang.Object r4 = r1.get(r3)
            if (r4 == 0) goto L_0x012d
            java.lang.Object r4 = r1.get(r3)
            com.baidu.searchbox.feed.model.FeedBaseModel r4 = (com.baidu.searchbox.feed.model.FeedBaseModel) r4
            boolean r5 = com.baidu.searchbox.feed.parser.FeedFilter.checkVideoFeed(r4)
            if (r5 != 0) goto L_0x0036
            boolean r5 = com.baidu.searchbox.feed.parser.FeedFilter.checkVideoAd(r4)
            if (r5 == 0) goto L_0x0032
            goto L_0x0036
        L_0x0032:
            r12 = r16
            goto L_0x012f
        L_0x0036:
            java.lang.String r5 = "type_video"
            com.baidu.searchbox.feed.model.FeedBaseModelHelper r6 = r4.getHelper()
            boolean r7 = r6.isAutoVideo()
            if (r7 == 0) goto L_0x0047
            java.lang.String r5 = "type_auto_video"
            goto L_0x005a
        L_0x0047:
            boolean r7 = r6.isADVideo()
            if (r7 == 0) goto L_0x0051
            java.lang.String r5 = "type_auto_video"
            goto L_0x005a
        L_0x0051:
            boolean r7 = r6.isMiniVideo()
            if (r7 == 0) goto L_0x005a
            java.lang.String r5 = "type_mini_video"
        L_0x005a:
            org.json.JSONArray r7 = r6.getPrefetch6sVideo()
            java.lang.String r8 = "1"
            java.lang.String r9 = "invisible"
            java.lang.String r10 = "cmd"
            java.lang.String r11 = "preboot_video"
            if (r7 == 0) goto L_0x00b9
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            com.baidu.searchbox.feed.model.FeedItemData r12 = r4.data
            if (r12 == 0) goto L_0x007f
            com.baidu.searchbox.feed.model.FeedItemData r12 = r4.data
            com.baidu.searchbox.feed.model.CString r12 = r12.cmd
            java.lang.String r12 = r12.get()
            if (r12 == 0) goto L_0x007f
            r7.put(r10, r12)
        L_0x007f:
            org.json.JSONObject r12 = r6.getSmartPrefetchPolicy()
            if (r12 == 0) goto L_0x0090
            org.json.JSONObject r12 = r6.getSmartPrefetchPolicy()
            java.lang.String r12 = r12.toString()
            r7.put(r11, r12)
        L_0x0090:
            int r12 = r3 + r19
            if (r12 < r2) goto L_0x0097
            r7.put(r9, r8)
        L_0x0097:
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r12 = new com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder
            r12.<init>()
            java.lang.String r13 = r4.id
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r12 = r12.key(r13)
            org.json.JSONArray r13 = r6.getPrefetch6sVideo()
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r12 = r12.prefetchVideo(r13)
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r12 = r12.params(r7)
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r12 = r12.type(r5)
            com.baidu.searchbox.prefetch.base.PrefetchItemData r12 = r12.build()
            r0.add(r12)
        L_0x00b9:
            org.json.JSONArray r7 = r6.getPrefetchVideo()
            if (r7 == 0) goto L_0x012a
            com.baidu.searchbox.feed.model.FeedItemData r7 = r4.data
            com.baidu.searchbox.feed.model.CString r7 = r7.cmd
            java.lang.String r7 = r7.get()
            com.baidu.searchbox.feed.model.FeedItemData r12 = r4.data
            if (r12 == 0) goto L_0x00de
            boolean r12 = android.text.TextUtils.isEmpty(r7)
            if (r12 != 0) goto L_0x00db
            r12 = r16
            boolean r13 = r12.isInvokeMiniOrShortVideoScheme(r7)
            if (r13 == 0) goto L_0x00e0
            r13 = 1
            goto L_0x00e1
        L_0x00db:
            r12 = r16
            goto L_0x00e0
        L_0x00de:
            r12 = r16
        L_0x00e0:
            r13 = 0
        L_0x00e1:
            if (r13 == 0) goto L_0x012f
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            com.baidu.searchbox.feed.model.FeedItemData r15 = r4.data
            if (r15 == 0) goto L_0x00ef
            r14.put(r10, r7)
        L_0x00ef:
            org.json.JSONObject r10 = r6.getSmartPrefetchPolicy()
            if (r10 == 0) goto L_0x0100
            org.json.JSONObject r10 = r6.getSmartPrefetchPolicy()
            java.lang.String r10 = r10.toString()
            r14.put(r11, r10)
        L_0x0100:
            int r10 = r3 + r19
            if (r10 < r2) goto L_0x0107
            r14.put(r9, r8)
        L_0x0107:
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r8 = new com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder
            r8.<init>()
            java.lang.String r9 = r4.id
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r8 = r8.key(r9)
            org.json.JSONArray r9 = r6.getPrefetchVideo()
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r8 = r8.prefetchVideo(r9)
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r8 = r8.params(r14)
            com.baidu.searchbox.prefetch.base.PrefetchItemData$Builder r8 = r8.type(r5)
            com.baidu.searchbox.prefetch.base.PrefetchItemData r8 = r8.build()
            r0.add(r8)
            goto L_0x012f
        L_0x012a:
            r12 = r16
            goto L_0x012f
        L_0x012d:
            r12 = r16
        L_0x012f:
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0133:
            r12 = r16
            return
        L_0x0136:
            r12 = r16
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.controller.PrefetchHelper.appendVideoPrefetchData(java.util.List, java.util.List, int, boolean):void");
    }

    public View.OnTouchListener prefetchTouchListener(final boolean isPrefetchSwitchEnable) {
        return new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                FeedBaseModel model;
                String str;
                FeedTemplate feedView = TplViewCaster.castToTemplate(v);
                if (feedView == null || event.getAction() != 0 || !isPrefetchSwitchEnable || !NetWorkUtils.isHighNetworkConnected() || (model = feedView.getFeedModel()) == null || TextUtils.isEmpty(model.id)) {
                    return false;
                }
                List<PrefetchItemData> prefetchData = new ArrayList<>();
                FeedBaseModelHelper helper = model.getHelper();
                if (!TextUtils.isEmpty(helper.getPrefetchHtmlUrl(true))) {
                    prefetchData.add(new PrefetchItemData.Builder().key(model.id).url(helper.getPrefetchHtmlUrl(true)).type(PrefetchTaskType.TYPE_HTML).build());
                }
                if (!TextUtils.isEmpty(helper.getPrefetchImgUrl())) {
                    PrefetchItemData.Builder url = new PrefetchItemData.Builder().key(model.id).url(helper.getPrefetchImgUrl());
                    if (FeedFilter.checkAtlasFeed(model)) {
                        str = PrefetchTaskType.TYPE_ATLAS;
                    } else {
                        str = PrefetchTaskType.TYPE_IMAGE;
                    }
                    prefetchData.add(url.type(str).params(FeedFilter.checkAtlasFeed(model) ? null : PrefetchHelper.generateSrFlagMap()).build());
                }
                PreFetcher.getInstance().statePrefetch(3, prefetchData);
                return false;
            }
        };
    }

    private boolean isInvokeMiniOrShortVideoScheme(String scheme) {
        String action = UnitedSchemeUtility.getAction(Uri.parse(scheme));
        return TextUtils.equals(action, "invokeVideoLandingPage") || TextUtils.equals(action, MiniVideoSchemeAction.ACTION_MINI_LANDING) || TextUtils.equals(action, "invokeVideoDetail");
    }

    public void release() {
        Handler handler = this.mPreFetchHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPreFetchRunnable);
            this.mPreFetchHandler = null;
            this.mPreFetchRunnable = null;
        }
        this.mPerformanceStrategy = null;
    }

    private ArrayList<FeedBaseModel> cloneSubFeedList(ArrayList<FeedBaseModel> original, int fromIndex, int toIndex) {
        if (original == null || fromIndex < 0 || toIndex > original.size() || fromIndex > toIndex) {
            return null;
        }
        try {
            return new ArrayList<>(original.subList(fromIndex, toIndex));
        } catch (Exception e2) {
            return null;
        }
    }

    public static String mappingNewPrefetchType(String type) {
        String newTypeStr = prefetchTypeMappingTable.get(type);
        if (TextUtils.isEmpty(newTypeStr)) {
            return type;
        }
        return newTypeStr;
    }
}
