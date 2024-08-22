package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PassCoreVHelper;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import fe.fe.ppp.ad.ad;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareStorage {
    public static final int CODE_APP_IS_NOT_ONLINE = -102;
    public static final int CODE_APP_SHARE_IS_DISABLED = -103;
    public static final int CODE_DEVICE_DO_NOT_FIND_OTHER_BAIDU_APP = -104;
    public static final int CODE_DEVICE_DO_NOT_FIND_SHARE_DATA = -105;
    public static final int CODE_GET_DATA_CHECK_ONLINE_FAIL = -107;
    public static final int CODE_GET_DATA_FROM_CLOUD_TIMEOUT = -106;
    public static final int CODE_PASS_HAS_NOT_INIT = -101;
    public static final String DEFAULT_PORTRAIT = (SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT);
    public static final String KEY_SHARE_MODELS_AES_IV = "key_pass_share_models_iv";
    public static final String KEY_SHARE_MODELS_AES_KEY = "key_pass_hare_models_key";
    public static int MODE = 5;
    public static final String MSG_APP_IS_NOT_ONLINE = "当前APP不是Release线上";
    public static final String MSG_APP_SHARE_IS_DISABLED = "当前APP配置不支持互通";
    public static final String MSG_DEVICE_DO_NOT_FIND_OTHER_BAIDU_APP = "当前设备未安装其他支持互通的百度产品";
    public static final String MSG_DEVICE_DO_NOT_FIND_SHARE_DATA = "当前设备存在互通产品但是获取不到互通信息(1、互通APP未登录 2、互通APP 或 当前APP未打开文件权限)";
    public static final String MSG_GET_DATA_CHECK_ONLINE_FAIL = "互通登录数据已过期";
    public static final String MSG_GET_DATA_FROM_CLOUD_TIMEOUT = "云端互通获取超时";
    public static final String MSG_PASS_HAS_NOT_INIT = "Pass SDK未初始化";
    public static final String SD_FILE_NAME = ".BD_SAPI_CACHE/.sapi_temp/";
    public static final int SHARE_ACCOUNT_BACKGROUND_TO_FOREGROUND = 1;
    public static final int SHARE_ACCOUNT_GET_TPL_STOKEN = 5;
    public static final int SHARE_ACCOUNT_INIT = 0;
    public static final int SHARE_ACCOUNT_LOGIN = 2;
    public static final int SHARE_ACCOUNT_LOGOUT = 3;
    public static final int SHARE_ACCOUNT_RESET = 4;
    public static final String SP_FILE_NAME = "sapi_share";
    public static final String SP_FILE_PATH = ".BD_SAPI_CACHE/";
    public Context context = SapiAccountManager.getInstance().getConfignation().context;
    public boolean readSpFromChmodFile = false;

    public interface CallBack {
        void call(StorageModel storageModel);
    }

    public static class StorageModel {
        public String app;
        public String bduss;
        public String displayname;
        public int env;
        public int flag;
        public String pkg;
        public String tpl;
        public String url;
        public String uuid;
        public int where;

        public static void buildFromSystem(final Context context, int i2, final CallBack callBack) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null || currentAccount.isGuestAccount()) {
                StorageModel storageModel = new StorageModel();
                storageModel.flag = 1;
                callBack.call(storageModel);
            } else if (i2 == 0 || i2 == 1) {
                StorageModel storageModel2 = new StorageModel();
                storageModel2.displayname = currentAccount.displayname;
                storageModel2.url = SapiContext.getInstance().getString(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT);
                storageModel2.app = SapiUtils.getAppName(context);
                storageModel2.pkg = context.getPackageName();
                storageModel2.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                storageModel2.bduss = currentAccount.bduss;
                storageModel2.uuid = UUID.randomUUID().toString();
                storageModel2.flag = 0;
                storageModel2.env = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                callBack.call(storageModel2);
            } else {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() {
                    public void onFinish() {
                    }

                    public void onStart() {
                    }

                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                        StorageModel storageModel = new StorageModel();
                        storageModel.flag = 1;
                        CallBack.this.call(storageModel);
                    }

                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                        StorageModel storageModel = new StorageModel();
                        storageModel.flag = 1;
                        CallBack.this.call(storageModel);
                    }

                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        StorageModel storageModel = new StorageModel();
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        if (!TextUtils.isEmpty(getUserInfoResult.portraitHttps)) {
                            storageModel.url = getUserInfoResult.portraitHttps;
                        } else {
                            storageModel.url = ShareStorage.DEFAULT_PORTRAIT;
                        }
                        SapiContext.getInstance().put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, storageModel.url);
                        storageModel.displayname = currentAccount.displayname;
                        storageModel.app = SapiUtils.getAppName(context);
                        storageModel.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                        storageModel.bduss = currentAccount.bduss;
                        storageModel.pkg = context.getPackageName();
                        storageModel.uuid = UUID.randomUUID().toString();
                        storageModel.flag = 0;
                        storageModel.env = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                        CallBack.this.call(storageModel);
                    }
                }, SapiContext.getInstance().getCurrentAccount().bduss);
            }
        }

        public static StorageModel fromJSON(JSONObject jSONObject) {
            StorageModel storageModel = new StorageModel();
            String optString = jSONObject.optString("url");
            storageModel.url = optString;
            if (TextUtils.isEmpty(optString)) {
                storageModel.url = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PORTRAIT);
            }
            storageModel.displayname = jSONObject.optString("displayname");
            storageModel.app = jSONObject.optString("app");
            storageModel.tpl = jSONObject.optString("tpl");
            storageModel.bduss = jSONObject.optString("bduss");
            storageModel.uuid = jSONObject.optString("uid");
            storageModel.pkg = jSONObject.optString(SapiAccount.ExtraProperty.EXTRA_PKG);
            storageModel.flag = jSONObject.optInt(OpenBdussResult.PARAMS_FLAG, -1);
            storageModel.env = jSONObject.optInt("env", Domain.DOMAIN_ONLINE.ordinal());
            return storageModel;
        }

        public static List<StorageModel> fromJSONArray(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    StorageModel fromJSON = fromJSON(jSONArray.getJSONObject(i2));
                    if (fromJSON != null && !TextUtils.isEmpty(fromJSON.displayname) && !TextUtils.isEmpty(fromJSON.url)) {
                        arrayList.add(fromJSON);
                    }
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return arrayList;
        }

        public static JSONArray toJSONArray(List<StorageModel> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (StorageModel json : list) {
                JSONObject json2 = json.toJSON();
                if (json2 != null) {
                    jSONArray.put(json2);
                }
            }
            return jSONArray;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.url);
                jSONObject.put("displayname", this.displayname);
                jSONObject.put("app", this.app);
                jSONObject.put("tpl", this.tpl);
                jSONObject.put("bduss", this.bduss);
                jSONObject.put("uid", this.uuid);
                jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, this.pkg);
                jSONObject.put(OpenBdussResult.PARAMS_FLAG, this.flag);
                jSONObject.put("env", this.env);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }

        public StorageModel() {
        }
    }

    public ShareStorage() {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null && sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            MODE = 4;
        }
    }

    @TargetApi(4)
    private String getDataFromShareInternal(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = this.context.getPackageName();
        }
        String str3 = this.context.getApplicationInfo().dataDir;
        String str4 = (str3.replace(this.context.getPackageName(), "") + str) + "/" + SP_FILE_PATH + str2;
        Log.e(ShareUtils.TAG, "getDataFromShareInternal", "fileName", str4);
        return FileUtil.read(str4);
    }

    private boolean meetShareInternalGray() {
        int i2 = SapiContext.getInstance().getInt(SapiContext.KEY_SHARE_INTERNAL_GRAY, -1);
        if (i2 == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            i2 = random.nextInt(100);
            SapiContext.getInstance().put(SapiContext.KEY_SHARE_INTERNAL_GRAY, i2);
        }
        return i2 <= SapiContext.getInstance().getShareInternalGray();
    }

    /* access modifiers changed from: private */
    public void setCloud(int i2, StorageModel storageModel) {
        SapiAccountManager.getInstance().getAccountService().setCloudShareAccount(i2, storageModel);
    }

    public void asyncSet(final int i2) {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() {
            public void run() {
                ShareStorage.this.syncSet(i2);
            }
        }));
    }

    public StorageModel get(String str) {
        StorageModel modelFromSp = getModelFromSp(str);
        return modelFromSp == null ? getModelFromSd(str) : modelFromSp;
    }

    @TargetApi(8)
    public StorageModel getModelFromSd(String str) {
        try {
            String sd = getSd(ad.rg(str.getBytes(), false));
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("get share model from sd_card pkg=");
            sb.append(str);
            sb.append(" value is ");
            sb.append(TextUtils.isEmpty(sd) ? "empty" : "not empty");
            objArr[0] = sb.toString();
            Log.d(ShareUtils.TAG, objArr);
            if (TextUtils.isEmpty(sd)) {
                return null;
            }
            try {
                sd = new String(ad.qw(Base64.decode(sd, 0), PassCoreVHelper.getAesIv(), PassCoreVHelper.getAesKey()));
            } catch (Exception e) {
                Log.e(e);
            } catch (Throwable th2) {
                Log.e(th2);
            }
            StorageModel fromJSON = StorageModel.fromJSON(new JSONObject(sd));
            fromJSON.where = 1;
            return fromJSON;
        } catch (Exception e2) {
            Log.e(ShareUtils.TAG, e2.getMessage());
            return null;
        } catch (Throwable th3) {
            Log.e(ShareUtils.TAG, th3.getMessage());
            return null;
        }
    }

    public StorageModel getModelFromSp(String str) {
        try {
            String sp = getSp(str, ad.rg(str.getBytes(), false));
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("get share model from share_preferences pkg=");
            sb.append(str);
            sb.append(" value is ");
            sb.append(TextUtils.isEmpty(sp) ? "empty" : "not empty");
            objArr[0] = sb.toString();
            Log.d(ShareUtils.TAG, objArr);
            if (TextUtils.isEmpty(sp)) {
                return null;
            }
            try {
                sp = new String(ad.qw(Base64.decode(sp, 0), PassCoreVHelper.getAesIv(), PassCoreVHelper.getAesKey()));
            } catch (Exception e) {
                Log.e(e);
            } catch (Throwable th2) {
                Log.e(th2);
            }
            StorageModel fromJSON = StorageModel.fromJSON(new JSONObject(sp));
            fromJSON.where = 0;
            return fromJSON;
        } catch (Exception e2) {
            Log.e(ShareUtils.TAG, e2.getMessage());
            return null;
        } catch (Throwable th3) {
            Log.e(ShareUtils.TAG, th3.getMessage());
            return null;
        }
    }

    public String getSd(String str) {
        String str2;
        try {
            if (!SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this.context)) {
                Log.d(ShareUtils.TAG, "getSd is not has READ_EXTERNAL_STORAGE permission");
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                str2 = this.context.getExternalCacheDir().getAbsolutePath() + File.separator + SD_FILE_NAME + str;
            } else {
                str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + SD_FILE_NAME + str;
            }
            if (FileUtil.isFileExist(str2)) {
                Log.d(ShareUtils.TAG, "getSd filePath=" + str2);
                return FileUtil.read(str2);
            }
            return null;
        } catch (Exception e) {
            Log.e(ShareUtils.TAG, e.getMessage());
        }
    }

    public String getSp(String str) {
        return getSp((String) null, str);
    }

    public boolean setSd(String str, String str2) {
        File file;
        try {
            if (!SapiUtils.checkRequestPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, this.context)) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                File externalCacheDir = this.context.getExternalCacheDir();
                file = new File(externalCacheDir, SD_FILE_NAME + str);
            } else {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                file = new File(externalStorageDirectory, SD_FILE_NAME + str);
            }
            if (TextUtils.isEmpty(str2)) {
                FileUtil.deleteFile(file);
                return true;
            }
            FileUtil.write(file, str2.getBytes(), false);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @TargetApi(4)
    public boolean setSp(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(SP_FILE_NAME, MODE);
            if (Build.VERSION.SDK_INT > 8) {
                sharedPreferences.edit().putString(str, str2).apply();
            } else {
                sharedPreferences.edit().putString(str, str2).commit();
            }
            return true;
        } catch (Throwable th2) {
            Log.e(th2);
            return false;
        }
    }

    public void syncSet(final int i2) {
        StorageModel.buildFromSystem(this.context, i2, new CallBack() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
            /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void call(com.baidu.sapi2.share.ShareStorage.StorageModel r7) {
                /*
                    r6 = this;
                    com.baidu.sapi2.SapiAccountManager r0 = com.baidu.sapi2.SapiAccountManager.getInstance()
                    com.baidu.sapi2.SapiConfiguration r0 = r0.getConfignation()
                    com.baidu.sapi2.utils.enums.LoginShareStrategy r0 = r0.loginShareStrategy()
                    com.baidu.sapi2.utils.enums.LoginShareStrategy r1 = com.baidu.sapi2.utils.enums.LoginShareStrategy.DISABLED
                    if (r0 != r1) goto L_0x0013
                    r0 = 1
                    r7.flag = r0
                L_0x0013:
                    com.baidu.sapi2.share.ShareStorage r0 = com.baidu.sapi2.share.ShareStorage.this
                    android.content.Context r0 = r0.context
                    java.lang.String r0 = r0.getPackageName()
                    byte[] r0 = r0.getBytes()
                    r1 = 0
                    java.lang.String r0 = fe.fe.ppp.ad.ad.rg(r0, r1)
                    java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0049, all -> 0x0044 }
                    org.json.JSONObject r3 = r7.toJSON()     // Catch:{ Exception -> 0x0049, all -> 0x0044 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0049, all -> 0x0044 }
                    java.lang.String r4 = com.baidu.sapi2.utils.PassCoreVHelper.getAesIv()     // Catch:{ Exception -> 0x0049, all -> 0x0044 }
                    java.lang.String r5 = com.baidu.sapi2.utils.PassCoreVHelper.getAesKey()     // Catch:{ Exception -> 0x0049, all -> 0x0044 }
                    byte[] r3 = fe.fe.ppp.ad.ad.ad(r3, r4, r5)     // Catch:{ Exception -> 0x0049, all -> 0x0044 }
                    byte[] r1 = android.util.Base64.encode(r3, r1)     // Catch:{ Exception -> 0x0049, all -> 0x0044 }
                    r2.<init>(r1)     // Catch:{ Exception -> 0x0049, all -> 0x0044 }
                    goto L_0x004f
                L_0x0044:
                    r1 = move-exception
                    com.baidu.sapi2.utils.Log.e(r1)
                    goto L_0x004d
                L_0x0049:
                    r1 = move-exception
                    com.baidu.sapi2.utils.Log.e(r1)
                L_0x004d:
                    java.lang.String r2 = ""
                L_0x004f:
                    com.baidu.sapi2.share.ShareStorage r1 = com.baidu.sapi2.share.ShareStorage.this
                    r1.setSp(r0, r2)
                    com.baidu.sapi2.share.ShareStorage r1 = com.baidu.sapi2.share.ShareStorage.this
                    r1.setSd(r0, r2)
                    int r0 = r3
                    r1 = 2
                    if (r0 == r1) goto L_0x0064
                    r1 = 3
                    if (r0 == r1) goto L_0x0064
                    r1 = 4
                    if (r0 != r1) goto L_0x006b
                L_0x0064:
                    com.baidu.sapi2.share.ShareStorage r0 = com.baidu.sapi2.share.ShareStorage.this
                    int r1 = r3
                    r0.setCloud(r1, r7)
                L_0x006b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.share.ShareStorage.AnonymousClass2.call(com.baidu.sapi2.share.ShareStorage$StorageModel):void");
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getSp(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 0
            r3 = 24
            if (r0 >= r3) goto L_0x0036
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r3 = "sapi_share"
            if (r0 == 0) goto L_0x0019
            android.content.Context r0 = r5.context
            int r4 = MODE
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r4)
            goto L_0x0037
        L_0x0019:
            android.content.Context r0 = r5.context     // Catch:{ Exception -> 0x0027 }
            r4 = 2
            android.content.Context r0 = r0.createPackageContext(r6, r4)     // Catch:{ Exception -> 0x0027 }
            int r4 = MODE     // Catch:{ Exception -> 0x0027 }
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r4)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0037
        L_0x0027:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r4 = 0
            java.lang.String r0 = r0.getMessage()
            r3[r4] = r0
            java.lang.String r0 = "pass_share_login"
            com.baidu.sapi2.utils.Log.e((java.lang.String) r0, (java.lang.Object[]) r3)
        L_0x0036:
            r0 = r2
        L_0x0037:
            if (r0 == 0) goto L_0x003f
            java.lang.String r2 = ""
            java.lang.String r2 = r0.getString(r7, r2)
        L_0x003f:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0051
            java.lang.String r2 = r5.getDataFromShareInternal(r6, r7)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0051
            r5.readSpFromChmodFile = r1
        L_0x0051:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.share.ShareStorage.getSp(java.lang.String, java.lang.String):java.lang.String");
    }
}
