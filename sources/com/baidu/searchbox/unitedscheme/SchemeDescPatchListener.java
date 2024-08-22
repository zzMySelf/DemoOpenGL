package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.android.VersionUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SchemeDescPatchListener extends JSONObjectCommandListener {
    private static final boolean DEBUG = AppConfig.isDebug();
    static final String DESC_PATCH_ACTION = "desc_patch";
    static final String DESC_PATCH_VERSION = "desc_patch_v";
    static final String END_VERSION = "endVersion";
    static final String KEY_DESC_PATCH_DATA = "desc_patch_data";
    static final String PATCH = "patch";
    static final String START_VERSION = "startVersion";
    private static final String TAG = SchemeDescPatchListener.class.getSimpleName();
    static String amendDes = "";
    static String endVersion;
    static String startVersion;

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(DESC_PATCH_ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || !TextUtils.equals(action, DESC_PATCH_ACTION) || TextUtils.isEmpty(value.version)) {
            return false;
        }
        if (!TextUtils.equals(value.version, getLocalVersion(context, module, action)) && value.data != null) {
            if (DEBUG) {
                Log.d(TAG, "value.data " + value.data);
            }
            if (SavePatchToFile(((JSONObject) value.data).toString())) {
                PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).edit().putString(DESC_PATCH_VERSION, value.version).apply();
                JSONArray patchArray = ((JSONObject) value.data).optJSONArray(PATCH);
                if (patchArray == null) {
                    return true;
                }
                startVersion = ((JSONObject) value.data).optString(START_VERSION);
                endVersion = ((JSONObject) value.data).optString("endVersion");
                amendDes = patchArray.toString();
                SchemeCollecter.finalDesPatch = SchemeCollecter.getAmendDes();
                return true;
            }
        }
        return false;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(DESC_PATCH_VERSION, "0");
    }

    private static boolean SavePatchToFile(String patch) {
        try {
            File file = new File(SchemeConfig.getAppContext().getFilesDir(), KEY_DESC_PATCH_DATA);
            if (file.exists()) {
                return FileUtils.saveToFileWithReturn(patch, file, false);
            }
            if (FileUtils.createNewFileSafely(file)) {
                return FileUtils.saveToFileWithReturn(patch, file, false);
            }
            return false;
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    static boolean checkVersionIsValid(String startVersion2, String endVersion2) {
        String currVersion = VersionUtils.getVersionName();
        if (compareVersion(currVersion, startVersion2) < 0 || compareVersion(currVersion, endVersion2) > 0) {
            return false;
        }
        return true;
    }

    public static int compareVersion(String currentAppVersion, String verifyAppVersion) {
        if (currentAppVersion == null && verifyAppVersion == null) {
            return 0;
        }
        if (currentAppVersion != null && verifyAppVersion == null) {
            return 1;
        }
        if (currentAppVersion == null && verifyAppVersion != null) {
            return -1;
        }
        String[] currentVersionElements = currentAppVersion.split("\\.");
        String[] verifyVersionElements = verifyAppVersion.split("\\.");
        int i2 = 0;
        while (i2 < currentVersionElements.length && i2 < verifyVersionElements.length) {
            try {
                int x = Integer.parseInt(currentVersionElements[i2]);
                int y = Integer.parseInt(verifyVersionElements[i2]);
                if (x < y) {
                    return -1;
                }
                if (x > y) {
                    return 1;
                }
                i2++;
            } catch (NumberFormatException e2) {
                return currentAppVersion.compareTo(verifyAppVersion);
            }
        }
        if (currentVersionElements.length > i2) {
            return 1;
        }
        if (verifyVersionElements.length > i2) {
            return -1;
        }
        return 0;
    }
}
