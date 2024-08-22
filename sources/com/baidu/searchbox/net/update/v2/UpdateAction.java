package com.baidu.searchbox.net.update.v2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface UpdateAction {
    String action();

    String module();
}
