package com.tera.scan.flutter.plugin.caller;

import android.app.Activity;
import androidx.annotation.Keep;
import java.util.concurrent.Callable;

@Keep
public interface HelperApiGen {
    void addThreadJob(String str, Callable<Object> callable);

    void openPhotoTakeActivity(Activity activity, int i2, int i3, String str, int i4, int i5, int i6, int i7);

    void openlocalImageSelectActivity(Activity activity, int i2, int i3);
}
