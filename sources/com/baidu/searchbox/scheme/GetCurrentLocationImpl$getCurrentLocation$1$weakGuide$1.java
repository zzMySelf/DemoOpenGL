package com.baidu.searchbox.scheme;

import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.scene.IScenePermissionCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/scheme/GetCurrentLocationImpl$getCurrentLocation$1$weakGuide$1", "Lcom/baidu/searchbox/scene/IScenePermissionCallback;", "onPermissionStateChange", "", "state", "", "lib-location-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetCurrentLocationImpl.kt */
public final class GetCurrentLocationImpl$getCurrentLocation$1$weakGuide$1 implements IScenePermissionCallback {
    final /* synthetic */ String $callback;
    final /* synthetic */ String $options;
    final /* synthetic */ Ref.ObjectRef<String> $scene;
    final /* synthetic */ BdSailorWebView $webView;

    GetCurrentLocationImpl$getCurrentLocation$1$weakGuide$1(BdSailorWebView $webView2, String $options2, String $callback2, Ref.ObjectRef<String> $scene2) {
        this.$webView = $webView2;
        this.$options = $options2;
        this.$callback = $callback2;
        this.$scene = $scene2;
    }

    public void onPermissionStateChange(boolean state) {
        BdSailorWebView $this$onPermissionStateChange_u24lambda_u2d0 = this.$webView;
        BdSailorWebView bdSailorWebView = this.$webView;
        String str = this.$options;
        String str2 = this.$callback;
        Ref.ObjectRef<String> objectRef = this.$scene;
        if (state) {
            GetCurrentLocationImpl getCurrentLocationImpl = GetCurrentLocationImpl.INSTANCE;
            WeakReference weakReference = new WeakReference(bdSailorWebView);
            String str3 = (String) objectRef.element;
            if (str3 == null) {
                str3 = "no_permission";
            }
            getCurrentLocationImpl.handleGetLocation(weakReference, str, str2, str3);
            return;
        }
        GetCurrentLocationImpl.INSTANCE.handlePermissionRefuse($this$onPermissionStateChange_u24lambda_u2d0, str2);
    }
}
