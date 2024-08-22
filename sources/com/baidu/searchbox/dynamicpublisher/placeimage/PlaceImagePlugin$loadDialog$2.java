package com.baidu.searchbox.dynamicpublisher.placeimage;

import com.baidu.searchbox.ugc.dialog.UploadPhotosDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ugc/dialog/UploadPhotosDialog;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlaceImagePlugin.kt */
final class PlaceImagePlugin$loadDialog$2 extends Lambda implements Function0<UploadPhotosDialog> {
    final /* synthetic */ PlaceImagePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaceImagePlugin$loadDialog$2(PlaceImagePlugin placeImagePlugin) {
        super(0);
        this.this$0 = placeImagePlugin;
    }

    public final UploadPhotosDialog invoke() {
        return this.this$0.initLoadDialog();
    }
}
