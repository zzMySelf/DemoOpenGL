package com.baidu.sapi2;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.PassHttpClientRequest;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.DynamicPwdWithAuthCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SapiCallbackInterceptor;
import com.baidu.sapi2.callback.SmsLoginLooperCallback;
import com.baidu.sapi2.httpwrap.BinaryHttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.DynamicPwdWithAuthResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SmsLoginLooperResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Enums;
import com.dlife.ctaccountapi.v;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import java.net.HttpCookie;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class EnhancedService extends AbstractService implements NoProguard {
    public static final String KEY_SMS_CODE_LENGTH = "smsCodeLength";
    public static final int SMS_CODE_DEFAULT_LENGTH = 6;
    public static final int d = 6;
    public static final String e = "1";
    public static EnhancedService f = null;
    public static int smsCodeLength = 6;
    public String a;
    public String b;
    public PassHttpClientRequest c;
    public boolean mCanLooperLoginCheck;

    public class a extends HttpHandlerWrap {
        public final /* synthetic */ SmsLoginLooperResult a;
        public final /* synthetic */ SmsLoginLooperCallback b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Looper looper, SmsLoginLooperResult smsLoginLooperResult, SmsLoginLooperCallback smsLoginLooperCallback) {
            super(looper);
            this.a = smsLoginLooperResult;
            this.b = smsLoginLooperCallback;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.a.setResultCode(i2);
            this.b.onFailure(this.a);
        }

        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.a.setResultCode(parseInt);
                this.a.setResultMsg(optString);
                if (parseInt == 0 || parseInt == 110000) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("res");
                    if (optJSONObject != null) {
                        SapiAccount parseAccount = EnhancedService.this.parseAccount(optJSONObject);
                        parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.QR.getName());
                        ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                        this.a.session = parseAccount;
                    }
                    this.b.onLoginDone(this.a);
                    return;
                }
                this.b.onFailure(this.a);
            } catch (Throwable th2) {
                this.b.onFailure(this.a);
                Log.e(th2);
            }
        }
    }

    public class b extends HttpHandlerWrap {
        public final /* synthetic */ SapiCallback a;
        public final /* synthetic */ GetDynamicPwdResult b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Looper looper, SapiCallback sapiCallback, GetDynamicPwdResult getDynamicPwdResult) {
            super(looper);
            this.a = sapiCallback;
            this.b = getDynamicPwdResult;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.b.setResultCode(i2);
            this.a.onFailure(this.b);
        }

        public void onFinish() {
            this.a.onFinish();
        }

        public void onStart() {
            this.a.onStart();
        }

        public void onSuccess(int i2, String str) {
            int errorCode = EnhancedService.this.getErrorCode(str);
            this.b.setResultCode(errorCode);
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("sdk");
                int optInt = jSONObject.optInt(EnhancedService.KEY_SMS_CODE_LENGTH, 6);
                EnhancedService.smsCodeLength = optInt;
                this.b.smsCodeLength = optInt;
                this.b.setResultMsg(optJSONObject.optString("msg"));
                if (errorCode != 0) {
                    this.a.onFailure(this.b);
                } else {
                    this.a.onSuccess(this.b);
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                Log.e(e);
            }
        }
    }

    public class c extends HttpHandlerWrap {
        public final /* synthetic */ GetDynamicPwdCallback a;
        public final /* synthetic */ GetDynamicPwdResult b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Looper looper, GetDynamicPwdCallback getDynamicPwdCallback, GetDynamicPwdResult getDynamicPwdResult) {
            super(looper);
            this.a = getDynamicPwdCallback;
            this.b = getDynamicPwdResult;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.b.setResultCode(i2);
            this.a.onFailure(this.b);
        }

        public void onFinish() {
            this.a.onFinish();
        }

        public void onStart() {
            this.a.onStart();
        }

        public void onSuccess(int i2, String str) {
            int errorCode = EnhancedService.this.getErrorCode(str);
            this.b.setResultCode(errorCode);
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.b.noNeedBack = jSONObject.optBoolean("retry");
                JSONObject optJSONObject = jSONObject.optJSONObject("sdk");
                int optInt = jSONObject.optInt(EnhancedService.KEY_SMS_CODE_LENGTH, 6);
                EnhancedService.smsCodeLength = optInt;
                this.b.smsCodeLength = optInt;
                this.b.setResultMsg(optJSONObject.optString("msg"));
                if (errorCode == 0) {
                    this.a.onSuccess(this.b);
                } else if (errorCode != 5) {
                    this.a.onFailure(this.b);
                } else {
                    String unused = EnhancedService.this.a = optJSONObject.optString("vcodestr");
                    String unused2 = EnhancedService.this.b = optJSONObject.optString("vcodesign");
                    this.a.onCaptchaRequired(this.b);
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                Log.e(e);
            }
        }
    }

    public class d extends HttpHandlerWrap {
        public final /* synthetic */ DynamicPwdWithAuthCallback a;
        public final /* synthetic */ DynamicPwdWithAuthResult b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Looper looper, DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback, DynamicPwdWithAuthResult dynamicPwdWithAuthResult, boolean z) {
            super(looper);
            this.a = dynamicPwdWithAuthCallback;
            this.b = dynamicPwdWithAuthResult;
            this.c = z;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.b.setResultCode(i2);
            this.a.onFailure(this.b);
        }

        public void onFinish() {
            this.a.onFinish();
        }

        public void onStart() {
            this.a.onStart();
        }

        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int errorCode = EnhancedService.this.getErrorCode(str);
                this.b.setResultCode(errorCode);
                int optInt = jSONObject.optInt(EnhancedService.KEY_SMS_CODE_LENGTH, 6);
                EnhancedService.smsCodeLength = optInt;
                this.b.smsCodeLength = optInt;
                JSONObject optJSONObject = jSONObject.optJSONObject("sdk");
                if (optJSONObject != null) {
                    this.b.setResultMsg(optJSONObject.optString("msg"));
                }
                if (errorCode == 0) {
                    this.a.onSuccess(this.b);
                    return;
                }
                String optString = jSONObject.optString("channelID");
                if (!this.c || TextUtils.isEmpty(optString)) {
                    this.a.onFailure(this.b);
                } else {
                    EnhancedService.this.a(optString, this.a);
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                Log.e(e);
            }
        }
    }

    public class e extends HttpHandlerWrap {
        public final /* synthetic */ SapiCallback a;
        public final /* synthetic */ DynamicPwdLoginResult b;
        public final /* synthetic */ SapiDataEncryptor c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Looper looper, SapiCallback sapiCallback, DynamicPwdLoginResult dynamicPwdLoginResult, SapiDataEncryptor sapiDataEncryptor) {
            super(looper);
            this.a = sapiCallback;
            this.b = dynamicPwdLoginResult;
            this.c = sapiDataEncryptor;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.b.setResultCode(i2);
            this.a.onFailure(this.b);
        }

        public void onFinish() {
            this.a.onFinish();
        }

        public void onStart() {
            this.a.onStart();
        }

        public void onSuccess(int i2, String str) {
            int errorCode = EnhancedService.this.getErrorCode(str);
            this.b.setResultCode(errorCode);
            try {
                JSONObject jSONObject = new JSONObject(this.c.decrypt(new JSONObject(str).optString("userinfo")));
                String optString = jSONObject.optJSONObject("sdk").optString("msg");
                this.b.noNeedBack = jSONObject.optBoolean("retry");
                this.b.setResultMsg(optString);
                if (errorCode != 0) {
                    this.a.onFailure(this.b);
                    return;
                }
                SapiAccount parseAccount = EnhancedService.this.parseAccount(jSONObject);
                if (this.a instanceof SapiCallbackInterceptor) {
                    try {
                        this.b.session = parseAccount;
                        ((SapiCallbackInterceptor) this.a).beforeSuccess(this.b);
                    } catch (Throwable th2) {
                        Log.e(th2);
                    }
                }
                parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                this.a.onSuccess(this.b);
            } catch (Exception e) {
                this.a.onFailure(this.b);
                Log.e(e);
            }
        }
    }

    public class f extends HttpHandlerWrap {
        public final /* synthetic */ DynamicPwdWithAuthCallback a;
        public final /* synthetic */ DynamicPwdWithAuthResult b;
        public final /* synthetic */ SapiDataEncryptor c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Looper looper, DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback, DynamicPwdWithAuthResult dynamicPwdWithAuthResult, SapiDataEncryptor sapiDataEncryptor, boolean z) {
            super(looper);
            this.a = dynamicPwdWithAuthCallback;
            this.b = dynamicPwdWithAuthResult;
            this.c = sapiDataEncryptor;
            this.d = z;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.b.setResultCode(i2);
            this.a.onFailure(this.b);
        }

        public void onFinish() {
            this.a.onFinish();
        }

        public void onStart() {
            this.a.onStart();
        }

        public void onSuccess(int i2, String str) {
            int errorCode = EnhancedService.this.getErrorCode(str);
            this.b.setResultCode(errorCode);
            try {
                JSONObject jSONObject = new JSONObject(this.c.decrypt(new JSONObject(str).optString("userinfo")));
                JSONObject optJSONObject = jSONObject.optJSONObject("sdk");
                if (optJSONObject != null) {
                    this.b.setResultMsg(optJSONObject.optString("msg"));
                }
                this.b.noNeedBack = jSONObject.optBoolean("retry");
                if (errorCode == 0) {
                    SapiAccount parseAccount = EnhancedService.this.parseAccount(jSONObject);
                    this.b.session = parseAccount;
                    parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                    ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                    this.a.onSuccess(this.b);
                    return;
                }
                String optString = jSONObject.optString("channelID");
                if (!this.d || TextUtils.isEmpty(optString)) {
                    this.a.onFailure(this.b);
                } else {
                    EnhancedService.this.a(optString, this.a);
                }
            } catch (Exception e2) {
                this.a.onFailure(this.b);
                Log.e(e2);
            }
        }
    }

    public class g extends BinaryHttpHandlerWrap {
        public final /* synthetic */ SapiCallback a;
        public final /* synthetic */ GetCaptchaResult b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Looper looper, String[] strArr, SapiCallback sapiCallback, GetCaptchaResult getCaptchaResult) {
            super(looper, strArr);
            this.a = sapiCallback;
            this.b = getCaptchaResult;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.b.setResultCode(i2);
            this.a.onFailure(this.b);
        }

        public void onFinish() {
            this.a.onFinish();
        }

        public void onStart() {
            this.a.onStart();
        }

        public void onSuccess(int i2, byte[] bArr) {
            if (bArr != null) {
                this.b.setResultCode(0);
                GetCaptchaResult getCaptchaResult = this.b;
                getCaptchaResult.captchaImage = bArr;
                this.a.onSuccess(getCaptchaResult);
                return;
            }
            this.b.setResultCode(-202);
            this.a.onFailure(this.b);
        }
    }

    public class h extends HttpHandlerWrap {
        public final /* synthetic */ DynamicPwdWithAuthResult a;
        public final /* synthetic */ DynamicPwdWithAuthCallback b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Looper looper, DynamicPwdWithAuthResult dynamicPwdWithAuthResult, DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback, String str) {
            super(looper);
            this.a = dynamicPwdWithAuthResult;
            this.b = dynamicPwdWithAuthCallback;
            this.c = str;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.a.setResultCode(i2);
            this.b.onFailure(this.a);
        }

        public void onFinish() {
        }

        public void onStart() {
        }

        public void onSuccess(int i2, String str) {
            int i3;
            try {
                i3 = new JSONObject(str).getInt("code");
            } catch (Exception e) {
                Log.e(e);
                i3 = -100;
            }
            this.a.setResultCode(i3);
            if (i3 == 0) {
                this.b.onSendAuthSms();
                EnhancedService enhancedService = EnhancedService.this;
                enhancedService.mCanLooperLoginCheck = true;
                enhancedService.startLooper(this.c, this.b);
                return;
            }
            this.b.onFailure(this.a);
        }
    }

    public class i extends HttpHandlerWrap {
        public final /* synthetic */ SmsLoginLooperResult a;
        public final /* synthetic */ SmsLoginLooperCallback b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Looper looper, SmsLoginLooperResult smsLoginLooperResult, SmsLoginLooperCallback smsLoginLooperCallback, String str) {
            super(looper);
            this.a = smsLoginLooperResult;
            this.b = smsLoginLooperCallback;
            this.c = str;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.a.setResultCode(i2);
            this.b.onFailure(this.a);
        }

        public void onFinish() {
        }

        public void onStart() {
        }

        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.a.setResultCode(parseInt);
                this.a.setResultMsg(optString);
                if (parseInt == 0) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                    int optInt = jSONObject2.optInt("status");
                    this.a.status = optInt;
                    if (optInt == 0) {
                        EnhancedService.this.getSmsLooperLoginResult(this.b, this.a, jSONObject2.optString(v.d));
                    } else if (optInt == 1) {
                        this.b.onOpenAuthDone(this.a);
                        if (EnhancedService.this.mCanLooperLoginCheck) {
                            EnhancedService.this.smsLoginLooper(this.b, this.c);
                        }
                    } else if (optInt == 2) {
                        this.a.setResultCode(optInt);
                        this.a.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                        this.b.onUserCancel(this.a);
                    } else if (EnhancedService.this.mCanLooperLoginCheck) {
                        EnhancedService.this.smsLoginLooper(this.b, this.c);
                    }
                } else if (parseInt != 1) {
                    this.b.onFailure(this.a);
                } else if (EnhancedService.this.mCanLooperLoginCheck) {
                    EnhancedService.this.smsLoginLooper(this.b, this.c);
                }
            } catch (Throwable th2) {
                this.b.onFailure(this.a);
                Log.e(th2);
            }
        }
    }

    public EnhancedService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    public static synchronized EnhancedService getInstance(SapiConfiguration sapiConfiguration, String str) {
        EnhancedService enhancedService;
        synchronized (EnhancedService.class) {
            if (f == null) {
                f = new EnhancedService(sapiConfiguration, str);
            }
            enhancedService = f;
        }
        return enhancedService;
    }

    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2, Map<String, String> map) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        DynamicPwdLoginResult dynamicPwdLoginResult = new DynamicPwdLoginResult();
        if (TextUtils.isEmpty(str)) {
            dynamicPwdLoginResult.setResultCode(-101);
            sapiCallback.onFailure(dynamicPwdLoginResult);
        } else if (TextUtils.isEmpty(str2)) {
            dynamicPwdLoginResult.setResultCode(-102);
            sapiCallback.onFailure(dynamicPwdLoginResult);
        } else {
            HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.LOGIN_URI);
            buildSapiParams.put("crypttype", String.valueOf(6));
            buildSapiParams.put("cert_id", String.valueOf(1));
            buildSapiParams.put("isphone", "1");
            buildSapiParams.put("isdpass", "1");
            if (map != null) {
                buildSapiParams.putAll(map);
            }
            SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", str);
                jSONObject.put("password", str2);
                jSONObject.put("login_type", "3");
                jSONObject.put("key", sapiDataEncryptor.getAESKey());
                buildSapiParams.put("userinfo", sapiDataEncryptor.encrypt(SapiDataEncryptor.Cert1.CERT, jSONObject.toString()));
                HttpClientWrap httpClientWrap = new HttpClientWrap();
                httpClientWrap.post(SapiEnv.LOGIN_URI, buildSapiParams, (List<HttpCookie>) null, getUaInfo(), new e(Looper.getMainLooper(), sapiCallback, dynamicPwdLoginResult, sapiDataEncryptor));
            } catch (Exception e2) {
                dynamicPwdLoginResult.setResultCode(-202);
                sapiCallback.onFailure(dynamicPwdLoginResult);
                Log.e(e2);
            }
        }
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (!TextUtils.isEmpty(this.a)) {
            GetCaptchaResult getCaptchaResult = new GetCaptchaResult();
            HttpClientWrap httpClientWrap = new HttpClientWrap();
            httpClientWrap.get(SapiEnv.CAPTCHA_URI + this.a, ReqPriority.IMMEDIATE, (HttpHashMap) null, (List<HttpCookie>) null, getUaInfo(), 0, new g(Looper.getMainLooper(), new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"}, sapiCallback, getCaptchaResult));
        } else {
            throw new IllegalArgumentException("captchaKey can't be empty");
        }
    }

    public String getCaptchaKey() {
        return this.a;
    }

    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        if (sapiCallback != null) {
            GetDynamicPwdResult getDynamicPwdResult = new GetDynamicPwdResult();
            if (TextUtils.isEmpty(str)) {
                getDynamicPwdResult.setResultCode(-101);
                sapiCallback.onFailure(getDynamicPwdResult);
            } else if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
                getDynamicPwdResult.setResultCode(-201);
                sapiCallback.onFailure(getDynamicPwdResult);
            } else {
                HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.GET_DYNAMIC_PWD_URI);
                buildSapiParams.put("username", str);
                new HttpClientWrap().post(SapiEnv.GET_DYNAMIC_PWD_URI, buildSapiParams, (List<HttpCookie>) null, getUaInfo(), new b(Looper.getMainLooper(), sapiCallback, getDynamicPwdResult));
            }
        } else {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
    }

    public int getSmsCodeLength() {
        return smsCodeLength;
    }

    public void getSmsLooperLoginResult(SmsLoginLooperCallback smsLoginLooperCallback, SmsLoginLooperResult smsLoginLooperResult, String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("display", "pcsdk");
        httpHashMapWrap.put(OCRTakePhotoActivity.ROUTER_INIT_TAB_QRCODE, "1");
        new HttpClientWrap().get(SapiEnv.GET_QR_LOGIN_RESULT, ReqPriority.IMMEDIATE, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new a(Looper.getMainLooper(), smsLoginLooperResult, smsLoginLooperCallback));
    }

    public void smsLoginLooper(SmsLoginLooperCallback smsLoginLooperCallback, String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put("callback", "cb");
        httpHashMapWrap.put("channel_id", str);
        httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
        SmsLoginLooperResult smsLoginLooperResult = new SmsLoginLooperResult();
        PassHttpClientRequest passHttpClientRequest = this.c;
        if (passHttpClientRequest != null) {
            passHttpClientRequest.cancel();
        }
        this.c = new HttpClientWrap().get(SapiEnv.GET_QR_LOGIN_STATUS_CHECK, ReqPriority.IMMEDIATE, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), 40000, new i(Looper.getMainLooper(), smsLoginLooperResult, smsLoginLooperCallback, str));
    }

    public void startLooper(String str, final DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback) {
        smsLoginLooper(new SmsLoginLooperCallback() {
            public void onFailure(SmsLoginLooperResult smsLoginLooperResult) {
                DynamicPwdWithAuthResult dynamicPwdWithAuthResult = new DynamicPwdWithAuthResult();
                dynamicPwdWithAuthResult.setResultCode(smsLoginLooperResult.getResultCode());
                dynamicPwdWithAuthResult.setResultMsg(smsLoginLooperResult.getResultMsg());
                dynamicPwdWithAuthCallback.onFailure(dynamicPwdWithAuthResult);
            }

            public void onLoginDone(SmsLoginLooperResult smsLoginLooperResult) {
                DynamicPwdWithAuthResult dynamicPwdWithAuthResult = new DynamicPwdWithAuthResult();
                dynamicPwdWithAuthResult.setResultCode(smsLoginLooperResult.getResultCode());
                dynamicPwdWithAuthResult.setResultMsg(smsLoginLooperResult.getResultMsg());
                dynamicPwdWithAuthResult.isSmsAuthLogin = true;
                dynamicPwdWithAuthResult.session = smsLoginLooperResult.session;
                dynamicPwdWithAuthCallback.onSuccess(dynamicPwdWithAuthResult);
            }

            public void onOpenAuthDone(SmsLoginLooperResult smsLoginLooperResult) {
            }

            public void onUserCancel(SmsLoginLooperResult smsLoginLooperResult) {
                DynamicPwdWithAuthResult dynamicPwdWithAuthResult = new DynamicPwdWithAuthResult();
                dynamicPwdWithAuthResult.setResultCode(smsLoginLooperResult.getResultCode());
                dynamicPwdWithAuthResult.setResultMsg(smsLoginLooperResult.getResultMsg());
                dynamicPwdWithAuthCallback.onFailure(dynamicPwdWithAuthResult);
            }
        }, str);
    }

    public void stopLooperLoginCheck() {
        this.mCanLooperLoginCheck = false;
        PassHttpClientRequest passHttpClientRequest = this.c;
        if (passHttpClientRequest != null) {
            passHttpClientRequest.cancel();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("channelID", str);
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null) {
            httpHashMapWrap.put("tpl", sapiConfiguration.tpl);
        }
        DynamicPwdWithAuthResult dynamicPwdWithAuthResult = new DynamicPwdWithAuthResult();
        new HttpClientWrap().post(SapiEnv.GET_VR_SMS_GUIDE, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new h(Looper.getMainLooper(), dynamicPwdWithAuthResult, dynamicPwdWithAuthCallback, str));
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2, Map<String, String> map) {
        SapiUtils.notNull(getDynamicPwdCallback, SapiCallback.class.getSimpleName() + " can't be null");
        GetDynamicPwdResult getDynamicPwdResult = new GetDynamicPwdResult();
        if (TextUtils.isEmpty(str)) {
            getDynamicPwdResult.setResultCode(-101);
            getDynamicPwdCallback.onFailure(getDynamicPwdResult);
            return;
        }
        HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.GET_DYNAMIC_PWD_URI);
        buildSapiParams.put("username", str);
        buildSapiParams.put("svcd", "1");
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(str2)) {
            buildSapiParams.put("vcodestr", this.a);
            buildSapiParams.put("vcodesign", this.b);
            buildSapiParams.put("verifycode", str2);
        }
        if (map != null) {
            buildSapiParams.putAll(map);
        }
        new HttpClientWrap().post(SapiEnv.GET_DYNAMIC_PWD_URI, ReqPriority.HIGH, buildSapiParams, (List<HttpCookie>) null, getUaInfo(), new c(Looper.getMainLooper(), getDynamicPwdCallback, getDynamicPwdResult));
    }

    public void dynamicPwdLogin(DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback, String str, String str2, boolean z) {
        DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback2 = dynamicPwdWithAuthCallback;
        SapiUtils.notNull(dynamicPwdWithAuthCallback2, SapiCallback.class.getSimpleName() + " can't be null");
        DynamicPwdWithAuthResult dynamicPwdWithAuthResult = new DynamicPwdWithAuthResult();
        if (TextUtils.isEmpty(str)) {
            dynamicPwdWithAuthResult.setResultCode(-101);
            dynamicPwdWithAuthCallback2.onFailure(dynamicPwdWithAuthResult);
        } else if (TextUtils.isEmpty(str2)) {
            dynamicPwdWithAuthResult.setResultCode(-102);
            dynamicPwdWithAuthCallback2.onFailure(dynamicPwdWithAuthResult);
        } else {
            HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.LOGIN_URI);
            buildSapiParams.put("crypttype", String.valueOf(6));
            buildSapiParams.put("cert_id", String.valueOf(1));
            String str3 = "1";
            buildSapiParams.put("isphone", str3);
            buildSapiParams.put("isdpass", str3);
            if (!z) {
                str3 = "0";
            }
            buildSapiParams.put("isvr", str3);
            buildSapiParams.put("deviceName", Build.BRAND + " " + Build.MODEL);
            SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", str);
                jSONObject.put("password", str2);
                jSONObject.put("login_type", "3");
                jSONObject.put("key", sapiDataEncryptor.getAESKey());
                buildSapiParams.put("userinfo", sapiDataEncryptor.encrypt(SapiDataEncryptor.Cert1.CERT, jSONObject.toString()));
                HttpClientWrap httpClientWrap = new HttpClientWrap();
                httpClientWrap.post(SapiEnv.LOGIN_URI, buildSapiParams, (List<HttpCookie>) null, getUaInfo(), new f(Looper.getMainLooper(), dynamicPwdWithAuthCallback, dynamicPwdWithAuthResult, sapiDataEncryptor, z));
            } catch (Exception e2) {
                dynamicPwdWithAuthResult.setResultCode(-202);
                dynamicPwdWithAuthCallback2.onFailure(dynamicPwdWithAuthResult);
                Log.e(e2);
            }
        }
    }

    public void getDynamicPwd(DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback, String str, boolean z) {
        if (dynamicPwdWithAuthCallback != null) {
            DynamicPwdWithAuthResult dynamicPwdWithAuthResult = new DynamicPwdWithAuthResult();
            if (TextUtils.isEmpty(str)) {
                dynamicPwdWithAuthResult.setResultCode(-101);
                dynamicPwdWithAuthCallback.onFailure(dynamicPwdWithAuthResult);
            } else if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
                dynamicPwdWithAuthResult.setResultCode(-201);
                dynamicPwdWithAuthCallback.onFailure(dynamicPwdWithAuthResult);
            } else {
                HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.GET_DYNAMIC_PWD_URI);
                buildSapiParams.put("username", str);
                buildSapiParams.put("isvr", z ? "1" : "0");
                buildSapiParams.put("deviceName", Build.BRAND + " " + Build.MODEL);
                buildSapiParams.put("skipreg", "1");
                new HttpClientWrap().post(SapiEnv.GET_DYNAMIC_PWD_URI, buildSapiParams, (List<HttpCookie>) null, getUaInfo(), new d(Looper.getMainLooper(), dynamicPwdWithAuthCallback, dynamicPwdWithAuthResult, z));
            }
        } else {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
    }
}
