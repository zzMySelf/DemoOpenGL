package com.baidu.sapi2;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.LoginWithUCAuthResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.searchbox.aps.invoker.helper.PluginInvokeActivityHelper;
import com.baidu.swan.apps.alliance.login.DefaultCookieUtils;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class OpenBdussService extends AbstractService implements NoProguard {
    /* access modifiers changed from: private */
    public Context context;

    public OpenBdussService(SapiConfiguration configuration, String versionName) {
        super(configuration, versionName);
        this.context = configuration.context;
    }

    public void getOpenBduss(GetOpenBdussDTO dto, GetOpenBdussCallback callback) {
        GetOpenBdussDTO getOpenBdussDTO = dto;
        GetOpenBdussCallback getOpenBdussCallback = callback;
        SapiUtils.notNull(getOpenBdussCallback, "GetOpenBdussCallback can't be null");
        SapiUtils.notNull(getOpenBdussDTO, "GetOpenBdussDTO can't be null");
        SapiUtils.notEmpty(getOpenBdussDTO.clientId, "GetOpenBdussDTO.clientId can't empty");
        SapiAccount sapiAccount = SapiContext.getInstance().getCurrentAccount();
        if (sapiAccount == null) {
            OpenBdussResult openBdussResult = new OpenBdussResult();
            openBdussResult.setResultCode(-901);
            getOpenBdussCallback.onFailure(openBdussResult);
            return;
        }
        OpenBdussResult historyOpenBdussResult = OpenBdussResult.fromJson(SapiContext.getInstance().getDecryptStr(SapiContext.KEY_OPEN_BDUSS_INFO));
        if (historyOpenBdussResult == null || historyOpenBdussResult.getResultCode() != 0 || !SecurityUtil.md5((sapiAccount.bduss + getOpenBdussDTO.clientId).getBytes(), false).equals(historyOpenBdussResult.flag)) {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
            if (!(historyOpenBdussResult == null || historyOpenBdussResult.tplStokenMap == null)) {
                historyOpenBdussResult.tplStokenMap.clear();
            }
        } else {
            boolean tplStokenAllInCache = true;
            Iterator<String> it = getOpenBdussDTO.targetTplList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!historyOpenBdussResult.tplStokenMap.containsKey(it.next())) {
                    tplStokenAllInCache = false;
                    break;
                }
            }
            if (tplStokenAllInCache) {
                historyOpenBdussResult.flag = "";
                getOpenBdussCallback.onSuccess(historyOpenBdussResult);
                return;
            }
        }
        HttpHashMapWrap params = new HttpHashMapWrap();
        params.put("client_id", getOpenBdussDTO.clientId);
        params.put("bduss", sapiAccount.bduss);
        params.put(LoginWithUCAuthResult.KEY_DATA_PTOKEN, sapiAccount.ptoken);
        params.put(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo(SapiEnv.GET_OPEN_BDUSS));
        if (getOpenBdussDTO.targetTplList != null && getOpenBdussDTO.targetTplList.size() > 0) {
            String targetTpls = getOpenBdussDTO.targetTplList.get(0);
            for (int i2 = 1; i2 < getOpenBdussDTO.targetTplList.size(); i2++) {
                targetTpls = targetTpls + "|" + getOpenBdussDTO.targetTplList.get(i2);
            }
            params.put("tpl_list", targetTpls);
        }
        final GetOpenBdussCallback getOpenBdussCallback2 = callback;
        final SapiAccount sapiAccount2 = sapiAccount;
        final GetOpenBdussDTO getOpenBdussDTO2 = dto;
        final OpenBdussResult openBdussResult2 = historyOpenBdussResult;
        HttpHashMapWrap httpHashMapWrap = params;
        new HttpClientWrap().post(SapiEnv.GET_OPEN_BDUSS, params, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            /* access modifiers changed from: protected */
            public void onStart() {
                getOpenBdussCallback2.onStart();
            }

            /* access modifiers changed from: protected */
            public void onSuccess(int statusCode, String responseBody) {
                try {
                    JSONObject json = new JSONObject(responseBody);
                    if (!TextUtils.isEmpty(json.optString("uid"))) {
                        json.put("bduss", sapiAccount2.bduss);
                    }
                    json.put(PluginInvokeActivityHelper.EXTRA_FLAG, SecurityUtil.md5((sapiAccount2.bduss + getOpenBdussDTO2.clientId).getBytes(), false));
                    json.put("displayname", sapiAccount2.displayname);
                    OpenBdussResult openBdussResult = OpenBdussResult.fromJson(json.toString());
                    if (openBdussResult == null || openBdussResult.getResultCode() != 0) {
                        getOpenBdussCallback2.onFailure(openBdussResult);
                        return;
                    }
                    OpenBdussResult openBdussResult2 = openBdussResult2;
                    if (openBdussResult2 != null && openBdussResult2.tplStokenMap.size() > 0) {
                        openBdussResult.tplStokenMap.putAll(openBdussResult2.tplStokenMap);
                    }
                    SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, openBdussResult.toJson().toString());
                    openBdussResult.flag = "";
                    getOpenBdussCallback2.onSuccess(openBdussResult);
                } catch (Exception e2) {
                    Log.e(e2);
                    OpenBdussResult openBdussResult3 = new OpenBdussResult();
                    openBdussResult3.setResultCode(-202);
                    getOpenBdussCallback2.onFailure(openBdussResult3);
                }
            }

            /* access modifiers changed from: protected */
            public void onFailure(Throwable error, int errorCode, String responseBody) {
                OpenBdussResult openBdussResult = new OpenBdussResult();
                openBdussResult.setResultCode(errorCode);
                getOpenBdussCallback2.onFailure(openBdussResult);
            }

            /* access modifiers changed from: protected */
            public void onFinish() {
                getOpenBdussCallback2.onFinish();
            }
        });
    }

    public void logout() {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() {
            public void run() {
                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
                try {
                    List<PassNameValuePair> cookies = new ArrayList<>();
                    for (String domain : SapiContext.getInstance().getOpenBdussDomains()) {
                        cookies.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + domain, SapiUtils.buildBDUSSCookie(domain, DefaultCookieUtils.BDUSS, "")));
                    }
                    SapiUtils.syncCookies(OpenBdussService.this.context, cookies);
                } catch (Throwable e2) {
                    Log.e(e2);
                }
            }
        }));
    }

    public int getBdussState() {
        SapiAccount sapiAccount = SapiContext.getInstance().getCurrentAccount();
        String cookieBduss = SapiUtils.getCookieBduss();
        if (sapiAccount == null && TextUtils.isEmpty(cookieBduss)) {
            return 1;
        }
        if (sapiAccount == null && !TextUtils.isEmpty(cookieBduss)) {
            return 2;
        }
        if (sapiAccount != null && TextUtils.isEmpty(cookieBduss)) {
            return 3;
        }
        if (sapiAccount == null || cookieBduss.equals(sapiAccount.bduss)) {
            return 0;
        }
        return 4;
    }
}
