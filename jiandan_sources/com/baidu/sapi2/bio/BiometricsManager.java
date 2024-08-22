package com.baidu.sapi2.bio;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.aiscan.R;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.base.utils.LiveStatService;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiometricsManager implements NoProguard {
    public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
    public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
    public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG = "faceDetect";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_VERIFY = "outer";
    public static final String PASS_PRODUCT_ID = "pp";
    public static final String TAG = "BiometricsManager";
    public static final String a = "刷脸核验规则说明";
    public static final String b = "scene:certlogin";
    public static final String c = "scene:uncertlogin";
    public static BiometricsManager d;

    public class a extends PassFaceRecogCallback {
        public final /* synthetic */ PassFaceRecogCallback a;

        public a(PassFaceRecogCallback passFaceRecogCallback) {
            this.a = passFaceRecogCallback;
        }

        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.a.onFailure(passFaceRecogResult);
        }

        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            this.a.onSuccess(passFaceRecogResult);
        }
    }

    public class b extends ClickableSpan {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ PassFaceRecogDTO d;

        public b(boolean z, Activity activity, String str, PassFaceRecogDTO passFaceRecogDTO) {
            this.a = z;
            this.b = activity;
            this.c = str;
            this.d = passFaceRecogDTO;
        }

        public void onClick(@NonNull View view) {
            SapiAccountService accountService;
            SapiAccountManager instance = SapiAccountManager.getInstance();
            if (instance != null && (accountService = instance.getAccountService()) != null) {
                String str = accountService.getExplainCameraDeatilUrl() + "&notLogin=1";
                if (instance.getConfignation() != null) {
                    if (this.a) {
                        CoreViewRouter.getInstance().loadCurrentProcessWebviewActivity(this.b, BiometricsManager.a, str);
                    } else {
                        CoreViewRouter.getInstance().loadRemoteProcessWebViewActivity(this.b, BiometricsManager.a, str);
                    }
                    SapiStatUtil.statExplainCamera("seeDetail", this.c);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("alert_purpose_notice", "3");
                    LiveStatService.onEvent(this.b, "pass_purpose_result", hashMap, hashMap2, this.d.uid);
                }
            }
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ PassBiometric a;
        public final /* synthetic */ PassFaceOperation b;
        public final /* synthetic */ PassFaceRecogCallback c;
        public final /* synthetic */ PassFaceRecogDTO d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;

        public c(PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Activity activity, String str) {
            this.a = passBiometric;
            this.b = passFaceOperation;
            this.c = passFaceRecogCallback;
            this.d = passFaceRecogDTO;
            this.e = activity;
            this.f = str;
        }

        public void onClick(View view) {
            BiometricsManager.this.a(this.a, this.b, this.c, this.d, this.e);
            SapiContext.getInstance().setIsAlreadyShowExplainCamera(true);
            SapiStatUtil.statExplainCamera("agree", this.f);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("alert_purpose_notice", "1");
            LiveStatService.onEvent(this.e, "pass_purpose_result", hashMap, hashMap2, this.d.uid);
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ PassFaceRecogCallback a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ PassFaceRecogDTO d;

        public d(PassFaceRecogCallback passFaceRecogCallback, String str, Activity activity, PassFaceRecogDTO passFaceRecogDTO) {
            this.a = passFaceRecogCallback;
            this.b = str;
            this.c = activity;
            this.d = passFaceRecogDTO;
        }

        public void onClick(View view) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            this.a.onFailure(passFaceRecogResult);
            SapiStatUtil.statExplainCamera("refuse", this.b);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("alert_purpose_notice", "2");
            LiveStatService.onEvent(this.c, "pass_purpose_result", hashMap, hashMap2, this.d.uid);
        }
    }

    public class e {
        public static final String p = "bduss";
        public static final String q = "certinfo";
        public static final String r = "authtoken";
        public static final String s = "faceDetect";
        public static final String t = "outer";
        public String a;
        public int b;
        public int c;
        public String d;
        public int e;
        public String f;
        public String g;
        public String h;

        /* renamed from: i  reason: collision with root package name */
        public String f958i;
        public String j;
        public String k;
        public String l;
        public String m;
        public List<PassNameValuePair> n = new ArrayList();

        public e() {
        }
    }

    public static String buildSubPro(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "empty";
        }
        return "pp-pp-" + str + "-{tpl:" + SapiAccountManager.getInstance().getConfignation().tpl + ",scene:" + str2 + "}";
    }

    public static BiometricsManager getInstance() {
        if (d == null) {
            d = new BiometricsManager();
        }
        return d;
    }

    public void livenessRecognize(Activity activity, PassFaceRecogType passFaceRecogType, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, boolean z2, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, passFaceRecogType, str, map, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, z, z2, (Bundle) null, passFaceRecogCallback);
    }

    public void livenessRecognizeWithFaceLive(Activity activity, PassFaceRecogType passFaceRecogType, int i2, boolean z, PassFaceRecogCallback passFaceRecogCallback) {
        PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        PassFaceRecogDTO passFaceRecogDTO = new PassFaceRecogDTO();
        PassFaceOperation passFaceOperation = new PassFaceOperation();
        passFaceOperation.operationType = PassFaceOperation.OperationType.RECOGNIZE;
        passFaceRecogDTO.extraParamsMap.put(StatHelper.SP_NO, "pp");
        passFaceRecogDTO.extraParamsMap.put("cuid", SapiUtils.getClientId(activity));
        passFaceRecogDTO.livenessType = passFaceRecogType;
        passFaceRecogDTO.passProductId = "pp";
        passFaceRecogDTO.quality = i2;
        if (!a(activity, passFaceRecogCallback, biometric, passFaceOperation, passFaceRecogDTO, "pp", z)) {
            a(biometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity);
        }
    }

    public void recogWithAuthToken(Activity activity, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_AUTHTOKEN, str, map, str2, "", "", str3, "", "", "", "", "", "", false, false, passFaceRecogCallback);
    }

    public void recogWithBduss(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_BDUSS, str, map, str2, str3, str4, "", "", "", "", "", "", "", false, false, passFaceRecogCallback);
    }

    public void recogWithCertInfo(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, PassFaceRecogCallback passFaceRecogCallback) {
        PassFaceRecogType passFaceRecogType = PassFaceRecogType.RECOG_TYPE_CERTINFO;
        livenessRecognize(activity, passFaceRecogType, str, map, str2, "", "", "", "", str3, str4, str5, str6, str7, z, false, passFaceRecogCallback);
    }

    public void recogWithFaceDetect(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        HashMap hashMap = map == null ? new HashMap() : map;
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("authsid", str4);
        }
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_FACEDETECT, str, hashMap, str2, "", "", "", str3, "", "", "", "", "", false, false, passFaceRecogCallback);
    }

    public void recogWithFaceLive(Activity activity, int i2, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognizeWithFaceLive(activity, PassFaceRecogType.RECOG_TYPE_FACEIMAGE, i2, false, passFaceRecogCallback);
    }

    public void recogWithFaceOuter(Activity activity, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_OUTER, str, map, str2, "", "", "", str3, "", "", "", "", "", false, false, passFaceRecogCallback);
    }

    /* access modifiers changed from: private */
    public void a(PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.FACE_CERT);
        if (!TextUtils.isEmpty(deviceInfo)) {
            passFaceRecogDTO.di = deviceInfo;
        }
        passBiometric.execute(passFaceOperation, new a(passFaceRecogCallback), passFaceRecogDTO, context);
    }

    public void livenessRecognize(Activity activity, PassFaceRecogType passFaceRecogType, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, boolean z2, Bundle bundle, PassFaceRecogCallback passFaceRecogCallback) {
        PassFaceRecogType passFaceRecogType2 = passFaceRecogType;
        String str12 = str;
        Map<String, String> map2 = map;
        String str13 = str6;
        PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        PassFaceRecogDTO passFaceRecogDTO = new PassFaceRecogDTO();
        PassFaceOperation passFaceOperation = new PassFaceOperation();
        passFaceOperation.operationType = PassFaceOperation.OperationType.RECOGNIZE;
        passFaceRecogDTO.extraParamsMap.put(StatHelper.SP_NO, str);
        passFaceRecogDTO.extraParamsMap.put("cuid", SapiUtils.getClientId(activity));
        passFaceRecogDTO.imageFlag = str2;
        passFaceRecogDTO.needAuthorizeCertInfo = z;
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            passFaceRecogDTO.uid = session.uid;
        }
        if (map2 != null) {
            passFaceRecogDTO.extraParamsMap.putAll(map);
        }
        passFaceRecogDTO.livenessType = passFaceRecogType2;
        if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            passFaceRecogDTO.realName = str7;
            passFaceRecogDTO.idCardNum = str8;
            passFaceRecogDTO.verifyType = str9;
            passFaceRecogDTO.nation = str10;
            passFaceRecogDTO.phoneNum = str11;
        } else if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str3);
            if (accountFromBduss != null) {
                passFaceRecogDTO.bduss = accountFromBduss.bduss;
                passFaceRecogDTO.uid = accountFromBduss.uid;
                passFaceRecogDTO.stoken = str4;
            }
        } else if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
            passFaceRecogDTO.authToken = str5;
        } else if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            passFaceRecogDTO.exUid = str13;
        } else if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_OUTER) {
            passFaceRecogDTO.exUid = str13;
        }
        passFaceRecogDTO.passProductId = str12;
        passFaceRecogDTO.extraParams = bundle;
        if (!TextUtils.isEmpty(str) && (str.contains(b) || str.contains(c))) {
            Log.e(TAG, "scene:certlogin and scene:uncertlogin");
        }
        if (!a(activity, passFaceRecogCallback, biometric, passFaceOperation, passFaceRecogDTO, str, z2)) {
            a(biometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity);
        }
    }

    public void recogWithBduss(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, boolean z, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_BDUSS, str, map, str2, str3, str4, "", "", "", "", "", "", "", false, z, passFaceRecogCallback);
    }

    public void recogWithFaceOuter(Activity activity, String str, Map<String, String> map, String str2, String str3, boolean z, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_OUTER, str, map, str2, "", "", "", str3, "", "", "", "", "", false, z, passFaceRecogCallback);
    }

    public void recogWithFaceDetect(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, boolean z, PassFaceRecogCallback passFaceRecogCallback) {
        HashMap hashMap = map == null ? new HashMap() : map;
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("authsid", str4);
        }
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_FACEDETECT, str, hashMap, str2, "", "", "", str3, "", "", "", "", "", false, z, passFaceRecogCallback);
    }

    private boolean a(Activity activity, PassFaceRecogCallback passFaceRecogCallback, PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogDTO passFaceRecogDTO, String str, boolean z) {
        Activity activity2 = activity;
        PassFaceRecogCallback passFaceRecogCallback2 = passFaceRecogCallback;
        boolean z2 = false;
        if (SapiUtils.checkRequestPermission("android.permission.CAMERA", activity) || SapiContext.getInstance().getIsAlreadyShowExplainCamera()) {
            return false;
        }
        if (activity2 == null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            passFaceRecogCallback.onFailure(passFaceRecogResult);
            return true;
        } else if (activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
            PassFaceRecogResult passFaceRecogResult2 = new PassFaceRecogResult();
            passFaceRecogResult2.setResultCode(-307);
            passFaceRecogCallback.onFailure(passFaceRecogResult2);
            return true;
        } else {
            String string = activity.getResources().getString(R.string.sapi_sdk_explain_camera_content);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new b(z, activity, str, passFaceRecogDTO), 89, string.length(), 33);
            if (SapiAccountManager.getInstance().getConfignation().isNightMode || DarkModeUtil.isDarkMode(activity)) {
                z2 = true;
            }
            CommonDialog.qw qwVar = new CommonDialog.qw(activity);
            qwVar.fe(z2);
            qwVar.uk(activity.getResources().getString(R.string.sapi_sdk_explain_camera_title));
            qwVar.rg(spannableStringBuilder);
            PassFaceRecogDTO passFaceRecogDTO2 = passFaceRecogDTO;
            qwVar.th(activity.getResources().getString(R.string.sapi_sdk_explain_camera_defuse), new d(passFaceRecogCallback, str, activity, passFaceRecogDTO2));
            qwVar.yj(activity.getResources().getString(R.string.sapi_sdk_explain_camera_agree), new c(passBiometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO2, activity, str));
            qwVar.de().show();
            return true;
        }
    }
}
