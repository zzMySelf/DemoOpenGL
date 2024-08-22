package com.baidu.searchbox.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/layout/ImageLoader;", "", "loadImage", "", "config", "Lkotlin/Function1;", "Lcom/baidu/searchbox/layout/Drawees;", "", "Lkotlin/ExtensionFunctionType;", "url", "", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: layout.kt */
public interface ImageLoader {
    boolean loadImage(String str);

    boolean loadImage(Function1<? super Drawees, Unit> function1);
}
