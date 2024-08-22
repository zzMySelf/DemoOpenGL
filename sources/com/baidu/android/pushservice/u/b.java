package com.baidu.android.pushservice.u;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.widget.WidgetDataStatisticUtils;
import java.util.Arrays;
import java.util.List;

public class b extends a {
    public void a(Context context, ComponentName componentName, int i2) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra(WidgetDataStatisticUtils.EXT_BADGE_COUNT, i2);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        if (context != null && a(context, "android.intent.action.BADGE_COUNT_UPDATE")) {
            context.sendBroadcast(intent);
            a(context, i2);
        }
    }

    public int b() {
        return 5;
    }

    public List<String> c() {
        return Arrays.asList(new String[]{""});
    }
}
