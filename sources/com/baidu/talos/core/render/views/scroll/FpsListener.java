package com.baidu.talos.core.render.views.scroll;

public interface FpsListener {
    void disable(String str);

    void enable(String str);

    boolean isEnabled();
}
