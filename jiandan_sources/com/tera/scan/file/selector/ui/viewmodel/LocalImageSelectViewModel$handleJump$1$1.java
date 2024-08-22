package com.tera.scan.file.selector.ui.viewmodel;

import com.alibaba.android.arouter.facade.Postcard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/alibaba/android/arouter/facade/Postcard;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LocalImageSelectViewModel$handleJump$1$1 extends Lambda implements Function1<Postcard, Unit> {
    public final /* synthetic */ ArrayList<String> $list;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalImageSelectViewModel$handleJump$1$1(ArrayList<String> arrayList) {
        super(1);
        this.$list = arrayList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Postcard) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Postcard postcard) {
        Intrinsics.checkNotNullParameter(postcard, "it");
        postcard.withStringArrayList("selectedImageList", this.$list);
    }
}
