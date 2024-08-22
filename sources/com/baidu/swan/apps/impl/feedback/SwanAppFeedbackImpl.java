package com.baidu.swan.apps.impl.feedback;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.interfaces.ISwanAppFeedback;
import com.baidu.swan.apps.util.SwanAppUtils;
import java.io.File;
import java.util.HashMap;

public class SwanAppFeedbackImpl implements ISwanAppFeedback {
    private static final String DEFAULT_TAG = "default";

    public boolean isFeedbackSupported() {
        return true;
    }

    public void feedback(Bitmap capture, HashMap<String, String> extraData, File[] extraFiles, ISwanAppFeedback.OnFeedbackResultCallback callback) {
        new SwanAppErrPageFeedback(capture, extraData, extraFiles, callback).report("white_screen");
    }

    public void feedback(HashMap<String, String> extraData, File cloneFile, ISwanAppFeedback.OnFeedbackResultCallback callback) {
        new SwanAppErrPageFeedback((Bitmap) null, extraData, new File[]{cloneFile}, callback).report("clone_swan");
    }

    public void feedback(HashMap<String, String> extraData, File file, ISwanAppFeedback.OnFeedbackResultCallback callback, String tag) {
        if (TextUtils.isEmpty(tag)) {
            tag = "default";
        }
        new SwanAppErrPageFeedback((Bitmap) null, extraData, new File[]{file}, callback).report(tag);
    }

    public void handleFeedback(Context context, String appId, String appName, String errorDes) {
        SwanAppFeedbackHelper.handleFeedback(context, appId, appName, SwanAppUtils.getCurSwanAppPageParam().getPage(), errorDes);
    }
}
