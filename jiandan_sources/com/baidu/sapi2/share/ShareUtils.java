package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.sdk.m.m.a;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.ShareAccountAccessor;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.ShareModelResultCallback;
import com.baidu.sapi2.callback.ShareModelWithCheckCallback;
import com.baidu.sapi2.callback.inner.GetOnlineAppCallback;
import com.baidu.sapi2.callback.inner.GetShareV3AppCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareUtils {
    public static final String ACTION_SHARE_ACTIVITY = "baidu.intent.action.account.SHARE_ACTIVITY";
    public static final String EXTRA_APP_PKG = "PKG";
    public static final String EXTRA_SDK_VERSION = "SDK_VERSION";
    public static final String EXTRA_V2_FACE_LOGIN_UIDS = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final String SHARE_ACCOUNT = "share_account";
    public static final String SHARE_ACCOUNT_CLOUND_VERSION = "shareV3";
    public static final String SHARE_ACCOUNT_NEW_VERSION = "shareV2";
    public static final String SHARE_FAIL_CODE = "share_fail_code";
    public static final String SHARE_FAIL_REASON = "share_fail_reason";
    public static final String S_SHARE_MODEL_FROM_APP_SP = "SHARE_MODEL_FROM_APP_SP";
    public static final String S_SHARE_MODEL_FROM_CLOUD = "SHARE_MODEL_FROM_CLOUD";
    public static final String S_SHARE_MODEL_FROM_SD = "SHARE_MODEL_FROM_SD";
    public static final String S_SHARE_MODEL_FROM_SP = "SHARE_MODEL_FROM_OVERALL_SP";
    public static final String S_SHARE_MODEL_FROM_V2 = "SHARE_MODEL_FROM_V2";
    public static final String S_SHARE_MODEL_FROM_WITH_ERROR = "SHARE_MODEL_FROM_WITH_ERROR";
    public static final String TAG = "pass_share_login";
    public static boolean isRequestShareFromCloudTimeOut = false;
    public static boolean mIsCheckShareOnlineTimeOut = false;
    public static List<ShareStorage.StorageModel> mShareModelsMemoryCache;
    public static String mShareModelsMemoryCacheFrom;

    public static List<ShareStorage.StorageModel> buildExpiredShareModels(List<ShareStorage.StorageModel> list) {
        int i2;
        if (list == null) {
            return new ArrayList(0);
        }
        LinkedList<String> invalidBdussList = ShareLoginModel.getInstance().getInvalidBdussList();
        if (invalidBdussList == null) {
            i2 = 0;
        } else {
            i2 = invalidBdussList.size();
        }
        Iterator<ShareStorage.StorageModel> it = list.iterator();
        while (it.hasNext()) {
            ShareStorage.StorageModel next = it.next();
            if (next != null && !TextUtils.isEmpty(next.bduss)) {
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        break;
                    } else if (TextUtils.equals(invalidBdussList.get(i3), next.bduss)) {
                        it.remove();
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        return list;
    }

    public static void cacheShareModels(List<ShareStorage.StorageModel> list, String str) {
        mShareModelsMemoryCache = list;
        mShareModelsMemoryCacheFrom = str;
    }

    public static void callbackShareModels(ShareModelWithCheckCallback shareModelWithCheckCallback, List<ShareStorage.StorageModel> list, String str) {
        if (shareModelWithCheckCallback != null) {
            shareModelWithCheckCallback.onSuccess(buildExpiredShareModels(list), str);
        }
    }

    public static boolean checkCalleeIdentity(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Map<String, String> authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
            String packageSign = SapiUtils.getPackageSign(context, str);
            if (TextUtils.isEmpty(packageSign)) {
                return false;
            }
            for (String next : authorizedPackages.keySet()) {
                if (str.matches(next) && packageSign.equals(authorizedPackages.get(next))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<ShareStorage.StorageModel> checkShareAppInstalled(List<ShareStorage.StorageModel> list, List<String> list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return null;
        }
        Iterator<ShareStorage.StorageModel> it = list.iterator();
        while (it.hasNext()) {
            ShareStorage.StorageModel next = it.next();
            boolean z = false;
            Iterator<String> it2 = list2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (TextUtils.equals(it2.next(), next.pkg)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                it.remove();
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    public static String[] getDeletedShareModels() {
        String string = SapiContext.getInstance().getString(SapiContext.KEY_SHARE_DELETE_LIST);
        if (!TextUtils.isEmpty(string)) {
            return string.split(",");
        }
        return null;
    }

    public static List<String> getInstalledApps(Context context) {
        SapiConfiguration confignation;
        Map<String, String> authorizedPackages;
        ArrayList arrayList = new ArrayList();
        try {
            SapiAccountManager instance = SapiAccountManager.getInstance();
            if (!(instance == null || (confignation = instance.getConfignation()) == null || !confignation.isAgreeDangerousProtocol() || (authorizedPackages = SapiContext.getInstance().getAuthorizedPackages()) == null)) {
                if (authorizedPackages.size() != 0) {
                    for (String next : authorizedPackages.keySet()) {
                        if (!TextUtils.isEmpty(next)) {
                            if (SapiUtils.checkAppInstalled(context, next) && !next.equals(context.getPackageName())) {
                                arrayList.add(next);
                            }
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e) {
            Log.e(e.getMessage(), new Object[0]);
        }
    }

    public static void getOnlineAppShareModel(List<ShareStorage.StorageModel> list, String str, final ShareModelResultCallback shareModelResultCallback) {
        getOnlineAppShareModel(list, str, (ShareModelCallback) new ShareModelCallback() {
            public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                if (list == null || list.size() == 0) {
                    ShareModelResultCallback.this.onFailure(-107, ShareStorage.MSG_GET_DATA_CHECK_ONLINE_FAIL);
                } else {
                    ShareModelResultCallback.this.onSuccess(list);
                }
            }
        });
    }

    public static void getShareModels(long j, Context context, String str, final ShareModelWithCheckCallback shareModelWithCheckCallback) {
        List<String> installedApps = getInstalledApps(context);
        if (installedApps == null || installedApps.size() <= 0) {
            StatService.onEventAutoStat(ShareStatKey.GET_SHARE_BUT_NONE_APP);
            shareModelWithCheckCallback.onFailure(-104, ShareStorage.MSG_DEVICE_DO_NOT_FIND_OTHER_BAIDU_APP, mShareModelsMemoryCacheFrom);
            return;
        }
        List<ShareStorage.StorageModel> shareModelsFromQuickCache = getShareModelsFromQuickCache(installedApps);
        if (shareModelsFromQuickCache == null || shareModelsFromQuickCache.size() <= 0) {
            List<ShareStorage.StorageModel> shareModelsFromShareStorage = getShareModelsFromShareStorage(installedApps);
            if (shareModelsFromShareStorage == null || shareModelsFromShareStorage.size() <= 0) {
                int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                List<ShareStorage.StorageModel> shareModelsFromSP = getShareModelsFromSP(ordinal, installedApps);
                if (shareModelsFromSP.size() > 0) {
                    cacheShareModels(shareModelsFromSP, S_SHARE_MODEL_FROM_SP);
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_DYNAMIC_SP);
                    callbackShareModels(shareModelWithCheckCallback, shareModelsFromSP, S_SHARE_MODEL_FROM_SP);
                    return;
                }
                if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", context)) {
                    List<ShareStorage.StorageModel> shareModelsFromSdCard = getShareModelsFromSdCard(ordinal, installedApps);
                    if (shareModelsFromSdCard.size() > 0) {
                        cacheShareModels(shareModelsFromSdCard, S_SHARE_MODEL_FROM_SD);
                        StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_DYNAMIC_SDCARD);
                        callbackShareModels(shareModelWithCheckCallback, shareModelsFromSdCard, S_SHARE_MODEL_FROM_SD);
                        return;
                    }
                } else {
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_NO_SDCARD_PERM);
                }
                final AnonymousClass1 r1 = new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message message) {
                        boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = true;
                        shareModelWithCheckCallback.onFailure(-106, ShareStorage.MSG_GET_DATA_FROM_CLOUD_TIMEOUT, ShareUtils.mShareModelsMemoryCacheFrom);
                    }
                };
                r1.removeCallbacksAndMessages((Object) null);
                r1.sendEmptyMessageDelayed(0, j);
                getShareV3App(context, str, installedApps, new GetShareV3AppCallback() {
                    public void onFailure() {
                        r1.removeCallbacksAndMessages((Object) null);
                        HashMap hashMap = new HashMap();
                        hashMap.put(a.Z, ShareUtils.isRequestShareFromCloudTimeOut ? "1" : "0");
                        hashMap.put("status", "0");
                        StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_CLOUD, hashMap);
                        if (ShareUtils.isRequestShareFromCloudTimeOut) {
                            boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = false;
                        } else {
                            r1.post(new Runnable() {
                                public void run() {
                                    shareModelWithCheckCallback.onFailure(-105, ShareStorage.MSG_DEVICE_DO_NOT_FIND_SHARE_DATA, ShareUtils.mShareModelsMemoryCacheFrom);
                                }
                            });
                        }
                    }

                    public void onSuccess(final List<ShareStorage.StorageModel> list) {
                        r1.removeCallbacksAndMessages((Object) null);
                        ShareUtils.cacheShareModels(list, ShareUtils.S_SHARE_MODEL_FROM_CLOUD);
                        HashMap hashMap = new HashMap();
                        hashMap.put(a.Z, ShareUtils.isRequestShareFromCloudTimeOut ? "1" : "0");
                        hashMap.put("status", "1");
                        StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_CLOUD, hashMap);
                        if (ShareUtils.isRequestShareFromCloudTimeOut) {
                            boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = false;
                        } else {
                            r1.post(new Runnable() {
                                public void run() {
                                    ShareUtils.callbackShareModels(shareModelWithCheckCallback, list, ShareUtils.S_SHARE_MODEL_FROM_CLOUD);
                                }
                            });
                        }
                    }
                });
                return;
            }
            cacheShareModels(shareModelsFromShareStorage, S_SHARE_MODEL_FROM_APP_SP);
            callbackShareModels(shareModelWithCheckCallback, shareModelsFromShareStorage, S_SHARE_MODEL_FROM_APP_SP);
            StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_INIT_SP);
            return;
        }
        callbackShareModels(shareModelWithCheckCallback, shareModelsFromQuickCache, mShareModelsMemoryCacheFrom);
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromQuickCache(List<String> list) {
        List<ShareStorage.StorageModel> checkShareAppInstalled;
        if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_CACHE_ABILITY).isMeetGray() || (checkShareAppInstalled = checkShareAppInstalled(mShareModelsMemoryCache, list)) == null || checkShareAppInstalled.size() <= 0) {
            return null;
        }
        Log.d(TAG, "get share model from modelsFromMemoryCache, size=" + checkShareAppInstalled.size());
        StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_MEMORY_CACHE);
        return checkShareAppInstalled;
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromSP(int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ShareStorage shareStorage = new ShareStorage();
        for (String modelFromSp : list) {
            ShareStorage.StorageModel modelFromSp2 = shareStorage.getModelFromSp(modelFromSp);
            if (modelFromSp2 != null && !TextUtils.isEmpty(modelFromSp2.displayname) && !TextUtils.isEmpty(modelFromSp2.url) && i2 == modelFromSp2.env) {
                arrayList.add(modelFromSp2);
            }
        }
        return arrayList;
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromSdCard(int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ShareStorage shareStorage = new ShareStorage();
        for (String modelFromSd : list) {
            ShareStorage.StorageModel modelFromSd2 = shareStorage.getModelFromSd(modelFromSd);
            if (modelFromSd2 != null && !TextUtils.isEmpty(modelFromSd2.displayname) && !TextUtils.isEmpty(modelFromSd2.url) && i2 == modelFromSd2.env) {
                arrayList.add(modelFromSd2);
            }
        }
        return arrayList;
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromShareStorage(List<String> list) {
        String string = SapiContext.getInstance().getString(SapiContext.KEY_SHARE_STORAGE);
        if (!TextUtils.isEmpty(string)) {
            String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(string, SapiContext.getInstance().getAccountEncryptKey());
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(decryptAccountInfo);
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
                return checkShareAppInstalled(ShareStorage.StorageModel.fromJSONArray(jSONArray), list);
            }
        }
        Log.e(TAG, "getShareStorage result is null");
        return new ArrayList(0);
    }

    public static List<ShareStorage.StorageModel> getShareStorageModel() {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration == null || sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            Log.d(TAG, "config initialShareStrategy is DISABLED");
            return new ArrayList(0);
        }
        List<String> installedApps = getInstalledApps(sapiConfiguration.context);
        if (installedApps == null || installedApps.size() == 0) {
            return new ArrayList(0);
        }
        List<ShareStorage.StorageModel> buildExpiredShareModels = buildExpiredShareModels(getShareModelsFromShareStorage(installedApps));
        String[] deletedShareModels = getDeletedShareModels();
        if (buildExpiredShareModels.size() > 0 && deletedShareModels != null && deletedShareModels.length > 0) {
            Log.d(TAG, "shareModels has value, deleteModels has value");
            Iterator<ShareStorage.StorageModel> it = buildExpiredShareModels.iterator();
            while (it.hasNext()) {
                ShareStorage.StorageModel next = it.next();
                for (String str : deletedShareModels) {
                    if (!TextUtils.isEmpty(next.url) && next.url.contains(str)) {
                        try {
                            it.remove();
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return buildExpiredShareModels;
    }

    public static void getShareV3App(Context context, String str, List<String> list, final GetShareV3AppCallback getShareV3AppCallback) {
        if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_MODEL_FROM_SERVER).isMeetGray()) {
            SapiAccountManager.getInstance().getAccountService().getShareV3App(str, list, context.getPackageName(), new GetShareV3AppCallback() {
                public void onFailure() {
                    GetShareV3AppCallback getShareV3AppCallback = GetShareV3AppCallback.this;
                    if (getShareV3AppCallback != null) {
                        getShareV3AppCallback.onFailure();
                    }
                }

                public void onSuccess(List<ShareStorage.StorageModel> list) {
                    if (GetShareV3AppCallback.this == null) {
                        return;
                    }
                    if (list == null || list.size() == 0) {
                        GetShareV3AppCallback.this.onFailure();
                    } else {
                        GetShareV3AppCallback.this.onSuccess(list);
                    }
                }
            });
        } else if (getShareV3AppCallback != null) {
            getShareV3AppCallback.onFailure();
        }
    }

    public static boolean isInV2ShareDisableWhiteList(SapiConfiguration sapiConfiguration) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("com.baidu.searchbox(.*)");
        for (String matches : arrayList) {
            if (sapiConfiguration.context.getPackageName().matches(matches)) {
                return true;
            }
        }
        return false;
    }

    public static void markAsDeleteShareLogin(String str) {
        String[] deletedShareModels = getDeletedShareModels();
        StringBuilder sb = new StringBuilder();
        if (deletedShareModels != null) {
            for (int length = deletedShareModels.length + 1 > 10 ? (deletedShareModels.length + 1) - 10 : 0; length < deletedShareModels.length; length++) {
                sb.append(deletedShareModels[length]);
                sb.append(",");
            }
        }
        sb.append(str);
        SapiContext.getInstance().put(SapiContext.KEY_SHARE_DELETE_LIST, sb.toString());
    }

    public static void onLoginActivityActivityResult(ShareCallPacking.ShareLoginCallBack shareLoginCallBack, int i2, int i3, Intent intent, ShareCallPacking shareCallPacking, List<PassNameValuePair> list, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        ShareCallPacking.ShareLoginCallBack shareLoginCallBack2 = shareLoginCallBack;
        Intent intent2 = intent;
        if (i2 == 20001) {
            if (shareLoginCallBack2 != null) {
                Context context = SapiAccountManager.getInstance().getConfignation().context;
                String str10 = "";
                if (intent2 != null) {
                    String stringExtra = intent2.getStringExtra(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE);
                    ShareLoginModel.getInstance().updateInvalidBdussList(intent2.getStringExtra(ShareLoginModel.INVALIDATE_BDUSS));
                    str2 = stringExtra;
                } else {
                    str2 = str10;
                }
                char c = 2;
                if (i3 != -1 || intent2 == null) {
                    if (intent2 != null) {
                        str7 = intent2.getStringExtra("share_fail_code");
                        str6 = intent2.getStringExtra("share_fail_reason");
                        if (TextUtils.isEmpty(str6)) {
                            str6 = SapiResult.ERROR_MSG_V2_SHARE_ACCOUNT_FAIL;
                        }
                        Toast.makeText(context, str6, 0).show();
                    } else {
                        str6 = "result data is null";
                        str7 = str10;
                    }
                    shareLoginCallBack2.onFailed(SapiResult.ERROR_CODE_V2_SHARE_ACCOUNT_FAIL, SapiResult.ERROR_MSG_V2_SHARE_ACCOUNT_FAIL);
                    str5 = str7;
                    str4 = str6;
                    str3 = str10;
                } else {
                    SapiAccount sapiAccount = (SapiAccount) intent2.getParcelableExtra("share_account");
                    if (sapiAccount != null) {
                        sapiAccount.fromType = FromType.LOGIN.getValue();
                        int intExtra = intent2.getIntExtra("SDK_VERSION", 0);
                        JSONObject jSONObject = new JSONObject();
                        if (intExtra >= 190) {
                            try {
                                String stringExtra2 = intent2.getStringExtra("PKG");
                                ShareAccountAccessor.getAccessor().setAccountPkg(sapiAccount, stringExtra2);
                                jSONObject.put("from_pkg", stringExtra2);
                                jSONObject.put("from_tpl", str10);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            sapiAccount.app = str10;
                        }
                        str9 = sapiAccount.uid;
                        SapiContext instance = SapiContext.getInstance();
                        instance.setCurrentAccount(sapiAccount);
                        instance.addLoginAccount(sapiAccount);
                        shareCallPacking.asyncMarkLoginState(2);
                        instance.setAccountActionType(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
                        SapiAccountManager.getInstance().getUserInfoAndRefershAccount(sapiAccount, Enums.LastLoginType.CHOICE_SHARE_V2.getValue(), jSONObject.toString());
                        if (instance.shareLivingunameEnable()) {
                            ArrayList arrayList = new ArrayList();
                            String stringExtra3 = intent2.getStringExtra("V2_FACE_LOGIN_UIDS_TIMES");
                            if (!TextUtils.isEmpty(stringExtra3)) {
                                arrayList.addAll(new FaceLoginService().str2ShareModelV2List(stringExtra3));
                            }
                            if (!arrayList.isEmpty()) {
                                new FaceLoginService().syncFaceLoginUidList(context, arrayList);
                            }
                        }
                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.CHOICE_SHARE_V2.getName());
                        shareLoginCallBack.onSuccess();
                        str8 = str10;
                        c = 0;
                    } else {
                        Toast.makeText(context, SapiResult.ERROR_MSG_V2_SHARE_ACCOUNT_FAIL, 0).show();
                        shareLoginCallBack2.onFailed(SapiResult.ERROR_CODE_V2_SHARE_ACCOUNT_FAIL, SapiResult.ERROR_MSG_V2_SHARE_ACCOUNT_FAIL);
                        str8 = ShareResult.ERROR_MSG_ACCOUNT_NULL;
                        str9 = str10;
                        c = 1;
                        str10 = "-3007";
                    }
                    str3 = str9;
                    str4 = str8;
                    str5 = str10;
                }
                if (SHARE_ACCOUNT_CLOUND_VERSION.equals(str2)) {
                    if (c == 0) {
                        SapiStatUtil.statInvokeCloudShareAccount(4);
                    } else {
                        SapiStatUtil.statInvokeCloudShareAccount(5);
                    }
                } else if (c == 0) {
                    SapiStatUtil.statShareV2Success(ShareCallPacking.statModel, str3, list, str);
                } else {
                    List<PassNameValuePair> list2 = list;
                    String str11 = str;
                    SapiStatUtil.statShareV2Fail(ShareCallPacking.statModel, str5, str4, str3, list, str);
                }
            } else {
                throw new IllegalArgumentException("and shareLoginCallBack can't be null");
            }
        }
    }

    public static void setShareStorageModel() {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        Context context = confignation.context;
        if (SapiUtils.isOnline(confignation) && confignation.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            List<String> installedApps = getInstalledApps(context);
            if (installedApps.size() == 0) {
                SapiContext.getInstance().setShareStorage((JSONArray) null);
                return;
            }
            ShareStorage shareStorage = new ShareStorage();
            int size = installedApps.size();
            int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
            int i2 = 1;
            Log.d(TAG, "current login env is " + ordinal);
            if (!SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", context)) {
                StatService.onEventAutoStat(ShareStatKey.SHARE_V2_LOGIN_NOT_STORAGE_PERM);
            }
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            int i3 = size;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (String next : installedApps) {
                sb.append(next);
                sb.append(",");
                ShareStorage.StorageModel storageModel = shareStorage.get(next);
                if (storageModel == null) {
                    i4++;
                } else {
                    Object[] objArr = new Object[i2];
                    objArr[0] = next + " env=" + storageModel.env + " flag=" + storageModel.flag + " displayName=" + storageModel.displayname;
                    Log.d(TAG, objArr);
                    if (storageModel.env != ordinal) {
                        i3--;
                    } else {
                        int i7 = storageModel.where;
                        if (i7 == 0) {
                            i5++;
                        } else if (i7 == 1) {
                            i6++;
                        }
                        if (storageModel.flag == 0) {
                            arrayList.add(storageModel);
                        }
                    }
                }
                i2 = 1;
            }
            Object[] objArr2 = new Object[i2];
            objArr2[0] = "share storage model result size=" + arrayList.size();
            Log.d(TAG, objArr2);
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            SapiContext.getInstance().setShareStorage(ShareStorage.StorageModel.toJSONArray(arrayList));
            SapiStatUtil.statShareV2OpenMax(context, i4, i5, i6, i3, shareStorage, arrayList);
        }
    }

    public static void startLoginShareActivityForResult(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5, String str6) {
        if (activity != null) {
            if (SHARE_ACCOUNT_NEW_VERSION.equals(str5)) {
                ShareCallPacking.statModel = new ShareCallPacking.StatModel();
                List<ShareStorage.StorageModel> shareStorageModel = getShareStorageModel();
                int i2 = 0;
                while (true) {
                    if (i2 < shareStorageModel.size()) {
                        if (shareStorageModel.get(i2).pkg.equals(str) && shareStorageModel.get(i2).url.equals(str2)) {
                            ShareCallPacking.StatModel statModel = ShareCallPacking.statModel;
                            statModel.index = i2;
                            statModel.accountTpl = shareStorageModel.get(i2).tpl;
                            ShareCallPacking.statModel.appName = shareStorageModel.get(i2).app;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                SapiStatUtil.statShareV2Click(ShareCallPacking.statModel, list, str6);
            } else {
                SapiStatUtil.statInvokeCloudShareAccount(3);
            }
            if (TextUtils.isEmpty(str) || !SapiUtils.isAppInstalled(activity, str)) {
                Toast.makeText(activity, "登录失败", 0).show();
                return;
            }
            ComponentName componentName = new ComponentName(str, "com.baidu.sapi2.activity.ShareActivity");
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.putExtra(ShareCallPacking.EXTRA_SESSION_ID, str4);
            intent.putExtra(ShareCallPacking.EXTRA_TRACE_ID, str3);
            intent.putExtra(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE, str5);
            intent.putExtra(ShareCallPacking.EXTRA_CALL_TYPE_SHARE, str6);
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration != null) {
                intent.putExtra(ShareCallPacking.EXTRA_FROM_APP_TPL, sapiConfiguration.tpl);
            } else {
                intent.putExtra(ShareCallPacking.EXTRA_FROM_APP_TPL, "unknown");
            }
            intent.setComponent(componentName);
            if (activity.getPackageManager().resolveActivity(intent, 65536) != null) {
                activity.startActivityForResult(intent, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("loginActivity can't be null");
    }

    public static void getOnlineAppShareModel(final List<ShareStorage.StorageModel> list, String str, final ShareModelCallback shareModelCallback) {
        if (SapiContext.getInstance() == null) {
            shareModelCallback.onReceiveShareModels(list);
        } else if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_SHARE_CHECK_ONLINE_SWITCH).isMeetGray()) {
            shareModelCallback.onReceiveShareModels(list);
        } else {
            String str2 = S_SHARE_MODEL_FROM_CLOUD.equals(str) ? "1" : "0";
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            if (S_SHARE_MODEL_FROM_CLOUD.equals(str)) {
                for (ShareStorage.StorageModel getOnlineRequestShareModel : list) {
                    arrayList.add(new GetOnlineRequestShareModel(getOnlineRequestShareModel));
                }
            } else {
                for (ShareStorage.StorageModel next : list) {
                    if (TextUtils.isEmpty(next.bduss)) {
                        arrayList2.add(next);
                    } else {
                        arrayList.add(new GetOnlineRequestShareModel(next));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                shareModelCallback.onReceiveShareModels(list);
                return;
            }
            int i2 = SapiContext.getInstance().getSapiOptions().shareCheckOnlineTimeOut;
            final AnonymousClass5 r4 = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    boolean unused = ShareUtils.mIsCheckShareOnlineTimeOut = true;
                    shareModelCallback.onReceiveShareModels(list);
                }
            };
            r4.removeCallbacksAndMessages((Object) null);
            r4.sendEmptyMessageDelayed(0, (long) i2);
            final ShareModelCallback shareModelCallback2 = shareModelCallback;
            final List<ShareStorage.StorageModel> list2 = list;
            final String str3 = str;
            SapiAccountManager.getInstance().getAccountService().getOnlineAppShareModel(arrayList, str2, new GetOnlineAppCallback() {
                public void onFailure() {
                    r4.removeCallbacksAndMessages((Object) null);
                    if (ShareUtils.mIsCheckShareOnlineTimeOut) {
                        boolean unused = ShareUtils.mIsCheckShareOnlineTimeOut = false;
                    } else {
                        r4.post(new Runnable() {
                            public void run() {
                                AnonymousClass6 r0 = AnonymousClass6.this;
                                shareModelCallback2.onReceiveShareModels(list2);
                            }
                        });
                    }
                }

                public void onSuccess(JSONArray jSONArray) {
                    r4.removeCallbacksAndMessages((Object) null);
                    if (ShareUtils.mIsCheckShareOnlineTimeOut) {
                        boolean unused = ShareUtils.mIsCheckShareOnlineTimeOut = false;
                    } else if (jSONArray == null || jSONArray.length() == 0) {
                        shareModelCallback2.onReceiveShareModels(new ArrayList());
                    } else {
                        try {
                            ArrayList<ShareStorage.StorageModel> arrayList = new ArrayList<>();
                            for (ShareStorage.StorageModel storageModel : list2) {
                                if (storageModel != null) {
                                    String str = storageModel.app + storageModel.pkg + storageModel.bduss;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= jSONArray.length()) {
                                            break;
                                        }
                                        String str2 = (String) jSONArray.get(i2);
                                        if (str2 != null) {
                                            if (str2.equals(str)) {
                                                break;
                                            }
                                        }
                                        i2++;
                                    }
                                    arrayList.add(storageModel);
                                }
                            }
                            if (!ShareUtils.S_SHARE_MODEL_FROM_CLOUD.equals(str3) && !arrayList2.isEmpty()) {
                                arrayList.addAll(arrayList2);
                            }
                            JSONArray jSONArray2 = new JSONArray();
                            for (ShareStorage.StorageModel storageModel2 : arrayList) {
                                if (storageModel2 != null) {
                                    jSONArray2.put(storageModel2.app);
                                }
                            }
                            shareModelCallback2.onReceiveShareModels(arrayList);
                        } catch (Exception e) {
                            shareModelCallback2.onReceiveShareModels(list2);
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
