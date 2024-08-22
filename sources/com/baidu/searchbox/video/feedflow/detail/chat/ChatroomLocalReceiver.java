package com.baidu.searchbox.video.feedflow.detail.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.talos.core.render.bindingx.internal.BindingXConstants;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0004J\u0018\u0010\u001f\u001a\u00020\u00102\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomLocalReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "halfPanelHeight", "", "isActive", "Lkotlin/Function0;", "", "pullListenerSet", "", "Lcom/baidu/searchbox/video/feedflow/detail/chat/IChatroomPullListener;", "getPullListenerSet", "()Ljava/util/Set;", "pullListenerSet$delegate", "Lkotlin/Lazy;", "addPullListener", "", "listener", "getIntentFilter", "Landroid/content/IntentFilter;", "notifyProgressChanged", "progress", "", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "removePullListener", "setHalfPanelHeight", "height", "setIsActive", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatroomLocalReceiver.kt */
public final class ChatroomLocalReceiver extends BroadcastReceiver {
    private int halfPanelHeight;
    private Function0<Boolean> isActive;
    private final Lazy pullListenerSet$delegate = BdPlayerUtils.lazyNone(ChatroomLocalReceiver$pullListenerSet$2.INSTANCE);

    private final Set<IChatroomPullListener> getPullListenerSet() {
        return (Set) this.pullListenerSet$delegate.getValue();
    }

    public void onReceive(Context context, Intent intent) {
        String result;
        int i2;
        if (intent != null && (result = intent.getStringExtra("result")) != null) {
            try {
                JSONObject resultObject = new JSONObject(result);
                String propertyName = resultObject.optString(BindingXConstants.RES_KEY_PROPERTY_NAME);
                double propertyValue = resultObject.optDouble("propertyValue");
                if (Intrinsics.areEqual((Object) propertyName, (Object) "transform.translateY") && (i2 = this.halfPanelHeight) > 0) {
                    notifyProgressChanged((float) (propertyValue / ((double) i2)));
                }
            } catch (Exception e2) {
            }
        }
    }

    private final void notifyProgressChanged(float progress) {
        Function0<Boolean> function0 = this.isActive;
        if (function0 != null ? Intrinsics.areEqual((Object) function0.invoke(), (Object) true) : false) {
            for (IChatroomPullListener listener : getPullListenerSet()) {
                listener.onPullProgressChanged(progress);
            }
        }
    }

    public final void setIsActive(Function0<Boolean> isActive2) {
        this.isActive = isActive2;
    }

    public final void setHalfPanelHeight(int height) {
        this.halfPanelHeight = height;
    }

    public final IntentFilter getIntentFilter() {
        return new IntentFilter("box.rnplugin.feedpage.feedChatRoom.videoPull");
    }

    public final void addPullListener(IChatroomPullListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getPullListenerSet().add(listener);
    }

    public final void removePullListener(IChatroomPullListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getPullListenerSet().remove(listener);
    }
}
