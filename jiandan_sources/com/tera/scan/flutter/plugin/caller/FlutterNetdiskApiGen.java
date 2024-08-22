package com.tera.scan.flutter.plugin.caller;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Keep;

@Keep
public interface FlutterNetdiskApiGen {
    void openFlutterBusinessActivity(Activity activity, String str, Bundle bundle);

    void retrieveJsonLogSave(String str, String str2);

    void retrieveLayerLogSave(int i2, String str);

    void retrieveLogSave(String str);

    String retrieveLogUniqueId();

    void retrieveLogUpload(String str);

    void retrieveUniqueLogSave(String str, String str2, String str3);
}
