package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCommonModel;
import com.baidu.wallet.lightapp.multipage.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class LightappJsClient implements NoProguard {
    public static final String LIGHTAPP_JS_NAME = "BLightApp";
    public static final int VIEW_INVISIBLE = 0;
    public static final int VIEW_VISIBLE = 1;
    public static boolean a = false;
    public static Pattern b = Pattern.compile("(\\w|\\.|\\$){1,20}");
    public final ConcurrentHashMap<String, b> c = new ConcurrentHashMap<>();
    public LightappBusinessClient d;
    public LightappJsNativeClient e;
    public String f;
    public String g;
    public LightappWebView h;

    /* renamed from: i  reason: collision with root package name */
    public a f3558i;
    public boolean j = false;

    public static class LightappInvokerCallbackImpl implements ILightappInvokerCallback {
        public final String a;
        public ArrayList<String> b;
        public final Map<String, b> c;
        public LightappBusinessClient d;

        public LightappInvokerCallbackImpl(Map<String, b> map, String str, ArrayList<String> arrayList, LightappBusinessClient lightappBusinessClient) {
            this.a = str;
            this.b = arrayList;
            this.c = map;
            this.d = lightappBusinessClient;
        }

        public void addStatics(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                this.b.add(str);
            }
        }

        public void onResult(int i2, String str) {
            b bVar = this.c.get(this.a);
            if (bVar != null) {
                String str2 = "\"" + LightappUtils.formatJSONForWebViewCallback(str) + "\"";
                if (i2 == 0) {
                    bVar.a(str2);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_SUCCESS, this.b);
                } else if (i2 != 1) {
                    this.b.add("jsonResult:: " + str2);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, this.b);
                } else {
                    String str3 = "";
                    if (TextUtils.isEmpty(str)) {
                        str = str3;
                    }
                    if (this.b.size() >= 2) {
                        this.b.add(1, str);
                    } else {
                        this.b.add(str);
                    }
                    try {
                        str3 = ((LightAppCommonModel) JsonUtils.fromJson(str, LightAppCommonModel.class)).cnt.errCode;
                    } catch (Exception unused) {
                    }
                    this.b.add(str3);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, this.b);
                    bVar.b(str2);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.a);
                arrayList.add("lightappJsCallback is null");
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, arrayList);
            }
            this.c.remove(this.a);
        }
    }

    public LightappJsClient(a aVar, LightappWebView lightappWebView) {
        this.f3558i = aVar;
        this.h = lightappWebView;
        this.d = new LightappBusinessClient(aVar);
        this.e = new LightappJsNativeClient(aVar);
    }

    private Context a() {
        a aVar = this.f3558i;
        if (aVar == null) {
            return null;
        }
        if (aVar.getActivity() != null) {
            return this.f3558i.getActivity();
        }
        return this.f3558i.getContext();
    }

    private boolean b(String str, String str2) {
        LightappJsNativeClient lightappJsNativeClient;
        Set<String> methodList;
        if (!TextUtils.isEmpty(str) && (lightappJsNativeClient = this.e) != null && (methodList = lightappJsNativeClient.getMethodList()) != null && methodList.size() >= 1) {
            return methodList.contains(str);
        }
        return false;
    }

    private boolean c(String str, String str2) {
        Set<String> methodList;
        if (!TextUtils.isEmpty(str) && (methodList = LightAppWrapper.getInstance().getMethodList()) != null && methodList.size() >= 1) {
            return methodList.contains(str);
        }
        return false;
    }

    public static void enableJsNameVerify(boolean z) {
        a = z;
    }

    public static final boolean isJsFunNameValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return b.matcher(str).matches();
    }

    @JavascriptInterface
    public void accessWalletService(String str, String str2) {
        if (this.d != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, str);
                jSONObject.put("serviceExtra", str2);
                jSONObject.put(LightappConstants.LIGHT_APP_NATIVE_INVOKER_METHOD_NAME, LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE);
                a(LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE, jSONObject.toString(), "", "");
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void bdLogin(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_BD_LOGIN, str, str2, str3);
    }

    @JavascriptInterface
    public void callCamera(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_CALL_CAMERA, str, str2, str3);
    }

    @JavascriptInterface
    public void callIDPotos(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_CALL_ID_PHOTOS, str, str2, str3);
    }

    @JavascriptInterface
    public void callQRCodeScanner(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_CALL_QRCODE_SCANNER, str, str2, str3);
    }

    @JavascriptInterface
    public void callShare(String str, String str2, String str3) {
        a(LightappJsNativeClient.METHOD_CALL_SHARE, str, str2, str3);
    }

    @JavascriptInterface
    public void closeWindow() {
        a(LightappJsNativeClient.METHOD_CLOSE_WINDOW, "", "", "");
    }

    public void destroy() {
        this.c.clear();
        this.d = null;
        this.e = null;
        this.f3558i = null;
        this.j = true;
    }

    @JavascriptInterface
    public void detectBankCard(String str, String str2, String str3) {
        a("detectBankCard", str, str2, str3);
    }

    @JavascriptInterface
    public void doBindCard(String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orderInfo", str3);
            jSONObject.put("showDialog", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("doBindCard", jSONObject.toString(), str, str2);
    }

    @JavascriptInterface
    public void doRnAuth(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orderInfo", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("doRnAuth", jSONObject.toString(), str, str2);
    }

    @JavascriptInterface
    public void dopay(String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orderInfo", str3);
            jSONObject.put("showDialog", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("dopay", jSONObject.toString(), str, str2);
    }

    public Set<String> getAllowCalledOnBackgroundMethodlist() {
        HashSet hashSet = new HashSet();
        hashSet.add(LightappBusinessClient.METHOD_GET_USER_AGENT);
        hashSet.add(LightappBusinessClient.MTD_CALLPHONEINFO);
        hashSet.add("setTitle");
        hashSet.add(LightappBusinessClient.MTD_SETMENU);
        hashSet.add(LightappBusinessClient.MTD_STATEVENT);
        hashSet.add(LightappBusinessClient.MTD_DIGEST);
        hashSet.add(LightappBusinessClient.MTD_ENCRYPT);
        hashSet.add(LightappBusinessClient.MTD_DECRYPT);
        hashSet.add(LightappBusinessClient.MTD_CUSTOMER_SERVICE);
        hashSet.add(LightappBusinessClient.MTD_GET_SUPPORT_LIST);
        hashSet.add("postEvent");
        hashSet.add(LightappBusinessClient.MTD_SET_FULLSCREEN);
        hashSet.add(LightappBusinessClient.MTD_H5GOBCK);
        hashSet.add(LightappBusinessClient.MTD_UNREGISTER_H5_GO_BACK);
        hashSet.add(LightappBusinessClient.MTD_H5ClOSE);
        hashSet.add(LightappBusinessClient.MTD_UNREGISTER_H5_CLOSE);
        hashSet.add(LightappBusinessClient.MTD_H5REFRESH);
        hashSet.add(LightappBusinessClient.MTD_UNREGISTER_H5_REFRESH);
        hashSet.add("getPayMethod");
        hashSet.add("setRnAuthResult");
        hashSet.add(LightappBusinessClient.MTD_SAVE_PIC);
        hashSet.add(LightappBusinessClient.MTD_SET_SCREEN_VERTICAL);
        hashSet.add(LightappBusinessClient.MTD_RPA_PERCEPTIONL);
        hashSet.add(LightappBusinessClient.MTD_INSERT_PHONE_NUM_TO_ADDRESS_BOOK);
        hashSet.add(LightappJsNativeClient.METHOD_GET_DEVIDE_INFO);
        if (PermissionManager.checkCallingPermission(a(), "android.permission.ACCESS_FINE_LOCATION")) {
            hashSet.add(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION);
        }
        hashSet.add(LightappJsNativeClient.MW_PRE_LOAD_EXCEPTION);
        hashSet.add(LightappJsNativeClient.MW_NATIVE_LOG);
        hashSet.add(LightappJsNativeClient.MW_IS_PRELOADED);
        hashSet.add(LightappJsNativeClient.MW_RM_FROM_PRELOAD_POOL);
        hashSet.add(LightappJsNativeClient.MW_GET_LANGBRIDGE_HASH_STAMP);
        hashSet.add(LightappJsNativeClient.MW_GET_LANGBRIDGE_SETTINGS);
        hashSet.add(LightappBusinessClient.MTD_GET_OFFLINE_INFO);
        hashSet.add(LightappBusinessClient.MTD_UPLOAD_MSG);
        hashSet.add(LightappBusinessClient.MTD_GET_LOAD_TIME_LINE);
        hashSet.add(LightappBusinessClient.MTD_SEND_TO_SMS);
        hashSet.add(LightappBusinessClient.MTD_GET_PERMISSION_STATE);
        hashSet.add(LightappBusinessClient.MTD_GET_PERMISSIOM_DIALOG_MSG);
        hashSet.add(LightappBusinessClient.METHOD_GET_SUPPORT_LIVENESS);
        hashSet.add(LightappBusinessClient.MTD_PERMISSION_UNIVERSAL_SET);
        hashSet.add("callNativeField");
        return hashSet;
    }

    @JavascriptInterface
    public void getBattery(String str, String str2) {
        LightappJsNativeClient lightappJsNativeClient = this.e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.getBattery(str, str2);
        }
    }

    @JavascriptInterface
    public void getCurrentPosition(String str, String str2) {
        a(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, "", str, str2);
    }

    @JavascriptInterface
    public void getDeviceInfo(String str, String str2, String str3) {
        a(LightappJsNativeClient.METHOD_GET_DEVIDE_INFO, str, str2, str3);
    }

    @JavascriptInterface
    public String getGlobalizationInfo() {
        return "";
    }

    public ILightappInvoker getLightappBusiness() {
        return this.d;
    }

    @JavascriptInterface
    public void getUserAgent(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_GET_USER_AGENT, str, str2, str3);
    }

    @JavascriptInterface
    public void initpay(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LightappConstants.INIT_PAY_PARAM_INIT_PARAM, str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(LightappBusinessClient.METHOD_INIT_PAY, jSONObject.toString(), str, str2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: java.lang.String} */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:54|55|56|(2:60|(6:62|63|(3:65|66|(1:68))|69|(1:73)|74))|75|76|79|80|(3:82|(1:84)|85)|86|87|(3:89|90|(3:92|104|(3:114|115|(3:117|118|(2:120|136)(2:121|135))(2:122|(2:124|(2:126|138)(2:127|137))(2:128|(2:130|131)(2:132|140))))(2:112|113)))|93|(1:95)(2:96|(1:98)(2:99|(1:101)(1:102)))|103|104|(0)(0)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0180 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x024c A[Catch:{ Exception -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0267 A[Catch:{ Exception -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0107 A[Catch:{ Exception -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0118 A[Catch:{ Exception -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0129 A[Catch:{ Exception -> 0x031b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012a A[Catch:{ Exception -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b2 A[Catch:{ Exception -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01dd A[SYNTHETIC, Splitter:B:89:0x01dd] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01ed A[Catch:{ Exception -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f3 A[Catch:{ Exception -> 0x031b }] */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void invokeBdWalletNative(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "serviceName"
            java.lang.String r5 = ":"
            java.lang.String r6 = "\""
            java.lang.String r7 = "from_url"
            java.lang.String r8 = "method_name"
            java.lang.String r9 = "password"
            java.lang.String r10 = "user_name"
            java.lang.String r11 = "extraParam"
            boolean r12 = android.text.TextUtils.isEmpty(r18)
            if (r12 == 0) goto L_0x001f
            return
        L_0x001f:
            boolean r12 = isJsFunNameValid(r19)
            if (r12 == 0) goto L_0x002b
            boolean r12 = isJsFunNameValid(r20)
            if (r12 != 0) goto L_0x0048
        L_0x002b:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.lang.String r13 = r1.f
            r12.add(r13)
            r12.add(r0)
            r12.add(r2)
            r12.add(r3)
            java.lang.String r13 = "invalid_js_funs"
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r13, r12)
            boolean r12 = a
            if (r12 == 0) goto L_0x0048
            return
        L_0x0048:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x031b }
            r12.<init>(r0)     // Catch:{ Exception -> 0x031b }
            java.lang.String r13 = "agentcuid"
            java.lang.String r13 = r12.optString(r13)     // Catch:{ Exception -> 0x031b }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x031b }
            java.lang.String r15 = ""
            if (r14 != 0) goto L_0x007d
            com.baidu.wallet.lightapp.base.b r14 = new com.baidu.wallet.lightapp.base.b     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.LightappWebView r2 = r1.h     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "window.onBDWalletCallbackProxy && window.onBDWalletCallbackProxy"
            r14.<init>(r2, r3, r15)     // Catch:{ Exception -> 0x031b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r2.<init>()     // Catch:{ Exception -> 0x031b }
            r2.append(r6)     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = com.baidu.wallet.lightapp.base.utils.LightappUtils.formatJSONForWebViewCallback(r13)     // Catch:{ Exception -> 0x031b }
            r2.append(r3)     // Catch:{ Exception -> 0x031b }
            r2.append(r6)     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x031b }
            r14.a((java.lang.String) r2)     // Catch:{ Exception -> 0x031b }
        L_0x007d:
            java.lang.Object r2 = r12.get(r8)     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x031b }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x031b }
            if (r3 == 0) goto L_0x008a
            return
        L_0x008a:
            java.lang.String r3 = r12.optString(r7)     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = r1.g     // Catch:{ Exception -> 0x031b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x031b }
            java.lang.String r14 = "#DifferentFromURL"
            r16 = 0
            if (r6 != 0) goto L_0x00cc
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x00cc
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x031b }
            java.lang.String r13 = r1.g     // Catch:{ Exception -> 0x031b }
            r6.<init>(r13)     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = r6.getHost()     // Catch:{ Exception -> 0x031b }
            java.net.URL r13 = new java.net.URL     // Catch:{ Exception -> 0x031b }
            r13.<init>(r3)     // Catch:{ Exception -> 0x031b }
            java.lang.String r13 = r13.getHost()     // Catch:{ Exception -> 0x031b }
            boolean r6 = android.text.TextUtils.equals(r6, r13)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x00f9
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x031b }
            java.lang.String r13 = r1.g     // Catch:{ Exception -> 0x031b }
            r6[r16] = r13     // Catch:{ Exception -> 0x031b }
            r13 = 1
            r6[r13] = r3     // Catch:{ Exception -> 0x031b }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r14, r6)     // Catch:{ Exception -> 0x031b }
            goto L_0x00f9
        L_0x00cc:
            java.lang.String r6 = r1.g     // Catch:{ Exception -> 0x031b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x00da
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x00e8
        L_0x00da:
            java.lang.String r6 = r1.g     // Catch:{ Exception -> 0x031b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x00f9
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x00f9
        L_0x00e8:
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x031b }
            java.lang.String r13 = r1.g     // Catch:{ Exception -> 0x031b }
            r6[r16] = r13     // Catch:{ Exception -> 0x031b }
            r13 = 1
            r6[r13] = r3     // Catch:{ Exception -> 0x031b }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r14, r6)     // Catch:{ Exception -> 0x031b }
        L_0x00f9:
            java.lang.String r6 = "1"
            com.baidu.wallet.paysdk.datamodel.SdkInitResponse r13 = com.baidu.wallet.paysdk.datamodel.SdkInitResponse.getInstance()     // Catch:{ Exception -> 0x031b }
            java.lang.String r13 = r13.langbridgeSafeCheckFromURL     // Catch:{ Exception -> 0x031b }
            boolean r6 = android.text.TextUtils.equals(r6, r13)     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x0118
            java.lang.String r6 = r1.f     // Catch:{ Exception -> 0x031b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x0120
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x0120
            r1.f = r3     // Catch:{ Exception -> 0x031b }
            goto L_0x0120
        L_0x0118:
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x0120
            r1.f = r3     // Catch:{ Exception -> 0x031b }
        L_0x0120:
            java.lang.String r3 = r1.f     // Catch:{ Exception -> 0x031b }
            r12.put(r7, r3)     // Catch:{ Exception -> 0x031b }
            boolean r3 = r1.j     // Catch:{ Exception -> 0x031b }
            if (r3 == 0) goto L_0x012a
            return
        L_0x012a:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x031b }
            r3.<init>(r0)     // Catch:{ Exception -> 0x031b }
            r3.remove(r8)     // Catch:{ Exception -> 0x0185 }
            int r6 = r3.length()     // Catch:{ Exception -> 0x0185 }
            if (r6 <= 0) goto L_0x0185
            java.lang.String r6 = "callAutomatedSubmission"
            boolean r6 = r6.equals(r2)     // Catch:{ Exception -> 0x0180 }
            if (r6 == 0) goto L_0x0180
            boolean r6 = r3.has(r11)     // Catch:{ Exception -> 0x0180 }
            if (r6 == 0) goto L_0x0180
            java.lang.String r6 = r3.getString(r11)     // Catch:{ Exception -> 0x0180 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0180 }
            if (r7 != 0) goto L_0x0180
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0180 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0180 }
            boolean r6 = r7.has(r10)     // Catch:{ Exception -> 0x0180 }
            java.lang.String r8 = "******"
            if (r6 == 0) goto L_0x016a
            java.lang.String r6 = r7.getString(r10)     // Catch:{ Exception -> 0x0180 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0180 }
            if (r6 != 0) goto L_0x016a
            r7.put(r10, r8)     // Catch:{ Exception -> 0x0180 }
        L_0x016a:
            boolean r6 = r7.has(r9)     // Catch:{ Exception -> 0x0180 }
            if (r6 == 0) goto L_0x017d
            java.lang.String r6 = r7.getString(r9)     // Catch:{ Exception -> 0x0180 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0180 }
            if (r6 != 0) goto L_0x017d
            r7.put(r9, r8)     // Catch:{ Exception -> 0x0180 }
        L_0x017d:
            r3.put(r11, r7)     // Catch:{ Exception -> 0x0180 }
        L_0x0180:
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0185 }
            goto L_0x0186
        L_0x0185:
            r3 = r15
        L_0x0186:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x031b }
            r6.<init>()     // Catch:{ Exception -> 0x031b }
            java.lang.String r7 = r1.f     // Catch:{ Exception -> 0x031b }
            java.lang.String r7 = com.baidu.apollon.utils.CheckUtils.stripUrlParams(r7)     // Catch:{ Exception -> 0x031b }
            r6.add(r7)     // Catch:{ Exception -> 0x031b }
            r6.add(r2)     // Catch:{ Exception -> 0x031b }
            r6.add(r3)     // Catch:{ Exception -> 0x031b }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x031b }
            r3.<init>()     // Catch:{ Exception -> 0x031b }
            java.lang.String r7 = "invokeBdWalletNative"
            r3.append(r7)     // Catch:{ Exception -> 0x031b }
            r3.append(r5)     // Catch:{ Exception -> 0x031b }
            r3.append(r2)     // Catch:{ Exception -> 0x031b }
            java.lang.String r7 = "gotoDXMPayService"
            boolean r7 = android.text.TextUtils.equals(r7, r2)     // Catch:{ Exception -> 0x031b }
            if (r7 == 0) goto L_0x01c5
            boolean r7 = r12.has(r4)     // Catch:{ Exception -> 0x031b }
            if (r7 == 0) goto L_0x01bf
            java.lang.Object r4 = r12.get(r4)     // Catch:{ Exception -> 0x031b }
            r15 = r4
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x031b }
        L_0x01bf:
            r3.append(r5)     // Catch:{ Exception -> 0x031b }
            r3.append(r15)     // Catch:{ Exception -> 0x031b }
        L_0x01c5:
            com.baidu.wallet.utils.LbAbilityNewWayUtils.generateCallbackKey(r3, r2)     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.b r4 = new com.baidu.wallet.lightapp.base.b     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.LightappWebView r5 = r1.h     // Catch:{ Exception -> 0x031b }
            r7 = r19
            r8 = r20
            r4.<init>(r5, r7, r8)     // Catch:{ Exception -> 0x031b }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.wallet.lightapp.base.b> r5 = r1.c     // Catch:{ Exception -> 0x031b }
            java.lang.String r7 = "#invokeBdWalletNative"
            if (r5 == 0) goto L_0x01e9
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.wallet.lightapp.base.b> r5 = r1.c     // Catch:{ Exception -> 0x031b }
            boolean r5 = r5.containsKey(r3)     // Catch:{ Exception -> 0x031b }
            if (r5 != 0) goto L_0x01e9
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r7, r6)     // Catch:{ Exception -> 0x031b }
            goto L_0x0224
        L_0x01e9:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.wallet.lightapp.base.b> r5 = r1.c     // Catch:{ Exception -> 0x031b }
            if (r5 != 0) goto L_0x01f3
            java.lang.String r5 = "mJsCallbacks is null"
            r6.add(r5)     // Catch:{ Exception -> 0x031b }
            goto L_0x0221
        L_0x01f3:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x031b }
            if (r5 == 0) goto L_0x01ff
            java.lang.String r5 = "callBackKey is null"
            r6.add(r5)     // Catch:{ Exception -> 0x031b }
            goto L_0x0221
        L_0x01ff:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.wallet.lightapp.base.b> r5 = r1.c     // Catch:{ Exception -> 0x031b }
            boolean r5 = r5.containsKey(r3)     // Catch:{ Exception -> 0x031b }
            if (r5 == 0) goto L_0x021c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r5.<init>()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = "mJsCallbacks containsKey: "
            r5.append(r8)     // Catch:{ Exception -> 0x031b }
            r5.append(r3)     // Catch:{ Exception -> 0x031b }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x031b }
            r6.add(r5)     // Catch:{ Exception -> 0x031b }
            goto L_0x0221
        L_0x021c:
            java.lang.String r5 = "调用异常"
            r6.add(r5)     // Catch:{ Exception -> 0x031b }
        L_0x0221:
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r7, r6)     // Catch:{ Exception -> 0x031b }
        L_0x0224:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.wallet.lightapp.base.b> r5 = r1.c     // Catch:{ Exception -> 0x031b }
            r5.put(r3, r4)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.LightappJsClient$LightappInvokerCallbackImpl r4 = new com.baidu.wallet.lightapp.base.LightappJsClient$LightappInvokerCallbackImpl     // Catch:{ Exception -> 0x031b }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.wallet.lightapp.base.b> r5 = r1.c     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.business.LightappBusinessClient r7 = r1.d     // Catch:{ Exception -> 0x031b }
            r4.<init>(r5, r3, r6, r7)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.multipage.a r3 = r1.f3558i     // Catch:{ Exception -> 0x031b }
            boolean r3 = r3.isActiveCell()     // Catch:{ Exception -> 0x031b }
            if (r3 != 0) goto L_0x0267
            java.util.Set r3 = r17.getAllowCalledOnBackgroundMethodlist()     // Catch:{ Exception -> 0x031b }
            if (r3 == 0) goto L_0x024c
            boolean r5 = r3.isEmpty()     // Catch:{ Exception -> 0x031b }
            if (r5 != 0) goto L_0x024c
            boolean r3 = r3.contains(r2)     // Catch:{ Exception -> 0x031b }
            if (r3 != 0) goto L_0x0267
        L_0x024c:
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel r0 = new com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel     // Catch:{ Exception -> 0x031b }
            r2 = 1
            r0.<init>(r2)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel$Data r2 = r0.cnt     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "20001"
            r2.errCode = r3     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel$Data r2 = r0.cnt     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "多webview框架下该端能力不允许后台调用"
            r2.des = r3     // Catch:{ Exception -> 0x031b }
            java.lang.String r0 = r0.toJson()     // Catch:{ Exception -> 0x031b }
            r2 = 1
            r4.onResult(r2, r0)     // Catch:{ Exception -> 0x031b }
            return
        L_0x0267:
            boolean r3 = r1.a(r2, r0)     // Catch:{ Exception -> 0x031b }
            java.lang.String r5 = "10003"
            if (r3 == 0) goto L_0x029a
            com.baidu.wallet.lightapp.business.LightappBusinessClient r0 = r1.d     // Catch:{ Exception -> 0x031b }
            if (r0 == 0) goto L_0x0281
            com.baidu.wallet.lightapp.business.LightappBusinessClient r0 = r1.d     // Catch:{ Exception -> 0x031b }
            android.content.Context r2 = r17.a()     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = r12.toString()     // Catch:{ Exception -> 0x031b }
            r0.lightappInvoke(r2, r3, r4)     // Catch:{ Exception -> 0x031b }
            goto L_0x0299
        L_0x0281:
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel r0 = new com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel     // Catch:{ Exception -> 0x031b }
            r2 = 1
            r0.<init>(r2)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel$Data r2 = r0.cnt     // Catch:{ Exception -> 0x031b }
            r2.errCode = r5     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel$Data r2 = r0.cnt     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "没有找到对应的方法, mLightappBusiness is null"
            r2.des = r3     // Catch:{ Exception -> 0x031b }
            java.lang.String r0 = r0.toJson()     // Catch:{ Exception -> 0x031b }
            r2 = 1
            r4.onResult(r2, r0)     // Catch:{ Exception -> 0x031b }
        L_0x0299:
            return
        L_0x029a:
            boolean r3 = r1.b(r2, r0)     // Catch:{ Exception -> 0x031b }
            if (r3 == 0) goto L_0x02cb
            com.baidu.wallet.lightapp.base.LightappJsNativeClient r0 = r1.e     // Catch:{ Exception -> 0x031b }
            if (r0 == 0) goto L_0x02b2
            com.baidu.wallet.lightapp.base.LightappJsNativeClient r0 = r1.e     // Catch:{ Exception -> 0x031b }
            android.content.Context r2 = r17.a()     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = r12.toString()     // Catch:{ Exception -> 0x031b }
            r0.lightappInvoke(r2, r3, r4)     // Catch:{ Exception -> 0x031b }
            goto L_0x02ca
        L_0x02b2:
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel r0 = new com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel     // Catch:{ Exception -> 0x031b }
            r2 = 1
            r0.<init>(r2)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel$Data r2 = r0.cnt     // Catch:{ Exception -> 0x031b }
            r2.errCode = r5     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel$Data r2 = r0.cnt     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "没有找到对应的方法, mLightappNative is null"
            r2.des = r3     // Catch:{ Exception -> 0x031b }
            java.lang.String r0 = r0.toJson()     // Catch:{ Exception -> 0x031b }
            r2 = 1
            r4.onResult(r2, r0)     // Catch:{ Exception -> 0x031b }
        L_0x02ca:
            return
        L_0x02cb:
            boolean r0 = r1.c(r2, r0)     // Catch:{ Exception -> 0x031b }
            if (r0 == 0) goto L_0x0300
            java.lang.String r0 = "method_implemented_by_app"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x031b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r5.<init>()     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = "#"
            r5.append(r6)     // Catch:{ Exception -> 0x031b }
            r5.append(r2)     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x031b }
            r3[r16] = r2     // Catch:{ Exception -> 0x031b }
            java.util.List r2 = java.util.Arrays.asList(r3)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r0, r2)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.LightAppWrapper r0 = com.baidu.wallet.lightapp.base.LightAppWrapper.getInstance()     // Catch:{ Exception -> 0x031b }
            android.content.Context r2 = r17.a()     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = r12.toString()     // Catch:{ Exception -> 0x031b }
            r0.lightappInvoke(r2, r3, r4)     // Catch:{ Exception -> 0x031b }
            return
        L_0x0300:
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel r0 = new com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel     // Catch:{ Exception -> 0x031b }
            r2 = 1
            r0.<init>(r2)     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel$Data r2 = r0.cnt     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "10004"
            r2.errCode = r3     // Catch:{ Exception -> 0x031b }
            com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel$Data r2 = r0.cnt     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "没有找到对应的方法"
            r2.des = r3     // Catch:{ Exception -> 0x031b }
            java.lang.String r0 = r0.toJson()     // Catch:{ Exception -> 0x031b }
            r2 = 1
            r4.onResult(r2, r0)     // Catch:{ Exception -> 0x031b }
            goto L_0x031f
        L_0x031b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x031f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.base.LightappJsClient.invokeBdWalletNative(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void onCallCameraPicCallbackLocal() {
        LightappJsNativeClient lightappJsNativeClient = this.e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.onCallCameraPicCallback();
        }
    }

    public void onContactsSelectedLocal(int i2, String[] strArr, String str) {
        LightappJsNativeClient lightappJsNativeClient = this.e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.onContactsSelected(this.f, i2, strArr, str);
        }
    }

    public void onFileFetchDone(int i2, int i3, Intent intent) {
        LightappJsNativeClient lightappJsNativeClient = this.e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.onFileFetchDone(i2, i3, intent);
        }
    }

    public void onInsertCalendarEventDone(boolean z) {
        LightappJsNativeClient lightappJsNativeClient = this.e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.handleInsertEventDone(z);
        }
    }

    public void onRequestPermissionsResultLocal(int i2, String[] strArr, int[] iArr) {
        LightappJsNativeClient lightappJsNativeClient = this.e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.onRequestPermissionsResult(this.f, i2, strArr, iArr);
        }
    }

    @JavascriptInterface
    public void selectPhonefromAdressBook(String str, String str2, String str3) {
        a("selectPhonefromAdressBook", str, str2, str3);
    }

    @JavascriptInterface
    public String sessionCommand(String str, String str2, String str3) {
        a aVar = this.f3558i;
        if (aVar == null) {
            return "";
        }
        return aVar.exeSSCommand(str, str2, str3);
    }

    public void setUrlLocal(String str) {
        this.f = str;
        this.g = str;
    }

    @JavascriptInterface
    public void testInvoke() {
        LogUtil.i("LightappJsClient", "testInvoke");
        DXMSdkSAUtils.onEvent("testInvoke");
    }

    @JavascriptInterface
    public void getCurrentPosition(String str, String str2, String str3) {
        a(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, str, str2, str3);
    }

    private boolean a(String str, String str2) {
        LightappBusinessClient lightappBusinessClient;
        Set<String> methodList;
        if (!TextUtils.isEmpty(str) && (lightappBusinessClient = this.d) != null && (methodList = lightappBusinessClient.getMethodList()) != null && methodList.size() >= 1) {
            return methodList.contains(str);
        }
        return false;
    }

    private void a(String str, String str2, String str3, String str4) {
        if (this.d != null) {
            JSONObject jSONObject = null;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject = new JSONObject(str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            jSONObject.put(LightappConstants.LIGHT_APP_NATIVE_INVOKER_METHOD_NAME, str);
            if (jSONObject != null) {
                invokeBdWalletNative(jSONObject.toString(), str3, str4);
            }
        }
    }
}
