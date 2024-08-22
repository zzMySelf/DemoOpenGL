package com.baidu.pass.biometrics.face.liveness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricOperation;
import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.pass.biometrics.base.dynamicupdate.LocalConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.pass.biometrics.face.liveness.c.d;
import com.baidu.pass.biometrics.face.liveness.c.e;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceOperationCallback;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.IInitCallback;
import com.baidu.sapi2.utils.SafeService;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.face.api.FaceApi;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PassFaceRecogManager implements PassBiometric {

    /* renamed from: e  reason: collision with root package name */
    private static final String f15828e = "PassFaceRecogManager";

    /* renamed from: f  reason: collision with root package name */
    private static final long f15829f = 300;

    /* renamed from: g  reason: collision with root package name */
    private static PassFaceRecogManager f15830g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final int f15831h = 30000;

    /* renamed from: i  reason: collision with root package name */
    private static final float f15832i = 0.6f;

    /* renamed from: j  reason: collision with root package name */
    private static final int f15833j = 40;
    private static final int k = 220;
    private static final float l = 0.8f;
    private static final int m = 20;
    private static final int n = 200;
    private static final float o = 0.6f;
    private static final float p = 0.7f;
    private static final int q = 3;
    private static final float r = 1.0f;
    private static final float s = 0.3f;
    private static final int t = 1126;
    private static final int u = 500;
    private static final int v = 150;
    private static final int w = 0;
    private static final boolean x = false;
    private static final boolean y = false;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public PassBiometricConfiguration f15834a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f15835b;

    /* renamed from: c  reason: collision with root package name */
    private PassFaceRecogCallback f15836c;

    /* renamed from: d  reason: collision with root package name */
    private long f15837d;
    public boolean useGzip = false;

    class a implements IInitCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f15838a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PassFaceRecogResult f15839b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PassFaceRecogCallback f15840c;

        a(Context context, PassFaceRecogResult passFaceRecogResult, PassFaceRecogCallback passFaceRecogCallback) {
            this.f15838a = context;
            this.f15839b = passFaceRecogResult;
            this.f15840c = passFaceRecogCallback;
        }

        public void initFailure(int i2, String str) {
            Log.e(PassFaceRecogManager.f15828e, "face FaceSDKManager initFailure: errCode=" + i2 + " ,errMsg=" + str);
            if (i2 == -1) {
                this.f15839b.setResultCode(-211);
                this.f15839b.setResultMsg(PassBiometricResult.ERROR_MSG_LACK_SO_ERROR);
            } else {
                this.f15839b.setResultCode(-209);
                this.f15839b.setResultMsg(PassBiometricResult.ERROR_MSG_SYSTEM_VERSION_LOW_ERROR);
            }
            this.f15840c.onFailure(this.f15839b);
        }

        public void initSuccess() {
            Log.e(PassFaceRecogManager.f15828e, "face FaceSDKManager initSuccess: ");
            boolean unused = PassFaceRecogManager.this.f15835b = true;
            Intent intent = new Intent(this.f15838a, PassLivenessRecogActivity.class);
            if (!(this.f15838a instanceof Activity)) {
                intent.setFlags(268435456);
            }
            this.f15838a.startActivity(intent);
        }
    }

    class b extends HttpHandlerWrap {
        b(boolean z) {
            super(z);
        }

        /* access modifiers changed from: protected */
        public void onFailure(Throwable th2, int i2, String str) {
            LocalConfigOptions.getInstance(PassFaceRecogManager.this.f15834a.getApplication()).setBioOptions(LocalConfigOptions.getInstance(PassFaceRecogManager.this.f15834a.getApplication()).getBioOptions());
        }

        /* access modifiers changed from: protected */
        public void onSuccess(int i2, String str) {
            try {
                LocalConfigOptions.getInstance(PassFaceRecogManager.this.f15834a.getApplication()).setBioOptions(SdkConfigOptions.fromOnLineJSON(new JSONObject(str)));
            } catch (JSONException e2) {
                onFailure(e2, e2.hashCode(), str);
            }
        }
    }

    private PassFaceRecogManager() {
    }

    private void b() {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("appid", this.f15834a.appId);
        httpHashMapWrap.put("tpl", this.f15834a.tpl);
        new HttpClientWrap(this.f15834a.getApplication()).get("https://wappass.bdimg.com/static/appsapi/appdistribute/android.txt", httpHashMapWrap, (List<HttpCookie>) null, new b(true));
    }

    private void c() {
        LocalConfigOptions.getInstance(this.f15834a.getApplication()).setBioOptions(LocalConfigOptions.getInstance(this.f15834a.getApplication()).getBioOptions());
    }

    private Map<String, String> d() {
        Map<String, String> map;
        PassBiometricConfiguration passBiometricConfiguration = this.f15834a;
        if (passBiometricConfiguration == null || (map = passBiometricConfiguration.faceResPaths) == null) {
            return a();
        }
        return map;
    }

    private void e() {
        this.f15837d = System.currentTimeMillis();
    }

    private boolean f() {
        return System.currentTimeMillis() - this.f15837d < 300;
    }

    private boolean g() {
        try {
            d.a();
            FaceConfig faceConfig = new FaceConfig();
            faceConfig.setBlurnessValue(0.6f);
            faceConfig.setBrightnessValue(40.0f);
            faceConfig.setBrightnessMaxValue(220.0f);
            faceConfig.setOcclusionLeftEyeValue(0.8f);
            faceConfig.setOcclusionRightEyeValue(0.8f);
            faceConfig.setOcclusionNoseValue(0.8f);
            faceConfig.setOcclusionMouthValue(0.8f);
            faceConfig.setOcclusionLeftContourValue(0.8f);
            faceConfig.setOcclusionRightContourValue(0.8f);
            faceConfig.setOcclusionChinValue(0.8f);
            faceConfig.setHeadPitchValue(20);
            faceConfig.setHeadYawValue(20);
            faceConfig.setHeadRollValue(20);
            faceConfig.setMinFaceSize(200);
            faceConfig.setNotFaceValue(0.6f);
            faceConfig.setEyeClosedValue(0.7f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(LivenessTypeEnum.Eye);
            arrayList.add(LivenessTypeEnum.Mouth);
            arrayList.add(LivenessTypeEnum.HeadLeft);
            arrayList.add(LivenessTypeEnum.HeadRight);
            faceConfig.setLivenessTypeList(arrayList);
            faceConfig.setLivenessRandom(false);
            faceConfig.setSound(false);
            faceConfig.setTimeDetectModule(30000);
            faceConfig.setCacheImageNum(3);
            faceConfig.setFaceFarRatio(0.3f);
            faceConfig.setFaceClosedRatio(1.0f);
            faceConfig.setResPaths(d());
            faceConfig.setIsCompressImage(true);
            faceConfig.setCompressValue(getFinalCompressValue());
            faceConfig.setOutputImageType(0);
            FaceSDKManager.getInstance().setFaceConfig(faceConfig);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static synchronized PassFaceRecogManager getInstance() {
        PassFaceRecogManager passFaceRecogManager;
        synchronized (PassFaceRecogManager.class) {
            if (f15830g == null) {
                f15830g = new PassFaceRecogManager();
            }
            passFaceRecogManager = f15830g;
        }
        return passFaceRecogManager;
    }

    public void cleanPassFaceRecogCallback() {
        this.f15836c = null;
    }

    public void config(PassBiometricConfiguration passBiometricConfiguration) {
        if (passBiometricConfiguration == null) {
            throw new IllegalArgumentException("PassBiometricConfiguration can't be null");
        } else if (TextUtils.isEmpty(passBiometricConfiguration.tpl) || TextUtils.isEmpty(passBiometricConfiguration.appId) || TextUtils.isEmpty(passBiometricConfiguration.appSignKey)) {
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        } else {
            this.f15834a = passBiometricConfiguration;
            FaceApi.setFaceLicenseId("pass_auth_id_01");
            ResUtils.setApplicationContext(passBiometricConfiguration.getApplication());
            BeanConstants.tpl = passBiometricConfiguration.tpl;
            BeanConstants.appid = passBiometricConfiguration.appId;
            BeanConstants.appSignKey = passBiometricConfiguration.appSignKey;
            c();
        }
    }

    public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
        if (passBiometricCallback == null) {
            throw new IllegalArgumentException(PassBiometricCallback.class.getSimpleName() + " can't be null");
        } else if (passBiometricOperation == null) {
            throw new IllegalArgumentException(PassBiometricOperation.class.getSimpleName() + " can't be null");
        } else if (passBiometricDto == null) {
            throw new IllegalArgumentException(PassBiometricDto.class.getSimpleName() + " can't be null");
        } else if (((PassFaceOperation) passBiometricOperation).operationType == PassFaceOperation.OperationType.RECOGNIZE && !f()) {
            e();
            PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) passBiometricDto;
            a(passFaceRecogDTO);
            a((PassFaceRecogCallback) passBiometricCallback, passFaceRecogDTO, context);
        }
    }

    public PassBiometricConfiguration getConfiguration() {
        return this.f15834a;
    }

    public int getFinalCompressValue() {
        PassFaceOperationCallback passFaceOperationCallback;
        int i2;
        PassBiometricConfiguration passBiometricConfiguration = this.f15834a;
        if (passBiometricConfiguration == null || (passFaceOperationCallback = passBiometricConfiguration.mCallBackFaceOption) == null) {
            return t;
        }
        HashMap<String, Integer> faceGrayOptionMap = passFaceOperationCallback.faceGrayOptionMap();
        if (faceGrayOptionMap == null || faceGrayOptionMap.get("android_face_compress") == null) {
            i2 = t;
        } else {
            i2 = faceGrayOptionMap.get("android_face_compress").intValue() == 1 ? 500 : t;
        }
        int callbackFaceCompressValue = this.f15834a.mCallBackFaceOption.callbackFaceCompressValue();
        return (callbackFaceCompressValue < 150 || callbackFaceCompressValue > t) ? i2 : callbackFaceCompressValue;
    }

    public PassFaceRecogCallback getPassFaceRecogCallback() {
        return this.f15836c;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        PassBiometricConfiguration configuration = getConfiguration();
        if (configuration != null) {
            configuration.setAgreeDangerousProtocol(z);
        }
    }

    private void a(PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        Log.w(f15828e, "face startLivenessRecogize: agreedangurage=" + this.f15834a.isAgreeDangerousProtocol());
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        if (passFaceRecogDTO == null) {
            try {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                }
            } catch (NoClassDefFoundError e2) {
                passFaceRecogResult.setResultCode(-212);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NOT_IMPORT_VIS_SDK);
                Log.e(f15828e, "face FaceSDKManager initFailure: NoClassDefFoundError:" + e2.getMessage() + ", errCode=" + passFaceRecogResult.getResultCode() + ", errMsg=" + passFaceRecogResult.getResultMsg());
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            }
        } else {
            if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
                if (TextUtils.isEmpty(passFaceRecogDTO.bduss) || TextUtils.isEmpty(passFaceRecogDTO.stoken)) {
                    passFaceRecogResult.setResultCode(101);
                    passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NO_LOGIN);
                    if (passFaceRecogCallback != null) {
                        passFaceRecogCallback.onFailure(passFaceRecogResult);
                        return;
                    }
                    return;
                }
            } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                if (TextUtils.isEmpty(passFaceRecogDTO.authToken)) {
                    passFaceRecogResult.setResultCode(-205);
                    if (passFaceRecogCallback != null) {
                        passFaceRecogCallback.onFailure(passFaceRecogResult);
                        return;
                    }
                    return;
                }
            } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
                if ((TextUtils.isEmpty(passFaceRecogDTO.realName) || TextUtils.isEmpty(passFaceRecogDTO.idCardNum)) && TextUtils.isEmpty(passFaceRecogDTO.getAccessToken())) {
                    passFaceRecogResult.setResultCode(-205);
                    if (passFaceRecogCallback != null) {
                        passFaceRecogCallback.onFailure(passFaceRecogResult);
                        return;
                    }
                    return;
                } else if (TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                    passFaceRecogDTO.exUid = "1";
                }
            } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
            this.f15836c = passFaceRecogCallback;
            if (!e.a(context)) {
                Log.d(f15828e, "face startLivenessRecogize: loadAIModelSo:-214");
                passFaceRecogResult.setResultCode(PassBiometricResult.ERROR_CODE_SO_ERROR);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SO_ERROR);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            } else if (!g()) {
                Log.d(f15828e, "face startLivenessRecogize: setFaceConfig: -210");
                passFaceRecogResult.setResultCode(-210);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_CONFIG_ERROR);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            } else if (this.f15835b) {
                Log.d(f15828e, "face startLivenessRecogize: hasInitFaceSDK start");
                Intent intent = new Intent(context, PassLivenessRecogActivity.class);
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            } else {
                PassBiometricConfiguration passBiometricConfiguration = this.f15834a;
                if (passBiometricConfiguration == null) {
                    Log.d(f15828e, "face startLivenessRecogize: configuration is null:-213");
                    passFaceRecogResult.setResultCode(PassBiometricResult.ERROR_CODE_NOT_INIT_PASS_SDK);
                    passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NOT_INIT_PASS_SDK);
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                } else if (!passBiometricConfiguration.isAgreeDangerousProtocol()) {
                    Log.d(f15828e, "face startLivenessRecogize: not agree-208");
                    passFaceRecogResult.setResultCode(-208);
                    passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_DANGEROUS_PROTOCOL_ERROR);
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                } else {
                    try {
                        SafeService.getInstance().init(context, this.f15834a.sofireAppKey, this.f15834a.sofireAppKey, this.f15834a.sofireHostID, false);
                        if (!F.getInstance().cp(context)) {
                            Log.d(f15828e, "face startLivenessRecogize: initSofireSDK & setAggree true");
                            SafeService.getInstance().setAgreeDangerousProtocol(context, true);
                        }
                    } catch (Exception e3) {
                        Log.e(f15828e, "face startLivenessRecogize: Exception:" + e3.getMessage());
                    }
                    FaceSDKManager.getInstance().initialize(this.f15834a.getApplication(), this.f15834a.licenseID, this.f15834a.licenseFileName, new a(context, passFaceRecogResult, passFaceRecogCallback));
                }
            }
        }
    }

    private Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("key", "" + "pass-key.face-android");
        hashMap.put(ConstPath.KEY_DETECT, "" + "detect/detect_rgb-customized-pa-faceid4_0.model.int8.0.0.6.1.pass.mml");
        hashMap.put(ConstPath.KEY_ALIGN, "" + "align/align-customized-pa-offlineCapture_withScore_quant_20200909.model.int8.6.4.7.1.pass.mml");
        hashMap.put("blur", "" + "blur/blur-customized-pa-blurnet_9768.model.int8-3.0.9.1.pass.mml");
        hashMap.put(ConstPath.KEY_OCCLU, "" + "occlusion/occlusion-customized-pa-occ.model.float32.2.0.6.1.pass.mml");
        hashMap.put(ConstPath.KEY_EYES, "" + "eyes_close/eyes-customized-pa-caiji.model.float32.1.0.3.1.pass.mml");
        hashMap.put("mouth", "" + "mouth_close/mouth-customized-pa-caiji.model.float32.1.0.3.1.pass.mml");
        return hashMap;
    }

    private void a(PassFaceRecogDTO passFaceRecogDTO) {
        if (!TextUtils.isEmpty(passFaceRecogDTO.passProductId) || (!passFaceRecogDTO.extraParamsMap.isEmpty() && !TextUtils.isEmpty(passFaceRecogDTO.extraParamsMap.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID)))) {
            if (TextUtils.isEmpty(passFaceRecogDTO.serviceType)) {
                passFaceRecogDTO.serviceType = "1008";
            }
            if (TextUtils.isEmpty(passFaceRecogDTO.extraParamsMap.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID))) {
                passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, passFaceRecogDTO.passProductId);
            }
            passFaceRecogDTO.processid = PassBiometricUtil.getUUID();
            com.baidu.pass.biometrics.face.liveness.a.a.b().a("request_data", passFaceRecogDTO);
            return;
        }
        throw new IllegalArgumentException("PassFaceRecogDTO.passProductId can't be empty");
    }
}
