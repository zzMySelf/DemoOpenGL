package com.baidu.chatsearch.aicall.interfaces;

import android.content.Context;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\f"}, d2 = {"Lcom/baidu/chatsearch/aicall/interfaces/AICallManager;", "", "launchAICall", "", "context", "Landroid/content/Context;", "params", "Lcom/baidu/chatsearch/aicall/interfaces/AICallLaunchParams;", "launchAICallForResult", "requestCode", "", "Companion", "lib-chatsearch-aicall-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AICallManager.kt */
public interface AICallManager {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean launchAICall(Context context, AICallLaunchParams aICallLaunchParams);

    boolean launchAICallForResult(Context context, int i2, AICallLaunchParams aICallLaunchParams);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/chatsearch/aicall/interfaces/AICallManager$Companion;", "", "()V", "serviceReference", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getOrNull", "Lcom/baidu/chatsearch/aicall/interfaces/AICallManager;", "lib-chatsearch-aicall-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AICallManager.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ServiceReference serviceReference = new ServiceReference("aicall", "AICallManager");

        private Companion() {
        }

        public final AICallManager getOrNull() {
            return (AICallManager) ServiceManager.getService(serviceReference);
        }
    }
}
