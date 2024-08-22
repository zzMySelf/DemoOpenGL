package com.baidu.download;

import com.baidu.searchbox.boxdownload.model.DownloadDbItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxDownloadDbOperatorImpl.kt */
final class BoxDownloadDbOperatorImpl$readItem$18 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ DownloadDbItem $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoxDownloadDbOperatorImpl$readItem$18(DownloadDbItem downloadDbItem) {
        super(1);
        this.$item = downloadDbItem;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String it) {
        this.$item.setUserAgent(it);
    }
}
