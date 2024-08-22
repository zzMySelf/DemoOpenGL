package com.baidu.wallet.base.widget.listview;

import android.app.Activity;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import java.lang.reflect.Field;

public class ViewMappingUtil {
    public static void a(Object obj, View view, Class<?> cls) {
        for (Field field : cls.getDeclaredFields()) {
            bind bind = (bind) field.getAnnotation(bind.class);
            if (bind != null) {
                try {
                    field.setAccessible(true);
                    field.set(obj, view.findViewById(ResUtils.id(view.getContext(), bind.value())));
                } catch (Exception unused) {
                    throw new RuntimeException(bind.value() + " map error!\nfield:" + field.getName());
                }
            }
        }
    }

    public static void mapView(Activity activity) {
        mapView(activity, activity.getWindow().getDecorView());
    }

    public static void mapView(Object obj, View view) {
        a(obj, view, obj.getClass());
    }
}
