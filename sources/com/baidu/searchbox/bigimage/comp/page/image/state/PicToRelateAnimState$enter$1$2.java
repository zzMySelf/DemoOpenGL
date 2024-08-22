package com.baidu.searchbox.bigimage.comp.page.image.state;

import com.baidu.searchbox.bigimage.comp.page.image.ImagePageComp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PicToRelateAnimState.kt */
final class PicToRelateAnimState$enter$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImagePageComp $owner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PicToRelateAnimState$enter$1$2(ImagePageComp imagePageComp) {
        super(0);
        this.$owner = imagePageComp;
    }

    public final void invoke() {
        this.$owner.getFsm$lib_search_bigimage_release().changeState(new PicState());
    }
}
