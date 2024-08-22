package com.pichillilorenzo.flutter_inappwebview;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RequestPermissionHandler implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static Map<Integer, List<Runnable>> actionDictionary = new HashMap();

    public static void checkAndRun(Activity activity, String str, int i2, Runnable runnable) {
        if (ContextCompat.checkSelfPermission(activity.getApplicationContext(), str) != 0) {
            if (actionDictionary.containsKey(Integer.valueOf(i2))) {
                actionDictionary.get(Integer.valueOf(i2)).add(runnable);
            } else {
                actionDictionary.put(Integer.valueOf(i2), Arrays.asList(new Runnable[]{runnable}));
            }
            ActivityCompat.requestPermissions(activity, new String[]{str}, i2);
            return;
        }
        runnable.run();
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (iArr.length > 0 && iArr[0] == 0) {
            List<Runnable> list = actionDictionary.get(Integer.valueOf(i2));
            for (Runnable runnable : list) {
                runnable.run();
                list.remove(runnable);
            }
        }
    }
}
