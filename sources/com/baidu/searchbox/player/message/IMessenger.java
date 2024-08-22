package com.baidu.searchbox.player.message;

import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.interfaces.InternalEventDispatcher;

public interface IMessenger {
    void addInterceptor(int i2, IVideoEventInterceptor iVideoEventInterceptor);

    void addInterceptor(IVideoEventInterceptor iVideoEventInterceptor);

    void addInternalDispatcher(InternalEventDispatcher internalEventDispatcher);

    String getType();

    void notifyEvent(VideoEvent videoEvent);

    void register(int i2, INeuron iNeuron);

    void release();

    void removeInterceptor(IVideoEventInterceptor iVideoEventInterceptor);

    void removeInternalDispatcher(InternalEventDispatcher internalEventDispatcher);

    void setInterceptor(IVideoEventInterceptor iVideoEventInterceptor);

    void unregister(INeuron iNeuron);
}
