package com.baidu.permissionhelper.context;

import android.content.Context;
import android.graphics.drawable.Drawable;

class ContextCompatApi21 {
    ContextCompatApi21() {
    }

    public static Drawable getDrawable(Context context, int id) {
        return context.getDrawable(id);
    }
}
