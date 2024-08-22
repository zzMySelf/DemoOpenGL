package com.baidu.searchbox.aps.net.callback.impl;

import android.util.Log;
import com.baidu.megapp.util.MegUtils;
import com.baidu.searchbox.aps.net.callback.HotfixCallback;

public class HotfixCallbackImpl implements HotfixCallback {
    private static final String TAG = "HotfixCallbackImpl";

    public boolean checkPatchIfNeed(String filePath) {
        if (!MegUtils.isDebug()) {
            return false;
        }
        Log.d(TAG, "checkPatchIfNeed implemented in aps -> return false");
        return false;
    }

    public boolean installHotfixPatch(String filePath) {
        if (!MegUtils.isDebug()) {
            return false;
        }
        Log.d(TAG, "installHotfixPatch implemented in aps -> return false");
        return false;
    }
}
