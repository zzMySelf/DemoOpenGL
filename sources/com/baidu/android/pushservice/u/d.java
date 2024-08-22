package com.baidu.android.pushservice.u;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Arrays;
import java.util.List;

public class d extends a {
    public void a(Context context, ComponentName componentName, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString("class", componentName.getClassName());
        bundle.putInt("badgenumber", i2);
        try {
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
            a(context, i2);
        } catch (Exception e2) {
        }
    }

    public int b() {
        return 0;
    }

    public List<String> c() {
        return Arrays.asList(new String[]{"com.huawei.android.launcher"});
    }
}
