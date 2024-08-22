package com.baidu.wallet.utils;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alipay.sdk.m.u.i;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.beans.EbpayHttpRequestInterceptor;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.beans.a.a;
import com.baidu.wallet.core.beans.a.c;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.RpaConfig;
import com.baidubce.util.Mimetypes;
import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.Callback;
import com.duxiaoman.okhttp3.Interceptor;
import fe.th.de.ddd;
import fe.th.de.ggg;
import fe.th.de.mmm;
import fe.th.de.nn;
import fe.th.de.ppp;
import fe.th.de.when;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class RpaProcessor implements NoProguard {
    public static final String RPA_ACTION_TRACKER = "rpa_action_tracker";
    public static final String RPA_DOM_DATA_LEGAL = "rpa_dom_data_legal";
    public static final String RPA_GET_DOM_SCRIPT = "rpa_get_dom_script";
    public static final String RPA_INITIALIZATION = "rpa_initialization";
    public static final String RPA_LOAD_TIME = "rpa_load_time";
    public static final String RPA_PAGE_POPUP = "rpa_page_popup";
    public static final String RPA_PAGE_PROHIBIT = "rpa_page_prohibit";
    public static final String RPA_PAGE_UPDATE = "rpa_page_update";
    public static final String RPA_SAVE_DOM = "rpa_save_dom";
    public static final String RPA_UPLOAD_DOM = "rpa_upload_dom";
    public static HashMap<String, Long> a = new HashMap<>();
    public static HashMap<String, Long> b = new HashMap<>();
    public static final String f = "sign";
    public static final String g = "from";
    public static final String h = "_ie";

    /* renamed from: i  reason: collision with root package name */
    public static final String f3650i = "ua";
    public static final String j = "wime";
    public static final String k = "fk_wcp";
    public static final String l = "nettype";
    public static final String m = "cuid_1";
    public static final String n = "cuid_2";

    /* renamed from: o  reason: collision with root package name */
    public static final String f3651o = "natbc";
    public RpaConfig[] c;
    public String d;
    public Executor e;
    public HashMap<String, Long> p;

    public interface IUploadFileCallback extends NoProguard {
        public static final int UPLOAD_ERROR = -1;

        void onUploadFail(int i2, String str);

        void onUploadSuccess(int i2, String str, String str2);
    }

    public static class UploadBosKey implements NoProguard {
        public String data;
    }

    public static class UploadResponse implements NoProguard {
        public UploadBosKey content;
        public String errorContent;
        public String msg;
        public int ret;
    }

    public static class a implements NoProguard {
        public static RpaProcessor a = new RpaProcessor();
    }

    private long a(String str) {
        Long remove = a.remove(str);
        if (remove != null) {
            return remove.longValue();
        }
        return 0;
    }

    private String b(String str) {
        String str2;
        try {
            URL url = new URL(str);
            str2 = url.getHost() + url.getPath();
        } catch (Exception unused) {
            str2 = CheckUtils.stripUrlParams(str);
            if (str2.startsWith("https://")) {
                str2.replace("https://", "");
            }
            if (str2.startsWith("http://")) {
                str2.replace("http://", "");
            }
        }
        if (str2.endsWith("/")) {
            return str2;
        }
        return str2 + "/";
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a.a(new File(str), "MD5");
        } catch (Exception unused) {
            return "";
        }
    }

    public static RpaProcessor getInstance() {
        return a.a;
    }

    public static int getIntValue(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            return 30;
        }
    }

    public static long getLongValue(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception unused) {
            return 30;
        }
    }

    public RpaConfig getTargetRpaConfig(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && isValid(str)) {
            for (RpaConfig rpaConfig : this.c) {
                if (str2.contains(rpaConfig.rpa_url)) {
                    return rpaConfig;
                }
            }
        }
        return null;
    }

    public boolean isNeedUploadDom(String str, String str2, RpaConfig.RpaSenseStrategy rpaSenseStrategy, long j2) {
        if (rpaSenseStrategy != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Long l2 = this.p.get(str);
            if (l2 == null) {
                this.p.put(str, l2);
                return true;
            } else if (j2 - l2.longValue() > getLongValue(rpaSenseStrategy.timeInterval) * 1000) {
                this.p.put(str, Long.valueOf(j2));
                return true;
            }
        }
        return false;
    }

    public boolean isValid(String str) {
        RpaConfig.RpaSenseStrategy[] rpaSenseStrategyArr;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.equals(str, this.d)) {
            try {
                this.d = str;
                this.c = (RpaConfig[]) JsonUtils.fromJson(str, RpaConfig[].class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        RpaConfig[] rpaConfigArr = this.c;
        if (rpaConfigArr != null && rpaConfigArr.length > 0) {
            int length = rpaConfigArr.length;
            int i2 = 0;
            while (i2 < length) {
                RpaConfig rpaConfig = rpaConfigArr[i2];
                if (TextUtils.isEmpty(rpaConfig.rpa_url)) {
                    i2++;
                } else if (!TextUtils.equals("1", rpaConfig.rpa_type) || (rpaSenseStrategyArr = rpaConfig.rpa_sense_strategy) == null || rpaSenseStrategyArr.length <= 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public void storePageStartedMills(String str, long j2) {
        a.put(str, Long.valueOf(j2));
    }

    public void uploadRpaAutomationFile(Context context, String str, String str2, long j2, IUploadFileCallback iUploadFileCallback) throws Exception {
        String str3 = str;
        IUploadFileCallback iUploadFileCallback2 = iUploadFileCallback;
        String str4 = DomainConfig.getInstance().getAppHost(new Boolean[]{Boolean.FALSE}) + "/odp/wireless/misc/app/saveFile";
        final ArrayList<RestNameValuePair> arrayList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(BeanConstants.COOKIE_OPENBDUSS);
        stringBuffer.append("=");
        stringBuffer.append(WalletLoginHelper.getInstance().getOpenLoginToken());
        if (!TextUtils.isEmpty(AccountManager.getInstance(context).getBfbToken())) {
            stringBuffer.append(i.b);
            stringBuffer.append("token=");
            stringBuffer.append(AccountManager.getInstance(context).getBfbToken());
        }
        arrayList.add(new RestNameValuePair("Cookie", stringBuffer.toString()));
        arrayList.add(new RestNameValuePair("Accept-Encoding", "gzip"));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EbpayHttpRequestInterceptor.PARAM_MOBILE_IP, PayUtils.encrypt("phone_number", PhoneUtils.getIpInfo()));
            jSONObject.put(EbpayHttpRequestInterceptor.PARAM_SIM_SERIAL_NUM, "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes()))));
        Context context2 = context;
        a(context, arrayList, str4);
        ggg.ad nn = new ggg().nn();
        nn.qw(new Interceptor() {
            public mmm intercept(Interceptor.Chain chain) throws IOException {
                ddd.qw yj2 = chain.request().yj();
                for (RestNameValuePair restNameValuePair : arrayList) {
                    yj2.qw(restNameValuePair.getName(), restNameValuePair.getValue());
                }
                return chain.qw(yj2.ad());
            }
        });
        ggg ad2 = nn.ad();
        try {
            File file = new File(str3);
            if (file.exists()) {
                String name = file.getName();
                String str5 = b(str2) + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j2)) + name;
                long length = file.length();
                ppp.qw qwVar = new ppp.qw();
                qwVar.rg(ppp.f5222th);
                qwVar.qw("fileKey", PayUtils.encrypt("phone_number", c(str3)));
                qwVar.qw("fileName", str5);
                qwVar.ad("file", str5, nn.de(when.fe(Mimetypes.MIMETYPE_OCTET_STREAM), file));
                for (RestNameValuePair restNameValuePair : arrayList) {
                    qwVar.qw(restNameValuePair.getName(), restNameValuePair.getValue());
                }
                ppp fe2 = qwVar.fe();
                ddd.qw qwVar2 = new ddd.qw();
                qwVar2.uk(str4);
                qwVar2.rg("POST", fe2);
                final IUploadFileCallback iUploadFileCallback3 = iUploadFileCallback;
                final String str6 = str2;
                final long j3 = length;
                final String str7 = str;
                ad2.mmm(qwVar2.ad()).qw(new Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        IUploadFileCallback iUploadFileCallback = iUploadFileCallback3;
                        if (iUploadFileCallback != null) {
                            iUploadFileCallback.onUploadFail(-1, "接口上传失败");
                        }
                        DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_UPLOAD_DOM, Arrays.asList(new String[]{str6, "0", "接口上传失败"}));
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:29:0x0120 A[Catch:{ Exception -> 0x014e }] */
                    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onResponse(com.duxiaoman.okhttp3.Call r13, fe.th.de.mmm r14) throws java.io.IOException {
                        /*
                            r12 = this;
                            java.lang.String r13 = "接口上传成功，boskey为空"
                            java.lang.String r0 = "接口上传成功，response数据解析失败"
                            java.lang.String r1 = "接口上传成功，response为空"
                            boolean r2 = r14.isSuccessful()
                            r3 = 4
                            r4 = 3
                            java.lang.String r5 = "0"
                            r6 = 2
                            r7 = 1
                            r8 = 0
                            java.lang.String r9 = "rpa_upload_dom"
                            if (r2 == 0) goto L_0x0124
                            r2 = -1
                            if (r14 == 0) goto L_0x00d7
                            fe.th.de.aaa r10 = r14.qw()     // Catch:{ Exception -> 0x00f2 }
                            if (r10 == 0) goto L_0x00d7
                            fe.th.de.aaa r14 = r14.qw()     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r14 = r14.pf()     // Catch:{ Exception -> 0x00f2 }
                            java.lang.Class<com.baidu.wallet.utils.RpaProcessor$UploadResponse> r1 = com.baidu.wallet.utils.RpaProcessor.UploadResponse.class
                            java.lang.Object r14 = com.baidu.apollon.utils.JsonUtils.fromJson(r14, r1)     // Catch:{ Exception -> 0x00f2 }
                            com.baidu.wallet.utils.RpaProcessor$UploadResponse r14 = (com.baidu.wallet.utils.RpaProcessor.UploadResponse) r14     // Catch:{ Exception -> 0x00f2 }
                            com.baidu.wallet.utils.RpaProcessor$IUploadFileCallback r1 = r3     // Catch:{ Exception -> 0x00f2 }
                            if (r1 == 0) goto L_0x00c0
                            int r0 = r14.ret     // Catch:{ Exception -> 0x00f2 }
                            if (r0 != 0) goto L_0x00a3
                            com.baidu.wallet.utils.RpaProcessor$UploadBosKey r0 = r14.content     // Catch:{ Exception -> 0x00f2 }
                            if (r0 == 0) goto L_0x008a
                            com.baidu.wallet.utils.RpaProcessor$UploadBosKey r0 = r14.content     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r0 = r0.data     // Catch:{ Exception -> 0x00f2 }
                            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00f2 }
                            if (r0 != 0) goto L_0x008a
                            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f2 }
                            r13.<init>()     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r0 = "boskey"
                            com.baidu.wallet.utils.RpaProcessor$UploadBosKey r1 = r14.content     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r1 = r1.data     // Catch:{ Exception -> 0x00f2 }
                            r13.put(r0, r1)     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r0 = "file_size"
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f2 }
                            r1.<init>()     // Catch:{ Exception -> 0x00f2 }
                            long r10 = r5     // Catch:{ Exception -> 0x00f2 }
                            r1.append(r10)     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r10 = ""
                            r1.append(r10)     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00f2 }
                            r13.put(r0, r1)     // Catch:{ Exception -> 0x00f2 }
                            com.baidu.wallet.utils.RpaProcessor$IUploadFileCallback r0 = r3     // Catch:{ Exception -> 0x00f2 }
                            int r1 = r14.ret     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r14 = r14.msg     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x00f2 }
                            r0.onUploadSuccess(r1, r14, r13)     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String[] r13 = new java.lang.String[r6]     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r14 = r4     // Catch:{ Exception -> 0x00f2 }
                            r13[r8] = r14     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r14 = "1"
                            r13[r7] = r14     // Catch:{ Exception -> 0x00f2 }
                            java.util.List r13 = java.util.Arrays.asList(r13)     // Catch:{ Exception -> 0x00f2 }
                            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r13)     // Catch:{ Exception -> 0x00f2 }
                            goto L_0x0113
                        L_0x008a:
                            com.baidu.wallet.utils.RpaProcessor$IUploadFileCallback r0 = r3     // Catch:{ Exception -> 0x00f2 }
                            int r14 = r14.ret     // Catch:{ Exception -> 0x00f2 }
                            r0.onUploadFail(r14, r13)     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String[] r14 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r0 = r4     // Catch:{ Exception -> 0x00f2 }
                            r14[r8] = r0     // Catch:{ Exception -> 0x00f2 }
                            r14[r7] = r5     // Catch:{ Exception -> 0x00f2 }
                            r14[r6] = r13     // Catch:{ Exception -> 0x00f2 }
                            java.util.List r13 = java.util.Arrays.asList(r14)     // Catch:{ Exception -> 0x00f2 }
                            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r13)     // Catch:{ Exception -> 0x00f2 }
                            goto L_0x0113
                        L_0x00a3:
                            com.baidu.wallet.utils.RpaProcessor$IUploadFileCallback r13 = r3     // Catch:{ Exception -> 0x00f2 }
                            int r0 = r14.ret     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r1 = r14.msg     // Catch:{ Exception -> 0x00f2 }
                            r13.onUploadFail(r0, r1)     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String[] r13 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r0 = r4     // Catch:{ Exception -> 0x00f2 }
                            r13[r8] = r0     // Catch:{ Exception -> 0x00f2 }
                            r13[r7] = r5     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r14 = r14.msg     // Catch:{ Exception -> 0x00f2 }
                            r13[r6] = r14     // Catch:{ Exception -> 0x00f2 }
                            java.util.List r13 = java.util.Arrays.asList(r13)     // Catch:{ Exception -> 0x00f2 }
                            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r13)     // Catch:{ Exception -> 0x00f2 }
                            goto L_0x0113
                        L_0x00c0:
                            com.baidu.wallet.utils.RpaProcessor$IUploadFileCallback r13 = r3     // Catch:{ Exception -> 0x00f2 }
                            r13.onUploadFail(r2, r0)     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String[] r13 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r14 = r4     // Catch:{ Exception -> 0x00f2 }
                            r13[r8] = r14     // Catch:{ Exception -> 0x00f2 }
                            r13[r7] = r5     // Catch:{ Exception -> 0x00f2 }
                            r13[r6] = r0     // Catch:{ Exception -> 0x00f2 }
                            java.util.List r13 = java.util.Arrays.asList(r13)     // Catch:{ Exception -> 0x00f2 }
                            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r13)     // Catch:{ Exception -> 0x00f2 }
                            goto L_0x0113
                        L_0x00d7:
                            com.baidu.wallet.utils.RpaProcessor$IUploadFileCallback r13 = r3     // Catch:{ Exception -> 0x00f2 }
                            if (r13 == 0) goto L_0x0113
                            com.baidu.wallet.utils.RpaProcessor$IUploadFileCallback r13 = r3     // Catch:{ Exception -> 0x00f2 }
                            r13.onUploadFail(r2, r1)     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String[] r13 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00f2 }
                            java.lang.String r14 = r4     // Catch:{ Exception -> 0x00f2 }
                            r13[r8] = r14     // Catch:{ Exception -> 0x00f2 }
                            r13[r7] = r5     // Catch:{ Exception -> 0x00f2 }
                            r13[r6] = r1     // Catch:{ Exception -> 0x00f2 }
                            java.util.List r13 = java.util.Arrays.asList(r13)     // Catch:{ Exception -> 0x00f2 }
                            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r13)     // Catch:{ Exception -> 0x00f2 }
                            goto L_0x0113
                        L_0x00f2:
                            r13 = move-exception
                            com.baidu.wallet.utils.RpaProcessor$IUploadFileCallback r14 = r3
                            if (r14 == 0) goto L_0x0113
                            java.lang.String r0 = "接口上传成功，response解析失败"
                            r14.onUploadFail(r2, r0)
                            java.lang.String[] r14 = new java.lang.String[r3]
                            java.lang.String r1 = r4
                            r14[r8] = r1
                            r14[r7] = r5
                            r14[r6] = r0
                            java.lang.String r13 = r13.toString()
                            r14[r4] = r13
                            java.util.List r13 = java.util.Arrays.asList(r14)
                            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r13)
                        L_0x0113:
                            java.io.File r13 = new java.io.File     // Catch:{ Exception -> 0x014e }
                            java.lang.String r14 = r7     // Catch:{ Exception -> 0x014e }
                            r13.<init>(r14)     // Catch:{ Exception -> 0x014e }
                            boolean r14 = r13.exists()     // Catch:{ Exception -> 0x014e }
                            if (r14 == 0) goto L_0x014e
                            r13.delete()     // Catch:{ Exception -> 0x014e }
                            goto L_0x014e
                        L_0x0124:
                            java.lang.String[] r13 = new java.lang.String[r3]
                            java.lang.String r0 = r4
                            r13[r8] = r0
                            r13[r7] = r5
                            java.lang.String r0 = "接口上传失败"
                            r13[r6] = r0
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            r0.<init>()
                            java.lang.String r1 = "错误码: "
                            r0.append(r1)
                            int r14 = r14.rg()
                            r0.append(r14)
                            java.lang.String r14 = r0.toString()
                            r13[r4] = r14
                            java.util.List r13 = java.util.Arrays.asList(r13)
                            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r9, r13)
                        L_0x014e:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.utils.RpaProcessor.AnonymousClass6.onResponse(com.duxiaoman.okhttp3.Call, fe.th.de.mmm):void");
                    }
                });
            } else if (iUploadFileCallback2 != null) {
                iUploadFileCallback2.onUploadFail(-1, "上传文件不存在");
            }
        } catch (Exception unused) {
            if (iUploadFileCallback2 != null) {
                iUploadFileCallback2.onUploadFail(-1, "上传文件创建失败");
            }
        }
    }

    public void uploadRpaFile(Context context, final String str, final String str2, long j2) throws Exception {
        String str3 = DomainConfig.getInstance().getAppHost(new Boolean[]{Boolean.FALSE}) + "/odp/wireless/misc/app/saveFile";
        final ArrayList<RestNameValuePair> arrayList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(BeanConstants.COOKIE_OPENBDUSS);
        stringBuffer.append("=");
        stringBuffer.append(WalletLoginHelper.getInstance().getOpenLoginToken());
        if (!TextUtils.isEmpty(AccountManager.getInstance(context).getBfbToken())) {
            stringBuffer.append(i.b);
            stringBuffer.append("token=");
            stringBuffer.append(AccountManager.getInstance(context).getBfbToken());
        }
        arrayList.add(new RestNameValuePair("Cookie", stringBuffer.toString()));
        arrayList.add(new RestNameValuePair("Accept-Encoding", "gzip"));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EbpayHttpRequestInterceptor.PARAM_MOBILE_IP, PayUtils.encrypt("phone_number", PhoneUtils.getIpInfo()));
            jSONObject.put(EbpayHttpRequestInterceptor.PARAM_SIM_SERIAL_NUM, "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes()))));
        a(context, arrayList, str3);
        ggg.ad nn = new ggg().nn();
        nn.qw(new Interceptor() {
            public mmm intercept(Interceptor.Chain chain) throws IOException {
                ddd.qw yj2 = chain.request().yj();
                for (RestNameValuePair restNameValuePair : arrayList) {
                    yj2.qw(restNameValuePair.getName(), restNameValuePair.getValue());
                }
                return chain.qw(yj2.ad());
            }
        });
        ggg ad2 = nn.ad();
        String str4 = b(str2) + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j2)) + "dom.txt";
        ppp.qw qwVar = new ppp.qw();
        qwVar.rg(ppp.f5222th);
        qwVar.qw("fileKey", PayUtils.encrypt("phone_number", c(str)));
        qwVar.qw("fileName", str4);
        qwVar.ad("file", str4, nn.de(when.fe(Mimetypes.MIMETYPE_OCTET_STREAM), new File(str)));
        for (RestNameValuePair restNameValuePair : arrayList) {
            qwVar.qw(restNameValuePair.getName(), restNameValuePair.getValue());
        }
        ppp fe2 = qwVar.fe();
        ddd.qw qwVar2 = new ddd.qw();
        qwVar2.uk(str3);
        qwVar2.rg("POST", fe2);
        ad2.mmm(qwVar2.ad()).qw(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_UPLOAD_DOM, Arrays.asList(new String[]{str2, "0"}));
            }

            public void onResponse(Call call, mmm mmm) throws IOException {
                if (mmm.isSuccessful()) {
                    DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_UPLOAD_DOM, Arrays.asList(new String[]{str2, "1"}));
                    try {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_UPLOAD_DOM, Arrays.asList(new String[]{str2, "0", "错误码: " + mmm.rg()}));
                }
            }
        });
    }

    public void uploadRpaHtml(Context context, String str, String str2, final String str3) {
        a.C0152a aVar = new a.C0152a();
        aVar.b = ShareTarget.ENCODING_TYPE_MULTIPART;
        aVar.a = str;
        aVar.c = str2;
        aVar.d = "file";
        c cVar = new c(context);
        cVar.a(aVar);
        cVar.setResponseCallback(new IBeanResponseCallback() {
            public void onBeanExecFailure(int i2, int i3, String str) {
                DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_UPLOAD_DOM, Arrays.asList(new String[]{str3, "0"}));
            }

            public void onBeanExecSuccess(int i2, Object obj, String str) {
                DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_UPLOAD_DOM, Arrays.asList(new String[]{str3, "1"}));
            }
        });
        cVar.execBean();
    }

    public void uploadRpaPageLoadMills(String str, long j2) {
        long a2 = a(str);
        if (a2 != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add("时间间隔");
            arrayList.add(String.valueOf(j2 - a2));
            DXMSdkSAUtils.onEventWithValues(RPA_LOAD_TIME, arrayList);
        }
    }

    public void writeHtmlToFile(Context context, String str, long j2, String str2) {
        Executor executor;
        if (WalletLoginHelper.getInstance().isLogin() && context != null && !TextUtils.isEmpty(str)) {
            String str3 = null;
            try {
                str3 = Base64.encodeBytes(str.getBytes(StandardCharsets.UTF_8));
                DXMSdkSAUtils.onEventWithValues(RPA_DOM_DATA_LEGAL, Arrays.asList(new String[]{str2, "1"}));
            } catch (Exception unused) {
                DXMSdkSAUtils.onEventWithValues(RPA_DOM_DATA_LEGAL, Arrays.asList(new String[]{str2, "0"}));
            }
            final String str4 = str3;
            if (!TextUtils.isEmpty(str4) && (executor = this.e) != null) {
                final Context context2 = context;
                final long j3 = j2;
                final String str5 = str2;
                executor.execute(new Runnable() {
                    public void run() {
                        String str = context2.getCacheDir() + File.separator + "dxm_rpa";
                        try {
                            File file = new File(str);
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            FileWriter fileWriter = new FileWriter(new File(str, j3 + ".txt"));
                            fileWriter.write(str4);
                            fileWriter.close();
                            DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_SAVE_DOM, Arrays.asList(new String[]{str5, "1"}));
                            RpaProcessor.this.uploadRpaFile(context2, str + File.separator + j3 + ".txt", str5, j3);
                        } catch (Exception e2) {
                            DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_SAVE_DOM, Arrays.asList(new String[]{str5, "0"}));
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public RpaProcessor() {
        this.e = null;
        this.p = new HashMap<>();
        DXMSdkSAUtils.onEvent(RPA_INITIALIZATION);
        this.e = new ThreadPoolExecutor(0, 2, 30, TimeUnit.SECONDS, new SynchronousQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
    }

    private void a(Context context, List<RestNameValuePair> list) {
        list.add(new RestNameValuePair("from", "JT"));
        list.add(new RestNameValuePair("_ie", com.baidu.apollon.heartbeat.a.h));
        list.add(new RestNameValuePair("ie", com.baidu.apollon.heartbeat.a.h));
        list.add(new RestNameValuePair("ua", BussinessUtils.getUA(context)));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wime", "");
            jSONObject.put("cuid_1", PayUtils.encrypt("phone_number", PhoneUtils.getCUID(context)));
            jSONObject.put("cuid_2", PayUtils.encrypt("phone_number", PhoneUtils.getCUID2(context)));
            jSONObject.put("fk_wcp", PayUtils.encrypt("phone_number", (((("fp=" + BdWalletUtils.getDeviceFP(context)) + "&lastModify=" + BdWalletUtils.getFPFileLastModified(context)) + "&cpuInfo=" + PhoneUtils.getSystemCPUInfo().getCpuPath() + "_" + PhoneUtils.getNumCores()) + "&diskCapacity=" + PhoneUtils.getTotalInternalMemorySize()) + "&upTime=" + (SystemClock.elapsedRealtime() / 1000)));
            jSONObject.put("nettype", NetworkUtils.getNetworkType(context));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        list.add(new RestNameValuePair("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes()))));
        String str = SafePay.getInstance().getpwProxy();
        boolean z = false;
        Iterator<RestNameValuePair> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if ("key".equals(it.next().getName())) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            list.add(new RestNameValuePair("key", str));
        }
        String newCookie = PayUtils.getNewCookie(context);
        if (!TextUtils.isEmpty(newCookie)) {
            list.add(new RestNameValuePair("natbc", SafePay.getInstance().encryptProxy(newCookie)));
        } else {
            list.add(new RestNameValuePair("natbc", ""));
        }
    }

    private List<RestNameValuePair> a(Context context, List<RestNameValuePair> list, String str) {
        if (list == null) {
            list = new ArrayList<>();
        }
        a(context, list);
        if (!a(list, "session_id") && NetworkBean.SessionCache.getInstance().matchSessionUri(str) && !TextUtils.isEmpty(NetworkBean.SessionCache.getInstance().getSessionId((NetworkBean.BizType) null))) {
            list.add(new RestNameValuePair("session_id", NetworkBean.SessionCache.getInstance().getSessionId((NetworkBean.BizType) null)));
        }
        list.add(new RestNameValuePair("nonce", PayUtils.getNonce(list)));
        return list;
    }

    private boolean a(List<RestNameValuePair> list, String str) {
        if (list == null) {
            return false;
        }
        for (RestNameValuePair name : list) {
            if (str.equals(name.getName())) {
                return true;
            }
        }
        return false;
    }
}
