package com.baidu.searchbox.base.util.scheme;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.util.io.JSONUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;

public class UnitedSchemeQuerySchemeUtil {
    private static final boolean DEBUG = UnitedSchemeConstants.DEBUG;
    public static final String KEY_PARAMS = "params";
    private static final int RESULT_CODE_INSTALLED = 0;
    private static final int RESULT_CODE_NOT_INSTALLED = 1;
    private static final int RESULT_CODE_PARAMS_ERR = -1;
    private static final int RESULT_CODE_UNKNOWN = 2;
    /* access modifiers changed from: private */
    public UnitedSchemeEntity mEntity;
    private CallbackHandler mSchemaHandler;

    public UnitedSchemeQuerySchemeUtil(UnitedSchemeEntity entity, CallbackHandler handler) {
        this.mSchemaHandler = handler;
        this.mEntity = entity;
    }

    public void handleQueryScheme() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                UnitedSchemeQuerySchemeUtil unitedSchemeQuerySchemeUtil = UnitedSchemeQuerySchemeUtil.this;
                unitedSchemeQuerySchemeUtil.handleQuerySchemeOnIO(unitedSchemeQuerySchemeUtil.mEntity.getParams().get("params"));
            }
        }, "handleQuerySchemeOnIO", 1);
    }

    /* access modifiers changed from: private */
    public void handleQuerySchemeOnIO(String param) {
        try {
            int resultCode = checkAppInstalled(AppRuntime.getApplication().getApplicationContext(), JSONUtils.parseString(param).optString("pkg"));
            JSONObject json = new JSONObject();
            json.put("result", String.valueOf(resultCode));
            UnitedSchemeEntity unitedSchemeEntity = this.mEntity;
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(this.mSchemaHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(json, 0));
        } catch (Throwable e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private int checkAppInstalled(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return -1;
        }
        String packageName2 = packageName.trim();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName2, 0);
            if (packageInfo == null || !TextUtils.equals(packageInfo.packageName, packageName2)) {
                return 2;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e2) {
            return 1;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 2;
        }
    }
}
