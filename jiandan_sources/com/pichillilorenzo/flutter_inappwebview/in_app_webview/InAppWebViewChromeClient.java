package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.MimeTypeMap;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.in_app_browser.ActivityResultListener;
import com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate;
import com.pichillilorenzo.flutter_inappwebview.types.CreateWindowAction;
import com.pichillilorenzo.flutter_inappwebview.types.URLRequest;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InAppWebViewChromeClient extends WebChromeClient implements PluginRegistry.ActivityResultListener, ActivityResultListener {
    public static final FrameLayout.LayoutParams FULLSCREEN_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-1, -1, 17);
    public static final int FULLSCREEN_SYSTEM_UI_VISIBILITY = 1798;
    @RequiresApi(api = 19)
    public static final int FULLSCREEN_SYSTEM_UI_VISIBILITY_KITKAT = 7942;
    public static final String LOG_TAG = "IABWebChromeClient";
    public static final int PICKER = 1;
    public static final int PICKER_LEGACY = 3;
    public static final String fileProviderAuthorityExtension = "flutter_inappwebview.fileprovider";
    public static Uri imageOutputFileUri;
    public static Uri videoOutputFileUri;
    public static int windowAutoincrementId = 0;
    public static Map<Integer, Message> windowWebViewMessages = new HashMap();
    public final String DEFAULT_MIME_TYPES = "*/*";
    public final MethodChannel channel;
    public InAppBrowserDelegate inAppBrowserDelegate;
    public View mCustomView;
    public WebChromeClient.CustomViewCallback mCustomViewCallback;
    public int mOriginalOrientation;
    public int mOriginalSystemUiVisibility;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public InAppWebViewChromeClient(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, MethodChannel methodChannel, InAppBrowserDelegate inAppBrowserDelegate2) {
        this.plugin = inAppWebViewFlutterPlugin;
        this.channel = methodChannel;
        this.inAppBrowserDelegate = inAppBrowserDelegate2;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.getActivityResultListeners().add(this);
        }
        PluginRegistry.Registrar registrar = inAppWebViewFlutterPlugin.registrar;
        if (registrar != null) {
            registrar.addActivityResultListener(this);
            return;
        }
        ActivityPluginBinding activityPluginBinding = inAppWebViewFlutterPlugin.activityPluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this);
        }
    }

    private Boolean acceptsAny(String[] strArr) {
        if (isArrayEmpty(strArr).booleanValue()) {
            return Boolean.TRUE;
        }
        for (String equals : strArr) {
            if (equals.equals("*/*")) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private Boolean acceptsImages(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(IStringUtil.CURRENT_PATH, ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains(MediaType.IMAGE_TYPE));
    }

    private Boolean acceptsImages(String[] strArr) {
        return Boolean.valueOf(acceptsAny(strArr).booleanValue() || arrayContainsString(getAcceptedMimeType(strArr), MediaType.IMAGE_TYPE).booleanValue());
    }

    private Boolean acceptsVideo(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(IStringUtil.CURRENT_PATH, ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains(MediaType.VIDEO_TYPE));
    }

    private Boolean acceptsVideo(String[] strArr) {
        return Boolean.valueOf(acceptsAny(strArr).booleanValue() || arrayContainsString(getAcceptedMimeType(strArr), MediaType.VIDEO_TYPE).booleanValue());
    }

    private Boolean arrayContainsString(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2 != null && str2.contains(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private String[] getAcceptedMimeType(String[] strArr) {
        if (isArrayEmpty(strArr).booleanValue()) {
            return new String[]{"*/*"};
        }
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (str.matches("\\.\\w+")) {
                strArr2[i2] = getMimeTypeFromExtension(str.replace(IStringUtil.CURRENT_PATH, ""));
            } else {
                strArr2[i2] = str;
            }
        }
        return strArr2;
    }

    @Nullable
    private Activity getActivity() {
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            return inAppBrowserDelegate2.getActivity();
        }
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null) {
            return inAppWebViewFlutterPlugin.activity;
        }
        return null;
    }

    @Nullable
    private File getCapturedFile(String str) {
        String str2;
        String str3;
        String str4 = "";
        if (str.equals("android.media.action.IMAGE_CAPTURE")) {
            str4 = Environment.DIRECTORY_PICTURES;
            str2 = MediaType.IMAGE_TYPE;
            str3 = ".jpg";
        } else if (str.equals("android.media.action.VIDEO_CAPTURE")) {
            str4 = Environment.DIRECTORY_MOVIES;
            str2 = MediaType.VIDEO_TYPE;
            str3 = ".mp4";
        } else {
            str2 = str4;
            str3 = str2;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return new File(Environment.getExternalStoragePublicDirectory(str4), String.format("%s-%d%s", new Object[]{str2, Long.valueOf(System.currentTimeMillis()), str3}));
        }
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return File.createTempFile(str2, str3, activity.getApplicationContext().getExternalFilesDir((String) null));
    }

    private Uri getCapturedMediaFile() {
        Uri uri = imageOutputFileUri;
        if (uri != null && isFileNotEmpty(uri)) {
            return imageOutputFileUri;
        }
        Uri uri2 = videoOutputFileUri;
        if (uri2 == null || !isFileNotEmpty(uri2)) {
            return null;
        }
        return videoOutputFileUri;
    }

    private Intent getFileChooserIntent(String str) {
        String str2 = str.isEmpty() ? "*/*" : str;
        if (str.matches("\\.\\w+")) {
            str2 = getMimeTypeFromExtension(str.replace(IStringUtil.CURRENT_PATH, ""));
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str2);
        return intent;
    }

    @RequiresApi(api = 19)
    private Intent getFileChooserIntent(String[] strArr, boolean z) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", getAcceptedMimeType(strArr));
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
        return intent;
    }

    private String getMimeTypeFromExtension(String str) {
        if (str != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        return null;
    }

    @Nullable
    private Uri getOutputUri(String str) {
        File file;
        try {
            file = getCapturedFile(str);
        } catch (IOException e) {
            e.printStackTrace();
            file = null;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return Uri.fromFile(file);
        }
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        String packageName = activity.getApplicationContext().getPackageName();
        return FileProvider.getUriForFile(activity.getApplicationContext(), packageName + IStringUtil.CURRENT_PATH + fileProviderAuthorityExtension, file);
    }

    private Intent getPhotoIntent() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri outputUri = getOutputUri("android.media.action.IMAGE_CAPTURE");
        imageOutputFileUri = outputUri;
        intent.putExtra("output", outputUri);
        return intent;
    }

    private Uri[] getSelectedFiles(Intent intent, int i2) {
        if (intent == null || intent.getData() == null) {
            if (intent == null || intent.getClipData() == null) {
                Uri capturedMediaFile = getCapturedMediaFile();
                if (capturedMediaFile == null) {
                    return null;
                }
                return new Uri[]{capturedMediaFile};
            }
            int itemCount = intent.getClipData().getItemCount();
            Uri[] uriArr = new Uri[itemCount];
            for (int i3 = 0; i3 < itemCount; i3++) {
                uriArr[i3] = intent.getClipData().getItemAt(i3).getUri();
            }
            return uriArr;
        } else if (i2 != -1 || Build.VERSION.SDK_INT < 21) {
            return null;
        } else {
            return WebChromeClient.FileChooserParams.parseResult(i2, intent);
        }
    }

    private Intent getVideoIntent() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        Uri outputUri = getOutputUri("android.media.action.VIDEO_CAPTURE");
        videoOutputFileUri = outputUri;
        intent.putExtra("output", outputUri);
        return intent;
    }

    private Boolean isArrayEmpty(String[] strArr) {
        boolean z = false;
        if (strArr.length == 0 || (strArr.length == 1 && strArr[0].length() == 0)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private boolean isFileNotEmpty(Uri uri) {
        Activity activity = getActivity();
        if (activity == null) {
            return false;
        }
        try {
            AssetFileDescriptor openAssetFileDescriptor = activity.getContentResolver().openAssetFileDescriptor(uri, "r");
            long length = openAssetFileDescriptor.getLength();
            openAssetFileDescriptor.close();
            return length > 0;
        } catch (IOException unused) {
            return false;
        }
    }

    public void createAlertDialog(WebView webView, String str, final JsResult jsResult, String str2, String str3) {
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        AnonymousClass2 r3 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                jsResult.confirm();
                dialogInterface.dismiss();
            }
        };
        Activity activity = getActivity();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, 2131952122);
            builder.setMessage((CharSequence) str);
            if (str3 == null || str3.isEmpty()) {
                builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) r3);
            } else {
                builder.setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) r3);
            }
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        }
    }

    public void createBeforeUnloadDialog(WebView webView, String str, final JsResult jsResult, String str2, String str3, String str4) {
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        AnonymousClass13 r4 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                jsResult.confirm();
                dialogInterface.dismiss();
            }
        };
        AnonymousClass14 r7 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                jsResult.cancel();
                dialogInterface.dismiss();
            }
        };
        Activity activity = getActivity();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, 2131952122);
            builder.setMessage((CharSequence) str);
            if (str3 == null || str3.isEmpty()) {
                builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) r4);
            } else {
                builder.setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) r4);
            }
            if (str4 == null || str4.isEmpty()) {
                builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) r7);
            } else {
                builder.setNegativeButton((CharSequence) str4, (DialogInterface.OnClickListener) r7);
            }
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        }
    }

    public void createConfirmDialog(WebView webView, String str, final JsResult jsResult, String str2, String str3, String str4) {
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        AnonymousClass5 r4 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                jsResult.confirm();
                dialogInterface.dismiss();
            }
        };
        AnonymousClass6 r7 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                jsResult.cancel();
                dialogInterface.dismiss();
            }
        };
        Activity activity = getActivity();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, 2131952122);
            builder.setMessage((CharSequence) str);
            if (str3 == null || str3.isEmpty()) {
                builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) r4);
            } else {
                builder.setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) r4);
            }
            if (str4 == null || str4.isEmpty()) {
                builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) r7);
            } else {
                builder.setNegativeButton((CharSequence) str4, (DialogInterface.OnClickListener) r7);
            }
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        }
    }

    public void createPromptDialog(WebView webView, String str, String str2, final JsPromptResult jsPromptResult, String str3, String str4, final String str5, String str6, String str7) {
        FrameLayout frameLayout = new FrameLayout(webView.getContext());
        final EditText editText = new EditText(webView.getContext());
        editText.setMaxLines(1);
        if (str4 != null && !str4.isEmpty()) {
            str2 = str4;
        }
        editText.setText(str2);
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        frameLayout.setPaddingRelative(45, 15, 45, 0);
        frameLayout.addView(editText);
        if (str3 != null && !str3.isEmpty()) {
            str = str3;
        }
        AnonymousClass9 r3 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                String obj = editText.getText().toString();
                JsPromptResult jsPromptResult = jsPromptResult;
                String str = str5;
                if (str != null) {
                    obj = str;
                }
                jsPromptResult.confirm(obj);
                dialogInterface.dismiss();
            }
        };
        AnonymousClass10 r5 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                jsPromptResult.cancel();
                dialogInterface.dismiss();
            }
        };
        Activity activity = getActivity();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, 2131952122);
            builder.setMessage((CharSequence) str);
            if (str7 == null || str7.isEmpty()) {
                builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) r3);
            } else {
                builder.setPositiveButton((CharSequence) str7, (DialogInterface.OnClickListener) r3);
            }
            if (str6 == null || str6.isEmpty()) {
                builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) r5);
            } else {
                builder.setNegativeButton((CharSequence) str6, (DialogInterface.OnClickListener) r5);
            }
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    jsPromptResult.cancel();
                    dialogInterface.dismiss();
                }
            });
            AlertDialog create = builder.create();
            create.setView(frameLayout);
            create.show();
        }
    }

    public void dispose() {
        ActivityPluginBinding activityPluginBinding;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (!(inAppWebViewFlutterPlugin == null || (activityPluginBinding = inAppWebViewFlutterPlugin.activityPluginBinding) == null)) {
            activityPluginBinding.removeActivityResultListener(this);
        }
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.getActivityResultListeners().clear();
            this.inAppBrowserDelegate = null;
        }
        this.plugin = null;
    }

    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
    }

    @Nullable
    public ViewGroup getRootView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.findViewById(16908290);
    }

    public boolean needsCameraPermission() {
        Activity activity = getActivity();
        if (activity == null) {
            return true;
        }
        try {
            return Arrays.asList(activity.getPackageManager().getPackageInfo(activity.getApplicationContext().getPackageName(), 4096).requestedPermissions).contains("android.permission.CAMERA") && ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA") != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public boolean onActivityResult(int i2, int i3, Intent intent) {
        if (InAppWebViewFlutterPlugin.filePathCallback == null && InAppWebViewFlutterPlugin.filePathCallbackLegacy == null) {
            return true;
        }
        if (i2 == 1) {
            Uri[] selectedFiles = i3 == -1 ? getSelectedFiles(intent, i3) : null;
            ValueCallback<Uri[]> valueCallback = InAppWebViewFlutterPlugin.filePathCallback;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(selectedFiles);
            }
        } else if (i2 == 3) {
            InAppWebViewFlutterPlugin.filePathCallbackLegacy.onReceiveValue(i3 == -1 ? intent != null ? intent.getData() : getCapturedMediaFile() : null);
        }
        InAppWebViewFlutterPlugin.filePathCallback = null;
        InAppWebViewFlutterPlugin.filePathCallbackLegacy = null;
        imageOutputFileUri = null;
        videoOutputFileUri = null;
        return true;
    }

    public void onCloseWindow(WebView webView) {
        this.channel.invokeMethod("onCloseWindow", new HashMap());
        super.onCloseWindow(webView);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", consoleMessage.message());
        hashMap.put("messageLevel", Integer.valueOf(consoleMessage.messageLevel().ordinal()));
        this.channel.invokeMethod("onConsoleMessage", hashMap);
        return true;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        String string;
        final int i2 = windowAutoincrementId + 1;
        windowAutoincrementId = i2;
        WebView.HitTestResult hitTestResult = webView.getHitTestResult();
        String extra = hitTestResult.getExtra();
        if (hitTestResult.getType() == 8) {
            Message obtainMessage = webView.getHandler().obtainMessage();
            webView.requestFocusNodeHref(obtainMessage);
            Bundle data = obtainMessage.getData();
            if (!(data == null || (string = data.getString("url")) == null || string.isEmpty())) {
                extra = string;
            }
        }
        CreateWindowAction createWindowAction = new CreateWindowAction(new URLRequest(extra, ShareTarget.METHOD_GET, (byte[]) null, (Map<String, String>) null), true, z2, false, i2, z);
        windowWebViewMessages.put(Integer.valueOf(i2), message);
        this.channel.invokeMethod("onCreateWindow", createWindowAction.toMap(), new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.toString();
                if (InAppWebViewChromeClient.windowWebViewMessages.containsKey(Integer.valueOf(i2))) {
                    InAppWebViewChromeClient.windowWebViewMessages.remove(Integer.valueOf(i2));
                }
            }

            public void notImplemented() {
                if (InAppWebViewChromeClient.windowWebViewMessages.containsKey(Integer.valueOf(i2))) {
                    InAppWebViewChromeClient.windowWebViewMessages.remove(Integer.valueOf(i2));
                }
            }

            public void success(@Nullable Object obj) {
                if (!(obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) && InAppWebViewChromeClient.windowWebViewMessages.containsKey(Integer.valueOf(i2))) {
                    InAppWebViewChromeClient.windowWebViewMessages.remove(Integer.valueOf(i2));
                }
            }
        });
        return true;
    }

    public void onGeolocationPermissionsHidePrompt() {
        this.channel.invokeMethod("onGeolocationPermissionsHidePrompt", new HashMap());
    }

    public void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, str);
        this.channel.invokeMethod("onGeolocationPermissionsShowPrompt", hashMap, new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.toString();
                callback.invoke(str, false, false);
            }

            public void notImplemented() {
                callback.invoke(str, false, false);
            }

            public void success(Object obj) {
                Map map = (Map) obj;
                if (map != null) {
                    callback.invoke((String) map.get(HttpHeaders.ReferrerPolicyValues.ORIGIN), ((Boolean) map.get("allow")).booleanValue(), ((Boolean) map.get("retain")).booleanValue());
                } else {
                    callback.invoke(str, false, false);
                }
            }
        });
    }

    public void onHideCustomView() {
        ViewGroup rootView;
        Activity activity = getActivity();
        if (activity != null && (rootView = getRootView()) != null) {
            ((FrameLayout) rootView).removeView(this.mCustomView);
            this.mCustomView = null;
            rootView.setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            activity.setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
            activity.getWindow().clearFlags(512);
            this.channel.invokeMethod("onExitFullscreen", new HashMap());
        }
    }

    public boolean onJsAlert(final WebView webView, String str, final String str2, final JsResult jsResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        hashMap.put("iosIsMainFrame", (Object) null);
        this.channel.invokeMethod("onJsAlert", hashMap, new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.toString();
                jsResult.cancel();
            }

            public void notImplemented() {
                InAppWebViewChromeClient.this.createAlertDialog(webView, str2, jsResult, (String) null, (String) null);
            }

            public void success(@Nullable Object obj) {
                String str;
                String str2;
                if (obj != null) {
                    Map map = (Map) obj;
                    String str3 = (String) map.get("message");
                    String str4 = (String) map.get("confirmButtonTitle");
                    Boolean bool = (Boolean) map.get("handledByClient");
                    if (bool == null || !bool.booleanValue()) {
                        str2 = str3;
                        str = str4;
                    } else {
                        Integer num = (Integer) map.get("action");
                        if (Integer.valueOf(num != null ? num.intValue() : 1).intValue() != 0) {
                            jsResult.cancel();
                            return;
                        } else {
                            jsResult.confirm();
                            return;
                        }
                    }
                } else {
                    str2 = null;
                    str = null;
                }
                InAppWebViewChromeClient.this.createAlertDialog(webView, str2, jsResult, str2, str);
            }
        });
        return true;
    }

    public boolean onJsBeforeUnload(final WebView webView, String str, final String str2, final JsResult jsResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        this.channel.invokeMethod("onJsBeforeUnload", hashMap, new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.toString();
                jsResult.cancel();
            }

            public void notImplemented() {
                InAppWebViewChromeClient.this.createConfirmDialog(webView, str2, jsResult, (String) null, (String) null, (String) null);
            }

            public void success(Object obj) {
                String str;
                String str2;
                String str3;
                if (obj != null) {
                    Map map = (Map) obj;
                    String str4 = (String) map.get("message");
                    String str5 = (String) map.get("confirmButtonTitle");
                    String str6 = (String) map.get("cancelButtonTitle");
                    Boolean bool = (Boolean) map.get("handledByClient");
                    if (bool == null || !bool.booleanValue()) {
                        str3 = str4;
                        str2 = str5;
                        str = str6;
                    } else {
                        Integer num = (Integer) map.get("action");
                        if (Integer.valueOf(num != null ? num.intValue() : 1).intValue() != 0) {
                            jsResult.cancel();
                            return;
                        } else {
                            jsResult.confirm();
                            return;
                        }
                    }
                } else {
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                InAppWebViewChromeClient.this.createBeforeUnloadDialog(webView, str2, jsResult, str3, str2, str);
            }
        });
        return true;
    }

    public boolean onJsConfirm(final WebView webView, String str, final String str2, final JsResult jsResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        hashMap.put("iosIsMainFrame", (Object) null);
        this.channel.invokeMethod("onJsConfirm", hashMap, new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.toString();
                jsResult.cancel();
            }

            public void notImplemented() {
                InAppWebViewChromeClient.this.createConfirmDialog(webView, str2, jsResult, (String) null, (String) null, (String) null);
            }

            public void success(Object obj) {
                String str;
                String str2;
                String str3;
                if (obj != null) {
                    Map map = (Map) obj;
                    String str4 = (String) map.get("message");
                    String str5 = (String) map.get("confirmButtonTitle");
                    String str6 = (String) map.get("cancelButtonTitle");
                    Boolean bool = (Boolean) map.get("handledByClient");
                    if (bool == null || !bool.booleanValue()) {
                        str3 = str4;
                        str2 = str5;
                        str = str6;
                    } else {
                        Integer num = (Integer) map.get("action");
                        if (Integer.valueOf(num != null ? num.intValue() : 1).intValue() != 0) {
                            jsResult.cancel();
                            return;
                        } else {
                            jsResult.confirm();
                            return;
                        }
                    }
                } else {
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                InAppWebViewChromeClient.this.createConfirmDialog(webView, str2, jsResult, str3, str2, str);
            }
        });
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        hashMap.put("defaultValue", str3);
        hashMap.put("iosIsMainFrame", (Object) null);
        final JsPromptResult jsPromptResult2 = jsPromptResult;
        final WebView webView2 = webView;
        final String str4 = str2;
        final String str5 = str3;
        this.channel.invokeMethod("onJsPrompt", hashMap, new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.toString();
                jsPromptResult2.cancel();
            }

            public void notImplemented() {
                InAppWebViewChromeClient.this.createPromptDialog(webView2, str4, str5, jsPromptResult2, (String) null, (String) null, (String) null, (String) null, (String) null);
            }

            public void success(Object obj) {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                if (obj != null) {
                    Map map = (Map) obj;
                    String str6 = (String) map.get("message");
                    String str7 = (String) map.get("defaultValue");
                    String str8 = (String) map.get("confirmButtonTitle");
                    String str9 = (String) map.get("cancelButtonTitle");
                    String str10 = (String) map.get("value");
                    Boolean bool = (Boolean) map.get("handledByClient");
                    if (bool == null || !bool.booleanValue()) {
                        str5 = str6;
                        str4 = str7;
                        str = str8;
                        str2 = str9;
                        str3 = str10;
                    } else {
                        Integer num = (Integer) map.get("action");
                        if (Integer.valueOf(num != null ? num.intValue() : 1).intValue() != 0) {
                            jsPromptResult2.cancel();
                            return;
                        } else {
                            jsPromptResult2.confirm(str10);
                            return;
                        }
                    }
                } else {
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                InAppWebViewChromeClient.this.createPromptDialog(webView2, str4, str5, jsPromptResult2, str5, str4, str3, str2, str);
            }
        });
        return true;
    }

    public void onPermissionRequest(final PermissionRequest permissionRequest) {
        if (Build.VERSION.SDK_INT >= 23) {
            HashMap hashMap = new HashMap();
            hashMap.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, permissionRequest.getOrigin().toString());
            hashMap.put("resources", Arrays.asList(permissionRequest.getResources()));
            this.channel.invokeMethod("onPermissionRequest", hashMap, new MethodChannel.Result() {
                public void error(String str, @Nullable String str2, @Nullable Object obj) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb.append(str2);
                    sb.toString();
                    permissionRequest.deny();
                }

                public void notImplemented() {
                    permissionRequest.deny();
                }

                public void success(Object obj) {
                    if (obj != null) {
                        Map map = (Map) obj;
                        Integer num = (Integer) map.get("action");
                        List list = (List) map.get("resources");
                        if (list == null) {
                            list = new ArrayList();
                        }
                        String[] strArr = (String[]) list.toArray(new String[list.size()]);
                        if (num != null) {
                            if (num.intValue() != 1) {
                                permissionRequest.deny();
                                return;
                            } else {
                                permissionRequest.grant(strArr);
                                return;
                            }
                        }
                    }
                    permissionRequest.deny();
                }
            });
        }
    }

    public void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        InAppWebView inAppWebView = (InAppWebView) webView;
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didChangeProgress(i2);
        }
        InAppWebViewClient inAppWebViewClient = inAppWebView.inAppWebViewClient;
        if (inAppWebViewClient != null) {
            inAppWebViewClient.loadCustomJavaScriptOnPageStarted(webView);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("progress", Integer.valueOf(i2));
        this.channel.invokeMethod("onProgressChanged", hashMap);
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            String message = e.getMessage();
        }
        bitmap.recycle();
        HashMap hashMap = new HashMap();
        hashMap.put("icon", byteArrayOutputStream.toByteArray());
        this.channel.invokeMethod("onReceivedIcon", hashMap);
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didChangeTitle(str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("title", str);
        this.channel.invokeMethod("onTitleChanged", hashMap);
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        super.onReceivedTouchIconUrl(webView, str, z);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("precomposed", Boolean.valueOf(z));
        this.channel.invokeMethod("onReceivedTouchIconUrl", hashMap);
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        ViewGroup rootView;
        if (this.mCustomView != null) {
            onHideCustomView();
            return;
        }
        Activity activity = getActivity();
        if (activity != null && (rootView = getRootView()) != null) {
            this.mCustomView = view;
            this.mOriginalSystemUiVisibility = rootView.getSystemUiVisibility();
            this.mOriginalOrientation = activity.getRequestedOrientation();
            this.mCustomViewCallback = customViewCallback;
            this.mCustomView.setBackgroundColor(-16777216);
            rootView.setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? FULLSCREEN_SYSTEM_UI_VISIBILITY_KITKAT : FULLSCREEN_SYSTEM_UI_VISIBILITY);
            activity.getWindow().setFlags(512, 512);
            ((FrameLayout) rootView).addView(this.mCustomView, FULLSCREEN_LAYOUT_PARAMS);
            this.channel.invokeMethod("onEnterFullscreen", new HashMap());
        }
    }

    @TargetApi(21)
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        boolean z = true;
        if (fileChooserParams.getMode() != 1) {
            z = false;
        }
        return startPhotoPickerIntent(valueCallback, fileChooserParams.createIntent(), acceptTypes, z);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        startPhotoPickerIntent(valueCallback, "");
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        startPhotoPickerIntent(valueCallback, str);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        startPhotoPickerIntent(valueCallback, str);
    }

    public void startPhotoPickerIntent(ValueCallback<Uri> valueCallback, String str) {
        InAppWebViewFlutterPlugin.filePathCallbackLegacy = valueCallback;
        Intent createChooser = Intent.createChooser(getFileChooserIntent(str), "");
        ArrayList arrayList = new ArrayList();
        if (acceptsImages(str).booleanValue()) {
            arrayList.add(getPhotoIntent());
        }
        if (acceptsVideo(str).booleanValue()) {
            arrayList.add(getVideoIntent());
        }
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        Activity activity = getActivity();
        if (activity != null && createChooser.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(createChooser, 3);
        }
    }

    @RequiresApi(api = 21)
    public boolean startPhotoPickerIntent(ValueCallback<Uri[]> valueCallback, Intent intent, String[] strArr, boolean z) {
        InAppWebViewFlutterPlugin.filePathCallback = valueCallback;
        ArrayList arrayList = new ArrayList();
        if (!needsCameraPermission()) {
            if (acceptsImages(strArr).booleanValue()) {
                arrayList.add(getPhotoIntent());
            }
            if (acceptsVideo(strArr).booleanValue()) {
                arrayList.add(getVideoIntent());
            }
        }
        Intent fileChooserIntent = getFileChooserIntent(strArr, z);
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", fileChooserIntent);
        intent2.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        Activity activity = getActivity();
        if (!(activity == null || intent2.resolveActivity(activity.getPackageManager()) == null)) {
            activity.startActivityForResult(intent2, 1);
        }
        return true;
    }
}
