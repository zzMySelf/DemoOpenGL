package com.baidu.searchbox.sniffer;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.helios.common.internal.util.MD5Utils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.browserenhanceengine.container.ScreenShotLogStatistics;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.containers.nps.netdisk.face.INetdiskPluginFace;
import com.baidu.searchbox.containers.nps.netdisk.face.data.NetdiskRestFileInfo;
import com.baidu.searchbox.favor.sync.util.FavorUtil;
import com.baidu.searchbox.feed.tts.interfaces.IFeedTTSContext;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.searchbox.sniffer.model.FilmShieldModel;
import com.baidu.searchbox.sniffer.model.SnifferNetDiskBusinessType;
import com.baidu.searchbox.sniffer.service.ISnifferFun;
import com.baidu.searchbox.sniffer.service.ISnifferNetDiskManager;
import com.baidu.searchbox.sniffer.utils.SnifferDetectUtilsKt;
import com.baidu.searchbox.sniffer.utils.SnifferJsUtils;
import com.baidu.searchbox.sniffer.utils.SnifferSaveNetUtilsKt;
import com.baidu.searchbox.sniffer.utils.SnifferUtilsKt;
import com.baidu.swan.apps.model.SwanAppErrorPageParam;
import com.baidu.yun.model.NetdiskShieldModel;
import com.baidu.yun.service.IYunFun;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016JO\u0010\u0012\u001a\u00020\t2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162-\u0010\u0017\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t0\u0018H\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\tH\u0016J\u001a\u0010'\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0012\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010+\u001a\u00020\tH\u0016J\u001c\u0010,\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010-\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u00102\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\rH\u0002J\b\u00105\u001a\u00020\tH\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\u0010\u00107\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/baidu/searchbox/sniffer/SnifferFunManager;", "Lcom/baidu/searchbox/sniffer/service/ISnifferFun;", "()V", "DEBUG", "", "hasVideoSnifferResult", "mPreActivityWidth", "", "doUpdateVisitedHistory", "", "view", "Lcom/baidu/browser/sailor/BdSailorWebView;", "url", "", "isReload", "isSameDocument", "fromContentCache", "isBackForward", "getFilmShieldStatus", "filmShieldModelList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/sniffer/model/FilmShieldModel;", "Lkotlin/collections/ArrayList;", "onFilmStatusCb", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "value", "getSnifferJsFromFile", "getSnifferJsString", "getSnifferNetDiskManager", "Lcom/baidu/searchbox/sniffer/service/ISnifferNetDiskManager;", "businessType", "Lcom/baidu/searchbox/sniffer/model/SnifferNetDiskBusinessType;", "onConfigurationChanged", "config", "Landroid/content/res/Configuration;", "onDestroy", "onGoBackOrForwardAnimationFinish", "i", "onNotifyFileInfo", "snifferFileJsonString", "onNotifyVideoInfo", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPause", "currentPageUrl", "onResume", "removeFilterChar", "sourceName", "resetContainer", "snifferABSwitch", "snifferUrlSwitch", "transNetdiskRestFileToSnifferSource", "Lcom/baidu/searchbox/sniffer/SnifferSourceInfo;", "restFile", "Lcom/baidu/searchbox/containers/nps/netdisk/face/data/NetdiskRestFileInfo;", "currentUrl", "Companion", "lib-sniffer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnifferFunManager.kt */
public final class SnifferFunManager implements ISnifferFun {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "SnifferFunManager";
    private final boolean DEBUG = AppConfig.isDebug();
    private boolean hasVideoSnifferResult;
    private int mPreActivityWidth;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/sniffer/SnifferFunManager$Companion;", "", "()V", "TAG", "", "lib-sniffer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SnifferFunManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String getSnifferJsString() {
        if (this.DEBUG) {
            Log.d(TAG, "getSnifferJsString：" + SnifferJsUtils.INSTANCE.getCacheJS());
        }
        return SnifferJsUtils.INSTANCE.getCacheJS();
    }

    public String getSnifferJsFromFile() {
        String jsFromFile = SnifferJsUtils.INSTANCE.getJsFromFile();
        if (this.DEBUG) {
            Log.d(TAG, "getSnifferJsFromFile：" + jsFromFile);
        }
        return jsFromFile;
    }

    public boolean snifferABSwitch() {
        boolean z = AbTestManager.getInstance().getSwitch("basic_sniffer_file_switch", false);
        if (!this.DEBUG) {
            return z;
        }
        Log.d(TAG, "getSnifferABSwitch：" + z);
        return true;
    }

    public boolean snifferUrlSwitch(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.DEBUG) {
            Log.d(TAG, "getSnifferUrlSwitch");
        }
        try {
            String host = new URL(url).getHost();
            JSONArray shieldJsonArray = new JSONArray(PreferenceUtils.getString(SnifferHostShieldCommandListener.SNIFFER_HOST_SHIELD_LIST_SP_KEY, ""));
            if (this.DEBUG) {
                Log.d(TAG, "getSnifferUrlSwitch：" + shieldJsonArray);
            }
            int length = shieldJsonArray.length();
            for (int index = 0; index < length; index++) {
                String shieldHost = shieldJsonArray.optString(index);
                Intrinsics.checkNotNullExpressionValue(host, "host");
                Intrinsics.checkNotNullExpressionValue(shieldHost, "shieldHost");
                if (StringsKt.contains$default((CharSequence) host, (CharSequence) shieldHost, false, 2, (Object) null)) {
                    if (this.DEBUG) {
                        Log.d(TAG, "getSnifferUrlSwitch：" + host + "被屏蔽");
                    }
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            return true;
        }
    }

    public void onNotifyFileInfo(String snifferFileJsonString) {
        int type;
        String sourceName;
        String str = snifferFileJsonString;
        String str2 = "sourceExtension";
        String str3 = "sourceType";
        String str4 = IFeedTTSContext.KEY_SOURCE_URL;
        String str5 = "webTitle";
        String str6 = SwanAppErrorPageParam.KEY_SWAN_WEB_URL;
        if (!this.hasVideoSnifferResult) {
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                try {
                    SnifferData snifferData = new SnifferData();
                    JSONObject snifferSourceJson = new JSONObject(str);
                    int iframeCount = snifferSourceJson.optInt("iframeCount");
                    boolean sniffParent = snifferSourceJson.optBoolean("sniffParent");
                    String currentUrl = snifferSourceJson.optString(ScreenShotLogStatistics.KEY_CURURL);
                    String duration = snifferSourceJson.optString("sniffTime");
                    snifferData.setIframeCount(Integer.valueOf(iframeCount));
                    snifferData.setSniffParent(Boolean.valueOf(sniffParent));
                    snifferData.setCurrentUrl(currentUrl);
                    snifferData.setDuration(duration);
                    JSONArray dataJsonArray = snifferSourceJson.optJSONArray("data");
                    if (dataJsonArray != null) {
                        JSONObject jSONObject = snifferSourceJson;
                        int coerceAtMost = RangesKt.coerceAtMost(dataJsonArray.length(), 100);
                        int index = 0;
                        while (index < coerceAtMost) {
                            int i2 = coerceAtMost;
                            JSONObject dataJson = dataJsonArray.getJSONObject(index);
                            String webUrl = dataJson.optString(str6);
                            String webTitle = dataJson.optString(str5);
                            String sourceUrl = dataJson.optString(str4);
                            String sourceName2 = dataJson.optString("sourceName");
                            String sourceType = dataJson.optString(str3);
                            String sourceExtension = dataJson.optString(str2);
                            int iframeCount2 = iframeCount;
                            String panPwd = dataJson.optString("panPwd");
                            if (TextUtils.isEmpty(sourceName2)) {
                                JSONObject jSONObject2 = dataJson;
                                sourceName = webTitle;
                            } else {
                                JSONObject jSONObject3 = dataJson;
                                sourceName = sourceName2;
                            }
                            Intrinsics.checkNotNullExpressionValue(sourceName, "sourceName");
                            String sourceName3 = removeFilterChar(sourceName);
                            boolean sniffParent2 = sniffParent;
                            String webTitle2 = webTitle;
                            Intrinsics.checkNotNullExpressionValue(webTitle2, str5);
                            String str7 = str5;
                            String webUrl2 = webUrl;
                            Intrinsics.checkNotNullExpressionValue(webUrl2, str6);
                            Intrinsics.checkNotNullExpressionValue(sourceName3, "sourceName");
                            String str8 = str6;
                            String sourceUrl2 = sourceUrl;
                            Intrinsics.checkNotNullExpressionValue(sourceUrl2, str4);
                            String str9 = str4;
                            String sourceType2 = sourceType;
                            Intrinsics.checkNotNullExpressionValue(sourceType2, str3);
                            String str10 = str3;
                            String sourceExtension2 = sourceExtension;
                            Intrinsics.checkNotNullExpressionValue(sourceExtension2, str2);
                            String str11 = str2;
                            SnifferSourceInfo snifferSourceInfo = new SnifferSourceInfo(webTitle2, webUrl2, sourceName3, sourceUrl2, sourceType2, sourceExtension2);
                            snifferSourceInfo.setPanPwd(panPwd);
                            String str12 = sourceExtension2;
                            snifferData.getSnifferSourceList().add(snifferSourceInfo);
                            index++;
                            coerceAtMost = i2;
                            str2 = str11;
                            str6 = str8;
                            str5 = str7;
                            str4 = str9;
                            str3 = str10;
                            iframeCount = iframeCount2;
                            sniffParent = sniffParent2;
                        }
                        boolean z = sniffParent;
                        if (this.DEBUG) {
                            Log.d(TAG, "snifferFileJsonString:" + str);
                        }
                        if (snifferData.getSnifferSourceList().size() != 0) {
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : snifferData.getSnifferSourceList()) {
                                if (((SnifferSourceInfo) element$iv$iv).isMagnetOrSeedType$lib_sniffer_release()) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            List snifferMagnetSeedSources = (List) destination$iv$iv;
                            if (!snifferMagnetSeedSources.isEmpty()) {
                                snifferData.getSnifferSourceList().removeAll(snifferMagnetSeedSources);
                                Object service = ServiceManager.getService(INetdiskPluginFace.Companion.getSERVICE_REFERENCE());
                                INetdiskPluginFace netdiskFace = service instanceof INetdiskPluginFace ? (INetdiskPluginFace) service : null;
                                Activity context = BdBoxActivityManager.getRealTopActivity();
                                if (netdiskFace == null || context == null || !SnifferMagnetCommandListenerKt.isSnifferMagnetEnable()) {
                                } else if (!SnifferSaveNetUtilsKt.checkIsLogin()) {
                                    List list = snifferMagnetSeedSources;
                                } else {
                                    Iterable<SnifferSourceInfo> $this$map$iv = snifferMagnetSeedSources;
                                    int $i$f$map = false;
                                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    for (SnifferSourceInfo it : $this$map$iv) {
                                        List snifferMagnetSeedSources2 = snifferMagnetSeedSources;
                                        if (Intrinsics.areEqual((Object) it.getSourceType(), (Object) "magnet")) {
                                            type = 4;
                                        } else {
                                            type = 2;
                                        }
                                        destination$iv$iv2.add(new Pair(it.getSourceUrl(), Integer.valueOf(type)));
                                        String str13 = snifferFileJsonString;
                                        snifferMagnetSeedSources = snifferMagnetSeedSources2;
                                        $this$map$iv = $this$map$iv;
                                        $i$f$map = $i$f$map;
                                    }
                                    Iterable iterable = $this$map$iv;
                                    int i3 = $i$f$map;
                                    netdiskFace.queryMagnetSeedResInfo(context, (List) destination$iv$iv2, new SnifferFunManager$onNotifyFileInfo$1(snifferData, this, currentUrl), new SnifferFunManager$onNotifyFileInfo$2(snifferData));
                                    return;
                                }
                                if (snifferData.getSnifferSourceList().size() != 0) {
                                    SnifferDetectUtilsKt.onDetectSource(snifferData);
                                    return;
                                }
                                return;
                            }
                            SnifferDetectUtilsKt.onDetectSource(snifferData);
                        }
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final SnifferSourceInfo transNetdiskRestFileToSnifferSource(NetdiskRestFileInfo restFile, String currentUrl) {
        String sourceType;
        switch (restFile.getType()) {
            case 2:
                sourceType = SnifferSourceInfo.SOURCE_TYPE_SEED;
                break;
            case 4:
                sourceType = "magnet";
                break;
            default:
                return null;
        }
        String sourceExtension = SnifferUtilsKt.getFileSuffix(restFile.getFileName());
        if (sourceExtension.length() == 0) {
            return null;
        }
        String fileName = restFile.getFileName();
        String fileName2 = restFile.getFileName();
        String sourceUrl = restFile.getSourceUrl();
        if (sourceUrl == null) {
            sourceUrl = "";
        }
        SnifferSourceInfo $this$transNetdiskRestFileToSnifferSource_u24lambda_u2d2 = new SnifferSourceInfo(fileName, currentUrl, fileName2, sourceUrl, sourceType, sourceExtension);
        $this$transNetdiskRestFileToSnifferSource_u24lambda_u2d2.setFileSize(restFile.getSize());
        $this$transNetdiskRestFileToSnifferSource_u24lambda_u2d2.setNetdiskRestFileInfo(restFile);
        return $this$transNetdiskRestFileToSnifferSource_u24lambda_u2d2;
    }

    private final String removeFilterChar(String sourceName) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(sourceName, "/", "", false, 4, (Object) null), IStringUtil.WINDOWS_FOLDER_SEPARATOR, "", false, 4, (Object) null), GameCenterUtils.SCHEME_SWAN_SUFFIX, "", false, 4, (Object) null), "|", "", false, 4, (Object) null), "\"", "", false, 4, (Object) null), FavorUtil.FAVOR_SCOPE_MORE_THAN, "", false, 4, (Object) null), FavorUtil.FAVOR_SCOPE_LESS_THAN, "", false, 4, (Object) null), ":", "", false, 4, (Object) null), "*", "", false, 4, (Object) null), " ", "", false, 4, (Object) null);
    }

    public void onNotifyVideoInfo() {
        if (this.DEBUG) {
            Log.d(TAG, "onNotifyVideoInfo");
        }
        this.hasVideoSnifferResult = true;
    }

    public void onPageFinished(BdSailorWebView view2, String url) {
        if (this.DEBUG) {
            Log.d(TAG, "onPageFinished：" + url);
        }
        SnifferDetectUtilsKt.setCurrentUrl(url);
    }

    public void onPageStarted(BdSailorWebView view2, String url, Bitmap favicon) {
        if (this.DEBUG) {
            Log.d(TAG, "onPageStarted：" + url);
        }
        this.hasVideoSnifferResult = false;
        SnifferDetectUtilsKt.clearLastDetectPageUrl();
        SnifferDetectUtilsKt.resetFloatingBallPosition();
        SnifferDetectUtilsKt.setCurrentUrl(url);
    }

    public void onDestroy() {
        if (this.DEBUG) {
            Log.d(TAG, "onDestroy");
        }
        SnifferDetectUtilsKt.release();
        this.hasVideoSnifferResult = false;
    }

    public void onPause(String currentPageUrl) {
        if (this.DEBUG) {
            Log.d(TAG, "onPause:" + currentPageUrl);
        }
        SnifferDetectUtilsKt.dismissBallViewAndPanel();
    }

    public void onResume(String currentPageUrl) {
        if (this.DEBUG) {
            Log.d(TAG, "onResume:" + currentPageUrl);
        }
        SnifferDetectUtilsKt.updateFloatingBallVisible(currentPageUrl == null ? "" : currentPageUrl);
    }

    public void doUpdateVisitedHistory(BdSailorWebView view2, String url, boolean isReload, boolean isSameDocument, boolean fromContentCache, boolean isBackForward) {
        if (this.DEBUG) {
            Log.d(TAG, "doUpdateVisitedHistory:" + url);
        }
        CharSequence charSequence = url;
        if (!(charSequence == null || charSequence.length() == 0)) {
            SnifferDetectUtilsKt.setCurrentUrl(url);
            SnifferDetectUtilsKt.updateFloatingBallVisible(url);
        }
    }

    public void resetContainer() {
        if (this.DEBUG) {
            Log.d(TAG, "resetContainer");
        }
        SnifferDetectUtilsKt.release();
        this.hasVideoSnifferResult = false;
    }

    public void onGoBackOrForwardAnimationFinish(BdSailorWebView view2, int i2) {
        if (this.DEBUG) {
            Log.d(TAG, "onGoBackOrForwardAnimationFinish");
        }
        SnifferDetectUtilsKt.dismissSnifferPanel();
    }

    public void onConfigurationChanged(Configuration config) {
        int activityWidth = SnifferUtilsKt.getActivityWidth(BdBoxActivityManager.getRealTopActivity());
        if (activityWidth != this.mPreActivityWidth) {
            this.mPreActivityWidth = activityWidth;
            if (this.DEBUG) {
                Log.d(TAG, "屏幕宽度发生变化，横竖屏切换");
            }
            SnifferDetectUtilsKt.resetFloatingBallPosition();
            SnifferDetectUtilsKt.dismissSnifferPanel();
        }
    }

    public ISnifferNetDiskManager getSnifferNetDiskManager(SnifferNetDiskBusinessType businessType) {
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        return SnifferNetDiskManager.Companion.getSnifferNetDiskManager(businessType);
    }

    public void getFilmShieldStatus(ArrayList<FilmShieldModel> filmShieldModelList, Function1<? super Map<String, FilmShieldModel>, Unit> onFilmStatusCb) {
        Intrinsics.checkNotNullParameter(filmShieldModelList, "filmShieldModelList");
        Intrinsics.checkNotNullParameter(onFilmStatusCb, "onFilmStatusCb");
        if (filmShieldModelList.isEmpty()) {
            UiThreadUtils.runOnUiThread(new SnifferFunManager$$ExternalSyntheticLambda0(onFilmStatusCb));
        }
        ArrayList netDiskShieldModelList = new ArrayList();
        for (FilmShieldModel filmShieldModel : filmShieldModelList) {
            NetdiskShieldModel netDiskShieldModel = new NetdiskShieldModel();
            NetdiskShieldModel $this$getFilmShieldStatus_u24lambda_u2d5_u24lambda_u2d4 = netDiskShieldModel;
            try {
                String url = filmShieldModel.getUrl();
                $this$getFilmShieldStatus_u24lambda_u2d5_u24lambda_u2d4.key = MD5Utils.toMd5(url != null ? StringsKt.encodeToByteArray(url) : null, false);
                String str = $this$getFilmShieldStatus_u24lambda_u2d5_u24lambda_u2d4.key;
                Intrinsics.checkNotNullExpressionValue(str, "key");
                filmShieldModel.setKey(str);
                $this$getFilmShieldStatus_u24lambda_u2d5_u24lambda_u2d4.title = filmShieldModel.getTitle();
                $this$getFilmShieldStatus_u24lambda_u2d5_u24lambda_u2d4.url = filmShieldModel.getUrl();
                $this$getFilmShieldStatus_u24lambda_u2d5_u24lambda_u2d4.domain = new URL(filmShieldModel.getWebUrl()).getHost();
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
            netDiskShieldModelList.add(netDiskShieldModel);
        }
        Object service = ServiceManager.getService(IYunFun.SERVICE_REFERENCE);
        Intrinsics.checkNotNullExpressionValue(service, "getService(IYunFun.SERVICE_REFERENCE)");
        IYunFun yunFun = (IYunFun) service;
        yunFun.requestNetDiskShieldService("1", netDiskShieldModelList, new SnifferFunManager$getFilmShieldStatus$3(onFilmStatusCb, filmShieldModelList, yunFun));
    }

    /* access modifiers changed from: private */
    /* renamed from: getFilmShieldStatus$lambda-3  reason: not valid java name */
    public static final void m3265getFilmShieldStatus$lambda3(Function1 $onFilmStatusCb) {
        Intrinsics.checkNotNullParameter($onFilmStatusCb, "$onFilmStatusCb");
        $onFilmStatusCb.invoke(MapsKt.emptyMap());
    }
}
