package com.baidu.searchbox.feed.tab.utils;

import android.graphics.drawable.Drawable;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.FeedSimpleKVFilePersister;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.container.creator.PageParams;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.home.NewHomeFun;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.tab.interaction.IAcrossBgProcessor;
import com.baidu.searchbox.feed.tab.model.FeedAcrossBg;
import com.baidu.searchbox.feed.tab.model.FeedAcrossBgHolder;
import com.baidu.searchbox.feed.tab.model.FeedAcrossBgHolderKt;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.homepage.extend.HomeBackgroundSkinInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001fJ\u0016\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0006J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\rH\u0002J\u000e\u0010'\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0005J\u0015\u0010(\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0018\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005J\u000e\u0010-\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0005J\u0010\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\u0010\u00100\u001a\u0004\u0018\u0001012\u0006\u0010#\u001a\u00020\u0005J\u0010\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005J\u0010\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005J\u0010\u00104\u001a\u0004\u0018\u0001012\u0006\u0010#\u001a\u00020\u0005J\u0012\u00105\u001a\u0004\u0018\u0001062\b\u0010#\u001a\u0004\u0018\u00010\u0005J\u0006\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u0002092\u0006\u0010#\u001a\u00020\u0005J\u0012\u0010:\u001a\u0004\u0018\u00010\u001f2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u000e\u0010;\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005J\u000e\u0010<\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0005J\u000e\u0010=\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010>\u001a\u00020\u001bJ\b\u0010?\u001a\u00020\u001bH\u0002J\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u0005H\u0002J\u000e\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u0010J\u0010\u0010D\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u0010H\u0002J\u0010\u0010E\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u0010H\u0002J\u000e\u0010F\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0005J\u0010\u0010G\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u0005H\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006I"}, d2 = {"Lcom/baidu/searchbox/feed/tab/utils/FeedAcrossBgHelper;", "", "()V", "bgProcessorMap", "", "", "Lcom/baidu/searchbox/feed/tab/interaction/IAcrossBgProcessor;", "getBgProcessorMap", "()Ljava/util/Map;", "setBgProcessorMap", "(Ljava/util/Map;)V", "feedBgHolders", "Ljava/util/HashMap;", "Lcom/baidu/searchbox/feed/tab/model/FeedAcrossBgHolder;", "Lkotlin/collections/HashMap;", "isCover", "", "()Z", "setCover", "(Z)V", "isLoadedLocalConfig", "setLoadedLocalConfig", "isOperateStatus", "setOperateStatus", "isTryGetBg", "setTryGetBg", "addAcrossBgIfNeed", "", "tabInfo", "Lcom/baidu/searchbox/feed/tab/update/MultiTabItemInfo;", "images", "Lorg/json/JSONObject;", "operateImages", "homeResource", "addBgProcessor", "tabId", "bgProcessor", "addFeedBgHolderIfNeed", "bgHolder", "canShowFeedAcrossBg", "clearBgImgIfNeed", "(Ljava/lang/String;)Lkotlin/Unit;", "getAcrossBgKey", "type", "getAcrossBgPath", "getBackgroundInfo", "getBannerLottie", "getCover", "getFeedBg", "Landroid/graphics/drawable/Drawable;", "getHeaderImg", "getHeaderNightImg", "getHomeBg", "getHomeColorBg", "Lcom/baidu/searchbox/homepage/extend/HomeBackgroundSkinInfo;", "getOperateStatus", "getStretchBg", "", "getTabAcrossBgJson", "getTabAcrossBgJsonStr", "isAcrossBgValid", "isHeaderImgValid", "loadAllConfig", "loadLocalConfigIfNeed", "parseBgHolderFromConfig", "config", "processAllAcrossBg", "needSave", "processAllAcrossBgAsync", "processAllAcrossBgSync", "removeBgProcessor", "saveBgConfig", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedAcrossBgHelper.kt */
public final class FeedAcrossBgHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<FeedAcrossBgHelper> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, FeedAcrossBgHelper$Companion$instance$2.INSTANCE);
    private Map<String, IAcrossBgProcessor> bgProcessorMap;
    private HashMap<String, FeedAcrossBgHolder> feedBgHolders;
    private boolean isCover;
    private boolean isLoadedLocalConfig;
    private boolean isOperateStatus;
    private boolean isTryGetBg;

    public /* synthetic */ FeedAcrossBgHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FeedAcrossBgHelper() {
        this.feedBgHolders = new HashMap<>();
        this.bgProcessorMap = new HashMap();
        this.isTryGetBg = true;
    }

    public final boolean isOperateStatus() {
        return this.isOperateStatus;
    }

    public final void setOperateStatus(boolean z) {
        this.isOperateStatus = z;
    }

    public final boolean isCover() {
        return this.isCover;
    }

    public final void setCover(boolean z) {
        this.isCover = z;
    }

    public final Map<String, IAcrossBgProcessor> getBgProcessorMap() {
        return this.bgProcessorMap;
    }

    public final void setBgProcessorMap(Map<String, IAcrossBgProcessor> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.bgProcessorMap = map;
    }

    public final boolean isLoadedLocalConfig() {
        return this.isLoadedLocalConfig;
    }

    public final void setLoadedLocalConfig(boolean z) {
        this.isLoadedLocalConfig = z;
    }

    public final boolean isTryGetBg() {
        return this.isTryGetBg;
    }

    public final void setTryGetBg(boolean z) {
        this.isTryGetBg = z;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/tab/utils/FeedAcrossBgHelper$Companion;", "", "()V", "instance", "Lcom/baidu/searchbox/feed/tab/utils/FeedAcrossBgHelper;", "getInstance", "()Lcom/baidu/searchbox/feed/tab/utils/FeedAcrossBgHelper;", "instance$delegate", "Lkotlin/Lazy;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedAcrossBgHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FeedAcrossBgHelper getInstance() {
            return (FeedAcrossBgHelper) FeedAcrossBgHelper.instance$delegate.getValue();
        }
    }

    public final void addAcrossBgIfNeed(MultiTabItemInfo tabInfo, JSONObject images, JSONObject operateImages, JSONObject homeResource) {
        FeedAcrossBgHolder bgHolder;
        Intrinsics.checkNotNullParameter(tabInfo, PageParams.KEY_TAB_INFO);
        if (NewHomeFun.INSTANCE.isNewHome()) {
            bgHolder = FeedAcrossBgHolderKt.toBgHolderByHomeResource(tabInfo.mId, homeResource);
        } else {
            boolean needPreloadFeedBg = !tabInfo.hasRNInfo();
            String str = tabInfo.mId;
            String str2 = null;
            String jSONObject = images != null ? images.toString() : null;
            if (operateImages != null) {
                str2 = operateImages.toString();
            }
            bgHolder = FeedAcrossBgHolderKt.toBgHolderObject(str, needPreloadFeedBg, jSONObject, str2);
        }
        if (bgHolder != null) {
            String str3 = tabInfo.mId;
            Intrinsics.checkNotNullExpressionValue(str3, "tabInfo.mId");
            addFeedBgHolderIfNeed(str3, bgHolder);
        }
    }

    private final JSONObject getTabAcrossBgJson(String tabId) {
        FeedAcrossBgHolder bgHolder = this.feedBgHolders.get(tabId);
        if (bgHolder != null) {
            return bgHolder.toJsonObject();
        }
        return null;
    }

    public final String getTabAcrossBgJsonStr(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        JSONObject tabAcrossBgJson = getTabAcrossBgJson(tabId);
        String jSONObject = tabAcrossBgJson != null ? tabAcrossBgJson.toString() : null;
        return jSONObject == null ? "" : jSONObject;
    }

    public final JSONObject getBackgroundInfo(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getBackgroundInfo_u24lambda_u2d2 = jSONObject;
        try {
            Object backgroundJson = getTabAcrossBgJson(tabId);
            if (backgroundJson == null) {
                backgroundJson = "";
            }
            $this$getBackgroundInfo_u24lambda_u2d2.put("backgrounds", backgroundJson);
            $this$getBackgroundInfo_u24lambda_u2d2.put("homeOperateStatus", getOperateStatus());
            $this$getBackgroundInfo_u24lambda_u2d2.put("isCover", getCover());
        } catch (JSONException e2) {
        }
        return jSONObject;
    }

    public final void processAllAcrossBg(boolean needSave) {
        if (UiThreadUtils.isOnUiThread()) {
            processAllAcrossBgAsync(needSave);
        } else {
            processAllAcrossBgSync(needSave);
        }
    }

    private final void processAllAcrossBgAsync(boolean needSave) {
        ExecutorUtilsExt.postOnElastic(new FeedAcrossBgHelper$$ExternalSyntheticLambda0(this, needSave), FeedAcrossBgHelperKt.PROCESS_BG_TASK, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: processAllAcrossBgAsync$lambda-3  reason: not valid java name */
    public static final void m19389processAllAcrossBgAsync$lambda3(FeedAcrossBgHelper this$0, boolean $needSave) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.processAllAcrossBgSync($needSave);
    }

    private final synchronized void processAllAcrossBgSync(boolean needSave) {
        JSONArray bgConfigArray = new JSONArray();
        for (Map.Entry entry : this.feedBgHolders.entrySet()) {
            String str = (String) entry.getKey();
            FeedAcrossBgHolder feedBgHolder = (FeedAcrossBgHolder) entry.getValue();
            feedBgHolder.processBg();
            bgConfigArray.put(feedBgHolder.toJsonObject());
        }
        if (needSave && bgConfigArray.length() > 0) {
            String jSONArray = bgConfigArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "bgConfigArray.toString()");
            saveBgConfig(jSONArray);
        }
    }

    private final void saveBgConfig(String config) {
        ExecutorUtilsExt.postOnElastic(new FeedAcrossBgHelper$$ExternalSyntheticLambda2(config), FeedAcrossBgHelperKt.SAVE_CONFIG_TASK, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: saveBgConfig$lambda-4  reason: not valid java name */
    public static final void m19390saveBgConfig$lambda4(String $config) {
        Intrinsics.checkNotNullParameter($config, "$config");
        FeedSimpleKVFilePersister.getPersister().putStringToFileAsync(FeedAcrossBgHelperKt.ACROSS_BG_FILE_NAME, $config);
    }

    private final void loadLocalConfigIfNeed() {
        if (this.isTryGetBg) {
            boolean backgroundPre = false;
            this.isTryGetBg = false;
            OnLineLog.get(OnLineLog.TAG_TABS).d("FeedAcrossBgHelper[AcrossBg]首次请求背景,尝试加载本地通栏背景配置");
            if (FeedAbtestManager.isBackgroundPreDownloadOpt() && FeedAbtestManager.isLowLevelPhone()) {
                backgroundPre = true;
            }
            if (!backgroundPre) {
                ExecutorUtilsExt.postOnElastic(new FeedAcrossBgHelper$$ExternalSyntheticLambda1(this), FeedAcrossBgHelperKt.LOAD_LOCAL_CONFIG_TASK, 2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadLocalConfigIfNeed$lambda-5  reason: not valid java name */
    public static final void m19388loadLocalConfigIfNeed$lambda5(FeedAcrossBgHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadAllConfig();
    }

    public final synchronized void loadAllConfig() {
        this.isTryGetBg = false;
        if (!this.isLoadedLocalConfig) {
            boolean z = true;
            this.isLoadedLocalConfig = true;
            OnLineLog.get(OnLineLog.TAG_TABS).d("FeedAcrossBgHelper[AcrossBg]开始真正加载本地通栏背景配置");
            String configString = FeedSimpleKVFilePersister.getPersister().getStringFromFileSync(FeedAcrossBgHelperKt.ACROSS_BG_FILE_NAME);
            CharSequence charSequence = configString;
            if (!(charSequence == null || charSequence.length() == 0)) {
                z = false;
            }
            if (!z) {
                try {
                    JSONArray configJson = new JSONArray(configString);
                    int length = configJson.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        String tabConfig = configJson.optString(i2);
                        Intrinsics.checkNotNullExpressionValue(tabConfig, "tabConfig");
                        parseBgHolderFromConfig(tabConfig);
                    }
                    processAllAcrossBg(false);
                } catch (JSONException e2) {
                }
            }
        }
    }

    private final void parseBgHolderFromConfig(String config) {
        FeedAcrossBgHolder bgHolder;
        try {
            JSONObject configJson = new JSONObject(config);
            String tabId = configJson.optString("tab_id");
            boolean needPreloadFeedBg = configJson.optBoolean(FeedAcrossBgHolderKt.KEY_PRELOAD_FEED_BG, true);
            String normalBgStr = configJson.optString("images", (String) null);
            String operateBgStr = configJson.optString(FeedAcrossBgHolderKt.KEY_OPERATE_BG, (String) null);
            if (NewHomeFun.INSTANCE.isNewHome()) {
                bgHolder = FeedAcrossBgHolderKt.toBgHolderForNewHome(tabId, normalBgStr, operateBgStr);
            } else {
                bgHolder = FeedAcrossBgHolderKt.toBgHolderObject(tabId, needPreloadFeedBg, normalBgStr, operateBgStr);
            }
            if (bgHolder != null) {
                FeedAcrossBgHolder it = bgHolder;
                if (it.isValid()) {
                    Intrinsics.checkNotNullExpressionValue(tabId, "tabId");
                    addFeedBgHolderIfNeed(tabId, it);
                }
            }
        } catch (JSONException e2) {
        }
    }

    private final synchronized void addFeedBgHolderIfNeed(String tabId, FeedAcrossBgHolder bgHolder) {
        if (!Intrinsics.areEqual((Object) bgHolder, (Object) this.feedBgHolders.get(tabId))) {
            OnLineLog.get(OnLineLog.TAG_TABS).d("FeedAcrossBgHelper[addBgHolder]添加通栏背景：" + tabId);
            this.feedBgHolders.put(tabId, bgHolder);
        } else {
            OnLineLog.get(OnLineLog.TAG_TABS).d("FeedAcrossBgHelper[addBgHolder]已存在该频道通栏背景：" + tabId);
        }
    }

    public final boolean isAcrossBgValid(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        return this.feedBgHolders.get(tabId) != null;
    }

    public final boolean isHeaderImgValid(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        FeedAcrossBgHolder bgHolder = this.feedBgHolders.get(tabId);
        if (bgHolder != null) {
            return bgHolder.isHeaderImgValid();
        }
        return false;
    }

    public final boolean canShowFeedAcrossBg(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        if (this.isOperateStatus && this.isCover) {
            return false;
        }
        FeedAcrossBgHolder feedAcrossBgHolder = this.feedBgHolders.get(tabId);
        return feedAcrossBgHolder != null && feedAcrossBgHolder.isBgReady(this.isOperateStatus);
    }

    public final Drawable getFeedBg(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        IAcrossBgProcessor bgProcessor = this.bgProcessorMap.get(tabId);
        if (bgProcessor != null) {
            return bgProcessor.onGetFeedBg();
        }
        FeedAcrossBgHolder bgHolder = this.feedBgHolders.get(tabId);
        if (bgHolder != null) {
            FeedAcrossBgHolder it = bgHolder;
            if (!this.isOperateStatus) {
                FeedAcrossBg normalBg = it.getNormalBg();
                if (normalBg != null) {
                    return normalBg.getFeedBgDrawable();
                }
                return null;
            } else if (this.isCover) {
                Drawable drawable = null;
                return null;
            } else {
                FeedAcrossBg operateBg = it.getOperateBg();
                if (operateBg != null) {
                    return operateBg.getFeedBgDrawable();
                }
                return null;
            }
        } else {
            loadLocalConfigIfNeed();
            return null;
        }
    }

    public final Drawable getHomeBg(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        IAcrossBgProcessor bgProcessor = this.bgProcessorMap.get(tabId);
        if (bgProcessor != null) {
            return bgProcessor.onGetHomeBg();
        }
        FeedAcrossBgHolder bgHolder = this.feedBgHolders.get(tabId);
        if (bgHolder != null) {
            FeedAcrossBgHolder it = bgHolder;
            if (!this.isOperateStatus) {
                FeedAcrossBg normalBg = it.getNormalBg();
                if (normalBg != null) {
                    return normalBg.getHomeBgDrawable();
                }
                return null;
            } else if (this.isCover) {
                Drawable drawable = null;
                return null;
            } else {
                FeedAcrossBg operateBg = it.getOperateBg();
                if (operateBg != null) {
                    return operateBg.getHomeBgDrawable();
                }
                return null;
            }
        } else {
            loadLocalConfigIfNeed();
            return null;
        }
    }

    public final HomeBackgroundSkinInfo getHomeColorBg(String tabId) {
        HomeBackgroundSkinInfo homeBackgroundSkinInfo;
        FeedAcrossBgHolder bgHolder = (FeedAcrossBgHolder) this.feedBgHolders.get(tabId);
        Drawable drawable = null;
        if (bgHolder == null) {
            return null;
        }
        FeedAcrossBgHolder it = bgHolder;
        if (this.isOperateStatus) {
            FeedAcrossBg operateBg = it.getOperateBg();
            if (operateBg != null) {
                drawable = operateBg.getHomeColorBgDrawable();
            }
            homeBackgroundSkinInfo = new HomeBackgroundSkinInfo(drawable);
        } else {
            FeedAcrossBg normalBg = it.getNormalBg();
            if (normalBg != null) {
                drawable = normalBg.getHomeColorBgDrawable();
            }
            homeBackgroundSkinInfo = new HomeBackgroundSkinInfo(drawable);
        }
        return homeBackgroundSkinInfo;
    }

    public final int getStretchBg(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        IAcrossBgProcessor bgProcessor = this.bgProcessorMap.get(tabId);
        if (bgProcessor != null) {
            return bgProcessor.onGetStretchBg();
        }
        int defaultColor = FeedRuntime.getAppContext().getResources().getColor(R.color.feed_transparent_color);
        if (getFeedBg(tabId) == null) {
            return defaultColor;
        }
        FeedAcrossBgHolder bgHolder = this.feedBgHolders.get(tabId);
        Integer bgColor = null;
        if (bgHolder != null) {
            FeedAcrossBgHolder it = bgHolder;
            if (!this.isOperateStatus) {
                FeedAcrossBg normalBg = it.getNormalBg();
                if (normalBg != null) {
                    bgColor = normalBg.getStretchColor();
                }
            } else if (this.isCover) {
                Integer num = null;
            } else {
                FeedAcrossBg operateBg = it.getOperateBg();
                if (operateBg != null) {
                    bgColor = operateBg.getStretchColor();
                }
            }
        }
        return bgColor != null ? bgColor.intValue() : defaultColor;
    }

    private final String getAcrossBgKey(String tabId, String type) {
        if (Intrinsics.areEqual((Object) FeedAcrossBgHelperKt.HOME_ACROSS_BG, (Object) type)) {
            return FeedAcrossBgHelperKt.HOME_ACROSS_BG + tabId;
        }
        return "feed_across_bg" + tabId;
    }

    public final String getAcrossBgPath(String tabId, String type) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(type, "type");
        return FeedPreferenceUtils.getQuickString(getAcrossBgKey(tabId, type), (String) null);
    }

    public final String getOperateStatus() {
        return this.isOperateStatus ? "1" : "0";
    }

    public final String getCover() {
        return this.isCover ? "1" : "0";
    }

    public final void addBgProcessor(String tabId, IAcrossBgProcessor bgProcessor) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(bgProcessor, "bgProcessor");
        this.bgProcessorMap.put(tabId, bgProcessor);
    }

    public final void removeBgProcessor(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        if (this.bgProcessorMap.containsKey(tabId)) {
            this.bgProcessorMap.remove(tabId);
        }
    }

    public final Unit clearBgImgIfNeed(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        FeedAcrossBgHolder feedAcrossBgHolder = this.feedBgHolders.get(tabId);
        if (feedAcrossBgHolder == null) {
            return null;
        }
        feedAcrossBgHolder.clearBgImgIfNeed();
        return Unit.INSTANCE;
    }

    public final String getHeaderImg(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        FeedAcrossBgHolder bgHolder = this.feedBgHolders.get(tabId);
        if (bgHolder == null) {
            return null;
        }
        FeedAcrossBgHolder it = bgHolder;
        if (this.isOperateStatus) {
            FeedAcrossBg operateBg = it.getOperateBg();
            if (operateBg != null) {
                return operateBg.getHeaderImgUrl();
            }
            return null;
        }
        FeedAcrossBg normalBg = it.getNormalBg();
        if (normalBg != null) {
            return normalBg.getHeaderImgUrl();
        }
        return null;
    }

    public final String getBannerLottie(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        FeedAcrossBgHolder it = this.feedBgHolders.get(tabId);
        if (it == null) {
            return null;
        }
        if (this.isOperateStatus) {
            FeedAcrossBg operateBg = it.getOperateBg();
            if (operateBg != null) {
                return operateBg.getBannerLottie();
            }
            return null;
        }
        FeedAcrossBg normalBg = it.getNormalBg();
        if (normalBg != null) {
            return normalBg.getBannerLottie();
        }
        return null;
    }

    public final String getHeaderNightImg(String tabId) {
        FeedAcrossBg normalBg;
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        FeedAcrossBgHolder bgHelper = this.feedBgHolders.get(tabId);
        if (bgHelper == null || (normalBg = bgHelper.getNormalBg()) == null) {
            return null;
        }
        return normalBg.getHeaderNightImg();
    }
}
