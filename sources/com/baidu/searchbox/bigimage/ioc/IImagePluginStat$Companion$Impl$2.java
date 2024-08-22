package com.baidu.searchbox.bigimage.ioc;

import com.baidu.searchbox.bigimage.ioc.IImagePluginStat;
import com.baidu.searchbox.bigimage.runtime.BigImageRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/bigimage/ioc/IImagePluginStat;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IImagePluginStat.kt */
final class IImagePluginStat$Companion$Impl$2 extends Lambda implements Function0<IImagePluginStat> {
    public static final IImagePluginStat$Companion$Impl$2 INSTANCE = new IImagePluginStat$Companion$Impl$2();

    IImagePluginStat$Companion$Impl$2() {
        super(0);
    }

    public final IImagePluginStat invoke() {
        IImagePluginStat imagePluginStat = BigImageRuntime.getImagePluginStat();
        if (imagePluginStat == null) {
            imagePluginStat = IImagePluginStat.Companion.$$INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullExpressionValue(imagePluginStat, "BigImageRuntime.getImagePluginStat() ?: Default");
        return imagePluginStat;
    }
}
