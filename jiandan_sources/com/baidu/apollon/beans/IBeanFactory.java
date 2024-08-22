package com.baidu.apollon.beans;

import android.content.Context;

public interface IBeanFactory {
    ApollonBean<?> getBean(Context context, int i2, String str);
}
