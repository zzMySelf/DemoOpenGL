package com.baidu.live.feed.search.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class WeakHandler extends Handler {
    private WeakReference<IWeakHandleMsg> obj;

    public interface IWeakHandleMsg {
        void handleMsg(Message message);
    }

    public WeakHandler(IWeakHandleMsg instance) {
        this.obj = new WeakReference<>(instance);
    }

    public void handleMessage(Message msg) {
        IWeakHandleMsg item;
        try {
            WeakReference<IWeakHandleMsg> weakReference = this.obj;
            if (weakReference != null && (item = (IWeakHandleMsg) weakReference.get()) != null) {
                item.handleMsg(msg);
                super.handleMessage(msg);
            }
        } catch (Exception e2) {
        }
    }
}
