package com.baidu.searchbox.video.component.autoplay.service;

import com.baidu.searchbox.video.component.autoplay.AutoPlayPlugin;
import com.baidu.searchbox.video.component.autoplay.IOnAutoPlayBeforeCallback;
import com.baidu.searchbox.video.component.autoplay.OnAutoPlayInterceptCallback;
import com.baidu.talos.core.render.bindingx.internal.BindingXConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/component/autoplay/service/AutoPlayInterceptorService;", "Lcom/baidu/searchbox/video/component/autoplay/service/IAutoPlayInterceptorService;", "plugin", "Lcom/baidu/searchbox/video/component/autoplay/AutoPlayPlugin;", "(Lcom/baidu/searchbox/video/component/autoplay/AutoPlayPlugin;)V", "addInterceptor", "", "interceptor", "Lcom/baidu/searchbox/video/component/autoplay/OnAutoPlayInterceptCallback;", "addPlayNextBeforeListener", "listener", "Lcom/baidu/searchbox/video/component/autoplay/IOnAutoPlayBeforeCallback;", "isInterceptorAutoPlay", "", "removeInterceptor", "removePlayNextBeforeListener", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoPlayInterceptorService.kt */
public final class AutoPlayInterceptorService implements IAutoPlayInterceptorService {
    private final AutoPlayPlugin plugin;

    public AutoPlayInterceptorService(AutoPlayPlugin plugin2) {
        Intrinsics.checkNotNullParameter(plugin2, "plugin");
        this.plugin = plugin2;
    }

    public void addInterceptor(OnAutoPlayInterceptCallback interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, BindingXConstants.STATE_INTERCEPTOR);
        this.plugin.collectInterceptor(interceptor);
    }

    public void removeInterceptor(OnAutoPlayInterceptCallback interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, BindingXConstants.STATE_INTERCEPTOR);
        this.plugin.removeInterceptor(interceptor);
    }

    public void addPlayNextBeforeListener(IOnAutoPlayBeforeCallback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.plugin.collectPlayNextBeforeListener(listener);
    }

    public void removePlayNextBeforeListener(IOnAutoPlayBeforeCallback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.plugin.removePlayNextBeforeListener(listener);
    }

    public boolean isInterceptorAutoPlay() {
        return this.plugin.isInterceptorAutoPlay();
    }
}
