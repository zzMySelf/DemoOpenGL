package com.baidu.swan.apps.impl.feedback;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.agent.activity.MegPluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.adaptation.interfaces.ISwanAppFeedback;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.R;
import com.baidu.swan.apps.impl.account.AccountUtils;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.menu.SwanAppMenuHelper;
import com.baidu.swan.apps.performance.data.SwanLaunchIdCache;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.storage.StorageUtil;
import com.baidu.swan.apps.swancore.SwanAppSwanCoreManager;
import com.baidu.swan.apps.toast.UniversalToast;
import com.baidu.swan.apps.util.SwanAppImageUtils;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.card.page.SwanCardPage;
import com.baidu.swan.device.info.ioc.SwanDeviceInfo;
import com.baidu.swan.utils.SwanAppFileUtils;
import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppFeedbackHelper implements IFeedbackConstants {
    private static final int COMPRESS_QUALITY = 5;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String EASY_BROWSE = "baiduboxapp://v1/easybrowse/open?url=";
    private static final String FEEDBACK_BASE_URL = "https://ufosdk.baidu.com/?m=Client&a=applet&appid=234193&channelid=33821&entrance=swan";
    private static final String PARAM_APPLET_NAME = "appletName";
    private static final String PARAM_APPVN = "appvn";
    private static final String PARAM_BASIC_VERSION = "basicJsVer";
    private static final String PARAM_CUID = "baiducuid";
    private static final String PARAM_ENTRY = "entry";
    private static final String PARAM_ERROR_DES = "errorDes";
    private static final String PARAM_EXTRASTRING = "extrastring";
    private static final String PARAM_LAUNCH_ID = "launchid";
    private static final String PARAM_LOGO = "logo";
    private static final String PARAM_NID = "nid";
    private static final String PARAM_OSVN = "osvn";
    private static final String PARAM_PHONE_MODEL = "model";
    private static final String PARAM_PICTURE_PATH = "imagePath";
    private static final String PARAM_SID = "sid";
    private static final String PATH_SWAN = "swan";
    private static final String SCREENSHOT_NAME = "easybrowse_feedback_screenshot";
    private static final String TAG = "SwanAppFeedbackHelper";
    private static final String VALUE_BASIC_JS_VER_KNOWN = "unknown";

    public static void handleFeedback(SwanApp swanApp, String url) {
        SwanAppRuntime.getSwanAppLogSystem().flush(false);
        Activity activity = Swan.get().getActivity();
        String imagePath = saveAndGetScreenshotLocalPath(activity);
        String entryUriString = getCommonEntryUri(swanApp.getAppId()).appendEncodedPath(url).build().toString();
        doFeedback(activity, buildFeedbackUri(activity, swanApp.getName(), swanApp.getAppId(), SwanAppUtils.getCurSwanAppPageParam().getPage(), imagePath, entryUriString).appendQueryParameter("logo", swanApp.getInfo().getIconUrl()).appendQueryParameter("extrastring", getExtraStringJson((String) null)).build());
    }

    public static void handleFeedback(SwanCard swanCard, String url) {
        String page;
        SwanAppRuntime.getSwanAppLogSystem().flush(false);
        Activity activity = swanCard.getActivity();
        String imagePath = saveAndGetScreenshotLocalPath(activity);
        String entryUriString = getCommonEntryUri(swanCard.getAppId()).appendEncodedPath(url).build().toString();
        SwanCardPage cardPage = SwanCardManager.get().getCurCardPage(swanCard.getCardId());
        if (cardPage != null) {
            page = cardPage.getCurSwanAppPageParams().getPage();
        } else {
            page = "";
        }
        doFeedback(activity, buildFeedbackUri(activity, swanCard.getInfo().getAppTitle(), swanCard.getAppId(), page, imagePath, entryUriString).appendQueryParameter("logo", swanCard.getInfo().getIconUrl()).appendQueryParameter("extrastring", getExtraStringJson((String) null)).build());
    }

    public static void handleFeedback(Context context, String appId, String appName, String errorPath, String errorDes) {
        SwanAppRuntime.getSwanAppLogSystem().flush(false);
        if (context != null) {
            doFeedback(context, buildFeedbackUri(context, appName, appId, errorPath, saveAndGetScreenshotLocalPath(context), buildEntryUriString(appId)).appendQueryParameter("extrastring", getExtraStringJson(errorDes)).build());
        }
    }

    public static String getExtraStringJson(String errorDes) {
        try {
            JSONObject res = new JSONObject();
            if (!TextUtils.isEmpty(errorDes)) {
                res.put(PARAM_ERROR_DES, errorDes);
            }
            res.put("sid", SwanAppRuntime.getSwanAppAbTestRuntime().getAllAbTest());
            res.put("launchid", SwanLaunchIdCache.getLaunchId());
            return res.toString();
        } catch (JSONException e2) {
            return errorDes;
        }
    }

    private static String saveAndGetScreenshotLocalPath(Context context) {
        String imagePath = getScreenshotLocalPath();
        if (context instanceof Activity) {
            saveScreenShotToLocalPath((Activity) context, imagePath);
        }
        if (DEBUG) {
            Log.d(TAG, "screenshot path: " + imagePath);
        }
        return imagePath;
    }

    private static Uri.Builder buildFeedbackUri(Context context, String appName, String appId, String errorPath, String imagePath, String entryStr) {
        return Uri.parse(FEEDBACK_BASE_URL).buildUpon().appendQueryParameter("baiducuid", SwanAppRuntime.getSwanAppAccountRuntime().getDeviceIdentity(context)).appendQueryParameter("osvn", SwanDeviceInfo.INSTANCE.getVersionRelease()).appendQueryParameter("appvn", SwanAppUtils.getPackageVersion(context, AppRuntime.getAppContext().getPackageName())).appendQueryParameter("model", SwanDeviceInfo.INSTANCE.getModel()).appendQueryParameter(PARAM_APPLET_NAME, appName).appendQueryParameter("nid", appId + "|" + errorPath).appendQueryParameter("entry", entryStr).appendQueryParameter("imagePath", imagePath).appendQueryParameter(PARAM_BASIC_VERSION, obtainBasicJsVersion());
    }

    private static void doFeedback(Context context, Uri feedbackUri) {
        String scheme = "baiduboxapp://v1/easybrowse/open?url=" + Uri.encode(feedbackUri.toString()) + "&newbrowser=1";
        SwanAppLog.logToFile(TAG, "#doFeedback uriStr=" + scheme);
        SchemeRouter.invoke(context, scheme);
    }

    private static String buildEntryUriString(String appkey) {
        if (appkey != null) {
            return getCommonEntryUri(appkey).build().toString();
        }
        SwanApp swanApp = SwanApp.getOrNull();
        return swanApp != null ? swanApp.getInfo().getLaunchScheme() : "";
    }

    private static Uri.Builder getCommonEntryUri(String path) {
        return new Uri.Builder().scheme(SchemeConfig.getSchemeHead()).authority("swan").appendPath(path);
    }

    private static void saveScreenShotToLocalPath(String imagePath) {
        Bitmap screenshot = SwanAppUIUtils.getFullScreenshot();
        if (SwanAppFileUtils.isExistFile(imagePath)) {
            SwanAppFileUtils.deleteFile(imagePath);
        }
        SwanAppImageUtils.saveBitmap(screenshot, imagePath, 5, Bitmap.CompressFormat.JPEG);
    }

    private static void saveScreenShotToLocalPath(Activity activity, String imagePath) {
        Bitmap screenshot = SwanAppUIUtils.getFullScreenshot(activity);
        if (SwanAppFileUtils.isExistFile(imagePath)) {
            SwanAppFileUtils.deleteFile(imagePath);
        }
        SwanAppImageUtils.saveBitmap(screenshot, imagePath, 5, Bitmap.CompressFormat.JPEG);
    }

    private static String getScreenshotLocalPath() {
        StringBuilder path = new StringBuilder();
        String tempDirectory = SwanAppController.getInstance().getSwanFilePaths().getTmpDirectory();
        if (TextUtils.isEmpty(tempDirectory)) {
            tempDirectory = StorageUtil.getSwanAppTmpDirectory("ScreenshotTempDirectory");
        }
        path.append(tempDirectory).append(File.separator).append(SCREENSHOT_NAME);
        return path.toString();
    }

    public static void feedback() {
        if (DEBUG) {
            Log.d(TAG, "MENU_ITEM_FEEDBACK");
        }
        feedback(new Bundle(), new ISwanAppFeedback.OnFeedbackResultCallback() {
            public void onResult(final String data) {
                SwanAppUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(data) && TextUtils.equals(new JSONObject(data).optString("result"), "success")) {
                                UniversalToast.makeText((Context) SwanAppRuntime.getAppContext(), R.string.swan_app_report_tips).setDuration(2).showToast();
                            }
                        } catch (JSONException e2) {
                            if (SwanAppFeedbackHelper.DEBUG) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }

    private static void feedback(Bundle params, final ISwanAppFeedback.OnFeedbackResultCallback callback) {
        if (Swan.get().hasAppOccupied()) {
            Bundle feedbackParams = new Bundle();
            if (params != null && params.size() > 0) {
                feedbackParams.putAll(params);
            }
            TreeSet<String> set = new TreeSet<>();
            set.add("BoxAccount_uid");
            set.add("BoxAccount_displayname");
            Map<String, String> map = AccountUtils.getSessions((Context) Swan.get().getActivity(), (Set<String>) set);
            feedbackParams.putString("BoxAccount_uid", map.get("BoxAccount_uid"));
            feedbackParams.putString("BoxAccount_displayname", map.get("BoxAccount_displayname"));
            feedbackParams.putString(FeedbackDelegation.BUNDLE_KEY_APP_ID, SwanApp.getSwanAppId() + "|" + SwanAppUtils.getCurSwanAppPageParam().getPage());
            if (ProcessUtils.isMainProcess()) {
                FeedbackDelegation.feedbackDirectly(Swan.get().getActivity(), feedbackParams, new TypedCallback<Bundle>() {
                    public void onCallback(Bundle msg) {
                        ISwanAppFeedback.OnFeedbackResultCallback onFeedbackResultCallback = ISwanAppFeedback.OnFeedbackResultCallback.this;
                        if (onFeedbackResultCallback != null) {
                            onFeedbackResultCallback.onResult(msg.getString(FeedbackDelegation.RESULT_KEY));
                        }
                    }
                });
            } else {
                DelegateUtils.callOnMainWithActivity(Swan.get().getActivity(), MegPluginDelegateActivity.class, FeedbackDelegation.class, feedbackParams, new DelegateListener() {
                    public void onDelegateCallBack(DelegateResult result) {
                        if (SwanAppFeedbackHelper.DEBUG) {
                            Log.d(SwanAppFeedbackHelper.TAG, "onDelegateCallBack");
                        }
                        ISwanAppFeedback.OnFeedbackResultCallback onFeedbackResultCallback = ISwanAppFeedback.OnFeedbackResultCallback.this;
                        if (onFeedbackResultCallback != null) {
                            onFeedbackResultCallback.onResult(result.mResult.getString(FeedbackDelegation.RESULT_KEY));
                        }
                    }
                });
            }
            SwanAppMenuHelper.doUBCEventStatistic("feedback", (String) null);
        }
    }

    private static String obtainBasicJsVersion() {
        SwanAppLaunchInfo.Impl launchInfo = Swan.get().getApp().getInfo();
        if (launchInfo != null) {
            return SwanAppSwanCoreManager.getSwanCoreVersionName(launchInfo.getSwanCoreVersion(), launchInfo.getAppFrameType());
        }
        return "unknown";
    }
}
