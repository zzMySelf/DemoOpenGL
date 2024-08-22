package com.baidu.swan.apps.setting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.api.module.account.LoginApi;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.network.update.node.SwanAppAccreditNode;
import com.baidu.swan.apps.prepose.util.SwanAppDebugUtil;
import com.baidu.swan.apps.runtime.Ability;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.runtime.SwanAppComponent;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.ScopeInfo;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.setting.oauth.request.LoginRequest;
import com.baidu.swan.apps.statistic.SwanAppLoginStatsUtils;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.storage.StorageUtil;
import com.baidu.swan.apps.storage.sp.SwanAppSharedPrefsWrapper;
import com.baidu.swan.apps.toast.UniversalToast;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.util.task.Task;
import com.baidu.swan.apps.util.task.TaskQueue;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SwanAppSetting extends SwanAppComponent implements Ability, SettingDef {
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String KEY_GAME_SWAN_JS_MD5 = "installed_game_swan_js_md5";
    public static final String KEY_INSTALLED_DEBUG_BUNDLE_MD5 = "installed_debug_bundle_md5";
    public static final String KEY_INSTALLED_DEBUG_GAME_BUNDLE_MD5 = "installed_debug_game_bundle_md5";
    public static final String KEY_SWAN_JS_MD5 = "installed_swan_js_md5";
    public static final String LOG_TAG = "SwanAppSetting";
    public static final String SETTING_PREFIX = "aiapp_setting_";
    /* access modifiers changed from: private */
    public final Map<String, Authorize> mAuthorizePool = new HashMap();
    public final TaskQueue mAuthorizeQueue = new TaskQueue();
    private final Set<SettingCallback> mCallbacks = new HashSet();
    private SwanAppSharedPrefsWrapper mPref;
    public final String name;
    public final String prefName;

    public interface SettingCallback {
        void onSettingFinish();
    }

    public SwanAppSetting(SwanApp swanApp) {
        super(swanApp);
        String storageName = StorageUtil.getStorageName(swanApp);
        this.name = storageName;
        this.prefName = "aiapp_setting_" + storageName;
    }

    public boolean available() {
        return true;
    }

    public boolean enable() {
        return true;
    }

    public void disable() {
    }

    public boolean enabled() {
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.mAuthorizePool.clear();
    }

    public void onActivityResume(Activity activity) {
    }

    private SwanAppSharedPrefsWrapper getPref() {
        if (this.mPref == null) {
            this.mPref = new SwanAppSharedPrefsWrapper(this.prefName, false);
        }
        return this.mPref;
    }

    public void clear() {
        getPref().edit().clear().apply();
    }

    public void clearWithCommit() {
        getPref().edit().clear().commit();
    }

    public void putBoolean(String key, boolean values) {
        getPref().putBoolean(key, values);
    }

    public void putString(String key, String values) {
        getPref().putString(key, values);
    }

    public void putStringSet(String key, Set<String> values) {
        SwanAppSharedPrefsWrapper pref = getPref();
        pref.remove(key);
        pref.putStringSet(key, values);
    }

    public void putLong(String key, long values) {
        getPref().putLong(key, values);
    }

    public boolean has(String key) {
        return this.mPref.contains(key);
    }

    public void remove(String key) {
        this.mPref.remove(key);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return getPref().getBoolean(key, defValue);
    }

    public String getString(String key, String defValue) {
        return getPref().getString(key, defValue);
    }

    public Set<String> getStringSet(String key, Set<String> defValue) {
        return getPref().getStringSet(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return getPref().getLong(key, defValue);
    }

    public Map<String, ?> get() {
        return getPref().getAll();
    }

    public String getPrefName() {
        return this.prefName;
    }

    public void checkOrAuthorize(Context context, String scope, TypedCallback<TaskResult<Authorize.Result>> callback) {
        checkOrAuthorize(context, scope, false, callback);
    }

    public void checkOrAuthorize(Context context, String scope, boolean invokedByUser, TypedCallback<TaskResult<Authorize.Result>> callback) {
        final TypedCallback<TaskResult<Authorize.Result>> typedCallback = callback;
        final String str = scope;
        final boolean z = invokedByUser;
        final Context context2 = context;
        checkAuthorize(scope, new TypedCallback<ScopeInfo>() {
            public void onCallback(ScopeInfo result) {
                TaskResult<Authorize.Result> taskResult = new TaskResult<>();
                if (!SwanAppSetting.DEBUG || !SwanAppDebugUtil.getForceAuthorizedDebug()) {
                    boolean needAuthorize = false;
                    boolean isResultNull = result == null;
                    SwanAppLog.logToFile(SwanAppSetting.LOG_TAG, "isResultNull = " + isResultNull + "; scope = " + str);
                    if (isResultNull || result.forbidden) {
                        taskResult.setError(new OAuthException(10005));
                        SwanAppSetting.this.notifyResultCallback(typedCallback, taskResult);
                        SwanAppLog.logToFile(SwanAppSetting.LOG_TAG, "checkOrAuthorize", new Exception("authorize fail"));
                        SwanAppUBCStatistic.onAuthorizeFailed(10005, result);
                        return;
                    }
                    if (z) {
                        if (result.tipStatus <= 0) {
                            needAuthorize = true;
                        }
                    } else if (result.tipStatus == 0) {
                        needAuthorize = true;
                    }
                    if (needAuthorize) {
                        SwanAppSetting.this.authorize(context2, str, z, new TypedCallback<TaskResult<Authorize.Result>>() {
                            public void onCallback(TaskResult<Authorize.Result> result) {
                                SwanAppSetting.this.notifyResultCallback(typedCallback, result);
                            }
                        });
                        return;
                    }
                    if (result.tipStatus > 0) {
                        taskResult.setOk();
                        taskResult.mData = new Authorize.Result(true, (String) null);
                    } else {
                        taskResult.setError(new OAuthException(10003));
                    }
                    SwanAppSetting.this.notifyResultCallback(typedCallback, taskResult);
                    return;
                }
                taskResult.setOk();
                taskResult.mData = new Authorize.Result(true, (String) null);
                SwanAppSetting.this.notifyResultCallback(typedCallback, taskResult);
            }
        });
    }

    public void checkAuthorize(String scope, final TypedCallback<ScopeInfo> callback) {
        if (TextUtils.isEmpty(scope)) {
            notifyResultCallback(callback, (Object) null);
        } else {
            SwanAppAccreditNode.getAccreditListData(scope, new TypedCallback<ScopeInfo>() {
                public void onCallback(ScopeInfo scopeInfo) {
                    SwanAppSetting.this.notifyResultCallback(callback, scopeInfo);
                }
            });
        }
    }

    public boolean checkAuthorizeFromLocalCache(String scope) {
        if (DEBUG && SwanAppDebugUtil.getForceAuthorizedDebug()) {
            return true;
        }
        ScopeInfo info = SwanAppAccreditNode.getAccreditListDataFromLocalCache(scope);
        if (info == null || info.forbidden || !info.authorized()) {
            return false;
        }
        return true;
    }

    public void authorize(Activity activity, TypedCallback<TaskResult<Authorize.Result>> callback) {
        authorize(activity, (String) null, false, true, true, callback);
    }

    public void authorize(Context context, String scope, boolean invokedByUser, TypedCallback<TaskResult<Authorize.Result>> callback) {
        authorize(context, scope, invokedByUser, true, false, callback);
    }

    public void authorize(Context context, String scope, boolean invokedByUser, boolean permit, boolean explicitly, TypedCallback<TaskResult<Authorize.Result>> callback) {
        preformAuthorize(context, scope, invokedByUser, permit, explicitly, callback);
    }

    private void preformAuthorize(Context context, final String scope, boolean invokedByUser, boolean permit, boolean explicitly, TypedCallback<TaskResult<Authorize.Result>> callback) {
        TypedCallback<TaskResult<Authorize.Result>> typedCallback = callback;
        final String finalScope = TextUtils.isEmpty(scope) ? "" : scope;
        Authorize authorize = this.mAuthorizePool.get(finalScope);
        if (authorize == null || TaskState.FINISHED == authorize.getStatus()) {
            Authorize authorize2 = Swan.get().getAdaptationProducer().getAdaptation().createOAuthObjectCreator().createAuthorize(context, invokedByUser, permit, new String[]{finalScope}, (String) null, explicitly);
            this.mAuthorizePool.put(finalScope, authorize2);
            authorize2.regCallback(typedCallback).regCallback(new TypedCallback<TaskResult<Authorize.Result>>() {
                public void onCallback(TaskResult<Authorize.Result> taskResult) {
                    SwanAppSetting.this.mAuthorizePool.remove(finalScope);
                }
            });
            final Authorize finalAuthorize = authorize2;
            SwanAppUBCStatistic.onSwanLoginProcessStatistic(SwanAppLoginStatsUtils.getLoginSceneFromLogin(scope), "requestModifyScope");
            String str = scope;
            this.mAuthorizeQueue.offer(new Task() {
                public void run() {
                    finalAuthorize.setLoginProcessScene(SwanAppLoginStatsUtils.getLoginSceneFromLogin(scope)).regCallback(new TypedCallback<TaskResult<Authorize.Result>>() {
                        public void onCallback(TaskResult<Authorize.Result> taskResult) {
                            AnonymousClass4.this.finish();
                        }
                    });
                    finalAuthorize.call();
                }
            });
            return;
        }
        authorize.regCallback(typedCallback);
    }

    /* access modifiers changed from: private */
    public <ResulT> void notifyResultCallback(TypedCallback<ResulT> callback, final ResulT result) {
        notifyCallback(callback, new Callbacker<TypedCallback<ResulT>>() {
            /* access modifiers changed from: package-private */
            public void exec(TypedCallback<ResulT> callback) {
                callback.onCallback(result);
            }
        });
    }

    public boolean startSettingFragment() {
        ISwanPageManager manager = SwanAppController.getInstance().getSwanPageManager();
        if (manager == null) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        manager.createTransaction("navigateTo").setCustomAnimations(ISwanPageManager.ANIM_ENTER, ISwanPageManager.ANIM_HOLD).pushFragment("authority", (SwanAppPageParam) null).commit();
        return true;
    }

    public synchronized void regCallback(SettingCallback callback) {
        this.mCallbacks.add(callback);
    }

    public synchronized void unregCallback(SettingCallback callback) {
        this.mCallbacks.remove(callback);
    }

    public synchronized void clearCallbacks() {
        this.mCallbacks.clear();
    }

    public synchronized void clearAuthorizeAndCallback() {
        this.mAuthorizePool.clear();
        this.mAuthorizeQueue.clear();
        clearCallbacks();
    }

    private <CallBackT> void notifyCallbacks(Collection<CallBackT> target, Callbacker<CallBackT> callbacker) {
        Iterator it = new ArrayList(target).iterator();
        while (it.hasNext()) {
            notifyCallback(it.next(), callbacker);
        }
    }

    private <CallBackT> void notifyCallback(final CallBackT target, final Callbacker<CallBackT> callbacker) {
        postToMain(new Runnable() {
            public void run() {
                callbacker.exec(target);
            }
        });
    }

    public synchronized void notifySettingFinish() {
        notifyCallbacks(new HashSet<>(this.mCallbacks), new Callbacker<SettingCallback>() {
            /* access modifiers changed from: package-private */
            public void exec(SettingCallback callback) {
                callback.onSettingFinish();
            }
        });
    }

    private abstract class Callbacker<CallBackT> {
        /* access modifiers changed from: package-private */
        public abstract void exec(CallBackT callbackt);

        private Callbacker() {
        }
    }

    private static void postToMain(Runnable runnable) {
        SwanAppUtils.runOnUiThread(runnable);
    }

    public void login(Activity activity, LoginApi.LoginTimeoutConfig timeoutConfig, Bundle loginParams, TypedCallback<TaskResult<LoginRequest.Result>> callback, String invokeScene) {
        final Activity activity2 = activity;
        final LoginApi.LoginTimeoutConfig loginTimeoutConfig = timeoutConfig;
        final Bundle bundle = loginParams;
        final String str = invokeScene;
        final TypedCallback<TaskResult<LoginRequest.Result>> typedCallback = callback;
        this.mAuthorizeQueue.offer(new Task() {
            public void run() {
                Swan.get().getAdaptationProducer().getAdaptation().createOAuthObjectCreator().createLoginRequest(activity2, loginTimeoutConfig, bundle).setLoginProcessScene(str).regCallback(typedCallback).regCallback(new TypedCallback<TaskResult<LoginRequest.Result>>() {
                    public void onCallback(TaskResult<LoginRequest.Result> taskResult) {
                        AnonymousClass8.this.finish();
                    }
                }).call();
            }
        });
    }
}
