package com.baidu.searchbox.novel.main.utils;

import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class NovelEventDispatcher implements NoProGuard {
    public static final String VIP_STATE_CHANGE = "VIP_STATE_CHANGE";
    private Hashtable<String, List<OnEventListener>> eventTable = new Hashtable<>();

    public interface OnEventListener {
        void onEvent();
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final NovelEventDispatcher INSTANCE = new NovelEventDispatcher();

        private Holder() {
        }
    }

    public static NovelEventDispatcher getInstance() {
        return Holder.INSTANCE;
    }

    public void onEvent(String event) {
        List<OnEventListener> onEventListeners;
        if (!TextUtils.isEmpty(event) && (onEventListeners = this.eventTable.get(event)) != null && !onEventListeners.isEmpty()) {
            for (OnEventListener onEventListener : onEventListeners) {
                if (onEventListener != null) {
                    onEventListener.onEvent();
                }
            }
        }
    }

    public void registerEventListener(String event, OnEventListener onEventListener) {
        if (onEventListener != null) {
            List<OnEventListener> listenerList = this.eventTable.get(event);
            if (listenerList == null) {
                List<OnEventListener> listenerList2 = new ArrayList<>();
                listenerList2.add(onEventListener);
                this.eventTable.put(event, listenerList2);
                return;
            }
            listenerList.add(onEventListener);
        }
    }

    public void unRegisterEventListener(String event, OnEventListener onEventListener) {
        List<OnEventListener> listenerList = this.eventTable.get(event);
        if (listenerList != null && onEventListener != null) {
            listenerList.remove(onEventListener);
        }
    }
}
