package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.apollon.utils.ResUtils;
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

    public class a extends HttpHandlerWrap {
        public final /* synthetic */ SetPortraitCallback a;
        public final /* synthetic */ SetPortraitResult b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Looper looper, SetPortraitCallback setPortraitCallback, SetPortraitResult setPortraitResult) {
            super(looper);
            this.a = setPortraitCallback;
            this.b = setPortraitResult;
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
            this.b.setResultCode(PortraitService.this.getErrorCode(str));
            this.b.setResultMsg(PortraitService.this.getErrorMsg(str));
            int resultCode = this.b.getResultCode();
            if (resultCode == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.b.portraitSign = jSONObject.optString("portrait_tag");
                    String optString = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PORTRAIT);
                    if (!TextUtils.isEmpty(optString)) {
                        SetPortraitResult setPortraitResult = this.b;
                        setPortraitResult.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", new Object[]{optString, this.b.portraitSign});
                    }
                } catch (JSONException unused) {
                }
                this.a.onSuccess(this.b);
            } else if (resultCode == 160103) {
                this.a.onBdussExpired(this.b);
            } else if (resultCode == 991613) {
                this.a.onFailure(this.b);
            } else if (resultCode != 991616) {
                this.a.onFailure(this.b);
            } else {
                this.a.onSuccess(this.b);
            }
        }
    }

    public class b extends HttpHandlerWrap {
        public final /* synthetic */ SetPopularPortraitResult a;
        public final /* synthetic */ SetPopularPortraitCallback b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Looper looper, SetPopularPortraitResult setPopularPortraitResult, SetPopularPortraitCallback setPopularPortraitCallback) {
            super(looper);
            this.a = setPopularPortraitResult;
            this.b = setPopularPortraitCallback;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.a.setResultCode(i2);
            this.b.onFailure(this.a);
        }

        public void onFinish() {
            this.b.onFinish();
        }

        public void onStart() {
            this.b.onStart();
        }

        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i3 = jSONObject.getInt("errno");
                this.a.setResultCode(i3);
                this.a.setResultMsg(jSONObject.optString("errmsg"));
                if (i3 == 0) {
                    this.b.onSuccess(this.a);
                } else {
                    this.b.onFailure(this.a);
                }
            } catch (JSONException e) {
                this.a.setResultCode(-202);
                this.b.onFailure(this.a);
                Log.e(e);
            }
        }
    }

    public class c extends HttpHandlerWrap {
        public final /* synthetic */ GetHistoryPortraitsResult a;
        public final /* synthetic */ GetHistoryPortraitsCallback b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Looper looper, GetHistoryPortraitsResult getHistoryPortraitsResult, GetHistoryPortraitsCallback getHistoryPortraitsCallback) {
            super(looper);
            this.a = getHistoryPortraitsResult;
            this.b = getHistoryPortraitsCallback;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            this.a.setResultCode(i2);
            this.b.onFailure(this.a);
        }

        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i3 = jSONObject.getInt("errno");
                this.a.setResultCode(i3);
                this.a.setResultMsg(jSONObject.optString("errmsg"));
                if (i3 == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("history");
                    int length = optJSONArray.length();
                    this.a.historyPortraits = new ArrayList(length);
                    for (int i4 = 0; i4 < length; i4++) {
                        this.a.historyPortraits.add(optJSONArray.optString(i4));
                    }
                    this.b.onSuccess(this.a);
                    return;
                }
                this.b.onFailure(this.a);
            } catch (JSONException e) {
                this.a.setResultCode(-202);
                this.b.onFailure(this.a);
                Log.e(e);
            }
        }
    }

    public class d extends HttpHandlerWrap {
        public final /* synthetic */ GetPopularPortraitsCallback a;
        public final /* synthetic */ GetPopularPortraitsInfoResult b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Looper looper, GetPopularPortraitsCallback getPopularPortraitsCallback, GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            super(looper);
            this.a = getPopularPortraitsCallback;
            this.b = getPopularPortraitsInfoResult;
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
                int optInt = jSONObject.optInt("errno");
                this.b.setResultCode(optInt);
                this.b.setResultMsg(jSONObject.optString("errmsg"));
                if (optInt == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    int length = optJSONArray.length();
                    this.b.popularPortraitsInfoList = new ArrayList(length);
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                            popularPortraitsInfo.num = optJSONObject.optInt("num");
                            popularPortraitsInfo.serie = optJSONObject.optString("serie");
                            popularPortraitsInfo.url = optJSONObject.optString("url");
                            popularPortraitsInfo.myItem = optJSONObject.optInt("myitem");
                            popularPortraitsInfo.color = optJSONObject.optString(ResUtils.f);
                            popularPortraitsInfo.category = optJSONObject.optString("category");
                            popularPortraitsInfo.gifUrl = optJSONObject.optString("gifUrl");
                            this.b.popularPortraitsInfoList.add(popularPortraitsInfo);
                        }
                    }
                    this.a.onSuccess(this.b);
                    return;
                }
                this.a.onFailure(this.b);
            } catch (JSONException e) {
                this.b.setResultCode(-202);
                this.a.onFailure(this.b);
                Log.e(e);
            }
        }
    }

    public PortraitService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    public String a() {
        return this.configuration.environment.getPortraitUrl() + "/sys/history";
    }

    public String b() {
        return this.configuration.environment.getPortraitUrl() + "/sys/portrait/hotitemlist";
    }

    public String c() {
        return this.configuration.environment.getPortraitUrl() + "/sys/sethotitem";
    }

    public String d() {
        return "/v2/sapi/center/setportrait";
    }

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
