package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SetPortraitDTO;
import com.baidu.sapi2.enums.PortraitCategory;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.httpwrap.MultipartHashMapWrap;
import com.baidu.sapi2.result.GetHistoryPortraitsResult;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.sapi2.result.SetPopularPortraitResult;
import com.baidu.sapi2.result.SetPortraitResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.ByteArrayInputStream;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PortraitService extends AbstractService implements NoProguard {

    class a extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SetPortraitCallback f17753a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SetPortraitResult f17754b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Looper looper, SetPortraitCallback setPortraitCallback, SetPortraitResult setPortraitResult) {
            super(looper);
            this.f17753a = setPortraitCallback;
            this.f17754b = setPortraitResult;
        }

        /* access modifiers changed from: protected */
        public void onFailure(Throwable th2, int i2, String str) {
            this.f17754b.setResultCode(i2);
            this.f17753a.onFailure(this.f17754b);
        }

        /* access modifiers changed from: protected */
        public void onFinish() {
            this.f17753a.onFinish();
        }

        /* access modifiers changed from: protected */
        public void onStart() {
            this.f17753a.onStart();
        }

        /* access modifiers changed from: protected */
        public void onSuccess(int i2, String str) {
            this.f17754b.setResultCode(PortraitService.this.getErrorCode(str));
            this.f17754b.setResultMsg(PortraitService.this.getErrorMsg(str));
            int resultCode = this.f17754b.getResultCode();
            if (resultCode == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f17754b.portraitSign = jSONObject.optString("portrait_tag");
                    String optString = jSONObject.optString("portrait");
                    if (!TextUtils.isEmpty(optString)) {
                        SetPortraitResult setPortraitResult = this.f17754b;
                        setPortraitResult.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", new Object[]{optString, setPortraitResult.portraitSign});
                    }
                } catch (JSONException e2) {
                }
                this.f17753a.onSuccess(this.f17754b);
            } else if (resultCode == 160103) {
                this.f17753a.onBdussExpired(this.f17754b);
            } else if (resultCode == 991613) {
                this.f17753a.onFailure(this.f17754b);
            } else if (resultCode != 991616) {
                this.f17753a.onFailure(this.f17754b);
            } else {
                this.f17753a.onSuccess(this.f17754b);
            }
        }
    }

    class b extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SetPopularPortraitResult f17756a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SetPopularPortraitCallback f17757b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Looper looper, SetPopularPortraitResult setPopularPortraitResult, SetPopularPortraitCallback setPopularPortraitCallback) {
            super(looper);
            this.f17756a = setPopularPortraitResult;
            this.f17757b = setPopularPortraitCallback;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.f17756a.setResultCode(i2);
            this.f17757b.onFailure(this.f17756a);
        }

        public void onFinish() {
            this.f17757b.onFinish();
        }

        public void onStart() {
            this.f17757b.onStart();
        }

        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i3 = jSONObject.getInt("errno");
                this.f17756a.setResultCode(i3);
                this.f17756a.setResultMsg(jSONObject.optString("errmsg"));
                if (i3 == 0) {
                    this.f17757b.onSuccess(this.f17756a);
                } else {
                    this.f17757b.onFailure(this.f17756a);
                }
            } catch (JSONException e2) {
                this.f17756a.setResultCode(-202);
                this.f17757b.onFailure(this.f17756a);
                Log.e(e2);
            }
        }
    }

    class c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GetHistoryPortraitsResult f17759a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GetHistoryPortraitsCallback f17760b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Looper looper, GetHistoryPortraitsResult getHistoryPortraitsResult, GetHistoryPortraitsCallback getHistoryPortraitsCallback) {
            super(looper);
            this.f17759a = getHistoryPortraitsResult;
            this.f17760b = getHistoryPortraitsCallback;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.f17759a.setResultCode(i2);
            this.f17760b.onFailure(this.f17759a);
        }

        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i3 = jSONObject.getInt("errno");
                this.f17759a.setResultCode(i3);
                this.f17759a.setResultMsg(jSONObject.optString("errmsg"));
                if (i3 == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("history");
                    int length = optJSONArray.length();
                    this.f17759a.historyPortraits = new ArrayList(length);
                    for (int i4 = 0; i4 < length; i4++) {
                        this.f17759a.historyPortraits.add(optJSONArray.optString(i4));
                    }
                    this.f17760b.onSuccess(this.f17759a);
                    return;
                }
                this.f17760b.onFailure(this.f17759a);
            } catch (JSONException e2) {
                this.f17759a.setResultCode(-202);
                this.f17760b.onFailure(this.f17759a);
                Log.e(e2);
            }
        }
    }

    class d extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GetPopularPortraitsCallback f17762a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GetPopularPortraitsInfoResult f17763b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Looper looper, GetPopularPortraitsCallback getPopularPortraitsCallback, GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            super(looper);
            this.f17762a = getPopularPortraitsCallback;
            this.f17763b = getPopularPortraitsInfoResult;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.f17763b.setResultCode(i2);
            this.f17762a.onFailure(this.f17763b);
        }

        public void onFinish() {
            this.f17762a.onFinish();
        }

        public void onStart() {
            this.f17762a.onStart();
        }

        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                this.f17763b.setResultCode(optInt);
                this.f17763b.setResultMsg(jSONObject.optString("errmsg"));
                if (optInt == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    int length = optJSONArray.length();
                    this.f17763b.popularPortraitsInfoList = new ArrayList(length);
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                            popularPortraitsInfo.num = optJSONObject.optInt("num");
                            popularPortraitsInfo.serie = optJSONObject.optString("serie");
                            popularPortraitsInfo.url = optJSONObject.optString("url");
                            popularPortraitsInfo.myItem = optJSONObject.optInt("myitem");
                            popularPortraitsInfo.color = optJSONObject.optString("color");
                            popularPortraitsInfo.category = optJSONObject.optString("category");
                            popularPortraitsInfo.gifUrl = optJSONObject.optString("gifUrl");
                            this.f17763b.popularPortraitsInfoList.add(popularPortraitsInfo);
                        }
                    }
                    this.f17762a.onSuccess(this.f17763b);
                    return;
                }
                this.f17762a.onFailure(this.f17763b);
            } catch (JSONException e2) {
                this.f17763b.setResultCode(-202);
                this.f17762a.onFailure(this.f17763b);
                Log.e(e2);
            }
        }
    }

    public PortraitService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.configuration.environment.getPortraitUrl() + "/sys/history";
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.configuration.environment.getPortraitUrl() + "/sys/portrait/hotitemlist";
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.configuration.environment.getPortraitUrl() + "/sys/sethotitem";
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return "/v2/sapi/center/setportrait";
    }

    /* access modifiers changed from: protected */
    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        SapiUtils.notNull(getHistoryPortraitsCallback, GetHistoryPortraitsCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notNull(getHistoryPortraitsDTO, "getHistoryPortrats dto can't be null");
        SapiUtils.notEmpty(getHistoryPortraitsDTO.bduss, "bduss can't be empty");
        int i2 = getHistoryPortraitsDTO.maxNum;
        if (i2 < 0 || i2 > 10) {
            throw new IllegalArgumentException("abnormal request history number");
        }
        GetHistoryPortraitsResult getHistoryPortraitsResult = new GetHistoryPortraitsResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("length", String.valueOf(getHistoryPortraitsDTO.maxNum));
        httpHashMapWrap.put("bduss", getHistoryPortraitsDTO.bduss);
        new HttpClientWrap().post(a(), ReqPriority.HIGH, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new c(Looper.getMainLooper(), getHistoryPortraitsResult, getHistoryPortraitsCallback));
    }

    /* access modifiers changed from: protected */
    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str, PortraitCategory portraitCategory) {
        SapiUtils.notNull(getPopularPortraitsCallback, GetPopularPortraitsCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        GetPopularPortraitsInfoResult getPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        if (portraitCategory != null) {
            httpHashMapWrap.put("category", portraitCategory.getValue());
        }
        new HttpClientWrap().post(b(), ReqPriority.HIGH, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new d(Looper.getMainLooper(), getPopularPortraitsCallback, getPopularPortraitsInfoResult));
    }

    /* access modifiers changed from: protected */
    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        SapiUtils.notNull(setPopularPortraitCallback, SetPopularPortraitCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notNull(setPopularPortraitDTO, "SetPopularPortraitDto can't be null");
        SapiUtils.notEmpty(setPopularPortraitDTO.bduss, "bduss can't be empty");
        SetPopularPortraitResult setPopularPortraitResult = new SetPopularPortraitResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", setPopularPortraitDTO.bduss);
        if (TextUtils.isEmpty(setPopularPortraitDTO.series)) {
            setPopularPortraitDTO.series = "wildkid";
        }
        httpHashMapWrap.put("serie", setPopularPortraitDTO.series);
        httpHashMapWrap.put("num", String.valueOf(setPopularPortraitDTO.num));
        new HttpClientWrap().post(c(), ReqPriority.HIGH, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new b(Looper.getMainLooper(), setPopularPortraitResult, setPopularPortraitCallback));
    }

    /* access modifiers changed from: protected */
    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback setPortraitCallback) {
        SapiUtils.notNull(setPortraitDTO, "SetPortraitDTO can't be null");
        SapiUtils.notNull(setPortraitCallback, "SetPortraitCallback can't be null");
        SapiUtils.notEmpty(setPortraitDTO.bduss, "bduss can't be empty");
        byte[] bArr = setPortraitDTO.file;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("file can't be empty");
        }
        SetPortraitResult setPortraitResult = new SetPortraitResult();
        MultipartHashMapWrap multipartHashMapWrap = new MultipartHashMapWrap();
        multipartHashMapWrap.put("bduss", setPortraitDTO.bduss);
        multipartHashMapWrap.put("portrait_type", setPortraitDTO.portraitType + "");
        multipartHashMapWrap.put("portrait_attribute", setPortraitDTO.portraitAttribute + "");
        multipartHashMapWrap.put("file", new ByteArrayInputStream(setPortraitDTO.file), "portrait.jpg", TextUtils.isEmpty(setPortraitDTO.contentType) ? "image/jpeg" : setPortraitDTO.contentType);
        new HttpClientWrap().post(d(), ReqPriority.HIGH, multipartHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new a(Looper.getMainLooper(), setPortraitCallback, setPortraitResult));
    }
}
