package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Base64;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.baidu.wallet.core.beans.CometHttpRequestInterceptor;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import org.json.JSONObject;

public class b extends AsyncTask<Void, Void, a> {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public OAuthListener f;
    public c g;

    public static class a {
        public OAuthErrCode a;
        public String b;
        public String c;
        public String d;
        public byte[] e;

        public static a a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, com.baidu.apollon.heartbeat.a.h));
                        int i2 = jSONObject.getInt("errcode");
                        if (i2 != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[]{Integer.valueOf(i2)}));
                            aVar.a = OAuthErrCode.WechatAuth_Err_NormalErr;
                            jSONObject.optString("errmsg");
                            return aVar;
                        }
                        String string = jSONObject.getJSONObject(OCRTakePhotoActivity.ROUTER_INIT_TAB_QRCODE).getString("qrcodebase64");
                        if (string != null) {
                            if (string.length() != 0) {
                                byte[] decode = Base64.decode(string, 0);
                                if (decode != null) {
                                    if (decode.length != 0) {
                                        aVar.a = OAuthErrCode.WechatAuth_Err_OK;
                                        aVar.e = decode;
                                        aVar.b = jSONObject.getString(UrlOcrConfig.IdCardKey.UUID);
                                        String string2 = jSONObject.getString("appname");
                                        aVar.c = string2;
                                        Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{aVar.b, string2, Integer.valueOf(aVar.e.length)}));
                                        return aVar;
                                    }
                                }
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                aVar.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                return aVar;
                            }
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        aVar.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (Exception e2) {
                        format = String.format("parse json fail, ex = %s", new Object[]{e2.getMessage()});
                        Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.a = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e3) {
                    format = String.format("parse fail, build String fail, ex = %s", new Object[]{e3.getMessage()});
                    Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.a = oAuthErrCode;
                    return aVar;
                }
            }
            aVar.a = oAuthErrCode;
            return aVar;
        }
    }

    public b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = oAuthListener;
    }

    public boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        c cVar = this.g;
        return cVar == null ? cancel(true) : cVar.cancel(true);
    }

    public Object doInBackground(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", new Object[]{this.a, this.c, this.d, this.b, this.e});
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a2 = com.tencent.mm.opensdk.channel.a.a.a(format, (int) CometHttpRequestInterceptor.a);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[]{format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        return a.a(a2);
    }

    public void onPostExecute(Object obj) {
        a aVar = (a) obj;
        OAuthErrCode oAuthErrCode = aVar.a;
        if (oAuthErrCode == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar.e.length);
            this.f.onAuthGotQrcode(aVar.d, aVar.e);
            c cVar = new c(aVar.b, this.f);
            this.g = cVar;
            if (Build.VERSION.SDK_INT >= 11) {
                cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                cVar.execute(new Void[0]);
            }
        } else {
            Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[]{oAuthErrCode}));
            this.f.onAuthFinish(aVar.a, (String) null);
        }
    }
}
