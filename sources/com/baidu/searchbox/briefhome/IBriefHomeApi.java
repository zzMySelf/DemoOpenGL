package com.baidu.searchbox.briefhome;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/briefhome/IBriefHomeApi;", "", "getBriefHomeSkinPlaceholderViewHeight", "", "getBriefHomeStyle", "Lcom/baidu/searchbox/briefhome/BriefHomeStyle;", "hasBriefHomeSkinPlaceholderView", "", "isHideFeedTabEnabled", "isNoHeaderBriefHomeStyle", "isThickBriefHomeStyle", "Companion", "lib-homepage-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IBriefHomeApi.kt */
public interface IBriefHomeApi {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String NAME = "briefhomeapi";
    public static final String NAME_SPACE = "baiduhome";

    int getBriefHomeSkinPlaceholderViewHeight();

    BriefHomeStyle getBriefHomeStyle();

    boolean hasBriefHomeSkinPlaceholderView();

    boolean isHideFeedTabEnabled();

    boolean isNoHeaderBriefHomeStyle();

    boolean isThickBriefHomeStyle();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/briefhome/IBriefHomeApi$Companion;", "", "()V", "NAME", "", "NAME_SPACE", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getBriefHomeApi", "Lcom/baidu/searchbox/briefhome/IBriefHomeApi;", "lib-homepage-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IBriefHomeApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String NAME = "briefhomeapi";
        public static final String NAME_SPACE = "baiduhome";
        private static final ServiceReference SERVICE_REFERENCE = new ServiceReference("baiduhome", "briefhomeapi");

        private Companion() {
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }

        public final IBriefHomeApi getBriefHomeApi() {
            Object service = ServiceManager.getService(SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(SERVICE_REFERENCE)");
            return (IBriefHomeApi) service;
        }
    }
}
