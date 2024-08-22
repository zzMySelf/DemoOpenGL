package com.baidu.searchbox.plugins.helper;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.chatsearch.aisearch.scheme.UnitedSchemeChatSearchDispatcher;
import com.baidu.nps.main.download.IDownloadCallback;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.plugin.IDownloadAuthorGetter;
import com.baidu.nps.plugin.IDownloadAuthorListener;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.push.MessageUtils;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.sociality.star.plugin.ImChatInvokeListener;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.sumeru.implugin.invoke.IChatInvokeCallback;
import com.baidu.sumeru.implugin.invoke.IChatInvokeListener;
import com.baidu.sumeru.implugin.invoke.IChatPluginInvoker;
import com.baidu.swan.apps.media.chooser.helper.SwanAppChooseConstant;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class IMPluginHelper {
    private static final int ADVISORY_CHAT_TYPE = 10;
    private static final String ADVISORY_SCHEME_HEADER = "baiduboxapp://advisory/enterServePage?params=";
    public static final int CALLBACK_RESULT_FAILED = -1;
    public static final int CALLBACK_RESULT_SUCCESS = 0;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    public static final int IS_BUSSINESS_ACCOUNT = 1;
    public static final String PACKAGE_NAME = "com.baidu.sumeru.implugin";
    private static final String PLUGIN_IMPL_CLASS_NAME = "com.baidu.sumeru.implugin.PluginInvoker";
    private static final String TAG = "IMPluginHelper";
    /* access modifiers changed from: private */
    public static IChatPluginInvoker mIMPluginInvoker;

    public interface Callback {
        void onResult(int i2);
    }

    public interface IInitCallback {
        void onResult(IChatPluginInvoker iChatPluginInvoker);
    }

    private IMPluginHelper() {
    }

    public static void invoke(String appId, Callback callback) {
        invoke(appId, "", 1, callback, "");
    }

    public static void invoke(String appId, String nickname, int msgtype, Callback callback, String ext) {
        invoke(appId, nickname, msgtype, callback, (IChatInvokeListener[]) null, ext);
    }

    public static void invoke(String appId, String nickname, int msgtype, Callback callback) {
        invoke(appId, nickname, msgtype, callback, (IChatInvokeListener[]) null, "");
    }

    public static void invoke(String appId, String nickname, int msgtype, Callback callback, IChatInvokeListener[] listeners, String ext) {
        if (!TextUtils.isEmpty(appId)) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("uid", appId);
                jsonObject.put("nickname", nickname);
                jsonObject.put("msgtype", msgtype);
                jsonObject.put("ext", ext);
                jsonObject.put(SwanAppChooseConstant.KEY_INVOKE_API_SOURCE, "2");
                if (MessageUtils.isBusinessAccount()) {
                    jsonObject.put("invokeRole", 1);
                }
            } catch (JSONException e2) {
                if (MessageRuntime.GLOBAL_DEBUG) {
                    e2.printStackTrace();
                }
            }
            startChatPlugin(jsonObject.toString(), callback, listeners);
        } else if (callback != null) {
            callback.onResult(-1);
        }
    }

    public static void invokeBySwan(Context activity, String appId, String nickname, int msgtype, String ext, Callback callback, ImChatInvokeListener[] listeners) {
        if (!TextUtils.isEmpty(appId)) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("uid", appId);
                jsonObject.put("nickname", nickname);
                jsonObject.put("msgtype", msgtype);
                jsonObject.put("ext", ext);
                jsonObject.put(SwanAppChooseConstant.KEY_INVOKE_API_SOURCE, "8");
                if (MessageUtils.isBusinessAccount()) {
                    jsonObject.put("invokeRole", 1);
                }
            } catch (JSONException e2) {
                if (MessageRuntime.GLOBAL_DEBUG) {
                    e2.printStackTrace();
                }
            }
            startChatPlugin(jsonObject.toString(), callback, listeners);
        } else if (callback != null) {
            callback.onResult(-1);
        }
    }

    public static void invokeChat(String appId, String nickname, int msgtype, String invokeSource, Callback callback) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("uid", appId);
            jsonObject.put("nickname", nickname);
            jsonObject.put("msgtype", msgtype);
            jsonObject.put(SwanAppChooseConstant.KEY_INVOKE_API_SOURCE, invokeSource);
            if (MessageUtils.isBusinessAccount()) {
                jsonObject.put("invokeRole", 1);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        startChatPlugin(jsonObject.toString(), callback, (IChatInvokeListener[]) null);
    }

    public static void invokeChat(String appId, String nickname, int msgtype, String invokeSource, Callback callback, String ext) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("uid", appId);
            jsonObject.put("nickname", nickname);
            jsonObject.put("msgtype", msgtype);
            jsonObject.put(SwanAppChooseConstant.KEY_INVOKE_API_SOURCE, invokeSource);
            jsonObject.put("ext", ext);
            if (MessageUtils.isBusinessAccount()) {
                jsonObject.put("invokeRole", 1);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        startChatPlugin(jsonObject.toString(), callback, (IChatInvokeListener[]) null);
    }

    public static void invokeAdvisoryChat(String uid, String nickname, int msgtype, String invokeSource, Callback callback, String ext) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("uid", uid);
            jsonObject.put("nickname", nickname);
            jsonObject.put("msgtype", msgtype);
            jsonObject.put(SwanAppChooseConstant.KEY_INVOKE_API_SOURCE, invokeSource);
            jsonObject.put("ext", ext);
            if (MessageUtils.isBusinessAccount()) {
                jsonObject.put("invokeRole", 1);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        advisoryInvoke(getAdvisoryScheme(jsonObject));
    }

    private static String getAdvisoryScheme(JSONObject extParams) {
        JSONObject paramJson = new JSONObject();
        try {
            paramJson.put("serveType", 10);
            paramJson.put(UnitedSchemeChatSearchDispatcher.PARAM_KEY_EXTPARAMS, extParams);
            return ADVISORY_SCHEME_HEADER + URLEncoder.encode(paramJson.toString(), "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static void advisoryInvoke(String scheme) {
        if (!TextUtils.isEmpty(scheme)) {
            BaseRouter.invokeScheme(MessageRuntime.getAppContext(), Uri.parse(scheme), "inside");
        }
    }

    public static void invokeChatBySwan(Context context, String appId, String nickname, int msgtype, String invokeSource, String ext, Callback callback) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("uid", appId);
            jsonObject.put("nickname", nickname);
            jsonObject.put("msgtype", msgtype);
            jsonObject.put(SwanAppChooseConstant.KEY_INVOKE_API_SOURCE, invokeSource);
            jsonObject.put("ext", ext);
            if (MessageUtils.isBusinessAccount()) {
                jsonObject.put("invokeRole", 1);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        startChatPlugin(jsonObject.toString(), callback, (IChatInvokeListener[]) null);
    }

    public static void invokeGameChat(String appId, String nickname, int msgtype, String invokeSource, Callback callback) {
        invokeGameChat(appId, nickname, msgtype, invokeSource, callback, (IChatInvokeListener[]) null);
    }

    public static void invokeGameChat(String appId, String nickname, int msgtype, String invokeSource, Callback callback, IChatInvokeListener[] listeners) {
        if (!TextUtils.isEmpty(appId)) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("uid", appId);
                jsonObject.put("nickname", nickname);
                jsonObject.put("msgtype", msgtype);
                jsonObject.put("isFromGame", true);
                jsonObject.put(SwanAppChooseConstant.KEY_INVOKE_API_SOURCE, invokeSource);
                jsonObject.put("isBattleHomeExist", false);
                JSONObject ext = new JSONObject();
                ext.put("source", "");
                jsonObject.put("ext", ext.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            startChatPlugin(jsonObject.toString(), callback, listeners);
        } else if (callback != null) {
            callback.onResult(-1);
        }
    }

    public static void installIMPluginForSilent(final IInitCallback callback) {
        IChatPluginInvoker iChatPluginInvoker = mIMPluginInvoker;
        if (iChatPluginInvoker == null) {
            int status = NPSPackageManager.getInstance().getBundleStatus("com.baidu.sumeru.implugin");
            if (status == 43) {
                if (DEBUG) {
                    Log.d(TAG, "im plugin installBundle is ready !!!!");
                }
                prepareImPlugin(callback, false);
            } else if (status == 44) {
                NPSPackageManager.getInstance().installBundle("com.baidu.sumeru.implugin", new IInstallCallback() {
                    public void onResult(int code, String s) {
                        if (code == 13) {
                            if (IMPluginHelper.DEBUG) {
                                Log.d(IMPluginHelper.TAG, "im plugin installBundle is success !!!!code:" + code + " result:" + s);
                            }
                            IMPluginHelper.prepareImPlugin(IInitCallback.this, false);
                        } else if (IMPluginHelper.DEBUG) {
                            Log.d(IMPluginHelper.TAG, "im plugin installBundle is fail code:" + code + " result:" + s);
                        }
                    }

                    public void onProgress(long l, long l1) {
                    }
                });
            } else {
                callback.onResult((IChatPluginInvoker) null);
            }
        } else if (callback != null) {
            callback.onResult(iChatPluginInvoker);
        }
    }

    private static void initIMPlugin(final IInitCallback callback) {
        IChatPluginInvoker iChatPluginInvoker = mIMPluginInvoker;
        if (iChatPluginInvoker == null) {
            int status = NPSPackageManager.getInstance().getBundleStatus("com.baidu.sumeru.implugin");
            if (status == 43) {
                prepareImPlugin(callback, true);
            } else if (status == 44) {
                cancelFailToast();
                NPSPackageManager.getInstance().installBundle("com.baidu.sumeru.implugin", 4, new IInstallCallback() {
                    public void onResult(int code, String s) {
                        if (code == 13) {
                            IMPluginHelper.prepareImPlugin(IInitCallback.this, true);
                        } else {
                            IMPluginHelper.toastPluginInstallError();
                        }
                    }

                    public void onProgress(long l, long l1) {
                    }
                }, BdBoxActivityManager.getTopActivity());
            } else {
                callback.onResult((IChatPluginInvoker) null);
            }
        } else if (callback != null) {
            callback.onResult(iChatPluginInvoker);
        }
    }

    /* access modifiers changed from: private */
    public static void toastPluginInstallError() {
        UiThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                UniversalToast.makeText(MessageRuntime.getAppContext(), R.string.bd_im_plugin_install_failed).show();
            }
        });
    }

    private static void cancelFailToast() {
        UniversalToast.cancelToast();
    }

    /* access modifiers changed from: private */
    public static void prepareImPlugin(final IInitCallback callback, final boolean isShowToast) {
        NPSManager.getInstance().loadClazz("com.baidu.sumeru.implugin", PLUGIN_IMPL_CLASS_NAME, IChatPluginInvoker.class, new IInvokeCallback() {
            public void onResult(int i2, String s, Object o) {
                if (i2 != 14) {
                    if (isShowToast) {
                        IMPluginHelper.toastPluginInstallError();
                    }
                    IInitCallback iInitCallback = callback;
                    if (iInitCallback != null) {
                        iInitCallback.onResult(IMPluginHelper.mIMPluginInvoker);
                        return;
                    }
                    return;
                }
                try {
                    IChatPluginInvoker unused = IMPluginHelper.mIMPluginInvoker = (IChatPluginInvoker) ((Class) o).newInstance();
                    IInitCallback iInitCallback2 = callback;
                    if (iInitCallback2 != null) {
                        iInitCallback2.onResult(IMPluginHelper.mIMPluginInvoker);
                    }
                } catch (Exception e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                    if (isShowToast) {
                        IMPluginHelper.toastPluginInstallError();
                    }
                    IInitCallback iInitCallback3 = callback;
                    if (iInitCallback3 != null) {
                        iInitCallback3.onResult((IChatPluginInvoker) null);
                    }
                }
                IMPluginHelper.downloadUpdatePackage();
            }
        });
    }

    /* access modifiers changed from: private */
    public static void downloadUpdatePackage() {
        NPSPackageManager.getInstance().downloadUpdatePackage("com.baidu.sumeru.implugin", new IDownloadCallback() {
            public void onResult(int i2, String s) {
            }

            public void onProgress(long l, long l1) {
            }
        }, new IDownloadAuthorGetter() {
            public void checkAuthorization(IBundleInfo iBundleInfo, int i2, IDownloadAuthorListener iDownloadAuthorListener) {
                if (iDownloadAuthorListener != null) {
                    iDownloadAuthorListener.onResult(1);
                }
            }
        }, 1);
    }

    public static void invokePaSetting(String paId) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("paid", paId);
            jsonObject.put(SwanAppChooseConstant.KEY_INVOKE_API_SOURCE, "2");
            if (MessageUtils.isBusinessAccount()) {
                jsonObject.put("invokeRole", 1);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        startPaSetting(jsonObject.toString(), new Callback() {
            public void onResult(int statusCode) {
                LogUtils.e(IMPluginHelper.TAG, "invokePaSetting onResult statusCode = " + statusCode);
            }
        });
    }

    public static void startPaSetting(final String params, final Callback callback) {
        if (TextUtils.isEmpty(params)) {
            if (callback != null) {
                callback.onResult(-1);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "startPaSetting failed, params is empty!");
                return;
            }
            return;
        }
        initIMPlugin(new IInitCallback() {
            public void onResult(IChatPluginInvoker instance) {
                if (instance != null) {
                    instance.openPaSettingActivity(MessageRuntime.getAppContext(), params, new IChatInvokeCallback() {
                        public void onResult(int i2, String s) {
                            if (callback != null) {
                                if (i2 == 0) {
                                    callback.onResult(0);
                                } else {
                                    callback.onResult(-1);
                                }
                            }
                            if (AppConfig.isDebug()) {
                                Log.d(IMPluginHelper.TAG, "startPaSetting onResult, status = 0, result = " + s);
                            }
                        }
                    });
                    return;
                }
                Callback callback = callback;
                if (callback != null) {
                    callback.onResult(-1);
                    if (AppConfig.isDebug()) {
                        Log.d(IMPluginHelper.TAG, "startPaSetting failed, plugin is not ready!");
                    }
                }
            }
        });
    }

    public static void startShieldSetting(final String params, final Callback callback) {
        if (TextUtils.isEmpty(params)) {
            if (callback != null) {
                callback.onResult(-1);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "startPaSetting failed, params is empty!");
                return;
            }
            return;
        }
        initIMPlugin(new IInitCallback() {
            public void onResult(IChatPluginInvoker instance) {
                if (instance != null) {
                    instance.openShieldSettingActivity(MessageRuntime.getAppContext(), params, new IChatInvokeCallback() {
                        public void onResult(int i2, String s) {
                            if (callback != null) {
                                if (i2 == 0) {
                                    callback.onResult(0);
                                } else {
                                    callback.onResult(-1);
                                }
                            }
                            if (AppConfig.isDebug()) {
                                Log.d(IMPluginHelper.TAG, "startShieldSetting onResult, status = 0, result = " + s);
                            }
                        }
                    });
                    return;
                }
                Callback callback = callback;
                if (callback != null) {
                    callback.onResult(-1);
                    if (AppConfig.isDebug()) {
                        Log.d(IMPluginHelper.TAG, "startShieldSetting failed, plugin is not ready!");
                    }
                }
            }
        });
    }

    public static void startChatPlugin(final String params, final Callback callback, final IChatInvokeListener[] listeners) {
        if (TextUtils.isEmpty(params)) {
            if (callback != null) {
                callback.onResult(-1);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "startChatPlugin failed, params is empty!");
                return;
            }
            return;
        }
        initIMPlugin(new IInitCallback() {
            public void onResult(IChatPluginInvoker instance) {
                if (instance != null) {
                    instance.openChatPlugin(MessageRuntime.getAppContext(), params, new IChatInvokeCallback() {
                        public void onResult(int i2, String s) {
                            if (callback != null) {
                                if (i2 == 0) {
                                    callback.onResult(0);
                                } else {
                                    callback.onResult(-1);
                                }
                            }
                            if (AppConfig.isDebug()) {
                                Log.d(IMPluginHelper.TAG, "startChatPlugin onResult, status = 0, result = " + s);
                            }
                        }
                    }, listeners);
                    return;
                }
                Callback callback = callback;
                if (callback != null) {
                    callback.onResult(-1);
                    if (AppConfig.isDebug()) {
                        Log.d(IMPluginHelper.TAG, "startChatPlugin failed, plugin is not ready!");
                    }
                }
            }
        });
    }

    public static void invokeChatBySource(String jumpSource, long id, String nickname, int type, String ext) {
        if (TextUtils.equals(jumpSource, "8")) {
            invokeBySwan((Context) null, String.valueOf(id), nickname, type, ext, new Callback() {
                public void onResult(int statusCode) {
                }
            }, (ImChatInvokeListener[]) null);
            return;
        }
        invoke(String.valueOf(id), nickname, type, new Callback() {
            public void onResult(int statusCode) {
            }
        }, "");
    }
}
