package com.baidu.searchbox.feed.ad.prerender;

import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0016\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0016\u0010\u0010\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH&J\b\u0010\u0011\u001a\u00020\u0007H&¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/feed/ad/prerender/IAdPreRender;", "", "consumable", "", "url", "", "preRenderAd", "", "asFeedBaseModel", "prefetchType", "", "lpRealUrl", "preRenderAdList", "asFeedBaseModelList", "", "preRenderResumableAd", "preRenderResumableAdList", "prepareAdPreRenderWebView", "Companion", "Impl", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IAdPreRender.kt */
public interface IAdPreRender {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean consumable(String str);

    void preRenderAd(int i2, String str);

    void preRenderAd(Object obj);

    void preRenderAdList(List<? extends Object> list);

    void preRenderResumableAd(int i2, String str);

    void preRenderResumableAd(Object obj);

    void preRenderResumableAdList(List<? extends Object> list);

    void prepareAdPreRenderWebView();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0016\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0016\u0010\u0012\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/feed/ad/prerender/IAdPreRender$Impl;", "Lcom/baidu/searchbox/feed/ad/prerender/IAdPreRender;", "()V", "consumable", "", "url", "", "preRenderAd", "", "asFeedBaseModel", "", "prefetchType", "", "lpRealUrl", "preRenderAdList", "asFeedBaseModelList", "", "preRenderResumableAd", "preRenderResumableAdList", "prepareAdPreRenderWebView", "Companion", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IAdPreRender.kt */
    public static final class Impl implements IAdPreRender {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        public void preRenderAd(Object asFeedBaseModel) {
            Intrinsics.checkNotNullParameter(asFeedBaseModel, "asFeedBaseModel");
        }

        public void preRenderAd(int prefetchType, String lpRealUrl) {
            Intrinsics.checkNotNullParameter(lpRealUrl, "lpRealUrl");
        }

        public void preRenderResumableAd(Object asFeedBaseModel) {
            Intrinsics.checkNotNullParameter(asFeedBaseModel, "asFeedBaseModel");
        }

        public void preRenderResumableAd(int prefetchType, String lpRealUrl) {
            Intrinsics.checkNotNullParameter(lpRealUrl, "lpRealUrl");
        }

        public void preRenderAdList(List<? extends Object> asFeedBaseModelList) {
            Intrinsics.checkNotNullParameter(asFeedBaseModelList, "asFeedBaseModelList");
        }

        public void preRenderResumableAdList(List<? extends Object> asFeedBaseModelList) {
            Intrinsics.checkNotNullParameter(asFeedBaseModelList, "asFeedBaseModelList");
        }

        public void prepareAdPreRenderWebView() {
        }

        public boolean consumable(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return false;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/feed/ad/prerender/IAdPreRender$Impl$Companion;", "", "()V", "get", "Lcom/baidu/searchbox/feed/ad/prerender/IAdPreRender;", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IAdPreRender.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final IAdPreRender get() {
                IAdPreRender iAdPreRender = AdRuntimeHolder.getAdPreRender();
                Intrinsics.checkNotNullExpressionValue(iAdPreRender, "getAdPreRender()");
                IAdPreRender.Companion.getEMPTY();
                return iAdPreRender;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/ad/prerender/IAdPreRender$Companion;", "", "()V", "EMPTY", "Lcom/baidu/searchbox/feed/ad/prerender/IAdPreRender;", "getEMPTY", "()Lcom/baidu/searchbox/feed/ad/prerender/IAdPreRender;", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IAdPreRender.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IAdPreRender EMPTY = new Impl();

        private Companion() {
        }

        public final IAdPreRender getEMPTY() {
            return EMPTY;
        }
    }
}
