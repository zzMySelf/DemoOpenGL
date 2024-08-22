package com.baidu.wallet.lightapp.business.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.utils.ImageBase64Utils;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static final String a = "a";
    public Activity b;
    public LightappBusinessClient c;
    public String d;
    public int e = -1;
    public String f;

    public a(Activity activity, LightappBusinessClient lightappBusinessClient, String str) {
        this.b = activity;
        this.c = lightappBusinessClient;
        this.d = str;
    }

    public void a(Intent intent, final JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(this.d);
            String optString = jSONObject2.optString("fixedWidth");
            if (!TextUtils.isEmpty(optString)) {
                this.e = Integer.parseInt(optString);
                String str = a;
                LogUtil.d(str, "fixedWidth = " + this.e);
            }
            this.f = jSONObject2.optString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            Uri data = intent.getData();
            if (data == null) {
                jSONObject.put("errCode", "10003");
                jSONObject.put("des", EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                this.c.setAlubmPhotoData(1, jSONObject);
                return;
            }
            ImageBase64Utils.getInstance().getImageBase64((Context) this.b, data, this.e, (ImageBase64Utils.ImageBase64Listener) new ImageBase64Utils.ImageBase64Listener() {
                /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
                    r10.put("errCode", "10003");
                    r10.put("des", com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction.ERROR_MSG_INSIDE);
                    com.baidu.wallet.lightapp.business.presenter.a.a(r8.b).setAlubmPhotoData(1, r10);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x0068, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0069, code lost:
                    r9 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
                    r9.printStackTrace();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x006d, code lost:
                    return;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0053 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onBase64Result(java.lang.String r9) {
                    /*
                        r8 = this;
                        boolean r0 = android.text.TextUtils.isEmpty(r9)
                        r1 = 1
                        java.lang.String r2 = "内部错误"
                        java.lang.String r3 = "10003"
                        java.lang.String r4 = "des"
                        java.lang.String r5 = "errCode"
                        if (r0 == 0) goto L_0x0029
                        org.json.JSONObject r0 = r10     // Catch:{ JSONException -> 0x0025 }
                        r0.put(r5, r3)     // Catch:{ JSONException -> 0x0025 }
                        org.json.JSONObject r0 = r10     // Catch:{ JSONException -> 0x0025 }
                        r0.put(r4, r2)     // Catch:{ JSONException -> 0x0025 }
                        com.baidu.wallet.lightapp.business.presenter.a r0 = com.baidu.wallet.lightapp.business.presenter.a.this     // Catch:{ JSONException -> 0x0025 }
                        com.baidu.wallet.lightapp.business.LightappBusinessClient r0 = r0.c     // Catch:{ JSONException -> 0x0025 }
                        org.json.JSONObject r6 = r10     // Catch:{ JSONException -> 0x0025 }
                        r0.setAlubmPhotoData(r1, r6)     // Catch:{ JSONException -> 0x0025 }
                        return
                    L_0x0025:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x0029:
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0053 }
                        r0.<init>()     // Catch:{ JSONException -> 0x0053 }
                        java.lang.String r6 = "image"
                        r0.put(r6, r9)     // Catch:{ JSONException -> 0x0053 }
                        org.json.JSONObject r9 = r10     // Catch:{ JSONException -> 0x0053 }
                        r6 = 0
                        r9.put(r5, r6)     // Catch:{ JSONException -> 0x0053 }
                        org.json.JSONObject r9 = r10     // Catch:{ JSONException -> 0x0053 }
                        java.lang.String r7 = "ok"
                        r9.put(r4, r7)     // Catch:{ JSONException -> 0x0053 }
                        org.json.JSONObject r9 = r10     // Catch:{ JSONException -> 0x0053 }
                        java.lang.String r7 = "data"
                        r9.put(r7, r0)     // Catch:{ JSONException -> 0x0053 }
                        com.baidu.wallet.lightapp.business.presenter.a r9 = com.baidu.wallet.lightapp.business.presenter.a.this     // Catch:{ JSONException -> 0x0053 }
                        com.baidu.wallet.lightapp.business.LightappBusinessClient r9 = r9.c     // Catch:{ JSONException -> 0x0053 }
                        org.json.JSONObject r0 = r10     // Catch:{ JSONException -> 0x0053 }
                        r9.setAlubmPhotoData(r6, r0)     // Catch:{ JSONException -> 0x0053 }
                        return
                    L_0x0053:
                        org.json.JSONObject r9 = r10     // Catch:{ JSONException -> 0x0069 }
                        r9.put(r5, r3)     // Catch:{ JSONException -> 0x0069 }
                        org.json.JSONObject r9 = r10     // Catch:{ JSONException -> 0x0069 }
                        r9.put(r4, r2)     // Catch:{ JSONException -> 0x0069 }
                        com.baidu.wallet.lightapp.business.presenter.a r9 = com.baidu.wallet.lightapp.business.presenter.a.this     // Catch:{ JSONException -> 0x0069 }
                        com.baidu.wallet.lightapp.business.LightappBusinessClient r9 = r9.c     // Catch:{ JSONException -> 0x0069 }
                        org.json.JSONObject r0 = r10     // Catch:{ JSONException -> 0x0069 }
                        r9.setAlubmPhotoData(r1, r0)     // Catch:{ JSONException -> 0x0069 }
                        return
                    L_0x0069:
                        r9 = move-exception
                        r9.printStackTrace()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.presenter.a.AnonymousClass1.onBase64Result(java.lang.String):void");
                }
            });
        } catch (Throwable th2) {
            try {
                jSONObject.put("errCode", "10003");
                jSONObject.put("des", th2.getMessage());
                this.c.setAlubmPhotoData(1, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
