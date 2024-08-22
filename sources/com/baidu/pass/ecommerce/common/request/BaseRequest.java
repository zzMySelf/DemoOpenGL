package com.baidu.pass.ecommerce.common.request;

import android.os.Handler;
import com.baidu.netdisk.network.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRequest {
    private static final String CLIENT = "android";
    private static final String CLIENT_FROM = "native";
    private static final int HTTP_OK_CODE = 200;
    private static final String KEY_CODE = "code";
    private static final String KEY_MSG = "msg";
    private static final String KEY_RESPONSE_CODE = "errno";
    private static final String KEY_RESPONSE_MSG = "errmsg";
    private static final String PASS_TPL = "pp";
    private static final String TAG = "BaseRequest";
    private long OPTION_NET_LOADING_LIMIT_TIME = 300;
    /* access modifiers changed from: private */
    public SapiAccount account = SapiContext.getInstance().getCurrentAccount();
    private Handler actionTimeHandler;
    /* access modifiers changed from: private */
    public AddressManageDTO addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
    /* access modifiers changed from: private */
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getSapiConfiguration();
    private List<HttpCookie> cookies = new ArrayList<HttpCookie>() {
        {
            add(BaseRequest.this.buildCookie("BAIDUID", SapiUtils.getCookie("https://baidu.com", "BAIDUID")));
            add(BaseRequest.this.buildCookie("cuid", SapiUtils.getClientId(BaseRequest.this.configuration.context)));
            if (BaseRequest.this.account != null) {
                add(BaseRequest.this.buildCookie(Constants.NETDISK_BDUSS_FIELD_NAME, BaseRequest.this.account.bduss));
                add(BaseRequest.this.buildCookie(Constants.COOKIE_STOKEN, BaseRequest.this.getPPSToken()));
            }
        }
    };
    private HttpHashMapWrap paramsMap = new HttpHashMapWrap() {
        {
            put("client", "android");
            put("clientfrom", "native");
            put("tpl", BaseRequest.this.configuration.tpl);
            if (BaseRequest.this.addressManageDTO != null) {
                put("tplse", BaseRequest.this.addressManageDTO.tplse);
                put("tplt", BaseRequest.this.addressManageDTO.tplt);
            }
        }
    };

    /* access modifiers changed from: private */
    public HttpCookie buildCookie(String str, String str2) {
        HttpCookie httpCookie = new HttpCookie(str, str2);
        httpCookie.setDomain(this.configuration.environment.getUrlDomain());
        httpCookie.setPath("/");
        return httpCookie;
    }

    /* access modifiers changed from: private */
    public String getPPSToken() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("pp");
        return SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
            public void onFailure(GetTplStokenResult getTplStokenResult) {
            }

            public void onFinish() {
            }

            public void onStart() {
            }

            public void onSuccess(GetTplStokenResult getTplStokenResult) {
            }
        }, this.account.bduss, arrayList).get("pp");
    }

    /* access modifiers changed from: private */
    public void releaseActionTimeHandler() {
        if (this.actionTimeHandler != null) {
            Log.d(TAG, "releaseActionTimeHandler");
            this.actionTimeHandler.removeCallbacksAndMessages((Object) null);
            this.actionTimeHandler = null;
        }
    }

    /* access modifiers changed from: protected */
    public void addCookie(HttpCookie httpCookie) {
        this.cookies.add(httpCookie);
    }

    /* access modifiers changed from: protected */
    public void addParams(String str, String str2) {
        this.paramsMap.put(str, str2);
    }

    /* access modifiers changed from: protected */
    public abstract String getRelativeUrl();

    /* access modifiers changed from: protected */
    public String getUserAgent() {
        return null;
    }

    public void submit(final NetCallback netCallback) {
        Handler handler = new Handler();
        this.actionTimeHandler = handler;
        handler.postDelayed(new Runnable() {
            public void run() {
                netCallback.onShowLoading();
            }
        }, this.OPTION_NET_LOADING_LIMIT_TIME);
        new HttpClientWrap().post(getRelativeUrl(), this.paramsMap, this.cookies, getUserAgent(), new HttpHandlerWrap() {
            /* access modifiers changed from: protected */
            /* JADX WARNING: Code restructure failed: missing block: B:5:0x004c, code lost:
                if (android.text.TextUtils.isEmpty(r6) == false) goto L_0x0059;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0053, code lost:
                if (android.text.TextUtils.isEmpty(r6) == false) goto L_0x0059;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onFailure(java.lang.Throwable r4, int r5, java.lang.String r6) {
                /*
                    r3 = this;
                    com.baidu.pass.ecommerce.common.request.BaseRequest r0 = com.baidu.pass.ecommerce.common.request.BaseRequest.this
                    r0.releaseActionTimeHandler()
                    r0 = 1
                    java.lang.Object[] r0 = new java.lang.Object[r0]
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "Failure: url="
                    java.lang.StringBuilder r1 = r1.append(r2)
                    com.baidu.pass.ecommerce.common.request.BaseRequest r2 = com.baidu.pass.ecommerce.common.request.BaseRequest.this
                    java.lang.String r2 = r2.getRelativeUrl()
                    java.lang.StringBuilder r1 = r1.append(r2)
                    java.lang.String r2 = " code="
                    java.lang.StringBuilder r1 = r1.append(r2)
                    java.lang.StringBuilder r5 = r1.append(r5)
                    java.lang.String r1 = " response="
                    java.lang.StringBuilder r5 = r5.append(r1)
                    java.lang.StringBuilder r5 = r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    r1 = 0
                    r0[r1] = r5
                    java.lang.String r5 = "BaseRequest"
                    com.baidu.sapi2.utils.Log.d(r5, r0)
                    com.baidu.pass.ecommerce.common.request.NetCallback r5 = r11
                    if (r5 != 0) goto L_0x0042
                    return
                L_0x0042:
                    if (r4 == 0) goto L_0x004f
                    java.lang.String r6 = r4.getMessage()
                    boolean r4 = android.text.TextUtils.isEmpty(r6)
                    if (r4 != 0) goto L_0x0056
                    goto L_0x0059
                L_0x004f:
                    boolean r4 = android.text.TextUtils.isEmpty(r6)
                    if (r4 != 0) goto L_0x0056
                    goto L_0x0059
                L_0x0056:
                    java.lang.String r6 = "未知错误"
                L_0x0059:
                    com.baidu.pass.ecommerce.common.request.NetCallback r4 = r11
                    r5 = -10000(0xffffffffffffd8f0, float:NaN)
                    r4.onFailure(r5, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.ecommerce.common.request.BaseRequest.AnonymousClass5.onFailure(java.lang.Throwable, int, java.lang.String):void");
            }

            /* access modifiers changed from: protected */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0069 A[Catch:{ JSONException -> 0x0090 }] */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x006f A[Catch:{ JSONException -> 0x0090 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(int r8, java.lang.String r9) {
                /*
                    r7 = this;
                    java.lang.String r0 = "msg"
                    java.lang.String r1 = "errmsg"
                    java.lang.String r2 = "code"
                    java.lang.String r3 = "errno"
                    com.baidu.pass.ecommerce.common.request.BaseRequest r4 = com.baidu.pass.ecommerce.common.request.BaseRequest.this
                    r4.releaseActionTimeHandler()
                    r4 = 1
                    java.lang.Object[] r4 = new java.lang.Object[r4]
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "Success: url="
                    java.lang.StringBuilder r5 = r5.append(r6)
                    com.baidu.pass.ecommerce.common.request.BaseRequest r6 = com.baidu.pass.ecommerce.common.request.BaseRequest.this
                    java.lang.String r6 = r6.getRelativeUrl()
                    java.lang.StringBuilder r5 = r5.append(r6)
                    java.lang.String r6 = " response="
                    java.lang.StringBuilder r5 = r5.append(r6)
                    java.lang.StringBuilder r5 = r5.append(r9)
                    java.lang.String r5 = r5.toString()
                    r6 = 0
                    r4[r6] = r5
                    java.lang.String r5 = "BaseRequest"
                    com.baidu.sapi2.utils.Log.d(r5, r4)
                    com.baidu.pass.ecommerce.common.request.NetCallback r4 = r11
                    if (r4 != 0) goto L_0x0040
                    return
                L_0x0040:
                    r5 = 200(0xc8, float:2.8E-43)
                    if (r5 == r8) goto L_0x0048
                    r4.onFailure(r8, r9)
                    return
                L_0x0048:
                    r8 = -10000(0xffffffffffffd8f0, float:NaN)
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0090 }
                    r4.<init>(r9)     // Catch:{ JSONException -> 0x0090 }
                    boolean r9 = r4.has(r3)     // Catch:{ JSONException -> 0x0090 }
                    if (r9 == 0) goto L_0x005a
                    int r9 = r4.optInt(r3, r8)     // Catch:{ JSONException -> 0x0090 }
                    goto L_0x0065
                L_0x005a:
                    boolean r9 = r4.has(r2)     // Catch:{ JSONException -> 0x0090 }
                    if (r9 == 0) goto L_0x0066
                    int r9 = r4.optInt(r2, r8)     // Catch:{ JSONException -> 0x0090 }
                L_0x0065:
                    goto L_0x0067
                L_0x0066:
                    r9 = r8
                L_0x0067:
                    if (r9 != 0) goto L_0x006f
                    com.baidu.pass.ecommerce.common.request.NetCallback r9 = r11     // Catch:{ JSONException -> 0x0090 }
                    r9.onSuccess(r4)     // Catch:{ JSONException -> 0x0090 }
                    goto L_0x009a
                L_0x006f:
                    boolean r2 = r4.has(r1)     // Catch:{ JSONException -> 0x0090 }
                    if (r2 == 0) goto L_0x007b
                    java.lang.String r0 = r4.optString(r1)     // Catch:{ JSONException -> 0x0090 }
                    goto L_0x0086
                L_0x007b:
                    boolean r1 = r4.has(r0)     // Catch:{ JSONException -> 0x0090 }
                    if (r1 == 0) goto L_0x0087
                    java.lang.String r0 = r4.optString(r0)     // Catch:{ JSONException -> 0x0090 }
                L_0x0086:
                    goto L_0x008a
                L_0x0087:
                    java.lang.String r0 = "未知错误"
                L_0x008a:
                    com.baidu.pass.ecommerce.common.request.NetCallback r1 = r11     // Catch:{ JSONException -> 0x0090 }
                    r1.onFailure(r9, r0)     // Catch:{ JSONException -> 0x0090 }
                    goto L_0x009a
                L_0x0090:
                    r9 = move-exception
                    com.baidu.pass.ecommerce.common.request.NetCallback r0 = r11
                    java.lang.String r9 = r9.getMessage()
                    r0.onFailure(r8, r9)
                L_0x009a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.ecommerce.common.request.BaseRequest.AnonymousClass5.onSuccess(int, java.lang.String):void");
            }
        });
    }
}
