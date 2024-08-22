package com.baidu.searchbox.generalcommunity.data.network;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.feed.base.hot.DynamicBeanPersonalize;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.utils.FeedModelFactory;
import com.baidu.searchbox.feed.parser.IFeedDataParser;
import com.baidu.searchbox.generalcommunity.context.GCommunityRuntime;
import com.baidu.searchbox.generalcommunity.injector.ConfigOptions;
import com.baidu.searchbox.generalcommunity.injector.RespInterceptor;
import com.baidu.searchbox.generalcommunity.utils.CommonUtils;
import com.baidu.searchbox.generalcommunity.utils.InjectorUtils;
import com.baidu.searchbox.generalcommunity.utils.performance.PullRefreshPerformanceStats;
import org.json.JSONObject;

public class GCommunityParser {
    public static final boolean DEBUG = GCommunityRuntime.GLOBAL_DEBUG;
    public static final String TAG = "GCommunityParser";
    private String mBusiness;

    public GCommunityParser(String business) {
        this.mBusiness = business;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0153  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.generalcommunity.model.GCommunityModel parseResponse(java.lang.String r22, boolean r23) {
        /*
            r21 = this;
            r1 = r21
            r2 = r23
            java.lang.String r0 = "policies"
            java.lang.String r3 = "toast"
            java.lang.String r4 = "has_more"
            java.lang.String r5 = ""
            com.baidu.searchbox.generalcommunity.model.GCommunityModel r6 = new com.baidu.searchbox.generalcommunity.model.GCommunityModel
            r6.<init>()
            java.lang.String r7 = r1.mBusiness
            com.baidu.searchbox.generalcommunity.injector.ConfigOptions r7 = com.baidu.searchbox.generalcommunity.utils.InjectorUtils.provideConfigOptions(r7)
            r8 = 0
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0119 }
            r10 = r22
            r9.<init>(r10)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r11 = "errno"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x0117 }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0117 }
            r13 = 1
            if (r12 != 0) goto L_0x0049
            java.lang.String r12 = "0"
            boolean r12 = android.text.TextUtils.equals(r12, r11)     // Catch:{ Exception -> 0x0117 }
            if (r12 != 0) goto L_0x0049
            if (r2 == 0) goto L_0x0048
            if (r7 == 0) goto L_0x0048
            boolean r0 = r7.mIsReportStability     // Catch:{ Exception -> 0x0117 }
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = r1.mBusiness     // Catch:{ Exception -> 0x0117 }
            int r3 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x0117 }
            com.baidu.searchbox.generalcommunity.utils.performance.GCommunityStabilityPerformance.reportStabilityStatistics(r0, r13, r3, r5)     // Catch:{ Exception -> 0x0117 }
        L_0x0048:
            return r6
        L_0x0049:
            java.lang.String r12 = "data"
            org.json.JSONObject r12 = r9.optJSONObject(r12)     // Catch:{ Exception -> 0x0117 }
            if (r12 != 0) goto L_0x0052
            return r6
        L_0x0052:
            java.lang.String r14 = "req_time"
            int r14 = r12.optInt(r14)     // Catch:{ Exception -> 0x0117 }
            long r14 = (long) r14     // Catch:{ Exception -> 0x0117 }
            r6.reqTimeStamp = r14     // Catch:{ Exception -> 0x0117 }
            java.lang.String r14 = "request_id"
            java.lang.String r14 = r12.optString(r14)     // Catch:{ Exception -> 0x0117 }
            r6.requestId = r14     // Catch:{ Exception -> 0x0117 }
            java.lang.String r14 = "shield_status"
            int r14 = r12.optInt(r14, r8)     // Catch:{ Exception -> 0x0117 }
            r6.shieldStatus = r14     // Catch:{ Exception -> 0x0117 }
            boolean r14 = r12.has(r4)     // Catch:{ Exception -> 0x0117 }
            if (r14 == 0) goto L_0x007b
            int r4 = r12.optInt(r4)     // Catch:{ Exception -> 0x0117 }
            r6.hasMore = r4     // Catch:{ Exception -> 0x0117 }
            goto L_0x0086
        L_0x007b:
            if (r7 == 0) goto L_0x0084
            boolean r4 = r7.mNeedLoadMore     // Catch:{ Exception -> 0x0117 }
            if (r4 == 0) goto L_0x0084
            r6.hasMore = r13     // Catch:{ Exception -> 0x0117 }
            goto L_0x0086
        L_0x0084:
            r6.hasMore = r8     // Catch:{ Exception -> 0x0117 }
        L_0x0086:
            java.lang.String r4 = "business"
            org.json.JSONObject r4 = r12.optJSONObject(r4)     // Catch:{ Exception -> 0x0117 }
            if (r4 == 0) goto L_0x0099
            java.lang.String r13 = r1.mBusiness     // Catch:{ Exception -> 0x0117 }
            com.baidu.searchbox.generalcommunity.injector.BusinessOwnFactory r13 = com.baidu.searchbox.generalcommunity.utils.InjectorUtils.provideOwnViewFactory(r13)     // Catch:{ Exception -> 0x0117 }
            if (r13 == 0) goto L_0x0099
            r13.getBusinessOwnData(r4, r6)     // Catch:{ Exception -> 0x0117 }
        L_0x0099:
            java.lang.String r13 = "itemlist"
            org.json.JSONObject r13 = r12.optJSONObject(r13)     // Catch:{ Exception -> 0x0117 }
            if (r13 != 0) goto L_0x00a3
            return r6
        L_0x00a3:
            boolean r14 = r13.has(r3)     // Catch:{ Exception -> 0x0117 }
            if (r14 == 0) goto L_0x00b8
            com.baidu.searchbox.generalcommunity.model.ToastDataBean r14 = new com.baidu.searchbox.generalcommunity.model.ToastDataBean     // Catch:{ Exception -> 0x0117 }
            r14.<init>()     // Catch:{ Exception -> 0x0117 }
            org.json.JSONObject r3 = r13.optJSONObject(r3)     // Catch:{ Exception -> 0x0117 }
            com.baidu.searchbox.generalcommunity.model.ToastDataBean r3 = r14.toModel((org.json.JSONObject) r3)     // Catch:{ Exception -> 0x0117 }
            r6.toast = r3     // Catch:{ Exception -> 0x0117 }
        L_0x00b8:
            boolean r3 = r13.has(r0)     // Catch:{ Exception -> 0x0117 }
            if (r3 == 0) goto L_0x00cd
            com.baidu.searchbox.generalcommunity.model.GCommunityPolicyModel r3 = new com.baidu.searchbox.generalcommunity.model.GCommunityPolicyModel     // Catch:{ Exception -> 0x0117 }
            r3.<init>()     // Catch:{ Exception -> 0x0117 }
            org.json.JSONObject r0 = r13.optJSONObject(r0)     // Catch:{ Exception -> 0x0117 }
            com.baidu.searchbox.generalcommunity.model.GCommunityPolicyModel r0 = r3.toModel((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x0117 }
            r6.policy = r0     // Catch:{ Exception -> 0x0117 }
        L_0x00cd:
            java.lang.String r0 = "items"
            org.json.JSONArray r0 = r13.optJSONArray(r0)     // Catch:{ Exception -> 0x0117 }
            if (r0 != 0) goto L_0x00d7
            return r6
        L_0x00d7:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0117 }
            r3.<init>()     // Catch:{ Exception -> 0x0117 }
            int r14 = r0.length()     // Catch:{ Exception -> 0x0117 }
            r15 = 0
        L_0x00e1:
            if (r15 >= r14) goto L_0x0110
            org.json.JSONObject r16 = r0.getJSONObject(r15)     // Catch:{ Exception -> 0x0117 }
            r17 = r16
            r8 = r17
            com.baidu.searchbox.feed.model.FeedBaseModel r17 = r1.parseCommunityBaseModel(r8, r2)     // Catch:{ Exception -> 0x0117 }
            r18 = r17
            r17 = r0
            com.baidu.searchbox.generalcommunity.data.network.GCommunityModelChecker r0 = com.baidu.searchbox.generalcommunity.data.network.GCommunityModelChecker.getInstance()     // Catch:{ Exception -> 0x0117 }
            r19 = r4
            java.lang.String r4 = r1.mBusiness     // Catch:{ Exception -> 0x0117 }
            r20 = r8
            r8 = r18
            boolean r0 = r0.check(r4, r8)     // Catch:{ Exception -> 0x0117 }
            if (r0 == 0) goto L_0x0108
            r3.add(r8)     // Catch:{ Exception -> 0x0117 }
        L_0x0108:
            int r15 = r15 + 1
            r0 = r17
            r4 = r19
            r8 = 0
            goto L_0x00e1
        L_0x0110:
            r17 = r0
            r19 = r4
            r6.baseModelList = r3     // Catch:{ Exception -> 0x0117 }
            goto L_0x0152
        L_0x0117:
            r0 = move-exception
            goto L_0x011c
        L_0x0119:
            r0 = move-exception
            r10 = r22
        L_0x011c:
            r0.printStackTrace()
            boolean r3 = android.text.TextUtils.isEmpty(r22)
            if (r3 != 0) goto L_0x0134
            if (r2 == 0) goto L_0x0134
            if (r7 == 0) goto L_0x0134
            boolean r3 = r7.mIsReportStability
            if (r3 == 0) goto L_0x0134
            java.lang.String r3 = r1.mBusiness
            r4 = 2
            r8 = 0
            com.baidu.searchbox.generalcommunity.utils.performance.GCommunityStabilityPerformance.reportStabilityStatistics(r3, r4, r8, r5)
        L_0x0134:
            boolean r3 = com.baidu.searchbox.generalcommunity.context.GCommunityRuntime.GLOBAL_DEBUG
            if (r3 != 0) goto L_0x0153
            com.baidu.pyramid.runtime.service.ServiceReference r3 = com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler.SERVICE_REFERENCE
            java.lang.Object r3 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r3)
            com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler r3 = (com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler) r3
            if (r3 == 0) goto L_0x0152
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "GCommunityParser"
            r4.<init>(r5)
            r5 = 0
            java.lang.String r8 = "community"
            java.lang.String r9 = "parseResponse"
            r3.onException(r4, r8, r9, r5)
        L_0x0152:
            return r6
        L_0x0153:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.generalcommunity.data.network.GCommunityParser.parseResponse(java.lang.String, boolean):com.baidu.searchbox.generalcommunity.model.GCommunityModel");
    }

    private FeedBaseModel parseCommunityBaseModel(JSONObject itemObj, boolean isPullToRefresh) {
        if (itemObj == null) {
            return null;
        }
        PullRefreshPerformanceStats.Impl refreshImpl = PullRefreshPerformanceStats.getStatsImpl(this.mBusiness);
        if (isPullToRefresh) {
            refreshImpl.setItemParseCount();
        }
        FeedBaseModel baseModel = parseCommunityBaseModel(itemObj);
        if (baseModel == null) {
            return null;
        }
        FeedItemData itemData = baseModel.data;
        if ((itemData instanceof DynamicBeanPersonalize) && ((DynamicBeanPersonalize) itemData).getPrePicList() != null && isPullToRefresh && refreshImpl.needPreLoad()) {
            refreshImpl.putImageValue(baseModel.id, ((DynamicBeanPersonalize) itemData).getPrePicList().size());
            refreshImpl.setIncludePicItem(false);
            CommonUtils.prefetchImage(((DynamicBeanPersonalize) itemData).getPrePicList());
        }
        return baseModel;
    }

    public FeedBaseModel parseCommunityBaseModel(JSONObject itemObj) {
        ConfigOptions configOptions;
        FeedBaseModel baseModel = FeedModelFactory.createNormalBaseModel();
        FeedBaseModel.fillModel(baseModel, itemObj, (IFeedDataParser<FeedItemData, IFeedDataParser.ItemDataParseEnv>) null);
        JSONObject dataObj = itemObj.optJSONObject("data");
        String layout = itemObj.optString("layout");
        RespInterceptor interceptor = InjectorUtils.provideRespInterceptor(this.mBusiness);
        if (interceptor != null) {
            baseModel.layout = interceptor.handleTemplateLayout(dataObj, layout);
        } else {
            baseModel.layout = layout;
        }
        if (baseModel.layout == null || !InjectorUtils.isTypeRegistered(this.mBusiness, baseModel.layout)) {
            if (DEBUG) {
                Log.d(TAG, "#parseCommunityBaseModel# layout: " + baseModel.layout + ", isRegistered: " + InjectorUtils.isTypeRegistered(this.mBusiness, baseModel.layout));
            }
            return null;
        }
        baseModel.ts = System.currentTimeMillis() + "";
        baseModel.data = (FeedItemData) InjectorUtils.provideBean(this.mBusiness, baseModel).toModel(dataObj != null ? dataObj : itemObj);
        baseModel.runtimeStatus.channelId = this.mBusiness;
        if (!(baseModel.data == null || baseModel.data.feedBar == null || baseModel.data.feedBar.share == null || !TextUtils.isEmpty(baseModel.data.feedBar.share.from) || (configOptions = InjectorUtils.provideConfigOptions(this.mBusiness)) == null || TextUtils.isEmpty(configOptions.mShareFrom))) {
            baseModel.data.feedBar.share.from = configOptions.mShareFrom;
        }
        return baseModel;
    }
}
