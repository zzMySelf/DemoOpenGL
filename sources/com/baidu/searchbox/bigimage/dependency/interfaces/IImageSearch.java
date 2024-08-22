package com.baidu.searchbox.bigimage.dependency.interfaces;

import android.content.Context;
import android.net.Uri;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&JB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&J\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/bigimage/dependency/interfaces/IImageSearch;", "", "handleBarcodeClick", "", "context", "Landroid/content/Context;", "content", "", "referer", "barcodeFormat", "codeType", "resultType", "codeText", "resultPageUrl", "jointSearchImgUrl", "url", "preHandle", "Landroid/net/Uri;", "urlStr", "Companion", "lib-bigimage-dependency-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IImageSearch.kt */
public interface IImageSearch {
    public static final Companion Companion = Companion.$$INSTANCE;

    void handleBarcodeClick(Context context, String str, String str2);

    void handleBarcodeClick(Context context, String str, String str2, String str3, String str4, String str5);

    String jointSearchImgUrl(String str);

    Uri preHandle(Context context, String str);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/bigimage/dependency/interfaces/IImageSearch$Companion;", "", "()V", "Empty", "Lcom/baidu/searchbox/bigimage/dependency/interfaces/IImageSearch;", "getEmpty", "()Lcom/baidu/searchbox/bigimage/dependency/interfaces/IImageSearch;", "Impl", "getImpl", "Impl$delegate", "Lkotlin/Lazy;", "lib-bigimage-dependency-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IImageSearch.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IImageSearch Empty = new IImageSearch$Companion$Empty$1();
        private static final Lazy<IImageSearch> Impl$delegate = LazyKt.lazy(IImageSearch$Companion$Impl$2.INSTANCE);

        private Companion() {
        }

        public final IImageSearch getEmpty() {
            return Empty;
        }

        public final IImageSearch getImpl() {
            return Impl$delegate.getValue();
        }
    }
}
