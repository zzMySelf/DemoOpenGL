package com.baidu.wallet.core.beans;

import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.wallet.core.NoProguard;
import java.util.Objects;

public abstract class ResponsePrecallback implements IBeanResponseCallback, NoProguard {

    public enum ResponseType {
        OkJson,
        OkString,
        Fail
    }

    public static String getNotifyKeyName(Class cls, ResponseType responseType) {
        if (cls != null) {
            if (responseType == null) {
                responseType = ResponseType.OkJson;
            }
            return cls.getSimpleName() + responseType.name();
        }
        throw new NullPointerException("callbackClz null");
    }

    public abstract void handleResponse(int i2, Object obj, String str);

    public void onBeanExecFailure(int i2, int i3, String str) {
        removeRequest();
        BeanErrorContent beanErrorContent = new BeanErrorContent(i2, i3, str, (Object) null);
        EventBus instance = EventBus.getInstance();
        Objects.requireNonNull(instance);
        instance.post(new EventBus.Event(getNotifyKeyName(ResponsePrecallback.class, ResponseType.Fail), beanErrorContent));
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Class<ResponsePrecallback> cls = ResponsePrecallback.class;
        if (obj != null) {
            EventBus instance = EventBus.getInstance();
            Objects.requireNonNull(instance);
            instance.post(new EventBus.Event(getNotifyKeyName(cls, ResponseType.OkJson), obj));
        } else if (TextUtils.isEmpty(str)) {
            EventBus instance2 = EventBus.getInstance();
            Objects.requireNonNull(instance2);
            instance2.post(new EventBus.Event(getNotifyKeyName(cls, ResponseType.OkString), str));
        }
        removeRequest();
        handleResponse(i2, obj, str);
    }

    public abstract void removeRequest();
}
