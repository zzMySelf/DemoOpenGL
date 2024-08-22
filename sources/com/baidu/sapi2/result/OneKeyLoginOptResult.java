package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class OneKeyLoginOptResult implements NoProguard {
    private static final String TAG = "OneKeyLoginOptResult";
    private int code;
    private String extraStr;
    private String operateType;
    private String securityPhone;
    private int subCode;

    private interface OptResultFields {
        public static final String CODE = "0";
        public static final String EXTRA = "3";
        public static final String OPERATE_TYPE = "2";
        public static final String SECURITY_PHONE = "fakeMobile";
        public static final String SUB_CODE = "1";
    }

    public int getCode() {
        return this.code;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public String getOperateType() {
        return this.operateType;
    }

    public String getExtraStr() {
        return this.extraStr;
    }

    public String getSecurityPhone() {
        return this.securityPhone;
    }

    public void setCode(int code2) {
        this.code = code2;
    }

    public void setSubCode(int subCode2) {
        this.subCode = subCode2;
    }

    public static OneKeyLoginOptResult formatOptResult(String resultStr) {
        OneKeyLoginOptResult optResult = new OneKeyLoginOptResult();
        if (!TextUtils.isEmpty(resultStr)) {
            try {
                JSONObject jsonObj = new JSONObject(resultStr);
                optResult.code = jsonObj.optInt("0", -202);
                optResult.subCode = jsonObj.optInt("1", -202);
                optResult.operateType = jsonObj.optString("2");
                optResult.extraStr = jsonObj.optString("3");
            } catch (JSONException e2) {
                Log.e(TAG, e2.getMessage());
            }
        }
        return optResult;
    }

    public static boolean isValid(OneKeyLoginOptResult result) {
        return result != null && result.code == 0 && result.subCode == 0 && !TextUtils.isEmpty(result.operateType) && !TextUtils.isEmpty(result.extraStr);
    }

    public void generateSecurityPhone() {
        Log.d(TAG, "generateSecurityPhone extraStr=" + this.extraStr);
        if (!TextUtils.isEmpty(this.extraStr)) {
            try {
                this.securityPhone = new JSONObject(this.extraStr).optString("fakeMobile");
            } catch (JSONException e2) {
                Log.e(TAG, e2.getMessage());
            }
        }
    }
}
