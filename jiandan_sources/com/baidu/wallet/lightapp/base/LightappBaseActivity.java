package com.baidu.wallet.lightapp.base;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.ZoomButtonsController;
import androidx.annotation.NonNull;
import androidx.core.net.MailTo;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.StringUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.multipage.a;
import com.baidu.wallet.permission.CommonPermissionCallback;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SuppressLint({"SetJavaScriptEnabled"})
public abstract class LightappBaseActivity extends BaseActivity implements NoProguard {
    public static final int CALL_CAMERA_ID_DETECT = 5;
    public static final int CALL_CAMERA_REQUESTCODE = 3;
    public static final int CONTACTS_REQUESTCODE = 4;
    public static final int FILECHOOSER_RESULTCODE = 1;
    public static final int FILECHOOSER_RESULTCODE_FOR_ANDROID_5 = 2;
    public static final int FILE_FETCH_REQUEST = 7;
    public static final int INPUT_FILE_GET_CAMMERA_PERMISSION = 101;
    public static final int INPUT_FILE_GET_STORAGE_PERMISSION = 102;
    public static final int INSERT_EVENTS_REQUEST = 6;
    public static int WEBVIEW_ERROR_TIME;
    public Intent a = null;
    public int b = -1;
    public String c = null;
    public boolean d = false;
    public CommonPermissionCallback e;
    public CommonPermissionCallback f;
    public Uri g;
    public long mLangbridgeHash = 0;
    public LightappJsClient mLightappJsClient;
    public boolean mNeedClearHistory = true;
    public boolean mNeedOverrideUrl = false;
    public List<String> mPhoneContacts;
    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessageForAndroid5;
    public LightappBrowserWebView mWebView;

    public class BaseCustomWebViewClient extends SafeWebView.SafeWebViewClient implements NoProguard {
        public BaseCustomWebViewClient() {
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            super.doUpdateVisitedHistory(webView, str, z);
            LightappBaseActivity lightappBaseActivity = LightappBaseActivity.this;
            if (lightappBaseActivity.mNeedClearHistory) {
                lightappBaseActivity.mWebView.clearHistory();
                if (str != null && !str.contains("about:blank")) {
                    LightappBaseActivity.this.mNeedClearHistory = false;
                }
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            LightappBaseActivity.this.mLightappJsClient.setUrlLocal(str);
            super.onPageStarted(webView, str, bitmap);
            LightappUtils.insertAppSessionIdJs(LightappBaseActivity.this.mWebView);
        }

        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(new String[]{i2 + "", str2}));
            LogUtil.d("LightappBaseActivity", "onReceivedError.showErrorPage");
            super.onReceivedError(webView, i2, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            LogUtil.d("LightappBaseActivity", "OriginalUrl : " + webView.getOriginalUrl());
            LogUtil.d("LightappBaseActivity", "shouldOverrideUrlLoading url = " + str);
            if (str.startsWith("tel:")) {
                try {
                    LightappBaseActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            } else if (str.startsWith(MailTo.MAILTO_SCHEME)) {
                try {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{str.replace(MailTo.MAILTO_SCHEME, "")});
                    LightappBaseActivity.this.startActivity(intent);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    GlobalUtils.toast(LightappBaseActivity.this.getActivity(), "请先配置邮箱");
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            } else if (str.toLowerCase(Locale.CHINA).startsWith("http") || str.toLowerCase(Locale.CHINA).startsWith("https") || str.toLowerCase(Locale.CHINA).startsWith("file")) {
                LangbridgeCacheManager.getInstance().handleLoadUrl(LightappBaseActivity.this.mLangbridgeHash, str);
                return false;
            } else {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent((ComponentName) null);
                    parseUri.setSelector((Intent) null);
                    LightappBaseActivity.this.startActivity(parseUri);
                    return true;
                } catch (Exception e3) {
                    LogUtil.d("LightappBaseActivity", e3.getMessage());
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
        }
    }

    public static int getNavigationBarHeight(@NonNull Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public abstract a getBusinessImpl();

    public abstract String getContentLayoutId();

    public abstract String getErrMsg();

    public abstract String getLightappWebviewId();

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.a = null;
        this.b = -1;
        boolean z = true;
        if (i2 == 1) {
            if (this.mUploadMessage != null) {
                Uri data = (intent == null || i3 != -1) ? null : intent.getData();
                if (data != null) {
                    this.mUploadMessage.onReceiveValue(data);
                } else {
                    this.mUploadMessage.onReceiveValue(this.g);
                }
                this.mUploadMessage = null;
                this.g = null;
            }
        } else if (i2 == 2) {
            if (this.mUploadMessageForAndroid5 != null) {
                Uri data2 = (intent == null || i3 != -1) ? null : intent.getData();
                if (data2 != null) {
                    this.mUploadMessageForAndroid5.onReceiveValue(new Uri[]{data2});
                } else {
                    Uri uri = this.g;
                    if (uri != null) {
                        this.mUploadMessageForAndroid5.onReceiveValue(new Uri[]{uri});
                    } else {
                        this.mUploadMessageForAndroid5.onReceiveValue(new Uri[0]);
                    }
                }
                this.mUploadMessageForAndroid5 = null;
                this.g = null;
            }
        } else if (i2 == 3) {
            if (i3 == -1) {
                this.mLightappJsClient.onCallCameraPicCallbackLocal();
            }
        } else if (i2 == 4) {
            if (i3 == -1) {
                if (!(intent == null || intent.getData() == null)) {
                    List<String> loadRawPhone = ContactManager.getIContactsImpl().loadRawPhone(intent.getData(), getActivity());
                    this.mPhoneContacts = loadRawPhone;
                    if (loadRawPhone != null && loadRawPhone.size() > 1) {
                        if (this.mPhoneContacts.size() == 2) {
                            String str = this.mPhoneContacts.get(0);
                            String str2 = this.mPhoneContacts.get(1);
                            if (!TextUtils.isEmpty(str) && str.equals(str2)) {
                                str = "";
                            }
                            this.mLightappJsClient.onContactsSelectedLocal(0, new String[]{str, StringUtils.trimAll(str2)}, "");
                            return;
                        }
                        prepareSelectNumDialog(this.mPhoneContacts, new AdapterView.OnItemClickListener() {
                            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                                if (i2 > 0 && i2 < LightappBaseActivity.this.mPhoneContacts.size()) {
                                    String replace = LightappBaseActivity.this.mPhoneContacts.get(i2).replace(" ", "").replace("-", "");
                                    LightappBaseActivity lightappBaseActivity = LightappBaseActivity.this;
                                    lightappBaseActivity.mLightappJsClient.onContactsSelectedLocal(0, new String[]{lightappBaseActivity.mPhoneContacts.get(0), replace}, "");
                                }
                            }
                        });
                        return;
                    }
                }
                this.mLightappJsClient.onContactsSelectedLocal(1, (String[]) null, getErrMsg());
            }
        } else if (i2 == 6) {
            LightappJsClient lightappJsClient = this.mLightappJsClient;
            if (i3 != -1) {
                z = false;
            }
            lightappJsClient.onInsertCalendarEventDone(z);
        } else if (i2 == 7) {
            this.mLightappJsClient.onFileFetchDone(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        increaseIconCloseStatus();
        LightappBrowserWebView lightappBrowserWebView = this.mWebView;
        if (lightappBrowserWebView == null || !lightappBrowserWebView.canGoBack()) {
            super.onBackPressed();
            return;
        }
        LogUtil.d("LightappBaseActivity", "cangoback:  " + this.mWebView.getUrl());
        this.mWebView.goBack();
        onWebViewBack();
        this.mNeedOverrideUrl = true;
    }

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(ResUtils.layout(getActivity(), getContentLayoutId()));
        } catch (Throwable th2) {
            String stackTraceString = Log.getStackTraceString(th2);
            WEBVIEW_ERROR_TIME++;
            if (stackTraceString.contains("NameNotFoundException: com.android.webview") || stackTraceString.contains("java.lang.RuntimeException: Cannot load WebView") || stackTraceString.contains("MissingWebViewPackageException: Failed to load WebView provider")) {
                Toast.makeText(getActivity(), ResUtils.getString(this, "langbridge_webview_error"), 1).show();
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_ERROR, Arrays.asList(new String[]{th2.getMessage(), "0", "" + WEBVIEW_ERROR_TIME, stackTraceString}));
            } else {
                if (WEBVIEW_ERROR_TIME >= 3) {
                    Toast.makeText(getActivity(), ResUtils.getString(this, "langbridge_webview_error2"), 1).show();
                }
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_ERROR, Arrays.asList(new String[]{th2.getMessage(), "1", "" + WEBVIEW_ERROR_TIME, stackTraceString}));
            }
        }
        LightappBrowserWebView lightappBrowserWebView = (LightappBrowserWebView) findViewById(ResUtils.id(getActivity(), getLightappWebviewId()));
        this.mWebView = lightappBrowserWebView;
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.getSettings().setDomStorageEnabled(true);
            this.mWebView.getSettings().setDatabaseEnabled(true);
            this.mWebView.getSettings().setGeolocationDatabasePath(DxmApplicationContextImpl.getApplicationContext(this).getDir("database", 0).getPath());
            setSupportZoom();
            this.mWebView.getSettings().setTextZoom(100);
            this.mWebView.getSettings().setGeolocationEnabled(true);
            this.mWebView.setScrollBarStyle(0);
            this.mWebView.clearCache(false);
            this.mWebView.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
                this.mWebView.removeJavascriptInterface("accessibility");
                this.mWebView.removeJavascriptInterface("accessibilityTraversal");
            }
            LightappJsClient lightappJsClient = new LightappJsClient(getBusinessImpl(), this.mWebView);
            this.mLightappJsClient = lightappJsClient;
            this.mWebView.addJavascriptInterface(lightappJsClient, LightappJsClient.LIGHTAPP_JS_NAME);
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this.mWebView, true);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        LightappJsClient lightappJsClient = this.mLightappJsClient;
        if (lightappJsClient != null) {
            lightappJsClient.destroy();
        }
        if (this.mWebView != null && !LightappWebViewCenter.getInstance().releaseLightappWebView(this, this.mWebView)) {
            this.mWebView.removeAllViews();
            ViewGroup viewGroup = (ViewGroup) this.mWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.mWebView);
            }
            this.mWebView.clearHistory();
            this.mWebView.destroy();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int r5, java.lang.String[] r6, int[] r7) {
        /*
            r4 = this;
            super.onRequestPermissionsResult(r5, r6, r7)
            com.baidu.wallet.lightapp.base.LightappJsClient r0 = r4.mLightappJsClient
            r0.onRequestPermissionsResultLocal(r5, r6, r7)
            if (r7 == 0) goto L_0x0080
            int r0 = r7.length
            if (r0 <= 0) goto L_0x0080
            r0 = 101(0x65, float:1.42E-43)
            r1 = 1
            r2 = 0
            r3 = 0
            if (r5 == r0) goto L_0x0045
            r0 = 102(0x66, float:1.43E-43)
            if (r5 == r0) goto L_0x0019
            goto L_0x005b
        L_0x0019:
            com.baidu.wallet.permission.CommonPermissionCallback r0 = r4.e
            if (r0 == 0) goto L_0x0022
            r0.onRequestPermissionsResult(r5, r6, r7)
            r4.e = r3
        L_0x0022:
            int r5 = r7.length
            r6 = 0
        L_0x0024:
            if (r6 >= r5) goto L_0x002f
            r0 = r7[r6]
            if (r0 == 0) goto L_0x002c
            r5 = 1
            goto L_0x0030
        L_0x002c:
            int r6 = r6 + 1
            goto L_0x0024
        L_0x002f:
            r5 = 0
        L_0x0030:
            if (r5 != 0) goto L_0x005e
            java.lang.String r6 = r4.c
            boolean r7 = r4.d
            int r0 = r4.b
            r4.a(r6, r7, r0)
            java.lang.String r6 = ""
            r4.c = r6
            r4.d = r2
            r6 = -1
            r4.b = r6
            goto L_0x005e
        L_0x0045:
            com.baidu.wallet.permission.CommonPermissionCallback r0 = r4.f
            if (r0 == 0) goto L_0x004e
            r0.onRequestPermissionsResult(r5, r6, r7)
            r4.f = r3
        L_0x004e:
            r5 = r7[r2]
            if (r5 != 0) goto L_0x005d
            android.content.Intent r5 = r4.a
            if (r5 == 0) goto L_0x005b
            int r6 = r4.b
            r4.startActivityForResult((android.content.Intent) r5, (int) r6)
        L_0x005b:
            r5 = 0
            goto L_0x005e
        L_0x005d:
            r5 = 1
        L_0x005e:
            if (r5 == 0) goto L_0x0080
            int r5 = r4.b
            if (r5 != r1) goto L_0x0070
            android.webkit.ValueCallback<android.net.Uri> r5 = r4.mUploadMessage
            if (r5 == 0) goto L_0x006d
            r5.onReceiveValue(r3)
            r4.mUploadMessage = r3
        L_0x006d:
            r4.g = r3
            goto L_0x0080
        L_0x0070:
            r6 = 2
            if (r5 != r6) goto L_0x0080
            android.webkit.ValueCallback<android.net.Uri[]> r5 = r4.mUploadMessageForAndroid5
            if (r5 == 0) goto L_0x007e
            android.net.Uri[] r6 = new android.net.Uri[r2]
            r5.onReceiveValue(r6)
            r4.mUploadMessageForAndroid5 = r3
        L_0x007e:
            r4.g = r3
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.base.LightappBaseActivity.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    public abstract void onWebViewBack();

    public abstract void prepareSelectNumDialog(List<String> list, AdapterView.OnItemClickListener onItemClickListener);

    @SuppressLint({"NewApi"})
    public void setSupportZoom() {
        this.mWebView.getSettings().setSupportZoom(true);
        this.mWebView.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.getSettings().setDisplayZoomControls(false);
        } else {
            setZoomControlGone(this.mWebView);
        }
        this.mWebView.getSettings().setUseWideViewPort(true);
    }

    public void setZoomControlGone(View view) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(view);
            zoomButtonsController.getZoomControls().setVisibility(8);
            try {
                declaredField.set(view, zoomButtonsController);
            } catch (IllegalArgumentException e2) {
                LogUtil.d(e2.getMessage());
            } catch (IllegalAccessException e3) {
                LogUtil.d(e3.getMessage());
            }
        } catch (SecurityException e4) {
            LogUtil.d(e4.getMessage());
        } catch (NoSuchFieldException e5) {
            LogUtil.d(e5.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0091, code lost:
        if (r2.equals(com.google.common.net.MediaType.IMAGE_TYPE) != false) goto L_0x009f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r17, boolean r18, int r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r19
            android.app.Activity r4 = r16.getActivity()
            java.lang.String r5 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r4 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r4, r5)
            java.lang.String r5 = ""
            if (r4 != 0) goto L_0x003c
            android.app.Activity r4 = r16.getActivity()
            java.lang.String r6 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r4 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r4, r6)
            if (r4 != 0) goto L_0x003c
            r1.c = r0
            r1.d = r2
            r1.b = r3
            android.app.Activity r0 = r16.getActivity()
            java.lang.String[] r2 = new java.lang.String[]{r6}
            com.baidu.wallet.lightapp.base.LightappBaseActivity$2 r4 = new com.baidu.wallet.lightapp.base.LightappBaseActivity$2
            r4.<init>(r3)
            com.baidu.wallet.permission.CommonPermissionCallback r0 = com.baidu.wallet.core.utils.BaiduWalletUtils.requestPermissionsDialog(r5, r0, r2, r4)
            r1.e = r0
            return
        L_0x003c:
            java.lang.String r4 = android.os.Environment.DIRECTORY_PICTURES
            java.io.File r4 = android.os.Environment.getExternalStoragePublicDirectory(r4)
            boolean r6 = r4.exists()
            if (r6 != 0) goto L_0x004b
            r4.mkdirs()
        L_0x004b:
            r16.getPackageManager()
            java.lang.String r6 = "/"
            java.lang.String[] r6 = r0.split(r6)
            if (r6 == 0) goto L_0x0235
            int r7 = r6.length
            if (r7 <= 0) goto L_0x0235
            r7 = 0
            r8 = r6[r7]
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x0064
            goto L_0x0235
        L_0x0064:
            java.lang.String r8 = "android.intent.action.GET_CONTENT"
            if (r2 == 0) goto L_0x0224
            r2 = r6[r7]
            r6 = -1
            int r9 = r2.hashCode()
            r10 = 93166550(0x58d9bd6, float:1.3316821E-35)
            r11 = 2
            r12 = 1
            if (r9 == r10) goto L_0x0094
            r10 = 100313435(0x5faa95b, float:2.3572098E-35)
            if (r9 == r10) goto L_0x008b
            r7 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r9 == r7) goto L_0x0081
            goto L_0x009e
        L_0x0081:
            java.lang.String r7 = "video"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x009e
            r7 = 1
            goto L_0x009f
        L_0x008b:
            java.lang.String r9 = "image"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x009e
            goto L_0x009f
        L_0x0094:
            java.lang.String r7 = "audio"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x009e
            r7 = 2
            goto L_0x009f
        L_0x009e:
            r7 = -1
        L_0x009f:
            java.lang.String r2 = "output"
            java.lang.String r9 = "FileProviderCalledInSearchboxPlugin"
            java.lang.String r10 = ".langbrigeProvider"
            java.lang.String r13 = ".fileprovider"
            java.lang.String r14 = "tieba"
            java.lang.String r15 = "iqiyi"
            java.lang.String r6 = "android.permission.CAMERA"
            if (r7 == 0) goto L_0x0174
            if (r7 == r12) goto L_0x00c6
            if (r7 == r11) goto L_0x00bd
            android.content.Intent r2 = new android.content.Intent
            r2.<init>(r8)
            r2.setType(r0)
            goto L_0x022c
        L_0x00bd:
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r0 = "android.provider.MediaStore.RECORD_SOUND"
            r2.<init>(r0)
            goto L_0x022c
        L_0x00c6:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = java.io.File.separator
            r7.append(r4)
            java.lang.String r4 = "video_"
            r7.append(r4)
            long r11 = java.lang.System.currentTimeMillis()
            r7.append(r11)
            java.lang.String r4 = ".mp4"
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r0.<init>(r4)
            java.lang.String r4 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID
            boolean r4 = r15.equals(r4)
            if (r4 == 0) goto L_0x0113
            android.app.Activity r4 = r16.getActivity()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r16.getPackageName()
            r7.append(r8)
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r4, r7, r0)
            r1.g = r0
            goto L_0x013c
        L_0x0113:
            java.lang.String r4 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID
            boolean r4 = r14.equals(r4)
            if (r4 == 0) goto L_0x011f
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEvent(r9)
            return
        L_0x011f:
            android.app.Activity r4 = r16.getActivity()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r16.getPackageName()
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r4, r7, r0)
            r1.g = r0
        L_0x013c:
            java.lang.String r0 = r16.getPackageName()
            android.net.Uri r4 = r1.g
            r7 = 3
            r1.grantUriPermission(r0, r4, r7)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r4 = "android.media.action.VIDEO_CAPTURE"
            r0.<init>(r4)
            android.net.Uri r4 = r1.g
            r0.putExtra(r2, r4)
            android.app.Activity r2 = r16.getActivity()
            boolean r2 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r2, r6)
            if (r2 != 0) goto L_0x0222
            r1.a = r0
            r1.b = r3
            android.app.Activity r0 = r16.getActivity()
            java.lang.String[] r2 = new java.lang.String[]{r6}
            com.baidu.wallet.lightapp.base.LightappBaseActivity$4 r3 = new com.baidu.wallet.lightapp.base.LightappBaseActivity$4
            r3.<init>()
            com.baidu.wallet.permission.CommonPermissionCallback r0 = com.baidu.wallet.core.utils.BaiduWalletUtils.requestPermissionsDialog(r5, r0, r2, r3)
            r1.f = r0
            return
        L_0x0174:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = java.io.File.separator
            r7.append(r4)
            java.lang.String r4 = "IMG_"
            r7.append(r4)
            long r11 = java.lang.System.currentTimeMillis()
            r7.append(r11)
            java.lang.String r4 = ".jpg"
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r0.<init>(r4)
            java.lang.String r4 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID
            boolean r4 = r15.equals(r4)
            if (r4 == 0) goto L_0x01c1
            android.app.Activity r4 = r16.getActivity()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r16.getPackageName()
            r7.append(r8)
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r4, r7, r0)
            r1.g = r0
            goto L_0x01ea
        L_0x01c1:
            java.lang.String r4 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID
            boolean r4 = r14.equals(r4)
            if (r4 == 0) goto L_0x01cd
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEvent(r9)
            return
        L_0x01cd:
            android.app.Activity r4 = r16.getActivity()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r16.getPackageName()
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r4, r7, r0)
            r1.g = r0
        L_0x01ea:
            java.lang.String r0 = r16.getPackageName()
            android.net.Uri r4 = r1.g
            r7 = 3
            r1.grantUriPermission(r0, r4, r7)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r4 = "android.media.action.IMAGE_CAPTURE"
            r0.<init>(r4)
            android.net.Uri r4 = r1.g
            r0.putExtra(r2, r4)
            android.app.Activity r2 = r16.getActivity()
            boolean r2 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r2, r6)
            if (r2 != 0) goto L_0x0222
            r1.a = r0
            r1.b = r3
            android.app.Activity r0 = r16.getActivity()
            java.lang.String[] r2 = new java.lang.String[]{r6}
            com.baidu.wallet.lightapp.base.LightappBaseActivity$3 r3 = new com.baidu.wallet.lightapp.base.LightappBaseActivity$3
            r3.<init>()
            com.baidu.wallet.permission.CommonPermissionCallback r0 = com.baidu.wallet.core.utils.BaiduWalletUtils.requestPermissionsDialog(r5, r0, r2, r3)
            r1.f = r0
            return
        L_0x0222:
            r2 = r0
            goto L_0x022c
        L_0x0224:
            android.content.Intent r2 = new android.content.Intent
            r2.<init>(r8)
            r2.setType(r0)
        L_0x022c:
            r1.startActivityForResult((android.content.Intent) r2, (int) r3)     // Catch:{ ActivityNotFoundException -> 0x0230 }
            goto L_0x0235
        L_0x0230:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0235:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.base.LightappBaseActivity.a(java.lang.String, boolean, int):void");
    }

    public class BaseCustomChromeClient extends SafeWebView.SafeChromeClient implements NoProguard {
        public BaseCustomChromeClient() {
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            String[] acceptTypes;
            LightappBaseActivity.this.mUploadMessageForAndroid5 = valueCallback;
            if (webView != null && !TextUtils.isEmpty(webView.getUrl())) {
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_INPUT_FILE, Arrays.asList(new String[]{webView.getUrl()}));
            }
            if (fileChooserParams != null && (acceptTypes = fileChooserParams.getAcceptTypes()) != null && acceptTypes.length > 0 && !TextUtils.isEmpty(acceptTypes[0])) {
                LightappBaseActivity.this.a(acceptTypes[0], fileChooserParams.isCaptureEnabled(), 2);
            }
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            LightappBaseActivity.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            try {
                LightappBaseActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            LightappBaseActivity.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str);
            try {
                LightappBaseActivity.this.startActivityForResult(Intent.createChooser(intent, "File Browser"), 1);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            LightappBaseActivity.this.mUploadMessage = valueCallback;
            if (!TextUtils.isEmpty(str)) {
                LightappBaseActivity.this.a(str, !TextUtils.isEmpty(str2), 1);
            }
        }
    }
}
