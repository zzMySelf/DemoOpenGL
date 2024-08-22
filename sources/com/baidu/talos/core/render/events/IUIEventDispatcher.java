package com.baidu.talos.core.render.events;

import com.baidu.talos.core.data.ParamArray;

public interface IUIEventDispatcher {
    void dispatchEvent(Event event);

    void dispatchTouches(long j2, String str, ParamArray paramArray);
}
