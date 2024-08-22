package com.baidu.searchbox.search.tab.implement.component;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.search.tab.core.component.Component;
import com.baidu.searchbox.search.tab.core.component.IComponent;
import com.baidu.searchbox.search.tab.core.message.EventMessage;
import com.baidu.searchbox.search.tab.core.message.IMessage;
import com.baidu.searchbox.search.tab.core.message.MessageBus;
import com.baidu.searchbox.search.tab.core.message.UBCMessage;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/component/UBCComponent;", "Lcom/baidu/searchbox/search/tab/core/component/Component;", "()V", "dispatchMessage", "", "message", "Lcom/baidu/searchbox/search/tab/core/message/IMessage;", "getComponentName", "Ljava/lang/Class;", "Lcom/baidu/searchbox/search/tab/core/component/IComponent;", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "subscribe", "messageBus", "Lcom/baidu/searchbox/search/tab/core/message/MessageBus;", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UBCComponent.kt */
public final class UBCComponent extends Component {
    public Class<? extends IComponent> getComponentName() {
        return UBCComponent.class;
    }

    public void subscribe(MessageBus messageBus) {
        Intrinsics.checkNotNullParameter(messageBus, "messageBus");
        messageBus.subscribe(UBCMessage.class, this);
        messageBus.subscribe(EventMessage.class, this);
    }

    public void dispatchMessage(IMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!(message instanceof UBCMessage)) {
            boolean z = message instanceof EventMessage;
        }
        if (AppConfig.isDebug()) {
            Log.d("UBCComponent", message.toString());
        }
    }

    public void onCreate() {
        if (AppConfig.isDebug()) {
            Log.d("UBCComponent", "onCreate");
        }
    }

    public void onStart() {
        if (AppConfig.isDebug()) {
            Log.d("UBCComponent", "onStart");
        }
    }

    public void onResume() {
        if (AppConfig.isDebug()) {
            Log.d("UBCComponent", PluginInvokerConstants.METHOD_ACTIVITY_ONRESUME);
        }
    }

    public void onPause() {
        if (AppConfig.isDebug()) {
            Log.d("UBCComponent", "onPause");
        }
    }

    public void onStop() {
        if (AppConfig.isDebug()) {
            Log.d("UBCComponent", "onStop");
        }
    }

    public void onDestroy() {
        if (AppConfig.isDebug()) {
            Log.d("UBCComponent", "onDestroy");
        }
    }
}
