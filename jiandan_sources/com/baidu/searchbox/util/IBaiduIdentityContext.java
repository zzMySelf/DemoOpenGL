package com.baidu.searchbox.util;

import android.content.Context;

public interface IBaiduIdentityContext {
    String ad(Context context);

    String getZid();

    String qw(Context context);
}
