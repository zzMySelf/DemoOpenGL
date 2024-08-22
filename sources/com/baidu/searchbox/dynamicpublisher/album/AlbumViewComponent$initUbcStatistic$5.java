package com.baidu.searchbox.dynamicpublisher.album;

import com.baidu.searchbox.ugc.utils.AlbumViewHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumViewComponent.kt */
final class AlbumViewComponent$initUbcStatistic$5 extends Lambda implements Function0<Integer> {
    final /* synthetic */ AlbumViewComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlbumViewComponent$initUbcStatistic$5(AlbumViewComponent albumViewComponent) {
        super(0);
        this.this$0 = albumViewComponent;
    }

    public final Integer invoke() {
        AlbumViewHelper access$getMAlbumViewHelper$p = this.this$0.mAlbumViewHelper;
        return Integer.valueOf(access$getMAlbumViewHelper$p != null ? access$getMAlbumViewHelper$p.getTotalNum() : 0);
    }
}
