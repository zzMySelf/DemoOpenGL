package com.baidu.voicesearch.component.voice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.voicesearch.component.utils.ToolsUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceErrorMappingControl {
    public static final String ERROR_MAPPING_FILE = "mms/Config/ErrorMapping";
    public static final String NOT_MAPPING = "07";
    private static final String TAG = VoiceErrorMappingControl.class.getSimpleName();
    private static VoiceErrorMappingControl mInstance;
    JSONObject mDefaultErrorMapping;
    JSONObject mErrorMapping;

    private VoiceErrorMappingControl(Context context) {
        createErrorCodeMapping(context);
    }

    public static VoiceErrorMappingControl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (VoiceErrorMappingControl.class) {
                mInstance = new VoiceErrorMappingControl(context);
            }
        }
        return mInstance;
    }

    public String getErrorCodeWithSdkCode(String sdkErrorCode) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(sdkErrorCode)) {
            return "07";
        }
        String result = "";
        JSONObject jSONObject2 = this.mErrorMapping;
        if (jSONObject2 != null && jSONObject2.has(sdkErrorCode)) {
            result = this.mErrorMapping.optString(sdkErrorCode);
        }
        if (TextUtils.isEmpty(result) && (jSONObject = this.mDefaultErrorMapping) != null && jSONObject.has(sdkErrorCode)) {
            result = this.mDefaultErrorMapping.optString(sdkErrorCode);
        }
        if (!TextUtils.isEmpty(result)) {
            return result;
        }
        return "07";
    }

    private void createErrorCodeMapping(Context context) {
        loadErrorCodeMappingFromServer(context);
        if (VoiceApplicationManager.getApplicationContext() != null) {
            loadErrorCodeMappingFromLocal(VoiceApplicationManager.getApplicationContext());
        }
    }

    private void loadErrorCodeMappingFromServer(Context context) {
        String mappingContent = getErrorMappingFromFile(context);
        if (!TextUtils.isEmpty(mappingContent)) {
            try {
                this.mErrorMapping = new JSONObject(mappingContent);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            this.mErrorMapping = null;
        }
    }

    private void loadErrorCodeMappingFromLocal(Context context) {
        String defaultMappingContent = getDefaultErrorMapping(context);
        if (!TextUtils.isEmpty(defaultMappingContent)) {
            try {
                this.mDefaultErrorMapping = new JSONObject(defaultMappingContent);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private String getErrorMappingFromFile(Context context) {
        if (context == null) {
            return "";
        }
        return ToolsUtils.getContentFromFile(context.getFilesDir().getAbsolutePath() + File.separator + "mms/Config/ErrorMapping");
    }

    private String getDefaultErrorMapping(Context context) {
        return ToolsUtils.getAssetsFileContent(context, "mms/Config/ErrorMapping");
    }
}
