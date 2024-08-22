package com.baidu.searchbox.search.shortcut;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.browser.R;
import com.baidu.browser.utils.FrescoImageLoadUtil;
import com.baidu.browser.utils.ImageLoadListener;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ng.browser.explore.model.VisitedSite;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.ubc.UBC;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import org.json.JSONObject;

public class SearchShortcutUtils {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final String INTENT_DUPLICATE_KEY = "duplicate";
    public static final String SEARCH_ADD_TO_LAUNCHER_SP_KEY = "search_result_add_to_launcher";
    private static final String SEARCH_FRAME_OPEN_LOGARGS = "%26needlog%3d1%26logargs%3d%7b%22source%22%3a%221021254v%22%2c%22from%22%3a%22openbox%22%2c%22page%22%3a%22shortcut%22%2c%22type%22%3a%22%22%2c%22value%22%3a%22show%22%2c%22channel%22%3a%22%22%7d";
    private static final String SEARCH_FRAME_OPEN_QUERY_PREFIX = "baiduboxapp://v1/browser/search?upgrade=1&query=";
    private static final String SEARCH_FRAME_OPEN_SUFFIX = "&simple=0&newwindow=0&append=1";
    private static final String SEARCH_FRAME_OPEN_URL_PREFIX = "baiduboxapp://v1/browser/open?upgrade=1&url=";
    private static final long SEARCH_SCHEME_SHORTCUT_TASK_DELAY_MILLIS = 2000;
    protected static final long SEARCH_SHORTCUT_ADD_BROADCAST_UNREGISTER_TIME = 15000;
    protected static final String SEARCH_SHORTCUT_ADD_ID = "search_shortcut_add_id";
    protected static final String SEARCH_SHORTCUT_ADD_SUCCESS_ACTION = "search_shortcut_add_success_action";
    private static final int SEARCH_SHORTCUT_IMAGE_SIZE = 144;
    protected static final String TAG = "SearchShortcutUtils";

    public interface OnAddShortcutIntentListener {
        void onAddShortcutIntentResult(boolean z);
    }

    private interface OnAddShortcutListener {
        void onAddShortcutResult(boolean z);

        void onShowAddShortcutGuide(boolean z);
    }

    private enum SearchShortcutMode {
        SEARCH_QUERY,
        NON_SEARCH_QUERY
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean addSearchResultShortcut(android.content.Context r8, com.baidu.searchbox.ng.browser.explore.model.VisitedSite r9, java.lang.String r10, boolean r11, final com.baidu.searchbox.search.shortcut.SearchShortcutUtils.OnAddShortcutIntentListener r12) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r11 != 0) goto L_0x0018
            if (r9 == 0) goto L_0x0018
            android.graphics.Bitmap r1 = r9.getIcon()
            r2 = r1
            if (r1 == 0) goto L_0x0018
            boolean r1 = r2.isRecycled()
            if (r1 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = r2
            goto L_0x0022
        L_0x0018:
            int r1 = com.baidu.browser.R.drawable.search_add_launcher_icon
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r8, r1)
            android.graphics.Bitmap r1 = com.baidu.android.util.bitmap.BitmapUtils.fromDrawable(r1)
        L_0x0022:
            r2 = 0
            r3 = 0
            boolean r4 = android.text.TextUtils.isEmpty(r10)
            if (r4 == 0) goto L_0x0039
            if (r9 != 0) goto L_0x002d
            return r0
        L_0x002d:
            com.baidu.searchbox.search.shortcut.SearchShortcutUtils$SearchShortcutMode r4 = com.baidu.searchbox.search.shortcut.SearchShortcutUtils.SearchShortcutMode.NON_SEARCH_QUERY
            java.lang.String r2 = buildSearchShortcutTitle(r8, r4, r10, r9)
            com.baidu.searchbox.search.shortcut.SearchShortcutUtils$SearchShortcutMode r4 = com.baidu.searchbox.search.shortcut.SearchShortcutUtils.SearchShortcutMode.NON_SEARCH_QUERY
            android.content.Intent r3 = buildSearchShortcutIntent(r4, r10, r9)
        L_0x0039:
            boolean r4 = android.text.TextUtils.isEmpty(r10)
            if (r4 != 0) goto L_0x0068
            boolean r4 = com.baidu.android.common.others.url.UrlUtil.isUrl(r10)
            if (r4 != 0) goto L_0x0059
            boolean r4 = com.baidu.android.common.others.url.UrlUtil.isUrlAuxiliary(r10)
            if (r4 == 0) goto L_0x004c
            goto L_0x0059
        L_0x004c:
            com.baidu.searchbox.search.shortcut.SearchShortcutUtils$SearchShortcutMode r4 = com.baidu.searchbox.search.shortcut.SearchShortcutUtils.SearchShortcutMode.SEARCH_QUERY
            java.lang.String r2 = buildSearchShortcutTitle(r8, r4, r10, r9)
            com.baidu.searchbox.search.shortcut.SearchShortcutUtils$SearchShortcutMode r4 = com.baidu.searchbox.search.shortcut.SearchShortcutUtils.SearchShortcutMode.SEARCH_QUERY
            android.content.Intent r3 = buildSearchShortcutIntent(r4, r10, r9)
            goto L_0x0068
        L_0x0059:
            if (r9 != 0) goto L_0x005c
            return r0
        L_0x005c:
            com.baidu.searchbox.search.shortcut.SearchShortcutUtils$SearchShortcutMode r4 = com.baidu.searchbox.search.shortcut.SearchShortcutUtils.SearchShortcutMode.NON_SEARCH_QUERY
            java.lang.String r2 = buildSearchShortcutTitle(r8, r4, r10, r9)
            com.baidu.searchbox.search.shortcut.SearchShortcutUtils$SearchShortcutMode r4 = com.baidu.searchbox.search.shortcut.SearchShortcutUtils.SearchShortcutMode.NON_SEARCH_QUERY
            android.content.Intent r3 = buildSearchShortcutIntent(r4, r10, r9)
        L_0x0068:
            if (r3 != 0) goto L_0x006b
            return r0
        L_0x006b:
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto L_0x0072
            return r0
        L_0x0072:
            com.baidu.searchbox.search.shortcut.SearchShortCutHelper r0 = com.baidu.searchbox.search.shortcut.SearchShortCutHelper.INSTANCE
            r4 = 0
            r0.setCachedBitmap(r4)
            java.lang.String r0 = getDefaultTitle(r8)
            boolean r0 = android.text.TextUtils.equals(r2, r0)
            if (r0 == 0) goto L_0x008b
            android.net.Uri r0 = r3.getData()
            java.lang.String r0 = r0.toString()
            goto L_0x008c
        L_0x008b:
            r0 = r2
        L_0x008c:
            com.baidu.searchbox.search.shortcut.SearchShortcutData r4 = new com.baidu.searchbox.search.shortcut.SearchShortcutData
            r4.<init>(r0, r2, r3)
            com.baidu.searchbox.search.shortcut.SearchShortcutUtils$1 r5 = new com.baidu.searchbox.search.shortcut.SearchShortcutUtils$1
            r5.<init>()
            r6 = 0
            addShortcut(r4, r1, r5, r6)
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.shortcut.SearchShortcutUtils.addSearchResultShortcut(android.content.Context, com.baidu.searchbox.ng.browser.explore.model.VisitedSite, java.lang.String, boolean, com.baidu.searchbox.search.shortcut.SearchShortcutUtils$OnAddShortcutIntentListener):boolean");
    }

    public static boolean addSchemeShortcut(String scheme, String title, String icon, final OnAddShortcutIntentListener listener) {
        Context context;
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        Intent intent = null;
        try {
            intent = Intent.parseUri(scheme, 1);
        } catch (URISyntaxException e2) {
            if (AppConfig.isDebug()) {
                Log.e(TAG, "Intent.parseUri URISyntaxException ", e2);
            }
        }
        if (intent == null || (context = AppRuntime.getAppContext()) == null) {
            return false;
        }
        Bitmap iconBitmap = null;
        SearchShortCutHelper.INSTANCE.setCachedBitmap((Bitmap) null);
        if (UrlUtils.isUrl(icon) && (iconBitmap = FrescoImageLoadUtil.INSTANCE.getBitmapMemoryCache(icon, 144, 144)) == null) {
            FrescoImageLoadUtil.INSTANCE.loadBitmap(icon, 144, 144, new ImageLoadListener() {
                public void onSuccess(Bitmap bitmap) {
                    SearchShortCutHelper.INSTANCE.setCachedBitmap(bitmap);
                    SearchShortcutData shortcut = SearchShortCutHelper.INSTANCE.getCachedShortcutData();
                    if (!bitmap.isRecycled() && shortcut != null) {
                        SearchShortcutUtils.modifyShortcut(shortcut, bitmap);
                        SearchShortCutHelper.INSTANCE.setCachedShortcutData((SearchShortcutData) null);
                    }
                }

                public void onFail() {
                }
            });
        }
        String title2 = buildSearchShortcutTitle(context, SearchShortcutMode.SEARCH_QUERY, title, (VisitedSite) null);
        if (TextUtils.isEmpty(title2)) {
            return false;
        }
        long delayMillis = 0;
        if (iconBitmap == null) {
            delayMillis = 2000;
        }
        addShortcut(new SearchShortcutData(scheme, title2, intent), iconBitmap, new OnAddShortcutListener() {
            public void onShowAddShortcutGuide(boolean isAddSuccess) {
                SearchShortcutUtils.showSearchShortcutGuide(Boolean.valueOf(isAddSuccess));
                Bitmap bitmap = SearchShortCutHelper.INSTANCE.getCachedBitmap();
                SearchShortcutData shortcut = SearchShortCutHelper.INSTANCE.getCachedShortcutData();
                if (isAddSuccess && bitmap != null && !bitmap.isRecycled() && shortcut != null) {
                    SearchShortcutUtils.modifyShortcut(shortcut, bitmap);
                    SearchShortCutHelper.INSTANCE.setCachedShortcutData((SearchShortcutData) null);
                }
            }

            public void onAddShortcutResult(boolean isAddSuccess) {
                OnAddShortcutIntentListener onAddShortcutIntentListener = OnAddShortcutIntentListener.this;
                if (onAddShortcutIntentListener != null) {
                    onAddShortcutIntentListener.onAddShortcutIntentResult(isAddSuccess);
                }
            }
        }, delayMillis);
        return true;
    }

    private static String getDefaultTitle(Context context) {
        return context.getResources().getString(R.string.search_result_shortcut_default_title);
    }

    public static void executeSearchAddLauncherUbcStatistics(String page, String value) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("from", "tool");
            jsonObject.put("source", "1021254v");
            jsonObject.put("page", page);
            jsonObject.put("value", value);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
                Log.d(TAG, TAG + e2.toString());
            }
        }
        UBC.onEvent("669", jsonObject.toString());
        if (DEBUG) {
            Log.d(TAG, "SearchShortcutUtils UBC.onEvent(): " + jsonObject.toString());
        }
    }

    private static String buildSearchShortcutTitle(Context context, SearchShortcutMode mode, String currentQuery, VisitedSite visitedSite) {
        String shortcutTitle = null;
        String shortcutTitleSuffix = context.getResources().getString(R.string.search_result_shortcut_suffix);
        switch (AnonymousClass4.$SwitchMap$com$baidu$searchbox$search$shortcut$SearchShortcutUtils$SearchShortcutMode[mode.ordinal()]) {
            case 1:
                shortcutTitle = currentQuery;
                break;
            case 2:
                shortcutTitle = visitedSite != null ? visitedSite.getTitle() : null;
                break;
        }
        if (TextUtils.isEmpty(shortcutTitle)) {
            shortcutTitle = getDefaultTitle(context);
        }
        return shortcutTitle + shortcutTitleSuffix;
    }

    /* renamed from: com.baidu.searchbox.search.shortcut.SearchShortcutUtils$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$search$shortcut$SearchShortcutUtils$SearchShortcutMode;

        static {
            int[] iArr = new int[SearchShortcutMode.values().length];
            $SwitchMap$com$baidu$searchbox$search$shortcut$SearchShortcutUtils$SearchShortcutMode = iArr;
            try {
                iArr[SearchShortcutMode.SEARCH_QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$search$shortcut$SearchShortcutUtils$SearchShortcutMode[SearchShortcutMode.NON_SEARCH_QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static Intent buildSearchShortcutIntent(SearchShortcutMode mode, String currentQuery, VisitedSite visitedSite) {
        String intentStrPrefix = null;
        String intentStrSuffix = "&simple=0&newwindow=0&append=1" + SEARCH_FRAME_OPEN_LOGARGS;
        switch (AnonymousClass4.$SwitchMap$com$baidu$searchbox$search$shortcut$SearchShortcutUtils$SearchShortcutMode[mode.ordinal()]) {
            case 1:
                intentStrPrefix = SEARCH_FRAME_OPEN_QUERY_PREFIX + currentQuery;
                break;
            case 2:
                intentStrPrefix = "baiduboxapp://v1/browser/open?upgrade=1&url=" + URLEncoder.encode(visitedSite.getUrl());
                break;
        }
        try {
            return Intent.parseUri(intentStrPrefix + intentStrSuffix, 1);
        } catch (URISyntaxException e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            Log.d(TAG, "SearchShortcutUtils Intent.parseUri URISyntaxException " + e2.toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void showSearchShortcutGuide(Boolean isSuccess) {
        Context context = AppRuntime.getAppContext();
        Intent intent = new Intent(context, SearchShortcutGuideActivity.class);
        intent.addFlags(268435456);
        if (!isSuccess.booleanValue()) {
            intent.putExtra(SearchShortcutGuideActivity.EXTRA_ADD_SHORTCUT_RESULT, false);
        }
        ActivityUtils.startActivitySafely(context, intent);
    }

    private static void addShortcut(SearchShortcutData shortcut, Bitmap icon, OnAddShortcutListener listener, long delayMillis) {
        ExecutorUtilsExt.delayPostOnElastic(new SearchShortcutUtils$$ExternalSyntheticLambda1(icon, shortcut, listener), SEARCH_ADD_TO_LAUNCHER_SP_KEY, 1, delayMillis);
    }

    static /* synthetic */ void lambda$addShortcut$1(Bitmap icon, SearchShortcutData shortcut, OnAddShortcutListener listener) {
        Bitmap iconBitmap;
        boolean result;
        if (icon == null || icon.isRecycled()) {
            iconBitmap = SearchShortCutHelper.INSTANCE.getCachedBitmap();
            SearchShortCutHelper.INSTANCE.setCachedBitmap((Bitmap) null);
        } else {
            iconBitmap = icon;
        }
        if (iconBitmap == null || iconBitmap.isRecycled()) {
            iconBitmap = BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.search_add_launcher_icon);
        }
        SearchShortCutHelper.INSTANCE.activeBroadCastReceiver(shortcut.getId(), new SearchShortcutUtils$$ExternalSyntheticLambda0(shortcut, listener));
        try {
            result = requestPinShortcut(shortcut, iconBitmap);
        } catch (Exception e2) {
            result = false;
        }
        if (!result) {
            SearchShortCutHelper.INSTANCE.unregisterBroadCastReceiver();
            SearchShortCutHelper.INSTANCE.recycleCachedBitmap();
            if (listener != null) {
                listener.onShowAddShortcutGuide(false);
            }
        }
        if (listener != null) {
            listener.onAddShortcutResult(result);
        }
        executeSearchAddLauncherUbcStatistics(result ? "success" : "fail", "show");
    }

    static /* synthetic */ Unit lambda$addShortcut$0(SearchShortcutData shortcut, OnAddShortcutListener listener) {
        SearchShortCutHelper.INSTANCE.setCachedShortcutData(shortcut);
        SearchShortCutHelper.INSTANCE.unregisterBroadCastReceiver();
        if (listener == null) {
            return null;
        }
        listener.onShowAddShortcutGuide(true);
        return null;
    }

    private static boolean requestPinShortcut(SearchShortcutData shortcutData, Bitmap icon) throws IllegalArgumentException, IllegalStateException {
        Context appContext;
        int requestCode = 0;
        if (icon == null || icon.isRecycled() || (appContext = AppRuntime.getAppContext()) == null) {
            return false;
        }
        ShortcutInfoCompat pinShortcutInfo = new ShortcutInfoCompat.Builder(appContext, shortcutData.getId()).setShortLabel(shortcutData.getLabel()).setLongLabel(shortcutData.getLabel()).setIcon(IconCompat.createWithBitmap(icon)).setIntent(shortcutData.getIntent()).build();
        Intent broadcastIntent = ShortcutManagerCompat.createShortcutResultIntent(appContext, pinShortcutInfo);
        broadcastIntent.setAction(SEARCH_SHORTCUT_ADD_SUCCESS_ACTION);
        broadcastIntent.putExtra(SEARCH_SHORTCUT_ADD_ID, shortcutData.getId());
        if (Build.VERSION.SDK_INT >= 31) {
            requestCode = shortcutData.getId().hashCode();
        }
        boolean result = ShortcutManagerCompat.requestPinShortcut(appContext, pinShortcutInfo, PendingIntent.getBroadcast(appContext, requestCode, broadcastIntent, Build.VERSION.SDK_INT >= 31 ? 67108864 : SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION).getIntentSender());
        if (AppConfig.isDebug()) {
            Log.d(TAG, "requestPinShortcut: id" + shortcutData.getId() + " result=" + result);
        }
        return result;
    }

    /* access modifiers changed from: private */
    public static void modifyShortcut(SearchShortcutData shortcutData, Bitmap icon) {
        ExecutorUtilsExt.postOnElastic(new SearchShortcutUtils$$ExternalSyntheticLambda2(shortcutData, icon), SEARCH_ADD_TO_LAUNCHER_SP_KEY, 1);
    }

    static /* synthetic */ void lambda$modifyShortcut$2(SearchShortcutData shortcutData, Bitmap icon) {
        try {
            updatePinShortcut(shortcutData, icon);
        } catch (Exception e2) {
        }
    }

    private static void updatePinShortcut(SearchShortcutData shortcutData, Bitmap icon) throws IllegalArgumentException {
        if (icon != null && !icon.isRecycled()) {
            Context appContext = AppRuntime.getAppContext();
            ShortcutInfoCompat pinShortcutInfo = new ShortcutInfoCompat.Builder(appContext, shortcutData.getId()).setShortLabel(shortcutData.getLabel()).setLongLabel(shortcutData.getLabel()).setIcon(IconCompat.createWithBitmap(icon)).setIntent(shortcutData.getIntent()).build();
            List<ShortcutInfoCompat> shortcutInfoCompatList = new ArrayList<>();
            shortcutInfoCompatList.add(pinShortcutInfo);
            boolean result = ShortcutManagerCompat.updateShortcuts(appContext, shortcutInfoCompatList);
            if (AppConfig.isDebug()) {
                Log.d(TAG, "updateShortcuts: id=" + shortcutData.getId() + " result=" + result);
            }
        }
    }
}
