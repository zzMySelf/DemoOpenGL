package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.ShareAccountAccessor;
import com.baidu.sapi2.callback.NetCallback;
import com.baidu.sapi2.callback.ShareModelWithCheckCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareLoginModel {
    public static String AUTH_APP_PKG_NAME = "auth_app_pkg_name";
    public static String AUTH_PASS_SDK_VERSION = "auth_pass_sdk_version";
    public static String FACE_LOGIN_UIDS = "face_login_uids";
    public static final String INVALIDATE_BDUSS = "invalidate_bduss";
    public static final String INVALID_BDUSS_LIST = "invalid_bduss_list";
    public static final int MAX_LENGTH_INVALID_BDUSS_SET = 16;
    public static final int REQUEST_CODE_SHARE_V4 = 100004;
    public static String SHARE_ACCOUNT_INFO = "share_account_info";
    public static final String SHARE_LOGIN_ACTIVITY = "com.baidu.sapi2.share.ShareActivity";
    public static final String SHARE_LOGIN_CALL_TYPE = "share_login_call_type";
    public static final String SHARE_LOGIN_FROM_TPL = "share_login_from_tpl";
    public static final String TAG = "sapi_ShareLoginModel";
    public static volatile ShareLoginModel instance;
    public LinkedList<String> invalidBdussList;

    public static ShareLoginModel getInstance() {
        if (instance == null) {
            synchronized (ShareLoginModel.class) {
                if (instance == null) {
                    instance = new ShareLoginModel();
                }
            }
        }
        return instance;
    }

    private LinkedList<String> initInvalidStringList() {
        LinkedList<String> linkedList = new LinkedList<>();
        String string = SapiContext.getInstance().getString(INVALID_BDUSS_LIST);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        linkedList.addLast(jSONArray.optString(i2));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return linkedList;
    }

    public void checkAuthAccountValid(final HashMap<String, String> hashMap, final BdussStatusCallback bdussStatusCallback) {
        final SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
        if (accountService == null || currentAccount == null || TextUtils.isEmpty(currentAccount.bduss)) {
            if (currentAccount == null || TextUtils.isEmpty(currentAccount.bduss)) {
                StatService.onEventAutoStat(ShareStatKey.AUTH_APP_READ_ACCOUNT_ERROR, hashMap);
            } else if (accountService == null) {
                StatService.onEventAutoStat(ShareStatKey.AUTH_APP_INIT_PASS_ERROR, hashMap);
            }
            bdussStatusCallback.onResultAccount((SapiAccount) null);
            return;
        }
        accountService.getUserInfo(currentAccount.bduss, currentAccount.getPtoken(), (NetCallback) new NetCallback() {
            public void onFailure(Throwable th2, int i2, String str) {
                Log.e(ShareLoginModel.TAG, "checkAuthAccountValid onFailure code=" + i2 + ", content=" + str);
                HashMap hashMap = hashMap;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i2);
                hashMap.put("code", sb.toString());
                StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_FAIL, hashMap);
                bdussStatusCallback.onResultAccount((SapiAccount) null);
            }

            public void onSuccess(int i2, String str) {
                JSONObject jSONObject;
                Log.d(ShareLoginModel.TAG, "checkAuthAccountValid onSuccess code=" + i2 + ", content=" + str);
                try {
                    jSONObject = new JSONObject(str);
                } catch (Exception e) {
                    Log.e(ShareLoginModel.TAG, (Throwable) e);
                    jSONObject = null;
                }
                int i3 = -100;
                if (jSONObject != null) {
                    i3 = jSONObject.optInt("errno", -100);
                }
                if (i3 == 0) {
                    StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_VALID, hashMap);
                    bdussStatusCallback.onResultAccount(currentAccount);
                } else if (400021 == i3) {
                    StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_INVALID, hashMap);
                    bdussStatusCallback.onBdussInvalidate(currentAccount.bduss);
                } else {
                    hashMap.put("code", "" + i2);
                    StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_INVALID, hashMap);
                    bdussStatusCallback.onResultAccount((SapiAccount) null);
                }
            }
        });
    }

    public LinkedList<String> getInvalidBdussList() {
        if (this.invalidBdussList == null) {
            this.invalidBdussList = initInvalidStringList();
        }
        return this.invalidBdussList;
    }

    public void getShareModels(long j, ShareModelWithCheckCallback shareModelWithCheckCallback) {
        if (j <= 0) {
            throw new IllegalArgumentException("must timeoutMills > 0");
        } else if (shareModelWithCheckCallback != null) {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration == null) {
                Log.d(ShareUtils.TAG, "getShareModels config is null");
                shareModelWithCheckCallback.onFailure(-101, "Pass SDK未初始化", ShareUtils.S_SHARE_MODEL_FROM_WITH_ERROR);
            } else if (!SapiUtils.isOnline(sapiConfiguration)) {
                Log.d(ShareUtils.TAG, "getShareModels environment is not online and is not config debugSupportShare");
                shareModelWithCheckCallback.onFailure(-102, ShareStorage.MSG_APP_IS_NOT_ONLINE, ShareUtils.S_SHARE_MODEL_FROM_WITH_ERROR);
            } else if (sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
                Log.d(ShareUtils.TAG, "getShareModels config loginShareStrategy is not DISABLED");
                shareModelWithCheckCallback.onFailure(-103, ShareStorage.MSG_APP_SHARE_IS_DISABLED, ShareUtils.S_SHARE_MODEL_FROM_WITH_ERROR);
            } else {
                ShareUtils.getShareModels(j, sapiConfiguration.context, sapiConfiguration.tpl, shareModelWithCheckCallback);
            }
        }
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        Log.d(ShareUtils.TAG, "build version is " + Build.VERSION.SDK_INT);
        SapiStatUtil.statLoadLogin("product_line_call");
        List<ShareStorage.StorageModel> shareStorageModel = ShareUtils.getShareStorageModel();
        if (shareStorageModel.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            SapiStatUtil.statShareV2Open(shareStorageModel, "product_line_call", arrayList);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("shareModels", "" + shareStorageModel.size());
        StatService.onEventAutoStat(ShareStatKey.CHECK_SHARE_V2_LOGIN_AVAILABLE, hashMap);
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (ShareStorage.StorageModel next : shareStorageModel) {
            if (next != null) {
                jSONArray.put(next.tpl);
                jSONArray2.put(next.app);
            }
        }
        return shareStorageModel;
    }

    public boolean isMeetShareV4(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(str, SHARE_LOGIN_ACTIVITY);
        if (context.getPackageManager().resolveActivity(intent, 131072) != null) {
            return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_SHARE_V4).isMeetGray();
        }
        return false;
    }

    public void openV4ShareLogin(Activity activity, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, str2);
            StatService.onEventAutoStat(ShareStatKey.SHARE_INVOKE_NEW_SHARE_AUTH, hashMap);
            ComponentName componentName = new ComponentName(str, SHARE_LOGIN_ACTIVITY);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            String tpl = SapiAccountManager.getInstance().getTpl();
            if (TextUtils.isEmpty(tpl)) {
                tpl = "unknown";
            }
            intent.putExtra(SHARE_LOGIN_FROM_TPL, tpl);
            intent.putExtra(SHARE_LOGIN_CALL_TYPE, str2);
            if (activity.getPackageManager().resolveActivity(intent, 65536) != null) {
                activity.startActivityForResult(intent, 100004);
            }
        } catch (Exception e) {
            Log.e("openV4ShareLogin", e.getMessage());
        }
    }

    public void processShareResult(Context context, Intent intent, ShareResultCallback shareResultCallback) {
        Bundle extras;
        if (shareResultCallback != null) {
            if (intent == null || (extras = intent.getExtras()) == null) {
                shareResultCallback.onResultAccount((SapiAccount) null);
                return;
            }
            updateInvalidBdussList(extras.getString(INVALIDATE_BDUSS));
            SapiAccount sapiAccount = (SapiAccount) extras.getParcelable(SHARE_ACCOUNT_INFO);
            if (sapiAccount == null) {
                StatService.onEventAutoStat(ShareStatKey.SHARE_NEW_AUTH_LOGIN_FAIL);
                shareResultCallback.onResultAccount((SapiAccount) null);
                return;
            }
            String stringExtra = intent.getStringExtra(AUTH_APP_PKG_NAME);
            String stringExtra2 = intent.getStringExtra(SHARE_LOGIN_FROM_TPL);
            ShareAccountAccessor.getAccessor().setAccountPkg(sapiAccount, stringExtra);
            intent.getStringExtra(AUTH_PASS_SDK_VERSION);
            SapiContext instance2 = SapiContext.getInstance();
            instance2.setCurrentAccount(sapiAccount);
            instance2.addLoginAccount(sapiAccount);
            new ShareCallPacking().asyncMarkLoginState(2);
            instance2.setAccountActionType(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
            JSONObject jSONObject = new JSONObject();
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            try {
                jSONObject.put("from_tpl", stringExtra2);
                jSONObject.put("from_pkg", stringExtra);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SapiAccountManager.getInstance().getUserInfoAndRefershAccount(sapiAccount, Enums.LastLoginType.CHOICE_SHARE_V2.getValue(), jSONObject.toString());
            if (instance2.shareLivingunameEnable()) {
                ArrayList arrayList = new ArrayList();
                String stringExtra3 = intent.getStringExtra(FACE_LOGIN_UIDS);
                if (!TextUtils.isEmpty(stringExtra3)) {
                    arrayList.addAll(new FaceLoginService().str2ShareModelV2List(stringExtra3));
                }
                if (!arrayList.isEmpty()) {
                    new FaceLoginService().syncFaceLoginUidList(context, arrayList);
                }
            }
            StatService.onEventAutoStat(ShareStatKey.SHARE_NEW_AUTH_LOGIN_SUCCESS);
            shareResultCallback.onResultAccount(sapiAccount);
        }
    }

    public void updateInvalidBdussList(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.invalidBdussList == null) {
                this.invalidBdussList = initInvalidStringList();
            }
            int size = this.invalidBdussList.size();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (TextUtils.equals(this.invalidBdussList.get(i2), str)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                this.invalidBdussList.addFirst(str);
            }
            while (this.invalidBdussList.size() > 16) {
                this.invalidBdussList.removeLast();
            }
            SapiContext.getInstance().put(INVALID_BDUSS_LIST, new JSONArray(this.invalidBdussList).toString());
        }
    }
}
