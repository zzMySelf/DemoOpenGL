package com.baidu.swan.webcompat.ioc;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.baidu.pyramid.annotation.component.DefaultHolder;
import com.baidu.pyramid.annotation.component.Holder;
import com.baidu.searchbox.sport.statistic.SportStats;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0003H&J7\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u0001H\u000f0\u0012H&¢\u0006\u0002\u0010\u0013R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/baidu/swan/webcompat/ioc/IWebCompat;", "", "baseUri", "Landroid/net/Uri;", "getBaseUri", "()Landroid/net/Uri;", "baseUriString", "", "getBaseUriString", "()Ljava/lang/String;", "getWebCompatUrl", "url", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "transformResponse", "Target", "response", "transform", "Lkotlin/Function1;", "(Landroid/webkit/WebResourceResponse;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Delegating", "Ioc", "IocDelegating", "lib-swan-webcompat-ioc_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWebCompat.kt */
public interface IWebCompat {
    Uri getBaseUri();

    String getBaseUriString();

    String getWebCompatUrl(String str);

    WebResourceResponse shouldInterceptRequest(Uri uri);

    <Target> Target transformResponse(WebResourceResponse webResourceResponse, Function1<? super WebResourceResponse, ? extends Target> function1);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/swan/webcompat/ioc/IWebCompat$Ioc;", "", "()V", "impl", "Lcom/baidu/pyramid/annotation/component/Holder;", "Lcom/baidu/swan/webcompat/ioc/IWebCompat;", "getImpl", "()Lcom/baidu/pyramid/annotation/component/Holder;", "setImpl", "(Lcom/baidu/pyramid/annotation/component/Holder;)V", "lib-swan-webcompat-ioc_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IWebCompat.kt */
    public static class Ioc {
        public Holder<IWebCompat> impl;

        public void initimpl() {
            DefaultHolder create = DefaultHolder.create();
            this.impl = create;
            create.set(new IWebCompat_IWebCompat$Ioc_Provider());
        }

        public Ioc() {
            initimpl();
        }

        public final Holder<IWebCompat> getImpl() {
            Holder<IWebCompat> holder = this.impl;
            if (holder != null) {
                return holder;
            }
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            return null;
        }

        public final void setImpl(Holder<IWebCompat> holder) {
            Intrinsics.checkNotNullParameter(holder, "<set-?>");
            this.impl = holder;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0001J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u0005H\u0001J8\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0016\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u00130\u0016H\u0001¢\u0006\u0002\u0010\u0017R\u0012\u0010\u0004\u001a\u00020\u0005X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/baidu/swan/webcompat/ioc/IWebCompat$Delegating;", "Lcom/baidu/swan/webcompat/ioc/IWebCompat;", "delegation", "(Lcom/baidu/swan/webcompat/ioc/IWebCompat;)V", "baseUri", "Landroid/net/Uri;", "getBaseUri", "()Landroid/net/Uri;", "baseUriString", "", "getBaseUriString", "()Ljava/lang/String;", "getDelegation", "()Lcom/baidu/swan/webcompat/ioc/IWebCompat;", "getWebCompatUrl", "url", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "transformResponse", "Target", "response", "transform", "Lkotlin/Function1;", "(Landroid/webkit/WebResourceResponse;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "lib-swan-webcompat-ioc_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IWebCompat.kt */
    public static class Delegating implements IWebCompat {
        private final IWebCompat delegation;

        public Uri getBaseUri() {
            return this.delegation.getBaseUri();
        }

        public String getBaseUriString() {
            return this.delegation.getBaseUriString();
        }

        public String getWebCompatUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return this.delegation.getWebCompatUrl(str);
        }

        public WebResourceResponse shouldInterceptRequest(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "url");
            return this.delegation.shouldInterceptRequest(uri);
        }

        public <Target> Target transformResponse(WebResourceResponse webResourceResponse, Function1<? super WebResourceResponse, ? extends Target> function1) {
            Intrinsics.checkNotNullParameter(function1, "transform");
            return this.delegation.transformResponse(webResourceResponse, function1);
        }

        public Delegating(IWebCompat delegation2) {
            Intrinsics.checkNotNullParameter(delegation2, SportStats.SPORT_STAT_OLYMPIC_DELEGATION_PAGE);
            this.delegation = delegation2;
        }

        public final IWebCompat getDelegation() {
            return this.delegation;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/swan/webcompat/ioc/IWebCompat$IocDelegating;", "Lcom/baidu/swan/webcompat/ioc/IWebCompat$Delegating;", "ioc", "Lcom/baidu/swan/webcompat/ioc/IWebCompat$Ioc;", "(Lcom/baidu/swan/webcompat/ioc/IWebCompat$Ioc;)V", "lib-swan-webcompat-ioc_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IWebCompat.kt */
    public static class IocDelegating extends Delegating {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public IocDelegating(com.baidu.swan.webcompat.ioc.IWebCompat.Ioc r3) {
            /*
                r2 = this;
                java.lang.String r0 = "ioc"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                com.baidu.pyramid.annotation.component.Holder r0 = r3.getImpl()
                java.lang.Object r0 = r0.get()
                java.lang.String r1 = "ioc.impl.get()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                com.baidu.swan.webcompat.ioc.IWebCompat r0 = (com.baidu.swan.webcompat.ioc.IWebCompat) r0
                r2.<init>(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.webcompat.ioc.IWebCompat.IocDelegating.<init>(com.baidu.swan.webcompat.ioc.IWebCompat$Ioc):void");
        }
    }
}
