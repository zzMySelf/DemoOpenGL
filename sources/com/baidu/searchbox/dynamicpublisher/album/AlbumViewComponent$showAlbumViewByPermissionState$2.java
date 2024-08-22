package com.baidu.searchbox.dynamicpublisher.album;

import com.baidu.searchbox.ugc.model.ImageGroup;
import com.baidu.searchbox.ugc.view.AlbumView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/baidu/searchbox/ugc/model/ImageGroup;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumViewComponent.kt */
final class AlbumViewComponent$showAlbumViewByPermissionState$2 extends Lambda implements Function1<List<? extends ImageGroup>, Unit> {
    final /* synthetic */ AlbumViewComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlbumViewComponent$showAlbumViewByPermissionState$2(AlbumViewComponent albumViewComponent) {
        super(1);
        this.this$0 = albumViewComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((List<? extends ImageGroup>) (List) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends ImageGroup> it) {
        AlbumView access$getMAlbumView$p = this.this$0.mAlbumView;
        if (access$getMAlbumView$p != null) {
            access$getMAlbumView$p.notifyUi(it);
        }
    }
}
