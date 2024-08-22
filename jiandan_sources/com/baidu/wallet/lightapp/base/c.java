package com.baidu.wallet.lightapp.base;

import android.app.Activity;
import android.view.WindowManager;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;

public final class c {
    public static void a(final float f, final Activity activity) {
        if (activity != null) {
            LightappUtils.runOnUiThread(new Runnable() {
                public void run() {
                    WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                    float f = attributes.screenBrightness;
                    float f2 = f;
                    if (f != f2) {
                        if (f2 < 0.0f || f2 > 1.0f) {
                            attributes.screenBrightness = -1.0f;
                        } else {
                            attributes.screenBrightness = f2;
                        }
                        activity.getWindow().setAttributes(attributes);
                    }
                }
            });
        }
    }

    public static void a(Activity activity) {
        a(-1.0f, activity);
    }
}
