package com.baidu.talos.core.devsupport;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.talos.core.BuildConfig;
import com.baidu.talos.core.devsupport.DevServerHelper;
import com.baidu.talos.core.devsupport.JSPackagerWebSocketClient;
import com.baidu.talos.core.util.OkHttpCallUtil;
import com.baidu.talos.util.UiThreadUtil;
import com.facebook.infer.annotation.Assertions;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Okio;
import okio.Sink;
import okio.Source;

public class TalosDevServerHelper {
    private static final String BUNDLE_URL_FORMAT = "http://%s/%s.bundle?platform=android&dev=%s&hot=%s&minify=%s&talosVersion=%s";
    private static final String DEFAULT_IP = "127.0.0.1";
    private static final String DEFAULT_PORT = "8081";
    private static final String HEAP_CAPTURE_UPLOAD_URL_FORMAT = "http://%s/jscheapcaptureupload";
    private static final int HTTP_CONNECT_TIMEOUT_MS = 5000;
    private static final String LAUNCH_JS_DEVTOOLS_COMMAND_URL_FORMAT = "http://%s/launch-js-devtools";
    private static final int LONG_POLL_FAILURE_DELAY_MS = 5000;
    private static final int LONG_POLL_KEEP_ALIVE_DURATION_MS = 120000;
    private static final String ONCHANGE_ENDPOINT_URL_FORMAT = "http://%s/onchange";
    private static final String PACKAGER_CONNECTION_URL_FORMAT = "ws://%s/message?role=shell";
    private static final String PACKAGER_OK_STATUS = "packager-status:running";
    private static final String PACKAGER_STATUS_URL_FORMAT = "http://%s/status";
    private static final String RELOAD_APP_ACTION_SUFFIX = ".RELOAD_APP_ACTION";
    public static final String RELOAD_APP_EXTRA_JS_PROXY = "jsproxy";
    private static final String SOURCE_MAP_URL_FORMAT = BUNDLE_URL_FORMAT.replaceFirst("\\.bundle", ".map");
    private static final String TAG = "TLS_DevServerHelper";
    private static final String TTF_URL_FORMAT = "http://%s/IconFontDev.ttf";
    private static final String WEBSOCKET_PROXY_URL_FORMAT = "ws://%s/debugger-proxy?role=client";
    private final OkHttpClient mClient = new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.MILLISECONDS).readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS).build();
    /* access modifiers changed from: private */
    @Nullable
    public Call mDownloadBundleFromURLCall;
    /* access modifiers changed from: private */
    @Nullable
    public Call mDownloadTTFFromURLCall;
    @Nullable
    private OkHttpClient mOnChangePollingClient;
    /* access modifiers changed from: private */
    public boolean mOnChangePollingEnabled;
    /* access modifiers changed from: private */
    @Nullable
    public DevServerHelper.OnServerContentChangeListener mOnServerContentChangeListener;
    /* access modifiers changed from: private */
    @Nullable
    public JSPackagerWebSocketClient mPackagerConnection;
    /* access modifiers changed from: private */
    public final Handler mRestartOnChangePollingHandler = new Handler(Looper.getMainLooper());

    public interface BundleDownloadCallback {
        void onFailure(Exception exc);

        void onSuccess();
    }

    public interface OnServerContentChangeListener {
        void onServerContentChanged();
    }

    public interface PackagerCommandListener {
        void onPackagerReloadCommand();
    }

    public interface PackagerStatusCallback {
        void onPackagerStatusFetched(boolean z);
    }

    public void openPackagerConnection(final DevServerHelper.PackagerCommandListener commandListener) {
        if (this.mPackagerConnection != null) {
            Log.w("TLS_DevServerHelper", "Packager connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... params) {
                    JSPackagerWebSocketClient unused = TalosDevServerHelper.this.mPackagerConnection = new JSPackagerWebSocketClient(TalosDevServerHelper.this.getPackagerConnectionURL(), new JSPackagerWebSocketClient.JSPackagerCallback() {
                        public void onMessage(String target, String action) {
                            if (commandListener != null && "bridge".equals(target) && "reload".equals(action)) {
                                commandListener.onPackagerReloadCommand();
                            }
                        }
                    });
                    TalosDevServerHelper.this.mPackagerConnection.connect();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void closePackagerConnection() {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... params) {
                if (TalosDevServerHelper.this.mPackagerConnection != null) {
                    TalosDevServerHelper.this.mPackagerConnection.closeQuietly();
                    JSPackagerWebSocketClient unused = TalosDevServerHelper.this.mPackagerConnection = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static String getReloadAppAction(Context context) {
        return context.getPackageName() + RELOAD_APP_ACTION_SUFFIX;
    }

    public String getWebsocketProxyURL() {
        return String.format(Locale.US, WEBSOCKET_PROXY_URL_FORMAT, new Object[]{getDebugServerHost()});
    }

    /* access modifiers changed from: private */
    public String getPackagerConnectionURL() {
        return String.format(Locale.US, PACKAGER_CONNECTION_URL_FORMAT, new Object[]{getDebugServerHost()});
    }

    public String getHeapCaptureUploadUrl() {
        return String.format(Locale.US, HEAP_CAPTURE_UPLOAD_URL_FORMAT, new Object[]{getDebugServerHost()});
    }

    private static String getHostForJSProxy() {
        return "localhost:8081";
    }

    private boolean getDevMode() {
        return true;
    }

    private boolean getJSMinifyMode() {
        return false;
    }

    private boolean getHMR() {
        return false;
    }

    private boolean getIconFontMode() {
        return false;
    }

    private String getDebugServerHost() {
        String ipFromSettings = TalosDevSharePreference.getInstance().getString(DevConstant.KEY_DEBUG_IP, "127.0.0.1");
        String portFromSettings = TalosDevSharePreference.getInstance().getString(DevConstant.KEY_DEBUG_PORT, DEFAULT_PORT);
        if (TextUtils.isEmpty(ipFromSettings)) {
            String host = AndroidInfoHelpers.getServerHost();
            if (host.equals("localhost:8081")) {
                Log.w("TLS_DevServerHelper", "You seem to be running on device. Run 'adb reverse tcp:8081 tcp:8081' to forward the debug server's port to the device.");
            }
            return host;
        } else if (TextUtils.isEmpty(portFromSettings)) {
            return ipFromSettings;
        } else {
            return ipFromSettings + AbstractJsonLexerKt.COLON + portFromSettings;
        }
    }

    private static String createBundleURL(String host, String jsModulePath, boolean devMode, boolean hmr, boolean jsMinify) {
        return String.format(Locale.US, BUNDLE_URL_FORMAT, new Object[]{host, jsModulePath, Boolean.valueOf(devMode), Boolean.valueOf(hmr), Boolean.valueOf(jsMinify), BuildConfig.TALOS_FRAME_VERSION});
    }

    private String createTTFURL(String host) {
        return String.format(Locale.US, TTF_URL_FORMAT, new Object[]{host});
    }

    public void downloadBundleFromURL(final DevServerHelper.BundleDownloadCallback callback, String jsModulePath, final File outputFile) {
        Call call = (Call) Assertions.assertNotNull(this.mClient.newCall(new Request.Builder().url(createBundleURL(getDebugServerHost(), jsModulePath, getDevMode(), getHMR(), getJSMinifyMode())).build()));
        this.mDownloadBundleFromURLCall = call;
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException e2) {
                if (TalosDevServerHelper.this.mDownloadBundleFromURLCall == null || TalosDevServerHelper.this.mDownloadBundleFromURLCall.isCanceled()) {
                    Call unused = TalosDevServerHelper.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                Call unused2 = TalosDevServerHelper.this.mDownloadBundleFromURLCall = null;
                callback.onFailure(DebugServerException.makeGeneric("Could not connect to development server.", "URL: " + call.request().url().toString(), e2));
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (TalosDevServerHelper.this.mDownloadBundleFromURLCall == null || TalosDevServerHelper.this.mDownloadBundleFromURLCall.isCanceled()) {
                    Call unused = TalosDevServerHelper.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                Call unused2 = TalosDevServerHelper.this.mDownloadBundleFromURLCall = null;
                if (!response.isSuccessful()) {
                    String body = response.body().string();
                    DebugServerException debugServerException = DebugServerException.parse(body);
                    if (debugServerException != null) {
                        callback.onFailure(debugServerException);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("The development server returned response error code: ").append(response.code()).append("\n\n").append("URL: ").append(call.request().url().toString()).append("\n\n").append("Body:\n").append(body);
                    callback.onFailure(new DebugServerException(sb.toString()));
                    return;
                }
                Sink output = null;
                try {
                    output = Okio.sink(outputFile);
                    Okio.buffer((Source) response.body().source()).readAll(output);
                    callback.onSuccess();
                } finally {
                    if (output != null) {
                        output.close();
                    }
                }
            }
        });
    }

    public void downloadTTFFromURL(final TTFDownloadCallback callback, final File outFile) {
        Call call = (Call) Assertions.assertNotNull(this.mClient.newCall(new Request.Builder().url(createTTFURL(getDebugServerHost())).build()));
        this.mDownloadTTFFromURLCall = call;
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException e2) {
                if (TalosDevServerHelper.this.mDownloadTTFFromURLCall == null || TalosDevServerHelper.this.mDownloadTTFFromURLCall.isCanceled()) {
                    Call unused = TalosDevServerHelper.this.mDownloadTTFFromURLCall = null;
                    return;
                }
                Call unused2 = TalosDevServerHelper.this.mDownloadTTFFromURLCall = null;
                callback.onFailure(new Exception("download iconfont failed"));
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (TalosDevServerHelper.this.mDownloadTTFFromURLCall == null || TalosDevServerHelper.this.mDownloadTTFFromURLCall.isCanceled()) {
                    Call unused = TalosDevServerHelper.this.mDownloadTTFFromURLCall = null;
                    return;
                }
                Call unused2 = TalosDevServerHelper.this.mDownloadTTFFromURLCall = null;
                if (!response.isSuccessful()) {
                    callback.onFailure(new Exception("response is not successful"));
                    return;
                }
                Sink output = null;
                try {
                    output = Okio.sink(outFile);
                    Okio.buffer((Source) response.body().source()).readAll(output);
                    callback.onSuccess();
                } finally {
                    if (output != null) {
                        output.close();
                    }
                }
            }
        });
    }

    public void cancelDownloadBundleFromURL() {
        Call call = this.mDownloadBundleFromURLCall;
        if (call != null) {
            call.cancel();
            this.mDownloadBundleFromURLCall = null;
        }
    }

    private static String createPackagerStatusURL(String host) {
        return String.format(Locale.US, PACKAGER_STATUS_URL_FORMAT, new Object[]{host});
    }

    public void stopPollingOnChangeEndpoint() {
        this.mOnChangePollingEnabled = false;
        this.mRestartOnChangePollingHandler.removeCallbacksAndMessages((Object) null);
        OkHttpClient okHttpClient = this.mOnChangePollingClient;
        if (okHttpClient != null) {
            OkHttpCallUtil.cancelTag(okHttpClient, this);
            this.mOnChangePollingClient = null;
        }
        this.mOnServerContentChangeListener = null;
    }

    public void startPollingOnChangeEndpoint(DevServerHelper.OnServerContentChangeListener onServerContentChangeListener) {
        if (!this.mOnChangePollingEnabled) {
            this.mOnChangePollingEnabled = true;
            this.mOnServerContentChangeListener = onServerContentChangeListener;
            this.mOnChangePollingClient = new OkHttpClient.Builder().connectionPool(new ConnectionPool(1, 120000, TimeUnit.MINUTES)).connectTimeout(5000, TimeUnit.MILLISECONDS).build();
            enqueueOnChangeEndpointLongPolling();
        }
    }

    /* access modifiers changed from: private */
    public void handleOnChangePollingResponse(boolean didServerContentChanged) {
        if (this.mOnChangePollingEnabled) {
            if (didServerContentChanged) {
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        if (TalosDevServerHelper.this.mOnServerContentChangeListener != null) {
                            TalosDevServerHelper.this.mOnServerContentChangeListener.onServerContentChanged();
                        }
                    }
                });
            }
            enqueueOnChangeEndpointLongPolling();
        }
    }

    private void enqueueOnChangeEndpointLongPolling() {
        ((OkHttpClient) Assertions.assertNotNull(this.mOnChangePollingClient)).newCall(new Request.Builder().url(createOnChangeEndpointUrl()).tag(this).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException e2) {
                if (TalosDevServerHelper.this.mOnChangePollingEnabled) {
                    Log.e("TLS_DevServerHelper", "Error while requesting /onchange endpoint", e2);
                    TalosDevServerHelper.this.mRestartOnChangePollingHandler.postDelayed(new Runnable() {
                        public void run() {
                            TalosDevServerHelper.this.handleOnChangePollingResponse(false);
                        }
                    }, 5000);
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                TalosDevServerHelper.this.handleOnChangePollingResponse(response.code() == 205);
            }
        });
    }

    private String createOnChangeEndpointUrl() {
        return String.format(Locale.US, ONCHANGE_ENDPOINT_URL_FORMAT, new Object[]{getDebugServerHost()});
    }

    private String createLaunchJSDevtoolsCommandUrl() {
        return String.format(Locale.US, LAUNCH_JS_DEVTOOLS_COMMAND_URL_FORMAT, new Object[]{getDebugServerHost()});
    }

    public void launchJSDevtools() {
        this.mClient.newCall(new Request.Builder().url(createLaunchJSDevtoolsCommandUrl()).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException e2) {
            }

            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    public String getSourceMapUrl(String mainModuleName) {
        return String.format(Locale.US, SOURCE_MAP_URL_FORMAT, new Object[]{getDebugServerHost(), mainModuleName, Boolean.valueOf(getDevMode()), Boolean.valueOf(getHMR()), Boolean.valueOf(getJSMinifyMode()), BuildConfig.TALOS_FRAME_VERSION});
    }

    public String getSourceUrl(String mainModuleName) {
        return String.format(Locale.US, BUNDLE_URL_FORMAT, new Object[]{getDebugServerHost(), mainModuleName, Boolean.valueOf(getDevMode()), Boolean.valueOf(getHMR()), Boolean.valueOf(getJSMinifyMode()), BuildConfig.TALOS_FRAME_VERSION});
    }

    public String getJSBundleURLForRemoteDebugging(String mainModuleName) {
        return createBundleURL(getHostForJSProxy(), mainModuleName, getDevMode(), getHMR(), getJSMinifyMode());
    }
}
