package com.baidu.nadcore.download.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.nadcore.download.basic.AdH5DownloadManager;
import com.baidu.nadcore.download.cache.AdDownloadCache;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.consts.DownloadCons;
import com.baidu.nadcore.download.model.AdDownloadBean;
import com.baidu.nadcore.download.utils.AdDownloadUtil;
import com.baidu.nadcore.download.view.DefaultDownloadViewLP;
import com.baidu.nadcore.download.view.DownloadViewFactory;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AppInfoModel;
import com.baidu.nadcore.safe.JSONUtils;
import com.baidu.nadcore.safe.MapUtils;
import com.baidu.nadcore.utils.LruCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class LPDownloadManager {
    private static final String TAG = "LPDownloadManager";
    private static final List<String> WITHE_LIST = new ArrayList<String>() {
        {
            add("https://cover.baidu.com");
            add("http://cover.baidu.com");
        }
    };
    private static LruCache<String, AdDownloadPresenterLP> mCache;
    private static Map<String, Integer> sLpUriMainColorCache;

    public static void prepare(Context context, RelativeLayout container, String params) {
        startDownload(context, container, params, false);
    }

    public static void cacheLpMainColor(String key, int color) {
        if (sLpUriMainColorCache == null) {
            sLpUriMainColorCache = new HashMap();
        }
        sLpUriMainColorCache.put(key, Integer.valueOf(color));
    }

    public static boolean startDownload(Context context, RelativeLayout container, String params, boolean next) {
        if (context == null || container == null || TextUtils.isEmpty(params)) {
            return false;
        }
        AdDownloadBean data = createData(params);
        if (data.invalid()) {
            return false;
        }
        JSONObject paramObj = JSONUtils.newJSONObject(params);
        String orgLpUrl = paramObj.optString(AdH5DownloadManager.LP_URL, "");
        int lpCheckMode = paramObj.optInt(DownloadCons.KEY_LP_CHECK_MODE, 0);
        AdDownloadPresenterLP presenter = (AdDownloadPresenterLP) MapUtils.get(mCache, data.getKey());
        if (presenter != null) {
            if (next && data.status != AdDownloadStatus.DOWNLOADING && presenter.isInDownloadWhiteList()) {
                presenter.run();
            }
            if (presenter.needCreateView()) {
                IAdDownloadView<?> downloadViewLP = DownloadViewFactory.getDownloadView(container, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
                Map<String, Integer> map = sLpUriMainColorCache;
                if (map != null && (downloadViewLP instanceof DefaultDownloadViewLP)) {
                    Integer bgColor = map.get(orgLpUrl);
                    ((DefaultDownloadViewLP) downloadViewLP).setAbsorbColor(bgColor != null ? bgColor.intValue() : -1);
                }
                presenter.setAdDownloadView(downloadViewLP);
                if (!presenter.isInDownloadWhiteList()) {
                    if (lpCheckMode == 1) {
                        presenter.showCheckView(container, presenter.getAdLpCheckerData(), context);
                    } else if (context instanceof Activity) {
                        presenter.showCheckDialog(container, presenter.getAdLpCheckerData(), (Activity) context);
                    }
                }
            }
            return true;
        } else if (AdDownloadUtil.canDirectDownload(params, orgLpUrl)) {
            AdDownloadPresenterLP presenter2 = createPresenter(container, data, orgLpUrl);
            presenter2.setInDownloadWhiteList(true);
            presenter2.run();
            return true;
        } else {
            remoteCheck(context, container, orgLpUrl, data, lpCheckMode);
            return true;
        }
    }

    private static AdDownloadBean createData(String params) {
        JSONObject obj = JSONUtils.newJSONObject(params);
        String key = obj.optString("key", "");
        String key2 = TextUtils.isEmpty(key) ? obj.optString(AdH5DownloadManager.LP_URL, "") : key;
        AdDownloadBean data = AdDownloadCache.instance().query(key2);
        if (data != null) {
            return data;
        }
        AdDownloadBean data2 = new AdDownloadBean();
        data2.downloadUrl = obj.optString("url", "");
        data2.setKey(key2);
        data2.ct.page = obj.optString("da_page", "");
        data2.ct.actionArea = obj.optString("da_area", "");
        data2.ct.business = obj.optString("business");
        data2.ct.contentType = obj.optString("content_type");
        data2.ct.contentLength = obj.optLong("content_length");
        data2.ct.closeVDownload = obj.optInt("close_v_dl");
        data2.mt.alsExt = obj.optString("log_ext");
        data2.mt.adId = obj.optString("ad_id");
        data2.mt.appIconUrl = obj.optString("app_icon");
        data2.mt.appName = obj.optString("app_name");
        return data2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void remoteCheck(android.content.Context r9, android.widget.RelativeLayout r10, java.lang.String r11, com.baidu.nadcore.download.model.AdDownloadBean r12, int r13) {
        /*
            java.util.List<java.lang.String> r0 = WITHE_LIST
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = r12.downloadUrl
            boolean r2 = r2.startsWith(r1)
            if (r2 != 0) goto L_0x0022
            boolean r2 = r11.startsWith(r1)
            if (r2 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            goto L_0x0006
        L_0x0022:
            com.baidu.nadcore.download.presenter.AdDownloadPresenterLP r0 = createPresenter(r10, r12, r11)
            r2 = 1
            r0.setInDownloadWhiteList(r2)
            r0.run()
            return
        L_0x002e:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            com.baidu.nadcore.download.model.AdDownloadMt r1 = r12.mt
            java.lang.String r1 = r1.alsExt
            java.lang.String r2 = "ext"
            r0.put(r2, r1)
            java.lang.String r1 = "charge_url"
            r0.put(r1, r11)
            java.lang.String r1 = r12.downloadUrl
            java.lang.String r2 = "apk_url"
            r0.put(r2, r1)
            com.baidu.nadcore.download.model.AdLpCheckRequest r1 = new com.baidu.nadcore.download.model.AdLpCheckRequest
            r1.<init>()
            com.baidu.nadcore.download.presenter.LPDownloadManager$2 r8 = new com.baidu.nadcore.download.presenter.LPDownloadManager$2
            r2 = r8
            r3 = r10
            r4 = r12
            r5 = r11
            r6 = r13
            r7 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            r1.perform(r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.download.presenter.LPDownloadManager.remoteCheck(android.content.Context, android.widget.RelativeLayout, java.lang.String, com.baidu.nadcore.download.model.AdDownloadBean, int):void");
    }

    /* access modifiers changed from: private */
    public static void updateBean(AdDownloadBean localData, AppInfoModel remoteData) {
        localData.downloadUrl = remoteData.apkUrl;
        localData.mt.appIconUrl = remoteData.appIcon;
        localData.mt.appName = remoteData.appName;
    }

    /* access modifiers changed from: private */
    public static AdDownloadPresenterLP createPresenter(RelativeLayout container, AdDownloadBean data, String orgLpUrl) {
        IAdDownloadView<?> downloadViewLP = DownloadViewFactory.getDownloadView(container, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
        Map<String, Integer> map = sLpUriMainColorCache;
        if (map != null && (downloadViewLP instanceof DefaultDownloadViewLP)) {
            Integer bgColor = map.get(orgLpUrl);
            ((DefaultDownloadViewLP) downloadViewLP).setAbsorbColor(bgColor != null ? bgColor.intValue() : -1);
        }
        AdDownloadPresenterLP presenter = new AdDownloadPresenterLP(data, downloadViewLP);
        if (mCache == null) {
            mCache = new LruCache<>(32);
        }
        MapUtils.put(mCache, data.getKey(), presenter);
        return presenter;
    }
}
