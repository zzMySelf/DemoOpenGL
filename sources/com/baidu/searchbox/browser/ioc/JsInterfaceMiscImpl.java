package com.baidu.searchbox.browser.ioc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.media.ImageUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.webapps.WebAppsCommandDispatchActivity;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.userinfo.AccountUserInfoManager;
import com.baidu.searchbox.browser.UtilsJavaScriptInterface;
import com.baidu.searchbox.browser.utils.CommonJsInterfaceUtils;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feedback.FeedbackInfoManager;
import com.baidu.searchbox.imsdk.ImSdkManager;
import com.baidu.searchbox.ng.browser.util.NgWebViewUtils;
import com.baidu.searchbox.scheme.GetCurrentLocationImpl;
import com.baidu.searchbox.search.pyramid.SearchWebAppInterface;
import com.baidu.searchbox.story.DownloadStoryReceiver;
import com.baidu.voice.pyramid.VoicePanelInterface;
import com.baidu.voice.vscb.IVoiceSearchCallback;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class JsInterfaceMiscImpl implements IJsInterfaceMisc {
    private static final String KEY_DOWNLOAD_FROM = "key_download_from";
    private static final String KEY_RANDOM = "key_random";

    public String getDownLoadKeyFrom() {
        return KEY_DOWNLOAD_FROM;
    }

    public String getDownLoadKeyRandom() {
        return KEY_RANDOM;
    }

    public long getDownLoadKeyRandomValue() {
        return DownloadStoryReceiver.UNI_RANDOM_VALUE;
    }

    public void startVoice(Context mActivity, String params, UtilsJavaScriptInterface utilsJs, String callBack) {
        VoicePanelInterface voicePanelInterface = (VoicePanelInterface) ServiceManager.getService(VoicePanelInterface.SERVICE_REFERENCE);
        if (voicePanelInterface != null) {
            voicePanelInterface.startThirdEntryVoiceSearch(mActivity, params, new VoiceThirdPartSearchCallBack(utilsJs, callBack));
        }
    }

    private static class VoiceThirdPartSearchCallBack implements IVoiceSearchCallback.IThirdPartSearchCallBack {
        private String mCallback;
        private WeakReference<UtilsJavaScriptInterface> mJsInterface;

        public VoiceThirdPartSearchCallBack(UtilsJavaScriptInterface jsInterface, String callback) {
            this.mJsInterface = new WeakReference<>(jsInterface);
            this.mCallback = callback;
        }

        public boolean executeThirdSearch(Context context, List<String> list, String s) {
            UtilsJavaScriptInterface javaScriptInterface = (UtilsJavaScriptInterface) this.mJsInterface.get();
            if (javaScriptInterface == null) {
                return true;
            }
            javaScriptInterface.postLoadJavaScript(this.mCallback, s);
            return true;
        }
    }

    public void feedback(final Context mActivity, final BdSailorWebView mWebView, final String options) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NgWebViewUtils.getSafeContext(mWebView) instanceof Activity) {
                    String from = "1";
                    boolean toMyFeed = false;
                    if (!TextUtils.isEmpty(options)) {
                        try {
                            JSONObject jobject = new JSONObject(options);
                            if (jobject.has("source")) {
                                String source = (String) jobject.get("source");
                                if (TextUtils.equals(source, FeedbackInfoManager.FEEDBACK_OPTIONS_IMG_SEARCH)) {
                                    from = "3";
                                } else if (TextUtils.equals(source, "card")) {
                                    from = "1";
                                } else if (TextUtils.equals(source, "news")) {
                                    from = "5";
                                } else {
                                    from = source;
                                }
                            }
                            if (jobject.has("tab")) {
                                toMyFeed = TextUtils.equals((String) jobject.get("tab"), FeedbackInfoManager.FEEDBACK_TAB_VALUE);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (!toMyFeed) {
                        FeedbackInfoManager.startToFeedbackFaqIntent((Context) null, from, (String) null, "", (JSONObject) null);
                    } else if (mWebView != null) {
                        final String innerFrom = from;
                        UiThreadUtil.runOnUiThread(new Runnable() {
                            public void run() {
                                Window window;
                                View view2;
                                Bitmap screenShot = null;
                                if (!(mActivity == null || !(mActivity instanceof Activity) || (window = ((Activity) mActivity).getWindow()) == null || (view2 = window.findViewById(16908290)) == null)) {
                                    screenShot = ImageUtils.captureViewSnapshot(view2);
                                }
                                FeedbackInfoManager.startToFeedbackFaqIntentWithScreenShot((Context) null, innerFrom, screenShot, "", (JSONObject) null);
                            }
                        });
                    } else {
                        FeedbackInfoManager.startToFeedbackFaqIntent((Context) null, from, "", "", (JSONObject) null);
                    }
                }
            }
        });
    }

    public boolean handleWebAppsCommandInvoke(Context context, String command) {
        SearchWebAppInterface searchWebApp = (SearchWebAppInterface) ServiceManager.getService(SearchWebAppInterface.SERVICE_REFERENCE);
        if (searchWebApp == null || !searchWebApp.isWebAppsSearchActivity(context)) {
            return false;
        }
        Intent intent = CommandUtils.parseCommand(context, command, 1);
        Intent dispatchIntent = new Intent(context.getApplicationContext(), WebAppsCommandDispatchActivity.class);
        dispatchIntent.putExtra(WebAppsCommandDispatchActivity.KEY_INTENT, intent);
        intent.addFlags(268435456);
        ActivityUtils.startActivitySafely(context, dispatchIntent);
        return true;
    }

    public void subscribePa(final JSONObject resultJson, final UtilsJavaScriptInterface.JsCallback callBack, long paId, Context context) {
        ImSdkManager.ISearchBoxSubscribePaListener listener = new ImSdkManager.ISearchBoxSubscribePaListener() {
            public void onSubsribePaResult(int errno, long paId) {
                if (errno == 0) {
                    try {
                        resultJson.put("st", CommonJsInterfaceUtils.getSiteStatusFollowed());
                        callBack.setResult(true);
                        resultJson.put("puid", CommonJsInterfaceUtils.getAccountUid());
                    } catch (JSONException e2) {
                        callBack.setResult(false);
                    }
                } else {
                    callBack.setResult(false);
                }
                callBack.notifyResult();
            }
        };
        final long finalPaId = paId;
        if (((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin()) {
            ImSdkManager.getInstance(context).subscribePaAsync(paId, listener);
            return;
        }
        final ImSdkManager.ISearchBoxSubscribePaListener iSearchBoxSubscribePaListener = listener;
        final UtilsJavaScriptInterface.JsCallback jsCallback = callBack;
        ImSdkManager.getInstance(AppRuntime.getAppContext()).login(new ImSdkManager.ISearchBoxLoginListener() {
            public void onLoginResult(int resultCode) {
                if (resultCode == 0) {
                    ImSdkManager.getInstance(AppRuntime.getAppContext()).subscribePaAsync(finalPaId, iSearchBoxSubscribePaListener);
                    return;
                }
                jsCallback.setResult(false);
                jsCallback.notifyResult();
            }
        });
    }

    public void getCurrentLocation(BdSailorWebView mWebView, Context mActivity, String options, String callback) {
        if (mWebView != null) {
            GetCurrentLocationImpl.INSTANCE.getCurrentLocation(mWebView, mActivity, options, callback);
        }
    }

    public Intent getUserInfoIntent(String uid, String uk, String iconUrl, String relation, String remarkName, String userName, String sign, String src, String ext) {
        return AccountUserInfoManager.getUserInfoIntent((String) null, uk, iconUrl, relation, remarkName, userName, sign, src, ext);
    }
}
