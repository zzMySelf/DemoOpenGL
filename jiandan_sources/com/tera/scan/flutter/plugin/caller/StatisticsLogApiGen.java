package com.tera.scan.flutter.plugin.caller;

import androidx.annotation.Keep;

@Keep
public interface StatisticsLogApiGen {
    void updateCount(String str, int i2, boolean z);

    void updateCount(String str, int i2, boolean z, String... strArr);

    void updateCount(String str, boolean z, boolean z2, String... strArr);

    void updateCount(String str, boolean z, String... strArr);
}
