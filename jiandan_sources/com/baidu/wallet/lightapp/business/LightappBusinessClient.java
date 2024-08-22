package com.baidu.wallet.lightapp.business;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.aiscan.R;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.restnet.http.b;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.Crypto;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.EncodeUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.pass.permissions.PermissionsHelperActivity;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.audio.AudioRecorder;
import com.baidu.wallet.base.audio.AudioVolume;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.dialog.PromptTipDialog;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.FileFetchManager;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.DangerousPermissionUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.SecurityUtils;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.lightapp.base.JavascriptInterfaceManager;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger;
import com.baidu.wallet.lightapp.base.datamodel.LightAppContactSelectModelBase64;
import com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppTakePictureModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.TitleBarParams;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCallIDPhotoModel;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCallQRCodeScannerModel;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCommonModel;
import com.baidu.wallet.lightapp.business.datamodel.LightAppDetectBankcardModel;
import com.baidu.wallet.lightapp.business.datamodel.LightAppUserAgentModel;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.livenessidentifyauth.DXMBioRecogSDK;
import com.baidu.wallet.livenessidentifyauth.api.DXMFaceLivenessCallback;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.permission.CommonPermissionCallback;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.ImageBase64Utils;
import com.baidu.wallet.utils.NetUtils;
import com.baidu.wallet.utils.StringUtil;
import com.baidu.wallet.utils.compress.VideoBase64Utils;
import com.baidu.wallet.utils.compress.VideoCompressUtils;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.security.AccessControlException;
import java.security.DigestException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class LightappBusinessClient implements ILightappInvoker, com.baidu.wallet.lightapp.business.presenter.b {
    public static final String ACCEPT_MESSAGE_CB = "accept";
    public static int B = 1;
    public static final String CALL_NATIVE_VOICE = "callNativeVoice";
    public static final String CANCEL_ACTION = "取消";
    public static final int CONTACTS_REQUESTCODE = 4;
    public static final int FIXED_CONTACT_SIZE = 1000;
    public static final int FIXED_IMAGE_WIDTH = 640;
    public static final String H5BanlanceCallback = "H5Balance";
    public static int JPEG_QUALITY = 70;
    public static final int JS_CALL_CAMERA = 3;
    public static final int JS_CALL_SELECT_ADDRESS_BOOK = 3;
    public static final int JS_DOPAY = 2;
    public static final int JS_INITPAY = 1;
    public static final String KeyH5CallTime = "H5CallTime";
    public static final String METHOD_ACCESS_WALLET_SERVICE = "accessWalletService";
    public static final String METHOD_BD_LOGIN = "bdLogin";
    public static final String METHOD_CALL_CAMERA = "callCamera";
    public static final String METHOD_CALL_ID_PHOTOS = "callIDPotos";
    public static final String METHOD_CALL_QRCODE_SCANNER = "callQRCodeScanner";
    public static final String METHOD_DETECT_BANKCARD = "detectBankCard";
    public static final String METHOD_DETECT_LIVENESS = "faceRegister";
    public static final String METHOD_DO_BIND_CARD = "doBindCard";
    public static final String METHOD_DO_PAY = "dopay";
    public static final String METHOD_DO_RN_AUTH = "doRnAuth";
    public static final String METHOD_GET_SUPPORT_LIVENESS = "getSupportLiveness";
    public static final String METHOD_GET_USER_AGENT = "getUserAgent";
    public static final String METHOD_IDENTIFY_AUTH = "identifyAuth";
    public static final String METHOD_INIT_PAY = "initpay";
    public static final String METHOD_POST_EVENT = "postEvent";
    public static final String METHOD_SET_RN_AUTH_RUSULT = "setRnAuthResult";
    public static final String MTD_ACCEPT_MESSAGE_FROM_LANGBRIDGE = "acceptMessageFromLangBridge";
    public static final String MTD_BINDCARD_INDEPENDENT = "bindCardIndependent";
    public static final String MTD_BINDCARD_INITIATIVE = "bindCardInitiative";
    public static final String MTD_CALLPHONEINFO = "callPhoneInfo";
    public static final String MTD_CALL_AUTOMATED_SUBMISSION = "callAutomatedSubmission";
    public static final String MTD_CALL_NATIVE_PHOTO = "callNativePhoto";
    public static final String MTD_CUSTOMER_SERVICE = "customerService";
    public static final String MTD_CUSTOM_RIGHT_BUTTON = "customRightButton";
    public static final String MTD_DECRYPT = "decrypt";
    public static final String MTD_DIGEST = "digest";
    public static final String MTD_ENCRYPT = "encrypt";
    public static final String MTD_END_AUDIO_RECORD = "endRecording";
    public static final String MTD_GET_LOAD_TIME_LINE = "getLoadTimeLine";
    public static final String MTD_GET_OFFLINE_INFO = "getOfflineCacheInfo";
    public static final String MTD_GET_PERMISSIOM_DIALOG_MSG = "getPermissionDialogDescription";
    public static final String MTD_GET_PERMISSION_STATE = "getPermissionState";
    public static final String MTD_GET_SUPPORT_LIST = "getSupportedMethodList";
    public static final String MTD_GOTO_DXM_PAY_SERVICE = "gotoDXMPayService";
    public static final String MTD_GO_TO_APP_SETTING = "goToAppSetting";
    public static final String MTD_H5ClOSE = "onBDWalletPageClose";
    public static final String MTD_H5GOBCK = "onBDWalletPageGoBack";
    public static final String MTD_H5REFRESH = "onBDWalletPageRefresh";
    public static final String MTD_INSERT_PHONE_NUM_TO_ADDRESS_BOOK = "insertPhoneNumToAddressBook";
    public static final String MTD_LIST_MY_BANK_CARD = "listMyBankCard";
    public static final String MTD_MESSAGE_FORWARDING = "messageForwarding";
    public static final String MTD_OPEN_IN_BROWSER = "openInBrowser";
    public static final String MTD_OPEN_NEW_LIGHT_BRIDGE = "openInNewLightBridge";
    public static final String MTD_PERMISSION_UNIVERSAL_SET = "permissionUniversalSet";
    public static final String MTD_PRECASHIER_GET_DEFAULT_PAY_METHOD = "getPayMethod";
    public static final String MTD_PRECASHIER_MODIFY_PAY_METHOD = "changePayMethod";
    public static final String MTD_PRECASHIER_ORDER_PAY_METHOD = "preOrderPay";
    public static final String MTD_RPA_PERCEPTIONL = "rpaPerception";
    public static final String MTD_SAVE_PIC = "savePic";
    public static final String MTD_SELECT_PHONE_FROM_ADRESSBOOK = "selectPhonefromAdressBook";
    public static final String MTD_SEND_TO_SMS = "sendToSMS";
    public static final String MTD_SETMENU = "setMenu";
    public static final String MTD_SETSUBMENU = "setSubMenu";
    public static final String MTD_SETTITLE = "setTitle";
    public static final String MTD_SET_FULLSCREEN = "setFullScreen";
    public static final String MTD_SET_LIGHT_BRIDGE_STYLE = "setHalfLightBridgeStyle";
    public static final String MTD_SET_SCREEN_VERTICAL = "setScreenVertical";
    public static final String MTD_SHOW_TITLE_FLOATVIEW = "showTitleFloatView";
    public static final String MTD_START_AUDIO_RECORD = "startRecording";
    public static final String MTD_STATEVENT = "doEvent";
    public static final String MTD_UNREGISTER_H5_CLOSE = "unregisterOnBDWalletPageClose";
    public static final String MTD_UNREGISTER_H5_GO_BACK = "unregisterOnBDWalletPageGoBack";
    public static final String MTD_UNREGISTER_H5_REFRESH = "unregisterOnBDWalletPageRefresh";
    public static final String MTD_UNREGISTER_MESSAGE_FROM_LANGBRIDGE = "unregisterAcceptMessageFromLangBridge";
    public static final String MTD_UPLOAD_MSG = "uploadMsg";
    public static final int REQUEST_INSERT_CONTACTS = 8;
    public static final int REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE = 245;
    public static final int REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_SENSE = 246;
    public static final int REQUEST_PERMISSION_RECORDAUDIO = 244;
    public static final int REQUEST_PERMISSION_SAVE_PIC = 248;
    public static final int REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK = 243;
    public static final int REQUEST_PERMISSION_UNIVERSAL_SET = 247;
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_INNER_ERROR = 3;
    public static final int RESULT_LOAD_IMAGE = 5;
    public static final int RESULT_NO_PERMISSION = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final String ROOT = "isBreak";
    public static final long SVC_ID_H5_BALANCE = 10002;
    public static final long SVC_ID_H5_CASHBACK = 10007;
    public static final long SVC_ID_H5_CHARGE = 10008;
    public static final long SVC_ID_H5_CHECKPWD = 10013;
    public static final long SVC_ID_H5_COUPON = 10004;
    public static final long SVC_ID_H5_HOMEPAGE = 10001;
    public static final long SVC_ID_H5_MYBANKCARD = 10005;
    public static final long SVC_ID_H5_PAY_SET = 10014;
    public static final long SVC_ID_H5_PWD_SET = 10015;
    public static final long SVC_ID_H5_QRGEN = 10011;
    public static final long SVC_ID_H5_SCANQR = 10010;
    public static final long SVC_ID_H5_SECURITCENTER = 10006;
    public static final long SVC_ID_H5_TRANSERECORD = 10003;
    public static final long SVC_ID_H5_TRANSFER = 10009;
    public static final String WCP = "H5_PWD_WCP";
    public static String a = null;
    public static int c = 1;
    public static int d = 1;
    public static int r = -1;
    public static int s = -1;
    public static int t = -1;
    public static String u = null;
    public static int v = 1;
    public static int w = 2;
    public final HashMap<String, ILightappInvokerCallback> A = new HashMap<>();
    public com.baidu.wallet.lightapp.multipage.a C;
    public ILightappInvokerCallback D = null;
    public ILightappInvokerCallback E = null;
    public ILightappInvokerCallback F = null;
    public HandlerThread G;
    public Handler H = null;
    public HashMap<String, b> I = null;
    public String J;
    public CommonPermissionCallback K;
    public JSONObject L = null;
    public String M = null;
    public String b = LightappBusinessClient.class.getSimpleName();
    public boolean e = false;
    public Class<?> f;
    public Method g;
    public Class<?> h;

    /* renamed from: i  reason: collision with root package name */
    public Class<?> f3568i;
    public Method j;
    public Class<?> k;
    public Class<?> l;
    public Method m;
    public Class<?> n;

    /* renamed from: o  reason: collision with root package name */
    public String f3569o;
    public ILightappInvokerCallback p;
    public String q;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;

    public class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public ILightappInvokerCallback e;
        public String f;
        public String g;
        public String h;

        public a() {
        }
    }

    public class b {
        public Context a;
        public String b;
        public ILightappInvokerCallback c;
        public String d;

        public b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
            this.a = context;
            this.b = str;
            this.c = iLightappInvokerCallback;
            this.d = str2;
        }
    }

    public static class c implements InvocationHandler {
        public ILightappInvokerCallback a;

        public c(ILightappInvokerCallback iLightappInvokerCallback) {
            this.a = iLightappInvokerCallback;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (this.a == null) {
                return null;
            }
            if (!"onResult".equals(method.getName())) {
                return method.invoke(this.a, objArr);
            }
            if (objArr != null && objArr.length >= 2) {
                this.a.onResult(objArr[0].intValue(), objArr[1]);
            }
            return null;
        }
    }

    public LightappBusinessClient(com.baidu.wallet.lightapp.multipage.a aVar) {
        this.C = aVar;
        HandlerThread handlerThread = new HandlerThread("LangbridgeThread");
        this.G = handlerThread;
        handlerThread.start();
        this.H = new Handler(this.G.getLooper()) {
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (1 == i2) {
                    LightappBusinessClient.this.a((a) message.obj);
                } else if (2 == i2) {
                    LightappBusinessClient.this.b((a) message.obj);
                }
            }
        };
    }

    private void A(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        DXMSdkSAUtils.onEventWithValues(MTD_H5ClOSE, Arrays.asList(new String[]{CheckUtils.stripUrlParams(str2)}));
        setH5Close(iLightappInvokerCallback);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|20|21|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x009e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void B(android.content.Context r20, java.lang.String r21, com.baidu.wallet.api.ILightappInvokerCallback r22, java.lang.String r23) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r22
            java.lang.String r3 = "all"
            java.lang.String r4 = "des"
            java.lang.String r5 = "errCode"
            java.lang.String r6 = "data"
            if (r2 != 0) goto L_0x0011
            return
        L_0x0011:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            r8 = 0
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c4 }
            r10 = r21
            r9.<init>(r10)     // Catch:{ Exception -> 0x00c4 }
            boolean r10 = r9.has(r3)     // Catch:{ Exception -> 0x00c4 }
            if (r10 == 0) goto L_0x005d
            java.lang.String r10 = "true"
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x00c4 }
            boolean r3 = r10.equals(r3)     // Catch:{ Exception -> 0x00c4 }
            if (r3 == 0) goto L_0x005d
            r3 = 10
            java.lang.String r9 = "screenWidth"
            java.lang.String r10 = "screenHeight"
            java.lang.String r11 = "walletUserAgent"
            java.lang.String r12 = "cuid"
            java.lang.String r13 = "BAIDUCUID"
            java.lang.String r14 = "location"
            java.lang.String r15 = "localIp"
            java.lang.String r16 = "wifi"
            java.lang.String r17 = "H5_PWD_WCP"
            java.lang.String r18 = "isBreak"
            java.lang.String[] r9 = new java.lang.String[]{r9, r10, r11, r12, r13, r14, r15, r16, r17, r18}     // Catch:{ Exception -> 0x00c4 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c4 }
            r10.<init>()     // Catch:{ Exception -> 0x00c4 }
            r11 = 0
        L_0x0050:
            if (r11 >= r3) goto L_0x005c
            r12 = r9[r11]     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r13 = "1"
            r10.put(r12, r13)     // Catch:{ Exception -> 0x00c4 }
            int r11 = r11 + 1
            goto L_0x0050
        L_0x005c:
            r9 = r10
        L_0x005d:
            org.json.JSONObject r3 = r1.a((android.content.Context) r0, (org.json.JSONObject) r9)     // Catch:{ Exception -> 0x00c4 }
            r1.L = r3     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r3 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r9 = "baiduapp"
            boolean r3 = r3.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r9 = "ok"
            if (r3 != 0) goto L_0x0095
            org.json.JSONObject r0 = r1.L     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c4 }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r0 = com.baidu.apollon.utils.Base64Utils.encodeToString(r0)     // Catch:{ Exception -> 0x00c4 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c4 }
            r3.<init>()     // Catch:{ Exception -> 0x00c4 }
            r3.put(r6, r0)     // Catch:{ Exception -> 0x00c4 }
            r3.put(r5, r8)     // Catch:{ Exception -> 0x00c4 }
            r3.put(r4, r9)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r0 = com.baidu.wallet.lightapp.base.utils.LightappUtils.assembleResult((int) r8, (org.json.JSONObject) r3)     // Catch:{ Exception -> 0x00c4 }
            r1.M = r0     // Catch:{ Exception -> 0x00c4 }
            r2.onResult(r8, r0)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x010a
        L_0x0095:
            com.baidu.wallet.lightapp.business.LightappBusinessClient$15 r3 = new com.baidu.wallet.lightapp.business.LightappBusinessClient$15     // Catch:{ Exception -> 0x009e }
            r3.<init>(r2)     // Catch:{ Exception -> 0x009e }
            com.baidu.wallet.core.utils.LocationUtils.getLocationIp(r0, r3)     // Catch:{ Exception -> 0x009e }
            goto L_0x010a
        L_0x009e:
            org.json.JSONObject r0 = r1.L     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c4 }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r0 = com.baidu.apollon.utils.Base64Utils.encodeToString(r0)     // Catch:{ Exception -> 0x00c4 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c4 }
            r3.<init>()     // Catch:{ Exception -> 0x00c4 }
            r3.put(r6, r0)     // Catch:{ Exception -> 0x00c4 }
            r3.put(r5, r8)     // Catch:{ Exception -> 0x00c4 }
            r3.put(r4, r9)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r0 = com.baidu.wallet.lightapp.base.utils.LightappUtils.assembleResult((int) r8, (org.json.JSONObject) r3)     // Catch:{ Exception -> 0x00c4 }
            r1.M = r0     // Catch:{ Exception -> 0x00c4 }
            r2.onResult(r8, r0)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x010a
        L_0x00c4:
            r0 = move-exception
            r3 = 1
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fc }
            r9.<init>()     // Catch:{ Exception -> 0x00fc }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00fc }
            byte[] r9 = r9.getBytes()     // Catch:{ Exception -> 0x00fc }
            java.lang.String r9 = com.baidu.apollon.utils.Base64Utils.encodeToString(r9)     // Catch:{ Exception -> 0x00fc }
            r7.put(r6, r9)     // Catch:{ Exception -> 0x00fc }
            r7.put(r5, r3)     // Catch:{ Exception -> 0x00fc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fc }
            r5.<init>()     // Catch:{ Exception -> 0x00fc }
            java.lang.String r6 = "exception."
            r5.append(r6)     // Catch:{ Exception -> 0x00fc }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x00fc }
            r5.append(r0)     // Catch:{ Exception -> 0x00fc }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x00fc }
            r7.put(r4, r0)     // Catch:{ Exception -> 0x00fc }
            java.lang.String r0 = com.baidu.wallet.lightapp.base.utils.LightappUtils.assembleResult((int) r3, (org.json.JSONObject) r7)     // Catch:{ Exception -> 0x00fc }
            r1.M = r0     // Catch:{ Exception -> 0x00fc }
            goto L_0x00fd
        L_0x00fc:
            r8 = 1
        L_0x00fd:
            if (r8 == 0) goto L_0x0105
            java.lang.String r0 = com.baidu.wallet.lightapp.base.utils.LightappUtils.assembleResult((int) r3, (org.json.JSONObject) r7)
            r1.M = r0
        L_0x0105:
            java.lang.String r0 = r1.M
            r2.onResult(r3, r0)
        L_0x010a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.LightappBusinessClient.B(android.content.Context, java.lang.String, com.baidu.wallet.api.ILightappInvokerCallback, java.lang.String):void");
    }

    private void C(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3 = this.b;
        LogUtil.d(str3, "callNativePhoto options = " + str);
        if (str == null || !str.contains("multipleMaxCount")) {
            D(context, str, iLightappInvokerCallback, str2);
        } else {
            E(context, str, iLightappInvokerCallback, str2);
        }
    }

    private void D(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        this.q = str;
        if (!PermissionManager.checkCallingPermission(this.C.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
            this.K = BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", this.C.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.C.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
                        return;
                    }
                    LightappBusinessClient.this.onRequestPermissionsResult(str2, 4, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new int[]{-1});
                }

                public void isShow(String str, Boolean bool) {
                }

                public void requestResult(String str, Boolean bool) {
                }
            });
        } else {
            this.C.loadAlubm(str);
        }
    }

    private void E(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        this.q = str;
        if (!PermissionManager.checkCallingPermission(this.C.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
            this.K = BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", this.C.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.C.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
                        return;
                    }
                    LightappBusinessClient.this.onRequestPermissionsResult(str2, 4, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new int[]{-1});
                }

                public void isShow(String str, Boolean bool) {
                }

                public void requestResult(String str, Boolean bool) {
                }
            });
        } else {
            a(context, str, str2);
        }
    }

    private void F(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("telephone_num");
                String optString2 = jSONObject.optString("sms_message");
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                    Intent intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("smsto:" + optString));
                    intent.putExtra("sms_body", optString2);
                    try {
                        context.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, "intent invalid", "#sendToSMSFail");
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "invalidate options", "#sendToSMSFail");
            }
        }
    }

    private void G(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            String permissionDialogDescription = DangerousPermissionUtils.getInstance().getPermissionDialogDescription(context, new JSONObject(str).optString("type"));
            if (TextUtils.isEmpty(permissionDialogDescription)) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "type invalidate", "#getPermissionDialogDescriptionFail");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", permissionDialogDescription);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "params invalidate", "#getPermissionDialogDescriptionFail");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void H(android.content.Context r6, java.lang.String r7, com.baidu.wallet.api.ILightappInvokerCallback r8, java.lang.String r9) {
        /*
            r5 = this;
            java.lang.String r9 = "#invokeBdWalletNativeFail"
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = 0
            r2 = 1
            java.lang.String r3 = "contacts"
            java.lang.String r4 = "android.permission.READ_CONTACTS"
            boolean r4 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r6, r4)     // Catch:{ JSONException -> 0x004f }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r3 = "location"
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r4 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r6, r4)     // Catch:{ JSONException -> 0x004f }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r3 = "camera"
            java.lang.String r4 = "android.permission.CAMERA"
            boolean r4 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r6, r4)     // Catch:{ JSONException -> 0x004f }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r3 = "audio"
            java.lang.String r4 = "android.permission.RECORD_AUDIO"
            boolean r4 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r6, r4)     // Catch:{ JSONException -> 0x004f }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r3 = "storage"
            java.lang.String r4 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r4 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r6, r4)     // Catch:{ JSONException -> 0x004f }
            if (r4 != 0) goto L_0x004a
            java.lang.String r4 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r6 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r6, r4)     // Catch:{ JSONException -> 0x004f }
            if (r6 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r6 = 0
            goto L_0x004b
        L_0x004a:
            r6 = 1
        L_0x004b:
            r0.put(r3, r6)     // Catch:{ JSONException -> 0x004f }
            goto L_0x006d
        L_0x004f:
            r6 = move-exception
            r6.printStackTrace()
            java.lang.String r3 = "permission check exception"
            r8.onResult(r2, r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r4.add(r7)
            java.lang.String r6 = r6.toString()
            r4.add(r6)
            r4.add(r3)
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r4)
        L_0x006d:
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            java.lang.String r3 = "errCode"
            r6.put(r3, r1)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r3 = "des"
            java.lang.String r4 = "成功"
            r6.put(r3, r4)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r3 = "permissions"
            r6.put(r3, r0)     // Catch:{ JSONException -> 0x0084 }
            goto L_0x00a2
        L_0x0084:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r3 = "permission put exception"
            r8.onResult(r2, r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r4.add(r7)
            java.lang.String r0 = r0.toString()
            r4.add(r0)
            r4.add(r3)
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r4)
        L_0x00a2:
            if (r8 == 0) goto L_0x00ac
            java.lang.String r6 = com.baidu.wallet.lightapp.base.utils.LightappUtils.assembleResult((int) r1, (org.json.JSONObject) r6)
            r8.onResult(r1, r6)
            goto L_0x00bf
        L_0x00ac:
            java.lang.String r6 = "callback is null"
            r8.onResult(r2, r6)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r8.add(r7)
            r8.add(r6)
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r8)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.LightappBusinessClient.H(android.content.Context, java.lang.String, com.baidu.wallet.api.ILightappInvokerCallback, java.lang.String):void");
    }

    private void I(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Context context2 = context;
        String str3 = str;
        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "uploadMsg, options: " + str3);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString("type");
                String str4 = "filename";
                String optString2 = jSONObject.optString("httpMethod", ShareTarget.METHOD_GET);
                String optString3 = jSONObject.optString("url");
                if (!TextUtils.isEmpty(optString)) {
                    String str5 = optString2;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    String str6 = "stack";
                    boolean equals = optString.equals("first_usable");
                    String str7 = UrlOcrConfig.IdCardKey.UUID;
                    String str8 = "message";
                    if (equals) {
                        linkedHashMap.put("url", optString3);
                        linkedHashMap.put("beforeFetchTime", jSONObject.optString("beforeFetchTime"));
                        linkedHashMap.put("navigateStartTime", jSONObject.optString("navigateStartTime"));
                        linkedHashMap.put("sslConnectTime", jSONObject.optString("sslConnectTime"));
                        linkedHashMap.put("connectTime", jSONObject.optString("connectTime"));
                        linkedHashMap.put("responseReceiveTime", jSONObject.optString("responseReceiveTime"));
                        linkedHashMap.put("responseTotalTime", jSONObject.optString("responseTotalTime"));
                        linkedHashMap.put("onLoadTime", jSONObject.optString("onLoadTime"));
                        linkedHashMap.put("referer", jSONObject.optString("referer"));
                        linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(optString3).toString());
                        Tracker.sendPerformanceInfoToSensors(optString, linkedHashMap, context2);
                    } else if (optString.equals("window_exception") || optString.equals("cross_origin_exception")) {
                        linkedHashMap.put("url", optString3);
                        String str9 = str8;
                        linkedHashMap.put(str9, jSONObject.optString(str9));
                        linkedHashMap.put("referer", jSONObject.optString("referer"));
                        String str10 = str7;
                        linkedHashMap.put(str10, jSONObject.optString(str10));
                        String str11 = str6;
                        linkedHashMap.put(str11, jSONObject.optString(str11));
                        String str12 = str4;
                        linkedHashMap.put(str12, jSONObject.optString(str12));
                        linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(optString3).toString());
                        try {
                            this.C.checkClodDown((String) linkedHashMap.get(str9), Arrays.asList(new String[]{optString3}), optString);
                            Tracker.send(optString, (Map<String, String>) linkedHashMap, context2, str5);
                            return;
                        } catch (JSONException e2) {
                            e = e2;
                        }
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e.getLocalizedMessage(), "#uploadMsgFail");
                return;
            }
        }
    }

    private void J(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (iLightappInvokerCallback != null) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPayService").action("enterDxmPayService").data("options", str), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 == 0) {
                        if (hashMap != null && hashMap.size() > 0) {
                            String str = (String) hashMap.get("result");
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    if (((Integer) new JSONObject(str).get("result")).intValue() == 0) {
                                        iLightappInvokerCallback.onResult(0, str);
                                    } else {
                                        iLightappInvokerCallback.onResult(1, str);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    iLightappInvokerCallback.onResult(1, "JsonException");
                                }
                            }
                        }
                    } else if (hashMap != null && hashMap.size() > 0) {
                        iLightappInvokerCallback.onResult(1, (String) hashMap.get("result"));
                    }
                }
            });
        }
    }

    private void K(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        String str3 = str2;
        if (this.C != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("icon_url");
                String optString2 = jSONObject.optString("callback");
                String optString3 = jSONObject.optString("bubble_text");
                String optString4 = jSONObject.optString("isolate", "0");
                int i2 = jSONObject.optInt("visibility", 1) == 0 ? 4 : 0;
                String optString5 = jSONObject.optString("bubble_url", "");
                int optInt = jSONObject.optInt("bubble_animation", 0);
                int i3 = jSONObject.optInt("bubble_visibility", 1) == 0 ? 4 : 0;
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    LightappUtils.onError(iLightappInvokerCallback2, str3, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数异常", "#setSubMenuFail");
                    return;
                }
                this.C.setSubMenu(optString, optString2, optString3, i2, optString4, optString5, i3, optInt);
                if (iLightappInvokerCallback2 != null) {
                    iLightappInvokerCallback2.onResult(0, LightappUtils.assembleResult((Map<String, Object>) new HashMap(), true));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback2, str3, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#setSubMenuFail");
            }
        }
    }

    private long a(long j2) {
        if (SVC_ID_H5_HOMEPAGE == j2) {
            return 16384;
        }
        if (SVC_ID_H5_BALANCE == j2) {
            return 32;
        }
        if (SVC_ID_H5_TRANSERECORD == j2) {
            return 16;
        }
        if (SVC_ID_H5_COUPON == j2) {
            return 64;
        }
        if (SVC_ID_H5_MYBANKCARD == j2) {
            return 4;
        }
        if (SVC_ID_H5_SECURITCENTER == j2) {
            return 8;
        }
        if (SVC_ID_H5_CASHBACK == j2) {
            return 8192;
        }
        if (SVC_ID_H5_CHARGE == j2) {
            return 1;
        }
        if (SVC_ID_H5_TRANSFER == j2) {
            return 2;
        }
        if (SVC_ID_H5_SCANQR == j2) {
            return 32768;
        }
        if (SVC_ID_H5_QRGEN == j2) {
            return 512;
        }
        if (10013 == j2) {
            return WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_CHECK;
        }
        if (SVC_ID_H5_PAY_SET == j2) {
            return WalletServiceBeanConst.SERVICE_ID_WALLET_PAY_SET;
        }
        if (SVC_ID_H5_PWD_SET == j2) {
            return WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_SET;
        }
        return -1;
    }

    private void g(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        a(MTD_SAVE_PIC, str);
        if (iLightappInvokerCallback != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                b(context, str, iLightappInvokerCallback);
            } else if (PermissionManager.checkCallingPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                b(context, str, iLightappInvokerCallback);
            } else {
                final Context context2 = context;
                final String str3 = str;
                final ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                final String str4 = str2;
                this.K = BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                    public void isAllAgree(Boolean bool) {
                        if (LightappBusinessClient.this.I == null) {
                            HashMap unused = LightappBusinessClient.this.I = new HashMap();
                        }
                        LightappBusinessClient.this.I.put(LightappBusinessClient.MTD_SAVE_PIC, new b(context2, str3, iLightappInvokerCallback2, str4));
                        if (!bool.booleanValue()) {
                            LightappBusinessClient.this.onRequestPermissionsResult(str4, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1});
                        } else if (!PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.C.getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC)) {
                            LightappUtils.onError(iLightappInvokerCallback2, "", "10002", "无储存权限", "");
                        }
                    }

                    public void isShow(String str, Boolean bool) {
                    }

                    public void requestResult(String str, Boolean bool) {
                    }
                });
            }
        }
    }

    private void h(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        a(MTD_SET_SCREEN_VERTICAL, str);
        if (iLightappInvokerCallback != null) {
            try {
                this.C.setScreenVertical(TextUtils.equals(new JSONObject(str).optString("isScreenVertical", ""), "1"));
                a(MTD_SET_SCREEN_VERTICAL, 0, LightappUtils.assembleResult(0, new JSONObject()));
            } catch (JSONException e2) {
                e2.printStackTrace();
                a(MTD_SET_SCREEN_VERTICAL, 1, LightappUtils.assembleFailResultWithErrCode(LightappConstants.ERRCODE_INVALID_PARAMETER, "参数解析失败"));
            }
        }
    }

    private void i(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        JSONObject jSONObject;
        try {
            String optString = ((JSONObject) new JSONTokener(str).nextValue()).optString("params", (String) null);
            if (optString != null) {
                jSONObject = (JSONObject) new JSONTokener(optString).nextValue();
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put("source_flag", 3);
            jSONObject.put("request_type", 11);
            BaiduWalletServiceController.getInstance().gotoWalletService((Context) getActivity(), 4, jSONObject.toString(), true);
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getMessage(), "#listMyBankCardFail");
        }
    }

    private void j(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            String optString = new JSONObject(str).optString("data", (String) null);
            if (TextUtils.isEmpty(optString)) {
                throw new InvalidParameterException("invalid parameter [data] (null)");
            } else if (!((JSONObject) new JSONTokener(optString).nextValue()).has("en")) {
                throw new InvalidParameterException("invalid parameter [data->en] (null)");
            } else if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(0, "{\"result\":0}");
            }
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#customerServiceFail");
        }
    }

    private void k(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (a(str2)) {
            jSONArray.put("0");
        }
        if (BeanConstants.CHANNEL_ID.equals("iqiyi")) {
            jSONArray.put("1");
        } else if (LocalRouter.getInstance(context).isProviderExisted("livenessidentifyauth")) {
            jSONArray.put("1");
        }
        if (Build.VERSION.SDK_INT >= 18) {
            if (!this.y) {
                try {
                    this.f3568i = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessManager");
                    Class<?> cls = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessCallback");
                    this.k = cls;
                    this.j = this.f3568i.getDeclaredMethod("startDetact", new Class[]{Context.class, String.class, cls});
                    jSONArray.put("2");
                } catch (Throwable th2) {
                    this.y = true;
                    throw th2;
                }
                this.y = true;
            } else if (!(this.f3568i == null || this.k == null || this.j == null)) {
                jSONArray.put("2");
            }
        }
        if (d()) {
            jSONArray.put("3");
        }
        try {
            jSONObject2.put("data", jSONArray);
            jSONObject.put("result", 0);
            jSONObject.put("cnt", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        iLightappInvokerCallback.onResult(0, jSONObject.toString());
    }

    private void l(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        this.f3569o = str;
        this.p = iLightappInvokerCallback;
        try {
            String optString = new JSONObject(str).optString("liveness_type", "0");
            char c2 = 65535;
            switch (optString.hashCode()) {
                case 48:
                    if (optString.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 49:
                    if (optString.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 50:
                    if (optString.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 51:
                    if (optString.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                n(context, str, iLightappInvokerCallback, str2);
            } else if (c2 == 1) {
                m(context, str, iLightappInvokerCallback, str2);
            } else if (c2 == 2) {
                o(context, str, iLightappInvokerCallback, str2);
            } else if (c2 != 3) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, EnterDxmPayServiceAction.ERR_MSG, "#callNativeVoice");
            } else {
                q(context, str, iLightappInvokerCallback, str2);
            }
        } catch (JSONException unused) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数解析异常", "#callNativeVoice");
        }
    }

    private void m(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            HashMap hashMap = (HashMap) JsonUtils.fromJson(new JSONObject(str).getString("dxmPayLiveness"), HashMap.class);
            if (BeanConstants.CHANNEL_ID.equals("iqiyi")) {
                b(context, hashMap, iLightappInvokerCallback, str2);
            } else {
                a(context, hashMap, iLightappInvokerCallback, str2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, EnterDxmPayServiceAction.ERR_MSG, "#identifyAuthFail");
        }
    }

    private void n(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Set<String> methodList = LightAppWrapper.getInstance().getMethodList();
        if (methodList != null && methodList.contains(CALL_NATIVE_VOICE)) {
            LightAppWrapper.getInstance().lightappInvoke(context, str, iLightappInvokerCallback);
        } else if (!a(str2)) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = "10004";
            data.des = "没有找到对应的方法";
            iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
        } else {
            final ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
            final String str3 = str2;
            final String str4 = str;
            final Context context2 = context;
            WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(context, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    LightappUtils.onError(iLightappInvokerCallback2, str3, String.valueOf(101), "请重新登录!", "#callNativeVoiceFail");
                }

                public void onSuccess(int i2, String str) {
                    try {
                        Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{LightappBusinessClient.this.h}, new c(iLightappInvokerCallback2));
                        boolean equals = "ONLINE".equals(DebugConfig.getInstance().getEnvironment());
                        JSONObject jSONObject = new JSONObject(str4);
                        jSONObject.put("stoken", WalletLoginHelper.getInstance().getLoginStoken());
                        LightappBusinessClient.this.g.invoke((Object) null, new Object[]{context2, jSONObject.toString(), Boolean.valueOf(equals), newProxyInstance});
                    } catch (Throwable unused) {
                        LightappUtils.onError(iLightappInvokerCallback2, str3, "10003", "reflect callNativeVoice fail!", "#callNativeVoiceFail");
                    }
                }
            }));
        }
    }

    private void o(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        if (!CheckUtils.isFastDoubleClick()) {
            if (Build.VERSION.SDK_INT < 18) {
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                data.errCode = "10004";
                data.des = "系统版本不支持";
                iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
            } else if (!PermissionManager.checkCallingPermission(context, "android.permission.CAMERA") || !PermissionManager.checkCallingPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                this.K = BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", getActivity(), new String[]{"android.permission.CAMERA", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                    public void isAllAgree(Boolean bool) {
                        if (bool.booleanValue()) {
                            PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.C.getActivity(), new String[]{"android.permission.CAMERA", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE);
                        } else {
                            LightappBusinessClient.this.onRequestPermissionsResult(str2, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, new String[]{"android.permission.CAMERA", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1, -1});
                        }
                    }

                    public void isShow(String str, Boolean bool) {
                    }

                    public void requestResult(String str, Boolean bool) {
                    }
                });
            } else {
                p(context, str, iLightappInvokerCallback, str2);
            }
        }
    }

    private void p(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        if (!this.y) {
            try {
                this.f3568i = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessManager");
                Class<?> cls = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessCallback");
                this.k = cls;
                this.j = this.f3568i.getDeclaredMethod("startDetact", new Class[]{Context.class, String.class, cls});
            } catch (Throwable th2) {
                this.y = true;
                throw th2;
            }
            this.y = true;
        }
        if (this.f3568i == null || this.k == null || this.j == null) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = "10004";
            data.des = "没有找到对应的方法";
            iLightappInvokerCallback2.onResult(1, lightAppErrorModel.toJson());
            return;
        }
        try {
            Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.k}, new c(iLightappInvokerCallback2));
            this.j.invoke((Object) null, new Object[]{context, str, newProxyInstance});
        } catch (Throwable unused) {
            LightappUtils.onError(iLightappInvokerCallback2, str2, "10003", "reflect faceliveness fail!", "#callFaceLivenessFail");
        }
    }

    private void q(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (!PermissionManager.checkCallingPermission(context, "android.permission.CAMERA") || !PermissionManager.checkCallingPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            PermissionManager.checkCallingOrSelfPermission(getActivity(), new String[]{"android.permission.CAMERA", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_SENSE);
        } else {
            r(context, str, iLightappInvokerCallback, str2);
        }
    }

    private void r(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (d()) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.n}, new c(iLightappInvokerCallback));
                this.m.invoke((Object) null, new Object[]{context, str, newProxyInstance});
            } catch (Throwable unused) {
                LightappUtils.onError(iLightappInvokerCallback, str2, "10003", "reflect senseliveness fail!", "#callSenseLivenessFail");
            }
        } else {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = "10004";
            data.des = "没有找到对应的方法";
            iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
        }
    }

    private void s(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (iLightappInvokerCallback != null) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                byte[] bArr = null;
                String optString = jSONObject.optString("algorithm", (String) null);
                if (optString != null) {
                    String optString2 = jSONObject.optString("data", (String) null);
                    if (optString2 != null) {
                        bArr = Base64.decode(optString2, 2);
                        if (bArr == null || bArr.length == 0) {
                            throw new IllegalArgumentException("传入的base64数据不正确");
                        }
                    }
                    if (Pattern.compile("MD5|SHA-(1|224|256|384|512)").matcher(optString).matches()) {
                        MessageDigest instance = MessageDigest.getInstance(optString);
                        if (bArr != null) {
                            instance.update(bArr);
                        }
                        hashMap.put("data", Base64.encodeToString(StringUtil.arrayToString(instance.digest(), 0, 9999).getBytes(), 2));
                        iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult((Map<String, Object>) hashMap, true));
                        return;
                    }
                    throw new NoSuchAlgorithmException("Supported algorithms: MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA- 512." + optString + " is not supported yet");
                }
                throw new InvalidParameterException("no message digest algorithm key [algorithm]");
            } catch (Exception unused) {
                throw new DigestException("make digest of data error");
            } catch (Exception e2) {
                throw e2;
            } catch (Exception e3) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e3.getLocalizedMessage(), "#digestFail");
            }
        }
    }

    private void t(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        a("selectPhonefromAdressBook", str);
        try {
            String optString = new JSONObject(str).optString("key", (String) null);
            u = optString;
            if (optString != null) {
                if (optString.trim().length() == 0) {
                    throw new InvalidParameterException("加密密钥格式非法");
                }
            }
            r = LightappUtils.parseJsonInt(str, "type");
            s = LightappUtils.parseJsonInt(str, "maxNum");
            t = LightappUtils.parseJsonInt(str, "base64");
            if (r != v) {
                if (r != w) {
                    throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
                }
            }
            if (!PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
                this.K = BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", getActivity(), new String[]{"android.permission.READ_CONTACTS"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                    public void isAllAgree(Boolean bool) {
                        if (!bool.booleanValue()) {
                            LightappBusinessClient.this.onRequestPermissionsResult("", LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, new String[]{"android.permission.READ_CONTACTS"}, new int[]{-1});
                        } else if (!PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK)) {
                            LightappBusinessClient.this.b(str2);
                        }
                    }

                    public void isShow(String str, Boolean bool) {
                    }

                    public void requestResult(String str, Boolean bool) {
                    }
                });
            } else if (this.C != null) {
                this.C.selectPhoneFromAddressBook();
            } else {
                throw new InvalidParameterException("mImpl null");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            throw new InvalidParameterException("参数格式非法");
        } catch (Exception e3) {
            e3.printStackTrace();
            ContactSelectModel contactSelectModel = new ContactSelectModel(1);
            ContactSelectModel.Data data = contactSelectModel.cnt;
            data.errCode = LightappConstants.ERRCODE_INVALID_PARAMETER;
            data.des = e3.getLocalizedMessage();
            iLightappInvokerCallback.onResult(1, contactSelectModel.toJson());
        }
    }

    private void u(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (this.C != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.C.setTitlesInMainThread(jSONObject.optString("mainTitle", (String) null), jSONObject.optString("subTitle", (String) null), "1".equals(jSONObject.optString("scaleMainTitle", "1")));
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, "");
                }
            } catch (Exception e2) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#setTitleFail");
            }
        }
    }

    private void v(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (this.C != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject fullScreenInMainThread = this.C.setFullScreenInMainThread(TextUtils.equals("1", jSONObject.optString("fullScreen", "")), TextUtils.equals("1", jSONObject.optString("isHideTitle", "")), TextUtils.equals("1", jSONObject.optString("isHideHost", "")), TextUtils.equals("1", jSONObject.optString("actionIconWhite", "")), jSONObject.optString("actionBarColor", (String) null), jSONObject.optString("titleColor", (String) null));
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, fullScreenInMainThread));
                }
            } catch (Exception e2) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#setFullScreenFail");
            }
        }
    }

    private void w(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
    }

    private void x(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                LogUtil.i(this.b, "Open in Browser Success");
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, "");
                }
            } else if (iLightappInvokerCallback != null) {
                LogUtil.i(this.b, "Open in Browser fail");
                iLightappInvokerCallback.onResult(1, "url为空");
            }
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#openInBrowserFail");
        }
    }

    private void y(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (this.C != null) {
            try {
                this.C.setMenuInMainThread(new JSONObject(str).getJSONArray("menu_list"));
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, "");
                }
            } catch (Exception e2) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#setMenuFail");
            }
        }
    }

    private void z(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        DXMSdkSAUtils.onEventWithValues(MTD_H5GOBCK, Arrays.asList(new String[]{CheckUtils.stripUrlParams(str2)}));
        setH5BackCb(iLightappInvokerCallback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0039 A[SYNTHETIC, Splitter:B:25:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003d A[Catch:{ Exception -> 0x0087 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void accessWalletService(android.content.Context r11, java.lang.String r12, com.baidu.wallet.api.ILightappInvokerCallback r13, java.lang.String r14) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            r1.<init>(r12)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r2 = "serviceId"
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x000e }
            goto L_0x0013
        L_0x000e:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ Exception -> 0x0021 }
            r2 = r0
        L_0x0013:
            java.lang.String r3 = "serviceExtra"
            java.lang.String r1 = r1.getString(r3)     // Catch:{ Exception -> 0x001a }
            goto L_0x0027
        L_0x001a:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r1 = move-exception
            goto L_0x0023
        L_0x0021:
            r1 = move-exception
            r2 = r0
        L_0x0023:
            r1.printStackTrace()
        L_0x0026:
            r1 = r0
        L_0x0027:
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r4 = "accessWalletService"
            boolean r4 = r10.a((java.lang.String) r4, (long) r2, (java.lang.String) r12)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r5 = "accessWalletServiceFail"
            java.lang.String r6 = "没有找到对应的方法"
            java.lang.String r7 = "10004"
            if (r4 != 0) goto L_0x003d
            com.baidu.wallet.lightapp.base.utils.LightappUtils.onError((com.baidu.wallet.api.ILightappInvokerCallback) r13, (java.lang.String) r14, (java.lang.String) r7, (java.lang.String) r6, (java.lang.String) r5)     // Catch:{ Exception -> 0x0087 }
            return
        L_0x003d:
            long r2 = r10.a((long) r2)     // Catch:{ Exception -> 0x0087 }
            r8 = -1
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x004b
            com.baidu.wallet.lightapp.base.utils.LightappUtils.onError((com.baidu.wallet.api.ILightappInvokerCallback) r13, (java.lang.String) r14, (java.lang.String) r7, (java.lang.String) r6, (java.lang.String) r5)     // Catch:{ Exception -> 0x0087 }
            return
        L_0x004b:
            if (r13 == 0) goto L_0x0070
            r4 = 32
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0065
            com.baidu.apollon.eventbus.EventBus r12 = com.baidu.apollon.eventbus.EventBus.getInstance()     // Catch:{ Exception -> 0x0087 }
            com.baidu.apollon.eventbus.EventBus$Event r14 = new com.baidu.apollon.eventbus.EventBus$Event     // Catch:{ Exception -> 0x0087 }
            java.util.Objects.requireNonNull(r12)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r4 = "H5Balance"
            r14.<init>(r4, r13)     // Catch:{ Exception -> 0x0087 }
            r12.postStickyEvent(r14)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0070
        L_0x0065:
            r4 = 60007(0xea67, double:2.96474E-319)
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0070
            r10.J(r11, r12, r13, r14)     // Catch:{ Exception -> 0x0087 }
            return
        L_0x0070:
            com.baidu.wallet.BaiduWalletServiceController r12 = com.baidu.wallet.BaiduWalletServiceController.getInstance()     // Catch:{ Exception -> 0x0087 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0087 }
            r14.<init>()     // Catch:{ Exception -> 0x0087 }
            r14.append(r2)     // Catch:{ Exception -> 0x0087 }
            r14.append(r0)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0087 }
            r12.gotoWalletService((android.content.Context) r11, (java.lang.String) r14, (java.lang.String) r1, (com.baidu.wallet.api.ILightappInvokerCallback) r13)     // Catch:{ Exception -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r11 = move-exception
            r11.printStackTrace()
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.LightappBusinessClient.accessWalletService(android.content.Context, java.lang.String, com.baidu.wallet.api.ILightappInvokerCallback, java.lang.String):void");
    }

    public void bdLogin(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        String str3;
        try {
            str3 = new JSONObject(str).optString("extra_param");
        } catch (JSONException unused) {
            str3 = "";
        }
        WalletLoginHelper.getInstance().onlyLogin(new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i2), str, "#bdLoginFail");
            }

            public void onSuccess(int i2, String str) {
                iLightappInvokerCallback.onResult(0, "0");
            }
        }), str3);
    }

    public void callCamera(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i2;
        a(METHOD_CALL_CAMERA, str);
        int parseJsonInt = LightappUtils.parseJsonInt(str, "type");
        if (1 == parseJsonInt) {
            try {
                i2 = (int) (new JSONObject(str).optDouble("quality") * 100.0d);
            } catch (Exception e2) {
                e2.printStackTrace();
                i2 = -1;
            }
            final int i3 = (i2 <= 0 || 100 < i2) ? -1 : i2;
            final ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
            final String str3 = str2;
            final Context context2 = context;
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("idcarddetect").action("enterIdCardDetect").data("type", 6).data("showAlbum", Boolean.FALSE).data("fromLangbridge", Boolean.TRUE), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 == 0) {
                        if (hashMap == null || hashMap.size() <= 0) {
                            ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback2;
                            if (iLightappInvokerCallback != null) {
                                iLightappInvokerCallback.onResult(1, "internal error null");
                                return;
                            }
                            return;
                        }
                        Bundle bundle = (Bundle) hashMap.get("result");
                        if (bundle != null) {
                            bundle.getInt("step");
                            String string = bundle.getString("pic1");
                            final LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(0);
                            AnonymousClass1 r1 = new ImageBase64Utils.ImageBase64Listener() {
                                public void onBase64Result(String str) {
                                    LightAppTakePictureModel lightAppTakePictureModel = lightAppTakePictureModel;
                                    lightAppTakePictureModel.cnt.image = str;
                                    iLightappInvokerCallback2.onResult(0, lightAppTakePictureModel.toJson());
                                }
                            };
                            ImageBase64Utils instance = ImageBase64Utils.getInstance();
                            int i3 = i3;
                            if (i3 > 0) {
                                instance.getImageBase64(string, -1, i3, (ImageBase64Utils.ImageBase64Listener) r1);
                            } else {
                                instance.getImageBase64(string, 640, (ImageBase64Utils.ImageBase64Listener) r1);
                            }
                        } else {
                            ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback2;
                            if (iLightappInvokerCallback2 != null) {
                                iLightappInvokerCallback2.onResult(1, "internal error");
                            }
                        }
                    } else if (i2 != 1) {
                        String str = (String) hashMap.get("errorMsg");
                        ILightappInvokerCallback iLightappInvokerCallback3 = iLightappInvokerCallback2;
                        String str2 = str3;
                        String num = Integer.toString(i2);
                        if (!TextUtils.isEmpty(str)) {
                            str = LightappConstants.ROUTER_INVOKE_FAIL;
                        }
                        LightappUtils.onError(iLightappInvokerCallback3, str2, num, str, "#callCameraFail");
                    } else if (hashMap == null || hashMap.size() <= 0) {
                        ILightappInvokerCallback iLightappInvokerCallback4 = iLightappInvokerCallback2;
                        if (iLightappInvokerCallback4 != null) {
                            iLightappInvokerCallback4.onResult(1, "internal error null");
                        }
                    } else {
                        int intValue = ((Integer) hashMap.get("errCode")).intValue();
                        String str3 = (String) hashMap.get("errMsg");
                        if (intValue == -1) {
                            LightappUtils.onError(iLightappInvokerCallback2, str3, "10002", LightappBusinessClient.this.a(context2, "访问相机的权限"), "#callCameraFail");
                        } else if (-2 == intValue) {
                            LightappUtils.onError(iLightappInvokerCallback2, str3, "10005", "取消", "#callCameraFail");
                        }
                    }
                }
            });
            return;
        }
        LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + parseJsonInt, "#callCameraFail");
    }

    public void callIDPotos(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3 = str;
        ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        String str4 = str2;
        a(METHOD_CALL_ID_PHOTOS, str);
        if (CheckUtils.isFastDoubleClick()) {
            LightappUtils.onError(iLightappInvokerCallback, str4, LightappConstants.ERRCODE_INVALID_PARAMETER, "快速点击重复", "#callIDPotosFail");
            return;
        }
        int parseJsonInt = LightappUtils.parseJsonInt(str, "type");
        int i2 = 5;
        if (1 == parseJsonInt) {
            i2 = 1;
        } else if (2 == parseJsonInt) {
            i2 = 3;
        } else if (3 == parseJsonInt) {
            i2 = 4;
        } else if (4 != parseJsonInt) {
            i2 = 5 == parseJsonInt ? 6 : -1;
        }
        if (i2 > 0) {
            a(context, i2, iLightappInvokerCallback, str2, LightappUtils.parseJsonInt(str, "showalbum") == 1);
            return;
        }
        LightappUtils.onError(iLightappInvokerCallback, str4, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + i2, "#callIDPotosFail");
    }

    public void callQRCodeScanner(final Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        int parseJsonInt = LightappUtils.parseJsonInt(str, "needScanResult");
        int parseJsonInt2 = LightappUtils.parseJsonInt(str, "type");
        int parseJsonInt3 = LightappUtils.parseJsonInt(str, "showQrCodeBtns");
        LogUtil.i("zxing", "qrCodeNeedResult" + parseJsonInt + "type" + parseJsonInt2 + "showQrCodeBtns" + parseJsonInt3);
        LocalRouter instance = LocalRouter.getInstance(context);
        boolean z2 = true;
        RouterRequest data = new RouterRequest().provider("saoyisao").action("qrcodescanner").data("withAnim", Boolean.toString(true)).data("showQrCodeBtns", Boolean.valueOf(parseJsonInt3 == 1));
        if (parseJsonInt != d) {
            z2 = false;
        }
        instance.route(context, data.data("qrcodeNeedResult", Boolean.valueOf(z2)).data("fromLangbridge", Boolean.TRUE).data("type", Integer.valueOf(parseJsonInt2)), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 0 && hashMap != null) {
                    LogUtil.i("zxing", "onResult");
                    String str = (String) hashMap.get("value");
                    LightAppCallQRCodeScannerModel lightAppCallQRCodeScannerModel = new LightAppCallQRCodeScannerModel();
                    lightAppCallQRCodeScannerModel.result = 0;
                    if (!TextUtils.isEmpty(str)) {
                        lightAppCallQRCodeScannerModel.cnt.scanResult = Base64.encodeToString(str.getBytes(), 2);
                    }
                    LogUtil.i("zxing", "onResult:" + str);
                    iLightappInvokerCallback.onResult(0, lightAppCallQRCodeScannerModel.toJson());
                } else if (i2 == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", "saoyisao");
                    hashMap2.put("action", "qrcodescanresult");
                    if (hashMap != null && hashMap.size() > 0 && "notSupport".equals(hashMap.get("errorMsg"))) {
                        hashMap2.put("errmsg", hashMap.get("errorMsg"));
                    }
                    LightappUtils.onError(iLightappInvokerCallback, str2, "10004", "没有找到对应的方法", "");
                    LogUtil.d("zxing", "callQRCodeScanner check not support");
                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                } else if (i2 == 1 && hashMap != null) {
                    int intValue = ((Integer) hashMap.get("errCode")).intValue();
                    String str2 = (String) hashMap.get("errorMsg");
                    if (intValue == 2 && TextUtils.equals(str2, "camera_permission_denied")) {
                        LightappUtils.onError(iLightappInvokerCallback, str2, "10002", LightappBusinessClient.this.a(context, "访问相机的权限"), "#callQRCodeScannerFail");
                    } else if (intValue == 0) {
                        LightappUtils.onError(iLightappInvokerCallback, str2, "10005", "取消", "#callQRCodeScannerFail");
                    }
                }
            }
        });
    }

    public void changePayMethod(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        if (iLightappInvokerCallback != null) {
            if (getActivity() != null) {
                getActivity();
            } else if (context == null || !(context instanceof Activity)) {
                iLightappInvokerCallback.onResult(1, "activity and context is null");
                return;
            } else {
                Activity activity = (Activity) context;
            }
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterChangePayMethod").data("options", str), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 != 0) {
                        String str = (String) hashMap.get("errorMsg");
                        ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                        String str2 = str2;
                        String num = Integer.toString(i2);
                        if (TextUtils.isEmpty(str)) {
                            str = LightappConstants.ROUTER_INVOKE_FAIL;
                        }
                        LightappUtils.onError(iLightappInvokerCallback, str2, num, str, "#changePayMethodFail");
                    } else if (hashMap == null || hashMap.size() <= 0) {
                        iLightappInvokerCallback.onResult(1, "resultData is null");
                    } else {
                        String str3 = (String) hashMap.get("result");
                        if (!TextUtils.isEmpty(str3)) {
                            try {
                                if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                                    iLightappInvokerCallback.onResult(0, str3);
                                } else {
                                    iLightappInvokerCallback.onResult(1, str3);
                                }
                            } catch (JSONException e) {
                                iLightappInvokerCallback.onResult(1, "result 解析异常");
                                e.printStackTrace();
                            }
                        } else {
                            iLightappInvokerCallback.onResult(1, "result is null");
                        }
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkPermission() {
        /*
            r7 = this;
            java.lang.String r0 = r7.J
            int r1 = r0.hashCode()
            r2 = -1367751899(0xffffffffae79c325, float:-5.678937E-11)
            r3 = 2
            r4 = 1
            r5 = -1
            r6 = 0
            if (r1 == r2) goto L_0x002e
            r2 = 263762004(0xfb8b054, float:1.821172E-29)
            if (r1 == r2) goto L_0x0024
            r2 = 1901043637(0x714f9fb5, float:1.0281035E30)
            if (r1 == r2) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            java.lang.String r1 = "location"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0024:
            java.lang.String r1 = "address_book"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = 2
            goto L_0x0039
        L_0x002e:
            java.lang.String r1 = "camera"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = 0
            goto L_0x0039
        L_0x0038:
            r0 = -1
        L_0x0039:
            if (r0 == 0) goto L_0x0048
            if (r0 == r4) goto L_0x0045
            if (r0 == r3) goto L_0x0042
            java.lang.String r0 = ""
            goto L_0x004a
        L_0x0042:
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            goto L_0x004a
        L_0x0045:
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            goto L_0x004a
        L_0x0048:
            java.lang.String r0 = "android.permission.CAMERA"
        L_0x004a:
            com.baidu.wallet.lightapp.base.datamodel.LightAppInfoModel r1 = new com.baidu.wallet.lightapp.base.datamodel.LightAppInfoModel
            r1.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0066
            android.app.Activity r2 = r7.getActivity()
            boolean r0 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r2, r0)
            if (r0 == 0) goto L_0x0066
            r1.result = r6
            java.lang.String r0 = "permission granted"
            r1.state = r0
            goto L_0x006c
        L_0x0066:
            r1.result = r5
            java.lang.String r0 = "permission denied"
            r1.state = r0
        L_0x006c:
            java.lang.String r0 = r1.toJson()
            java.lang.String r1 = "goToAppSetting"
            r7.a((java.lang.String) r1, (int) r6, (java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.LightappBusinessClient.checkPermission():void");
    }

    public void detectBankCard(final Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        a("detectBankCard", str);
        try {
            HashMap hashMap = (HashMap) JsonUtils.fromJson(str, HashMap.class);
            if (LocalRouter.getInstance(context).isProviderExisted("bankdetection")) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("bankdetection").action("bankcarddetction").data(hashMap), new RouterCallback() {
                    public void onResult(int i2, HashMap hashMap) {
                        if (i2 == 0) {
                            if (hashMap != null && !TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                                String str = (String) hashMap.get("card_num");
                                if (!TextUtils.isEmpty(str)) {
                                    LightAppDetectBankcardModel lightAppDetectBankcardModel = new LightAppDetectBankcardModel(0);
                                    lightAppDetectBankcardModel.cnt.data = str;
                                    iLightappInvokerCallback.onResult(0, lightAppDetectBankcardModel.toJson());
                                }
                            }
                        } else if (i2 != 1 || hashMap == null) {
                            if (i2 == 5) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("provider", "bankdetection");
                                hashMap2.put("action", "bankcarddetction");
                                DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                            }
                        } else if (((Integer) hashMap.get("errCode")).intValue() == -1) {
                            ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                            String str2 = str2;
                            LightappUtils.onError(iLightappInvokerCallback, str2, "10002", PhoneUtils.getApplicationName(context) + "没有" + "访问相机的权限", "#detectBankCardFail");
                        } else if (((Integer) hashMap.get("errCode")).intValue() == -2) {
                            LightappUtils.onError(iLightappInvokerCallback, str2, "10005", "取消", "#detectBankCardFail");
                        }
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void detectLiveness(final Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        a("detectLiveness", str);
        try {
            HashMap hashMap = (HashMap) JsonUtils.fromJson(str, HashMap.class);
            if (LocalRouter.getInstance(context).isProviderExisted("livenessdetect")) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("livenessdetect").action("livenessdetect").data(hashMap), new RouterCallback() {
                    public void onResult(int i2, HashMap hashMap) {
                        if (i2 == 0) {
                            if (hashMap != null) {
                                Object obj = hashMap.get("value");
                                if (obj instanceof JSONObject) {
                                    try {
                                        LightAppCommonModel lightAppCommonModel = new LightAppCommonModel(0);
                                        lightAppCommonModel.cnt.data = (HashMap) JsonUtils.fromJson(((JSONObject) obj).toString(), HashMap.class);
                                        iLightappInvokerCallback.onResult(0, lightAppCommonModel.toJson());
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } else if (i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "livenessdetect");
                            hashMap2.put("action", "livenessdetect");
                            DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        } else {
                            LightappUtils.onError(iLightappInvokerCallback, str2, i2 + "", PhoneUtils.getApplicationName(context) + ((String) hashMap.get("errorMsg")), "#faceRegisterFail");
                        }
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void doBindCard(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2, final String str3) {
        this.e = false;
        String str4 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLDecoder.decode(str, "gbk");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    str4 = (String) jSONObject.get("orderInfo");
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    this.e = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterDoInnerBind").data("showDialog", Boolean.valueOf(this.e)).data("orderInfo", str4), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 != 0) {
                    String str = (String) hashMap.get("errorMsg");
                    ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                    String str2 = str2;
                    String num = Integer.toString(i2);
                    if (!TextUtils.isEmpty(str)) {
                        str = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    LightappUtils.onError(iLightappInvokerCallback, str2, num, str, "#doBindCardFail");
                } else if (hashMap != null && hashMap.size() > 0) {
                    int intValue = ((Integer) hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue();
                    String str3 = (String) hashMap.get("params");
                    if (intValue == 0) {
                        iLightappInvokerCallback.onResult(0, str3);
                        return;
                    }
                    ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                    String str4 = str2;
                    StringBuilder sb = new StringBuilder();
                    sb.append(Bank.HOT_BANK_LETTER);
                    sb.append(TextUtils.isEmpty(str3) ? "doBindCard" : str3);
                    sb.append("Fail");
                    LightappUtils.onError(iLightappInvokerCallback2, str4, "10005", str3, sb.toString());
                }
            }
        });
    }

    public void doRnAuth(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    str3 = (String) new JSONObject(str).get("orderInfo");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterDoRnAuth").data(getUrlParam(str3)), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 != 0) {
                    String str = (String) hashMap.get("errorMsg");
                    ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                    String str2 = str2;
                    String num = Integer.toString(i2);
                    if (!TextUtils.isEmpty(str)) {
                        str = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    LightappUtils.onError(iLightappInvokerCallback, str2, num, str, "#doRnAuthFail");
                } else if (hashMap != null && hashMap.size() > 0) {
                    int intValue = ((Integer) hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue();
                    String str3 = (String) hashMap.get("authDesc");
                    if (intValue == 0) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("result", intValue);
                            jSONObject.put("cnt", str3);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        iLightappInvokerCallback.onResult(0, jSONObject.toString());
                        return;
                    }
                    LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(intValue), str3, "#doRnAuthFail");
                }
            }
        });
    }

    public void dopay(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        this.e = false;
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    str3 = (String) jSONObject.get("orderInfo");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    this.e = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterDoPayWithParams").data("orderInfo", str3).data("showDialog", Boolean.valueOf(this.e)), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 != 0) {
                    String str = (String) hashMap.get("errorMsg");
                    ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                    String str2 = str2;
                    String num = Integer.toString(i2);
                    if (!TextUtils.isEmpty(str)) {
                        str = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    LightappUtils.onError(iLightappInvokerCallback, str2, num, str, "#dopayFail");
                } else if (hashMap != null && hashMap.size() > 0) {
                    int intValue = ((Integer) hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue();
                    String str3 = (String) hashMap.get("payDesc");
                    if (intValue == 0 || intValue == 1) {
                        iLightappInvokerCallback.onResult(0, str3);
                    } else {
                        iLightappInvokerCallback.onResult(1, str3);
                    }
                }
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        HandlerThread handlerThread = this.G;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        HashMap<String, b> hashMap = this.I;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public String getAcceptMessageFlag() {
        return a;
    }

    public Activity getActivity() {
        com.baidu.wallet.lightapp.multipage.a aVar = this.C;
        if (aVar != null) {
            return aVar.getActivity();
        }
        return null;
    }

    public ILightappInvokerCallback getH5BackCb() {
        return this.D;
    }

    public ILightappInvokerCallback getH5Close() {
        return this.E;
    }

    public ILightappInvokerCallback getH5Refresh() {
        return this.F;
    }

    public void getLoadTimeLine(ILightappInvokerCallback iLightappInvokerCallback) {
        if (iLightappInvokerCallback != null) {
            String loadTimeLine = this.C.getLoadTimeLine();
            String str = this.b;
            LogUtil.d(str, "getLoadTimeLine result = " + loadTimeLine);
            iLightappInvokerCallback.onResult(0, loadTimeLine);
        }
    }

    public Set<String> getMethodList() {
        HashSet hashSet = new HashSet();
        hashSet.add(METHOD_CALL_CAMERA);
        if (e(METHOD_CALL_QRCODE_SCANNER)) {
            hashSet.add(METHOD_CALL_QRCODE_SCANNER);
        }
        hashSet.add(METHOD_CALL_ID_PHOTOS);
        if (e("detectBankCard")) {
            hashSet.add("detectBankCard");
        }
        if (e(METHOD_DETECT_LIVENESS)) {
            hashSet.add(METHOD_DETECT_LIVENESS);
        }
        hashSet.add(METHOD_INIT_PAY);
        hashSet.add("dopay");
        hashSet.add("doBindCard");
        hashSet.add("doRnAuth");
        hashSet.add(METHOD_BD_LOGIN);
        hashSet.add(MTD_LIST_MY_BANK_CARD);
        hashSet.add("getPayMethod");
        hashSet.add("changePayMethod");
        hashSet.add("preOrderPay");
        hashSet.add("postEvent");
        hashSet.add(MTD_BINDCARD_INITIATIVE);
        hashSet.add(MTD_BINDCARD_INDEPENDENT);
        hashSet.add("setRnAuthResult");
        hashSet.add(MTD_GOTO_DXM_PAY_SERVICE);
        hashSet.add(METHOD_ACCESS_WALLET_SERVICE);
        hashSet.add(METHOD_GET_USER_AGENT);
        hashSet.add(MTD_CALLPHONEINFO);
        hashSet.add("setTitle");
        hashSet.add(MTD_SETMENU);
        hashSet.add(MTD_H5GOBCK);
        hashSet.add(MTD_H5REFRESH);
        hashSet.add(MTD_STATEVENT);
        hashSet.add(CALL_NATIVE_VOICE);
        hashSet.add(MTD_OPEN_IN_BROWSER);
        hashSet.add(MTD_DIGEST);
        hashSet.add(MTD_ENCRYPT);
        hashSet.add(MTD_DECRYPT);
        hashSet.add("selectPhonefromAdressBook");
        hashSet.add(MTD_CUSTOMER_SERVICE);
        hashSet.add(MTD_START_AUDIO_RECORD);
        hashSet.add(MTD_END_AUDIO_RECORD);
        hashSet.add(MTD_GET_SUPPORT_LIST);
        hashSet.add(MTD_SET_FULLSCREEN);
        hashSet.add(METHOD_GET_SUPPORT_LIVENESS);
        hashSet.add(MTD_CALL_NATIVE_PHOTO);
        hashSet.add(MTD_GET_LOAD_TIME_LINE);
        hashSet.add(MTD_GO_TO_APP_SETTING);
        hashSet.add(MTD_OPEN_NEW_LIGHT_BRIDGE);
        hashSet.add(MTD_SET_LIGHT_BRIDGE_STYLE);
        hashSet.add(MTD_MESSAGE_FORWARDING);
        hashSet.add(MTD_ACCEPT_MESSAGE_FROM_LANGBRIDGE);
        hashSet.add(MTD_UNREGISTER_MESSAGE_FROM_LANGBRIDGE);
        hashSet.add(MTD_SEND_TO_SMS);
        hashSet.add(MTD_GET_PERMISSION_STATE);
        hashSet.add(MTD_GET_PERMISSIOM_DIALOG_MSG);
        hashSet.add(MTD_GET_OFFLINE_INFO);
        hashSet.add(MTD_UPLOAD_MSG);
        hashSet.add(MTD_SETSUBMENU);
        hashSet.add(MTD_UNREGISTER_H5_GO_BACK);
        hashSet.add(MTD_H5ClOSE);
        hashSet.add(MTD_UNREGISTER_H5_CLOSE);
        hashSet.add(MTD_UNREGISTER_H5_REFRESH);
        hashSet.add(MTD_SHOW_TITLE_FLOATVIEW);
        hashSet.add(MTD_CUSTOM_RIGHT_BUTTON);
        hashSet.add(MTD_PERMISSION_UNIVERSAL_SET);
        hashSet.add(MTD_SAVE_PIC);
        hashSet.add(MTD_SET_SCREEN_VERTICAL);
        hashSet.add(MTD_RPA_PERCEPTIONL);
        hashSet.add(MTD_INSERT_PHONE_NUM_TO_ADDRESS_BOOK);
        hashSet.add(MTD_CALL_AUTOMATED_SUBMISSION);
        return hashSet;
    }

    public void getOfflineCacheInfo(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        JSONObject offlineCacheInfo = LangbridgeCacheManager.getInstance().getOfflineCacheInfo(str2);
        if (offlineCacheInfo == null) {
            offlineCacheInfo = new JSONObject();
        }
        iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, offlineCacheInfo));
    }

    public void getPayMethod(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (iLightappInvokerCallback == null) {
            b("getPayMethod", 1, "callback is null");
        } else {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterGetPayMethod").data("options", str), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 != 0) {
                        iLightappInvokerCallback.onResult(1, "resultCode is fail");
                    } else if (hashMap == null || hashMap.size() <= 0) {
                        iLightappInvokerCallback.onResult(1, "resultData is null");
                    } else {
                        String str = (String) hashMap.get("result");
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                if (((Integer) new JSONObject(str).get("result")).intValue() == 0) {
                                    iLightappInvokerCallback.onResult(0, str);
                                } else {
                                    iLightappInvokerCallback.onResult(1, str);
                                }
                            } catch (JSONException e) {
                                iLightappInvokerCallback.onResult(1, "数据解析异常");
                                e.printStackTrace();
                            }
                        } else {
                            iLightappInvokerCallback.onResult(1, "result is null");
                        }
                    }
                }
            });
        }
    }

    @SuppressLint({"DefaultLocale"})
    public HashMap<String, String> getSinalParam(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        try {
            for (String split : str.split(com.alipay.sdk.m.s.a.n)) {
                String[] split2 = split.split("=");
                String str2 = "";
                if (split2 != null && !TextUtils.isEmpty(split2[0])) {
                    if (split2.length > 1) {
                        str2 = URLDecoder.decode(split2[1]);
                    }
                    hashMap.put(split2[0], str2);
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public void getSupportedMethodList(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (iLightappInvokerCallback != null) {
            JSONObject jSONObject = new JSONObject();
            Set<String> supportMethodList = LightappJsNativeClient.getSupportMethodList(context);
            supportMethodList.addAll(getMethodList());
            supportMethodList.add(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE);
            try {
                jSONObject.put("data", new JSONArray(JsonUtils.toJson(supportMethodList)));
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
            } catch (JSONException e2) {
                e2.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str2, "10003", "失败", "#getSupportedMethodListFail");
            }
        }
    }

    public HashMap<String, String> getUrlParam(String str) {
        String str2;
        if (str.contains("input_charset=1")) {
            try {
                str2 = EncodeUtils.gbk2utf8(URLDecoder.decode(str, "gbk"));
            } catch (UnsupportedEncodingException unused) {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        }
        return getSinalParam(str);
    }

    public void getUserAgent(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String ua = BussinessUtils.getUA(context);
        if (LightappUtils.parseJsonInt(str, "base64") == c) {
            ua = Base64.encodeToString(ua.getBytes(), 2);
        }
        LightAppUserAgentModel lightAppUserAgentModel = new LightAppUserAgentModel(0);
        lightAppUserAgentModel.cnt.data = ua;
        iLightappInvokerCallback.onResult(0, lightAppUserAgentModel.toJson());
    }

    public void initpay(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            try {
                str3 = (String) new JSONObject(str).get(LightappConstants.INIT_PAY_PARAM_INIT_PARAM);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            new HashMap().put("sp", str3);
        }
        str3 = "";
        new HashMap().put("sp", str3);
    }

    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        Context context2 = context;
        String str2 = str;
        ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str3 = (String) jSONObject.get(LightappConstants.LIGHT_APP_NATIVE_INVOKER_METHOD_NAME);
                this.A.put(str3, iLightappInvokerCallback2);
                if (TextUtils.isEmpty(str3)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    arrayList.add("method is null");
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, arrayList);
                    return;
                }
                String str4 = (String) jSONObject.get(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
                if (!JavascriptInterfaceManager.verifyPermission(new URL(str4), str3)) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(CheckUtils.stripUrlParams(str4));
                    arrayList2.add(str3);
                    LightappUtils.onError(iLightappInvokerCallback2, LightappConstants.ERRCODE_HOST_NOT_AUTHORITY, ResUtils.getString(context, "host_not_authority"), LightAppStatEvent.LIGHT_APP_NOT_INTERNAL_URL, (Collection<String>) arrayList2);
                } else if (METHOD_CALL_CAMERA.equals(str3)) {
                    callCamera(context, str, iLightappInvokerCallback2, str4);
                } else if (METHOD_CALL_QRCODE_SCANNER.equals(str3)) {
                    if (!LocalRouter.getInstance(context).isProviderExisted("saoyisao")) {
                        GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_not_include_tips"));
                    } else {
                        callQRCodeScanner(context, str, iLightappInvokerCallback2, str4);
                    }
                } else if (METHOD_CALL_ID_PHOTOS.equals(str3)) {
                    callIDPotos(context, str, iLightappInvokerCallback2, str4);
                } else if ("detectBankCard".equals(str3)) {
                    detectBankCard(context, str, iLightappInvokerCallback2, str4);
                } else if (METHOD_INIT_PAY.equals(str3)) {
                    initpay(context, str, iLightappInvokerCallback2, str4);
                } else if ("dopay".equals(str3)) {
                    dopay(context, str, iLightappInvokerCallback2, str4);
                } else if ("doBindCard".equals(str3)) {
                    doBindCard(context, str, iLightappInvokerCallback, str4, (String) null);
                } else if ("doRnAuth".equals(str3)) {
                    doRnAuth(context, str, iLightappInvokerCallback2, str4);
                } else if (METHOD_ACCESS_WALLET_SERVICE.equals(str3)) {
                    accessWalletService(context, str, iLightappInvokerCallback2, str4);
                } else if (METHOD_BD_LOGIN.equals(str3)) {
                    bdLogin(context, str, iLightappInvokerCallback2, str4);
                } else if (METHOD_GET_USER_AGENT.equals(str3)) {
                    getUserAgent(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_CALLPHONEINFO.equals(str3)) {
                    B(context, str, iLightappInvokerCallback2, str4);
                } else if ("setTitle".equals(str3)) {
                    u(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_SET_FULLSCREEN.equals(str3)) {
                    v(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_SETMENU.equals(str3)) {
                    y(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_H5GOBCK.equals(str3)) {
                    z(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_STATEVENT.equals(str3)) {
                    w(context, str, iLightappInvokerCallback2, str4);
                } else if (CALL_NATIVE_VOICE.equals(str3)) {
                    l(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_OPEN_IN_BROWSER.equals(str3)) {
                    x(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_DIGEST.equals(str3)) {
                    s(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_ENCRYPT.equals(str3)) {
                    a(context, str, iLightappInvokerCallback, str4, true);
                } else if (MTD_DECRYPT.equals(str3)) {
                    a(context, str, iLightappInvokerCallback, str4, false);
                } else if (MTD_BINDCARD_INDEPENDENT.equals(str3)) {
                    b(context, str, iLightappInvokerCallback, str4, true);
                } else if (MTD_BINDCARD_INITIATIVE.equals(str3)) {
                    b(context, str, iLightappInvokerCallback, str4, false);
                } else if ("selectPhonefromAdressBook".equals(str3)) {
                    t(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_CUSTOMER_SERVICE.equals(str3)) {
                    j(context, str, iLightappInvokerCallback2, str4);
                } else if ("getPayMethod".equals(str3)) {
                    getPayMethod(context, str, iLightappInvokerCallback2, str4);
                } else if ("changePayMethod".equals(str3)) {
                    changePayMethod(context, str, iLightappInvokerCallback2, str4);
                } else if ("preOrderPay".equals(str3)) {
                    preOrderPay(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_START_AUDIO_RECORD.equals(str3)) {
                    a(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_END_AUDIO_RECORD.equals(str3)) {
                    c(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_LIST_MY_BANK_CARD.equals(str3)) {
                    i(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_GET_SUPPORT_LIST.equals(str3)) {
                    getSupportedMethodList(context, str, iLightappInvokerCallback2, str4);
                } else if ("setRnAuthResult".equals(str3)) {
                    setRnAuthResultInMainThread(context, str, iLightappInvokerCallback2, str4);
                } else if ("postEvent".equals(str3)) {
                    postEvent(context, str, iLightappInvokerCallback2, str4);
                } else if (METHOD_DETECT_LIVENESS.equals(str3)) {
                    detectLiveness(context, str, iLightappInvokerCallback2, str4);
                } else if (METHOD_GET_SUPPORT_LIVENESS.equals(str3)) {
                    k(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_CALL_NATIVE_PHOTO.equals(str3)) {
                    C(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_GET_LOAD_TIME_LINE.equals(str3)) {
                    getLoadTimeLine(iLightappInvokerCallback2);
                } else if (MTD_GET_OFFLINE_INFO.equals(str3)) {
                    getOfflineCacheInfo(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_UPLOAD_MSG.equals(str3)) {
                    I(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_GO_TO_APP_SETTING.equals(str3)) {
                    b(context, jSONObject);
                } else if (MTD_SEND_TO_SMS.equals(str3)) {
                    F(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_GET_PERMISSION_STATE.equals(str3)) {
                    H(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_GET_PERMISSIOM_DIALOG_MSG.equals(str3)) {
                    G(context, str, iLightappInvokerCallback2, str4);
                } else if (MTD_OPEN_NEW_LIGHT_BRIDGE.equals(str3)) {
                    a(context, jSONObject, iLightappInvokerCallback, str4, a(jSONObject), b(jSONObject));
                } else {
                    Integer num = null;
                    if (MTD_SET_LIGHT_BRIDGE_STYLE.equals(str3)) {
                        Double a2 = a(jSONObject);
                        String b2 = b(jSONObject);
                        if (jSONObject.has(Constants.HALF_LIGHTBRIDGE_HIDE_ACTIONBAR)) {
                            num = Integer.valueOf(jSONObject.optInt(Constants.HALF_LIGHTBRIDGE_HIDE_ACTIONBAR, 0));
                        }
                        a(context, a2, b2, num, iLightappInvokerCallback);
                    } else if (MTD_MESSAGE_FORWARDING.equals(str3)) {
                        a(context, jSONObject, str4, iLightappInvokerCallback2);
                    } else if (MTD_ACCEPT_MESSAGE_FROM_LANGBRIDGE.equals(str3)) {
                        d(ACCEPT_MESSAGE_CB, str4);
                    } else if (MTD_UNREGISTER_MESSAGE_FROM_LANGBRIDGE.equals(str3)) {
                        d((String) null);
                    } else if (MTD_GOTO_DXM_PAY_SERVICE.equals(str3)) {
                        J(context, str, iLightappInvokerCallback2, str4);
                    } else if (MTD_SETSUBMENU.equals(str3)) {
                        K(context, str, iLightappInvokerCallback2, str4);
                    } else if (MTD_UNREGISTER_H5_GO_BACK.equals(str3)) {
                        setH5BackCb((ILightappInvokerCallback) null);
                    } else if (MTD_H5ClOSE.equals(str3)) {
                        A(context, str, iLightappInvokerCallback2, str4);
                    } else if (MTD_UNREGISTER_H5_CLOSE.equals(str3)) {
                        setH5Close((ILightappInvokerCallback) null);
                    } else if (MTD_SHOW_TITLE_FLOATVIEW.equals(str3)) {
                        a(str, iLightappInvokerCallback2);
                    } else if (MTD_CUSTOM_RIGHT_BUTTON.equals(str3)) {
                        b(str, iLightappInvokerCallback2);
                    } else if (MTD_PERMISSION_UNIVERSAL_SET.equals(str3)) {
                        a(context, str, iLightappInvokerCallback);
                    } else if (MTD_SAVE_PIC.equals(str3)) {
                        g(context, str, iLightappInvokerCallback2, str4);
                    } else if (MTD_SET_SCREEN_VERTICAL.equals(str3)) {
                        h(context, str, iLightappInvokerCallback2, str4);
                    } else if (MTD_RPA_PERCEPTIONL.equals(str3)) {
                        f(context, str, iLightappInvokerCallback2, str4);
                    } else if (MTD_INSERT_PHONE_NUM_TO_ADDRESS_BOOK.equals(str3)) {
                        e(context, str, iLightappInvokerCallback2, str4);
                    } else if (MTD_CALL_AUTOMATED_SUBMISSION.equals(str3)) {
                        com.baidu.wallet.lightapp.business.b.a.a(context, str, iLightappInvokerCallback2, str4);
                    } else if (MTD_H5REFRESH.equals(str3)) {
                        d(context, str, iLightappInvokerCallback2, str4);
                    } else if (MTD_UNREGISTER_H5_REFRESH.equals(str3)) {
                        setH5Refresh((ILightappInvokerCallback) null);
                    } else {
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_INVOKE_METHOD_NOT_SUPPORT, Arrays.asList(new String[]{str2}));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(str);
                arrayList3.add(e2.toString());
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, arrayList3);
            }
        } else if (iLightappInvokerCallback2 != null) {
            iLightappInvokerCallback2.onResult(1, "invalid options");
        }
    }

    public void login(String str, String str2, String str3) {
        LogUtil.d("bdLogin. options = " + str + ", success = " + str2 + ", fail = " + str3);
    }

    public void onContactsSelected(String str, int i2, String[] strArr, String str2, String str3) {
        final ContactSelectModel contactSelectModel = new ContactSelectModel();
        if (i2 != 0) {
            contactSelectModel.result = 1;
            if (TextUtils.equals(str2, "取消")) {
                contactSelectModel.cnt.errCode = "10005";
            } else {
                contactSelectModel.cnt.errCode = "10002";
            }
            contactSelectModel.cnt.des = str2;
            a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
        } else if (strArr != null) {
            String str4 = "";
            String str5 = strArr.length > 0 ? strArr[0] : str4;
            if (strArr.length > 1) {
                str4 = strArr[1];
            }
            contactSelectModel.result = 0;
            ContactSelectModel.SelectedContact selectedContact = contactSelectModel.cnt.selected;
            selectedContact.name = str5;
            selectedContact.phone = str4;
            if (r == w) {
                PhoneContactsMananger.a((Context) getActivity()).a((PhoneContactsMananger.d) new PhoneContactsMananger.d() {
                    public void a(List<ContactSelectModel.AllContact> list, int i2) {
                        if (LightappBusinessClient.u != null) {
                            contactSelectModel.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), LightappBusinessClient.u));
                        } else {
                            contactSelectModel.cnt.all = list;
                        }
                        if (LightappBusinessClient.t == LightappBusinessClient.B) {
                            LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                            ContactSelectModel contactSelectModel = contactSelectModel;
                            lightAppContactSelectModelBase64.result = contactSelectModel.result;
                            ContactSelectModel.Data data = contactSelectModel.cnt;
                            if (data != null) {
                                lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data).getBytes());
                            }
                            LightappBusinessClient.this.a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
                            return;
                        }
                        LightappBusinessClient.this.a("selectPhonefromAdressBook", 0, contactSelectModel.toJson());
                    }
                });
                if (s > 0) {
                    PhoneContactsMananger.a((Context) getActivity()).a(s, false);
                } else {
                    PhoneContactsMananger.a((Context) getActivity()).a(1000, false);
                }
            } else if (t == B) {
                LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                lightAppContactSelectModelBase64.result = contactSelectModel.result;
                ContactSelectModel.Data data = contactSelectModel.cnt;
                if (data != null) {
                    lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data).getBytes());
                }
                a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
            } else {
                a("selectPhonefromAdressBook", 0, contactSelectModel.toJson());
            }
        }
    }

    public void onInsertPhoneNumToAddressBookResult(int i2, String str, String str2) {
        if (i2 == 0) {
            a(MTD_INSERT_PHONE_NUM_TO_ADDRESS_BOOK, 0, LightappUtils.assembleResult(0, new JSONObject()));
        } else {
            a(MTD_INSERT_PHONE_NUM_TO_ADDRESS_BOOK, 1, LightappUtils.assembleFailResultWithErrCode(str, str2));
        }
    }

    public void onRequestPermissionsResult(String str, int i2, String[] strArr, int[] iArr) {
        b bVar;
        CommonPermissionCallback commonPermissionCallback = this.K;
        ILightappInvokerCallback iLightappInvokerCallback = null;
        if (commonPermissionCallback != null) {
            commonPermissionCallback.onRequestPermissionsResult(i2, strArr, iArr);
            this.K = null;
        }
        if (244 == i2) {
            b bVar2 = this.I.get(MTD_START_AUDIO_RECORD);
            if (strArr == null || iArr == null || strArr.length == 0 || iArr.length == 0) {
                if (bVar2 != null) {
                    iLightappInvokerCallback = bVar2.c;
                }
                LightappUtils.onError(iLightappInvokerCallback, str, "10002", "无录音权限", "startRecordingFail");
                return;
            }
            return;
        }
        int i3 = 0;
        if (243 == i2) {
            if (strArr == null || iArr == null || strArr.length == 0 || iArr.length == 0) {
                b(str);
                return;
            }
            while (i3 < strArr.length) {
                if (!"android.permission.READ_CONTACTS".equalsIgnoreCase(strArr[i3])) {
                    i3++;
                } else if (i3 < iArr.length) {
                    int i4 = iArr[i3];
                    if (i4 == 0) {
                        com.baidu.wallet.lightapp.multipage.a aVar = this.C;
                        if (aVar != null) {
                            aVar.selectPhoneFromAddressBook();
                            return;
                        }
                        return;
                    } else if (i4 == -1) {
                        b(str);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (245 == i2 || 246 == i2) {
            if (strArr == null || iArr == null || strArr.length == 0 || iArr.length == 0) {
                c("没有相机和存储权限");
                return;
            }
            while (i3 < strArr.length) {
                if ("android.permission.CAMERA".equalsIgnoreCase(strArr[i3])) {
                    if (i3 < iArr.length && iArr[i3] == -1) {
                        c(EnterDxmPayServiceAction.ERROR_MSG_PERMISSION);
                        return;
                    }
                } else if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i3]) && i3 < iArr.length && iArr[i3] == -1) {
                    c("没有存储权限");
                    return;
                }
                i3++;
            }
            if (245 == i2) {
                p(getActivity(), this.f3569o, this.p, str);
            } else if (246 == i2) {
                r(getActivity(), this.f3569o, this.p, str);
            }
        } else if (i2 == 4) {
            if (strArr == null || iArr == null || strArr.length == 0 || iArr.length == 0) {
                c(MTD_CALL_NATIVE_PHOTO, "没有存储权限");
                return;
            }
            while (i3 < strArr.length) {
                if (!"android.permission.READ_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i3]) || i3 >= iArr.length || iArr[i3] != -1) {
                    i3++;
                } else {
                    c(MTD_CALL_NATIVE_PHOTO, "没有存储权限");
                    return;
                }
            }
            if (this.q.contains("multipleMaxCount")) {
                a((Context) getActivity(), this.q, str);
            } else {
                this.C.loadAlubm(this.q);
            }
        } else if (247 == i2) {
            if (strArr == null || iArr == null || strArr.length == 0 || iArr.length == 0) {
                b("", "获取权限失败");
                return;
            }
            while (i3 < strArr.length) {
                if ("android.permission.CAMERA".equalsIgnoreCase(strArr[i3])) {
                    if (i3 < iArr.length && iArr[i3] == -1) {
                        b("android.permission.CAMERA", "无相机权限");
                        return;
                    }
                } else if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i3])) {
                    if (i3 < iArr.length && iArr[i3] == -1) {
                        b(StorageUtils.EXTERNAL_STORAGE_PERMISSION, "无相机存储权限");
                        return;
                    }
                } else if ("android.permission.READ_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i3])) {
                    if (i3 < iArr.length && iArr[i3] == -1) {
                        b("android.permission.READ_EXTERNAL_STORAGE", "无相册访问权限");
                        return;
                    }
                } else if ("android.permission.ACCESS_FINE_LOCATION".equalsIgnoreCase(strArr[i3])) {
                    if (i3 < iArr.length && iArr[i3] == -1) {
                        b("android.permission.ACCESS_FINE_LOCATION", "无位置访问权限");
                        return;
                    }
                } else if ("android.permission.RECORD_AUDIO".equalsIgnoreCase(strArr[i3]) && i3 < iArr.length && iArr[i3] == -1) {
                    b("android.permission.RECORD_AUDIO", "无麦克风访问权限");
                    return;
                }
                i3++;
            }
            e();
        } else if (248 == i2 && (bVar = this.I.get(MTD_SAVE_PIC)) != null) {
            if (strArr == null || iArr == null || strArr.length == 0 || iArr.length == 0) {
                LightappUtils.onError(bVar.c, str, "10002", "无储存权限", "savePicFail");
                return;
            }
            while (i3 < strArr.length) {
                if (!StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i3]) || i3 >= iArr.length || iArr[i3] != -1) {
                    i3++;
                } else {
                    LightappUtils.onError(bVar.c, str, "10002", "无储存权限", "savePicFail");
                    return;
                }
            }
            b(bVar.a, bVar.b, bVar.c);
        }
    }

    public void postEvent(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("event_key");
            String string2 = jSONObject.getString("event_value");
            if (!TextUtils.isEmpty(string)) {
                if (!TextUtils.isEmpty(string2)) {
                    byte[] decode = Base64.decode(string2, 2);
                    if (decode == null) {
                        string2 = "";
                    } else {
                        string2 = new String(decode);
                    }
                }
                EventBus instance = EventBus.getInstance();
                Objects.requireNonNull(instance);
                EventBus.getInstance().post(new EventBus.Event(string, string2));
                LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterDoPostEvent").data("event_key", string).data("event_value", string2), new RouterCallback() {
                    public void onResult(int i2, HashMap hashMap) {
                    }
                });
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, "");
                }
            }
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#postEventFail");
        }
    }

    public void preOrderPay(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        if (iLightappInvokerCallback == null) {
            b("preOrderPay", 1, "callback is null");
        } else {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterPreOrderPay").data("options", str), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 != 0) {
                        String str = (String) hashMap.get("errorMsg");
                        ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                        String str2 = str2;
                        String num = Integer.toString(i2);
                        if (TextUtils.isEmpty(str)) {
                            str = LightappConstants.ROUTER_INVOKE_FAIL;
                        }
                        LightappUtils.onError(iLightappInvokerCallback, str2, num, str, "#preOrderPayFail");
                    } else if (hashMap == null || hashMap.size() <= 0) {
                        iLightappInvokerCallback.onResult(1, "resultData is null");
                    } else {
                        String str3 = (String) hashMap.get("result");
                        if (!TextUtils.isEmpty(str3)) {
                            try {
                                if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                                    iLightappInvokerCallback.onResult(0, str3);
                                } else {
                                    iLightappInvokerCallback.onResult(1, str3);
                                }
                            } catch (JSONException e) {
                                iLightappInvokerCallback.onResult(1, "result 解析异常");
                                e.printStackTrace();
                            }
                        } else {
                            iLightappInvokerCallback.onResult(1, "result is null");
                        }
                    }
                }
            });
        }
    }

    public void setAlubmPhotoData(int i2, JSONObject jSONObject) {
        String str = this.b;
        LogUtil.d(str, "resultCode = " + i2 + " ; jsonObject = " + jSONObject.toString());
        a(MTD_CALL_NATIVE_PHOTO, i2, LightappUtils.assembleResult(i2, jSONObject));
    }

    public void setH5BackCb(ILightappInvokerCallback iLightappInvokerCallback) {
        this.D = iLightappInvokerCallback;
    }

    public void setH5Close(ILightappInvokerCallback iLightappInvokerCallback) {
        this.E = iLightappInvokerCallback;
    }

    public void setH5Refresh(ILightappInvokerCallback iLightappInvokerCallback) {
        this.F = iLightappInvokerCallback;
    }

    public void setRnAuthResult(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        String str3 = "";
        LogUtil.d("lightapp", "setRnAuthResult url = " + str2);
        if (!TextUtils.isEmpty(str)) {
            int i2 = -1;
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    int intValue = ((Integer) jSONObject.get("rnauth_result")).intValue();
                    try {
                        String str4 = (String) jSONObject.get("rnauth_des");
                        try {
                            iLightappInvokerCallback.onResult(0, str3);
                            LogUtil.d("langbrige", "setRnAuthResult OK");
                            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(intValue)).data("desc", str4), new RouterCallback() {
                                public void onResult(int i2, HashMap hashMap) {
                                    if (i2 != 0) {
                                        LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i2), "invoke_method_fail_from_router", "#setRnAuthResultFail");
                                        return;
                                    }
                                    String str = (String) hashMap.get("errorMsg");
                                    ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                                    String str2 = str2;
                                    String num = Integer.toString(i2);
                                    if (!TextUtils.isEmpty(str)) {
                                        str = LightappConstants.ROUTER_INVOKE_FAIL;
                                    }
                                    LightappUtils.onError(iLightappInvokerCallback, str2, num, str, "#setRnAuthResultFail");
                                }
                            });
                        } catch (JSONException e2) {
                            e = e2;
                            str3 = str4;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        i2 = intValue;
                        e.printStackTrace();
                        LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i2), str3, "#setRnAuthResultFail");
                    }
                } catch (JSONException e4) {
                    e = e4;
                    e.printStackTrace();
                    LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i2), str3, "#setRnAuthResultFail");
                }
            } catch (JSONException e5) {
                e5.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i2), str3, "#setRnAuthResultFail");
            }
        }
    }

    public void setRnAuthResultInMainThread(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        final Context context2 = context;
        final String str3 = str;
        final ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        final String str4 = str2;
        AnonymousClass2 r0 = new Runnable() {
            public void run() {
                LightappBusinessClient.this.setRnAuthResult(context2, str3, iLightappInvokerCallback2, str4);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r0);
        }
    }

    private void d(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        DXMSdkSAUtils.onEventWithValues(MTD_H5REFRESH, Arrays.asList(new String[]{CheckUtils.stripUrlParams(str2)}));
        setH5Refresh(iLightappInvokerCallback);
    }

    private void e(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("mobile");
            String optString2 = jSONObject.optString("name");
            if (!TextUtils.isEmpty(optString)) {
                if (!TextUtils.isEmpty(optString2)) {
                    this.C.insertPhoneNumToAddressBook(optString2, optString);
                    return;
                }
            }
            onInsertPhoneNumToAddressBookResult(1, LightappConstants.ERRCODE_INVALID_PARAMETER, "传入参数非法");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        com.baidu.wallet.lightapp.multipage.a aVar = this.C;
        if (aVar != null) {
            aVar.rpaPerception(context, str, iLightappInvokerCallback, str2);
        }
    }

    private void c(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        a aVar = new a();
        aVar.e = iLightappInvokerCallback;
        aVar.g = str2;
        Handler handler = this.H;
        handler.sendMessageDelayed(handler.obtainMessage(2, aVar), 300);
    }

    private boolean d() {
        if (!this.z) {
            try {
                this.l = Class.forName("com.sensetime.liveness.motion.api.SenseLiveness");
                Class<?> cls = Class.forName("com.sensetime.liveness.motion.api.SenseLivenessCallback");
                this.n = cls;
                this.m = this.l.getDeclaredMethod("startDetect", new Class[]{Context.class, String.class, cls});
            } catch (Throwable th2) {
                this.z = true;
                throw th2;
            }
            this.z = true;
        }
        if (this.l == null || this.n == null || this.m == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void b(a aVar) {
        try {
            AudioRecorder instance = AudioRecorder.getInstance();
            instance.end();
            aVar.e.onResult(0, "{\"result\":0}");
            LogUtil.d("AudioRecorder", "endRecoding  state:" + instance.getState());
        } catch (Exception e2) {
            LightappUtils.onError(aVar.e, aVar.g, "10003", e2.getLocalizedMessage(), "endRecordingFail");
        }
    }

    private void c(String str) {
        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
        data.errCode = "10002";
        data.des = str;
        a(CALL_NATIVE_VOICE, 1, lightAppErrorModel.toJson());
    }

    private void a(String str, String str2) {
        LogUtil.logd("method:" + str + "options=" + str2);
    }

    private void a(final Context context, int i2, final ILightappInvokerCallback iLightappInvokerCallback, final String str, boolean z2) {
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("idcarddetect").action("enterIdCardDetect").data("type", Integer.valueOf(i2)).data("showAlbum", Boolean.valueOf(z2)).data("fromLangbridge", Boolean.TRUE), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 0) {
                    if (hashMap == null || hashMap.size() <= 0) {
                        LightappUtils.onError(iLightappInvokerCallback, str, Integer.toString(i2), "数据返回为空", "#callIDPotosFail");
                        return;
                    }
                    Bundle bundle = (Bundle) hashMap.get("result");
                    if (bundle != null) {
                        bundle.getInt("step");
                        String string = bundle.getString("pic1");
                        final String string2 = bundle.getString("pic2");
                        final LightAppCallIDPhotoModel lightAppCallIDPhotoModel = new LightAppCallIDPhotoModel(0);
                        ImageBase64Utils instance = ImageBase64Utils.getInstance();
                        final String str = string;
                        final ImageBase64Utils imageBase64Utils = instance;
                        instance.getImageBase64(string, 640, (ImageBase64Utils.ImageBase64Listener) new ImageBase64Utils.ImageBase64Listener() {
                            public void onBase64Result(String str) {
                                lightAppCallIDPhotoModel.cnt.front = str;
                                imageBase64Utils.getImageBase64(string2, 640, (ImageBase64Utils.ImageBase64Listener) new ImageBase64Utils.ImageBase64Listener() {
                                    public void onBase64Result(String str) {
                                        AnonymousClass1 r0 = AnonymousClass1.this;
                                        LightAppCallIDPhotoModel lightAppCallIDPhotoModel = lightAppCallIDPhotoModel;
                                        lightAppCallIDPhotoModel.cnt.back = str;
                                        iLightappInvokerCallback.onResult(0, lightAppCallIDPhotoModel.toJson());
                                        try {
                                            if (str != null) {
                                                File file = new File(str);
                                                if (file.exists()) {
                                                    file.delete();
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th2.printStackTrace();
                                        }
                                        try {
                                            if (string2 != null) {
                                                File file2 = new File(string2);
                                                if (file2.exists()) {
                                                    file2.delete();
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th3.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });
                    }
                } else if (i2 != 1) {
                    String str2 = (String) hashMap.get("errorMsg");
                    ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                    String str3 = str;
                    String num = Integer.toString(i2);
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    LightappUtils.onError(iLightappInvokerCallback, str3, num, str2, "#callIDPotosFail");
                } else if (hashMap != null && hashMap.size() > 0) {
                    int intValue = ((Integer) hashMap.get("errCode")).intValue();
                    String str4 = (String) hashMap.get("errMsg");
                    if (intValue == -1) {
                        LightappUtils.onError(iLightappInvokerCallback, str, "10002", LightappBusinessClient.this.a(context, "访问相机的权限"), "#callIDPotosFail");
                    } else if (-2 == intValue) {
                        LightappUtils.onError(iLightappInvokerCallback, str, "10005", "取消", "#callIDPotosFail");
                    }
                }
            }
        });
    }

    private void e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errCode", String.valueOf(0));
            jSONObject.put("des", "成功打开权限");
            a(MTD_PERMISSION_UNIVERSAL_SET, 0, LightappUtils.assembleResult(0, jSONObject));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void c(String str, String str2) {
        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
        data.errCode = "10002";
        data.des = str2;
        a(str, 1, lightAppErrorModel.toJson());
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            if (PermissionManager.checkCallingPermission(context, "android.permission.RECORD_AUDIO")) {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("callback", (String) null);
                if (LightappJsClient.isJsFunNameValid(optString)) {
                    a aVar = new a();
                    if (!"stereo".equals(jSONObject.optString("channelType", "mono"))) {
                        aVar.b = 16;
                    } else {
                        aVar.b = 12;
                    }
                    int optInt = jSONObject.optInt("samplingAccuracy", 16);
                    aVar.c = optInt;
                    if (8 != optInt) {
                        aVar.c = 2;
                    } else {
                        aVar.c = 3;
                    }
                    aVar.a = jSONObject.optInt("samplingRate", PermissionsHelperActivity.e);
                    aVar.d = jSONObject.optInt("maxChunkSize", 2048);
                    aVar.f = optString;
                    aVar.e = iLightappInvokerCallback;
                    aVar.g = str2;
                    this.H.obtainMessage(1, aVar).sendToTarget();
                    return;
                }
                throw new InvalidParameterException("invalid parameter [callback]:" + optString);
            }
            throw new AccessControlException("android.permission.RECORD_AUDIO");
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, e2 instanceof AccessControlException ? "10002" : LightappConstants.ERRCODE_INVALID_PARAMETER, e2.toString(), "startRecordingFail");
        }
    }

    /* access modifiers changed from: private */
    public void a(final a aVar) {
        try {
            LogUtil.d("AudioRecorder", MTD_START_AUDIO_RECORD);
            if (getActivity() != null) {
                final AudioRecorder instance = AudioRecorder.getInstance();
                if (instance.init(aVar.a, aVar.b, aVar.c, aVar.d)) {
                    aVar.h = UUID.randomUUID().toString();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("result", 0);
                    jSONObject.put("recordId", aVar.h);
                    aVar.e.onResult(0, jSONObject.toString());
                    final JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("recordId", aVar.h);
                    jSONObject2.put("hasNext", 1);
                    instance.addObserver(new Observer() {
                        public AudioVolume a = new AudioVolume(4000);

                        public void update(Observable observable, Object obj) {
                            if (instance == observable && LightappBusinessClient.this.getActivity() != null) {
                                boolean z = false;
                                if (obj instanceof ByteBuffer) {
                                    ByteBuffer byteBuffer = (ByteBuffer) obj;
                                    AudioVolume audioVolume = this.a;
                                    if (2 == aVar.c) {
                                        z = true;
                                    }
                                    audioVolume.calAccumulatedVolume(byteBuffer, z);
                                    try {
                                        jSONObject2.put("volume", this.a.getVolume());
                                        LogUtil.d("volume", "update: " + this.a);
                                        jSONObject2.put("data", Base64.encodeToString(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining(), 2));
                                        LightappBusinessClient.this.getActivity().runOnUiThread(new Runnable() {
                                            public void run() {
                                                try {
                                                    LightappBusinessClient.this.C.executeJsFunction(aVar.f, jSONObject2.toString());
                                                } catch (Exception e) {
                                                    LogUtil.e("audioData", "update error: ", e);
                                                }
                                            }
                                        });
                                    } catch (Exception e2) {
                                        LogUtil.e("audioData", "update: ", e2);
                                    }
                                } else if ((obj instanceof AudioRecorder.State) && AudioRecorder.State.STOP == ((AudioRecorder.State) obj)) {
                                    try {
                                        jSONObject2.put("hasNext", 0);
                                        jSONObject2.remove("data");
                                        jSONObject2.remove("volume");
                                        LightappBusinessClient.this.getActivity().runOnUiThread(new Runnable() {
                                            public void run() {
                                                try {
                                                    LightappBusinessClient.this.C.executeJsFunction(aVar.f, jSONObject2.toString());
                                                } catch (Exception e) {
                                                    LogUtil.e("audioData", "update error: ", e);
                                                }
                                            }
                                        });
                                    } catch (Exception e3) {
                                        LogUtil.e("audioData", "update: ", e3);
                                    }
                                }
                            }
                        }
                    });
                    instance.setState(AudioRecorder.State.RUNNING);
                    new Thread(instance).start();
                    LogUtil.i(MTD_START_AUDIO_RECORD, "ar-->" + instance);
                    return;
                }
                throw new Exception("can not acquire audio recorder");
            }
            throw new IllegalStateException("activity null");
        } catch (Exception e2) {
            LightappUtils.onError(aVar.e, aVar.g, "10003", e2.getLocalizedMessage(), "startRecordingFail");
        }
    }

    private boolean e(String str) {
        return a(str, -1, "");
    }

    private void d(String str, String str2) {
        d(str);
    }

    private void d(String str) {
        a = str;
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (!PermissionManager.checkCallingPermission(context, "android.permission.RECORD_AUDIO")) {
            final Context context2 = context;
            final String str3 = str;
            final ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
            final String str4 = str2;
            this.K = BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                public void isAllAgree(Boolean bool) {
                    if (LightappBusinessClient.this.I == null) {
                        HashMap unused = LightappBusinessClient.this.I = new HashMap();
                    }
                    LightappBusinessClient.this.I.put(LightappBusinessClient.MTD_START_AUDIO_RECORD, new b(context2, str3, iLightappInvokerCallback2, str4));
                    if (!bool.booleanValue()) {
                        LightappBusinessClient.this.onRequestPermissionsResult("", LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO, new String[]{"android.permission.RECORD_AUDIO"}, new int[]{-1});
                    } else if (!PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO)) {
                        LightappUtils.onError(iLightappInvokerCallback2, str4, "10002", "无录音权限", "startRecordingFail");
                    }
                }

                public void isShow(String str, Boolean bool) {
                }

                public void requestResult(String str, Boolean bool) {
                }
            });
            return;
        }
        b(context, str, iLightappInvokerCallback, str2);
    }

    private String b(JSONObject jSONObject) {
        if (jSONObject.has(Constants.HALF_LIGHTBRIDGE_TRANSLUCENCY_COLOR)) {
            return jSONObject.optString(Constants.HALF_LIGHTBRIDGE_TRANSLUCENCY_COLOR);
        }
        return null;
    }

    private Double a(JSONObject jSONObject) {
        if (jSONObject.has(Constants.HALF_LIGHTBRIDGE_HEIGHT)) {
            return Double.valueOf(jSONObject.optDouble(Constants.HALF_LIGHTBRIDGE_HEIGHT));
        }
        return null;
    }

    private void b(String str, ILightappInvokerCallback iLightappInvokerCallback) {
        if (this.C != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                TitleBarParams.b bVar = new TitleBarParams.b();
                if (jSONObject.has("left_params")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("left_params");
                    if (jSONObject2.has("show_goback_button")) {
                        TitleBarParams.c cVar = new TitleBarParams.c();
                        cVar.a = jSONObject2.optString("show_goback_button");
                        bVar.a(cVar);
                    }
                }
                if (jSONObject.has("bar_params")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("bar_params");
                    if (jSONObject3.has("show_title")) {
                        TitleBarParams.a aVar = new TitleBarParams.a();
                        aVar.a = jSONObject3.optString("show_title");
                        bVar.a(aVar);
                    }
                }
                String optString = jSONObject.optString("show_more_default");
                bVar.a(optString);
                if (!TextUtils.equals("1", optString)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("right_params");
                    if (!optJSONArray.isNull(0)) {
                        JSONObject jSONObject4 = optJSONArray.getJSONObject(0);
                        if (jSONObject4.has("title") && jSONObject4.has("callback")) {
                            TitleBarParams.d dVar = new TitleBarParams.d();
                            dVar.a = jSONObject4.optString("title");
                            dVar.c = jSONObject4.optString("text_color");
                            dVar.b = jSONObject4.optString("callback");
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(dVar);
                            bVar.a((List<TitleBarParams.d>) arrayList);
                        }
                    }
                }
                this.C.customNaviBar(bVar.a());
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, "");
                }
            } catch (Exception e2) {
                LightappUtils.onError(iLightappInvokerCallback, "", "10003", e2.getLocalizedMessage(), "#customRightButtonFail");
            }
        }
    }

    private void a(String str, ILightappInvokerCallback iLightappInvokerCallback) {
        if (this.C != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean equals = TextUtils.equals("1", jSONObject.optString("isShowTitleFloatView", ""));
                String optString = jSONObject.optString("titleFloatViewColor", (String) null);
                if (!equals || !TextUtils.isEmpty(optString)) {
                    this.C.showTitleFloatView(equals, optString);
                    if (iLightappInvokerCallback != null) {
                        iLightappInvokerCallback.onResult(0, "");
                        return;
                    }
                    return;
                }
                LightappUtils.onError(iLightappInvokerCallback, "", LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 titleFloatViewColor值为空", "#showTitleFloatViewFail");
            } catch (Exception e2) {
                LightappUtils.onError(iLightappInvokerCallback, "", LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#showTitleFloatViewFail");
            }
        }
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        try {
            String optString = new JSONObject(str).optString("permission_type");
            String[] strArr = null;
            char c2 = 65535;
            boolean z2 = true;
            switch (optString.hashCode()) {
                case 49:
                    if (optString.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (optString.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (optString.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 52:
                    if (optString.equals("4")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                strArr = new String[]{"android.permission.CAMERA", StorageUtils.EXTERNAL_STORAGE_PERMISSION};
            } else if (c2 == 1) {
                strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
            } else if (c2 == 2) {
                strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
            } else if (c2 == 3) {
                strArr = new String[]{"android.permission.RECORD_AUDIO"};
            }
            if (strArr != null) {
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        if (!PermissionManager.checkCallingPermission(context, strArr[i2])) {
                            PermissionManager.checkCallingOrSelfPermission(getActivity(), strArr, REQUEST_PERMISSION_UNIVERSAL_SET);
                            z2 = false;
                        } else {
                            i2++;
                        }
                    }
                }
                if (z2 && iLightappInvokerCallback != null) {
                    LightAppCommonModel lightAppCommonModel = new LightAppCommonModel(0);
                    lightAppCommonModel.cnt.errCode = String.valueOf(0);
                    lightAppCommonModel.cnt.des = "已经有权限了";
                    iLightappInvokerCallback.onResult(0, lightAppCommonModel.toJson());
                    return;
                }
                return;
            }
            LightappUtils.onError(iLightappInvokerCallback, "", LightappConstants.ERRCODE_INVALID_PARAMETER, "type value error", "#permissionUniversalSetFail");
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, "", LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#permissionUniversalSetFail");
        }
    }

    private void a(final Context context, HashMap hashMap, final ILightappInvokerCallback iLightappInvokerCallback, final String str) {
        if (LocalRouter.getInstance(context).isProviderExisted("livenessidentifyauth")) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("livenessidentifyauth").action("livenessidentifyauth").data(hashMap), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 == 0) {
                        if (hashMap != null) {
                            Object obj = hashMap.get("value");
                            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                                try {
                                    LightAppCommonModel lightAppCommonModel = new LightAppCommonModel(0);
                                    lightAppCommonModel.cnt.errCode = String.valueOf(0);
                                    lightAppCommonModel.cnt.des = "成功";
                                    lightAppCommonModel.cnt.data = (HashMap) JsonUtils.fromJson((String) obj, HashMap.class);
                                    iLightappInvokerCallback.onResult(0, lightAppCommonModel.toJson());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    LightappUtils.onError(iLightappInvokerCallback, str, i2 + "", PhoneUtils.getApplicationName(context) + ((String) hashMap.get("errorMsg")), "#identifyAuthFail");
                                }
                            }
                        }
                    } else if (i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "livenessidentifyauth");
                        hashMap2.put("action", "livenessidentifyauth");
                        DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        LightappUtils.onError(iLightappInvokerCallback, str, "10004", "没有找到对应的方法", "#identifyAuthFail");
                    } else {
                        LightappUtils.onError(iLightappInvokerCallback, str, i2 + "", PhoneUtils.getApplicationName(context) + ((String) hashMap.get("errorMsg")), "#identifyAuthFail");
                    }
                }
            });
        } else {
            LightappUtils.onError(iLightappInvokerCallback, str, "10004", "没有找到对应的方法", "#identifyAuthFail");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0205 A[SYNTHETIC, Splitter:B:103:0x0205] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x021b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0253 A[SYNTHETIC, Splitter:B:123:0x0253] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0281 A[SYNTHETIC, Splitter:B:137:0x0281] */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Context r17, java.lang.String r18, com.baidu.wallet.api.ILightappInvokerCallback r19) {
        /*
            r16 = this;
            r1 = r19
            java.lang.String r2 = "10003"
            java.lang.String r3 = "10001"
            java.lang.String r4 = "is_pending"
            java.lang.String r5 = ""
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r6 = "mounted"
            boolean r0 = r0.equals(r6)
            r6 = 1
            if (r0 != 0) goto L_0x001d
            java.lang.String r0 = "设备没有挂载外部储存设备"
            r1.onResult(r6, r0)
            return
        L_0x001d:
            r7 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0230, all -> 0x01e2 }
            r9 = r18
            r0.<init>(r9)     // Catch:{ JSONException -> 0x0230, all -> 0x01e2 }
            java.lang.String r9 = "data"
            java.lang.String r9 = r0.optString(r9, r5)     // Catch:{ JSONException -> 0x0230, all -> 0x01e2 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ JSONException -> 0x0230, all -> 0x01e2 }
            if (r10 == 0) goto L_0x0037
            java.lang.String r0 = "没有图片数据"
            com.baidu.wallet.lightapp.base.utils.LightappUtils.onError((com.baidu.wallet.api.ILightappInvokerCallback) r1, (java.lang.String) r5, (java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r5)     // Catch:{ JSONException -> 0x0230, all -> 0x01e2 }
            return
        L_0x0037:
            r10 = 2
            byte[] r9 = android.util.Base64.decode(r9, r10)     // Catch:{ JSONException -> 0x0230, all -> 0x01e2 }
            int r10 = r9.length     // Catch:{ JSONException -> 0x0230, all -> 0x01e2 }
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeByteArray(r9, r7, r10)     // Catch:{ JSONException -> 0x0230, all -> 0x01e2 }
            java.lang.String r10 = "quality"
            r11 = 4604930618986332160(0x3fe8000000000000, double:0.75)
            double r10 = r0.optDouble(r10, r11)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r12 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r10 = r10 * r12
            int r10 = (int) r10     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            if (r10 < 0) goto L_0x0054
            r11 = 100
            if (r10 <= r11) goto L_0x0056
        L_0x0054:
            r10 = 75
        L_0x0056:
            java.lang.String r11 = "folder"
            java.lang.String r0 = r0.optString(r11, r5)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r12 = 29
            java.lang.String r13 = ".jpg"
            java.lang.String r14 = "/"
            if (r11 < r12) goto L_0x0122
            android.content.ContentResolver r11 = r17.getContentResolver()     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ JSONException -> 0x011d, all -> 0x0118 }
            r12.<init>()     // Catch:{ JSONException -> 0x011d, all -> 0x0118 }
            java.lang.String r15 = "_display_name"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r8.<init>()     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r8.append(r6)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r8.append(r13)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            java.lang.String r6 = r8.toString()     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r12.put(r15, r6)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            java.lang.String r6 = "mime_type"
            java.lang.String r7 = "image/jpeg"
            r12.put(r6, r7)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            java.lang.String r6 = "relative_path"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r7.<init>()     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            java.lang.String r8 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r7.append(r8)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r7.append(r14)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r7.append(r0)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            java.lang.String r0 = r7.toString()     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r12.put(r6, r0)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r0 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            r12.put(r4, r0)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            android.net.Uri r6 = r11.insert(r0, r12)     // Catch:{ JSONException -> 0x0113, all -> 0x010e }
            java.io.OutputStream r7 = r11.openOutputStream(r6)     // Catch:{ JSONException -> 0x010c, all -> 0x0107 }
            if (r7 != 0) goto L_0x00e8
            java.lang.String r0 = "图片保存失败！未获取到图片输出流"
            com.baidu.wallet.lightapp.base.utils.LightappUtils.onError((com.baidu.wallet.api.ILightappInvokerCallback) r1, (java.lang.String) r5, (java.lang.String) r2, (java.lang.String) r0, (java.lang.String) r5)     // Catch:{ JSONException -> 0x0104, all -> 0x00ff }
            if (r7 == 0) goto L_0x00cb
            r7.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00cb
        L_0x00c6:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x00cb:
            if (r9 == 0) goto L_0x00d6
            boolean r0 = r9.isRecycled()
            if (r0 != 0) goto L_0x00d6
            r9.recycle()
        L_0x00d6:
            if (r11 == 0) goto L_0x00e7
            r12.clear()
            r1 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r12.put(r4, r0)
            r1 = 0
            r11.update(r6, r12, r1, r1)
        L_0x00e7:
            return
        L_0x00e8:
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ JSONException -> 0x0104, all -> 0x00ff }
            r9.compress(r0, r10, r7)     // Catch:{ JSONException -> 0x0104, all -> 0x00ff }
            r7.flush()     // Catch:{ JSONException -> 0x0104, all -> 0x00ff }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0104, all -> 0x00ff }
            r0.<init>()     // Catch:{ JSONException -> 0x0104, all -> 0x00ff }
            r8 = 0
            java.lang.String r0 = com.baidu.wallet.lightapp.base.utils.LightappUtils.assembleResult((int) r8, (org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x0104, all -> 0x00ff }
            r1.onResult(r8, r0)     // Catch:{ JSONException -> 0x0104, all -> 0x00ff }
            goto L_0x01b8
        L_0x00ff:
            r0 = move-exception
            r8 = r6
            r6 = r7
            goto L_0x01e8
        L_0x0104:
            r0 = move-exception
            goto L_0x0236
        L_0x0107:
            r0 = move-exception
            r8 = r6
            r6 = 0
            goto L_0x01e8
        L_0x010c:
            r0 = move-exception
            goto L_0x0115
        L_0x010e:
            r0 = move-exception
            r6 = 0
            r8 = 0
            goto L_0x01e8
        L_0x0113:
            r0 = move-exception
            r6 = 0
        L_0x0115:
            r7 = 0
            goto L_0x0236
        L_0x0118:
            r0 = move-exception
            r6 = 0
            r8 = 0
            goto L_0x01e7
        L_0x011d:
            r0 = move-exception
            r6 = 0
            r7 = 0
            goto L_0x0235
        L_0x0122:
            java.io.File r6 = new java.io.File     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r7.<init>()     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            java.lang.String r8 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            java.io.File r8 = android.os.Environment.getExternalStoragePublicDirectory(r8)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r7.append(r8)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r7.append(r14)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r7.append(r0)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            java.lang.String r0 = r7.toString()     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r6.<init>(r0)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            boolean r0 = r6.exists()     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            if (r0 != 0) goto L_0x015d
            boolean r0 = r6.mkdirs()     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            if (r0 != 0) goto L_0x015d
            java.lang.String r0 = "图片保存失败！未成功创建文件保存路径"
            r6 = 1
            r1.onResult(r6, r0)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            if (r9 == 0) goto L_0x015c
            boolean r0 = r9.isRecycled()
            if (r0 != 0) goto L_0x015c
            r9.recycle()
        L_0x015c:
            return
        L_0x015d:
            java.io.File r0 = new java.io.File     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r7.<init>()     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r7.append(r11)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r7.append(r13)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r0.<init>(r6, r7)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            r6.<init>(r0)     // Catch:{ JSONException -> 0x01de, all -> 0x01da }
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r9.compress(r7, r10, r6)     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r6.flush()     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            android.content.Intent r7 = new android.content.Intent     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            java.lang.String r8 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r10.<init>()     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            java.lang.String r11 = "file://"
            r10.append(r11)     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            java.lang.String r0 = r0.getPath()     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r10.append(r0)     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            java.lang.String r0 = r10.toString()     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r7.<init>(r8, r0)     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r0 = r17
            r0.sendBroadcast(r7)     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r0.<init>()     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r7 = 0
            java.lang.String r0 = com.baidu.wallet.lightapp.base.utils.LightappUtils.assembleResult((int) r7, (org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r1.onResult(r7, r0)     // Catch:{ JSONException -> 0x01d6, all -> 0x01d4 }
            r7 = r6
            r6 = 0
            r11 = 0
            r12 = 0
        L_0x01b8:
            if (r7 == 0) goto L_0x01c3
            r7.close()     // Catch:{ IOException -> 0x01be }
            goto L_0x01c3
        L_0x01be:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x01c3:
            if (r9 == 0) goto L_0x01ce
            boolean r0 = r9.isRecycled()
            if (r0 != 0) goto L_0x01ce
            r9.recycle()
        L_0x01ce:
            if (r12 == 0) goto L_0x027a
            if (r11 == 0) goto L_0x027a
            goto L_0x026b
        L_0x01d4:
            r0 = move-exception
            goto L_0x01dc
        L_0x01d6:
            r0 = move-exception
            r7 = r6
            r6 = 0
            goto L_0x0234
        L_0x01da:
            r0 = move-exception
            r6 = 0
        L_0x01dc:
            r8 = 0
            goto L_0x01e6
        L_0x01de:
            r0 = move-exception
            r6 = 0
            r7 = 0
            goto L_0x0234
        L_0x01e2:
            r0 = move-exception
            r6 = 0
            r8 = 0
            r9 = 0
        L_0x01e6:
            r11 = 0
        L_0x01e7:
            r12 = 0
        L_0x01e8:
            r0.printStackTrace()     // Catch:{ all -> 0x022d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x022d }
            r3.<init>()     // Catch:{ all -> 0x022d }
            java.lang.String r7 = "图片保存失败! "
            r3.append(r7)     // Catch:{ all -> 0x022d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x022d }
            r3.append(r0)     // Catch:{ all -> 0x022d }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x022d }
            com.baidu.wallet.lightapp.base.utils.LightappUtils.onError((com.baidu.wallet.api.ILightappInvokerCallback) r1, (java.lang.String) r5, (java.lang.String) r2, (java.lang.String) r0, (java.lang.String) r5)     // Catch:{ all -> 0x022d }
            if (r6 == 0) goto L_0x020e
            r6.close()     // Catch:{ IOException -> 0x0209 }
            goto L_0x020e
        L_0x0209:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x020e:
            if (r9 == 0) goto L_0x0219
            boolean r0 = r9.isRecycled()
            if (r0 != 0) goto L_0x0219
            r9.recycle()
        L_0x0219:
            if (r12 == 0) goto L_0x027a
            if (r11 == 0) goto L_0x027a
            r12.clear()
            r1 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r12.put(r4, r0)
            r1 = 0
            r11.update(r8, r12, r1, r1)
            goto L_0x027a
        L_0x022d:
            r0 = move-exception
            r1 = r0
            goto L_0x027f
        L_0x0230:
            r0 = move-exception
            r6 = 0
            r7 = 0
            r9 = 0
        L_0x0234:
            r11 = 0
        L_0x0235:
            r12 = 0
        L_0x0236:
            r0.printStackTrace()     // Catch:{ all -> 0x027b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x027b }
            r2.<init>()     // Catch:{ all -> 0x027b }
            java.lang.String r8 = "数据解析失败"
            r2.append(r8)     // Catch:{ all -> 0x027b }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x027b }
            r2.append(r0)     // Catch:{ all -> 0x027b }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x027b }
            com.baidu.wallet.lightapp.base.utils.LightappUtils.onError((com.baidu.wallet.api.ILightappInvokerCallback) r1, (java.lang.String) r5, (java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r5)     // Catch:{ all -> 0x027b }
            if (r7 == 0) goto L_0x025c
            r7.close()     // Catch:{ IOException -> 0x0257 }
            goto L_0x025c
        L_0x0257:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x025c:
            if (r9 == 0) goto L_0x0267
            boolean r0 = r9.isRecycled()
            if (r0 != 0) goto L_0x0267
            r9.recycle()
        L_0x0267:
            if (r12 == 0) goto L_0x027a
            if (r11 == 0) goto L_0x027a
        L_0x026b:
            r12.clear()
            r1 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r12.put(r4, r0)
            r1 = 0
            r11.update(r6, r12, r1, r1)
        L_0x027a:
            return
        L_0x027b:
            r0 = move-exception
            r1 = r0
            r8 = r6
            r6 = r7
        L_0x027f:
            if (r6 == 0) goto L_0x028a
            r6.close()     // Catch:{ IOException -> 0x0285 }
            goto L_0x028a
        L_0x0285:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x028a:
            if (r9 == 0) goto L_0x0295
            boolean r0 = r9.isRecycled()
            if (r0 != 0) goto L_0x0295
            r9.recycle()
        L_0x0295:
            if (r12 == 0) goto L_0x02a8
            if (r11 == 0) goto L_0x02a8
            r12.clear()
            r2 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            r12.put(r4, r0)
            r2 = 0
            r11.update(r8, r12, r2, r2)
        L_0x02a8:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.LightappBusinessClient.b(android.content.Context, java.lang.String, com.baidu.wallet.api.ILightappInvokerCallback):void");
    }

    private boolean a(String str) {
        if (!this.x) {
            try {
                this.f = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                Class<?> cls = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                this.h = cls;
                this.g = this.f.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, new Class[]{Context.class, String.class, Boolean.TYPE, cls});
            } catch (Throwable th2) {
                this.x = true;
                throw th2;
            }
            this.x = true;
        }
        if (this.f == null || this.h == null || this.g == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2, String str2) {
        ILightappInvokerCallback iLightappInvokerCallback;
        try {
            if (this.A != null && (iLightappInvokerCallback = this.A.get(str)) != null) {
                iLightappInvokerCallback.onResult(i2, str2);
                this.A.remove(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2, boolean z2) {
        byte[] bArr;
        String str3 = z2 ? MTD_ENCRYPT : MTD_DECRYPT;
        if (iLightappInvokerCallback != null) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("key", (String) null);
                if (!TextUtils.isEmpty(optString)) {
                    String optString2 = jSONObject.optString("data", (String) null);
                    if (optString2 != null) {
                        String optString3 = jSONObject.optString("algorithm", (String) null);
                        if (optString3 == null) {
                            throw new InvalidParameterException("no algorithm key [algorithm]");
                        } else if (Pattern.compile("DES|AES|RSA").matcher(optString3).matches()) {
                            byte[] decode = Base64.decode(optString2, 2);
                            if (decode == null || decode.length == 0) {
                                throw new IllegalArgumentException("传入的base64数据不正确");
                            }
                            if (z2) {
                                if ("DES".equals(optString3)) {
                                    bArr = Crypto.desEncrypt(decode, optString);
                                } else if (AESUtil.ALGORITHM_NAME.equals(optString3)) {
                                    bArr = Crypto.aesEncrypt(decode, optString);
                                } else if ("RSA".equals(optString3)) {
                                    bArr = Crypto.rsaEncrypt(decode, optString);
                                } else {
                                    throw new NoSuchAlgorithmException(optString3);
                                }
                            } else if ("DES".equals(optString3)) {
                                bArr = Crypto.desDecrypt(decode, optString);
                            } else if (AESUtil.ALGORITHM_NAME.equals(optString3)) {
                                bArr = Crypto.aesDecrypt(decode, optString);
                            } else if ("RSA".equals(optString3)) {
                                bArr = Crypto.rsaDecrypt(decode, optString);
                            } else {
                                throw new NoSuchAlgorithmException(optString3);
                            }
                            if (bArr == null) {
                                throw new Exception(z2 ? "encrypt error!" : "decrypt error!");
                            }
                            hashMap.put("data", Base64.encodeToString(bArr, 2));
                            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult((Map<String, Object>) hashMap, true));
                        } else {
                            throw new NoSuchAlgorithmException("Supported algorithms: DES, AES, RSA." + optString3 + " is not supported yet");
                        }
                    } else {
                        throw new InvalidParameterException("no data key [data]");
                    }
                } else {
                    throw new InvalidParameterException("no key [key]");
                }
            } catch (Exception e2) {
                throw e2;
            } catch (Exception e3) {
                String localizedMessage = e3.getLocalizedMessage();
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, localizedMessage, Bank.HOT_BANK_LETTER + str3 + "Fail");
            }
        }
    }

    private JSONObject a(Context context, JSONObject jSONObject) throws Exception {
        if (context == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject.has("screenWidth")) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            jSONObject2.put("screenWidth", displayMetrics.widthPixels + "");
        }
        if (jSONObject.has("screenHeight")) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            jSONObject2.put("screenHeight", displayMetrics2.heightPixels + "");
        }
        if (jSONObject.has("walletUserAgent")) {
            jSONObject2.put("walletUserAgent", BussinessUtils.getUA(context) + "");
        }
        if (jSONObject.has("cuid")) {
            jSONObject2.put("cuid", PhoneUtils.getCUID(context) + "");
        }
        if (jSONObject.has("BAIDUCUID")) {
            jSONObject2.put("BAIDUCUID", DeviceId.getCUID(context));
        }
        if (jSONObject.has(b.c.j)) {
            String gPSLocation = PhoneUtils.getGPSLocation(context);
            if (TextUtils.isEmpty(gPSLocation)) {
                jSONObject2.put(b.c.j, "");
            } else {
                String[] split = gPSLocation.split(":");
                if (split == null || 2 != split.length) {
                    jSONObject2.put(b.c.j, "");
                } else {
                    jSONObject2.put(b.c.j, "{\"longitude\":" + split[0] + ",\"latitude\":" + split[1] + "}");
                }
            }
        }
        if (jSONObject.has("localIp")) {
            jSONObject2.put("localIp", PhoneUtils.getIpInfo() + "");
        }
        if (jSONObject.has("wifi")) {
            jSONObject2.put("wifi", NetUtils.getWifiSig(context, PhoneUtils.getCUID(context)));
        }
        if (jSONObject.has(WCP)) {
            try {
                if (!jSONObject2.has("wime")) {
                    jSONObject2.put("wime", "");
                }
                if (!jSONObject2.has("cuid_1")) {
                    jSONObject2.put("cuid_1", PhoneUtils.getCUID(context));
                }
                if (!jSONObject2.has("cuid_2")) {
                    jSONObject2.put("cuid_2", PhoneUtils.getCUID2(context));
                }
                if (!jSONObject2.has("nettype")) {
                    jSONObject2.put("nettype", NetworkUtils.getNetworkType(context));
                }
                if (!jSONObject2.has("wloc")) {
                    jSONObject2.put("wloc", PhoneUtils.getGPSLocation(context));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONObject.has(ROOT)) {
            try {
                if (!jSONObject2.has(ROOT)) {
                    jSONObject2.put(ROOT, SecurityUtils.isRoot());
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return jSONObject2;
    }

    private void b(final Context context, HashMap hashMap, final ILightappInvokerCallback iLightappInvokerCallback, final String str) {
        DXMBioRecogSDK.getInstance().invokeDxmFaceSDK(context, hashMap, new DXMFaceLivenessCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 0) {
                    LightAppCommonModel lightAppCommonModel = new LightAppCommonModel(0);
                    lightAppCommonModel.cnt.errCode = String.valueOf(0);
                    LightAppCommonModel.Data data = lightAppCommonModel.cnt;
                    data.des = "成功";
                    data.data = hashMap;
                    iLightappInvokerCallback.onResult(0, lightAppCommonModel.toJson());
                    return;
                }
                ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                String str = str;
                String valueOf = String.valueOf(i2);
                LightappUtils.onError(iLightappInvokerCallback, str, valueOf, PhoneUtils.getApplicationName(context) + hashMap.get("msg"), "#identifyAuthFail");
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        ContactSelectModel contactSelectModel = new ContactSelectModel(1);
        ContactSelectModel.Data data = contactSelectModel.cnt;
        data.errCode = "10002";
        data.des = PhoneUtils.getApplicationName(getActivity()) + "没有" + "访问通信录的权限";
        a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
    }

    private void b(String str, String str2) {
        String str3 = "10002";
        try {
            if (!TextUtils.isEmpty(str) && getActivity() != null && !getActivity().shouldShowRequestPermissionRationale(str)) {
                str2 = "用户拒绝了权限，并点击不再提醒";
                str3 = LightappConstants.ERRCODE_PERMISSION_REFUSE_AND_NO_REMINDER;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errCode", str3);
            jSONObject.put("des", str2);
            a(MTD_PERMISSION_UNIVERSAL_SET, 1, LightappUtils.assembleResult(1, jSONObject));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2, boolean z2) {
        doBindCard(context, str, iLightappInvokerCallback, str2, z2 ? MTD_BINDCARD_INDEPENDENT : MTD_BINDCARD_INITIATIVE);
    }

    private void b(String str, int i2, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("" + i2);
        arrayList.add(str2);
        arrayList.add(str);
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, arrayList);
    }

    private void b(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            b("gotoAppSetting", 1, "context or options is null");
            return;
        }
        try {
            String string = jSONObject.getString("permission_type");
            if (TextUtils.isEmpty(string)) {
                b("gotoAppSetting", 1, "type is null");
                return;
            }
            this.J = string;
            Intent intent = new Intent();
            this.C.setIsCheckPermission(true);
            try {
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
                context.startActivity(intent);
            } catch (Exception unused) {
                context.startActivity(new Intent("android.settings.SETTINGS"));
            }
        } catch (JSONException e2) {
            b("gotoAppSetting", 1, "type 解析异常");
            e2.printStackTrace();
        }
    }

    private void a(final Context context, final String str, final String str2) {
        int i2;
        int i3;
        JSONException jSONException;
        int i4;
        String str3 = "";
        int i5 = 50;
        int i6 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i2 = jSONObject.optInt("multipleMaxCount");
            try {
                i3 = jSONObject.optInt("choice_type");
                try {
                    i5 = jSONObject.optInt("max_video_size", 50);
                    str3 = jSONObject.optString("notice_board_msg", str3);
                    String str4 = this.b;
                    LogUtil.d(str4, "callMultiNativePhotos maxCOunt = " + i2);
                    if (i2 > SdkInitResponse.getInstance().getMultipleMaxCount() || i2 <= 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errCode", LightappConstants.ERRCODE_INVALID_PARAMETER);
                        jSONObject2.put("des", "参数异常");
                        a(MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject2));
                        return;
                    }
                } catch (JSONException e2) {
                    JSONException jSONException2 = e2;
                    i4 = i3;
                    i6 = i2;
                    jSONException = jSONException2;
                    jSONException.printStackTrace();
                    i2 = i6;
                    i3 = i4;
                    LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("imageselector").action("enterLocalImageSel").data("multipleMaxCount", Integer.valueOf(i2)).data("max_video_size", Integer.valueOf(i5)).data("notice_board_msg", str3).data("choice_type", Integer.valueOf(i3)), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                            int i3 = i2;
                            HashMap hashMap2 = hashMap;
                            if (i3 == 0) {
                                if (hashMap2 != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    JSONObject jSONObject2 = new JSONObject();
                                    List list = (List) hashMap2.get("data");
                                    int intValue = ((Integer) hashMap2.get("mediaType")).intValue();
                                    if (intValue == 1) {
                                        ArrayList arrayList = new ArrayList();
                                        long currentTimeMillis = System.currentTimeMillis();
                                        if (list != null && list.size() > 0) {
                                            for (final Object next : list) {
                                                if (next == null || !(next instanceof Uri)) {
                                                    try {
                                                        JSONObject jSONObject3 = new JSONObject();
                                                        jSONObject3.put("errCode", "10003");
                                                        jSONObject3.put("des", EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                                                        LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject3));
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }
                                                } else {
                                                    final ArrayList arrayList2 = arrayList;
                                                    final List list2 = list;
                                                    final long j = currentTimeMillis;
                                                    final JSONObject jSONObject4 = jSONObject2;
                                                    final JSONObject jSONObject5 = jSONObject;
                                                    ImageBase64Utils.getInstance().getImageBase64(context, (Uri) next, -1, 100, new ImageBase64Utils.ImageBase64Listener() {
                                                        public void onBase64Result(String str) {
                                                            LogUtil.d("album", "uri = " + next + " ; ThreadName =  " + Thread.currentThread().getName());
                                                            if (!TextUtils.isEmpty(str)) {
                                                                try {
                                                                    arrayList2.add(str);
                                                                    if (arrayList2.size() == list2.size()) {
                                                                        LogUtil.d("album", "success cost = " + (System.currentTimeMillis() - j));
                                                                        try {
                                                                            jSONObject4.put("photos", new JSONArray(arrayList2));
                                                                            jSONObject5.put("data", jSONObject4);
                                                                            jSONObject5.put("errCode", 0);
                                                                            jSONObject5.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                        } catch (JSONException e2) {
                                                                            e2.printStackTrace();
                                                                        }
                                                                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList2.size())}));
                                                                        LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject5));
                                                                        arrayList2.clear();
                                                                    }
                                                                } catch (OutOfMemoryError e3) {
                                                                    if (LightappBusinessClient.this.getActivity() != null && !LightappBusinessClient.this.getActivity().isDestroyed() && !LightappBusinessClient.this.getActivity().isFinishing()) {
                                                                        PromptTipDialog promptTipDialog = new PromptTipDialog(LightappBusinessClient.this.getActivity());
                                                                        promptTipDialog.setTitleMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_title));
                                                                        promptTipDialog.setMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_message));
                                                                        promptTipDialog.show();
                                                                    }
                                                                    List list = arrayList2;
                                                                    if (list != null) {
                                                                        list.clear();
                                                                    }
                                                                    ArrayList arrayList = new ArrayList();
                                                                    arrayList.add("1");
                                                                    arrayList.add(e3.getMessage());
                                                                    arrayList.add("OutOfMemoryError");
                                                                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, arrayList);
                                                                }
                                                            } else {
                                                                try {
                                                                    JSONObject jSONObject = new JSONObject();
                                                                    jSONObject.put("errCode", "10003");
                                                                    jSONObject.put("des", "读取图片数据异常");
                                                                    LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject));
                                                                } catch (JSONException e4) {
                                                                    e4.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                        }
                                    } else if (intValue == 2) {
                                        ArrayList arrayList3 = new ArrayList();
                                        if (list != null && list.size() > 0) {
                                            for (final Object next2 : list) {
                                                try {
                                                    String str = context.getCacheDir() + File.separator + "Video_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".mp4";
                                                    final String str2 = str;
                                                    final ArrayList arrayList4 = arrayList3;
                                                    final List list3 = list;
                                                    final JSONObject jSONObject6 = jSONObject2;
                                                    final JSONObject jSONObject7 = jSONObject;
                                                    VideoCompressUtils.convertVideo(context, (Uri) next2, str, new VideoCompressUtils.ProgressListener() {
                                                        public void onFinish(boolean z) {
                                                            if (z) {
                                                                VideoBase64Utils.video2base64(str2, new VideoBase64Utils.VideoBase64Listener() {
                                                                    public void onBase64Result(String str) {
                                                                        arrayList4.add(str);
                                                                        if (arrayList4.size() == list3.size()) {
                                                                            try {
                                                                                jSONObject6.put("videos", new JSONArray(arrayList4));
                                                                                jSONObject7.put("data", jSONObject6);
                                                                                jSONObject7.put("errCode", 0);
                                                                                jSONObject7.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                            } catch (JSONException e) {
                                                                                e.printStackTrace();
                                                                            }
                                                                            AnonymousClass2 r1 = AnonymousClass2.this;
                                                                            AnonymousClass21 r2 = AnonymousClass21.this;
                                                                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList4.size())}));
                                                                            AnonymousClass2 r0 = AnonymousClass2.this;
                                                                            LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject7));
                                                                        }
                                                                    }
                                                                });
                                                                return;
                                                            }
                                                            try {
                                                                VideoBase64Utils.video2base64(FileFetchManager.getFileAbsolutePath(context, (Uri) next2), new VideoBase64Utils.VideoBase64Listener() {
                                                                    public void onBase64Result(String str) {
                                                                        arrayList4.add(str);
                                                                        if (arrayList4.size() == list3.size()) {
                                                                            try {
                                                                                jSONObject6.put("videos", new JSONArray(arrayList4));
                                                                                jSONObject7.put("data", jSONObject6);
                                                                                jSONObject7.put("errCode", 0);
                                                                                jSONObject7.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                            } catch (JSONException e) {
                                                                                e.printStackTrace();
                                                                            }
                                                                            AnonymousClass2 r1 = AnonymousClass2.this;
                                                                            AnonymousClass21 r2 = AnonymousClass21.this;
                                                                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList4.size())}));
                                                                            AnonymousClass2 r0 = AnonymousClass2.this;
                                                                            LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject7));
                                                                        }
                                                                    }
                                                                });
                                                            } catch (Exception unused) {
                                                                JSONObject jSONObject = new JSONObject();
                                                                try {
                                                                    jSONObject.put("errCode", "10003");
                                                                    jSONObject.put("des", EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                                                                    LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject));
                                                                } catch (JSONException e2) {
                                                                    e2.printStackTrace();
                                                                }
                                                            }
                                                        }

                                                        public void onProgress(float f2) {
                                                        }

                                                        public void onStart() {
                                                        }
                                                    });
                                                } catch (OutOfMemoryError e2) {
                                                    if (LightappBusinessClient.this.getActivity() != null && !LightappBusinessClient.this.getActivity().isDestroyed() && !LightappBusinessClient.this.getActivity().isFinishing()) {
                                                        PromptTipDialog promptTipDialog = new PromptTipDialog(LightappBusinessClient.this.getActivity());
                                                        promptTipDialog.setTitleMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_title));
                                                        promptTipDialog.setMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_message));
                                                        promptTipDialog.show();
                                                    }
                                                    arrayList3.clear();
                                                    ArrayList arrayList5 = new ArrayList();
                                                    arrayList5.add("1");
                                                    arrayList5.add(e2.getMessage());
                                                    arrayList5.add("video OutOfMemoryError");
                                                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, arrayList5);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (i3 == 5) {
                                try {
                                    JSONObject jSONObject8 = new JSONObject();
                                    jSONObject8.put("errCode", "10004");
                                    jSONObject8.put("des", EnterDxmPayServiceAction.ERR_METHOD_BLACK_LIST_MEG);
                                    LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject8));
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                }
                            } else {
                                try {
                                    JSONObject jSONObject9 = new JSONObject();
                                    jSONObject9.put("errCode", "10005");
                                    jSONObject9.put("des", "用户取消选择");
                                    LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject9));
                                } catch (JSONException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                    });
                }
            } catch (JSONException e3) {
                e = e3;
                i6 = i2;
                jSONException = e;
                i4 = 0;
                jSONException.printStackTrace();
                i2 = i6;
                i3 = i4;
                LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("imageselector").action("enterLocalImageSel").data("multipleMaxCount", Integer.valueOf(i2)).data("max_video_size", Integer.valueOf(i5)).data("notice_board_msg", str3).data("choice_type", Integer.valueOf(i3)), new RouterCallback() {
                    public void onResult(int i2, HashMap hashMap) {
                        int i3 = i2;
                        HashMap hashMap2 = hashMap;
                        if (i3 == 0) {
                            if (hashMap2 != null) {
                                JSONObject jSONObject = new JSONObject();
                                JSONObject jSONObject2 = new JSONObject();
                                List list = (List) hashMap2.get("data");
                                int intValue = ((Integer) hashMap2.get("mediaType")).intValue();
                                if (intValue == 1) {
                                    ArrayList arrayList = new ArrayList();
                                    long currentTimeMillis = System.currentTimeMillis();
                                    if (list != null && list.size() > 0) {
                                        for (final Object next : list) {
                                            if (next == null || !(next instanceof Uri)) {
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject();
                                                    jSONObject3.put("errCode", "10003");
                                                    jSONObject3.put("des", EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                                                    LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject3));
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            } else {
                                                final ArrayList arrayList2 = arrayList;
                                                final List list2 = list;
                                                final long j = currentTimeMillis;
                                                final JSONObject jSONObject4 = jSONObject2;
                                                final JSONObject jSONObject5 = jSONObject;
                                                ImageBase64Utils.getInstance().getImageBase64(context, (Uri) next, -1, 100, new ImageBase64Utils.ImageBase64Listener() {
                                                    public void onBase64Result(String str) {
                                                        LogUtil.d("album", "uri = " + next + " ; ThreadName =  " + Thread.currentThread().getName());
                                                        if (!TextUtils.isEmpty(str)) {
                                                            try {
                                                                arrayList2.add(str);
                                                                if (arrayList2.size() == list2.size()) {
                                                                    LogUtil.d("album", "success cost = " + (System.currentTimeMillis() - j));
                                                                    try {
                                                                        jSONObject4.put("photos", new JSONArray(arrayList2));
                                                                        jSONObject5.put("data", jSONObject4);
                                                                        jSONObject5.put("errCode", 0);
                                                                        jSONObject5.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                    } catch (JSONException e2) {
                                                                        e2.printStackTrace();
                                                                    }
                                                                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList2.size())}));
                                                                    LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject5));
                                                                    arrayList2.clear();
                                                                }
                                                            } catch (OutOfMemoryError e3) {
                                                                if (LightappBusinessClient.this.getActivity() != null && !LightappBusinessClient.this.getActivity().isDestroyed() && !LightappBusinessClient.this.getActivity().isFinishing()) {
                                                                    PromptTipDialog promptTipDialog = new PromptTipDialog(LightappBusinessClient.this.getActivity());
                                                                    promptTipDialog.setTitleMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_title));
                                                                    promptTipDialog.setMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_message));
                                                                    promptTipDialog.show();
                                                                }
                                                                List list = arrayList2;
                                                                if (list != null) {
                                                                    list.clear();
                                                                }
                                                                ArrayList arrayList = new ArrayList();
                                                                arrayList.add("1");
                                                                arrayList.add(e3.getMessage());
                                                                arrayList.add("OutOfMemoryError");
                                                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, arrayList);
                                                            }
                                                        } else {
                                                            try {
                                                                JSONObject jSONObject = new JSONObject();
                                                                jSONObject.put("errCode", "10003");
                                                                jSONObject.put("des", "读取图片数据异常");
                                                                LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject));
                                                            } catch (JSONException e4) {
                                                                e4.printStackTrace();
                                                            }
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                    }
                                } else if (intValue == 2) {
                                    ArrayList arrayList3 = new ArrayList();
                                    if (list != null && list.size() > 0) {
                                        for (final Object next2 : list) {
                                            try {
                                                String str = context.getCacheDir() + File.separator + "Video_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".mp4";
                                                final String str2 = str;
                                                final ArrayList arrayList4 = arrayList3;
                                                final List list3 = list;
                                                final JSONObject jSONObject6 = jSONObject2;
                                                final JSONObject jSONObject7 = jSONObject;
                                                VideoCompressUtils.convertVideo(context, (Uri) next2, str, new VideoCompressUtils.ProgressListener() {
                                                    public void onFinish(boolean z) {
                                                        if (z) {
                                                            VideoBase64Utils.video2base64(str2, new VideoBase64Utils.VideoBase64Listener() {
                                                                public void onBase64Result(String str) {
                                                                    arrayList4.add(str);
                                                                    if (arrayList4.size() == list3.size()) {
                                                                        try {
                                                                            jSONObject6.put("videos", new JSONArray(arrayList4));
                                                                            jSONObject7.put("data", jSONObject6);
                                                                            jSONObject7.put("errCode", 0);
                                                                            jSONObject7.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                        } catch (JSONException e) {
                                                                            e.printStackTrace();
                                                                        }
                                                                        AnonymousClass2 r1 = AnonymousClass2.this;
                                                                        AnonymousClass21 r2 = AnonymousClass21.this;
                                                                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList4.size())}));
                                                                        AnonymousClass2 r0 = AnonymousClass2.this;
                                                                        LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject7));
                                                                    }
                                                                }
                                                            });
                                                            return;
                                                        }
                                                        try {
                                                            VideoBase64Utils.video2base64(FileFetchManager.getFileAbsolutePath(context, (Uri) next2), new VideoBase64Utils.VideoBase64Listener() {
                                                                public void onBase64Result(String str) {
                                                                    arrayList4.add(str);
                                                                    if (arrayList4.size() == list3.size()) {
                                                                        try {
                                                                            jSONObject6.put("videos", new JSONArray(arrayList4));
                                                                            jSONObject7.put("data", jSONObject6);
                                                                            jSONObject7.put("errCode", 0);
                                                                            jSONObject7.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                        } catch (JSONException e) {
                                                                            e.printStackTrace();
                                                                        }
                                                                        AnonymousClass2 r1 = AnonymousClass2.this;
                                                                        AnonymousClass21 r2 = AnonymousClass21.this;
                                                                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList4.size())}));
                                                                        AnonymousClass2 r0 = AnonymousClass2.this;
                                                                        LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject7));
                                                                    }
                                                                }
                                                            });
                                                        } catch (Exception unused) {
                                                            JSONObject jSONObject = new JSONObject();
                                                            try {
                                                                jSONObject.put("errCode", "10003");
                                                                jSONObject.put("des", EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                                                                LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject));
                                                            } catch (JSONException e2) {
                                                                e2.printStackTrace();
                                                            }
                                                        }
                                                    }

                                                    public void onProgress(float f2) {
                                                    }

                                                    public void onStart() {
                                                    }
                                                });
                                            } catch (OutOfMemoryError e2) {
                                                if (LightappBusinessClient.this.getActivity() != null && !LightappBusinessClient.this.getActivity().isDestroyed() && !LightappBusinessClient.this.getActivity().isFinishing()) {
                                                    PromptTipDialog promptTipDialog = new PromptTipDialog(LightappBusinessClient.this.getActivity());
                                                    promptTipDialog.setTitleMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_title));
                                                    promptTipDialog.setMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_message));
                                                    promptTipDialog.show();
                                                }
                                                arrayList3.clear();
                                                ArrayList arrayList5 = new ArrayList();
                                                arrayList5.add("1");
                                                arrayList5.add(e2.getMessage());
                                                arrayList5.add("video OutOfMemoryError");
                                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, arrayList5);
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (i3 == 5) {
                            try {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("errCode", "10004");
                                jSONObject8.put("des", EnterDxmPayServiceAction.ERR_METHOD_BLACK_LIST_MEG);
                                LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject8));
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        } else {
                            try {
                                JSONObject jSONObject9 = new JSONObject();
                                jSONObject9.put("errCode", "10005");
                                jSONObject9.put("des", "用户取消选择");
                                LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject9));
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                });
            }
        } catch (JSONException e4) {
            e = e4;
            jSONException = e;
            i4 = 0;
            jSONException.printStackTrace();
            i2 = i6;
            i3 = i4;
            LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("imageselector").action("enterLocalImageSel").data("multipleMaxCount", Integer.valueOf(i2)).data("max_video_size", Integer.valueOf(i5)).data("notice_board_msg", str3).data("choice_type", Integer.valueOf(i3)), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    int i3 = i2;
                    HashMap hashMap2 = hashMap;
                    if (i3 == 0) {
                        if (hashMap2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            List list = (List) hashMap2.get("data");
                            int intValue = ((Integer) hashMap2.get("mediaType")).intValue();
                            if (intValue == 1) {
                                ArrayList arrayList = new ArrayList();
                                long currentTimeMillis = System.currentTimeMillis();
                                if (list != null && list.size() > 0) {
                                    for (final Object next : list) {
                                        if (next == null || !(next instanceof Uri)) {
                                            try {
                                                JSONObject jSONObject3 = new JSONObject();
                                                jSONObject3.put("errCode", "10003");
                                                jSONObject3.put("des", EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                                                LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject3));
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            final ArrayList arrayList2 = arrayList;
                                            final List list2 = list;
                                            final long j = currentTimeMillis;
                                            final JSONObject jSONObject4 = jSONObject2;
                                            final JSONObject jSONObject5 = jSONObject;
                                            ImageBase64Utils.getInstance().getImageBase64(context, (Uri) next, -1, 100, new ImageBase64Utils.ImageBase64Listener() {
                                                public void onBase64Result(String str) {
                                                    LogUtil.d("album", "uri = " + next + " ; ThreadName =  " + Thread.currentThread().getName());
                                                    if (!TextUtils.isEmpty(str)) {
                                                        try {
                                                            arrayList2.add(str);
                                                            if (arrayList2.size() == list2.size()) {
                                                                LogUtil.d("album", "success cost = " + (System.currentTimeMillis() - j));
                                                                try {
                                                                    jSONObject4.put("photos", new JSONArray(arrayList2));
                                                                    jSONObject5.put("data", jSONObject4);
                                                                    jSONObject5.put("errCode", 0);
                                                                    jSONObject5.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                } catch (JSONException e2) {
                                                                    e2.printStackTrace();
                                                                }
                                                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList2.size())}));
                                                                LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject5));
                                                                arrayList2.clear();
                                                            }
                                                        } catch (OutOfMemoryError e3) {
                                                            if (LightappBusinessClient.this.getActivity() != null && !LightappBusinessClient.this.getActivity().isDestroyed() && !LightappBusinessClient.this.getActivity().isFinishing()) {
                                                                PromptTipDialog promptTipDialog = new PromptTipDialog(LightappBusinessClient.this.getActivity());
                                                                promptTipDialog.setTitleMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_title));
                                                                promptTipDialog.setMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_message));
                                                                promptTipDialog.show();
                                                            }
                                                            List list = arrayList2;
                                                            if (list != null) {
                                                                list.clear();
                                                            }
                                                            ArrayList arrayList = new ArrayList();
                                                            arrayList.add("1");
                                                            arrayList.add(e3.getMessage());
                                                            arrayList.add("OutOfMemoryError");
                                                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, arrayList);
                                                        }
                                                    } else {
                                                        try {
                                                            JSONObject jSONObject = new JSONObject();
                                                            jSONObject.put("errCode", "10003");
                                                            jSONObject.put("des", "读取图片数据异常");
                                                            LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject));
                                                        } catch (JSONException e4) {
                                                            e4.printStackTrace();
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }
                                }
                            } else if (intValue == 2) {
                                ArrayList arrayList3 = new ArrayList();
                                if (list != null && list.size() > 0) {
                                    for (final Object next2 : list) {
                                        try {
                                            String str = context.getCacheDir() + File.separator + "Video_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".mp4";
                                            final String str2 = str;
                                            final ArrayList arrayList4 = arrayList3;
                                            final List list3 = list;
                                            final JSONObject jSONObject6 = jSONObject2;
                                            final JSONObject jSONObject7 = jSONObject;
                                            VideoCompressUtils.convertVideo(context, (Uri) next2, str, new VideoCompressUtils.ProgressListener() {
                                                public void onFinish(boolean z) {
                                                    if (z) {
                                                        VideoBase64Utils.video2base64(str2, new VideoBase64Utils.VideoBase64Listener() {
                                                            public void onBase64Result(String str) {
                                                                arrayList4.add(str);
                                                                if (arrayList4.size() == list3.size()) {
                                                                    try {
                                                                        jSONObject6.put("videos", new JSONArray(arrayList4));
                                                                        jSONObject7.put("data", jSONObject6);
                                                                        jSONObject7.put("errCode", 0);
                                                                        jSONObject7.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                    } catch (JSONException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                    AnonymousClass2 r1 = AnonymousClass2.this;
                                                                    AnonymousClass21 r2 = AnonymousClass21.this;
                                                                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList4.size())}));
                                                                    AnonymousClass2 r0 = AnonymousClass2.this;
                                                                    LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject7));
                                                                }
                                                            }
                                                        });
                                                        return;
                                                    }
                                                    try {
                                                        VideoBase64Utils.video2base64(FileFetchManager.getFileAbsolutePath(context, (Uri) next2), new VideoBase64Utils.VideoBase64Listener() {
                                                            public void onBase64Result(String str) {
                                                                arrayList4.add(str);
                                                                if (arrayList4.size() == list3.size()) {
                                                                    try {
                                                                        jSONObject6.put("videos", new JSONArray(arrayList4));
                                                                        jSONObject7.put("data", jSONObject6);
                                                                        jSONObject7.put("errCode", 0);
                                                                        jSONObject7.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                    } catch (JSONException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                    AnonymousClass2 r1 = AnonymousClass2.this;
                                                                    AnonymousClass21 r2 = AnonymousClass21.this;
                                                                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList4.size())}));
                                                                    AnonymousClass2 r0 = AnonymousClass2.this;
                                                                    LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject7));
                                                                }
                                                            }
                                                        });
                                                    } catch (Exception unused) {
                                                        JSONObject jSONObject = new JSONObject();
                                                        try {
                                                            jSONObject.put("errCode", "10003");
                                                            jSONObject.put("des", EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                                                            LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject));
                                                        } catch (JSONException e2) {
                                                            e2.printStackTrace();
                                                        }
                                                    }
                                                }

                                                public void onProgress(float f2) {
                                                }

                                                public void onStart() {
                                                }
                                            });
                                        } catch (OutOfMemoryError e2) {
                                            if (LightappBusinessClient.this.getActivity() != null && !LightappBusinessClient.this.getActivity().isDestroyed() && !LightappBusinessClient.this.getActivity().isFinishing()) {
                                                PromptTipDialog promptTipDialog = new PromptTipDialog(LightappBusinessClient.this.getActivity());
                                                promptTipDialog.setTitleMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_title));
                                                promptTipDialog.setMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_message));
                                                promptTipDialog.show();
                                            }
                                            arrayList3.clear();
                                            ArrayList arrayList5 = new ArrayList();
                                            arrayList5.add("1");
                                            arrayList5.add(e2.getMessage());
                                            arrayList5.add("video OutOfMemoryError");
                                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, arrayList5);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (i3 == 5) {
                        try {
                            JSONObject jSONObject8 = new JSONObject();
                            jSONObject8.put("errCode", "10004");
                            jSONObject8.put("des", EnterDxmPayServiceAction.ERR_METHOD_BLACK_LIST_MEG);
                            LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject8));
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    } else {
                        try {
                            JSONObject jSONObject9 = new JSONObject();
                            jSONObject9.put("errCode", "10005");
                            jSONObject9.put("des", "用户取消选择");
                            LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject9));
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            });
        }
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("imageselector").action("enterLocalImageSel").data("multipleMaxCount", Integer.valueOf(i2)).data("max_video_size", Integer.valueOf(i5)).data("notice_board_msg", str3).data("choice_type", Integer.valueOf(i3)), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                int i3 = i2;
                HashMap hashMap2 = hashMap;
                if (i3 == 0) {
                    if (hashMap2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        List list = (List) hashMap2.get("data");
                        int intValue = ((Integer) hashMap2.get("mediaType")).intValue();
                        if (intValue == 1) {
                            ArrayList arrayList = new ArrayList();
                            long currentTimeMillis = System.currentTimeMillis();
                            if (list != null && list.size() > 0) {
                                for (final Object next : list) {
                                    if (next == null || !(next instanceof Uri)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put("errCode", "10003");
                                            jSONObject3.put("des", EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                                            LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject3));
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        final ArrayList arrayList2 = arrayList;
                                        final List list2 = list;
                                        final long j = currentTimeMillis;
                                        final JSONObject jSONObject4 = jSONObject2;
                                        final JSONObject jSONObject5 = jSONObject;
                                        ImageBase64Utils.getInstance().getImageBase64(context, (Uri) next, -1, 100, new ImageBase64Utils.ImageBase64Listener() {
                                            public void onBase64Result(String str) {
                                                LogUtil.d("album", "uri = " + next + " ; ThreadName =  " + Thread.currentThread().getName());
                                                if (!TextUtils.isEmpty(str)) {
                                                    try {
                                                        arrayList2.add(str);
                                                        if (arrayList2.size() == list2.size()) {
                                                            LogUtil.d("album", "success cost = " + (System.currentTimeMillis() - j));
                                                            try {
                                                                jSONObject4.put("photos", new JSONArray(arrayList2));
                                                                jSONObject5.put("data", jSONObject4);
                                                                jSONObject5.put("errCode", 0);
                                                                jSONObject5.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                            } catch (JSONException e2) {
                                                                e2.printStackTrace();
                                                            }
                                                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList2.size())}));
                                                            LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject5));
                                                            arrayList2.clear();
                                                        }
                                                    } catch (OutOfMemoryError e3) {
                                                        if (LightappBusinessClient.this.getActivity() != null && !LightappBusinessClient.this.getActivity().isDestroyed() && !LightappBusinessClient.this.getActivity().isFinishing()) {
                                                            PromptTipDialog promptTipDialog = new PromptTipDialog(LightappBusinessClient.this.getActivity());
                                                            promptTipDialog.setTitleMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_title));
                                                            promptTipDialog.setMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_message));
                                                            promptTipDialog.show();
                                                        }
                                                        List list = arrayList2;
                                                        if (list != null) {
                                                            list.clear();
                                                        }
                                                        ArrayList arrayList = new ArrayList();
                                                        arrayList.add("1");
                                                        arrayList.add(e3.getMessage());
                                                        arrayList.add("OutOfMemoryError");
                                                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, arrayList);
                                                    }
                                                } else {
                                                    try {
                                                        JSONObject jSONObject = new JSONObject();
                                                        jSONObject.put("errCode", "10003");
                                                        jSONObject.put("des", "读取图片数据异常");
                                                        LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject));
                                                    } catch (JSONException e4) {
                                                        e4.printStackTrace();
                                                    }
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        } else if (intValue == 2) {
                            ArrayList arrayList3 = new ArrayList();
                            if (list != null && list.size() > 0) {
                                for (final Object next2 : list) {
                                    try {
                                        String str = context.getCacheDir() + File.separator + "Video_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".mp4";
                                        final String str2 = str;
                                        final ArrayList arrayList4 = arrayList3;
                                        final List list3 = list;
                                        final JSONObject jSONObject6 = jSONObject2;
                                        final JSONObject jSONObject7 = jSONObject;
                                        VideoCompressUtils.convertVideo(context, (Uri) next2, str, new VideoCompressUtils.ProgressListener() {
                                            public void onFinish(boolean z) {
                                                if (z) {
                                                    VideoBase64Utils.video2base64(str2, new VideoBase64Utils.VideoBase64Listener() {
                                                        public void onBase64Result(String str) {
                                                            arrayList4.add(str);
                                                            if (arrayList4.size() == list3.size()) {
                                                                try {
                                                                    jSONObject6.put("videos", new JSONArray(arrayList4));
                                                                    jSONObject7.put("data", jSONObject6);
                                                                    jSONObject7.put("errCode", 0);
                                                                    jSONObject7.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                } catch (JSONException e) {
                                                                    e.printStackTrace();
                                                                }
                                                                AnonymousClass2 r1 = AnonymousClass2.this;
                                                                AnonymousClass21 r2 = AnonymousClass21.this;
                                                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList4.size())}));
                                                                AnonymousClass2 r0 = AnonymousClass2.this;
                                                                LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject7));
                                                            }
                                                        }
                                                    });
                                                    return;
                                                }
                                                try {
                                                    VideoBase64Utils.video2base64(FileFetchManager.getFileAbsolutePath(context, (Uri) next2), new VideoBase64Utils.VideoBase64Listener() {
                                                        public void onBase64Result(String str) {
                                                            arrayList4.add(str);
                                                            if (arrayList4.size() == list3.size()) {
                                                                try {
                                                                    jSONObject6.put("videos", new JSONArray(arrayList4));
                                                                    jSONObject7.put("data", jSONObject6);
                                                                    jSONObject7.put("errCode", 0);
                                                                    jSONObject7.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                                } catch (JSONException e) {
                                                                    e.printStackTrace();
                                                                }
                                                                AnonymousClass2 r1 = AnonymousClass2.this;
                                                                AnonymousClass21 r2 = AnonymousClass21.this;
                                                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(new String[]{str2, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, str, String.valueOf(arrayList4.size())}));
                                                                AnonymousClass2 r0 = AnonymousClass2.this;
                                                                LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, jSONObject7));
                                                            }
                                                        }
                                                    });
                                                } catch (Exception unused) {
                                                    JSONObject jSONObject = new JSONObject();
                                                    try {
                                                        jSONObject.put("errCode", "10003");
                                                        jSONObject.put("des", EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                                                        LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject));
                                                    } catch (JSONException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                            }

                                            public void onProgress(float f2) {
                                            }

                                            public void onStart() {
                                            }
                                        });
                                    } catch (OutOfMemoryError e2) {
                                        if (LightappBusinessClient.this.getActivity() != null && !LightappBusinessClient.this.getActivity().isDestroyed() && !LightappBusinessClient.this.getActivity().isFinishing()) {
                                            PromptTipDialog promptTipDialog = new PromptTipDialog(LightappBusinessClient.this.getActivity());
                                            promptTipDialog.setTitleMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_title));
                                            promptTipDialog.setMessage(LightappBusinessClient.this.getActivity().getString(R.string.error_over_dialog_message));
                                            promptTipDialog.show();
                                        }
                                        arrayList3.clear();
                                        ArrayList arrayList5 = new ArrayList();
                                        arrayList5.add("1");
                                        arrayList5.add(e2.getMessage());
                                        arrayList5.add("video OutOfMemoryError");
                                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, arrayList5);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                } else if (i3 == 5) {
                    try {
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("errCode", "10004");
                        jSONObject8.put("des", EnterDxmPayServiceAction.ERR_METHOD_BLACK_LIST_MEG);
                        LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject8));
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    try {
                        JSONObject jSONObject9 = new JSONObject();
                        jSONObject9.put("errCode", "10005");
                        jSONObject9.put("des", "用户取消选择");
                        LightappBusinessClient.this.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject9));
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        });
    }

    private void a(Context context, JSONObject jSONObject, ILightappInvokerCallback iLightappInvokerCallback, String str, Double d2, String str2) {
        String str3;
        boolean z2;
        boolean z3;
        String str4;
        JSONException jSONException;
        boolean z4;
        JSONObject jSONObject2 = jSONObject;
        ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        String str5 = str;
        String str6 = "";
        if (context != null || jSONObject2 != null) {
            try {
                str3 = jSONObject2.getString("link_addr");
            } catch (JSONException e2) {
                e2.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback2, str5, LightappConstants.ERRCODE_INVALID_PARAMETER, "invalidate urls", "#openInNewLightBridgeFail");
                str3 = str6;
            }
            if (TextUtils.isEmpty(str3)) {
                LightappUtils.onError(iLightappInvokerCallback2, str5, LightappConstants.ERRCODE_INVALID_PARAMETER, "invalidate urls", "#openInNewLightBridgeFail");
            }
            String optString = jSONObject2.optString("extra_param");
            String str7 = this.b;
            LogUtil.d(str7, "openInNewLightBridge，extra_param:  " + optString);
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject2.optString("extra_params");
            }
            String str8 = this.b;
            LogUtil.d(str8, "openInNewLightBridge，extra_params:  " + optString);
            boolean z5 = false;
            if (!TextUtils.isEmpty(optString)) {
                try {
                    JSONObject jSONObject3 = new JSONObject(optString);
                    boolean optBoolean = jSONObject3.optBoolean("withAnim");
                    try {
                        boolean optBoolean2 = jSONObject3.optBoolean("showShare");
                        try {
                            str6 = jSONObject3.optString("title");
                            z2 = optBoolean2;
                            z3 = optBoolean;
                        } catch (JSONException e3) {
                            jSONException = e3;
                            z4 = optBoolean2;
                            z5 = optBoolean;
                            jSONException.printStackTrace();
                            z2 = z4;
                            z3 = z5;
                            str4 = str6;
                            String str9 = this.b;
                            LogUtil.d(str9, "openInNewLightBridge，halfHeight:" + d2 + ",halfColor:" + str2);
                            this.C.startNewLightApp(context, str3, str4, z3, z2, d2, str2);
                            a(iLightappInvokerCallback2, "参数合法，尝试打开");
                        }
                    } catch (JSONException e4) {
                        jSONException = e4;
                        z5 = optBoolean;
                        z4 = false;
                        jSONException.printStackTrace();
                        z2 = z4;
                        z3 = z5;
                        str4 = str6;
                        String str92 = this.b;
                        LogUtil.d(str92, "openInNewLightBridge，halfHeight:" + d2 + ",halfColor:" + str2);
                        this.C.startNewLightApp(context, str3, str4, z3, z2, d2, str2);
                        a(iLightappInvokerCallback2, "参数合法，尝试打开");
                    }
                } catch (JSONException e5) {
                    jSONException = e5;
                    z4 = false;
                    jSONException.printStackTrace();
                    z2 = z4;
                    z3 = z5;
                    str4 = str6;
                    String str922 = this.b;
                    LogUtil.d(str922, "openInNewLightBridge，halfHeight:" + d2 + ",halfColor:" + str2);
                    this.C.startNewLightApp(context, str3, str4, z3, z2, d2, str2);
                    a(iLightappInvokerCallback2, "参数合法，尝试打开");
                }
                str4 = str6;
            } else {
                str4 = str6;
                z3 = false;
                z2 = false;
            }
            String str9222 = this.b;
            LogUtil.d(str9222, "openInNewLightBridge，halfHeight:" + d2 + ",halfColor:" + str2);
            this.C.startNewLightApp(context, str3, str4, z3, z2, d2, str2);
            a(iLightappInvokerCallback2, "参数合法，尝试打开");
        }
    }

    private void a(ILightappInvokerCallback iLightappInvokerCallback, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("des", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (iLightappInvokerCallback != null) {
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
        }
    }

    private void a(Context context, Double d2, String str, Integer num, ILightappInvokerCallback iLightappInvokerCallback) {
        String str2 = this.b;
        LogUtil.d(str2, "setHalfLightBridgeStyle:  halfHeight:" + d2 + ",halfColor" + str + ",visible:" + num);
        if (d2 == null && str == null && num == null) {
            LightappUtils.onError(iLightappInvokerCallback, "", LightappConstants.ERRCODE_INVALID_PARAMETER, "invalidate params", "#setHalfLightBridgeStyleFail");
            return;
        }
        this.C.setHalfLightBridgeStyle(context, d2, str, num == null ? 0 : num.intValue());
        a(iLightappInvokerCallback, "成功");
    }

    private void a(Context context, JSONObject jSONObject, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        String str2 = this.b;
        LogUtil.d(str2, "setMessageForwarding:  optionsJson:" + jSONObject);
        String optString = jSONObject.optString("extra_param");
        if (TextUtils.isEmpty(optString)) {
            LightappUtils.onError(iLightappInvokerCallback, str, LightappConstants.ERRCODE_INVALID_PARAMETER, "invalidate urls", "#messageForwardingFail");
            return;
        }
        a(iLightappInvokerCallback, "成功");
        this.C.messageForwarding(context, optString);
    }

    /* access modifiers changed from: private */
    public String a(Context context, String str) {
        return PhoneUtils.getApplicationName(context) + "没有" + str;
    }

    private boolean a(String str, long j2, String str2) {
        if (METHOD_CALL_QRCODE_SCANNER.equals(str)) {
            return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("saoyisao").action("qrcodescanresult").data("type", Integer.valueOf(LightappUtils.parseJsonInt(str2, "type"))));
        }
        if ("detectBankCard".equals(str)) {
            return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("bankdetection").action("bankcarddetction"));
        }
        if (METHOD_DETECT_LIVENESS.equals(str)) {
            return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("livenessdetect").action("livenessdetect"));
        }
        if (!METHOD_ACCESS_WALLET_SERVICE.equals(str)) {
            return true;
        }
        if (j2 == SVC_ID_H5_HOMEPAGE) {
            return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider(((Boolean) SharedPreferencesUtils.getParam(getActivity(), BeanConstants.PREFERENCES_NAME, BeanConstants.PREFS_KEY_USE_NEW_HOME, Boolean.TRUE)).booleanValue() ? "newhome" : "home").action("launcher"));
        } else if (j2 == SVC_ID_H5_BALANCE || j2 == SVC_ID_H5_TRANSERECORD || j2 == SVC_ID_H5_COUPON || j2 == SVC_ID_H5_MYBANKCARD || j2 == SVC_ID_H5_SECURITCENTER || j2 == SVC_ID_H5_CASHBACK) {
            return true;
        } else {
            if (j2 == SVC_ID_H5_CHARGE) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("fastpay").action("doPhoneCharge"));
            }
            if (j2 == SVC_ID_H5_TRANSFER) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("transfer").action("entertransfer"));
            }
            if (j2 == SVC_ID_H5_SCANQR) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("saoyisao").action("qrcodescanner").data("type", Integer.valueOf(LightappUtils.parseJsonInt(str2, "type"))));
            }
            if (j2 == SVC_ID_H5_QRGEN || j2 == 10013 || j2 == SVC_ID_H5_PAY_SET || j2 == SVC_ID_H5_PWD_SET || j2 == -1) {
                return true;
            }
            return false;
        }
    }
}
